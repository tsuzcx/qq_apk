package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int cSx;
  int iFr;
  String iFt;
  String iFu;
  long iWh;
  int iWi;
  int iWj;
  int type;
  String username;
  
  public a()
  {
    AppMethodBeat.i(20513);
    this.cSx = -1;
    this.username = "";
    this.iWh = 0L;
    this.type = 0;
    this.iWi = 0;
    this.iFr = 0;
    this.iWj = 0;
    this.iFt = "";
    this.iFu = "";
    AppMethodBeat.o(20513);
  }
  
  public final String aWe()
  {
    if (this.iFu == null) {
      return "";
    }
    return this.iFu;
  }
  
  public final String bci()
  {
    if (this.iFt == null) {
      return "";
    }
    return this.iFt;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.a
 * JD-Core Version:    0.7.0.1
 */