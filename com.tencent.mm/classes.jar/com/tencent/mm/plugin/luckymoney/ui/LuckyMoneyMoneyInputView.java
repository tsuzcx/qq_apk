package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView
  extends LinearLayout
  implements b
{
  private TextWatcher ajS = new LuckyMoneyMoneyInputView.1(this);
  private TextView haW;
  private f lLA;
  private d lLB;
  private double lLC;
  private double lLD;
  private TenpaySecureEditText lLx;
  private TextView lLy;
  private TextView lVJ;
  public int mType;
  
  public LuckyMoneyMoneyInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a.bfg();
    this.lLB = a.bfh().bfG();
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_money_input_view, this, true);
    this.lLx = ((TenpaySecureEditText)paramContext.findViewById(a.f.lucky_money_et));
    this.lLx.addTextChangedListener(this.ajS);
    this.haW = ((TextView)paramContext.findViewById(a.f.lucky_money_money_input_title));
    this.lVJ = ((TextView)paramContext.findViewById(a.f.lucky_money_money_input_group_icon));
    this.lLy = ((TextView)paramContext.findViewById(a.f.lucky_money_amount_unit_title));
  }
  
  private boolean bgk()
  {
    return (this.lLB != null) && (!bk.bl(this.lLB.lPQ));
  }
  
  public final int bfp()
  {
    if (bk.bl(this.lLx.getText().toString())) {}
    double d;
    do
    {
      return 0;
      d = bk.getDouble(this.lLx.getText().toString(), -1.0D);
      if (d < 0.0D) {
        return 3;
      }
      if ((d > this.lLC) && (this.lLC > 0.0D)) {
        return 1;
      }
    } while ((d >= this.lLD) || (d <= 0.0D));
    return 2;
  }
  
  public double getInput()
  {
    return bk.getDouble(this.lLx.getText().toString(), 0.0D);
  }
  
  public int getInputViewId()
  {
    return getId();
  }
  
  public final void onError()
  {
    this.haW.setTextColor(o.dI(getContext()));
    this.lLx.setTextColor(o.dI(getContext()));
    this.lLy.setTextColor(o.dI(getContext()));
  }
  
  public final void restore()
  {
    this.haW.setTextColor(-16777216);
    this.lLx.setTextColor(-16777216);
    this.lLy.setTextColor(-16777216);
  }
  
  public void setAmount(String paramString)
  {
    this.lLx.setText(paramString);
  }
  
  public void setHint(String paramString)
  {
    this.lLx.setHint(paramString);
  }
  
  public void setMaxAmount(double paramDouble)
  {
    this.lLC = paramDouble;
  }
  
  public void setMaxLen(int paramInt)
  {
    this.lLx.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public void setMinAmount(double paramDouble)
  {
    this.lLD = paramDouble;
  }
  
  public void setOnInputValidChangerListener(f paramf)
  {
    this.lLA = paramf;
  }
  
  public void setShowGroupIcon(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.lVJ.setVisibility(0);
      return;
    }
    this.lVJ.setVisibility(8);
  }
  
  public void setTitle(String paramString)
  {
    this.haW.setText(paramString);
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public final String td(int paramInt)
  {
    a.bfg();
    this.lLB = a.bfh().bfG();
    if (paramInt == 1)
    {
      if (this.mType == 1) {
        return getContext().getString(a.i.lucky_money_total_amount_max_limit_tips, new Object[] { Math.round(this.lLC), bk.aM(this.lLB.lLd, "") });
      }
      if (bgk()) {
        return getContext().getString(a.i.lucky_money_amount_max_limit_tips_format, new Object[] { this.lLB.lPQ, Math.round(this.lLC), bk.aM(this.lLB.lLd, "") });
      }
      return getContext().getString(a.i.lucky_money_amount_max_limit_tips, new Object[] { Math.round(this.lLC), bk.aM(this.lLB.lLd, "") });
    }
    if (paramInt == 2)
    {
      if (bgk()) {
        return getContext().getString(a.i.lucky_money_amount_min_limit_tips_format, new Object[] { this.lLB.lPQ, com.tencent.mm.wallet_core.ui.e.A(this.lLD), bk.aM(this.lLB.lLd, "") });
      }
      return getContext().getString(a.i.lucky_money_amount_min_limit_tips, new Object[] { com.tencent.mm.wallet_core.ui.e.A(this.lLD), bk.aM(this.lLB.lLd, "") });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView
 * JD-Core Version:    0.7.0.1
 */