package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class j
  implements a
{
  private int height;
  private String lup;
  private long nFS;
  private long nFT;
  private int nFZ;
  private int width;
  
  public j(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(62448);
    this.nFS = 0L;
    this.nFZ = -1;
    this.lup = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.nFT = paramLong;
    this.nFZ = 20;
    ab.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(20), paramString });
    AppMethodBeat.o(62448);
  }
  
  public final boolean bHJ()
  {
    AppMethodBeat.i(62451);
    if (this.nFS != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishWxAMEncode(this.nFS);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ab.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(62451);
        return false;
      }
      ab.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bo.isNullOrNil(this.lup))
      {
        FileOp.q(this.lup, arrayOfByte);
        AppMethodBeat.o(62451);
        return true;
      }
    }
    AppMethodBeat.o(62451);
    return false;
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(62450);
    if ((this.nFS != 0L) && (!bo.ce(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.nFT;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.nFS, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        ab.e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(62450);
        return false;
      }
      AppMethodBeat.o(62450);
      return true;
    }
    ab.i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(62450);
    return false;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(62449);
    this.nFS = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.nFT, this.nFZ);
    if (this.nFS == 0L)
    {
      h.qsU.cT(852, 12);
      ab.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", new Object[] { Long.valueOf(this.nFS) });
      AppMethodBeat.o(62449);
      return false;
    }
    ab.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.nFS) });
    AppMethodBeat.o(62449);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.j
 * JD-Core Version:    0.7.0.1
 */