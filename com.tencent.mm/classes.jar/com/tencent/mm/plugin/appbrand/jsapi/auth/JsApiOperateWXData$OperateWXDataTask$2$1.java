package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.widget.b.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class JsApiOperateWXData$OperateWXDataTask$2$1
  implements i.d
{
  JsApiOperateWXData$OperateWXDataTask$2$1(JsApiOperateWXData.OperateWXDataTask.2 param2) {}
  
  public final void a(int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(130879);
    ab.i("MicroMsg.AppBrand.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      ab.d("MicroMsg.AppBrand.JsApiOperateWXData", "press back button!");
      this.hEa.hDY.hDu.b(this.hEa.hDY.hDv, this.hEa.hDY.hry, "fail auth cancel");
      this.hEa.hDY.hDw.aBV();
      AppMethodBeat.o(130879);
      return;
    }
    this.hEa.hDY.hDy = "operateWXDataConfirm";
    JsApiOperateWXData.OperateWXDataTask localOperateWXDataTask = this.hEa.hDY;
    if (paramArrayList.size() > 0) {}
    for (paramArrayList = (String)paramArrayList.get(0);; paramArrayList = "")
    {
      localOperateWXDataTask.hDW = paramArrayList;
      this.hEa.hDY.hDA = paramInt;
      AppBrandMainProcessService.a(this.hEa.hDY);
      if (paramInt != 2) {
        break;
      }
      this.hEa.hDY.hDu.b(this.hEa.hDY.hDv, this.hEa.hDY.hry, "fail auth deny");
      this.hEa.hDY.hDw.aBV();
      AppMethodBeat.o(130879);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.2.1
 * JD-Core Version:    0.7.0.1
 */