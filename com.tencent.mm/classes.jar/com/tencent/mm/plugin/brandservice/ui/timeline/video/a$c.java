package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.a.b;
import a.f.b.j;
import a.f.b.u.b;
import a.f.b.u.d;
import a.l;
import a.v;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.protocal.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$callback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "handleMsg", "func", "", "param", "invokeAsResult", "plugin-brandservice_release"})
public final class a$c
  extends m
{
  a$c(u.d paramd1, String paramString, u.d paramd2, b paramb, u.b paramb1) {}
  
  public final Bundle dm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(15115);
    if (paramString1 == null) {}
    do
    {
      for (;;)
      {
        paramString1 = super.dm(paramString1, paramString2);
        j.p(paramString1, "super.handleMsg(func, param)");
        AppMethodBeat.o(15115);
        return paramString1;
        switch (paramString1.hashCode())
        {
        }
      }
    } while (!paramString1.equals("configMpAdAttrs"));
    ab.i("MicroMsg.AdWebViewManager", "configMpAdAttrs:".concat(String.valueOf(paramString2)));
    int i = new i(paramString2).getInt("viewHeight");
    if (f.DEBUG) {}
    for (paramString1 = ",param:".concat(String.valueOf(paramString2)); i > 0; paramString1 = "")
    {
      this.kfe.S(Integer.valueOf((int)(i * this.kfa.BNo + 0.5F)));
      paramString1 = c.anl("configMpAdAttrs:ok".concat(String.valueOf(paramString1)));
      j.p(paramString1, "ConstantsJSAPIFunc.creat…gMpAdAttrs:ok$debugInfo\")");
      AppMethodBeat.o(15115);
      return paramString1;
    }
    paramString1 = c.anl("configMpAdAttrs:err height".concat(String.valueOf(paramString1)));
    j.p(paramString1, "ConstantsJSAPIFunc.creat…rs:err height$debugInfo\")");
    AppMethodBeat.o(15115);
    return paramString1;
  }
  
  public final boolean e(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(15113);
    j.q(paramBundle, "data");
    ab.i("MicroMsg.AdWebViewManager", "callback:".concat(String.valueOf(paramInt)));
    boolean bool = super.e(paramInt, paramBundle);
    AppMethodBeat.o(15113);
    return bool;
  }
  
  public final Bundle i(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(15114);
    ab.i("MicroMsg.AdWebViewManager", "invokeAsResult:".concat(String.valueOf(paramInt)));
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (((WeakReference)this.kfb.BNq).get() != null)
    {
      localObject1 = ((WeakReference)this.kfb.BNq).get();
      if (localObject1 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
        AppMethodBeat.o(15114);
        throw paramBundle;
      }
      if (!((TmplShareWebViewToolUI)localObject1).isFinishing()) {}
    }
    else
    {
      AppMethodBeat.o(15114);
      return localBundle;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(15114);
      return localBundle;
      if (paramBundle == null) {
        j.ebi();
      }
      paramBundle.setClassLoader(WebViewUI.class.getClassLoader());
      localObject1 = (Context)((WeakReference)this.kfb.BNq).get();
      Object localObject2 = paramBundle.getString("open_ui_with_webview_ui_plugin_name");
      String str = paramBundle.getString("open_ui_with_webview_ui_plugin_entry");
      Intent localIntent = new Intent();
      paramBundle = paramBundle.getBundle("open_ui_with_webview_ui_extras");
      if (paramBundle == null) {
        j.ebi();
      }
      d.b((Context)localObject1, (String)localObject2, str, localIntent.putExtras(paramBundle).putExtra("KPublisherId", this.kfc));
      continue;
      localObject1 = ((WeakReference)this.kfb.BNq).get();
      if (localObject1 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
        AppMethodBeat.o(15114);
        throw paramBundle;
      }
      localObject2 = (TmplShareWebViewToolUI)localObject1;
      if (paramBundle != null) {}
      for (localObject1 = paramBundle.getString("action");; localObject1 = null)
      {
        if (!j.e("sendMPPageData", localObject1)) {
          break label311;
        }
        ((TmplShareWebViewToolUI)localObject2).O(paramBundle);
        break;
      }
      label311:
      if (j.e("closeAdWebview", localObject1))
      {
        ((TmplShareWebViewToolUI)localObject2).aYu();
      }
      else if (j.e("adWebviewReady", localObject1))
      {
        ((TmplShareWebViewToolUI)localObject2).aYv();
      }
      else if (j.e("getMPVideoState", localObject1))
      {
        localBundle.putAll(((TmplShareWebViewToolUI)localObject2).aYw());
      }
      else if (j.e("setWebviewBackground", localObject1))
      {
        paramBundle = paramBundle.getString("backgroundColor");
        ab.i("MicroMsg.AdWebViewManager", "setWebviewBackground ".concat(String.valueOf(paramBundle)));
        paramInt = g.by(paramBundle, 0);
        if (((WeakReference)this.kfd.BNq).get() != null)
        {
          paramBundle = ((WeakReference)this.kfd.BNq).get();
          if (paramBundle == null) {
            j.ebi();
          }
          ((View)paramBundle).setBackgroundColor(paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c
 * JD-Core Version:    0.7.0.1
 */