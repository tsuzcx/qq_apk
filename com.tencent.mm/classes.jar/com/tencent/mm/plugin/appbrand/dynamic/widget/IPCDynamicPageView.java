package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.dynamic.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.a.f;
import com.tencent.mm.plugin.appbrand.dynamic.a.g;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;

public class IPCDynamicPageView
  extends LinearLayout
  implements p, com.tencent.mm.plugin.appbrand.canvas.widget.a, com.tencent.mm.plugin.appbrand.dynamic.h
{
  public static aq khX;
  private static LinearLayout.LayoutParams kmj;
  public String gcZ;
  private long jWf;
  private f kic;
  private Bundle kmb;
  private com.tencent.mm.plugin.appbrand.dynamic.a kmc;
  public ab kmd;
  public volatile boolean kme;
  public long kmf;
  private com.tencent.mm.plugin.appbrand.canvas.widget.a kmg;
  private Runnable kmh;
  private Runnable kmi;
  private volatile boolean mDetached;
  
  static
  {
    AppMethodBeat.i(121566);
    khX = new aq("WxaWidget#UIActionThread");
    kmj = new LinearLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(121566);
  }
  
  public IPCDynamicPageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(121526);
    this.kmh = new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(121519);
        long l;
        if (!IPCDynamicPageView.a(IPCDynamicPageView.this))
        {
          IPCDynamicPageView.a(IPCDynamicPageView.this, true);
          IPCDynamicPageView.b(IPCDynamicPageView.this);
          l = System.currentTimeMillis() - IPCDynamicPageView.c(IPCDynamicPageView.this);
          if (l > 1000L) {
            break label121;
          }
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.sw(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).bdP();
          AppMethodBeat.o(121519);
          return;
          label121:
          if (l > 2000L) {
            if (l <= 3000L) {
              i = 2;
            } else if (l <= 4000L) {
              i = 3;
            } else if (l <= 5000L) {
              i = 4;
            } else if (l <= 6000L) {
              i = 5;
            } else if (l <= 7000L) {
              i = 6;
            } else if (l <= 8000L) {
              i = 7;
            } else if (l <= 9000L) {
              i = 8;
            } else if (l <= 10000L) {
              i = 9;
            } else {
              i = 10;
            }
          }
        }
      }
    };
    this.kmi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          ae.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.bgp();
          if (!bu.isNullOrNil((String)localObject1)) {
            break label286;
          }
          ae.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).bdR();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          ae.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.h.a(i.bgs().Pc((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = j.bgu();
          if (!((j)localObject2).kir.containsKey(localObject1))
          {
            com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((j)localObject2).kir.remove(localObject1);
          break;
          label286:
          localObject1 = (WeakReference)((e)localObject2).mViewMap.remove(localObject1);
          if (localObject1 != null) {
            ((WeakReference)localObject1).get();
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(121526);
  }
  
  public IPCDynamicPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121527);
    this.kmh = new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(121519);
        long l;
        if (!IPCDynamicPageView.a(IPCDynamicPageView.this))
        {
          IPCDynamicPageView.a(IPCDynamicPageView.this, true);
          IPCDynamicPageView.b(IPCDynamicPageView.this);
          l = System.currentTimeMillis() - IPCDynamicPageView.c(IPCDynamicPageView.this);
          if (l > 1000L) {
            break label121;
          }
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.sw(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).bdP();
          AppMethodBeat.o(121519);
          return;
          label121:
          if (l > 2000L) {
            if (l <= 3000L) {
              i = 2;
            } else if (l <= 4000L) {
              i = 3;
            } else if (l <= 5000L) {
              i = 4;
            } else if (l <= 6000L) {
              i = 5;
            } else if (l <= 7000L) {
              i = 6;
            } else if (l <= 8000L) {
              i = 7;
            } else if (l <= 9000L) {
              i = 8;
            } else if (l <= 10000L) {
              i = 9;
            } else {
              i = 10;
            }
          }
        }
      }
    };
    this.kmi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          ae.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.bgp();
          if (!bu.isNullOrNil((String)localObject1)) {
            break label286;
          }
          ae.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).bdR();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          ae.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.h.a(i.bgs().Pc((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = j.bgu();
          if (!((j)localObject2).kir.containsKey(localObject1))
          {
            com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((j)localObject2).kir.remove(localObject1);
          break;
          label286:
          localObject1 = (WeakReference)((e)localObject2).mViewMap.remove(localObject1);
          if (localObject1 != null) {
            ((WeakReference)localObject1).get();
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(121527);
  }
  
  public IPCDynamicPageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121528);
    this.kmh = new Runnable()
    {
      public final void run()
      {
        int i = 1;
        AppMethodBeat.i(121519);
        long l;
        if (!IPCDynamicPageView.a(IPCDynamicPageView.this))
        {
          IPCDynamicPageView.a(IPCDynamicPageView.this, true);
          IPCDynamicPageView.b(IPCDynamicPageView.this);
          l = System.currentTimeMillis() - IPCDynamicPageView.c(IPCDynamicPageView.this);
          if (l > 1000L) {
            break label121;
          }
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.sw(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).bdP();
          AppMethodBeat.o(121519);
          return;
          label121:
          if (l > 2000L) {
            if (l <= 3000L) {
              i = 2;
            } else if (l <= 4000L) {
              i = 3;
            } else if (l <= 5000L) {
              i = 4;
            } else if (l <= 6000L) {
              i = 5;
            } else if (l <= 7000L) {
              i = 6;
            } else if (l <= 8000L) {
              i = 7;
            } else if (l <= 9000L) {
              i = 8;
            } else if (l <= 10000L) {
              i = 9;
            } else {
              i = 10;
            }
          }
        }
      }
    };
    this.kmi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          ae.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.bgp();
          if (!bu.isNullOrNil((String)localObject1)) {
            break label286;
          }
          ae.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).bdR();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          ae.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.h.a(i.bgs().Pc((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = j.bgu();
          if (!((j)localObject2).kir.containsKey(localObject1))
          {
            com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((j)localObject2).kir.remove(localObject1);
          break;
          label286:
          localObject1 = (WeakReference)((e)localObject2).mViewMap.remove(localObject1);
          if (localObject1 != null) {
            ((WeakReference)localObject1).get();
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(121528);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(121529);
    this.kmc = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
    paramContext = b.cy(paramContext);
    addView(paramContext, kmj);
    this.kmg = ((com.tencent.mm.plugin.appbrand.canvas.widget.a)paramContext);
    this.kmg.setTraceId(this.gcZ);
    AppMethodBeat.o(121529);
  }
  
  private void sv(final int paramInt)
  {
    AppMethodBeat.i(121561);
    if (this.kmd == null)
    {
      ae.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", new Object[] { this.gcZ, Integer.valueOf(paramInt) });
      AppMethodBeat.o(121561);
      return;
    }
    final com.tencent.mm.modelappbrand.h localh = this.kmd.aEh();
    if (localh == null)
    {
      ae.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", new Object[] { this.gcZ, Integer.valueOf(paramInt) });
      AppMethodBeat.o(121561);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localh.N(this, paramInt);
      AppMethodBeat.o(121561);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.b.Q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121525);
        localh.N(IPCDynamicPageView.this, paramInt);
        AppMethodBeat.o(121525);
      }
    });
    AppMethodBeat.o(121561);
  }
  
  public final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(121548);
    this.kmg.P(paramRunnable);
    AppMethodBeat.o(121548);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121545);
    this.kmg.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(121545);
  }
  
  public final void a(String paramString, t paramt)
  {
    AppMethodBeat.i(121537);
    if (this.kmd == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121537);
      return;
    }
    ah localah = (ah)this.kmd.CP("openApp");
    if (localah == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121537);
      return;
    }
    localah.CR(paramString);
    AppMethodBeat.o(121537);
  }
  
  public final void a(String paramString1, String paramString2, t paramt)
  {
    AppMethodBeat.i(121539);
    if (this.kmd == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121539);
      return;
    }
    y localy = (y)this.kmd.CP("showPicker");
    if (localy == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121539);
      return;
    }
    localy.a(paramString1, paramString2, paramt);
    AppMethodBeat.o(121539);
  }
  
  public final void a(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121543);
    this.kmg.a(paramJSONArray, parama);
    AppMethodBeat.o(121543);
  }
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, t paramt)
  {
    AppMethodBeat.i(121538);
    if (this.kmd == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121538);
      return;
    }
    af localaf = (af)this.kmd.CP("OnTapCallback");
    if (localaf == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121538);
      return;
    }
    localaf.b(paramBoolean1, paramString, paramBoolean2);
    AppMethodBeat.o(121538);
  }
  
  public final boolean aS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121562);
    Object localObject = this.kmc;
    String str = this.gcZ;
    if ((((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).gcZ == null) || (((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).gcZ.length() == 0) || (paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(121562);
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("id", str);
    ((Bundle)localObject).putString("event", paramString1);
    ((Bundle)localObject).putString("data", paramString2);
    paramString1 = (IPCBoolean)com.tencent.mm.ipcinvoker.h.a(i.bgs().Pc(str), (Parcelable)localObject, a.f.class);
    if (paramString1 != null)
    {
      boolean bool = paramString1.value;
      AppMethodBeat.o(121562);
      return bool;
    }
    AppMethodBeat.o(121562);
    return false;
  }
  
  public final void b(int paramInt, t paramt)
  {
    AppMethodBeat.i(121540);
    if (this.kmd == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121540);
      return;
    }
    aj localaj = (aj)this.kmd.CP("setWidgetSize");
    if (localaj == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121540);
      return;
    }
    localaj.a(paramInt, paramt);
    AppMethodBeat.o(121540);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121546);
    this.kmg.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(121546);
  }
  
  public final void b(String paramString, t paramt)
  {
    AppMethodBeat.i(121535);
    if (this.kmd == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121535);
      return;
    }
    ad localad = (ad)this.kmd.CP("makePhoneCall");
    if (localad == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121535);
      return;
    }
    localad.CQ(paramString);
    AppMethodBeat.o(121535);
  }
  
  public final void b(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121544);
    this.kmg.b(paramJSONArray, parama);
    AppMethodBeat.o(121544);
  }
  
  public final void bdP()
  {
    AppMethodBeat.i(121542);
    long l = System.currentTimeMillis() - this.jWf;
    khX.removeCallbacks(this.kmh);
    if (l < 12L)
    {
      khX.postDelayed(this.kmh, l);
      AppMethodBeat.o(121542);
      return;
    }
    this.kmh.run();
    AppMethodBeat.o(121542);
  }
  
  public final void bdQ()
  {
    AppMethodBeat.i(121547);
    this.kmg.bdQ();
    AppMethodBeat.o(121547);
  }
  
  public final void bdR()
  {
    AppMethodBeat.i(121559);
    this.kmg.bdR();
    AppMethodBeat.o(121559);
  }
  
  public final void bgr()
  {
    AppMethodBeat.i(121534);
    if (this.kmd == null)
    {
      AppMethodBeat.o(121534);
      return;
    }
    ag localag = (ag)this.kmd.CP("onUiUpdate");
    if (localag == null)
    {
      AppMethodBeat.o(121534);
      return;
    }
    localag.aEj();
    AppMethodBeat.o(121534);
  }
  
  public final void c(String paramString, t paramt)
  {
    AppMethodBeat.i(121536);
    if (this.kmd == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121536);
      return;
    }
    ai localai = (ai)this.kmd.CP("onSearchWAWidgetReloadData");
    if (localai == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121536);
      return;
    }
    localai.CS(paramString);
    AppMethodBeat.o(121536);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(121532);
    if (this.kic != null) {
      ae.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", new Object[] { this.gcZ, this.kic.field_id, this.kic.field_appId, this.kic.field_cacheKey });
    }
    for (;;)
    {
      bdQ();
      AppMethodBeat.o(121532);
      return;
      ae.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", new Object[] { this.gcZ });
    }
  }
  
  public final void d(final String paramString1, final String paramString2, final Bundle paramBundle)
  {
    AppMethodBeat.i(121530);
    khX.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121522);
        String str1 = "";
        if (paramBundle != null) {
          str1 = paramBundle.getString("cache_key", "");
        }
        u.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s)", new Object[] { paramString1, paramString2 });
        IPCDynamicPageView.a(IPCDynamicPageView.this, com.tencent.mm.plugin.appbrand.dynamic.j.b.Pt(paramString1));
        if (IPCDynamicPageView.g(IPCDynamicPageView.this) == null) {
          IPCDynamicPageView.a(IPCDynamicPageView.this, new f());
        }
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_id = paramString1;
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_cacheKey = str1;
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_appId = u.CK(IPCDynamicPageView.e(IPCDynamicPageView.this));
        IPCDynamicPageView.this.getDrawContext().gCz.k("id", paramString1);
        e.bgp().c(paramString1, IPCDynamicPageView.this);
        if (paramBundle != null) {
          paramBundle.putBundle("__env_args", IPCDynamicPageView.b(IPCDynamicPageView.this, paramBundle));
        }
        IPCDynamicPageView.f(IPCDynamicPageView.this);
        str1 = paramString1;
        String str2 = paramString2;
        Bundle localBundle1 = paramBundle;
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("id", str1);
        localBundle2.putString("appId", str2);
        localBundle2.putBundle("extData", localBundle1);
        u.i("MicroMsg.DynamicIPCJsBridge", "before IPCInvoke_AttachTo invoke", new Object[0]);
        com.tencent.mm.ipcinvoker.h.a(i.bgs().Pc(str1), localBundle2, com.tencent.mm.plugin.appbrand.dynamic.a.a.class, null);
        AppMethodBeat.o(121522);
      }
    });
    AppMethodBeat.o(121530);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(121531);
    if (com.tencent.e.j.a.gat() == khX.getSerial())
    {
      this.kmi.run();
      AppMethodBeat.o(121531);
      return;
    }
    khX.post(this.kmi);
    AppMethodBeat.o(121531);
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(121549);
    d locald = this.kmg.getDrawContext();
    AppMethodBeat.o(121549);
    return locald;
  }
  
  public Bundle getExtData()
  {
    return this.kmb;
  }
  
  public String getExtId()
  {
    return this.gcZ;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(121556);
    String str = this.kmg.getSessionId();
    AppMethodBeat.o(121556);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(121552);
    String str = this.kmg.getTraceId();
    AppMethodBeat.o(121552);
    return str;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(121541);
    boolean bool = this.kmg.h(paramCanvas);
    AppMethodBeat.o(121541);
    return bool;
  }
  
  public final boolean isPaused()
  {
    AppMethodBeat.i(121555);
    boolean bool = this.kmg.isPaused();
    AppMethodBeat.o(121555);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(121553);
    ae.i("MicroMsg.IPCDynamicPageView", "onPause(%s)", new Object[] { this.gcZ });
    khX.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121523);
        IPCDynamicPageView.f(IPCDynamicPageView.this);
        String str = IPCDynamicPageView.e(IPCDynamicPageView.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("id", str);
        com.tencent.mm.ipcinvoker.h.a(i.bgs().Pc(str), localBundle, a.d.class, null);
        AppMethodBeat.o(121523);
      }
    });
    AppMethodBeat.o(121553);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121554);
    ae.i("MicroMsg.IPCDynamicPageView", "onResume(%s)", new Object[] { this.gcZ });
    this.kmg.onResume();
    khX.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121524);
        IPCDynamicPageView.f(IPCDynamicPageView.this);
        String str = IPCDynamicPageView.e(IPCDynamicPageView.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("id", str);
        com.tencent.mm.ipcinvoker.h.a(i.bgs().Pc(str), localBundle, a.e.class, null);
        AppMethodBeat.o(121524);
      }
    });
    AppMethodBeat.o(121554);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(121560);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ae.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("__page_view_width", paramInt1);
    localBundle1.putInt("__page_view_height", paramInt2);
    String str = this.gcZ;
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("id", str);
    localBundle2.putBundle("__env_args", localBundle1);
    com.tencent.mm.ipcinvoker.h.a(i.bgs().Pc(str), localBundle2, a.g.class, null);
    AppMethodBeat.o(121560);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(121550);
    this.kmg.setDrawActionReportable(parama);
    AppMethodBeat.o(121550);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(121557);
    this.kmg.setSessionId(paramString);
    AppMethodBeat.o(121557);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(121558);
    this.kmg.setStartTime(paramLong);
    AppMethodBeat.o(121558);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(121551);
    this.kmg.setTraceId(paramString);
    AppMethodBeat.o(121551);
  }
  
  public final void sq(int paramInt)
  {
    AppMethodBeat.i(121533);
    sv(paramInt);
    detach();
    AppMethodBeat.o(121533);
  }
  
  public final void sw(int paramInt)
  {
    AppMethodBeat.i(121563);
    this.kmc.bz(this.gcZ, paramInt);
    AppMethodBeat.o(121563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView
 * JD-Core Version:    0.7.0.1
 */