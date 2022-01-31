package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class g
  implements a
{
  private int height;
  private String lup;
  private long nFS;
  private long nFT;
  private int width;
  
  public g(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(62421);
    this.nFS = 0L;
    this.lup = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.nFT = paramLong;
    ab.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(62421);
  }
  
  public final boolean bHJ()
  {
    AppMethodBeat.i(62424);
    if (this.nFS != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishGifEncode(this.nFS);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ab.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(62424);
        return false;
      }
      ab.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bo.isNullOrNil(this.lup))
      {
        FileOp.q(this.lup, arrayOfByte);
        AppMethodBeat.o(62424);
        return true;
      }
    }
    AppMethodBeat.o(62424);
    return false;
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(62423);
    if ((this.nFS != 0L) && (!bo.ce(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.nFT;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.nFS, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        ab.e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(62423);
        return false;
      }
      AppMethodBeat.o(62423);
      return true;
    }
    ab.i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(62423);
    return false;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(62422);
    this.nFS = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.nFT);
    if (this.nFS == 0L)
    {
      h.qsU.cT(852, 11);
      ab.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", new Object[] { Long.valueOf(this.nFS) });
      AppMethodBeat.o(62422);
      return false;
    }
    ab.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.nFS) });
    AppMethodBeat.o(62422);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.g
 * JD-Core Version:    0.7.0.1
 */