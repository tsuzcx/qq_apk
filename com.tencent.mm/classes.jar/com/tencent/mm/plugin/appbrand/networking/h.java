package com.tencent.mm.plugin.appbrand.networking;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Locale;
import junit.framework.Assert;

public final class h
  implements c
{
  protected static final boolean nug;
  public static final h qld;
  protected static final com.tencent.mm.ck.a qle;
  protected static final a qlf;
  
  static
  {
    AppMethodBeat.i(47763);
    qld = new h();
    nug = WeChatEnvironment.hasDebugger();
    qle = new com.tencent.mm.ck.a("MicroMsg.WxaCgiServiceWC");
    a locala = new a((byte)0);
    qlf = locala;
    locala.bR("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", 1714);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync", 1192);
    qlf.bR("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", 1345);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", 1115);
    qlf.bR("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", 1862);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", 1194);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", 1191);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", 1180);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", 1183);
    qlf.bR("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    qlf.bR("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    qlf.bR("/cgi-bin/mmbiz-bin/js-operatewxdata", 1133);
    qlf.bR("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    qlf.bR("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    qlf.bR("/cgi-bin/mmbiz-bin/js-login", 1029);
    qlf.bR("/cgi-bin/mmbiz-bin/js-login-confirm", 1117);
    qlf.bR("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", 2920);
    qlf.bR("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", 4428);
    qlf.bR("/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport", 1009);
    AppMethodBeat.o(47763);
  }
  
  private <Resp extends dyy> f<Resp> b(String paramString, com.tencent.mm.cd.a parama, Class<Resp> paramClass)
  {
    AppMethodBeat.i(47761);
    d.a locala = new d.a();
    locala.funcId = qlf.aeU(paramString);
    locala.uri = paramString;
    locala.lBU = parama;
    try
    {
      locala.lBV = ((com.tencent.mm.cd.a)paramClass.newInstance());
      paramString = g.ijP().d(qle).g(new h.1(this, locala, paramString));
      AppMethodBeat.o(47761);
      return paramString;
    }
    catch (InstantiationException parama)
    {
      do
      {
        Log.e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", new Object[] { paramClass.getName() });
      } while (!nug);
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
    public final int aeU(String paramString)
    {
      AppMethodBeat.i(175022);
      int i = super.get(paramString.hashCode(), -1);
      if (i == -1) {
        Assert.assertEquals(String.format(Locale.US, "Found invalid funcid, please register %s in this map.", new Object[] { paramString }), false, h.nug);
      }
      AppMethodBeat.o(175022);
      return i;
    }
    
    public final void bR(String paramString, int paramInt)
    {
      AppMethodBeat.i(175021);
      super.put(paramString.hashCode(), paramInt);
      AppMethodBeat.o(175021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.h
 * JD-Core Version:    0.7.0.1
 */