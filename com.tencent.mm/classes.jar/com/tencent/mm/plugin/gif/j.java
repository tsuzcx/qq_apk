package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Arrays;

public final class j
  implements a
{
  private int height;
  private String rpE;
  private int width;
  private long yeH;
  private long yeI;
  private int yeT;
  
  public j(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(104683);
    this.yeH = 0L;
    this.yeT = -1;
    this.rpE = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.yeI = paramLong;
    this.yeT = 20;
    Log.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(20), paramString });
    AppMethodBeat.o(104683);
  }
  
  public final boolean d(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(104685);
    if ((this.yeH != 0L) && (!Util.isNullOrNil(paramArrayOfByte)) && (paramArrayOfByte.length == this.width * this.height * 4))
    {
      long l = this.yeI;
      if (paramLong >= 0L) {
        l = paramLong;
      }
      int i = MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.yeH, this.width, this.height, paramArrayOfByte, l);
      if (i < 0)
      {
        Log.e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(104685);
        return false;
      }
      AppMethodBeat.o(104685);
      return true;
    }
    Log.i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
    AppMethodBeat.o(104685);
    return false;
  }
  
  public final boolean dXw()
  {
    AppMethodBeat.i(104686);
    if (this.yeH != 0L)
    {
      byte[] arrayOfByte = MMWXGFJNI.nativeFinishWxAMEncode(this.yeH);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        Log.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", new Object[] { Arrays.toString(arrayOfByte) });
        AppMethodBeat.o(104686);
        return false;
      }
      Log.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      if (!Util.isNullOrNil(this.rpE))
      {
        s.f(this.rpE, arrayOfByte, arrayOfByte.length);
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
    this.yeH = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.yeI, this.yeT);
    if (this.yeH == 0L)
    {
      h.CyF.dN(852, 12);
      Log.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", new Object[] { Long.valueOf(this.yeH) });
      AppMethodBeat.o(104684);
      return false;
    }
    Log.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", new Object[] { Long.valueOf(this.yeH) });
    AppMethodBeat.o(104684);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.j
 * JD-Core Version:    0.7.0.1
 */