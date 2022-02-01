package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  int backgroundColor;
  int bmA = -1;
  int bmB = -1;
  int bmC = -1;
  int bmD = -1;
  d bmE;
  Layout.Alignment bmF;
  int bmx;
  boolean bmy;
  boolean bmz;
  String fontFamily;
  float fontSize;
  String id;
  int italic = -1;
  
  public final d aS(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92858);
    boolean bool;
    if (this.bmE == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.bmA = i;
      AppMethodBeat.o(92858);
      return this;
      bool = false;
      break;
      label41:
      i = 0;
    }
  }
  
  public final d aT(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92859);
    boolean bool;
    if (this.bmE == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.bmB = i;
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
      if ((!this.bmy) && (paramd.bmy)) {
        fk(paramd.bmx);
      }
      if (this.bmC == -1) {
        this.bmC = paramd.bmC;
      }
      if (this.italic == -1) {
        this.italic = paramd.italic;
      }
      if (this.fontFamily == null) {
        this.fontFamily = paramd.fontFamily;
      }
      if (this.bmA == -1) {
        this.bmA = paramd.bmA;
      }
      if (this.bmB == -1) {
        this.bmB = paramd.bmB;
      }
      if (this.bmF == null) {
        this.bmF = paramd.bmF;
      }
      if (this.bmD == -1)
      {
        this.bmD = paramd.bmD;
        this.fontSize = paramd.fontSize;
      }
      if ((!this.bmz) && (paramd.bmz)) {
        fl(paramd.backgroundColor);
      }
    }
    AppMethodBeat.o(92861);
    return this;
  }
  
  public final d fk(int paramInt)
  {
    AppMethodBeat.i(92860);
    if (this.bmE == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bmx = paramInt;
      this.bmy = true;
      AppMethodBeat.o(92860);
      return this;
    }
  }
  
  public final d fl(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.bmz = true;
    return this;
  }
  
  public final int uv()
  {
    int j = 0;
    if ((this.bmC == -1) && (this.italic == -1)) {
      return -1;
    }
    if (this.bmC == 1) {}
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
 * Qualified Name:     com.google.android.exoplayer2.f.e.d
 * JD-Core Version:    0.7.0.1
 */