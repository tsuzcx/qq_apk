package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;

public class j
  implements at
{
  private static ap bAz = null;
  private static int fWf;
  public static j.a gAT = j.a.gAY;
  private a gAS;
  private o gAU;
  private c gAV;
  
  static
  {
    fWf = 0;
  }
  
  public j()
  {
    AppMethodBeat.i(124706);
    this.gAU = new j.2(this);
    this.gAV = new j.3(this);
    AppMethodBeat.o(124706);
  }
  
  public static void a(j.a parama)
  {
    AppMethodBeat.i(124709);
    gAT = parama;
    switch (j.4.gAX[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124709);
      return;
      fWf = 0;
      if (bAz == null) {
        bAz = new ap(new j.1(), true);
      }
      ab.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      bAz.ag(900000L, 900000L);
      AppMethodBeat.o(124709);
      return;
      if (bAz != null) {
        bAz.stopTimer();
      }
      ab.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      gAT = j.a.gAY;
      ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
      fWf = 0;
      bAz = null;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(124708);
    this.gAS = new a();
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.gAU);
    this.gAV.alive();
    b.c.dmg();
    b.LE(43);
    AppMethodBeat.o(124708);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(124707);
    a locala = this.gAS;
    com.tencent.mm.sdk.b.a.ymk.d(locala.gAC);
    this.gAS = null;
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.gAU);
    this.gAV.dead();
    AppMethodBeat.o(124707);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.j
 * JD-Core Version:    0.7.0.1
 */