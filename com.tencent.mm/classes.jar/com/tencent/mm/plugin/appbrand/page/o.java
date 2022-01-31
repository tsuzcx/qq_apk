package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.luggage.g.d;
import com.tencent.luggage.g.f;
import com.tencent.luggage.g.h;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.page.b.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import me.imid.swipebacklayout.lib.a;
import org.json.JSONObject;

public abstract class o
  extends SwipeBackLayout
{
  private View Qz;
  private r gPB;
  private boolean ivV = true;
  private boolean ivW = false;
  private int ivX;
  private int ivY;
  final boolean[] ivZ = { false };
  private final SwipeBackLayout.a iwa = new o.1(this);
  public boolean mSwiping = false;
  
  public o(Context paramContext, r paramr)
  {
    super(paramContext);
    this.gPB = paramr;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setScrimColor(0);
    this.Qz = vs();
    addView(getContentView());
    setContentView(getContentView());
    a(this.iwa);
  }
  
  private void a(String paramString, bf parambf)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", h.cg(getCurrentUrl()));
    localHashMap.put("query", h.ch(getCurrentUrl()));
    localHashMap.put("rawPath", getCurrentUrl());
    if (parambf != null) {
      localHashMap.put("openType", parambf.toString());
    }
    if ("onAppRoute".equals(paramString))
    {
      parambf = (c)getCurrentPageView().x(c.class);
      if ((parambf == null) || (!parambf.vy())) {
        break label153;
      }
    }
    label153:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("resizing", Boolean.valueOf(bool));
      com.tencent.luggage.g.i.d(localHashMap);
      getCurrentPageView().b(paramString, new JSONObject(localHashMap).toString(), null);
      return;
    }
  }
  
  protected static boolean f(int[] paramArrayOfInt, int paramInt)
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
    return this.Qz;
  }
  
  private void hide()
  {
    if (this.ivV) {
      setVisibility(4);
    }
  }
  
  private static void m(View paramView, float paramFloat)
  {
    paramView.clearAnimation();
    paramView.setTranslationX(paramFloat);
  }
  
  private void onSwipe(float paramFloat)
  {
    if (this.ivV)
    {
      if (paramFloat < 0.0F) {
        break label45;
      }
      setVisibility(0);
    }
    for (;;)
    {
      float f = getContentView().getWidth() / 4;
      m(getContentView(), f * (1.0F - paramFloat) * -1.0F);
      return;
      label45:
      hide();
    }
  }
  
  public final void a(bf parambf)
  {
    a("onAppRoute", parambf);
    d.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[] { parambf.toString(), getCurrentUrl() });
  }
  
  protected void a(v paramv, AppBrandPageFullScreenView paramAppBrandPageFullScreenView)
  {
    if ((paramAppBrandPageFullScreenView != null) && (paramAppBrandPageFullScreenView.getParent() == null) && ((this.Qz instanceof ViewGroup))) {
      ((ViewGroup)this.Qz).addView(paramAppBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public abstract void a(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public final int aIT()
  {
    if (this.gPB == null) {
      return -1;
    }
    return this.gPB.iwj.indexOf(this);
  }
  
  final void aIU()
  {
    if (this.ivV)
    {
      this.ivV = false;
      this.ivW = false;
      vu();
    }
  }
  
  final void aIV()
  {
    if (!this.ivV)
    {
      this.ivV = true;
      vv();
    }
  }
  
  public final void aIW()
  {
    a("onAppRouteDone", null);
    d.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[] { getCurrentUrl() });
  }
  
  public abstract boolean bV(String paramString);
  
  protected void cleanup() {}
  
  public String getAppId()
  {
    return this.gPB.getAppId();
  }
  
  protected r getContainer()
  {
    return this.gPB;
  }
  
  public abstract v getCurrentPageView();
  
  public abstract String getCurrentUrl();
  
  public a.d getPageConfig()
  {
    return getCurrentPageView().getPageConfig();
  }
  
  protected final void hideVKB()
  {
    f.av(getContext());
  }
  
  protected final boolean isInBackground()
  {
    return this.ivV;
  }
  
  public abstract void loadUrl(String paramString);
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.ivV) {
      this.ivW = true;
    }
    v localv = getCurrentPageView();
    if (localv != null) {
      localv.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.ivV) && (!this.ivW) && (this.ivX > 0) && (this.ivY > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.ivX, 1073741824), View.MeasureSpec.makeMeasureSpec(this.ivY, 1073741824));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    this.ivX = getMeasuredWidth();
    this.ivY = getMeasuredHeight();
  }
  
  final void performDestroy()
  {
    vt();
  }
  
  protected abstract View vs();
  
  protected void vt()
  {
    d.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[] { getCurrentUrl() });
  }
  
  protected void vu()
  {
    d.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[] { getCurrentUrl() });
    r localr = this.gPB;
    if ((localr.iwj.size() > 1) || (localr.getRuntime().gPQ)) {}
    for (boolean bool = true;; bool = false)
    {
      setEnableGesture(bool);
      setEdgeTrackingEnabled(1);
      onSwipe(1.0F);
      this.ivZ[0] = false;
      this.mSwiping = false;
      this.AET = 0.0F;
      this.CKY.cancel();
      this.CKY.aL(0);
      if ((this.AEQ != 0) || (this.AER != 0))
      {
        this.AER = 0;
        this.AEQ = 0;
        requestLayout();
      }
      setVisibility(0);
      return;
    }
  }
  
  protected void vv()
  {
    d.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[] { getCurrentUrl() });
  }
  
  final void wm()
  {
    cleanup();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o
 * JD-Core Version:    0.7.0.1
 */