package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int bsY;
  long fCI;
  int fCJ;
  int fCK;
  int fns;
  String fnu;
  String fnv;
  int type;
  String username;
  
  public a()
  {
    AppMethodBeat.i(16467);
    this.bsY = -1;
    this.username = "";
    this.fCI = 0L;
    this.type = 0;
    this.fCJ = 0;
    this.fns = 0;
    this.fCK = 0;
    this.fnu = "";
    this.fnv = "";
    AppMethodBeat.o(16467);
  }
  
  public final String agY()
  {
    if (this.fnu == null) {
      return "";
    }
    return this.fnu;
  }
  
  public final String agZ()
  {
    if (this.fnv == null) {
      return "";
    }
    return this.fnv;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ar.a
 * JD-Core Version:    0.7.0.1
 */