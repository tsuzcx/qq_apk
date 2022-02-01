package com.tencent.mm.plugin.flutter.voip.d;

import android.graphics.SurfaceTexture;
import android.util.Size;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipSurfaceTexture;", "Landroidx/lifecycle/LifecycleOwner;", "st", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;)V", "TAG", "", "lifeCycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "localTextureRenderSizeChanged", "Lkotlin/Function1;", "Landroid/util/Size;", "", "getLocalTextureRenderSizeChanged", "()Lkotlin/jvm/functions/Function1;", "setLocalTextureRenderSizeChanged", "(Lkotlin/jvm/functions/Function1;)V", "mSurfaceTextureEventCallback", "Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipSurfaceTexture$ISurfaceTextureEventCallback;", "size", "Landroidx/lifecycle/MutableLiveData;", "getSt", "()Landroid/graphics/SurfaceTexture;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "onSurfaceTextureDestroy", "onSurfaceTextureSizeChanged", "width", "", "height", "setSurfaceTextureEventListener", "listener", "ISurfaceTextureEventCallback", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements q
{
  public final SurfaceTexture HnK;
  private a HnL;
  public b<? super Size, ah> HnM;
  private final androidx.lifecycle.s HnN;
  private x<Size> HnO;
  private final String TAG;
  
  public a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(263307);
    this.HnK = paramSurfaceTexture;
    this.TAG = kotlin.g.b.s.X("MicorMsg.FlutterVoipSurfaceTexture@", Integer.valueOf(hashCode()));
    this.HnN = new androidx.lifecycle.s((q)this);
    this.HnO = new x();
    this.HnO.a((q)this, new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(263307);
  }
  
  private static final void a(a parama, Size paramSize)
  {
    AppMethodBeat.i(263315);
    kotlin.g.b.s.u(parama, "this$0");
    if (paramSize != null)
    {
      parama = parama.HnL;
      if (parama != null) {
        parama.iR(paramSize.getWidth(), paramSize.getHeight());
      }
    }
    AppMethodBeat.o(263315);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(263331);
    kotlin.g.b.s.u(parama, "listener");
    this.HnL = parama;
    parama = this.HnL;
    if (parama != null) {
      parama.n(this.HnK);
    }
    this.HnN.e(j.b.bHj);
    AppMethodBeat.o(263331);
  }
  
  public final void fwh()
  {
    AppMethodBeat.i(263339);
    a locala = this.HnL;
    if (locala != null) {
      locala.fwh();
    }
    AppMethodBeat.o(263339);
  }
  
  public final j getLifecycle()
  {
    return (j)this.HnN;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipSurfaceTexture$ISurfaceTextureEventCallback;", "", "onSurfaceTextureDestroy", "", "onSurfaceTextureReady", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureSizeChanged", "width", "", "height", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void fwh();
    
    public abstract void iR(int paramInt1, int paramInt2);
    
    public abstract void n(SurfaceTexture paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.d.a
 * JD-Core Version:    0.7.0.1
 */