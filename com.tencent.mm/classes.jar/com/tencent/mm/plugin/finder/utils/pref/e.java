package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterLotteryHistoryPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements i
{
  private final f Gmr;
  private final Context context;
  private final String name;
  
  public e(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(333841);
    this.name = paramString;
    this.Gmr = paramf;
    this.context = paramContext;
    AppMethodBeat.o(333841);
  }
  
  public final String fiv()
  {
    return this.name;
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(333865);
    Object localObject = d.AwY;
    localObject = d.a.auT(Util.nullAsNil(com.tencent.mm.model.z.bAW()));
    if (localObject == null) {}
    for (int i = 0; (i & 0x20000) > 0; i = ((m)localObject).field_extFlag)
    {
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.b(this.context, 7L, 2L);
      }
      this.Gmr.eh(this.name, false);
      AppMethodBeat.o(333865);
      return;
    }
    this.Gmr.eh(this.name, true);
    AppMethodBeat.o(333865);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(333877);
    Intent localIntent = new Intent();
    Object localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.b(this.context, 7L, 1L);
    localObject = as.GSQ;
    as.a.a(this.context, localIntent, 0L, 0, false, 124);
    a.GfO.a((Context)this.context, null, true);
    AppMethodBeat.o(333877);
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.e
 * JD-Core Version:    0.7.0.1
 */