package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Arrays;

public final class j
  implements a
{
  private int height;
  private String poB;
  private long txY;
  private long txZ;
  private int tyg;
  private int width;
  
  public j(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104683);
    this.txY = 0L;
    this.tyg = -1;
    this.poB = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.txZ = paramLong;
    this.tyg = 20;
    ac.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(20), paramString });
    AppMethodBeat.o(104683);
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104685);
    if ((this.txY != 0L) && (!bs.cv(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.txZ;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.txY, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        ac.e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(104685);
        return false;
      }
      AppMethodBeat.o(104685);
      return true;
    }
    ac.i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(104685);
    return false;
  }
  
  public final boolean cRQ()
  {
    AppMethodBeat.i(104686);
    if (this.txY != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishWxAMEncode(this.txY);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ac.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104686);
        return false;
      }
      ac.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bs.isNullOrNil(this.poB))
      {
        i.f(this.poB, arrayOfByte, arrayOfByte.length);
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
    this.txY = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.txZ, this.tyg);
    if (this.txY == 0L)
    {
      h.wUl.dB(852, 12);
      ac.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", new Object[] { Long.valueOf(this.txY) });
      AppMethodBeat.o(104684);
      return false;
    }
    ac.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.txY) });
    AppMethodBeat.o(104684);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.j
 * JD-Core Version:    0.7.0.1
 */