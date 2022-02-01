package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Arrays;

public final class g
  implements a
{
  private int height;
  private String pYH;
  private long uMn;
  private long uMo;
  private int width;
  
  public g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104655);
    this.uMn = 0L;
    this.pYH = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.uMo = paramLong;
    ae.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(104655);
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104657);
    if ((this.uMn != 0L) && (!bu.cF(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.uMo;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.uMn, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        ae.e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(104657);
        return false;
      }
      AppMethodBeat.o(104657);
      return true;
    }
    ae.i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(104657);
    return false;
  }
  
  public final boolean ddN()
  {
    AppMethodBeat.i(104658);
    if (this.uMn != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishGifEncode(this.uMn);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ae.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104658);
        return false;
      }
      ae.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bu.isNullOrNil(this.pYH))
      {
        o.f(this.pYH, arrayOfByte, arrayOfByte.length);
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
    this.uMn = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.uMo);
    if (this.uMn == 0L)
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(852, 11);
      ae.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", new Object[] { Long.valueOf(this.uMn) });
      AppMethodBeat.o(104656);
      return false;
    }
    ae.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.uMn) });
    AppMethodBeat.o(104656);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.g
 * JD-Core Version:    0.7.0.1
 */