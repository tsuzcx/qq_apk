package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
final class q$a$b
  implements x.a
{
  q$a$b(q.a parama, V8Function paramV8Function) {}
  
  public final int a(int paramInt1, final int paramInt2, final String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(208754);
    p.h(paramb, "rr");
    p.h(paramn, "<anonymous parameter 4>");
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.okb.oka.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208752);
          V8Function localV8Function = this.okf.okc;
          V8Object localV8Object = q.a(this.okf.okb.oka).getGlobalObject();
          V8Array localV8Array = q.a(this.okf.okb.oka).newV8Array();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("err_code", paramInt2);
          localJSONObject.put("err_msg", "fail");
          localV8Function.call(localV8Object, localV8Array.push(localJSONObject.toString()));
          AppMethodBeat.o(208752);
        }
      });
      AppMethodBeat.o(208754);
      return 0;
    }
    paramb = paramb.aEV();
    paramString = paramb;
    if (!(paramb instanceof ou)) {
      paramString = null;
    }
    paramString = (ou)paramString;
    if (paramString == null)
    {
      AppMethodBeat.o(208754);
      return 0;
    }
    ae.i(this.okb.TAG, "canvasRequest resp_json=" + paramString.GcA);
    this.okb.oka.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208753);
        this.okf.okc.call(q.a(this.okf.okb.oka).getGlobalObject(), q.a(this.okf.okb.oka).newV8Array().push(paramString.GcA));
        AppMethodBeat.o(208753);
      }
    });
    AppMethodBeat.o(208754);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.q.a.b
 * JD-Core Version:    0.7.0.1
 */