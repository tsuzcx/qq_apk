package com.tencent.mm.live.core.core.trtc;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
public final class a$t
  extends u
  implements kotlin.g.a.b<SurfaceTexture, ah>
{
  public a$t(a parama, String paramString)
  {
    super(1);
  }
  
  private static final void a(a parama, SurfaceTexture paramSurfaceTexture, String paramString)
  {
    AppMethodBeat.i(248226);
    s.u(parama, "this$0");
    com.tencent.thumbplayer.g.b localb = a.j(parama);
    if (localb != null) {
      localb.setSurface(new Surface(paramSurfaceTexture));
    }
    paramSurfaceTexture = a.j(parama);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.prepareAsync();
    }
    paramSurfaceTexture = a.j(parama);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setOnPreparedListener(new a.t..ExternalSyntheticLambda0(parama, paramString));
    }
    AppMethodBeat.o(248226);
  }
  
  private static final void a(a parama, String paramString, ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(248219);
    s.u(parama, "this$0");
    paramITPPlayer = a.j(parama);
    if (paramITPPlayer != null) {
      paramITPPlayer.start();
    }
    Log.i("MicroMsg.LiveCore", "startPushLocalVideo success");
    paramITPPlayer = parama.mRs;
    com.tencent.mm.media.widget.a.b localb = com.tencent.mm.media.widget.a.b.nGj;
    com.tencent.mm.plugin.sight.base.b localb1 = f.aVX(paramString);
    if (localb1 == null)
    {
      paramString = null;
      if (paramString != null) {
        break label168;
      }
      paramString = a.j(parama);
      if (paramString != null) {
        break label160;
      }
      i = 0;
      label69:
      com.tencent.mm.media.widget.a.b.uj(i);
      if (localb1 != null) {
        break label176;
      }
      paramString = null;
      label80:
      if (paramString != null) {
        break label196;
      }
      paramString = a.j(parama);
      if (paramString != null) {
        break label188;
      }
      i = 0;
      label95:
      com.tencent.mm.media.widget.a.b.uk(i);
      if (localb1 != null) {
        break label204;
      }
    }
    label160:
    label168:
    label176:
    label188:
    label196:
    label204:
    for (int i = 0;; i = localb1.hYK)
    {
      com.tencent.mm.media.widget.a.b.ul(i);
      com.tencent.mm.media.widget.a.b.setFrontCamera(false);
      paramString = ah.aiuX;
      paramITPPlayer.a(localb);
      parama.mRs.setOnDrawListener((kotlin.g.a.b)new a(parama));
      AppMethodBeat.o(248219);
      return;
      paramString = Integer.valueOf(localb1.height);
      break;
      i = paramString.getVideoHeight();
      break label69;
      i = paramString.intValue();
      break label69;
      paramString = Integer.valueOf(localb1.width);
      break label80;
      i = paramString.getVideoWidth();
      break label95;
      i = paramString.intValue();
      break label95;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.g.d, ah>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.t
 * JD-Core Version:    0.7.0.1
 */