package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.jw;
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
  public String jZi;
  public JSONObject oiG;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b oiH;
  public com.tencent.mm.ac.b.b.a oiI;
  public e oiJ;
  public String oiK;
  public long oiL;
  public String viewId;
  
  public final void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b paramb, com.tencent.mm.ac.b.b.a parama, e parame, String paramString3)
  {
    AppMethodBeat.i(121369);
    this.jZi = paramString1;
    this.viewId = paramString2;
    this.oiG = paramJSONObject;
    this.oiH = paramb;
    this.oiI = parama;
    this.oiJ = parame;
    this.oiK = paramString3;
    this.oiL = System.currentTimeMillis();
    AppMethodBeat.o(121369);
  }
  
  public final void run()
  {
    AppMethodBeat.i(121370);
    if (this.oiJ.ago(this.oiK))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.viewId);
      localBundle.putInt("drawStrategy", this.oiJ.bNA());
      localBundle.putString("remoteProcess", i.aFr());
      a.dl(this.viewId, this.oiK);
      Object localObject1;
      switch (this.oiJ.bNA())
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.d.J(this.oiG);
        CollectSession localCollectSession = c.cY((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.rE(19);
        localObject2 = new jw().AS(u.SO(this.viewId));
        ((jw)localObject2).gyo = u.SM(this.viewId);
        ((jw)localObject2).gLX = 11L;
        localObject2 = ((jw)localObject2).AR(this.viewId);
        ((jw)localObject2).gLY = System.currentTimeMillis();
        ((jw)localObject2).AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
        if (!j.a(this.jZi, localBundle, a.class, new f() {})) {
          break;
        }
        this.oiJ.bNz();
        AppMethodBeat.o(121370);
        return;
        localObject1 = (String)this.oiJ.e(this.oiG, this.oiK);
        this.oiJ.cB(this.oiK);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        continue;
        localObject1 = (DrawCanvasArg)this.oiJ.e(this.oiG, this.oiK);
        this.oiJ.cB(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
      }
      if (localObject1 != null) {
        ((DrawCanvasArg)localObject1).reset();
      }
      AppMethodBeat.o(121370);
      return;
    }
    if ((this.oiI != null) && (this.oiH != null)) {
      this.oiI.bt(this.oiH.a(true, "same actions with last draw, drop this", null));
    }
    AppMethodBeat.o(121370);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b
 * JD-Core Version:    0.7.0.1
 */