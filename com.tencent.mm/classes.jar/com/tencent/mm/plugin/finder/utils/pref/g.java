package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterPosterGuidePref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "CREATER_GUIDE_URL", "CREATER_GUIDE_URL_EN", "CREATER_GUIDE_URL_Traditional", "TAG", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updateView", "isFromSceneEnd", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements i
{
  private final f Gmr;
  private String Gmx;
  private String Gmy;
  private String Gmz;
  private final String TAG;
  private final Context context;
  private final String name;
  
  public g(String paramString, f paramf, Context paramContext)
  {
    AppMethodBeat.i(333844);
    this.name = paramString;
    this.Gmr = paramf;
    this.context = paramContext;
    this.TAG = "Finder.PosterCenterPosterGuidePref";
    this.Gmx = ("https://" + WeChatHosts.domainString(e.h.host_kf_qq_com) + "/touch/scene_product.html?scene_id=kf7428");
    this.Gmy = ("https://" + WeChatHosts.domainString(e.h.host_kf_qq_com) + "/touch/scene_faq.html?scene_id=kf7467");
    this.Gmz = ("https://" + WeChatHosts.domainString(e.h.host_kf_qq_com) + "/touch/scene_faq.html?scene_id=kf7468");
    AppMethodBeat.o(333844);
  }
  
  public final String fiv()
  {
    return this.name;
  }
  
  public final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(333874);
    f localf = this.Gmr;
    String str = this.name;
    d locald = d.FAy;
    if (!d.eQh()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localf.eh(str, paramBoolean);
      AppMethodBeat.o(333874);
      return;
    }
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(333883);
    Intent localIntent = new Intent();
    Object localObject;
    if (LocaleUtil.isSimplifiedChineseAppLang()) {
      localObject = this.Gmx;
    }
    for (;;)
    {
      Log.i(this.TAG, s.X("url = ", localObject));
      localIntent.putExtra("rawUrl", (String)localObject);
      c.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
      localObject = z.FrZ;
      z.b(this.context, 4L, 1L);
      AppMethodBeat.o(333883);
      return;
      if (LocaleUtil.isTraditionalChineseAppLang())
      {
        localObject = this.Gmy;
      }
      else
      {
        s.p(LocaleUtil.getApplicationLanguage(), "en");
        localObject = this.Gmz;
      }
    }
  }
  
  public final void onCreate() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(333862);
    z localz = z.FrZ;
    z.b(this.context, 4L, 2L);
    AppMethodBeat.o(333862);
  }
  
  public final void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.g
 * JD-Core Version:    0.7.0.1
 */