package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Arrays;

public final class g
  implements a
{
  private int height;
  private String oLh;
  private long sqf;
  private long sqg;
  private int width;
  
  public g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104655);
    this.sqf = 0L;
    this.oLh = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.sqg = paramLong;
    ad.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(104655);
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104657);
    if ((this.sqf != 0L) && (!bt.cw(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.sqg;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.sqf, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        ad.e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(104657);
        return false;
      }
      AppMethodBeat.o(104657);
      return true;
    }
    ad.i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(104657);
    return false;
  }
  
  public final boolean cEG()
  {
    AppMethodBeat.i(104658);
    if (this.sqf != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishGifEncode(this.sqf);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ad.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104658);
        return false;
      }
      ad.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bt.isNullOrNil(this.oLh))
      {
        i.f(this.oLh, arrayOfByte, arrayOfByte.length);
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
    this.sqf = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.sqg);
    if (this.sqf == 0L)
    {
      h.vKh.dB(852, 11);
      ad.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", new Object[] { Long.valueOf(this.sqf) });
      AppMethodBeat.o(104656);
      return false;
    }
    ad.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.sqf) });
    AppMethodBeat.o(104656);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.g
 * JD-Core Version:    0.7.0.1
 */