package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.g;
import com.tencent.mm.ui.widget.MMEditText;

public class WxaLuckyMoneyTextInputView
  extends LinearLayout
  implements com.tencent.mm.plugin.luckymoney.ui.c
{
  private TextView lfN;
  private g ugV;
  private MMEditText uiu;
  
  public WxaLuckyMoneyTextInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65025);
    paramContext = LayoutInflater.from(paramContext).inflate(2131496121, this, true);
    this.uiu = ((MMEditText)paramContext.findViewById(2131301944));
    this.lfN = ((TextView)paramContext.findViewById(2131301945));
    this.uiu.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65024);
        if (WxaLuckyMoneyTextInputView.a(WxaLuckyMoneyTextInputView.this) != null)
        {
          paramAnonymousView = WxaLuckyMoneyTextInputView.a(WxaLuckyMoneyTextInputView.this);
          WxaLuckyMoneyTextInputView.this.getInputViewId();
          paramAnonymousView.cYF();
        }
        AppMethodBeat.o(65024);
      }
    });
    paramContext = com.tencent.mm.ui.tools.b.c.d(this.uiu).jQ(0, 24);
    paramContext.IVj = false;
    paramContext.a(null);
    AppMethodBeat.o(65025);
  }
  
  public final String HD(int paramInt)
  {
    return null;
  }
  
  public final int cYE()
  {
    return 0;
  }
  
  public String getInput()
  {
    AppMethodBeat.i(65026);
    String str = this.uiu.getText().toString();
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
  
  public final void onError() {}
  
  public final void restore() {}
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(65027);
    this.uiu.setHint(paramString);
    AppMethodBeat.o(65027);
  }
  
  public void setOnInputValidChangerListener(g paramg)
  {
    this.ugV = paramg;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(65028);
    this.lfN.setText(paramString);
    AppMethodBeat.o(65028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView
 * JD-Core Version:    0.7.0.1
 */