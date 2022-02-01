package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.model.a.a;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.glm;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "finderUsername", "", "finderDescObject", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "ticket", "Lcom/tencent/mm/protobuf/ByteString;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "visibilityMode", "", "visibilityList", "Ljava/util/LinkedList;", "visibilityRoomList", "visibilityUserList", "luckyMoneyChatroomList", "gameAppId", "scene", "wxaGameLiveInfo", "Lcom/tencent/mm/protocal/protobuf/WxaGameLiveInfo;", "liveChargePost", "Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;ILjava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/WxaGameLiveInfo;Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;)V", "TAG", "getLiveChargePost", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends o<awc>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private final bfy CJb;
  private a CJc;
  private awb CJd;
  private final String TAG;
  
  private i(String paramString1, FinderObjectDesc paramFinderObjectDesc, bno parambno, int paramInt1, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, String paramString2, int paramInt2, glm paramglm, bfy parambfy, bui parambui, a parama)
  {
    AppMethodBeat.i(360347);
    this.CJb = parambfy;
    this.TAG = "Finder.CgiFinderCreateLive";
    this.CJc = parama;
    this.CJd = new awb();
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    parambfy = this.CJd;
    parama = bi.ABn;
    parambfy.ZEc = bi.a(parambui);
    this.CJd.objectDesc = paramFinderObjectDesc;
    this.CJd.ZGI = null;
    parambfy = this.CJd;
    parambui = new StringBuilder();
    if (paramString1 == null)
    {
      paramFinderObjectDesc = null;
      parambfy.clientId = (g.getMessageDigest(paramFinderObjectDesc) + '_' + System.currentTimeMillis());
      this.CJd.finderUsername = paramString1;
      this.CJd.ZGK = parambno;
      this.CJd.ZFY = paramInt1;
      this.CJd.ZFZ = paramLinkedList1;
      this.CJd.ZGb = paramLinkedList2;
      this.CJd.ZGL = paramLinkedList4;
      this.CJd.ZGc = paramLinkedList3;
      this.CJd.ZGM = paramString2;
      this.CJd.scene = paramInt2;
      this.CJd.ZGT = paramglm;
      paramFinderObjectDesc = this.CJb;
      if ((paramFinderObjectDesc == null) || (paramFinderObjectDesc.ZGN != 2)) {
        break label958;
      }
      paramInt1 = 1;
      label289:
      if (paramInt1 != 0)
      {
        this.CJd.ZGN = this.CJb.ZGN;
        this.CJd.ZGO = this.CJb.ZGO;
        parambno = this.CJd;
        paramFinderObjectDesc = this.CJb.ZPJ;
        if (paramFinderObjectDesc != null) {
          break label964;
        }
        paramFinderObjectDesc = null;
        label341:
        parambno.ZGQ = paramFinderObjectDesc;
        parambno = this.CJd;
        paramFinderObjectDesc = this.CJb.ZPJ;
        if (paramFinderObjectDesc != null) {
          break label972;
        }
        paramFinderObjectDesc = null;
        label365:
        parambno.ZGR = paramFinderObjectDesc;
        this.CJd.ZFY = 0;
      }
    }
    for (;;)
    {
      try
      {
        this.ABH.put("username", paramString1);
        this.ABH.put("clientId", this.CJd.clientId);
        paramFinderObjectDesc = this.ABH;
        paramString1 = this.CJd.ZGK;
        if (paramString1 != null) {
          continue;
        }
        paramString1 = null;
        paramFinderObjectDesc.put("tagId", paramString1);
        paramFinderObjectDesc = this.ABH;
        paramString1 = this.CJd.ZGK;
        if (paramString1 != null) {
          continue;
        }
        paramString1 = null;
        paramFinderObjectDesc.put("tagName", paramString1);
        this.ABH.put("visibilityMode", this.CJd.ZFY);
        paramString1 = this.ABH;
        paramFinderObjectDesc = a.a.CDx;
        paramString1.put("beautyData", a.a.ekb());
      }
      catch (Exception paramString1)
      {
        label958:
        label964:
        label972:
        Log.e(this.TAG, paramString1.toString());
        continue;
        paramString1 = paramString1.xms;
        continue;
        paramString1 = paramString1.ZWk;
        if (paramString1 != null) {
          continue;
        }
        paramString1 = null;
        continue;
        paramString1 = paramString1.xms;
        continue;
        paramString1 = Integer.valueOf(paramString1.ZSe);
        continue;
      }
      paramString1 = new gdd();
      paramString1.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
      paramFinderObjectDesc = this.CJd.ZEc;
      if (paramFinderObjectDesc != null) {
        paramFinderObjectDesc.ZEq = new com.tencent.mm.bx.b(paramString1.toByteArray());
      }
      paramString1 = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999692);
      paramString1 = new c.a();
      paramString1.otE = ((com.tencent.mm.bx.a)this.CJd);
      paramFinderObjectDesc = new awc();
      paramFinderObjectDesc.setBaseResponse(new kd());
      paramFinderObjectDesc.getBaseResponse().akjO = new etl();
      paramString1.otF = ((com.tencent.mm.bx.a)paramFinderObjectDesc);
      paramString1.uri = "/cgi-bin/micromsg-bin/findercreatelive";
      paramString1.funcId = 3686;
      c(paramString1.bEF());
      paramFinderObjectDesc = this.TAG;
      parambno = new StringBuilder();
      paramLinkedList1 = parambno.append("CgiFinderCreateLive init ").append(this.CJd.clientId).append(',').append(this.CJd.finderUsername).append(',').append(this.CJd.objectDesc).append(", tag:[");
      paramString1 = this.CJd.ZGK;
      if (paramString1 != null) {
        continue;
      }
      paramString1 = null;
      paramLinkedList1 = paramLinkedList1.append(paramString1).append('-');
      paramString1 = this.CJd.ZGK;
      if (paramString1 != null) {
        continue;
      }
      paramString1 = null;
      paramLinkedList1.append(paramString1).append("], visibility_mode:").append(this.CJd.ZFY).append(", visible_username_list:").append(this.CJd.ZGc).append(", visibility_file_id_list:").append(this.CJd.ZFZ).append(", visible_chatroom_id_list:").append(this.CJd.ZGb).append(", luckyMoneyChatroom:").append(this.CJd.ZGL).append(", gameAppId:").append(this.CJd.ZGM).append(", gameVersionType:");
      paramString1 = this.CJd.ZGT;
      if (paramString1 != null) {
        continue;
      }
      paramString1 = null;
      paramString1 = parambno.append(paramString1).append(", scene:").append(this.CJd.scene).append(",liveChargePost:[");
      paramLinkedList1 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      paramString1.append(com.tencent.mm.plugin.finder.live.view.convert.a.a(this.CJb)).append(']');
      Log.i(paramFinderObjectDesc, parambno.toString());
      AppMethodBeat.o(360347);
      return;
      paramFinderObjectDesc = paramString1.getBytes(kotlin.n.d.UTF_8);
      s.s(paramFinderObjectDesc, "(this as java.lang.String).getBytes(charset)");
      break;
      paramInt1 = 0;
      break label289;
      paramFinderObjectDesc = paramFinderObjectDesc.ZWy;
      break label341;
      paramFinderObjectDesc = paramFinderObjectDesc.username_list;
      break label365;
      paramString1 = Integer.valueOf(paramString1.ZWi);
      continue;
      paramString1 = paramString1.xms;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, awc paramawc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */