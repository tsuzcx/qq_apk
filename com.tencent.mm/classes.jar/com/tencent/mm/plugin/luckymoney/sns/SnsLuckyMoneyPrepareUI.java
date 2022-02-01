package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.h.c;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.base.t;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements com.tencent.mm.plugin.luckymoney.ui.g
{
  private av jkD;
  private ScrollView kLj;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private int mType;
  private TextView mkS;
  protected Button pOj;
  protected TextView peG;
  protected Dialog tipDialog;
  private j vjG;
  private com.tencent.mm.plugin.luckymoney.ui.b vkA;
  protected LuckyMoneyNumInputView vkr;
  protected LuckyMoneyTextInputView vkt;
  protected Button vku;
  private TextView vky;
  protected LuckyMoneyMoneyInputView vrB;
  private View vrC;
  private View vrD;
  private ViewGroup vrE;
  private int vrF;
  private String vrG;
  private int vrH;
  private boolean vrI;
  private String vrJ;
  
  public SnsLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65387);
    this.vkr = null;
    this.vrB = null;
    this.vkt = null;
    this.peG = null;
    this.vku = null;
    this.pOj = null;
    this.tipDialog = null;
    this.vkA = new com.tencent.mm.plugin.luckymoney.ui.b();
    this.jkD = null;
    AppMethodBeat.o(65387);
  }
  
  private int diH()
  {
    AppMethodBeat.i(65398);
    if (this.vrI)
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
  
  protected final void ai(View paramView, final int paramInt)
  {
    AppMethodBeat.i(65394);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    View localView = findViewById(2131305696);
    final EditText localEditText = (EditText)paramView.findViewById(2131301810);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(65394);
      return;
    }
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65374);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new ap().postDelayed(new Runnable()
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
        new ap().postDelayed(new Runnable()
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    paramView = (TextView)paramView.findViewById(2131301716);
    if (paramView != null) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65377);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    localView.setOnClickListener(new SnsLuckyMoneyPrepareUI.14(this));
    AppMethodBeat.o(65394);
  }
  
  public final void dhR()
  {
    AppMethodBeat.i(65397);
    com.tencent.mm.plugin.luckymoney.b.a.dhH();
    this.vjG = com.tencent.mm.plugin.luckymoney.b.a.dhI().dil();
    int i;
    double d2;
    double d1;
    if ((this.vrB.dhQ() != 3) && (this.vkr.dhQ() != 3))
    {
      i = this.vkr.getInput();
      d2 = this.vrB.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.vrB.getInput();
      }
    }
    for (;;)
    {
      if (this.vkA.djp())
      {
        this.vku.setClickable(false);
        this.vku.setEnabled(false);
        this.peG.setText(com.tencent.mm.wallet_core.ui.e.D(d2));
        AppMethodBeat.o(65397);
        return;
        if (i > 0) {
          d1 = this.vrB.getInput() / i;
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
            this.vku.setClickable(false);
            this.vku.setEnabled(false);
            break;
            if ((d2 > this.vjG.vjf) && (this.vjG.vjf > 0.0D))
            {
              this.vkA.TW(getString(2131760977, new Object[] { Math.round(this.vjG.vjf), bt.bI(this.vjG.vji, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label650;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.vjG.vjd) || (this.vjG.vjd <= 0.0D)) {
                break label644;
              }
              this.vkA.TW(getString(2131760922, new Object[] { Math.round(this.vjG.vjd), bt.bI(this.vjG.vji, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.vjG.vje) {
                  break label641;
                }
                this.vkA.TW(getString(2131760924, new Object[] { com.tencent.mm.wallet_core.ui.e.C(this.vjG.vje), bt.bI(this.vjG.vji, "") }));
                i = 1;
                break label159;
                if ((d1 <= this.vjG.vjg) || (this.vjG.vjg <= 0.0D)) {
                  break label644;
                }
                this.vkA.TW(getString(2131760922, new Object[] { Math.round(this.vjG.vjg), bt.bI(this.vjG.vji, "") }));
                this.vkr.onError();
                this.vrB.onError();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.vkA.TW(getString(2131760924, new Object[] { "0.01", bt.bI(this.vjG.vji, "") }));
                this.vkr.onError();
                this.vrB.onError();
                i = 1;
                break label159;
                this.vku.setClickable(true);
                this.vku.setEnabled(true);
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
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65391);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.vrC.getVisibility() == 0))
    {
      this.vrC.setVisibility(8);
      dje();
      AppMethodBeat.o(65391);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65391);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131494656;
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
    getResources().getDrawable(2131232950);
    setBackBtn(new SnsLuckyMoneyPrepareUI.1(this));
    this.vrC = findViewById(2131301905);
    this.vrD = findViewById(2131301908);
    this.pOj = ((Button)findViewById(2131301907));
    this.vkt = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.vkt.setHintText(getString(2131760843));
    this.vku = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.mkS = ((TextView)findViewById(2131301894));
    this.vkr = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.vrB = ((LuckyMoneyMoneyInputView)findViewById(2131301715));
    this.peG = ((TextView)findViewById(2131301909));
    this.vrE = ((ViewGroup)findViewById(2131301903));
    this.kLj = ((ScrollView)findViewById(2131301943));
    this.vky = ((TextView)findViewById(2131301901));
    Object localObject1;
    if (this.mType == 1)
    {
      this.vrB.setTitle(getString(2131760978));
      this.vrB.setShowGroupIcon(true);
      this.vrB.setOnInputValidChangerListener(this);
      this.vkr.setOnInputValidChangerListener(this);
      this.vkt.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.vrB.findViewById(2131301810);
      Object localObject2 = (EditText)this.vkr.findViewById(2131301810);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65384);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.val$hintTv.setOnClickListener(null);
          this.vkC.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vrB, 2);
          SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vkr, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65384);
        }
      });
      Object localObject3 = (TextView)this.vrB.findViewById(2131301716);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65385);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            this.val$hintTv.setOnClickListener(null);
            this.vkC.setOnClickListener(null);
            SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vrB, 2);
            SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vkr, 0);
            SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65385);
          }
        });
      }
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65386);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.val$hintTv.setOnClickListener(null);
          this.vkC.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vrB, 2);
          SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vkr, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65386);
        }
      });
      if (this.vjG != null)
      {
        if (this.mType != 1) {
          break label1031;
        }
        this.vrB.setMaxAmount(this.vjG.vjf);
        label442:
        this.vrB.setMinAmount(this.vjG.vje);
      }
      if ((!this.vrI) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1048;
      }
      this.vkr.setNum("1");
      label487:
      this.vkr.setMaxNum(this.vjG.vjc);
      this.vkr.setMinNum(1);
      ad.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.vkr.getInput());
      this.vrB.setMaxLen(12);
      if (!this.vrI) {
        break label1073;
      }
      if (getIntent().getIntExtra("key_chatroom_num", 0) <= 0) {
        break label1061;
      }
      Object localObject4 = getString(2131760885);
      Object localObject5 = getString(2131760882);
      localObject1 = getString(2131760884);
      localObject2 = getString(2131760883);
      localObject3 = new SpannableString((String)localObject4 + (String)localObject5);
      l locall = new l(this);
      ((SpannableString)localObject3).setSpan(locall, ((String)localObject4).length(), ((String)localObject4).length() + ((String)localObject5).length(), 33);
      localObject4 = new SpannableString((String)localObject1 + (String)localObject2);
      localObject5 = new l(this);
      ((SpannableString)localObject4).setSpan(localObject5, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject2).length(), 33);
      locall.DfS = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65375);
          int i = SnsLuckyMoneyPrepareUI.this.vkr.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.vrB.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 0);
          SnsLuckyMoneyPrepareUI.this.vrB.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.vrB.setShowGroupIcon(false);
          SnsLuckyMoneyPrepareUI.this.vrB.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131760979));
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.vrB.setAmount(com.tencent.mm.wallet_core.ui.e.C(d / i));
          }
          SnsLuckyMoneyPrepareUI.this.vrB.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).vjd);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.vkG);
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
          AppMethodBeat.o(65375);
        }
      };
      ((l)localObject5).DfS = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65379);
          int i = SnsLuckyMoneyPrepareUI.this.vkr.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.vrB.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 1);
          SnsLuckyMoneyPrepareUI.this.vrB.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.vrB.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131760978));
          SnsLuckyMoneyPrepareUI.this.vrB.setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.vrB.setAmount(com.tencent.mm.wallet_core.ui.e.C(d * i));
          }
          SnsLuckyMoneyPrepareUI.this.vrB.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).vjf);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.vkH);
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
          AppMethodBeat.o(65379);
        }
      };
      this.mkS.setMovementMethod(LinkMovementMethod.getInstance());
      this.mkS.setText((CharSequence)localObject3);
      this.mkS.setVisibility(0);
    }
    for (;;)
    {
      this.vku.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65381);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4) });
          if (SnsLuckyMoneyPrepareUI.this.vrB.dhQ() != 0) {
            t.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), 2131765031, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65381);
            return;
            int i = SnsLuckyMoneyPrepareUI.this.vkr.getInput();
            double d = SnsLuckyMoneyPrepareUI.this.vrB.getInput();
            long l2 = 0L;
            long l1;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) == 1)
            {
              l1 = com.tencent.mm.wallet_core.ui.e.E(d);
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().set(356354, Integer.valueOf(i));
              label201:
              localObject = SnsLuckyMoneyPrepareUI.this.vkt.getInput();
              paramAnonymousView = (View)localObject;
              if (bt.isNullOrNil((String)localObject)) {
                paramAnonymousView = SnsLuckyMoneyPrepareUI.this.getString(2131760843);
              }
              localObject = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
              if ((!SnsLuckyMoneyPrepareUI.e(SnsLuckyMoneyPrepareUI.this)) || (bt.isNullOrNil((String)localObject))) {
                break label384;
              }
            }
            label384:
            for (paramAnonymousView = new aq(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, z.diq(), (String)localObject, z.ze((String)localObject), com.tencent.mm.model.u.aAm(), com.tencent.mm.model.u.aAo(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), "");; paramAnonymousView = new aq(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, z.diq(), null, null, com.tencent.mm.model.u.aAm(), com.tencent.mm.model.u.aAo(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), ""))
            {
              SnsLuckyMoneyPrepareUI.this.doSceneProgress(paramAnonymousView, false);
              if (SnsLuckyMoneyPrepareUI.this.tipDialog == null) {
                break label429;
              }
              SnsLuckyMoneyPrepareUI.this.tipDialog.show();
              break;
              l1 = com.tencent.mm.wallet_core.ui.e.E(i * d);
              l2 = com.tencent.mm.wallet_core.ui.e.E(d);
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().set(356353, Integer.valueOf(i));
              break label201;
            }
            label429:
            SnsLuckyMoneyPrepareUI.this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(SnsLuckyMoneyPrepareUI.this.getContext(), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(65380);
                if ((SnsLuckyMoneyPrepareUI.this.tipDialog != null) && (SnsLuckyMoneyPrepareUI.this.tipDialog.isShowing())) {
                  SnsLuckyMoneyPrepareUI.this.tipDialog.hide();
                }
                if ((SnsLuckyMoneyPrepareUI.g(SnsLuckyMoneyPrepareUI.this).getVisibility() == 8) || (SnsLuckyMoneyPrepareUI.h(SnsLuckyMoneyPrepareUI.this).getVisibility() == 4))
                {
                  ad.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                  SnsLuckyMoneyPrepareUI.this.finish();
                }
                SnsLuckyMoneyPrepareUI.this.vuU.forceCancel();
                AppMethodBeat.o(65380);
              }
            });
          }
        }
      });
      this.peG.setText(com.tencent.mm.wallet_core.ui.e.D(0.0D));
      this.vkA.a(this.vkr);
      this.vkA.a(this.vrB);
      this.vkA.a(this.vkt);
      localObject1 = (TextView)findViewById(2131301898);
      this.vkA.n((TextView)localObject1);
      if ((this.vrI) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(2131301902);
        ((TextView)localObject1).setText(getString(2131760910, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.jkD = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65382);
          int i;
          double d2;
          if ((SnsLuckyMoneyPrepareUI.this.vrB.dhQ() != 3) && (SnsLuckyMoneyPrepareUI.this.vkr.dhQ() != 3))
          {
            i = SnsLuckyMoneyPrepareUI.this.vkr.getInput();
            d2 = SnsLuckyMoneyPrepareUI.this.vrB.getInput();
            d1 = d2;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).vjf) || (SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).djq()))
            {
              SnsLuckyMoneyPrepareUI.this.vku.setClickable(false);
              SnsLuckyMoneyPrepareUI.this.vku.setEnabled(false);
            }
            for (;;)
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).djq());
              SnsLuckyMoneyPrepareUI.j(SnsLuckyMoneyPrepareUI.this).fkZ();
              AppMethodBeat.o(65382);
              return false;
              SnsLuckyMoneyPrepareUI.this.vku.setClickable(true);
              SnsLuckyMoneyPrepareUI.this.vku.setEnabled(true);
            }
          }
        }
      }, false);
      if (this.kLj != null) {
        this.kLj.setOnTouchListener(new SnsLuckyMoneyPrepareUI.18(this));
      }
      this.vrB.setType(this.mType);
      if ((!this.vrI) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1138;
      }
      this.vrB.requestFocus();
      AppMethodBeat.o(65389);
      return;
      this.vrB.setTitle(getString(2131760979));
      this.vrB.setShowGroupIcon(false);
      break;
      label1031:
      this.vrB.setMaxAmount(this.vjG.vjd);
      break label442;
      label1048:
      this.vkr.setNum("");
      break label487;
      label1061:
      this.vkr.setVisibility(8);
      continue;
      label1073:
      if (this.mType == 1)
      {
        this.mkS.setText(this.vjG.vnU);
        this.mkS.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.mkS.setText(this.vjG.vnV);
        this.mkS.setVisibility(0);
      }
    }
    label1138:
    this.vkr.requestFocus();
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
        com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.vrI) && (!bt.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.ui.base.h.cl(this, getString(2131760233));
          Object localObject2 = bw.M(this.vrJ, "msg");
          if (localObject2 == null)
          {
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65393);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.dhH().dhK().aoT((String)localObject2))
          {
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!z.Z(this.vrJ, (String)localObject1, 1))
            {
              ad.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.dhH().dhK().aoU((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        djf();
        new ap().postDelayed(new SnsLuckyMoneyPrepareUI.7(this), 200L);
        this.pOj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65370);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            z.a(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), SnsLuckyMoneyPrepareUI.m(SnsLuckyMoneyPrepareUI.this), false);
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
        ((ImageView)findViewById(2131301897)).setOnClickListener(new SnsLuckyMoneyPrepareUI.9(this));
        continue;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(7), localObject1 });
          if (!bt.isNullOrNil((String)localObject1)) {
            doSceneProgress(new at(((String)localObject1).replaceAll(",", "|"), this.vrG, "v1.0"));
          } else {
            finish();
          }
        }
        else if (paramInt2 == 0)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject1).putExtra("key_type", 1);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
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
    this.vrF = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.vrI = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ai("v1.0", 0, (byte)0), false);
      com.tencent.mm.plugin.luckymoney.b.a.dhH();
      this.vjG = com.tencent.mm.plugin.luckymoney.b.a.dhI().dil();
      ad.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.vrI + ", config " + this.vjG);
      initView();
      com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(1) });
      AppMethodBeat.o(65388);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65390);
    super.onDestroy();
    this.vkA.clear();
    this.jkD.fkZ();
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65392);
    if ((paramn instanceof aq))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramn;
        this.vrH = paramString.par;
        this.vrG = paramString.vkl;
        this.vrJ = paramString.vqz;
        paramn = new PayInfo();
        paramn.dlu = paramString.thm;
        paramn.dCC = 37;
        paramn.channel = this.mChannel;
        f.a(this, paramn, 1);
        AppMethodBeat.o(65392);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.vku.setEnabled(false);
        this.vku.setClickable(false);
        this.jkD.az(5000L, 5000L);
        com.tencent.mm.ui.base.h.cl(this, paramString);
        AppMethodBeat.o(65392);
        return true;
      }
      com.tencent.mm.ui.base.h.cl(this, paramString);
      AppMethodBeat.o(65392);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.vrI)
        {
          com.tencent.mm.ui.base.h.cl(this, getString(2131760233));
          finish();
        }
        for (;;)
        {
          AppMethodBeat.o(65392);
          return true;
          djf();
          this.vrD.postDelayed(new SnsLuckyMoneyPrepareUI.2(this), 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.e(getContext(), paramString, "", getString(2131760958), getString(2131755691), new SnsLuckyMoneyPrepareUI.3(this), new SnsLuckyMoneyPrepareUI.4(this));
        AppMethodBeat.o(65392);
        return true;
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.ai)paramn;
        com.tencent.mm.plugin.luckymoney.b.a.dhH();
        this.vjG = com.tencent.mm.plugin.luckymoney.b.a.dhI().dil();
        ad.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.vjG);
        if (this.mType != 1) {
          break label656;
        }
        this.vrB.setMaxAmount(this.vjG.vjf);
        this.vrB.setMinAmount(this.vjG.vje);
        this.vkr.setMaxNum(this.vjG.vjc);
        if ((paramString.vqf) && (this.vrI))
        {
          paramn = (TextView)findViewById(2131301899);
          paramn.setOnClickListener(new SnsLuckyMoneyPrepareUI.5(this));
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(8) });
          paramn.setVisibility(0);
        }
        if (bt.isNullOrNil(paramString.iTH)) {
          break label673;
        }
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iTH);
        this.vky.setText(paramString.iTH);
        if (!bt.isNullOrNil(paramString.vqh)) {
          this.vky.setOnClickListener(new SnsLuckyMoneyPrepareUI.6(this, paramString));
        }
        this.vky.setVisibility(0);
      }
      for (;;)
      {
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131101114);
        com.tencent.mm.plugin.luckymoney.ui.h.a(this, this.vrE, paramString.vqj, paramn);
        AppMethodBeat.o(65392);
        return true;
        label656:
        this.vrB.setMaxAmount(this.vjG.vjd);
        break;
        label673:
        this.vky.setVisibility(8);
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