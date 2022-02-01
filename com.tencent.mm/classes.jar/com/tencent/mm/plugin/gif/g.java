package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Arrays;

public final class g
  implements a
{
  private int height;
  private String poB;
  private long txY;
  private long txZ;
  private int width;
  
  public g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104655);
    this.txY = 0L;
    this.poB = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.txZ = paramLong;
    ac.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(104655);
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104657);
    if ((this.txY != 0L) && (!bs.cv(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.txZ;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.txY, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        ac.e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(104657);
        return false;
      }
      AppMethodBeat.o(104657);
      return true;
    }
    ac.i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(104657);
    return false;
  }
  
  public final boolean cRQ()
  {
    AppMethodBeat.i(104658);
    if (this.txY != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishGifEncode(this.txY);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ac.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104658);
        return false;
      }
      ac.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bs.isNullOrNil(this.poB))
      {
        i.f(this.poB, arrayOfByte, arrayOfByte.length);
        AppMethodBeat.o(104658);
        return true;
      }
    }
    AppMethodBeat.o(104658);
    return false;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(104656);
    this.txY = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.txZ);
    if (this.txY == 0L)
    {
      h.wUl.dB(852, 11);
      ac.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", new Object[] { Long.valueOf(this.txY) });
      AppMethodBeat.o(104656);
      return false;
    }
    ac.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.txY) });
    AppMethodBeat.o(104656);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.g
 * JD-Core Version:    0.7.0.1
 */