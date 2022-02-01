package com.tencent.mm.plugin.finder.viewmodel;

import android.app.Activity;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.k;
import d.g.b.v.b;
import d.o;
import d.v;
import d.y;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "lastAddress", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "getLastAddress", "()Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "setLastAddress", "(Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;)V", "locationListener", "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1;", "checkLocationPermissionWithRequest", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "checkLocationPermissionWithoutRequest", "forceRequestLocation", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLocation", "requestLocationPermission", "storeLocation", "longitude", "latitude", "Companion", "plugin-finder_release"})
public final class FinderGlobalLocationVM
  extends UIComponentPlugin<PluginFinder>
  implements com.tencent.mm.ak.g
{
  public static final FinderGlobalLocationVM.a sbK;
  public awb sbI;
  private final c sbJ;
  
  static
  {
    AppMethodBeat.i(204369);
    sbK = new FinderGlobalLocationVM.a((byte)0);
    AppMethodBeat.o(204369);
  }
  
  public FinderGlobalLocationVM()
  {
    AppMethodBeat.i(204368);
    StringBuilder localStringBuilder = new StringBuilder("isGetGps=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    ac.i("Finder.GlobalLocationVM", com.tencent.mm.plugin.finder.storage.b.czj());
    this.sbJ = new c(this);
    AppMethodBeat.o(204368);
  }
  
  public static boolean cFG()
  {
    AppMethodBeat.i(204362);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.j(ai.getContext(), "android.permission.ACCESS_COARSE_LOCATION", false);
    AppMethodBeat.o(204362);
    return bool;
  }
  
  public static o<Float, Float> cFH()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(204365);
    Object localObject = com.tencent.mm.kernel.g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).agA().get(ah.a.GVP, ";");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204365);
      throw ((Throwable)localObject);
    }
    localObject = d.n.n.b((CharSequence)localObject, new char[] { ';' });
    Float localFloat = d.n.n.aXc((String)((List)localObject).get(0));
    if (localFloat != null) {}
    for (float f1 = localFloat.floatValue();; f1 = 0.0F)
    {
      localObject = d.n.n.aXc((String)((List)localObject).get(1));
      if (localObject != null) {
        f2 = ((Float)localObject).floatValue();
      }
      localObject = new o(Float.valueOf(f1), Float.valueOf(f2));
      AppMethodBeat.o(204365);
      return localObject;
    }
  }
  
  public static long cFI()
  {
    AppMethodBeat.i(204366);
    e locale = com.tencent.mm.kernel.g.agR();
    k.g(locale, "MMKernel.storage()");
    long l = locale.agA().a(ah.a.GVQ, 0L);
    AppMethodBeat.o(204366);
    return l;
  }
  
  public static boolean g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(204363);
    k.h(paramMMActivity, "activity");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramMMActivity, "android.permission.ACCESS_COARSE_LOCATION", 79, null, null);
    AppMethodBeat.o(204363);
    return bool;
  }
  
  public final void bTx()
  {
    AppMethodBeat.i(204364);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (!com.tencent.mm.plugin.finder.storage.b.czj())
    {
      ac.w("Finder.GlobalLocationVM", "[requestLocation] is not enabel");
      AppMethodBeat.o(204364);
      return;
    }
    if (!cFG())
    {
      ac.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
      AppMethodBeat.o(204364);
      return;
    }
    ac.i("Finder.GlobalLocationVM", "[requestLocation]...");
    c.b(null, (d.g.a.a)new d(this));
    AppMethodBeat.o(204364);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(204367);
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(204367);
      return;
      com.tencent.mm.kernel.g.agi().b(665, (com.tencent.mm.ak.g)this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.sbI = ((com.tencent.mm.plugin.location.model.g)paramn).cWO();
      }
      awb localawb = this.sbI;
      if (localawb != null)
      {
        if (bs.isNullOrNil(localawb.iKc))
        {
          this.sbI = null;
          ac.i("Finder.GlobalLocationVM", "Get Location Fail");
          AppMethodBeat.o(204367);
          return;
        }
        paramn = localawb.iJU;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        localawb.iJU = paramString;
        paramn = localawb.iJV;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        localawb.iJV = paramString;
        ac.i("Finder.GlobalLocationVM", "Get Location " + localawb.iKc + ' ' + localawb.iJU + ' ' + localawb.iJV);
        AppMethodBeat.o(204367);
        return;
      }
      ac.i("Finder.GlobalLocationVM", "Get Location Fail");
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public b(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-finder_release"})
  public static final class c
    implements b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(204358);
      d.aEL().c((b.a)this);
      final v.b localb1 = new v.b();
      localb1.KUM = paramFloat1;
      final v.b localb2 = new v.b();
      localb2.KUM = paramFloat2;
      Object localObject;
      if (paramBoolean)
      {
        FinderGlobalLocationVM.O(paramFloat1, paramFloat2);
        ac.i("Finder.GlobalLocationVM", "[onGetLocation] longitude=" + localb1.KUM + " latitude=" + localb2.KUM);
        localObject = new hg();
        ((hg)localObject).diq.lng = paramFloat1;
        ((hg)localObject).diq.lat = paramFloat2;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        h.JZN.aS((Runnable)new a(this, localb2, localb1));
        AppMethodBeat.o(204358);
        return true;
        localObject = FinderGlobalLocationVM.cFH();
        localb1.KUM = ((Number)((o)localObject).first).floatValue();
        localb2.KUM = ((Number)((o)localObject).second).floatValue();
        ac.i("Finder.GlobalLocationVM", "[onGetLocation] from cache. longitude=" + localb1.KUM + " latitude=" + localb2.KUM);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderGlobalLocationVM.c paramc, v.b paramb1, v.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(204357);
        com.tencent.mm.plugin.location.model.g localg = new com.tencent.mm.plugin.location.model.g(localb2.KUM, localb1.KUM);
        com.tencent.mm.kernel.g.agi().a(665, (com.tencent.mm.ak.g)this.sbM.sbL);
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)localg);
        AppMethodBeat.o(204357);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM
 * JD-Core Version:    0.7.0.1
 */