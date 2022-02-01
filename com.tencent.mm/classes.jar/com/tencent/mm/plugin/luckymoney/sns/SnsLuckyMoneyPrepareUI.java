package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.model.p;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.i;
import com.tencent.mm.plugin.luckymoney.ui.i.c;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.u;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements com.tencent.mm.plugin.luckymoney.ui.h
{
  private static final String yQK;
  private MTimerHandler klF;
  private ScrollView lTw;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private int mType;
  private TextView nAB;
  protected TextView qAC;
  protected Button rlN;
  protected Dialog tipDialog;
  private o yPZ;
  protected LuckyMoneyNumInputView yQL;
  protected LuckyMoneyTextInputView yQN;
  protected Button yQO;
  private TextView yQS;
  private c yQU;
  private int yUr;
  protected LuckyMoneyMoneyInputView yYI;
  private View yYJ;
  private View yYK;
  private ViewGroup yYL;
  private String yYM;
  private int yYN;
  private boolean yYO;
  private String yYP;
  
  static
  {
    AppMethodBeat.i(213335);
    yQK = "https://" + WeChatHosts.domainString(2131761715) + "/touch/product/wechathongbao_platform_app.html?scene_id=kf7";
    AppMethodBeat.o(213335);
  }
  
  public SnsLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65387);
    this.yQL = null;
    this.yYI = null;
    this.yQN = null;
    this.qAC = null;
    this.yQO = null;
    this.rlN = null;
    this.tipDialog = null;
    this.yQU = new c();
    this.klF = null;
    AppMethodBeat.o(65387);
  }
  
  private int efB()
  {
    AppMethodBeat.i(65398);
    if (this.yYO)
    {
      if (getIntent().getIntExtra("key_chatroom_num", 0) > 0)
      {
        AppMethodBeat.o(65398);
        return 2;
      }
      AppMethodBeat.o(65398);
      return 1;
    }
    AppMethodBeat.o(65398);
    return 3;
  }
  
  protected final void ak(View paramView, final int paramInt)
  {
    AppMethodBeat.i(65394);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
    this.mKBLayout = findViewById(2131308960);
    View localView = findViewById(2131308963);
    final EditText localEditText = (EditText)paramView.findViewById(2131304116);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(65394);
      return;
    }
    com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65374);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65372);
              if ((!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown())) {
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
              }
              SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.10.this.val$editMode);
              SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
              ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(65372);
            }
          }, 300L);
          AppMethodBeat.o(65374);
          return;
        }
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65373);
            SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(SnsLuckyMoneyPrepareUI.10.this.val$hintTv, 0);
            AppMethodBeat.o(65373);
          }
        }, 200L);
        AppMethodBeat.o(65374);
      }
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65376);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, paramInt);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65376);
          return;
          if (this.val$isShowSysKB)
          {
            SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
          }
        }
      }
    });
    paramView = (TextView)paramView.findViewById(2131304016);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65377);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
          {
            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, paramInt);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65377);
            return;
            if (this.val$isShowSysKB)
            {
              SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
              ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
            }
          }
        }
      });
    }
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65378);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65378);
      }
    });
    AppMethodBeat.o(65394);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65391);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.yYJ.getVisibility() == 0))
    {
      this.yYJ.setVisibility(8);
      efZ();
      AppMethodBeat.o(65391);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65391);
    return bool;
  }
  
  public final void eeI()
  {
    AppMethodBeat.i(65397);
    com.tencent.mm.plugin.luckymoney.b.a.eex();
    this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
    int i;
    double d2;
    double d1;
    if ((this.yYI.eeH() != 3) && (this.yQL.eeH() != 3))
    {
      i = this.yQL.getInput();
      d2 = this.yYI.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.yYI.getInput();
      }
    }
    for (;;)
    {
      if (this.yQU.egj())
      {
        this.yQO.setClickable(false);
        this.yQO.setEnabled(false);
        this.qAC.setText(com.tencent.mm.wallet_core.ui.f.D(d2));
        AppMethodBeat.o(65397);
        return;
        if (i > 0) {
          d1 = this.yYI.getInput() / i;
        }
      }
      else
      {
        if ((d2 == 0.0D) || (d1 == 0.0D)) {
          i = 1;
        }
        for (;;)
        {
          label159:
          if (i != 0)
          {
            this.yQO.setClickable(false);
            this.yQO.setEnabled(false);
            break;
            if ((d2 > this.yPZ.yPy) && (this.yPZ.yPy > 0.0D))
            {
              this.yQU.aeu(getString(2131762752, new Object[] { Math.round(this.yPZ.yPy), Util.nullAs(this.yPZ.yPB, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label650;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.yPZ.yPw) || (this.yPZ.yPw <= 0.0D)) {
                break label644;
              }
              this.yQU.aeu(getString(2131762696, new Object[] { Math.round(this.yPZ.yPw), Util.nullAs(this.yPZ.yPB, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.yPZ.yPx) {
                  break label641;
                }
                this.yQU.aeu(getString(2131762698, new Object[] { com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.yPZ.yPx), Util.nullAs(this.yPZ.yPB, "") }));
                i = 1;
                break label159;
                if ((d1 <= this.yPZ.yPz) || (this.yPZ.yPz <= 0.0D)) {
                  break label644;
                }
                this.yQU.aeu(getString(2131762696, new Object[] { Math.round(this.yPZ.yPz), Util.nullAs(this.yPZ.yPB, "") }));
                this.yQL.onError();
                this.yYI.onError();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.yQU.aeu(getString(2131762698, new Object[] { "0.01", Util.nullAs(this.yPZ.yPB, "") }));
                this.yQL.onError();
                this.yYI.onError();
                i = 1;
                break label159;
                this.yQO.setClickable(true);
                this.yQO.setEnabled(true);
                break;
              }
            }
            label641:
            break label159;
            label644:
            i = 0;
          }
          label650:
          i = 0;
        }
      }
      d1 = 0.0D;
      continue;
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495380;
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(65396);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      this.mTenpayKBStateListener.onVisibleStateChange(false);
    }
    AppMethodBeat.o(65396);
  }
  
  public void initView()
  {
    AppMethodBeat.i(65389);
    getResources().getDrawable(2131233600);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65363);
        SnsLuckyMoneyPrepareUI.this.finish();
        AppMethodBeat.o(65363);
        return true;
      }
    });
    this.yYJ = findViewById(2131304224);
    this.yYK = findViewById(2131304227);
    this.rlN = ((Button)findViewById(2131304226));
    this.yQN = ((LuckyMoneyTextInputView)findViewById(2131304284));
    this.yQN.setHintText(getString(2131762600));
    this.yQO = ((Button)findViewById(2131304215));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
    this.mKBLayout = findViewById(2131308960);
    this.nAB = ((TextView)findViewById(2131304213));
    this.yQL = ((LuckyMoneyNumInputView)findViewById(2131304210));
    this.yYI = ((LuckyMoneyMoneyInputView)findViewById(2131304015));
    this.qAC = ((TextView)findViewById(2131304228));
    this.yYL = ((ViewGroup)findViewById(2131304222));
    this.lTw = ((ScrollView)findViewById(2131304268));
    this.yQS = ((TextView)findViewById(2131304220));
    Object localObject1;
    if (this.mType == 1)
    {
      this.yYI.setTitle(getString(2131762753));
      this.yYI.setShowGroupIcon(true);
      this.yYI.setOnInputValidChangerListener(this);
      this.yQL.setOnInputValidChangerListener(this);
      this.yQN.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.yYI.findViewById(2131304116);
      Object localObject2 = (EditText)this.yQL.findViewById(2131304116);
      com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65384);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.val$hintTv.setOnClickListener(null);
          this.yQW.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yYI, 2);
          SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yQL, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65384);
        }
      });
      Object localObject3 = (TextView)this.yYI.findViewById(2131304016);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65385);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            this.val$hintTv.setOnClickListener(null);
            this.yQW.setOnClickListener(null);
            SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yYI, 2);
            SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yQL, 0);
            SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65385);
          }
        });
      }
      com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65386);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.val$hintTv.setOnClickListener(null);
          this.yQW.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yYI, 2);
          SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yQL, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65386);
        }
      });
      if (this.yPZ != null)
      {
        if (this.mType != 1) {
          break label1036;
        }
        this.yYI.setMaxAmount(this.yPZ.yPy);
        label447:
        this.yYI.setMinAmount(this.yPZ.yPx);
      }
      if ((!this.yYO) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1053;
      }
      this.yQL.setNum("1");
      label492:
      this.yQL.setMaxNum(this.yPZ.yPv);
      this.yQL.setMinNum(1);
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.yQL.getInput());
      this.yYI.setMaxLen(12);
      if (!this.yYO) {
        break label1078;
      }
      if (getIntent().getIntExtra("key_chatroom_num", 0) <= 0) {
        break label1066;
      }
      Object localObject4 = getString(2131762654);
      Object localObject5 = getString(2131762651);
      localObject1 = getString(2131762653);
      localObject2 = getString(2131762652);
      localObject3 = new SpannableString((String)localObject4 + (String)localObject5);
      l locall = new l(this);
      ((SpannableString)localObject3).setSpan(locall, ((String)localObject4).length(), ((String)localObject4).length() + ((String)localObject5).length(), 33);
      localObject4 = new SpannableString((String)localObject1 + (String)localObject2);
      localObject5 = new l(this);
      ((SpannableString)localObject4).setSpan(localObject5, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject2).length(), 33);
      locall.IgH = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65375);
          int i = SnsLuckyMoneyPrepareUI.this.yQL.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.yYI.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 0);
          SnsLuckyMoneyPrepareUI.this.yYI.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.yYI.setShowGroupIcon(false);
          SnsLuckyMoneyPrepareUI.this.yYI.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131762754));
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.yYI.setAmount(com.tencent.mm.wallet_core.ui.f.formatMoney2f(d / i));
          }
          SnsLuckyMoneyPrepareUI.this.yYI.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).yPw);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.yRa);
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
          AppMethodBeat.o(65375);
        }
      };
      ((l)localObject5).IgH = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65379);
          int i = SnsLuckyMoneyPrepareUI.this.yQL.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.yYI.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 1);
          SnsLuckyMoneyPrepareUI.this.yYI.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.yYI.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131762753));
          SnsLuckyMoneyPrepareUI.this.yYI.setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.yYI.setAmount(com.tencent.mm.wallet_core.ui.f.formatMoney2f(d * i));
          }
          SnsLuckyMoneyPrepareUI.this.yYI.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).yPy);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.yRb);
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
          AppMethodBeat.o(65379);
        }
      };
      this.nAB.setMovementMethod(LinkMovementMethod.getInstance());
      this.nAB.setText((CharSequence)localObject3);
      this.nAB.setVisibility(0);
    }
    for (;;)
    {
      this.yQO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65381);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4) });
          if (SnsLuckyMoneyPrepareUI.this.yYI.eeH() != 0) {
            u.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), 2131767474, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65381);
            return;
            int i = SnsLuckyMoneyPrepareUI.this.yQL.getInput();
            double d = SnsLuckyMoneyPrepareUI.this.yYI.getInput();
            long l2 = 0L;
            long l1;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) == 1)
            {
              l1 = com.tencent.mm.wallet_core.ui.f.E(d);
              g.aAi();
              g.aAh().azQ().set(356354, Integer.valueOf(i));
              label201:
              localObject = SnsLuckyMoneyPrepareUI.this.yQN.getInput();
              paramAnonymousView = (View)localObject;
              if (Util.isNullOrNil((String)localObject)) {
                paramAnonymousView = SnsLuckyMoneyPrepareUI.this.getString(2131762600);
              }
              localObject = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
              if ((!SnsLuckyMoneyPrepareUI.e(SnsLuckyMoneyPrepareUI.this)) || (Util.isNullOrNil((String)localObject))) {
                break label384;
              }
            }
            label384:
            for (paramAnonymousView = new ba(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, af.efj(), (String)localObject, af.Ir((String)localObject), com.tencent.mm.model.z.aTY(), com.tencent.mm.model.z.aUa(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), "");; paramAnonymousView = new ba(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, af.efj(), null, null, com.tencent.mm.model.z.aTY(), com.tencent.mm.model.z.aUa(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), ""))
            {
              SnsLuckyMoneyPrepareUI.this.doSceneProgress(paramAnonymousView, false);
              if (SnsLuckyMoneyPrepareUI.this.tipDialog == null) {
                break label429;
              }
              SnsLuckyMoneyPrepareUI.this.tipDialog.show();
              break;
              l1 = com.tencent.mm.wallet_core.ui.f.E(i * d);
              l2 = com.tencent.mm.wallet_core.ui.f.E(d);
              g.aAi();
              g.aAh().azQ().set(356353, Integer.valueOf(i));
              break label201;
            }
            label429:
            SnsLuckyMoneyPrepareUI.this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(SnsLuckyMoneyPrepareUI.this.getContext(), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(65380);
                if ((SnsLuckyMoneyPrepareUI.this.tipDialog != null) && (SnsLuckyMoneyPrepareUI.this.tipDialog.isShowing())) {
                  SnsLuckyMoneyPrepareUI.this.tipDialog.hide();
                }
                if ((SnsLuckyMoneyPrepareUI.g(SnsLuckyMoneyPrepareUI.this).getVisibility() == 8) || (SnsLuckyMoneyPrepareUI.h(SnsLuckyMoneyPrepareUI.this).getVisibility() == 4))
                {
                  Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                  SnsLuckyMoneyPrepareUI.this.finish();
                }
                SnsLuckyMoneyPrepareUI.this.zbX.forceCancel();
                AppMethodBeat.o(65380);
              }
            });
          }
        }
      });
      this.qAC.setText(com.tencent.mm.wallet_core.ui.f.D(0.0D));
      this.yQU.a(this.yQL);
      this.yQU.a(this.yYI);
      this.yQU.a(this.yQN);
      localObject1 = (TextView)findViewById(2131304217);
      this.yQU.t((TextView)localObject1);
      if ((this.yYO) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(2131304221);
        ((TextView)localObject1).setText(getString(2131762684, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.klF = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65382);
          int i;
          double d2;
          if ((SnsLuckyMoneyPrepareUI.this.yYI.eeH() != 3) && (SnsLuckyMoneyPrepareUI.this.yQL.eeH() != 3))
          {
            i = SnsLuckyMoneyPrepareUI.this.yQL.getInput();
            d2 = SnsLuckyMoneyPrepareUI.this.yYI.getInput();
            d1 = d2;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).yPy) || (SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).egk()))
            {
              SnsLuckyMoneyPrepareUI.this.yQO.setClickable(false);
              SnsLuckyMoneyPrepareUI.this.yQO.setEnabled(false);
            }
            for (;;)
            {
              Log.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).egk());
              SnsLuckyMoneyPrepareUI.j(SnsLuckyMoneyPrepareUI.this).stopped();
              AppMethodBeat.o(65382);
              return false;
              SnsLuckyMoneyPrepareUI.this.yQO.setClickable(true);
              SnsLuckyMoneyPrepareUI.this.yQO.setEnabled(true);
            }
          }
        }
      }, false);
      if (this.lTw != null) {
        this.lTw.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(65383);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
              SnsLuckyMoneyPrepareUI.this.hideVKB();
            }
            AppMethodBeat.o(65383);
            return false;
          }
        });
      }
      this.yYI.setType(this.mType);
      if ((!this.yYO) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1143;
      }
      this.yYI.requestFocus();
      AppMethodBeat.o(65389);
      return;
      this.yYI.setTitle(getString(2131762754));
      this.yYI.setShowGroupIcon(false);
      break;
      label1036:
      this.yYI.setMaxAmount(this.yPZ.yPw);
      break label447;
      label1053:
      this.yQL.setNum("");
      break label492;
      label1066:
      this.yQL.setVisibility(8);
      continue;
      label1078:
      if (this.mType == 1)
      {
        this.nAB.setText(this.yPZ.yUR);
        this.nAB.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.nAB.setText(this.yPZ.yUS);
        this.nAB.setVisibility(0);
      }
    }
    label1143:
    this.yQL.requestFocus();
    AppMethodBeat.o(65389);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65393);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(65393);
      return;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.yYO) && (!Util.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.ui.base.h.cD(this, getString(2131761619));
          Object localObject2 = XmlParser.parseXml(this.yYP, "msg", null);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65393);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDu((String)localObject2))
          {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!af.ac(this.yYP, (String)localObject1, 1))
            {
              Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDv((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        ega();
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65368);
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(0);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(800L);
            localScaleAnimation.setStartOffset(200L);
            localScaleAnimation.setInterpolator(new BounceInterpolator());
            SnsLuckyMoneyPrepareUI.this.findViewById(2131304225).startAnimation(localScaleAnimation);
            AppMethodBeat.o(65368);
          }
        }, 200L);
        this.rlN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65370);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            af.a(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), SnsLuckyMoneyPrepareUI.m(SnsLuckyMoneyPrepareUI.this), false);
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65369);
                SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(8);
                SnsLuckyMoneyPrepareUI.n(SnsLuckyMoneyPrepareUI.this);
                AppMethodBeat.o(65369);
              }
            }, 100L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65370);
          }
        });
        ((ImageView)findViewById(2131304216)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65371);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(8);
            SnsLuckyMoneyPrepareUI.o(SnsLuckyMoneyPrepareUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65371);
          }
        });
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(7), localObject1 });
          if (!Util.isNullOrNil((String)localObject1)) {
            doSceneProgress(new bf(((String)localObject1).replaceAll(",", "|"), this.yYM, "v1.0"));
          } else {
            finish();
          }
        }
        else if (paramInt2 == 0)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject1).putExtra("key_type", 1);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65388);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.yUr = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.yYO = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      doSceneProgress(new aq("v1.0", 0, (byte)0), false);
      com.tencent.mm.plugin.luckymoney.b.a.eex();
      this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
      Log.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.yYO + ", config " + this.yPZ);
      initView();
      com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(1) });
      AppMethodBeat.o(65388);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65390);
    super.onDestroy();
    this.yQU.clear();
    this.klF.stopped();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(65390);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65395);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      hideTenpayKB();
      AppMethodBeat.o(65395);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(65395);
    return bool;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(65392);
    if ((paramq instanceof ba))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ba)paramq;
        this.yYN = paramString.qwe;
        this.yYM = paramString.yQE;
        this.yYP = paramString.yXH;
        paramq = new PayInfo();
        paramq.dDL = paramString.wFL;
        paramq.dVv = 37;
        paramq.channel = this.mChannel;
        com.tencent.mm.pluginsdk.wallet.f.a(this, paramq, 1);
        AppMethodBeat.o(65392);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.yQO.setEnabled(false);
        this.yQO.setClickable(false);
        this.klF.startTimer(5000L);
        com.tencent.mm.ui.base.h.cD(this, paramString);
        AppMethodBeat.o(65392);
        return true;
      }
      com.tencent.mm.ui.base.h.cD(this, paramString);
      AppMethodBeat.o(65392);
      return true;
    }
    if ((paramq instanceof bf))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.yYO)
        {
          com.tencent.mm.ui.base.h.cD(this, getString(2131761619));
          finish();
        }
        for (;;)
        {
          AppMethodBeat.o(65392);
          return true;
          ega();
          this.yYK.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65364);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = SnsLuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              SnsLuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(65364);
            }
          }, 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.c(getContext(), paramString, "", getString(2131762732), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65365);
            Object localObject = new Intent();
            ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
            ((Intent)localObject).putExtra("key_type", 1);
            paramAnonymousDialogInterface = SnsLuckyMoneyPrepareUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(65365);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(65392);
        return true;
      }
    }
    else if ((paramq instanceof aq))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramq;
        com.tencent.mm.plugin.luckymoney.b.a.eex();
        this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.yPZ);
        if (this.mType != 1) {
          break label653;
        }
        this.yYI.setMaxAmount(this.yPZ.yPy);
        this.yYI.setMinAmount(this.yPZ.yPx);
        this.yQL.setMaxNum(this.yPZ.yPv);
        if ((paramString.yXl) && (this.yYO))
        {
          paramq = (TextView)findViewById(2131304218);
          paramq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65366);
              Object localObject = new b();
              ((b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
              com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
              localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
              paramAnonymousView = SnsLuckyMoneyPrepareUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65366);
            }
          });
          com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(efB()), Integer.valueOf(8) });
          paramq.setVisibility(0);
        }
        if (Util.isNullOrNil(paramString.jTx)) {
          break label670;
        }
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.jTx);
        this.yQS.setText(paramString.jTx);
        if (!Util.isNullOrNil(paramString.yXn)) {
          this.yQS.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65367);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              com.tencent.mm.wallet_core.ui.f.p(SnsLuckyMoneyPrepareUI.this.getContext(), paramString.yXn, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65367);
            }
          });
        }
        this.yQS.setVisibility(0);
      }
      for (;;)
      {
        paramq = new i.c();
        paramq.textColor = getResources().getColor(2131101357);
        i.a(this, this.yYL, paramString.yXp, paramq);
        AppMethodBeat.o(65392);
        return true;
        label653:
        this.yYI.setMaxAmount(this.yPZ.yPw);
        break;
        label670:
        this.yQS.setVisibility(8);
      }
    }
    AppMethodBeat.o(65392);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */