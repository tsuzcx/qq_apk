package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  public String hpq;
  public JSONObject hpr;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b hps;
  public com.tencent.mm.z.b.b.a hpt;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e hpu;
  public String hpv;
  public long hpw;
  public String process;
  
  public final void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b paramb, com.tencent.mm.z.b.b.a parama, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e parame, String paramString3)
  {
    AppMethodBeat.i(10889);
    this.process = paramString1;
    this.hpq = paramString2;
    this.hpr = paramJSONObject;
    this.hps = paramb;
    this.hpt = parama;
    this.hpu = parame;
    this.hpv = paramString3;
    this.hpw = System.currentTimeMillis();
    AppMethodBeat.o(10889);
  }
  
  public final void run()
  {
    AppMethodBeat.i(10890);
    if (this.hpu.Bl(this.hpv))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.hpq);
      localBundle.putInt("drawStrategy", this.hpu.azU());
      localBundle.putString("remoteProcess", com.tencent.mm.ipcinvoker.e.PM());
      a.bQ(this.hpq, this.hpv);
      Object localObject1;
      switch (this.hpu.azU())
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = d.u(this.hpr);
        CollectSession localCollectSession = c.bH((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.kS(19);
        localObject2 = new af().fB(u.qn(this.hpq));
        ((af)localObject2).cUl = u.qm(this.hpq);
        ((af)localObject2).cUh = 11L;
        localObject2 = ((af)localObject2).fA(this.hpq);
        ((af)localObject2).cUi = System.currentTimeMillis();
        ((af)localObject2).fC(at.gU(ah.getContext())).ake();
        if (!f.a(this.process, localBundle, a.class, new b.1(this, (DrawCanvasArg)localObject1))) {
          break;
        }
        this.hpu.azT();
        AppMethodBeat.o(10890);
        return;
        localObject1 = (String)this.hpu.d(this.hpr, this.hpv);
        this.hpu.bh(this.hpv);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        continue;
        localObject1 = (DrawCanvasArg)this.hpu.d(this.hpr, this.hpv);
        this.hpu.bh(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
      }
      if (localObject1 != null) {
        ((DrawCanvasArg)localObject1).reset();
      }
      AppMethodBeat.o(10890);
      return;
    }
    if ((this.hpt != null) && (this.hps != null)) {
      this.hpt.aj(this.hps.a(true, "same actions with last draw, drop this", null));
    }
    AppMethodBeat.o(10890);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b
 * JD-Core Version:    0.7.0.1
 */