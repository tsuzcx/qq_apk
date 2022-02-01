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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
  implements b
{
  o bZw;
  boolean caA;
  final ConcurrentHashMap<String, Class<? extends a>> caB;
  private com.tencent.luggage.webview.a.a caC;
  private final MutableContextWrapper cas;
  final Class<? extends com.tencent.luggage.webview.a> cat;
  public l cau;
  public com.tencent.luggage.webview.a cav;
  boolean caw;
  public com.tencent.luggage.d.a.a cax;
  public com.tencent.luggage.webview.a.b cay;
  com.tencent.luggage.webview.a.d caz;
  private Handler mHandler;
  public String mUrl;
  
  public k(Context paramContext, Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    AppMethodBeat.i(140424);
    this.caw = false;
    this.caA = false;
    this.caB = new ConcurrentHashMap();
    this.caC = new com.tencent.luggage.webview.a.a()
    {
      private void bY(String paramAnonymousString)
      {
        AppMethodBeat.i(194783);
        if (!k.this.caA)
        {
          if (bZ(paramAnonymousString))
          {
            AppMethodBeat.o(194783);
            return;
          }
          k.this.Bl();
        }
        AppMethodBeat.o(194783);
      }
      
      private static boolean bZ(String paramAnonymousString)
      {
        AppMethodBeat.i(194784);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(194784);
          return false;
        }
        paramAnonymousString = Uri.parse(paramAnonymousString).getPath();
        if ((paramAnonymousString != null) && (paramAnonymousString.trim().endsWith("html")))
        {
          AppMethodBeat.o(194784);
          return true;
        }
        AppMethodBeat.o(194784);
        return false;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140421);
        bY(paramAnonymousWebResourceRequest.getUrl().toString());
        if (k.this.cau != null)
        {
          paramAnonymousBundle = k.this.cau.a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          if (paramAnonymousBundle != null)
          {
            AppMethodBeat.o(140421);
            return paramAnonymousBundle;
          }
        }
        paramAnonymousWebResourceRequest = k.this.cay.cC(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(140421);
        return paramAnonymousWebResourceRequest;
      }
      
      public final boolean bT(String paramAnonymousString)
      {
        AppMethodBeat.i(140417);
        Iterator localIterator = k.this.caz.cju.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Pair)localIterator.next();
          e locale = (e)((Pair)localObject).first;
          localObject = (Pattern)((Pair)localObject).second;
          if ((localObject != null) && (((Pattern)localObject).matcher(paramAnonymousString).matches()))
          {
            boolean bool = locale.Ev();
            AppMethodBeat.o(140417);
            return bool;
          }
        }
        AppMethodBeat.o(140417);
        return false;
      }
      
      public final void bU(String paramAnonymousString)
      {
        AppMethodBeat.i(140418);
        k.this.caA = false;
        k.this.mUrl = paramAnonymousString;
        if (k.this.cau != null) {
          k.this.cau.bU(paramAnonymousString);
        }
        AppMethodBeat.o(140418);
      }
      
      public final void bV(String paramAnonymousString)
      {
        AppMethodBeat.i(140419);
        k.this.mUrl = paramAnonymousString;
        k.this.bZw.bZD.onReady();
        if (k.this.cau != null)
        {
          k.this.bZw.bM(k.this.cau.Bm());
          k.this.cau.bV(paramAnonymousString);
        }
        AppMethodBeat.o(140419);
      }
      
      public final WebResourceResponse bW(String paramAnonymousString)
      {
        AppMethodBeat.i(140420);
        bY(paramAnonymousString);
        paramAnonymousString = k.this.cay.cC(paramAnonymousString);
        AppMethodBeat.o(140420);
        return paramAnonymousString;
      }
      
      public final String bX(String paramAnonymousString)
      {
        AppMethodBeat.i(140422);
        paramAnonymousString = k.this.bZw.bZD.bN(paramAnonymousString);
        AppMethodBeat.o(140422);
        return paramAnonymousString;
      }
    };
    this.cas = new MutableContextWrapper(paramContext);
    paramContext = paramClass;
    if (paramClass == null) {
      paramContext = com.tencent.luggage.webview.default_impl.a.class;
    }
    this.cat = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    Bf();
    this.cav = ((com.tencent.luggage.webview.a)org.a.a.bA(this.cat).ag(new Object[] { this.cas }).object);
    this.cav.setWebCore(this);
    this.cav.a(this.caC);
    this.bZw = new o(this.cav);
    AppMethodBeat.o(140424);
  }
  
  private void Bf()
  {
    AppMethodBeat.i(140425);
    this.cay = new com.tencent.luggage.webview.a.b();
    this.caz = new com.tencent.luggage.webview.a.d();
    Bg();
    AppMethodBeat.o(140425);
  }
  
  private void Bg()
  {
    AppMethodBeat.i(140426);
    this.cay.a(new com.tencent.luggage.webview.a.a(this.cas));
    AppMethodBeat.o(140426);
  }
  
  private void Bk()
  {
    AppMethodBeat.i(140435);
    ViewParent localViewParent = getView().getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(getView());
    }
    AppMethodBeat.o(140435);
  }
  
  public final com.tencent.luggage.d.a.a Bh()
  {
    if (this.cax == null) {
      return com.tencent.luggage.d.a.a.caN;
    }
    return this.cax;
  }
  
  final void Bi()
  {
    AppMethodBeat.i(140430);
    if (this.caw)
    {
      this.caw = false;
      Bf();
    }
    AppMethodBeat.o(140430);
  }
  
  @Deprecated
  public final <T> T Bj()
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
      ad.e(getClass().getSimpleName(), "CoreImpl cast failed", new Object[] { localException });
      AppMethodBeat.o(140431);
    }
    return null;
  }
  
  public final void Bl()
  {
    try
    {
      AppMethodBeat.i(194785);
      if (!this.caA)
      {
        ad.m("Luggage.LuggageWebCore", "try inject jsbridge", new Object[0]);
        this.bZw.AK();
        if (this.cau != null) {
          this.bZw.bM(this.cau.Bm());
        }
        this.caA = true;
      }
      AppMethodBeat.o(194785);
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
          ad.e("Luggage.LuggageWebCore", "Null Event, Ignore");
          AppMethodBeat.o(140416);
          return;
        }
        if (paramAnonymousb == com.tencent.luggage.d.a.b.caQ)
        {
          paramAnonymousb = k.this.bZw;
          com.tencent.luggage.bridge.d locald = new com.tencent.luggage.bridge.d(paramc.name(), paramc.AM());
          paramAnonymousb.bZC.a(locald);
        }
        AppMethodBeat.o(140416);
      }
    };
    com.tencent.luggage.d.a.a locala = Bh();
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
          ((a)localObject1).bZT = paramb;
          this.caB.put(((a)localObject1).name(), localObject2);
          localObject2 = this.bZw;
          String str = ((a)localObject1).name();
          Object localObject1 = new com.tencent.luggage.bridge.l()
          {
            public final void a(com.tencent.luggage.bridge.k paramAnonymousk)
            {
              AppMethodBeat.i(140414);
              k localk = k.this;
              a locala = this.caD;
              paramAnonymousk = new k.2(localk, locala, paramAnonymousk);
              localk.Bh().a(locala.name(), paramAnonymousk);
              AppMethodBeat.o(140414);
            }
          };
          ((o)localObject2).bZE.put(str, localObject1);
        }
        catch (Exception localException2)
        {
          ad.e("Luggage.LuggageWebCore", "registerJsApi: ".concat(String.valueOf(localException2)));
        }
        localException1 = localException1;
        ad.e("Luggage.LuggageWebCore", "JsApi Initialize failed, %s, %s", new Object[] { ((Class)localObject2).getName(), localException1 });
      }
    }
    AppMethodBeat.o(140428);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140436);
    Bk();
    if (!this.caw) {
      this.cav.destroy();
    }
    AppMethodBeat.o(140436);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(140432);
    View localView = this.cav.getView();
    AppMethodBeat.o(140432);
    return localView;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(140433);
    this.cav.loadUrl(paramString);
    AppMethodBeat.o(140433);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(140427);
    this.cas.setBaseContext(paramContext);
    if (this.cav != null) {
      this.cav.setContext(paramContext);
    }
    AppMethodBeat.o(140427);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(140434);
    this.cav.stopLoading();
    AppMethodBeat.o(140434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.k
 * JD-Core Version:    0.7.0.1
 */