package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.app.Activity;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class WxaLuckyMoneyPrepareUI
  extends WxaLuckyMoneyBaseUI
  implements c, com.tencent.mm.plugin.luckymoney.ui.h
{
  private static final String EuI;
  private a EuH;
  private LuckyMoneyNumInputView EuJ;
  private WxaLuckyMoneyMoneyInputView EuK;
  private LuckyMoneyTextInputView EuL;
  private Button EuM;
  private LinearLayout EuN;
  private TextView EuO;
  private MMScrollView EuP;
  private TextView EuQ;
  private int EuR;
  private com.tencent.mm.plugin.luckymoney.ui.c EuS;
  private h.a Eub;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private TextView qCM;
  private TextView tZC;
  
  static
  {
    AppMethodBeat.i(277394);
    EuI = "https://" + WeChatHosts.domainString(a.i.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf7";
    AppMethodBeat.o(277394);
  }
  
  public WxaLuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(64965);
    this.EuH = null;
    this.Eub = h.a.EtD;
    this.EuJ = null;
    this.EuK = null;
    this.EuL = null;
    this.tZC = null;
    this.EuM = null;
    this.EuR = 0;
    this.EuS = new com.tencent.mm.plugin.luckymoney.ui.c();
    AppMethodBeat.o(64965);
  }
  
  protected final void ao(final View paramView, final int paramInt)
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
    com.tencent.mm.wallet_core.ui.g.setNoSystemInputOnEditText(localEditText);
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
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64955);
      }
    });
    AppMethodBeat.o(64971);
  }
  
  public final MMActivity eOa()
  {
    return this;
  }
  
  public final void eOb() {}
  
  public final void eOd()
  {
    AppMethodBeat.i(64974);
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = d3;
    double d1 = d4;
    int i;
    if (this.EuK.eOc() != 3)
    {
      d2 = d3;
      d1 = d4;
      if (this.EuJ.eOc() != 3)
      {
        i = this.EuJ.getInput();
        d4 = this.EuK.getInput();
        if (this.Eub != h.a.EtE) {
          break label164;
        }
        d1 = d4 * i;
        d2 = this.EuK.getInput();
      }
    }
    boolean bool1 = this.EuS.ePM();
    Object localObject = com.tencent.mm.plugin.luckymoney.appbrand.a.g.Ett;
    if (bool1)
    {
      Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
      this.EuM.setClickable(false);
      this.EuM.setEnabled(false);
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etz;
      if (!Util.isNullOrNil((String)localObject)) {
        break label778;
      }
      this.tZC.setText(com.tencent.mm.wallet_core.ui.g.F(d1));
      AppMethodBeat.o(64974);
      return;
      label164:
      d2 = d3;
      d1 = d4;
      if (i <= 0) {
        break;
      }
      d2 = this.EuK.getInput() / i;
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
          this.EuM.setClickable(false);
          this.EuM.setEnabled(false);
          break;
          if ((d1 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etx) && (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etx > 0.0D))
          {
            this.EuS.amo(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etx), Util.nullAs(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).EtA, "") }));
            bool1 = true;
          }
          else if (d2 > 0.0D)
          {
            Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
            if (this.Eub == h.a.EtE)
            {
              bool1 = bool2;
              if (d2 > ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etv)
              {
                bool1 = bool2;
                if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etv > 0.0D)
                {
                  this.EuS.amo(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etv), Util.nullAs(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).EtA, "") }));
                  bool1 = true;
                }
              }
              label439:
              Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
              bool2 = bool1;
              if (!bool1)
              {
                if (this.Eub != h.a.EtE) {
                  break label689;
                }
                bool2 = bool1;
                if (d2 < ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etw)
                {
                  this.EuS.amo(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { com.tencent.mm.wallet_core.ui.g.formatMoney2f(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Etw), Util.nullAs(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).EtA, "") }));
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
              if (d2 <= ((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Ety) {
                break label439;
              }
              bool1 = bool2;
              if (((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Ety <= 0.0D) {
                break label439;
              }
              this.EuS.amo(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).Ety), Util.nullAs(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).EtA, "") }));
              bool1 = true;
              this.EuJ.onError();
              this.EuK.onError();
              break label439;
              label689:
              bool2 = bool1;
              if (d2 < 0.01D)
              {
                this.EuS.amo(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", Util.nullAs(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject).EtA, "") }));
                bool2 = true;
                this.EuJ.onError();
                this.EuK.onError();
              }
            }
          }
        }
      }
      this.EuM.setClickable(true);
      this.EuM.setEnabled(true);
    }
    label778:
    this.tZC.setText((String)localObject + com.tencent.mm.wallet_core.ui.g.formatMoney2f(d1));
    AppMethodBeat.o(64974);
  }
  
  public final void error(String paramString)
  {
    AppMethodBeat.i(64967);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.h.a(this, str, null, false, new WxaLuckyMoneyPrepareUI.1(this));
    AppMethodBeat.o(64967);
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
    this.EuL = ((LuckyMoneyTextInputView)findViewById(a.f.lucky_money_wish_et));
    this.EuL.setHintText(getString(a.i.lucky_money_default_wish));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!Util.isNullOrNil((String)localObject1)) {
      this.EuL.setHintText((String)localObject1);
    }
    this.EuM = ((Button)findViewById(a.f.lucky_money_prepare_btn));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    this.qCM = ((TextView)findViewById(a.f.lucky_money_prepare_amount_tips));
    this.EuJ = ((LuckyMoneyNumInputView)findViewById(a.f.lucky_money_num_et));
    this.EuK = ((WxaLuckyMoneyMoneyInputView)findViewById(a.f.lucky_money_amount_et));
    this.tZC = ((TextView)findViewById(a.f.lucky_money_prepare_total_amount));
    this.EuP = ((MMScrollView)findViewById(a.f.lucky_money_sv));
    this.EuQ = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    this.EuN = ((LinearLayout)findViewById(a.f.lucky_money_range_ll));
    this.EuO = ((TextView)findViewById(a.f.lucky_money_range_result));
    setMMTitle(a.i.lucky_money_to_send_title);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.Eub == h.a.EtD)
    {
      this.EuK.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.EuK.setShowGroupIcon(true);
      this.EuK.setOnInputValidChangerListener(this);
      this.EuK.setHint(getString(a.i.lucky_money_money_hint));
      this.EuJ.setOnInputValidChangerListener(this);
      this.EuJ.setHint(getString(a.i.lucky_money_num_hint));
      this.EuJ.setNum("");
      this.EuL.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.EuK.findViewById(a.f.lucky_money_et);
      localObject3 = (EditText)this.EuJ.findViewById(a.f.lucky_money_et);
      com.tencent.mm.wallet_core.ui.g.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64945);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.val$hintTv.setOnClickListener(null);
          this.EuU.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ao(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ao(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64945);
        }
      });
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.EuK.findViewById(a.f.lucky_money_amount_unit_title);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(64946);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            this.val$hintTv.setOnClickListener(null);
            this.EuU.setOnClickListener(null);
            WxaLuckyMoneyPrepareUI.this.ao(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
            WxaLuckyMoneyPrepareUI.this.ao(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(64946);
          }
        });
      }
      com.tencent.mm.wallet_core.ui.g.setNoSystemInputOnEditText((EditText)localObject3);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject3, 0);
      ((EditText)localObject3).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64947);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.val$hintTv.setOnClickListener(null);
          this.EuU.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ao(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ao(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(64947);
        }
      });
      ((MMEditText)this.EuL.findViewById(a.f.lucky_money_text)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(64948);
          this.val$hintTv.setOnClickListener(null);
          this.EuU.setOnClickListener(null);
          WxaLuckyMoneyPrepareUI.this.ao(WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this), 2);
          WxaLuckyMoneyPrepareUI.this.ao(WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(64948);
        }
      });
      localObject2 = com.tencent.mm.plugin.luckymoney.appbrand.a.g.Ett;
      if (this.Eub != h.a.EtD) {
        break label1029;
      }
      this.EuK.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).Etx);
    }
    int i;
    for (;;)
    {
      this.EuK.setMinAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).Etw);
      this.EuJ.setMaxNum(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).Etu);
      localObject2 = h.a.EtD;
      this.EuJ.setMinNum(1);
      this.EuK.setMaxLen(12);
      Object localObject5 = getString(a.i.lucky_money_f2f_random_tip_prefix);
      Object localObject6 = getString(a.i.lucky_money_group_tips_change_to_fixed);
      localObject2 = getString(a.i.lucky_money_f2f_fixed_tip_prefix);
      localObject3 = getString(a.i.lucky_money_group_tips_change_to_random);
      localObject4 = new m(this);
      final SpannableString localSpannableString = new SpannableString((String)localObject5 + (String)localObject6);
      localSpannableString.setSpan(localObject4, ((String)localObject5).length(), ((String)localObject5).length() + ((String)localObject6).length(), 33);
      localObject5 = new SpannableString((String)localObject2 + (String)localObject3);
      localObject6 = new m(this);
      ((SpannableString)localObject5).setSpan(localObject6, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject3).length(), 33);
      ((m)localObject4).OYN = new m.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64960);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.EtE);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(false);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_unit_amount_title));
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.g.formatMoney2f(d / i));
          }
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.Ett.Etv);
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(this.EuY);
          AppMethodBeat.o(64960);
        }
      };
      ((m)localObject6).OYN = new m.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(64961);
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this, h.a.EtD);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setType(WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.Ett.Etx);
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setTitle(WxaLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_total_amount_title));
          WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setShowGroupIcon(true);
          if ((d > 0.0D) && (i > 0)) {
            WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.g.formatMoney2f(d * i));
          }
          WxaLuckyMoneyPrepareUI.g(WxaLuckyMoneyPrepareUI.this).setText(localSpannableString);
          AppMethodBeat.o(64961);
        }
      };
      this.qCM.setMovementMethod(LinkMovementMethod.getInstance());
      this.qCM.setText(localSpannableString);
      this.qCM.setVisibility(0);
      this.EuM.setClickable(false);
      this.EuM.setEnabled(false);
      this.EuM.setOnClickListener(new aa()
      {
        public final void cOw()
        {
          AppMethodBeat.i(64957);
          if (WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this) == null)
          {
            Log.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).eOc() != 0)
          {
            w.makeText(WxaLuckyMoneyPrepareUI.this.getContext(), a.i.wallet_balance_save_input_invalid, 0).show();
            AppMethodBeat.o(64957);
            return;
          }
          int i = WxaLuckyMoneyPrepareUI.c(WxaLuckyMoneyPrepareUI.this).getInput();
          double d = WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this).getInput();
          String str2 = WxaLuckyMoneyPrepareUI.d(WxaLuckyMoneyPrepareUI.this).getInput();
          String str1 = str2;
          if (Util.isNullOrNil(str2)) {
            if (Util.isNullOrNil(this.EuX)) {
              break label172;
            }
          }
          label172:
          for (str1 = this.EuX; WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.EtD; str1 = WxaLuckyMoneyPrepareUI.this.getString(a.i.lucky_money_default_wish))
          {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).e((int)com.tencent.mm.wallet_core.ui.g.G(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
            AppMethodBeat.o(64957);
            return;
          }
          if (WxaLuckyMoneyPrepareUI.e(WxaLuckyMoneyPrepareUI.this) == h.a.EtE) {
            WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.this).f((int)com.tencent.mm.wallet_core.ui.g.G(d), i, str1, WxaLuckyMoneyPrepareUI.f(WxaLuckyMoneyPrepareUI.this));
          }
          AppMethodBeat.o(64957);
        }
      });
      this.EuS.a(this.EuJ);
      this.EuS.a(this.EuK);
      this.EuS.a(this.EuL);
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.EuS.z((TextView)localObject1);
      if (this.EuP != null) {
        this.EuP.setOnTouchListener(new View.OnTouchListener()
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
      this.EuK.setType(this.Eub);
      addIconOptionMenu(0, a.e.lucky_money_help_btn, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(64959);
          com.tencent.mm.wallet_core.ui.g.p(WxaLuckyMoneyPrepareUI.this.getContext(), WxaLuckyMoneyPrepareUI.bzf(), false);
          AppMethodBeat.o(64959);
          return true;
        }
      });
      i = getIntent().getIntExtra("range", 0);
      Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.EuN.setVisibility(8);
      if (i != 0) {
        break label1043;
      }
      this.EuR = 0;
      AppMethodBeat.o(64968);
      return;
      this.EuK.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.EuK.setShowGroupIcon(false);
      break;
      label1029:
      this.EuK.setMaxAmount(((com.tencent.mm.plugin.luckymoney.appbrand.a.g)localObject2).Etv);
    }
    label1043:
    if (i == 1)
    {
      this.EuR = 1;
      AppMethodBeat.o(64968);
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(a.i.wxa_lucky_money_range_friend));
    ((ArrayList)localObject1).add(getString(a.i.wxa_lucky_money_range_public));
    this.EuN.setVisibility(0);
    this.EuO.setText((CharSequence)((ArrayList)localObject1).get(this.EuR));
    this.EuN.setOnClickListener(new WxaLuckyMoneyPrepareUI.16(this, (ArrayList)localObject1));
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
    this.EuH = new d();
    this.EuH.d(this, getIntent());
    AppMethodBeat.o(64966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64970);
    super.onDestroy();
    this.EuS.clear();
    if (this.EuH != null) {
      this.EuH.onDestroy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */