package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class d
{
  String aQh;
  int bCT;
  boolean bCU;
  boolean bCV;
  int bCW;
  int bCX;
  int bCY;
  int bCZ;
  String bDA;
  int bDa;
  Layout.Alignment bDc;
  String bDy;
  List<String> bDz;
  int backgroundColor;
  String fontFamily;
  float fontSize;
  
  public d()
  {
    AppMethodBeat.i(92891);
    this.aQh = "";
    this.bDy = "";
    this.bDz = Collections.emptyList();
    this.bDA = "";
    this.fontFamily = null;
    this.bCU = false;
    this.bCV = false;
    this.bCW = -1;
    this.bCX = -1;
    this.bCY = -1;
    this.bCZ = -1;
    this.bDa = -1;
    this.bDc = null;
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
    if ((this.bCY == -1) && (this.bCZ == -1)) {
      return -1;
    }
    if (this.bCY == 1) {}
    for (int i = 1;; i = 0)
    {
      if (this.bCZ == 1) {
        j = 2;
      }
      return i | j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.d
 * JD-Core Version:    0.7.0.1
 */