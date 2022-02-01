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
import com.tencent.mm.ipcinvoker.h.c;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.x;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;

public class IPCDynamicPageView
  extends LinearLayout
  implements p, com.tencent.mm.plugin.appbrand.canvas.widget.a, com.tencent.mm.plugin.appbrand.dynamic.h
{
  public static MMHandler rjW;
  private static LinearLayout.LayoutParams rog;
  public String lWh;
  private volatile boolean mDetached;
  private long qSY;
  private com.tencent.mm.plugin.appbrand.widget.h rkb;
  private Bundle rnY;
  private com.tencent.mm.plugin.appbrand.dynamic.a rnZ;
  public aa roa;
  public volatile boolean rob;
  public long roc;
  private com.tencent.mm.plugin.appbrand.canvas.widget.a rod;
  private Runnable roe;
  private Runnable rof;
  
  static
  {
    AppMethodBeat.i(121566);
    rjW = new MMHandler("WxaWidget#UIActionThread");
    rog = new LinearLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(121566);
  }
  
  public IPCDynamicPageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(121526);
    this.roe = new Runnable()
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.zV(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).cjV();
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
    this.rof = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          Log.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.cnt();
          if (!Util.isNullOrNil((String)localObject1)) {
            break label286;
          }
          Log.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).cjX();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          Log.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = com.tencent.mm.plugin.appbrand.dynamic.j.cny();
          if (!((com.tencent.mm.plugin.appbrand.dynamic.j)localObject2).rkp.containsKey(localObject1))
          {
            c.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((com.tencent.mm.plugin.appbrand.dynamic.j)localObject2).rkp.remove(localObject1);
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
    this.roe = new Runnable()
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.zV(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).cjV();
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
    this.rof = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          Log.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.cnt();
          if (!Util.isNullOrNil((String)localObject1)) {
            break label286;
          }
          Log.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).cjX();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          Log.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = com.tencent.mm.plugin.appbrand.dynamic.j.cny();
          if (!((com.tencent.mm.plugin.appbrand.dynamic.j)localObject2).rkp.containsKey(localObject1))
          {
            c.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((com.tencent.mm.plugin.appbrand.dynamic.j)localObject2).rkp.remove(localObject1);
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
    this.roe = new Runnable()
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.zV(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).cjV();
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
    this.rof = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          Log.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.cnt();
          if (!Util.isNullOrNil((String)localObject1)) {
            break label286;
          }
          Log.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).cjX();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          Log.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = com.tencent.mm.plugin.appbrand.dynamic.j.cny();
          if (!((com.tencent.mm.plugin.appbrand.dynamic.j)localObject2).rkp.containsKey(localObject1))
          {
            c.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((com.tencent.mm.plugin.appbrand.dynamic.j)localObject2).rkp.remove(localObject1);
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
    this.rnZ = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
    paramContext = b.dM(paramContext);
    addView(paramContext, rog);
    this.rod = ((com.tencent.mm.plugin.appbrand.canvas.widget.a)paramContext);
    this.rod.setTraceId(this.lWh);
    AppMethodBeat.o(121529);
  }
  
  private void zU(final int paramInt)
  {
    AppMethodBeat.i(121561);
    if (this.roa == null)
    {
      Log.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", new Object[] { this.lWh, Integer.valueOf(paramInt) });
      AppMethodBeat.o(121561);
      return;
    }
    final com.tencent.mm.modelappbrand.i locali = this.roa.bEU();
    if (locali == null)
    {
      Log.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", new Object[] { this.lWh, Integer.valueOf(paramInt) });
      AppMethodBeat.o(121561);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      locali.S(this, paramInt);
      AppMethodBeat.o(121561);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.b.ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121525);
        locali.S(IPCDynamicPageView.this, paramInt);
        AppMethodBeat.o(121525);
      }
    });
    AppMethodBeat.o(121561);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121545);
    this.rod.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(121545);
  }
  
  public final void a(String paramString, t paramt)
  {
    AppMethodBeat.i(121537);
    if (this.roa == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121537);
      return;
    }
    ag localag = (ag)this.roa.KV("openApp");
    if (localag == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121537);
      return;
    }
    localag.KX(paramString);
    AppMethodBeat.o(121537);
  }
  
  public final void a(String paramString1, String paramString2, t paramt)
  {
    AppMethodBeat.i(121539);
    if (this.roa == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121539);
      return;
    }
    x localx = (x)this.roa.KV("showPicker");
    if (localx == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121539);
      return;
    }
    localx.a(paramString1, paramString2, paramt);
    AppMethodBeat.o(121539);
  }
  
  public final void a(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121543);
    this.rod.a(paramJSONArray, parama);
    AppMethodBeat.o(121543);
  }
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, t paramt)
  {
    AppMethodBeat.i(121538);
    if (this.roa == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121538);
      return;
    }
    ae localae = (ae)this.roa.KV("OnTapCallback");
    if (localae == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121538);
      return;
    }
    localae.b(paramBoolean1, paramString, paramBoolean2);
    AppMethodBeat.o(121538);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    AppMethodBeat.i(121548);
    this.rod.ab(paramRunnable);
    AppMethodBeat.o(121548);
  }
  
  public final void b(int paramInt, t paramt)
  {
    AppMethodBeat.i(121540);
    if (this.roa == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121540);
      return;
    }
    ai localai = (ai)this.roa.KV("setWidgetSize");
    if (localai == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121540);
      return;
    }
    localai.a(paramInt, paramt);
    AppMethodBeat.o(121540);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121546);
    this.rod.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(121546);
  }
  
  public final void b(String paramString, t paramt)
  {
    AppMethodBeat.i(121535);
    if (this.roa == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121535);
      return;
    }
    ac localac = (ac)this.roa.KV("makePhoneCall");
    if (localac == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121535);
      return;
    }
    localac.KW(paramString);
    AppMethodBeat.o(121535);
  }
  
  public final void b(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121544);
    this.rod.b(paramJSONArray, parama);
    AppMethodBeat.o(121544);
  }
  
  public final boolean bk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121562);
    Object localObject = this.rnZ;
    String str = this.lWh;
    if ((((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).lWh == null) || (((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).lWh.length() == 0) || (paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(121562);
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("id", str);
    ((Bundle)localObject).putString("event", paramString1);
    ((Bundle)localObject).putString("data", paramString2);
    paramString1 = (IPCBoolean)com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX(str), (Parcelable)localObject, a.f.class);
    if (paramString1 != null)
    {
      boolean bool = paramString1.value;
      AppMethodBeat.o(121562);
      return bool;
    }
    AppMethodBeat.o(121562);
    return false;
  }
  
  public final void c(String paramString, t paramt)
  {
    AppMethodBeat.i(121536);
    if (this.roa == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121536);
      return;
    }
    ah localah = (ah)this.roa.KV("onSearchWAWidgetReloadData");
    if (localah == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121536);
      return;
    }
    localah.KY(paramString);
    AppMethodBeat.o(121536);
  }
  
  public final void cjV()
  {
    AppMethodBeat.i(121542);
    long l = System.currentTimeMillis() - this.qSY;
    rjW.removeCallbacks(this.roe);
    if (l < 12L)
    {
      rjW.postDelayed(this.roe, l);
      AppMethodBeat.o(121542);
      return;
    }
    this.roe.run();
    AppMethodBeat.o(121542);
  }
  
  public final void cjW()
  {
    AppMethodBeat.i(121547);
    this.rod.cjW();
    AppMethodBeat.o(121547);
  }
  
  public final void cjX()
  {
    AppMethodBeat.i(121559);
    this.rod.cjX();
    AppMethodBeat.o(121559);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(121532);
    if (this.rkb != null) {
      Log.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", new Object[] { this.lWh, this.rkb.field_id, this.rkb.field_appId, this.rkb.field_cacheKey });
    }
    for (;;)
    {
      cjW();
      AppMethodBeat.o(121532);
      return;
      Log.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", new Object[] { this.lWh });
    }
  }
  
  public final void cnv()
  {
    AppMethodBeat.i(121534);
    if (this.roa == null)
    {
      AppMethodBeat.o(121534);
      return;
    }
    af localaf = (af)this.roa.KV("onUiUpdate");
    if (localaf == null)
    {
      AppMethodBeat.o(121534);
      return;
    }
    localaf.bEW();
    AppMethodBeat.o(121534);
  }
  
  public final void d(final String paramString1, final String paramString2, final Bundle paramBundle)
  {
    AppMethodBeat.i(121530);
    rjW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121522);
        String str1 = "";
        if (paramBundle != null) {
          str1 = paramBundle.getString("cache_key", "");
        }
        u.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s)", new Object[] { paramString1, paramString2 });
        IPCDynamicPageView.a(IPCDynamicPageView.this, com.tencent.mm.plugin.appbrand.dynamic.j.b.Zo(paramString1));
        if (IPCDynamicPageView.g(IPCDynamicPageView.this) == null) {
          IPCDynamicPageView.a(IPCDynamicPageView.this, new com.tencent.mm.plugin.appbrand.widget.h());
        }
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_id = paramString1;
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_cacheKey = str1;
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_appId = u.KQ(IPCDynamicPageView.e(IPCDynamicPageView.this));
        IPCDynamicPageView.this.getDrawContext().mBj.q("id", paramString1);
        e.cnt().d(paramString1, IPCDynamicPageView.this);
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
        com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX(str1), localBundle2, com.tencent.mm.plugin.appbrand.dynamic.a.a.class, null);
        AppMethodBeat.o(121522);
      }
    });
    AppMethodBeat.o(121530);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(121531);
    if (com.tencent.threadpool.j.a.jZA() == rjW.getSerial())
    {
      this.rof.run();
      AppMethodBeat.o(121531);
      return;
    }
    rjW.post(this.rof);
    AppMethodBeat.o(121531);
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(121549);
    d locald = this.rod.getDrawContext();
    AppMethodBeat.o(121549);
    return locald;
  }
  
  public Bundle getExtData()
  {
    return this.rnY;
  }
  
  public String getExtId()
  {
    return this.lWh;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(121556);
    String str = this.rod.getSessionId();
    AppMethodBeat.o(121556);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(121552);
    String str = this.rod.getTraceId();
    AppMethodBeat.o(121552);
    return str;
  }
  
  public final boolean isPaused()
  {
    AppMethodBeat.i(121555);
    boolean bool = this.rod.isPaused();
    AppMethodBeat.o(121555);
    return bool;
  }
  
  public final boolean l(Canvas paramCanvas)
  {
    AppMethodBeat.i(121541);
    boolean bool = this.rod.l(paramCanvas);
    AppMethodBeat.o(121541);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(121553);
    Log.i("MicroMsg.IPCDynamicPageView", "onPause(%s)", new Object[] { this.lWh });
    rjW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121523);
        IPCDynamicPageView.f(IPCDynamicPageView.this);
        String str = IPCDynamicPageView.e(IPCDynamicPageView.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("id", str);
        com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX(str), localBundle, a.d.class, null);
        AppMethodBeat.o(121523);
      }
    });
    AppMethodBeat.o(121553);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121554);
    Log.i("MicroMsg.IPCDynamicPageView", "onResume(%s)", new Object[] { this.lWh });
    this.rod.onResume();
    rjW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121524);
        IPCDynamicPageView.f(IPCDynamicPageView.this);
        String str = IPCDynamicPageView.e(IPCDynamicPageView.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("id", str);
        com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX(str), localBundle, a.e.class, null);
        AppMethodBeat.o(121524);
      }
    });
    AppMethodBeat.o(121554);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(121560);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("__page_view_width", paramInt1);
    localBundle1.putInt("__page_view_height", paramInt2);
    String str = this.lWh;
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("id", str);
    localBundle2.putBundle("__env_args", localBundle1);
    com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.cnw().YX(str), localBundle2, a.g.class, null);
    AppMethodBeat.o(121560);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(121550);
    this.rod.setDrawActionReportable(parama);
    AppMethodBeat.o(121550);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(121557);
    this.rod.setSessionId(paramString);
    AppMethodBeat.o(121557);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(121558);
    this.rod.setStartTime(paramLong);
    AppMethodBeat.o(121558);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(121551);
    this.rod.setTraceId(paramString);
    AppMethodBeat.o(121551);
  }
  
  public final void zP(int paramInt)
  {
    AppMethodBeat.i(121533);
    zU(paramInt);
    detach();
    AppMethodBeat.o(121533);
  }
  
  public final void zV(int paramInt)
  {
    AppMethodBeat.i(121563);
    this.rnZ.cw(this.lWh, paramInt);
    AppMethodBeat.o(121563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView
 * JD-Core Version:    0.7.0.1
 */