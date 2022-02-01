package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;

public final class j$c
{
  String oHu;
  String[] oHv;
  long[] oHw;
  AtomicLong oHx;
  String table;
  
  public j$c(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(238996);
    this.oHw = new long[2];
    this.oHx = new AtomicLong(0L);
    this.table = paramString2;
    this.oHu = paramString1;
    this.oHv = paramArrayOfString;
    this.oHw[0] = paramLong1;
    this.oHw[1] = paramLong2;
    this.oHx.set(paramLong1);
    AppMethodBeat.o(238996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.j.c
 * JD-Core Version:    0.7.0.1
 */