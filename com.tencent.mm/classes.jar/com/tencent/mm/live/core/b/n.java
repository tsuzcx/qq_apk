package com.tencent.mm.live.core.b;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "onViewCreated", "Lkotlin/Function0;", "", "getOnViewCreated", "()Lkotlin/jvm/functions/Function0;", "setOnViewCreated", "(Lkotlin/jvm/functions/Function0;)V", "onViewSizeChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "getOnViewSizeChanged", "()Lkotlin/jvm/functions/Function2;", "setOnViewSizeChanged", "(Lkotlin/jvm/functions/Function2;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-core_release"})
public final class n
{
  public static final a ksJ;
  public SurfaceHolder aNC;
  public a<x> ksH;
  public m<? super Integer, ? super Integer, x> ksI;
  
  static
  {
    AppMethodBeat.i(199112);
    ksJ = new a((byte)0);
    AppMethodBeat.o(199112);
  }
  
  public n(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(199110);
    this.aNC = paramSurfaceHolder;
    paramSurfaceHolder = this.aNC;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.addCallback((SurfaceHolder.Callback)new SurfaceHolder.Callback()
      {
        public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(199237);
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceChanged width is " + paramAnonymousInt2 + " and height is " + paramAnonymousInt3);
          paramAnonymousSurfaceHolder = this.ksK.ksI;
          if (paramAnonymousSurfaceHolder != null)
          {
            paramAnonymousSurfaceHolder.invoke(Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
            AppMethodBeat.o(199237);
            return;
          }
          AppMethodBeat.o(199237);
        }
        
        public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(199235);
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceCreated");
          paramAnonymousSurfaceHolder = this.ksK.ksH;
          if (paramAnonymousSurfaceHolder != null)
          {
            paramAnonymousSurfaceHolder.invoke();
            AppMethodBeat.o(199235);
            return;
          }
          AppMethodBeat.o(199235);
        }
        
        public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(199233);
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceDestroyed");
          AppMethodBeat.o(199233);
        }
      });
      AppMethodBeat.o(199110);
      return;
    }
    AppMethodBeat.o(199110);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199119);
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if (!p.h(this.aNC, paramObject.aNC)) {}
      }
    }
    else
    {
      AppMethodBeat.o(199119);
      return true;
    }
    AppMethodBeat.o(199119);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199118);
    SurfaceHolder localSurfaceHolder = this.aNC;
    if (localSurfaceHolder != null)
    {
      int i = localSurfaceHolder.hashCode();
      AppMethodBeat.o(199118);
      return i;
    }
    AppMethodBeat.o(199118);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199115);
    String str = "RenderSurfaceHolder(surfaceHolder=" + this.aNC + ")";
    AppMethodBeat.o(199115);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.n
 * JD-Core Version:    0.7.0.1
 */