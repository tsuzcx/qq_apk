package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.h.d;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.bk.a;
import com.tencent.mm.f.a.cc;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.hw;
import com.tencent.mm.f.a.kw;
import com.tencent.mm.f.a.mn;
import com.tencent.mm.f.a.mp;
import com.tencent.mm.f.a.tt;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.e;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;

public class n
  implements be
{
  private static o.a appForegroundListener;
  private c Ekb;
  private a Ekc;
  private b Ekd;
  private a.a Eke;
  private int Ekf;
  private e Ekg;
  private e Ekh;
  private q Eki;
  private r Ekj;
  private k Ekk;
  private o Ekl;
  private d Ekm;
  private m Ekn;
  private l Eko;
  private com.tencent.mm.an.i Ekp;
  private IListener Ekq;
  private IListener Ekr;
  private IListener Eks;
  private IListener Ekt;
  private ck.a Eku;
  
  static
  {
    AppMethodBeat.i(55749);
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(55729);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            paramAnonymousString = new tt();
            paramAnonymousString.fTc.active = false;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(55729);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(55728);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            paramAnonymousString = new tt();
            paramAnonymousString.fTc.active = true;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(55728);
      }
    };
    AppMethodBeat.o(55749);
  }
  
  public n()
  {
    AppMethodBeat.i(55736);
    this.Ekb = new c((byte)0);
    this.Ekc = new a((byte)0);
    this.Ekd = new b((byte)0);
    this.Ekf = 0;
    this.Ekg = new b();
    this.Ekh = new p();
    this.Eki = null;
    this.Ekj = null;
    this.Ekk = null;
    this.Ekl = null;
    this.Ekm = new d();
    this.Ekn = null;
    this.Eko = null;
    this.Ekp = new n.1(this);
    this.Ekq = new IListener() {};
    this.Ekr = new IListener() {};
    this.Eks = new IListener() {};
    this.Ekt = new IListener() {};
    this.Eku = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(55732);
        new p().b(paramAnonymousa);
        AppMethodBeat.o(55732);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    AppMethodBeat.o(55736);
  }
  
  public static void D(long paramLong, String paramString)
  {
    AppMethodBeat.i(55748);
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(paramLong);
    if (localca.erm())
    {
      localca.Jo(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(paramLong, localca);
    }
    AppMethodBeat.o(55748);
  }
  
  public static void aK(ca paramca)
  {
    AppMethodBeat.i(55744);
    if ((paramca != null) && (paramca.field_msgId != 0L))
    {
      ca.b localb = ca.b.bxa(paramca.field_content);
      paramca = new x((float)localb.Ejo, (float)localb.Ejn, paramca.field_msgId);
      h.aGY().a(paramca, 0);
    }
    AppMethodBeat.o(55744);
  }
  
  private static n eMf()
  {
    AppMethodBeat.i(55737);
    n localn = (n)y.as(n.class);
    AppMethodBeat.o(55737);
    return localn;
  }
  
  public static a.a eMg()
  {
    AppMethodBeat.i(55738);
    h.aHE().aGH();
    if (eMf().Eke == null) {
      eMf().Eke = new a.a();
    }
    a.a locala = eMf().Eke;
    AppMethodBeat.o(55738);
    return locala;
  }
  
  public static m eMh()
  {
    AppMethodBeat.i(55739);
    h.aHE().aGH();
    if (eMf().Ekn == null) {
      eMf().Ekn = new m();
    }
    m localm = eMf().Ekn;
    AppMethodBeat.o(55739);
    return localm;
  }
  
  public static l eMi()
  {
    AppMethodBeat.i(55740);
    h.aHE().aGH();
    if (eMf().Eko == null) {
      eMf().Eko = new l();
    }
    l locall = eMf().Eko;
    AppMethodBeat.o(55740);
    return locall;
  }
  
  public static q eMj()
  {
    AppMethodBeat.i(55741);
    if (eMf().Eki == null) {
      eMf().Eki = new q();
    }
    q localq = eMf().Eki;
    AppMethodBeat.o(55741);
    return localq;
  }
  
  public static r eMk()
  {
    AppMethodBeat.i(55742);
    if (eMf().Ekj == null) {
      eMf().Ekj = new r();
    }
    r localr = eMf().Ekj;
    AppMethodBeat.o(55742);
    return localr;
  }
  
  public static k eMl()
  {
    AppMethodBeat.i(55743);
    if (eMf().Ekk == null) {
      eMf().Ekk = new k();
    }
    k localk = eMf().Ekk;
    AppMethodBeat.o(55743);
    return localk;
  }
  
  public static String eMm()
  {
    AppMethodBeat.i(55745);
    String str = h.aHG().cachePath + "trackroom/";
    AppMethodBeat.o(55745);
    return str;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(55746);
    h.d.a(Integer.valueOf(48), this.Ekg);
    h.d.a(Integer.valueOf(61), this.Ekh);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("trackmsg", this.Eku, true);
    h.aGY().a(x.arZ(), this.Ekp);
    EventCenter.instance.addListener(this.Ekb);
    EventCenter.instance.addListener(this.Ekc);
    EventCenter.instance.addListener(this.Ekq);
    EventCenter.instance.addListener(this.Ekr);
    EventCenter.instance.addListener(this.Eks);
    EventCenter.instance.addListener(this.Ekt);
    EventCenter.instance.addListener(this.Ekd);
    appForegroundListener.alive();
    com.tencent.mm.bk.d.meW = eMj();
    r localr = eMk();
    com.tencent.mm.bk.d.meV = localr;
    localr.bpI();
    if (eMf().Ekl == null) {
      eMf().Ekl = new o();
    }
    com.tencent.mm.ce.a.a.a.UOn = eMf().Ekl;
    h.aHE().aGH();
    if (eMf().Ekm == null) {
      eMf().Ekm = new d();
    }
    com.tencent.mm.plugin.q.c.a.Esq = eMf().Ekm;
    AppMethodBeat.o(55746);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55747);
    appForegroundListener.dead();
    if (this.Eki != null)
    {
      this.Eki.EkJ = null;
      this.Eki.stop();
      this.Eki.VG(1);
    }
    h.d.b(Integer.valueOf(48), this.Ekg);
    h.d.b(Integer.valueOf(61), this.Ekh);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("trackmsg", this.Eku, true);
    h.aGY().b(x.arZ(), this.Ekp);
    EventCenter.instance.removeListener(this.Ekb);
    EventCenter.instance.removeListener(this.Ekc);
    EventCenter.instance.removeListener(this.Ekq);
    EventCenter.instance.removeListener(this.Ekr);
    EventCenter.instance.removeListener(this.Eks);
    EventCenter.instance.removeListener(this.Ekt);
    EventCenter.instance.removeListener(this.Ekd);
    Object localObject;
    if (this.Ekk != null)
    {
      localObject = this.Ekk;
      ((k)localObject).eMe();
      ((k)localObject).EjG.clear();
    }
    if (this.Ekn != null) {
      this.Ekn.stop();
    }
    if (this.Eko != null)
    {
      localObject = this.Eko;
      eMh().b((c)localObject);
    }
    AppMethodBeat.o(55747);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    extends IListener<hw>
  {
    private a()
    {
      AppMethodBeat.i(160947);
      this.__eventId = hw.class.getName().hashCode();
      AppMethodBeat.o(160947);
    }
  }
  
  static final class b
    extends IListener<mn>
  {
    private b()
    {
      AppMethodBeat.i(160949);
      this.__eventId = mn.class.getName().hashCode();
      AppMethodBeat.o(160949);
    }
  }
  
  static final class c
    extends IListener<mp>
  {
    private volatile boolean mIsStarted;
    
    private c()
    {
      AppMethodBeat.i(160951);
      this.mIsStarted = false;
      this.__eventId = mp.class.getName().hashCode();
      AppMethodBeat.o(160951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */