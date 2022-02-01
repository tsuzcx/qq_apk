package com.tencent.mm.plugin.comm;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.zh;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.j.a.c.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.vfs.y;

public class PluginComm
  extends f
  implements i, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.comm.a.a
{
  private IListener qCu;
  
  public PluginComm()
  {
    AppMethodBeat.i(151478);
    this.qCu = new IListener() {};
    AppMethodBeat.o(151478);
  }
  
  public static boolean isVoipStarted()
  {
    AppMethodBeat.i(151483);
    zj localzj = new zj();
    localzj.efx.dKy = 2;
    EventCenter.instance.publish(localzj);
    boolean bool = localzj.efy.calling;
    AppMethodBeat.o(151483);
    return bool;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151479);
    y.b("xlog", "xlog", 864000000L, 583);
    y.a("wallet_images", "wallet/images", 52428800L, 7);
    y.at("CheckResUpdate", "CheckResUpdate", 7);
    y.b("share", "share", 259200000L, 103);
    y.a("URLImageCache", "Cache", 134217728L, 39);
    y.a("VUserIcon", "vusericon", 16777216L, 7);
    AppMethodBeat.o(151479);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151480);
    if (paramg.aBb())
    {
      pin(com.tencent.mm.plugin.a.blX());
      pin(com.tencent.mm.plugin.g.a.cxS());
      pin(com.tencent.mm.plugin.h.a.cBk());
      pin(d.dZE());
      pin(com.tencent.mm.plugin.image.c.dZD());
      pin(com.tencent.mm.plugin.u.a.eCP());
      pin(com.tencent.mm.plugin.m.b.eip());
      pin(com.tencent.mm.plugin.c.a.bqE());
      pin(com.tencent.mm.plugin.r.a.eAN());
      pin(o.Kah);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.m.a.a.class, new com.tencent.mm.plugin.m.a());
      ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(com.tencent.mm.plugin.g.a.cxS());
      com.tencent.mm.ui.g.a.a.a(new com.tencent.mm.ui.g.a.b()
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
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151481);
    EventCenter.instance.addListener(this.qCu);
    com.tencent.mm.kernel.g.azz().a(302, this);
    com.tencent.mm.plugin.base.model.c.cjL();
    AppMethodBeat.o(151481);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151482);
    EventCenter.instance.removeListener(this.qCu);
    com.tencent.mm.kernel.g.azz().b(302, this);
    AppMethodBeat.o(151482);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(223696);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      com.tencent.mm.plugin.base.model.c.cjL();
    }
    AppMethodBeat.o(223696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.PluginComm
 * JD-Core Version:    0.7.0.1
 */