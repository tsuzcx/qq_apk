package com.tencent.mm.plugin.fts.ui;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;

public final class b$c
{
  public static final int tIU;
  public static final TextPaint tIV;
  public static final int tIW;
  public static final TextPaint tIX;
  public static final int tIY;
  public static final TextPaint tIZ;
  public static final int tJa;
  public static final TextPaint tJb;
  
  static
  {
    AppMethodBeat.i(111812);
    tIU = a.ax(ak.getContext(), 2131165192);
    tIV = new TextPaint();
    tIW = a.ax(ak.getContext(), 2131165517);
    tIX = new TextPaint();
    tIY = a.ax(ak.getContext(), 2131165466);
    tIZ = new TextPaint();
    tJa = a.ax(ak.getContext(), 2131165574);
    tJb = new TextPaint();
    tIV.setTextSize(tIU);
    tIX.setTextSize(tIW);
    tIZ.setTextSize(tIY);
    tJb.setTextSize(tJa);
    AppMethodBeat.o(111812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.c
 * JD-Core Version:    0.7.0.1
 */