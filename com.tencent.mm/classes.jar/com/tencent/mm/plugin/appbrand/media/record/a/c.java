package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class c
  implements d
{
  String kRt = "audio/mp4a-latm";
  String kRu = "audio/mpeg";
  d.a kRv = null;
  int kRw = 0;
  int kRx = 0;
  byte[] kRy;
  int kRz = 0;
  
  public final void a(d.a parama)
  {
    this.kRv = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146344);
    if (this.kRv == null)
    {
      ad.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (this.kRx == 0.0D)
    {
      ad.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (paramInt > this.kRx) {
      ad.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kRx) });
    }
    ad.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.kRz), Integer.valueOf(paramInt) });
    int i = this.kRz + paramInt;
    if ((i >= this.kRx) && (paramArrayOfByte != null))
    {
      ad.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
      if (i > this.kRy.length)
      {
        ad.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
        byte[] arrayOfByte = this.kRy;
        this.kRy = new byte[i];
        System.arraycopy(arrayOfByte, 0, this.kRy, 0, this.kRz);
      }
      System.arraycopy(paramArrayOfByte, 0, this.kRy, this.kRz, paramInt);
      this.kRv.c(this.kRy, i, false);
      this.kRz = 0;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        ad.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.kRz) });
        this.kRv.c(this.kRy, this.kRz, paramBoolean);
        this.kRz = 0;
      }
      AppMethodBeat.o(146344);
      return;
      if (paramArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.kRy, this.kRz, paramInt);
        this.kRz = i;
        ad.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.kRz) });
      }
    }
  }
  
  public void flush() {}
  
  public boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public final void r(double paramDouble)
  {
    AppMethodBeat.i(146343);
    this.kRx = ((int)(1024.0D * paramDouble));
    ad.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.kRx) });
    this.kRy = new byte[this.kRx];
    AppMethodBeat.o(146343);
  }
  
  public final void ti(int paramInt)
  {
    AppMethodBeat.i(146342);
    ad.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.kRw) });
    this.kRw = paramInt;
    AppMethodBeat.o(146342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.c
 * JD-Core Version:    0.7.0.1
 */