package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mn;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
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
  public String mzg;
  public JSONObject rmi;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b rmj;
  public com.tencent.mm.ac.b.b.a rmk;
  public e rml;
  public String rmm;
  public long rmn;
  public String viewId;
  
  public final void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b paramb, com.tencent.mm.ac.b.b.a parama, e parame, String paramString3)
  {
    AppMethodBeat.i(121369);
    this.mzg = paramString1;
    this.viewId = paramString2;
    this.rmi = paramJSONObject;
    this.rmj = paramb;
    this.rmk = parama;
    this.rml = parame;
    this.rmm = paramString3;
    this.rmn = System.currentTimeMillis();
    AppMethodBeat.o(121369);
  }
  
  public final void run()
  {
    AppMethodBeat.i(121370);
    if (this.rml.Zk(this.rmm))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.viewId);
      localBundle.putInt("drawStrategy", this.rml.cnP());
      localBundle.putString("remoteProcess", i.aYs());
      a.dE(this.viewId, this.rmm);
      Object localObject1;
      switch (this.rml.cnP())
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.d.U(this.rmi);
        CollectSession localCollectSession = c.dp((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.rG(19);
        localObject2 = new mn().uY(u.KQ(this.viewId));
        ((mn)localObject2).iKD = u.KO(this.viewId);
        ((mn)localObject2).jbJ = 11L;
        localObject2 = ((mn)localObject2).uX(this.viewId);
        ((mn)localObject2).jbK = System.currentTimeMillis();
        ((mn)localObject2).uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
        if (!j.a(this.mzg, localBundle, a.class, new f() {})) {
          break;
        }
        this.rml.cnO();
        AppMethodBeat.o(121370);
        return;
        localObject1 = (String)this.rml.e(this.rmi, this.rmm);
        this.rml.dV(this.rmm);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        continue;
        localObject1 = (DrawCanvasArg)this.rml.e(this.rmi, this.rmm);
        this.rml.dV(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
      }
      if (localObject1 != null) {
        ((DrawCanvasArg)localObject1).reset();
      }
      AppMethodBeat.o(121370);
      return;
    }
    if ((this.rmk != null) && (this.rmj != null)) {
      this.rmk.cN(this.rmj.a(true, "same actions with last draw, drop this", null));
    }
    AppMethodBeat.o(121370);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b
 * JD-Core Version:    0.7.0.1
 */