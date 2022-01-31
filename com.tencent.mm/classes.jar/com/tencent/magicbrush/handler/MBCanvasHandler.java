package com.tencent.magicbrush.handler;

import android.graphics.Bitmap;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.c.g;
import com.tencent.magicbrush.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MBCanvasHandler
{
  public final long mNativeInst;
  public final MBRuntime mbRuntime;
  
  public MBCanvasHandler(MBRuntime paramMBRuntime, long paramLong)
  {
    this.mbRuntime = paramMBRuntime;
    this.mNativeInst = paramLong;
  }
  
  private int[] s(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115894);
    if (paramBoolean)
    {
      localObject = this.mbRuntime.getCanvasSize(paramInt);
      AppMethodBeat.o(115894);
      return localObject;
    }
    Object localObject = this.mbRuntime.getJsThreadHandler();
    if (localObject == null)
    {
      AppMethodBeat.o(115894);
      return null;
    }
    localObject = (int[])((MBJsThreadHandler)localObject).a(new MBCanvasHandler.2(this, paramInt));
    AppMethodBeat.o(115894);
    return localObject;
  }
  
  public final Bitmap a(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(115893);
    g localg = this.mbRuntime.getMBRuntimeView();
    if (localg == null)
    {
      c.c.i("MicroMsg.MBCanvasHandler", "MBRuntimeView is null.", new Object[0]);
      AppMethodBeat.o(115893);
      return null;
    }
    paramBitmap = (Bitmap)c.b(new MBCanvasHandler.1(this, localg, s(this.mbRuntime.getScreenCanvasId(), paramBoolean), paramBitmap));
    AppMethodBeat.o(115893);
    return paramBitmap;
  }
  
  public native Bitmap nativeCaptureCanvas(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MBCanvasHandler
 * JD-Core Version:    0.7.0.1
 */