package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.mm.sdk.platformtools.y;

public class b
  implements c
{
  String gOt = "audio/mp4a-latm";
  String gOu = "audio/mpeg";
  c.a gOv = null;
  int gOw = 0;
  int gOx = 0;
  byte[] gOy;
  int gOz = 0;
  
  public final void a(c.a parama)
  {
    this.gOv = parama;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return false;
  }
  
  public void close() {}
  
  public final void d(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (this.gOv == null) {
      y.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
    }
    for (;;)
    {
      return;
      if (this.gOx == 0.0D)
      {
        y.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
        return;
      }
      if (paramInt > this.gOx) {
        y.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.gOx) });
      }
      y.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[] { Integer.valueOf(this.gOz), Integer.valueOf(paramInt) });
      int i = this.gOz + paramInt;
      if ((i >= this.gOx) && (paramArrayOfByte != null))
      {
        y.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[] { Integer.valueOf(i) });
        if (i > this.gOy.length)
        {
          y.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[] { Integer.valueOf(i) });
          byte[] arrayOfByte = this.gOy;
          this.gOy = new byte[i];
          System.arraycopy(arrayOfByte, 0, this.gOy, 0, this.gOz);
        }
        System.arraycopy(paramArrayOfByte, 0, this.gOy, this.gOz, paramInt);
        this.gOv.c(this.gOy, i, false);
        this.gOz = 0;
      }
      while (paramBoolean)
      {
        y.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[] { Integer.valueOf(this.gOz) });
        this.gOv.c(this.gOy, this.gOz, paramBoolean);
        this.gOz = 0;
        return;
        if (paramArrayOfByte != null)
        {
          System.arraycopy(paramArrayOfByte, 0, this.gOy, this.gOz, paramInt);
          this.gOz = i;
          y.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[] { Integer.valueOf(this.gOz) });
        }
      }
    }
  }
  
  public boolean f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public void flush() {}
  
  public final void lV(int paramInt)
  {
    y.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[] { Integer.valueOf(this.gOw) });
    this.gOw = paramInt;
  }
  
  public final void p(double paramDouble)
  {
    this.gOx = ((int)(1024.0D * paramDouble));
    y.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameKbSize:%b frameByteSize:%d", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(this.gOx) });
    this.gOy = new byte[this.gOx];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.b
 * JD-Core Version:    0.7.0.1
 */