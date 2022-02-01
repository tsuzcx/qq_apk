package com.tencent.mm.live.core.b;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "onViewCreated", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "", "getOnViewCreated", "()Lkotlin/jvm/functions/Function2;", "setOnViewCreated", "(Lkotlin/jvm/functions/Function2;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-core_release"})
public final class j
{
  public static final a gsk;
  public SurfaceHolder aTK;
  public m<? super Integer, ? super Integer, y> gsj;
  
  static
  {
    AppMethodBeat.i(209337);
    gsk = new a((byte)0);
    AppMethodBeat.o(209337);
  }
  
  public j(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(209336);
    this.aTK = paramSurfaceHolder;
    paramSurfaceHolder = this.aTK;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.addCallback((SurfaceHolder.Callback)new SurfaceHolder.Callback()
      {
        public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(209335);
          ac.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceChanged width is " + paramAnonymousInt2 + " and height is " + paramAnonymousInt3);
          paramAnonymousSurfaceHolder = this.gsl.gsj;
          if (paramAnonymousSurfaceHolder != null)
          {
            paramAnonymousSurfaceHolder.n(Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
            AppMethodBeat.o(209335);
            return;
          }
          AppMethodBeat.o(209335);
        }
        
        public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(209334);
          ac.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceCreated");
          AppMethodBeat.o(209334);
        }
        
        public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(209333);
          ac.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceDestroyed");
          AppMethodBeat.o(209333);
        }
      });
      AppMethodBeat.o(209336);
      return;
    }
    AppMethodBeat.o(209336);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(209340);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if (!k.g(this.aTK, paramObject.aTK)) {}
      }
    }
    else
    {
      AppMethodBeat.o(209340);
      return true;
    }
    AppMethodBeat.o(209340);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(209339);
    SurfaceHolder localSurfaceHolder = this.aTK;
    if (localSurfaceHolder != null)
    {
      int i = localSurfaceHolder.hashCode();
      AppMethodBeat.o(209339);
      return i;
    }
    AppMethodBeat.o(209339);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209338);
    String str = "RenderSurfaceHolder(surfaceHolder=" + this.aTK + ")";
    AppMethodBeat.o(209338);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.b.j
 * JD-Core Version:    0.7.0.1
 */