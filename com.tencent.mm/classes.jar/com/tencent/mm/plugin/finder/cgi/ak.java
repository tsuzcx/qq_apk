package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiMegaVideoPost;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostResponse;", "clientId", "", "megaVideoDesc", "Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;)V", "TAG", "getClientId", "()Ljava/lang/String;", "getMegaVideoDesc", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoDesc;", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ak
  extends c<cog>
{
  private final String TAG;
  private final String clientId;
  private cof tut;
  private final cnl tuu;
  
  public ak(String paramString, cnl paramcnl)
  {
    AppMethodBeat.i(242317);
    this.clientId = paramString;
    this.tuu = paramcnl;
    this.TAG = "Finder.CgiMegaVideoPost";
    paramString = new cof();
    paramString.username = z.aUg();
    paramString.clientId = this.clientId;
    paramString.MtG = this.tuu;
    paramcnl = ap.tuF;
    paramString.MtV = ap.cYc();
    this.tut = paramString;
    paramString = this.TAG;
    paramcnl = new StringBuilder("init CgiMegaVideoPost: videoPlayLen = ");
    Object localObject = this.tuu.media;
    p.g(localObject, "megaVideoDesc.media");
    localObject = (cod)j.kt((List)localObject);
    int i;
    if (localObject != null)
    {
      i = ((cod)localObject).Mur;
      paramcnl = paramcnl.append(i).append(", videoPlayLenMs = ");
      localObject = this.tuu.media;
      p.g(localObject, "megaVideoDesc.media");
      localObject = (cod)j.kt((List)localObject);
      if (localObject == null) {
        break label323;
      }
    }
    label323:
    for (long l = ((cod)localObject).Mus;; l = 0L)
    {
      Log.i(paramString, l);
      Log.i(this.TAG, "CgiMegaVideoPost clientId:" + this.clientId);
      paramString = new d.a();
      paramString.c((a)this.tut);
      paramcnl = new cog();
      paramcnl.setBaseResponse(new BaseResponse());
      paramcnl.getBaseResponse().ErrMsg = new dqi();
      paramString.d((a)paramcnl);
      paramString.MB("/cgi-bin/micromsg-bin/megavideopost");
      paramString.sG(4079);
      c(paramString.aXF());
      AppMethodBeat.o(242317);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ak
 * JD-Core Version:    0.7.0.1
 */