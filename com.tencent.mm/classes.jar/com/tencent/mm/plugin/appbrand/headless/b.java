package com.tencent.mm.plugin.appbrand.headless;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.ak;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/headless/HeadlessPage;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandSinglePage;", "context", "Landroid/content/Context;", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;)V", "createContentView", "Landroid/view/View;", "loadUrl", "", "url", "", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends al
{
  private static final b.a ruo;
  
  static
  {
    AppMethodBeat.i(317560);
    ruo = new b.a((byte)0);
    AppMethodBeat.o(317560);
  }
  
  public b(Context paramContext, x paramx)
  {
    super(paramContext, paramx);
    AppMethodBeat.i(317554);
    AppMethodBeat.o(317554);
  }
  
  public final void a(String paramString, cb paramcb)
  {
    AppMethodBeat.i(317567);
    if (cb.tBm == paramcb) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(317567);
      throw paramString;
    }
    Log.i("MicroMsg.AppBrand.HeadlessPage", "loadUrl appId:" + getAppId() + " url:" + paramString + ", type:" + paramcb);
    super.a(paramString, paramcb);
    AppMethodBeat.o(317567);
  }
  
  public final View createContentView()
  {
    AppMethodBeat.i(317576);
    Object localObject = new c(this);
    ((c)localObject).a(getContext(), getRuntime());
    ah localah = ah.aiuX;
    this.enm = ((ad)localObject);
    localObject = this.enm;
    s.checkNotNull(localObject);
    localObject = ((ad)localObject).getContentView();
    s.checkNotNull(localObject);
    s.s(localObject, "mPageView!!.contentView!!");
    AppMethodBeat.o(317576);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.headless.b
 * JD-Core Version:    0.7.0.1
 */