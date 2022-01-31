package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.mm.modelappbrand.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class a
  implements c
{
  private Map<Object, Set<View>> fUt = new HashMap();
  
  public final Map<Object, Set<View>> Jl()
  {
    return this.fUt;
  }
  
  public final Set<View> ay(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return (Set)this.fUt.get(paramObject);
  }
  
  public final Set<View> az(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return (Set)this.fUt.remove(paramObject);
  }
  
  public final boolean d(Object paramObject, View paramView)
  {
    if ((paramObject == null) || (paramView == null)) {
      return false;
    }
    Set localSet = (Set)this.fUt.get(paramObject);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.fUt.put(paramObject, localObject);
    }
    return ((Set)localObject).add(paramView);
  }
  
  public final boolean e(Object paramObject, View paramView)
  {
    if ((paramObject == null) || (paramView == null)) {
      return false;
    }
    paramObject = (Set)this.fUt.get(paramObject);
    if (paramObject != null) {
      return paramObject.remove(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */