package com.tencent.mm.plugin.location.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.g.d;
import com.tencent.mm.am.s;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.a.ih;
import com.tencent.mm.autogen.a.ma;
import com.tencent.mm.autogen.a.nt;
import com.tencent.mm.autogen.a.nw;
import com.tencent.mm.autogen.a.vi;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.bd.a;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.e;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.protocal.protobuf.eud;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;

public class SubCoreLocation
  implements be
{
  private static q.a appForegroundListener;
  private LocationServerListener KcK;
  private FetchStreetViewUrlListener KcL;
  private LocServForNoteListener KcM;
  private a.a KcN;
  private int KcO;
  private e KcP;
  private e KcQ;
  private o KcR;
  private p KcS;
  private k KcT;
  private TrackAvatarCacheService KcU;
  private d KcV;
  private m KcW;
  private l KcX;
  private com.tencent.mm.am.h KcY;
  private IListener KcZ;
  private IListener Kda;
  private IListener Kdb;
  private IListener Kdc;
  private cl.a Kdd;
  
  static
  {
    AppMethodBeat.i(55749);
    appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(55729);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            paramAnonymousString = new vi();
            paramAnonymousString.hZa.active = false;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(55729);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(55728);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            paramAnonymousString = new vi();
            paramAnonymousString.hZa.active = true;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(55728);
      }
    };
    AppMethodBeat.o(55749);
  }
  
  public SubCoreLocation()
  {
    AppMethodBeat.i(55736);
    this.KcK = new LocationServerListener();
    this.KcL = new FetchStreetViewUrlListener();
    this.KcM = new LocServForNoteListener();
    this.KcO = 0;
    this.KcP = new b();
    this.KcQ = new n();
    this.KcR = null;
    this.KcS = null;
    this.KcT = null;
    this.KcU = null;
    this.KcV = new d();
    this.KcW = null;
    this.KcX = null;
    this.KcY = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
      {
        AppMethodBeat.i(55725);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (com.tencent.mm.modelsimple.y)paramAnonymousp;
          paramAnonymousp = paramAnonymousString.bMy();
          if (paramAnonymousp.vhJ == 0) {
            SubCoreLocation.R(paramAnonymousString.msgId, com.tencent.mm.modelsimple.y.Pc(paramAnonymousp.aazh));
          }
        }
        AppMethodBeat.o(55725);
      }
    };
    this.KcZ = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Kda = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Kdb = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Kdc = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Kdd = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(55732);
        new n().b(paramAnonymousa);
        AppMethodBeat.o(55732);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    AppMethodBeat.o(55736);
  }
  
  public static void R(long paramLong, String paramString)
  {
    AppMethodBeat.i(55748);
    cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramLong);
    if ((localcc != null) && (localcc.fxT()))
    {
      localcc.BU(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramLong, localcc);
    }
    AppMethodBeat.o(55748);
  }
  
  public static void aY(cc paramcc)
  {
    AppMethodBeat.i(55744);
    if ((paramcc != null) && (paramcc.field_msgId != 0L))
    {
      cc.c localc = cc.c.byt(paramcc.field_content);
      paramcc = new com.tencent.mm.modelsimple.y((float)localc.KbX, (float)localc.KbW, paramcc.field_msgId);
      com.tencent.mm.kernel.h.aZW().a(paramcc, 0);
    }
    AppMethodBeat.o(55744);
  }
  
  public static l fUA()
  {
    AppMethodBeat.i(55740);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fUx().KcX == null) {
      fUx().KcX = new l();
    }
    l locall = fUx().KcX;
    AppMethodBeat.o(55740);
    return locall;
  }
  
  public static o fUB()
  {
    AppMethodBeat.i(55741);
    if (fUx().KcR == null) {
      fUx().KcR = new o();
    }
    o localo = fUx().KcR;
    AppMethodBeat.o(55741);
    return localo;
  }
  
  public static p fUC()
  {
    AppMethodBeat.i(55742);
    if (fUx().KcS == null) {
      fUx().KcS = new p();
    }
    p localp = fUx().KcS;
    AppMethodBeat.o(55742);
    return localp;
  }
  
  public static k fUD()
  {
    AppMethodBeat.i(55743);
    if (fUx().KcT == null) {
      fUx().KcT = new k();
    }
    k localk = fUx().KcT;
    AppMethodBeat.o(55743);
    return localk;
  }
  
  public static String fUE()
  {
    AppMethodBeat.i(55745);
    String str = com.tencent.mm.kernel.h.baE().cachePath + "trackroom/";
    AppMethodBeat.o(55745);
    return str;
  }
  
  private static SubCoreLocation fUx()
  {
    AppMethodBeat.i(55737);
    SubCoreLocation localSubCoreLocation = (SubCoreLocation)com.tencent.mm.model.y.aL(SubCoreLocation.class);
    AppMethodBeat.o(55737);
    return localSubCoreLocation;
  }
  
  public static a.a fUy()
  {
    AppMethodBeat.i(55738);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fUx().KcN == null) {
      fUx().KcN = new a.a();
    }
    a.a locala = fUx().KcN;
    AppMethodBeat.o(55738);
    return locala;
  }
  
  public static m fUz()
  {
    AppMethodBeat.i(55739);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fUx().KcW == null) {
      fUx().KcW = new m();
    }
    m localm = fUx().KcW;
    AppMethodBeat.o(55739);
    return localm;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(55746);
    g.d.a(Integer.valueOf(48), this.KcP);
    g.d.a(Integer.valueOf(61), this.KcQ);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("trackmsg", this.Kdd, true);
    com.tencent.mm.kernel.h.aZW().a(com.tencent.mm.modelsimple.y.aLV(), this.KcY);
    this.KcK.alive();
    this.KcL.alive();
    this.KcZ.alive();
    this.Kda.alive();
    this.Kdb.alive();
    this.Kdc.alive();
    this.KcM.alive();
    appForegroundListener.alive();
    com.tencent.mm.bd.d.oXO = fUB();
    p localp = fUC();
    com.tencent.mm.bd.d.oXN = localp;
    localp.bNo();
    if (fUx().KcU == null) {
      fUx().KcU = new TrackAvatarCacheService();
    }
    com.tencent.mm.by.a.a.a.acjy = fUx().KcU;
    com.tencent.mm.kernel.h.baC().aZJ();
    if (fUx().KcV == null) {
      fUx().KcV = new d();
    }
    com.tencent.mm.plugin.p.c.a.KkW = fUx().KcV;
    AppMethodBeat.o(55746);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55747);
    appForegroundListener.dead();
    if (this.KcR != null)
    {
      this.KcR.Kds = null;
      this.KcR.stop();
      this.KcR.ZC(1);
    }
    g.d.b(Integer.valueOf(48), this.KcP);
    g.d.b(Integer.valueOf(61), this.KcQ);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("trackmsg", this.Kdd, true);
    com.tencent.mm.kernel.h.aZW().b(com.tencent.mm.modelsimple.y.aLV(), this.KcY);
    this.KcK.dead();
    this.KcL.dead();
    this.KcZ.dead();
    this.Kda.dead();
    this.Kdb.dead();
    this.Kdc.dead();
    this.KcM.dead();
    Object localObject;
    if (this.KcT != null)
    {
      localObject = this.KcT;
      ((k)localObject).fUw();
      ((k)localObject).Kcp.clear();
    }
    if (this.KcW != null) {
      this.KcW.stop();
    }
    if (this.KcX != null)
    {
      localObject = this.KcX;
      fUz().b((c)localObject);
    }
    AppMethodBeat.o(55747);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class FetchStreetViewUrlListener
    extends IListener<ih>
  {
    public FetchStreetViewUrlListener()
    {
      super();
      AppMethodBeat.i(160947);
      this.__eventId = ih.class.getName().hashCode();
      AppMethodBeat.o(160947);
    }
  }
  
  static final class LocServForNoteListener
    extends IListener<nt>
  {
    public LocServForNoteListener()
    {
      super();
      AppMethodBeat.i(160949);
      this.__eventId = nt.class.getName().hashCode();
      AppMethodBeat.o(160949);
    }
  }
  
  static final class LocationServerListener
    extends IListener<nw>
  {
    private volatile boolean mIsStarted;
    
    public LocationServerListener()
    {
      super();
      AppMethodBeat.i(160951);
      this.mIsStarted = false;
      this.__eventId = nw.class.getName().hashCode();
      AppMethodBeat.o(160951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.SubCoreLocation
 * JD-Core Version:    0.7.0.1
 */