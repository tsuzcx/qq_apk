package com.tencent.luggage.d;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.f;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.p;
import com.tencent.luggage.webview.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
  implements b
{
  o bWt;
  private final MutableContextWrapper bXp;
  final Class<? extends com.tencent.luggage.webview.a> bXq;
  public l bXr;
  public com.tencent.luggage.webview.a bXs;
  boolean bXt;
  public com.tencent.luggage.d.a.a bXu;
  public com.tencent.luggage.webview.a.b bXv;
  com.tencent.luggage.webview.a.d bXw;
  boolean bXx;
  final ConcurrentHashMap<String, Class<? extends a>> bXy;
  private com.tencent.luggage.webview.a.a bXz;
  private Handler mHandler;
  public String mUrl;
  
  public k(Context paramContext, Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    AppMethodBeat.i(140424);
    this.bXt = false;
    this.bXx = false;
    this.bXy = new ConcurrentHashMap();
    this.bXz = new com.tencent.luggage.webview.a.a()
    {
      private void bO(String paramAnonymousString)
      {
        AppMethodBeat.i(200921);
        if (!k.this.bXx)
        {
          if (bP(paramAnonymousString))
          {
            AppMethodBeat.o(200921);
            return;
          }
          k.this.AP();
        }
        AppMethodBeat.o(200921);
      }
      
      private static boolean bP(String paramAnonymousString)
      {
        AppMethodBeat.i(200922);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(200922);
          return false;
        }
        paramAnonymousString = Uri.parse(paramAnonymousString).getPath();
        if ((paramAnonymousString != null) && (paramAnonymousString.trim().endsWith("html")))
        {
          AppMethodBeat.o(200922);
          return true;
        }
        AppMethodBeat.o(200922);
        return false;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140421);
        bO(paramAnonymousWebResourceRequest.getUrl().toString());
        if (k.this.bXr != null)
        {
          paramAnonymousBundle = k.this.bXr.a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          if (paramAnonymousBundle != null)
          {
            AppMethodBeat.o(140421);
            return paramAnonymousBundle;
          }
        }
        paramAnonymousWebResourceRequest = k.this.bXv.cr(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(140421);
        return paramAnonymousWebResourceRequest;
      }
      
      public final boolean bJ(String paramAnonymousString)
      {
        AppMethodBeat.i(140417);
        Iterator localIterator = k.this.bXw.cgq.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Pair)localIterator.next();
          e locale = (e)((Pair)localObject).first;
          localObject = (Pattern)((Pair)localObject).second;
          if ((localObject != null) && (((Pattern)localObject).matcher(paramAnonymousString).matches()))
          {
            boolean bool = locale.DY();
            AppMethodBeat.o(140417);
            return bool;
          }
        }
        AppMethodBeat.o(140417);
        return false;
      }
      
      public final void bK(String paramAnonymousString)
      {
        AppMethodBeat.i(140418);
        k.this.bXx = false;
        k.this.mUrl = paramAnonymousString;
        if (k.this.bXr != null) {
          k.this.bXr.bK(paramAnonymousString);
        }
        AppMethodBeat.o(140418);
      }
      
      public final void bL(String paramAnonymousString)
      {
        AppMethodBeat.i(140419);
        k.this.mUrl = paramAnonymousString;
        k.this.bWt.bWA.onReady();
        if (k.this.bXr != null)
        {
          k.this.bWt.bC(k.this.bXr.AQ());
          k.this.bXr.bL(paramAnonymousString);
        }
        AppMethodBeat.o(140419);
      }
      
      public final WebResourceResponse bM(String paramAnonymousString)
      {
        AppMethodBeat.i(140420);
        bO(paramAnonymousString);
        paramAnonymousString = k.this.bXv.cr(paramAnonymousString);
        AppMethodBeat.o(140420);
        return paramAnonymousString;
      }
      
      public final String bN(String paramAnonymousString)
      {
        AppMethodBeat.i(140422);
        paramAnonymousString = k.this.bWt.bWA.bD(paramAnonymousString);
        AppMethodBeat.o(140422);
        return paramAnonymousString;
      }
    };
    this.bXp = new MutableContextWrapper(paramContext);
    paramContext = paramClass;
    if (paramClass == null) {
      paramContext = com.tencent.luggage.webview.default_impl.a.class;
    }
    this.bXq = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    AJ();
    this.bXs = ((com.tencent.luggage.webview.a)org.a.a.bD(this.bXq).ai(new Object[] { this.bXp }).object);
    this.bXs.setWebCore(this);
    this.bXs.a(this.bXz);
    this.bWt = new o(this.bXs);
    AppMethodBeat.o(140424);
  }
  
  private void AJ()
  {
    AppMethodBeat.i(140425);
    this.bXv = new com.tencent.luggage.webview.a.b();
    this.bXw = new com.tencent.luggage.webview.a.d();
    AK();
    AppMethodBeat.o(140425);
  }
  
  private void AK()
  {
    AppMethodBeat.i(140426);
    this.bXv.a(new com.tencent.luggage.webview.a.a(this.bXp));
    AppMethodBeat.o(140426);
  }
  
  private void AO()
  {
    AppMethodBeat.i(140435);
    ViewParent localViewParent = getView().getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(getView());
    }
    AppMethodBeat.o(140435);
  }
  
  public final com.tencent.luggage.d.a.a AL()
  {
    if (this.bXu == null) {
      return com.tencent.luggage.d.a.a.bXK;
    }
    return this.bXu;
  }
  
  final void AM()
  {
    AppMethodBeat.i(140430);
    if (this.bXt)
    {
      this.bXt = false;
      AJ();
    }
    AppMethodBeat.o(140430);
  }
  
  @Deprecated
  public final <T> T AN()
  {
    AppMethodBeat.i(140431);
    try
    {
      View localView = getView();
      AppMethodBeat.o(140431);
      return localView;
    }
    catch (Exception localException)
    {
      ac.e(getClass().getSimpleName(), "CoreImpl cast failed", new Object[] { localException });
      AppMethodBeat.o(140431);
    }
    return null;
  }
  
  public final void AP()
  {
    try
    {
      AppMethodBeat.i(200923);
      if (!this.bXx)
      {
        ac.m("Luggage.LuggageWebCore", "try inject jsbridge", new Object[0]);
        this.bWt.Ao();
        if (this.bXr != null) {
          this.bWt.bC(this.bXr.AQ());
        }
        this.bXx = true;
      }
      AppMethodBeat.o(200923);
      return;
    }
    finally {}
  }
  
  public final void a(final c paramc)
  {
    AppMethodBeat.i(140429);
    com.tencent.luggage.d.a.c local3 = new com.tencent.luggage.d.a.c()
    {
      public final void a(com.tencent.luggage.d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(140416);
        if (paramc == null)
        {
          ac.e("Luggage.LuggageWebCore", "Null Event, Ignore");
          AppMethodBeat.o(140416);
          return;
        }
        if (paramAnonymousb == com.tencent.luggage.d.a.b.bXN)
        {
          paramAnonymousb = k.this.bWt;
          com.tencent.luggage.bridge.d locald = new com.tencent.luggage.bridge.d(paramc.name(), paramc.Aq());
          paramAnonymousb.bWz.a(locald);
        }
        AppMethodBeat.o(140416);
      }
    };
    com.tencent.luggage.d.a.a locala = AL();
    paramc.name();
    locala.a(local3);
    AppMethodBeat.o(140429);
  }
  
  public final void a(List<Class<? extends a>> paramList, b paramb)
  {
    AppMethodBeat.i(140428);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (Class)paramList.next();
      try
      {
        localObject1 = (a)((Class)localObject2).newInstance();
      }
      catch (Exception localException1)
      {
        try
        {
          ((a)localObject1).bWQ = paramb;
          this.bXy.put(((a)localObject1).name(), localObject2);
          localObject2 = this.bWt;
          String str = ((a)localObject1).name();
          Object localObject1 = new com.tencent.luggage.bridge.l()
          {
            public final void a(com.tencent.luggage.bridge.k paramAnonymousk)
            {
              AppMethodBeat.i(140414);
              k localk = k.this;
              a locala = this.bXA;
              paramAnonymousk = new k.2(localk, locala, paramAnonymousk);
              localk.AL().a(locala.name(), paramAnonymousk);
              AppMethodBeat.o(140414);
            }
          };
          ((o)localObject2).bWB.put(str, localObject1);
        }
        catch (Exception localException2)
        {
          ac.e("Luggage.LuggageWebCore", "registerJsApi: ".concat(String.valueOf(localException2)));
        }
        localException1 = localException1;
        ac.e("Luggage.LuggageWebCore", "JsApi Initialize failed, %s, %s", new Object[] { ((Class)localObject2).getName(), localException1 });
      }
    }
    AppMethodBeat.o(140428);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140436);
    AO();
    if (!this.bXt) {
      this.bXs.destroy();
    }
    AppMethodBeat.o(140436);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(140432);
    View localView = this.bXs.getView();
    AppMethodBeat.o(140432);
    return localView;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(140433);
    this.bXs.loadUrl(paramString);
    AppMethodBeat.o(140433);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(140427);
    this.bXp.setBaseContext(paramContext);
    if (this.bXs != null) {
      this.bXs.setContext(paramContext);
    }
    AppMethodBeat.o(140427);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(140434);
    this.bXs.stopLoading();
    AppMethodBeat.o(140434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.k
 * JD-Core Version:    0.7.0.1
 */