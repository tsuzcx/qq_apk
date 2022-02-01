package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterSettleToAgencyPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "TAG", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"})
public final class h
  implements i
{
  private final f AJD;
  private final String TAG;
  private final Context context;
  private final String name;
  
  public h(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(281121);
    this.name = paramString;
    this.AJD = paramf;
    this.context = paramContext;
    this.TAG = "PosterCenterSettleToAgencyPref";
    AppMethodBeat.o(281121);
  }
  
  public final String egv()
  {
    return this.name;
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(281118);
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject = d.a.aAK(Util.nullAsNil(z.bdh()));
    if (localObject != null) {}
    for (long l = ((com.tencent.mm.plugin.finder.api.i)localObject).field_liveSwitchFlag; com.tencent.mm.ae.d.dr((int)l, 1024); l = 0L)
    {
      this.AJD.dz(this.name, false);
      AppMethodBeat.o(281118);
      return;
    }
    this.AJD.dz(this.name, true);
    AppMethodBeat.o(281118);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(281120);
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject = d.a.aAK(Util.nullAsNil(z.bdh()));
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.api.i)localObject).field_agencyCollaborateInfo;
      if (localObject != null)
      {
        localObject = ((dt)localObject).RJj;
        if (localObject == null) {}
      }
    }
    for (localObject = ((du)localObject).jump_url;; localObject = null)
    {
      Log.i(this.TAG, "jumpUrl:".concat(String.valueOf(localObject)));
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", (String)localObject);
      c.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(281120);
      return;
    }
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.h
 * JD-Core Version:    0.7.0.1
 */