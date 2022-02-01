package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveLotteryHistory;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryHistoryResponse;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(IJJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends o<bhz>
{
  public static final a CKa;
  
  static
  {
    AppMethodBeat.i(360288);
    CKa = new a((byte)0);
    AppMethodBeat.o(360288);
  }
  
  private ah(String paramString)
  {
    AppMethodBeat.i(360280);
    bhy localbhy = new bhy();
    localbhy.scene = 1;
    Object localObject = bi.ABn;
    localbhy.ZEc = bi.dVu();
    localbhy.finderUsername = z.bAW();
    localbhy.liveId = 0L;
    localbhy.hKN = 0L;
    localbhy.lastBuffer = null;
    localbhy.objectNonceId = paramString;
    localObject = new c.a();
    ((c.a)localObject).otE = ((a)localbhy);
    bhz localbhz = new bhz();
    localbhz.setBaseResponse(new kd());
    localbhz.getBaseResponse().akjO = new etl();
    ((c.a)localObject).otF = ((a)localbhz);
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/finderlivegetlotteryhistory";
    ((c.a)localObject).funcId = 6484;
    c(((c.a)localObject).bEF());
    Log.i("Finder.CgiFinderLiveLotteryHistory", "CgiFinderLiveLotteryHistory init, finderUsername = " + localbhy.finderUsername + ", liveId = 0, objectId = 0" + ", objectNonceId = " + paramString + ", scene = 1,  lastBuffer = " + null);
    AppMethodBeat.o(360280);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveLotteryHistory$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ah
 * JD-Core Version:    0.7.0.1
 */