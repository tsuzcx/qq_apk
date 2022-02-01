package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetJumpInfo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetJumpInfoResponse;", "objectId", "", "liveId", "type", "", "jumpId", "", "jumpBuf", "Lcom/tencent/mm/protobuf/ByteString;", "uxInfo", "sessionBuf", "(JJILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getLiveId", "()J", "getObjectId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetJumpInfoRequest;", "getType", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends c<bhx>
{
  private bhw Cvw;
  private final String TAG;
  private final long hKN;
  private final long liveId;
  private final int type;
  
  public n(long paramLong1, long paramLong2, int paramInt, String paramString1, b paramb, String paramString2, String paramString3)
  {
    super(null);
    AppMethodBeat.i(351203);
    this.hKN = paramLong1;
    this.liveId = paramLong2;
    this.type = paramInt;
    this.TAG = "Finder.CgiFinderLiveGetJumpInfo";
    this.Cvw = new bhw();
    bhw localbhw = this.Cvw;
    bi localbi = bi.ABn;
    localbhw.YIY = bi.dVu();
    this.Cvw.object_id = this.hKN;
    this.Cvw.mMJ = this.liveId;
    this.Cvw.type = this.type;
    this.Cvw.jump_id = paramString1;
    this.Cvw.ZRc = paramb;
    if (paramString2 != null) {
      this.Cvw.ZRd = b.bsj(paramString2);
    }
    if (paramString3 != null) {
      this.Cvw.ZRe = b.bsj(paramString3);
    }
    this.Cvw.scene = 1;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.Cvw);
    paramb = new bhx();
    paramb.setBaseResponse(new kd());
    paramb.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramb);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderlivegetjumpinfo";
    paramString1.funcId = 6283;
    c(paramString1.bEF());
    Log.i(this.TAG, "init liveId:" + this.liveId + ", objectId:" + this.hKN + '}');
    AppMethodBeat.o(351203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.n
 * JD-Core Version:    0.7.0.1
 */