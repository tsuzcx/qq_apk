package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pullScene", "(JLjava/lang/String;IILjava/lang/String;ZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;JLjava/lang/String;ZZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "getDown", "()Z", "getEnterScene", "()I", "getFeedUsername", "()Ljava/lang/String;", "getJustUpdateObjectStatus", "getPullScene", "rootCommentId", "getScene", "filterDuplicate", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "svrComment", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class q
  extends w<anh>
{
  public static final a rIL;
  private final long dtq;
  private final int enterScene;
  private final String objectNonceId;
  private long rID;
  private final String rIE;
  private boolean rIF;
  private ab rIG;
  private final long rIH;
  private final boolean rII;
  private final boolean rIJ;
  private final int rIK;
  private final int scene;
  private String username;
  
  static
  {
    AppMethodBeat.i(165180);
    rIL = new a((byte)0);
    AppMethodBeat.o(165180);
  }
  
  private q(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, com.tencent.mm.bx.b paramb, ab paramab, long paramLong2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, aqy paramaqy, int paramInt3)
  {
    super(paramaqy);
    AppMethodBeat.i(201075);
    this.dtq = paramLong1;
    this.objectNonceId = paramString1;
    this.enterScene = paramInt1;
    this.scene = paramInt2;
    this.rIE = paramString2;
    this.rIF = paramBoolean1;
    this.rIG = paramab;
    this.rIH = paramLong2;
    this.username = paramString3;
    this.rII = paramBoolean2;
    this.rIJ = paramBoolean3;
    this.rIK = paramInt3;
    paramString1 = this.rIG;
    if (paramString1 != null)
    {
      paramLong1 = paramString1.field_actionInfo.Gla.commentId;
      this.rID = paramLong1;
      paramString2 = new b.a();
      paramString1 = new ang();
      paramString1.rIZ = this.dtq;
      paramString1.objectNonceId = this.objectNonceId;
      if (!i.DEBUG) {
        break label273;
      }
      paramab = (CharSequence)this.objectNonceId;
      if ((paramab != null) && (paramab.length() != 0)) {
        break label267;
      }
    }
    label267:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 == 0) && (!d.g.b.p.i(String.valueOf(this.dtq), this.objectNonceId))) {
        break label273;
      }
      paramString1 = (Throwable)new RuntimeException(this.dtq + ' ' + this.objectNonceId);
      AppMethodBeat.o(201075);
      throw paramString1;
      paramLong1 = 0L;
      break;
    }
    label273:
    if (d.g.b.p.i(Boolean.valueOf(this.rIF), Boolean.TRUE))
    {
      paramInt1 = 1;
      paramString1.Gmq = paramInt1;
      paramString1.lastBuffer = paramb;
      paramString1.Gmp = 0L;
      paramString1.Gmr = paramString4;
      if (bt.isNullOrNil(this.username)) {
        break label734;
      }
      paramString1.rTn = this.username;
      label333:
      if (this.rIH != 0L) {
        paramString1.rIH = this.rIH;
      }
      paramString1.rID = this.rID;
      if (!this.rII) {
        break label744;
      }
      paramInt1 = 2;
      label368:
      paramString1.direction = paramInt1;
      paramString1.scene = this.enterScene;
      paramab = v.rIR;
      paramString1.Glv = v.a(paramaqy);
      paramInt1 = this.scene;
      paramInt2 = this.enterScene;
      paramab = this.rIE;
      d.g.b.p.h(paramab, "feedUsername");
      ad.i("Finder.CgiGetFinderFeedComment", "getIdScene scene:" + paramInt1 + ", commentScene:" + paramInt2);
      paramString3 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHb().value()).intValue() == 1) {
        break label756;
      }
      paramString3 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cGm() != 1) {
        break label756;
      }
      paramString3 = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.aiX(paramab)) {
        break label750;
      }
      paramInt1 = 1;
      label504:
      paramString1.Gms = paramInt1;
      paramString1.rIK = this.rIK;
      paramString2.c((a)paramString1);
      paramab = new anh();
      paramab.setBaseResponse(new BaseResponse());
      paramab.getBaseResponse().ErrMsg = new cwt();
      paramString2.d((a)paramab);
      paramString2.Dl("/cgi-bin/micromsg-bin/findergetcommentdetail");
      paramString2.oP(3763);
      c(paramString2.aDC());
      paramString2 = new StringBuilder("CgiGetFinderFeedComment init identityScene:").append(paramString1.Gms).append(", feedId=").append(this.dtq).append(" lastBuffer=");
      if (paramb == null) {
        break label794;
      }
      paramBoolean1 = true;
      paramString2 = paramString2.append(paramBoolean1).append(" isSecondCommentFetch=");
      if (this.rIG == null) {
        break label800;
      }
    }
    label645:
    label794:
    label800:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ad.i("Finder.CgiGetFinderFeedComment", paramBoolean1 + " scene " + paramString1.scene + ", justUpdateObjectStatus:" + this.rIJ + ", encryptedObjectid:" + paramString4);
      AppMethodBeat.o(201075);
      return;
      paramInt1 = 0;
      break;
      label734:
      paramString1.rTn = u.aAu();
      break label333;
      label744:
      paramInt1 = 1;
      break label368;
      label750:
      paramInt1 = 3;
      break label504;
      label756:
      if (paramInt2 == 7)
      {
        paramInt1 = 1;
        break label504;
      }
      if ((paramInt2 == 8) && (paramInt1 == 1))
      {
        paramInt1 = 1;
        break label504;
      }
      paramInt1 = 2;
      break label504;
      paramBoolean1 = false;
      break label645;
    }
  }
  
  private static LinkedList<FinderCommentInfo> ad(LinkedList<FinderCommentInfo> paramLinkedList)
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
      ad.w("Finder.CgiGetFinderFeedComment", "filterDuplicate " + localFinderCommentInfo.commentId + " content " + localFinderCommentInfo.content + " username " + localFinderCommentInfo.username);
    }
    AppMethodBeat.o(165177);
    return localLinkedList;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment$Companion;", "", "()V", "getIdScene", "", "scene", "commentScene", "feedUsername", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.q
 * JD-Core Version:    0.7.0.1
 */