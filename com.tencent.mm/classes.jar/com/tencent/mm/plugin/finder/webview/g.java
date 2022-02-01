package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.stub.b;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "()V", "authError", "Ljava/lang/ref/WeakReference;", "Ljava/lang/Runnable;", "getAuthError", "()Ljava/lang/ref/WeakReference;", "setAuthError", "(Ljava/lang/ref/WeakReference;)V", "contextRef", "Landroid/content/Context;", "getContextRef", "setContextRef", "webViewCallback", "Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "getWebViewCallback", "()Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "setWebViewCallback", "(Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;)V", "webViewControllerRef", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getWebViewControllerRef", "setWebViewControllerRef", "onAuthError", "", "reason", "", "reqUrl", "", "errType", "errCode", "errMsg", "onBinded", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends l
{
  public static final a GXC;
  WeakReference<BaseWebViewController> GXD;
  WeakReference<Runnable> GXE;
  b GXF;
  WeakReference<Context> contextRef;
  
  static
  {
    AppMethodBeat.i(334442);
    GXC = new a((byte)0);
    AppMethodBeat.o(334442);
  }
  
  public g()
  {
    AppMethodBeat.i(334437);
    this.GXF = new b();
    AppMethodBeat.o(334437);
  }
  
  public final void b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(334460);
    kotlin.g.b.s.u(paramString1, "reqUrl");
    kotlin.g.b.s.u(paramString2, "errMsg");
    super.b(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
    Log.i("Finder.WebViewController", "reason:" + paramInt1 + " reqUrl:" + paramString1 + " errType:" + paramInt2 + " errCode:" + paramInt3 + " :" + paramString2 + ": String) ");
    paramString1 = this.GXE;
    if (paramString1 != null)
    {
      paramString1 = (Runnable)paramString1.get();
      if (paramString1 != null) {
        paramString1.run();
      }
    }
    AppMethodBeat.o(334460);
  }
  
  public final void cxX()
  {
    AppMethodBeat.i(334449);
    try
    {
      Object localObject1 = this.GXD;
      if (localObject1 != null)
      {
        localObject1 = (BaseWebViewController)((WeakReference)localObject1).get();
        if (localObject1 != null)
        {
          localObject1 = ((BaseWebViewController)localObject1).irJ();
          if (localObject1 != null)
          {
            f localf = (f)this.GXF;
            Object localObject2 = this.GXD;
            int i;
            if (localObject2 == null) {
              i = 0;
            }
            for (;;)
            {
              ((e)localObject1).a(localf, i);
              AppMethodBeat.o(334449);
              return;
              localObject2 = (BaseWebViewController)((WeakReference)localObject2).get();
              if (localObject2 == null) {
                i = 0;
              } else {
                i = ((BaseWebViewController)localObject2).irL();
              }
            }
          }
        }
      }
      return;
    }
    finally
    {
      Log.printErrStackTrace("Finder.WebViewController", localThrowable, "initWebViewController exception", new Object[0]);
      AppMethodBeat.o(334449);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewController$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/FinderWebViewController$setWebViewCallback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/PreloadWebViewStubCallback;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "invokeAsResult", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.webview.ui.tools.widget.s
  {
    b(g paramg, WeakReference<BaseWebViewController> paramWeakReference)
    {
      super();
    }
    
    public final boolean i(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(334464);
      Object localObject1;
      com.tencent.mm.plugin.webview.jsapi.j localj;
      LinkedList localLinkedList;
      if (paramInt == 1013)
      {
        try
        {
          localObject1 = (BaseWebViewController)iCz().get();
          if (localObject1 != null) {
            break label169;
          }
          localj = null;
          localLinkedList = new LinkedList();
          if (paramBundle != null) {
            break label179;
          }
          localObject1 = "";
        }
        catch (IOException paramBundle)
        {
          label52:
          Log.printErrStackTrace("Finder.WebViewController", (Throwable)paramBundle, "parse webCompt", new Object[0]);
        }
        if ((paramBundle == null) || (paramBundle.containsKey("__webComptList") != true)) {
          break label278;
        }
      }
      label261:
      label272:
      label273:
      label275:
      label278:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          Object localObject2 = paramBundle.getStringArrayList("__webComptList");
          kotlin.g.b.s.checkNotNull(localObject2);
          localObject2 = ((ArrayList)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              String str2 = (String)((Iterator)localObject2).next();
              ddx localddx = new ddx();
              localddx.parseFrom(paramBundle.getByteArray(str2));
              localLinkedList.add(localddx);
              continue;
              label162:
              AppMethodBeat.o(334464);
              return true;
              label169:
              localj = ((BaseWebViewController)localObject1).getJsapi();
              break;
              label179:
              localObject1 = paramBundle.getString("__appId");
              if (localObject1 != null) {
                break label272;
              }
              localObject1 = "";
              break label261;
            }
          }
        }
        for (;;)
        {
          String str1 = paramBundle.getString("__url");
          if (str1 != null) {
            break label275;
          }
          str1 = "";
          break;
          if (localj == null) {
            break label162;
          }
          paramBundle = localj.itJ();
          if (paramBundle == null) {
            break label162;
          }
          paramBundle.c((String)localObject1, str1, localLinkedList);
          break label162;
          boolean bool = super.i(paramInt, paramBundle);
          AppMethodBeat.o(334464);
          return bool;
          for (;;)
          {
            if (paramBundle != null) {
              break label273;
            }
            str1 = "";
            break;
          }
        }
        break label52;
      }
    }
    
    public final Bundle m(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(334478);
      Bundle localBundle2 = new Bundle();
      switch (paramInt)
      {
      }
      try
      {
        for (;;)
        {
          super.m(paramInt, paramBundle);
          AppMethodBeat.o(334478);
          return localBundle2;
          if (paramBundle != null)
          {
            Object localObject = this.GXG.contextRef;
            if (localObject != null)
            {
              Context localContext = (Context)((WeakReference)localObject).get();
              if (localContext != null)
              {
                paramBundle.setClassLoader(localContext.getClassLoader());
                Bundle localBundle1 = paramBundle.getBundle("open_ui_with_webview_ui_extras");
                String str1 = IntentUtil.getString(paramBundle, "open_ui_with_webview_ui_plugin_name");
                String str2 = IntentUtil.getString(paramBundle, "open_ui_with_webview_ui_plugin_entry");
                Intent localIntent = new Intent();
                localObject = localBundle1;
                if (localBundle1 == null) {
                  localObject = new Bundle();
                }
                c.b(localContext, str1, str2, localIntent.putExtras((Bundle)localObject));
              }
            }
          }
        }
      }
      finally
      {
        for (;;)
        {
          Log.e("Finder.WebViewController", "In invokeAsResult method, it happens something unwanted!");
        }
        paramBundle = this.GXG.contextRef;
        if (paramBundle != null) {}
      }
      for (paramBundle = null;; paramBundle = (Context)paramBundle.get())
      {
        localBundle2.putParcelable("delegate", (Parcelable)ActivityStarterIpcDelegate.bq(paramBundle));
        AppMethodBeat.o(334478);
        return localBundle2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.g
 * JD-Core Version:    0.7.0.1
 */