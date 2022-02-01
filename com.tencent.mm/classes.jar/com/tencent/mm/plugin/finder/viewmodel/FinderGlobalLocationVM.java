package com.tencent.mm.plugin.finder.viewmodel;

import android.app.Activity;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.p;
import d.g.b.y.b;
import d.l;
import d.o;
import d.v;
import d.z;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "lastAddress", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "getLastAddress", "()Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "setLastAddress", "(Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;)V", "locationListener", "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1;", "checkLocationPermissionWithRequest", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "checkLocationPermissionWithoutRequest", "forceRequestLocation", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLocation", "requestLocationPermission", "storeLocation", "longitude", "latitude", "Companion", "plugin-finder_release"})
public final class FinderGlobalLocationVM
  extends UIComponentPlugin<PluginFinder>
  implements f
{
  public static final FinderGlobalLocationVM.a tko;
  public bap tkm;
  private final c tkn;
  
  static
  {
    AppMethodBeat.i(206031);
    tko = new FinderGlobalLocationVM.a((byte)0);
    AppMethodBeat.o(206031);
  }
  
  public FinderGlobalLocationVM()
  {
    AppMethodBeat.i(206030);
    StringBuilder localStringBuilder = new StringBuilder("isGetGps=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    ae.i("Finder.GlobalLocationVM", com.tencent.mm.plugin.finder.storage.b.cIb());
    this.tkn = new c(this);
    AppMethodBeat.o(206030);
  }
  
  public static boolean cQK()
  {
    AppMethodBeat.i(206024);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.k(ak.getContext(), "android.permission.ACCESS_COARSE_LOCATION", false);
    AppMethodBeat.o(206024);
    return bool;
  }
  
  public static o<Float, Float> cQL()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(206027);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajA().get(am.a.Jdi, ";");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(206027);
      throw ((Throwable)localObject);
    }
    localObject = d.n.n.b((CharSequence)localObject, new char[] { ';' });
    Float localFloat = d.n.n.beJ((String)((List)localObject).get(0));
    if (localFloat != null) {}
    for (float f1 = localFloat.floatValue();; f1 = 0.0F)
    {
      localObject = d.n.n.beJ((String)((List)localObject).get(1));
      if (localObject != null) {
        f2 = ((Float)localObject).floatValue();
      }
      localObject = new o(Float.valueOf(f1), Float.valueOf(f2));
      AppMethodBeat.o(206027);
      return localObject;
    }
  }
  
  public static long cQM()
  {
    AppMethodBeat.i(206028);
    e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    long l = locale.ajA().a(am.a.Jdj, 0L);
    AppMethodBeat.o(206028);
    return l;
  }
  
  public static boolean h(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(206025);
    p.h(paramMMActivity, "activity");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramMMActivity, "android.permission.ACCESS_COARSE_LOCATION", 79, null, null);
    AppMethodBeat.o(206025);
    return bool;
  }
  
  public final void bZr()
  {
    AppMethodBeat.i(206026);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (!com.tencent.mm.plugin.finder.storage.b.cIb())
    {
      ae.w("Finder.GlobalLocationVM", "[requestLocation] is not enabel");
      AppMethodBeat.o(206026);
      return;
    }
    if (!cQK())
    {
      ae.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
      AppMethodBeat.o(206026);
      return;
    }
    ae.i("Finder.GlobalLocationVM", "[requestLocation]...");
    c.b(null, (d.g.a.a)new d(this));
    AppMethodBeat.o(206026);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(206029);
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(206029);
      return;
      com.tencent.mm.kernel.g.ajj().b(665, (f)this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.tkm = ((com.tencent.mm.plugin.location.model.g)paramn).diZ();
      }
      bap localbap = this.tkm;
      if (localbap != null)
      {
        if (bu.isNullOrNil(localbap.jge))
        {
          this.tkm = null;
          ae.i("Finder.GlobalLocationVM", "Get Location Fail");
          AppMethodBeat.o(206029);
          return;
        }
        paramn = localbap.jfW;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        localbap.jfW = paramString;
        paramn = localbap.jfX;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        localbap.jfX = paramString;
        ae.i("Finder.GlobalLocationVM", "Get Location " + localbap.jge + ' ' + localbap.jfW + ' ' + localbap.jfX);
        AppMethodBeat.o(206029);
        return;
      }
      ae.i("Finder.GlobalLocationVM", "Get Location Fail");
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public b(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-finder_release"})
  public static final class c
    implements b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(206020);
      d.aIh().c((b.a)this);
      final y.b localb1 = new y.b();
      localb1.NiU = paramFloat1;
      final y.b localb2 = new y.b();
      localb2.NiU = paramFloat2;
      Object localObject;
      if (paramBoolean)
      {
        FinderGlobalLocationVM.Q(paramFloat1, paramFloat2);
        ae.i("Finder.GlobalLocationVM", "[onGetLocation] longitude=" + localb1.NiU + " latitude=" + localb2.NiU);
        localObject = new hm();
        ((hm)localObject).dvb.lng = paramFloat1;
        ((hm)localObject).dvb.lat = paramFloat2;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        h.MqF.aO((Runnable)new a(this, localb2, localb1));
        AppMethodBeat.o(206020);
        return true;
        localObject = FinderGlobalLocationVM.cQL();
        localb1.NiU = ((Number)((o)localObject).first).floatValue();
        localb2.NiU = ((Number)((o)localObject).second).floatValue();
        ae.i("Finder.GlobalLocationVM", "[onGetLocation] from cache. longitude=" + localb1.NiU + " latitude=" + localb2.NiU);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderGlobalLocationVM.c paramc, y.b paramb1, y.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(206019);
        com.tencent.mm.plugin.location.model.g localg = new com.tencent.mm.plugin.location.model.g(localb2.NiU, localb1.NiU);
        com.tencent.mm.kernel.g.ajj().a(665, (f)this.tkq.tkp);
        com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)localg);
        AppMethodBeat.o(206019);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM
 * JD-Core Version:    0.7.0.1
 */