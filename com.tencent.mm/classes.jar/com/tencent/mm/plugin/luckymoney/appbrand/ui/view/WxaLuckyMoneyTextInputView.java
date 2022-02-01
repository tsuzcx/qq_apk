package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.d;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;

public class WxaLuckyMoneyTextInputView
  extends LinearLayout
  implements d
{
  private h KmE;
  private MMEditText Koc;
  private TextView sUt;
  
  public WxaLuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65025);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wxa_lucky_money_text_input_view, this, true);
    this.Koc = ((MMEditText)paramContext.findViewById(a.f.lucky_money_text));
    this.sUt = ((TextView)paramContext.findViewById(a.f.lucky_money_text_input_title));
    this.Koc.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65024);
        if (WxaLuckyMoneyTextInputView.a(WxaLuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = WxaLuckyMoneyTextInputView.a(WxaLuckyMoneyTextInputView.this);
          WxaLuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.fWx();
        }
        AppMethodBeat.o(65024);
      }
    });
    c.i(this.Koc).oF(0, 24).Nc(false).a(null);
    AppMethodBeat.o(65025);
  }
  
  public final String ZF(int paramInt)
  {
    return null;
  }
  
  public final void atR() {}
  
  public final int fWv()
  {
    return 0;
  }
  
  public final int fWw()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65026);
    String str = this.Koc.getText().toString();
    AppMethodBeat.o(65026);
    return str;
  }
  
  public int getInputViewId()
  {
    AppMethodBeat.i(65029);
    int i = getId();
    AppMethodBeat.o(65029);
    return i;
  }
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65027);
    this.Koc.setHint(paramString);
    AppMethodBeat.o(65027);
  }
  
  public void setOnInputValidChangerListener(h paramh)
  {
    this.KmE = paramh;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65028);
    this.sUt.setText(paramString);
    AppMethodBeat.o(65028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */