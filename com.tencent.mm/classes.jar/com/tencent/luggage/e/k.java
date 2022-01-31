package com.tencent.luggage.e;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.f;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.p;
import com.tencent.luggage.webview.a.a;
import com.tencent.luggage.webview.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k
  implements b
{
  o bhF;
  private final MutableContextWrapper biE;
  final Class<? extends com.tencent.luggage.webview.a> biF;
  l biG;
  public com.tencent.luggage.webview.a biH;
  boolean biI = false;
  public com.tencent.luggage.e.a.a biJ;
  public com.tencent.luggage.webview.a.b biK;
  com.tencent.luggage.webview.a.d biL;
  final ConcurrentHashMap<String, Class<? extends a>> biM = new ConcurrentHashMap();
  private a.a biN = new a.a()
  {
    public final void bc(String paramAnonymousString)
    {
      k.this.mUrl = paramAnonymousString;
      k.this.bc(paramAnonymousString);
      k.this.bhF.bhN.pT();
      if (k.this.biG != null)
      {
        k.this.bhF.aV(k.this.biG.qq());
        k.this.biG.bc(paramAnonymousString);
      }
    }
    
    public final void bd(String paramAnonymousString)
    {
      k.this.mUrl = paramAnonymousString;
      k.this.bd(paramAnonymousString);
      k.this.bhF.bhN.onReady();
      if (k.this.biG != null)
      {
        k.this.bhF.aV(k.this.biG.qq());
        k.this.biG.bd(paramAnonymousString);
      }
    }
    
    public final boolean be(String paramAnonymousString)
    {
      Iterator localIterator = k.this.biL.bjT.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Pair)localIterator.next();
        e locale = (e)((Pair)localObject).first;
        localObject = (Pattern)((Pair)localObject).second;
        if ((localObject != null) && (((Pattern)localObject).matcher(paramAnonymousString).matches())) {
          return locale.qy();
        }
      }
      return false;
    }
    
    public final WebResourceResponse bf(String paramAnonymousString)
    {
      Iterator localIterator = k.this.biK.bjT.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Pair)localIterator.next();
        Object localObject1 = (com.tencent.luggage.webview.a.c)((Pair)localObject2).first;
        localObject2 = (Pattern)((Pair)localObject2).second;
        if ((localObject2 != null) && (((Pattern)localObject2).matcher(paramAnonymousString).matches()))
        {
          localObject1 = ((com.tencent.luggage.webview.a.c)localObject1).bf(paramAnonymousString);
          if (localObject1 != null) {
            return localObject1;
          }
        }
      }
      return null;
    }
    
    public final String bg(String paramAnonymousString)
    {
      return k.this.bhF.bhN.aW(paramAnonymousString);
    }
  };
  private Handler mHandler;
  public String mUrl;
  
  public k(Context paramContext, Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    this.biE = new MutableContextWrapper(paramContext);
    paramContext = paramClass;
    if (paramClass == null) {
      paramContext = com.tencent.luggage.webview.default_impl.a.class;
    }
    this.biF = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.biH = ((com.tencent.luggage.webview.a)org.b.a.al(this.biF).F(new Object[] { this.biE.getBaseContext() }).object);
    this.biH.a(this.biN);
    this.bhF = new o(this.biH);
    qn();
  }
  
  private void qn()
  {
    this.biK = new com.tencent.luggage.webview.a.b();
    this.biL = new com.tencent.luggage.webview.a.d();
    this.biK.a(new com.tencent.luggage.webview.a.a(this.biE.getBaseContext()));
  }
  
  public final void a(final c paramc)
  {
    paramc = new com.tencent.luggage.e.a.c()
    {
      public final void a(com.tencent.luggage.e.a.b paramAnonymousb)
      {
        if (paramc == null) {
          com.tencent.luggage.j.c.e("Luggage.LuggageWebCore", "Null Event, Ignore");
        }
        while (paramAnonymousb != com.tencent.luggage.e.a.b.bjc) {
          return;
        }
        paramAnonymousb = k.this.bhF;
        com.tencent.luggage.bridge.d locald = new com.tencent.luggage.bridge.d(paramc.name(), paramc.pV());
        paramAnonymousb.bhM.a(locald);
      }
    };
    qo().a(paramc);
  }
  
  public final void a(List<Class<? extends a>> paramList, b paramb)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    if (localIterator.hasNext()) {
      localObject2 = (Class)localIterator.next();
    }
    for (;;)
    {
      try
      {
        localObject1 = (a)((Class)localObject2).newInstance();
        if (paramb != null) {
          break label156;
        }
        paramList = this;
      }
      catch (Exception paramList)
      {
        try
        {
          ((a)localObject1).bif = paramList;
          this.biM.put(((a)localObject1).name(), localObject2);
          paramList = this.bhF;
          localObject2 = ((a)localObject1).name();
          Object localObject1 = new k.1(this, (a)localObject1);
          paramList.bhO.put(localObject2, localObject1);
        }
        catch (Exception paramList)
        {
          com.tencent.luggage.j.c.e("Luggage.LuggageWebCore", "registerJsApi: " + paramList);
        }
        paramList = paramList;
        com.tencent.luggage.j.c.e("Luggage.LuggageWebCore", "JsApi Initialize failed, %s, %s", new Object[] { ((Class)localObject2).getName(), paramList });
      }
      break;
      break;
      return;
      label156:
      paramList = paramb;
    }
  }
  
  final void aaj()
  {
    if (this.biI)
    {
      this.biI = false;
      qn();
    }
  }
  
  public void bc(String paramString) {}
  
  public void bd(String paramString) {}
  
  public final void destroy()
  {
    ViewParent localViewParent = getView().getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(getView());
    }
    if (!this.biI) {
      this.mHandler.postDelayed(new k.4(this), 500L);
    }
  }
  
  public final View getView()
  {
    return this.biH.getView();
  }
  
  public void loadUrl(String paramString)
  {
    this.biH.loadUrl(paramString);
  }
  
  final com.tencent.luggage.e.a.a qo()
  {
    if (this.biJ == null) {
      return com.tencent.luggage.e.a.a.biZ;
    }
    return this.biJ;
  }
  
  @Deprecated
  public final <T> T qp()
  {
    try
    {
      View localView = getView();
      return localView;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.j.c.e(getClass().getSimpleName(), "CoreImpl cast failed", new Object[] { localException });
    }
    return null;
  }
  
  public final void setContext(Context paramContext)
  {
    this.biE.setBaseContext(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.e.k
 * JD-Core Version:    0.7.0.1
 */