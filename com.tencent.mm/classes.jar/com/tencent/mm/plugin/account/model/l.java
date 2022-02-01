package com.tencent.mm.plugin.account.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.pluginsdk.g.j;
import com.tencent.mm.pluginsdk.h.a.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class l
  implements aw
{
  private static au bYO = null;
  private static int hZs;
  public static a iOt = a.iOy;
  private a iOs;
  private p iOu;
  private c iOv;
  
  static
  {
    hZs = 0;
  }
  
  public l()
  {
    AppMethodBeat.i(127858);
    this.iOu = new l.3(this);
    this.iOv = new c() {};
    AppMethodBeat.o(127858);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127861);
    iOt = parama;
    switch (l.5.jsc[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127861);
      return;
      hZs = 0;
      if (bYO == null) {
        bYO = new au(new l.2(), true);
      }
      ac.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      bYO.au(900000L, 900000L);
      AppMethodBeat.o(127861);
      return;
      if (bYO != null) {
        bYO.stopTimer();
      }
      ac.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      iOt = a.iOy;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
      hZs = 0;
      bYO = null;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(127860);
    this.iOs = new a();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.iOu);
    this.iOv.alive();
    b.eLH();
    b.WB(43);
    ((k)g.ab(k.class)).awB().a(j.Has);
    h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210371);
        j.fdj();
        j.fdk();
        AppMethodBeat.o(210371);
      }
    });
    AppMethodBeat.o(127860);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127859);
    a locala = this.iOs;
    com.tencent.mm.sdk.b.a.GpY.d(locala.iOd);
    this.iOs = null;
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.iOu);
    this.iOv.dead();
    ((k)g.ab(k.class)).awB().b(j.Has);
    AppMethodBeat.o(127859);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(127857);
      iOy = new a("NONE", 0);
      iOz = new a("SENT", 1);
      iOA = new a("VERIFIED", 2);
      iOB = new a[] { iOy, iOz, iOA };
      AppMethodBeat.o(127857);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l
 * JD-Core Version:    0.7.0.1
 */