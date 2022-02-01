package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
final class q$a$a
  implements IPCRunCgi.a
{
  q$a$a(q.a parama, V8Function paramV8Function) {}
  
  public final void a(int paramInt1, final int paramInt2, final String paramString, b paramb)
  {
    AppMethodBeat.i(208751);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e(this.okb.TAG, "adRequest callback errType=" + paramInt1 + ", errCode=" + paramInt2);
      this.okb.oka.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208749);
          V8Function localV8Function = this.okd.okc;
          V8Object localV8Object = q.a(this.okd.okb.oka).getGlobalObject();
          V8Array localV8Array = q.a(this.okd.okb.oka).newV8Array();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("err_code", paramInt2);
          localJSONObject.put("err_msg", "fail");
          localV8Function.call(localV8Object, localV8Array.push(localJSONObject.toString()));
          AppMethodBeat.o(208749);
        }
      });
      AppMethodBeat.o(208751);
      return;
    }
    p.g(paramb, "rr");
    paramb = paramb.aEV();
    paramString = paramb;
    if (!(paramb instanceof dnq)) {
      paramString = null;
    }
    paramString = (dnq)paramString;
    if (paramString == null)
    {
      ae.e(this.okb.TAG, "adRequest resp is null");
      AppMethodBeat.o(208751);
      return;
    }
    this.okb.oka.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208750);
        ae.d(this.okd.okb.TAG, "adRequest resp data: " + paramString.GcA);
        V8Function localV8Function = this.okd.okc;
        V8Object localV8Object = q.a(this.okd.okb.oka).getGlobalObject();
        V8Array localV8Array = q.a(this.okd.okb.oka).newV8Array();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("err_msg", "ok");
        String str2 = paramString.GcA;
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localJSONObject.put("data", str1);
        localV8Function.call(localV8Object, localV8Array.push(localJSONObject.toString()));
        AppMethodBeat.o(208750);
      }
    });
    AppMethodBeat.o(208751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.q.a.a
 * JD-Core Version:    0.7.0.1
 */