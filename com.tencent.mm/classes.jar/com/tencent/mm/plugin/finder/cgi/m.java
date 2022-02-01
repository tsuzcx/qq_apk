package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILjava/lang/String;ZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;JLjava/lang/String;ZZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getDown", "()Z", "getEnterScene", "()I", "getFeedUsername", "()Ljava/lang/String;", "getJustUpdateObjectStatus", "rootCommentId", "getScene", "filterDuplicate", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "svrComment", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class m
  extends r<aki>
{
  public static final m.a qXB;
  private final long dig;
  private final int enterScene;
  private final String objectNonceId;
  private final boolean qXA;
  private long qXu;
  private final String qXv;
  private boolean qXw;
  private t qXx;
  private final long qXy;
  private final boolean qXz;
  private final int scene;
  private String username;
  
  static
  {
    AppMethodBeat.i(165180);
    qXB = new m.a((byte)0);
    AppMethodBeat.o(165180);
  }
  
  private m(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, com.tencent.mm.bw.b paramb, t paramt, long paramLong2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201140);
    this.dig = paramLong1;
    this.objectNonceId = paramString1;
    this.enterScene = paramInt1;
    this.scene = paramInt2;
    this.qXv = paramString2;
    this.qXw = paramBoolean1;
    this.qXx = paramt;
    this.qXy = paramLong2;
    this.username = paramString3;
    this.qXz = paramBoolean2;
    this.qXA = paramBoolean3;
    paramString1 = this.qXx;
    if (paramString1 != null)
    {
      paramLong1 = paramString1.field_actionInfo.EDq.commentId;
      this.qXu = paramLong1;
      paramString2 = new b.a();
      paramString1 = new akh();
      paramString1.qXP = this.dig;
      paramString1.objectNonceId = this.objectNonceId;
      if (!h.DEBUG) {
        break label267;
      }
      paramt = (CharSequence)this.objectNonceId;
      if ((paramt != null) && (paramt.length() != 0)) {
        break label261;
      }
    }
    label261:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 == 0) && (!k.g(String.valueOf(this.dig), this.objectNonceId))) {
        break label267;
      }
      paramString1 = (Throwable)new RuntimeException(this.dig + ' ' + this.objectNonceId);
      AppMethodBeat.o(201140);
      throw paramString1;
      paramLong1 = 0L;
      break;
    }
    label267:
    if (k.g(Boolean.valueOf(this.qXw), Boolean.TRUE))
    {
      paramInt1 = 1;
      paramString1.EEz = paramInt1;
      paramString1.lastBuffer = paramb;
      paramString1.EEy = 0L;
      paramString1.EEA = paramString4;
      if (bs.isNullOrNil(this.username)) {
        break label709;
      }
      paramString1.rfC = this.username;
      label327:
      if (this.qXy != 0L) {
        paramString1.qXy = this.qXy;
      }
      paramString1.qXu = this.qXu;
      if (!this.qXz) {
        break label719;
      }
      paramInt1 = 2;
      label362:
      paramString1.direction = paramInt1;
      paramString1.scene = this.enterScene;
      paramt = q.qXH;
      paramString1.EDL = q.a(paramanm);
      paramInt1 = this.scene;
      paramInt2 = this.enterScene;
      paramt = this.qXv;
      k.h(paramt, "feedUsername");
      ac.i("Finder.CgiGetFinderFeedComment", "getIdScene scene:" + paramInt1 + ", commentScene:" + paramInt2);
      paramString3 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czB()) {
        break label731;
      }
      paramString3 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czC() != 1) {
        break label731;
      }
      paramString3 = n.rPN;
      if (!n.aeD(paramt)) {
        break label725;
      }
      paramInt1 = 1;
      label487:
      paramString1.EEB = paramInt1;
      paramString2.c((a)paramString1);
      paramt = new aki();
      paramt.setBaseResponse(new BaseResponse());
      paramt.getBaseResponse().ErrMsg = new crm();
      paramString2.d((a)paramt);
      paramString2.Am("/cgi-bin/micromsg-bin/findergetcommentdetail");
      paramString2.op(3763);
      c(paramString2.aAz());
      paramString2 = new StringBuilder("CgiGetFinderFeedComment init identityScene:").append(paramString1.EEB).append(", feedId=").append(this.dig).append(" lastBuffer=");
      if (paramb == null) {
        break label757;
      }
      paramBoolean1 = true;
      label620:
      paramString2 = paramString2.append(paramBoolean1).append(" isSecondCommentFetch=");
      if (this.qXx == null) {
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
      ac.i("Finder.CgiGetFinderFeedComment", paramBoolean1 + " scene " + paramString1.scene + ", justUpdateObjectStatus:" + this.qXA + ", encryptedObjectid:" + paramString4);
      AppMethodBeat.o(201140);
      return;
      paramInt1 = 0;
      break;
      paramString1.rfC = u.axE();
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
      ac.w("Finder.CgiGetFinderFeedComment", "filterDuplicate " + localFinderCommentInfo.commentId + " content " + localFinderCommentInfo.content + " username " + localFinderCommentInfo.username);
    }
    AppMethodBeat.o(165177);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.m
 * JD-Core Version:    0.7.0.1
 */