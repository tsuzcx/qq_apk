package com.tencent.mm.plugin.comm;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aao;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.k.a.c.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.vfs.ab;

public class PluginComm
  extends f
  implements i, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.comm.a.a
{
  private IListener ubt;
  
  public PluginComm()
  {
    AppMethodBeat.i(151478);
    this.ubt = new IListener() {};
    AppMethodBeat.o(151478);
  }
  
  public static boolean isVoipStarted()
  {
    AppMethodBeat.i(151483);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 2;
    EventCenter.instance.publish(localaaq);
    boolean bool = localaaq.fZN.calling;
    AppMethodBeat.o(151483);
    return bool;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151479);
    ab.aE("tinker", "tinker", 2050);
    ab.a("xlog", "xlog", 864000000L, 581);
    ab.a("xlogPrivate", "files/xlog", 864000000L, 2626);
    ab.a("wallet_images", "wallet/images", 52428800L, 7776000000L, 5);
    ab.aE("CheckResUpdate", "CheckResUpdate", 5);
    ab.a("share", "share", 259200000L, 101);
    ab.a("URLImageCache", "Cache", 134217728L, 7776000000L, 37);
    ab.a("GalleryDiskCache", "imgcache", 536870912L, 604800000L, 37);
    ab.a("VUserIcon", "vusericon", 16777216L, 7776000000L, 5);
    AppMethodBeat.o(151479);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151480);
    if (paramg.aIE())
    {
      pin(com.tencent.mm.plugin.g.bwf());
      pin(com.tencent.mm.plugin.i.a.cMn());
      pin(com.tencent.mm.plugin.l.a.cPO());
      pin(d.eIB());
      pin(com.tencent.mm.plugin.image.c.eIA());
      pin(com.tencent.mm.plugin.ae.a.foH());
      pin(com.tencent.mm.plugin.s.b.eRU());
      pin(com.tencent.mm.plugin.c.a.bBt());
      pin(com.tencent.mm.plugin.ab.a.fmr());
      pin(n.RaK);
      h.b(com.tencent.mm.plugin.s.a.a.class, new com.tencent.mm.plugin.s.a());
      ((com.tencent.mm.plugin.auth.a.c)h.ag(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(com.tencent.mm.plugin.i.a.cMn());
      com.tencent.mm.ui.h.a.a.a(new com.tencent.mm.ui.h.a.b()
      {
        public final void c(ImageView paramAnonymousImageView, String paramAnonymousString)
        {
          AppMethodBeat.i(151476);
          a.b.c(paramAnonymousImageView, paramAnonymousString);
          AppMethodBeat.o(151476);
        }
        
        public final void d(ImageView paramAnonymousImageView, String paramAnonymousString)
        {
          AppMethodBeat.i(169194);
          a.b.d(paramAnonymousImageView, paramAnonymousString);
          AppMethodBeat.o(169194);
        }
      });
    }
    AppMethodBeat.o(151480);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(151481);
    EventCenter.instance.addListener(this.ubt);
    h.aGY().a(302, this);
    com.tencent.mm.plugin.base.model.c.cxc();
    AppMethodBeat.o(151481);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151482);
    EventCenter.instance.removeListener(this.ubt);
    h.aGY().b(302, this);
    AppMethodBeat.o(151482);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(228412);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      com.tencent.mm.plugin.base.model.c.cxc();
    }
    AppMethodBeat.o(228412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.PluginComm
 * JD-Core Version:    0.7.0.1
 */