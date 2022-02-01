package com.tencent.mm.plugin.appbrand.networking;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Locale;
import junit.framework.Assert;

public final class h
  implements c
{
  protected static final boolean jAe;
  public static final h mbU;
  protected static final com.tencent.mm.cd.a mbV;
  protected static final a mbW;
  
  static
  {
    AppMethodBeat.i(47763);
    mbU = new h();
    jAe = bv.fpT();
    mbV = new com.tencent.mm.cd.a("MicroMsg.WxaCgiServiceWC");
    a locala = new a((byte)0);
    mbW = locala;
    locala.put("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", 1714);
    mbW.put("/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync", 1192);
    mbW.put("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", 1345);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", 1115);
    mbW.put("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", 1862);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", 1194);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", 1191);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", 1180);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", 1183);
    mbW.put("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    mbW.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    mbW.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    mbW.put("/cgi-bin/mmbiz-bin/js-operatewxdata", 1133);
    mbW.put("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    mbW.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    mbW.put("/cgi-bin/mmbiz-bin/js-login", 1029);
    mbW.put("/cgi-bin/mmbiz-bin/js-login-confirm", 1117);
    mbW.put("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", 2920);
    AppMethodBeat.o(47763);
  }
  
  private <Resp extends cwj> f<Resp> b(final String paramString, com.tencent.mm.bw.a parama, Class<Resp> paramClass)
  {
    AppMethodBeat.i(47761);
    final b.a locala = new b.a();
    locala.funcId = mbW.NZ(paramString);
    locala.uri = paramString;
    locala.hQF = parama;
    try
    {
      locala.hQG = ((com.tencent.mm.bw.a)paramClass.newInstance());
      paramString = g.fWL().d(mbV).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(47761);
      return paramString;
    }
    catch (InstantiationException parama)
    {
      do
      {
        ae.e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", new Object[] { paramClass.getName() });
      } while (!jAe);
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
    public final int NZ(String paramString)
    {
      AppMethodBeat.i(175022);
      int i = super.get(paramString.hashCode(), -1);
      if (i == -1) {
        Assert.assertEquals(String.format(Locale.US, "Found invalid funcid, please register %s in this map.", new Object[] { paramString }), false, h.jAe);
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
    public final com.tencent.mm.ak.b a(com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(222848);
      ae.i("MicroMsg.WxaCgiServiceWC.IPCRunCgiMainProcessMonitor", "before run cgi, rr.url=%s, rr.cmdid=%d", new Object[] { paramb.getUri(), Integer.valueOf(paramb.getType()) });
      AppMethodBeat.o(222848);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.h
 * JD-Core Version:    0.7.0.1
 */