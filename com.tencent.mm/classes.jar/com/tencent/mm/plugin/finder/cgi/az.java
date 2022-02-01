package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pullScene", "verifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;", "(JLjava/lang/String;IILjava/lang/String;ZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;JLjava/lang/String;ZZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;)V", "getDown", "()Z", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "getEnterScene", "()I", "getFeedUsername", "()Ljava/lang/String;", "getJustUpdateObjectStatus", "getPullScene", "rootCommentId", "getScene", "getVerifyInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;", "filterDuplicate", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "svrComment", "isEnableReport", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
  extends c<ayl>
{
  public static final a AAS;
  private final String AAT;
  private boolean AAU;
  private au AAV;
  private final long AAW;
  private final boolean AAX;
  private final int AAY;
  private final bkr AAZ;
  private com.tencent.mm.plugin.findersdk.b.a.b AAa;
  private long ABa;
  private final boolean aLv;
  private final int enterScene;
  private final long feedId;
  private final String objectNonceId;
  private final int scene;
  private String username;
  
  static
  {
    AppMethodBeat.i(165180);
    AAS = new a((byte)0);
    AppMethodBeat.o(165180);
  }
  
  private az(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, com.tencent.mm.bx.b paramb, au paramau, long paramLong2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, bui parambui, int paramInt3, bkr parambkr)
  {
    super(parambui);
    AppMethodBeat.i(336194);
    this.feedId = paramLong1;
    this.objectNonceId = paramString1;
    this.enterScene = paramInt1;
    this.scene = paramInt2;
    this.AAT = paramString2;
    this.AAU = paramBoolean1;
    this.AAV = paramau;
    this.AAW = paramLong2;
    this.username = paramString3;
    this.aLv = paramBoolean2;
    this.AAX = paramBoolean3;
    this.AAY = paramInt3;
    this.AAZ = parambkr;
    paramString1 = this.AAV;
    if (paramString1 == null)
    {
      paramLong1 = 0L;
      this.ABa = paramLong1;
      paramString2 = new c.a();
      paramString1 = new ayk();
      paramString1.hKN = this.feedId;
      paramString1.objectNonceId = this.objectNonceId;
      if (BuildInfo.DEBUG)
      {
        paramau = (CharSequence)this.objectNonceId;
        if ((paramau != null) && (paramau.length() != 0)) {
          break label765;
        }
        paramInt1 = 1;
        label190:
        if (paramInt1 == 0) {
          s.p(String.valueOf(this.feedId), this.objectNonceId);
        }
      }
      if (!s.p(Boolean.valueOf(this.AAU), Boolean.TRUE)) {
        break label771;
      }
      paramInt1 = 1;
      label229:
      paramString1.ZJf = paramInt1;
      paramString1.lastBuffer = paramb;
      paramString1.ZJe = 0L;
      paramString1.ZJg = paramString4;
      if (Util.isNullOrNil(this.username)) {
        break label777;
      }
      paramString1.finderUsername = this.username;
      label270:
      if (this.AAW != 0L) {
        paramString1.AAW = this.AAW;
      }
      paramString1.ABa = this.ABa;
      if (!this.aLv) {
        break label787;
      }
      paramInt1 = 2;
      label305:
      paramString1.direction = paramInt1;
      paramString1.scene = this.enterScene;
      paramau = bi.ABn;
      paramString1.CJv = bi.a(parambui);
      paramInt1 = this.scene;
      paramInt2 = this.enterScene;
      paramau = this.AAT;
      s.u(paramau, "feedUsername");
      Log.i("Finder.CgiGetFinderFeedComment", "getIdScene scene:" + paramInt1 + ", commentScene:" + paramInt2);
      paramString3 = d.FAy;
      if (((Number)d.eSA().bmg()).intValue() == 1) {
        break label799;
      }
      paramString3 = d.FAy;
      if (d.eRy() != 1) {
        break label799;
      }
      paramString3 = av.GiL;
      if (!av.Iz(paramau)) {
        break label793;
      }
      paramInt1 = 1;
      label439:
      paramString1.ZJh = paramInt1;
      paramString1.AAY = this.AAY;
      paramau = k.aeZF;
      paramau = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      paramString1.longitude = ((Number)paramau.bsC).floatValue();
      paramString1.latitude = ((Number)paramau.bsD).floatValue();
      paramau = this.AAZ;
      if (paramau != null) {
        paramString1.ZJk = paramau;
      }
      paramau = bi.ABn;
      paramString1.ZDQ = bi.bTZ();
      paramString2.otE = ((a)paramString1);
      paramau = new ayl();
      paramau.setBaseResponse(new kd());
      paramau.getBaseResponse().akjO = new etl();
      paramString2.otF = ((a)paramau);
      paramString2.uri = "/cgi-bin/micromsg-bin/findergetcommentdetail";
      paramString2.funcId = 3763;
      c(paramString2.bEF());
      paramString2 = new StringBuilder("CgiGetFinderFeedComment init identityScene:").append(paramString1.ZJh).append(", feedId=").append(this.feedId).append(" lastBuffer=");
      if (paramb == null) {
        break label837;
      }
      paramBoolean1 = true;
      label664:
      paramString2 = paramString2.append(paramBoolean1).append(" isSecondCommentFetch=");
      if (this.AAV == null) {
        break label843;
      }
    }
    label771:
    label777:
    label787:
    label793:
    label799:
    label837:
    label843:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      Log.i("Finder.CgiGetFinderFeedComment", paramBoolean1 + " scene " + paramString1.scene + ", justUpdateObjectStatus:" + this.AAX + ", encryptedObjectid:" + paramString4);
      this.AAa = com.tencent.mm.plugin.findersdk.b.a.b.Hdf;
      AppMethodBeat.o(336194);
      return;
      paramLong1 = paramString1.eZI().commentId;
      break;
      label765:
      paramInt1 = 0;
      break label190;
      paramInt1 = 0;
      break label229;
      paramString1.finderUsername = z.bAW();
      break label270;
      paramInt1 = 1;
      break label305;
      paramInt1 = 3;
      break label439;
      if (paramInt2 == 7)
      {
        paramInt1 = 1;
        break label439;
      }
      if ((paramInt2 == 8) && (paramInt1 == 1))
      {
        paramInt1 = 1;
        break label439;
      }
      paramInt1 = 2;
      break label439;
      paramBoolean1 = false;
      break label664;
    }
  }
  
  private static LinkedList<FinderCommentInfo> ag(LinkedList<FinderCommentInfo> paramLinkedList)
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
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return this.AAa;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment$Companion;", "", "()V", "getIdScene", "", "scene", "commentScene", "feedUsername", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.az
 * JD-Core Version:    0.7.0.1
 */