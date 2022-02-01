package com.tencent.mm.plugin.finder.upload.postlogic.finderstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.be;
import com.tencent.mm.plugin.finder.cgi.dg;
import com.tencent.mm.plugin.finder.cgi.o;
import com.tencent.mm.plugin.finder.report.ah.c;
import com.tencent.mm.plugin.finder.report.ah.d;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.n;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.bg;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
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
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dne;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/finderstage/FinderPostCgiStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "TAG", "", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "resultStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "dealDumpCgi", "", "feedObject", "postScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "dealLongVideoCgi", "doPostSceneContinue", "", "fillReportTotalCostTime", "svrId", "", "getStageType", "", "onFailed", "nextStage", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccess", "onWait", "setResult", "stage", "start", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
  implements com.tencent.mm.am.h
{
  public FinderItem Ged;
  private com.tencent.mm.plugin.finder.upload.postlogic.base.e Gev;
  private final String TAG;
  private CountDownLatch yuW;
  
  public c(FinderItem paramFinderItem)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343184);
    this.Ged = paramFinderItem;
    this.TAG = "LogPost.FinderPostCgiStage";
    paramFinderItem = this.Ged;
    g.a locala = g.Gfb;
    this.Gev = ((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramFinderItem, g.fev()));
    this.yuW = new CountDownLatch(1);
    AppMethodBeat.o(343184);
  }
  
  private static final Object a(FinderItem paramFinderItem, dg paramdg, c paramc, b.a parama)
  {
    AppMethodBeat.i(343222);
    kotlin.g.b.s.u(paramFinderItem, "$feedObject");
    kotlin.g.b.s.u(paramdg, "$postScene");
    kotlin.g.b.s.u(paramc, "this$0");
    Object localObject1 = paramFinderItem.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).megaCgiErrorType = parama.errType;
    }
    localObject1 = paramFinderItem.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).megaCgiErrorCode = parama.errCode;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    d.a.v(paramFinderItem);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((doa)parama.ott).ZXx;
      bsw localbsw = paramdg.ADb;
      atr localatr = new atr();
      localatr.ZEi = new LinkedList();
      Object localObject2 = localatr.ZEi;
      atq localatq = new atq();
      localatq.type = 1;
      Object localObject3 = new byx();
      long l;
      if (parama == null)
      {
        l = 0L;
        ((byx)localObject3).id = l;
        ((byx)localObject3).ZXx = parama;
        if (parama != null) {
          break label291;
        }
        parama = "";
        label183:
        ((byx)localObject3).aahV = parama;
        parama = ah.aiuX;
        localatq.ZEf = ((byx)localObject3);
        parama = ah.aiuX;
        ((LinkedList)localObject2).add(localatq);
        parama = localatr.ZEi;
        paramFinderItem = paramFinderItem.getFeedObject().attachmentList;
        if (paramFinderItem != null) {
          break label311;
        }
        paramFinderItem = null;
        label232:
        if (paramFinderItem != null) {
          break label432;
        }
      }
      label291:
      label422:
      label432:
      for (paramFinderItem = (Collection)new LinkedList();; paramFinderItem = (Collection)paramFinderItem)
      {
        parama.addAll(paramFinderItem);
        paramFinderItem = ah.aiuX;
        localbsw.attachmentList = localatr;
        boolean bool = paramc.a(paramdg);
        AppMethodBeat.o(343222);
        return Boolean.valueOf(bool);
        l = parama.id;
        break;
        localObject1 = parama.aahV;
        parama = (b.a)localObject1;
        if (localObject1 != null) {
          break label183;
        }
        parama = "";
        break label183;
        label311:
        paramFinderItem = paramFinderItem.ZEi;
        if (paramFinderItem == null)
        {
          paramFinderItem = null;
          break label232;
        }
        localObject1 = (Iterable)paramFinderItem;
        paramFinderItem = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localatq = (atq)localObject2;
          localObject3 = av.GiL;
          kotlin.g.b.s.s(localatq, "it");
          if (!av.a(localatq)) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label422;
            }
            paramFinderItem.add(localObject2);
            break;
          }
        }
        paramFinderItem = (List)paramFinderItem;
        break label232;
      }
    }
    paramFinderItem = paramc.Ged;
    paramdg = g.Gfb;
    paramc.g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramFinderItem, g.fev()));
    paramFinderItem = ah.aiuX;
    AppMethodBeat.o(343222);
    return paramFinderItem;
  }
  
  private static final Object a(FinderItem paramFinderItem, c paramc, dg paramdg, b.a parama)
  {
    AppMethodBeat.i(343235);
    kotlin.g.b.s.u(paramFinderItem, "$feedObject");
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramdg, "$postScene");
    Object localObject = paramFinderItem.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).dumpCgiErrorType = parama.errType;
    }
    localObject = paramFinderItem.field_reportObject;
    if (localObject != null) {
      ((FinderFeedReportObject)localObject).dumpCgiErrorCode = parama.errCode;
    }
    localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    d.a.v(paramFinderItem);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      Log.i(paramc.TAG, "dumpcgi, waitType:" + ((axk)parama.ott).EUp + " url:" + ((axk)parama.ott).url + ", thumbUrl:" + ((axk)parama.ott).thumbUrl);
      paramFinderItem = paramdg.ADb.aaay;
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
      paramdg.ADb.EUp = ((axk)parama.ott).EUp;
      boolean bool = paramc.a(paramdg);
      AppMethodBeat.o(343235);
      return Boolean.valueOf(bool);
    }
    paramFinderItem = paramc.Ged;
    paramdg = g.Gfb;
    paramc.g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramFinderItem, g.fev()));
    paramFinderItem = ah.aiuX;
    AppMethodBeat.o(343235);
    return paramFinderItem;
  }
  
  private final boolean a(dg paramdg)
  {
    AppMethodBeat.i(343209);
    Log.i(this.TAG, "doPostSceneContinue finderObj_waitType: " + this.Ged.getPostInfo().EUp + ", request_waitType:" + paramdg.ADb.EUp);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eQB().bmg()).intValue() == 3)
    {
      paramdg = this.Ged;
      localObject = g.Gfb;
      g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramdg, g.fev()));
      AppMethodBeat.o(343209);
      return false;
    }
    com.tencent.mm.kernel.h.baD().mCm.a(3585, (com.tencent.mm.am.h)this);
    boolean bool = com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramdg, 0);
    AppMethodBeat.o(343209);
    return bool;
  }
  
  private final void g(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343199);
    this.Gev = parame;
    this.yuW.countDown();
    AppMethodBeat.o(343199);
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343291);
    kotlin.g.b.s.u(parame, "nextStage");
    AppMethodBeat.o(343291);
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343296);
    kotlin.g.b.s.u(parame, "nextStage");
    AppMethodBeat.o(343296);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343305);
    kotlin.g.b.s.u(parame, "nextStage");
    AppMethodBeat.o(343305);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(343285);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    if (!d.a.pX(this.Ged.getLocalId()))
    {
      localObject1 = this.Ged;
      localObject2 = g.Gfb;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g((FinderItem)localObject1, g.feu());
      AppMethodBeat.o(343285);
      return localObject1;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("doPostScene ", Long.valueOf(this.Ged.getLocalId())));
    localObject1 = ah.d.Ftw;
    ah.d.tI(this.Ged.isLongVideo());
    this.Ged.trackPost("doPostScene");
    localObject1 = this.Ged.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 4;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    d.a.v(this.Ged);
    Object localObject5 = this.Ged;
    Object localObject4 = this.Ged.getPostInfo().clientId;
    localObject1 = localObject4;
    if (localObject4 == null) {
      localObject1 = "";
    }
    dg localdg = new dg((FinderItem)localObject5, (String)localObject1, this.Ged.getLocalId());
    localObject1 = this.Ged.getFeedObject().attachmentList;
    Object localObject6;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((atr)localObject1).ZEi;
      if (localObject1 != null)
      {
        localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject1 = ((Iterator)localObject4).next();
          localObject5 = (atq)localObject1;
          localObject6 = av.GiL;
          kotlin.g.b.s.s(localObject5, "it");
          if (av.a((atq)localObject5))
          {
            localObject1 = (atq)localObject1;
            if (localObject1 == null) {
              break label483;
            }
            localObject1 = ((atq)localObject1).ZEf;
            if ((localObject1 == null) || (((byx)localObject1).id != 0L)) {
              break label483;
            }
            i = 1;
            label293:
            if (i == 0) {
              break label782;
            }
            localObject5 = this.Ged;
            localObject2 = ((FinderItem)localObject5).getPostInfo().clientId;
            if (localObject2 != null) {
              break label488;
            }
            localObject2 = "";
            label319:
            localObject6 = new dnh();
            localObject1 = localdg.ADb.aaay;
            if (localObject1 != null) {
              break label491;
            }
            localObject1 = "";
          }
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
      localObject1 = null;
      break;
      label483:
      i = 0;
      break label293;
      label488:
      break label319;
      label491:
      localObject4 = ((FinderObjectDesc)localObject1).description;
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = "";
      }
    }
    ((LinkedList)localObject1).addAll((Collection)localObject4);
    localObject4 = ah.aiuX;
    ((dnh)localObject6).media = ((LinkedList)localObject1);
    ((dnh)localObject6).mediaType = 0;
    localObject1 = localdg.ADb.aaay;
    if (localObject1 == null)
    {
      localObject1 = "";
      ((dnh)localObject6).aaUC = ((String)localObject1);
      localObject1 = localdg.ADb.aaay;
      if (localObject1 != null) {
        break label715;
      }
      localObject1 = null;
      label578:
      ((dnh)localObject6).aaUD = ((dnu)localObject1);
      localObject1 = localdg.ADb.aaay;
      if (localObject1 != null) {
        break label737;
      }
      localObject1 = null;
      label599:
      ((dnh)localObject6).aaUE = ((dnl)localObject1);
      localObject1 = localdg.ADb.aaay;
      if (localObject1 != null) {
        break label759;
      }
      localObject1 = localObject3;
      label621:
      ((dnh)localObject6).aaUF = ((dnu)localObject1);
      localObject1 = ah.aiuX;
      new be((String)localObject2, (dnh)localObject6).bFJ().g(new c..ExternalSyntheticLambda0((FinderItem)localObject5, localdg, this));
    }
    for (;;)
    {
      this.yuW.await();
      localObject1 = this.Gev;
      AppMethodBeat.o(343285);
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
      label715:
      localObject1 = ((FinderObjectDesc)localObject1).location;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label578;
      }
      localObject1 = bg.b((boi)localObject1);
      break label578;
      label737:
      localObject1 = ((FinderObjectDesc)localObject1).extReading;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label599;
      }
      localObject1 = bg.a((axa)localObject1);
      break label599;
      label759:
      localObject4 = ((FinderObjectDesc)localObject1).feed_location;
      localObject1 = localObject3;
      if (localObject4 == null) {
        break label621;
      }
      localObject1 = bg.b((boi)localObject4);
      break label621;
      label782:
      localObject1 = this.Ged.getPostInfo().aaPB;
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        label799:
        if (Util.isNullOrNil((String)localObject1)) {
          break label1082;
        }
        localObject6 = this.Ged;
        localObject1 = ((FinderItem)localObject6).getFeedObject().objectDesc;
        if (localObject1 != null) {
          break label885;
        }
        i = 0;
        label827:
        if (i == 0) {
          break label929;
        }
        Log.i(this.TAG, "dealDumpCgi has done, continue post");
        localObject1 = localdg.ADb;
        localObject2 = ((FinderItem)localObject6).getFeedObject().objectDesc;
        if (localObject2 != null) {
          break label907;
        }
        i = 0;
      }
      for (;;)
      {
        ((bsw)localObject1).EUp = i;
        a(localdg);
        break;
        localObject1 = ((epm)localObject1).AyS;
        break label799;
        label885:
        localObject1 = ((FinderObjectDesc)localObject1).client_draft_ext_info;
        if (localObject1 == null)
        {
          i = 0;
          break label827;
        }
        i = ((auq)localObject1).ZEX;
        break label827;
        label907:
        localObject2 = ((FinderObjectDesc)localObject2).client_draft_ext_info;
        if (localObject2 == null) {
          i = 0;
        } else {
          i = ((auq)localObject2).ZEX;
        }
      }
      label929:
      localObject3 = ((FinderItem)localObject6).getPostInfo().aaPB;
      localObject4 = ((FinderItem)localObject6).getPostInfo().clientId;
      if (localObject4 == null)
      {
        localObject4 = "";
        label958:
        if (localObject3 != null) {
          break label1021;
        }
        localObject1 = "";
        label966:
        if (localObject3 != null) {
          break label1040;
        }
        localObject2 = "";
        label974:
        if (localObject3 != null) {
          break label1059;
        }
        localObject3 = "";
      }
      for (;;)
      {
        new o((String)localObject4, (String)localObject1, (String)localObject2, (String)localObject3).bFJ().g(new c..ExternalSyntheticLambda1((FinderItem)localObject6, this, localdg));
        break;
        break label958;
        label1021:
        localObject1 = ((epm)localObject3).AyS;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label966;
        }
        break label966;
        label1040:
        localObject2 = ((epm)localObject3).appid;
        if (localObject2 == null)
        {
          localObject2 = "";
          break label974;
        }
        break label974;
        label1059:
        localObject5 = ((epm)localObject3).AyT;
        localObject3 = localObject5;
        if (localObject5 == null) {
          localObject3 = "";
        }
      }
      label1082:
      a(localdg);
    }
  }
  
  public final int fer()
  {
    return 4;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(343325);
    com.tencent.mm.kernel.h.baD().mCm.b(3585, (com.tencent.mm.am.h)this);
    if (paramp == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(343325);
      throw paramString;
    }
    Object localObject = ((dg)paramp).clientId;
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.Ged.getPostInfo().clientId))
    {
      Log.w(this.TAG, "not my feed!");
      AppMethodBeat.o(343325);
      return;
    }
    this.Ged.trackPost("doPostSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      long l = ((dg)paramp).feedObject.id;
      paramString = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      paramString = e.a.jn(l);
      if (paramString != null)
      {
        localObject = paramString.field_reportObject;
        if (localObject != null) {
          ((FinderFeedReportObject)localObject).postTaskCost += (int)fep();
        }
      }
      if (paramString != null)
      {
        paramString = paramString.field_reportObject;
        if (paramString != null)
        {
          localObject = i.Gcb;
          i.a(paramString, "postSuccess");
        }
      }
      paramString = com.tencent.mm.plugin.finder.upload.g.GbJ;
      com.tencent.mm.plugin.finder.upload.g.fdW().ay(this.Ged.getLocalId(), ((dg)paramp).feedObject.id);
      if (this.Ged.getPostInfo().aaPx > 0L)
      {
        paramString = ah.c.Ftv;
        ah.c.D(cn.bDu() - this.Ged.getPostInfo().aaPx, this.Ged.isLongVideo());
      }
      paramString = ((dg)paramp).ADb.aaay;
      if (paramString == null)
      {
        l = 0L;
        if (l != 0L)
        {
          paramString = j.FKc;
          paramString = ((dg)paramp).ADb.aaay;
          if (paramString != null) {
            break label385;
          }
        }
      }
      label385:
      for (l = 0L;; l = paramString.draftObjectId)
      {
        j.pZ(l);
        g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new e(this.Ged));
        AppMethodBeat.o(343325);
        return;
        l = paramString.draftObjectId;
        break;
      }
    }
    if (this.Ged.isPostFailed())
    {
      paramString = v.FrN;
      v.r(this.Ged.getLocalId(), paramInt1, paramInt2);
      paramString = com.tencent.mm.plugin.finder.upload.g.GbJ;
      com.tencent.mm.plugin.finder.upload.g.fdW().qz(this.Ged.getLocalId());
    }
    paramString = this.Ged;
    paramp = g.Gfb;
    g((com.tencent.mm.plugin.finder.upload.postlogic.base.e)new g(paramString, g.fev()));
    AppMethodBeat.o(343325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.finderstage.c
 * JD-Core Version:    0.7.0.1
 */