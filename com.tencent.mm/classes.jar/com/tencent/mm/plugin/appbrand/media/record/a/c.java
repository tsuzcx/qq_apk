package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class c
  implements d
{
  String lWD = "audio/mp4a-latm";
  String lWE = "audio/mpeg";
  d.a lWF = null;
  int lWG = 0;
  int lWH = 0;
  byte[] lWI;
  int lWJ = 0;
  
  public final void a(d.a parama)
  {
    this.lWF = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146344);
    if (this.lWF == null)
    {
      ae.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (this.lWH == 0.0D)
    {
      ae.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (paramInt > this.lWH) {
      ae.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lWH) });
    }
    ae.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.lWJ), Integer.valueOf(paramInt) });
    int i = this.lWJ + paramInt;
    if ((i >= this.lWH) && (paramArrayOfByte != null))
    {
      ae.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
      if (i > this.lWI.length)
      {
        ae.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
        byte[] arrayOfByte = this.lWI;
        this.lWI = new byte[i];
        System.arraycopy(arrayOfByte, 0, this.lWI, 0, this.lWJ);
      }
      System.arraycopy(paramArrayOfByte, 0, this.lWI, this.lWJ, paramInt);
      this.lWF.c(this.lWI, i, false);
      this.lWJ = 0;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        ae.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.lWJ) });
        this.lWF.c(this.lWI, this.lWJ, paramBoolean);
        this.lWJ = 0;
      }
      AppMethodBeat.o(146344);
      return;
      if (paramArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.lWI, this.lWJ, paramInt);
        this.lWJ = i;
        ae.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.lWJ) });
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
    this.lWH = ((int)(1024.0D * paramDouble));
    ae.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.lWH) });
    this.lWI = new byte[this.lWH];
    AppMethodBeat.o(146343);
  }
  
  public final void uJ(int paramInt)
  {
    AppMethodBeat.i(146342);
    ae.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.lWG) });
    this.lWG = paramInt;
    AppMethodBeat.o(146342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.c
 * JD-Core Version:    0.7.0.1
 */