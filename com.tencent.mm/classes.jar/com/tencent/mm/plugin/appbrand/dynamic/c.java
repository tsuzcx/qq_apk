package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.c.e;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.j.b.b;
import com.tencent.mm.plugin.appbrand.jsruntime.y;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String Nl;
  String appId;
  boolean ga;
  String gaR;
  volatile e gzR;
  int keK;
  boolean keL;
  f keM;
  String keN;
  volatile boolean keO;
  volatile boolean keP;
  private volatile boolean keQ;
  boolean keR;
  boolean keS;
  private IPCRunCgi.a keT;
  Runnable keU;
  Context mContext;
  String mSessionId;
  String mUrl;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(121149);
    this.keR = false;
    this.keS = false;
    this.mContext = paramContext;
    this.keT = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(121141);
        ad.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        f localf = c.this.keM;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(638L, 0L, 1L, false);
          if ((c.this.keK == 1) && (!c.this.keR))
          {
            v.ma(18);
            paramAnonymousString = new ej().nF(u.Ci(c.this.gaR));
            paramAnonymousString.ehS = u.Cg(c.this.gaR);
            paramAnonymousString.ehP = 10L;
            paramAnonymousString.ehR = 2L;
            paramAnonymousString = paramAnonymousString.nE(c.this.gaR);
            paramAnonymousString.ehQ = System.currentTimeMillis();
            paramAnonymousString.nG(ay.iR(aj.getContext())).aLk();
          }
          if (localf != null) {}
          for (long l = localf.field_interval;; l = 10L)
          {
            b.k(c.this.keU, l * 1000L);
            if ((c.this.keM == null) || (TextUtils.isEmpty(c.this.keM.field_data))) {
              j.bfM().M(c.this.gaR, 627, 2);
            }
            AppMethodBeat.o(121141);
            return;
          }
        }
        if ((c.this.keK == 1) && (!c.this.keR))
        {
          c.this.keR = true;
          v.ma(17);
          paramAnonymousString = new ej().nF(u.Ci(c.this.gaR));
          paramAnonymousString.ehS = u.Cg(c.this.gaR);
          paramAnonymousString.ehP = 10L;
          paramAnonymousString.ehR = 1L;
          paramAnonymousString = paramAnonymousString.nE(c.this.gaR);
          paramAnonymousString.ehQ = System.currentTimeMillis();
          paramAnonymousString.nG(ay.iR(aj.getContext())).aLk();
        }
        paramAnonymousb = (afn)paramAnonymousb.hNL.hNQ;
        if (paramAnonymousb.Gdx != null) {}
        for (paramAnonymousString = paramAnonymousb.Gdx.ffY(); localf == null; paramAnonymousString = "")
        {
          AppMethodBeat.o(121141);
          return;
        }
        if (!bt.isNullOrNil(paramAnonymousString)) {
          localf.field_data = paramAnonymousString;
        }
        for (;;)
        {
          localf.field_interval = paramAnonymousb.guN;
          localf.field_updateTime = System.currentTimeMillis();
          paramAnonymousString = (Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localf.convertTo(), b.b.class);
          if (paramAnonymousString != null) {
            paramAnonymousString.getBoolean("result", false);
          }
          if (c.this.ga) {
            break;
          }
          ad.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
          AppMethodBeat.o(121141);
          return;
          if ((c.this.keM == null) || (TextUtils.isEmpty(c.this.keM.field_data))) {
            j.bfM().M(c.this.gaR, 627, 4);
          }
        }
        c.this.a(c.this.gzR, localf);
        if ((c.this.keK == 1) && (!c.this.keS)) {
          c.this.keS = true;
        }
        if (localf.field_interval > 0) {
          c.this.bfF();
        }
        AppMethodBeat.o(121141);
      }
    };
    this.keU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121142);
        c.this.bfF();
        AppMethodBeat.o(121142);
      }
    };
    AppMethodBeat.o(121149);
  }
  
  public final void A(Bundle paramBundle)
  {
    AppMethodBeat.i(121154);
    if (paramBundle == null)
    {
      AppMethodBeat.o(121154);
      return;
    }
    if (this.gzR != null)
    {
      y.b localb = this.gzR.ail();
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
    paramf = i.bfK().Ou(paramf.field_id);
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
  
  final void bfF()
  {
    AppMethodBeat.i(121152);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.keL)
    {
      AppMethodBeat.o(121152);
      return;
    }
    f localf = this.keM;
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
    if (this.keP)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.keQ = true;
      AppMethodBeat.o(121152);
      return;
    }
    if (bt.isNullOrNil(localf.field_appId))
    {
      ad.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.gaR });
      AppMethodBeat.o(121152);
      return;
    }
    this.keQ = false;
    long l = localf.field_updateTime + localf.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.k(this.keU, l);
      AppMethodBeat.o(121152);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.keM.field_id, this.keM.field_appId });
    if ((this.keK == 1) && (!this.keR))
    {
      v.ma(16);
      localObject = new ej().nF(u.Ci(this.gaR));
      ((ej)localObject).ehS = u.Cg(this.gaR);
      ((ej)localObject).ehP = 9L;
      localObject = ((ej)localObject).nE(this.gaR);
      ((ej)localObject).ehQ = System.currentTimeMillis();
      ((ej)localObject).nG(ay.iR(aj.getContext())).aLk();
    }
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1193;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    afm localafm = new afm();
    localafm.duW = localf.field_appId;
    localafm.key = localf.field_cacheKey;
    localafm.scene = this.keK;
    localafm.query = this.Nl;
    localafm.url = this.mUrl;
    ((b.a)localObject).hNM = localafm;
    ((b.a)localObject).hNN = new afn();
    IPCRunCgi.a(((b.a)localObject).aDC(), this.keT);
    AppMethodBeat.o(121152);
  }
  
  public final boolean cH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121150);
    if ((this.gzR == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(121150);
      return false;
    }
    boolean bool = this.gzR.aq(paramString1, paramString2);
    AppMethodBeat.o(121150);
    return bool;
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(121151);
    if (this.keM != null) {
      ad.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.keM.field_id, this.keM.field_appId });
    }
    for (;;)
    {
      if (this.gzR != null) {
        this.gzR.onStop();
      }
      AppMethodBeat.o(121151);
      return;
      ad.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  public final boolean isPaused()
  {
    return this.keO;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121155);
    ad.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.gaR });
    boolean bool = this.keO;
    if (this.gzR != null) {
      this.gzR.b(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
    }
    this.keO = false;
    bool = this.keP;
    this.keP = false;
    if ((bool) && (this.keQ)) {
      bfF();
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