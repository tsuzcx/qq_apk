package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.protocal.c.cis;
import com.tencent.mm.protocal.c.cit;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

final class a$b$1
  implements Runnable
{
  a$b$1(a.b paramb, c paramc, String paramString, com.tencent.mm.ipcinvoker.c paramc1) {}
  
  public final void run()
  {
    Object localObject = this.fTt;
    y.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", new Object[] { ((c)localObject).dIX });
    ((c)localObject).ahC = false;
    ((c)localObject).cleanup();
    ((c)localObject).dIU = null;
    ((c)localObject).fTE = null;
    ((c)localObject).dIX = null;
    ((c)localObject).fKV = null;
    k.tc(this.BD);
    this.dGE.U(null);
    localObject = f.aeW();
    String str = this.BD;
    if (!((f)localObject).fTT.containsKey(str)) {
      y.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[] { str });
    }
    f.b localb;
    do
    {
      return;
      localb = (f.b)((f)localObject).fTT.get(str);
      y.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[] { localb.fTX.toString() });
    } while (localb.fTX.size() <= 0);
    b.a locala = new b.a();
    locala.ecG = 2653;
    locala.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
    cis localcis = new cis();
    localcis.bOL = u.jy(str);
    localcis.id = localb.dWx;
    localcis.tWZ = localb.fTX;
    localcis.bVk = localb.bVk;
    locala.ecH = localcis;
    locala.ecI = new cit();
    b.a(locala.Kt(), ((f)localObject).fTU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.b.1
 * JD-Core Version:    0.7.0.1
 */