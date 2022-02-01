package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e jKN;
  public Map<String, WeakReference<View>> jKO;
  
  private e()
  {
    AppMethodBeat.i(121159);
    this.jKO = new ConcurrentHashMap();
    AppMethodBeat.o(121159);
  }
  
  public static e bcd()
  {
    AppMethodBeat.i(121160);
    if (jKN == null) {}
    try
    {
      if (jKN == null) {
        jKN = new e();
      }
      e locale = jKN;
      AppMethodBeat.o(121160);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(121160);
    }
  }
  
  public final View KW(String paramString)
  {
    AppMethodBeat.i(121162);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
      AppMethodBeat.o(121162);
      return null;
    }
    paramString = (WeakReference)this.jKO.get(paramString);
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
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
      AppMethodBeat.o(121161);
      return false;
    }
    if (paramView == null)
    {
      ac.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
      AppMethodBeat.o(121161);
      return false;
    }
    paramView = (WeakReference)this.jKO.put(paramString, new WeakReference(paramView));
    if ((paramView != null) && (paramView.get() != null)) {
      ac.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[] { paramString });
    }
    AppMethodBeat.o(121161);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e
 * JD-Core Version:    0.7.0.1
 */