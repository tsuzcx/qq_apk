package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  int aWA;
  boolean aWB;
  boolean aWC;
  int aWD = -1;
  int aWE = -1;
  int aWF = -1;
  int aWG = -1;
  int aWH = -1;
  d aWI;
  Layout.Alignment aWJ;
  String aWz;
  int backgroundColor;
  float fontSize;
  String id;
  
  public final d aI(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(95690);
    boolean bool;
    if (this.aWI == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.aWD = i;
      AppMethodBeat.o(95690);
      return this;
      bool = false;
      break;
      label41:
      i = 0;
    }
  }
  
  public final d aJ(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(95691);
    boolean bool;
    if (this.aWI == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.aWE = i;
      AppMethodBeat.o(95691);
      return this;
      bool = false;
      break;
      label41:
      i = 0;
    }
  }
  
  final d b(d paramd)
  {
    AppMethodBeat.i(95693);
    if (paramd != null)
    {
      if ((!this.aWB) && (paramd.aWB)) {
        ee(paramd.aWA);
      }
      if (this.aWF == -1) {
        this.aWF = paramd.aWF;
      }
      if (this.aWG == -1) {
        this.aWG = paramd.aWG;
      }
      if (this.aWz == null) {
        this.aWz = paramd.aWz;
      }
      if (this.aWD == -1) {
        this.aWD = paramd.aWD;
      }
      if (this.aWE == -1) {
        this.aWE = paramd.aWE;
      }
      if (this.aWJ == null) {
        this.aWJ = paramd.aWJ;
      }
      if (this.aWH == -1)
      {
        this.aWH = paramd.aWH;
        this.fontSize = paramd.fontSize;
      }
      if ((!this.aWC) && (paramd.aWC)) {
        ef(paramd.backgroundColor);
      }
    }
    AppMethodBeat.o(95693);
    return this;
  }
  
  public final d ee(int paramInt)
  {
    AppMethodBeat.i(95692);
    if (this.aWI == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.aWA = paramInt;
      this.aWB = true;
      AppMethodBeat.o(95692);
      return this;
    }
  }
  
  public final d ef(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.aWC = true;
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.d
 * JD-Core Version:    0.7.0.1
 */