package com.tencent.mm.plugin.finder.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.b;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "lastAddress", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "getLastAddress", "()Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "setLastAddress", "(Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;)V", "locationListener", "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1;", "checkLocationPermissionWithRequest", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "checkLocationPermissionWithoutRequest", "forceRequestLocation", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLocation", "requestLocationPermission", "storeLocation", "longitude", "latitude", "Companion", "plugin-finder_release"})
public final class FinderGlobalLocationVM
  extends UIComponentPlugin<PluginFinder>
  implements com.tencent.mm.ak.i
{
  public static final a wtQ;
  public bme wtO;
  private final c wtP;
  
  static
  {
    AppMethodBeat.i(255328);
    wtQ = new a((byte)0);
    AppMethodBeat.o(255328);
  }
  
  public FinderGlobalLocationVM()
  {
    AppMethodBeat.i(255327);
    StringBuilder localStringBuilder = new StringBuilder("isGetGps=");
    c localc = c.vCb;
    Log.i("Finder.GlobalLocationVM", c.drM());
    this.wtP = new c(this);
    AppMethodBeat.o(255327);
  }
  
  public static boolean dHO()
  {
    AppMethodBeat.i(255321);
    boolean bool = b.k(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION", false);
    AppMethodBeat.o(255321);
    return bool;
  }
  
  public static o<Float, Float> dHP()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(255324);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.Omx, ";");
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(255324);
      throw ((Throwable)localObject);
    }
    localObject = n.a((CharSequence)localObject, new char[] { ';' });
    Float localFloat = n.buy((String)((List)localObject).get(0));
    if (localFloat != null) {}
    for (float f1 = localFloat.floatValue();; f1 = 0.0F)
    {
      localObject = n.buy((String)((List)localObject).get(1));
      if (localObject != null) {
        f2 = ((Float)localObject).floatValue();
      }
      localObject = new o(Float.valueOf(f1), Float.valueOf(f2));
      AppMethodBeat.o(255324);
      return localObject;
    }
  }
  
  public static long dHQ()
  {
    AppMethodBeat.i(255325);
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    long l = locale.azQ().a(ar.a.Omy, 0L);
    AppMethodBeat.o(255325);
    return l;
  }
  
  public static boolean h(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(255322);
    p.h(paramMMActivity, "activity");
    boolean bool = b.a((Activity)paramMMActivity, "android.permission.ACCESS_FINE_LOCATION", 79, null, null);
    AppMethodBeat.o(255322);
    return bool;
  }
  
  public final void cxh()
  {
    AppMethodBeat.i(255323);
    c localc = c.vCb;
    if (!c.drM())
    {
      Log.w("Finder.GlobalLocationVM", "[requestLocation] is not enabel");
      AppMethodBeat.o(255323);
      return;
    }
    if (!dHO())
    {
      Log.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
      AppMethodBeat.o(255323);
      return;
    }
    Log.i("Finder.GlobalLocationVM", "[requestLocation]...");
    com.tencent.mm.ac.d.c("Finder.GlobalLocationVM#RequestLocation", (kotlin.g.a.a)new d(this));
    AppMethodBeat.o(255323);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(255326);
    if (paramq != null) {
      switch (paramq.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(255326);
      return;
      com.tencent.mm.kernel.g.azz().b(665, (com.tencent.mm.ak.i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.wtO = ((com.tencent.mm.plugin.location.model.g)paramq).ecK();
      }
      bme localbme = this.wtO;
      if (localbme != null)
      {
        if (Util.isNullOrNil(localbme.keh))
        {
          this.wtO = null;
          Log.i("Finder.GlobalLocationVM", "Get Location Fail");
          AppMethodBeat.o(255326);
          return;
        }
        paramq = localbme.kdZ;
        paramString = paramq;
        if (paramq == null) {
          paramString = "";
        }
        localbme.kdZ = paramString;
        paramq = localbme.kea;
        paramString = paramq;
        if (paramq == null) {
          paramString = "";
        }
        localbme.kea = paramString;
        Log.i("Finder.GlobalLocationVM", "Get Location " + localbme.keh + ' ' + localbme.kdZ + ' ' + localbme.kea);
        AppMethodBeat.o(255326);
        return;
      }
      Log.i("Finder.GlobalLocationVM", "Get Location Fail");
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$Companion;", "", "()V", "REQUST_PERMISSION_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public b(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-finder_release"})
  public static final class c
    implements b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(255317);
      com.tencent.mm.modelgeo.d.bca().c((b.a)this);
      final z.b localb1 = new z.b();
      localb1.SYC = paramFloat1;
      final z.b localb2 = new z.b();
      localb2.SYC = paramFloat2;
      Object localObject;
      if (paramBoolean)
      {
        FinderGlobalLocationVM.U(paramFloat1, paramFloat2);
        Log.i("Finder.GlobalLocationVM", "[onGetLocation] longitude=" + localb1.SYC + " latitude=" + localb2.SYC);
        localObject = new hy();
        ((hy)localObject).dMA.lng = paramFloat1;
        ((hy)localObject).dMA.lat = paramFloat2;
        EventCenter.instance.publish((IEvent)localObject);
      }
      for (;;)
      {
        h.RTc.aX((Runnable)new a(this, localb2, localb1));
        AppMethodBeat.o(255317);
        return true;
        localObject = FinderGlobalLocationVM.dHP();
        localb1.SYC = ((Number)((o)localObject).first).floatValue();
        localb2.SYC = ((Number)((o)localObject).second).floatValue();
        Log.i("Finder.GlobalLocationVM", "[onGetLocation] from cache. longitude=" + localb1.SYC + " latitude=" + localb2.SYC);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderGlobalLocationVM.c paramc, z.b paramb1, z.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(255316);
        com.tencent.mm.plugin.location.model.g localg = new com.tencent.mm.plugin.location.model.g(localb2.SYC, localb1.SYC);
        com.tencent.mm.kernel.g.azz().a(665, (com.tencent.mm.ak.i)this.wtS.wtR);
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localg);
        AppMethodBeat.o(255316);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderGlobalLocationVM paramFinderGlobalLocationVM)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  public static final class e
    implements DialogInterface.OnClickListener
  {
    public e(MMActivity paramMMActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(255319);
      paramDialogInterface = k.vfA;
      k.ac((Context)this.nbB, 4);
      paramDialogInterface = this.nbB;
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(255319);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  public static final class f
    implements DialogInterface.OnClickListener
  {
    public f(MMActivity paramMMActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(255320);
      paramDialogInterface = k.vfA;
      k.ac((Context)this.nbB, 3);
      AppMethodBeat.o(255320);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM
 * JD-Core Version:    0.7.0.1
 */