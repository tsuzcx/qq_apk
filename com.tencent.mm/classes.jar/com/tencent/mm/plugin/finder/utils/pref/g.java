package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.preference.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterPosterGuidePref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "CREATER_GUIDE_URL", "CREATER_GUIDE_URL_EN", "CREATER_GUIDE_URL_Traditional", "TAG", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"})
public final class g
  implements i
{
  private final f AJD;
  private String AJL;
  private String AJM;
  private String AJN;
  private final String TAG;
  private final Context context;
  private final String name;
  
  public g(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(276870);
    this.name = paramString;
    this.AJD = paramf;
    this.context = paramContext;
    this.TAG = "Finder.PosterCenterPosterGuidePref";
    this.AJL = ("https://" + WeChatHosts.domainString(b.j.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf7428");
    this.AJM = ("https://" + WeChatHosts.domainString(b.j.host_kf_qq_com) + "/touch/scene_faq.html?scene_id=kf7467");
    this.AJN = ("https://" + WeChatHosts.domainString(b.j.host_kf_qq_com) + "/touch/scene_faq.html?scene_id=kf7468");
    AppMethodBeat.o(276870);
  }
  
  public final String egv()
  {
    return this.name;
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(276868);
    f localf = this.AJD;
    String str = this.name;
    d locald = d.AjH;
    if (!d.dRU()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localf.dz(str, paramBoolean);
      AppMethodBeat.o(276868);
      return;
    }
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(276869);
    Intent localIntent = new Intent();
    Object localObject;
    if (LocaleUtil.isSimplifiedChineseAppLang()) {
      localObject = this.AJL;
    }
    for (;;)
    {
      Log.i(this.TAG, "url = ".concat(String.valueOf(localObject)));
      localIntent.putExtra("rawUrl", (String)localObject);
      c.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
      localObject = n.zWF;
      n.b(this.context, 4L, 1L);
      AppMethodBeat.o(276869);
      return;
      if (LocaleUtil.isTraditionalChineseAppLang())
      {
        localObject = this.AJM;
      }
      else
      {
        p.h(LocaleUtil.getApplicationLanguage(), "en");
        localObject = this.AJN;
      }
    }
  }
  
  public final void onCreate() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(276867);
    n localn = n.zWF;
    n.b(this.context, 4L, 2L);
    AppMethodBeat.o(276867);
  }
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.g
 * JD-Core Version:    0.7.0.1
 */