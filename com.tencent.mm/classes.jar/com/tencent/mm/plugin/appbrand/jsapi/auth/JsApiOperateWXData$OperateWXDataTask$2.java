package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import com.tencent.mm.plugin.appbrand.widget.b.i.d;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.protocal.protobuf.bwv;
import java.util.LinkedList;

final class JsApiOperateWXData$OperateWXDataTask$2
  implements Runnable
{
  JsApiOperateWXData$OperateWXDataTask$2(JsApiOperateWXData.OperateWXDataTask paramOperateWXDataTask, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(130880);
    bwv localbwv = (bwv)this.hDM.getFirst();
    Object localObject = new JsApiOperateWXData.OperateWXDataTask.2.1(this);
    localObject = new i(f.a(this.hDY.hDv), (i.d)localObject);
    ((i)localObject).FG(this.hDY.mAppName);
    ((i)localObject).FH(localbwv.Desc);
    ((i)localObject).FJ(this.hDY.hDC);
    ((i)localObject).FK(this.hDY.hDD);
    ((i)localObject).FL(this.hDY.hDE);
    ((i)localObject).ka(this.hDY.hDB);
    if ("scope.userInfo".equals(localbwv.wAh))
    {
      e.a locala = e.hDq;
      e.a.a(this.hDY.hDv.getContext(), d.rd(this.hDY.hDF), this.hDY.hDG, localbwv.wAh, (i)localObject);
    }
    for (;;)
    {
      this.hDY.hDv.asX().b((k)localObject);
      AppMethodBeat.o(130880);
      return;
      ((i)localObject).FM(localbwv.wAh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.2
 * JD-Core Version:    0.7.0.1
 */