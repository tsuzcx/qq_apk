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
import com.tencent.mm.sdk.platformtools.ae;
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
      private void cI(String paramAnonymousString)
      {
        AppMethodBeat.i(201158);
        if (!p.this.chT)
        {
          if (cJ(paramAnonymousString))
          {
            AppMethodBeat.o(201158);
            return;
          }
          p.this.Cr();
        }
        AppMethodBeat.o(201158);
      }
      
      private static boolean cJ(String paramAnonymousString)
      {
        AppMethodBeat.i(201159);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(201159);
          return false;
        }
        paramAnonymousString = Uri.parse(paramAnonymousString).getPath();
        if ((paramAnonymousString != null) && (paramAnonymousString.trim().endsWith("html")))
        {
          AppMethodBeat.o(201159);
          return true;
        }
        AppMethodBeat.o(201159);
        return false;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(201156);
        cI(paramAnonymousWebResourceRequest.getUrl().toString());
        if (p.this.chO != null)
        {
          paramAnonymousBundle = p.this.chO.a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          if (paramAnonymousBundle != null)
          {
            AppMethodBeat.o(201156);
            return paramAnonymousBundle;
          }
        }
        paramAnonymousWebResourceRequest = p.this.chR.dv(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(201156);
        return paramAnonymousWebResourceRequest;
      }
      
      public final boolean cD(String paramAnonymousString)
      {
        AppMethodBeat.i(201152);
        Iterator localIterator = p.this.chS.crl.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Pair)localIterator.next();
          e locale = (e)((Pair)localObject).first;
          localObject = (Pattern)((Pair)localObject).second;
          if ((localObject != null) && (((Pattern)localObject).matcher(paramAnonymousString).matches()))
          {
            boolean bool = locale.FD();
            AppMethodBeat.o(201152);
            return bool;
          }
        }
        AppMethodBeat.o(201152);
        return false;
      }
      
      public final void cE(String paramAnonymousString)
      {
        AppMethodBeat.i(201153);
        p.this.chT = false;
        p.this.mUrl = paramAnonymousString;
        if (p.this.chO != null) {
          p.this.chO.cE(paramAnonymousString);
        }
        AppMethodBeat.o(201153);
      }
      
      public final void cF(String paramAnonymousString)
      {
        AppMethodBeat.i(201154);
        p.this.mUrl = paramAnonymousString;
        p.this.cgI.cgP.onReady();
        if (p.this.chO != null)
        {
          p.this.cgI.cw(p.this.chO.Cs());
          p.this.chO.cF(paramAnonymousString);
        }
        AppMethodBeat.o(201154);
      }
      
      public final WebResourceResponse cG(String paramAnonymousString)
      {
        AppMethodBeat.i(201155);
        cI(paramAnonymousString);
        paramAnonymousString = p.this.chR.dv(paramAnonymousString);
        AppMethodBeat.o(201155);
        return paramAnonymousString;
      }
      
      public final String cH(String paramAnonymousString)
      {
        AppMethodBeat.i(201157);
        paramAnonymousString = p.this.cgI.cgP.cx(paramAnonymousString);
        AppMethodBeat.o(201157);
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
    Cm();
    this.chP = ((com.tencent.luggage.webview.a)org.a.a.bF(this.chN).ai(new Object[] { this.chM }).object);
    this.chP.setWebCore(this);
    this.chP.a(this.chU);
    this.cgI = new o(this.chP);
    AppMethodBeat.o(140424);
  }
  
  private void Cm()
  {
    AppMethodBeat.i(140425);
    this.chR = new b();
    this.chS = new d();
    Cn();
    AppMethodBeat.o(140425);
  }
  
  private void Cn()
  {
    AppMethodBeat.i(140426);
    this.chR.a(new com.tencent.luggage.webview.a.a(this.chM));
    AppMethodBeat.o(140426);
  }
  
  private void Cq()
  {
    AppMethodBeat.i(140435);
    ViewParent localViewParent = getView().getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(getView());
    }
    AppMethodBeat.o(140435);
  }
  
  final void Co()
  {
    AppMethodBeat.i(140430);
    if (this.chQ)
    {
      this.chQ = false;
      Cm();
    }
    AppMethodBeat.o(140430);
  }
  
  @Deprecated
  public final <T> T Cp()
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
      ae.e(getClass().getSimpleName(), "CoreImpl cast failed", new Object[] { localException });
      AppMethodBeat.o(140431);
    }
    return null;
  }
  
  public final void Cr()
  {
    try
    {
      AppMethodBeat.i(201162);
      if (!this.chT)
      {
        ae.m("Luggage.LuggageWebCore", "try inject jsbridge", new Object[0]);
        this.cgI.BM();
        if (this.chO != null) {
          this.cgI.cw(this.chO.Cs());
        }
        this.chT = true;
      }
      AppMethodBeat.o(201162);
      return;
    }
    finally {}
  }
  
  public final void cC(String paramString)
  {
    AppMethodBeat.i(201160);
    this.chP.evaluateJavascript(paramString, null);
    AppMethodBeat.o(201160);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140436);
    Cq();
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
    AppMethodBeat.i(201161);
    String str = this.chP.getUserAgent();
    AppMethodBeat.o(201161);
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