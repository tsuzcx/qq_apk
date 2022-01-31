package com.tencent.mm.plugin.gif;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;

public final class j
  implements a
{
  private int height;
  private String jkO;
  private int liE = -1;
  private long lix = 0L;
  private long liy;
  private int width;
  
  public j(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.jkO = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.liy = paramLong;
    this.liE = 20;
    y.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(20), paramString });
  }
  
  public final boolean baL()
  {
    if (this.lix != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishWxAMEncode(this.lix);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        y.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        return false;
      }
      y.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bk.bl(this.jkO))
      {
        FileOp.k(this.jkO, arrayOfByte);
        return true;
      }
    }
    return false;
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    if ((this.lix != 0L) && (!bk.bE(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.liy;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.lix, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        y.e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        return false;
      }
      return true;
    }
    y.i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    return false;
  }
  
  public final boolean init()
  {
    this.lix = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.liy, this.liE);
    if (this.lix == 0L)
    {
      h.nFQ.h(852L, 12L, 1L);
      y.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", new Object[] { Long.valueOf(this.lix) });
      return false;
    }
    y.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.lix) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.j
 * JD-Core Version:    0.7.0.1
 */