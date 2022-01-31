package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.f.g;
import com.tencent.mm.plugin.appbrand.i.w;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.c.e;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.appbrand.canvas.widget.b
{
  String DK;
  boolean ajS;
  String appId;
  volatile e eGt;
  String equ;
  int hnd;
  boolean hne;
  com.tencent.mm.plugin.appbrand.widget.f hnf;
  String hng;
  volatile boolean hnh;
  volatile boolean hni;
  private volatile boolean hnj;
  boolean hnk;
  boolean hnl;
  private com.tencent.mm.ipcinvoker.wx_extension.b.a hnm;
  Runnable hnn;
  Context mContext;
  String mSessionId;
  String mUrl;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(10668);
    this.hnk = false;
    this.hnl = false;
    this.mContext = paramContext;
    this.hnm = new c.1(this);
    this.hnn = new c.2(this);
    AppMethodBeat.o(10668);
  }
  
  final void a(e parame, com.tencent.mm.plugin.appbrand.widget.f paramf)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10672);
    if ((parame == null) || (paramf == null) || (bo.isNullOrNil(paramf.field_data)))
    {
      if (parame == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramf == null) {
          bool2 = true;
        }
        ab.i("MicroMsg.DynamicPageViewIPCProxy", "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(10672);
        return;
      }
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", new Object[] { paramf.field_id });
    com.tencent.mm.plugin.appbrand.dynamic.f.c localc = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
    localc.data = paramf.field_data;
    parame.a(localc, new c.6(this));
    parame = new Bundle();
    parame.putString("widgetId", paramf.field_id);
    parame.putString("respData", paramf.field_data);
    paramf = i.azB().AY(paramf.field_id);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch onDataPush event to view proce %s", new Object[] { paramf });
    if (paramf == null)
    {
      ToolsProcessIPCService.b(parame, c.a.class);
      AppMethodBeat.o(10672);
      return;
    }
    com.tencent.mm.ipcinvoker.f.a(paramf, parame, c.a.class, null);
    AppMethodBeat.o(10672);
  }
  
  final void azw()
  {
    AppMethodBeat.i(10671);
    u.i("MicroMsg.DynamicPageViewIPCProxy", "try to refresh", new Object[0]);
    if (this.hne)
    {
      AppMethodBeat.o(10671);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.f localf = this.hnf;
    if ((localf == null) || (!this.ajS))
    {
      if (localf == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.i("MicroMsg.DynamicPageViewIPCProxy", "cacheData %b, mRunning %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.ajS) });
        AppMethodBeat.o(10671);
        return;
      }
    }
    if (this.hni)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "paused", new Object[0]);
      this.hnj = true;
      AppMethodBeat.o(10671);
      return;
    }
    if (bo.isNullOrNil(localf.field_appId))
    {
      ab.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[] { this.equ });
      AppMethodBeat.o(10671);
      return;
    }
    this.hnj = false;
    long l = localf.field_updateTime + localf.field_interval * 1000L - System.currentTimeMillis();
    if (l > 0L)
    {
      u.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[] { Long.valueOf(l) });
      b.l(this.hnn, l);
      AppMethodBeat.o(10671);
      return;
    }
    u.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s)", new Object[] { this.hnf.field_id, this.hnf.field_appId });
    if ((this.hnd == 1) && (!this.hnk))
    {
      v.kS(16);
      localObject = new af().fB(u.qn(this.equ));
      ((af)localObject).cUl = u.qm(this.equ);
      ((af)localObject).cUh = 9L;
      localObject = ((af)localObject).fA(this.equ);
      ((af)localObject).cUi = System.currentTimeMillis();
      ((af)localObject).fC(at.gU(ah.getContext())).ake();
    }
    Object localObject = new com.tencent.mm.ai.b.a();
    ((com.tencent.mm.ai.b.a)localObject).funcId = 1193;
    ((com.tencent.mm.ai.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
    za localza = new za();
    localza.cwc = localf.field_appId;
    localza.key = localf.field_cacheKey;
    localza.scene = this.hnd;
    localza.query = this.DK;
    localza.url = this.mUrl;
    ((com.tencent.mm.ai.b.a)localObject).fsX = localza;
    ((com.tencent.mm.ai.b.a)localObject).fsY = new zb();
    com.tencent.mm.ipcinvoker.wx_extension.b.a(((com.tencent.mm.ai.b.a)localObject).ado(), this.hnm);
    AppMethodBeat.o(10671);
  }
  
  public final boolean bM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10669);
    if ((this.eGt == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(10669);
      return false;
    }
    boolean bool = this.eGt.V(paramString1, paramString2);
    AppMethodBeat.o(10669);
    return bool;
  }
  
  final void cleanup()
  {
    AppMethodBeat.i(10670);
    if (this.hnf != null) {
      ab.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s)", new Object[] { this.hnf.field_id, this.hnf.field_appId });
    }
    for (;;)
    {
      if (this.eGt != null) {
        this.eGt.onStop();
      }
      AppMethodBeat.o(10670);
      return;
      ab.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
    }
  }
  
  public final boolean isPaused()
  {
    return this.hnh;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(10674);
    ab.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[] { this.equ });
    boolean bool = this.hnh;
    if (this.eGt != null) {
      this.eGt.b(new g());
    }
    this.hnh = false;
    bool = this.hni;
    this.hni = false;
    if ((bool) && (this.hnj)) {
      azw();
    }
    AppMethodBeat.o(10674);
  }
  
  public final void v(Bundle paramBundle)
  {
    AppMethodBeat.i(10673);
    if (paramBundle == null)
    {
      AppMethodBeat.o(10673);
      return;
    }
    if (this.eGt != null)
    {
      v.b localb = this.eGt.Qx();
      if (localb == null)
      {
        AppMethodBeat.o(10673);
        return;
      }
      Object localObject = paramBundle.keySet();
      if ((localObject == null) || (localb == null))
      {
        AppMethodBeat.o(10673);
        return;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localb.i(str, paramBundle.get(str));
      }
    }
    AppMethodBeat.o(10673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.c
 * JD-Core Version:    0.7.0.1
 */