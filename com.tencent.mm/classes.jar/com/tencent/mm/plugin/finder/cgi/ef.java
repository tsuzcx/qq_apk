package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetFriendBoxLiveMsg;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetFriendBoxLiveMsgResp;", "liveCookies", "", "boxId", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "objectId", "", "liveId", "anchorUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "([BLcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;Lcom/tencent/mm/protobuf/ByteString;JJLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getAnchorUserName", "()Ljava/lang/String;", "getBoxId", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveCookies", "()[B", "getLiveId", "()J", "getObjectId", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "logInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetFriendBoxLiveMsgReq;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ef
  extends c<dzw>
{
  public final bfv Don;
  private final String TAG;
  private final long hKN;
  private final b lastBuffer;
  private final long liveId;
  private final byte[] mZp;
  private final String mZs;
  
  public ef(byte[] paramArrayOfByte, bfv parambfv, b paramb, long paramLong1, long paramLong2, String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(370695);
    this.mZp = paramArrayOfByte;
    this.Don = parambfv;
    this.lastBuffer = paramb;
    this.hKN = paramLong1;
    this.liveId = paramLong2;
    this.mZs = paramString;
    this.TAG = "Finder.CgiFinderGetFriendBoxLiveMsg";
    paramArrayOfByte = new cje();
    parambfv = bi.ABn;
    paramArrayOfByte.YIY = bi.a(parambui);
    paramArrayOfByte.YJa = b.cX(this.mZp);
    paramArrayOfByte.akjQ = this.Don;
    paramArrayOfByte.ZEQ = this.lastBuffer;
    paramArrayOfByte.object_id = this.hKN;
    paramArrayOfByte.mMJ = this.liveId;
    paramArrayOfByte.YIZ = this.mZs;
    parambfv = new c.a();
    parambfv.otE = ((a)paramArrayOfByte);
    paramb = new dzw();
    paramb.setBaseResponse(new kd());
    paramb.getBaseResponse().akjO = new etl();
    parambfv.otF = ((a)paramb);
    parambfv.uri = "/cgi-bin/micromsg-bin/findergetfriendboxlivemsg";
    parambfv.funcId = 11261;
    c(parambfv.bEF());
    parambfv = this.TAG;
    s.u(paramArrayOfByte, "<this>");
    Log.i(parambfv, s.X("CgiFinderGetFriendBoxLiveMsg init ", ""));
    AppMethodBeat.o(370695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ef
 * JD-Core Version:    0.7.0.1
 */