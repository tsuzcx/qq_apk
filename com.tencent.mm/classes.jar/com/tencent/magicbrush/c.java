package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/MBExternalSurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "texId", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "(ILcom/tencent/magicbrush/MBRuntime;)V", "matrix", "", "getTexId", "()I", "destroy", "", "getMatrix", "getTransformMatrix", "mtx", "Companion", "lib-magicbrush-nano_release"})
public final class c
  extends SurfaceTexture
{
  public static final a cLs;
  
  static
  {
    AppMethodBeat.i(203985);
    cLs = new a((byte)0);
    AppMethodBeat.o(203985);
  }
  
  public final void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(203982);
    p.k(paramArrayOfFloat, "mtx");
    super.getTransformMatrix(paramArrayOfFloat);
    p.j(Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length), "java.util.Arrays.copyOf(this, size)");
    AppMethodBeat.o(203982);
    throw null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/MBExternalSurfaceTexture$Companion;", "", "()V", "TAG", "", "lib-magicbrush-nano_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.c
 * JD-Core Version:    0.7.0.1
 */