package com.tencent.mm.live.core.b;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "onViewCreated", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "", "getOnViewCreated", "()Lkotlin/jvm/functions/Function2;", "setOnViewCreated", "(Lkotlin/jvm/functions/Function2;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-core_release"})
public final class j
{
  public static final j.a gOB;
  public SurfaceHolder bee;
  public m<? super Integer, ? super Integer, z> gOA;
  
  static
  {
    AppMethodBeat.i(197007);
    gOB = new j.a((byte)0);
    AppMethodBeat.o(197007);
  }
  
  public j(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(197006);
    this.bee = paramSurfaceHolder;
    paramSurfaceHolder = this.bee;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.addCallback((SurfaceHolder.Callback)new SurfaceHolder.Callback()
      {
        public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(197005);
          ae.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceChanged width is " + paramAnonymousInt2 + " and height is " + paramAnonymousInt3);
          paramAnonymousSurfaceHolder = this.gOC.gOA;
          if (paramAnonymousSurfaceHolder != null)
          {
            paramAnonymousSurfaceHolder.p(Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
            AppMethodBeat.o(197005);
            return;
          }
          AppMethodBeat.o(197005);
        }
        
        public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(197004);
          ae.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceCreated");
          AppMethodBeat.o(197004);
        }
        
        public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(197003);
          ae.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceDestroyed");
          AppMethodBeat.o(197003);
        }
      });
      AppMethodBeat.o(197006);
      return;
    }
    AppMethodBeat.o(197006);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197010);
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
      AppMethodBeat.o(197010);
      return true;
    }
    AppMethodBeat.o(197010);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197009);
    SurfaceHolder localSurfaceHolder = this.bee;
    if (localSurfaceHolder != null)
    {
      int i = localSurfaceHolder.hashCode();
      AppMethodBeat.o(197009);
      return i;
    }
    AppMethodBeat.o(197009);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197008);
    String str = "RenderSurfaceHolder(surfaceHolder=" + this.bee + ")";
    AppMethodBeat.o(197008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.j
 * JD-Core Version:    0.7.0.1
 */