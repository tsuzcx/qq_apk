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
  private TextView DSR;
  private TextView DSS;
  private boolean DST;
  
  public DialNumberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25568);
    this.DST = false;
    LayoutInflater.from(getContext()).inflate(R.i.efS, this);
    this.DSR = ((TextView)findViewById(R.h.dEt));
    this.DSS = ((TextView)findViewById(R.h.dEu));
    if (d.qV(16))
    {
      this.DSR.setTypeface(Typeface.create("sans-serif-light", 0));
      this.DSS.setTypeface(Typeface.create("sans-serif-normal", 0));
    }
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(25568);
  }
  
  public final void bs(float paramFloat)
  {
    AppMethodBeat.i(25569);
    this.DSR.setTextSize(0, paramFloat);
    AppMethodBeat.o(25569);
  }
  
  public String getNumberText()
  {
    AppMethodBeat.i(25570);
    String str = this.DSR.getText().toString();
    AppMethodBeat.o(25570);
    return str;
  }
  
  public String getOtherText()
  {
    AppMethodBeat.i(25571);
    String str = this.DSS.getText().toString();
    AppMethodBeat.o(25571);
    return str;
  }
  
  public final void iy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(25572);
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.length() == 1)) {
      this.DSR.setText(paramString1);
    }
    if ((Util.isNullOrNil(paramString2)) && (!"1".equals(paramString1)))
    {
      this.DSS.setVisibility(8);
      AppMethodBeat.o(25572);
      return;
    }
    this.DSS.setText(paramString2);
    this.DSS.setVisibility(0);
    AppMethodBeat.o(25572);
  }
  
  public void setInTalkUIMode(boolean paramBoolean)
  {
    AppMethodBeat.i(25573);
    this.DST = paramBoolean;
    if (this.DST)
    {
      if (("#".equals(this.DSR.getText())) || ("*".equals(this.DSR.getText()))) {
        this.DSR.setTextColor(getContext().getResources().getColor(R.e.dkk));
      }
      for (;;)
      {
        this.DSS.setTextColor(getContext().getResources().getColor(R.e.dkk));
        setBackgroundDrawable(getResources().getDrawable(R.g.dnp));
        AppMethodBeat.o(25573);
        return;
        this.DSR.setTextColor(getContext().getResources().getColor(R.e.dkm));
      }
    }
    if (("#".equals(this.DSR.getText())) || ("*".equals(this.DSR.getText()))) {
      this.DSR.setTextColor(getContext().getResources().getColor(R.e.dkk));
    }
    for (;;)
    {
      this.DSS.setTextColor(getContext().getResources().getColor(R.e.dkk));
      setBackgroundDrawable(getResources().getDrawable(R.g.dnq));
      AppMethodBeat.o(25573);
      return;
      this.DSR.setTextColor(getContext().getResources().getColor(R.e.dkl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.DialNumberButton
 * JD-Core Version:    0.7.0.1
 */