package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.b.g;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "finderUsername", "", "finderDescObject", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "ticket", "Lcom/tencent/mm/protobuf/ByteString;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "visibilityMode", "", "visibilityList", "Ljava/util/LinkedList;", "visibilityRoomList", "visibilityUserList", "luckyMoneyChatroomList", "gameAppId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;ILjava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class i
  extends n<art>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private a yiZ;
  private ars yja;
  
  private i(String paramString1, FinderObjectDesc paramFinderObjectDesc, bda parambda, int paramInt, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, String paramString2, a parama)
  {
    AppMethodBeat.i(283835);
    this.TAG = "Finder.CgiFinderCreateLive";
    this.yiZ = parama;
    this.yja = new ars();
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yja.objectDesc = paramFinderObjectDesc;
    this.yja.SFa = null;
    parama = this.yja;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString1 != null)
    {
      paramFinderObjectDesc = kotlin.n.d.UTF_8;
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(283835);
        throw paramString1;
      }
      paramFinderObjectDesc = paramString1.getBytes(paramFinderObjectDesc);
      p.j(paramFinderObjectDesc, "(this as java.lang.String).getBytes(charset)");
      parama.clientId = (g.getMessageDigest(paramFinderObjectDesc) + '_' + System.currentTimeMillis());
      this.yja.finderUsername = paramString1;
      paramFinderObjectDesc = this.yja;
      parama = ao.xcj;
      paramFinderObjectDesc.SDi = ao.dnO();
      this.yja.SFc = parambda;
      this.yja.SEy = paramInt;
      this.yja.SEz = paramLinkedList1;
      this.yja.SEB = paramLinkedList2;
      this.yja.SFd = paramLinkedList4;
      this.yja.SEC = paramLinkedList3;
      this.yja.SFe = paramString2;
      this.xcu.put("username", paramString1);
      this.xcu.put("clientId", this.yja.clientId);
      paramFinderObjectDesc = this.xcu;
      paramString1 = this.yja.SFc;
      if (paramString1 == null) {
        break label778;
      }
      paramString1 = Integer.valueOf(paramString1.SOi);
      label329:
      paramFinderObjectDesc.put("tagId", paramString1);
      paramFinderObjectDesc = this.xcu;
      paramString1 = this.yja.SFc;
      if (paramString1 == null) {
        break label783;
      }
      paramString1 = paramString1.ugl;
      label359:
      paramFinderObjectDesc.put("tagName", paramString1);
      this.xcu.put("visibilityMode", this.yja.SEy);
      paramString1 = new fgr();
      paramString1.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
      paramFinderObjectDesc = this.yja.SDi;
      if (paramFinderObjectDesc != null) {
        paramFinderObjectDesc.SDs = new com.tencent.mm.cd.b(paramString1.toByteArray());
      }
      paramString1 = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999692);
      paramString1 = new d.a();
      paramString1.c((a)this.yja);
      paramFinderObjectDesc = new art();
      paramFinderObjectDesc.setBaseResponse(new jh());
      paramFinderObjectDesc.getBaseResponse().Tef = new eaf();
      paramString1.d((a)paramFinderObjectDesc);
      paramString1.TW("/cgi-bin/micromsg-bin/findercreatelive");
      paramString1.vD(3686);
      c(paramString1.bgN());
      paramFinderObjectDesc = this.TAG;
      parambda = new StringBuilder("CgiFinderCreateLive init ").append(this.yja.clientId).append(',').append(this.yja.finderUsername).append(',').append(this.yja.objectDesc).append(", tag:[");
      paramString1 = this.yja.SFc;
      if (paramString1 == null) {
        break label788;
      }
      paramString1 = paramString1.ugl;
      label611:
      parambda = parambda.append(paramString1).append('-');
      paramString1 = this.yja.SFc;
      if (paramString1 == null) {
        break label793;
      }
      paramString1 = paramString1.SOk;
      if (paramString1 == null) {
        break label793;
      }
    }
    label778:
    label783:
    label788:
    label793:
    for (paramString1 = paramString1.ugl;; paramString1 = null)
    {
      Log.i(paramFinderObjectDesc, paramString1 + ']' + ", visibility_mode:" + this.yja.SEy + ", usersize:" + this.yja.SEC.size() + ", list size:" + this.yja.SEz.size() + ", visible_chatroom_id_list:" + this.yja.SEB + ", luckyMoneyChatroom:" + this.yja.SFd + ", gameAppId:" + this.yja.SFe);
      AppMethodBeat.o(283835);
      return;
      paramFinderObjectDesc = null;
      break;
      paramString1 = null;
      break label329;
      paramString1 = null;
      break label359;
      paramString1 = null;
      break label611;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, art paramart);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */