package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
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
  public String dAM;
  public com.tencent.mm.ab.b.b.a jmA;
  public e jmB;
  public String jmC;
  public long jmD;
  public JSONObject jmy;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b jmz;
  public String process;
  
  public final void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b paramb, com.tencent.mm.ab.b.b.a parama, e parame, String paramString3)
  {
    AppMethodBeat.i(121369);
    this.process = paramString1;
    this.dAM = paramString2;
    this.jmy = paramJSONObject;
    this.jmz = paramb;
    this.jmA = parama;
    this.jmB = parame;
    this.jmC = paramString3;
    this.jmD = System.currentTimeMillis();
    AppMethodBeat.o(121369);
  }
  
  public final void run()
  {
    AppMethodBeat.i(121370);
    if (this.jmB.Hj(this.jmC))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.dAM);
      localBundle.putInt("drawStrategy", this.jmB.aVB());
      localBundle.putString("remoteProcess", g.adv());
      a.cz(this.dAM, this.jmC);
      Object localObject1;
      switch (this.jmB.aVB())
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.d.z(this.jmy);
        CollectSession localCollectSession = c.cn((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.lI(19);
        localObject2 = new ca().iI(u.vd(this.dAM));
        ((ca)localObject2).dQy = u.vb(this.dAM);
        ((ca)localObject2).dQv = 11L;
        localObject2 = ((ca)localObject2).iH(this.dAM);
        ((ca)localObject2).dQw = System.currentTimeMillis();
        ((ca)localObject2).iJ(ay.iw(aj.getContext())).aBj();
        if (!h.a(this.process, localBundle, a.class, new com.tencent.mm.ipcinvoker.d() {})) {
          break;
        }
        this.jmB.aVA();
        AppMethodBeat.o(121370);
        return;
        localObject1 = (String)this.jmB.c(this.jmy, this.jmC);
        this.jmB.cr(this.jmC);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        continue;
        localObject1 = (DrawCanvasArg)this.jmB.c(this.jmy, this.jmC);
        this.jmB.cr(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
      }
      if (localObject1 != null) {
        ((DrawCanvasArg)localObject1).reset();
      }
      AppMethodBeat.o(121370);
      return;
    }
    if ((this.jmA != null) && (this.jmz != null)) {
      this.jmA.bl(this.jmz.a(true, "same actions with last draw, drop this", null));
    }
    AppMethodBeat.o(121370);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b
 * JD-Core Version:    0.7.0.1
 */