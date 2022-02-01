package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveOpenTransferBuffer;", "Req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferResponse;", "cgiUri", "", "cgiNumber", "", "token", "req", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "TAG", "getCgiNumber", "()I", "getCgiUri", "()Ljava/lang/String;", "getReq", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferRequest;", "getToken", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah<Req extends a>
  extends c<bkq>
{
  public static final a AzO;
  private final int AzP;
  public final Req AzQ;
  private final bkp AzR;
  private final String TAG;
  private final String cgiUri;
  private final String token;
  
  static
  {
    AppMethodBeat.i(336270);
    AzO = new a((byte)0);
    AppMethodBeat.o(336270);
  }
  
  public ah(String paramString1, int paramInt, String paramString2, Req paramReq)
  {
    AppMethodBeat.i(336265);
    this.cgiUri = paramString1;
    this.AzP = paramInt;
    this.token = paramString2;
    this.AzQ = paramReq;
    this.TAG = "Finder.CgiFinderLiveOpenTransferBase";
    this.AzR = new bkp();
    paramString1 = this.AzR;
    paramString2 = bi.ABn;
    paramString1.YIY = bi.dVu();
    paramString1 = this.AzR;
    paramString2 = new bko();
    paramString2.ZTO = 0;
    paramString2.token = this.token;
    paramReq = kotlin.ah.aiuX;
    paramString1.ZTP = paramString2;
    paramString1 = this.AzR;
    paramString2 = aw.Gjk;
    paramString1.ZQU = aw.j(this.AzQ);
    this.AzR.YSb = "";
    paramString1 = new c.a();
    paramString1.otE = ((a)this.AzR);
    paramString2 = new bkq();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = this.cgiUri;
    paramString1.funcId = this.AzP;
    c(paramString1.bEF());
    Log.i(this.TAG, "init cgiUri:" + this.cgiUri + ", cgiNumber:" + this.AzP + ", token:" + this.token);
    AppMethodBeat.o(336265);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveOpenTransferBuffer$Companion;", "", "()V", "getResp", "Resp", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveOpenTransferResponse;", "resp", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;Lcom/tencent/mm/protobuf/BaseProtoBuf;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <Resp extends a> Resp a(b.a<bkq> parama, Resp paramResp)
    {
      AppMethodBeat.i(336518);
      s.u(parama, "<this>");
      s.u(paramResp, "resp");
      parama = (bkq)parama.ott;
      if (parama == null)
      {
        AppMethodBeat.o(336518);
        return null;
      }
      parama = parama.ZQV;
      if (parama == null)
      {
        AppMethodBeat.o(336518);
        return null;
      }
      parama = parama.toByteArray();
      try
      {
        paramResp.parseFrom(parama);
        if (paramResp == null)
        {
          AppMethodBeat.o(336518);
          return null;
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parama });
          paramResp = null;
        }
        AppMethodBeat.o(336518);
      }
      return paramResp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ah
 * JD-Core Version:    0.7.0.1
 */