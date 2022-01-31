package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Map;

final class a$b$1
  implements Runnable
{
  a$b$1(a.b paramb, c paramc, String paramString, com.tencent.mm.ipcinvoker.c paramc1) {}
  
  public final void run()
  {
    AppMethodBeat.i(10644);
    Object localObject = this.hmU;
    ab.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", new Object[] { ((c)localObject).equ });
    ((c)localObject).ajS = false;
    ((c)localObject).cleanup();
    ((c)localObject).eGt = null;
    ((c)localObject).hnf = null;
    ((c)localObject).equ = null;
    ((c)localObject).mSessionId = null;
    k.Be(this.val$id);
    this.eEg.ad(null);
    localObject = f.azz();
    String str = this.val$id;
    if (!((f)localObject).hnv.containsKey(str))
    {
      ab.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[] { str });
      AppMethodBeat.o(10644);
      return;
    }
    f.b localb = (f.b)((f)localObject).hnv.get(str);
    ab.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[] { localb.hnz.toString() });
    if (localb.hnz.size() > 0)
    {
      b.a locala = new b.a();
      locala.funcId = 2653;
      locala.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
      cwe localcwe = new cwe();
      localcwe.cwc = u.qn(str);
      localcwe.id = localb.fmF;
      localcwe.yet = localb.hnz;
      localcwe.query = localb.query;
      locala.fsX = localcwe;
      locala.fsY = new cwf();
      b.a(locala.ado(), ((f)localObject).hnw);
    }
    AppMethodBeat.o(10644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b.1
 * JD-Core Version:    0.7.0.1
 */