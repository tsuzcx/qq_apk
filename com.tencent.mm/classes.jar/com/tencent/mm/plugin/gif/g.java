package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Arrays;

public final class g
  implements a
{
  private long Jhx;
  private long Jhy;
  private int height;
  private String outputPath;
  private int width;
  
  public g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104655);
    this.Jhx = 0L;
    this.outputPath = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.Jhy = paramLong;
    Log.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(104655);
  }
  
  public final boolean e(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104657);
    if ((this.Jhx != 0L) && (!Util.isNullOrNil(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.Jhy;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.Jhx, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        Log.e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(104657);
        return false;
      }
      AppMethodBeat.o(104657);
      return true;
    }
    Log.i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(104657);
    return false;
  }
  
  public final boolean fIZ()
  {
    AppMethodBeat.i(104658);
    if (this.Jhx != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishGifEncode(this.Jhx);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        Log.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104658);
        return false;
      }
      Log.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!Util.isNullOrNil(this.outputPath))
      {
        y.f(this.outputPath, arrayOfByte, arrayOfByte.length);
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
    this.Jhx = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.Jhy);
    if (this.Jhx == 0L)
    {
      h.OAn.kJ(852, 11);
      Log.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", new Object[] { Long.valueOf(this.Jhx) });
      AppMethodBeat.o(104656);
      return false;
    }
    Log.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.Jhx) });
    AppMethodBeat.o(104656);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.g
 * JD-Core Version:    0.7.0.1
 */