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
  private TextView sEh;
  private TextView sEi;
  private boolean sEj;
  
  public DialNumberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25568);
    this.sEj = false;
    LayoutInflater.from(getContext()).inflate(2131493708, this);
    this.sEh = ((TextView)findViewById(2131299096));
    this.sEi = ((TextView)findViewById(2131299097));
    if (d.lf(16))
    {
      this.sEh.setTypeface(Typeface.create("sans-serif-light", 0));
      this.sEi.setTypeface(Typeface.create("sans-serif-normal", 0));
    }
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(25568);
  }
  
  public final void gT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25572);
    if ((!bt.isNullOrNil(paramString1)) && (paramString1.length() == 1)) {
      this.sEh.setText(paramString1);
    }
    if ((bt.isNullOrNil(paramString2)) && (!"1".equals(paramString1)))
    {
      this.sEi.setVisibility(8);
      AppMethodBeat.o(25572);
      return;
    }
    this.sEi.setText(paramString2);
    this.sEi.setVisibility(0);
    AppMethodBeat.o(25572);
  }
  
  public String getNumberText()
  {
    AppMethodBeat.i(25570);
    String str = this.sEh.getText().toString();
    AppMethodBeat.o(25570);
    return str;
  }
  
  public String getOtherText()
  {
    AppMethodBeat.i(25571);
    String str = this.sEi.getText().toString();
    AppMethodBeat.o(25571);
    return str;
  }
  
  public void setInTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25573);
    this.sEj = paramBoolean;
    if (this.sEj)
    {
      if (("#".equals(this.sEh.getText())) || ("*".equals(this.sEh.getText()))) {
        this.sEh.setTextColor(getContext().getResources().getColor(2131100232));
      }
      for (;;)
      {
        this.sEi.setTextColor(getContext().getResources().getColor(2131100232));
        setBackgroundDrawable(getResources().getDrawable(2131231912));
        AppMethodBeat.o(25573);
        return;
        this.sEh.setTextColor(getContext().getResources().getColor(2131100234));
      }
    }
    if (("#".equals(this.sEh.getText())) || ("*".equals(this.sEh.getText()))) {
      this.sEh.setTextColor(getContext().getResources().getColor(2131100232));
    }
    for (;;)
    {
      this.sEi.setTextColor(getContext().getResources().getColor(2131100232));
      setBackgroundDrawable(getResources().getDrawable(2131231913));
      AppMethodBeat.o(25573);
      return;
      this.sEh.setTextColor(getContext().getResources().getColor(2131100233));
    }
  }
  
  public final void setNumberTextSize$255e752(float paramFloat)
  {
    AppMethodBeat.i(25569);
    this.sEh.setTextSize(0, paramFloat);
    AppMethodBeat.o(25569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialNumberButton
 * JD-Core Version:    0.7.0.1
 */