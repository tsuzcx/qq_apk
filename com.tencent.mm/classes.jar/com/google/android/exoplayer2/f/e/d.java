package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  int backgroundColor;
  Layout.Alignment dgA;
  int dgs;
  boolean dgt;
  boolean dgu;
  int dgv = -1;
  int dgw = -1;
  int dgx = -1;
  int dgy = -1;
  d dgz;
  String fontFamily;
  float fontSize;
  String id;
  int italic = -1;
  
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
  
  final d b(d paramd)
  {
    AppMethodBeat.i(92861);
    if (paramd != null)
    {
      if ((!this.dgt) && (paramd.dgt)) {
        iz(paramd.dgs);
      }
      if (this.dgx == -1) {
        this.dgx = paramd.dgx;
      }
      if (this.italic == -1) {
        this.italic = paramd.italic;
      }
      if (this.fontFamily == null) {
        this.fontFamily = paramd.fontFamily;
      }
      if (this.dgv == -1) {
        this.dgv = paramd.dgv;
      }
      if (this.dgw == -1) {
        this.dgw = paramd.dgw;
      }
      if (this.dgA == null) {
        this.dgA = paramd.dgA;
      }
      if (this.dgy == -1)
      {
        this.dgy = paramd.dgy;
        this.fontSize = paramd.fontSize;
      }
      if ((!this.dgu) && (paramd.dgu)) {
        iA(paramd.backgroundColor);
      }
    }
    AppMethodBeat.o(92861);
    return this;
  }
  
  public final d bA(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92858);
    boolean bool;
    if (this.dgz == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.dgv = i;
      AppMethodBeat.o(92858);
      return this;
      bool = false;
      break;
      label41:
      i = 0;
    }
  }
  
  public final d bB(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92859);
    boolean bool;
    if (this.dgz == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.dgw = i;
      AppMethodBeat.o(92859);
      return this;
      bool = false;
      break;
      label41:
      i = 0;
    }
  }
  
  public final d iA(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.dgu = true;
    return this;
  }
  
  public final d iz(int paramInt)
  {
    AppMethodBeat.i(92860);
    if (this.dgz == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.dgs = paramInt;
      this.dgt = true;
      AppMethodBeat.o(92860);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.d
 * JD-Core Version:    0.7.0.1
 */