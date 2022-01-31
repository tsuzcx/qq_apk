package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.am;

public final class h
{
  static int index = 0;
  private h.a hKG;
  int[] hMm = { 1000, 1000, 1000, 2000, 5000, 9000, 1000 };
  int hMn = 0;
  boolean hMo = false;
  am hMp = new am(Looper.getMainLooper(), new h.1(this), false);
  
  public h(h.a parama)
  {
    this.hKG = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h
 * JD-Core Version:    0.7.0.1
 */