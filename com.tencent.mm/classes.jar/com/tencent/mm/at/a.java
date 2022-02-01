package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int drx;
  long hFM;
  int hFN;
  int hFO;
  int hpt;
  String hpv;
  String hpw;
  int type;
  String username;
  
  public a()
  {
    AppMethodBeat.i(20513);
    this.drx = -1;
    this.username = "";
    this.hFM = 0L;
    this.type = 0;
    this.hFN = 0;
    this.hpt = 0;
    this.hFO = 0;
    this.hpv = "";
    this.hpw = "";
    AppMethodBeat.o(20513);
  }
  
  public final String aES()
  {
    if (this.hpv == null) {
      return "";
    }
    return this.hpv;
  }
  
  public final String azm()
  {
    if (this.hpw == null) {
      return "";
    }
    return this.hpw;
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
 * Qualified Name:     com.tencent.mm.at.a
 * JD-Core Version:    0.7.0.1
 */