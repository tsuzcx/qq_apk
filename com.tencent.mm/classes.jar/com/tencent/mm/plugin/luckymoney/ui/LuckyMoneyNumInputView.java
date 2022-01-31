package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
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
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView
  extends LinearLayout
  implements b
{
  private TextWatcher ajS = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this) != null)
      {
        paramAnonymousEditable = LuckyMoneyNumInputView.a(LuckyMoneyNumInputView.this);
        LuckyMoneyNumInputView.this.getInputViewId();
        paramAnonymousEditable.bfq();
      }
    }
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private TextView haW;
  private f lLA;
  private d lLB;
  private TenpaySecureEditText lWL;
  private TextView lWM;
  private int lWN = 2147483647;
  private int lWO = 1;
  private int mNum = 1;
  
  public LuckyMoneyNumInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.lucky_money_num_input_view, this, true);
    this.haW = ((TextView)paramContext.findViewById(a.f.lucky_money_num_input_title));
    this.lWL = ((TenpaySecureEditText)paramContext.findViewById(a.f.lucky_money_et));
    this.lWM = ((TextView)paramContext.findViewById(a.f.lucky_money_num_unit));
    this.lWL.setText(this.mNum);
    this.lWL.addTextChangedListener(this.ajS);
  }
  
  private boolean bgk()
  {
    return (this.lLB != null) && (!bk.bl(this.lLB.lPQ));
  }
  
  public final int bfp()
  {
    if (bk.bl(this.lWL.getText().toString())) {}
    int i;
    do
    {
      return 0;
      i = bk.getInt(this.lWL.getText().toString(), -1);
      if (i < 0) {
        return 3;
      }
      if ((i > this.lWN) && (this.lWN > 0)) {
        return 1;
      }
    } while ((i >= this.lWO) || (this.lWO <= 0));
    return 2;
  }
  
  public int getInput()
  {
    try
    {
      int i = Integer.parseInt(this.lWL.getText().toString(), 10);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int getInputViewId()
  {
    return getId();
  }
  
  public final void onError()
  {
    this.haW.setTextColor(o.dI(getContext()));
    this.lWL.setTextColor(o.dI(getContext()));
    this.lWM.setTextColor(o.dI(getContext()));
  }
  
  public final void restore()
  {
    this.haW.setTextColor(-16777216);
    this.lWL.setTextColor(-16777216);
    this.lWM.setTextColor(-16777216);
  }
  
  public void setHint(String paramString)
  {
    this.lWL.setHint(paramString);
  }
  
  public void setMaxNum(int paramInt)
  {
    int j = 3;
    this.lWN = paramInt;
    int k = 0;
    int i = paramInt;
    paramInt = k;
    while (i > 0)
    {
      paramInt += 1;
      i /= 10;
    }
    if (paramInt <= 3) {
      paramInt = j;
    }
    for (;;)
    {
      this.lWL.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      return;
    }
  }
  
  public void setMinNum(int paramInt)
  {
    this.lWO = paramInt;
  }
  
  public void setNum(String paramString)
  {
    this.lWL.setText(paramString);
    this.lWL.setSelection(this.lWL.getText().length());
    this.mNum = bk.getInt(paramString, 0);
  }
  
  public void setOnInputValidChangerListener(f paramf)
  {
    this.lLA = paramf;
  }
  
  public final String td(int paramInt)
  {
    a.bfg();
    this.lLB = a.bfh().bfG();
    if (paramInt == 1)
    {
      if (bgk()) {
        return getContext().getString(a.i.lucky_money_num_max_limit_tips_format, new Object[] { Integer.valueOf(this.lWN), this.lLB.lPQ });
      }
      return getContext().getString(a.i.lucky_money_num_max_limit_tips, new Object[] { Integer.valueOf(this.lWN) });
    }
    if (paramInt == 2)
    {
      if (bgk()) {
        return getContext().getString(a.i.lucky_money_num_luck_min_limit_tips_format, new Object[] { Integer.valueOf(this.lWO), this.lLB.lPQ });
      }
      return getContext().getString(a.i.lucky_money_num_luck_min_limit_tips, new Object[] { Integer.valueOf(this.lWO) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView
 * JD-Core Version:    0.7.0.1
 */