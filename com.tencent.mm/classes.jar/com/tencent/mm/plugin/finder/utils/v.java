package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSystemPermissionUI;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderLbsLogic;", "", "()V", "TAG", "", "asyncRequestLbs", "", "checkLocationBeforeCgi", "", "noPermission", "Lkotlin/Function0;", "cacheInvalid", "cacheValid", "checkLocationPermission", "requestLocationPermission", "activity", "Lcom/tencent/mm/ui/MMActivity;", "syncWaitLbs", "transferLbsLifeToFinderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "lbsLife", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "longitude", "", "latitude", "city", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v GgU;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333734);
    GgU = new v();
    TAG = "Finder.FinderLbsLogic";
    AppMethodBeat.o(333734);
  }
  
  public static boi a(dgz paramdgz, float paramFloat1, float paramFloat2, String paramString)
  {
    AppMethodBeat.i(333721);
    if (paramdgz == null)
    {
      AppMethodBeat.o(333721);
      return null;
    }
    boi localboi = new boi();
    localboi.longitude = paramFloat1;
    localboi.latitude = paramFloat2;
    localboi.city = paramString;
    localboi.poiName = paramdgz.hAP;
    paramString = paramdgz.MpN;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      localboi.ReU = paramString;
      localboi.ZWG = paramdgz.MpI;
      localboi.ReW = paramdgz.vhJ;
      AppMethodBeat.o(333721);
      return localboi;
      paramString = (etl)p.oL((List)paramString);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.toString();
      }
    }
  }
  
  public static void a(kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2, kotlin.g.a.a<ah> parama3)
  {
    AppMethodBeat.i(333674);
    Object localObject = k.aeZF;
    localObject = (g)k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).cq(g.class);
    if (!((g)localObject).dUi())
    {
      if (parama1 != null)
      {
        parama1.invoke();
        AppMethodBeat.o(333674);
      }
    }
    else
    {
      long l1 = com.tencent.mm.model.cn.bDu();
      long l2 = ((g)localObject).dUj();
      parama1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (l1 - l2 < com.tencent.mm.plugin.finder.storage.d.eRI())
      {
        parama3.invoke();
        AppMethodBeat.o(333674);
        return;
      }
      parama2.invoke();
    }
    AppMethodBeat.o(333674);
  }
  
  public static boolean eot()
  {
    AppMethodBeat.i(333682);
    k localk = k.aeZF;
    boolean bool = ((g)k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).cq(g.class)).dUi();
    AppMethodBeat.o(333682);
    return bool;
  }
  
  public static boolean feV()
  {
    AppMethodBeat.i(333698);
    k localk = k.aeZF;
    boolean bool = ((g)k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).cq(g.class)).pH(true);
    AppMethodBeat.o(333698);
    return bool;
  }
  
  public static boolean feW()
  {
    AppMethodBeat.i(333713);
    try
    {
      synchronized (new Object())
      {
        Log.i(TAG, "start syncWaitLbs");
        new FinderLbsLogic.syncWaitLbs.1.listener.1(???, f.hfK).alive();
        if (feV())
        {
          Log.i(TAG, "wait syncWaitLbs");
          com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          ???.wait(com.tencent.mm.plugin.finder.storage.d.eRJ());
          Log.i(TAG, "syncWaitLbs ok");
          AppMethodBeat.o(333713);
          return true;
        }
        Log.i(TAG, "syncWaitLbs no permission");
        AppMethodBeat.o(333713);
        return false;
      }
      return false;
    }
    finally
    {
      Log.printErrStackTrace(TAG, localThrowable, "syncWaitLbs exception", new Object[0]);
      AppMethodBeat.o(333713);
    }
  }
  
  public static void k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(333691);
    s.u(paramMMActivity, "activity");
    if ((((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actu, d.a.acsN)) && (((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actu, d.a.acsO))) {}
    Object localObject;
    for (int i = 1; !eot(); i = 0)
    {
      localObject = k.aeZF;
      ((g)k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).cq(g.class)).h(paramMMActivity);
      AppMethodBeat.o(333691);
      return;
    }
    if (i == 0)
    {
      localObject = new Intent((Context)paramMMActivity, SettingsSystemPermissionUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/utils/FinderLbsLogic", "requestLocationPermission", "(Lcom/tencent/mm/ui/MMActivity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramMMActivity, "com/tencent/mm/plugin/finder/utils/FinderLbsLogic", "requestLocationPermission", "(Lcom/tencent/mm/ui/MMActivity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(333691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.v
 * JD-Core Version:    0.7.0.1
 */