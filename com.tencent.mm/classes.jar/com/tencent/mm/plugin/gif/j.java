package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Arrays;

public final class j
  implements a
{
  private int height;
  private String pSc;
  private long uAI;
  private long uAJ;
  private int uAQ;
  private int width;
  
  public j(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104683);
    this.uAI = 0L;
    this.uAQ = -1;
    this.pSc = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.uAJ = paramLong;
    this.uAQ = 20;
    ad.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(20), paramString });
    AppMethodBeat.o(104683);
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104685);
    if ((this.uAI != 0L) && (!bt.cC(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.uAJ;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.uAI, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        ad.e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(104685);
        return false;
      }
      AppMethodBeat.o(104685);
      return true;
    }
    ad.i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(104685);
    return false;
  }
  
  public final boolean daW()
  {
    AppMethodBeat.i(104686);
    if (this.uAI != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishWxAMEncode(this.uAI);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ad.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104686);
        return false;
      }
      ad.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bt.isNullOrNil(this.pSc))
      {
        i.f(this.pSc, arrayOfByte, arrayOfByte.length);
        AppMethodBeat.o(104686);
        return true;
      }
    }
    AppMethodBeat.o(104686);
    return false;
  }
  
  public final boolean init()
  {
    AppMethodBeat.i(104684);
    this.uAI = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.uAJ, this.uAQ);
    if (this.uAI == 0L)
    {
      g.yhR.dD(852, 12);
      ad.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", new Object[] { Long.valueOf(this.uAI) });
      AppMethodBeat.o(104684);
      return false;
    }
    ad.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.uAI) });
    AppMethodBeat.o(104684);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.j
 * JD-Core Version:    0.7.0.1
 */