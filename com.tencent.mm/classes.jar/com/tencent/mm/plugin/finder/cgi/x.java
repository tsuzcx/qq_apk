package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.o.l;
import com.tencent.mm.live.b.o.m;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderPostLiveAppMsg;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "roomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "callBack", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;Lkotlin/jvm/functions/Function4;)V", "TAG", "getCallBack", "()Lkotlin/jvm/functions/Function4;", "setCallBack", "(Lkotlin/jvm/functions/Function4;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgRequest;", "initReqResp", "onCgiEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class x
  extends an<ban>
{
  public static final a ttF;
  private final String TAG;
  private bam ttD;
  private r<? super Integer, ? super Integer, ? super String, ? super ban, kotlin.x> ttE;
  
  static
  {
    AppMethodBeat.i(242254);
    ttF = new a((byte)0);
    AppMethodBeat.o(242254);
  }
  
  public x(aut paramaut, g paramg, r<? super Integer, ? super Integer, ? super String, ? super ban, kotlin.x> paramr)
  {
    AppMethodBeat.i(242253);
    this.ttE = paramr;
    this.TAG = "Finder.CgiFinderPostLiveAppMsg";
    this.ttD = new bam();
    this.ttD.LFp = com.tencent.mm.bw.b.cD(paramg.hIt);
    this.ttD.uio = paramaut;
    this.ttD.hyH = paramg.liveInfo.liveId;
    this.ttD.object_id = paramg.hFK;
    this.ttD.object_nonce_id = paramg.hwg;
    paramaut = this.ttD;
    paramg = m.vVH;
    int i;
    if (m.dBP())
    {
      paramg = o.m.hHB;
      i = o.m.aFV();
      paramaut.scene = i;
      this.ttD.LAt = z.aUg();
      paramaut = this.ttD;
      paramg = am.tuw;
      paramaut.LAI = am.cXY();
      paramaut = new d.a();
      paramaut.c((a)this.ttD);
      paramg = new ban();
      paramg.setBaseResponse(new BaseResponse());
      paramg.getBaseResponse().ErrMsg = new dqi();
      paramaut.d((a)paramg);
      paramaut.MB("/cgi-bin/micromsg-bin/finderpostliveappmsg");
      paramaut.sG(6888);
      c(paramaut.aXF());
      paramg = this.TAG;
      paramr = new StringBuilder("CgiFinderPostLiveAppMsg init ").append(this.ttD.hyH).append(",msgType ");
      paramaut = this.ttD.uio;
      if (paramaut == null) {
        break label341;
      }
    }
    label341:
    for (paramaut = Integer.valueOf(paramaut.ybm);; paramaut = null)
    {
      Log.i(paramg, paramaut);
      AppMethodBeat.o(242253);
      return;
      paramg = com.tencent.mm.live.core.core.d.b.hCo;
      if (b.a.aDp())
      {
        paramg = o.m.hHB;
        i = o.m.aFW();
        break;
      }
      paramg = o.m.hHB;
      i = o.m.aFW();
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderPostLiveAppMsg$Companion;", "", "()V", "genComplaintMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "genReplyCommentMsg", "atUser", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "replyContent", "", "getHighlightCheerMsg", "getTickleMsg", "tickleUser", "plugin-finder_release"})
  public static final class a
  {
    public static aut a(avn paramavn, String paramString)
    {
      AppMethodBeat.i(242251);
      p.h(paramavn, "atUser");
      p.h(paramString, "replyContent");
      aut localaut = new aut();
      localaut.LFz = paramavn;
      paramavn = new avb();
      paramavn.content = paramString;
      localaut.LFB = com.tencent.mm.bw.b.cD(paramavn.toByteArray());
      paramavn = o.l.hHy;
      localaut.ybm = o.l.aFP();
      localaut.LFr = (z.aTY() + System.currentTimeMillis());
      AppMethodBeat.o(242251);
      return localaut;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.x
 * JD-Core Version:    0.7.0.1
 */