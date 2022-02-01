package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUtils;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsResp;", "type", "", "url", "", "articleScene", "(ILjava/lang/String;I)V", "TAG", "getArticleScene", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsReq;", "getType", "getUrl", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  extends c<byw>
{
  public static final a AAI;
  private static final int AAL = 0;
  private static final int AAM;
  private final int AAJ;
  private byv AAK;
  private final String TAG;
  private final int type;
  private final String url;
  
  static
  {
    AppMethodBeat.i(336195);
    AAI = new a((byte)0);
    AAM = 1;
    AppMethodBeat.o(336195);
  }
  
  public av(int paramInt1, String paramString, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(370689);
    this.type = paramInt1;
    this.url = paramString;
    this.AAJ = paramInt2;
    this.TAG = "Finder.CgiFinderUtils";
    this.AAK = new byv();
    paramString = this.AAK;
    Object localObject = bi.ABn;
    paramString.ZEc = bi.a(this.Auc);
    this.AAK.username = z.bAW();
    this.AAK.type = this.type;
    this.AAK.url = this.url;
    this.AAK.aahS = this.AAJ;
    paramString = new c.a();
    paramString.otE = ((a)this.AAK);
    localObject = new byw();
    ((byw)localObject).setBaseResponse(new kd());
    ((byw)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/finderutils";
    paramString.funcId = 4046;
    c(paramString.bEF());
    Log.i(this.TAG, "init type:" + this.type + ", url:" + this.url);
    AppMethodBeat.o(370689);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUtils$Companion;", "", "()V", "SCNEN_MP_DEFAULT", "", "getSCNEN_MP_DEFAULT", "()I", "SCNEN_MP_LIVEROOM", "getSCNEN_MP_LIVEROOM", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.av
 * JD-Core Version:    0.7.0.1
 */