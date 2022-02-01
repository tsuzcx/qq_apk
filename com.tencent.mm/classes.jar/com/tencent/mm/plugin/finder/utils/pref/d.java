package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkn;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterLiveTaskPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "TAG", "getContext", "()Landroid/content/Context;", "hasExposeLiveTaskTips", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"})
public final class d
  implements i
{
  final com.tencent.mm.ui.base.preference.f AJD;
  String AJH;
  private final String TAG;
  final Context context;
  final String name;
  
  public d(String paramString, com.tencent.mm.ui.base.preference.f paramf, Context paramContext)
  {
    AppMethodBeat.i(269535);
    this.name = paramString;
    this.AJD = paramf;
    this.context = paramContext;
    this.TAG = "Finder.PosterCenterLiveTaskPref";
    this.AJH = "";
    AppMethodBeat.o(269535);
  }
  
  public final String egv()
  {
    return this.name;
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(269533);
    this.AJD.dz(this.name, true);
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    if (com.tencent.mm.plugin.finder.api.d.a.aAQ("Entrance_PrimarySetting"))
    {
      this.AJD.dz(this.name, false);
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.drm();
      Context localContext = this.context;
      if (localContext == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(269533);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.plugin.finder.extension.reddot.h.a((r)localObject, (androidx.lifecycle.l)localContext, (s)new a(this));
      if (paramBoolean) {
        com.tencent.mm.plugin.report.service.h.IzE.a(22748, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Long.valueOf(cm.bfE()), z.bdh() });
      }
    }
    AppMethodBeat.o(269533);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(269534);
    Object localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    bkn localbkn = ((PluginFinder)localObject).getRedDotManager().aBe("FinderSettingLiveTask");
    localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)localObject).getRedDotManager().aBf("FinderSettingLiveTask");
    if ((locall != null) && (localbkn != null))
    {
      localObject = com.tencent.mm.plugin.finder.report.l.zWx;
      localObject = aj.Bnu;
      localObject = this.context;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(269534);
        throw ((Throwable)localObject);
      }
      localObject = aj.a.fZ((Context)localObject);
      if (localObject == null) {
        break label216;
      }
    }
    label216:
    for (localObject = ((aj)localObject).ekY();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.l.a("10", locall, localbkn, 2, (bid)localObject, 0, 0, null, 224);
      localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().aBd("FinderSettingLiveTask");
      localObject = a.ACH;
      a.ao(this.context, 1);
      com.tencent.mm.plugin.report.service.h.IzE.a(22748, new Object[] { Integer.valueOf(1), Integer.valueOf(2), Long.valueOf(cm.bfE()), z.bdh() });
      AppMethodBeat.o(269534);
      return;
    }
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop()
  {
    this.AJH = "";
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class a<T>
    implements s<h.a>
  {
    a(d paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.d
 * JD-Core Version:    0.7.0.1
 */