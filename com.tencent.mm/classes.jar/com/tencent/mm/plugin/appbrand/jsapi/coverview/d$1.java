package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.HashMap;
import java.util.Map;

final class d$1
  implements m
{
  d$1(d paramd, e parame, int paramInt) {}
  
  public final void i(View paramView, int paramInt1, int paramInt2)
  {
    if (!(paramView instanceof WxaScrollView)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.gkV.agW().F(this.gkY, false);
      } while (localObject == null);
      localObject = ((u.b)localObject).getString("data", null);
    } while (localObject == null);
    paramView = ((WxaScrollView)paramView).getTargetView();
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", localObject);
    localHashMap.put("scrollLeft", Integer.valueOf(h.mx(paramInt1)));
    localHashMap.put("scrollTop", Integer.valueOf(h.mx(paramInt2)));
    localHashMap.put("scrollWidth", Integer.valueOf(h.mx(paramView.getWidth())));
    localHashMap.put("scrollHeight", Integer.valueOf(h.mx(paramView.getHeight())));
    paramView = new l().p(localHashMap);
    this.gkV.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.d.1
 * JD-Core Version:    0.7.0.1
 */