package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderSearchEvent;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchEventResponse;", "nickName", "", "eventName", "query", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "requestId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "getEventName", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getNickName", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "getQuery", "request", "Lcom/tencent/mm/protocal/protobuf/FinderSearchEventRequest;", "getRequestId", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends c<buq>
{
  private bup AzY;
  private final String TAG;
  private final String eventName;
  private final String hOG;
  private final b lastBuffer;
  private final String nickName;
  public int pullType;
  private final String query;
  
  public ao(String paramString1, String paramString2, String paramString3, b paramb, String paramString4)
  {
    super(null);
    AppMethodBeat.i(336219);
    this.nickName = paramString1;
    this.eventName = paramString2;
    this.query = paramString3;
    this.lastBuffer = paramb;
    this.hOG = paramString4;
    this.TAG = "Finder.CgiFinderSearchEventUtils";
    this.AzY = new bup();
    paramString1 = this.AzY;
    paramString2 = bi.ABn;
    paramString1.YIY = bi.a(this.Auc);
    int i;
    if (s.p(this.hOG, ""))
    {
      this.AzY.request_id = String.valueOf(cn.bDw());
      paramString1 = (CharSequence)this.query;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label333;
      }
      i = 1;
      label148:
      if (i != 0) {
        break label339;
      }
      this.AzY.query = this.query;
    }
    for (;;)
    {
      if (this.lastBuffer != null) {
        this.AzY.aacl = this.lastBuffer;
      }
      paramString1 = new c.a();
      paramString1.otE = ((a)this.AzY);
      paramString2 = new buq();
      paramString2.BaseResponse = new kd();
      paramString2.BaseResponse.akjO = new etl();
      paramString1.otF = ((a)paramString2);
      paramString1.uri = "/cgi-bin/micromsg-bin/findersearchevent";
      paramString1.funcId = 6241;
      c(paramString1.bEF());
      Log.i(this.TAG, "nickName: " + this.nickName + ", eventName: " + this.eventName + ", query: " + this.query);
      AppMethodBeat.o(336219);
      return;
      this.AzY.request_id = this.hOG;
      break;
      label333:
      i = 0;
      break label148;
      label339:
      this.AzY.aabM = this.nickName;
      this.AzY.aaaG = this.eventName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ao
 * JD-Core Version:    0.7.0.1
 */