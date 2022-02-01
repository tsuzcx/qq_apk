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
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.ab;
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
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;

public class IPCDynamicPageView
  extends LinearLayout
  implements p, com.tencent.mm.plugin.appbrand.canvas.widget.a, com.tencent.mm.plugin.appbrand.dynamic.h
{
  public static ao jKv;
  private static LinearLayout.LayoutParams jOI;
  public String fHr;
  private f jKA;
  private Bundle jOA;
  private com.tencent.mm.plugin.appbrand.dynamic.a jOB;
  public ab jOC;
  public volatile boolean jOD;
  public long jOE;
  private com.tencent.mm.plugin.appbrand.canvas.widget.a jOF;
  private Runnable jOG;
  private Runnable jOH;
  private long jyR;
  private volatile boolean mDetached;
  
  static
  {
    AppMethodBeat.i(121566);
    jKv = new ao("WxaWidget#UIActionThread");
    jOI = new LinearLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(121566);
  }
  
  public IPCDynamicPageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(121526);
    this.jOG = new Runnable()
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
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.rR(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).aZL();
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
    this.jOH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (bs.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.bcd();
          if (!bs.isNullOrNil((String)localObject1)) {
            break label286;
          }
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).aZN();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.h.a(i.bcg().La((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = j.bci();
          if (!((j)localObject2).jKQ.containsKey(localObject1))
          {
            com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((j)localObject2).jKQ.remove(localObject1);
          break;
          label286:
          localObject1 = (WeakReference)((e)localObject2).jKO.remove(localObject1);
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
    this.jOG = new Runnable()
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
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.rR(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).aZL();
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
    this.jOH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (bs.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.bcd();
          if (!bs.isNullOrNil((String)localObject1)) {
            break label286;
          }
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).aZN();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.h.a(i.bcg().La((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = j.bci();
          if (!((j)localObject2).jKQ.containsKey(localObject1))
          {
            com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((j)localObject2).jKQ.remove(localObject1);
          break;
          label286:
          localObject1 = (WeakReference)((e)localObject2).jKO.remove(localObject1);
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
    this.jOG = new Runnable()
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
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(645L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(645L, 11L, 1L, false);
          IPCDynamicPageView.this.rR(2107);
          IPCDynamicPageView.a(IPCDynamicPageView.this, System.currentTimeMillis());
          IPCDynamicPageView.d(IPCDynamicPageView.this).aZL();
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
    this.jOH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121520);
        Object localObject1 = IPCDynamicPageView.e(IPCDynamicPageView.this);
        if (bs.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
          AppMethodBeat.o(121520);
          return;
        }
        IPCDynamicPageView.b(IPCDynamicPageView.this, true);
        Object localObject2 = IPCDynamicPageView.f(IPCDynamicPageView.this);
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[] { Integer.valueOf(localObject2.hashCode()) });
          localObject2 = e.bcd();
          if (!bs.isNullOrNil((String)localObject1)) {
            break label286;
          }
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
        }
        for (;;)
        {
          IPCDynamicPageView.this.cleanup();
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, null);
          IPCDynamicPageView.a(IPCDynamicPageView.this, false);
          IPCDynamicPageView.d(IPCDynamicPageView.this).aZN();
          IPCDynamicPageView.d(IPCDynamicPageView.this).setTraceId(null);
          AppMethodBeat.o(121520);
          return;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[] { Integer.valueOf(localObject2.hashCode()), localObject1 });
          Bundle localBundle = new Bundle();
          localBundle.putString("id", (String)localObject1);
          com.tencent.mm.ipcinvoker.h.a(i.bcg().La((String)localObject1), localBundle, a.b.class, new a.2((com.tencent.mm.plugin.appbrand.dynamic.a)localObject2, (String)localObject1));
          localObject2 = j.bci();
          if (!((j)localObject2).jKQ.containsKey(localObject1))
          {
            com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", new Object[] { localObject1 });
            break;
          }
          ((j)localObject2).jKQ.remove(localObject1);
          break;
          label286:
          localObject1 = (WeakReference)((e)localObject2).jKO.remove(localObject1);
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
    this.jOB = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
    paramContext = b.cz(paramContext);
    addView(paramContext, jOI);
    this.jOF = ((com.tencent.mm.plugin.appbrand.canvas.widget.a)paramContext);
    this.jOF.setTraceId(this.fHr);
    AppMethodBeat.o(121529);
  }
  
  private void rQ(final int paramInt)
  {
    AppMethodBeat.i(121561);
    if (this.jOC == null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", new Object[] { this.fHr, Integer.valueOf(paramInt) });
      AppMethodBeat.o(121561);
      return;
    }
    final com.tencent.mm.modelappbrand.h localh = this.jOC.aAO();
    if (localh == null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", new Object[] { this.fHr, Integer.valueOf(paramInt) });
      AppMethodBeat.o(121561);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localh.N(this, paramInt);
      AppMethodBeat.o(121561);
      return;
    }
    com.tencent.mm.plugin.appbrand.dynamic.b.T(new Runnable()
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
  
  public final void S(Runnable paramRunnable)
  {
    AppMethodBeat.i(121548);
    this.jOF.S(paramRunnable);
    AppMethodBeat.o(121548);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121545);
    this.jOF.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(121545);
  }
  
  public final void a(String paramString, t paramt)
  {
    AppMethodBeat.i(121537);
    if (this.jOC == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121537);
      return;
    }
    ah localah = (ah)this.jOC.zo("openApp");
    if (localah == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121537);
      return;
    }
    localah.zq(paramString);
    AppMethodBeat.o(121537);
  }
  
  public final void a(String paramString1, String paramString2, t paramt)
  {
    AppMethodBeat.i(121539);
    if (this.jOC == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121539);
      return;
    }
    y localy = (y)this.jOC.zo("showPicker");
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
    this.jOF.a(paramJSONArray, parama);
    AppMethodBeat.o(121543);
  }
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, t paramt)
  {
    AppMethodBeat.i(121538);
    if (this.jOC == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121538);
      return;
    }
    af localaf = (af)this.jOC.zo("OnTapCallback");
    if (localaf == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121538);
      return;
    }
    localaf.b(paramBoolean1, paramString, paramBoolean2);
    AppMethodBeat.o(121538);
  }
  
  public final boolean aR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121562);
    Object localObject = this.jOB;
    String str = this.fHr;
    if ((((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).fHr == null) || (((com.tencent.mm.plugin.appbrand.dynamic.a)localObject).fHr.length() == 0) || (paramString1 == null) || (paramString1.length() == 0))
    {
      AppMethodBeat.o(121562);
      return false;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("id", str);
    ((Bundle)localObject).putString("event", paramString1);
    ((Bundle)localObject).putString("data", paramString2);
    paramString1 = (IPCBoolean)com.tencent.mm.ipcinvoker.h.a(i.bcg().La(str), (Parcelable)localObject, a.f.class);
    if (paramString1 != null)
    {
      boolean bool = paramString1.value;
      AppMethodBeat.o(121562);
      return bool;
    }
    AppMethodBeat.o(121562);
    return false;
  }
  
  public final void aZL()
  {
    AppMethodBeat.i(121542);
    long l = System.currentTimeMillis() - this.jyR;
    jKv.removeCallbacks(this.jOG);
    if (l < 12L)
    {
      jKv.postDelayed(this.jOG, l);
      AppMethodBeat.o(121542);
      return;
    }
    this.jOG.run();
    AppMethodBeat.o(121542);
  }
  
  public final void aZM()
  {
    AppMethodBeat.i(121547);
    this.jOF.aZM();
    AppMethodBeat.o(121547);
  }
  
  public final void aZN()
  {
    AppMethodBeat.i(121559);
    this.jOF.aZN();
    AppMethodBeat.o(121559);
  }
  
  public final void b(int paramInt, t paramt)
  {
    AppMethodBeat.i(121540);
    if (this.jOC == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121540);
      return;
    }
    aj localaj = (aj)this.jOC.zo("setWidgetSize");
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
    this.jOF.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(121546);
  }
  
  public final void b(String paramString, t paramt)
  {
    AppMethodBeat.i(121535);
    if (this.jOC == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121535);
      return;
    }
    ad localad = (ad)this.jOC.zo("makePhoneCall");
    if (localad == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121535);
      return;
    }
    localad.zp(paramString);
    AppMethodBeat.o(121535);
  }
  
  public final void b(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.canvas.widget.a.a parama)
  {
    AppMethodBeat.i(121544);
    this.jOF.b(paramJSONArray, parama);
    AppMethodBeat.o(121544);
  }
  
  public final void bcf()
  {
    AppMethodBeat.i(121534);
    if (this.jOC == null)
    {
      AppMethodBeat.o(121534);
      return;
    }
    ag localag = (ag)this.jOC.zo("onUiUpdate");
    if (localag == null)
    {
      AppMethodBeat.o(121534);
      return;
    }
    localag.aAQ();
    AppMethodBeat.o(121534);
  }
  
  public final void c(String paramString, t paramt)
  {
    AppMethodBeat.i(121536);
    if (this.jOC == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121536);
      return;
    }
    ai localai = (ai)this.jOC.zo("onSearchWAWidgetReloadData");
    if (localai == null)
    {
      paramt.b(false, "listener is null", null);
      AppMethodBeat.o(121536);
      return;
    }
    localai.zr(paramString);
    AppMethodBeat.o(121536);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(121532);
    if (this.jKA != null) {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", new Object[] { this.fHr, this.jKA.field_id, this.jKA.field_appId, this.jKA.field_cacheKey });
    }
    for (;;)
    {
      aZM();
      AppMethodBeat.o(121532);
      return;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", new Object[] { this.fHr });
    }
  }
  
  public final void d(final String paramString1, final String paramString2, final Bundle paramBundle)
  {
    AppMethodBeat.i(121530);
    jKv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121522);
        String str1 = "";
        if (paramBundle != null) {
          str1 = paramBundle.getString("cache_key", "");
        }
        u.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s)", new Object[] { paramString1, paramString2 });
        IPCDynamicPageView.a(IPCDynamicPageView.this, com.tencent.mm.plugin.appbrand.dynamic.j.b.Lr(paramString1));
        if (IPCDynamicPageView.g(IPCDynamicPageView.this) == null) {
          IPCDynamicPageView.a(IPCDynamicPageView.this, new f());
        }
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_id = paramString1;
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_cacheKey = str1;
        IPCDynamicPageView.g(IPCDynamicPageView.this).field_appId = u.zj(IPCDynamicPageView.e(IPCDynamicPageView.this));
        IPCDynamicPageView.this.getDrawContext().ggi.l("id", paramString1);
        e.bcd().c(paramString1, IPCDynamicPageView.this);
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
        com.tencent.mm.ipcinvoker.h.a(i.bcg().La(str1), localBundle2, com.tencent.mm.plugin.appbrand.dynamic.a.a.class, null);
        AppMethodBeat.o(121522);
      }
    });
    AppMethodBeat.o(121530);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(121531);
    if (com.tencent.e.j.a.fEC() == jKv.getSerial())
    {
      this.jOH.run();
      AppMethodBeat.o(121531);
      return;
    }
    jKv.post(this.jOH);
    AppMethodBeat.o(121531);
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(121549);
    d locald = this.jOF.getDrawContext();
    AppMethodBeat.o(121549);
    return locald;
  }
  
  public Bundle getExtData()
  {
    return this.jOA;
  }
  
  public String getExtId()
  {
    return this.fHr;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(121556);
    String str = this.jOF.getSessionId();
    AppMethodBeat.o(121556);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(121552);
    String str = this.jOF.getTraceId();
    AppMethodBeat.o(121552);
    return str;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(121541);
    boolean bool = this.jOF.h(paramCanvas);
    AppMethodBeat.o(121541);
    return bool;
  }
  
  public final boolean isPaused()
  {
    AppMethodBeat.i(121555);
    boolean bool = this.jOF.isPaused();
    AppMethodBeat.o(121555);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(121553);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "onPause(%s)", new Object[] { this.fHr });
    jKv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121523);
        IPCDynamicPageView.f(IPCDynamicPageView.this);
        String str = IPCDynamicPageView.e(IPCDynamicPageView.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("id", str);
        com.tencent.mm.ipcinvoker.h.a(i.bcg().La(str), localBundle, a.d.class, null);
        AppMethodBeat.o(121523);
      }
    });
    AppMethodBeat.o(121553);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121554);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "onResume(%s)", new Object[] { this.fHr });
    this.jOF.onResume();
    jKv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121524);
        IPCDynamicPageView.f(IPCDynamicPageView.this);
        String str = IPCDynamicPageView.e(IPCDynamicPageView.this);
        Bundle localBundle = new Bundle();
        localBundle.putString("id", str);
        com.tencent.mm.ipcinvoker.h.a(i.bcg().La(str), localBundle, a.e.class, null);
        AppMethodBeat.o(121524);
      }
    });
    AppMethodBeat.o(121554);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(121560);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("__page_view_width", paramInt1);
    localBundle1.putInt("__page_view_height", paramInt2);
    String str = this.fHr;
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("id", str);
    localBundle2.putBundle("__env_args", localBundle1);
    com.tencent.mm.ipcinvoker.h.a(i.bcg().La(str), localBundle2, a.g.class, null);
    AppMethodBeat.o(121560);
  }
  
  public final void rL(int paramInt)
  {
    AppMethodBeat.i(121533);
    rQ(paramInt);
    detach();
    AppMethodBeat.o(121533);
  }
  
  public final void rR(int paramInt)
  {
    AppMethodBeat.i(121563);
    this.jOB.bu(this.fHr, paramInt);
    AppMethodBeat.o(121563);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(121550);
    this.jOF.setDrawActionReportable(parama);
    AppMethodBeat.o(121550);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(121557);
    this.jOF.setSessionId(paramString);
    AppMethodBeat.o(121557);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(121558);
    this.jOF.setStartTime(paramLong);
    AppMethodBeat.o(121558);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(121551);
    this.jOF.setTraceId(paramString);
    AppMethodBeat.o(121551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView
 * JD-Core Version:    0.7.0.1
 */