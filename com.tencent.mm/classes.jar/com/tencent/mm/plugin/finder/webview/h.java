package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.stub.b;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "()V", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "webViewCallback", "com/tencent/mm/plugin/finder/webview/FinderWebViewController$webViewCallback$1", "Lcom/tencent/mm/plugin/finder/webview/FinderWebViewController$webViewCallback$1;", "webViewControllerRef", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getWebViewControllerRef", "setWebViewControllerRef", "onBinded", "", "Companion", "plugin-finder_release"})
public final class h
  extends j
{
  public static final a Brv;
  WeakReference<BaseWebViewController> Brt;
  private b Bru;
  WeakReference<Context> aFX;
  
  static
  {
    AppMethodBeat.i(271960);
    Brv = new a((byte)0);
    AppMethodBeat.o(271960);
  }
  
  public h()
  {
    AppMethodBeat.i(271959);
    this.Bru = new b(this);
    AppMethodBeat.o(271959);
  }
  
  public final void bXM()
  {
    AppMethodBeat.i(271957);
    try
    {
      Object localObject1 = this.Brt;
      if (localObject1 != null)
      {
        localObject1 = (BaseWebViewController)((WeakReference)localObject1).get();
        if (localObject1 != null)
        {
          localObject1 = ((BaseWebViewController)localObject1).gSm();
          if (localObject1 != null)
          {
            f localf = (f)this.Bru;
            Object localObject2 = this.Brt;
            if (localObject2 != null)
            {
              localObject2 = (BaseWebViewController)((WeakReference)localObject2).get();
              if (localObject2 == null) {}
            }
            for (int i = ((BaseWebViewController)localObject2).gSo();; i = 0)
            {
              ((e)localObject1).a(localf, i);
              AppMethodBeat.o(271957);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(271957);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("Finder.WebViewController", localThrowable, "initWebViewController exception", new Object[0]);
      AppMethodBeat.o(271957);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewController$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/webview/FinderWebViewController$webViewCallback$1", "Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "getCommitUrl", "", "getCurrentUrl", "invokeAsResult", "Landroid/os/Bundle;", "actionCode", "", "data", "plugin-finder_release"})
  public static final class b
    extends b
  {
    public final String bXN()
    {
      AppMethodBeat.i(282759);
      Log.v("Finder.WebViewController", "getCommitUrl");
      for (;;)
      {
        try
        {
          Object localObject = this.Brw.Brt;
          if (localObject != null)
          {
            localObject = (BaseWebViewController)((WeakReference)localObject).get();
            if (localObject != null)
            {
              String str2 = ((BaseWebViewController)localObject).PFN;
              localObject = str2;
              if (str2 != null)
              {
                AppMethodBeat.o(282759);
                return localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("Finder.WebViewController", localThrowable, "getCommitUrl exception", new Object[0]);
          AppMethodBeat.o(282759);
          return "";
        }
        String str1 = "";
      }
    }
    
    public final String getCurrentUrl()
    {
      AppMethodBeat.i(282760);
      Log.v("Finder.WebViewController", "getCurrentUrl");
      for (;;)
      {
        try
        {
          Object localObject = this.Brw.Brt;
          if (localObject != null)
          {
            localObject = (BaseWebViewController)((WeakReference)localObject).get();
            if (localObject != null)
            {
              String str2 = ((BaseWebViewController)localObject).getCurrentUrl();
              localObject = str2;
              if (str2 != null)
              {
                AppMethodBeat.o(282760);
                return localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("Finder.WebViewController", localThrowable, "getCommitUrl exception", new Object[0]);
          AppMethodBeat.o(282760);
          return "";
        }
        String str1 = "";
      }
    }
    
    public final Bundle l(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(282761);
      Bundle localBundle = new Bundle();
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(282761);
        return localBundle;
        if (paramBundle != null) {
          try
          {
            Object localObject = this.Brw.aFX;
            if (localObject != null)
            {
              Context localContext = (Context)((WeakReference)localObject).get();
              if (localContext != null)
              {
                p.j(localContext, "it");
                paramBundle.setClassLoader(localContext.getClassLoader());
                localObject = paramBundle.getBundle("open_ui_with_webview_ui_extras");
                String str1 = IntentUtil.getString(paramBundle, "open_ui_with_webview_ui_plugin_name");
                String str2 = IntentUtil.getString(paramBundle, "open_ui_with_webview_ui_plugin_entry");
                Intent localIntent = new Intent();
                paramBundle = (Bundle)localObject;
                if (localObject == null) {
                  paramBundle = new Bundle();
                }
                c.b(localContext, str1, str2, localIntent.putExtras(paramBundle));
              }
            }
          }
          catch (Throwable paramBundle)
          {
            Log.e("Finder.WebViewController", "In invokeAsResult method, it happens something unwanted!");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.h
 * JD-Core Version:    0.7.0.1
 */