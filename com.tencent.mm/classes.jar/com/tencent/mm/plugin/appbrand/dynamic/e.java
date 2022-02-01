package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e kip;
  public Map<String, WeakReference<View>> mViewMap;
  
  private e()
  {
    AppMethodBeat.i(121159);
    this.mViewMap = new ConcurrentHashMap();
    AppMethodBeat.o(121159);
  }
  
  public static e bgp()
  {
    AppMethodBeat.i(121160);
    if (kip == null) {}
    try
    {
      if (kip == null) {
        kip = new e();
      }
      e locale = kip;
      AppMethodBeat.o(121160);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121160);
    }
  }
  
  public final View OY(String paramString)
  {
    AppMethodBeat.i(121162);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
      AppMethodBeat.o(121162);
      return null;
    }
    paramString = (WeakReference)this.mViewMap.get(paramString);
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
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
      AppMethodBeat.o(121161);
      return false;
    }
    if (paramView == null)
    {
      ae.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
      AppMethodBeat.o(121161);
      return false;
    }
    paramView = (WeakReference)this.mViewMap.put(paramString, new WeakReference(paramView));
    if ((paramView != null) && (paramView.get() != null)) {
      ae.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[] { paramString });
    }
    AppMethodBeat.o(121161);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e
 * JD-Core Version:    0.7.0.1
 */