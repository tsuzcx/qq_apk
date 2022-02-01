package com.tencent.mm.plugin.finder.upload;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.o.b;
import com.tencent.mm.plugin.finder.report.o.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "call", "", "checkIfNeedMarkDelete", "preUrl", "", "clearPostFile", "doPostScene", "feedObject", "isToManyTry", "", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "moveFileToPost", "moveFileToPostForNormal", "moveFileToPostForVLog", "notifyError", "errType", "", "errCode", "errMsg", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryPost", "postInfo", "uniqueId", "updateTryCount", "Companion", "plugin-finder_release"})
public class h
  extends com.tencent.mm.loader.g.c
  implements com.tencent.mm.ak.f
{
  private static boolean sUB;
  public static final a sUC;
  FinderItem sTR;
  
  static
  {
    AppMethodBeat.i(167777);
    sUC = new a((byte)0);
    AppMethodBeat.o(167777);
  }
  
  public h(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167776);
    this.sTR = paramFinderItem;
    AppMethodBeat.o(167776);
  }
  
  private final void ajK(String paramString)
  {
    AppMethodBeat.i(167773);
    ae.w("Finder.LogPost.FinderPostTask", "post failed, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), paramString });
    this.sTR.setPostFailed();
    paramString = this.sTR.field_reportObject;
    if (paramString != null) {
      paramString.cgiErrorType = -1;
    }
    paramString = this.sTR.field_reportObject;
    if (paramString != null) {
      paramString.cgiErrorCode = -1;
    }
    paramString = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
    b.a.i(this.sTR);
    a(com.tencent.mm.loader.g.j.hiz);
    paramString = g.sUx;
    g.cNo().xB(this.sTR.getLocalId());
    paramString = o.c.sAI;
    o.c.cFJ();
    AppMethodBeat.o(167773);
  }
  
  private static void ajL(String paramString)
  {
    AppMethodBeat.i(167775);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sYn;
    if (d.n.n.nF(paramString, com.tencent.mm.plugin.finder.utils.r.cOy()))
    {
      localObject = f.sUp;
      f.ajJ(paramString);
    }
    AppMethodBeat.o(167775);
  }
  
  private final void cNq()
  {
    AppMethodBeat.i(204955);
    Object localObject1 = ((bvz)this.sTR.getMediaExtList().get(0)).HiW;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((aaq)localObject1).GrU;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dpj)((Iterator)localObject1).next();
          if (o.fB(((dpj)localObject2).path))
          {
            localObject3 = ((dpj)localObject2).path;
            p.g(localObject3, "it.path");
            Object localObject4 = com.tencent.mm.plugin.finder.utils.r.sYn;
            if (!d.n.n.nF((String)localObject3, com.tencent.mm.plugin.finder.utils.r.cOy()))
            {
              localObject3 = com.tencent.mm.plugin.finder.utils.r.sYn;
              localObject3 = com.tencent.mm.plugin.finder.utils.r.akb(aj.ej(((dpj)localObject2).path) + ((dpj)localObject2).hashCode());
              o.mF(((dpj)localObject2).path, (String)localObject3);
              ae.i("Finder.LogPost.FinderPostTask", "copy " + ((dpj)localObject2).path + " to " + (String)localObject3 + "  real:" + o.k((String)localObject3, false) + ",result:" + o.fB((String)localObject3));
              if (o.fB((String)localObject3))
              {
                if (((dpj)localObject2).BXz == 1)
                {
                  localObject4 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
                  com.tencent.mm.plugin.recordvideo.e.b.axe(((dpj)localObject2).path);
                }
                ((dpj)localObject2).path = ((String)localObject3);
              }
            }
          }
        }
      }
    }
    localObject1 = ((bvz)this.sTR.getMediaExtList().get(0)).thumbUrl;
    if ((o.fB((String)localObject1)) && (localObject1 != null))
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
      if (!d.n.n.nF((String)localObject1, com.tencent.mm.plugin.finder.utils.r.cOy()))
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
        localObject2 = com.tencent.mm.plugin.finder.utils.r.akb(aj.ej((String)localObject1) + ((String)localObject1).hashCode());
        o.mF((String)localObject1, (String)localObject2);
        ae.i("Finder.LogPost.FinderPostTask", "copy thumb" + (String)localObject1 + " to " + (String)localObject2 + "  real:" + o.k((String)localObject2, false) + ",result:" + o.fB((String)localObject2));
        if (o.fB((String)localObject2))
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
          com.tencent.mm.plugin.recordvideo.e.b.axe((String)localObject1);
          ((bvz)this.sTR.getMediaExtList().get(0)).thumbUrl = ((String)localObject2);
        }
      }
    }
    AppMethodBeat.o(204955);
  }
  
  private final void cNr()
  {
    AppMethodBeat.i(204956);
    Iterator localIterator = ((Iterable)this.sTR.getMediaList()).iterator();
    int i = 0;
    label937:
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        d.a.j.gkd();
      }
      bvz localbvz = (bvz)localObject1;
      boolean bool1 = o.fB(localbvz.url);
      boolean bool2 = o.fB(localbvz.thumbUrl);
      boolean bool3 = o.fB(localbvz.coverUrl);
      localObject1 = aj.ej(localbvz.url);
      ae.i("Finder.LogPost.FinderPostTask", "moveFileToPost, mediaId: " + (String)localObject1 + ", fileExist:" + bool1 + ", thumbExist:" + bool2 + ", before url: " + localbvz.url + ", " + localbvz.thumbUrl + ", " + localbvz.coverUrl);
      if ((bool1) || (bool2)) {
        switch (localbvz.mediaType)
        {
        }
      }
      label691:
      label1335:
      for (;;)
      {
        ae.i("Finder.LogPost.FinderPostTask", "moveFileToPost, after mediaId: " + localbvz.mediaId + ", url: " + localbvz.url + ", " + localbvz.thumbUrl + ", " + localbvz.coverUrl);
        i += 1;
        break;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if ((bool1) && (bool2))
        {
          localObject1 = localbvz.thumbUrl;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
            if (d.n.n.nF((String)localObject1, com.tencent.mm.plugin.finder.utils.r.cOy()) == true) {}
          }
          else
          {
            ae.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image thumb");
            localObject1 = f.sUp;
            localObject2 = localbvz.url;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject3 = localbvz.thumbUrl;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            p.h(localObject1, "imagePath");
            p.h(localObject2, "thumbOriginPath");
            localObject3 = com.tencent.mm.plugin.finder.utils.r.sYn;
            p.h(localObject1, "imagePath");
            localObject3 = com.tencent.mm.plugin.finder.utils.r.cOy() + "image_" + aj.ej((String)localObject1) + "_" + o.aZS((String)localObject1) + "_thumb";
            ae.i(f.TAG, "copyImageThumbFromTmpToPost, imagePath:" + (String)localObject1 + ", thumbOriginPath:" + (String)localObject2 + ", thumbPostPath:" + (String)localObject3);
            localObject4 = i.sUG;
            if (!i.ajM((String)localObject2)) {
              break label691;
            }
            ae.i(f.TAG, "copyImageThumbFromTmpToPost exist, copy");
            o.mF((String)localObject2, (String)localObject3);
          }
        }
        long l;
        for (;;)
        {
          if (o.fB((String)localObject3)) {
            localbvz.thumbUrl = ((String)localObject3);
          }
          if (!bool1) {
            break;
          }
          localObject1 = localbvz.url;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
            if (d.n.n.nF((String)localObject1, com.tencent.mm.plugin.finder.utils.r.cOy()) == true) {
              break;
            }
          }
          ae.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image");
          localObject1 = new com.tencent.mm.plugin.finder.loader.g(localbvz, com.tencent.mm.plugin.finder.storage.r.sJu);
          localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
          localObject1 = com.tencent.mm.plugin.finder.utils.r.a((com.tencent.mm.plugin.finder.loader.g)localObject1, String.valueOf(this.sTR.getCreateTime()));
          l = o.mF(localbvz.url, (String)localObject1);
          if (!o.fB((String)localObject1)) {
            break label711;
          }
          localbvz.url = ((String)localObject1);
          localbvz.mediaId = aj.ej(localbvz.url);
          break;
          ae.i(f.TAG, "copyImageThumbFromTmpToPost not exist, generate");
          f.gx((String)localObject1, (String)localObject3);
        }
        label711:
        ae.i("Finder.LogPost.FinderPostTask", "copy Image failed, copyRet:".concat(String.valueOf(l)));
        continue;
        if (!this.sTR.isNeedCrop(i))
        {
          if ((bool1) && (bool2))
          {
            ae.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video thumb");
            localObject2 = localbvz.thumbUrl;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            p.g(localObject1, "it.thumbUrl ?: \"\"");
            localObject2 = f.sUp;
            localObject3 = localbvz.url;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject4 = localbvz.thumbUrl;
            localObject3 = localObject4;
            if (localObject4 == null) {
              localObject3 = "";
            }
            p.h(localObject2, "videoFilePath");
            p.h(localObject3, "thumbOriginPath");
            localObject4 = com.tencent.mm.plugin.finder.utils.r.sYn;
            localObject4 = com.tencent.mm.plugin.finder.utils.r.akc((String)localObject2);
            ae.i(f.TAG, "copyVideoThumbFileToPost, videoFilePath:" + (String)localObject2 + ", thumbOriginPath:" + (String)localObject3 + ", thumbPostPath:" + (String)localObject4);
            i locali = i.sUG;
            if (!i.ajM((String)localObject3)) {
              break label1222;
            }
            ae.i(f.TAG, "copyImageThumbFromTmpToPost exist, copy");
            o.mF((String)localObject3, (String)localObject4);
            if (o.fB((String)localObject4))
            {
              localbvz.thumbUrl = ((String)localObject4);
              if ((p.i(localObject1, localbvz.thumbUrl) ^ true)) {
                ajL((String)localObject1);
              }
            }
          }
          if (bool1)
          {
            ae.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video");
            localObject1 = new m(localbvz, com.tencent.mm.plugin.finder.storage.r.sJH, 0, null, 12);
            localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
            localObject3 = com.tencent.mm.plugin.finder.utils.r.a((m)localObject1, String.valueOf(this.sTR.getCreateTime()));
            l = o.mF(localbvz.url, (String)localObject3);
            if (!o.fB((String)localObject3)) {
              break label1318;
            }
            if ((p.i(localObject3, localbvz.url) ^ true))
            {
              localObject2 = localbvz.url;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              ajL((String)localObject1);
            }
            localbvz.url = ((String)localObject3);
            localObject2 = localbvz.url;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localbvz.mediaId = aj.ej((String)localObject1);
          }
        }
        for (;;)
        {
          if (!bool3) {
            break label1335;
          }
          localObject1 = localbvz.coverUrl;
          if (localObject1 == null) {
            break;
          }
          localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
          if (d.n.n.nF((String)localObject1, com.tencent.mm.plugin.finder.utils.r.cOy()) != true) {
            break;
          }
          ae.i("Finder.LogPost.FinderPostTask", "moveFileToPost Cover");
          localObject1 = new com.tencent.mm.plugin.finder.loader.n(localbvz, com.tencent.mm.plugin.finder.storage.r.sJu);
          localObject2 = com.tencent.mm.plugin.finder.utils.r.sYn;
          localObject1 = com.tencent.mm.plugin.finder.utils.r.a((com.tencent.mm.plugin.finder.loader.n)localObject1, String.valueOf(this.sTR.getCreateTime()));
          o.mF(localbvz.coverUrl, (String)localObject1);
          localbvz.coverUrl = ((String)localObject1);
          break;
          label1222:
          ae.i(f.TAG, "copyImageThumbFromTmpToPost not exist, generate");
          localObject3 = i.sUG;
          localObject3 = i.dz((String)localObject2, 4);
          ae.i(f.TAG, "genVideoThumbFileTmp videoFilePath:" + (String)localObject2 + ", targetWidth:" + ((Point)localObject3).x + ", targetHeight:" + ((Point)localObject3).y);
          f.a((String)localObject2, ((Point)localObject3).x, ((Point)localObject3).y, null, (String)localObject4);
          break label937;
          ae.i("Finder.LogPost.FinderPostTask", "copy Video failed, copyRet:".concat(String.valueOf(l)));
        }
      }
    }
    label1318:
    AppMethodBeat.o(204956);
  }
  
  private final void l(final FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167770);
    com.tencent.mm.ac.c.h((d.g.a.a)new b(this, paramFinderItem));
    AppMethodBeat.o(167770);
  }
  
  public String aeW()
  {
    AppMethodBeat.i(167772);
    String str = "post_" + this.sTR.getLocalId();
    AppMethodBeat.o(167772);
    return str;
  }
  
  public void call()
  {
    AppMethodBeat.i(167774);
    Object localObject1 = this.sTR.getPostInfo();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((((Boolean)com.tencent.mm.plugin.finder.storage.b.cJf().value()).booleanValue()) && (ae.getLogLevel() >= 0))
    {
      ae.i("Finder.LogPost.FinderPostTask", "debug failed");
      ajK("failed for debug");
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      com.tencent.mm.plugin.finder.storage.b.cJf().reset();
      AppMethodBeat.o(167774);
      return;
    }
    if (((bwa)localObject1).hiJ > 5) {}
    for (int i = 1; i != 0; i = 0)
    {
      ajK("try to post this feed too many times!");
      AppMethodBeat.o(167774);
      return;
    }
    localObject2 = o.c.sAI;
    o.c.cFK();
    localObject2 = this.sTR;
    Object localObject3 = ((FinderItem)localObject2).getPostInfo();
    ((bwa)localObject3).hiJ += 1;
    ((FinderItem)localObject2).setPostInfo((bwa)localObject3);
    localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
    b.a.i((FinderItem)localObject2);
    if (((bwa)localObject1).HiZ == 1)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      if (!b.a.xw(this.sTR.getLocalId()))
      {
        ae.i("Finder.LogPost.FinderPostTask", "post before doscene2 cancel because feed is deleted");
        a(com.tencent.mm.loader.g.j.hiA);
        AppMethodBeat.o(167774);
      }
    }
    else
    {
      ae.i("Finder.LogPost.FinderPostTask", "try post need upload task " + this.sTR.getLocalId());
      localObject1 = this.sTR.getFinderObject();
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if ((localObject1 == null) || (this.sTR.getRefObjectFlag() != 0L)) {
          break label475;
        }
        ae.i("Finder.LogPost.FinderPostTask", "moveFileToPost");
        localObject1 = com.tencent.mm.plugin.finder.utils.r.sYn;
        localObject1 = com.tencent.mm.plugin.finder.utils.r.cOy();
        o.aZI((String)localObject1);
        if ((sUB) && (ae.getLogLevel() <= 1))
        {
          ae.i("Finder.LogPost.FinderPostTask", "debugDeleteFileWhenMoveFile");
          o.dd((String)localObject1, true);
        }
        if ((this.sTR.getMediaExtList().size() != 1) || (((bvz)this.sTR.getMediaExtList().get(0)).HiW == null)) {
          break label400;
        }
        cNq();
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        b.a.i(this.sTR);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        if (b.a.xw(this.sTR.getLocalId())) {
          break label407;
        }
        ae.i("Finder.LogPost.FinderPostTask", "post before mediaprocess cancel because feed is deleted");
        a(com.tencent.mm.loader.g.j.hiA);
        AppMethodBeat.o(167774);
        return;
        localObject1 = null;
        break;
        label400:
        cNr();
      }
      label407:
      localObject1 = g.sUx;
      localObject1 = g.cNo();
      localObject2 = new c(this.sTR);
      localObject3 = (com.tencent.mm.loader.g.f)new c(this);
      p.h(localObject2, "processTask");
      p.h(localObject3, "callback");
      ((g)localObject1).sUs.a((com.tencent.mm.loader.g.c)localObject2, (com.tencent.mm.loader.g.f)localObject3);
      AppMethodBeat.o(167774);
      return;
    }
    label475:
    l(this.sTR);
    AppMethodBeat.o(167774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(167771);
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).ajj().b(3585, (com.tencent.mm.ak.f)this);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(167771);
      throw paramString;
    }
    localObject = ((ax)paramn).clientId;
    ae.i("Finder.LogPost.FinderPostTask", "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.sTR.getPostInfo().clientId))
    {
      ae.w("Finder.LogPost.FinderPostTask", "not my feed!");
      AppMethodBeat.o(167771);
      return;
    }
    this.sTR.trackPost("doPostSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = g.sUx;
      com.tencent.mm.ac.c.h((d.g.a.a)new g.e(g.cNo(), this.sTR.getLocalId(), ((ax)paramn).rSc.id));
      if (this.sTR.getPostInfo().Hjc > 0L)
      {
        paramString = o.b.sAp;
        o.b.wU(ch.aDa() - this.sTR.getPostInfo().Hjc);
      }
      a(com.tencent.mm.loader.g.j.hiy);
      AppMethodBeat.o(167771);
      return;
    }
    a(com.tencent.mm.loader.g.j.hiA);
    if (this.sTR.isPostFailed())
    {
      paramString = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.k(this.sTR.getLocalId(), paramInt1, paramInt2);
      paramString = g.sUx;
      g.cNo().xB(this.sTR.getLocalId());
    }
    AppMethodBeat.o(167771);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask$Companion;", "", "()V", "TAG", "", "debugDeleteFileWhenMoveFile", "", "getDebugDeleteFileWhenMoveFile", "()Z", "setDebugDeleteFileWhenMoveFile", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(h paramh, FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderPostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<c>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderPostTask$tryPost$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.loader.g.f<k>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.h
 * JD-Core Version:    0.7.0.1
 */