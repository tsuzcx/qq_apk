package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class d
{
  int backgroundColor;
  String cui;
  Layout.Alignment dgA;
  String dgW;
  List<String> dgX;
  String dgY;
  int dgs;
  boolean dgt;
  boolean dgu;
  int dgv;
  int dgw;
  int dgx;
  int dgy;
  String fontFamily;
  float fontSize;
  int italic;
  
  public d()
  {
    AppMethodBeat.i(92891);
    this.cui = "";
    this.dgW = "";
    this.dgX = Collections.emptyList();
    this.dgY = "";
    this.fontFamily = null;
    this.dgt = false;
    this.dgu = false;
    this.dgv = -1;
    this.dgw = -1;
    this.dgx = -1;
    this.italic = -1;
    this.dgy = -1;
    this.dgA = null;
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
  
  public final int TY()
  {
    int j = 0;
    if ((this.dgx == -1) && (this.italic == -1)) {
      return -1;
    }
    if (this.dgx == 1) {}
    for (int i = 1;; i = 0)
    {
      if (this.italic == 1) {
        j = 2;
      }
      return i | j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.d
 * JD-Core Version:    0.7.0.1
 */