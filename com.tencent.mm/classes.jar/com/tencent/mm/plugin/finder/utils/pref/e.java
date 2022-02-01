package com.tencent.mm.plugin.finder.utils.pref;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.f;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterLotteryHistoryPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"})
public final class e
  implements i
{
  private final f AJD;
  private final Context context;
  private final String name;
  
  public e(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(267170);
    this.name = paramString;
    this.AJD = paramf;
    this.context = paramContext;
    AppMethodBeat.o(267170);
  }
  
  public final String egv()
  {
    return this.name;
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(267168);
    Object localObject = d.wZQ;
    localObject = d.a.aAK(Util.nullAsNil(z.bdh()));
    if (localObject != null) {}
    for (int i = ((com.tencent.mm.plugin.finder.api.i)localObject).field_extFlag; (i & 0x20000) > 0; i = 0)
    {
      if (paramBoolean)
      {
        localObject = n.zWF;
        n.b(this.context, 7L, 2L);
      }
      this.AJD.dz(this.name, false);
      AppMethodBeat.o(267168);
      return;
    }
    this.AJD.dz(this.name, true);
    AppMethodBeat.o(267168);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(267169);
    Object localObject1 = new Intent();
    Object localObject2 = n.zWF;
    n.b(this.context, 7L, 1L);
    localObject2 = aj.Bnu;
    aj.a.a(this.context, (Intent)localObject1, 0L, 0, false, 124);
    localObject1 = a.ACH;
    localObject1 = this.context;
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(267169);
      throw ((Throwable)localObject1);
    }
    a.a((Activity)localObject1, null, true);
    AppMethodBeat.o(267169);
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.e
 * JD-Core Version:    0.7.0.1
 */