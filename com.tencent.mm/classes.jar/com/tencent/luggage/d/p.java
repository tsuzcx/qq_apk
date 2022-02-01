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
  private o eiB;
  private final MutableContextWrapper ejG;
  final Class<? extends com.tencent.luggage.webview.a> ejH;
  public q ejI;
  public com.tencent.luggage.webview.a ejJ;
  boolean ejK;
  public b ejL;
  private d ejM;
  private boolean ejN;
  private a.a ejO;
  private Handler mHandler;
  public String mUrl;
  
  public p(Context paramContext, Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    AppMethodBeat.i(140424);
    this.ejK = false;
    this.ejN = false;
    this.ejO = new a.a()
    {
      private void eK(String paramAnonymousString)
      {
        AppMethodBeat.i(219943);
        if (!p.f(p.this))
        {
          if (eL(paramAnonymousString))
          {
            AppMethodBeat.o(219943);
            return;
          }
          p.this.aoG();
        }
        AppMethodBeat.o(219943);
      }
      
      private static boolean eL(String paramAnonymousString)
      {
        AppMethodBeat.i(219945);
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          AppMethodBeat.o(219945);
          return false;
        }
        paramAnonymousString = Uri.parse(paramAnonymousString).getPath();
        if ((paramAnonymousString != null) && (paramAnonymousString.trim().endsWith("html")))
        {
          AppMethodBeat.o(219945);
          return true;
        }
        AppMethodBeat.o(219945);
        return false;
      }
      
      public final WebResourceResponse a(WebResourceRequest paramAnonymousWebResourceRequest, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(219953);
        eK(paramAnonymousWebResourceRequest.getUrl().toString());
        if (p.d(p.this) != null)
        {
          paramAnonymousBundle = p.d(p.this).a(paramAnonymousWebResourceRequest, paramAnonymousBundle);
          if (paramAnonymousBundle != null)
          {
            AppMethodBeat.o(219953);
            return paramAnonymousBundle;
          }
        }
        paramAnonymousWebResourceRequest = p.e(p.this).fN(paramAnonymousWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(219953);
        return paramAnonymousWebResourceRequest;
      }
      
      public final boolean eF(String paramAnonymousString)
      {
        AppMethodBeat.i(219947);
        Iterator localIterator = p.a(p.this).exu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Pair)localIterator.next();
          e locale = (e)((Pair)localObject).first;
          localObject = (Pattern)((Pair)localObject).second;
          if ((localObject != null) && (((Pattern)localObject).matcher(paramAnonymousString).matches()))
          {
            boolean bool = locale.atq();
            AppMethodBeat.o(219947);
            return bool;
          }
        }
        AppMethodBeat.o(219947);
        return false;
      }
      
      public final void eG(String paramAnonymousString)
      {
        AppMethodBeat.i(219948);
        p.b(p.this);
        p.a(p.this, paramAnonymousString);
        p.c(p.this);
        if (p.d(p.this) != null) {
          p.d(p.this).eG(paramAnonymousString);
        }
        AppMethodBeat.o(219948);
      }
      
      public final void eH(String paramAnonymousString)
      {
        AppMethodBeat.i(219950);
        p.a(p.this, paramAnonymousString);
        p.c(p.this).eiI.onReady();
        if (p.d(p.this) != null)
        {
          p.c(p.this).ey(p.d(p.this).aoH());
          p.d(p.this).eH(paramAnonymousString);
        }
        AppMethodBeat.o(219950);
      }
      
      public final WebResourceResponse eI(String paramAnonymousString)
      {
        AppMethodBeat.i(219952);
        eK(paramAnonymousString);
        if (p.d(p.this) != null)
        {
          WebResourceResponse localWebResourceResponse = p.d(p.this).aoI();
          if (localWebResourceResponse != null)
          {
            AppMethodBeat.o(219952);
            return localWebResourceResponse;
          }
        }
        paramAnonymousString = p.e(p.this).fN(paramAnonymousString);
        AppMethodBeat.o(219952);
        return paramAnonymousString;
      }
      
      public final String eJ(String paramAnonymousString)
      {
        AppMethodBeat.i(219954);
        paramAnonymousString = p.c(p.this).eiI.ez(paramAnonymousString);
        AppMethodBeat.o(219954);
        return paramAnonymousString;
      }
    };
    this.ejG = new MutableContextWrapper(paramContext);
    paramContext = paramClass;
    if (paramClass == null) {
      paramContext = com.tencent.luggage.webview.default_impl.a.class;
    }
    this.ejH = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    aoB();
    this.ejJ = ((com.tencent.luggage.webview.a)org.a.a.cQ(this.ejH).av(new Object[] { this.ejG }).object);
    this.ejJ.setWebCore(this);
    this.ejJ.a(this.ejO);
    this.eiB = new o(this.ejJ);
    AppMethodBeat.o(140424);
  }
  
  private void aoB()
  {
    AppMethodBeat.i(140425);
    this.ejL = new b();
    this.ejM = new d();
    aoC();
    AppMethodBeat.o(140425);
  }
  
  private void aoC()
  {
    AppMethodBeat.i(140426);
    this.ejL.a(new com.tencent.luggage.webview.a.a(this.ejG));
    AppMethodBeat.o(140426);
  }
  
  public final void aoD()
  {
    AppMethodBeat.i(140430);
    if (this.ejK)
    {
      this.ejK = false;
      aoB();
    }
    AppMethodBeat.o(140430);
  }
  
  @Deprecated
  public final <T> T aoE()
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
  
  public final void aoF()
  {
    AppMethodBeat.i(219944);
    if (this.ejJ != null) {
      this.ejJ.destroy();
    }
    AppMethodBeat.o(219944);
  }
  
  public final void aoG()
  {
    try
    {
      AppMethodBeat.i(219951);
      if (!this.ejN)
      {
        Log.printInfoStack("Luggage.LuggageWebCore", "try inject jsbridge", new Object[0]);
        this.eiB.aob();
        if (this.ejI != null) {
          this.eiB.ey(this.ejI.aoH());
        }
        this.ejN = true;
      }
      AppMethodBeat.o(219951);
      return;
    }
    finally {}
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(140436);
    Log.i("Luggage.LuggageWebCore", "destroy");
    if (!this.ejK) {
      this.ejJ.destroy();
    }
    AppMethodBeat.o(140436);
  }
  
  public final void eE(String paramString)
  {
    AppMethodBeat.i(219946);
    this.ejJ.evaluateJavascript(paramString, null);
    AppMethodBeat.o(219946);
  }
  
  public final o getBridge()
  {
    return this.eiB;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(219949);
    String str = this.ejJ.getUserAgent();
    AppMethodBeat.o(219949);
    return str;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(140432);
    View localView = this.ejJ.getView();
    AppMethodBeat.o(140432);
    return localView;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(140433);
    this.ejJ.loadUrl(paramString);
    AppMethodBeat.o(140433);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(140427);
    this.ejG.setBaseContext(paramContext);
    if (this.ejJ != null) {
      this.ejJ.setContext(paramContext);
    }
    AppMethodBeat.o(140427);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(140434);
    this.ejJ.stopLoading();
    AppMethodBeat.o(140434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.p
 * JD-Core Version:    0.7.0.1
 */