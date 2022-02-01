package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  int backgroundColor;
  int bsB;
  boolean bsC;
  boolean bsD;
  int bsE = -1;
  int bsF = -1;
  int bsG = -1;
  int bsH = -1;
  int bsI = -1;
  float bsJ;
  d bsK;
  Layout.Alignment bsL;
  String id;
  String jD;
  
  public final d aU(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92858);
    boolean bool;
    if (this.bsK == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.bsE = i;
      AppMethodBeat.o(92858);
      return this;
      bool = false;
      break;
      label41:
      i = 0;
    }
  }
  
  public final d aV(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92859);
    boolean bool;
    if (this.bsK == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.bsF = i;
      AppMethodBeat.o(92859);
      return this;
      bool = false;
      break;
      label41:
      i = 0;
    }
  }
  
  final d b(d paramd)
  {
    AppMethodBeat.i(92861);
    if (paramd != null)
    {
      if ((!this.bsC) && (paramd.bsC)) {
        eP(paramd.bsB);
      }
      if (this.bsG == -1) {
        this.bsG = paramd.bsG;
      }
      if (this.bsH == -1) {
        this.bsH = paramd.bsH;
      }
      if (this.jD == null) {
        this.jD = paramd.jD;
      }
      if (this.bsE == -1) {
        this.bsE = paramd.bsE;
      }
      if (this.bsF == -1) {
        this.bsF = paramd.bsF;
      }
      if (this.bsL == null) {
        this.bsL = paramd.bsL;
      }
      if (this.bsI == -1)
      {
        this.bsI = paramd.bsI;
        this.bsJ = paramd.bsJ;
      }
      if ((!this.bsD) && (paramd.bsD)) {
        eQ(paramd.backgroundColor);
      }
    }
    AppMethodBeat.o(92861);
    return this;
  }
  
  public final d eP(int paramInt)
  {
    AppMethodBeat.i(92860);
    if (this.bsK == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bsB = paramInt;
      this.bsC = true;
      AppMethodBeat.o(92860);
      return this;
    }
  }
  
  public final d eQ(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.bsD = true;
    return this;
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
 * Qualified Name:     com.google.android.exoplayer2.f.e.d
 * JD-Core Version:    0.7.0.1
 */