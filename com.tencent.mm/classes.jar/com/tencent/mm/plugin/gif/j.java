package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Arrays;

public final class j
  implements a
{
  private int height;
  private String pYH;
  private long uMn;
  private long uMo;
  private int uMv;
  private int width;
  
  public j(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104683);
    this.uMn = 0L;
    this.uMv = -1;
    this.pYH = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.uMo = paramLong;
    this.uMv = 20;
    ae.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(20), paramString });
    AppMethodBeat.o(104683);
  }
  
  public final boolean c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104685);
    if ((this.uMn != 0L) && (!bu.cF(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.uMo;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.uMn, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        ae.e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(104685);
        return false;
      }
      AppMethodBeat.o(104685);
      return true;
    }
    ae.i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(104685);
    return false;
  }
  
  public final boolean ddN()
  {
    AppMethodBeat.i(104686);
    if (this.uMn != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishWxAMEncode(this.uMn);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        ae.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104686);
        return false;
      }
      ae.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!bu.isNullOrNil(this.pYH))
      {
        o.f(this.pYH, arrayOfByte, arrayOfByte.length);
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
    this.uMn = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.uMo, this.uMv);
    if (this.uMn == 0L)
    {
      g.yxI.dD(852, 12);
      ae.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", new Object[] { Long.valueOf(this.uMn) });
      AppMethodBeat.o(104684);
      return false;
    }
    ae.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.uMn) });
    AppMethodBeat.o(104684);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.j
 * JD-Core Version:    0.7.0.1
 */