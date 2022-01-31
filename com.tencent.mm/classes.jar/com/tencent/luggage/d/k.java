package com.tencent.luggage.d;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class k
  implements b
{
  o byf;
  private final MutableContextWrapper bzc;
  final Class<? extends com.tencent.luggage.webview.a> bzd;
  public l bze;
  public com.tencent.luggage.webview.a bzf;
  boolean bzg;
  public com.tencent.luggage.d.a.a bzh;
  public com.tencent.luggage.webview.a.b bzi;
  com.tencent.luggage.webview.a.d bzj;
  final ConcurrentHashMap<String, Class<? extends a>> bzk;
  private a.a bzl;
  private Handler mHandler;
  public String mUrl;
  
  public k(Context paramContext, Class<? extends com.tencent.luggage.webview.a> paramClass)
  {
    AppMethodBeat.i(90823);
    this.bzg = false;
    this.bzk = new ConcurrentHashMap();
    this.bzl = new k.4(this);
    this.bzc = new MutableContextWrapper(paramContext);
    paramContext = paramClass;
    if (paramClass == null) {
      paramContext = com.tencent.luggage.webview.default_impl.a.class;
    }
    this.bzd = paramContext;
    this.mHandler = new Handler(Looper.getMainLooper());
    ur();
    this.bzf = ((com.tencent.luggage.webview.a)org.a.a.ba(this.bzd).ac(new Object[] { this.bzc }).object);
    this.bzf.setWebCore(this);
    this.bzf.a(this.bzl);
    this.byf = new o(this.bzf);
    AppMethodBeat.o(90823);
  }
  
  private void ur()
  {
    AppMethodBeat.i(90824);
    this.bzi = new com.tencent.luggage.webview.a.b();
    this.bzj = new com.tencent.luggage.webview.a.d();
    us();
    AppMethodBeat.o(90824);
  }
  
  private void us()
  {
    AppMethodBeat.i(90825);
    this.bzi.a(new com.tencent.luggage.webview.a.a(this.bzc));
    AppMethodBeat.o(90825);
  }
  
  private void uw()
  {
    AppMethodBeat.i(90834);
    ViewParent localViewParent = getView().getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(getView());
    }
    AppMethodBeat.o(90834);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(90828);
    k.3 local3 = new k.3(this, paramc);
    com.tencent.luggage.d.a.a locala = ut();
    paramc.name();
    locala.a(local3);
    AppMethodBeat.o(90828);
  }
  
  public final void a(List<Class<? extends a>> paramList, b paramb)
  {
    AppMethodBeat.i(90827);
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
          ((a)localObject1).byD = paramb;
          this.bzk.put(((a)localObject1).name(), localObject2);
          localObject2 = this.byf;
          String str = ((a)localObject1).name();
          Object localObject1 = new k.1(this, (a)localObject1);
          ((o)localObject2).byo.put(str, localObject1);
        }
        catch (Exception localException2)
        {
          com.tencent.luggage.g.d.e("Luggage.LuggageWebCore", "registerJsApi: ".concat(String.valueOf(localException2)));
        }
        localException1 = localException1;
        com.tencent.luggage.g.d.e("Luggage.LuggageWebCore", "JsApi Initialize failed, %s, %s", new Object[] { ((Class)localObject2).getName(), localException1 });
      }
    }
    AppMethodBeat.o(90827);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(90835);
    uw();
    if (!this.bzg) {
      this.bzf.destroy();
    }
    AppMethodBeat.o(90835);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(90831);
    View localView = this.bzf.getView();
    AppMethodBeat.o(90831);
    return localView;
  }
  
  public final void loadUrl(String paramString)
  {
    AppMethodBeat.i(90832);
    this.bzf.loadUrl(paramString);
    AppMethodBeat.o(90832);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(90826);
    this.bzc.setBaseContext(paramContext);
    if (this.bzf != null) {
      this.bzf.setContext(paramContext);
    }
    AppMethodBeat.o(90826);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(90833);
    this.bzf.stopLoading();
    AppMethodBeat.o(90833);
  }
  
  public final com.tencent.luggage.d.a.a ut()
  {
    if (this.bzh == null) {
      return com.tencent.luggage.d.a.a.bzy;
    }
    return this.bzh;
  }
  
  final void uu()
  {
    AppMethodBeat.i(90829);
    if (this.bzg)
    {
      this.bzg = false;
      ur();
    }
    AppMethodBeat.o(90829);
  }
  
  @Deprecated
  public final <T> T uv()
  {
    AppMethodBeat.i(90830);
    try
    {
      View localView = getView();
      AppMethodBeat.o(90830);
      return localView;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.g.d.e(getClass().getSimpleName(), "CoreImpl cast failed", new Object[] { localException });
      AppMethodBeat.o(90830);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.d.k
 * JD-Core Version:    0.7.0.1
 */