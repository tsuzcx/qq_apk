package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Util;

public class DialNumberButton
  extends RelativeLayout
{
  private TextView JKb;
  private TextView JKc;
  private boolean JKd;
  
  public DialNumberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25568);
    this.JKd = false;
    LayoutInflater.from(getContext()).inflate(R.i.giR, this);
    this.JKb = ((TextView)findViewById(R.h.fFy));
    this.JKc = ((TextView)findViewById(R.h.fFz));
    if (d.rb(16))
    {
      this.JKb.setTypeface(Typeface.create("sans-serif-light", 0));
      this.JKc.setTypeface(Typeface.create("sans-serif-normal", 0));
    }
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(25568);
  }
  
  public final void cw(float paramFloat)
  {
    AppMethodBeat.i(25569);
    this.JKb.setTextSize(0, paramFloat);
    AppMethodBeat.o(25569);
  }
  
  public String getNumberText()
  {
    AppMethodBeat.i(25570);
    String str = this.JKb.getText().toString();
    AppMethodBeat.o(25570);
    return str;
  }
  
  public String getOtherText()
  {
    AppMethodBeat.i(25571);
    String str = this.JKc.getText().toString();
    AppMethodBeat.o(25571);
    return str;
  }
  
  public final void jI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25572);
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.length() == 1)) {
      this.JKb.setText(paramString1);
    }
    if ((Util.isNullOrNil(paramString2)) && (!"1".equals(paramString1)))
    {
      this.JKc.setVisibility(8);
      AppMethodBeat.o(25572);
      return;
    }
    this.JKc.setText(paramString2);
    this.JKc.setVisibility(0);
    AppMethodBeat.o(25572);
  }
  
  public void setInTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25573);
    this.JKd = paramBoolean;
    if (this.JKd)
    {
      if (("#".equals(this.JKb.getText())) || ("*".equals(this.JKb.getText()))) {
        this.JKb.setTextColor(getContext().getResources().getColor(R.e.fkm));
      }
      for (;;)
      {
        this.JKc.setTextColor(getContext().getResources().getColor(R.e.fkm));
        setBackgroundDrawable(getResources().getDrawable(R.g.fnB));
        AppMethodBeat.o(25573);
        return;
        this.JKb.setTextColor(getContext().getResources().getColor(R.e.fko));
      }
    }
    if (("#".equals(this.JKb.getText())) || ("*".equals(this.JKb.getText()))) {
      this.JKb.setTextColor(getContext().getResources().getColor(R.e.fkm));
    }
    for (;;)
    {
      this.JKc.setTextColor(getContext().getResources().getColor(R.e.fkm));
      setBackgroundDrawable(getResources().getDrawable(R.g.fnC));
      AppMethodBeat.o(25573);
      return;
      this.JKb.setTextColor(getContext().getResources().getColor(R.e.fkn));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialNumberButton
 * JD-Core Version:    0.7.0.1
 */