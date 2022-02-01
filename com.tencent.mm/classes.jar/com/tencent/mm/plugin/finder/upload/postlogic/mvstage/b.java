package com.tencent.mm.plugin.finder.upload.postlogic.mvstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.by;
import com.tencent.mm.plugin.finder.cgi.dg;
import com.tencent.mm.plugin.finder.report.ah.c;
import com.tencent.mm.plugin.finder.report.ah.d;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.postlogic.base.e;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/mvstage/MvPostCgiStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "TAG", "", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mvClipListener", "getMvClipListener", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postClipFailed", "", "getPostClipFailed", "()Z", "setPostClipFailed", "(Z)V", "postingClipSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "getPostingClipSet", "()Ljava/util/HashSet;", "resultStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "doMvPostSceneContinue", "", "doPostSceneContinue", "postScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "getStageType", "", "onFailed", "nextStage", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccess", "onWait", "saveToDb", "setResult", "stage", "start", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
  implements com.tencent.mm.am.h
{
  final HashSet<by> GeG;
  boolean GeH;
  private final com.tencent.mm.am.h GeI;
  public final FinderItem Ged;
  private e Gev;
  private final String TAG;
  private CountDownLatch yuW;
  
  public b(FinderItem paramFinderItem)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343247);
    this.Ged = paramFinderItem;
    this.TAG = "LogPost.MvPostCgiStage";
    paramFinderItem = this.Ged;
    f.a locala = f.Gfh;
    this.Gev = ((e)new f(paramFinderItem, f.fev()));
    this.yuW = new CountDownLatch(1);
    this.GeG = new HashSet();
    this.GeI = ((com.tencent.mm.am.h)new a(this));
    AppMethodBeat.o(343247);
  }
  
  private final boolean a(dg paramdg)
  {
    AppMethodBeat.i(343261);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eQB().bmg()).intValue() == 3)
    {
      paramdg = this.Ged;
      localObject = f.Gfh;
      g((e)new f(paramdg, f.fev()));
      AppMethodBeat.o(343261);
      return false;
    }
    com.tencent.mm.kernel.h.baD().mCm.a(3585, (com.tencent.mm.am.h)this);
    boolean bool = com.tencent.mm.kernel.h.aZW().a((p)paramdg, 0);
    AppMethodBeat.o(343261);
    return bool;
  }
  
  public final void d(e parame)
  {
    AppMethodBeat.i(343332);
    kotlin.g.b.s.u(parame, "nextStage");
    com.tencent.mm.kernel.h.aZW().b(6649, this.GeI);
    AppMethodBeat.o(343332);
  }
  
  public final void e(e parame)
  {
    AppMethodBeat.i(343346);
    kotlin.g.b.s.u(parame, "nextStage");
    com.tencent.mm.kernel.h.aZW().b(6649, this.GeI);
    AppMethodBeat.o(343346);
  }
  
  public final void f(e parame)
  {
    AppMethodBeat.i(343361);
    kotlin.g.b.s.u(parame, "nextStage");
    com.tencent.mm.kernel.h.aZW().b(6649, this.GeI);
    AppMethodBeat.o(343361);
  }
  
  final void feA()
  {
    AppMethodBeat.i(343292);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    if (d.a.pX(this.Ged.getLocalId()))
    {
      localObject1 = ah.d.Ftw;
      ah.d.tI(this.Ged.isLongVideo());
      this.Ged.trackPost("doMvPostScene");
      localObject1 = this.Ged.field_reportObject;
      if (localObject1 != null) {
        ((FinderFeedReportObject)localObject1).postStage = 4;
      }
      feB();
      FinderItem localFinderItem = this.Ged;
      localObject2 = this.Ged.getPostInfo().clientId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      a(new dg(localFinderItem, (String)localObject1, this.Ged.getLocalId()));
      AppMethodBeat.o(343292);
      return;
    }
    Log.i(this.TAG, "post before doScene cancel because feed is deleted");
    localObject1 = this.Ged;
    Object localObject2 = f.Gfh;
    g((e)new f((FinderItem)localObject1, f.fev()));
    AppMethodBeat.o(343292);
  }
  
  final void feB()
  {
    AppMethodBeat.i(343321);
    d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    d.a.u(this.Ged);
    AppMethodBeat.o(343321);
  }
  
  public final e feo()
  {
    AppMethodBeat.i(343284);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    if (!d.a.pX(this.Ged.getLocalId()))
    {
      localObject1 = this.Ged;
      localObject2 = f.Gfh;
      localObject1 = (e)new f((FinderItem)localObject1, f.feu());
      AppMethodBeat.o(343284);
      return localObject1;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("doMvPostScene ", Long.valueOf(this.Ged.getLocalId())));
    localObject1 = ah.d.Ftw;
    ah.d.tI(this.Ged.isLongVideo());
    this.Ged.trackPost("doMvPostScene");
    localObject1 = this.Ged.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 7;
    }
    feB();
    localObject1 = this.Ged.getFeedObject().objectDesc;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((FinderObjectDesc)localObject1).mvInfo)
    {
      localObject1 = this.Ged;
      localObject2 = f.Gfh;
      localObject1 = (e)new f((FinderItem)localObject1, f.fev());
      AppMethodBeat.o(343284);
      return localObject1;
    }
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
      label304:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if (((boq)localObject4).refObjectId == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label304;
          }
          ((Collection)localObject1).add(localObject4);
          break;
        }
      }
      ((LinkedList)localObject2).addAll((Collection)localObject1);
      localObject2 = ((Iterable)localObject2).iterator();
      label328:
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
          break label328;
        }
        localObject1 = new by((FinderItem)localObject1, (boq)localObject3, (byte)0);
        this.GeG.add(localObject1);
        break label328;
        localObject1 = ((bol)localObject1).ZWI;
        kotlin.g.b.s.s(localObject1, "mvInfo.orderedTrackList");
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label525:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (((boq)localObject4).refObjectId == 0L) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label525;
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
    AppMethodBeat.o(343284);
    return localObject1;
  }
  
  public final int fer()
  {
    return 4;
  }
  
  final void g(e parame)
  {
    AppMethodBeat.i(343265);
    this.Gev = parame;
    this.yuW.countDown();
    AppMethodBeat.o(343265);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(343310);
    com.tencent.mm.kernel.h.baD().mCm.b(3585, (com.tencent.mm.am.h)this);
    if (paramp == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(343310);
      throw paramString;
    }
    String str = ((dg)paramp).clientId;
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str });
    if (!str.equals(this.Ged.getPostInfo().clientId))
    {
      Log.w(this.TAG, "not my feed!");
      AppMethodBeat.o(343310);
      return;
    }
    this.Ged.trackPost("doPostSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = g.GbJ;
      g.fdW().ay(this.Ged.getLocalId(), ((dg)paramp).feedObject.id);
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
            break label306;
          }
        }
      }
      label306:
      for (long l = 0L;; l = paramString.draftObjectId)
      {
        j.pZ(l);
        g((e)new d(this.Ged));
        AppMethodBeat.o(343310);
        return;
        l = paramString.draftObjectId;
        break;
      }
    }
    if (this.Ged.isPostFailed())
    {
      paramString = v.FrN;
      v.r(this.Ged.getLocalId(), paramInt1, paramInt2);
      paramString = g.GbJ;
      g.fdW().qz(this.Ged.getLocalId());
    }
    paramString = this.Ged;
    paramp = f.Gfh;
    g((e)new f(paramString, f.fev()));
    AppMethodBeat.o(343310);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/postlogic/mvstage/MvPostCgiStage$mvClipListener$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.am.h
  {
    a(b paramb) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      f.a locala = null;
      AppMethodBeat.i(343219);
      if (((paramp instanceof by)) && (this.Gfd.GeG.contains(paramp)))
      {
        this.Gfd.GeG.remove(paramp);
        FinderObject localFinderObject;
        long l;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localFinderObject = ((by)paramp).dVH();
          Object localObject = ((Iterable)this.Gfd.Ged.getClipListExt()).iterator();
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
                  break label259;
                }
                l = 0L;
                label146:
                paramString.id = l;
              }
              paramString = ((by)paramp).ABV;
              if (localFinderObject != null) {
                break label269;
              }
              l = 0L;
              label169:
              paramString.refObjectId = l;
              localObject = ((by)paramp).ABV;
              if (localFinderObject != null) {
                break label279;
              }
              paramString = locala;
              label193:
              ((boq)localObject).ZWZ = paramString;
              ((by)paramp).ABV.TBO = 0L;
              this.Gfd.feB();
            }
          }
        }
        for (;;)
        {
          if ((!this.Gfd.GeG.isEmpty()) || (this.Gfd.GeH)) {
            break label299;
          }
          this.Gfd.feA();
          AppMethodBeat.o(343219);
          return;
          paramString = null;
          break;
          label259:
          l = localFinderObject.id;
          break label146;
          label269:
          l = localFinderObject.id;
          break label169;
          label279:
          paramString = localFinderObject.objectNonceId;
          break label193;
          this.Gfd.GeH = true;
        }
        label299:
        if ((this.Gfd.GeG.isEmpty()) && (this.Gfd.GeH))
        {
          paramString = this.Gfd;
          paramp = this.Gfd.Ged;
          locala = f.Gfh;
          paramString.g((e)new f(paramp, f.fev()));
        }
      }
      AppMethodBeat.o(343219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.mvstage.b
 * JD-Core Version:    0.7.0.1
 */