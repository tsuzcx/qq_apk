package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.by;
import com.tencent.mm.plugin.finder.cgi.bz;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.postlogic.base.e;
import com.tencent.mm.plugin.finder.upload.postlogic.f;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftCgiStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "setDraftItem", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mvClipListener", "getMvClipListener", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postClipFailed", "", "getPostClipFailed", "()Z", "setPostClipFailed", "(Z)V", "postingClipSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "getPostingClipSet", "()Ljava/util/HashSet;", "resultStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "doMvPostSceneContinue", "", "doPostSceneContinue", "postScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost2;", "fillReportTotalCostTime", "getStageType", "", "onFailed", "nextStage", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccess", "onWait", "saveToDb", "setResult", "stage", "start", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends f
  implements com.tencent.mm.am.h
{
  com.tencent.mm.plugin.finder.storage.i ABX;
  final HashSet<by> GeG;
  boolean GeH;
  private final com.tencent.mm.am.h GeI;
  final FinderItem Ged;
  private e Gev;
  final String TAG;
  private CountDownLatch yuW;
  
  public h(com.tencent.mm.plugin.finder.storage.i parami)
  {
    super(j.e(parami));
    AppMethodBeat.i(343049);
    this.ABX = parami;
    this.TAG = "LogPost.MvDraftCgiStage";
    this.Ged = this.ABX.eYK();
    parami = this.ABX;
    localObject = c.GdZ;
    this.Gev = ((e)new c(parami, c.fev()));
    this.yuW = new CountDownLatch(1);
    this.GeG = new HashSet();
    this.GeI = ((com.tencent.mm.am.h)new a(this));
    AppMethodBeat.o(343049);
  }
  
  private final boolean a(bz parambz)
  {
    AppMethodBeat.i(343061);
    Object localObject = d.FAy;
    if (((Number)d.eQB().bmg()).intValue() == 3)
    {
      parambz = this.ABX;
      localObject = c.GdZ;
      g((e)new c(parambz, c.fev()));
      AppMethodBeat.o(343061);
      return false;
    }
    com.tencent.mm.kernel.h.baD().mCm.a(6649, (com.tencent.mm.am.h)this);
    boolean bool = com.tencent.mm.kernel.h.aZW().a((p)parambz, 0);
    AppMethodBeat.o(343061);
    return bool;
  }
  
  public final void d(e parame)
  {
    AppMethodBeat.i(343154);
    kotlin.g.b.s.u(parame, "nextStage");
    com.tencent.mm.kernel.h.aZW().b(6649, this.GeI);
    AppMethodBeat.o(343154);
  }
  
  public final void e(e parame)
  {
    AppMethodBeat.i(343161);
    kotlin.g.b.s.u(parame, "nextStage");
    com.tencent.mm.kernel.h.aZW().b(6649, this.GeI);
    AppMethodBeat.o(343161);
  }
  
  public final void f(e parame)
  {
    AppMethodBeat.i(343175);
    kotlin.g.b.s.u(parame, "nextStage");
    com.tencent.mm.kernel.h.aZW().b(6649, this.GeI);
    AppMethodBeat.o(343175);
  }
  
  final void feA()
  {
    AppMethodBeat.i(343112);
    Object localObject1 = j.FKc;
    if (j.pX(this.ABX.field_localId))
    {
      localObject1 = i.c.FoQ;
      i.c.tI(this.Ged.isLongVideo());
      this.Ged.trackPost("doMvPostScene");
      localObject1 = this.Ged.field_reportObject;
      if (localObject1 != null) {
        ((FinderFeedReportObject)localObject1).postStage = 4;
      }
      feB();
      com.tencent.mm.plugin.finder.storage.i locali = this.ABX;
      localObject2 = this.Ged.getPostInfo().clientId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      a(new bz(locali, (String)localObject1, (byte)0));
      AppMethodBeat.o(343112);
      return;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("post before doScene cancel because feed is deleted ", Long.valueOf(this.ABX.field_localId)));
    localObject1 = this.ABX;
    Object localObject2 = c.GdZ;
    g((e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev()));
    AppMethodBeat.o(343112);
  }
  
  final void feB()
  {
    AppMethodBeat.i(343147);
    com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(this.ABX);
    AppMethodBeat.o(343147);
  }
  
  public final e feo()
  {
    AppMethodBeat.i(343093);
    Object localObject1 = j.FKc;
    if (!j.pX(this.ABX.field_localId))
    {
      Log.i(this.TAG, kotlin.g.b.s.X("start but not exist: ", Long.valueOf(this.ABX.field_localId)));
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      localObject1 = (e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.feu());
      AppMethodBeat.o(343093);
      return localObject1;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("doMvPostScene ", Long.valueOf(this.ABX.field_localId)));
    localObject1 = i.c.FoQ;
    i.c.tI(this.Ged.isLongVideo());
    this.Ged.trackPost("doMvPostScene");
    localObject1 = this.Ged.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 7;
    }
    localObject1 = (CharSequence)this.Ged.getPostInfo().clientId;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        this.Ged.getPostInfo().clientId = kotlin.g.b.s.X("FinderLocal_", Long.valueOf(System.nanoTime()));
      }
      feB();
      localObject1 = this.Ged.getFeedObject().objectDesc;
      if (localObject1 != null) {
        break label259;
      }
    }
    label259:
    for (localObject1 = null;; localObject1 = ((FinderObjectDesc)localObject1).mvInfo)
    {
      if (localObject1 != null) {
        break label267;
      }
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      localObject1 = (e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
      AppMethodBeat.o(343093);
      return localObject1;
      i = 0;
      break;
    }
    label267:
    com.tencent.mm.kernel.h.aZW().a(6649, this.GeI);
    Object localObject2 = new LinkedList();
    Object localObject3;
    Object localObject4;
    if (((bol)localObject1).ZWM == 1)
    {
      localObject1 = ((bol)localObject1).ZWL;
      kotlin.g.b.s.s(localObject1, "mvInfo.ordered_track_list_flex_clip");
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label387:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if (((boq)localObject4).refObjectId == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label387;
          }
          ((Collection)localObject1).add(localObject4);
          break;
        }
      }
      ((LinkedList)localObject2).addAll((Collection)localObject1);
      localObject2 = ((Iterable)localObject2).iterator();
      label411:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (boq)((Iterator)localObject2).next();
        localObject4 = ((Iterable)this.Ged.getClipListExt()).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject4).next();
        } while (!kotlin.g.b.s.p(((FinderItem)localObject1).getObjectNonceId(), ((boq)localObject3).ZWZ));
      }
    }
    else
    {
      for (;;)
      {
        localObject1 = (FinderItem)localObject1;
        if (localObject1 == null) {
          break label411;
        }
        localObject1 = new by((FinderItem)localObject1, (boq)localObject3, (byte)0);
        this.GeG.add(localObject1);
        break label411;
        localObject1 = ((bol)localObject1).ZWI;
        kotlin.g.b.s.s(localObject1, "mvInfo.orderedTrackList");
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label608:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (((boq)localObject4).refObjectId == 0L) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label608;
            }
            ((Collection)localObject1).add(localObject4);
            break;
          }
        }
        ((LinkedList)localObject2).addAll((Collection)localObject1);
        break;
        localObject1 = null;
      }
    }
    if (!((Collection)this.GeG).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, kotlin.g.b.s.X("start clip cgi, size:", Integer.valueOf(this.GeG.size())));
      localObject1 = ((Iterable)this.GeG).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (by)((Iterator)localObject1).next();
        com.tencent.mm.kernel.h.aZW().a((p)localObject2, 0);
      }
    }
    feA();
    this.yuW.await();
    localObject1 = this.Gev;
    AppMethodBeat.o(343093);
    return localObject1;
  }
  
  public final int fer()
  {
    return 4;
  }
  
  final void g(e parame)
  {
    AppMethodBeat.i(343068);
    this.Gev = parame;
    this.yuW.countDown();
    AppMethodBeat.o(343068);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(343138);
    if (!(paramp instanceof bz))
    {
      AppMethodBeat.o(343138);
      return;
    }
    com.tencent.mm.kernel.h.baD().mCm.b(6649, (com.tencent.mm.am.h)this);
    Object localObject = ((bz)paramp).clientId;
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.Ged.getPostInfo().clientId))
    {
      Log.w(this.TAG, "not my feed!");
      AppMethodBeat.o(343138);
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
      g((e)new b(this.ABX));
      AppMethodBeat.o(343138);
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
      g((e)new c(paramString, c.fev()));
      AppMethodBeat.o(343138);
      return;
      Log.i(this.TAG, "deleted when scene end.");
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftCgiStage$mvClipListener$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.am.h
  {
    a(h paramh) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      c.a locala = null;
      AppMethodBeat.i(343059);
      if (((paramp instanceof by)) && (this.GeJ.GeG.contains(paramp)))
      {
        Log.i(this.GeJ.TAG, "clip cgi errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.GeJ.GeG.remove(paramp);
        FinderObject localFinderObject;
        long l;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localFinderObject = ((by)paramp).dVH();
          Object localObject = ((Iterable)this.GeJ.Ged.getClipListExt()).iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramString = ((Iterator)localObject).next();
            if (kotlin.g.b.s.p(((FinderItem)paramString).getObjectNonceId(), ((by)paramp).ABU.getObjectNonceId()))
            {
              paramString = (FinderItem)paramString;
              if (paramString != null)
              {
                paramString = paramString.getFeedObject();
                if (localFinderObject != null) {
                  break label293;
                }
                l = 0L;
                label180:
                paramString.id = l;
              }
              paramString = ((by)paramp).ABV;
              if (localFinderObject != null) {
                break label303;
              }
              l = 0L;
              label203:
              paramString.refObjectId = l;
              localObject = ((by)paramp).ABV;
              if (localFinderObject != null) {
                break label313;
              }
              paramString = locala;
              label227:
              ((boq)localObject).ZWZ = paramString;
              ((by)paramp).ABV.TBO = 0L;
              this.GeJ.feB();
            }
          }
        }
        for (;;)
        {
          if ((!this.GeJ.GeG.isEmpty()) || (this.GeJ.GeH)) {
            break label333;
          }
          this.GeJ.feA();
          AppMethodBeat.o(343059);
          return;
          paramString = null;
          break;
          label293:
          l = localFinderObject.id;
          break label180;
          label303:
          l = localFinderObject.id;
          break label203;
          label313:
          paramString = localFinderObject.objectNonceId;
          break label227;
          this.GeJ.GeH = true;
        }
        label333:
        if ((this.GeJ.GeG.isEmpty()) && (this.GeJ.GeH))
        {
          paramString = this.GeJ;
          paramp = this.GeJ.ABX;
          locala = c.GdZ;
          paramString.g((e)new c(paramp, c.fev()));
        }
      }
      AppMethodBeat.o(343059);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.h
 * JD-Core Version:    0.7.0.1
 */