package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.luggage.j.g;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.e.b;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.plugin.appbrand.v.r;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.statusbar.b;
import java.util.HashMap;
import java.util.Map;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import org.json.JSONObject;

public abstract class k
  extends SwipeBackLayout
{
  private View QR;
  private n fyp;
  private boolean gSK;
  final boolean[] gSL = { false };
  private final SwipeBackLayout.a gSM = new SwipeBackLayout.a()
  {
    public final boolean aK(boolean paramAnonymousBoolean)
    {
      return false;
    }
    
    public final void e(int paramAnonymousInt, float paramAnonymousFloat)
    {
      k localk;
      if (paramAnonymousInt != 0)
      {
        k.a(k.this, true);
        localk = k.a(k.this).d(k.this);
        if (Float.compare(1.0F, paramAnonymousFloat) > 0) {
          break label123;
        }
        if (k.this.gSL[0] == 0)
        {
          if (localk != null) {
            k.bV(k.b(localk));
          }
          localk = k.this;
          localk.mSwiping = true;
          localk.post(new k.2(localk));
          k.this.gSL[0] = true;
        }
      }
      for (;;)
      {
        y.i("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramAnonymousFloat) });
        return;
        k.a(k.this, false);
        break;
        label123:
        if (localk != null) {
          k.a(localk, paramAnonymousFloat);
        }
      }
    }
    
    public final void l(MotionEvent paramAnonymousMotionEvent) {}
    
    public final void qs() {}
  };
  public boolean mSwiping = false;
  
  public k(Context paramContext, n paramn)
  {
    super(paramContext);
    this.fyp = paramn;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setScrimColor(0);
    this.QR = agE();
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    ((ViewGroup)this.QR).addView(agF(), paramContext);
    addView(getContentView());
    setContentView(getContentView());
    com.tencent.mm.ui.statusbar.a.w(getContentView(), this.fyp.getAppConfig().fNB.adW());
    a(this.gSM);
  }
  
  private void a(String paramString, al paramal)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", g.bi(getCurrentUrl()));
    localHashMap.put("query", g.bj(getCurrentUrl()));
    localHashMap.put("rawPath", getCurrentUrl());
    if (paramal != null) {
      localHashMap.put("openType", paramal.toString());
    }
    c.c(localHashMap);
    getCurrentPageView().a(paramString, new JSONObject(localHashMap).toString(), null);
  }
  
  protected static boolean e(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return true;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label35;
      }
      if (paramArrayOfInt[i] == paramInt) {
        break;
      }
      i += 1;
    }
    label35:
    return false;
  }
  
  private View getContentView()
  {
    return this.QR;
  }
  
  private static void l(View paramView, float paramFloat)
  {
    paramView.clearAnimation();
    paramView.setTranslationX(paramFloat);
  }
  
  private void onSwipe(float paramFloat)
  {
    if (this.gSK)
    {
      if (paramFloat < 0.0F) {
        break label45;
      }
      setVisibility(0);
    }
    for (;;)
    {
      float f = getContentView().getWidth() / 4;
      l(getContentView(), f * (1.0F - paramFloat) * -1.0F);
      return;
      label45:
      if (this.gSK) {
        setVisibility(4);
      }
    }
  }
  
  public final void a(al paramal)
  {
    a("onAppRoute", paramal);
    y.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[] { paramal.toString(), getCurrentUrl() });
  }
  
  public View agE()
  {
    return new b(getContext());
  }
  
  public abstract View agF();
  
  public void agG()
  {
    y.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  public void agH()
  {
    y.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    setEnableGesture(this.fyp.agM());
    setEdgeTrackingEnabled(1);
    onSwipe(1.0F);
    this.gSK = false;
    setVisibility(0);
    agJ();
  }
  
  public void agI()
  {
    y.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
    this.gSK = true;
  }
  
  public void agJ()
  {
    Object localObject = getPageConfig();
    q localq = getCurrentPageView();
    String str1 = ((a.d)localObject).fNY;
    String str2 = ((a.d)localObject).fNV;
    if (!localq.gTK) {
      localq.gTL = r.bb(str1, localq.gTL);
    }
    if (!localq.gTM) {
      localq.gTN = str2;
    }
    localq.N(localq.gTL, localq.gTN);
    localObject = ((a.d)localObject).fOf;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (((String)localObject).equals("auto"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("landscape"))
          {
            i = 1;
            continue;
            if (((String)localObject).equals("portrait")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    e.r((Activity)getContext()).a(e.b.fOr, null);
    return;
    e.r((Activity)getContext()).a(e.b.fOt, null);
    return;
    e.r((Activity)getContext()).a(e.b.fOq, null);
  }
  
  public void agK()
  {
    boolean bool = true;
    a.d locald = getPageConfig();
    getCurrentPageView().tD(locald.fNU);
    getCurrentPageView().q(locald.fNW);
    getCurrentPageView().tC(locald.fNY);
    getCurrentPageView().tE(locald.fNV);
    getCurrentPageView().cT(locald.fOd);
    getCurrentPageView().bu(locald.fOe, locald.fNR);
    getCurrentPageView().gTC.dO(true);
    q localq = getCurrentPageView();
    if (!locald.fOb) {}
    for (;;)
    {
      localq.dw(bool);
      return;
      bool = false;
    }
  }
  
  public final void amV()
  {
    a("onAppRouteDone", null);
    y.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[] { getCurrentUrl() });
  }
  
  public abstract void b(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public void cleanup() {}
  
  public String getAppId()
  {
    return this.fyp.getAppId();
  }
  
  public n getContainer()
  {
    return this.fyp;
  }
  
  public abstract q getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public a.d getPageConfig()
  {
    return this.fyp.getAppConfig().sd(g.bi(getCurrentUrl()));
  }
  
  public abstract void loadUrl(String paramString);
  
  public abstract boolean tz(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.k
 * JD-Core Version:    0.7.0.1
 */