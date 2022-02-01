package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  int bCV;
  boolean bCW;
  boolean bCX;
  int bCY = -1;
  int bCZ = -1;
  int bDa = -1;
  int bDb = -1;
  int bDc = -1;
  d bDd;
  Layout.Alignment bDe;
  int backgroundColor;
  String fontFamily;
  float fontSize;
  String id;
  
  public final d aU(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92858);
    boolean bool;
    if (this.bDd == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.bCY = i;
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
    if (this.bDd == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.bCZ = i;
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
      if ((!this.bCW) && (paramd.bCW)) {
        eS(paramd.bCV);
      }
      if (this.bDa == -1) {
        this.bDa = paramd.bDa;
      }
      if (this.bDb == -1) {
        this.bDb = paramd.bDb;
      }
      if (this.fontFamily == null) {
        this.fontFamily = paramd.fontFamily;
      }
      if (this.bCY == -1) {
        this.bCY = paramd.bCY;
      }
      if (this.bCZ == -1) {
        this.bCZ = paramd.bCZ;
      }
      if (this.bDe == null) {
        this.bDe = paramd.bDe;
      }
      if (this.bDc == -1)
      {
        this.bDc = paramd.bDc;
        this.fontSize = paramd.fontSize;
      }
      if ((!this.bCX) && (paramd.bCX)) {
        eT(paramd.backgroundColor);
      }
    }
    AppMethodBeat.o(92861);
    return this;
  }
  
  public final d eS(int paramInt)
  {
    AppMethodBeat.i(92860);
    if (this.bDd == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bCV = paramInt;
      this.bCW = true;
      AppMethodBeat.o(92860);
      return this;
    }
  }
  
  public final d eT(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.bCX = true;
    return this;
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
 * Qualified Name:     com.google.android.exoplayer2.f.e.d
 * JD-Core Version:    0.7.0.1
 */