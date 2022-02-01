package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  public String dyy;
  public JSONObject jML;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b jMM;
  public com.tencent.mm.aa.b.b.a jMN;
  public e jMO;
  public String jMP;
  public long jMQ;
  public String process;
  
  public final void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b paramb, com.tencent.mm.aa.b.b.a parama, e parame, String paramString3)
  {
    AppMethodBeat.i(121369);
    this.process = paramString1;
    this.dyy = paramString2;
    this.jML = paramJSONObject;
    this.jMM = paramb;
    this.jMN = parama;
    this.jMO = parame;
    this.jMP = paramString3;
    this.jMQ = System.currentTimeMillis();
    AppMethodBeat.o(121369);
  }
  
  public final void run()
  {
    AppMethodBeat.i(121370);
    if (this.jMO.Ln(this.jMP))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.dyy);
      localBundle.putInt("drawStrategy", this.jMO.bcz());
      localBundle.putString("remoteProcess", g.aeL());
      a.cJ(this.dyy, this.jMP);
      Object localObject1;
      switch (this.jMO.bcz())
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.d.z(this.jML);
        CollectSession localCollectSession = c.cx((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.lA(19);
        localObject2 = new do().ly(u.zj(this.dyy));
        ((do)localObject2).dSn = u.zh(this.dyy);
        ((do)localObject2).dSk = 11L;
        localObject2 = ((do)localObject2).lx(this.dyy);
        ((do)localObject2).dSl = System.currentTimeMillis();
        ((do)localObject2).lz(ax.iH(ai.getContext())).aHZ();
        if (!h.a(this.process, localBundle, a.class, new com.tencent.mm.ipcinvoker.d() {})) {
          break;
        }
        this.jMO.bcy();
        AppMethodBeat.o(121370);
        return;
        localObject1 = (String)this.jMO.c(this.jML, this.jMP);
        this.jMO.cp(this.jMP);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        continue;
        localObject1 = (DrawCanvasArg)this.jMO.c(this.jML, this.jMP);
        this.jMO.cp(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
      }
      if (localObject1 != null) {
        ((DrawCanvasArg)localObject1).reset();
      }
      AppMethodBeat.o(121370);
      return;
    }
    if ((this.jMN != null) && (this.jMM != null)) {
      this.jMN.bi(this.jMM.a(true, "same actions with last draw, drop this", null));
    }
    AppMethodBeat.o(121370);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b
 * JD-Core Version:    0.7.0.1
 */