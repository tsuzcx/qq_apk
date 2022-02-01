package com.tencent.mm.plugin.finder.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jc;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/plugin/finder/api/IFinderGlobalLocationVM;", "()V", "lastAddress", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "getLastAddress", "()Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "setLastAddress", "(Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;)V", "locationListener", "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1;", "checkLocationPermissionWithRequest", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "checkLocationPermissionWithoutRequest", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "requestLocation", "isIgnoreConfig", "requestLocationPermissionWithAlert", "", "storeLocation", "longitude", "latitude", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.ui.component.n<PluginFinder>
  implements g
{
  public static final a GJY;
  public cig GJZ;
  private final b GKa;
  
  static
  {
    AppMethodBeat.i(337233);
    GJY = new a((byte)0);
    AppMethodBeat.o(337233);
  }
  
  public b()
  {
    AppMethodBeat.i(337186);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    Log.i("Finder.GlobalLocationVM", s.X("isGetGps=", Boolean.valueOf(com.tencent.mm.plugin.finder.storage.d.eRr())));
    this.GKa = new b(this);
    AppMethodBeat.o(337186);
  }
  
  private static final void a(MMActivity paramMMActivity, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(337196);
    s.u(paramMMActivity, "$activity");
    paramDialogInterface = z.FrZ;
    z.av((Context)paramMMActivity, 4);
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramMMActivity);
    AppMethodBeat.o(337196);
  }
  
  private static final void b(MMActivity paramMMActivity, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(337202);
    s.u(paramMMActivity, "$activity");
    paramDialogInterface = z.FrZ;
    z.av((Context)paramMMActivity, 3);
    AppMethodBeat.o(337202);
  }
  
  public final r<Float, Float> dUh()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(337278);
    Object localObject = h.baE().ban().get(at.a.addQ, ";");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(337278);
      throw ((Throwable)localObject);
    }
    localObject = kotlin.n.n.a((CharSequence)localObject, new char[] { ';' }, 0, 6);
    Float localFloat = kotlin.n.n.bJE((String)((List)localObject).get(0));
    float f1;
    if (localFloat == null)
    {
      f1 = 0.0F;
      localObject = kotlin.n.n.bJE((String)((List)localObject).get(1));
      if (localObject != null) {
        break label137;
      }
    }
    for (;;)
    {
      localObject = new r(Float.valueOf(f1), Float.valueOf(f2));
      AppMethodBeat.o(337278);
      return localObject;
      f1 = localFloat.floatValue();
      break;
      label137:
      f2 = ((Float)localObject).floatValue();
    }
  }
  
  public final boolean dUi()
  {
    AppMethodBeat.i(337262);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.k(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION", false);
    AppMethodBeat.o(337262);
    return bool;
  }
  
  public final long dUj()
  {
    AppMethodBeat.i(337283);
    long l = h.baE().ban().a(at.a.addR, 0L);
    Log.i("Finder.GlobalLocationVM", s.X("[lastLocationTime] time=", Long.valueOf(l)));
    AppMethodBeat.o(337283);
    return l;
  }
  
  public final void h(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(337294);
    s.u(paramMMActivity, "activity");
    if ((Build.VERSION.SDK_INT > 23) && (!paramMMActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")))
    {
      com.tencent.mm.ui.base.k.a((Context)paramMMActivity, paramMMActivity.getString(e.h.permission_location_request_again_msg), paramMMActivity.getString(e.h.permission_tips_title), paramMMActivity.getString(e.h.jump_to_settings), paramMMActivity.getString(e.h.app_cancel), false, new b..ExternalSyntheticLambda1(paramMMActivity), new b..ExternalSyntheticLambda0(paramMMActivity));
      AppMethodBeat.o(337294);
      return;
    }
    s.u(paramMMActivity, "activity");
    com.tencent.mm.pluginsdk.permission.b.a((Activity)paramMMActivity, "android.permission.ACCESS_FINE_LOCATION", 79, null);
    AppMethodBeat.o(337294);
  }
  
  public final boolean pH(boolean paramBoolean)
  {
    AppMethodBeat.i(337268);
    if (!paramBoolean)
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRr())
      {
        Log.w("Finder.GlobalLocationVM", "[requestLocation] is not enabel");
        AppMethodBeat.o(337268);
        return false;
      }
    }
    if (!dUi())
    {
      Log.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
      AppMethodBeat.o(337268);
      return false;
    }
    Log.i("Finder.GlobalLocationVM", s.X("[requestLocation]... ", Util.getStack()));
    com.tencent.mm.ae.d.e("Finder.GlobalLocationVM#RequestLocation", (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(337268);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$Companion;", "", "()V", "REQUST_PERMISSION_CODE", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.modelgeo.b.a
  {
    b(b paramb) {}
    
    public final boolean onGetLocation(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
    {
      AppMethodBeat.i(337255);
      com.tencent.mm.modelgeo.d.bJl().a((com.tencent.mm.modelgeo.b.a)this);
      final ah.b localb1 = new ah.b();
      localb1.aiwZ = paramFloat1;
      final ah.b localb2 = new ah.b();
      localb2.aiwZ = paramFloat2;
      Object localObject;
      if (paramBoolean)
      {
        b.aD(paramFloat1, paramFloat2);
        Log.i("Finder.GlobalLocationVM", "[onGetLocation] longitude=" + localb1.aiwZ + " latitude=" + localb2.aiwZ);
        localObject = new jc();
        ((jc)localObject).hKK.lng = paramFloat1;
        ((jc)localObject).hKK.lat = paramFloat2;
        ((jc)localObject).publish();
      }
      for (;;)
      {
        e.launch$default((e)this.GKb, null, null, (m)new a(this.GKb, localb2, localb1, null), 3, null);
        AppMethodBeat.o(337255);
        return true;
        localObject = this.GKb.dUh();
        localb1.aiwZ = ((Number)((r)localObject).bsC).floatValue();
        localb2.aiwZ = ((Number)((r)localObject).bsD).floatValue();
        Log.i("Finder.GlobalLocationVM", "[onGetLocation] from cache. longitude=" + localb1.aiwZ + " latitude=" + localb2.aiwZ);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<kotlinx.coroutines.aq, kotlin.d.d<? super ah>, Object>
    {
      Object Uf;
      int label;
      
      a(b paramb, ah.b paramb1, ah.b paramb2, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(337133);
        paramd = new a(this.GKb, localb2, localb1, paramd);
        paramd.L$0 = paramObject;
        paramObject = (kotlin.d.d)paramd;
        AppMethodBeat.o(337133);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(337120);
        localObject2 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(337120);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.GKb;
          localObject1 = localb2;
          localObject3 = localb1;
        }
        try
        {
          Result.Companion localCompanion = Result.Companion;
          localObject1 = (com.tencent.mm.am.b)new ax(((ah.b)localObject1).aiwZ, ((ah.b)localObject3).aiwZ);
          this.L$0 = paramObject;
          this.Uf = paramObject;
          this.label = 1;
          localObject1 = com.tencent.mm.af.b.a((com.tencent.mm.am.b)localObject1, this);
          if (localObject1 != localObject2) {
            break label360;
          }
          AppMethodBeat.o(337120);
          return localObject2;
        }
        finally
        {
          for (;;)
          {
            localObject1 = Result.Companion;
            paramObject = Result.constructor-impl(ResultKt.createFailure(paramObject));
            continue;
            localObject2 = paramObject;
          }
        }
        localObject2 = (b)this.Uf;
        Object localObject3 = (b)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject3;
        ((b)localObject2).GJZ = ((cig)localObject1);
        localObject2 = paramObject.GJZ;
        if (localObject2 == null)
        {
          paramObject = null;
          if (paramObject == null) {
            Log.i("Finder.GlobalLocationVM", "Get Location Fail");
          }
          paramObject = Result.constructor-impl(ah.aiuX);
          paramObject = Result.exceptionOrNull-impl(paramObject);
          if (paramObject != null) {
            Log.printErrStackTrace("Finder.GlobalLocationVM", paramObject, "", new Object[0]);
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(337120);
          return paramObject;
        }
        if (Util.isNullOrNil(((cig)localObject2).pSo))
        {
          paramObject.GJZ = null;
          Log.i("Finder.GlobalLocationVM", "Get Location Fail");
        }
        for (;;)
        {
          paramObject = ah.aiuX;
          break;
          localObject1 = ((cig)localObject2).pSg;
          paramObject = localObject1;
          if (localObject1 == null) {
            paramObject = "";
          }
          ((cig)localObject2).pSg = paramObject;
          localObject1 = ((cig)localObject2).pSh;
          paramObject = localObject1;
          if (localObject1 == null) {
            paramObject = "";
          }
          ((cig)localObject2).pSh = paramObject;
          Log.i("Finder.GlobalLocationVM", "Get Location " + ((cig)localObject2).pSo + ' ' + ((cig)localObject2).pSg + ' ' + ((cig)localObject2).pSh);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.b
 * JD-Core Version:    0.7.0.1
 */