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
import com.tencent.mm.sdk.platformtools.bt;

public class DialNumberButton
  extends RelativeLayout
{
  private TextView uOB;
  private TextView uOC;
  private boolean uOD;
  
  public DialNumberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25568);
    this.uOD = false;
    LayoutInflater.from(getContext()).inflate(2131493708, this);
    this.uOB = ((TextView)findViewById(2131299096));
    this.uOC = ((TextView)findViewById(2131299097));
    if (d.ly(16))
    {
      this.uOB.setTypeface(Typeface.create("sans-serif-light", 0));
      this.uOC.setTypeface(Typeface.create("sans-serif-normal", 0));
    }
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(25568);
  }
  
  public String getNumberText()
  {
    AppMethodBeat.i(25570);
    String str = this.uOB.getText().toString();
    AppMethodBeat.o(25570);
    return str;
  }
  
  public String getOtherText()
  {
    AppMethodBeat.i(25571);
    String str = this.uOC.getText().toString();
    AppMethodBeat.o(25571);
    return str;
  }
  
  public final void hw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25572);
    if ((!bt.isNullOrNil(paramString1)) && (paramString1.length() == 1)) {
      this.uOB.setText(paramString1);
    }
    if ((bt.isNullOrNil(paramString2)) && (!"1".equals(paramString1)))
    {
      this.uOC.setVisibility(8);
      AppMethodBeat.o(25572);
      return;
    }
    this.uOC.setText(paramString2);
    this.uOC.setVisibility(0);
    AppMethodBeat.o(25572);
  }
  
  public void setInTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25573);
    this.uOD = paramBoolean;
    if (this.uOD)
    {
      if (("#".equals(this.uOB.getText())) || ("*".equals(this.uOB.getText()))) {
        this.uOB.setTextColor(getContext().getResources().getColor(2131100232));
      }
      for (;;)
      {
        this.uOC.setTextColor(getContext().getResources().getColor(2131100232));
        setBackgroundDrawable(getResources().getDrawable(2131231912));
        AppMethodBeat.o(25573);
        return;
        this.uOB.setTextColor(getContext().getResources().getColor(2131100234));
      }
    }
    if (("#".equals(this.uOB.getText())) || ("*".equals(this.uOB.getText()))) {
      this.uOB.setTextColor(getContext().getResources().getColor(2131100232));
    }
    for (;;)
    {
      this.uOC.setTextColor(getContext().getResources().getColor(2131100232));
      setBackgroundDrawable(getResources().getDrawable(2131231913));
      AppMethodBeat.o(25573);
      return;
      this.uOB.setTextColor(getContext().getResources().getColor(2131100233));
    }
  }
  
  public final void setNumberTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(25569);
    this.uOB.setTextSize(0, paramFloat);
    AppMethodBeat.o(25569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialNumberButton
 * JD-Core Version:    0.7.0.1
 */