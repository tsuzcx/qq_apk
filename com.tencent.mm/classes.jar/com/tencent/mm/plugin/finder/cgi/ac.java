package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUserPage;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageResponse;", "username", "", "enterType", "", "(Ljava/lang/String;I)V", "TAG", "getEnterType", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageRequest;", "getUsername", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ac
  extends c<FinderUserPageResponse>
{
  private final String TAG;
  private final String username;
  private blb xbI;
  private final int xbJ;
  
  public ac(String paramString)
  {
    super(null);
    AppMethodBeat.i(225888);
    this.username = paramString;
    this.xbJ = 17;
    this.TAG = "Finder.CgiFinderUserPage";
    this.xbI = new blb();
    this.xbI.username = this.username;
    this.xbI.xbJ = this.xbJ;
    this.xbI.firstPageMD5 = "";
    this.xbI.RLN = z.bdh();
    paramString = this.xbI;
    Object localObject = ao.xcj;
    paramString.yjp = ao.a(null);
    paramString = this.xbI.yjp;
    if (paramString != null) {
      paramString.scene = 0;
    }
    paramString = this.xbI;
    localObject = ao.xcj;
    paramString.SCW = ao.dnP();
    paramString = new d.a();
    paramString.c((a)this.xbI);
    localObject = new FinderUserPageResponse();
    ((FinderUserPageResponse)localObject).setBaseResponse(new jh());
    ((FinderUserPageResponse)localObject).getBaseResponse().Tef = new eaf();
    paramString.d((a)localObject);
    paramString.TW("/cgi-bin/micromsg-bin/finderuserpage");
    paramString.vD(3736);
    c(paramString.bgN());
    Log.i(this.TAG, "init username:" + this.username + ", enterType:" + this.xbJ);
    AppMethodBeat.o(225888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ac
 * JD-Core Version:    0.7.0.1
 */