package com.tencent.mm.plugin.appbrand.networking;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.b;
import java.util.Locale;
import junit.framework.Assert;

public final class h
  implements c
{
  protected static final boolean kAU;
  public static final h njF;
  protected static final com.tencent.mm.cd.a njG;
  protected static final a njH;
  
  static
  {
    AppMethodBeat.i(47763);
    njF = new h();
    kAU = WeChatEnvironment.hasDebugger();
    njG = new com.tencent.mm.cd.a("MicroMsg.WxaCgiServiceWC");
    a locala = new a((byte)0);
    njH = locala;
    locala.put("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", 1714);
    njH.put("/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync", 1192);
    njH.put("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", 1345);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", 1115);
    njH.put("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", 1862);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", 1194);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", 1191);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", 1180);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", 1183);
    njH.put("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    njH.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    njH.put("/cgi-bin/mmbiz-bin/js-operatewxdata", 1133);
    njH.put("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    njH.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    njH.put("/cgi-bin/mmbiz-bin/js-login", 1029);
    njH.put("/cgi-bin/mmbiz-bin/js-login-confirm", 1117);
    njH.put("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", 2920);
    njH.put("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", 4428);
    njH.put("/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport", 1009);
    AppMethodBeat.o(47763);
  }
  
  private <Resp extends dpc> f<Resp> b(final String paramString, com.tencent.mm.bw.a parama, Class<Resp> paramClass)
  {
    AppMethodBeat.i(47761);
    final d.a locala = new d.a();
    locala.funcId = njH.Xi(paramString);
    locala.uri = paramString;
    locala.iLN = parama;
    try
    {
      locala.iLO = ((com.tencent.mm.bw.a)paramClass.newInstance());
      paramString = g.hio().d(njG).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(47761);
      return paramString;
    }
    catch (InstantiationException parama)
    {
      do
      {
        Log.e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", new Object[] { paramClass.getName() });
      } while (!kAU);
      paramString = new RuntimeException(parama);
      AppMethodBeat.o(47761);
      throw paramString;
    }
    catch (IllegalAccessException parama)
    {
      label82:
      break label82;
    }
  }
  
  static final class a
    extends SparseIntArray
  {
    public final int Xi(String paramString)
    {
      AppMethodBeat.i(175022);
      int i = super.get(paramString.hashCode(), -1);
      if (i == -1) {
        Assert.assertEquals(String.format(Locale.US, "Found invalid funcid, please register %s in this map.", new Object[] { paramString }), false, h.kAU);
      }
      AppMethodBeat.o(175022);
      return i;
    }
    
    public final void put(String paramString, int paramInt)
    {
      AppMethodBeat.i(175021);
      super.put(paramString.hashCode(), paramInt);
      AppMethodBeat.o(175021);
    }
  }
  
  static final class b
    implements IPCRunCgi.b
  {
    public final d a(d paramd)
    {
      AppMethodBeat.i(227222);
      Log.i("MicroMsg.WxaCgiServiceWC.IPCRunCgiMainProcessMonitor", "before run cgi, rr.url=%s, rr.cmdid=%d", new Object[] { paramd.getUri(), Integer.valueOf(paramd.getType()) });
      AppMethodBeat.o(227222);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.h
 * JD-Core Version:    0.7.0.1
 */