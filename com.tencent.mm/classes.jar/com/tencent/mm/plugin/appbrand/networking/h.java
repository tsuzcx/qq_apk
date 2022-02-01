package com.tencent.mm.plugin.appbrand.networking;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.b;
import java.util.Locale;
import junit.framework.Assert;

public final class h
  implements c
{
  protected static final boolean qsQ;
  public static final h tpZ;
  protected static final com.tencent.mm.cf.a tqa;
  protected static final a tqb;
  
  static
  {
    AppMethodBeat.i(47763);
    tpZ = new h();
    if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool = true;; bool = false)
    {
      qsQ = bool;
      tqa = new com.tencent.mm.cf.a("MicroMsg.WxaCgiServiceWC");
      a locala = new a((byte)0);
      tqb = locala;
      locala.cj("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", 1714);
      tqb.cj(at.rxA, 1192);
      tqb.cj("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", 1345);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", 1115);
      tqb.cj("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", 1862);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", 1194);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", 1191);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", 1180);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", 1183);
      tqb.cj("/cgi-bin/mmbiz-bin/js-authorize", 1157);
      tqb.cj("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
      tqb.cj("/cgi-bin/mmbiz-bin/js-operatewxdata", 1133);
      tqb.cj("/cgi-bin/mmbiz-bin/js-authorize", 1157);
      tqb.cj("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
      tqb.cj("/cgi-bin/mmbiz-bin/js-login", 1029);
      tqb.cj("/cgi-bin/mmbiz-bin/js-login-confirm", 1117);
      tqb.cj("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", 2920);
      tqb.cj("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", 4428);
      tqb.cj("/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport", 1009);
      tqb.cj("/cgi-bin/mmbiz-bin/wxabusiness/reportusercheckphoneprivacy", 7056);
      AppMethodBeat.o(47763);
      return;
    }
  }
  
  private <Resp extends esc> f<Resp> b(final String paramString, com.tencent.mm.bx.a parama, Class<Resp> paramClass)
  {
    AppMethodBeat.i(47761);
    final c.a locala = new c.a();
    locala.funcId = tqb.Xw(paramString);
    locala.uri = paramString;
    locala.otE = parama;
    try
    {
      locala.otF = ((com.tencent.mm.bx.a)paramClass.newInstance());
      paramString = g.jPX().d(tqa).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(47761);
      return paramString;
    }
    catch (InstantiationException parama)
    {
      do
      {
        Log.e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", new Object[] { paramClass.getName() });
      } while (!qsQ);
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
    public final int Xw(String paramString)
    {
      AppMethodBeat.i(175022);
      int i = super.get(paramString.hashCode(), -1);
      if (i == -1) {
        Assert.assertEquals(String.format(Locale.US, "Found invalid funcid, please register %s in this map.", new Object[] { paramString }), false, h.qsQ);
      }
      AppMethodBeat.o(175022);
      return i;
    }
    
    public final void cj(String paramString, int paramInt)
    {
      AppMethodBeat.i(175021);
      super.put(paramString.hashCode(), paramInt);
      AppMethodBeat.o(175021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.h
 * JD-Core Version:    0.7.0.1
 */