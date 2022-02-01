package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterLiveShopPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "Lcom/tencent/mm/plugin/finder/utils/pref/WithPrepareResp;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "TAG", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWxaPreloadInfo;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "shopBindInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updatePrepareResp", "updateView", "isFromSceneEnd", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements i, j
{
  private bys AwM;
  private final f Gmr;
  private bzd Gmt;
  private boh Gmu;
  private final String TAG;
  private final Context context;
  private final String name;
  
  public c(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(333854);
    this.name = paramString;
    this.Gmr = paramf;
    this.context = paramContext;
    this.TAG = "Finder.PosterCenterLiveShopPref";
    this.Gmt = new bzd();
    this.Gmu = new boh();
    AppMethodBeat.o(333854);
  }
  
  public final void b(bys parambys)
  {
    AppMethodBeat.i(333910);
    s.u(parambys, "prepareResp");
    this.AwM = parambys;
    bzd localbzd = parambys.aahz;
    Object localObject = localbzd;
    if (localbzd == null) {
      localObject = new bzd();
    }
    this.Gmt = ((bzd)localObject);
    localObject = parambys.aahN;
    parambys = (bys)localObject;
    if (localObject == null) {
      parambys = new boh();
    }
    this.Gmu = parambys;
    AppMethodBeat.o(333910);
  }
  
  public final String fiv()
  {
    return this.name;
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(333888);
    Log.i(this.TAG, "update shop:" + this.Gmt.appId + ',' + this.Gmt.aail);
    Object localObject2 = this.Gmr.bAi(this.name);
    Object localObject1 = d.FAy;
    if (d.eWz()) {}
    for (localObject1 = (CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_shop_shelf);; localObject1 = (CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_shop))
    {
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      if (Util.isNullOrNil(this.Gmt.appId)) {
        break;
      }
      this.Gmr.eh(this.name, false);
      localObject1 = d.FAy;
      if (!d.eWz()) {
        break label228;
      }
      localObject1 = ((com.tencent.mm.plugin.g)h.ax(com.tencent.mm.plugin.g.class)).a(this.Gmu);
      if (localObject1 == null) {
        break label228;
      }
      localObject1 = (com.tencent.mm.plugin.appbrand.api.g)p.oL((List)localObject1);
      if (localObject1 == null) {
        break label228;
      }
      localObject2 = h.ax(com.tencent.mm.plugin.g.class);
      s.s(localObject2, "service(IFinderCommonLiveService::class.java)");
      ((com.tencent.mm.plugin.g)localObject2).a((com.tencent.mm.plugin.appbrand.api.g)localObject1);
      AppMethodBeat.o(333888);
      return;
    }
    this.Gmr.eh(this.name, true);
    label228:
    AppMethodBeat.o(333888);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(333892);
    Log.i(this.TAG, "enter shop:" + this.Gmt.appId + ',' + this.Gmt.aail);
    String str2 = "setting:0" + com.tencent.mm.model.z.bAW() + ":0:" + Util.getUuidRandom();
    com.tencent.mm.plugin.finder.report.z.FrZ.b(2L, String.valueOf(this.Gmt.appId), Util.getUuidRandom().toString(), String.valueOf(SystemClock.elapsedRealtimeNanos()), "setting", "");
    a locala = a.GfO;
    Context localContext = this.context;
    Object localObject2 = this.Gmt.appId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str1 = this.Gmt.aail;
    localObject2 = str1;
    if (str1 == null) {
      localObject2 = "";
    }
    locala.a(localContext, (String)localObject1, (String)localObject2, 1176, str2);
    AppMethodBeat.o(333892);
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.c
 * JD-Core Version:    0.7.0.1
 */