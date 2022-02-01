package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.base.preference.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterAuthPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"})
public final class a
  implements i
{
  private final f AJD;
  private final Context context;
  private final String name;
  
  public a(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(276058);
    this.name = paramString;
    this.AJD = paramf;
    this.context = paramContext;
    AppMethodBeat.o(276058);
  }
  
  public final String egv()
  {
    return this.name;
  }
  
  public final void jq(boolean paramBoolean) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(276057);
    Object localObject = new xw();
    ((xw)localObject).fWN.userName = "gh_4ee148a6ecaa@app";
    ((xw)localObject).fWN.appId = "wxdfda2588e999a42d";
    ((xw)localObject).fWN.fWP = "pages/index/index.html";
    ((xw)localObject).fWN.scene = 1201;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = n.zWF;
    n.b(this.context, 3L, 1L);
    AppMethodBeat.o(276057);
  }
  
  public final void onCreate() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(276056);
    n localn = n.zWF;
    n.b(this.context, 3L, 2L);
    AppMethodBeat.o(276056);
  }
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.a
 * JD-Core Version:    0.7.0.1
 */