package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.cgi.n;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAuthAppMsg;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderSendInviteMsgResponse;", "toUserName", "", "msgContent", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAuthAppMsg$CallBack;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAuthAppMsg$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAuthAppMsg$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAuthAppMsg$CallBack;)V", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class f
  extends n<bix>
{
  private final String TAG;
  private d lKU;
  private a xau;
  
  public f(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(273181);
    this.xau = parama;
    this.TAG = "NetSceneFinderAuthAppMsg";
    parama = new d.a();
    parama.TW("/cgi-bin/micromsg-bin/findersendinvitemsg");
    parama.vD(6412);
    biw localbiw = new biw();
    localbiw.sWA = paramString1;
    localbiw.from_username = z.bcZ();
    paramString1 = XmlParser.parseXml(paramString2, "msg", null);
    localbiw.scene = Util.safeParseInt((String)paramString1.get(".msg.appmsg.finderGuarantee.scene"));
    paramString2 = (String)paramString1.get(".msg.appmsg.finderGuarantee.relativePath");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localbiw.link = paramString1;
    parama.c((a)localbiw);
    parama.d((a)new bix());
    paramString1 = parama.bgN();
    p.j(paramString1, "builder.buildInstance()");
    this.lKU = paramString1;
    c(this.lKU);
    Log.i(this.TAG, "NetSceneFinderAuthAppMsg init");
    AppMethodBeat.o(273181);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAuthAppMsg$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderSendInviteMsgResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt, bix parambix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.f
 * JD-Core Version:    0.7.0.1
 */