package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.a.f;
import com.tencent.mm.plugin.appbrand.dynamic.a.g;
import com.tencent.mm.plugin.appbrand.dynamic.b;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;

public class IPCDynamicPageView
  extends LinearLayout
  implements n, com.tencent.mm.plugin.appbrand.canvas.widget.a, h
{
  public static ah fTz;
  private static LinearLayout.LayoutParams fXN = new LinearLayout.LayoutParams(-1, -1);
  public String dIX;
  private long fLf;
  private g fTE;
  private Bundle fXF;
  private com.tencent.mm.plugin.appbrand.dynamic.a fXG;
  public z fXH;
  public volatile boolean fXI;
  public long fXJ;
  private com.tencent.mm.plugin.appbrand.canvas.widget.a fXK;
  private Runnable fXL = new IPCDynamicPageView.1(this);
  private Runnable fXM = new IPCDynamicPageView.2(this);
  private volatile boolean mDetached;
  
  static
  {
    HandlerThread localHandlerThread = e.aap("WxaWidget#UIActionThread");
    localHandlerThread.start();
    fTz = new ah(localHandlerThread.getLooper());
  }
  
  public IPCDynamicPageView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public IPCDynamicPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public IPCDynamicPageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.fXG = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
    paramContext = c.bt(paramContext);
    addView(paramContext, fXN);
    this.fXK = ((com.tencent.mm.plugin.appbrand.canvas.widget.a)paramContext);
    this.fXK.setTraceId(this.dIX);
  }
  
  private void kL(int paramInt)
  {
    if (this.fXH == null)
    {
      y.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", new Object[] { this.dIX, Integer.valueOf(paramInt) });
      return;
    }
    com.tencent.mm.modelappbrand.f localf = this.fXH.JA();
    if (localf == null)
    {
      y.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", new Object[] { this.dIX, Integer.valueOf(paramInt) });
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localf.y(this, paramInt);
      return;
    }
    b.v(new IPCDynamicPageView.7(this, localf, paramInt));
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    this.fXK.a(paramDrawCanvasArg, parama);
  }
  
  public final void a(String paramString, t paramt)
  {
    if (this.fXH == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    ae localae = (ae)this.fXH.jC("openApp");
    if (localae == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    localae.jE(paramString);
  }
  
  public final void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    fTz.post(new IPCDynamicPageView.4(this, paramBundle, paramString1, paramString2));
  }
  
  public final void a(String paramString1, String paramString2, t paramt)
  {
    if (this.fXH == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    x localx = (x)this.fXH.jC("showPicker");
    if (localx == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    localx.a(paramString1, paramString2, paramt);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    this.fXK.a(paramJSONArray, parama);
  }
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, t paramt)
  {
    if (this.fXH == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    ad localad = (ad)this.fXH.jC("OnTapCallback");
    if (localad == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    localad.b(paramBoolean1, paramString, paramBoolean2);
  }
  
  public final boolean ad(String paramString1, String paramString2)
  {
    Object localObject = this.fXG;
    String str = this.dIX;
    if ((((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).dIX == null) || (((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).dIX.length() == 0) || (paramString1 == null) || (paramString1.length() == 0)) {
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("id", str);
    ((Bundle)localObject).putString("event", paramString1);
    ((Bundle)localObject).putString("data", paramString2);
    paramString1 = (IPCBoolean)com.tencent.mm.ipcinvoker.f.a(i.aeX().sX(str), (Parcelable)localObject, a.f.class);
    if (paramString1 != null) {
      return paramString1.value;
    }
    return false;
  }
  
  public final void adB()
  {
    long l = System.currentTimeMillis() - this.fLf;
    fTz.removeCallbacks(this.fXL);
    if (l < 12L)
    {
      fTz.postDelayed(this.fXL, l);
      return;
    }
    this.fXL.run();
  }
  
  public final void adC()
  {
    this.fXK.adC();
  }
  
  public final void adD()
  {
    this.fXK.adD();
  }
  
  public final void b(int paramInt, t paramt)
  {
    if (this.fXH == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    ag localag = (ag)this.fXH.jC("setWidgetSize");
    if (localag == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    localag.a(paramInt, paramt);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    this.fXK.b(paramDrawCanvasArg, parama);
  }
  
  public final void b(String paramString, t paramt)
  {
    if (this.fXH == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    ab localab = (ab)this.fXH.jC("makePhoneCall");
    if (localab == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    localab.jD(paramString);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    this.fXK.b(paramJSONArray, parama);
  }
  
  public final void c(String paramString, t paramt)
  {
    if (this.fXH == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    af localaf = (af)this.fXH.jC("onSearchWAWidgetReloadData");
    if (localaf == null)
    {
      paramt.b(false, "listener is null", null);
      return;
    }
    localaf.jF(paramString);
  }
  
  public final void cleanup()
  {
    if (this.fTE != null) {
      y.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", new Object[] { this.dIX, this.fTE.field_id, this.fTE.field_appId, this.fTE.field_cacheKey });
    }
    for (;;)
    {
      adC();
      return;
      y.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", new Object[] { this.dIX });
    }
  }
  
  public final void detach()
  {
    if (Looper.myLooper() == fTz.getLooper())
    {
      this.fXM.run();
      return;
    }
    fTz.post(this.fXM);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    return this.fXK.f(paramCanvas);
  }
  
  public d getDrawContext()
  {
    return this.fXK.getDrawContext();
  }
  
  public Bundle getExtData()
  {
    return this.fXF;
  }
  
  public String getExtId()
  {
    return this.dIX;
  }
  
  public String getSessionId()
  {
    return this.fXK.getSessionId();
  }
  
  public String getTraceId()
  {
    return this.fXK.getTraceId();
  }
  
  public final boolean isPaused()
  {
    return this.fXK.isPaused();
  }
  
  public final void kG(int paramInt)
  {
    kL(paramInt);
    detach();
  }
  
  public final void kM(int paramInt)
  {
    Object localObject = this.fXG;
    String str = this.dIX;
    if ((((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).dIX == null) || (((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).dIX.length() == 0)) {
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("id", str);
    ((Bundle)localObject).putInt("widgetState", paramInt);
    com.tencent.mm.ipcinvoker.f.a(i.aeX().sX(str), (Parcelable)localObject, f.a.class, null);
  }
  
  public final void onPause()
  {
    y.i("MicroMsg.IPCDynamicPageView", "onPause(%s)", new Object[] { this.dIX });
    this.fXK.onPause();
    fTz.post(new IPCDynamicPageView.5(this));
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.IPCDynamicPageView", "onResume(%s)", new Object[] { this.dIX });
    this.fXK.onResume();
    fTz.post(new IPCDynamicPageView.6(this));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    y.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("__page_view_width", paramInt1);
    localBundle1.putInt("__page_view_height", paramInt2);
    String str = this.dIX;
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("id", str);
    localBundle2.putBundle("__env_args", localBundle1);
    com.tencent.mm.ipcinvoker.f.a(i.aeX().sX(str), localBundle2, a.g.class, null);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.fXK.setDrawActionReportable(parama);
  }
  
  public void setSessionId(String paramString)
  {
    this.fXK.setSessionId(paramString);
  }
  
  public void setStartTime(long paramLong)
  {
    this.fXK.setStartTime(paramLong);
  }
  
  public void setTraceId(String paramString)
  {
    this.fXK.setTraceId(paramString);
  }
  
  public final void t(Runnable paramRunnable)
  {
    this.fXK.t(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView
 * JD-Core Version:    0.7.0.1
 */