package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Random;

public final class h$a
{
  public String data;
  public String eMn;
  public boolean eMo;
  public boolean eMp;
  public int eMq;
  public int eMr;
  public int eMs;
  public boolean eMt;
  
  public h$a(h paramh)
  {
    long l3 = 0xFFFFFFFF & System.currentTimeMillis();
    long l4 = 0xFFFFFFFF & new Random(System.currentTimeMillis()).nextInt();
    long l2 = l3 << 32 | l4;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = Math.abs(l2);
    }
    paramh = this.eMu.eMj + String.valueOf(l1);
    y.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", new Object[] { Long.valueOf(l4), Long.toBinaryString(l4), Long.valueOf(l3), Long.toBinaryString(l3), Long.valueOf(l1), Long.toBinaryString(l1), this.eMu.eMj, paramh });
    this.eMn = paramh;
    this.eMo = false;
    this.eMp = false;
    this.eMq = 2147483647;
    this.eMr = 0;
    this.eMs = -1;
    this.data = null;
    this.eMt = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h.a
 * JD-Core Version:    0.7.0.1
 */