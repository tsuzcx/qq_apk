package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiUpdateRedPacketCoverInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetExtraInfoResponse;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "coverInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoRedPacketCover;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoRedPacketCover;)V", "TAG", "", "getCoverInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoRedPacketCover;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetExtraInfoRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
  extends o<bhp>
{
  private final bkz CKR;
  private bho CKS;
  private final String TAG;
  
  public bc(com.tencent.mm.plugin.finder.live.model.context.a parama, bkz parambkz)
  {
    AppMethodBeat.i(360162);
    this.CKR = parambkz;
    this.TAG = "Finder.CgiUpdateRedPacketCoverInfo";
    this.CKS = new bho();
    parambkz = this.CKS;
    Object localObject = bi.ABn;
    parambkz.YIY = bi.dVu();
    this.CKS.ZQW = ((e)parama.business(e.class)).mIC;
    parambkz = z.bAW();
    int i;
    if (parambkz != null)
    {
      if (((CharSequence)parambkz).length() != 0) {
        break label356;
      }
      i = 1;
      if (i != 0) {
        break label361;
      }
      i = 1;
      label107:
      if (i == 0) {
        break label366;
      }
    }
    for (;;)
    {
      if (parambkz != null) {
        this.CKS.YIZ = parambkz;
      }
      this.CKS.YJa = new b(((f)parama.business(f.class)).mZp);
      this.CKS.object_id = ((f)parama.business(f.class)).hKN;
      this.CKS.mMJ = ((f)parama.business(f.class)).liveInfo.liveId;
      parama = this.CKS;
      parambkz = new LinkedList();
      localObject = new crp();
      ((crp)localObject).Tps = 1;
      ((crp)localObject).ZQU = new b(this.CKR.toByteArray());
      ah localah = ah.aiuX;
      parambkz.add(localObject);
      localObject = ah.aiuX;
      parama.ZQX = parambkz;
      parama = new c.a();
      parama.otE = ((com.tencent.mm.bx.a)this.CKS);
      parambkz = new bhp();
      parambkz.setBaseResponse(new kd());
      parambkz.getBaseResponse().akjO = new etl();
      parama.otF = ((com.tencent.mm.bx.a)parambkz);
      parama.uri = "/cgi-bin/micromsg-bin/finderlivegetextrainfo";
      parama.funcId = 8259;
      c(parama.bEF());
      Log.i(this.TAG, "init");
      AppMethodBeat.o(360162);
      return;
      label356:
      i = 0;
      break;
      label361:
      i = 0;
      break label107;
      label366:
      parambkz = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.bc
 * JD-Core Version:    0.7.0.1
 */