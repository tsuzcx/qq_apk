package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import java.util.Collections;
import java.util.List;

final class d
{
  String aPL = "";
  String aPM = "";
  List<String> aPN = Collections.emptyList();
  String aPO = "";
  String aPg = null;
  int aPh;
  boolean aPi = false;
  boolean aPj = false;
  int aPk = -1;
  int aPl = -1;
  int aPm = -1;
  int aPn = -1;
  Layout.Alignment aPp = null;
  int backgroundColor;
  float fontSize;
  int italic = -1;
  
  static int a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramString1.isEmpty()) || (paramInt1 == -1)) {
      return paramInt1;
    }
    if (paramString1.equals(paramString2)) {
      return paramInt1 + paramInt2;
    }
    return -1;
  }
  
  public final int getStyle()
  {
    int j = 0;
    if ((this.aPm == -1) && (this.italic == -1)) {
      return -1;
    }
    if (this.aPm == 1) {}
    for (int i = 1;; i = 0)
    {
      if (this.italic == 1) {
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