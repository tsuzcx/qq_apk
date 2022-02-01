package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c.e;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.j.b.b;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String Nl;
  String appId;
  volatile e gCy;
  boolean ga;
  String gcZ;
  int kia;
  boolean kib;
  f kic;
  String kid;
  volatile boolean kie;
  volatile boolean kif;
  private volatile boolean kig;
  boolean kih;
  boolean kii;
  private IPCRunCgi.a kij;
  Runnable kik;
  Context mContext;
  String mSessionId;
  String mUrl;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(121149);
    this.kih = false;
    this.kii = false;
    this.mContext = paramContext;
    this.kij = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(121141);
        ae.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        f localf = c.this.kic;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(638L, 0L, 1L, false);
          if ((c.this.kia == 1) && (!c.this.kih))
          {
            v.md(18);
            paramAnonymousString = new el().oa(u.CK(c.this.gcZ));
            paramAnonymousString.ejC = u.CI(c.this.gcZ);
            paramAnonymousString.ejz = 10L;
            paramAnonymousString.ejB = 2L;
            paramAnonymousString = paramAnonymousString.nZ(c.this.gcZ);
            paramAnonymousString.ejA = System.currentTimeMillis();
            paramAnonymousString.ob(az.iW(ak.getContext())).aLH();
          }
          if (localf != null) {}
          for (long l = localf.field_interval;; l = 10L)
          {
            b.k(c.this.kik, l * 1000L);
            if ((c.this.kic == null) || (TextUtils.isEmpty(c.this.kic.field_data))) {
              j.bgu().M(c.this.gcZ, 627, 2);
            }
            AppMethodBeat.o(121141);
            return;
          }
        }
        if ((c.this.kia == 1) && (!c.this.kih))
        {
          c.this.kih = true;
          v.md(17);
          paramAnonymousString = new el().oa(u.CK(c.this.gcZ));
          paramAnonymousString.ejC = u.CI(c.this.gcZ);
          paramAnonymousString.ejz = 10L;
          paramAnonymousString.ejB = 1L;
          paramAnonymousString = paramAnonymousString.nZ(c.this.gcZ);
          paramAnonymousString.ejA = System.currentTimeMillis();
          paramAnonymousString.ob(az.iW(ak.getContext())).aLH();
        }
        paramAnonymousb = (afw)paramAnonymousb.hQE.hQJ;
        if (paramAnonymousb.Gwe != null) {}
        for (paramAnonymousString = paramAnonymousb.Gwe.fjO(); localf == null; paramAnonymousString = "")
        {
          AppMethodBeat.o(121141);
          return;
        }
        if (!bu.isNullOrNil(paramAnonymousString)) {
          localf.field_data = paramAnonymousString;
        }
        for (;;)
        {
          localf.field_interval = paramAnonymousb.gxu;
          localf.field_updateTime = System.currentTimeMillis();
          paramAnonymousString = (Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localf.convertTo(), b.b.class);
          if (paramAnonymousString != null) {
            paramAnonymousString.getBoolean("result", false);
          }
          if (c.this.ga) {
            break;
          }
          ae.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
          AppMethodBeat.o(121141);
          return;
          if ((c.this.kic == null) || (TextUtils.isEmpty(c.this.kic.field_data))) {
            j.bgu().M(c.this.gcZ, 627, 4);
          }
        }
        c.this.a(c.this.gCy, localf);
        if ((c.this.kia == 1) && (!c.this.kii)) {
          c.this.kii = true;
        }
        if (localf.field_interval > 0) {
          c.this.bgn();
        }
        AppMethodBeat.o(121141);
      }
    };
    this.kik = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121142);
        c.this.bgn();
        AppMethodBeat.o(121142);
      }
    };
    AppMethodBeat.o(121149);
  }
  
  public final void B(Bundle paramBundle)
  {
    AppMethodBeat.i(121154);
    if (paramBundle == null)
    {
      AppMethodBeat.o(121154);
      return;
    }
    if (this.gCy != null)
    {
      z.b localb = this.gCy.aiA();
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
  
  final void a(e parame, f paramf)
  {
    boolean bool2 = false;
    AppMethodBeat.i(121153);
    if ((parame == null) || (paramf == null) || (bu.isNullOrNil(paramf.field_data)))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramf == null) {
          bool2 = true;
        }
        ae.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(121153);
        return;
      }
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", new Object[] { paramf.field_id });
    com.tencent.mm.plugin.appbrand.dynamic.f.c localc = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
    localc.data = paramf.field_data;
    parame.a(localc, new ValueCallback() {});
    parame = new Bundle();
    parame.putString("widgetId", paramf.field_id);
    parame.putString("respData", paramf.field_data);
    paramf = i.bgs().Pc(paramf.field_id);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", new Object[] { paramf });
    if (paramf == null)
    {
      ToolsProcessIPCService.a(parame, a.class);
      AppMethodBeat.o(121153);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a(paramf, parame, a.class, null);
    AppMethodBeat.o(121153);
  }
  
  final void bgn()
  {
    AppMethodBeat.i(121152);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.kib)
    {
      AppMethodBeat.o(121152);
      return;
    }
    f localf = this.kic;
    if ((localf == null) || (!this.ga))
    {
      if (localf == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.ga) });
        AppMethodBeat.o(121152);
        return;
      }
    }
    if (this.kif)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.kig = true;
      AppMethodBeat.o(121152);
      return;
    }
    if (bu.isNullOrNil(localf.field_appId))
    {
      ae.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.gcZ });
      AppMethodBeat.o(121152);
      return;
    }
    this.kig = false;
    long l = localf.field_updateTime + localf.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.k(this.kik, l);
      AppMethodBeat.o(121152);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.kic.field_id, this.kic.field_appId });
    if ((this.kia == 1) && (!this.kih))
    {
      v.md(16);
      localObject = new el().oa(u.CK(this.gcZ));
      ((el)localObject).ejC = u.CI(this.gcZ);
      ((el)localObject).ejz = 9L;
      localObject = ((el)localObject).nZ(this.gcZ);
      ((el)localObject).ejA = System.currentTimeMillis();
      ((el)localObject).ob(az.iW(ak.getContext())).aLH();
    }
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1193;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    afv localafv = new afv();
    localafv.dwb = localf.field_appId;
    localafv.key = localf.field_cacheKey;
    localafv.scene = this.kia;
    localafv.query = this.Nl;
    localafv.url = this.mUrl;
    ((b.a)localObject).hQF = localafv;
    ((b.a)localObject).hQG = new afw();
    IPCRunCgi.a(((b.a)localObject).aDS(), this.kij);
    AppMethodBeat.o(121152);
  }
  
  public final boolean cJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121150);
    if ((this.gCy == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(121150);
      return false;
    }
    boolean bool = this.gCy.ar(paramString1, paramString2);
    AppMethodBeat.o(121150);
    return bool;
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(121151);
    if (this.kic != null) {
      ae.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.kic.field_id, this.kic.field_appId });
    }
    for (;;)
    {
      if (this.gCy != null) {
        this.gCy.onStop();
      }
      AppMethodBeat.o(121151);
      return;
      ae.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  public final boolean isPaused()
  {
    return this.kie;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121155);
    ae.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.gcZ });
    boolean bool = this.kie;
    if (this.gCy != null) {
      this.gCy.b(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
    }
    this.kie = false;
    bool = this.kif;
    this.kif = false;
    if ((bool) && (this.kig)) {
      bgn();
    }
    AppMethodBeat.o(121155);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c
 * JD-Core Version:    0.7.0.1
 */