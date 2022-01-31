package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.b.a;

public class j
  implements w
{
  public LinkedList<i> fyW;
  HashMap<String, i> fyX;
  private h fyY;
  private Class<? extends i> fyZ;
  Activity fyk;
  FrameLayout fyq;
  
  public j(h paramh, Class<? extends i> paramClass)
  {
    this.fyk = paramh.getContext();
    this.fyW = new LinkedList();
    this.fyX = new HashMap();
    this.fyq = paramh.aoN();
    this.fyY = paramh;
    this.fyZ = paramClass;
  }
  
  protected final i ZU()
  {
    return (i)a.al(this.fyZ).F(new Object[] { this.fyk, this }).object;
  }
  
  public final i ZV()
  {
    return (i)this.fyW.peek();
  }
  
  public final int ZW()
  {
    return this.fyW.size();
  }
  
  protected final void ZX()
  {
    Iterator localIterator = this.fyW.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      locali.fyq.setVisibility(8);
      this.fyX.put(locali.mAppId, locali);
      locali.fyy.fFN.ku(12);
    }
    this.fyW.clear();
  }
  
  protected final Iterator<i> ZY()
  {
    return new LinkedList(this.fyX.values()).iterator();
  }
  
  public final h ZZ()
  {
    return this.fyY;
  }
  
  public final void a(MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult)
  {
    b(paramMiniProgramNavigationBackResult);
    this.fyk.finish();
  }
  
  public final void a(i parami, AppBrandInitConfig paramAppBrandInitConfig)
  {
    if (paramAppBrandInitConfig == null) {
      return;
    }
    this.fyk.runOnUiThread(new j.1(this, parami, paramAppBrandInitConfig));
  }
  
  protected void a(i parami1, i parami2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    parami2.fym = parami1;
    parami2.a(paramAppBrandInitConfig);
    this.fyW.push(parami2);
    this.fyq.addView(parami2.fyq);
    if (parami1 != null) {
      parami1.ZM();
    }
  }
  
  protected void b(MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult) {}
  
  protected void b(i parami1, i parami2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    int i = this.fyW.indexOf(parami2) - 1;
    if (i >= 0)
    {
      Object localObject = new LinkedList();
      while ((i >= 0) && (((i)this.fyW.get(i)).ZG()))
      {
        ((LinkedList)localObject).add(this.fyW.get(i));
        i -= 1;
      }
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i locali = (i)((Iterator)localObject).next();
        if (locali != parami1) {
          f(locali);
        }
      }
    }
    if (!this.fyW.contains(parami2))
    {
      this.fyW.push(parami2);
      if (this.fyq.indexOfChild(parami2.fyq) == -1) {
        this.fyq.addView(parami2.fyq);
      }
      this.fyX.remove(parami2.mAppId);
    }
    this.fyW.remove(parami2);
    this.fyW.push(parami2);
    parami2.fyq.setVisibility(0);
    this.fyq.bringChildToFront(parami2.fyq);
    parami2.fym = parami1;
    parami2.b(paramAppBrandInitConfig);
    if (parami1 != null)
    {
      parami1.ZM();
      parami2.ZN();
    }
  }
  
  protected void c(i parami1, i parami2, Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public final void cleanup()
  {
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(this.fyW);
    ((LinkedList)localObject).addAll(this.fyX.values());
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      locali.fyE = false;
      f(locali);
    }
    y.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
  }
  
  public final void close()
  {
    onClose();
    if (this.fyY.aoO())
    {
      this.fyk.moveTaskToBack(true);
      return;
    }
    this.fyk.finish();
  }
  
  public final i d(i parami)
  {
    int i = this.fyW.indexOf(parami);
    int j = this.fyW.size();
    if ((i == -1) || (i >= j - 1)) {
      return null;
    }
    return (i)this.fyW.get(i + 1);
  }
  
  public final boolean e(i parami)
  {
    return this.fyW.contains(parami);
  }
  
  public final void f(i parami)
  {
    if (parami == null) {
      return;
    }
    n.runOnUiThread(new j.2(this, parami));
  }
  
  protected void onClose() {}
  
  public final void onResume()
  {
    i locali = ZV();
    if (locali != null) {
      locali.ZN();
    }
  }
  
  protected final i qD(String paramString)
  {
    Iterator localIterator = this.fyW.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.mAppId.equals(paramString)) {
        return locali;
      }
    }
    return (i)this.fyX.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j
 * JD-Core Version:    0.7.0.1
 */