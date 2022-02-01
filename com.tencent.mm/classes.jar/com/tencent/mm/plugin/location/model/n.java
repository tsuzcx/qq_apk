package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.f.d;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.b;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;

public class n
  implements aw
{
  private static com.tencent.mm.app.n.a appForegroundListener;
  private c sPA;
  private c sPB;
  private cc.a sPC;
  private c sPj;
  private a sPk;
  private b sPl;
  private a.a sPm;
  private int sPn;
  private com.tencent.mm.model.e sPo;
  private com.tencent.mm.model.e sPp;
  private q sPq;
  private r sPr;
  private k sPs;
  private o sPt;
  private d sPu;
  private m sPv;
  private l sPw;
  private com.tencent.mm.al.g sPx;
  private c sPy;
  private c sPz;
  
  static
  {
    AppMethodBeat.i(55749);
    appForegroundListener = new com.tencent.mm.app.n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(55729);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new rb();
            paramAnonymousString.dwF.active = false;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(55729);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(55728);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new rb();
            paramAnonymousString.dwF.active = true;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
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
    this.sPj = new c((byte)0);
    this.sPk = new a((byte)0);
    this.sPl = new b((byte)0);
    this.sPn = 0;
    this.sPo = new b();
    this.sPp = new p();
    this.sPq = null;
    this.sPr = null;
    this.sPs = null;
    this.sPt = null;
    this.sPu = new d();
    this.sPv = null;
    this.sPw = null;
    this.sPx = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(55725);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (w)paramAnonymousn;
          paramAnonymousn = paramAnonymousString.aBa();
          if (paramAnonymousn.mBH == 0) {
            n.t(paramAnonymousString.msgId, w.zf(paramAnonymousn.DyQ));
          }
        }
        AppMethodBeat.o(55725);
      }
    };
    this.sPy = new c() {};
    this.sPz = new c() {};
    this.sPA = new c() {};
    this.sPB = new c() {};
    this.sPC = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(55732);
        new p().b(paramAnonymousa);
        AppMethodBeat.o(55732);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(55736);
  }
  
  public static void al(bl parambl)
  {
    AppMethodBeat.i(55744);
    if ((parambl != null) && (parambl.field_msgId != 0L))
    {
      bl.b localb = bl.b.aIP(parambl.field_content);
      parambl = new w((float)localb.sOw, (float)localb.sOv, parambl.field_msgId);
      com.tencent.mm.kernel.g.aeS().a(parambl, 0);
    }
    AppMethodBeat.o(55744);
  }
  
  private static n cJm()
  {
    AppMethodBeat.i(55737);
    n localn = (n)t.ap(n.class);
    AppMethodBeat.o(55737);
    return localn;
  }
  
  public static a.a cJn()
  {
    AppMethodBeat.i(55738);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cJm().sPm == null) {
      cJm().sPm = new a.a();
    }
    a.a locala = cJm().sPm;
    AppMethodBeat.o(55738);
    return locala;
  }
  
  public static m cJo()
  {
    AppMethodBeat.i(55739);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cJm().sPv == null) {
      cJm().sPv = new m();
    }
    m localm = cJm().sPv;
    AppMethodBeat.o(55739);
    return localm;
  }
  
  public static l cJp()
  {
    AppMethodBeat.i(55740);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cJm().sPw == null) {
      cJm().sPw = new l();
    }
    l locall = cJm().sPw;
    AppMethodBeat.o(55740);
    return locall;
  }
  
  public static q cJq()
  {
    AppMethodBeat.i(55741);
    if (cJm().sPq == null) {
      cJm().sPq = new q();
    }
    q localq = cJm().sPq;
    AppMethodBeat.o(55741);
    return localq;
  }
  
  public static r cJr()
  {
    AppMethodBeat.i(55742);
    if (cJm().sPr == null) {
      cJm().sPr = new r();
    }
    r localr = cJm().sPr;
    AppMethodBeat.o(55742);
    return localr;
  }
  
  public static k cJs()
  {
    AppMethodBeat.i(55743);
    if (cJm().sPs == null) {
      cJm().sPs = new k();
    }
    k localk = cJm().sPs;
    AppMethodBeat.o(55743);
    return localk;
  }
  
  public static String cJt()
  {
    AppMethodBeat.i(55745);
    String str = com.tencent.mm.kernel.g.afB().cachePath + "trackroom/";
    AppMethodBeat.o(55745);
    return str;
  }
  
  public static void t(long paramLong, String paramString)
  {
    AppMethodBeat.i(55748);
    bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramLong);
    if (localbl.cxD())
    {
      localbl.oa(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(paramLong, localbl);
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
    f.d.a(Integer.valueOf(48), this.sPo);
    f.d.a(Integer.valueOf(61), this.sPp);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("trackmsg", this.sPC, true);
    com.tencent.mm.kernel.g.aeS().a(424, this.sPx);
    com.tencent.mm.sdk.b.a.ESL.c(this.sPj);
    com.tencent.mm.sdk.b.a.ESL.c(this.sPk);
    com.tencent.mm.sdk.b.a.ESL.c(this.sPy);
    com.tencent.mm.sdk.b.a.ESL.c(this.sPz);
    com.tencent.mm.sdk.b.a.ESL.c(this.sPA);
    com.tencent.mm.sdk.b.a.ESL.c(this.sPB);
    com.tencent.mm.sdk.b.a.ESL.c(this.sPl);
    appForegroundListener.alive();
    com.tencent.mm.bj.d.hxy = cJq();
    r localr = cJr();
    com.tencent.mm.bj.d.hxx = localr;
    localr.aBU();
    if (cJm().sPt == null) {
      cJm().sPt = new o();
    }
    com.tencent.mm.by.a.a.a.EKY = cJm().sPt;
    com.tencent.mm.kernel.g.afz().aeD();
    if (cJm().sPu == null) {
      cJm().sPu = new d();
    }
    com.tencent.mm.plugin.k.c.a.sXC = cJm().sPu;
    AppMethodBeat.o(55746);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55747);
    appForegroundListener.dead();
    if (this.sPq != null)
    {
      this.sPq.sPR = null;
      this.sPq.stop();
      this.sPq.FF(1);
    }
    f.d.b(Integer.valueOf(48), this.sPo);
    f.d.b(Integer.valueOf(61), this.sPp);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("trackmsg", this.sPC, true);
    com.tencent.mm.kernel.g.aeS().b(424, this.sPx);
    com.tencent.mm.sdk.b.a.ESL.d(this.sPj);
    com.tencent.mm.sdk.b.a.ESL.d(this.sPk);
    com.tencent.mm.sdk.b.a.ESL.d(this.sPy);
    com.tencent.mm.sdk.b.a.ESL.d(this.sPz);
    com.tencent.mm.sdk.b.a.ESL.d(this.sPA);
    com.tencent.mm.sdk.b.a.ESL.d(this.sPB);
    com.tencent.mm.sdk.b.a.ESL.d(this.sPl);
    Object localObject;
    if (this.sPs != null)
    {
      localObject = this.sPs;
      ((k)localObject).cJl();
      ((k)localObject).sOO.clear();
    }
    if (this.sPv != null) {
      this.sPv.stop();
    }
    if (this.sPw != null)
    {
      localObject = this.sPw;
      cJo().b((com.tencent.mm.pluginsdk.location.b)localObject);
    }
    AppMethodBeat.o(55747);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    extends c<ha>
  {
    private a()
    {
      AppMethodBeat.i(160947);
      this.__eventId = ha.class.getName().hashCode();
      AppMethodBeat.o(160947);
    }
  }
  
  static final class b
    extends c<kn>
  {
    private b()
    {
      AppMethodBeat.i(160949);
      this.__eventId = kn.class.getName().hashCode();
      AppMethodBeat.o(160949);
    }
  }
  
  static final class c
    extends c<kp>
  {
    private volatile boolean mIsStarted;
    
    private c()
    {
      AppMethodBeat.i(160951);
      this.mIsStarted = false;
      this.__eventId = kp.class.getName().hashCode();
      AppMethodBeat.o(160951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */