package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  public String aQj;
  public JSONObject kgW;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b kgX;
  public com.tencent.mm.ab.b.b.a kgY;
  public e kgZ;
  public String kha;
  public long khb;
  public String process;
  
  public final void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b paramb, com.tencent.mm.ab.b.b.a parama, e parame, String paramString3)
  {
    AppMethodBeat.i(121369);
    this.process = paramString1;
    this.aQj = paramString2;
    this.kgW = paramJSONObject;
    this.kgX = paramb;
    this.kgY = parama;
    this.kgZ = parame;
    this.kha = paramString3;
    this.khb = System.currentTimeMillis();
    AppMethodBeat.o(121369);
  }
  
  public final void run()
  {
    AppMethodBeat.i(121370);
    if (this.kgZ.OH(this.kha))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.aQj);
      localBundle.putInt("drawStrategy", this.kgZ.bgd());
      localBundle.putString("remoteProcess", g.ahx());
      a.cL(this.aQj, this.kha);
      Object localObject1;
      switch (this.kgZ.bgd())
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.d.z(this.kgW);
        CollectSession localCollectSession = c.cz((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.ma(19);
        localObject2 = new ej().nF(u.Ci(this.aQj));
        ((ej)localObject2).ehS = u.Cg(this.aQj);
        ((ej)localObject2).ehP = 11L;
        localObject2 = ((ej)localObject2).nE(this.aQj);
        ((ej)localObject2).ehQ = System.currentTimeMillis();
        ((ej)localObject2).nG(ay.iR(aj.getContext())).aLk();
        if (!h.a(this.process, localBundle, a.class, new com.tencent.mm.ipcinvoker.d() {})) {
          break;
        }
        this.kgZ.bgc();
        AppMethodBeat.o(121370);
        return;
        localObject1 = (String)this.kgZ.c(this.kgW, this.kha);
        this.kgZ.cr(this.kha);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        continue;
        localObject1 = (DrawCanvasArg)this.kgZ.c(this.kgW, this.kha);
        this.kgZ.cr(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
      }
      if (localObject1 != null) {
        ((DrawCanvasArg)localObject1).reset();
      }
      AppMethodBeat.o(121370);
      return;
    }
    if ((this.kgY != null) && (this.kgX != null)) {
      this.kgY.bk(this.kgX.a(true, "same actions with last draw, drop this", null));
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