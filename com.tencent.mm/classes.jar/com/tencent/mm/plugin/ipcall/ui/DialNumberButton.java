package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bo;

public class DialNumberButton
  extends RelativeLayout
{
  private TextView nQm;
  private TextView nQn;
  private boolean nQo;
  
  public DialNumberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(21953);
    this.nQo = false;
    LayoutInflater.from(getContext()).inflate(2130969319, this);
    this.nQm = ((TextView)findViewById(2131823393));
    this.nQn = ((TextView)findViewById(2131823394));
    if (d.fv(16))
    {
      this.nQm.setTypeface(Typeface.create("sans-serif-light", 0));
      this.nQn.setTypeface(Typeface.create("sans-serif-normal", 0));
    }
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(21953);
  }
  
  public final void eS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(21957);
    if ((!bo.isNullOrNil(paramString1)) && (paramString1.length() == 1)) {
      this.nQm.setText(paramString1);
    }
    if ((bo.isNullOrNil(paramString2)) && (!"1".equals(paramString1)))
    {
      this.nQn.setVisibility(8);
      AppMethodBeat.o(21957);
      return;
    }
    this.nQn.setText(paramString2);
    this.nQn.setVisibility(0);
    AppMethodBeat.o(21957);
  }
  
  public String getNumberText()
  {
    AppMethodBeat.i(21955);
    String str = this.nQm.getText().toString();
    AppMethodBeat.o(21955);
    return str;
  }
  
  public String getOtherText()
  {
    AppMethodBeat.i(21956);
    String str = this.nQn.getText().toString();
    AppMethodBeat.o(21956);
    return str;
  }
  
  public void setInTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(21958);
    this.nQo = paramBoolean;
    if (this.nQo)
    {
      if (("#".equals(this.nQm.getText())) || ("*".equals(this.nQm.getText()))) {
        this.nQm.setTextColor(getContext().getResources().getColor(2131689945));
      }
      for (;;)
      {
        this.nQn.setTextColor(getContext().getResources().getColor(2131689945));
        setBackgroundDrawable(getResources().getDrawable(2130838528));
        AppMethodBeat.o(21958);
        return;
        this.nQm.setTextColor(getContext().getResources().getColor(2131689947));
      }
    }
    if (("#".equals(this.nQm.getText())) || ("*".equals(this.nQm.getText()))) {
      this.nQm.setTextColor(getContext().getResources().getColor(2131689945));
    }
    for (;;)
    {
      this.nQn.setTextColor(getContext().getResources().getColor(2131689945));
      setBackgroundDrawable(getResources().getDrawable(2130838529));
      AppMethodBeat.o(21958);
      return;
      this.nQm.setTextColor(getContext().getResources().getColor(2131689946));
    }
  }
  
  public final void setNumberTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(21954);
    this.nQm.setTextSize(0, paramFloat);
    AppMethodBeat.o(21954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialNumberButton
 * JD-Core Version:    0.7.0.1
 */