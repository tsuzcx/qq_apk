package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int cUP;
  long lMC;
  int lMD;
  int lME;
  int lvr;
  String lvt;
  String lvu;
  int type;
  String username;
  
  public a()
  {
    AppMethodBeat.i(20513);
    this.cUP = -1;
    this.username = "";
    this.lMC = 0L;
    this.type = 0;
    this.lMD = 0;
    this.lvr = 0;
    this.lME = 0;
    this.lvt = "";
    this.lvu = "";
    AppMethodBeat.o(20513);
  }
  
  public final String bfh()
  {
    if (this.lvu == null) {
      return "";
    }
    return this.lvu;
  }
  
  public final String blx()
  {
    if (this.lvt == null) {
      return "";
    }
    return this.lvt;
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
 * Qualified Name:     com.tencent.mm.aw.a
 * JD-Core Version:    0.7.0.1
 */