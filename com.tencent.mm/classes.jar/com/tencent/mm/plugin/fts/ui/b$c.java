package com.tencent.mm.plugin.fts.ui;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b$c
{
  public static final int HwO;
  public static final TextPaint HwP;
  public static final int HwQ;
  public static final TextPaint HwR;
  public static final int HwS;
  public static final TextPaint HwT;
  public static final int HwU;
  public static final TextPaint HwV;
  
  static
  {
    AppMethodBeat.i(111812);
    HwO = a.br(MMApplicationContext.getContext(), p.b.BigTextSize);
    HwP = new TextPaint();
    HwQ = a.br(MMApplicationContext.getContext(), p.b.NormalTextSize);
    HwR = new TextPaint();
    HwS = a.br(MMApplicationContext.getContext(), p.b.HintTextSize);
    HwT = new TextPaint();
    HwU = a.br(MMApplicationContext.getContext(), p.b.SmallerTextSize);
    HwV = new TextPaint();
    HwP.setTextSize(HwO);
    HwR.setTextSize(HwQ);
    HwT.setTextSize(HwS);
    HwV.setTextSize(HwU);
    AppMethodBeat.o(111812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.c
 * JD-Core Version:    0.7.0.1
 */