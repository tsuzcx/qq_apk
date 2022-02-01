package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Arrays;

public final class j
  implements a
{
  private int height;
  private String oLh;
  private long sqf;
  private long sqg;
  private int sqo;
  private int width;
  
  public j(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104683);
    this.sqf = 0L;
    this.sqo = -1;
    this.oLh = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.sqg = paramLong;
    this.sqo = 20;
    ad.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(20), paramString });
    AppMethodBeat.o(104683);
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104685);
    if ((this.sqf != 0L) && (!bt.cw(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.sqg;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.sqf, this.width, this.height, paramArrayOfByte, l);
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
  
  public final boolean cEG()
  {
    AppMethodBeat.i(104686);
    if (this.sqf != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishWxAMEncode(this.sqf);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ad.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104686);
        return false;
      }
      ad.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bt.isNullOrNil(this.oLh))
      {
        i.f(this.oLh, arrayOfByte, arrayOfByte.length);
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
    this.sqf = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.sqg, this.sqo);
    if (this.sqf == 0L)
    {
      h.vKh.dB(852, 12);
      ad.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", new Object[] { Long.valueOf(this.sqf) });
      AppMethodBeat.o(104684);
      return false;
    }
    ad.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.sqf) });
    AppMethodBeat.o(104684);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.j
 * JD-Core Version:    0.7.0.1
 */