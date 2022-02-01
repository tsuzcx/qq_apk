package com.tencent.mm.live.core.core.trtc;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.d;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$n
  extends u
  implements b<SurfaceTexture, ah>
{
  a$n(a parama)
  {
    super(1);
  }
  
  private static final void a(a parama, SurfaceTexture paramSurfaceTexture)
  {
    int i = 1080;
    int j = 0;
    AppMethodBeat.i(248256);
    s.u(parama, "this$0");
    Object localObject1 = parama.mRu;
    Object localObject2;
    boolean bool;
    if (localObject1 != null)
    {
      localObject2 = parama.mRA;
      if (localObject2 == null)
      {
        bool = false;
        localObject2 = parama.mRA;
        if (localObject2 != null) {
          break label180;
        }
        label53:
        ((com.tencent.mm.media.widget.a.f)localObject1).a(paramSurfaceTexture, bool, i);
      }
    }
    else
    {
      paramSurfaceTexture = parama.mRu;
      if ((paramSurfaceTexture == null) || (paramSurfaceTexture.bsD() != true)) {
        break label201;
      }
      i = 1;
      label85:
      if (i == 0) {
        break label226;
      }
      Log.i("MicroMsg.LiveCore", "start preview success");
      localObject1 = parama.mRs;
      paramSurfaceTexture = parama.mRu;
      if (paramSurfaceTexture != null) {
        break label206;
      }
      paramSurfaceTexture = null;
      label113:
      s.checkNotNull(paramSurfaceTexture);
      ((d)localObject1).a(paramSurfaceTexture);
      paramSurfaceTexture = a.a.bfr().bfq();
      parama = parama.mRu;
      if (parama != null) {
        break label216;
      }
    }
    label180:
    label201:
    label206:
    label216:
    for (i = j;; i = parama.btf())
    {
      paramSurfaceTexture.cameraId = i;
      AppMethodBeat.o(248256);
      return;
      localObject2 = ((h)localObject2).mNB;
      if (localObject2 == null)
      {
        bool = false;
        break;
      }
      bool = ((com.tencent.mm.live.core.core.model.f)localObject2).mNk;
      break;
      localObject2 = ((h)localObject2).mNB;
      if (localObject2 == null) {
        break label53;
      }
      i = ((com.tencent.mm.live.core.core.model.f)localObject2).mNl;
      break label53;
      i = 0;
      break label85;
      paramSurfaceTexture = paramSurfaceTexture.btc();
      break label113;
    }
    label226:
    Log.i("MicroMsg.LiveCore", "start preview fail");
    AppMethodBeat.o(248256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.n
 * JD-Core Version:    0.7.0.1
 */