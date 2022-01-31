package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(19)
public class WxaLuckyMoneyPrepareUI
  extends WxaLuckyMoneyBaseUI
  implements c, f
{
  private TextView iKS = null;
  private TextView iKV;
  private h.a lLE = h.a.lLg;
  private a lMl = null;
  private LuckyMoneyNumInputView lMm = null;
  private WxaLuckyMoneyMoneyInputView lMn = null;
  private LuckyMoneyTextInputView lMo = null;
  private Button lMp = null;
  private LinearLayout lMq;
  protected View lMr;
  private TextView lMs;
  private MMScrollView lMt;
  private TextView lMu;
  private int lMv = 0;
  private com.tencent.mm.plugin.luckymoney.ui.a lMw = new com.tencent.mm.plugin.luckymoney.ui.a();
  protected MyKeyboardWindow mKeyboard;
  
  protected final void J(View paramView, int paramInt)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.lMr = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    EditText localEditText = (EditText)paramView.findViewById(a.f.lucky_money_et);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.lMr == null)) {
      return;
    }
    e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new WxaLuckyMoneyPrepareUI.6(this, paramInt, localEditText));
    localEditText.setOnClickListener(new WxaLuckyMoneyPrepareUI.7(this, paramInt, localEditText));
    TextView localTextView = (TextView)paramView.findViewById(a.f.lucky_money_amount_unit_title);
    if (localTextView != null) {
      localTextView.setOnClickListener(new WxaLuckyMoneyPrepareUI.8(this, localEditText, paramView, paramInt));
    }
    localView.setOnClickListener(new WxaLuckyMoneyPrepareUI.9(this));
  }
  
  protected final void VH()
  {
    if ((this.lMr != null) && (this.lMr.isShown())) {
      this.lMr.setVisibility(8);
    }
  }
  
  public final MMActivity bfn()
  {
    return this;
  }
  
  public final void bfo() {}
  
  public final void bfq()
  {
    int i;
    double d2;
    double d1;
    if ((this.lMn.bfp() != 3) && (this.lMm.bfp() != 3))
    {
      i = this.lMm.getInput();
      d2 = this.lMn.getInput();
      if (this.lLE == h.a.lLh)
      {
        d2 *= i;
        d1 = this.lMn.getInput();
      }
    }
    for (;;)
    {
      boolean bool1 = this.lMw.bgi();
      Object localObject = g.lKW;
      boolean bool2;
      if (bool1)
      {
        y.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
        this.lMp.setClickable(false);
        this.lMp.setEnabled(false);
        localObject = ((g)localObject).lLc;
        if (bk.bl((String)localObject))
        {
          this.iKS.setText(e.B(d2));
          return;
          if (i <= 0) {
            break label757;
          }
          d1 = this.lMn.getInput() / i;
        }
      }
      else if ((d2 == 0.0D) || (d1 == 0.0D))
      {
        bool2 = true;
      }
      for (;;)
      {
        if (bool2)
        {
          this.lMp.setClickable(false);
          this.lMp.setEnabled(false);
          break;
          if ((d2 > ((g)localObject).lLa) && (((g)localObject).lLa > 0.0D))
          {
            this.lMw.tR(getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(((g)localObject).lLa), bk.aM(((g)localObject).lLd, "") }));
            bool2 = true;
            continue;
          }
          if (d1 <= 0.0D) {
            break label751;
          }
          y.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount " + d1);
          if (this.lLE == h.a.lLh)
          {
            if ((d1 <= ((g)localObject).lKY) || (((g)localObject).lKY <= 0.0D)) {
              break label745;
            }
            this.lMw.tR(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(((g)localObject).lKY), bk.aM(((g)localObject).lLd, "") }));
            bool1 = true;
          }
        }
        for (;;)
        {
          label390:
          y.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
          bool2 = bool1;
          if (!bool1)
          {
            if (this.lLE != h.a.lLh) {
              break label626;
            }
            bool2 = bool1;
            if (d1 < ((g)localObject).lKZ)
            {
              this.lMw.tR(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { e.A(((g)localObject).lKZ), bk.aM(((g)localObject).lLd, "") }));
              bool2 = true;
            }
          }
          for (;;)
          {
            y.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
            break;
            if ((d1 <= ((g)localObject).lLb) || (((g)localObject).lLb <= 0.0D)) {
              break label745;
            }
            this.lMw.tR(getString(a.i.lucky_money_per_amount_max_limit_tips, new Object[] { Math.round(((g)localObject).lLb), bk.aM(((g)localObject).lLd, "") }));
            this.lMm.onError();
            this.lMn.onError();
            bool1 = true;
            break label390;
            label626:
            bool2 = bool1;
            if (d1 < 0.01D)
            {
              this.lMw.tR(getString(a.i.lucky_money_per_amount_min_limit_tips, new Object[] { "0.01", bk.aM(((g)localObject).lLd, "") }));
              this.lMm.onError();
              this.lMn.onError();
              bool2 = true;
            }
          }
          this.lMp.setClickable(true);
          this.lMp.setEnabled(true);
          break;
          this.iKS.setText((String)localObject + e.A(d2));
          return;
          label745:
          bool1 = false;
        }
        label751:
        bool2 = false;
      }
      label757:
      d1 = 0.0D;
      continue;
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public final void error(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.h.a(this, str, null, false, new WxaLuckyMoneyPrepareUI.1(this));
  }
  
  protected final int getLayoutId()
  {
    return a.g.wxa_lucky_money_prepare_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new WxaLuckyMoneyPrepareUI.10(this));
    this.lMo = ((LuckyMoneyTextInputView)findViewById(a.f.lucky_money_wish_et));
    this.lMo.setHintText(getString(a.i.lucky_money_default_wish));
    Object localObject1 = getIntent().getStringExtra("defaultWishingWord");
    y.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", new Object[] { localObject1 });
    if (!bk.bl((String)localObject1)) {
      this.lMo.setHintText((String)localObject1);
    }
    this.lMp = ((Button)findViewById(a.f.lucky_money_prepare_btn));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.lMr = findViewById(a.f.tenpay_keyboard_layout);
    this.iKV = ((TextView)findViewById(a.f.lucky_money_prepare_amount_tips));
    this.lMm = ((LuckyMoneyNumInputView)findViewById(a.f.lucky_money_num_et));
    this.lMn = ((WxaLuckyMoneyMoneyInputView)findViewById(a.f.lucky_money_amount_et));
    this.iKS = ((TextView)findViewById(a.f.lucky_money_prepare_total_amount));
    this.lMt = ((MMScrollView)findViewById(a.f.lucky_money_sv));
    this.lMu = ((TextView)findViewById(a.f.lucky_money_prepare_notice_tips));
    this.lMq = ((LinearLayout)findViewById(a.f.lucky_money_range_ll));
    this.lMs = ((TextView)findViewById(a.f.lucky_money_range_result));
    setMMTitle(a.i.lucky_money_to_send_title);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.lLE == h.a.lLg)
    {
      this.lMn.setTitle(getString(a.i.lucky_money_total_amount_title));
      this.lMn.setShowGroupIcon(true);
      this.lMn.setOnInputValidChangerListener(this);
      this.lMn.setHint(getString(a.i.lucky_money_money_hint));
      this.lMm.setOnInputValidChangerListener(this);
      this.lMm.setHint(getString(a.i.lucky_money_num_hint));
      this.lMm.setNum("");
      this.lMo.setOnInputValidChangerListener(this);
      localObject2 = (EditText)this.lMn.findViewById(a.f.lucky_money_et);
      localObject3 = (EditText)this.lMm.findViewById(a.f.lucky_money_et);
      e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)this.mController.uMN.getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).addTextChangedListener(new WxaLuckyMoneyPrepareUI.17(this));
      ((EditText)localObject2).setOnClickListener(new WxaLuckyMoneyPrepareUI.2(this, (EditText)localObject2, (EditText)localObject3));
      ((EditText)localObject2).requestFocus();
      localObject4 = (TextView)this.lMn.findViewById(a.f.lucky_money_amount_unit_title);
      if (localObject4 != null) {
        ((TextView)localObject4).setOnClickListener(new WxaLuckyMoneyPrepareUI.3(this, (EditText)localObject2, (EditText)localObject3));
      }
      e.setNoSystemInputOnEditText((EditText)localObject3);
      ((InputMethodManager)this.mController.uMN.getSystemService("input_method")).showSoftInput((View)localObject3, 0);
      ((EditText)localObject3).setOnClickListener(new WxaLuckyMoneyPrepareUI.4(this, (EditText)localObject2, (EditText)localObject3));
      ((MMEditText)this.lMo.findViewById(a.f.lucky_money_text)).setOnFocusChangeListener(new WxaLuckyMoneyPrepareUI.5(this, (EditText)localObject2, (EditText)localObject3));
      localObject2 = g.lKW;
      if (this.lLE != h.a.lLg) {
        break label1021;
      }
      this.lMn.setMaxAmount(((g)localObject2).lLa);
    }
    int i;
    for (;;)
    {
      this.lMn.setMinAmount(((g)localObject2).lKZ);
      this.lMm.setMaxNum(((g)localObject2).lKX);
      localObject2 = h.a.lLg;
      this.lMm.setMinNum(1);
      this.lMn.setMaxLen(12);
      Object localObject5 = getString(a.i.lucky_money_f2f_random_tip_prefix);
      Object localObject6 = getString(a.i.lucky_money_group_tips_change_to_fixed);
      localObject2 = getString(a.i.lucky_money_f2f_fixed_tip_prefix);
      localObject3 = getString(a.i.lucky_money_group_tips_change_to_random);
      localObject4 = new com.tencent.mm.plugin.wallet_core.ui.h(this);
      SpannableString localSpannableString = new SpannableString((String)localObject5 + (String)localObject6);
      localSpannableString.setSpan(localObject4, ((String)localObject5).length(), ((String)localObject5).length() + ((String)localObject6).length(), 33);
      localObject5 = new SpannableString((String)localObject2 + (String)localObject3);
      localObject6 = new com.tencent.mm.plugin.wallet_core.ui.h(this);
      ((SpannableString)localObject5).setSpan(localObject6, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject3).length(), 33);
      ((com.tencent.mm.plugin.wallet_core.ui.h)localObject4).qDo = new WxaLuckyMoneyPrepareUI.14(this, (SpannableString)localObject5);
      ((com.tencent.mm.plugin.wallet_core.ui.h)localObject6).qDo = new WxaLuckyMoneyPrepareUI.15(this, localSpannableString);
      this.iKV.setMovementMethod(LinkMovementMethod.getInstance());
      this.iKV.setText(localSpannableString);
      this.iKV.setVisibility(0);
      this.lMp.setClickable(false);
      this.lMp.setEnabled(false);
      this.lMp.setOnClickListener(new WxaLuckyMoneyPrepareUI.11(this, (String)localObject1));
      this.lMw.a(this.lMm);
      this.lMw.a(this.lMn);
      this.lMw.a(this.lMo);
      localObject1 = (TextView)findViewById(a.f.lucky_money_prepare_error_tips);
      this.lMw.g((TextView)localObject1);
      if (this.lMt != null) {
        this.lMt.setOnTouchListener(new WxaLuckyMoneyPrepareUI.12(this));
      }
      this.lMn.setType(this.lLE);
      addIconOptionMenu(0, a.e.lucky_money_help_btn, new WxaLuckyMoneyPrepareUI.13(this));
      i = getIntent().getIntExtra("range", 0);
      y.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", new Object[] { Integer.valueOf(i) });
      this.lMq.setVisibility(8);
      if (i != 0) {
        break label1035;
      }
      this.lMv = 0;
      return;
      this.lMn.setTitle(getString(a.i.lucky_money_unit_amount_title));
      this.lMn.setShowGroupIcon(false);
      break;
      label1021:
      this.lMn.setMaxAmount(((g)localObject2).lKY);
    }
    label1035:
    if (i == 1)
    {
      this.lMv = 1;
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(getString(a.i.wxa_lucky_money_range_friend));
    ((ArrayList)localObject1).add(getString(a.i.wxa_lucky_money_range_public));
    this.lMq.setVisibility(0);
    this.lMs.setText((CharSequence)((ArrayList)localObject1).get(this.lMv));
    this.lMq.setOnClickListener(new WxaLuckyMoneyPrepareUI.16(this, (ArrayList)localObject1));
  }
  
  public void onBackPressed()
  {
    setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    this.lMl = new d();
    this.lMl.a(this, getIntent());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.lMw.clear();
    if (this.lMl != null) {
      this.lMl.onDestroy();
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.lMr != null) && (this.lMr.isShown()))
    {
      this.lMr.setVisibility(8);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */