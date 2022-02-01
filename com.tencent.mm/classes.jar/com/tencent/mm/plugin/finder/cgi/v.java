package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetMiaoJianVideoMeta;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMiaoJianVideoMetaResp;", "md5", "", "(Ljava/lang/String;)V", "TAG", "getMd5", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetMiaoJianVideoMetaReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends c<baj>
{
  private bai Azr;
  private final String TAG;
  private final String md5;
  
  public v(String paramString)
  {
    AppMethodBeat.i(336393);
    this.md5 = paramString;
    this.TAG = "Finder.CgiFinderGetMiaoJianVideoMeta";
    paramString = new bai();
    Object localObject = bi.ABn;
    paramString.YIY = bi.dVu();
    paramString.md5 = paramString.md5;
    localObject = ah.aiuX;
    this.Azr = paramString;
    this.Azr.md5 = this.md5;
    Log.i(this.TAG, s.X("CgiFinderGetMiaoJianVideoMeta md5:", this.md5));
    paramString = new c.a();
    paramString.otE = ((a)this.Azr);
    localObject = new baj();
    ((baj)localObject).setBaseResponse(new kd());
    ((baj)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/findergetmiaojianvideometa";
    paramString.funcId = 4198;
    c(paramString.bEF());
    AppMethodBeat.o(336393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.v
 * JD-Core Version:    0.7.0.1
 */