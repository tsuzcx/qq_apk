package com.tencent.mm.plugin.comm;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.ui.a.b;

public class PluginComm
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.comm.a.a
{
  private com.tencent.mm.sdk.b.c oCV;
  
  public PluginComm()
  {
    AppMethodBeat.i(151478);
    this.oCV = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(151478);
  }
  
  public static boolean isVoipStarted()
  {
    AppMethodBeat.i(151483);
    xh localxh = new xh();
    localxh.dAb.dgL = 2;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    boolean bool = localxh.dAc.dAd;
    AppMethodBeat.o(151483);
    return bool;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151479);
    if (paramg.ahL()) {
      com.tencent.mm.vfs.o.a("wallet_images", "wallet/images", 52428800L, 7);
    }
    AppMethodBeat.o(151479);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(151480);
    if (paramg.ahL())
    {
      pin(com.tencent.mm.plugin.a.aNI());
      pin(com.tencent.mm.plugin.g.a.bUj());
      pin(com.tencent.mm.plugin.h.a.bXx());
      pin(d.cTG());
      pin(com.tencent.mm.plugin.image.c.cTF());
      pin(com.tencent.mm.plugin.u.a.doE());
      pin(com.tencent.mm.plugin.n.b.dcg());
      pin(com.tencent.mm.plugin.c.a.aRW());
      pin(com.tencent.mm.plugin.s.a.dnt());
      pin(com.tencent.mm.pluginsdk.h.a.c.o.DlR);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.n.a.a.class, new com.tencent.mm.plugin.n.a());
      ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(com.tencent.mm.plugin.g.a.bUj());
      com.tencent.mm.ui.f.a.a.a(new com.tencent.mm.ui.f.a.b()
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
    com.tencent.mm.sdk.b.a.GpY.c(this.oCV);
    AppMethodBeat.o(151481);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151482);
    com.tencent.mm.sdk.b.a.GpY.d(this.oCV);
    AppMethodBeat.o(151482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.PluginComm
 * JD-Core Version:    0.7.0.1
 */