package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gob;
import com.tencent.mm.protocal.protobuf.goc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetBoxMsgTips;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetBoxMsgTipsResp;", "liveCookies", "", "objectId", "", "liveId", "boxList", "", "Lcom/tencent/mm/protocal/protobuf/BoxIdAndLastBuffer;", "anchorUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "([BJJLjava/util/List;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getAnchorUserName", "()Ljava/lang/String;", "getBoxList", "()Ljava/util/List;", "getLiveCookies", "()[B", "getLiveId", "()J", "getObjectId", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "logInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetBoxMsgTipsReq;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ee
  extends c<goc>
{
  private final String TAG;
  private final long hKN;
  private final long liveId;
  private final byte[] mZp;
  private final String mZs;
  public final List<and> ynl;
  
  public ee(byte[] paramArrayOfByte, long paramLong1, long paramLong2, List<? extends and> paramList, String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(370693);
    this.mZp = paramArrayOfByte;
    this.hKN = paramLong1;
    this.liveId = paramLong2;
    this.ynl = paramList;
    this.mZs = paramString;
    this.TAG = "Finder.CgiFinderGetBoxMsgTips";
    paramArrayOfByte = new gob();
    paramList = bi.ABn;
    paramArrayOfByte.YIY = bi.a(parambui);
    paramArrayOfByte.YJa = b.cX(this.mZp);
    paramArrayOfByte.object_id = this.hKN;
    paramArrayOfByte.mMJ = this.liveId;
    paramArrayOfByte.akkM.addAll((Collection)this.ynl);
    paramArrayOfByte.YIZ = this.mZs;
    paramList = new c.a();
    paramList.otE = ((a)paramArrayOfByte);
    paramString = new goc();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramList.otF = ((a)paramString);
    paramList.uri = "/cgi-bin/micromsg-bin/finderlivegetboxmsgtips";
    paramList.funcId = 11382;
    c(paramList.bEF());
    paramList = this.TAG;
    s.u(paramArrayOfByte, "<this>");
    Log.i(paramList, s.X("CgiFinderGetBoxMsgTips init ", ""));
    AppMethodBeat.o(370693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ee
 * JD-Core Version:    0.7.0.1
 */