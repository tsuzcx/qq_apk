package com.tencent.mm.plugin.finder.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.p;
import d.g.b.y.b;
import d.l;
import d.o;
import d.v;
import d.z;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "lastAddress", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "getLastAddress", "()Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "setLastAddress", "(Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;)V", "locationListener", "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1;", "checkLocationPermissionWithRequest", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "checkLocationPermissionWithoutRequest", "forceRequestLocation", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLocation", "requestLocationPermission", "storeLocation", "longitude", "latitude", "Companion", "plugin-finder_release"})
public final class FinderGlobalLocationVM
  extends UIComponentPlugin<PluginFinder>
  implements f
{
  public static final a sZa;
  public azz sYY;
  private final c sYZ;
  
  static
  {
    AppMethodBeat.i(205383);
    sZa = new a((byte)0);
    AppMethodBeat.o(205383);
  }
  
  public FinderGlobalLocationVM()
  {
    AppMethodBeat.i(205382);
    StringBuilder localStringBuilder = new StringBuilder("isGetGps=");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    ad.i("Finder.GlobalLocationVM", com.tencent.mm.plugin.finder.storage.b.cGe());
    this.sYZ = new c(this);
    AppMethodBeat.o(205382);
  }
  
  public static boolean cOa()
  {
    AppMethodBeat.i(205376);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.j(aj.getContext(), "android.permission.ACCESS_COARSE_LOCATION", false);
    AppMethodBeat.o(205376);
    return bool;
  }
  
  public static o<Float, Float> cOb()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(205379);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajl().get(al.a.IIF, ";");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(205379);
      throw ((Throwable)localObject);
    }
    localObject = d.n.n.b((CharSequence)localObject, new char[] { ';' });
    Float localFloat = d.n.n.bdf((String)((List)localObject).get(0));
    if (localFloat != null) {}
    for (float f1 = localFloat.floatValue();; f1 = 0.0F)
    {
      localObject = d.n.n.bdf((String)((List)localObject).get(1));
      if (localObject != null) {
        f2 = ((Float)localObject).floatValue();
      }
      localObject = new o(Float.valueOf(f1), Float.valueOf(f2));
      AppMethodBeat.o(205379);
      return localObject;
    }
  }
  
  public static long cOc()
  {
    AppMethodBeat.i(205380);
    e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    long l = locale.ajl().a(al.a.IIG, 0L);
    AppMethodBeat.o(205380);
    return l;
  }
  
  public static boolean h(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(205377);
    p.h(paramMMActivity, "activity");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramMMActivity, "android.permission.ACCESS_COARSE_LOCATION", 79, null, null);
    AppMethodBeat.o(205377);
    return bool;
  }
  
  public final void bYc()
  {
    AppMethodBeat.i(205378);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (!com.tencent.mm.plugin.finder.storage.b.cGe())
    {
      ad.w("Finder.GlobalLocationVM", "[requestLocation] is not enabel");
      AppMethodBeat.o(205378);
      return;
    }
    if (!cOa())
    {
      ad.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
      AppMethodBeat.o(205378);
      return;
    }
    ad.i("Finder.GlobalLocationVM", "[requestLocation]...");
    c.b(null, (d.g.a.a)new d(this));
    AppMethodBeat.o(205378);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(205381);
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205381);
      return;
      com.tencent.mm.kernel.g.aiU().b(665, (f)this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.sYY = ((com.tencent.mm.plugin.location.model.g)paramn).dga();
      }
      azz localazz = this.sYY;
      if (localazz != null)
      {
        if (bt.isNullOrNil(localazz.jdl))
        {
          this.sYY = null;
          ad.i("Finder.GlobalLocationVM", "Get Location Fail");
          AppMethodBeat.o(205381);
          return;
        }
        paramn = localazz.jdd;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        localazz.jdd = paramString;
        paramn = localazz.jde;
        paramString = paramn;
        if (paramn == null) {
          paramString = "";
        }
        localazz.jde = paramString;
        ad.i("Finder.GlobalLocationVM", "Get Location " + localazz.jdl + ' ' + localazz.jdd + ' ' + localazz.jde);
        AppMethodBeat.o(205381);
        return;
      }
      ad.i("Finder.GlobalLocationVM", "Get Location Fail");
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$Companion;", "", "()V", "REQUST_PERMISSION_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public b(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-finder_release"})
  public static final class c
    implements b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(205372);
      d.aHQ().c((b.a)this);
      final y.b localb1 = new y.b();
      localb1.MLR = paramFloat1;
      final y.b localb2 = new y.b();
      localb2.MLR = paramFloat2;
      Object localObject;
      if (paramBoolean)
      {
        FinderGlobalLocationVM.Q(paramFloat1, paramFloat2);
        ad.i("Finder.GlobalLocationVM", "[onGetLocation] longitude=" + localb1.MLR + " latitude=" + localb2.MLR);
        localObject = new hl();
        ((hl)localObject).dtW.lng = paramFloat1;
        ((hl)localObject).dtW.lat = paramFloat2;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        com.tencent.e.h.LTJ.aR((Runnable)new a(this, localb2, localb1));
        AppMethodBeat.o(205372);
        return true;
        localObject = FinderGlobalLocationVM.cOb();
        localb1.MLR = ((Number)((o)localObject).first).floatValue();
        localb2.MLR = ((Number)((o)localObject).second).floatValue();
        ad.i("Finder.GlobalLocationVM", "[onGetLocation] from cache. longitude=" + localb1.MLR + " latitude=" + localb2.MLR);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderGlobalLocationVM.c paramc, y.b paramb1, y.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(205371);
        com.tencent.mm.plugin.location.model.g localg = new com.tencent.mm.plugin.location.model.g(localb2.MLR, localb1.MLR);
        com.tencent.mm.kernel.g.aiU().a(665, (f)this.sZc.sZb);
        com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)localg);
        AppMethodBeat.o(205371);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  public static final class e
    implements DialogInterface.OnClickListener
  {
    public e(MMActivity paramMMActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(205374);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.W((Context)this.lPs, 4);
      paramDialogInterface = this.lPs;
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(205374);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  public static final class f
    implements DialogInterface.OnClickListener
  {
    public f(MMActivity paramMMActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(205375);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.W((Context)this.lPs, 3);
      AppMethodBeat.o(205375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM
 * JD-Core Version:    0.7.0.1
 */