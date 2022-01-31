package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Random;

public final class h$a
{
  public String data;
  public String gbT;
  public boolean gbU;
  public boolean gbV;
  public int gbW;
  public int gbX;
  public int gbY;
  public boolean gbZ;
  
  public h$a(h paramh)
  {
    AppMethodBeat.i(116746);
    this.gbU = false;
    this.gbV = false;
    this.gbW = 2147483647;
    this.gbX = 0;
    this.gbY = -1;
    this.data = null;
    this.gbZ = false;
    this.gbT = vX(this.gca.gbP);
    AppMethodBeat.o(116746);
  }
  
  public h$a(h paramh, String paramString)
  {
    AppMethodBeat.i(155551);
    this.gbU = false;
    this.gbV = false;
    this.gbW = 2147483647;
    this.gbX = 0;
    this.gbY = -1;
    this.data = null;
    this.gbZ = false;
    this.gbT = vX(paramString);
    AppMethodBeat.o(155551);
  }
  
  private static String vX(String paramString)
  {
    AppMethodBeat.i(155552);
    long l3 = 0xFFFFFFFF & System.currentTimeMillis();
    long l4 = 0xFFFFFFFF & new Random(System.currentTimeMillis()).nextInt();
    long l2 = l3 << 32 | l4;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = Math.abs(l2);
    }
    String str = paramString + l1;
    ab.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", new Object[] { Long.valueOf(l4), Long.toBinaryString(l4), Long.valueOf(l3), Long.toBinaryString(l3), Long.valueOf(l1), Long.toBinaryString(l1), paramString, str });
    AppMethodBeat.o(155552);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h.a
 * JD-Core Version:    0.7.0.1
 */