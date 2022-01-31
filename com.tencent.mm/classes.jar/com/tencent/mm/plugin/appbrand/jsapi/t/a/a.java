package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import android.annotation.TargetApi;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(5)
public abstract class a
  implements e
{
  Map<String, e.c> ifp = new ConcurrentHashMap();
  
  public final e.c CV(String paramString)
  {
    return (e.c)this.ifp.get(paramString);
  }
  
  public final void CW(String paramString)
  {
    this.ifp.remove(paramString);
  }
  
  protected void R(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.ifp.values().iterator();
    while (localIterator.hasNext()) {
      ((e.c)localIterator.next()).S(paramString, paramInt1, paramInt2);
    }
  }
  
  public final void a(String paramString, e.c paramc)
  {
    this.ifp.put(paramString, paramc);
  }
  
  protected void aGa()
  {
    Iterator localIterator = this.ifp.values().iterator();
    while (localIterator.hasNext()) {
      ((e.c)localIterator.next()).onStart();
    }
  }
  
  protected void aGb()
  {
    Iterator localIterator = this.ifp.values().iterator();
    while (localIterator.hasNext()) {
      ((e.c)localIterator.next()).onResume();
    }
  }
  
  protected void aGc()
  {
    Iterator localIterator = this.ifp.values().iterator();
    while (localIterator.hasNext()) {
      ((e.c)localIterator.next()).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.a
 * JD-Core Version:    0.7.0.1
 */