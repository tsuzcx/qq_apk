package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class d
{
  int aWA;
  boolean aWB;
  boolean aWC;
  int aWD;
  int aWE;
  int aWF;
  int aWG;
  int aWH;
  Layout.Alignment aWJ;
  String aWz;
  String aXf;
  String aXg;
  List<String> aXh;
  String aXi;
  int backgroundColor;
  float fontSize;
  
  public d()
  {
    AppMethodBeat.i(95723);
    this.aXf = "";
    this.aXg = "";
    this.aXh = Collections.emptyList();
    this.aXi = "";
    this.aWz = null;
    this.aWB = false;
    this.aWC = false;
    this.aWD = -1;
    this.aWE = -1;
    this.aWF = -1;
    this.aWG = -1;
    this.aWH = -1;
    this.aWJ = null;
    AppMethodBeat.o(95723);
  }
  
  static int a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(95724);
    if ((paramString1.isEmpty()) || (paramInt1 == -1))
    {
      AppMethodBeat.o(95724);
      return paramInt1;
    }
    if (paramString1.equals(paramString2))
    {
      AppMethodBeat.o(95724);
      return paramInt1 + paramInt2;
    }
    AppMethodBeat.o(95724);
    return -1;
  }
  
  public final int getStyle()
  {
    int j = 0;
    if ((this.aWF == -1) && (this.aWG == -1)) {
      return -1;
    }
    if (this.aWF == 1) {}
    for (int i = 1;; i = 0)
    {
      if (this.aWG == 1) {
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