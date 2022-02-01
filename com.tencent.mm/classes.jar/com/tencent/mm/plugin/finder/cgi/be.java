package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoPost;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostResponse;", "clientId", "", "megaVideoDesc", "Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;)V", "TAG", "getClientId", "()Ljava/lang/String;", "getMegaVideoDesc", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  extends b<doa>
{
  private final dnh ABh;
  private dnz ABi;
  private final String TAG;
  private final String clientId;
  
  public be(String paramString, dnh paramdnh)
  {
    AppMethodBeat.i(336478);
    this.clientId = paramString;
    this.ABh = paramdnh;
    this.TAG = "Finder.CgiMegaVideoPost";
    paramString = new dnz();
    paramString.username = z.bAW();
    paramString.clientId = this.clientId;
    paramString.aaUt = this.ABh;
    paramdnh = bn.ABz;
    paramString.aaUG = bn.dVA();
    paramdnh = ah.aiuX;
    this.ABi = paramString;
    paramString = this.TAG;
    paramdnh = new StringBuilder("init CgiMegaVideoPost: videoPlayLen = ");
    Object localObject = this.ABh.media;
    s.s(localObject, "megaVideoDesc.media");
    localObject = (dnv)p.oL((List)localObject);
    int i;
    if (localObject == null)
    {
      i = 0;
      paramdnh = paramdnh.append(i).append(", videoPlayLenMs = ");
      localObject = this.ABh.media;
      s.s(localObject, "megaVideoDesc.media");
      localObject = (dnv)p.oL((List)localObject);
      if (localObject != null) {
        break label313;
      }
    }
    label313:
    for (long l = 0L;; l = ((dnv)localObject).aaUY)
    {
      Log.i(paramString, l);
      Log.i(this.TAG, s.X("CgiMegaVideoPost clientId:", this.clientId));
      paramString = new c.a();
      paramString.otE = ((a)this.ABi);
      paramdnh = new doa();
      paramdnh.setBaseResponse(new kd());
      paramdnh.getBaseResponse().akjO = new etl();
      paramString.otF = ((a)paramdnh);
      paramString.uri = "/cgi-bin/micromsg-bin/megavideopost";
      paramString.funcId = 4079;
      c(paramString.bEF());
      AppMethodBeat.o(336478);
      return;
      i = ((dnv)localObject).aaUX;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.be
 * JD-Core Version:    0.7.0.1
 */