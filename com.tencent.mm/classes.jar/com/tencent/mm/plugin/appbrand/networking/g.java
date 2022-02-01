package com.tencent.mm.plugin.appbrand.networking;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.cn.f;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;
import junit.framework.Assert;

public final class g
  implements b
{
  protected static final boolean jxf;
  public static final g lXn;
  protected static final com.tencent.mm.ce.a lXo;
  protected static final a lXp;
  
  static
  {
    AppMethodBeat.i(47763);
    lXn = new g();
    jxf = bu.flY();
    lXo = new com.tencent.mm.ce.a("MicroMsg.WxaCgiServiceWC");
    a locala = new a((byte)0);
    lXp = locala;
    locala.put("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", 1714);
    lXp.put("/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync", 1192);
    lXp.put("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", 1345);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", 1115);
    lXp.put("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", 1862);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", 1194);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", 1191);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", 1180);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", 1183);
    lXp.put("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    lXp.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    lXp.put("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    lXp.put("/cgi-bin/mmbiz-bin/js-operatewxdata", 1133);
    lXp.put("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    lXp.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    lXp.put("/cgi-bin/mmbiz-bin/js-login", 1029);
    lXp.put("/cgi-bin/mmbiz-bin/js-login-confirm", 1117);
    lXp.put("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", 2920);
    AppMethodBeat.o(47763);
  }
  
  private <Resp extends cvp> f<Resp> b(final String paramString, com.tencent.mm.bx.a parama, Class<Resp> paramClass)
  {
    AppMethodBeat.i(47761);
    final b.a locala = new b.a();
    locala.funcId = lXp.Nr(paramString);
    locala.uri = paramString;
    locala.hNM = parama;
    try
    {
      locala.hNN = ((com.tencent.mm.bx.a)paramClass.newInstance());
      paramString = com.tencent.mm.cn.g.fSm().d(lXo).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(47761);
      return paramString;
    }
    catch (InstantiationException parama)
    {
      do
      {
        ad.e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", new Object[] { paramClass.getName() });
      } while (!jxf);
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
    public final int Nr(String paramString)
    {
      AppMethodBeat.i(175022);
      int i = super.get(paramString.hashCode(), -1);
      if (i == -1) {
        Assert.assertEquals(String.format(Locale.US, "Found invalid funcid, please register %s in this map.", new Object[] { paramString }), false, g.jxf);
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
    public final com.tencent.mm.al.b a(com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(188678);
      ad.i("MicroMsg.WxaCgiServiceWC.IPCRunCgiMainProcessMonitor", "before run cgi, rr.url=%s, rr.cmdid=%d", new Object[] { paramb.getUri(), Integer.valueOf(paramb.getType()) });
      AppMethodBeat.o(188678);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.g
 * JD-Core Version:    0.7.0.1
 */