package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.h.b.a.r;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  public String fVM;
  public JSONObject fVN;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b fVO;
  public com.tencent.mm.aa.b.b.a fVP;
  public u.b fVQ;
  public com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e fVR;
  public String fVS;
  public long fVT;
  public String process;
  
  public final void run()
  {
    if (this.fVR.ti(this.fVS))
    {
      u.v("DrawCanvasRunnable", "running draw", new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("viewId", this.fVM);
      localBundle.putInt("drawStrategy", this.fVR.afp());
      localBundle.putString("remoteProcess", com.tencent.mm.ipcinvoker.e.BV());
      Object localObject1;
      switch (this.fVR.afp())
      {
      default: 
        localObject1 = null;
        Object localObject2 = d.n(this.fVN);
        CollectSession localCollectSession = c.bf((String)localObject2, "after_jsapi_invoke");
        localBundle.putString("__session_id", (String)localObject2);
        localBundle.putParcelable("__cost_time_session", localCollectSession);
        v.jdMethod_if(19);
        localObject2 = new r();
        ((r)localObject2).cjv = u.jy(this.fVM);
        ((r)localObject2).cjw = u.jx(this.fVM);
        ((r)localObject2).cjs = 11L;
        ((r)localObject2).cjr = this.fVM;
        ((r)localObject2).cjt = System.currentTimeMillis();
        ((r)localObject2).cjy = aq.fH(ae.getContext());
        ((r)localObject2).QX();
        if (f.a(this.process, localBundle, a.class, new b.1(this, (DrawCanvasArg)localObject1))) {
          this.fVR.afo();
        }
        break;
      }
      while (localObject1 == null)
      {
        return;
        localObject1 = (String)this.fVR.f(this.fVN, this.fVS);
        this.fVR.aN(this.fVS);
        localBundle.putString("jsApiInvokeData", (String)localObject1);
        localObject1 = null;
        break;
        localObject1 = (DrawCanvasArg)this.fVR.f(this.fVN, this.fVS);
        this.fVR.aN(localObject1);
        localBundle.putParcelable("jsApiInvokeDataObj", (Parcelable)localObject1);
        break;
      }
      ((DrawCanvasArg)localObject1).reset();
      return;
    }
    this.fVP.ab(this.fVO.a(true, "same actions with last draw, drop this", null));
  }
  
  private static class a
    implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b
 * JD-Core Version:    0.7.0.1
 */