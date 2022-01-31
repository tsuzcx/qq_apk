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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.a.f;
import com.tencent.mm.plugin.appbrand.dynamic.a.g;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONArray;

public class IPCDynamicPageView
  extends LinearLayout
  implements n, com.tencent.mm.plugin.appbrand.canvas.widget.a, h
{
  public static ak hna;
  private static LinearLayout.LayoutParams hrn;
  public String equ;
  private long her;
  private com.tencent.mm.plugin.appbrand.widget.f hnf;
  private Bundle hrf;
  private com.tencent.mm.plugin.appbrand.dynamic.a hrg;
  public com.tencent.mm.modelappbrand.ab hrh;
  public volatile boolean hri;
  public long hrj;
  private com.tencent.mm.plugin.appbrand.canvas.widget.a hrk;
  private Runnable hrl;
  private Runnable hrm;
  private volatile boolean mDetached;
  
  static
  {
    AppMethodBeat.i(11084);
    HandlerThread localHandlerThread = com.tencent.mm.sdk.g.d.aqu("WxaWidget#UIActionThread");
    localHandlerThread.start();
    hna = new ak(localHandlerThread.getLooper());
    hrn = new LinearLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(11084);
  }
  
  public IPCDynamicPageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(11044);
    this.hrl = new IPCDynamicPageView.1(this);
    this.hrm = new IPCDynamicPageView.2(this);
    init(paramContext);
    AppMethodBeat.o(11044);
  }
  
  public IPCDynamicPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(11045);
    this.hrl = new IPCDynamicPageView.1(this);
    this.hrm = new IPCDynamicPageView.2(this);
    init(paramContext);
    AppMethodBeat.o(11045);
  }
  
  public IPCDynamicPageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(11046);
    this.hrl = new IPCDynamicPageView.1(this);
    this.hrm = new IPCDynamicPageView.2(this);
    init(paramContext);
    AppMethodBeat.o(11046);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(11047);
    this.hrg = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
    paramContext = b.bX(paramContext);
    addView(paramContext, hrn);
    this.hrk = ((com.tencent.mm.plugin.appbrand.canvas.widget.a)paramContext);
    this.hrk.setTraceId(this.equ);
    AppMethodBeat.o(11047);
  }
  
  private void nJ(int paramInt)
  {
    AppMethodBeat.i(11079);
    if (this.hrh == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", new Object[] { this.equ, Integer.valueOf(paramInt) });
      AppMethodBeat.o(11079);
      return;
    }
    com.tencent.mm.modelappbrand.f localf = this.hrh.acz();
    if (localf == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", new Object[] { this.equ, Integer.valueOf(paramInt) });
      AppMethodBeat.o(11079);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localf.I(this, paramInt);
      AppMethodBeat.o(11079);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.b.D(new IPCDynamicPageView.7(this, localf, paramInt));
    AppMethodBeat.o(11079);
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(11066);
    this.hrk.B(paramRunnable);
    AppMethodBeat.o(11066);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(11063);
    this.hrk.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(11063);
  }
  
  public final void a(String paramString, t paramt)
  {
    AppMethodBeat.i(11055);
    if (this.hrh == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11055);
      return;
    }
    ah localah = (ah)this.hrh.qs("openApp");
    if (localah == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11055);
      return;
    }
    localah.qu(paramString);
    AppMethodBeat.o(11055);
  }
  
  public final void a(String paramString1, String paramString2, t paramt)
  {
    AppMethodBeat.i(11057);
    if (this.hrh == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11057);
      return;
    }
    y localy = (y)this.hrh.qs("showPicker");
    if (localy == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11057);
      return;
    }
    localy.a(paramString1, paramString2, paramt);
    AppMethodBeat.o(11057);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(11061);
    this.hrk.a(paramJSONArray, parama);
    AppMethodBeat.o(11061);
  }
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, t paramt)
  {
    AppMethodBeat.i(11056);
    if (this.hrh == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11056);
      return;
    }
    af localaf = (af)this.hrh.qs("OnTapCallback");
    if (localaf == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11056);
      return;
    }
    localaf.b(paramBoolean1, paramString, paramBoolean2);
    AppMethodBeat.o(11056);
  }
  
  public final boolean at(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11080);
    Object localObject = this.hrg;
    String str = this.equ;
    if ((((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).equ == null) || (((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).equ.length() == 0) || (paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(11080);
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("id", str);
    ((Bundle)localObject).putString("event", paramString1);
    ((Bundle)localObject).putString("data", paramString2);
    paramString1 = (IPCBoolean)com.tencent.mm.ipcinvoker.f.a(i.azB().AY(str), (Parcelable)localObject, a.f.class);
    if (paramString1 != null)
    {
      boolean bool = paramString1.value;
      AppMethodBeat.o(11080);
      return bool;
    }
    AppMethodBeat.o(11080);
    return false;
  }
  
  public final void axT()
  {
    AppMethodBeat.i(11060);
    long l = System.currentTimeMillis() - this.her;
    hna.removeCallbacks(this.hrl);
    if (l < 12L)
    {
      hna.postDelayed(this.hrl, l);
      AppMethodBeat.o(11060);
      return;
    }
    this.hrl.run();
    AppMethodBeat.o(11060);
  }
  
  public final void axU()
  {
    AppMethodBeat.i(11065);
    this.hrk.axU();
    AppMethodBeat.o(11065);
  }
  
  public final void axV()
  {
    AppMethodBeat.i(11077);
    this.hrk.axV();
    AppMethodBeat.o(11077);
  }
  
  public final void azA()
  {
    AppMethodBeat.i(11052);
    if (this.hrh == null)
    {
      AppMethodBeat.o(11052);
      return;
    }
    ag localag = (ag)this.hrh.qs("onUiUpdate");
    if (localag == null)
    {
      AppMethodBeat.o(11052);
      return;
    }
    localag.acB();
    AppMethodBeat.o(11052);
  }
  
  public final void b(int paramInt, t paramt)
  {
    AppMethodBeat.i(11058);
    if (this.hrh == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11058);
      return;
    }
    aj localaj = (aj)this.hrh.qs("setWidgetSize");
    if (localaj == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11058);
      return;
    }
    localaj.a(paramInt, paramt);
    AppMethodBeat.o(11058);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(11064);
    this.hrk.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(11064);
  }
  
  public final void b(String paramString, t paramt)
  {
    AppMethodBeat.i(11053);
    if (this.hrh == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11053);
      return;
    }
    ad localad = (ad)this.hrh.qs("makePhoneCall");
    if (localad == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11053);
      return;
    }
    localad.qt(paramString);
    AppMethodBeat.o(11053);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(11062);
    this.hrk.b(paramJSONArray, parama);
    AppMethodBeat.o(11062);
  }
  
  public final void c(String paramString, t paramt)
  {
    AppMethodBeat.i(11054);
    if (this.hrh == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11054);
      return;
    }
    ai localai = (ai)this.hrh.qs("onSearchWAWidgetReloadData");
    if (localai == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(11054);
      return;
    }
    localai.qv(paramString);
    AppMethodBeat.o(11054);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(11050);
    if (this.hnf != null) {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", new Object[] { this.equ, this.hnf.field_id, this.hnf.field_appId, this.hnf.field_cacheKey });
    }
    for (;;)
    {
      axU();
      AppMethodBeat.o(11050);
      return;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", new Object[] { this.equ });
    }
  }
  
  public final void d(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(11048);
    hna.post(new IPCDynamicPageView.4(this, paramBundle, paramString1, paramString2));
    AppMethodBeat.o(11048);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(11049);
    if (Looper.myLooper() == hna.getLooper())
    {
      this.hrm.run();
      AppMethodBeat.o(11049);
      return;
    }
    hna.post(this.hrm);
    AppMethodBeat.o(11049);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    AppMethodBeat.i(11059);
    boolean bool = this.hrk.f(paramCanvas);
    AppMethodBeat.o(11059);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext()
  {
    AppMethodBeat.i(11067);
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.hrk.getDrawContext();
    AppMethodBeat.o(11067);
    return locald;
  }
  
  public Bundle getExtData()
  {
    return this.hrf;
  }
  
  public String getExtId()
  {
    return this.equ;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(11074);
    String str = this.hrk.getSessionId();
    AppMethodBeat.o(11074);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(11070);
    String str = this.hrk.getTraceId();
    AppMethodBeat.o(11070);
    return str;
  }
  
  public final boolean isPaused()
  {
    AppMethodBeat.i(11073);
    boolean bool = this.hrk.isPaused();
    AppMethodBeat.o(11073);
    return bool;
  }
  
  public final void nE(int paramInt)
  {
    AppMethodBeat.i(11051);
    nJ(paramInt);
    detach();
    AppMethodBeat.o(11051);
  }
  
  public final void nK(int paramInt)
  {
    AppMethodBeat.i(11081);
    this.hrg.aY(this.equ, paramInt);
    AppMethodBeat.o(11081);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(11071);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "onPause(%s)", new Object[] { this.equ });
    hna.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(11041);
        IPCDynamicPageView.f(IPCDynamicPageView.this);
        String str = IPCDynamicPageView.e(IPCDynamicPageView.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("id", str);
        com.tencent.mm.ipcinvoker.f.a(i.azB().AY(str), localBundle, a.d.class, null);
        AppMethodBeat.o(11041);
      }
    });
    AppMethodBeat.o(11071);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(11072);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "onResume(%s)", new Object[] { this.equ });
    this.hrk.onResume();
    hna.post(new IPCDynamicPageView.6(this));
    AppMethodBeat.o(11072);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(11078);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("__page_view_width", paramInt1);
    localBundle1.putInt("__page_view_height", paramInt2);
    String str = this.equ;
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("id", str);
    localBundle2.putBundle("__env_args", localBundle1);
    com.tencent.mm.ipcinvoker.f.a(i.azB().AY(str), localBundle2, a.g.class, null);
    AppMethodBeat.o(11078);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(11068);
    this.hrk.setDrawActionReportable(parama);
    AppMethodBeat.o(11068);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(11075);
    this.hrk.setSessionId(paramString);
    AppMethodBeat.o(11075);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(11076);
    this.hrk.setStartTime(paramLong);
    AppMethodBeat.o(11076);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(11069);
    this.hrk.setTraceId(paramString);
    AppMethodBeat.o(11069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView
 * JD-Core Version:    0.7.0.1
 */