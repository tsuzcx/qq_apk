package com.tencent.mm.plugin.finder.upload;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.n.b;
import com.tencent.mm.plugin.finder.report.n.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "call", "", "checkIfNeedMarkDelete", "preUrl", "", "clearPostFile", "doPostScene", "feedObject", "isToManyTry", "", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "moveFileToPost", "moveFileToPostForNormal", "moveFileToPostForVLog", "notifyError", "errType", "", "errCode", "errMsg", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryPost", "postInfo", "uniqueId", "updateTryCount", "Companion", "plugin-finder_release"})
public class h
  extends com.tencent.mm.loader.g.c
  implements com.tencent.mm.al.f
{
  private static boolean sJo;
  public static final a sJp;
  FinderItem sIF;
  
  static
  {
    AppMethodBeat.i(167777);
    sJp = new a((byte)0);
    AppMethodBeat.o(167777);
  }
  
  public h(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167776);
    this.sIF = paramFinderItem;
    AppMethodBeat.o(167776);
  }
  
  private final void aiN(String paramString)
  {
    AppMethodBeat.i(167773);
    ad.w("Finder.LogPost.FinderPostTask", "post failed, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), paramString });
    this.sIF.setPostFailed();
    paramString = this.sIF.field_reportObject;
    if (paramString != null) {
      paramString.cgiErrorType = -1;
    }
    paramString = this.sIF.field_reportObject;
    if (paramString != null) {
      paramString.cgiErrorCode = -1;
    }
    paramString = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    b.a.i(this.sIF);
    a(com.tencent.mm.loader.g.j.hfL);
    paramString = g.sJk;
    g.cKK().xk(this.sIF.getLocalId());
    paramString = n.c.sqy;
    n.c.cDN();
    AppMethodBeat.o(167773);
  }
  
  private static void aiO(String paramString)
  {
    AppMethodBeat.i(167775);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sNc;
    if (d.n.n.nz(paramString, com.tencent.mm.plugin.finder.utils.r.cLQ()))
    {
      localObject = f.sJc;
      f.aiM(paramString);
    }
    AppMethodBeat.o(167775);
  }
  
  private final void cKM()
  {
    AppMethodBeat.i(204337);
    Object localObject1 = ((bvf)this.sIF.getMediaExtList().get(0)).GPu.FZu;
    p.g(localObject1, "compositionInfo.tracks");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (dom)((Iterator)localObject1).next();
      if (com.tencent.mm.vfs.i.fv(((dom)localObject2).path))
      {
        localObject3 = ((dom)localObject2).path;
        p.g(localObject3, "it.path");
        Object localObject4 = com.tencent.mm.plugin.finder.utils.r.sNc;
        if (!d.n.n.nz((String)localObject3, com.tencent.mm.plugin.finder.utils.r.cLQ()))
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.r.sNc;
          localObject3 = com.tencent.mm.plugin.finder.utils.r.aje(ai.ee(((dom)localObject2).path) + ((dom)localObject2).hashCode());
          com.tencent.mm.vfs.i.mz(((dom)localObject2).path, (String)localObject3);
          ad.i("Finder.LogPost.FinderPostTask", "copy " + ((dom)localObject2).path + " to " + (String)localObject3 + "  real:" + com.tencent.mm.vfs.i.k((String)localObject3, false) + ",result:" + com.tencent.mm.vfs.i.fv((String)localObject3));
          if (com.tencent.mm.vfs.i.fv((String)localObject3))
          {
            if (((dom)localObject2).BGb == 1)
            {
              localObject4 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
              com.tencent.mm.plugin.recordvideo.e.b.avP(((dom)localObject2).path);
            }
            ((dom)localObject2).path = ((String)localObject3);
          }
        }
      }
    }
    localObject1 = ((bvf)this.sIF.getMediaExtList().get(0)).thumbUrl;
    if (com.tencent.mm.vfs.i.fv((String)localObject1))
    {
      p.g(localObject1, "thumbPath");
      localObject2 = com.tencent.mm.plugin.finder.utils.r.sNc;
      if (!d.n.n.nz((String)localObject1, com.tencent.mm.plugin.finder.utils.r.cLQ()))
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.r.sNc;
        localObject2 = com.tencent.mm.plugin.finder.utils.r.aje(ai.ee((String)localObject1) + ((String)localObject1).hashCode());
        com.tencent.mm.vfs.i.mz((String)localObject1, (String)localObject2);
        ad.i("Finder.LogPost.FinderPostTask", "copy thumb" + (String)localObject1 + " to " + (String)localObject2 + "  real:" + com.tencent.mm.vfs.i.k((String)localObject2, false) + ",result:" + com.tencent.mm.vfs.i.fv((String)localObject2));
        if (com.tencent.mm.vfs.i.fv((String)localObject2))
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
          com.tencent.mm.plugin.recordvideo.e.b.avP((String)localObject1);
          ((bvf)this.sIF.getMediaExtList().get(0)).thumbUrl = ((String)localObject2);
        }
      }
    }
    AppMethodBeat.o(204337);
  }
  
  private final void cKN()
  {
    AppMethodBeat.i(204338);
    Iterator localIterator = ((Iterable)this.sIF.getMediaList()).iterator();
    int i = 0;
    label683:
    label703:
    label1262:
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        d.a.j.gfB();
      }
      localObject1 = (bvf)localObject1;
      boolean bool1 = com.tencent.mm.vfs.i.fv(((bvf)localObject1).url);
      boolean bool2 = com.tencent.mm.vfs.i.fv(((bvf)localObject1).thumbUrl);
      boolean bool3 = com.tencent.mm.vfs.i.fv(((bvf)localObject1).coverUrl);
      Object localObject2 = ai.ee(((bvf)localObject1).url);
      ad.i("Finder.LogPost.FinderPostTask", "moveFileToPost, mediaId: " + (String)localObject2 + ", fileExist:" + bool1 + ", thumbExist:" + bool2 + ", before url: " + ((bvf)localObject1).url + ", " + ((bvf)localObject1).thumbUrl + ", " + ((bvf)localObject1).coverUrl);
      if ((bool1) || (bool2)) {
        switch (((bvf)localObject1).mediaType)
        {
        }
      }
      label895:
      label1279:
      for (;;)
      {
        ad.i("Finder.LogPost.FinderPostTask", "moveFileToPost, after mediaId: " + ((bvf)localObject1).mediaId + ", url: " + ((bvf)localObject1).url + ", " + ((bvf)localObject1).thumbUrl + ", " + ((bvf)localObject1).coverUrl);
        i += 1;
        break;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if ((bool1) && (bool2))
        {
          localObject2 = ((bvf)localObject1).thumbUrl;
          p.g(localObject2, "it.thumbUrl");
          localObject3 = com.tencent.mm.plugin.finder.utils.r.sNc;
          if (!d.n.n.nz((String)localObject2, com.tencent.mm.plugin.finder.utils.r.cLQ()))
          {
            ad.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image thumb");
            localObject2 = f.sJc;
            localObject2 = ((bvf)localObject1).url;
            p.g(localObject2, "it.url");
            localObject3 = ((bvf)localObject1).thumbUrl;
            p.g(localObject3, "it.thumbUrl");
            p.h(localObject2, "imagePath");
            p.h(localObject3, "thumbOriginPath");
            localObject4 = com.tencent.mm.plugin.finder.utils.r.sNc;
            p.h(localObject2, "imagePath");
            localObject4 = com.tencent.mm.plugin.finder.utils.r.cLQ() + "image_" + ai.ee((String)localObject2) + "_" + com.tencent.mm.vfs.i.aYp((String)localObject2) + "_thumb";
            ad.i(f.TAG, "copyImageThumbFromTmpToPost, imagePath:" + (String)localObject2 + ", thumbOriginPath:" + (String)localObject3 + ", thumbPostPath:" + (String)localObject4);
            localObject5 = i.sJt;
            if (!i.aiP((String)localObject3)) {
              break label683;
            }
            ad.i(f.TAG, "copyImageThumbFromTmpToPost exist, copy");
            com.tencent.mm.vfs.i.mz((String)localObject3, (String)localObject4);
          }
        }
        long l;
        for (;;)
        {
          if (com.tencent.mm.vfs.i.fv((String)localObject4)) {
            ((bvf)localObject1).thumbUrl = ((String)localObject4);
          }
          if (!bool1) {
            break;
          }
          localObject2 = ((bvf)localObject1).url;
          p.g(localObject2, "it.url");
          localObject3 = com.tencent.mm.plugin.finder.utils.r.sNc;
          if (d.n.n.nz((String)localObject2, com.tencent.mm.plugin.finder.utils.r.cLQ())) {
            break;
          }
          ad.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image");
          localObject2 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject1, com.tencent.mm.plugin.finder.storage.r.syD);
          localObject3 = com.tencent.mm.plugin.finder.utils.r.sNc;
          localObject2 = com.tencent.mm.plugin.finder.utils.r.a((com.tencent.mm.plugin.finder.loader.g)localObject2, String.valueOf(this.sIF.getCreateTime()));
          l = com.tencent.mm.vfs.i.mz(((bvf)localObject1).url, (String)localObject2);
          if (!com.tencent.mm.vfs.i.fv((String)localObject2)) {
            break label703;
          }
          ((bvf)localObject1).url = ((String)localObject2);
          ((bvf)localObject1).mediaId = ai.ee(((bvf)localObject1).url);
          break;
          ad.i(f.TAG, "copyImageThumbFromTmpToPost not exist, generate");
          f.gs((String)localObject2, (String)localObject4);
        }
        ad.i("Finder.LogPost.FinderPostTask", "copy Image failed, copyRet:".concat(String.valueOf(l)));
        continue;
        if (!this.sIF.isNeedCrop(i))
        {
          if ((bool1) && (bool2))
          {
            ad.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video thumb");
            localObject2 = ((bvf)localObject1).thumbUrl;
            localObject3 = f.sJc;
            localObject3 = ((bvf)localObject1).url;
            p.g(localObject3, "it.url");
            localObject5 = ((bvf)localObject1).thumbUrl;
            p.g(localObject5, "it.thumbUrl");
            p.h(localObject3, "videoFilePath");
            p.h(localObject5, "thumbOriginPath");
            localObject4 = com.tencent.mm.plugin.finder.utils.r.sNc;
            localObject4 = com.tencent.mm.plugin.finder.utils.r.ajf((String)localObject3);
            ad.i(f.TAG, "copyVideoThumbFileToPost, videoFilePath:" + (String)localObject3 + ", thumbOriginPath:" + (String)localObject5 + ", thumbPostPath:" + (String)localObject4);
            i locali = i.sJt;
            if (!i.aiP((String)localObject5)) {
              break label1166;
            }
            ad.i(f.TAG, "copyImageThumbFromTmpToPost exist, copy");
            com.tencent.mm.vfs.i.mz((String)localObject5, (String)localObject4);
            if (com.tencent.mm.vfs.i.fv((String)localObject4))
            {
              ((bvf)localObject1).thumbUrl = ((String)localObject4);
              if ((p.i(localObject2, ((bvf)localObject1).thumbUrl) ^ true))
              {
                p.g(localObject2, "preUrl");
                aiO((String)localObject2);
              }
            }
          }
          if (bool1)
          {
            ad.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video");
            localObject2 = new m((bvf)localObject1, com.tencent.mm.plugin.finder.storage.r.syQ, 0, null, 12);
            localObject3 = com.tencent.mm.plugin.finder.utils.r.sNc;
            localObject2 = com.tencent.mm.plugin.finder.utils.r.a((m)localObject2, String.valueOf(this.sIF.getCreateTime()));
            l = com.tencent.mm.vfs.i.mz(((bvf)localObject1).url, (String)localObject2);
            if (!com.tencent.mm.vfs.i.fv((String)localObject2)) {
              break label1262;
            }
            if ((p.i(localObject2, ((bvf)localObject1).url) ^ true))
            {
              localObject3 = ((bvf)localObject1).url;
              p.g(localObject3, "it.url");
              aiO((String)localObject3);
            }
            ((bvf)localObject1).url = ((String)localObject2);
            ((bvf)localObject1).mediaId = ai.ee(((bvf)localObject1).url);
          }
        }
        for (;;)
        {
          if (!bool3) {
            break label1279;
          }
          localObject2 = ((bvf)localObject1).coverUrl;
          p.g(localObject2, "it.coverUrl");
          localObject3 = com.tencent.mm.plugin.finder.utils.r.sNc;
          if (!d.n.n.nz((String)localObject2, com.tencent.mm.plugin.finder.utils.r.cLQ())) {
            break;
          }
          ad.i("Finder.LogPost.FinderPostTask", "moveFileToPost Cover");
          localObject2 = new com.tencent.mm.plugin.finder.loader.n((bvf)localObject1, com.tencent.mm.plugin.finder.storage.r.syD);
          localObject3 = com.tencent.mm.plugin.finder.utils.r.sNc;
          localObject2 = com.tencent.mm.plugin.finder.utils.r.a((com.tencent.mm.plugin.finder.loader.n)localObject2, String.valueOf(this.sIF.getCreateTime()));
          com.tencent.mm.vfs.i.mz(((bvf)localObject1).coverUrl, (String)localObject2);
          ((bvf)localObject1).coverUrl = ((String)localObject2);
          break;
          ad.i(f.TAG, "copyImageThumbFromTmpToPost not exist, generate");
          localObject5 = i.sJt;
          localObject5 = i.du((String)localObject3, 4);
          ad.i(f.TAG, "genVideoThumbFileTmp videoFilePath:" + (String)localObject3 + ", targetWidth:" + ((Point)localObject5).x + ", targetHeight:" + ((Point)localObject5).y);
          f.a((String)localObject3, ((Point)localObject5).x, ((Point)localObject5).y, null, (String)localObject4);
          break label895;
          ad.i("Finder.LogPost.FinderPostTask", "copy Video failed, copyRet:".concat(String.valueOf(l)));
        }
      }
    }
    label1166:
    AppMethodBeat.o(204338);
  }
  
  private final void l(final FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167770);
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramFinderItem));
    AppMethodBeat.o(167770);
  }
  
  public String aeK()
  {
    AppMethodBeat.i(167772);
    String str = "post_" + this.sIF.getLocalId();
    AppMethodBeat.o(167772);
    return str;
  }
  
  public void call()
  {
    AppMethodBeat.i(167774);
    Object localObject1 = this.sIF.getPostInfo();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((((Boolean)com.tencent.mm.plugin.finder.storage.b.cHg().value()).booleanValue()) && (ad.getLogLevel() >= 0))
    {
      ad.i("Finder.LogPost.FinderPostTask", "debug failed");
      aiN("failed for debug");
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      com.tencent.mm.plugin.finder.storage.b.cHg().reset();
      AppMethodBeat.o(167774);
      return;
    }
    if (((bvg)localObject1).hfV > 5) {}
    for (int i = 1; i != 0; i = 0)
    {
      aiN("try to post this feed too many times!");
      AppMethodBeat.o(167774);
      return;
    }
    localObject2 = n.c.sqy;
    n.c.cDO();
    localObject2 = this.sIF;
    Object localObject3 = ((FinderItem)localObject2).getPostInfo();
    ((bvg)localObject3).hfV += 1;
    ((FinderItem)localObject2).setPostInfo((bvg)localObject3);
    localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    b.a.i((FinderItem)localObject2);
    if (((bvg)localObject1).GPx == 1)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
      if (!b.a.xf(this.sIF.getLocalId()))
      {
        ad.i("Finder.LogPost.FinderPostTask", "post before doscene2 cancel because feed is deleted");
        a(com.tencent.mm.loader.g.j.hfM);
        AppMethodBeat.o(167774);
      }
    }
    else
    {
      ad.i("Finder.LogPost.FinderPostTask", "try post need upload task " + this.sIF.getLocalId());
      localObject1 = this.sIF.getFinderObject();
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if ((localObject1 == null) || (this.sIF.getRefObjectFlag() != 0L)) {
          break label475;
        }
        ad.i("Finder.LogPost.FinderPostTask", "moveFileToPost");
        localObject1 = com.tencent.mm.plugin.finder.utils.r.sNc;
        localObject1 = com.tencent.mm.plugin.finder.utils.r.cLQ();
        com.tencent.mm.vfs.i.aYg((String)localObject1);
        if ((sJo) && (ad.getLogLevel() <= 1))
        {
          ad.i("Finder.LogPost.FinderPostTask", "debugDeleteFileWhenMoveFile");
          com.tencent.mm.vfs.i.cZ((String)localObject1, true);
        }
        if ((this.sIF.getMediaExtList().size() != 1) || (((bvf)this.sIF.getMediaExtList().get(0)).GPu == null)) {
          break label400;
        }
        cKM();
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        b.a.i(this.sIF);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        if (b.a.xf(this.sIF.getLocalId())) {
          break label407;
        }
        ad.i("Finder.LogPost.FinderPostTask", "post before mediaprocess cancel because feed is deleted");
        a(com.tencent.mm.loader.g.j.hfM);
        AppMethodBeat.o(167774);
        return;
        localObject1 = null;
        break;
        label400:
        cKN();
      }
      label407:
      localObject1 = g.sJk;
      localObject1 = g.cKK();
      localObject2 = new c(this.sIF);
      localObject3 = (com.tencent.mm.loader.g.f)new c(this);
      p.h(localObject2, "processTask");
      p.h(localObject3, "callback");
      ((g)localObject1).sJf.a((com.tencent.mm.loader.g.c)localObject2, (com.tencent.mm.loader.g.f)localObject3);
      AppMethodBeat.o(167774);
      return;
    }
    label475:
    l(this.sIF);
    AppMethodBeat.o(167774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(167771);
    Object localObject = com.tencent.mm.kernel.g.ajB();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aiU().b(3585, (com.tencent.mm.al.f)this);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(167771);
      throw paramString;
    }
    localObject = ((aw)paramn).clientId;
    ad.i("Finder.LogPost.FinderPostTask", "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.sIF.getPostInfo().clientId))
    {
      ad.w("Finder.LogPost.FinderPostTask", "not my feed!");
      AppMethodBeat.o(167771);
      return;
    }
    this.sIF.trackPost("doPostSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = g.sJk;
      com.tencent.mm.ad.c.g((d.g.a.a)new g.e(g.cKK(), this.sIF.getLocalId(), ((aw)paramn).rJO.id));
      if (this.sIF.getPostInfo().GPA > 0L)
      {
        paramString = n.b.sqe;
        n.b.wD(cf.aCK() - this.sIF.getPostInfo().GPA);
      }
      a(com.tencent.mm.loader.g.j.hfK);
      AppMethodBeat.o(167771);
      return;
    }
    a(com.tencent.mm.loader.g.j.hfM);
    if (this.sIF.isPostFailed())
    {
      paramString = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.k(this.sIF.getLocalId(), paramInt1, paramInt2);
      paramString = g.sJk;
      g.cKK().xk(this.sIF.getLocalId());
    }
    AppMethodBeat.o(167771);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask$Companion;", "", "()V", "TAG", "", "debugDeleteFileWhenMoveFile", "", "getDebugDeleteFileWhenMoveFile", "()Z", "setDebugDeleteFileWhenMoveFile", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(h paramh, FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderPostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<c>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderPostTask$tryPost$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.loader.g.f<k>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.h
 * JD-Core Version:    0.7.0.1
 */