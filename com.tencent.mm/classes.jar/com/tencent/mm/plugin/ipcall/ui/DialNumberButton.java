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
import com.tencent.mm.sdk.platformtools.Util;

public class DialNumberButton
  extends RelativeLayout
{
  private TextView ysN;
  private TextView ysO;
  private boolean ysP;
  
  public DialNumberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25568);
    this.ysP = false;
    LayoutInflater.from(getContext()).inflate(2131493840, this);
    this.ysN = ((TextView)findViewById(2131299619));
    this.ysO = ((TextView)findViewById(2131299620));
    if (d.oD(16))
    {
      this.ysN.setTypeface(Typeface.create("sans-serif-light", 0));
      this.ysO.setTypeface(Typeface.create("sans-serif-normal", 0));
    }
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(25568);
  }
  
  public String getNumberText()
  {
    AppMethodBeat.i(25570);
    String str = this.ysN.getText().toString();
    AppMethodBeat.o(25570);
    return str;
  }
  
  public String getOtherText()
  {
    AppMethodBeat.i(25571);
    String str = this.ysO.getText().toString();
    AppMethodBeat.o(25571);
    return str;
  }
  
  public final void il(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25572);
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.length() == 1)) {
      this.ysN.setText(paramString1);
    }
    if ((Util.isNullOrNil(paramString2)) && (!"1".equals(paramString1)))
    {
      this.ysO.setVisibility(8);
      AppMethodBeat.o(25572);
      return;
    }
    this.ysO.setText(paramString2);
    this.ysO.setVisibility(0);
    AppMethodBeat.o(25572);
  }
  
  public void setInTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25573);
    this.ysP = paramBoolean;
    if (this.ysP)
    {
      if (("#".equals(this.ysN.getText())) || ("*".equals(this.ysN.getText()))) {
        this.ysN.setTextColor(getContext().getResources().getColor(2131100266));
      }
      for (;;)
      {
        this.ysO.setTextColor(getContext().getResources().getColor(2131100266));
        setBackgroundDrawable(getResources().getDrawable(2131231996));
        AppMethodBeat.o(25573);
        return;
        this.ysN.setTextColor(getContext().getResources().getColor(2131100268));
      }
    }
    if (("#".equals(this.ysN.getText())) || ("*".equals(this.ysN.getText()))) {
      this.ysN.setTextColor(getContext().getResources().getColor(2131100266));
    }
    for (;;)
    {
      this.ysO.setTextColor(getContext().getResources().getColor(2131100266));
      setBackgroundDrawable(getResources().getDrawable(2131231997));
      AppMethodBeat.o(25573);
      return;
      this.ysN.setTextColor(getContext().getResources().getColor(2131100267));
    }
  }
  
  public final void setNumberTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(25569);
    this.ysN.setTextSize(0, paramFloat);
    AppMethodBeat.o(25569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialNumberButton
 * JD-Core Version:    0.7.0.1
 */