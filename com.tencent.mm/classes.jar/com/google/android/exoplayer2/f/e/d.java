package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;

final class d
{
  String aPg;
  int aPh;
  boolean aPi;
  boolean aPj;
  int aPk = -1;
  int aPl = -1;
  int aPm = -1;
  int aPn = -1;
  d aPo;
  Layout.Alignment aPp;
  int backgroundColor;
  float fontSize;
  String id;
  int italic = -1;
  
  public final d aA(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (this.aPo == null)
    {
      bool = true;
      a.aC(bool);
      if (!paramBoolean) {
        break label31;
      }
    }
    for (;;)
    {
      this.aPl = i;
      return this;
      bool = false;
      break;
      label31:
      i = 0;
    }
  }
  
  public final d az(boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    if (this.aPo == null)
    {
      bool = true;
      a.aC(bool);
      if (!paramBoolean) {
        break label31;
      }
    }
    for (;;)
    {
      this.aPk = i;
      return this;
      bool = false;
      break;
      label31:
      i = 0;
    }
  }
  
  public final d b(d paramd)
  {
    if (paramd != null)
    {
      if ((!this.aPi) && (paramd.aPi)) {
        dr(paramd.aPh);
      }
      if (this.aPm == -1) {
        this.aPm = paramd.aPm;
      }
      if (this.italic == -1) {
        this.italic = paramd.italic;
      }
      if (this.aPg == null) {
        this.aPg = paramd.aPg;
      }
      if (this.aPk == -1) {
        this.aPk = paramd.aPk;
      }
      if (this.aPl == -1) {
        this.aPl = paramd.aPl;
      }
      if (this.aPp == null) {
        this.aPp = paramd.aPp;
      }
      if (this.aPn == -1)
      {
        this.aPn = paramd.aPn;
        this.fontSize = paramd.fontSize;
      }
      if ((!this.aPj) && (paramd.aPj)) {
        ds(paramd.backgroundColor);
      }
    }
    return this;
  }
  
  public final d dr(int paramInt)
  {
    if (this.aPo == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      this.aPh = paramInt;
      this.aPi = true;
      return this;
    }
  }
  
  public final d ds(int paramInt)
  {
    this.backgroundColor = paramInt;
    this.aPj = true;
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.d
 * JD-Core Version:    0.7.0.1
 */