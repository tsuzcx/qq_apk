package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j$a
{
  double cij;
  double cik;
  double cil;
  double[] cim;
  double cin;
  double cio;
  int cip;
  double ciq;
  double cir;
  int cis;
  double cit;
  double ciu;
  double civ;
  int mType;
  
  protected j$a(int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt2, double paramDouble6, int paramInt3, double paramDouble7, double paramDouble8)
  {
    AppMethodBeat.i(87961);
    this.cim = new double[2];
    this.mType = paramInt1;
    this.cij = paramDouble1;
    this.cik = paramDouble2;
    this.cil = paramDouble3;
    this.cin = paramDouble4;
    this.cio = paramDouble5;
    this.cip = paramInt2;
    this.ciq = paramDouble6;
    this.cir = 0.0D;
    this.cis = paramInt3;
    this.cit = 0.0D;
    this.ciu = paramDouble7;
    this.civ = paramDouble8;
    AppMethodBeat.o(87961);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(87962);
    String str = String.valueOf(this.mType) + ',' + this.cij + ',' + this.cik + ',' + this.cil + ',' + this.cin + ',' + this.cio + ',' + this.cip + ',' + this.ciq + ',' + this.cir + ',' + this.cis + ',' + this.ciu + ',' + this.civ;
    AppMethodBeat.o(87962);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.a.j.a
 * JD-Core Version:    0.7.0.1
 */