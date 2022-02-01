package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class WxaLuckyMoneyPrepareUI
  extends WxaLuckyMoneyBaseUI
  implements c, h
{
  private static final String Knp;
  private h.a KmI;
  private a Kno;
  private LuckyMoneyNumInputView Knq;
  private WxaLuckyMoneyMoneyInputView Knr;
  private LuckyMoneyTextInputView Kns;
  private Button Knt;
  private LinearLayout Knu;
  private TextView Knv;
  private MMScrollView Knw;
  private TextView Knx;
  private int Kny;
  private com.tencent.mm.plugin.luckymoney.ui.c Knz;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private TextView tHK;
  private TextView xcT;
  
  static
  {
    AppMethodBeat.i(284099);
    Knp = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf7";
    AppMethodBeat.o(284099);
  }
  
  public WxaLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(64965);
    this.Kno = null;
    this.KmI = h.a.Kmk;
    this.Knq = null;
    this.Knr = null;
    this.Kns = null;
    this.xcT = null;
    this.Knt = null;
    this.Kny = 0;
    this.Knz = new com.tencent.mm.plugin.luckymoney.ui.c();
    AppMethodBeat.o(64965);
  }
  
  protected final void aF(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(64971);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    final EditText localEditText = (EditText)paramView.findViewById(a.f.lucky_money_et);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(64971);
      return;
    }
    i.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(64951);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
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
        new MMHandler().postDelayed(new Runnable()
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
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    TextView localTextView = (TextView)paramView.findViewById(a.f.lucky_money_amount_unit_title);
    if (localTextView != null) {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64954);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
              new MMHandler().postDelayed(new Runnable()
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
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64955);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64955);
      }
    });
    AppMethodBeat.o(64971);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64967);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(a.i.wallet_unknown_err);
    }
    k.a(this, str, null, false, new WxaLuckyMoneyPrepareUI.1(this));
    AppMethodBeat.o(64967);
  }
  
  public final MMActivity fWt()
  {
    return this;
  }
  
  public final void fWu() {}
  
  public final void fWx()
  {
    AppMethodBeat.i(64974);
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = d3;
    double d1 = d4;
    int i;
    if (this.Knr.fWv() != 3)
    {
      d2 = d3;
      d1 = d4;
      if (this.Knq.fWv() != 3)
      {
        i = this.Knq.getInput();
        d4 = this.Knr.getInput();
        if (this.KmI != h.a.Kml) {
          break label166;
        }
        d1 = d4 * i;
        d2 = this.Knr.getInput();
      }
    }
    boolean bool1 = this.Knz.fYs();
    Object localObject = g.Kma;
    if (bool1)
    {
      Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
      this.Knt.setClickable(false);
      this.Knt.setEnabled(false);
    }
    for (;;)
    {
      localObject = ((g)localObject).Kmg;
      if (!Util.isNullOrNil((String)localObject)) {
        break label780;
      }
      this.xcT.setText(i.X(d1));
      AppMethodBeat.o(64974);
      return;
      label166:
      d2 = d3;
      d1 = d4;
      if (i <= 0) {
        break;
      }
      d2 = this.Knr.getInput() / i;
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
          this.Knt.setClickable(false);
          this.Knt.setEnabled(false);
          break;
          if ((d1 > ((g)localObject).Kme) && (((g)localObject).Kme > 0.0D))
          {
            this.Knz.afy(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(((g)localObject).Kme), Util.nullAs(((g)localObject).Kmh, "") }));
            bool1 = true;
          }
          else if (d2 > 0.0D)
          {
            Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
            if (this.KmI == h.a.Kml)
            {
              bool1 = bool2;
              if (d2 > ((g)localObject).Kmc)
              {
                bool1 = bool2;
                if (((g)localObject).Kmc > 0.0D)
                {
                  this.Knz.afy(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(((g)localObject).Kmc), Util.nullAs(((g)localObject).Kmh, "") }));
                  bool1 = true;
                }
              }
              label441:
              Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
              bool2 = bool1;
              if (!bool1)
              {
                if (this.KmI != h.a.Kml) {
                  break label691;
                }
                bool2 = bool1;
                if (d2 < ((g)localObject).Kmd)
                {
                  this.Knz.afy(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { i.formatMoney2f(((g)localObject).Kmd), Util.nullAs(((g)localObject).Kmh, "") }));
                  bool2 = true;
                }
              }
            }
            for (;;)
            {
              Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              bool1 = bool2;
              break;
              bool1 = bool2;
              if (d2 <= ((g)localObject).Kmf) {
                break label441;
              }
              bool1 = bool2;
              if (((g)localObject).Kmf <= 0.0D) {
                break label441;
              }
              this.Knz.afy(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(((g)localObject).Kmf), Util.nullAs(((g)localObject).Kmh, "") }));
              bool1 = true;
              this.Knq.atR();
              this.Knr.atR();
              break label441;
              label691:
              bool2 = bool1;
              if (d2 < 0.01D)
              {
                this.Knz.afy(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", Util.nullAs(((g)localObject).Kmh, "") }));
                bool2 = true;
                this.Knq.atR();
                this.Knr.atR();
              }
            }
          }
        }
      }
      this.Knt.setClickable(true);
      this.Knt.setEnabled(true);
    }
    label780:
    this.xcT.setText((String)localObject + i.formatMoney2f(d1));
    AppMethodBeat.o(64974);
  }
  
  public int getLayoutId()
  {
    return a.g.wxa_lucky_money_prepare_ui;
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64956);
        WxaLuckyMoneyPrepareUI.this.setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        WxaLuckyMoneyPrepareUI.this.finish();
        AppMethodBeat.o(64956);
        return true;
      }
    });
    this.Kns = ((LuckyMoneyTextInputView)findViewById(a.f.lucky_money_wish_et));
    this.Kns.setHintText(getString(a.i.lucky_money_default_wish));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!Util.isNullOrNil((String)localObject1)) {
      this.Kns.setHintText((String)localObject1);
    }
    this.Knt = ((Button)findViewById(a.f.lucky_money_prepare_btn));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    this.tHK = ((TextView)findViewById(a.f.lucky_money_prepare_amount_tips));
    this.Knq = ((LuckyMoneyNumInputView)findViewById(a.f.lucky_money_num_et));
    this.Knr = ((WxaLuckyMoneyMoneyInputView)findViewById(a.f.lucky_money_amount_et));
    this.xcT = ((TextView)findViewById(a.f.lucky_money_prepare_total_amount));
    this.Knw = ((MMScrollView)findViewById(a.f.lucky_money_sv));
    this.Knx = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    this.Knu = ((LinearLayout)findViewById(a.f.lucky_money_range_ll));
    this.Knv = ((TextView)findViewById(a.f.lucky_money_range_result));
    setMMTitle(a.i.lucky_money_to_send_title);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.KmI == h.a.Kmk)
    {
      this.Knr.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.Knr.setShowGroupIcon(true);
      this.Knr.setOnInputValidChangerListener(this);
      this.Knr.setHint(getString(a.i.lucky_money_money_hint));
      this.Knq.setOnInputValidChangerListener(this);
      this.Knq.setHint(getString(a.i.lucky_money_num_hint));
      this.Knq.setNum("");
      this.Kns.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.Knr.findViewById(a.f.lucky_money_et);
      localObject3 = (EditText)this.Knq.findViewById(a.f.lucky_money_et);
      i.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64945);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          this.val$hintTv.setOnClickListener(null);
          this.KnB.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.aF(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.aF(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64945);
        }
      });
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.Knr.findViewById(a.f.lucky_money_amount_unit_title);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64946);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            this.val$hintTv.setOnClickListener(null);
            this.KnB.setOnClickListener(null);
            WxaLuckyMoneyPrepareUI.this.aF(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
            WxaLuckyMoneyPrepareUI.this.aF(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64946);
          }
        });
      }
      i.setNoSystemInputOnEditText((EditText)localObject3);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject3, 0);
      ((EditText)localObject3).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64947);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          this.val$hintTv.setOnClickListener(null);
          this.KnB.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.aF(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.aF(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64947);
        }
      });
      ((MMEditText)this.Kns.findViewById(a.f.lucky_money_text)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64948);
          this.val$hintTv.setOnClickListener(null);
          this.KnB.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.aF(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.aF(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(64948);
        }
      });
      localObject2 = g.Kma;
      if (this.KmI != h.a.Kmk) {
        break label1029;
      }
      this.Knr.setMaxAmount(((g)localObject2).Kme);
    }
    int i;
    for (;;)
    {
      this.Knr.setMinAmount(((g)localObject2).Kmd);
      this.Knq.setMaxNum(((g)localObject2).Kmb);
      localObject2 = h.a.Kmk;
      this.Knq.setMinNum(1);
      this.Knr.setMaxLen(12);
      Object localObject5 = getString(a.i.lucky_money_f2f_random_tip_prefix);
      Object localObject6 = getString(a.i.lucky_money_group_tips_change_to_fixed);
      localObject2 = getString(a.i.lucky_money_f2f_fixed_tip_prefix);
      localObject3 = getString(a.i.lucky_money_group_tips_change_to_random);
      localObject4 = new n(this);
      final SpannableString localSpannableString = new SpannableString((String)localObject5 + (String)localObject6);
      localSpannableString.setSpan(localObject4, ((String)localObject5).length(), ((String)localObject5).length() + ((String)localObject6).length(), 33);
      localObject5 = new SpannableString((String)localObject2 + (String)localObject3);
      localObject6 = new n(this);
      ((SpannableString)localObject5).setSpan(localObject6, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject3).length(), 33);
      ((n)localObject4).VPb = new n.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64960);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.Kml);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(false);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_unit_amount_title));
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(i.formatMoney2f(d / i));
          }
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(g.Kma.Kmc);
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(this.KnF);
          AppMethodBeat.o(64960);
        }
      };
      ((n)localObject6).VPb = new n.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64961);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.Kmk);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(g.Kma.Kme);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_total_amount_title));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(i.formatMoney2f(d * i));
          }
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(localSpannableString);
          AppMethodBeat.o(64961);
        }
      };
      this.tHK.setMovementMethod(LinkMovementMethod.getInstance());
      this.tHK.setText(localSpannableString);
      this.tHK.setVisibility(0);
      this.Knt.setClickable(false);
      this.Knt.setEnabled(false);
      this.Knt.setOnClickListener(new ac()
      {
        public final void dsb()
        {
          AppMethodBeat.i(64957);
          if (WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this) == null)
          {
            Log.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).fWv() != 0)
          {
            aa.makeText(WxaLuckyMoneyPrepareUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
            AppMethodBeat.o(64957);
            return;
          }
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          String str2 = WxaLuckyMoneyPrepareUI.d(WxaLuckyMoneyPrepareUI.this).getInput();
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            if (Util.isNullOrNil(this.KnE)) {
              break label172;
            }
          }
          label172:
          for (str1 = this.KnE; WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.Kmk; str1 = WxaLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_default_wish))
          {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).e((int)i.Y(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.Kml) {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).f((int)i.Y(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
          }
          AppMethodBeat.o(64957);
        }
      });
      this.Knz.a(this.Knq);
      this.Knz.a(this.Knr);
      this.Knz.a(this.Kns);
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.Knz.A((TextView)localObject1);
      if (this.Knw != null) {
        this.Knw.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(64958);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
              WxaLuckyMoneyPrepareUI.this.hideVKB();
            }
            AppMethodBeat.o(64958);
            return false;
          }
        });
      }
      this.Knr.setType(this.KmI);
      addIconOptionMenu(0, a.e.lucky_money_help_btn, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64959);
          i.p(WxaLuckyMoneyPrepareUI.this.getContext(), WxaLuckyMoneyPrepareUI.Knp, false);
          AppMethodBeat.o(64959);
          return true;
        }
      });
      i = getIntent().getIntExtra("range", 0);
      Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.Knu.setVisibility(8);
      if (i != 0) {
        break label1043;
      }
      this.Kny = 0;
      AppMethodBeat.o(64968);
      return;
      this.Knr.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.Knr.setShowGroupIcon(false);
      break;
      label1029:
      this.Knr.setMaxAmount(((g)localObject2).Kmc);
    }
    label1043:
    if (i == 1)
    {
      this.Kny = 1;
      AppMethodBeat.o(64968);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(a.i.wxa_lucky_money_range_friend));
    ((ArrayList)localObject1).add(getString(a.i.wxa_lucky_money_range_public));
    this.Knu.setVisibility(0);
    this.Knv.setText((CharSequence)((ArrayList)localObject1).get(this.Kny));
    this.Knu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(64963);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new com.tencent.mm.ui.widget.picker.b(WxaLuckyMoneyPrepareUI.this.getContext(), this.zOa);
        paramAnonymousView.aFq(WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
        paramAnonymousView.agkc = new b.b()
        {
          public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
          {
            AppMethodBeat.i(64962);
            paramAnonymousView.hide();
            if (paramAnonymous2Boolean) {
              WxaLuckyMoneyPrepareUI.h(WxaLuckyMoneyPrepareUI.this).setText((CharSequence)paramAnonymous2Object1);
            }
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, paramAnonymousView.jIz());
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
    this.Kno = new d();
    this.Kno.d(this, getIntent());
    AppMethodBeat.o(64966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64970);
    super.onDestroy();
    this.Knz.clear();
    if (this.Kno != null) {
      this.Kno.onDestroy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */