package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Vector;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.a<o>
{
  public static final int CTRL_INDEX = 295;
  public static final String NAME = "operateRecorder";
  private static Vector<String> gim = new Vector();
  private g.b gda;
  private j.b giS;
  private q giT;
  private int giU;
  
  public final void a(o paramo, JSONObject paramJSONObject, int paramInt)
  {
    e.a(paramo.mAppId, new j.3(this, paramo, paramJSONObject, paramInt));
    int i;
    if ((paramo.getContext() instanceof Activity))
    {
      localObject = (Activity)paramo.getContext();
      if (localObject != null) {
        break label95;
      }
      y.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
      paramo.C(paramInt, h("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label133;
      }
      y.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
      paramo.C(paramInt, h("fail:system permission denied", null));
      return;
      localObject = null;
      break;
      label95:
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      i = bool;
      if (bool)
      {
        e.vX(paramo.mAppId);
        i = bool;
      }
    }
    label133:
    Object localObject = paramo.getRuntime().Zz();
    if ((((n)localObject).getCurrentPage() == null) || (((n)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramo.C(paramInt, h("fail", null));
      return;
    }
    this.giT = ((n)localObject).getCurrentPage().getCurrentPageView();
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
      paramo.C(paramInt, h("fail:data is null", null));
      return;
    }
    localObject = paramo.mAppId;
    y.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[] { localObject, paramJSONObject.toString() });
    if (this.giS == null) {
      this.giS = new j.b(this, paramo, paramInt);
    }
    this.giS.gfg = paramInt;
    this.giS.appId = ((String)localObject);
    this.giS.giZ = paramJSONObject.toString();
    this.giS.processName = ae.getProcessName();
    if (this.gda == null) {
      this.gda = new j.1(this, (String)localObject, paramo, paramInt);
    }
    this.giS.gda = this.gda;
    this.giS.ahU();
  }
  
  public static final class a
    extends l
  {
    private static final int CTRL_INDEX = 296;
    private static final String NAME = "onRecorderStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.j
 * JD-Core Version:    0.7.0.1
 */