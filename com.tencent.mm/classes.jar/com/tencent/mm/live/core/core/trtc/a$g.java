package com.tencent.mm.live.core.core.trtc;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
public final class a$g
  extends u
  implements b<SurfaceTexture, ah>
{
  public a$g(a parama)
  {
    super(1);
  }
  
  private static final void a(a parama, SurfaceTexture paramSurfaceTexture)
  {
    int j = 0;
    AppMethodBeat.i(248212);
    s.u(parama, "this$0");
    int k = a.d(parama);
    Object localObject1 = parama.mRu;
    Object localObject2;
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      localObject2 = parama.mRA;
      if (localObject2 == null)
      {
        bool = false;
        ((com.tencent.mm.media.widget.a.f)localObject1).a(paramSurfaceTexture, bool, k);
      }
    }
    else
    {
      paramSurfaceTexture = parama.mRu;
      if ((paramSurfaceTexture == null) || (paramSurfaceTexture.bsD() != true)) {
        break label222;
      }
      i = 1;
      label77:
      if (i == 0) {
        break label248;
      }
      Log.i("MicroMsg.LiveCore", "start preview success, mirrorMode:" + parama.mRs.bgA() + " resolution:" + k);
      paramSurfaceTexture = a.a.bfr().bfq();
      localObject1 = parama.mRu;
      if (localObject1 != null) {
        break label227;
      }
      i = j;
      label138:
      paramSurfaceTexture.cameraId = i;
      localObject1 = parama.mRs;
      paramSurfaceTexture = parama.mRu;
      if (paramSurfaceTexture != null) {
        break label238;
      }
    }
    label222:
    label227:
    label238:
    for (paramSurfaceTexture = null;; paramSurfaceTexture = paramSurfaceTexture.btc())
    {
      s.checkNotNull(paramSurfaceTexture);
      ((com.tencent.mm.live.core.b.d)localObject1).a(paramSurfaceTexture);
      parama.mRs.setOnDrawListener((b)new a(parama));
      AppMethodBeat.o(248212);
      return;
      localObject2 = ((h)localObject2).mNB;
      if (localObject2 == null)
      {
        bool = false;
        break;
      }
      bool = ((com.tencent.mm.live.core.core.model.f)localObject2).mNk;
      break;
      i = 0;
      break label77;
      i = ((com.tencent.mm.media.widget.a.f)localObject1).btf();
      break label138;
    }
    label248:
    Log.i("MicroMsg.LiveCore", "start preview fail");
    AppMethodBeat.o(248212);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<com.tencent.mm.media.g.d, ah>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.g
 * JD-Core Version:    0.7.0.1
 */