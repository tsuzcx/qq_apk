package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class j$1$1
  implements c
{
  j$1$1(j.1 param1) {}
  
  public final void H(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.gpe.ggE.C(this.gpe.dIS, this.gpe.gpd.h("ok", null));
      return;
    }
    this.gpe.ggE.C(this.gpe.dIS, this.gpe.gpd.h("fail:" + paramString, null));
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramString2 = new HashMap();
      paramString2.put("tempImagePath", paramString1);
      paramString2.put("width", Integer.valueOf(paramInt2));
      paramString2.put("height", Integer.valueOf(paramInt3));
      this.gpe.ggE.C(this.gpe.dIS, this.gpe.gpd.h("ok", paramString2));
      return;
    }
    this.gpe.ggE.C(this.gpe.dIS, this.gpe.gpd.h("fail:" + paramString2, null));
  }
  
  public final void c(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    y.d("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s", new Object[] { Integer.valueOf(paramInt), paramString2, paramString3 });
    if (paramInt == 0)
    {
      paramString1 = new HashMap();
      paramString1.put("tempThumbPath", paramString2);
      paramString1.put("tempVideoPath", paramString3);
      this.gpe.ggE.C(this.gpe.dIS, this.gpe.gpd.h("ok", paramString1));
      return;
    }
    this.gpe.ggE.C(this.gpe.dIS, this.gpe.gpd.h("fail:" + paramString1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j.1.1
 * JD-Core Version:    0.7.0.1
 */