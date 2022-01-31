package com.tencent.mm.plugin.fts.ui;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class b$c
{
  public static final int mVT;
  public static final TextPaint mVU;
  public static final int mVV;
  public static final TextPaint mVW;
  public static final int mVX;
  public static final TextPaint mVY;
  public static final int mVZ;
  public static final TextPaint mWa;
  
  static
  {
    AppMethodBeat.i(61719);
    mVT = a.ao(ah.getContext(), 2131427501);
    mVU = new TextPaint();
    mVV = a.ao(ah.getContext(), 2131427809);
    mVW = new TextPaint();
    mVX = a.ao(ah.getContext(), 2131427758);
    mVY = new TextPaint();
    mVZ = a.ao(ah.getContext(), 2131427860);
    mWa = new TextPaint();
    mVU.setTextSize(mVT);
    mVW.setTextSize(mVV);
    mVY.setTextSize(mVX);
    mWa.setTextSize(mVZ);
    AppMethodBeat.o(61719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.c
 * JD-Core Version:    0.7.0.1
 */