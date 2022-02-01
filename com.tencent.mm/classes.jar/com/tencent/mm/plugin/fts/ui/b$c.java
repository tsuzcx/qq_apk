package com.tencent.mm.plugin.fts.ui;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b$c
{
  public static final int wZT;
  public static final TextPaint wZU;
  public static final int wZV;
  public static final TextPaint wZW;
  public static final int wZX;
  public static final TextPaint wZY;
  public static final int wZZ;
  public static final TextPaint xaa;
  
  static
  {
    AppMethodBeat.i(111812);
    wZT = a.aG(MMApplicationContext.getContext(), 2131165195);
    wZU = new TextPaint();
    wZV = a.aG(MMApplicationContext.getContext(), 2131165535);
    wZW = new TextPaint();
    wZX = a.aG(MMApplicationContext.getContext(), 2131165482);
    wZY = new TextPaint();
    wZZ = a.aG(MMApplicationContext.getContext(), 2131165592);
    xaa = new TextPaint();
    wZU.setTextSize(wZT);
    wZW.setTextSize(wZV);
    wZY.setTextSize(wZX);
    xaa.setTextSize(wZZ);
    AppMethodBeat.o(111812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.c
 * JD-Core Version:    0.7.0.1
 */