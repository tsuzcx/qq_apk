package com.tencent.mm.as;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int eQp;
  long oFj;
  int oFk;
  int oFl;
  int omO;
  String omQ;
  String omR;
  int type;
  String username;
  
  public a()
  {
    AppMethodBeat.i(20513);
    this.eQp = -1;
    this.username = "";
    this.oFj = 0L;
    this.type = 0;
    this.oFk = 0;
    this.omO = 0;
    this.oFl = 0;
    this.omQ = "";
    this.omR = "";
    AppMethodBeat.o(20513);
  }
  
  public final String bCY()
  {
    if (this.omR == null) {
      return "";
    }
    return this.omR;
  }
  
  public final String bJs()
  {
    if (this.omQ == null) {
      return "";
    }
    return this.omQ;
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
 * Qualified Name:     com.tencent.mm.as.a
 * JD-Core Version:    0.7.0.1
 */