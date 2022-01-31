package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e hns;
  public Map<String, WeakReference<View>> hnt;
  
  private e()
  {
    AppMethodBeat.i(10678);
    this.hnt = new ConcurrentHashMap();
    AppMethodBeat.o(10678);
  }
  
  public static e azy()
  {
    AppMethodBeat.i(10679);
    if (hns == null) {}
    try
    {
      if (hns == null) {
        hns = new e();
      }
      e locale = hns;
      AppMethodBeat.o(10679);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(10679);
    }
  }
  
  public final View AV(String paramString)
  {
    AppMethodBeat.i(10681);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
      AppMethodBeat.o(10681);
      return null;
    }
    paramString = (WeakReference)this.hnt.get(paramString);
    if (paramString != null)
    {
      paramString = (View)paramString.get();
      AppMethodBeat.o(10681);
      return paramString;
    }
    AppMethodBeat.o(10681);
    return null;
  }
  
  public final boolean b(String paramString, View paramView)
  {
    AppMethodBeat.i(10680);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
      AppMethodBeat.o(10680);
      return false;
    }
    if (paramView == null)
    {
      ab.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
      AppMethodBeat.o(10680);
      return false;
    }
    paramView = (WeakReference)this.hnt.put(paramString, new WeakReference(paramView));
    if ((paramView != null) && (paramView.get() != null)) {
      ab.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[] { paramString });
    }
    AppMethodBeat.o(10680);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e
 * JD-Core Version:    0.7.0.1
 */