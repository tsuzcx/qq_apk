package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.at.e;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bi;

final class b$a
{
  bi cmQ;
  String eDA;
  int eDB;
  d eDC;
  boolean eDD;
  c eDE;
  c eDF;
  long eDv;
  int eDw;
  e eDx;
  String eDy;
  boolean eDz;
  final b rr;
  
  b$a(long paramLong, bi parambi, b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(16180);
    this.cmQ = null;
    this.eDz = false;
    this.eDB = 0;
    this.eDD = false;
    this.eDE = new b.a.1(this);
    this.eDF = new b.a.2(this);
    this.eDv = paramLong;
    this.cmQ = parambi;
    this.rr = paramb;
    this.eDw = paramInt;
    this.eDD = paramBoolean;
    AppMethodBeat.o(16180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.insane_statistic.b.a
 * JD-Core Version:    0.7.0.1
 */