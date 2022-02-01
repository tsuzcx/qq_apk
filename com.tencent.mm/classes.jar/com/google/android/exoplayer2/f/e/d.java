package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  int backgroundColor;
  int buC;
  boolean buD;
  boolean buE;
  int buF = -1;
  int buG = -1;
  int buH = -1;
  int buI = -1;
  int buJ = -1;
  float buK;
  d buL;
  Layout.Alignment buM;
  String iE;
  String id;
  
  public final d aV(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(92858);
    boolean bool;
    if (this.buL == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.buF = i;
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
    if (this.buL == null)
    {
      bool = true;
      a.checkState(bool);
      if (!paramBoolean) {
        break label41;
      }
    }
    for (;;)
    {
      this.buG = i;
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
      if ((!this.buD) && (paramd.buD)) {
        fc(paramd.buC);
      }
      if (this.buH == -1) {
        this.buH = paramd.buH;
      }
      if (this.buI == -1) {
        this.buI = paramd.buI;
      }
      if (this.iE == null) {
        this.iE = paramd.iE;
      }
      if (this.buF == -1) {
        this.buF = paramd.buF;
      }
      if (this.buG == -1) {
        this.buG = paramd.buG;
      }
      if (this.buM == null) {
        this.buM = paramd.buM;
      }
      if (this.buJ == -1)
      {
        this.buJ = paramd.buJ;
        this.buK = paramd.buK;
      }
      if ((!this.buE) && (paramd.buE)) {
        fd(paramd.backgroundColor);
      }
    }
    AppMethodBeat.o(92861);
    return this;
  }
  
  public final d fc(int paramInt)
  {
    AppMethodBeat.i(92860);
    if (this.buL == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.buC = paramInt;
      this.buD = true;
      AppMethodBeat.o(92860);
      return this;
    }
  }
  
  public final d fd(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.buE = true;
    return this;
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
 * Qualified Name:     com.google.android.exoplayer2.f.e.d
 * JD-Core Version:    0.7.0.1
 */