package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.cgi.bc;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.v.c;
import com.tencent.mm.plugin.finder.report.v.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "mvClipListener", "getMvClipListener", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postClipFailed", "", "getPostClipFailed", "()Z", "setPostClipFailed", "(Z)V", "postingClipSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "Lkotlin/collections/HashSet;", "getPostingClipSet", "()Ljava/util/HashSet;", "checkIfNeedMarkDelete", "", "preUrl", "", "clearPostFile", "dealDumpCgi", "feedObject", "postScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "dealLongVideoCgi", "doMvPostScene", "doMvPostSceneContinue", "doPostScene", "doPostSceneContinue", "fillReportProcessCostTime", "finderItem", "succ", "costTime", "", "fillReportTotalCostTime", "svrId", "fillReportUploadCostTime", "isToManyTry", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "notifyError", "errType", "", "errCode", "errMsg", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postFinderFeed", "postInfo", "postMvFeed", "saveToDb", "start", "tryPost", "uniqueId", "updateTryCount", "Companion", "plugin-finder_release"})
public class h
  extends j
  implements com.tencent.mm.an.i
{
  private static boolean AAr;
  public static final a AAs;
  final HashSet<bc> AAo;
  boolean AAp;
  final com.tencent.mm.an.i AAq;
  FinderItem Azr;
  
  static
  {
    AppMethodBeat.i(167777);
    AAs = new a((byte)0);
    AppMethodBeat.o(167777);
  }
  
  public h(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167776);
    this.Azr = paramFinderItem;
    this.AAo = new HashSet();
    this.AAq = ((com.tencent.mm.an.i)new f(this));
    AppMethodBeat.o(167776);
  }
  
  private final boolean a(cf paramcf)
  {
    AppMethodBeat.i(225080);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dSo().aSr()).intValue() == 3)
    {
      a(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(225080);
      return false;
    }
    localObject = com.tencent.mm.kernel.h.aHF();
    p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().a(3585, (com.tencent.mm.an.i)this);
    boolean bool = com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramcf);
    AppMethodBeat.o(225080);
    return bool;
  }
  
  private final void aFn(String paramString)
  {
    AppMethodBeat.i(167773);
    Log.w("Finder.LogPost.FinderPostTask", "post failed, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), paramString });
    this.Azr.setPostFailed();
    paramString = this.Azr.field_reportObject;
    if (paramString != null) {
      paramString.cgiErrorType = -1;
    }
    paramString = this.Azr.field_reportObject;
    if (paramString != null) {
      paramString.cgiErrorCode = -1;
    }
    paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    c.a.s(this.Azr);
    a(com.tencent.mm.loader.g.j.kQe);
    paramString = v.d.zYG;
    v.d.qm(this.Azr.isLongVideo());
    AppMethodBeat.o(167773);
  }
  
  private final void ecm()
  {
    AppMethodBeat.i(225076);
    c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
    c.a.r(this.Azr);
    AppMethodBeat.o(225076);
  }
  
  private final void ecn()
  {
    AppMethodBeat.i(225078);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(225078);
  }
  
  private final void w(final FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167770);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramFinderItem));
    AppMethodBeat.o(167770);
  }
  
  public String aBG()
  {
    AppMethodBeat.i(167772);
    String str = "post_" + this.Azr.getLocalId();
    AppMethodBeat.o(167772);
    return str;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(167771);
    Object localObject = com.tencent.mm.kernel.h.aHF();
    p.j(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject).aGY().b(3585, (com.tencent.mm.an.i)this);
    if (paramq == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(167771);
      throw paramString;
    }
    localObject = ((cf)paramq).clientId;
    Log.i("Finder.LogPost.FinderPostTask", "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.Azr.getPostInfo().clientId))
    {
      Log.w("Finder.LogPost.FinderPostTask", "not my feed!");
      AppMethodBeat.o(167771);
      return;
    }
    this.Azr.trackPost("doPostSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      long l = ((cf)paramq).feedObject.id;
      paramString = e.AmW;
      paramString = e.a.MH(l);
      if (paramString != null)
      {
        localObject = paramString.field_reportObject;
        if (localObject != null) {
          ((FinderFeedReportObject)localObject).postTaskCost += (int)ecq();
        }
      }
      if (paramString != null)
      {
        paramString = paramString.field_reportObject;
        if (paramString != null)
        {
          localObject = i.AAy;
          i.a(paramString, "postSuccess");
        }
      }
      paramString = g.AAk;
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g.e(g.ecj(), this.Azr.getLocalId(), ((cf)paramq).feedObject.id));
      if (this.Azr.getPostInfo().TAj > 0L)
      {
        paramString = v.c.zYk;
        v.c.y(cm.bfC() - this.Azr.getPostInfo().TAj, this.Azr.isLongVideo());
      }
      a(com.tencent.mm.loader.g.j.kQd);
      AppMethodBeat.o(167771);
      return;
    }
    a(com.tencent.mm.loader.g.j.kQf);
    if (this.Azr.isPostFailed())
    {
      paramString = k.zWs;
      k.j(this.Azr.getLocalId(), paramInt1, paramInt2);
    }
    AppMethodBeat.o(167771);
  }
  
  public final void start()
  {
    AppMethodBeat.i(225074);
    Object localObject1 = d.AzT;
    long l = this.Azr.getLocalId();
    int k = this.Azr.getPostInfo().TAi;
    for (;;)
    {
      int j;
      try
      {
        Object localObject2 = d.AzQ.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          if (((d.a)((Iterator)localObject2).next()).localId == l)
          {
            j = 1;
            break label911;
            if (i >= 0)
            {
              Log.i(d.TAG, "exist check " + l + ", progress:" + k);
              if (!d.AzP)
              {
                d.AzP = true;
                localObject2 = new d.b();
                com.tencent.e.h.ZvG.o((Runnable)localObject2, d.AzR);
              }
              localObject2 = x.aazN;
              localObject1 = this.Azr.getPostInfo();
              localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
              if ((!((Boolean)com.tencent.mm.plugin.finder.storage.d.dUn().aSr()).booleanValue()) || (Log.getLogLevel() < 0)) {
                break label321;
              }
              Log.i("Finder.LogPost.FinderPostTask", "debug failed");
              aFn("failed for debug");
              localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
              com.tencent.mm.plugin.finder.storage.d.dUn().reset();
              AppMethodBeat.o(225074);
            }
          }
          else
          {
            j = 0;
            break label911;
            i += 1;
          }
        }
        else
        {
          i = -1;
          continue;
        }
        d.AzQ.add(new d.a(l, k, cm.bfC()));
        Log.i(d.TAG, "add check " + l + ", progress:" + k);
        continue;
        if (BuildInfo.DEBUG) {
          break label339;
        }
      }
      finally
      {
        AppMethodBeat.o(225074);
      }
      label321:
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
      {
        label339:
        localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
        com.tencent.mm.plugin.finder.storage.d.dRH();
      }
      int i = ((csh)localObject1).kQn;
      Object localObject4 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (i > com.tencent.mm.plugin.finder.storage.d.dRG()) {}
      for (i = 1; i != 0; i = 0)
      {
        aFn("try to post this feed too many times!");
        AppMethodBeat.o(225074);
        return;
      }
      localObject4 = v.d.zYG;
      v.d.qn(this.Azr.isLongVideo());
      localObject4 = this.Azr;
      Object localObject5 = ((FinderItem)localObject4).getPostInfo();
      ((csh)localObject5).kQn += 1;
      ((FinderItem)localObject4).setPostInfo((csh)localObject5);
      localObject5 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      c.a.s((FinderItem)localObject4);
      if (this.Azr.isMvFeed())
      {
        localObject4 = f.AzZ;
        f.t(this.Azr);
        if (((csh)localObject1).TAg == 1)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          if (c.a.MR(this.Azr.getLocalId()))
          {
            ecn();
            AppMethodBeat.o(225074);
            return;
          }
          Log.i("Finder.LogPost.FinderPostTask", "post before doscene2 cancel because feed is deleted");
          a(com.tencent.mm.loader.g.j.kQf);
          AppMethodBeat.o(225074);
          return;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        if (!c.a.MR(this.Azr.getLocalId()))
        {
          Log.i("Finder.LogPost.FinderPostTask", "post before mediaprocess cancel because feed is deleted");
          a(com.tencent.mm.loader.g.j.kQf);
          AppMethodBeat.o(225074);
          return;
        }
        localObject1 = g.AAk;
        localObject1 = g.ecj();
        localObject4 = new r(this.Azr);
        localObject5 = (com.tencent.mm.loader.g.f)new h(this);
        p.k(localObject4, "processTask");
        p.k(localObject5, "callback");
        ((g)localObject1).AAd.a((com.tencent.mm.loader.g.c)localObject4, (com.tencent.mm.loader.g.f)localObject5);
        AppMethodBeat.o(225074);
        return;
      }
      if (((csh)localObject1).TAg == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        if (!c.a.MR(this.Azr.getLocalId()))
        {
          Log.i("Finder.LogPost.FinderPostTask", "post before doscene2 cancel because feed is deleted");
          a(com.tencent.mm.loader.g.j.kQf);
          AppMethodBeat.o(225074);
        }
      }
      else
      {
        Log.i("Finder.LogPost.FinderPostTask", "try post need upload task " + this.Azr.getLocalId());
        localObject1 = this.Azr.getFinderObject();
        if (localObject1 != null) {
          localObject1 = ((FinderObject)localObject1).objectDesc;
        }
        while ((localObject1 != null) && (this.Azr.getRefObjectFlag() == 0L))
        {
          localObject1 = f.AzZ;
          f.t(this.Azr);
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          if (!c.a.MR(this.Azr.getLocalId()))
          {
            Log.i("Finder.LogPost.FinderPostTask", "post before mediaprocess cancel because feed is deleted");
            a(com.tencent.mm.loader.g.j.kQf);
            AppMethodBeat.o(225074);
            return;
            localObject1 = null;
          }
          else
          {
            localObject1 = g.AAk;
            localObject1 = g.ecj();
            localObject4 = new c(this.Azr);
            localObject5 = (com.tencent.mm.loader.g.f)new g(this);
            p.k(localObject4, "processTask");
            p.k(localObject5, "callback");
            ((g)localObject1).AAc.a((com.tencent.mm.loader.g.c)localObject4, (com.tencent.mm.loader.g.f)localObject5);
            AppMethodBeat.o(225074);
            return;
          }
        }
      }
      w(this.Azr);
      AppMethodBeat.o(225074);
      return;
      label911:
      if (j == 0) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask$Companion;", "", "()V", "TAG", "", "debugDeleteFileWhenMoveFile", "", "getDebugDeleteFileWhenMoveFile", "()Z", "setDebugDeleteFileWhenMoveFile", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(h paramh, FinderItem paramFinderItem, cf paramcf) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(h paramh, FinderItem paramFinderItem, cf paramcf) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(h paramh, FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostTask$mvClipListener$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.an.i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      Object localObject1 = null;
      AppMethodBeat.i(243340);
      if (((paramq instanceof bc)) && (this.AAt.AAo.contains(paramq)))
      {
        this.AAt.AAo.remove(paramq);
        long l;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((bc)paramq).lKU.bhY();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostDraftResponse");
            AppMethodBeat.o(243340);
            throw paramString;
          }
          FinderObject localFinderObject = ((bgv)paramString).SFP;
          Object localObject2 = ((Iterable)this.AAt.Azr.getClipListExt()).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramString = ((Iterator)localObject2).next();
            if (p.h(((FinderItem)paramString).getObjectNonceId(), ((bc)paramq).xcG.getObjectNonceId()))
            {
              paramString = (FinderItem)paramString;
              if (paramString != null)
              {
                paramString = paramString.getFeedObject();
                if (localFinderObject == null) {
                  break label305;
                }
                l = localFinderObject.id;
                label182:
                paramString.id = l;
              }
              paramString = ((bc)paramq).xcH;
              if (localFinderObject == null) {
                break label311;
              }
              l = localFinderObject.id;
              label209:
              paramString.refObjectId = l;
              localObject2 = ((bc)paramq).xcH;
              paramString = localObject1;
              if (localFinderObject != null) {
                paramString = localFinderObject.objectNonceId;
              }
              ((bdt)localObject2).SOS = paramString;
              ((bc)paramq).xcH.MSG = 0L;
              h.b(this.AAt);
            }
          }
        }
        for (;;)
        {
          if ((!this.AAt.AAo.isEmpty()) || (this.AAt.AAp)) {
            break label328;
          }
          h.c(this.AAt);
          AppMethodBeat.o(243340);
          return;
          paramString = null;
          break;
          label305:
          l = 0L;
          break label182;
          label311:
          l = 0L;
          break label209;
          this.AAt.AAp = true;
        }
        label328:
        if ((this.AAt.AAo.isEmpty()) && (this.AAt.AAp)) {
          this.AAt.a(com.tencent.mm.loader.g.j.kQf);
        }
      }
      AppMethodBeat.o(243340);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostTask$postFinderFeed$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<c>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostTask$postFinderFeed$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.loader.g.f<n>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostTask$postMvFeed$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.loader.g.f<r>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostTask$postMvFeed$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.loader.g.f<s>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.h
 * JD-Core Version:    0.7.0.1
 */