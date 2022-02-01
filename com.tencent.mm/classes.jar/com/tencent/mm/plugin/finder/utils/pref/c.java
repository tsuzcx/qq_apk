package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterLiveShopPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "Lcom/tencent/mm/plugin/finder/utils/pref/WithPrepareResp;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "TAG", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "shopBindInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "shopInfo", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updatePrepareResp", "updateView", "isFromSceneEnd", "", "plugin-finder_release"})
public final class c
  implements i, j
{
  private final f AJD;
  private bln AJG;
  private final String TAG;
  private final Context context;
  private final String name;
  private ble wZz;
  private bln zSA;
  
  public c(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(273337);
    this.name = paramString;
    this.AJD = paramf;
    this.context = paramContext;
    this.TAG = "Finder.PosterCenterLiveShopPref";
    this.AJG = new bln();
    this.zSA = new bln();
    AppMethodBeat.o(273337);
  }
  
  public final void b(ble paramble)
  {
    AppMethodBeat.i(273336);
    p.k(paramble, "prepareResp");
    this.wZz = paramble;
    bln localbln2 = paramble.SWh;
    bln localbln1 = localbln2;
    if (localbln2 == null) {
      localbln1 = new bln();
    }
    this.AJG = localbln1;
    localbln1 = paramble.wxaShopInfo;
    paramble = localbln1;
    if (localbln1 == null) {
      paramble = new bln();
    }
    this.zSA = paramble;
    AppMethodBeat.o(273336);
  }
  
  public final String egv()
  {
    return this.name;
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(273334);
    Log.i(this.TAG, "update shop:" + this.AJG.appId + ',' + this.AJG.SWz);
    Object localObject2 = this.AJD.byG(this.name);
    p.j(localObject2, "preferenceScreen.findPreference(name)");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    Object localObject3;
    s locals;
    String str;
    if (com.tencent.mm.plugin.finder.storage.d.dXH())
    {
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      localObject1 = (CharSequence)((Context)localObject1).getResources().getString(b.j.finder_shop_shelf);
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      if (Util.isNullOrNil(this.AJG.appId)) {
        break label395;
      }
      this.AJD.dz(this.name, false);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dXH()) {
        break label410;
      }
      localObject3 = this.AJG;
      locals = s.xWG;
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject2 = ((bln)localObject3).appId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      str = ((bln)localObject3).SWz;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      str = ((bln)localObject3).Sba;
      if (str != null) {
        break label416;
      }
      str = "";
    }
    label395:
    label410:
    label416:
    for (;;)
    {
      p.k(localObject1, "appid");
      p.k(localObject2, "path");
      p.k(str, "appUsername");
      localObject3 = new g();
      ((g)localObject3).appId = ((String)localObject1);
      ((g)localObject3).nBq = ((String)localObject2);
      localObject1 = new at();
      ((at)localObject1).yiA = 1;
      ((at)localObject1).yiF = 1;
      ((g)localObject3).nBr = ((com.tencent.mm.plugin.appbrand.api.d)localObject1);
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {}
      for (int i = 1176;; i = 1177)
      {
        ((g)localObject3).scene = i;
        ((g)localObject3).nBE = new HalfScreenConfig(true, 10, null, false, null, false, null, null, false, false, null, null, false, 8188);
        ((g)localObject3).username = str;
        ((g)localObject3).cBU = com.tencent.mm.plugin.finder.live.utils.a.dEO();
        s.a(locals, null, (g)localObject3);
        AppMethodBeat.o(273334);
        return;
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = (CharSequence)((Context)localObject1).getResources().getString(b.j.finder_shop);
        break;
      }
      this.AJD.dz(this.name, true);
      AppMethodBeat.o(273334);
      return;
    }
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(273335);
    Log.i(this.TAG, "enter shop:" + this.AJG.appId + ',' + this.AJG.SWz);
    String str2 = "setting:0" + z.bdh() + ":0:" + Util.getUuidRandom();
    Object localObject1 = n.zWF;
    n.a(2L, String.valueOf(this.AJG.appId), Util.getUuidRandom().toString(), 1176L, String.valueOf(SystemClock.elapsedRealtimeNanos()), "setting", "");
    localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
    Context localContext = this.context;
    Object localObject2 = this.AJG.appId;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str1 = this.AJG.SWz;
    localObject2 = str1;
    if (str1 == null) {
      localObject2 = "";
    }
    com.tencent.mm.plugin.finder.utils.a.a(localContext, (String)localObject1, (String)localObject2, 1176, str2);
    AppMethodBeat.o(273335);
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.c
 * JD-Core Version:    0.7.0.1
 */