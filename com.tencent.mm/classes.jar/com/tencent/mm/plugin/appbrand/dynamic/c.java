package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c.e;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.b.a.do;
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
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.adm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String Lt;
  String appId;
  boolean eg;
  String fHr;
  volatile e ggh;
  f jKA;
  String jKB;
  volatile boolean jKC;
  volatile boolean jKD;
  private volatile boolean jKE;
  boolean jKF;
  boolean jKG;
  private IPCRunCgi.a jKH;
  Runnable jKI;
  int jKy;
  boolean jKz;
  Context mContext;
  String mSessionId;
  String mUrl;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(121149);
    this.jKF = false;
    this.jKG = false;
    this.mContext = paramContext;
    this.jKH = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(121141);
        ac.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        f localf = c.this.jKA;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(638L, 0L, 1L, false);
          if ((c.this.jKy == 1) && (!c.this.jKF))
          {
            v.lA(18);
            paramAnonymousString = new do().ly(u.zj(c.this.fHr));
            paramAnonymousString.dSn = u.zh(c.this.fHr);
            paramAnonymousString.dSk = 10L;
            paramAnonymousString.dSm = 2L;
            paramAnonymousString = paramAnonymousString.lx(c.this.fHr);
            paramAnonymousString.dSl = System.currentTimeMillis();
            paramAnonymousString.lz(ax.iH(ai.getContext())).aHZ();
          }
          if (localf != null) {}
          for (long l = localf.field_interval;; l = 10L)
          {
            b.j(c.this.jKI, l * 1000L);
            if ((c.this.jKA == null) || (TextUtils.isEmpty(c.this.jKA.field_data))) {
              j.bci().K(c.this.fHr, 627, 2);
            }
            AppMethodBeat.o(121141);
            return;
          }
        }
        if ((c.this.jKy == 1) && (!c.this.jKF))
        {
          c.this.jKF = true;
          v.lA(17);
          paramAnonymousString = new do().ly(u.zj(c.this.fHr));
          paramAnonymousString.dSn = u.zh(c.this.fHr);
          paramAnonymousString.dSk = 10L;
          paramAnonymousString.dSm = 1L;
          paramAnonymousString = paramAnonymousString.lx(c.this.fHr);
          paramAnonymousString.dSl = System.currentTimeMillis();
          paramAnonymousString.lz(ax.iH(ai.getContext())).aHZ();
        }
        paramAnonymousb = (adm)paramAnonymousb.hvs.hvw;
        if (paramAnonymousb.Ewb != null) {}
        for (paramAnonymousString = paramAnonymousb.Ewb.eQU(); localf == null; paramAnonymousString = "")
        {
          AppMethodBeat.o(121141);
          return;
        }
        if (!bs.isNullOrNil(paramAnonymousString)) {
          localf.field_data = paramAnonymousString;
        }
        for (;;)
        {
          localf.field_interval = paramAnonymousb.gbd;
          localf.field_updateTime = System.currentTimeMillis();
          paramAnonymousString = (Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localf.convertTo(), b.b.class);
          if (paramAnonymousString != null) {
            paramAnonymousString.getBoolean("result", false);
          }
          if (c.this.eg) {
            break;
          }
          ac.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
          AppMethodBeat.o(121141);
          return;
          if ((c.this.jKA == null) || (TextUtils.isEmpty(c.this.jKA.field_data))) {
            j.bci().K(c.this.fHr, 627, 4);
          }
        }
        c.this.a(c.this.ggh, localf);
        if ((c.this.jKy == 1) && (!c.this.jKG)) {
          c.this.jKG = true;
        }
        if (localf.field_interval > 0) {
          c.this.bcb();
        }
        AppMethodBeat.o(121141);
      }
    };
    this.jKI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121142);
        c.this.bcb();
        AppMethodBeat.o(121142);
      }
    };
    AppMethodBeat.o(121149);
  }
  
  final void a(e parame, f paramf)
  {
    boolean bool2 = false;
    AppMethodBeat.i(121153);
    if ((parame == null) || (paramf == null) || (bs.isNullOrNil(paramf.field_data)))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramf == null) {
          bool2 = true;
        }
        ac.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    paramf = i.bcg().La(paramf.field_id);
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
  
  final void bcb()
  {
    AppMethodBeat.i(121152);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.jKz)
    {
      AppMethodBeat.o(121152);
      return;
    }
    f localf = this.jKA;
    if ((localf == null) || (!this.eg))
    {
      if (localf == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.eg) });
        AppMethodBeat.o(121152);
        return;
      }
    }
    if (this.jKD)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.jKE = true;
      AppMethodBeat.o(121152);
      return;
    }
    if (bs.isNullOrNil(localf.field_appId))
    {
      ac.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.fHr });
      AppMethodBeat.o(121152);
      return;
    }
    this.jKE = false;
    long l = localf.field_updateTime + localf.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.j(this.jKI, l);
      AppMethodBeat.o(121152);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.jKA.field_id, this.jKA.field_appId });
    if ((this.jKy == 1) && (!this.jKF))
    {
      v.lA(16);
      localObject = new do().ly(u.zj(this.fHr));
      ((do)localObject).dSn = u.zh(this.fHr);
      ((do)localObject).dSk = 9L;
      localObject = ((do)localObject).lx(this.fHr);
      ((do)localObject).dSl = System.currentTimeMillis();
      ((do)localObject).lz(ax.iH(ai.getContext())).aHZ();
    }
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1193;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    adl localadl = new adl();
    localadl.djj = localf.field_appId;
    localadl.key = localf.field_cacheKey;
    localadl.scene = this.jKy;
    localadl.query = this.Lt;
    localadl.url = this.mUrl;
    ((b.a)localObject).hvt = localadl;
    ((b.a)localObject).hvu = new adm();
    IPCRunCgi.a(((b.a)localObject).aAz(), this.jKH);
    AppMethodBeat.o(121152);
  }
  
  public final boolean cF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121150);
    if ((this.ggh == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(121150);
      return false;
    }
    boolean bool = this.ggh.ap(paramString1, paramString2);
    AppMethodBeat.o(121150);
    return bool;
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(121151);
    if (this.jKA != null) {
      ac.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.jKA.field_id, this.jKA.field_appId });
    }
    for (;;)
    {
      if (this.ggh != null) {
        this.ggh.onStop();
      }
      AppMethodBeat.o(121151);
      return;
      ac.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  public final boolean isPaused()
  {
    return this.jKC;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121155);
    ac.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.fHr });
    boolean bool = this.jKC;
    if (this.ggh != null) {
      this.ggh.b(new g());
    }
    this.jKC = false;
    bool = this.jKD;
    this.jKD = false;
    if ((bool) && (this.jKE)) {
      bcb();
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
    if (this.ggh != null)
    {
      y.b localb = this.ggh.afz();
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
        localb.l(str, paramBundle.get(str));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c
 * JD-Core Version:    0.7.0.1
 */