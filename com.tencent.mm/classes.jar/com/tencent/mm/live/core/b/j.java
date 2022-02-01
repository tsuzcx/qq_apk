package com.tencent.mm.live.core.b;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "onViewCreated", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "", "getOnViewCreated", "()Lkotlin/jvm/functions/Function2;", "setOnViewCreated", "(Lkotlin/jvm/functions/Function2;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-core_release"})
public final class j
{
  public static final j.a gLS;
  public SurfaceHolder bee;
  public m<? super Integer, ? super Integer, z> gLR;
  
  static
  {
    AppMethodBeat.i(216995);
    gLS = new j.a((byte)0);
    AppMethodBeat.o(216995);
  }
  
  public j(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(216994);
    this.bee = paramSurfaceHolder;
    paramSurfaceHolder = this.bee;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.addCallback((SurfaceHolder.Callback)new SurfaceHolder.Callback()
      {
        public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(216993);
          ad.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceChanged width is " + paramAnonymousInt2 + " and height is " + paramAnonymousInt3);
          paramAnonymousSurfaceHolder = this.gLT.gLR;
          if (paramAnonymousSurfaceHolder != null)
          {
            paramAnonymousSurfaceHolder.p(Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
            AppMethodBeat.o(216993);
            return;
          }
          AppMethodBeat.o(216993);
        }
        
        public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(216992);
          ad.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceCreated");
          AppMethodBeat.o(216992);
        }
        
        public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(216991);
          ad.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceDestroyed");
          AppMethodBeat.o(216991);
        }
      });
      AppMethodBeat.o(216994);
      return;
    }
    AppMethodBeat.o(216994);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216998);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if (!p.i(this.bee, paramObject.bee)) {}
      }
    }
    else
    {
      AppMethodBeat.o(216998);
      return true;
    }
    AppMethodBeat.o(216998);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(216997);
    SurfaceHolder localSurfaceHolder = this.bee;
    if (localSurfaceHolder != null)
    {
      int i = localSurfaceHolder.hashCode();
      AppMethodBeat.o(216997);
      return i;
    }
    AppMethodBeat.o(216997);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216996);
    String str = "RenderSurfaceHolder(surfaceHolder=" + this.bee + ")";
    AppMethodBeat.o(216996);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.j
 * JD-Core Version:    0.7.0.1
 */