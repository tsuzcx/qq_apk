package com.tencent.mm.plugin.fts.ui;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ai;

public final class b$c
{
  public static final int sBC;
  public static final TextPaint sBD;
  public static final int sBE;
  public static final TextPaint sBF;
  public static final int sBG;
  public static final TextPaint sBH;
  public static final int sBI;
  public static final TextPaint sBJ;
  
  static
  {
    AppMethodBeat.i(111812);
    sBC = a.au(ai.getContext(), 2131165192);
    sBD = new TextPaint();
    sBE = a.au(ai.getContext(), 2131165517);
    sBF = new TextPaint();
    sBG = a.au(ai.getContext(), 2131165466);
    sBH = new TextPaint();
    sBI = a.au(ai.getContext(), 2131165574);
    sBJ = new TextPaint();
    sBD.setTextSize(sBC);
    sBF.setTextSize(sBE);
    sBH.setTextSize(sBG);
    sBJ.setTextSize(sBI);
    AppMethodBeat.o(111812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.c
 * JD-Core Version:    0.7.0.1
 */