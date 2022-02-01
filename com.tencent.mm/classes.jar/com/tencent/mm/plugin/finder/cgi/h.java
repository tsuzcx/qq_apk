package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILjava/lang/String;ZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;JLjava/lang/String;ZZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getDown", "()Z", "getEnterScene", "()I", "getFeedUsername", "()Ljava/lang/String;", "getJustUpdateObjectStatus", "rootCommentId", "getScene", "filterDuplicate", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "svrComment", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class h
  extends an<aiw>
{
  public static final a qoJ;
  private final int enterScene;
  private final long feedId;
  private final String objectNonceId;
  private final String qVj;
  private long qoB;
  private boolean qoC;
  private com.tencent.mm.plugin.finder.storage.k qoD;
  private final long qoE;
  private final boolean qoF;
  private final boolean qoG;
  private final int scene;
  private String username;
  
  static
  {
    AppMethodBeat.i(165180);
    qoJ = new a((byte)0);
    AppMethodBeat.o(165180);
  }
  
  private h(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, com.tencent.mm.bx.b paramb, com.tencent.mm.plugin.finder.storage.k paramk, long paramLong2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197263);
    this.feedId = paramLong1;
    this.objectNonceId = paramString1;
    this.enterScene = paramInt1;
    this.scene = paramInt2;
    this.qVj = paramString2;
    this.qoC = paramBoolean1;
    this.qoD = paramk;
    this.qoE = paramLong2;
    this.username = paramString3;
    this.qoF = paramBoolean2;
    this.qoG = paramBoolean3;
    paramString1 = this.qoD;
    if (paramString1 != null)
    {
      paramLong1 = paramString1.field_actionInfo.Dkk.commentId;
      this.qoB = paramLong1;
      paramString2 = new b.a();
      paramString1 = new aiv();
      paramString1.objectId = this.feedId;
      paramString1.objectNonceId = this.objectNonceId;
      if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
        break label267;
      }
      paramk = (CharSequence)this.objectNonceId;
      if ((paramk != null) && (paramk.length() != 0)) {
        break label261;
      }
    }
    label261:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 == 0) && (!d.g.b.k.g(String.valueOf(this.feedId), this.objectNonceId))) {
        break label267;
      }
      paramString1 = (Throwable)new RuntimeException(this.feedId + ' ' + this.objectNonceId);
      AppMethodBeat.o(197263);
      throw paramString1;
      paramLong1 = 0L;
      break;
    }
    label267:
    if (d.g.b.k.g(Boolean.valueOf(this.qoC), Boolean.TRUE))
    {
      paramInt1 = 1;
      paramString1.Dlk = paramInt1;
      paramString1.lastBuffer = paramb;
      paramString1.Dlj = 0L;
      paramString1.Dll = paramString4;
      if (bt.isNullOrNil(this.username)) {
        break label709;
      }
      paramString1.finderUsername = this.username;
      label327:
      if (this.qoE != 0L) {
        paramString1.qoE = this.qoE;
      }
      paramString1.qoB = this.qoB;
      if (!this.qoF) {
        break label719;
      }
      paramInt1 = 2;
      label362:
      paramString1.direction = paramInt1;
      paramString1.scene = this.enterScene;
      paramk = am.KJy;
      paramString1.Dkw = am.a(paramdzp);
      paramInt1 = this.scene;
      paramInt2 = this.enterScene;
      paramk = this.qVj;
      d.g.b.k.h(paramk, "feedUsername");
      ad.i("Finder.CgiGetFinderFeedComment", "getIdScene scene:" + paramInt1 + ", commentScene:" + paramInt2);
      paramString3 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.cqa()) {
        break label731;
      }
      paramString3 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUn() != 1) {
        break label731;
      }
      paramString3 = i.qTa;
      if (!i.ZR(paramk)) {
        break label725;
      }
      paramInt1 = 1;
      label487:
      paramString1.Lxs = paramInt1;
      paramString2.c((a)paramString1);
      paramk = new aiw();
      paramk.setBaseResponse(new BaseResponse());
      paramk.getBaseResponse().ErrMsg = new cmf();
      paramString2.d((a)paramk);
      paramString2.wg("/cgi-bin/micromsg-bin/findergetcommentdetail");
      paramString2.nB(3763);
      c(paramString2.atI());
      paramString2 = new StringBuilder("CgiGetFinderFeedComment init identityScene:").append(paramString1.Lxs).append(", feedId=").append(this.feedId).append(" lastBuffer=");
      if (paramb == null) {
        break label757;
      }
      paramBoolean1 = true;
      label620:
      paramString2 = paramString2.append(paramBoolean1).append(" isSecondCommentFetch=");
      if (this.qoD == null) {
        break label763;
      }
    }
    label709:
    label719:
    label725:
    label731:
    label757:
    label763:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ad.i("Finder.CgiGetFinderFeedComment", paramBoolean1 + " scene " + paramString1.scene + ", justUpdateObjectStatus:" + this.qoG + ", encryptedObjectid:" + paramString4);
      AppMethodBeat.o(197263);
      return;
      paramInt1 = 0;
      break;
      paramString1.finderUsername = u.aqO();
      break label327;
      paramInt1 = 1;
      break label362;
      paramInt1 = 3;
      break label487;
      if ((paramInt2 == 7) || (paramInt2 == 8))
      {
        paramInt1 = 1;
        break label487;
      }
      paramInt1 = 2;
      break label487;
      paramBoolean1 = false;
      break label620;
    }
  }
  
  private static LinkedList<FinderCommentInfo> ab(LinkedList<FinderCommentInfo> paramLinkedList)
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment$Companion;", "", "()V", "getIdScene", "", "scene", "commentScene", "feedUsername", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.h
 * JD-Core Version:    0.7.0.1
 */