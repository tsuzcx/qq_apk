package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g;

public abstract class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
  implements f
{
  public final <T extends g> T D(Class<T> paramClass)
  {
    if (getRuntime() != null) {
      return getRuntime().c(paramClass, true);
    }
    return super.D(paramClass);
  }
  
  public final b Zk()
  {
    if (getRuntime() == null) {
      return b.fFL;
    }
    return getRuntime().fyy.fFN.acz();
  }
  
  public final k Zl()
  {
    if (getRuntime() == null) {
      return null;
    }
    return getRuntime().Zl();
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.b.i Zm()
  {
    if (getRuntime() == null) {
      return null;
    }
    return getRuntime().fys;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d
 * JD-Core Version:    0.7.0.1
 */