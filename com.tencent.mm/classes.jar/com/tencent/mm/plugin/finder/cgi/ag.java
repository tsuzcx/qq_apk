package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pullScene", "verifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;", "(JLjava/lang/String;IILjava/lang/String;ZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;JLjava/lang/String;ZZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;)V", "getDown", "()Z", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "getEnterScene", "()I", "getFeedUsername", "()Ljava/lang/String;", "getJustUpdateObjectStatus", "getPullScene", "rootCommentId", "getScene", "getVerifyInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;", "filterDuplicate", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "svrComment", "isEnableReport", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public final class ag
  extends c<att>
{
  public static final a xbY;
  private final int enterScene;
  private final long feedId;
  private final String objectNonceId;
  private final int scene;
  private String username;
  private long xbP;
  private final String xbQ;
  private boolean xbR;
  private am xbS;
  private final long xbT;
  private final boolean xbU;
  private final boolean xbV;
  private final int xbW;
  private final bbk xbX;
  private com.tencent.mm.plugin.findersdk.b.a.b xbn;
  
  static
  {
    AppMethodBeat.i(165180);
    xbY = new a((byte)0);
    AppMethodBeat.o(165180);
  }
  
  private ag(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, com.tencent.mm.cd.b paramb, am paramam, long paramLong2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, bid parambid, int paramInt3, bbk parambbk)
  {
    super(parambid);
    AppMethodBeat.i(280083);
    this.feedId = paramLong1;
    this.objectNonceId = paramString1;
    this.enterScene = paramInt1;
    this.scene = paramInt2;
    this.xbQ = paramString2;
    this.xbR = paramBoolean1;
    this.xbS = paramam;
    this.xbT = paramLong2;
    this.username = paramString3;
    this.xbU = paramBoolean2;
    this.xbV = paramBoolean3;
    this.xbW = paramInt3;
    this.xbX = parambbk;
    paramString1 = this.xbS;
    if (paramString1 != null)
    {
      paramLong1 = paramString1.dYY().commentId;
      this.xbP = paramLong1;
      paramString2 = new d.a();
      paramString1 = new ats();
      paramString1.xbk = this.feedId;
      paramString1.objectNonceId = this.objectNonceId;
      if (BuildInfo.DEBUG)
      {
        paramam = (CharSequence)this.objectNonceId;
        if ((paramam != null) && (paramam.length() != 0)) {
          break label754;
        }
        paramInt1 = 1;
        label196:
        if (paramInt1 == 0) {
          p.h(String.valueOf(this.feedId), this.objectNonceId);
        }
      }
      if (!p.h(Boolean.valueOf(this.xbR), Boolean.TRUE)) {
        break label760;
      }
      paramInt1 = 1;
      label235:
      paramString1.SGs = paramInt1;
      paramString1.lastBuffer = paramb;
      paramString1.SGr = 0L;
      paramString1.SGt = paramString4;
      if (Util.isNullOrNil(this.username)) {
        break label766;
      }
      paramString1.finderUsername = this.username;
      label276:
      if (this.xbT != 0L) {
        paramString1.xbT = this.xbT;
      }
      paramString1.xbP = this.xbP;
      if (!this.xbU) {
        break label776;
      }
      paramInt1 = 2;
      label311:
      paramString1.direction = paramInt1;
      paramString1.scene = this.enterScene;
      paramam = ao.xcj;
      paramString1.yjp = ao.a(parambid);
      paramInt1 = this.scene;
      paramInt2 = this.enterScene;
      paramam = this.xbQ;
      p.k(paramam, "feedUsername");
      Log.i("Finder.CgiGetFinderFeedComment", "getIdScene scene:" + paramInt1 + ", commentScene:" + paramInt2);
      paramString3 = d.AjH;
      if (((Number)d.dUh().aSr()).intValue() == 1) {
        break label788;
      }
      paramString3 = d.AjH;
      if (d.dTj() != 1) {
        break label788;
      }
      paramString3 = aj.AGc;
      if (!aj.PE(paramam)) {
        break label782;
      }
      paramInt1 = 1;
      label446:
      paramString1.SGu = paramInt1;
      paramString1.xbW = this.xbW;
      paramam = g.Xox;
      paramam = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
      paramString1.longitude = ((Number)paramam.Mx).floatValue();
      paramString1.latitude = ((Number)paramam.My).floatValue();
      paramam = this.xbX;
      if (paramam != null) {
        paramString1.SGx = paramam;
      }
      paramString2.c((com.tencent.mm.cd.a)paramString1);
      paramam = new att();
      paramam.setBaseResponse(new jh());
      paramam.getBaseResponse().Tef = new eaf();
      paramString2.d((com.tencent.mm.cd.a)paramam);
      paramString2.TW("/cgi-bin/micromsg-bin/findergetcommentdetail");
      paramString2.vD(3763);
      c(paramString2.bgN());
      paramString2 = new StringBuilder("CgiGetFinderFeedComment init identityScene:").append(paramString1.SGu).append(", feedId=").append(this.feedId).append(" lastBuffer=");
      if (paramb == null) {
        break label826;
      }
      paramBoolean1 = true;
      label659:
      paramString2 = paramString2.append(paramBoolean1).append(" isSecondCommentFetch=");
      if (this.xbS == null) {
        break label832;
      }
    }
    label776:
    label782:
    label788:
    label826:
    label832:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      Log.i("Finder.CgiGetFinderFeedComment", paramBoolean1 + " scene " + paramString1.scene + ", justUpdateObjectStatus:" + this.xbV + ", encryptedObjectid:" + paramString4);
      this.xbn = com.tencent.mm.plugin.findersdk.b.a.b.BvV;
      AppMethodBeat.o(280083);
      return;
      paramLong1 = 0L;
      break;
      label754:
      paramInt1 = 0;
      break label196;
      label760:
      paramInt1 = 0;
      break label235;
      label766:
      paramString1.finderUsername = z.bdh();
      break label276;
      paramInt1 = 1;
      break label311;
      paramInt1 = 3;
      break label446;
      if (paramInt2 == 7)
      {
        paramInt1 = 1;
        break label446;
      }
      if ((paramInt2 == 8) && (paramInt1 == 1))
      {
        paramInt1 = 1;
        break label446;
      }
      paramInt1 = 2;
      break label446;
      paramBoolean1 = false;
      break label659;
    }
  }
  
  private static LinkedList<FinderCommentInfo> ac(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(165177);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = ((Iterable)paramLinkedList).iterator();
    while (localIterator1.hasNext())
    {
      FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)localIterator1.next();
      Iterator localIterator2 = ((Iterable)localLinkedList).iterator();
      label55:
      int i;
      if (localIterator2.hasNext())
      {
        paramLinkedList = localIterator2.next();
        if (((FinderCommentInfo)paramLinkedList).commentId == localFinderCommentInfo.commentId)
        {
          i = 1;
          label91:
          if (i == 0) {
            break label112;
          }
        }
      }
      for (;;)
      {
        if (paramLinkedList != null) {
          break label119;
        }
        localLinkedList.add(localFinderCommentInfo);
        break;
        i = 0;
        break label91;
        label112:
        break label55;
        paramLinkedList = null;
      }
      label119:
      Log.w("Finder.CgiGetFinderFeedComment", "filterDuplicate " + localFinderCommentInfo.commentId + " content " + localFinderCommentInfo.content + " username " + localFinderCommentInfo.username);
    }
    AppMethodBeat.o(165177);
    return localLinkedList;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return this.xbn;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment$Companion;", "", "()V", "getIdScene", "", "scene", "commentScene", "feedUsername", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ag
 * JD-Core Version:    0.7.0.1
 */