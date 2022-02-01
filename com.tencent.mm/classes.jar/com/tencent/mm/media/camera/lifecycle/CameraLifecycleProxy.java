package com.tencent.mm.media.camera.lifecycle;

import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/lifecycle/CameraLifecycleProxy;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleEventObserver;", "cameraKit", "Lcom/tencent/mm/media/camera/ICameraKit;", "(Lcom/tencent/mm/media/camera/ICameraKit;)V", "getCameraKit", "()Lcom/tencent/mm/media/camera/ICameraKit;", "setCameraKit", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "attachLifeCycleOwner", "", "owner", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CameraLifecycleProxy
  implements o, q
{
  public static final CameraLifecycleProxy.a nvs;
  private g nvt;
  public final androidx.lifecycle.s nvu;
  
  static
  {
    AppMethodBeat.i(237289);
    nvs = new CameraLifecycleProxy.a((byte)0);
    AppMethodBeat.o(237289);
  }
  
  public CameraLifecycleProxy(g paramg)
  {
    AppMethodBeat.i(237275);
    this.nvt = paramg;
    this.nvu = new androidx.lifecycle.s((q)this);
    AppMethodBeat.o(237275);
  }
  
  public final j getLifecycle()
  {
    return (j)this.nvu;
  }
  
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(237311);
    kotlin.g.b.s.u(paramq, "source");
    kotlin.g.b.s.u(parama, "event");
    Log.i("MicroMsg.Camera.CameraLifecycleProxy", kotlin.g.b.s.X("onStateChanged:", parama));
    this.nvu.a(parama);
    if (b.$EnumSwitchMapping$0[parama.ordinal()] == 1) {
      this.nvt.onDestroy();
    }
    AppMethodBeat.o(237311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.lifecycle.CameraLifecycleProxy
 * JD-Core Version:    0.7.0.1
 */