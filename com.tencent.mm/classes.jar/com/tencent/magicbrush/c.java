package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MBExternalSurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "texId", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "(ILcom/tencent/magicbrush/MBRuntime;)V", "matrix", "", "getTexId", "()I", "destroy", "", "getMatrix", "getTransformMatrix", "mtx", "Companion", "lib-magicbrush-nano_release"})
public final class c
  extends SurfaceTexture
{
  public static final a cKK;
  private float[] cKH;
  private final int cKI;
  private final MBRuntime cKJ;
  
  static
  {
    AppMethodBeat.i(206819);
    cKK = new a((byte)0);
    AppMethodBeat.o(206819);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(206818);
    setOnFrameAvailableListener(null);
    this.cKJ.nativeDestroyExternalTexture(this.cKJ.mNativeInst, this.cKI);
    AppMethodBeat.o(206818);
  }
  
  public final void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206817);
    p.h(paramArrayOfFloat, "mtx");
    super.getTransformMatrix(paramArrayOfFloat);
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    p.g(paramArrayOfFloat, "java.util.Arrays.copyOf(this, size)");
    this.cKH = paramArrayOfFloat;
    AppMethodBeat.o(206817);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/magicbrush/MBExternalSurfaceTexture$Companion;", "", "()V", "TAG", "", "lib-magicbrush-nano_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.c
 * JD-Core Version:    0.7.0.1
 */