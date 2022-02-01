package com.tencent.mm.live.core.b;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "onViewCreated", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "", "getOnViewCreated", "()Lkotlin/jvm/functions/Function2;", "setOnViewCreated", "(Lkotlin/jvm/functions/Function2;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-core_release"})
public final class j
{
  public static final a qUq;
  public SurfaceHolder aSS;
  public m<? super Integer, ? super Integer, y> qUp;
  
  static
  {
    AppMethodBeat.i(205799);
    qUq = new a((byte)0);
    AppMethodBeat.o(205799);
  }
  
  public j(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(205798);
    this.aSS = paramSurfaceHolder;
    paramSurfaceHolder = this.aSS;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.addCallback((SurfaceHolder.Callback)new SurfaceHolder.Callback()
      {
        public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(205797);
          ad.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceChanged width is " + paramAnonymousInt2 + " and height is " + paramAnonymousInt3);
          paramAnonymousSurfaceHolder = this.qUs.qUp;
          if (paramAnonymousSurfaceHolder != null)
          {
            paramAnonymousSurfaceHolder.n(Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
            AppMethodBeat.o(205797);
            return;
          }
          AppMethodBeat.o(205797);
        }
        
        public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(205796);
          ad.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceCreated");
          AppMethodBeat.o(205796);
        }
        
        public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(205795);
          ad.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceDestroyed");
          AppMethodBeat.o(205795);
        }
      });
      AppMethodBeat.o(205798);
      return;
    }
    AppMethodBeat.o(205798);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205802);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if (!k.g(this.aSS, paramObject.aSS)) {}
      }
    }
    else
    {
      AppMethodBeat.o(205802);
      return true;
    }
    AppMethodBeat.o(205802);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205801);
    SurfaceHolder localSurfaceHolder = this.aSS;
    if (localSurfaceHolder != null)
    {
      int i = localSurfaceHolder.hashCode();
      AppMethodBeat.o(205801);
      return i;
    }
    AppMethodBeat.o(205801);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205800);
    String str = "RenderSurfaceHolder(surfaceHolder=" + this.aSS + ")";
    AppMethodBeat.o(205800);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.j
 * JD-Core Version:    0.7.0.1
 */