package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderPostLiveAppMsg;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "callBack", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lkotlin/jvm/functions/Function4;)V", "TAG", "getCallBack", "()Lkotlin/jvm/functions/Function4;", "setCallBack", "(Lkotlin/jvm/functions/Function4;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgRequest;", "initReqResp", "onCgiEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends c<bsq>
{
  public static final a CvN;
  private kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super bsq, ah> CvO;
  private bsp CvP;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(351188);
    CvN = new a((byte)0);
    AppMethodBeat.o(351188);
  }
  
  public x(bdm parambdm, com.tencent.mm.plugin.finder.live.model.context.a parama, bui parambui, kotlin.g.a.r<? super Integer, ? super Integer, ? super String, ? super bsq, ah> paramr)
  {
    super(parambui);
    AppMethodBeat.i(351177);
    this.CvO = paramr;
    this.TAG = "Finder.CgiFinderPostLiveAppMsg";
    this.CvP = new bsp();
    this.CvP.YJa = b.cX(((f)((e)parama.business(e.class)).business(f.class)).mZp);
    this.CvP.CER = parambdm;
    this.CvP.mMJ = ((f)parama.business(f.class)).liveInfo.liveId;
    this.CvP.object_id = ((f)parama.business(f.class)).hKN;
    this.CvP.object_nonce_id = ((f)parama.business(f.class)).nonceId;
    parambdm = this.CvP;
    paramr = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int i;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramr = l.k.mYO;
      i = l.k.bhG();
      parambdm.scene = i;
      this.CvP.YIZ = z.bAW();
      parambdm = this.CvP;
      paramr = bi.ABn;
      parambdm.ZEc = bi.dVu();
      parambdm = bi.ABn;
      parambdm = this.CvP.ZEc;
      if (parambui != null) {
        break label415;
      }
      i = 0;
      label221:
      bi.a(parambdm, p.listOf(new kotlin.r(Integer.valueOf(i), Long.valueOf(((f)parama.business(f.class)).hKN))));
      parambdm = new c.a();
      parambdm.otE = ((com.tencent.mm.bx.a)this.CvP);
      parama = new bsq();
      parama.setBaseResponse(new kd());
      parama.getBaseResponse().akjO = new etl();
      parambdm.otF = ((com.tencent.mm.bx.a)parama);
      parambdm.uri = "/cgi-bin/micromsg-bin/finderpostliveappmsg";
      parambdm.funcId = 6888;
      c(parambdm.bEF());
      parama = this.TAG;
      parambui = new StringBuilder("CgiFinderPostLiveAppMsg init ").append(this.CvP.mMJ).append(",msgType ");
      parambdm = this.CvP.CER;
      if (parambdm != null) {
        break label424;
      }
    }
    label415:
    label424:
    for (parambdm = null;; parambdm = Integer.valueOf(parambdm.msg_type))
    {
      Log.i(parama, parambdm);
      AppMethodBeat.o(351177);
      return;
      paramr = l.k.mYO;
      i = l.k.bhH();
      break;
      i = parambui.hLK;
      break label221;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderPostLiveAppMsg$Companion;", "", "()V", "genApplaudMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "genAtWxFriendCommentMsg", "atUser", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "replyContent", "", "genComplaintMsg", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgSeq", "", "genLocationMsg", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "extraFastCommentContent", "genReplyCommentMsg", "cdnServerIp", "getHighlightCheerMsg", "getTickleMsg", "tickleUser", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static bdm a(bgh parambgh, String paramString1, String paramString2)
    {
      AppMethodBeat.i(351103);
      s.u(parambgh, "atUser");
      s.u(paramString1, "replyContent");
      bdm localbdm = new bdm();
      localbdm.ZNW = parambgh;
      parambgh = new bes();
      parambgh.content = paramString1;
      paramString1 = new bsr();
      paramString1.aaav = paramString2;
      paramString2 = ah.aiuX;
      parambgh.ZPb = paramString1;
      paramString1 = ah.aiuX;
      localbdm.ZNY = b.cX(parambgh.toByteArray());
      localbdm.msg_type = 20002;
      localbdm.Tro = s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(351103);
      return localbdm;
    }
    
    public static bdm k(List<? extends bgh> paramList, String paramString)
    {
      ah localah = null;
      AppMethodBeat.i(351115);
      s.u(paramList, "atUser");
      s.u(paramString, "replyContent");
      bdm localbdm = new bdm();
      Iterator localIterator = ((Iterable)paramList).iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localObject1 = ((bgh)localObject2).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          label73:
          if (!s.p(localObject1, "notify@all")) {
            break label181;
          }
          localObject1 = localObject2;
          label85:
          if ((bgh)localObject1 != null) {
            break label188;
          }
        }
      }
      for (Object localObject1 = localah;; localObject1 = ah.aiuX)
      {
        if (localObject1 == null)
        {
          localbdm.msg_type = 20034;
          localObject1 = new bed();
          ((bed)localObject1).content = paramString;
          ((bed)localObject1).ZOH = new LinkedList((Collection)paramList);
          paramList = ah.aiuX;
          localbdm.ZNY = b.cX(((bed)localObject1).toByteArray());
        }
        localbdm.Tro = s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(351115);
        return localbdm;
        localObject1 = ((FinderContact)localObject1).username;
        break label73;
        label181:
        break;
        localObject1 = null;
        break label85;
        label188:
        localbdm.msg_type = 20032;
        localObject1 = new bed();
        ((bed)localObject1).content = paramString;
        localah = ah.aiuX;
        localbdm.ZNY = b.cX(((bed)localObject1).toByteArray());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.x
 * JD-Core Version:    0.7.0.1
 */