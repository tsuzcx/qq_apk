package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;

public class n
  implements bd
{
  private static o.a appForegroundListener;
  private IListener yGA;
  private cj.a yGB;
  private c yGi;
  private a yGj;
  private b yGk;
  private a.a yGl;
  private int yGm;
  private com.tencent.mm.model.e yGn;
  private com.tencent.mm.model.e yGo;
  private q yGp;
  private r yGq;
  private k yGr;
  private o yGs;
  private d yGt;
  private m yGu;
  private l yGv;
  private com.tencent.mm.ak.i yGw;
  private IListener yGx;
  private IListener yGy;
  private IListener yGz;
  
  static
  {
    AppMethodBeat.i(55749);
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(55729);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            paramAnonymousString = new ss();
            paramAnonymousString.dZj.active = false;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(55729);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(55728);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            paramAnonymousString = new ss();
            paramAnonymousString.dZj.active = true;
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
    this.yGi = new c((byte)0);
    this.yGj = new a((byte)0);
    this.yGk = new b((byte)0);
    this.yGm = 0;
    this.yGn = new b();
    this.yGo = new p();
    this.yGp = null;
    this.yGq = null;
    this.yGr = null;
    this.yGs = null;
    this.yGt = new d();
    this.yGu = null;
    this.yGv = null;
    this.yGw = new n.1(this);
    this.yGx = new IListener() {};
    this.yGy = new IListener() {};
    this.yGz = new IListener() {};
    this.yGA = new IListener() {};
    this.yGB = new cj.a()
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
  
  public static void aA(ca paramca)
  {
    AppMethodBeat.i(55744);
    if ((paramca != null) && (paramca.field_msgId != 0L))
    {
      ca.b localb = ca.b.bkB(paramca.field_content);
      paramca = new x((float)localb.yFv, (float)localb.yFu, paramca.field_msgId);
      g.azz().a(paramca, 0);
    }
    AppMethodBeat.o(55744);
  }
  
  private static n ecN()
  {
    AppMethodBeat.i(55737);
    n localn = (n)y.at(n.class);
    AppMethodBeat.o(55737);
    return localn;
  }
  
  public static a.a ecO()
  {
    AppMethodBeat.i(55738);
    g.aAf().azk();
    if (ecN().yGl == null) {
      ecN().yGl = new a.a();
    }
    a.a locala = ecN().yGl;
    AppMethodBeat.o(55738);
    return locala;
  }
  
  public static m ecP()
  {
    AppMethodBeat.i(55739);
    g.aAf().azk();
    if (ecN().yGu == null) {
      ecN().yGu = new m();
    }
    m localm = ecN().yGu;
    AppMethodBeat.o(55739);
    return localm;
  }
  
  public static l ecQ()
  {
    AppMethodBeat.i(55740);
    g.aAf().azk();
    if (ecN().yGv == null) {
      ecN().yGv = new l();
    }
    l locall = ecN().yGv;
    AppMethodBeat.o(55740);
    return locall;
  }
  
  public static q ecR()
  {
    AppMethodBeat.i(55741);
    if (ecN().yGp == null) {
      ecN().yGp = new q();
    }
    q localq = ecN().yGp;
    AppMethodBeat.o(55741);
    return localq;
  }
  
  public static r ecS()
  {
    AppMethodBeat.i(55742);
    if (ecN().yGq == null) {
      ecN().yGq = new r();
    }
    r localr = ecN().yGq;
    AppMethodBeat.o(55742);
    return localr;
  }
  
  public static k ecT()
  {
    AppMethodBeat.i(55743);
    if (ecN().yGr == null) {
      ecN().yGr = new k();
    }
    k localk = ecN().yGr;
    AppMethodBeat.o(55743);
    return localk;
  }
  
  public static String ecU()
  {
    AppMethodBeat.i(55745);
    String str = g.aAh().cachePath + "trackroom/";
    AppMethodBeat.o(55745);
    return str;
  }
  
  public static void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(55748);
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramLong);
    if (localca.dOS())
    {
      localca.CA(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramLong, localca);
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
    h.d.a(Integer.valueOf(48), this.yGn);
    h.d.a(Integer.valueOf(61), this.yGo);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("trackmsg", this.yGB, true);
    g.azz().a(424, this.yGw);
    EventCenter.instance.addListener(this.yGi);
    EventCenter.instance.addListener(this.yGj);
    EventCenter.instance.addListener(this.yGx);
    EventCenter.instance.addListener(this.yGy);
    EventCenter.instance.addListener(this.yGz);
    EventCenter.instance.addListener(this.yGA);
    EventCenter.instance.addListener(this.yGk);
    appForegroundListener.alive();
    com.tencent.mm.bi.d.jpB = ecR();
    r localr = ecS();
    com.tencent.mm.bi.d.jpA = localr;
    localr.bgs();
    if (ecN().yGs == null) {
      ecN().yGs = new o();
    }
    com.tencent.mm.bx.a.a.a.NAL = ecN().yGs;
    g.aAf().azk();
    if (ecN().yGt == null) {
      ecN().yGt = new d();
    }
    com.tencent.mm.plugin.k.c.a.yOs = ecN().yGt;
    AppMethodBeat.o(55746);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55747);
    appForegroundListener.dead();
    if (this.yGp != null)
    {
      this.yGp.yGP = null;
      this.yGp.stop();
      this.yGp.Px(1);
    }
    h.d.b(Integer.valueOf(48), this.yGn);
    h.d.b(Integer.valueOf(61), this.yGo);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("trackmsg", this.yGB, true);
    g.azz().b(424, this.yGw);
    EventCenter.instance.removeListener(this.yGi);
    EventCenter.instance.removeListener(this.yGj);
    EventCenter.instance.removeListener(this.yGx);
    EventCenter.instance.removeListener(this.yGy);
    EventCenter.instance.removeListener(this.yGz);
    EventCenter.instance.removeListener(this.yGA);
    EventCenter.instance.removeListener(this.yGk);
    Object localObject;
    if (this.yGr != null)
    {
      localObject = this.yGr;
      ((k)localObject).ecM();
      ((k)localObject).yFN.clear();
    }
    if (this.yGu != null) {
      this.yGu.stop();
    }
    if (this.yGv != null)
    {
      localObject = this.yGv;
      ecP().b((c)localObject);
    }
    AppMethodBeat.o(55747);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    extends IListener<hp>
  {
    private a()
    {
      AppMethodBeat.i(160947);
      this.__eventId = hp.class.getName().hashCode();
      AppMethodBeat.o(160947);
    }
  }
  
  static final class b
    extends IListener<lw>
  {
    private b()
    {
      AppMethodBeat.i(160949);
      this.__eventId = lw.class.getName().hashCode();
      AppMethodBeat.o(160949);
    }
  }
  
  static final class c
    extends IListener<ly>
  {
    private volatile boolean mIsStarted;
    
    private c()
    {
      AppMethodBeat.i(160951);
      this.mIsStarted = false;
      this.__eventId = ly.class.getName().hashCode();
      AppMethodBeat.o(160951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */