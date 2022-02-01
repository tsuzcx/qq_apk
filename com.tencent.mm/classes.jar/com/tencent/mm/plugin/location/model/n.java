package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.e.d;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.b;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;

public class n
  implements ax
{
  private static com.tencent.mm.app.n.a appForegroundListener;
  private c vaf;
  private a vag;
  private b vah;
  private a.a vai;
  private int vaj;
  private com.tencent.mm.model.e vak;
  private com.tencent.mm.model.e val;
  private q vam;
  private r van;
  private k vao;
  private o vap;
  private d vaq;
  private m var;
  private l vas;
  private f vat;
  private c vau;
  private c vav;
  private c vaw;
  private c vax;
  private cd.a vay;
  
  static
  {
    AppMethodBeat.i(55749);
    appForegroundListener = new com.tencent.mm.app.n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(55729);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new rv();
            paramAnonymousString.dGs.active = false;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(55729);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(55728);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new rv();
            paramAnonymousString.dGs.active = true;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
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
    this.vaf = new c((byte)0);
    this.vag = new a((byte)0);
    this.vah = new b((byte)0);
    this.vaj = 0;
    this.vak = new b();
    this.val = new p();
    this.vam = null;
    this.van = null;
    this.vao = null;
    this.vap = null;
    this.vaq = new d();
    this.var = null;
    this.vas = null;
    this.vat = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(55725);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (w)paramAnonymousn;
          paramAnonymousn = paramAnonymousString.aLb();
          if (paramAnonymousn.nEf == 0) {
            n.s(paramAnonymousString.msgId, w.Gp(paramAnonymousn.GDJ));
          }
        }
        AppMethodBeat.o(55725);
      }
    };
    this.vau = new c() {};
    this.vav = new c() {};
    this.vaw = new c() {};
    this.vax = new c() {};
    this.vay = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(55732);
        new p().b(paramAnonymousa);
        AppMethodBeat.o(55732);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(55736);
  }
  
  public static void aq(bu parambu)
  {
    AppMethodBeat.i(55744);
    if ((parambu != null) && (parambu.field_msgId != 0L))
    {
      bu.b localb = bu.b.aUc(parambu.field_content);
      parambu = new w((float)localb.uZs, (float)localb.uZr, parambu.field_msgId);
      g.aiU().a(parambu, 0);
    }
    AppMethodBeat.o(55744);
  }
  
  private static n dgd()
  {
    AppMethodBeat.i(55737);
    n localn = (n)t.ap(n.class);
    AppMethodBeat.o(55737);
    return localn;
  }
  
  public static a.a dge()
  {
    AppMethodBeat.i(55738);
    g.ajA().aiF();
    if (dgd().vai == null) {
      dgd().vai = new a.a();
    }
    a.a locala = dgd().vai;
    AppMethodBeat.o(55738);
    return locala;
  }
  
  public static m dgf()
  {
    AppMethodBeat.i(55739);
    g.ajA().aiF();
    if (dgd().var == null) {
      dgd().var = new m();
    }
    m localm = dgd().var;
    AppMethodBeat.o(55739);
    return localm;
  }
  
  public static l dgg()
  {
    AppMethodBeat.i(55740);
    g.ajA().aiF();
    if (dgd().vas == null) {
      dgd().vas = new l();
    }
    l locall = dgd().vas;
    AppMethodBeat.o(55740);
    return locall;
  }
  
  public static q dgh()
  {
    AppMethodBeat.i(55741);
    if (dgd().vam == null) {
      dgd().vam = new q();
    }
    q localq = dgd().vam;
    AppMethodBeat.o(55741);
    return localq;
  }
  
  public static r dgi()
  {
    AppMethodBeat.i(55742);
    if (dgd().van == null) {
      dgd().van = new r();
    }
    r localr = dgd().van;
    AppMethodBeat.o(55742);
    return localr;
  }
  
  public static k dgj()
  {
    AppMethodBeat.i(55743);
    if (dgd().vao == null) {
      dgd().vao = new k();
    }
    k localk = dgd().vao;
    AppMethodBeat.o(55743);
    return localk;
  }
  
  public static String dgk()
  {
    AppMethodBeat.i(55745);
    String str = g.ajC().cachePath + "trackroom/";
    AppMethodBeat.o(55745);
    return str;
  }
  
  public static void s(long paramLong, String paramString)
  {
    AppMethodBeat.i(55748);
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramLong);
    if (localbu.cTe())
    {
      localbu.tP(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(paramLong, localbu);
    }
    AppMethodBeat.o(55748);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(55746);
    e.d.a(Integer.valueOf(48), this.vak);
    e.d.a(Integer.valueOf(61), this.val);
    ((com.tencent.mm.plugin.messenger.foundation.a.r)g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("trackmsg", this.vay, true);
    g.aiU().a(424, this.vat);
    com.tencent.mm.sdk.b.a.IbL.c(this.vaf);
    com.tencent.mm.sdk.b.a.IbL.c(this.vag);
    com.tencent.mm.sdk.b.a.IbL.c(this.vau);
    com.tencent.mm.sdk.b.a.IbL.c(this.vav);
    com.tencent.mm.sdk.b.a.IbL.c(this.vaw);
    com.tencent.mm.sdk.b.a.IbL.c(this.vax);
    com.tencent.mm.sdk.b.a.IbL.c(this.vah);
    appForegroundListener.alive();
    com.tencent.mm.bj.d.irv = dgh();
    r localr = dgi();
    com.tencent.mm.bj.d.iru = localr;
    localr.aLU();
    if (dgd().vap == null) {
      dgd().vap = new o();
    }
    com.tencent.mm.by.a.a.a.HTy = dgd().vap;
    g.ajA().aiF();
    if (dgd().vaq == null) {
      dgd().vaq = new d();
    }
    com.tencent.mm.plugin.k.c.a.viz = dgd().vaq;
    AppMethodBeat.o(55746);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55747);
    appForegroundListener.dead();
    if (this.vam != null)
    {
      this.vam.vaN = null;
      this.vam.stop();
      this.vam.IW(1);
    }
    e.d.b(Integer.valueOf(48), this.vak);
    e.d.b(Integer.valueOf(61), this.val);
    ((com.tencent.mm.plugin.messenger.foundation.a.r)g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("trackmsg", this.vay, true);
    g.aiU().b(424, this.vat);
    com.tencent.mm.sdk.b.a.IbL.d(this.vaf);
    com.tencent.mm.sdk.b.a.IbL.d(this.vag);
    com.tencent.mm.sdk.b.a.IbL.d(this.vau);
    com.tencent.mm.sdk.b.a.IbL.d(this.vav);
    com.tencent.mm.sdk.b.a.IbL.d(this.vaw);
    com.tencent.mm.sdk.b.a.IbL.d(this.vax);
    com.tencent.mm.sdk.b.a.IbL.d(this.vah);
    Object localObject;
    if (this.vao != null)
    {
      localObject = this.vao;
      ((k)localObject).dgc();
      ((k)localObject).uZK.clear();
    }
    if (this.var != null) {
      this.var.stop();
    }
    if (this.vas != null)
    {
      localObject = this.vas;
      dgf().b((com.tencent.mm.pluginsdk.location.b)localObject);
    }
    AppMethodBeat.o(55747);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    extends c<hg>
  {
    private a()
    {
      AppMethodBeat.i(160947);
      this.__eventId = hg.class.getName().hashCode();
      AppMethodBeat.o(160947);
    }
  }
  
  static final class b
    extends c<lf>
  {
    private b()
    {
      AppMethodBeat.i(160949);
      this.__eventId = lf.class.getName().hashCode();
      AppMethodBeat.o(160949);
    }
  }
  
  static final class c
    extends c<lh>
  {
    private volatile boolean mIsStarted;
    
    private c()
    {
      AppMethodBeat.i(160951);
      this.mIsStarted = false;
      this.__eventId = lh.class.getName().hashCode();
      AppMethodBeat.o(160951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */