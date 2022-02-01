package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pullScene", "(JLjava/lang/String;IILjava/lang/String;ZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;JLjava/lang/String;ZZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "getDown", "()Z", "getEnterScene", "()I", "getFeedUsername", "()Ljava/lang/String;", "getJustUpdateObjectStatus", "getPullScene", "rootCommentId", "getScene", "filterDuplicate", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "svrComment", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class q
  extends w<anu>
{
  public static final a rQV;
  private final long duw;
  private final int enterScene;
  private final String objectNonceId;
  private long rQN;
  private final String rQO;
  private boolean rQP;
  private ab rQQ;
  private final long rQR;
  private final boolean rQS;
  private final boolean rQT;
  private final int rQU;
  private final int scene;
  private String username;
  
  static
  {
    AppMethodBeat.i(165180);
    rQV = new a((byte)0);
    AppMethodBeat.o(165180);
  }
  
  private q(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, com.tencent.mm.bw.b paramb, ab paramab, long paramLong2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, arn paramarn, int paramInt3)
  {
    super(paramarn);
    AppMethodBeat.i(201493);
    this.duw = paramLong1;
    this.objectNonceId = paramString1;
    this.enterScene = paramInt1;
    this.scene = paramInt2;
    this.rQO = paramString2;
    this.rQP = paramBoolean1;
    this.rQQ = paramab;
    this.rQR = paramLong2;
    this.username = paramString3;
    this.rQS = paramBoolean2;
    this.rQT = paramBoolean3;
    this.rQU = paramInt3;
    paramString1 = this.rQQ;
    if (paramString1 != null)
    {
      paramLong1 = paramString1.cLl().commentId;
      this.rQN = paramLong1;
      paramString2 = new b.a();
      paramString1 = new ant();
      paramString1.rRn = this.duw;
      paramString1.objectNonceId = this.objectNonceId;
      if (!j.DEBUG) {
        break label270;
      }
      paramab = (CharSequence)this.objectNonceId;
      if ((paramab != null) && (paramab.length() != 0)) {
        break label264;
      }
    }
    label264:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 == 0) && (!d.g.b.p.i(String.valueOf(this.duw), this.objectNonceId))) {
        break label270;
      }
      paramString1 = (Throwable)new RuntimeException(this.duw + ' ' + this.objectNonceId);
      AppMethodBeat.o(201493);
      throw paramString1;
      paramLong1 = 0L;
      break;
    }
    label270:
    if (d.g.b.p.i(Boolean.valueOf(this.rQP), Boolean.TRUE))
    {
      paramInt1 = 1;
      paramString1.GFy = paramInt1;
      paramString1.lastBuffer = paramb;
      paramString1.GFx = 0L;
      paramString1.GFz = paramString4;
      if (bu.isNullOrNil(this.username)) {
        break label730;
      }
      paramString1.sbR = this.username;
      label330:
      if (this.rQR != 0L) {
        paramString1.rQR = this.rQR;
      }
      paramString1.rQN = this.rQN;
      if (!this.rQS) {
        break label740;
      }
      paramInt1 = 2;
      label365:
      paramString1.direction = paramInt1;
      paramString1.scene = this.enterScene;
      paramab = v.rRb;
      paramString1.GDR = v.a(paramarn);
      paramInt1 = this.scene;
      paramInt2 = this.enterScene;
      paramab = this.rQO;
      d.g.b.p.h(paramab, "feedUsername");
      ae.i("Finder.CgiGetFinderFeedComment", "getIdScene scene:" + paramInt1 + ", commentScene:" + paramInt2);
      paramString3 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cJa().value()).intValue() == 1) {
        break label752;
      }
      paramString3 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cIj() != 1) {
        break label752;
      }
      paramString3 = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.ajU(paramab)) {
        break label746;
      }
      paramInt1 = 1;
      label500:
      paramString1.GFA = paramInt1;
      paramString1.rQU = this.rQU;
      paramString2.c((a)paramString1);
      paramab = new anu();
      paramab.setBaseResponse(new BaseResponse());
      paramab.getBaseResponse().ErrMsg = new cxn();
      paramString2.d((a)paramab);
      paramString2.DN("/cgi-bin/micromsg-bin/findergetcommentdetail");
      paramString2.oS(3763);
      c(paramString2.aDS());
      paramString2 = new StringBuilder("CgiGetFinderFeedComment init identityScene:").append(paramString1.GFA).append(", feedId=").append(this.duw).append(" lastBuffer=");
      if (paramb == null) {
        break label790;
      }
      paramBoolean1 = true;
      paramString2 = paramString2.append(paramBoolean1).append(" isSecondCommentFetch=");
      if (this.rQQ == null) {
        break label796;
      }
    }
    label641:
    label790:
    label796:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ae.i("Finder.CgiGetFinderFeedComment", paramBoolean1 + " scene " + paramString1.scene + ", justUpdateObjectStatus:" + this.rQT + ", encryptedObjectid:" + paramString4);
      AppMethodBeat.o(201493);
      return;
      paramInt1 = 0;
      break;
      label730:
      paramString1.sbR = com.tencent.mm.model.v.aAK();
      break label330;
      label740:
      paramInt1 = 1;
      break label365;
      label746:
      paramInt1 = 3;
      break label500;
      label752:
      if (paramInt2 == 7)
      {
        paramInt1 = 1;
        break label500;
      }
      if ((paramInt2 == 8) && (paramInt1 == 1))
      {
        paramInt1 = 1;
        break label500;
      }
      paramInt1 = 2;
      break label500;
      paramBoolean1 = false;
      break label641;
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
      ae.w("Finder.CgiGetFinderFeedComment", "filterDuplicate " + localFinderCommentInfo.commentId + " content " + localFinderCommentInfo.content + " username " + localFinderCommentInfo.username);
    }
    AppMethodBeat.o(165177);
    return localLinkedList;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment$Companion;", "", "()V", "getIdScene", "", "scene", "commentScene", "feedUsername", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.q
 * JD-Core Version:    0.7.0.1
 */