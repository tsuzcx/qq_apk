package com.tencent.mm.au;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int dDp;
  int hHL;
  String hHN;
  String hHO;
  long hYr;
  int hYs;
  int hYt;
  int type;
  String username;
  
  public a()
  {
    AppMethodBeat.i(20513);
    this.dDp = -1;
    this.username = "";
    this.hYr = 0L;
    this.type = 0;
    this.hYs = 0;
    this.hHL = 0;
    this.hYt = 0;
    this.hHN = "";
    this.hHO = "";
    AppMethodBeat.o(20513);
  }
  
  public final String aCq()
  {
    if (this.hHO == null) {
      return "";
    }
    return this.hHO;
  }
  
  public final String aHX()
  {
    if (this.hHN == null) {
      return "";
    }
    return this.hHN;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.au.a
 * JD-Core Version:    0.7.0.1
 */