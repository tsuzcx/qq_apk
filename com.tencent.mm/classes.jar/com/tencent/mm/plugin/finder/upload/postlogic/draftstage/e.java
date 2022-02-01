package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.be;
import com.tencent.mm.plugin.finder.cgi.bz;
import com.tencent.mm.plugin.finder.cgi.o;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.data.n;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bg;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftPostCgiStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "setDraftItem", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "resultStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "dealDumpCgi", "", "feedObject", "dealLongVideoCgi", "doPostSceneContinue", "", "fillReportTotalCostTime", "getStageType", "", "onFailed", "nextStage", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccess", "onWait", "setResult", "stage", "start", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.plugin.finder.storage.i ABX;
  private final FinderItem Ged;
  private com.tencent.mm.plugin.finder.upload.postlogic.base.e Gev;
  private final String TAG;
  private CountDownLatch yuW;
  
  public e(com.tencent.mm.plugin.finder.storage.i parami)
  {
    super(j.e(parami));
    AppMethodBeat.i(343078);
    this.ABX = parami;
    this.TAG = "LogPost.FinderDraftPostCgiStage";
    this.Ged = this.ABX.eYK();
    parami = this.ABX;
    localObject = c.GdZ;
    this.Gev = ((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(parami, c.fev()));
    this.yuW = new CountDownLatch(1);
    AppMethodBeat.o(343078);
  }
  
  private static final Object a(FinderItem paramFinderItem, e parame, b.a parama)
  {
    AppMethodBeat.i(343107);
    kotlin.g.b.s.u(paramFinderItem, "$feedObject");
    kotlin.g.b.s.u(parame, "this$0");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).megaCgiErrorType = parama.errType;
    }
    localObject = paramFinderItem.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).megaCgiErrorCode = parama.errCode;
    }
    localObject = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(parame.ABX);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((doa)parama.ott).ZXx;
      localObject = com.tencent.mm.plugin.finder.upload.i.Gcb;
      com.tencent.mm.plugin.finder.upload.i.a(parama, paramFinderItem);
      boolean bool = parame.fez();
      AppMethodBeat.o(343107);
      return Boolean.valueOf(bool);
    }
    paramFinderItem = parame.ABX;
    parama = c.GdZ;
    parame.g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramFinderItem, c.fev()));
    paramFinderItem = ah.aiuX;
    AppMethodBeat.o(343107);
    return paramFinderItem;
  }
  
  private static final Object b(FinderItem paramFinderItem, e parame, b.a parama)
  {
    AppMethodBeat.i(343118);
    kotlin.g.b.s.u(paramFinderItem, "$feedObject");
    kotlin.g.b.s.u(parame, "this$0");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).dumpCgiErrorType = parama.errType;
    }
    paramFinderItem = paramFinderItem.field_reportObject;
    if (paramFinderItem != null) {
      paramFinderItem.dumpCgiErrorCode = parama.errCode;
    }
    paramFinderItem = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(parame.ABX);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      Log.i(parame.TAG, "dumpcgi, waitType:" + ((axk)parama.ott).EUp + " url:" + ((axk)parama.ott).url + ", thumbUrl:" + ((axk)parama.ott).thumbUrl);
      paramFinderItem = parame.Ged.getFeedObject().objectDesc;
      if (paramFinderItem != null)
      {
        paramFinderItem = paramFinderItem.media;
        if (paramFinderItem != null)
        {
          FinderMedia localFinderMedia = (FinderMedia)kotlin.a.p.oL((List)paramFinderItem);
          if (localFinderMedia != null)
          {
            localObject = ((axk)parama.ott).url;
            paramFinderItem = (FinderItem)localObject;
            if (localObject == null) {
              paramFinderItem = "";
            }
            localFinderMedia.url = paramFinderItem;
            localObject = ((axk)parama.ott).thumbUrl;
            paramFinderItem = (FinderItem)localObject;
            if (localObject == null) {
              paramFinderItem = "";
            }
            localFinderMedia.thumbUrl = paramFinderItem;
          }
        }
      }
      paramFinderItem = parame.Ged.getFeedObject().objectDesc;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        if (paramFinderItem == null)
        {
          paramFinderItem = parame.Ged.getFeedObject().objectDesc;
          if (paramFinderItem != null) {
            paramFinderItem.client_draft_ext_info = new auq();
          }
        }
        paramFinderItem = parame.Ged.getFeedObject().objectDesc;
        if (paramFinderItem != null) {
          break label354;
        }
      }
      label354:
      for (paramFinderItem = null;; paramFinderItem = paramFinderItem.client_draft_ext_info)
      {
        if (paramFinderItem != null) {
          paramFinderItem.ZEX = ((axk)parama.ott).EUp;
        }
        boolean bool = parame.fez();
        AppMethodBeat.o(343118);
        return Boolean.valueOf(bool);
        paramFinderItem = paramFinderItem.client_draft_ext_info;
        break;
      }
    }
    paramFinderItem = parame.ABX;
    parama = c.GdZ;
    parame.g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramFinderItem, c.fev()));
    paramFinderItem = ah.aiuX;
    AppMethodBeat.o(343118);
    return paramFinderItem;
  }
  
  private final boolean fez()
  {
    AppMethodBeat.i(343092);
    Object localObject1 = d.FAy;
    if (((Number)d.eQB().bmg()).intValue() == 3)
    {
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev()));
      AppMethodBeat.o(343092);
      return false;
    }
    com.tencent.mm.plugin.finder.storage.i locali = this.ABX;
    Object localObject2 = this.Ged.getPostInfo().clientId;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject1 = new bz(locali, (String)localObject1, (byte)0);
    com.tencent.mm.kernel.h.baD().mCm.a(6649, (com.tencent.mm.am.h)this);
    boolean bool = com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
    AppMethodBeat.o(343092);
    return bool;
  }
  
  private final void g(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343084);
    this.Gev = parame;
    this.yuW.countDown();
    AppMethodBeat.o(343084);
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343159);
    kotlin.g.b.s.u(parame, "nextStage");
    AppMethodBeat.o(343159);
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343165);
    kotlin.g.b.s.u(parame, "nextStage");
    AppMethodBeat.o(343165);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343170);
    kotlin.g.b.s.u(parame, "nextStage");
    AppMethodBeat.o(343170);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(343155);
    Object localObject1 = j.FKc;
    if (!j.pX(this.ABX.field_localId))
    {
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.feu());
      AppMethodBeat.o(343155);
      return localObject1;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("doPostScene ", Long.valueOf(this.ABX.field_localId)));
    localObject1 = i.c.FoQ;
    i.c.tI(this.Ged.isLongVideo());
    this.Ged.trackDraftPost("doPostScene");
    localObject1 = this.Ged.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 4;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(this.ABX);
    localObject1 = (CharSequence)this.Ged.getPostInfo().clientId;
    int i;
    Object localObject5;
    Object localObject6;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        this.Ged.getPostInfo().clientId = kotlin.g.b.s.X("FinderLocal_feed_", Long.valueOf(System.nanoTime()));
      }
      localObject1 = this.Ged.getFeedObject().attachmentList;
      if (localObject1 == null) {
        break label499;
      }
      localObject1 = ((atr)localObject1).ZEi;
      if (localObject1 == null) {
        break label499;
      }
      localObject4 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = ((Iterator)localObject4).next();
        localObject5 = (atq)localObject1;
        localObject6 = av.GiL;
        kotlin.g.b.s.s(localObject5, "it");
        if (av.a((atq)localObject5))
        {
          label271:
          localObject1 = (atq)localObject1;
          if (localObject1 == null) {
            break label499;
          }
          localObject1 = ((atq)localObject1).ZEf;
          if ((localObject1 == null) || (((byx)localObject1).id != 0L)) {
            break label499;
          }
          i = 1;
          label300:
          if (i == 0) {
            break label808;
          }
          localObject5 = this.Ged;
          localObject2 = ((FinderItem)localObject5).getPostInfo().clientId;
          if (localObject2 != null) {
            break label504;
          }
          localObject2 = "";
          label327:
          localObject6 = new dnh();
          localObject1 = this.Ged.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label507;
          }
          localObject1 = "";
        }
      }
    }
    for (;;)
    {
      ((dnh)localObject6).description = ((String)localObject1);
      localObject1 = new LinkedList();
      Object localObject7 = (Iterable)((FinderItem)localObject5).getLongVideoMediaExtList();
      localObject4 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject7, 10));
      localObject7 = ((Iterable)localObject7).iterator();
      while (((Iterator)localObject7).hasNext())
      {
        dji localdji = (dji)((Iterator)localObject7).next();
        dnv localdnv = n.c(localdji);
        localdnv.url = localdji.aaPd;
        localdnv.thumbUrl = localdji.aaPe;
        localdnv.md5sum = localdji.md5sum;
        localdnv.coverUrl = localdji.aaPg;
        ((Collection)localObject4).add(localdnv);
      }
      i = 0;
      break;
      localObject1 = null;
      break label271;
      label499:
      i = 0;
      break label300;
      label504:
      break label327;
      label507:
      localObject4 = ((FinderObjectDesc)localObject1).description;
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = "";
      }
    }
    ((LinkedList)localObject1).addAll((Collection)localObject4);
    Object localObject4 = ah.aiuX;
    ((dnh)localObject6).media = ((LinkedList)localObject1);
    ((dnh)localObject6).mediaType = 0;
    localObject1 = this.Ged.getFeedObject().objectDesc;
    if (localObject1 == null)
    {
      localObject1 = "";
      ((dnh)localObject6).aaUC = ((String)localObject1);
      localObject1 = this.Ged.getFeedObject().objectDesc;
      if (localObject1 != null) {
        break label741;
      }
      localObject1 = null;
      label600:
      ((dnh)localObject6).aaUD = ((dnu)localObject1);
      localObject1 = this.Ged.getFeedObject().objectDesc;
      if (localObject1 != null) {
        break label763;
      }
      localObject1 = null;
      label623:
      ((dnh)localObject6).aaUE = ((dnl)localObject1);
      localObject1 = this.Ged.getFeedObject().objectDesc;
      if (localObject1 != null) {
        break label785;
      }
      localObject1 = localObject3;
      label647:
      ((dnh)localObject6).aaUF = ((dnu)localObject1);
      localObject1 = ah.aiuX;
      new be((String)localObject2, (dnh)localObject6).bFJ().g(new e..ExternalSyntheticLambda0((FinderItem)localObject5, this));
    }
    for (;;)
    {
      this.yuW.await();
      localObject1 = this.Gev;
      AppMethodBeat.o(343155);
      return localObject1;
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject4 = ((bxs)localObject1).aagD;
      localObject1 = localObject4;
      if (localObject4 != null) {
        break;
      }
      localObject1 = "";
      break;
      label741:
      localObject1 = ((FinderObjectDesc)localObject1).location;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label600;
      }
      localObject1 = bg.b((boi)localObject1);
      break label600;
      label763:
      localObject1 = ((FinderObjectDesc)localObject1).extReading;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label623;
      }
      localObject1 = bg.a((axa)localObject1);
      break label623;
      label785:
      localObject4 = ((FinderObjectDesc)localObject1).feed_location;
      localObject1 = localObject3;
      if (localObject4 == null) {
        break label647;
      }
      localObject1 = bg.b((boi)localObject4);
      break label647;
      label808:
      localObject1 = this.Ged.getPostInfo().aaPB;
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        label825:
        if (Util.isNullOrNil((String)localObject1)) {
          break label1047;
        }
        localObject1 = this.Ged.getFeedObject().objectDesc;
        if (localObject1 != null) {
          break label958;
        }
        i = 0;
        label849:
        if (i != 0) {
          break label1047;
        }
        localObject6 = this.Ged;
        localObject3 = ((FinderItem)localObject6).getPostInfo().aaPB;
        localObject4 = ((FinderItem)localObject6).getPostInfo().clientId;
        if (localObject4 != null) {
          break label980;
        }
        localObject4 = "";
        label889:
        if (localObject3 != null) {
          break label983;
        }
        localObject1 = "";
        label898:
        if (localObject3 != null) {
          break label1003;
        }
        localObject2 = "";
        label907:
        if (localObject3 != null) {
          break label1023;
        }
        localObject3 = "";
      }
      for (;;)
      {
        new o((String)localObject4, (String)localObject1, (String)localObject2, (String)localObject3).bFJ().g(new e..ExternalSyntheticLambda1((FinderItem)localObject6, this));
        break;
        localObject1 = ((epm)localObject1).AyS;
        break label825;
        label958:
        localObject1 = ((FinderObjectDesc)localObject1).client_draft_ext_info;
        if (localObject1 == null)
        {
          i = 0;
          break label849;
        }
        i = ((auq)localObject1).ZEX;
        break label849;
        label980:
        break label889;
        label983:
        localObject1 = ((epm)localObject3).AyS;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label898;
        }
        break label898;
        label1003:
        localObject2 = ((epm)localObject3).appid;
        if (localObject2 == null)
        {
          localObject2 = "";
          break label907;
        }
        break label907;
        label1023:
        localObject5 = ((epm)localObject3).AyT;
        localObject3 = localObject5;
        if (localObject5 == null) {
          localObject3 = "";
        }
      }
      label1047:
      fez();
    }
  }
  
  public final int fer()
  {
    return 4;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(343182);
    com.tencent.mm.kernel.h.baD().mCm.b(6649, (com.tencent.mm.am.h)this);
    if (paramp == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderDraftPost2");
      AppMethodBeat.o(343182);
      throw paramString;
    }
    Object localObject = ((bz)paramp).clientId;
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.Ged.getPostInfo().clientId))
    {
      Log.w(this.TAG, "not my feed!");
      AppMethodBeat.o(343182);
      return;
    }
    this.Ged.trackDraftPost("doPostSceneEnd");
    paramp = ((bz)paramp).dVH();
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("svrFinderObj id:");
    if (paramp == null) {}
    for (paramString = null;; paramString = Long.valueOf(paramp.id))
    {
      Log.i((String)localObject, paramString + ", localId:" + this.ABX.field_localId);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null)) {
        break;
      }
      paramString = this.Ged.field_reportObject;
      if (paramString != null) {
        paramString.postTaskCost += (int)fep();
      }
      paramString = this.Ged.field_reportObject;
      if (paramString != null)
      {
        localObject = com.tencent.mm.plugin.finder.upload.i.Gcb;
        com.tencent.mm.plugin.finder.upload.i.a(paramString, "postSuccess");
      }
      paramString = com.tencent.mm.plugin.finder.report.h.Fop;
      com.tencent.mm.plugin.finder.report.h.c(this.ABX);
      paramString = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
      com.tencent.mm.plugin.finder.storage.logic.c.a(this.ABX, paramp);
      paramString = g.GbJ;
      g.fdW().az(this.ABX.field_localId, paramp.id);
      if (this.Ged.getPostInfo().aaPx > 0L)
      {
        paramString = i.b.Fox;
        i.b.D(cn.bDu() - this.Ged.getPostInfo().aaPx, this.Ged.isLongVideo());
      }
      g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new b(this.ABX));
      AppMethodBeat.o(343182);
      return;
    }
    paramString = i.c.FoQ;
    i.c.tJ(this.Ged.isLongVideo());
    paramString = j.FKc;
    if (j.pX(this.ABX.field_localId))
    {
      if (paramInt1 == 4)
      {
        this.ABX.setPostFailed();
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
        com.tencent.mm.plugin.finder.storage.logic.c.g(this.ABX);
        paramString = i.c.FoQ;
        i.c.tC(this.Ged.isLongVideo());
      }
      if (this.ABX.isPostFailed())
      {
        paramString = v.FrN;
        v.r(this.ABX.field_localId, paramInt1, paramInt2);
        paramString = com.tencent.mm.plugin.finder.report.h.Fop;
        com.tencent.mm.plugin.finder.report.h.c(this.ABX);
        paramString = g.GbJ;
        g.fdW().qB(this.ABX.field_localId);
      }
    }
    for (;;)
    {
      paramString = this.ABX;
      paramp = c.GdZ;
      g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c(paramString, c.fev()));
      AppMethodBeat.o(343182);
      return;
      Log.i(this.TAG, "deleted when scene end.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.e
 * JD-Core Version:    0.7.0.1
 */