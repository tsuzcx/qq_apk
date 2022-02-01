package com.tencent.luggage.d;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.webview.a.a;
import com.tencent.luggage.webview.a.b;
import com.tencent.luggage.webview.a.d;
import com.tencent.luggage.webview.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p
  extends n
{
  private o cqI;
  private final MutableContextWrapper crM;
  final Class<? extends com.tencent.luggage.webview.a> crN;
  public q crO;
  public com.tencent.luggage.webview.a crP;
  boolean crQ;
  public b crR;
  private d crS;
  private boolean crT;
  private a.a crU;
  private Handler mHandler;
  public String mUrl;
  
  public p(Context paramContext, Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    AppMethodBeat.i(140424);
    this.crQ = false;
    this.crT = false;
    this.crU = new a.a()
    {
      private static boolean dA(String paramAnonymousString)
      {
        AppMethodBeat.i(209276);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(209276);
          return false;
        }
        paramAnonymousString = Uri.parse(paramAnonymousString).getPath();
        if ((paramAnonymousString != null) && (paramAnonymousString.trim().endsWith("html")))
        {
          AppMethodBeat.o(209276);
          return true;
        }
        AppMethodBeat.o(209276);
        return false;
      }
      
      private void dz(String paramAnonymousString)
      {
        AppMethodBeat.i(209273);
        if (!p.f(p.this))
        {
          if (dA(paramAnonymousString))
          {
            AppMethodBeat.o(209273);
            return;
          }
          p.this.Oy();
        }
        AppMethodBeat.o(209273);
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(209268);
        dz(paramAnonymousWebResourceRequest.getUrl().toString());
        if (p.d(p.this) != null)
        {
          paramAnonymousBundle = p.d(p.this).a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          if (paramAnonymousBundle != null)
          {
            AppMethodBeat.o(209268);
            return paramAnonymousBundle;
          }
        }
        paramAnonymousWebResourceRequest = p.e(p.this).eq(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(209268);
        return paramAnonymousWebResourceRequest;
      }
      
      public final boolean du(String paramAnonymousString)
      {
        AppMethodBeat.i(209257);
        Iterator localIterator = p.a(p.this).cEi.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Pair)localIterator.next();
          e locale = (e)((Pair)localObject).first;
          localObject = (Pattern)((Pair)localObject).second;
          if ((localObject != null) && (((Pattern)localObject).matcher(paramAnonymousString).matches()))
          {
            boolean bool = locale.SL();
            AppMethodBeat.o(209257);
            return bool;
          }
        }
        AppMethodBeat.o(209257);
        return false;
      }
      
      public final void dv(String paramAnonymousString)
      {
        AppMethodBeat.i(209261);
        p.b(p.this);
        p.a(p.this, paramAnonymousString);
        p.c(p.this);
        if (p.d(p.this) != null) {
          p.d(p.this).dv(paramAnonymousString);
        }
        AppMethodBeat.o(209261);
      }
      
      public final void dw(String paramAnonymousString)
      {
        AppMethodBeat.i(209263);
        p.a(p.this, paramAnonymousString);
        p.c(p.this).cqP.NR();
        if (p.d(p.this) != null)
        {
          p.c(p.this).dl(p.d(p.this).Oz());
          p.d(p.this).dw(paramAnonymousString);
        }
        AppMethodBeat.o(209263);
      }
      
      public final WebResourceResponse dx(String paramAnonymousString)
      {
        AppMethodBeat.i(209266);
        dz(paramAnonymousString);
        if (p.d(p.this) != null) {
          p.d(p.this);
        }
        paramAnonymousString = p.e(p.this).eq(paramAnonymousString);
        AppMethodBeat.o(209266);
        return paramAnonymousString;
      }
      
      public final String dy(String paramAnonymousString)
      {
        AppMethodBeat.i(209270);
        paramAnonymousString = p.c(p.this).cqP.dm(paramAnonymousString);
        AppMethodBeat.o(209270);
        return paramAnonymousString;
      }
    };
    this.crM = new MutableContextWrapper(paramContext);
    paramContext = paramClass;
    if (paramClass == null) {
      paramContext = com.tencent.luggage.webview.default_impl.a.class;
    }
    this.crN = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    Ot();
    this.crP = ((com.tencent.luggage.webview.a)org.a.a.ce(this.crN).ao(new Object[] { this.crM }).object);
    this.crP.setWebCore(this);
    this.crP.a(this.crU);
    this.cqI = new o(this.crP);
    AppMethodBeat.o(140424);
  }
  
  private void Ot()
  {
    AppMethodBeat.i(140425);
    this.crR = new b();
    this.crS = new d();
    Ou();
    AppMethodBeat.o(140425);
  }
  
  private void Ou()
  {
    AppMethodBeat.i(140426);
    this.crR.a(new com.tencent.luggage.webview.a.a(this.crM));
    AppMethodBeat.o(140426);
  }
  
  public final void Ov()
  {
    AppMethodBeat.i(140430);
    if (this.crQ)
    {
      this.crQ = false;
      Ot();
    }
    AppMethodBeat.o(140430);
  }
  
  @Deprecated
  public final <T> T Ow()
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
      Log.e(getClass().getSimpleName(), "CoreImpl cast failed", new Object[] { localException });
      AppMethodBeat.o(140431);
    }
    return null;
  }
  
  public final void Ox()
  {
    AppMethodBeat.i(210244);
    if (this.crP != null) {
      this.crP.destroy();
    }
    AppMethodBeat.o(210244);
  }
  
  public final void Oy()
  {
    try
    {
      AppMethodBeat.i(210255);
      if (!this.crT)
      {
        Log.printInfoStack("Luggage.LuggageWebCore", "try inject jsbridge", new Object[0]);
        this.cqI.NQ();
        if (this.crO != null) {
          this.cqI.dl(this.crO.Oz());
        }
        this.crT = true;
      }
      AppMethodBeat.o(210255);
      return;
    }
    finally {}
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140436);
    Log.i("Luggage.LuggageWebCore", "destroy");
    if (!this.crQ) {
      this.crP.destroy();
    }
    AppMethodBeat.o(140436);
  }
  
  public final void dt(String paramString)
  {
    AppMethodBeat.i(210248);
    this.crP.evaluateJavascript(paramString, null);
    AppMethodBeat.o(210248);
  }
  
  public final o getBridge()
  {
    return this.cqI;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(210253);
    String str = this.crP.getUserAgent();
    AppMethodBeat.o(210253);
    return str;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(140432);
    View localView = this.crP.getView();
    AppMethodBeat.o(140432);
    return localView;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(140433);
    this.crP.loadUrl(paramString);
    AppMethodBeat.o(140433);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(140427);
    this.crM.setBaseContext(paramContext);
    if (this.crP != null) {
      this.crP.setContext(paramContext);
    }
    AppMethodBeat.o(140427);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(140434);
    this.crP.stopLoading();
    AppMethodBeat.o(140434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.p
 * JD-Core Version:    0.7.0.1
 */