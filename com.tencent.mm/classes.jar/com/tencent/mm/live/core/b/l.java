package com.tencent.mm.live.core.b;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "onViewCreated", "Lkotlin/Function0;", "", "getOnViewCreated", "()Lkotlin/jvm/functions/Function0;", "setOnViewCreated", "(Lkotlin/jvm/functions/Function0;)V", "onViewSizeChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "getOnViewSizeChanged", "()Lkotlin/jvm/functions/Function2;", "setOnViewSizeChanged", "(Lkotlin/jvm/functions/Function2;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-core_release"})
public final class l
{
  public static final a hEE;
  public SurfaceHolder beb;
  public a<x> hEC;
  public m<? super Integer, ? super Integer, x> hED;
  
  static
  {
    AppMethodBeat.i(196695);
    hEE = new a((byte)0);
    AppMethodBeat.o(196695);
  }
  
  public l(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(196694);
    this.beb = paramSurfaceHolder;
    paramSurfaceHolder = this.beb;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.addCallback((SurfaceHolder.Callback)new SurfaceHolder.Callback()
      {
        public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(196693);
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceChanged width is " + paramAnonymousInt2 + " and height is " + paramAnonymousInt3);
          paramAnonymousSurfaceHolder = this.hEF.hED;
          if (paramAnonymousSurfaceHolder != null)
          {
            paramAnonymousSurfaceHolder.invoke(Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
            AppMethodBeat.o(196693);
            return;
          }
          AppMethodBeat.o(196693);
        }
        
        public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(196692);
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceCreated");
          paramAnonymousSurfaceHolder = this.hEF.hEC;
          if (paramAnonymousSurfaceHolder != null)
          {
            paramAnonymousSurfaceHolder.invoke();
            AppMethodBeat.o(196692);
            return;
          }
          AppMethodBeat.o(196692);
        }
        
        public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(196691);
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceDestroyed");
          AppMethodBeat.o(196691);
        }
      });
      AppMethodBeat.o(196694);
      return;
    }
    AppMethodBeat.o(196694);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196698);
    if (this != paramObject)
    {
      if ((paramObject instanceof l))
      {
        paramObject = (l)paramObject;
        if (!p.j(this.beb, paramObject.beb)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196698);
      return true;
    }
    AppMethodBeat.o(196698);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196697);
    SurfaceHolder localSurfaceHolder = this.beb;
    if (localSurfaceHolder != null)
    {
      int i = localSurfaceHolder.hashCode();
      AppMethodBeat.o(196697);
      return i;
    }
    AppMethodBeat.o(196697);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196696);
    String str = "RenderSurfaceHolder(surfaceHolder=" + this.beb + ")";
    AppMethodBeat.o(196696);
    return str;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.b.l
 * JD-Core Version:    0.7.0.1
 */