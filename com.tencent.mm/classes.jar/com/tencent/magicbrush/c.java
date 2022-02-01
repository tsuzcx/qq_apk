package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MBExternalSurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "texId", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "(ILcom/tencent/magicbrush/MBRuntime;)V", "matrix", "", "getTexId", "()I", "destroy", "", "getMatrix", "getTransformMatrix", "mtx", "Companion", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class c
  extends SurfaceTexture
{
  public static final c.a eGM;
  
  static
  {
    AppMethodBeat.i(228829);
    eGM = new c.a((byte)0);
    AppMethodBeat.o(228829);
  }
  
  public final void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(228834);
    s.t(paramArrayOfFloat, "mtx");
    super.getTransformMatrix(paramArrayOfFloat);
    s.r(Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length), "java.util.Arrays.copyOf(this, size)");
    AppMethodBeat.o(228834);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.c
 * JD-Core Version:    0.7.0.1
 */