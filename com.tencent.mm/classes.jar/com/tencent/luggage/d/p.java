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
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.webview.a.a;
import com.tencent.luggage.webview.a.b;
import com.tencent.luggage.webview.a.d;
import com.tencent.luggage.webview.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class p
  extends n
{
  o cgI;
  private final MutableContextWrapper chM;
  final Class<? extends com.tencent.luggage.webview.a> chN;
  public q chO;
  public com.tencent.luggage.webview.a chP;
  boolean chQ;
  public b chR;
  d chS;
  boolean chT;
  private a.a chU;
  private Handler mHandler;
  public String mUrl;
  
  public p(Context paramContext, Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    AppMethodBeat.i(140424);
    this.chQ = false;
    this.chT = false;
    this.chU = new a.a()
    {
      private void cH(String paramAnonymousString)
      {
        AppMethodBeat.i(187591);
        if (!p.this.chT)
        {
          if (cI(paramAnonymousString))
          {
            AppMethodBeat.o(187591);
            return;
          }
          p.this.Co();
        }
        AppMethodBeat.o(187591);
      }
      
      private static boolean cI(String paramAnonymousString)
      {
        AppMethodBeat.i(187592);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(187592);
          return false;
        }
        paramAnonymousString = Uri.parse(paramAnonymousString).getPath();
        if ((paramAnonymousString != null) && (paramAnonymousString.trim().endsWith("html")))
        {
          AppMethodBeat.o(187592);
          return true;
        }
        AppMethodBeat.o(187592);
        return false;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(187589);
        cH(paramAnonymousWebResourceRequest.getUrl().toString());
        if (p.this.chO != null)
        {
          paramAnonymousBundle = p.this.chO.a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          if (paramAnonymousBundle != null)
          {
            AppMethodBeat.o(187589);
            return paramAnonymousBundle;
          }
        }
        paramAnonymousWebResourceRequest = p.this.chR.dt(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(187589);
        return paramAnonymousWebResourceRequest;
      }
      
      public final boolean cC(String paramAnonymousString)
      {
        AppMethodBeat.i(187585);
        Iterator localIterator = p.this.chS.cqH.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Pair)localIterator.next();
          e locale = (e)((Pair)localObject).first;
          localObject = (Pattern)((Pair)localObject).second;
          if ((localObject != null) && (((Pattern)localObject).matcher(paramAnonymousString).matches()))
          {
            boolean bool = locale.Fx();
            AppMethodBeat.o(187585);
            return bool;
          }
        }
        AppMethodBeat.o(187585);
        return false;
      }
      
      public final void cD(String paramAnonymousString)
      {
        AppMethodBeat.i(187586);
        p.this.chT = false;
        p.this.mUrl = paramAnonymousString;
        if (p.this.chO != null) {
          p.this.chO.cD(paramAnonymousString);
        }
        AppMethodBeat.o(187586);
      }
      
      public final void cE(String paramAnonymousString)
      {
        AppMethodBeat.i(187587);
        p.this.mUrl = paramAnonymousString;
        p.this.cgI.cgP.onReady();
        if (p.this.chO != null)
        {
          p.this.cgI.cv(p.this.chO.Cp());
          p.this.chO.cE(paramAnonymousString);
        }
        AppMethodBeat.o(187587);
      }
      
      public final WebResourceResponse cF(String paramAnonymousString)
      {
        AppMethodBeat.i(187588);
        cH(paramAnonymousString);
        paramAnonymousString = p.this.chR.dt(paramAnonymousString);
        AppMethodBeat.o(187588);
        return paramAnonymousString;
      }
      
      public final String cG(String paramAnonymousString)
      {
        AppMethodBeat.i(187590);
        paramAnonymousString = p.this.cgI.cgP.cw(paramAnonymousString);
        AppMethodBeat.o(187590);
        return paramAnonymousString;
      }
    };
    this.chM = new MutableContextWrapper(paramContext);
    paramContext = paramClass;
    if (paramClass == null) {
      paramContext = com.tencent.luggage.webview.default_impl.a.class;
    }
    this.chN = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    Cj();
    this.chP = ((com.tencent.luggage.webview.a)org.a.a.bF(this.chN).aj(new Object[] { this.chM }).object);
    this.chP.setWebCore(this);
    this.chP.a(this.chU);
    this.cgI = new o(this.chP);
    AppMethodBeat.o(140424);
  }
  
  private void Cj()
  {
    AppMethodBeat.i(140425);
    this.chR = new b();
    this.chS = new d();
    Ck();
    AppMethodBeat.o(140425);
  }
  
  private void Ck()
  {
    AppMethodBeat.i(140426);
    this.chR.a(new com.tencent.luggage.webview.a.a(this.chM));
    AppMethodBeat.o(140426);
  }
  
  private void Cn()
  {
    AppMethodBeat.i(140435);
    ViewParent localViewParent = getView().getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(getView());
    }
    AppMethodBeat.o(140435);
  }
  
  final void Cl()
  {
    AppMethodBeat.i(140430);
    if (this.chQ)
    {
      this.chQ = false;
      Cj();
    }
    AppMethodBeat.o(140430);
  }
  
  @Deprecated
  public final <T> T Cm()
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
  
  public final void Co()
  {
    try
    {
      AppMethodBeat.i(187595);
      if (!this.chT)
      {
        ad.m("Luggage.LuggageWebCore", "try inject jsbridge", new Object[0]);
        this.cgI.BL();
        if (this.chO != null) {
          this.cgI.cv(this.chO.Cp());
        }
        this.chT = true;
      }
      AppMethodBeat.o(187595);
      return;
    }
    finally {}
  }
  
  public final void cB(String paramString)
  {
    AppMethodBeat.i(187593);
    this.chP.evaluateJavascript(paramString, null);
    AppMethodBeat.o(187593);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140436);
    Cn();
    if (!this.chQ) {
      this.chP.destroy();
    }
    AppMethodBeat.o(140436);
  }
  
  final o getBridge()
  {
    return this.cgI;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(187594);
    String str = this.chP.getUserAgent();
    AppMethodBeat.o(187594);
    return str;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(140432);
    View localView = this.chP.getView();
    AppMethodBeat.o(140432);
    return localView;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(140433);
    this.chP.loadUrl(paramString);
    AppMethodBeat.o(140433);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(140427);
    this.chM.setBaseContext(paramContext);
    if (this.chP != null) {
      this.chP.setContext(paramContext);
    }
    AppMethodBeat.o(140427);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(140434);
    this.chP.stopLoading();
    AppMethodBeat.o(140434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.p
 * JD-Core Version:    0.7.0.1
 */