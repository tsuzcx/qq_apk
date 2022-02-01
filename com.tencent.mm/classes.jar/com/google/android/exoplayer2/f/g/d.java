package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class d
{
  int backgroundColor;
  int buC;
  boolean buD;
  boolean buE;
  int buF;
  int buG;
  int buH;
  int buI;
  int buJ;
  float buK;
  Layout.Alignment buM;
  String bvi;
  String bvj;
  List<String> bvk;
  String bvl;
  String iE;
  
  public d()
  {
    AppMethodBeat.i(92891);
    this.bvi = "";
    this.bvj = "";
    this.bvk = Collections.emptyList();
    this.bvl = "";
    this.iE = null;
    this.buD = false;
    this.buE = false;
    this.buF = -1;
    this.buG = -1;
    this.buH = -1;
    this.buI = -1;
    this.buJ = -1;
    this.buM = null;
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
    if ((this.buH == -1) && (this.buI == -1)) {
      return -1;
    }
    if (this.buH == 1) {}
    for (int i = 1;; i = 0)
    {
      if (this.buI == 1) {
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