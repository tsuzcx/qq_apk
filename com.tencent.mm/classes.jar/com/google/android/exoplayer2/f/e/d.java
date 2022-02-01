package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  int bCT;
  boolean bCU;
  boolean bCV;
  int bCW = -1;
  int bCX = -1;
  int bCY = -1;
  int bCZ = -1;
  int bDa = -1;
  d bDb;
  Layout.Alignment bDc;
  int backgroundColor;
  String fontFamily;
  float fontSize;
  String id;
  
  public final d aV(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92858);
    boolean bool;
    if (this.bDb == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.bCW = i;
      AppMethodBeat.o(92858);
      return this;
      bool = false;
      break;
      label41:
      i = 0;
    }
  }
  
  public final d aW(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92859);
    boolean bool;
    if (this.bDb == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.bCX = i;
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
      if ((!this.bCU) && (paramd.bCU)) {
        eT(paramd.bCT);
      }
      if (this.bCY == -1) {
        this.bCY = paramd.bCY;
      }
      if (this.bCZ == -1) {
        this.bCZ = paramd.bCZ;
      }
      if (this.fontFamily == null) {
        this.fontFamily = paramd.fontFamily;
      }
      if (this.bCW == -1) {
        this.bCW = paramd.bCW;
      }
      if (this.bCX == -1) {
        this.bCX = paramd.bCX;
      }
      if (this.bDc == null) {
        this.bDc = paramd.bDc;
      }
      if (this.bDa == -1)
      {
        this.bDa = paramd.bDa;
        this.fontSize = paramd.fontSize;
      }
      if ((!this.bCV) && (paramd.bCV)) {
        eU(paramd.backgroundColor);
      }
    }
    AppMethodBeat.o(92861);
    return this;
  }
  
  public final d eT(int paramInt)
  {
    AppMethodBeat.i(92860);
    if (this.bDb == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bCT = paramInt;
      this.bCU = true;
      AppMethodBeat.o(92860);
      return this;
    }
  }
  
  public final d eU(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.bCV = true;
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.d
 * JD-Core Version:    0.7.0.1
 */