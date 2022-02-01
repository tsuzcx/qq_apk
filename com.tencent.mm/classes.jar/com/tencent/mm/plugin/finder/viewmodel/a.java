package com.tencent.mm.plugin.finder.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.il;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.location.model.g;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import kotlin.g.b.aa.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/api/IFinderGlobalLocationVM;", "()V", "lastAddress", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "getLastAddress", "()Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "setLastAddress", "(Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;)V", "locationListener", "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1;", "checkLocationPermissionWithRequest", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "checkLocationPermissionWithoutRequest", "forceRequestLocation", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLocation", "requestLocationPermission", "storeLocation", "longitude", "latitude", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.ui.component.i<PluginFinder>
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.finder.api.f
{
  public static final a Bgh;
  public btn Bgf;
  private final c Bgg;
  
  static
  {
    AppMethodBeat.i(289642);
    Bgh = new a((byte)0);
    AppMethodBeat.o(289642);
  }
  
  public a()
  {
    AppMethodBeat.i(289641);
    StringBuilder localStringBuilder = new StringBuilder("isGetGps=");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    Log.i("Finder.GlobalLocationVM", com.tencent.mm.plugin.finder.storage.d.dTc());
    this.Bgg = new c(this);
    AppMethodBeat.o(289641);
  }
  
  public static boolean ejZ()
  {
    AppMethodBeat.i(289634);
    boolean bool = b.k(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION", false);
    AppMethodBeat.o(289634);
    return bool;
  }
  
  public static long eka()
  {
    AppMethodBeat.i(289638);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    long l = localf.aHp().a(ar.a.VBv, 0L);
    AppMethodBeat.o(289638);
    return l;
  }
  
  public static boolean i(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(289635);
    p.k(paramMMActivity, "activity");
    boolean bool = b.a((Activity)paramMMActivity, "android.permission.ACCESS_FINE_LOCATION", 79, null, null);
    AppMethodBeat.o(289635);
    return bool;
  }
  
  public final void cKK()
  {
    AppMethodBeat.i(289636);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (!com.tencent.mm.plugin.finder.storage.d.dTc())
    {
      Log.w("Finder.GlobalLocationVM", "[requestLocation] is not enabel");
      AppMethodBeat.o(289636);
      return;
    }
    if (!ejZ())
    {
      Log.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
      AppMethodBeat.o(289636);
      return;
    }
    Log.i("Finder.GlobalLocationVM", "[requestLocation]...");
    com.tencent.mm.ae.d.c("Finder.GlobalLocationVM#RequestLocation", (kotlin.g.a.a)new d(this));
    AppMethodBeat.o(289636);
  }
  
  public final o<Float, Float> dnl()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(289637);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VBu, ";");
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(289637);
      throw ((Throwable)localObject);
    }
    localObject = kotlin.n.n.a((CharSequence)localObject, new char[] { ';' });
    Float localFloat = kotlin.n.n.bHA((String)((List)localObject).get(0));
    if (localFloat != null) {}
    for (float f1 = localFloat.floatValue();; f1 = 0.0F)
    {
      localObject = kotlin.n.n.bHA((String)((List)localObject).get(1));
      if (localObject != null) {
        f2 = ((Float)localObject).floatValue();
      }
      localObject = new o(Float.valueOf(f1), Float.valueOf(f2));
      AppMethodBeat.o(289637);
      return localObject;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(289639);
    if (paramq != null) {
      switch (paramq.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(289639);
      return;
      com.tencent.mm.kernel.h.aGY().b(665, (com.tencent.mm.an.i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        this.Bgf = ((g)paramq).eMc();
      }
      btn localbtn = this.Bgf;
      if (localbtn != null)
      {
        if (Util.isNullOrNil(localbtn.mVH))
        {
          this.Bgf = null;
          Log.i("Finder.GlobalLocationVM", "Get Location Fail");
          AppMethodBeat.o(289639);
          return;
        }
        paramq = localbtn.mVz;
        paramString = paramq;
        if (paramq == null) {
          paramString = "";
        }
        localbtn.mVz = paramString;
        paramq = localbtn.mVA;
        paramString = paramq;
        if (paramq == null) {
          paramString = "";
        }
        localbtn.mVA = paramString;
        Log.i("Finder.GlobalLocationVM", "Get Location " + localbtn.mVH + ' ' + localbtn.mVz + ' ' + localbtn.mVA);
        AppMethodBeat.o(289639);
        return;
      }
      Log.i("Finder.GlobalLocationVM", "Get Location Fail");
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$Companion;", "", "()V", "REQUST_PERMISSION_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-finder_release"})
  public static final class c
    implements b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(292248);
      com.tencent.mm.modelgeo.d.blq().b((b.a)this);
      final aa.b localb1 = new aa.b();
      localb1.aaBy = paramFloat1;
      final aa.b localb2 = new aa.b();
      localb2.aaBy = paramFloat2;
      Object localObject;
      if (paramBoolean)
      {
        a.W(paramFloat1, paramFloat2);
        Log.i("Finder.GlobalLocationVM", "[onGetLocation] longitude=" + localb1.aaBy + " latitude=" + localb2.aaBy);
        localObject = new il();
        ((il)localObject).fFF.lng = paramFloat1;
        ((il)localObject).fFF.lat = paramFloat2;
        EventCenter.instance.publish((IEvent)localObject);
      }
      for (;;)
      {
        com.tencent.e.h.ZvG.be((Runnable)new a(this, localb2, localb1));
        AppMethodBeat.o(292248);
        return true;
        localObject = this.Bgi.dnl();
        localb1.aaBy = ((Number)((o)localObject).Mx).floatValue();
        localb2.aaBy = ((Number)((o)localObject).My).floatValue();
        Log.i("Finder.GlobalLocationVM", "[onGetLocation] from cache. longitude=" + localb1.aaBy + " latitude=" + localb2.aaBy);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.c paramc, aa.b paramb1, aa.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(274662);
        g localg = new g(localb2.aaBy, localb1.aaBy);
        com.tencent.mm.kernel.h.aGY().a(665, (com.tencent.mm.an.i)this.Bgj.Bgi);
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localg);
        AppMethodBeat.o(274662);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  public static final class e
    implements DialogInterface.OnClickListener
  {
    public e(MMActivity paramMMActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(272275);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.al((Context)this.mpU, 4);
      paramDialogInterface = this.mpU;
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(272275);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  public static final class f
    implements DialogInterface.OnClickListener
  {
    public f(MMActivity paramMMActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(281842);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.al((Context)this.mpU, 3);
      AppMethodBeat.o(281842);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.a
 * JD-Core Version:    0.7.0.1
 */