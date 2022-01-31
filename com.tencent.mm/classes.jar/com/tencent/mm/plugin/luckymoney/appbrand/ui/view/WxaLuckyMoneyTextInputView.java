package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.g;
import com.tencent.mm.ui.widget.MMEditText;

public class WxaLuckyMoneyTextInputView
  extends LinearLayout
  implements com.tencent.mm.plugin.luckymoney.ui.c
{
  private TextView iJG;
  private g oiU;
  private MMEditText okr;
  
  public WxaLuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42136);
    paramContext = LayoutInflater.from(paramContext).inflate(2130971338, this, true);
    this.okr = ((MMEditText)paramContext.findViewById(2131825833));
    this.iJG = ((TextView)paramContext.findViewById(2131825832));
    this.okr.setOnFocusChangeListener(new WxaLuckyMoneyTextInputView.1(this));
    paramContext = com.tencent.mm.ui.tools.b.c.d(this.okr).hR(0, 24);
    paramContext.AyD = false;
    paramContext.a(null);
    AppMethodBeat.o(42136);
  }
  
  public final int bMP()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(42137);
    String str = this.okr.getText().toString();
    AppMethodBeat.o(42137);
    return str;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(42140);
    int i = getId();
    AppMethodBeat.o(42140);
    return i;
  }
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(42138);
    this.okr.setHint(paramString);
    AppMethodBeat.o(42138);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.oiU = paramg;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(42139);
    this.iJG.setText(paramString);
    AppMethodBeat.o(42139);
  }
  
  public final String yf(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */