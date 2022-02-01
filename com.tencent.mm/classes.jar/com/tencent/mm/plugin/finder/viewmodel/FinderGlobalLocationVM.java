package com.tencent.mm.plugin.finder.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.k;
import d.g.b.v.f;
import d.o;
import d.v;
import d.y;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "lastAddress", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "getLastAddress", "()Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "setLastAddress", "(Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;)V", "locationListener", "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1;", "checkLocationPermissionWithRequest", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "checkLocationPermissionWithoutRequest", "forceRequestLocation", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLocation", "requestLocationPermission", "storeLocation", "longitude", "latitude", "Companion", "plugin-finder_release"})
public final class FinderGlobalLocationVM
  extends UIComponentPlugin<PluginFinder>
  implements com.tencent.mm.al.g
{
  public static final a LgU;
  public asx LgS;
  private final c LgT;
  
  static
  {
    AppMethodBeat.i(200299);
    LgU = new a((byte)0);
    AppMethodBeat.o(200299);
  }
  
  public FinderGlobalLocationVM()
  {
    AppMethodBeat.i(200298);
    StringBuilder localStringBuilder = new StringBuilder("isGetGps=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    ad.i("Finder.GlobalLocationVM", com.tencent.mm.plugin.finder.storage.b.cpJ());
    this.LgT = new c(this);
    AppMethodBeat.o(200298);
  }
  
  public static boolean fXe()
  {
    AppMethodBeat.i(200292);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.k(aj.getContext(), "android.permission.ACCESS_COARSE_LOCATION", false);
    AppMethodBeat.o(200292);
    return bool;
  }
  
  public static o<Float, Float> fXf()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(200295);
    Object localObject = com.tencent.mm.kernel.g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).afk().get(ae.a.LBr, ";");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(200295);
      throw ((Throwable)localObject);
    }
    localObject = d.n.n.a((CharSequence)localObject, new char[] { ';' });
    Float localFloat = d.n.n.aRd((String)((List)localObject).get(0));
    if (localFloat != null) {}
    for (float f1 = localFloat.floatValue();; f1 = 0.0F)
    {
      localObject = d.n.n.aRd((String)((List)localObject).get(1));
      if (localObject != null) {
        f2 = ((Float)localObject).floatValue();
      }
      localObject = new o(Float.valueOf(f1), Float.valueOf(f2));
      AppMethodBeat.o(200295);
      return localObject;
    }
  }
  
  public static long fXg()
  {
    AppMethodBeat.i(200296);
    e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    long l = locale.afk().a(ae.a.LBs, 0L);
    AppMethodBeat.o(200296);
    return l;
  }
  
  public static boolean r(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(200293);
    k.h(paramMMActivity, "activity");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramMMActivity, "android.permission.ACCESS_COARSE_LOCATION", 79, null, null);
    AppMethodBeat.o(200293);
    return bool;
  }
  
  public final void bMk()
  {
    AppMethodBeat.i(200294);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.cpJ())
    {
      ad.w("Finder.GlobalLocationVM", "[requestLocation] is not enabel");
      AppMethodBeat.o(200294);
      return;
    }
    if (!fXe())
    {
      ad.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
      AppMethodBeat.o(200294);
      return;
    }
    ad.i("Finder.GlobalLocationVM", "[requestLocation]...");
    c.b(null, (d.g.a.a)new d(this));
    AppMethodBeat.o(200294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(200297);
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200297);
      return;
      com.tencent.mm.kernel.g.aeS().b(665, (com.tencent.mm.al.g)this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.LgS = ((com.tencent.mm.plugin.location.model.g)paramn).cJj();
      }
      asx localasx = this.LgS;
      if (localasx != null)
      {
        if (bt.isNullOrNil(localasx.ijV))
        {
          this.LgS = null;
          ad.i("Finder.GlobalLocationVM", "Get Location Fail");
          AppMethodBeat.o(200297);
          return;
        }
        paramn = localasx.ijN;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        localasx.ijN = paramString;
        paramn = localasx.ijO;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        localasx.ijO = paramString;
        ad.i("Finder.GlobalLocationVM", "Get Location " + localasx.ijV + ' ' + localasx.ijN + ' ' + localasx.ijO);
        AppMethodBeat.o(200297);
        return;
      }
      ad.i("Finder.GlobalLocationVM", "Get Location Fail");
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$Companion;", "", "()V", "REQUST_PERMISSION_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public b(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-finder_release"})
  public static final class c
    implements b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(200288);
      d.axT().c((b.a)this);
      final v.f localf1 = new v.f();
      localf1.LEv = paramFloat1;
      final v.f localf2 = new v.f();
      localf2.LEv = paramFloat2;
      Object localObject;
      if (paramBoolean)
      {
        FinderGlobalLocationVM.aq(paramFloat1, paramFloat2);
        ad.i("Finder.GlobalLocationVM", "[onGetLocation] longitude=" + localf1.LEv + " latitude=" + localf2.LEv);
        localObject = new ym();
        ((ym)localObject).aCC.lng = paramFloat1;
        ((ym)localObject).aCC.lat = paramFloat2;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        h.Iye.aP((Runnable)new a(this, localf2, localf1));
        AppMethodBeat.o(200288);
        return true;
        localObject = FinderGlobalLocationVM.fXf();
        localf1.LEv = ((Number)((o)localObject).first).floatValue();
        localf2.LEv = ((Number)((o)localObject).second).floatValue();
        ad.i("Finder.GlobalLocationVM", "[onGetLocation] from cache. longitude=" + localf1.LEv + " latitude=" + localf2.LEv);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderGlobalLocationVM.c paramc, v.f paramf1, v.f paramf2) {}
      
      public final void run()
      {
        AppMethodBeat.i(200287);
        com.tencent.mm.plugin.location.model.g localg = new com.tencent.mm.plugin.location.model.g(localf2.LEv, localf1.LEv);
        com.tencent.mm.kernel.g.aeS().a(665, (com.tencent.mm.al.g)this.LgW.LgV);
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)localg);
        AppMethodBeat.o(200287);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  public static final class e
    implements DialogInterface.OnClickListener
  {
    public e(MMActivity paramMMActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(200290);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.aS((Context)this.qCc, 4);
      paramDialogInterface = this.qCc;
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(200290);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  public static final class f
    implements DialogInterface.OnClickListener
  {
    public f(MMActivity paramMMActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(200291);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.aS((Context)this.qCc, 3);
      AppMethodBeat.o(200291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM
 * JD-Core Version:    0.7.0.1
 */