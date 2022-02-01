package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkn;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterOriginalPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "hasExposeOriginalTips", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"})
public final class f
  implements i
{
  final com.tencent.mm.ui.base.preference.f AJD;
  String AJJ;
  final Context context;
  final String name;
  
  public f(String paramString, com.tencent.mm.ui.base.preference.f paramf, Context paramContext)
  {
    AppMethodBeat.i(286893);
    this.name = paramString;
    this.AJD = paramf;
    this.context = paramContext;
    this.AJJ = "";
    AppMethodBeat.o(286893);
  }
  
  public final String egv()
  {
    return this.name;
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(286891);
    this.AJD.dz(this.name, true);
    Object localObject = v.ADV;
    if (v.edj())
    {
      this.AJD.dz(this.name, false);
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.dqS();
      Context localContext = this.context;
      if (localContext == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(286891);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.plugin.finder.extension.reddot.h.a((r)localObject, (androidx.lifecycle.l)localContext, (s)new a(this));
      if (paramBoolean)
      {
        localObject = n.zWF;
        n.b(this.context, 6L, 2L);
      }
    }
    AppMethodBeat.o(286891);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(286892);
    Object localObject1 = this.AJD.byG(this.name);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
      AppMethodBeat.o(286892);
      throw ((Throwable)localObject1);
    }
    localObject1 = (NewTipPreference)localObject1;
    Object localObject2 = n.zWF;
    n.a(this.context, 6L, 1L, ((NewTipPreference)localObject1).fiL());
    localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject2 = ((PluginFinder)localObject1).getRedDotManager().aBe("OriginalEntrance");
    localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)localObject1).getRedDotManager().aBf("OriginalEntrance");
    if ((locall != null) && (localObject2 != null))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
      localObject1 = aj.Bnu;
      localObject1 = aj.a.fZ(this.context);
      if (localObject1 == null) {
        break label261;
      }
    }
    label261:
    for (localObject1 = ((aj)localObject1).ekY();; localObject1 = null)
    {
      com.tencent.mm.plugin.finder.report.l.a("10", locall, (bkn)localObject2, 2, (bid)localObject1, 0, 0, null, 224);
      localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject1).getRedDotManager().aBd("OriginalEntrance");
      localObject1 = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject1).getRedDotManager().d("FinderPosterEntrance", new int[] { 1000 });
      localObject1 = d.AjH;
      localObject1 = d.dVJ();
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      c.b(this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(286892);
      return;
    }
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop()
  {
    this.AJJ = "";
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class a<T>
    implements s<h.a>
  {
    a(f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.f
 * JD-Core Version:    0.7.0.1
 */