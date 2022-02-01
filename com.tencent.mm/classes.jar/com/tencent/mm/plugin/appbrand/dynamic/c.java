package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.b.a.hr;
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
import com.tencent.mm.plugin.appbrand.m.z;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String Nv;
  String appId;
  String gIx;
  boolean gc;
  String hes;
  volatile com.tencent.mm.aa.c.e hpm;
  int llJ;
  boolean llK;
  com.tencent.mm.plugin.appbrand.widget.e llL;
  volatile boolean llM;
  volatile boolean llN;
  private volatile boolean llO;
  boolean llP;
  boolean llQ;
  private IPCRunCgi.a llR;
  Runnable llS;
  Context mContext;
  String mSessionId;
  String mUrl;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(121149);
    this.llP = false;
    this.llQ = false;
    this.mContext = paramContext;
    this.llR = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(121141);
        Log.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        u.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        com.tencent.mm.plugin.appbrand.widget.e locale = c.this.llL;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(638L, 0L, 1L, false);
          if ((c.this.llJ == 1) && (!c.this.llP))
          {
            v.pl(18);
            paramAnonymousString = new hr().vt(u.Lv(c.this.gIx));
            paramAnonymousString.eBS = u.Lt(c.this.gIx);
            paramAnonymousString.eMi = 10L;
            paramAnonymousString.eMk = 2L;
            paramAnonymousString = paramAnonymousString.vs(c.this.gIx);
            paramAnonymousString.eMj = System.currentTimeMillis();
            paramAnonymousString.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
          }
          if (locale != null) {}
          for (long l = locale.field_interval;; l = 10L)
          {
            b.j(c.this.llS, l * 1000L);
            if ((c.this.llL == null) || (TextUtils.isEmpty(c.this.llL.field_data))) {
              j.bBN().P(c.this.gIx, 627, 2);
            }
            AppMethodBeat.o(121141);
            return;
          }
        }
        if ((c.this.llJ == 1) && (!c.this.llP))
        {
          c.this.llP = true;
          v.pl(17);
          paramAnonymousString = new hr().vt(u.Lv(c.this.gIx));
          paramAnonymousString.eBS = u.Lt(c.this.gIx);
          paramAnonymousString.eMi = 10L;
          paramAnonymousString.eMk = 1L;
          paramAnonymousString = paramAnonymousString.vs(c.this.gIx);
          paramAnonymousString.eMj = System.currentTimeMillis();
          paramAnonymousString.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
        }
        paramAnonymousd = (aid)paramAnonymousd.iLL.iLR;
        if (paramAnonymousd.LrK != null) {}
        for (paramAnonymousString = paramAnonymousd.LrK.yO(); locale == null; paramAnonymousString = "")
        {
          AppMethodBeat.o(121141);
          return;
        }
        if (!Util.isNullOrNil(paramAnonymousString)) {
          locale.field_data = paramAnonymousString;
        }
        for (;;)
        {
          locale.field_interval = paramAnonymousd.gTn;
          locale.field_updateTime = System.currentTimeMillis();
          paramAnonymousString = (Bundle)com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, locale.convertTo(), b.b.class);
          if (paramAnonymousString != null) {
            paramAnonymousString.getBoolean("result", false);
          }
          if (c.this.gc) {
            break;
          }
          Log.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
          AppMethodBeat.o(121141);
          return;
          if ((c.this.llL == null) || (TextUtils.isEmpty(c.this.llL.field_data))) {
            j.bBN().P(c.this.gIx, 627, 4);
          }
        }
        c.this.a(c.this.hpm, locale);
        if ((c.this.llJ == 1) && (!c.this.llQ)) {
          c.this.llQ = true;
        }
        if (locale.field_interval > 0) {
          c.this.bBG();
        }
        AppMethodBeat.o(121141);
      }
    };
    this.llS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121142);
        c.this.bBG();
        AppMethodBeat.o(121142);
      }
    };
    AppMethodBeat.o(121149);
  }
  
  public final void H(Bundle paramBundle)
  {
    AppMethodBeat.i(121154);
    if (paramBundle == null)
    {
      AppMethodBeat.o(121154);
      return;
    }
    if (this.hpm != null)
    {
      ad.b localb = this.hpm.ayQ();
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
  
  final void a(com.tencent.mm.aa.c.e parame, com.tencent.mm.plugin.appbrand.widget.e parame1)
  {
    boolean bool2 = false;
    AppMethodBeat.i(121153);
    if ((parame == null) || (parame1 == null) || (Util.isNullOrNil(parame1.field_data)))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (parame1 == null) {
          bool2 = true;
        }
        Log.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(121153);
        return;
      }
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", new Object[] { parame1.field_id });
    com.tencent.mm.plugin.appbrand.dynamic.f.c localc = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
    localc.data = parame1.field_data;
    parame.a(localc, new ValueCallback() {});
    parame = new Bundle();
    parame.putString("widgetId", parame1.field_id);
    parame.putString("respData", parame1.field_data);
    parame1 = i.bBL().Yn(parame1.field_id);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", new Object[] { parame1 });
    if (parame1 == null)
    {
      ToolsProcessIPCService.a(parame, a.class);
      AppMethodBeat.o(121153);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a(parame1, parame, a.class, null);
    AppMethodBeat.o(121153);
  }
  
  final void bBG()
  {
    AppMethodBeat.i(121152);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.llK)
    {
      AppMethodBeat.o(121152);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.e locale = this.llL;
    if ((locale == null) || (!this.gc))
    {
      if (locale == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.gc) });
        AppMethodBeat.o(121152);
        return;
      }
    }
    if (this.llN)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.llO = true;
      AppMethodBeat.o(121152);
      return;
    }
    if (Util.isNullOrNil(locale.field_appId))
    {
      Log.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.gIx });
      AppMethodBeat.o(121152);
      return;
    }
    this.llO = false;
    long l = locale.field_updateTime + locale.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.j(this.llS, l);
      AppMethodBeat.o(121152);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.llL.field_id, this.llL.field_appId });
    if ((this.llJ == 1) && (!this.llP))
    {
      v.pl(16);
      localObject = new hr().vt(u.Lv(this.gIx));
      ((hr)localObject).eBS = u.Lt(this.gIx);
      ((hr)localObject).eMi = 9L;
      localObject = ((hr)localObject).vs(this.gIx);
      ((hr)localObject).eMj = System.currentTimeMillis();
      ((hr)localObject).vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
    }
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 1193;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    aic localaic = new aic();
    localaic.dNI = locale.field_appId;
    localaic.key = locale.field_cacheKey;
    localaic.scene = this.llJ;
    localaic.query = this.Nv;
    localaic.url = this.mUrl;
    ((d.a)localObject).iLN = localaic;
    ((d.a)localObject).iLO = new aid();
    IPCRunCgi.a(((d.a)localObject).aXF(), this.llR);
    AppMethodBeat.o(121152);
  }
  
  public final boolean cY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121150);
    if ((this.hpm == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(121150);
      return false;
    }
    boolean bool = this.hpm.at(paramString1, paramString2);
    AppMethodBeat.o(121150);
    return bool;
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(121151);
    if (this.llL != null) {
      Log.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.llL.field_id, this.llL.field_appId });
    }
    for (;;)
    {
      if (this.hpm != null) {
        this.hpm.onStop();
      }
      AppMethodBeat.o(121151);
      return;
      Log.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  public final boolean isPaused()
  {
    return this.llM;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121155);
    Log.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.gIx });
    boolean bool = this.llM;
    if (this.hpm != null) {
      this.hpm.b(new g());
    }
    this.llM = false;
    bool = this.llN;
    this.llN = false;
    if ((bool) && (this.llO)) {
      bBG();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c
 * JD-Core Version:    0.7.0.1
 */