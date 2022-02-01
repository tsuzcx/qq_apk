package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "feedId", "", "objectNonceId", "", "enterScene", "", "scene", "feedUsername", "needObject", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "pullScene", "(JLjava/lang/String;IILjava/lang/String;ZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;JLjava/lang/String;ZZLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "getDown", "()Z", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "getEnterScene", "()I", "getFeedUsername", "()Ljava/lang/String;", "getJustUpdateObjectStatus", "getPullScene", "rootCommentId", "getScene", "filterDuplicate", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "svrComment", "isEnableReport", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class af
  extends an<ars>
{
  public static final a tun;
  private final int enterScene;
  private final long feedId;
  private final String objectNonceId;
  private final int scene;
  private com.tencent.mm.plugin.finder.cgi.report.b ttH;
  private long tuf;
  private final String tug;
  private boolean tuh;
  private com.tencent.mm.plugin.finder.storage.an tui;
  private final long tuj;
  private final boolean tuk;
  private final boolean tul;
  private final int tum;
  private String username;
  
  static
  {
    AppMethodBeat.i(165180);
    tun = new a((byte)0);
    AppMethodBeat.o(165180);
  }
  
  private af(long paramLong1, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, com.tencent.mm.bw.b paramb, com.tencent.mm.plugin.finder.storage.an paraman, long paramLong2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, bbn parambbn, int paramInt3)
  {
    super(parambbn);
    AppMethodBeat.i(242300);
    this.feedId = paramLong1;
    this.objectNonceId = paramString1;
    this.enterScene = paramInt1;
    this.scene = paramInt2;
    this.tug = paramString2;
    this.tuh = paramBoolean1;
    this.tui = paraman;
    this.tuj = paramLong2;
    this.username = paramString3;
    this.tuk = paramBoolean2;
    this.tul = paramBoolean3;
    this.tum = paramInt3;
    paramString1 = this.tui;
    if (paramString1 != null)
    {
      paramLong1 = paramString1.dyb().commentId;
      this.tuf = paramLong1;
      paramString2 = new d.a();
      paramString1 = new arr();
      paramString1.hFK = this.feedId;
      paramString1.objectNonceId = this.objectNonceId;
      if (!BuildInfo.DEBUG) {
        break label270;
      }
      paraman = (CharSequence)this.objectNonceId;
      if ((paraman != null) && (paraman.length() != 0)) {
        break label264;
      }
    }
    label264:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 == 0) && (!p.j(String.valueOf(this.feedId), this.objectNonceId))) {
        break label270;
      }
      paramString1 = (Throwable)new RuntimeException(this.feedId + ' ' + this.objectNonceId);
      AppMethodBeat.o(242300);
      throw paramString1;
      paramLong1 = 0L;
      break;
    }
    label270:
    if (p.j(Boolean.valueOf(this.tuh), Boolean.TRUE))
    {
      paramInt1 = 1;
      paramString1.LDb = paramInt1;
      paramString1.lastBuffer = paramb;
      paramString1.LDa = 0L;
      paramString1.LDc = paramString4;
      if (Util.isNullOrNil(this.username)) {
        break label738;
      }
      paramString1.finderUsername = this.username;
      label330:
      if (this.tuj != 0L) {
        paramString1.tuj = this.tuj;
      }
      paramString1.tuf = this.tuf;
      if (!this.tuk) {
        break label748;
      }
      paramInt1 = 2;
      label365:
      paramString1.direction = paramInt1;
      paramString1.scene = this.enterScene;
      paraman = am.tuw;
      paramString1.uli = am.a(parambbn);
      paramInt1 = this.scene;
      paramInt2 = this.enterScene;
      paraman = this.tug;
      p.h(paraman, "feedUsername");
      Log.i("Finder.CgiGetFinderFeedComment", "getIdScene scene:" + paramInt1 + ", commentScene:" + paramInt2);
      paramString3 = c.vCb;
      if (((Number)c.dsP().value()).intValue() == 1) {
        break label760;
      }
      paramString3 = c.vCb;
      if (c.drT() != 1) {
        break label760;
      }
      paramString3 = y.vXH;
      if (!y.In(paraman)) {
        break label754;
      }
      paramInt1 = 1;
      label501:
      paramString1.LDd = paramInt1;
      paramString1.tum = this.tum;
      paramString2.c((a)paramString1);
      paraman = new ars();
      paraman.setBaseResponse(new BaseResponse());
      paraman.getBaseResponse().ErrMsg = new dqi();
      paramString2.d((a)paraman);
      paramString2.MB("/cgi-bin/micromsg-bin/findergetcommentdetail");
      paramString2.sG(3763);
      c(paramString2.aXF());
      paramString2 = new StringBuilder("CgiGetFinderFeedComment init identityScene:").append(paramString1.LDd).append(", feedId=").append(this.feedId).append(" lastBuffer=");
      if (paramb == null) {
        break label798;
      }
      paramBoolean1 = true;
      paramString2 = paramString2.append(paramBoolean1).append(" isSecondCommentFetch=");
      if (this.tui == null) {
        break label804;
      }
    }
    label642:
    label798:
    label804:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      Log.i("Finder.CgiGetFinderFeedComment", paramBoolean1 + " scene " + paramString1.scene + ", justUpdateObjectStatus:" + this.tul + ", encryptedObjectid:" + paramString4);
      this.ttH = com.tencent.mm.plugin.finder.cgi.report.b.tyf;
      AppMethodBeat.o(242300);
      return;
      paramInt1 = 0;
      break;
      label738:
      paramString1.finderUsername = z.aUg();
      break label330;
      label748:
      paramInt1 = 1;
      break label365;
      label754:
      paramInt1 = 3;
      break label501;
      label760:
      if (paramInt2 == 7)
      {
        paramInt1 = 1;
        break label501;
      }
      if ((paramInt2 == 8) && (paramInt1 == 1))
      {
        paramInt1 = 1;
        break label501;
      }
      paramInt1 = 2;
      break label501;
      paramBoolean1 = false;
      break label642;
    }
  }
  
  private static LinkedList<FinderCommentInfo> ae(LinkedList<FinderCommentInfo> paramLinkedList)
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
  
  public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return this.ttH;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment$Companion;", "", "()V", "getIdScene", "", "scene", "commentScene", "feedUsername", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.af
 * JD-Core Version:    0.7.0.1
 */