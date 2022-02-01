package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class d
{
  String aQa;
  int bCV;
  boolean bCW;
  boolean bCX;
  int bCY;
  int bCZ;
  String bDA;
  List<String> bDB;
  String bDC;
  int bDa;
  int bDb;
  int bDc;
  Layout.Alignment bDe;
  int backgroundColor;
  String fontFamily;
  float fontSize;
  
  public d()
  {
    AppMethodBeat.i(92891);
    this.aQa = "";
    this.bDA = "";
    this.bDB = Collections.emptyList();
    this.bDC = "";
    this.fontFamily = null;
    this.bCW = false;
    this.bCX = false;
    this.bCY = -1;
    this.bCZ = -1;
    this.bDa = -1;
    this.bDb = -1;
    this.bDc = -1;
    this.bDe = null;
    AppMethodBeat.o(92891);
  }
  
  static int b(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(92892);
    if ((paramString1.isEmpty()) || (paramInt1 == -1))
    {
      AppMethodBeat.o(92892);
      return paramInt1;
    }
    if (paramString1.equals(paramString2))
    {
      AppMethodBeat.o(92892);
      return paramInt1 + paramInt2;
    }
    AppMethodBeat.o(92892);
    return -1;
  }
  
  public final int getStyle()
  {
    int j = 0;
    if ((this.bDa == -1) && (this.bDb == -1)) {
      return -1;
    }
    if (this.bDa == 1) {}
    for (int i = 1;; i = 0)
    {
      if (this.bDb == 1) {
        j = 2;
      }
      return i | j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.d
 * JD-Core Version:    0.7.0.1
 */