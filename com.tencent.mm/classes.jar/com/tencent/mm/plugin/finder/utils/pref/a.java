package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterAuthPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements i
{
  private final f Gmr;
  private final Context context;
  private final String name;
  
  public a(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(333849);
    this.name = paramString;
    this.Gmr = paramf;
    this.context = paramContext;
    AppMethodBeat.o(333849);
  }
  
  public final String fiv()
  {
    return this.name;
  }
  
  public final void kD(boolean paramBoolean) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(333887);
    Object localObject = new zp();
    ((zp)localObject).icM.userName = "gh_4ee148a6ecaa@app";
    ((zp)localObject).icM.appId = "wxdfda2588e999a42d";
    ((zp)localObject).icM.icO = "pages/index/index.html";
    ((zp)localObject).icM.scene = 1201;
    ((zp)localObject).icM.context = this.context;
    ((zp)localObject).publish();
    localObject = z.FrZ;
    z.b(this.context, 3L, 1L);
    AppMethodBeat.o(333887);
  }
  
  public final void onCreate() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(333871);
    z localz = z.FrZ;
    z.b(this.context, 3L, 2L);
    AppMethodBeat.o(333871);
  }
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.a
 * JD-Core Version:    0.7.0.1
 */