package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterSettleToAgencyPref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "TAG", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements i
{
  private final f Gmr;
  private final String TAG;
  private final Context context;
  private final String name;
  
  public h(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(333837);
    this.name = paramString;
    this.Gmr = paramf;
    this.context = paramContext;
    this.TAG = "PosterCenterSettleToAgencyPref";
    AppMethodBeat.o(333837);
  }
  
  public final String fiv()
  {
    return this.name;
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(333860);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = d.a.auT(Util.nullAsNil(z.bAW()));
    if (localObject == null) {}
    for (long l = 0L; com.tencent.mm.ae.d.ee((int)l, 1024); l = ((m)localObject).field_liveSwitchFlag)
    {
      this.Gmr.eh(this.name, false);
      AppMethodBeat.o(333860);
      return;
    }
    this.Gmr.eh(this.name, true);
    AppMethodBeat.o(333860);
  }
  
  public final void onClick()
  {
    Intent localIntent = null;
    AppMethodBeat.i(333873);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = d.a.auT(Util.nullAsNil(z.bAW()));
    if (localObject1 == null) {
      localObject1 = localIntent;
    }
    for (;;)
    {
      Log.i(this.TAG, s.X("jumpUrl:", localObject1));
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", (String)localObject1);
      c.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(333873);
      return;
      Object localObject2 = ((m)localObject1).field_agencyCollaborateInfo;
      localObject1 = localIntent;
      if (localObject2 != null)
      {
        localObject2 = ((ei)localObject2).YGw;
        localObject1 = localIntent;
        if (localObject2 != null) {
          localObject1 = ((ej)localObject2).jump_url;
        }
      }
    }
  }
  
  public final void onCreate() {}
  
  public final void onResume() {}
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.h
 * JD-Core Version:    0.7.0.1
 */