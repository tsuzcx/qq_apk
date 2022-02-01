package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  public String aQj;
  public JSONObject kkm;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b kkn;
  public com.tencent.mm.aa.b.b.a kko;
  public e kkp;
  public String kkq;
  public long kkr;
  public String process;
  
  public final void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b paramb, com.tencent.mm.aa.b.b.a parama, e parame, String paramString3)
  {
    AppMethodBeat.i(121369);
    this.process = paramString1;
    this.aQj = paramString2;
    this.kkm = paramJSONObject;
    this.kkn = paramb;
    this.kko = parama;
    this.kkp = parame;
    this.kkq = paramString3;
    this.kkr = System.currentTimeMillis();
    AppMethodBeat.o(121369);
  }
  
  public final void run()
  {
    AppMethodBeat.i(121370);
    if (this.kkp.Pp(this.kkq))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.aQj);
      localBundle.putInt("drawStrategy", this.kkp.bgL());
      localBundle.putString("remoteProcess", g.ahM());
      a.cN(this.aQj, this.kkq);
      Object localObject1;
      switch (this.kkp.bgL())
      {
      default: 
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = com.tencent.mm.plugin.appbrand.dynamic.h.d.z(this.kkm);
        CollectSession localCollectSession = c.cB((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.md(19);
        localObject2 = new el().oa(u.CK(this.aQj));
        ((el)localObject2).ejC = u.CI(this.aQj);
        ((el)localObject2).ejz = 11L;
        localObject2 = ((el)localObject2).nZ(this.aQj);
        ((el)localObject2).ejA = System.currentTimeMillis();
        ((el)localObject2).ob(az.iW(ak.getContext())).aLH();
        if (!h.a(this.process, localBundle, a.class, new com.tencent.mm.ipcinvoker.d() {})) {
          break;
        }
        this.kkp.bgK();
        AppMethodBeat.o(121370);
        return;
        localObject1 = (String)this.kkp.c(this.kkm, this.kkq);
        this.kkp.cs(this.kkq);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        continue;
        localObject1 = (DrawCanvasArg)this.kkp.c(this.kkm, this.kkq);
        this.kkp.cs(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
      }
      if (localObject1 != null) {
        ((DrawCanvasArg)localObject1).reset();
      }
      AppMethodBeat.o(121370);
      return;
    }
    if ((this.kko != null) && (this.kkn != null)) {
      this.kko.bk(this.kkn.a(true, "same actions with last draw, drop this", null));
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