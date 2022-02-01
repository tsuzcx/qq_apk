package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class c
  implements d
{
  String lsT = "audio/mp4a-latm";
  String lsU = "audio/mpeg";
  d.a lsV = null;
  int lsW = 0;
  int lsX = 0;
  byte[] lsY;
  int lsZ = 0;
  
  public final void a(d.a parama)
  {
    this.lsV = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(146344);
    if (this.lsV == null)
    {
      ac.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (this.lsX == 0.0D)
    {
      ac.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
      AppMethodBeat.o(146344);
      return;
    }
    if (paramInt > this.lsX) {
      ac.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lsX) });
    }
    ac.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.lsZ), Integer.valueOf(paramInt) });
    int i = this.lsZ + paramInt;
    if ((i >= this.lsX) && (paramArrayOfByte != null))
    {
      ac.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
      if (i > this.lsY.length)
      {
        ac.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
        byte[] arrayOfByte = this.lsY;
        this.lsY = new byte[i];
        System.arraycopy(arrayOfByte, 0, this.lsY, 0, this.lsZ);
      }
      System.arraycopy(paramArrayOfByte, 0, this.lsY, this.lsZ, paramInt);
      this.lsV.c(this.lsY, i, false);
      this.lsZ = 0;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        ac.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.lsZ) });
        this.lsV.c(this.lsY, this.lsZ, paramBoolean);
        this.lsZ = 0;
      }
      AppMethodBeat.o(146344);
      return;
      if (paramArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.lsY, this.lsZ, paramInt);
        this.lsZ = i;
        ac.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.lsZ) });
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
    this.lsX = ((int)(1024.0D * paramDouble));
    ac.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.lsX) });
    this.lsY = new byte[this.lsX];
    AppMethodBeat.o(146343);
  }
  
  public final void tZ(int paramInt)
  {
    AppMethodBeat.i(146342);
    ac.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.lsW) });
    this.lsW = paramInt;
    AppMethodBeat.o(146342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.c
 * JD-Core Version:    0.7.0.1
 */