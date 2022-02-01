package com.tencent.mm.plugin.finder.upload;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.cgi.cb;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.report.r.c;
import com.tencent.mm.plugin.finder.report.r.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "mvClipListener", "getMvClipListener", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postClipFailed", "", "getPostClipFailed", "()Z", "setPostClipFailed", "(Z)V", "postingClipSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "Lkotlin/collections/HashSet;", "getPostingClipSet", "()Ljava/util/HashSet;", "checkIfNeedMarkDelete", "", "preUrl", "", "clearPostFile", "dealDumpCgi", "feedObject", "postScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "dealLongVideoCgi", "doMvPostScene", "doMvPostSceneContinue", "doPostScene", "doPostSceneContinue", "fillReportProcessCostTime", "finderItem", "succ", "costTime", "", "fillReportTotalCostTime", "svrId", "fillReportUploadCostTime", "isInPosting", "path", "isToManyTry", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "moveFileToPost", "moveFileToPostForNormal", "moveFileToPostForVLog", "notifyError", "errType", "", "errCode", "errMsg", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postFinderFeed", "postInfo", "postMvFeed", "saveToDb", "start", "tryPost", "uniqueId", "updateTryCount", "Companion", "plugin-finder_release"})
public class h
  extends j
  implements com.tencent.mm.ak.i
{
  private static boolean vSQ;
  public static final a vSR;
  FinderItem vRO;
  final HashSet<az> vSN;
  boolean vSO;
  final com.tencent.mm.ak.i vSP;
  
  static
  {
    AppMethodBeat.i(167777);
    vSR = new a((byte)0);
    AppMethodBeat.o(167777);
  }
  
  public h(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167776);
    this.vRO = paramFinderItem;
    this.vSN = new HashSet();
    this.vSP = ((com.tencent.mm.ak.i)new f(this));
    AppMethodBeat.o(167776);
  }
  
  private final boolean a(cb paramcb)
  {
    AppMethodBeat.i(253091);
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dra().value()).intValue() == 3)
    {
      a(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(253091);
      return false;
    }
    localObject = com.tencent.mm.kernel.g.aAg();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().a(3585, (com.tencent.mm.ak.i)this);
    boolean bool = com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramcb);
    AppMethodBeat.o(253091);
    return bool;
  }
  
  private final void avW(String paramString)
  {
    AppMethodBeat.i(167773);
    Log.w("Finder.LogPost.FinderPostTask", "post failed, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), paramString });
    this.vRO.setPostFailed();
    paramString = this.vRO.field_reportObject;
    if (paramString != null) {
      paramString.cgiErrorType = -1;
    }
    paramString = this.vRO.field_reportObject;
    if (paramString != null) {
      paramString.cgiErrorCode = -1;
    }
    paramString = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    c.a.r(this.vRO);
    a(com.tencent.mm.loader.g.j.ibx);
    paramString = g.vSJ;
    g.dBa().FY(this.vRO.getLocalId());
    paramString = r.d.vhx;
    r.d.ob(this.vRO.isLongVideo());
    AppMethodBeat.o(167773);
  }
  
  private static boolean avX(String paramString)
  {
    AppMethodBeat.i(253093);
    if (paramString != null)
    {
      al localal = al.waC;
      boolean bool = kotlin.n.n.J(paramString, al.dEH(), false);
      AppMethodBeat.o(253093);
      return bool;
    }
    AppMethodBeat.o(253093);
    return false;
  }
  
  private static void avY(String paramString)
  {
    AppMethodBeat.i(167775);
    Object localObject = al.waC;
    if (kotlin.n.n.J(paramString, al.dEH(), false))
    {
      localObject = f.vSz;
      f.avV(paramString);
    }
    AppMethodBeat.o(167775);
  }
  
  private final void dBc()
  {
    AppMethodBeat.i(253089);
    c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    c.a.q(this.vRO);
    AppMethodBeat.o(253089);
  }
  
  private final void dBd()
  {
    AppMethodBeat.i(253090);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(253090);
  }
  
  private final void dBe()
  {
    AppMethodBeat.i(167774);
    Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost");
    Object localObject = al.waC;
    localObject = al.dEH();
    com.tencent.mm.vfs.s.boN((String)localObject);
    if ((vSQ) && (Log.getLogLevel() <= 1))
    {
      Log.i("Finder.LogPost.FinderPostTask", "debugDeleteFileWhenMoveFile");
      com.tencent.mm.vfs.s.dy((String)localObject, true);
    }
    if (!this.vRO.isMvFeed())
    {
      if ((this.vRO.getMediaExtList().size() != 1) || (((cjl)this.vRO.getMediaExtList().get(0)).MfU == null)) {
        break label139;
      }
      dBf();
    }
    for (;;)
    {
      localObject = this.vRO.getMediaList();
      this.vRO.setMediaList((LinkedList)localObject);
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      c.a.r(this.vRO);
      AppMethodBeat.o(167774);
      return;
      label139:
      dBg();
    }
  }
  
  private final void dBf()
  {
    AppMethodBeat.i(253092);
    Object localObject3 = ((cjl)this.vRO.getMediaExtList().get(0)).MfU;
    if (localObject3 != null)
    {
      localObject1 = ((acn)localObject3).Lnd;
      if (localObject1 != null)
      {
        Iterator localIterator = ((Iterable)localObject1).iterator();
        while (localIterator.hasNext())
        {
          ejf localejf = (ejf)localIterator.next();
          if (com.tencent.mm.vfs.s.YS(localejf.path))
          {
            localObject1 = localejf.path;
            p.g(localObject1, "it.path");
            localObject2 = al.waC;
            if (!kotlin.n.n.J((String)localObject1, al.dEH(), false))
            {
              localObject1 = al.waC;
              String str = al.awC(MD5Util.getMD5String(localejf.path) + localejf.hashCode());
              localObject2 = localejf.path;
              localObject1 = localObject2;
              if (Build.VERSION.SDK_INT >= 30)
              {
                Uri localUri = p.b.P(MMApplicationContext.getContext(), (String)localObject2);
                localObject1 = localObject2;
                if (localObject2 != null) {
                  localObject1 = String.valueOf(localUri);
                }
              }
              com.tencent.mm.vfs.s.nw((String)localObject1, str);
              Log.i("Finder.LogPost.FinderPostTask", "copy " + localejf.path + " to " + str + "  real:" + com.tencent.mm.vfs.s.k(str, false) + ",result:" + com.tencent.mm.vfs.s.YS(str));
              if (com.tencent.mm.vfs.s.YS(str))
              {
                if (localejf.Gze == 1)
                {
                  localObject1 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                  com.tencent.mm.plugin.recordvideo.e.c.aLC(localejf.path);
                }
                localObject1 = ((acn)localObject3).Lnj;
                p.g(localObject1, "compositionInfo.trackLabelInfoList");
                localObject2 = ((Iterable)localObject1).iterator();
                do
                {
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localObject1 = ((Iterator)localObject2).next();
                } while (!p.j(((acp)localObject1).path, localejf.path));
                for (;;)
                {
                  localObject1 = (acp)localObject1;
                  if (localObject1 != null) {
                    ((acp)localObject1).path = str;
                  }
                  localejf.path = str;
                  break;
                  localObject1 = null;
                }
              }
            }
          }
        }
      }
    }
    Object localObject2 = ((cjl)this.vRO.getMediaExtList().get(0)).thumbUrl;
    if ((com.tencent.mm.vfs.s.YS((String)localObject2)) && (localObject2 != null))
    {
      localObject1 = al.waC;
      if (!kotlin.n.n.J((String)localObject2, al.dEH(), false))
      {
        localObject1 = al.waC;
        localObject3 = al.awC(MD5Util.getMD5String((String)localObject2) + ((String)localObject2).hashCode());
        if (Build.VERSION.SDK_INT < 30) {
          break label574;
        }
      }
    }
    label574:
    for (Object localObject1 = String.valueOf(p.b.O(MMApplicationContext.getContext(), (String)localObject2));; localObject1 = localObject2)
    {
      com.tencent.mm.vfs.s.nw((String)localObject1, (String)localObject3);
      Log.i("Finder.LogPost.FinderPostTask", "copy thumb" + (String)localObject2 + " to " + (String)localObject3 + "  real:" + com.tencent.mm.vfs.s.k((String)localObject3, false) + ",result:" + com.tencent.mm.vfs.s.YS((String)localObject3));
      if (com.tencent.mm.vfs.s.YS((String)localObject3))
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.aLC((String)localObject2);
        ((cjl)this.vRO.getMediaExtList().get(0)).thumbUrl = ((String)localObject3);
      }
      AppMethodBeat.o(253092);
      return;
    }
  }
  
  private final void dBg()
  {
    AppMethodBeat.i(253094);
    Iterator localIterator = ((Iterable)this.vRO.getMediaList()).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      cjl localcjl = (cjl)localObject1;
      boolean bool1 = com.tencent.mm.vfs.s.YS(localcjl.url);
      boolean bool2 = com.tencent.mm.vfs.s.YS(localcjl.thumbUrl);
      boolean bool3 = com.tencent.mm.vfs.s.YS(localcjl.coverUrl);
      localObject1 = MD5Util.getMD5String(localcjl.url);
      boolean bool4 = avX(localcjl.url);
      boolean bool5 = avX(localcjl.thumbUrl);
      boolean bool6 = avX(localcjl.coverUrl);
      Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost, mediaId: " + (String)localObject1 + ", fileExist:" + bool1 + ", thumbExist:" + bool2 + ", before url: " + localcjl.url + ", " + localcjl.thumbUrl + ", " + localcjl.coverUrl);
      if ((bool1) || (bool2)) {
        switch (localcjl.mediaType)
        {
        }
      }
      label963:
      label981:
      for (;;)
      {
        Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost, after mediaId: " + localcjl.mediaId + ", url: " + localcjl.url + ", " + localcjl.thumbUrl + ", " + localcjl.coverUrl);
        i += 1;
        break;
        Object localObject2;
        Object localObject3;
        if ((bool1) && (bool2) && (!bool5))
        {
          Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image thumb");
          localObject1 = f.vSz;
          localObject2 = localcjl.url;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = localcjl.thumbUrl;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject1 = f.gY((String)localObject1, (String)localObject2);
          if (com.tencent.mm.vfs.s.YS((String)localObject1)) {
            localcjl.thumbUrl = ((String)localObject1);
          }
        }
        if ((bool1) && (!bool4))
        {
          Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image");
          localObject1 = new k(localcjl, com.tencent.mm.plugin.finder.storage.x.vEn, null, null, 12);
          localObject2 = al.waC;
          localObject1 = al.a((k)localObject1, String.valueOf(this.vRO.getCreateTime()));
          long l = com.tencent.mm.vfs.s.nw(localcjl.url, (String)localObject1);
          if (com.tencent.mm.vfs.s.YS((String)localObject1))
          {
            localcjl.url = ((String)localObject1);
            localcjl.mediaId = MD5Util.getMD5String(localcjl.url);
          }
          else
          {
            Log.i("Finder.LogPost.FinderPostTask", "copy Image failed, copyRet:".concat(String.valueOf(l)));
            continue;
            if (!this.vRO.isNeedCrop(i))
            {
              if ((bool1) && (bool2) && (!bool5))
              {
                Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video thumb");
                localObject2 = localcjl.thumbUrl;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                p.g(localObject1, "it.thumbUrl ?: \"\"");
                localObject2 = f.vSz;
                localObject3 = localcjl.url;
                localObject2 = localObject3;
                if (localObject3 == null) {
                  localObject2 = "";
                }
                String str = localcjl.thumbUrl;
                localObject3 = str;
                if (str == null) {
                  localObject3 = "";
                }
                localObject2 = f.gX((String)localObject2, (String)localObject3);
                if (com.tencent.mm.vfs.s.YS((String)localObject2))
                {
                  localcjl.thumbUrl = ((String)localObject2);
                  if ((p.j(localObject1, localcjl.thumbUrl) ^ true)) {
                    avY((String)localObject1);
                  }
                }
              }
              if ((bool1) && (!bool4))
              {
                Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video");
                localObject1 = new com.tencent.mm.plugin.finder.loader.s(localcjl, com.tencent.mm.plugin.finder.storage.x.vEA, 0, null, 12);
                localObject2 = al.waC;
                localObject3 = al.a((com.tencent.mm.plugin.finder.loader.s)localObject1, String.valueOf(this.vRO.getCreateTime()));
                l = com.tencent.mm.vfs.s.nw(localcjl.url, (String)localObject3);
                if (!com.tencent.mm.vfs.s.YS((String)localObject3)) {
                  break label963;
                }
                if ((p.j(localObject3, localcjl.url) ^ true))
                {
                  localObject2 = localcjl.url;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  avY((String)localObject1);
                }
                localcjl.url = ((String)localObject3);
                localObject2 = localcjl.url;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                localcjl.mediaId = MD5Util.getMD5String((String)localObject1);
              }
            }
            for (;;)
            {
              if ((!bool3) || (bool6)) {
                break label981;
              }
              localObject1 = localcjl.coverUrl;
              if (localObject1 == null) {
                break;
              }
              localObject2 = al.waC;
              if (kotlin.n.n.J((String)localObject1, al.dEH(), false) != true) {
                break;
              }
              Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Cover");
              localObject1 = new com.tencent.mm.plugin.finder.loader.q(localcjl, com.tencent.mm.plugin.finder.storage.x.vEn);
              localObject2 = al.waC;
              localObject1 = al.a((com.tencent.mm.plugin.finder.loader.q)localObject1, String.valueOf(this.vRO.getCreateTime()));
              com.tencent.mm.vfs.s.nw(localcjl.coverUrl, (String)localObject1);
              localcjl.coverUrl = ((String)localObject1);
              break;
              Log.i("Finder.LogPost.FinderPostTask", "copy Video failed, copyRet:".concat(String.valueOf(l)));
            }
          }
        }
      }
    }
    AppMethodBeat.o(253094);
  }
  
  private final void u(final FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167770);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new e(this, paramFinderItem));
    AppMethodBeat.o(167770);
  }
  
  public String auK()
  {
    AppMethodBeat.i(167772);
    String str = "post_" + this.vRO.getLocalId();
    AppMethodBeat.o(167772);
    return str;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(167771);
    Object localObject = com.tencent.mm.kernel.g.aAg();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().b(3585, (com.tencent.mm.ak.i)this);
    if (paramq == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(167771);
      throw paramString;
    }
    localObject = ((cb)paramq).clientId;
    Log.i("Finder.LogPost.FinderPostTask", "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.vRO.getPostInfo().clientId))
    {
      Log.w("Finder.LogPost.FinderPostTask", "not my feed!");
      AppMethodBeat.o(167771);
      return;
    }
    this.vRO.trackPost("doPostSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      long l = ((cb)paramq).feedObject.id;
      paramString = e.vFX;
      paramString = e.a.Fy(l);
      if (paramString != null)
      {
        localObject = paramString.field_reportObject;
        if (localObject != null) {
          ((FinderFeedReportObject)localObject).postTaskCost += (int)dBi();
        }
      }
      if (paramString != null)
      {
        paramString = paramString.field_reportObject;
        if (paramString != null)
        {
          localObject = i.vSX;
          i.a(paramString, "postSuccess");
        }
      }
      paramString = g.vSJ;
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new g.e(g.dBa(), this.vRO.getLocalId(), ((cb)paramq).feedObject.id));
      if (this.vRO.getPostInfo().Mpd > 0L)
      {
        paramString = r.c.vhb;
        r.c.y(cl.aWy() - this.vRO.getPostInfo().Mpd, this.vRO.isLongVideo());
      }
      a(com.tencent.mm.loader.g.j.ibw);
      AppMethodBeat.o(167771);
      return;
    }
    a(com.tencent.mm.loader.g.j.iby);
    if (this.vRO.isPostFailed())
    {
      paramString = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.j(this.vRO.getLocalId(), paramInt1, paramInt2);
      paramString = g.vSJ;
      g.dBa().FY(this.vRO.getLocalId());
    }
    AppMethodBeat.o(167771);
  }
  
  public final void start()
  {
    AppMethodBeat.i(253088);
    Object localObject1 = d.vSt;
    long l = this.vRO.getLocalId();
    int k = this.vRO.getPostInfo().Mpc;
    for (;;)
    {
      int j;
      try
      {
        Object localObject2 = d.vSq.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          if (((d.a)((Iterator)localObject2).next()).localId == l)
          {
            j = 1;
            break label895;
            if (i >= 0)
            {
              Log.i(d.TAG, "exist check " + l + ", progress:" + k);
              if (!d.vSp)
              {
                d.vSp = true;
                localObject2 = new d.b();
                com.tencent.f.h.RTc.o((Runnable)localObject2, d.vSr);
              }
              localObject2 = kotlin.x.SXb;
              localObject1 = this.vRO.getPostInfo();
              localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
              if ((!((Boolean)com.tencent.mm.plugin.finder.storage.c.dsU().value()).booleanValue()) || (Log.getLogLevel() < 0)) {
                break label321;
              }
              Log.i("Finder.LogPost.FinderPostTask", "debug failed");
              avW("failed for debug");
              localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
              com.tencent.mm.plugin.finder.storage.c.dsU().reset();
              AppMethodBeat.o(253088);
            }
          }
          else
          {
            j = 0;
            break label895;
            i += 1;
          }
        }
        else
        {
          i = -1;
          continue;
        }
        d.vSq.add(new d.a(l, k, cl.aWy()));
        Log.i(d.TAG, "add check " + l + ", progress:" + k);
        continue;
        if (BuildInfo.DEBUG) {
          break label339;
        }
      }
      finally
      {
        AppMethodBeat.o(253088);
      }
      label321:
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
      {
        label339:
        localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c.dqv();
      }
      int i = ((cjm)localObject1).ibG;
      Object localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (i > com.tencent.mm.plugin.finder.storage.c.dqu()) {}
      for (i = 1; i != 0; i = 0)
      {
        avW("try to post this feed too many times!");
        AppMethodBeat.o(253088);
        return;
      }
      localObject4 = r.d.vhx;
      r.d.oc(this.vRO.isLongVideo());
      localObject4 = this.vRO;
      Object localObject5 = ((FinderItem)localObject4).getPostInfo();
      ((cjm)localObject5).ibG += 1;
      ((FinderItem)localObject4).setPostInfo((cjm)localObject5);
      localObject5 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      c.a.r((FinderItem)localObject4);
      if (this.vRO.isMvFeed())
      {
        dBe();
        if (((cjm)localObject1).Mpa == 1)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          if (c.a.FR(this.vRO.getLocalId()))
          {
            dBd();
            AppMethodBeat.o(253088);
            return;
          }
          Log.i("Finder.LogPost.FinderPostTask", "post before doscene2 cancel because feed is deleted");
          a(com.tencent.mm.loader.g.j.iby);
          AppMethodBeat.o(253088);
          return;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        if (!c.a.FR(this.vRO.getLocalId()))
        {
          Log.i("Finder.LogPost.FinderPostTask", "post before mediaprocess cancel because feed is deleted");
          a(com.tencent.mm.loader.g.j.iby);
          AppMethodBeat.o(253088);
          return;
        }
        localObject1 = g.vSJ;
        localObject1 = g.dBa();
        localObject4 = new r(this.vRO);
        localObject5 = (com.tencent.mm.loader.g.f)new h(this);
        p.h(localObject4, "processTask");
        p.h(localObject5, "callback");
        ((g)localObject1).vSD.a((com.tencent.mm.loader.g.c)localObject4, (com.tencent.mm.loader.g.f)localObject5);
        AppMethodBeat.o(253088);
        return;
      }
      if (((cjm)localObject1).Mpa == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        if (!c.a.FR(this.vRO.getLocalId()))
        {
          Log.i("Finder.LogPost.FinderPostTask", "post before doscene2 cancel because feed is deleted");
          a(com.tencent.mm.loader.g.j.iby);
          AppMethodBeat.o(253088);
        }
      }
      else
      {
        Log.i("Finder.LogPost.FinderPostTask", "try post need upload task " + this.vRO.getLocalId());
        localObject1 = this.vRO.getFinderObject();
        if (localObject1 != null) {
          localObject1 = ((FinderObject)localObject1).objectDesc;
        }
        while ((localObject1 != null) && (this.vRO.getRefObjectFlag() == 0L))
        {
          dBe();
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          if (!c.a.FR(this.vRO.getLocalId()))
          {
            Log.i("Finder.LogPost.FinderPostTask", "post before mediaprocess cancel because feed is deleted");
            a(com.tencent.mm.loader.g.j.iby);
            AppMethodBeat.o(253088);
            return;
            localObject1 = null;
          }
          else
          {
            localObject1 = g.vSJ;
            localObject1 = g.dBa();
            localObject4 = new c(this.vRO);
            localObject5 = (com.tencent.mm.loader.g.f)new g(this);
            p.h(localObject4, "processTask");
            p.h(localObject5, "callback");
            ((g)localObject1).vSC.a((com.tencent.mm.loader.g.c)localObject4, (com.tencent.mm.loader.g.f)localObject5);
            AppMethodBeat.o(253088);
            return;
          }
        }
      }
      u(this.vRO);
      AppMethodBeat.o(253088);
      return;
      label895:
      if (j == 0) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask$Companion;", "", "()V", "TAG", "", "debugDeleteFileWhenMoveFile", "", "getDebugDeleteFileWhenMoveFile", "()Z", "setDebugDeleteFileWhenMoveFile", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(h paramh, FinderItem paramFinderItem, cb paramcb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(h paramh, FinderItem paramFinderItem, cb paramcb) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    e(h paramh, FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostTask$mvClipListener$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.ak.i
  {
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      Object localObject1 = null;
      AppMethodBeat.i(253083);
      if (((paramq instanceof az)) && (this.vSS.vSN.contains(paramq)))
      {
        this.vSS.vSN.remove(paramq);
        long l;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((az)paramq).iUB.aYK();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostDraftResponse");
            AppMethodBeat.o(253083);
            throw paramString;
          }
          FinderObject localFinderObject = ((bak)paramString).LCD;
          Object localObject2 = ((Iterable)this.vSS.vRO.getClipListExt()).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramString = ((Iterator)localObject2).next();
            if (p.j(((FinderItem)paramString).getObjectNonceId(), ((az)paramq).tuX.getObjectNonceId()))
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
              paramString = ((az)paramq).tuY;
              if (localFinderObject == null) {
                break label311;
              }
              l = localFinderObject.id;
              label209:
              paramString.refObjectId = l;
              localObject2 = ((az)paramq).tuY;
              paramString = localObject1;
              if (localFinderObject != null) {
                paramString = localFinderObject.objectNonceId;
              }
              ((axz)localObject2).LIm = paramString;
              ((az)paramq).tuY.Ghw = 0L;
              h.b(this.vSS);
            }
          }
        }
        for (;;)
        {
          if ((!this.vSS.vSN.isEmpty()) || (this.vSS.vSO)) {
            break label328;
          }
          h.c(this.vSS);
          AppMethodBeat.o(253083);
          return;
          paramString = null;
          break;
          label305:
          l = 0L;
          break label182;
          label311:
          l = 0L;
          break label209;
          this.vSS.vSO = true;
        }
        label328:
        if ((this.vSS.vSN.isEmpty()) && (this.vSS.vSO)) {
          this.vSS.a(com.tencent.mm.loader.g.j.iby);
        }
      }
      AppMethodBeat.o(253083);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostTask$postFinderFeed$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<c>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostTask$postFinderFeed$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.loader.g.f<n>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostTask$postMvFeed$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.loader.g.f<r>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostTask$postMvFeed$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.loader.g.f<s>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.h
 * JD-Core Version:    0.7.0.1
 */