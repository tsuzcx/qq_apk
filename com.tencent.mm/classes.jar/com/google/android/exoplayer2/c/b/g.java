package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.i.j;

final class g
{
  public c aCK;
  public long aCL;
  public long aCM;
  public long aCN;
  public int aCO;
  public long[] aCP;
  public int[] aCQ;
  public int[] aCR;
  public int[] aCS;
  public long[] aCT;
  public boolean[] aCU;
  public boolean aCV;
  public boolean[] aCW;
  public f aCX;
  public int aCY;
  public j aCZ;
  public boolean aDa;
  public long aDb;
  public int sampleCount;
  
  public final void cZ(int paramInt)
  {
    if ((this.aCZ == null) || (this.aCZ.limit < paramInt)) {
      this.aCZ = new j(paramInt);
    }
    this.aCY = paramInt;
    this.aCV = true;
    this.aDa = true;
  }
  
  public final long da(int paramInt)
  {
    return this.aCT[paramInt] + this.aCS[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.g
 * JD-Core Version:    0.7.0.1
 */