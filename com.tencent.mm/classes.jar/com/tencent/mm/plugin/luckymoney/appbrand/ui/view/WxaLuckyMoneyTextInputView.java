package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;

public class WxaLuckyMoneyTextInputView
  extends LinearLayout
  implements b
{
  private TextView haW;
  private f lLA;
  private MMEditText lMY;
  
  public WxaLuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wxa_lucky_money_text_input_view, this, true);
    this.lMY = ((MMEditText)paramContext.findViewById(a.f.lucky_money_text));
    this.haW = ((TextView)paramContext.findViewById(a.f.lucky_money_text_input_title));
    this.lMY.setOnFocusChangeListener(new WxaLuckyMoneyTextInputView.1(this));
    paramContext = c.d(this.lMY).fJ(0, 24);
    paramContext.wfM = false;
    paramContext.a(null);
  }
  
  public final int bfp()
  {
    return 0;
  }
  
  public String getInput()
  {
    return this.lMY.getText().toString();
  }
  
  public int getInputViewId()
  {
    return getId();
  }
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    this.lMY.setHint(paramString);
  }
  
  public void setOnInputValidChangerListener(f paramf)
  {
    this.lLA = paramf;
  }
  
  public void setTitle(String paramString)
  {
    this.haW.setText(paramString);
  }
  
  public final String td(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */