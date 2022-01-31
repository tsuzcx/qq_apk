package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.plugin.appbrand.v.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.d;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  private static long gBf = 200L;
  private static long gBg = 20L;
  private g gAD;
  private final List<l> gBh = new LinkedList();
  private Runnable gBi;
  
  private h()
  {
    if (ajX()) {}
    for (int i = 20;; i = 200)
    {
      gBf = i;
      this.gBi = new h.1(this);
      this.gAD = new g(gBf, new h.2(this));
      return;
    }
  }
  
  public static h ajW()
  {
    return h.a.gBk;
  }
  
  private static boolean ajX()
  {
    if (MMWebView.getUsingTbsCoreVersion(ae.getContext()) >= 36867) {}
    while (MMWebView.getCurWebType() == WebView.d.xho) {
      return true;
    }
    return false;
  }
  
  public static int ajY()
  {
    if (ajX()) {
      return 5;
    }
    return 20;
  }
  
  public static int lA(int paramInt)
  {
    switch (paramInt)
    {
    case 200: 
    default: 
      return 3;
    case 0: 
      return 0;
    case 20: 
      return 1;
    }
    return 2;
  }
  
  public final boolean a(l paraml, f arg2)
  {
    if (paraml == null) {
      return false;
    }
    if (!(???.getRuntime() instanceof n)) {
      y.e("MicroMsg.SensorJsEventPublisher", "hasPermission not AppBrandRuntimeWC");
    }
    for (boolean bool = false; !bool; bool = ((n)???.getRuntime()).fzB.a(???, paraml)) {
      return false;
    }
    for (;;)
    {
      synchronized (this.gBh)
      {
        bool = this.gBh.isEmpty();
        if (!this.gBh.isEmpty())
        {
          if (((l)this.gBh.get(0)).equals(paraml))
          {
            this.gBh.add(0, paraml);
            this.gBh.remove(1);
            if ((bool) && (!this.gAD.k(new Object[0])))
            {
              y.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { paraml.getName() });
              c.DS().k(this.gBi, gBf);
            }
            return true;
          }
          this.gBh.remove(paraml);
          this.gBh.add(paraml);
        }
      }
      this.gBh.add(paraml);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.h
 * JD-Core Version:    0.7.0.1
 */