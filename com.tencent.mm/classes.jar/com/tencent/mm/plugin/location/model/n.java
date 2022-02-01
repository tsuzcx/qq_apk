package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.ak.f;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.b;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;

public class n
  implements az
{
  private static o.a appForegroundListener;
  private o vmA;
  private d vmB;
  private m vmC;
  private l vmD;
  private f vmE;
  private c vmF;
  private c vmG;
  private c vmH;
  private c vmI;
  private cf.a vmJ;
  private c vmq;
  private a vmr;
  private b vms;
  private a.a vmt;
  private int vmu;
  private com.tencent.mm.model.e vmv;
  private com.tencent.mm.model.e vmw;
  private q vmx;
  private r vmy;
  private k vmz;
  
  static
  {
    AppMethodBeat.i(55749);
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(55729);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            paramAnonymousString = new rw();
            paramAnonymousString.dHy.active = false;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(55729);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(55728);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            paramAnonymousString = new rw();
            paramAnonymousString.dHy.active = true;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
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
    this.vmq = new c((byte)0);
    this.vmr = new a((byte)0);
    this.vms = new b((byte)0);
    this.vmu = 0;
    this.vmv = new b();
    this.vmw = new p();
    this.vmx = null;
    this.vmy = null;
    this.vmz = null;
    this.vmA = null;
    this.vmB = new d();
    this.vmC = null;
    this.vmD = null;
    this.vmE = new n.1(this);
    this.vmF = new c() {};
    this.vmG = new c() {};
    this.vmH = new c() {};
    this.vmI = new c() {};
    this.vmJ = new cf.a()
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
  
  public static void ap(bv parambv)
  {
    AppMethodBeat.i(55744);
    if ((parambv != null) && (parambv.field_msgId != 0L))
    {
      bv.b localb = bv.b.aVD(parambv.field_content);
      parambv = new x((float)localb.vlD, (float)localb.vlC, parambv.field_msgId);
      g.ajj().a(parambv, 0);
    }
    AppMethodBeat.o(55744);
  }
  
  private static n djc()
  {
    AppMethodBeat.i(55737);
    n localn = (n)u.ap(n.class);
    AppMethodBeat.o(55737);
    return localn;
  }
  
  public static a.a djd()
  {
    AppMethodBeat.i(55738);
    g.ajP().aiU();
    if (djc().vmt == null) {
      djc().vmt = new a.a();
    }
    a.a locala = djc().vmt;
    AppMethodBeat.o(55738);
    return locala;
  }
  
  public static m dje()
  {
    AppMethodBeat.i(55739);
    g.ajP().aiU();
    if (djc().vmC == null) {
      djc().vmC = new m();
    }
    m localm = djc().vmC;
    AppMethodBeat.o(55739);
    return localm;
  }
  
  public static l djf()
  {
    AppMethodBeat.i(55740);
    g.ajP().aiU();
    if (djc().vmD == null) {
      djc().vmD = new l();
    }
    l locall = djc().vmD;
    AppMethodBeat.o(55740);
    return locall;
  }
  
  public static q djg()
  {
    AppMethodBeat.i(55741);
    if (djc().vmx == null) {
      djc().vmx = new q();
    }
    q localq = djc().vmx;
    AppMethodBeat.o(55741);
    return localq;
  }
  
  public static r djh()
  {
    AppMethodBeat.i(55742);
    if (djc().vmy == null) {
      djc().vmy = new r();
    }
    r localr = djc().vmy;
    AppMethodBeat.o(55742);
    return localr;
  }
  
  public static k dji()
  {
    AppMethodBeat.i(55743);
    if (djc().vmz == null) {
      djc().vmz = new k();
    }
    k localk = djc().vmz;
    AppMethodBeat.o(55743);
    return localk;
  }
  
  public static String djj()
  {
    AppMethodBeat.i(55745);
    String str = g.ajR().cachePath + "trackroom/";
    AppMethodBeat.o(55745);
    return str;
  }
  
  public static void s(long paramLong, String paramString)
  {
    AppMethodBeat.i(55748);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramLong);
    if (localbv.cVJ())
    {
      localbv.uk(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(paramLong, localbv);
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
    e.d.a(Integer.valueOf(48), this.vmv);
    e.d.a(Integer.valueOf(61), this.vmw);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("trackmsg", this.vmJ, true);
    g.ajj().a(424, this.vmE);
    com.tencent.mm.sdk.b.a.IvT.c(this.vmq);
    com.tencent.mm.sdk.b.a.IvT.c(this.vmr);
    com.tencent.mm.sdk.b.a.IvT.c(this.vmF);
    com.tencent.mm.sdk.b.a.IvT.c(this.vmG);
    com.tencent.mm.sdk.b.a.IvT.c(this.vmH);
    com.tencent.mm.sdk.b.a.IvT.c(this.vmI);
    com.tencent.mm.sdk.b.a.IvT.c(this.vms);
    appForegroundListener.alive();
    com.tencent.mm.bi.d.iup = djg();
    r localr = djh();
    com.tencent.mm.bi.d.iuo = localr;
    localr.aMr();
    if (djc().vmA == null) {
      djc().vmA = new o();
    }
    com.tencent.mm.bx.a.a.a.InF = djc().vmA;
    g.ajP().aiU();
    if (djc().vmB == null) {
      djc().vmB = new d();
    }
    com.tencent.mm.plugin.k.c.a.vuE = djc().vmB;
    AppMethodBeat.o(55746);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55747);
    appForegroundListener.dead();
    if (this.vmx != null)
    {
      this.vmx.vmY = null;
      this.vmx.stop();
      this.vmx.Jv(1);
    }
    e.d.b(Integer.valueOf(48), this.vmv);
    e.d.b(Integer.valueOf(61), this.vmw);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("trackmsg", this.vmJ, true);
    g.ajj().b(424, this.vmE);
    com.tencent.mm.sdk.b.a.IvT.d(this.vmq);
    com.tencent.mm.sdk.b.a.IvT.d(this.vmr);
    com.tencent.mm.sdk.b.a.IvT.d(this.vmF);
    com.tencent.mm.sdk.b.a.IvT.d(this.vmG);
    com.tencent.mm.sdk.b.a.IvT.d(this.vmH);
    com.tencent.mm.sdk.b.a.IvT.d(this.vmI);
    com.tencent.mm.sdk.b.a.IvT.d(this.vms);
    Object localObject;
    if (this.vmz != null)
    {
      localObject = this.vmz;
      ((k)localObject).djb();
      ((k)localObject).vlV.clear();
    }
    if (this.vmC != null) {
      this.vmC.stop();
    }
    if (this.vmD != null)
    {
      localObject = this.vmD;
      dje().b((com.tencent.mm.pluginsdk.location.b)localObject);
    }
    AppMethodBeat.o(55747);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    extends c<hh>
  {
    private a()
    {
      AppMethodBeat.i(160947);
      this.__eventId = hh.class.getName().hashCode();
      AppMethodBeat.o(160947);
    }
  }
  
  static final class b
    extends c<lg>
  {
    private b()
    {
      AppMethodBeat.i(160949);
      this.__eventId = lg.class.getName().hashCode();
      AppMethodBeat.o(160949);
    }
  }
  
  static final class c
    extends c<li>
  {
    private volatile boolean mIsStarted;
    
    private c()
    {
      AppMethodBeat.i(160951);
      this.mIsStarted = false;
      this.__eventId = li.class.getName().hashCode();
      AppMethodBeat.o(160951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */