package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Arrays;

public final class g
  implements a
{
  private int height;
  private String rpE;
  private int width;
  private long yeH;
  private long yeI;
  
  public g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104655);
    this.yeH = 0L;
    this.rpE = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.yeI = paramLong;
    Log.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(104655);
  }
  
  public final boolean d(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104657);
    if ((this.yeH != 0L) && (!Util.isNullOrNil(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.yeI;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.yeH, this.width, this.height, paramArrayOfByte, l);
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
  
  public final boolean dXw()
  {
    AppMethodBeat.i(104658);
    if (this.yeH != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishGifEncode(this.yeH);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        Log.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104658);
        return false;
      }
      Log.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!Util.isNullOrNil(this.rpE))
      {
        s.f(this.rpE, arrayOfByte, arrayOfByte.length);
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
    this.yeH = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.yeI);
    if (this.yeH == 0L)
    {
      h.CyF.dN(852, 11);
      Log.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", new Object[] { Long.valueOf(this.yeH) });
      AppMethodBeat.o(104656);
      return false;
    }
    Log.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.yeH) });
    AppMethodBeat.o(104656);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.g
 * JD-Core Version:    0.7.0.1
 */