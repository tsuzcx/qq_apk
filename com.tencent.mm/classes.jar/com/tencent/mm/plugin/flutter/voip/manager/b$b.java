package com.tencent.mm.plugin.flutter.voip.manager;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.voip.d.a.a;
import com.tencent.mm.plugin.voip.video.render.g;
import com.tencent.mm.plugin.voip.video.render.j;
import com.tencent.mm.plugin.voip.video.render.o;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/voip/manager/FlutterVoipMgr$addRenderSurfaceTexture$1$1", "Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipSurfaceTexture$ISurfaceTextureEventCallback;", "onSurfaceTextureDestroy", "", "onSurfaceTextureReady", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureSizeChanged", "width", "", "height", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
  implements a.a
{
  b$b(b paramb, g paramg, int paramInt, j paramj) {}
  
  public final void fwh()
  {
    AppMethodBeat.i(263530);
    Log.w("MicroMsg.FlutterVoipMgr", "onSurfaceTextureDestroy");
    Object localObject = this.HnC;
    g localg = this.HnB;
    int i = this.mWi;
    s.u(localg, "renderGLSurface");
    o localo = ((j)localObject).UTl;
    if (localo != null) {
      localo.c(localg, i);
    }
    localObject = ((j)localObject).UTl;
    if (localObject != null) {
      ((o)localObject).a(localg);
    }
    AppMethodBeat.o(263530);
  }
  
  public final void iR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263524);
    Log.i("MicroMsg.FlutterVoipMgr", "onSurfaceTextureSizeChanged: width=" + paramInt1 + ", height=" + paramInt2);
    Object localObject = this.HnC;
    g localg = this.HnB;
    int i = this.mWi;
    s.u(localg, "renderGLSurface");
    localg.mO(paramInt1, paramInt2);
    o localo = ((j)localObject).UTl;
    if (localo != null) {
      localo.a(localg, i);
    }
    localObject = ((j)localObject).UTl;
    if (localObject != null) {
      ((o)localObject).idi();
    }
    AppMethodBeat.o(263524);
  }
  
  public final void n(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(263517);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.FlutterVoipMgr", s.X("onSurfaceTextureReady: ", paramSurfaceTexture));
    b.c(this.HnA).d(this.HnB, this.mWi);
    AppMethodBeat.o(263517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.manager.b.b
 * JD-Core Version:    0.7.0.1
 */