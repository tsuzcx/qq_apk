package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class d
{
  int backgroundColor;
  int bsB;
  boolean bsC;
  boolean bsD;
  int bsE;
  int bsF;
  int bsG;
  int bsH;
  int bsI;
  float bsJ;
  Layout.Alignment bsL;
  String bth;
  String bti;
  List<String> btj;
  String btk;
  String jD;
  
  public d()
  {
    AppMethodBeat.i(92891);
    this.bth = "";
    this.bti = "";
    this.btj = Collections.emptyList();
    this.btk = "";
    this.jD = null;
    this.bsC = false;
    this.bsD = false;
    this.bsE = -1;
    this.bsF = -1;
    this.bsG = -1;
    this.bsH = -1;
    this.bsI = -1;
    this.bsL = null;
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
    if ((this.bsG == -1) && (this.bsH == -1)) {
      return -1;
    }
    if (this.bsG == 1) {}
    for (int i = 1;; i = 0)
    {
      if (this.bsH == 1) {
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