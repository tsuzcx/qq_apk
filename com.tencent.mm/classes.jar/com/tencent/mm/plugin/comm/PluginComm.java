package com.tencent.mm.plugin.comm;

import android.widget.ImageView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.acl;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.vfs.af;

public class PluginComm
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.am.h, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.comm.a.b
{
  private IListener xeK;
  
  public PluginComm()
  {
    AppMethodBeat.i(151478);
    this.xeK = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(151478);
  }
  
  public static boolean isVoipStarted()
  {
    AppMethodBeat.i(151483);
    acn localacn = new acn();
    localacn.ifU.hId = 2;
    localacn.publish();
    boolean bool = localacn.ifV.calling;
    AppMethodBeat.o(151483);
    return bool;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(151479);
    af.aR("tinker", "tinker", 2050);
    af.a("xlog", "xlog", 864000000L, 581);
    af.a("xlogPrivate", "files/xlog", 864000000L, 2626);
    af.b("wallet_images", "wallet/images", 52428800L, 7776000000L, 5);
    af.aR("CheckResUpdate", "CheckResUpdate", 5);
    af.a("share", "share", 259200000L, 101);
    af.b("URLImageCache", "Cache", 134217728L, 7776000000L, 37);
    af.b("GalleryDiskCache", "imgcache", 536870912L, 604800000L, 37);
    af.b("VUserIcon", "vusericon", 16777216L, 7776000000L, 5);
    AppMethodBeat.o(151479);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(151480);
    if (paramg.bbA())
    {
      pin(com.tencent.mm.plugin.n.bUY());
      pin(com.tencent.mm.plugin.i.a.dpR());
      pin(com.tencent.mm.plugin.l.a.dul());
      pin(d.fQC());
      pin(com.tencent.mm.plugin.image.c.fQB());
      pin(com.tencent.mm.plugin.af.a.gzK());
      pin(com.tencent.mm.plugin.r.b.gaD());
      pin(com.tencent.mm.plugin.c.a.caJ());
      pin(com.tencent.mm.plugin.openapi.a.gxf());
      pin(com.tencent.mm.pluginsdk.res.downloader.model.n.XWP);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.r.a.a.class, new com.tencent.mm.plugin.r.a());
      ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(com.tencent.mm.plugin.i.a.dpR());
      com.tencent.mm.ui.i.a.a.a(new com.tencent.mm.ui.i.a.b()
      {
        public final void g(ImageView paramAnonymousImageView, String paramAnonymousString)
        {
          AppMethodBeat.i(151476);
          a.b.g(paramAnonymousImageView, paramAnonymousString);
          AppMethodBeat.o(151476);
        }
        
        public final void h(ImageView paramAnonymousImageView, String paramAnonymousString)
        {
          AppMethodBeat.i(169194);
          a.b.h(paramAnonymousImageView, paramAnonymousString);
          AppMethodBeat.o(169194);
        }
      });
    }
    AppMethodBeat.o(151480);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(151481);
    this.xeK.alive();
    com.tencent.mm.kernel.h.aZW().a(302, this);
    com.tencent.mm.plugin.base.model.c.cZN();
    AppMethodBeat.o(151481);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151482);
    this.xeK.dead();
    com.tencent.mm.kernel.h.aZW().b(302, this);
    AppMethodBeat.o(151482);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(260513);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.base.model.c.cZN();
      com.tencent.mm.ce.b.Kn(true);
    }
    AppMethodBeat.o(260513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.PluginComm
 * JD-Core Version:    0.7.0.1
 */