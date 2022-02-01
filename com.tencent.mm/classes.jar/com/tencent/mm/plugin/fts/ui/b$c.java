package com.tencent.mm.plugin.fts.ui;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b$c
{
  public static final int BLS;
  public static final TextPaint BLT;
  public static final int BLU;
  public static final TextPaint BLV;
  public static final int BLW;
  public static final TextPaint BLX;
  public static final int BLY;
  public static final TextPaint BLZ;
  
  static
  {
    AppMethodBeat.i(111812);
    BLS = a.aY(MMApplicationContext.getContext(), o.b.BigTextSize);
    BLT = new TextPaint();
    BLU = a.aY(MMApplicationContext.getContext(), o.b.NormalTextSize);
    BLV = new TextPaint();
    BLW = a.aY(MMApplicationContext.getContext(), o.b.HintTextSize);
    BLX = new TextPaint();
    BLY = a.aY(MMApplicationContext.getContext(), o.b.SmallerTextSize);
    BLZ = new TextPaint();
    BLT.setTextSize(BLS);
    BLV.setTextSize(BLU);
    BLX.setTextSize(BLW);
    BLZ.setTextSize(BLY);
    AppMethodBeat.o(111812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.c
 * JD-Core Version:    0.7.0.1
 */