package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  public JSONObject lnV;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b lnW;
  public com.tencent.mm.aa.b.b.a lnX;
  public e lnY;
  public String lnZ;
  public long loa;
  public String process;
  public String viewId;
  
  public final void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b paramb, com.tencent.mm.aa.b.b.a parama, e parame, String paramString3)
  {
    AppMethodBeat.i(121369);
    this.process = paramString1;
    this.viewId = paramString2;
    this.lnV = paramJSONObject;
    this.lnW = paramb;
    this.lnX = parama;
    this.lnY = parame;
    this.lnZ = paramString3;
    this.loa = System.currentTimeMillis();
    AppMethodBeat.o(121369);
  }
  
  public final void run()
  {
    AppMethodBeat.i(121370);
    if (this.lnY.YA(this.lnZ))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.viewId);
      localBundle.putInt("drawStrategy", this.lnY.bCe());
      localBundle.putString("remoteProcess", g.axZ());
      a.dc(this.viewId, this.lnZ);
      Object localObject1;
      switch (this.lnY.bCe())
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.d.G(this.lnV);
        CollectSession localCollectSession = c.cP((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.pl(19);
        localObject2 = new hr().vt(u.Lv(this.viewId));
        ((hr)localObject2).eBS = u.Lt(this.viewId);
        ((hr)localObject2).eMi = 11L;
        localObject2 = ((hr)localObject2).vs(this.viewId);
        ((hr)localObject2).eMj = System.currentTimeMillis();
        ((hr)localObject2).vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
        if (!h.a(this.process, localBundle, a.class, new com.tencent.mm.ipcinvoker.d() {})) {
          break;
        }
        this.lnY.bCd();
        AppMethodBeat.o(121370);
        return;
        localObject1 = (String)this.lnY.d(this.lnV, this.lnZ);
        this.lnY.cB(this.lnZ);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        continue;
        localObject1 = (DrawCanvasArg)this.lnY.d(this.lnV, this.lnZ);
        this.lnY.cB(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
      }
      if (localObject1 != null) {
        ((DrawCanvasArg)localObject1).reset();
      }
      AppMethodBeat.o(121370);
      return;
    }
    if ((this.lnX != null) && (this.lnW != null)) {
      this.lnX.bt(this.lnW.a(true, "same actions with last draw, drop this", null));
    }
    AppMethodBeat.o(121370);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b
 * JD-Core Version:    0.7.0.1
 */