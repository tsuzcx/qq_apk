package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.c.e;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.f.g;
import com.tencent.mm.plugin.appbrand.dynamic.j.b.b;
import com.tencent.mm.plugin.appbrand.jsruntime.y;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String Ky;
  String appId;
  boolean arf;
  String fDK;
  volatile e gbB;
  int jkl;
  boolean jkm;
  f jkn;
  String jko;
  volatile boolean jkp;
  volatile boolean jkq;
  private volatile boolean jkr;
  boolean jks;
  boolean jkt;
  private IPCRunCgi.a jku;
  Runnable jkv;
  Context mContext;
  String mSessionId;
  String mUrl;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(121149);
    this.jks = false;
    this.jkt = false;
    this.mContext = paramContext;
    this.jku = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(121141);
        ad.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        f localf = c.this.jkn;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(638L, 0L, 1L, false);
          if ((c.this.jkl == 1) && (!c.this.jks))
          {
            v.lI(18);
            paramAnonymousString = new ca().iI(u.vd(c.this.fDK));
            paramAnonymousString.dQy = u.vb(c.this.fDK);
            paramAnonymousString.dQv = 10L;
            paramAnonymousString.dQx = 2L;
            paramAnonymousString = paramAnonymousString.iH(c.this.fDK);
            paramAnonymousString.dQw = System.currentTimeMillis();
            paramAnonymousString.iJ(ay.iw(aj.getContext())).aBj();
          }
          if (localf != null) {}
          for (long l = localf.field_interval;; l = 10L)
          {
            b.j(c.this.jkv, l * 1000L);
            if ((c.this.jkn == null) || (TextUtils.isEmpty(c.this.jkn.field_data))) {
              j.aVk().L(c.this.fDK, 627, 2);
            }
            AppMethodBeat.o(121141);
            return;
          }
        }
        if ((c.this.jkl == 1) && (!c.this.jks))
        {
          c.this.jks = true;
          v.lI(17);
          paramAnonymousString = new ca().iI(u.vd(c.this.fDK));
          paramAnonymousString.dQy = u.vb(c.this.fDK);
          paramAnonymousString.dQv = 10L;
          paramAnonymousString.dQx = 1L;
          paramAnonymousString = paramAnonymousString.iH(c.this.fDK);
          paramAnonymousString.dQw = System.currentTimeMillis();
          paramAnonymousString.iJ(ay.iw(aj.getContext())).aBj();
        }
        paramAnonymousb = (acn)paramAnonymousb.gUT.gUX;
        if (paramAnonymousb.DcU != null) {}
        for (paramAnonymousString = paramAnonymousb.DcU.eBA(); localf == null; paramAnonymousString = "")
        {
          AppMethodBeat.o(121141);
          return;
        }
        if (!bt.isNullOrNil(paramAnonymousString)) {
          localf.field_data = paramAnonymousString;
        }
        for (;;)
        {
          localf.field_interval = paramAnonymousb.fWw;
          localf.field_updateTime = System.currentTimeMillis();
          paramAnonymousString = (Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localf.convertTo(), b.b.class);
          if (paramAnonymousString != null) {
            paramAnonymousString.getBoolean("result", false);
          }
          if (c.this.arf) {
            break;
          }
          ad.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
          AppMethodBeat.o(121141);
          return;
          if ((c.this.jkn == null) || (TextUtils.isEmpty(c.this.jkn.field_data))) {
            j.aVk().L(c.this.fDK, 627, 4);
          }
        }
        c.this.a(c.this.gbB, localf);
        if ((c.this.jkl == 1) && (!c.this.jkt)) {
          c.this.jkt = true;
        }
        if (localf.field_interval > 0) {
          c.this.aVd();
        }
        AppMethodBeat.o(121141);
      }
    };
    this.jkv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121142);
        c.this.aVd();
        AppMethodBeat.o(121142);
      }
    };
    AppMethodBeat.o(121149);
  }
  
  final void a(e parame, f paramf)
  {
    boolean bool2 = false;
    AppMethodBeat.i(121153);
    if ((parame == null) || (paramf == null) || (bt.isNullOrNil(paramf.field_data)))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramf == null) {
          bool2 = true;
        }
        ad.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    paramf = i.aVi().GW(paramf.field_id);
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
  
  final void aVd()
  {
    AppMethodBeat.i(121152);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.jkm)
    {
      AppMethodBeat.o(121152);
      return;
    }
    f localf = this.jkn;
    if ((localf == null) || (!this.arf))
    {
      if (localf == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.arf) });
        AppMethodBeat.o(121152);
        return;
      }
    }
    if (this.jkq)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.jkr = true;
      AppMethodBeat.o(121152);
      return;
    }
    if (bt.isNullOrNil(localf.field_appId))
    {
      ad.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.fDK });
      AppMethodBeat.o(121152);
      return;
    }
    this.jkr = false;
    long l = localf.field_updateTime + localf.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.j(this.jkv, l);
      AppMethodBeat.o(121152);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.jkn.field_id, this.jkn.field_appId });
    if ((this.jkl == 1) && (!this.jks))
    {
      v.lI(16);
      localObject = new ca().iI(u.vd(this.fDK));
      ((ca)localObject).dQy = u.vb(this.fDK);
      ((ca)localObject).dQv = 9L;
      localObject = ((ca)localObject).iH(this.fDK);
      ((ca)localObject).dQw = System.currentTimeMillis();
      ((ca)localObject).iJ(ay.iw(aj.getContext())).aBj();
    }
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1193;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    acm localacm = new acm();
    localacm.dlB = localf.field_appId;
    localacm.key = localf.field_cacheKey;
    localacm.scene = this.jkl;
    localacm.query = this.Ky;
    localacm.url = this.mUrl;
    ((b.a)localObject).gUU = localacm;
    ((b.a)localObject).gUV = new acn();
    IPCRunCgi.a(((b.a)localObject).atI(), this.jku);
    AppMethodBeat.o(121152);
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(121151);
    if (this.jkn != null) {
      ad.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.jkn.field_id, this.jkn.field_appId });
    }
    for (;;)
    {
      if (this.gbB != null) {
        this.gbB.onStop();
      }
      AppMethodBeat.o(121151);
      return;
      ad.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  public final boolean cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121150);
    if ((this.gbB == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(121150);
      return false;
    }
    boolean bool = this.gbB.am(paramString1, paramString2);
    AppMethodBeat.o(121150);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.jkp;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121155);
    ad.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.fDK });
    boolean bool = this.jkp;
    if (this.gbB != null) {
      this.gbB.b(new g());
    }
    this.jkp = false;
    bool = this.jkq;
    this.jkq = false;
    if ((bool) && (this.jkr)) {
      aVd();
    }
    AppMethodBeat.o(121155);
  }
  
  public final void z(Bundle paramBundle)
  {
    AppMethodBeat.i(121154);
    if (paramBundle == null)
    {
      AppMethodBeat.o(121154);
      return;
    }
    if (this.gbB != null)
    {
      y.b localb = this.gbB.aej();
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
        localb.m(str, paramBundle.get(str));
      }
    }
    AppMethodBeat.o(121154);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c
 * JD-Core Version:    0.7.0.1
 */