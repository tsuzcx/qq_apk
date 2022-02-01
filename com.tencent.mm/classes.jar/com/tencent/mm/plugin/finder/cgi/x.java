package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetShareProductInfo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetShareProductInfoResponse;", "finderUsername", "", "objectId", "", "productId", "shareScene", "", "(Ljava/lang/String;JJI)V", "TAG", "getFinderUsername", "()Ljava/lang/String;", "getObjectId", "()J", "getProductId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetShareProductInfoRequest;", "getShareScene", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends c<bay>
{
  private final long Azu;
  private bax Azv;
  private final String TAG;
  private final String finderUsername;
  private final long hKN;
  private final int shareScene;
  
  public x(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    super(null);
    AppMethodBeat.i(336484);
    this.finderUsername = paramString;
    this.hKN = paramLong1;
    this.Azu = paramLong2;
    this.shareScene = paramInt;
    this.TAG = "Finder.CgiFinderGetShareProductInfo";
    this.Azv = new bax();
    paramString = this.Azv;
    Object localObject = bi.ABn;
    paramString.YIY = bi.a(null);
    this.Azv.YIZ = this.finderUsername;
    this.Azv.object_id = this.hKN;
    this.Azv.DVk = this.Azu;
    this.Azv.scene = this.shareScene;
    paramString = new c.a();
    paramString.otE = ((a)this.Azv);
    localObject = new bay();
    ((bay)localObject).setBaseResponse(new kd());
    ((bay)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/findergetshareproductinfo";
    paramString.funcId = 4117;
    c(paramString.bEF());
    Log.i(this.TAG, "init finderUsername:" + this.finderUsername + ", objectId:" + d.hF(this.hKN) + ", productId:" + d.hF(this.Azu) + ", shareScene:" + this.shareScene);
    AppMethodBeat.o(336484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.x
 * JD-Core Version:    0.7.0.1
 */