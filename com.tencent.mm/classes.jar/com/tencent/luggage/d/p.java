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

public final class p
  extends n
{
  o csD;
  private final MutableContextWrapper ctH;
  final Class<? extends com.tencent.luggage.webview.a> ctI;
  public q ctJ;
  public com.tencent.luggage.webview.a ctK;
  boolean ctL;
  public b ctM;
  d ctN;
  boolean ctO;
  private a.a ctP;
  private Handler mHandler;
  public String mUrl;
  
  public p(Context paramContext, Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    AppMethodBeat.i(140424);
    this.ctL = false;
    this.ctO = false;
    this.ctP = new a.a()
    {
      private void cZ(String paramAnonymousString)
      {
        AppMethodBeat.i(221195);
        if (!p.this.ctO)
        {
          if (df(paramAnonymousString))
          {
            AppMethodBeat.o(221195);
            return;
          }
          p.this.LI();
        }
        AppMethodBeat.o(221195);
      }
      
      private static boolean df(String paramAnonymousString)
      {
        AppMethodBeat.i(221196);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(221196);
          return false;
        }
        paramAnonymousString = Uri.parse(paramAnonymousString).getPath();
        if ((paramAnonymousString != null) && (paramAnonymousString.trim().endsWith("html")))
        {
          AppMethodBeat.o(221196);
          return true;
        }
        AppMethodBeat.o(221196);
        return false;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(221193);
        cZ(paramAnonymousWebResourceRequest.getUrl().toString());
        if (p.this.ctJ != null)
        {
          paramAnonymousBundle = p.this.ctJ.a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          if (paramAnonymousBundle != null)
          {
            AppMethodBeat.o(221193);
            return paramAnonymousBundle;
          }
        }
        paramAnonymousWebResourceRequest = p.this.ctM.dO(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(221193);
        return paramAnonymousWebResourceRequest;
      }
      
      public final boolean cU(String paramAnonymousString)
      {
        AppMethodBeat.i(221189);
        Iterator localIterator = p.this.ctN.cDB.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Pair)localIterator.next();
          e locale = (e)((Pair)localObject).first;
          localObject = (Pattern)((Pair)localObject).second;
          if ((localObject != null) && (((Pattern)localObject).matcher(paramAnonymousString).matches()))
          {
            boolean bool = locale.Pm();
            AppMethodBeat.o(221189);
            return bool;
          }
        }
        AppMethodBeat.o(221189);
        return false;
      }
      
      public final void cV(String paramAnonymousString)
      {
        AppMethodBeat.i(221190);
        p.this.ctO = false;
        p.this.mUrl = paramAnonymousString;
        if (p.this.ctJ != null) {
          p.this.ctJ.cV(paramAnonymousString);
        }
        AppMethodBeat.o(221190);
      }
      
      public final void cW(String paramAnonymousString)
      {
        AppMethodBeat.i(221191);
        p.this.mUrl = paramAnonymousString;
        p.this.csD.csK.onReady();
        if (p.this.ctJ != null)
        {
          p.this.csD.cN(p.this.ctJ.LJ());
          p.this.ctJ.cW(paramAnonymousString);
        }
        AppMethodBeat.o(221191);
      }
      
      public final WebResourceResponse cX(String paramAnonymousString)
      {
        AppMethodBeat.i(221192);
        cZ(paramAnonymousString);
        paramAnonymousString = p.this.ctM.dO(paramAnonymousString);
        AppMethodBeat.o(221192);
        return paramAnonymousString;
      }
      
      public final String cY(String paramAnonymousString)
      {
        AppMethodBeat.i(221194);
        paramAnonymousString = p.this.csD.csK.cO(paramAnonymousString);
        AppMethodBeat.o(221194);
        return paramAnonymousString;
      }
    };
    this.ctH = new MutableContextWrapper(paramContext);
    paramContext = paramClass;
    if (paramClass == null) {
      paramContext = com.tencent.luggage.webview.default_impl.a.class;
    }
    this.ctI = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    LD();
    this.ctK = ((com.tencent.luggage.webview.a)org.a.a.bF(this.ctI).ak(new Object[] { this.ctH }).object);
    this.ctK.setWebCore(this);
    this.ctK.a(this.ctP);
    this.csD = new o(this.ctK);
    AppMethodBeat.o(140424);
  }
  
  private void LD()
  {
    AppMethodBeat.i(140425);
    this.ctM = new b();
    this.ctN = new d();
    LE();
    AppMethodBeat.o(140425);
  }
  
  private void LE()
  {
    AppMethodBeat.i(140426);
    this.ctM.a(new com.tencent.luggage.webview.a.a(this.ctH));
    AppMethodBeat.o(140426);
  }
  
  public final void LF()
  {
    AppMethodBeat.i(140430);
    if (this.ctL)
    {
      this.ctL = false;
      LD();
    }
    AppMethodBeat.o(140430);
  }
  
  @Deprecated
  public final <T> T LG()
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
  
  public final void LH()
  {
    AppMethodBeat.i(221197);
    if (this.ctK != null) {
      this.ctK.destroy();
    }
    AppMethodBeat.o(221197);
  }
  
  public final void LI()
  {
    try
    {
      AppMethodBeat.i(221200);
      if (!this.ctO)
      {
        Log.printInfoStack("Luggage.LuggageWebCore", "try inject jsbridge", new Object[0]);
        this.csD.La();
        if (this.ctJ != null) {
          this.csD.cN(this.ctJ.LJ());
        }
        this.ctO = true;
      }
      AppMethodBeat.o(221200);
      return;
    }
    finally {}
  }
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(221198);
    this.ctK.evaluateJavascript(paramString, null);
    AppMethodBeat.o(221198);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140436);
    Log.i("Luggage.LuggageWebCore", "destroy");
    if (!this.ctL) {
      this.ctK.destroy();
    }
    AppMethodBeat.o(140436);
  }
  
  final o getBridge()
  {
    return this.csD;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(221199);
    String str = this.ctK.getUserAgent();
    AppMethodBeat.o(221199);
    return str;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(140432);
    View localView = this.ctK.getView();
    AppMethodBeat.o(140432);
    return localView;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(140433);
    this.ctK.loadUrl(paramString);
    AppMethodBeat.o(140433);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(140427);
    this.ctH.setBaseContext(paramContext);
    if (this.ctK != null) {
      this.ctK.setContext(paramContext);
    }
    AppMethodBeat.o(140427);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(140434);
    this.ctK.stopLoading();
    AppMethodBeat.o(140434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.p
 * JD-Core Version:    0.7.0.1
 */