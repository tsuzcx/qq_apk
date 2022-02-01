package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class c
  implements d
{
  String lSc = "audio/mp4a-latm";
  String lSd = "audio/mpeg";
  d.a lSe = null;
  int lSf = 0;
  int lSg = 0;
  byte[] lSh;
  int lSi = 0;
  
  public final void a(d.a parama)
  {
    this.lSe = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146344);
    if (this.lSe == null)
    {
      ad.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (this.lSg == 0.0D)
    {
      ad.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (paramInt > this.lSg) {
      ad.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lSg) });
    }
    ad.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.lSi), Integer.valueOf(paramInt) });
    int i = this.lSi + paramInt;
    if ((i >= this.lSg) && (paramArrayOfByte != null))
    {
      ad.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
      if (i > this.lSh.length)
      {
        ad.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
        byte[] arrayOfByte = this.lSh;
        this.lSh = new byte[i];
        System.arraycopy(arrayOfByte, 0, this.lSh, 0, this.lSi);
      }
      System.arraycopy(paramArrayOfByte, 0, this.lSh, this.lSi, paramInt);
      this.lSe.c(this.lSh, i, false);
      this.lSi = 0;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        ad.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.lSi) });
        this.lSe.c(this.lSh, this.lSi, paramBoolean);
        this.lSi = 0;
      }
      AppMethodBeat.o(146344);
      return;
      if (paramArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.lSh, this.lSi, paramInt);
        this.lSi = i;
        ad.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.lSi) });
      }
    }
  }
  
  public void flush() {}
  
  public boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(146343);
    this.lSg = ((int)(1024.0D * paramDouble));
    ad.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.lSg) });
    this.lSh = new byte[this.lSg];
    AppMethodBeat.o(146343);
  }
  
  public final void uD(int paramInt)
  {
    AppMethodBeat.i(146342);
    ad.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.lSf) });
    this.lSf = paramInt;
    AppMethodBeat.o(146342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.c
 * JD-Core Version:    0.7.0.1
 */