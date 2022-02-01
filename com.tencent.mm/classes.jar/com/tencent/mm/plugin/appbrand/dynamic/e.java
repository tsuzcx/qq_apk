package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e rkn;
  public Map<String, WeakReference<View>> mViewMap;
  
  private e()
  {
    AppMethodBeat.i(121159);
    this.mViewMap = new ConcurrentHashMap();
    AppMethodBeat.o(121159);
  }
  
  public static e cnt()
  {
    AppMethodBeat.i(121160);
    if (rkn == null) {}
    try
    {
      if (rkn == null) {
        rkn = new e();
      }
      e locale = rkn;
      AppMethodBeat.o(121160);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121160);
    }
  }
  
  public final View YT(String paramString)
  {
    AppMethodBeat.i(121162);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
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
  
  public final boolean d(String paramString, View paramView)
  {
    AppMethodBeat.i(121161);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
      AppMethodBeat.o(121161);
      return false;
    }
    if (paramView == null)
    {
      Log.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
      AppMethodBeat.o(121161);
      return false;
    }
    paramView = (WeakReference)this.mViewMap.put(paramString, new WeakReference(paramView));
    if ((paramView != null) && (paramView.get() != null)) {
      Log.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[] { paramString });
    }
    AppMethodBeat.o(121161);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e
 * JD-Core Version:    0.7.0.1
 */