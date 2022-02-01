package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class g
  extends h
{
  private static final int cST;
  private static final byte[] cSU;
  private boolean cSV;
  
  static
  {
    AppMethodBeat.i(92165);
    cST = x.du("Opus");
    cSU = new byte[] { 79, 112, 117, 115, 72, 101, 97, 100 };
    AppMethodBeat.o(92165);
  }
  
  private static void j(List<byte[]> paramList, int paramInt)
  {
    AppMethodBeat.i(92164);
    long l = paramInt * 1000000000L / 48000L;
    paramList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(l).array());
    AppMethodBeat.o(92164);
  }
  
  public static boolean r(m paramm)
  {
    AppMethodBeat.i(92160);
    if (paramm.UF() < cSU.length)
    {
      AppMethodBeat.o(92160);
      return false;
    }
    byte[] arrayOfByte = new byte[cSU.length];
    paramm.readBytes(arrayOfByte, 0, cSU.length);
    boolean bool = Arrays.equals(arrayOfByte, cSU);
    AppMethodBeat.o(92160);
    return bool;
  }
  
  protected final boolean a(m paramm, long paramLong, h.a parama)
  {
    AppMethodBeat.i(92163);
    if (!this.cSV)
    {
      paramm = Arrays.copyOf(paramm.data, paramm.limit);
      int i = paramm[9];
      int j = paramm[11];
      int k = paramm[10];
      ArrayList localArrayList = new ArrayList(3);
      localArrayList.add(paramm);
      j(localArrayList, (j & 0xFF) << 8 | k & 0xFF);
      j(localArrayList, 3840);
      parama.cHc = Format.a(null, "audio/opus", -1, -1, i & 0xFF, 48000, localArrayList, null, null);
      this.cSV = true;
      AppMethodBeat.o(92163);
      return true;
    }
    if (paramm.readInt() == cST) {}
    for (boolean bool = true;; bool = false)
    {
      paramm.setPosition(0);
      AppMethodBeat.o(92163);
      return bool;
    }
  }
  
  protected final void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(92161);
    super.reset(paramBoolean);
    if (paramBoolean) {
      this.cSV = false;
    }
    AppMethodBeat.o(92161);
  }
  
  protected final long s(m paramm)
  {
    AppMethodBeat.i(92162);
    paramm = paramm.data;
    int i = paramm[0] & 0xFF;
    int j;
    int k;
    switch (i & 0x3)
    {
    default: 
      j = paramm[1] & 0x3F;
      i >>= 3;
      k = i & 0x3;
      if (i >= 16) {
        i = 2500 << k;
      }
      break;
    }
    for (;;)
    {
      long l = ck(i * j);
      AppMethodBeat.o(92162);
      return l;
      j = 1;
      break;
      j = 2;
      break;
      if (i >= 12) {
        i = 10000 << (k & 0x1);
      } else if (k == 3) {
        i = 60000;
      } else {
        i = 10000 << k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.g
 * JD-Core Version:    0.7.0.1
 */