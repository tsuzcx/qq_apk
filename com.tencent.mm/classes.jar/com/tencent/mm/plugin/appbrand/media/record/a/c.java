package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class c
  implements d
{
  int ckZ = 0;
  String iqf = "audio/mp4a-latm";
  String iqg = "audio/mpeg";
  d.a iqh = null;
  int iqi = 0;
  byte[] iqj;
  int iqk = 0;
  
  public final void a(d.a parama)
  {
    this.iqh = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void f(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(105651);
    if (this.iqh == null)
    {
      ab.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
      AppMethodBeat.o(105651);
      return;
    }
    if (this.iqi == 0.0D)
    {
      ab.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
      AppMethodBeat.o(105651);
      return;
    }
    if (paramInt > this.iqi) {
      ab.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.iqi) });
    }
    ab.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.iqk), Integer.valueOf(paramInt) });
    int i = this.iqk + paramInt;
    if ((i >= this.iqi) && (paramArrayOfByte != null))
    {
      ab.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
      if (i > this.iqj.length)
      {
        ab.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
        byte[] arrayOfByte = this.iqj;
        this.iqj = new byte[i];
        System.arraycopy(arrayOfByte, 0, this.iqj, 0, this.iqk);
      }
      System.arraycopy(paramArrayOfByte, 0, this.iqj, this.iqk, paramInt);
      this.iqh.d(this.iqj, i, false);
      this.iqk = 0;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        ab.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.iqk) });
        this.iqh.d(this.iqj, this.iqk, paramBoolean);
        this.iqk = 0;
      }
      AppMethodBeat.o(105651);
      return;
      if (paramArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte, 0, this.iqj, this.iqk, paramInt);
        this.iqk = i;
        ab.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.iqk) });
      }
    }
  }
  
  public void flush() {}
  
  public boolean h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public final void oT(int paramInt)
  {
    AppMethodBeat.i(105649);
    ab.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.ckZ) });
    this.ckZ = paramInt;
    AppMethodBeat.o(105649);
  }
  
  public final void s(double paramDouble)
  {
    AppMethodBeat.i(105650);
    this.iqi = ((int)(1024.0D * paramDouble));
    ab.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.iqi) });
    this.iqj = new byte[this.iqi];
    AppMethodBeat.o(105650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.c
 * JD-Core Version:    0.7.0.1
 */