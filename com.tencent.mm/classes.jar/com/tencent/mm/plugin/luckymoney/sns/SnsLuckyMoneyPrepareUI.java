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
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.h.c;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.t;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class SnsLuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements com.tencent.mm.plugin.luckymoney.ui.g
{
  private aw jnx;
  private ScrollView kOy;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private int mType;
  private TextView mpP;
  protected Button pUO;
  protected TextView plm;
  protected Dialog tipDialog;
  protected LuckyMoneyMoneyInputView vDG;
  private View vDH;
  private View vDI;
  private ViewGroup vDJ;
  private int vDK;
  private String vDL;
  private int vDM;
  private boolean vDN;
  private String vDO;
  private j vvL;
  private TextView vwD;
  private com.tencent.mm.plugin.luckymoney.ui.b vwF;
  protected LuckyMoneyNumInputView vww;
  protected LuckyMoneyTextInputView vwy;
  protected Button vwz;
  
  public SnsLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65387);
    this.vww = null;
    this.vDG = null;
    this.vwy = null;
    this.plm = null;
    this.vwz = null;
    this.pUO = null;
    this.tipDialog = null;
    this.vwF = new com.tencent.mm.plugin.luckymoney.ui.b();
    this.jnx = null;
    AppMethodBeat.o(65387);
  }
  
  private int dlG()
  {
    AppMethodBeat.i(65398);
    if (this.vDN)
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
    com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65374);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
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
        new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    if ((paramKeyEvent.getKeyCode() == 4) && (this.vDH.getVisibility() == 0))
    {
      this.vDH.setVisibility(8);
      dmd();
      AppMethodBeat.o(65391);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65391);
    return bool;
  }
  
  public final void dkQ()
  {
    AppMethodBeat.i(65397);
    com.tencent.mm.plugin.luckymoney.b.a.dkG();
    this.vvL = com.tencent.mm.plugin.luckymoney.b.a.dkH().dlk();
    int i;
    double d2;
    double d1;
    if ((this.vDG.dkP() != 3) && (this.vww.dkP() != 3))
    {
      i = this.vww.getInput();
      d2 = this.vDG.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.vDG.getInput();
      }
    }
    for (;;)
    {
      if (this.vwF.dmo())
      {
        this.vwz.setClickable(false);
        this.vwz.setEnabled(false);
        this.plm.setText(com.tencent.mm.wallet_core.ui.f.D(d2));
        AppMethodBeat.o(65397);
        return;
        if (i > 0) {
          d1 = this.vDG.getInput() / i;
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
            this.vwz.setClickable(false);
            this.vwz.setEnabled(false);
            break;
            if ((d2 > this.vvL.vvk) && (this.vvL.vvk > 0.0D))
            {
              this.vwF.UG(getString(2131760977, new Object[] { Math.round(this.vvL.vvk), bu.bI(this.vvL.vvn, "") }));
              i = 1;
              continue;
            }
            if (d1 <= 0.0D) {
              break label650;
            }
            if (this.mType == 0)
            {
              if ((d1 <= this.vvL.vvi) || (this.vvL.vvi <= 0.0D)) {
                break label644;
              }
              this.vwF.UG(getString(2131760922, new Object[] { Math.round(this.vvL.vvi), bu.bI(this.vvL.vvn, "") }));
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              if (this.mType == 0)
              {
                if (d1 >= this.vvL.vvj) {
                  break label641;
                }
                this.vwF.UG(getString(2131760924, new Object[] { com.tencent.mm.wallet_core.ui.f.C(this.vvL.vvj), bu.bI(this.vvL.vvn, "") }));
                i = 1;
                break label159;
                if ((d1 <= this.vvL.vvl) || (this.vvL.vvl <= 0.0D)) {
                  break label644;
                }
                this.vwF.UG(getString(2131760922, new Object[] { Math.round(this.vvL.vvl), bu.bI(this.vvL.vvn, "") }));
                this.vww.onError();
                this.vDG.onError();
                i = 1;
                continue;
              }
              if (d1 < 0.01D)
              {
                this.vwF.UG(getString(2131760924, new Object[] { "0.01", bu.bI(this.vvL.vvn, "") }));
                this.vww.onError();
                this.vDG.onError();
                i = 1;
                break label159;
                this.vwz.setClickable(true);
                this.vwz.setEnabled(true);
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
    this.vDH = findViewById(2131301905);
    this.vDI = findViewById(2131301908);
    this.pUO = ((Button)findViewById(2131301907));
    this.vwy = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.vwy.setHintText(getString(2131760843));
    this.vwz = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.mpP = ((TextView)findViewById(2131301894));
    this.vww = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.vDG = ((LuckyMoneyMoneyInputView)findViewById(2131301715));
    this.plm = ((TextView)findViewById(2131301909));
    this.vDJ = ((ViewGroup)findViewById(2131301903));
    this.kOy = ((ScrollView)findViewById(2131301943));
    this.vwD = ((TextView)findViewById(2131301901));
    Object localObject1;
    if (this.mType == 1)
    {
      this.vDG.setTitle(getString(2131760978));
      this.vDG.setShowGroupIcon(true);
      this.vDG.setOnInputValidChangerListener(this);
      this.vww.setOnInputValidChangerListener(this);
      this.vwy.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.vDG.findViewById(2131301810);
      Object localObject2 = (EditText)this.vww.findViewById(2131301810);
      com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65384);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.val$hintTv.setOnClickListener(null);
          this.vwH.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vDG, 2);
          SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vww, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65384);
        }
      });
      Object localObject3 = (TextView)this.vDG.findViewById(2131301716);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65385);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            this.val$hintTv.setOnClickListener(null);
            this.vwH.setOnClickListener(null);
            SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vDG, 2);
            SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vww, 0);
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.val$hintTv.setOnClickListener(null);
          this.vwH.setOnClickListener(null);
          SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vDG, 2);
          SnsLuckyMoneyPrepareUI.this.ai(SnsLuckyMoneyPrepareUI.this.vww, 0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65386);
        }
      });
      if (this.vvL != null)
      {
        if (this.mType != 1) {
          break label1032;
        }
        this.vDG.setMaxAmount(this.vvL.vvk);
        label443:
        this.vDG.setMinAmount(this.vvL.vvj);
      }
      if ((!this.vDN) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1049;
      }
      this.vww.setNum("1");
      label488:
      this.vww.setMaxNum(this.vvL.vvh);
      this.vww.setMinNum(1);
      ae.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.vww.getInput());
      this.vDG.setMaxLen(12);
      if (!this.vDN) {
        break label1074;
      }
      if (getIntent().getIntExtra("key_chatroom_num", 0) <= 0) {
        break label1062;
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
      locall.Dxw = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65375);
          int i = SnsLuckyMoneyPrepareUI.this.vww.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.vDG.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 0);
          SnsLuckyMoneyPrepareUI.this.vDG.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.vDG.setShowGroupIcon(false);
          SnsLuckyMoneyPrepareUI.this.vDG.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131760979));
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.vDG.setAmount(com.tencent.mm.wallet_core.ui.f.C(d / i));
          }
          SnsLuckyMoneyPrepareUI.this.vDG.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).vvi);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.vwL);
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
          AppMethodBeat.o(65375);
        }
      };
      ((l)localObject5).Dxw = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65379);
          int i = SnsLuckyMoneyPrepareUI.this.vww.getInput();
          double d = SnsLuckyMoneyPrepareUI.this.vDG.getInput();
          SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this, 1);
          SnsLuckyMoneyPrepareUI.this.vDG.setType(SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this));
          SnsLuckyMoneyPrepareUI.this.vDG.setTitle(SnsLuckyMoneyPrepareUI.this.getString(2131760978));
          SnsLuckyMoneyPrepareUI.this.vDG.setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            SnsLuckyMoneyPrepareUI.this.vDG.setAmount(com.tencent.mm.wallet_core.ui.f.C(d * i));
          }
          SnsLuckyMoneyPrepareUI.this.vDG.setMaxAmount(SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).vvk);
          SnsLuckyMoneyPrepareUI.c(SnsLuckyMoneyPrepareUI.this).setText(this.vwM);
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
          AppMethodBeat.o(65379);
        }
      };
      this.mpP.setMovementMethod(LinkMovementMethod.getInstance());
      this.mpP.setText((CharSequence)localObject3);
      this.mpP.setVisibility(0);
    }
    for (;;)
    {
      this.vwz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65381);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4) });
          if (SnsLuckyMoneyPrepareUI.this.vDG.dkP() != 0) {
            t.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), 2131765031, 0).show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65381);
            return;
            int i = SnsLuckyMoneyPrepareUI.this.vww.getInput();
            double d = SnsLuckyMoneyPrepareUI.this.vDG.getInput();
            long l2 = 0L;
            long l1;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) == 1)
            {
              l1 = com.tencent.mm.wallet_core.ui.f.E(d);
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(356354, Integer.valueOf(i));
              label201:
              localObject = SnsLuckyMoneyPrepareUI.this.vwy.getInput();
              paramAnonymousView = (View)localObject;
              if (bu.isNullOrNil((String)localObject)) {
                paramAnonymousView = SnsLuckyMoneyPrepareUI.this.getString(2131760843);
              }
              localObject = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
              if ((!SnsLuckyMoneyPrepareUI.e(SnsLuckyMoneyPrepareUI.this)) || (bu.isNullOrNil((String)localObject))) {
                break label384;
              }
            }
            label384:
            for (paramAnonymousView = new com.tencent.mm.plugin.luckymoney.model.aq(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, z.dlp(), (String)localObject, z.zO((String)localObject), v.aAC(), v.aAE(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), "");; paramAnonymousView = new com.tencent.mm.plugin.luckymoney.model.aq(i, l1, l2, SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this), paramAnonymousView, z.dlp(), null, null, v.aAC(), v.aAE(), SnsLuckyMoneyPrepareUI.f(SnsLuckyMoneyPrepareUI.this), ""))
            {
              SnsLuckyMoneyPrepareUI.this.doSceneProgress(paramAnonymousView, false);
              if (SnsLuckyMoneyPrepareUI.this.tipDialog == null) {
                break label429;
              }
              SnsLuckyMoneyPrepareUI.this.tipDialog.show();
              break;
              l1 = com.tencent.mm.wallet_core.ui.f.E(i * d);
              l2 = com.tencent.mm.wallet_core.ui.f.E(d);
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(356353, Integer.valueOf(i));
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
                  ae.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                  SnsLuckyMoneyPrepareUI.this.finish();
                }
                SnsLuckyMoneyPrepareUI.this.vGY.forceCancel();
                AppMethodBeat.o(65380);
              }
            });
          }
        }
      });
      this.plm.setText(com.tencent.mm.wallet_core.ui.f.D(0.0D));
      this.vwF.a(this.vww);
      this.vwF.a(this.vDG);
      this.vwF.a(this.vwy);
      localObject1 = (TextView)findViewById(2131301898);
      this.vwF.m((TextView)localObject1);
      if ((this.vDN) && (this.mType == 1))
      {
        localObject1 = (TextView)findViewById(2131301902);
        ((TextView)localObject1).setText(getString(2131760910, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject1).setVisibility(0);
      }
      this.jnx = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65382);
          int i;
          double d2;
          if ((SnsLuckyMoneyPrepareUI.this.vDG.dkP() != 3) && (SnsLuckyMoneyPrepareUI.this.vww.dkP() != 3))
          {
            i = SnsLuckyMoneyPrepareUI.this.vww.getInput();
            d2 = SnsLuckyMoneyPrepareUI.this.vDG.getInput();
            d1 = d2;
            if (SnsLuckyMoneyPrepareUI.a(SnsLuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this).vvk) || (SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).dmp()))
            {
              SnsLuckyMoneyPrepareUI.this.vwz.setClickable(false);
              SnsLuckyMoneyPrepareUI.this.vwz.setEnabled(false);
            }
            for (;;)
            {
              ae.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + SnsLuckyMoneyPrepareUI.i(SnsLuckyMoneyPrepareUI.this).dmp());
              SnsLuckyMoneyPrepareUI.j(SnsLuckyMoneyPrepareUI.this).foU();
              AppMethodBeat.o(65382);
              return false;
              SnsLuckyMoneyPrepareUI.this.vwz.setClickable(true);
              SnsLuckyMoneyPrepareUI.this.vwz.setEnabled(true);
            }
          }
        }
      }, false);
      if (this.kOy != null) {
        this.kOy.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(65383);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
              SnsLuckyMoneyPrepareUI.this.hideVKB();
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(65383);
            return false;
          }
        });
      }
      this.vDG.setType(this.mType);
      if ((!this.vDN) || (getIntent().getIntExtra("key_chatroom_num", 0) != 0)) {
        break label1139;
      }
      this.vDG.requestFocus();
      AppMethodBeat.o(65389);
      return;
      this.vDG.setTitle(getString(2131760979));
      this.vDG.setShowGroupIcon(false);
      break;
      label1032:
      this.vDG.setMaxAmount(this.vvL.vvi);
      break label443;
      label1049:
      this.vww.setNum("");
      break label488;
      label1062:
      this.vww.setVisibility(8);
      continue;
      label1074:
      if (this.mType == 1)
      {
        this.mpP.setText(this.vvL.vzZ);
        this.mpP.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.mpP.setText(this.vvL.vAa);
        this.mpP.setVisibility(0);
      }
    }
    label1139:
    this.vww.requestFocus();
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
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(5) });
        Object localObject1 = getIntent().getStringExtra("key_username");
        if ((this.vDN) && (!bu.isNullOrNil((String)localObject1)))
        {
          com.tencent.mm.ui.base.h.cm(this, getString(2131760233));
          Object localObject2 = bx.M(this.vDO, "msg");
          if (localObject2 == null)
          {
            ae.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65393);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.dkG().dkJ().apY((String)localObject2))
          {
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!z.Z(this.vDO, (String)localObject1, 1))
            {
              ae.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.dkG().dkJ().apZ((String)localObject2);
            }
          }
          for (;;)
          {
            finish();
            break;
            ae.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          }
        }
        dme();
        new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65368);
            SnsLuckyMoneyPrepareUI.l(SnsLuckyMoneyPrepareUI.this).setVisibility(0);
            ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
            localScaleAnimation.setDuration(800L);
            localScaleAnimation.setStartOffset(200L);
            localScaleAnimation.setInterpolator(new BounceInterpolator());
            SnsLuckyMoneyPrepareUI.this.findViewById(2131301906).startAnimation(localScaleAnimation);
            AppMethodBeat.o(65368);
          }
        }, 200L);
        this.pUO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65370);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
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
        ((ImageView)findViewById(2131301897)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65371);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(7), localObject1 });
          if (!bu.isNullOrNil((String)localObject1)) {
            doSceneProgress(new at(((String)localObject1).replaceAll(",", "|"), this.vDL, "v1.0"));
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
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
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
    this.vDK = getIntent().getIntExtra("key_way", 3);
    if (getIntent().getIntExtra("key_from", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.vDN = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      doSceneProgress(new ai("v1.0", 0, (byte)0), false);
      com.tencent.mm.plugin.luckymoney.b.a.dkG();
      this.vvL = com.tencent.mm.plugin.luckymoney.b.a.dkH().dlk();
      ae.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.vDN + ", config " + this.vvL);
      initView();
      com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(1) });
      AppMethodBeat.o(65388);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65390);
    super.onDestroy();
    this.vwF.clear();
    this.jnx.foU();
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65392);
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.aq))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.hide();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.aq)paramn;
        this.vDM = paramString.pgV;
        this.vDL = paramString.vwq;
        this.vDO = paramString.vCE;
        paramn = new PayInfo();
        paramn.dmw = paramString.tsf;
        paramn.dDH = 37;
        paramn.channel = this.mChannel;
        com.tencent.mm.pluginsdk.wallet.f.a(this, paramn, 1);
        AppMethodBeat.o(65392);
        return true;
      }
      if (paramInt2 == 401)
      {
        this.vwz.setEnabled(false);
        this.vwz.setClickable(false);
        this.jnx.ay(5000L, 5000L);
        com.tencent.mm.ui.base.h.cm(this, paramString);
        AppMethodBeat.o(65392);
        return true;
      }
      com.tencent.mm.ui.base.h.cm(this, paramString);
      AppMethodBeat.o(65392);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.vDN)
        {
          com.tencent.mm.ui.base.h.cm(this, getString(2131760233));
          finish();
        }
        for (;;)
        {
          AppMethodBeat.o(65392);
          return true;
          dme();
          this.vDI.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65364);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = SnsLuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              SnsLuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(65364);
            }
          }, 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.e(getContext(), paramString, "", getString(2131760958), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65365);
            Object localObject = new Intent();
            ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
            ((Intent)localObject).putExtra("key_type", 1);
            paramAnonymousDialogInterface = SnsLuckyMoneyPrepareUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    else if ((paramn instanceof ai))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ai)paramn;
        com.tencent.mm.plugin.luckymoney.b.a.dkG();
        this.vvL = com.tencent.mm.plugin.luckymoney.b.a.dkH().dlk();
        ae.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.vvL);
        if (this.mType != 1) {
          break label656;
        }
        this.vDG.setMaxAmount(this.vvL.vvk);
        this.vDG.setMinAmount(this.vvL.vvj);
        this.vww.setMaxNum(this.vvL.vvh);
        if ((paramString.vCk) && (this.vDN))
        {
          paramn = (TextView)findViewById(2131301899);
          paramn.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65366);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
              localObject = new Intent();
              ((Intent)localObject).setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
              paramAnonymousView = SnsLuckyMoneyPrepareUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65366);
            }
          });
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(8) });
          paramn.setVisibility(0);
        }
        if (bu.isNullOrNil(paramString.iWA)) {
          break label673;
        }
        ae.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iWA);
        this.vwD.setText(paramString.iWA);
        if (!bu.isNullOrNil(paramString.vCm)) {
          this.vwD.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65367);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.wallet_core.ui.f.p(SnsLuckyMoneyPrepareUI.this.getContext(), paramString.vCm, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65367);
            }
          });
        }
        this.vwD.setVisibility(0);
      }
      for (;;)
      {
        paramn = new h.c();
        paramn.textColor = getResources().getColor(2131101114);
        com.tencent.mm.plugin.luckymoney.ui.h.a(this, this.vDJ, paramString.vCo, paramn);
        AppMethodBeat.o(65392);
        return true;
        label656:
        this.vDG.setMaxAmount(this.vvL.vvi);
        break;
        label673:
        this.vwD.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */