package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e jkA;
  public Map<String, WeakReference<View>> jkB;
  
  private e()
  {
    AppMethodBeat.i(121159);
    this.jkB = new ConcurrentHashMap();
    AppMethodBeat.o(121159);
  }
  
  public static e aVf()
  {
    AppMethodBeat.i(121160);
    if (jkA == null) {}
    try
    {
      if (jkA == null) {
        jkA = new e();
      }
      e locale = jkA;
      AppMethodBeat.o(121160);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121160);
    }
  }
  
  public final View GS(String paramString)
  {
    AppMethodBeat.i(121162);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
      AppMethodBeat.o(121162);
      return null;
    }
    paramString = (WeakReference)this.jkB.get(paramString);
    if (paramString != null)
    {
      paramString = (View)paramString.get();
      AppMethodBeat.o(121162);
      return paramString;
    }
    AppMethodBeat.o(121162);
    return null;
  }
  
  public final boolean c(String paramString, View paramView)
  {
    AppMethodBeat.i(121161);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
      AppMethodBeat.o(121161);
      return false;
    }
    if (paramView == null)
    {
      ad.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
      AppMethodBeat.o(121161);
      return false;
    }
    paramView = (WeakReference)this.jkB.put(paramString, new WeakReference(paramView));
    if ((paramView != null) && (paramView.get() != null)) {
      ad.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[] { paramString });
    }
    AppMethodBeat.o(121161);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e
 * JD-Core Version:    0.7.0.1
 */