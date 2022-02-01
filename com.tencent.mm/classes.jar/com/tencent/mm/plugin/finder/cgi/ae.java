package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUtils;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsResp;", "type", "", "url", "", "(ILjava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsReq;", "getType", "()I", "getUrl", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ae
  extends c<bli>
{
  private final String TAG;
  private final int type;
  private final String url;
  private blh xbN;
  
  public ae(String paramString)
  {
    super(null);
    AppMethodBeat.i(289370);
    this.type = 1;
    this.url = paramString;
    this.TAG = "Finder.CgiFinderUtils";
    this.xbN = new blh();
    paramString = this.xbN;
    Object localObject = ao.xcj;
    paramString.SDi = ao.a(this.xbu);
    this.xbN.username = z.bdh();
    this.xbN.type = this.type;
    this.xbN.url = this.url;
    paramString = new d.a();
    paramString.c((a)this.xbN);
    localObject = new bli();
    ((bli)localObject).setBaseResponse(new jh());
    ((bli)localObject).getBaseResponse().Tef = new eaf();
    paramString.d((a)localObject);
    paramString.TW("/cgi-bin/micromsg-bin/finderutils");
    paramString.vD(4046);
    c(paramString.bgN());
    Log.i(this.TAG, "init type:" + this.type + ", url:" + this.url);
    AppMethodBeat.o(289370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ae
 * JD-Core Version:    0.7.0.1
 */