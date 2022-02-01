package com.tencent.mm.live.core.b;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "onViewCreated", "Lkotlin/Function0;", "", "getOnViewCreated", "()Lkotlin/jvm/functions/Function0;", "setOnViewCreated", "(Lkotlin/jvm/functions/Function0;)V", "onViewSizeChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "getOnViewSizeChanged", "()Lkotlin/jvm/functions/Function2;", "setOnViewSizeChanged", "(Lkotlin/jvm/functions/Function2;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k.a mWy;
  public SurfaceHolder cHy;
  public m<? super Integer, ? super Integer, ah> mWA;
  public a<ah> mWz;
  
  static
  {
    AppMethodBeat.i(247694);
    mWy = new k.a((byte)0);
    AppMethodBeat.o(247694);
  }
  
  public k(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(247679);
    this.cHy = paramSurfaceHolder;
    paramSurfaceHolder = this.cHy;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.addCallback((SurfaceHolder.Callback)new SurfaceHolder.Callback()
      {
        public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(247686);
          s.u(paramAnonymousSurfaceHolder, "holder");
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceChanged width is " + paramAnonymousInt2 + " and height is " + paramAnonymousInt3);
          paramAnonymousSurfaceHolder = this.mWB.mWA;
          if (paramAnonymousSurfaceHolder != null) {
            paramAnonymousSurfaceHolder.invoke(Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3));
          }
          AppMethodBeat.o(247686);
        }
        
        public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(247674);
          s.u(paramAnonymousSurfaceHolder, "holder");
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceCreated");
          paramAnonymousSurfaceHolder = this.mWB.mWz;
          if (paramAnonymousSurfaceHolder != null) {
            paramAnonymousSurfaceHolder.invoke();
          }
          AppMethodBeat.o(247674);
        }
        
        public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(247664);
          s.u(paramAnonymousSurfaceHolder, "holder");
          Log.i("MicroMsg.RenderSurfaceHolder", "RenderSurfaceHolder has been surfaceDestroyed");
          AppMethodBeat.o(247664);
        }
      });
    }
    AppMethodBeat.o(247679);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247712);
    if (this == paramObject)
    {
      AppMethodBeat.o(247712);
      return true;
    }
    if (!(paramObject instanceof k))
    {
      AppMethodBeat.o(247712);
      return false;
    }
    paramObject = (k)paramObject;
    if (!s.p(this.cHy, paramObject.cHy))
    {
      AppMethodBeat.o(247712);
      return false;
    }
    AppMethodBeat.o(247712);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247707);
    if (this.cHy == null)
    {
      AppMethodBeat.o(247707);
      return 0;
    }
    int i = this.cHy.hashCode();
    AppMethodBeat.o(247707);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247701);
    String str = "RenderSurfaceHolder(surfaceHolder=" + this.cHy + ')';
    AppMethodBeat.o(247701);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.k
 * JD-Core Version:    0.7.0.1
 */