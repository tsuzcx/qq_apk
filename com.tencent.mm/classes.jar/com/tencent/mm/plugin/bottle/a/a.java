package com.tencent.mm.plugin.bottle.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  String content;
  long createtime;
  private int drx;
  int hFO;
  int hpt;
  String hpv;
  String hpw;
  int msgType;
  String ntr;
  int nts;
  String ntt;
  int ntu;
  int ntv;
  
  public a()
  {
    AppMethodBeat.i(22643);
    this.drx = -1;
    this.ntr = "";
    this.nts = 0;
    this.ntt = "";
    this.ntu = 0;
    this.msgType = 0;
    this.ntv = 0;
    this.content = "";
    this.createtime = 0L;
    this.hpt = 0;
    this.hFO = 0;
    this.hpv = "";
    this.hpw = "";
    AppMethodBeat.o(22643);
  }
  
  public final String getContent()
  {
    if (this.content == null) {
      return "";
    }
    return this.content;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.a
 * JD-Core Version:    0.7.0.1
 */