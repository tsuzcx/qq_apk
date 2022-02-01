package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoPost;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostResponse;", "clientId", "", "megaVideoDesc", "Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;)V", "TAG", "getClientId", "()Ljava/lang/String;", "getMegaVideoDesc", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class al
  extends c<cwv>
{
  private final String TAG;
  private final String clientId;
  private cwu xcf;
  private final cwc xcg;
  
  public al(String paramString, cwc paramcwc)
  {
    AppMethodBeat.i(292172);
    this.clientId = paramString;
    this.xcg = paramcwc;
    this.TAG = "Finder.CgiMegaVideoPost";
    paramString = new cwu();
    paramString.username = z.bdh();
    paramString.clientId = this.clientId;
    paramString.TEM = this.xcg;
    paramcwc = as.xco;
    paramString.TFa = as.dnT();
    this.xcf = paramString;
    paramString = this.TAG;
    paramcwc = new StringBuilder("init CgiMegaVideoPost: videoPlayLen = ");
    Object localObject = this.xcg.media;
    p.j(localObject, "megaVideoDesc.media");
    localObject = (cwq)j.lp((List)localObject);
    int i;
    if (localObject != null)
    {
      i = ((cwq)localObject).TFq;
      paramcwc = paramcwc.append(i).append(", videoPlayLenMs = ");
      localObject = this.xcg.media;
      p.j(localObject, "megaVideoDesc.media");
      localObject = (cwq)j.lp((List)localObject);
      if (localObject == null) {
        break label323;
      }
    }
    label323:
    for (long l = ((cwq)localObject).TFr;; l = 0L)
    {
      Log.i(paramString, l);
      Log.i(this.TAG, "CgiMegaVideoPost clientId:" + this.clientId);
      paramString = new d.a();
      paramString.c((a)this.xcf);
      paramcwc = new cwv();
      paramcwc.setBaseResponse(new jh());
      paramcwc.getBaseResponse().Tef = new eaf();
      paramString.d((a)paramcwc);
      paramString.TW("/cgi-bin/micromsg-bin/megavideopost");
      paramString.vD(4079);
      c(paramString.bgN());
      AppMethodBeat.o(292172);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.al
 * JD-Core Version:    0.7.0.1
 */