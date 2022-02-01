package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c.e;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.b.a.jw;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.j.b.b;
import com.tencent.mm.plugin.appbrand.m.z;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String Ln;
  boolean Tb;
  String appId;
  String jQi;
  String jsP;
  volatile e kbd;
  Context mContext;
  String mSessionId;
  String mUrl;
  private volatile boolean ogA;
  boolean ogB;
  boolean ogC;
  private IPCRunCgi.a ogD;
  Runnable ogE;
  int ogv;
  boolean ogw;
  com.tencent.mm.plugin.appbrand.widget.g ogx;
  volatile boolean ogy;
  volatile boolean ogz;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(121149);
    this.ogB = false;
    this.ogC = false;
    this.mContext = paramContext;
    this.ogD = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd)
      {
        AppMethodBeat.i(121141);
        Log.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        com.tencent.mm.plugin.appbrand.widget.g localg = c.this.ogx;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(638L, 0L, 1L, false);
          if ((c.this.ogv == 1) && (!c.this.ogB))
          {
            v.rE(18);
            paramAnonymousString = new jw().AS(u.SO(c.this.jsP));
            paramAnonymousString.gyo = u.SM(c.this.jsP);
            paramAnonymousString.gLX = 10L;
            paramAnonymousString.gLZ = 2L;
            paramAnonymousString = paramAnonymousString.AR(c.this.jsP);
            paramAnonymousString.gLY = System.currentTimeMillis();
            paramAnonymousString.AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
          }
          if (localg != null) {}
          for (long l = localg.field_interval;; l = 10L)
          {
            b.i(c.this.ogE, l * 1000L);
            if ((c.this.ogx == null) || (TextUtils.isEmpty(c.this.ogx.field_data))) {
              j.bNj().P(c.this.jsP, 627, 2);
            }
            AppMethodBeat.o(121141);
            return;
          }
        }
        if ((c.this.ogv == 1) && (!c.this.ogB))
        {
          c.this.ogB = true;
          v.rE(17);
          paramAnonymousString = new jw().AS(u.SO(c.this.jsP));
          paramAnonymousString.gyo = u.SM(c.this.jsP);
          paramAnonymousString.gLX = 10L;
          paramAnonymousString.gLZ = 1L;
          paramAnonymousString = paramAnonymousString.AR(c.this.jsP);
          paramAnonymousString.gLY = System.currentTimeMillis();
          paramAnonymousString.AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
        }
        paramAnonymousd = (aio)d.c.b(paramAnonymousd.lBS);
        if (paramAnonymousd.Sth != null) {}
        for (paramAnonymousString = paramAnonymousd.Sth.Ap(); localg == null; paramAnonymousString = "")
        {
          AppMethodBeat.o(121141);
          return;
        }
        if (!Util.isNullOrNil(paramAnonymousString)) {
          localg.field_data = paramAnonymousString;
        }
        for (;;)
        {
          localg.field_interval = paramAnonymousd.interval;
          localg.field_updateTime = System.currentTimeMillis();
          paramAnonymousString = (Bundle)com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, localg.convertTo(), b.b.class);
          if (paramAnonymousString != null) {
            paramAnonymousString.getBoolean("result", false);
          }
          if (c.this.Tb) {
            break;
          }
          Log.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
          AppMethodBeat.o(121141);
          return;
          if ((c.this.ogx == null) || (TextUtils.isEmpty(c.this.ogx.field_data))) {
            j.bNj().P(c.this.jsP, 627, 4);
          }
        }
        c.this.a(c.this.kbd, localg);
        if ((c.this.ogv == 1) && (!c.this.ogC)) {
          c.this.ogC = true;
        }
        if (localg.field_interval > 0) {
          c.this.bNc();
        }
        AppMethodBeat.o(121141);
      }
    };
    this.ogE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121142);
        c.this.bNc();
        AppMethodBeat.o(121142);
      }
    };
    AppMethodBeat.o(121149);
  }
  
  public final void N(Bundle paramBundle)
  {
    AppMethodBeat.i(121154);
    if (paramBundle == null)
    {
      AppMethodBeat.o(121154);
      return;
    }
    if (this.kbd != null)
    {
      ad.b localb = this.kbd.aGj();
      if (localb == null)
      {
        AppMethodBeat.o(121154);
        return;
      }
      Object localObject = paramBundle.keySet();
      if ((localObject == null) || (localb == null))
      {
        AppMethodBeat.o(121154);
        return;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localb.k(str, paramBundle.get(str));
      }
    }
    AppMethodBeat.o(121154);
  }
  
  final void a(e parame, com.tencent.mm.plugin.appbrand.widget.g paramg)
  {
    boolean bool2 = false;
    AppMethodBeat.i(121153);
    if ((parame == null) || (paramg == null) || (Util.isNullOrNil(paramg.field_data)))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramg == null) {
          bool2 = true;
        }
        Log.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(121153);
        return;
      }
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", new Object[] { paramg.field_id });
    com.tencent.mm.plugin.appbrand.dynamic.f.c localc = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
    localc.data = paramg.field_data;
    parame.a(localc, new ValueCallback() {});
    parame = new Bundle();
    parame.putString("widgetId", paramg.field_id);
    parame.putString("respData", paramg.field_data);
    paramg = i.bNh().agb(paramg.field_id);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", new Object[] { paramg });
    if (paramg == null)
    {
      ToolsProcessIPCService.a(parame, a.class);
      AppMethodBeat.o(121153);
      return;
    }
    com.tencent.mm.ipcinvoker.j.a(paramg, parame, a.class, null);
    AppMethodBeat.o(121153);
  }
  
  final void bNc()
  {
    AppMethodBeat.i(121152);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.ogw)
    {
      AppMethodBeat.o(121152);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.g localg = this.ogx;
    if ((localg == null) || (!this.Tb))
    {
      if (localg == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.Tb) });
        AppMethodBeat.o(121152);
        return;
      }
    }
    if (this.ogz)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.ogA = true;
      AppMethodBeat.o(121152);
      return;
    }
    if (Util.isNullOrNil(localg.field_appId))
    {
      Log.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.jsP });
      AppMethodBeat.o(121152);
      return;
    }
    this.ogA = false;
    long l = localg.field_updateTime + localg.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.i(this.ogE, l);
      AppMethodBeat.o(121152);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.ogx.field_id, this.ogx.field_appId });
    if ((this.ogv == 1) && (!this.ogB))
    {
      v.rE(16);
      localObject = new jw().AS(u.SO(this.jsP));
      ((jw)localObject).gyo = u.SM(this.jsP);
      ((jw)localObject).gLX = 9L;
      localObject = ((jw)localObject).AR(this.jsP);
      ((jw)localObject).gLY = System.currentTimeMillis();
      ((jw)localObject).AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
    }
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 1193;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    ain localain = new ain();
    localain.appid = localg.field_appId;
    localain.key = localg.field_cacheKey;
    localain.scene = this.ogv;
    localain.query = this.Ln;
    localain.url = this.mUrl;
    ((d.a)localObject).lBU = localain;
    ((d.a)localObject).lBV = new aio();
    IPCRunCgi.a(((d.a)localObject).bgN(), this.ogD);
    AppMethodBeat.o(121152);
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(121151);
    if (this.ogx != null) {
      Log.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.ogx.field_id, this.ogx.field_appId });
    }
    for (;;)
    {
      if (this.kbd != null) {
        this.kbd.onStop();
      }
      AppMethodBeat.o(121151);
      return;
      Log.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  public final boolean dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121150);
    if ((this.kbd == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(121150);
      return false;
    }
    boolean bool = this.kbd.ax(paramString1, paramString2);
    AppMethodBeat.o(121150);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.ogy;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121155);
    Log.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.jsP });
    boolean bool = this.ogy;
    if (this.kbd != null) {
      this.kbd.b(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
    }
    this.ogy = false;
    bool = this.ogz;
    this.ogz = false;
    if ((bool) && (this.ogA)) {
      bNc();
    }
    AppMethodBeat.o(121155);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  static class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c
 * JD-Core Version:    0.7.0.1
 */