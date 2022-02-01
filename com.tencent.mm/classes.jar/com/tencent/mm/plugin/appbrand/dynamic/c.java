package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c.e;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.mmdata.rpt.mn;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.f.g;
import com.tencent.mm.plugin.appbrand.dynamic.j.b.b;
import com.tencent.mm.plugin.appbrand.n.z;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String appId;
  String brD;
  boolean bzr;
  String lWh;
  volatile e mBi;
  Context mContext;
  String mSessionId;
  String mUrl;
  String mpa;
  int rjZ;
  boolean rka;
  com.tencent.mm.plugin.appbrand.widget.h rkb;
  volatile boolean rkc;
  volatile boolean rkd;
  private volatile boolean rke;
  boolean rkf;
  boolean rkg;
  private IPCRunCgi.a rkh;
  Runnable rki;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(121149);
    this.rkf = false;
    this.rkg = false;
    this.mContext = paramContext;
    this.rkh = new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(121141);
        Log.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        com.tencent.mm.plugin.appbrand.widget.h localh = c.this.rkb;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(638L, 0L, 1L, false);
          if ((c.this.rjZ == 1) && (!c.this.rkf))
          {
            v.rG(18);
            paramAnonymousString = new mn().uY(u.KQ(c.this.lWh));
            paramAnonymousString.iKD = u.KO(c.this.lWh);
            paramAnonymousString.jbJ = 10L;
            paramAnonymousString.jbL = 2L;
            paramAnonymousString = paramAnonymousString.uX(c.this.lWh);
            paramAnonymousString.jbK = System.currentTimeMillis();
            paramAnonymousString.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
          }
          if (localh != null) {}
          for (long l = localh.field_interval;; l = 10L)
          {
            b.j(c.this.rki, l * 1000L);
            if ((c.this.rkb == null) || (TextUtils.isEmpty(c.this.rkb.field_data))) {
              j.cny().T(c.this.lWh, 627, 2);
            }
            AppMethodBeat.o(121141);
            return;
          }
        }
        if ((c.this.rjZ == 1) && (!c.this.rkf))
        {
          c.this.rkf = true;
          v.rG(17);
          paramAnonymousString = new mn().uY(u.KQ(c.this.lWh));
          paramAnonymousString.iKD = u.KO(c.this.lWh);
          paramAnonymousString.jbJ = 10L;
          paramAnonymousString.jbL = 1L;
          paramAnonymousString = paramAnonymousString.uX(c.this.lWh);
          paramAnonymousString.jbK = System.currentTimeMillis();
          paramAnonymousString.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
        }
        paramAnonymousc = (ali)c.c.b(paramAnonymousc.otC);
        if (paramAnonymousc.Zsu != null) {}
        for (paramAnonymousString = paramAnonymousc.Zsu.ZV(); localh == null; paramAnonymousString = "")
        {
          AppMethodBeat.o(121141);
          return;
        }
        if (!Util.isNullOrNil(paramAnonymousString)) {
          localh.field_data = paramAnonymousString;
        }
        for (;;)
        {
          localh.field_interval = paramAnonymousc.interval;
          localh.field_updateTime = System.currentTimeMillis();
          paramAnonymousString = (Bundle)com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, localh.convertTo(), b.b.class);
          if (paramAnonymousString != null) {
            paramAnonymousString.getBoolean("result", false);
          }
          if (c.this.bzr) {
            break;
          }
          Log.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
          AppMethodBeat.o(121141);
          return;
          if ((c.this.rkb == null) || (TextUtils.isEmpty(c.this.rkb.field_data))) {
            j.cny().T(c.this.lWh, 627, 4);
          }
        }
        c.this.a(c.this.mBi, localh);
        if ((c.this.rjZ == 1) && (!c.this.rkg)) {
          c.this.rkg = true;
        }
        if (localh.field_interval > 0) {
          c.this.cnr();
        }
        AppMethodBeat.o(121141);
      }
    };
    this.rki = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121142);
        c.this.cnr();
        AppMethodBeat.o(121142);
      }
    };
    AppMethodBeat.o(121149);
  }
  
  public final void X(Bundle paramBundle)
  {
    AppMethodBeat.i(121154);
    if (paramBundle == null)
    {
      AppMethodBeat.o(121154);
      return;
    }
    if (this.mBi != null)
    {
      ad.b localb = this.mBi.aZk();
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
        localb.q(str, paramBundle.get(str));
      }
    }
    AppMethodBeat.o(121154);
  }
  
  final void a(e parame, com.tencent.mm.plugin.appbrand.widget.h paramh)
  {
    boolean bool2 = false;
    AppMethodBeat.i(121153);
    if ((parame == null) || (paramh == null) || (Util.isNullOrNil(paramh.field_data)))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramh == null) {
          bool2 = true;
        }
        Log.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(121153);
        return;
      }
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", new Object[] { paramh.field_id });
    com.tencent.mm.plugin.appbrand.dynamic.f.c localc = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
    localc.data = paramh.field_data;
    parame.a(localc, new ValueCallback() {});
    parame = new Bundle();
    parame.putString("widgetId", paramh.field_id);
    parame.putString("respData", paramh.field_data);
    paramh = i.cnw().YX(paramh.field_id);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", new Object[] { paramh });
    if (paramh == null)
    {
      ToolsProcessIPCService.a(parame, a.class);
      AppMethodBeat.o(121153);
      return;
    }
    com.tencent.mm.ipcinvoker.j.a(paramh, parame, a.class, null);
    AppMethodBeat.o(121153);
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(121151);
    if (this.rkb != null) {
      Log.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.rkb.field_id, this.rkb.field_appId });
    }
    for (;;)
    {
      if (this.mBi != null) {
        this.mBi.onStop();
      }
      AppMethodBeat.o(121151);
      return;
      Log.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  final void cnr()
  {
    AppMethodBeat.i(121152);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.rka)
    {
      AppMethodBeat.o(121152);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.h localh = this.rkb;
    if ((localh == null) || (!this.bzr))
    {
      if (localh == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.bzr) });
        AppMethodBeat.o(121152);
        return;
      }
    }
    if (this.rkd)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.rke = true;
      AppMethodBeat.o(121152);
      return;
    }
    if (Util.isNullOrNil(localh.field_appId))
    {
      Log.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.lWh });
      AppMethodBeat.o(121152);
      return;
    }
    this.rke = false;
    long l = localh.field_updateTime + localh.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.j(this.rki, l);
      AppMethodBeat.o(121152);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.rkb.field_id, this.rkb.field_appId });
    if ((this.rjZ == 1) && (!this.rkf))
    {
      v.rG(16);
      localObject = new mn().uY(u.KQ(this.lWh));
      ((mn)localObject).iKD = u.KO(this.lWh);
      ((mn)localObject).jbJ = 9L;
      localObject = ((mn)localObject).uX(this.lWh);
      ((mn)localObject).jbK = System.currentTimeMillis();
      ((mn)localObject).uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
    }
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).funcId = 1193;
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    alh localalh = new alh();
    localalh.appid = localh.field_appId;
    localalh.key = localh.field_cacheKey;
    localalh.scene = this.rjZ;
    localalh.query = this.brD;
    localalh.url = this.mUrl;
    ((com.tencent.mm.am.c.a)localObject).otE = localalh;
    ((com.tencent.mm.am.c.a)localObject).otF = new ali();
    IPCRunCgi.a(((com.tencent.mm.am.c.a)localObject).bEF(), this.rkh);
    AppMethodBeat.o(121152);
  }
  
  public final boolean dA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121150);
    if ((this.mBi == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(121150);
      return false;
    }
    boolean bool = this.mBi.aF(paramString1, paramString2);
    AppMethodBeat.o(121150);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.rkc;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121155);
    Log.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.lWh });
    boolean bool = this.rkc;
    if (this.mBi != null) {
      this.mBi.b(new g());
    }
    this.rkc = false;
    bool = this.rkd;
    this.rkd = false;
    if ((bool) && (this.rke)) {
      cnr();
    }
    AppMethodBeat.o(121155);
  }
  
  static class a
    implements d<Bundle, Bundle>
  {}
  
  static class b
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c
 * JD-Core Version:    0.7.0.1
 */