package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class WxaLuckyMoneyPrepareUI
  extends WxaLuckyMoneyBaseUI
  implements c, com.tencent.mm.plugin.luckymoney.ui.g
{
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private TextView mpP;
  private TextView plm;
  private h.a vvO;
  private LinearLayout vwA;
  private TextView vwB;
  private MMScrollView vwC;
  private TextView vwD;
  private int vwE;
  private com.tencent.mm.plugin.luckymoney.ui.b vwF;
  private a vwv;
  private LuckyMoneyNumInputView vww;
  private WxaLuckyMoneyMoneyInputView vwx;
  private LuckyMoneyTextInputView vwy;
  private Button vwz;
  
  public WxaLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(64965);
    this.vwv = null;
    this.vvO = h.a.vvq;
    this.vww = null;
    this.vwx = null;
    this.vwy = null;
    this.plm = null;
    this.vwz = null;
    this.vwE = 0;
    this.vwF = new com.tencent.mm.plugin.luckymoney.ui.b();
    AppMethodBeat.o(64965);
  }
  
  protected final void ai(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(64971);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    View localView = findViewById(2131305696);
    final EditText localEditText = (EditText)paramView.findViewById(2131301810);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(64971);
      return;
    }
    f.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(64951);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new aq().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(64949);
              if ((!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown())) {
                WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
              }
              WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, WxaLuckyMoneyPrepareUI.6.this.val$editMode);
              WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
              ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(64949);
            }
          }, 300L);
          AppMethodBeat.o(64951);
          return;
        }
        new aq().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64950);
            WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(WxaLuckyMoneyPrepareUI.6.this.val$hintTv, 0);
            AppMethodBeat.o(64950);
          }
        }, 200L);
        AppMethodBeat.o(64951);
      }
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64952);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, paramInt);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64952);
          return;
          if (this.val$isShowSysKB)
          {
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
            ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
          }
        }
      }
    });
    TextView localTextView = (TextView)paramView.findViewById(2131301716);
    if (localTextView != null) {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64954);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB)) {
            if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
              WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(localEditText);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64954);
            return;
            if ((!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
            {
              ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              new aq().postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(64953);
                  WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                  WxaLuckyMoneyPrepareUI.8.this.val$parent.requestFocus();
                  if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(WxaLuckyMoneyPrepareUI.8.this.val$hintTv);
                  }
                  WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, WxaLuckyMoneyPrepareUI.8.this.val$editMode);
                  AppMethodBeat.o(64953);
                }
              }, 200L);
            }
            else if (this.val$isShowSysKB)
            {
              WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
              ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
            }
          }
        }
      });
    }
    localView.setOnClickListener(new WxaLuckyMoneyPrepareUI.9(this));
    AppMethodBeat.o(64971);
  }
  
  public final MMActivity dkN()
  {
    return this;
  }
  
  public final void dkO() {}
  
  public final void dkQ()
  {
    AppMethodBeat.i(64974);
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = d3;
    double d1 = d4;
    int i;
    if (this.vwx.dkP() != 3)
    {
      d2 = d3;
      d1 = d4;
      if (this.vww.dkP() != 3)
      {
        i = this.vww.getInput();
        d4 = this.vwx.getInput();
        if (this.vvO != h.a.vvr) {
          break label162;
        }
        d1 = d4 * i;
        d2 = this.vwx.getInput();
      }
    }
    boolean bool1 = this.vwF.dmo();
    Object localObject = com.tencent.mm.plugin.luckymoney.appbrand.a.g.vvg;
    if (bool1)
    {
      ae.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
      this.vwz.setClickable(false);
      this.vwz.setEnabled(false);
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvm;
      if (!bu.isNullOrNil((String)localObject)) {
        break label773;
      }
      this.plm.setText(f.D(d1));
      AppMethodBeat.o(64974);
      return;
      label162:
      d2 = d3;
      d1 = d4;
      if (i <= 0) {
        break;
      }
      d2 = this.vwx.getInput() / i;
      d1 = d4;
      break;
      boolean bool2 = false;
      bool1 = false;
      if ((d1 == 0.0D) || (d2 == 0.0D)) {
        bool1 = true;
      }
      for (;;)
      {
        if (bool1)
        {
          this.vwz.setClickable(false);
          this.vwz.setEnabled(false);
          break;
          if ((d1 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvk) && (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvk > 0.0D))
          {
            this.vwF.UG(getString(2131760977, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvk), bu.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvn, "") }));
            bool1 = true;
          }
          else if (d2 > 0.0D)
          {
            ae.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
            if (this.vvO == h.a.vvr)
            {
              bool1 = bool2;
              if (d2 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvi)
              {
                bool1 = bool2;
                if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvi > 0.0D)
                {
                  this.vwF.UG(getString(2131760922, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvi), bu.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvn, "") }));
                  bool1 = true;
                }
              }
              label436:
              ae.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
              bool2 = bool1;
              if (!bool1)
              {
                if (this.vvO != h.a.vvr) {
                  break label684;
                }
                bool2 = bool1;
                if (d2 < ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvj)
                {
                  this.vwF.UG(getString(2131760924, new Object[] { f.C(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvj), bu.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvn, "") }));
                  bool2 = true;
                }
              }
            }
            for (;;)
            {
              ae.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              bool1 = bool2;
              break;
              bool1 = bool2;
              if (d2 <= ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvl) {
                break label436;
              }
              bool1 = bool2;
              if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvl <= 0.0D) {
                break label436;
              }
              this.vwF.UG(getString(2131760922, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvl), bu.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvn, "") }));
              bool1 = true;
              this.vww.onError();
              this.vwx.onError();
              break label436;
              label684:
              bool2 = bool1;
              if (d2 < 0.01D)
              {
                this.vwF.UG(getString(2131760924, new Object[] { "0.01", bu.bI(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).vvn, "") }));
                bool2 = true;
                this.vww.onError();
                this.vwx.onError();
              }
            }
          }
        }
      }
      this.vwz.setClickable(true);
      this.vwz.setEnabled(true);
    }
    label773:
    this.plm.setText((String)localObject + f.C(d1));
    AppMethodBeat.o(64974);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64967);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131765901);
    }
    h.a(this, str, null, false, new WxaLuckyMoneyPrepareUI.1(this));
    AppMethodBeat.o(64967);
  }
  
  public int getLayoutId()
  {
    return 2131496119;
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(64973);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown())) {
      this.mKBLayout.setVisibility(8);
    }
    AppMethodBeat.o(64973);
  }
  
  public void initView()
  {
    AppMethodBeat.i(64968);
    setBackBtn(new WxaLuckyMoneyPrepareUI.10(this));
    this.vwy = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.vwy.setHintText(getString(2131760843));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    ae.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!bu.isNullOrNil((String)localObject1)) {
      this.vwy.setHintText((String)localObject1);
    }
    this.vwz = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.mpP = ((TextView)findViewById(2131301894));
    this.vww = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.vwx = ((WxaLuckyMoneyMoneyInputView)findViewById(2131301715));
    this.plm = ((TextView)findViewById(2131301909));
    this.vwC = ((MMScrollView)findViewById(2131301943));
    this.vwD = ((TextView)findViewById(2131301901));
    this.vwA = ((LinearLayout)findViewById(2131301911));
    this.vwB = ((TextView)findViewById(2131301912));
    setMMTitle(2131760975);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.vvO == h.a.vvq)
    {
      this.vwx.setTitle(getString(2131760978));
      this.vwx.setShowGroupIcon(true);
      this.vwx.setOnInputValidChangerListener(this);
      this.vwx.setHint(getString(2131760895));
      this.vww.setOnInputValidChangerListener(this);
      this.vww.setHint(getString(2131760911));
      this.vww.setNum("");
      this.vwy.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.vwx.findViewById(2131301810);
      localObject3 = (EditText)this.vww.findViewById(2131301810);
      f.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64945);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.val$hintTv.setOnClickListener(null);
          this.vwH.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64945);
        }
      });
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.vwx.findViewById(2131301716);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64946);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            this.val$hintTv.setOnClickListener(null);
            this.vwH.setOnClickListener(null);
            WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
            WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64946);
          }
        });
      }
      f.setNoSystemInputOnEditText((EditText)localObject3);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject3, 0);
      ((EditText)localObject3).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64947);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.val$hintTv.setOnClickListener(null);
          this.vwH.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64947);
        }
      });
      ((MMEditText)this.vwy.findViewById(2131301944)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64948);
          this.val$hintTv.setOnClickListener(null);
          this.vwH.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ai(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(64948);
        }
      });
      localObject2 = com.tencent.mm.plugin.luckymoney.appbrand.a.g.vvg;
      if (this.vvO != h.a.vvq) {
        break label1022;
      }
      this.vwx.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).vvk);
    }
    int i;
    for (;;)
    {
      this.vwx.setMinAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).vvj);
      this.vww.setMaxNum(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).vvh);
      localObject2 = h.a.vvq;
      this.vww.setMinNum(1);
      this.vwx.setMaxLen(12);
      Object localObject5 = getString(2131760867);
      Object localObject6 = getString(2131760882);
      localObject2 = getString(2131760861);
      localObject3 = getString(2131760883);
      localObject4 = new l(this);
      final SpannableString localSpannableString = new SpannableString((String)localObject5 + (String)localObject6);
      localSpannableString.setSpan(localObject4, ((String)localObject5).length(), ((String)localObject5).length() + ((String)localObject6).length(), 33);
      localObject5 = new SpannableString((String)localObject2 + (String)localObject3);
      localObject6 = new l(this);
      ((SpannableString)localObject5).setSpan(localObject6, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject3).length(), 33);
      ((l)localObject4).Dxw = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64960);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.vvr);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(false);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131760979));
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(f.C(d / i));
          }
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.vvg.vvi);
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(this.vwL);
          AppMethodBeat.o(64960);
        }
      };
      ((l)localObject6).Dxw = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64961);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.vvq);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.vvg.vvk);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(2131760978));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(f.C(d * i));
          }
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(localSpannableString);
          AppMethodBeat.o(64961);
        }
      };
      this.mpP.setMovementMethod(LinkMovementMethod.getInstance());
      this.mpP.setText(localSpannableString);
      this.mpP.setVisibility(0);
      this.vwz.setClickable(false);
      this.vwz.setEnabled(false);
      this.vwz.setOnClickListener(new w()
      {
        public final void ccc()
        {
          AppMethodBeat.i(64957);
          if (WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this) == null)
          {
            ae.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).dkP() != 0)
          {
            t.makeText(WxaLuckyMoneyPrepareUI.this.getContext(), 2131765031, 0).show();
            AppMethodBeat.o(64957);
            return;
          }
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          String str2 = WxaLuckyMoneyPrepareUI.d(WxaLuckyMoneyPrepareUI.this).getInput();
          String str1 = str2;
          if (bu.isNullOrNil(str2)) {
            if (bu.isNullOrNil(this.vwK)) {
              break label171;
            }
          }
          label171:
          for (str1 = this.vwK; WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.vvq; str1 = WxaLuckyMoneyPrepareUI.this.getString(2131760843))
          {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).c((int)f.E(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.vvr) {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).d((int)f.E(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
          }
          AppMethodBeat.o(64957);
        }
      });
      this.vwF.a(this.vww);
      this.vwF.a(this.vwx);
      this.vwF.a(this.vwy);
      localObject1 = (TextView)findViewById(2131301898);
      this.vwF.m((TextView)localObject1);
      if (this.vwC != null) {
        this.vwC.setOnTouchListener(new WxaLuckyMoneyPrepareUI.12(this));
      }
      this.vwx.setType(this.vvO);
      addIconOptionMenu(0, 2131233032, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64959);
          f.p(WxaLuckyMoneyPrepareUI.this.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
          AppMethodBeat.o(64959);
          return true;
        }
      });
      i = getIntent().getIntExtra("range", 0);
      ae.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.vwA.setVisibility(8);
      if (i != 0) {
        break label1036;
      }
      this.vwE = 0;
      AppMethodBeat.o(64968);
      return;
      this.vwx.setTitle(getString(2131760979));
      this.vwx.setShowGroupIcon(false);
      break;
      label1022:
      this.vwx.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).vvi);
    }
    label1036:
    if (i == 1)
    {
      this.vwE = 1;
      AppMethodBeat.o(64968);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(2131766304));
    ((ArrayList)localObject1).add(getString(2131766305));
    this.vwA.setVisibility(0);
    this.vwB.setText((CharSequence)((ArrayList)localObject1).get(this.vwE));
    this.vwA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(64963);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.c(WxaLuckyMoneyPrepareUI.this.getContext(), this.rkt);
        paramAnonymousView.agm(WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
        paramAnonymousView.Lxq = new c.a()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(64962);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              WxaLuckyMoneyPrepareUI.h(WxaLuckyMoneyPrepareUI.this).setText((CharSequence)paramAnonymous2Object1);
            }
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, paramAnonymousView.fRg());
            AppMethodBeat.o(64962);
          }
        };
        paramAnonymousView.show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64963);
      }
    });
    AppMethodBeat.o(64968);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(64969);
    setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
    finish();
    AppMethodBeat.o(64969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64966);
    super.onCreate(paramBundle);
    initView();
    this.vwv = new d();
    this.vwv.d(this, getIntent());
    AppMethodBeat.o(64966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64970);
    super.onDestroy();
    this.vwF.clear();
    if (this.vwv != null) {
      this.vwv.onDestroy();
    }
    AppMethodBeat.o(64970);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(64972);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(64972);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(64972);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */