package com.tencent.mm.plugin.gif;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;

public final class g
  implements a
{
  private int height;
  private String jkO;
  private long lix = 0L;
  private long liy;
  private int width;
  
  public g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.jkO = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.liy = paramLong;
    y.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString });
  }
  
  public final boolean baL()
  {
    if (this.lix != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishGifEncode(this.lix);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        y.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        return false;
      }
      y.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
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
      int i = MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.lix, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        y.e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        return false;
      }
      return true;
    }
    y.i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    return false;
  }
  
  public final boolean init()
  {
    this.lix = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.liy);
    if (this.lix == 0L)
    {
      h.nFQ.h(852L, 11L, 1L);
      y.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", new Object[] { Long.valueOf(this.lix) });
      return false;
    }
    y.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.lix) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.g
 * JD-Core Version:    0.7.0.1
 */