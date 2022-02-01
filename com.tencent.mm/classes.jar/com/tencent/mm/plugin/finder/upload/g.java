package com.tencent.mm.plugin.finder.upload;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.b.k;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "call", "", "checkIfNeedMarkDelete", "preUrl", "", "clearPostFile", "doPostScene", "feedObject", "isToManyTry", "", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "moveFileToPost", "moveFileToPostForNormal", "moveFileToPostForVLog", "notifyError", "errType", "", "errCode", "errMsg", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryPost", "postInfo", "uniqueId", "updateTryCount", "Companion", "plugin-finder_release"})
public class g
  extends com.tencent.mm.loader.g.c
  implements com.tencent.mm.ak.g
{
  private static boolean rNm;
  public static final g.a rNn;
  FinderItem rMD;
  
  static
  {
    AppMethodBeat.i(167777);
    rNn = new g.a((byte)0);
    AppMethodBeat.o(167777);
  }
  
  public g(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167776);
    this.rMD = paramFinderItem;
    AppMethodBeat.o(167776);
  }
  
  private final void aet(String paramString)
  {
    AppMethodBeat.i(167773);
    ac.w("Finder.FinderPostTask", "post failed, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), paramString });
    this.rMD.setPostFailed();
    paramString = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
    b.a.h(this.rMD);
    a(com.tencent.mm.loader.g.h.gLO);
    paramString = f.rNg;
    f.cCv().vi(this.rMD.getLocalId());
    paramString = i.c.ryP;
    i.c.cxe();
    AppMethodBeat.o(167773);
  }
  
  private static void aeu(String paramString)
  {
    AppMethodBeat.i(167775);
    Object localObject = p.rQw;
    if (d.n.n.nb(paramString, p.cDw()))
    {
      localObject = e.rMX;
      e.aes(paramString);
    }
    AppMethodBeat.o(167775);
  }
  
  private final void cCx()
  {
    AppMethodBeat.i(203504);
    Object localObject1 = ((bqs)this.rMD.getMediaExtList().get(0)).FfQ.Esk;
    k.g(localObject1, "compositionInfo.tracks");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (dix)((Iterator)localObject1).next();
      if (i.eA(((dix)localObject2).path))
      {
        localObject3 = ((dix)localObject2).path;
        k.g(localObject3, "it.path");
        Object localObject4 = p.rQw;
        if (!d.n.n.nb((String)localObject3, p.cDw()))
        {
          localObject3 = p.rQw;
          localObject3 = p.aeK(ah.dg(((dix)localObject2).path) + ((dix)localObject2).hashCode());
          i.lZ(((dix)localObject2).path, (String)localObject3);
          ac.i("Finder.FinderPostTask", "copy " + ((dix)localObject2).path + " to " + (String)localObject3 + "  real:" + i.k((String)localObject3, false) + ",result:" + i.eA((String)localObject3));
          if (i.eA((String)localObject3))
          {
            if (((dix)localObject2).AnI == 1)
            {
              localObject4 = com.tencent.mm.plugin.recordvideo.e.b.wDE;
              com.tencent.mm.plugin.recordvideo.e.b.aqP(((dix)localObject2).path);
            }
            ((dix)localObject2).path = ((String)localObject3);
          }
        }
      }
    }
    localObject1 = ((bqs)this.rMD.getMediaExtList().get(0)).thumbUrl;
    if (i.eA((String)localObject1))
    {
      k.g(localObject1, "thumbPath");
      localObject2 = p.rQw;
      if (!d.n.n.nb((String)localObject1, p.cDw()))
      {
        localObject2 = p.rQw;
        localObject2 = p.aeK(ah.dg((String)localObject1) + ((String)localObject1).hashCode());
        i.lZ((String)localObject1, (String)localObject2);
        ac.i("Finder.FinderPostTask", "copy thumb" + (String)localObject1 + " to " + (String)localObject2 + "  real:" + i.k((String)localObject2, false) + ",result:" + i.eA((String)localObject2));
        if (i.eA((String)localObject2))
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.e.b.wDE;
          com.tencent.mm.plugin.recordvideo.e.b.aqP((String)localObject1);
          ((bqs)this.rMD.getMediaExtList().get(0)).thumbUrl = ((String)localObject2);
        }
      }
    }
    AppMethodBeat.o(203504);
  }
  
  private final void cCy()
  {
    AppMethodBeat.i(203505);
    Iterator localIterator = ((Iterable)this.rMD.getMediaList()).iterator();
    int i = 0;
    label683:
    label703:
    label1262:
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        d.a.j.fOc();
      }
      localObject1 = (bqs)localObject1;
      boolean bool1 = i.eA(((bqs)localObject1).url);
      boolean bool2 = i.eA(((bqs)localObject1).thumbUrl);
      boolean bool3 = i.eA(((bqs)localObject1).coverUrl);
      Object localObject2 = ah.dg(((bqs)localObject1).url);
      ac.i("Finder.FinderPostTask", "moveFileToPost, mediaId: " + (String)localObject2 + ", fileExist:" + bool1 + ", thumbExist:" + bool2 + ", before url: " + ((bqs)localObject1).url + ", " + ((bqs)localObject1).thumbUrl + ", " + ((bqs)localObject1).coverUrl);
      if ((bool1) || (bool2)) {
        switch (((bqs)localObject1).mediaType)
        {
        }
      }
      label895:
      label1279:
      for (;;)
      {
        ac.i("Finder.FinderPostTask", "moveFileToPost, after mediaId: " + ((bqs)localObject1).mediaId + ", url: " + ((bqs)localObject1).url + ", " + ((bqs)localObject1).thumbUrl + ", " + ((bqs)localObject1).coverUrl);
        i += 1;
        break;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if ((bool1) && (bool2))
        {
          localObject2 = ((bqs)localObject1).thumbUrl;
          k.g(localObject2, "it.thumbUrl");
          localObject3 = p.rQw;
          if (!d.n.n.nb((String)localObject2, p.cDw()))
          {
            ac.i("Finder.FinderPostTask", "moveFileToPost Image thumb");
            localObject2 = e.rMX;
            localObject2 = ((bqs)localObject1).url;
            k.g(localObject2, "it.url");
            localObject3 = ((bqs)localObject1).thumbUrl;
            k.g(localObject3, "it.thumbUrl");
            k.h(localObject2, "imagePath");
            k.h(localObject3, "thumbOriginPath");
            localObject4 = p.rQw;
            k.h(localObject2, "imagePath");
            localObject4 = p.cDw() + "image_" + ah.dg((String)localObject2) + "_" + i.aSq((String)localObject2) + "_thumb";
            ac.i(e.TAG, "copyImageThumbFromTmpToPost, imagePath:" + (String)localObject2 + ", thumbOriginPath:" + (String)localObject3 + ", thumbPostPath:" + (String)localObject4);
            localObject5 = h.rNr;
            if (!h.aev((String)localObject3)) {
              break label683;
            }
            ac.i(e.TAG, "copyImageThumbFromTmpToPost exist, copy");
            i.lZ((String)localObject3, (String)localObject4);
          }
        }
        long l;
        for (;;)
        {
          if (i.eA((String)localObject4)) {
            ((bqs)localObject1).thumbUrl = ((String)localObject4);
          }
          if (!bool1) {
            break;
          }
          localObject2 = ((bqs)localObject1).url;
          k.g(localObject2, "it.url");
          localObject3 = p.rQw;
          if (d.n.n.nb((String)localObject2, p.cDw())) {
            break;
          }
          ac.i("Finder.FinderPostTask", "moveFileToPost Image");
          localObject2 = new com.tencent.mm.plugin.finder.loader.f((bqs)localObject1, com.tencent.mm.plugin.finder.storage.m.rDQ);
          localObject3 = p.rQw;
          localObject2 = p.a((com.tencent.mm.plugin.finder.loader.f)localObject2, String.valueOf(this.rMD.getCreateTime()));
          l = i.lZ(((bqs)localObject1).url, (String)localObject2);
          if (!i.eA((String)localObject2)) {
            break label703;
          }
          ((bqs)localObject1).url = ((String)localObject2);
          ((bqs)localObject1).mediaId = ah.dg(((bqs)localObject1).url);
          break;
          ac.i(e.TAG, "copyImageThumbFromTmpToPost not exist, generate");
          e.gh((String)localObject2, (String)localObject4);
        }
        ac.i("Finder.FinderPostTask", "copy Image failed, copyRet:".concat(String.valueOf(l)));
        continue;
        if (!this.rMD.isNeedCrop(i))
        {
          if ((bool1) && (bool2))
          {
            ac.i("Finder.FinderPostTask", "moveFileToPost Video thumb");
            localObject2 = ((bqs)localObject1).thumbUrl;
            localObject3 = e.rMX;
            localObject3 = ((bqs)localObject1).url;
            k.g(localObject3, "it.url");
            localObject5 = ((bqs)localObject1).thumbUrl;
            k.g(localObject5, "it.thumbUrl");
            k.h(localObject3, "videoFilePath");
            k.h(localObject5, "thumbOriginPath");
            localObject4 = p.rQw;
            localObject4 = p.aeL((String)localObject3);
            ac.i(e.TAG, "copyVideoThumbFileToPost, videoFilePath:" + (String)localObject3 + ", thumbOriginPath:" + (String)localObject5 + ", thumbPostPath:" + (String)localObject4);
            h localh = h.rNr;
            if (!h.aev((String)localObject5)) {
              break label1166;
            }
            ac.i(e.TAG, "copyImageThumbFromTmpToPost exist, copy");
            i.lZ((String)localObject5, (String)localObject4);
            if (i.eA((String)localObject4))
            {
              ((bqs)localObject1).thumbUrl = ((String)localObject4);
              if ((k.g(localObject2, ((bqs)localObject1).thumbUrl) ^ true))
              {
                k.g(localObject2, "preUrl");
                aeu((String)localObject2);
              }
            }
          }
          if (bool1)
          {
            ac.i("Finder.FinderPostTask", "moveFileToPost Video");
            localObject2 = new com.tencent.mm.plugin.finder.loader.l((bqs)localObject1, com.tencent.mm.plugin.finder.storage.m.rEd, 0, null, 12);
            localObject3 = p.rQw;
            localObject2 = p.a((com.tencent.mm.plugin.finder.loader.l)localObject2, String.valueOf(this.rMD.getCreateTime()));
            l = i.lZ(((bqs)localObject1).url, (String)localObject2);
            if (!i.eA((String)localObject2)) {
              break label1262;
            }
            if ((k.g(localObject2, ((bqs)localObject1).url) ^ true))
            {
              localObject3 = ((bqs)localObject1).url;
              k.g(localObject3, "it.url");
              aeu((String)localObject3);
            }
            ((bqs)localObject1).url = ((String)localObject2);
            ((bqs)localObject1).mediaId = ah.dg(((bqs)localObject1).url);
          }
        }
        for (;;)
        {
          if (!bool3) {
            break label1279;
          }
          localObject2 = ((bqs)localObject1).coverUrl;
          k.g(localObject2, "it.coverUrl");
          localObject3 = p.rQw;
          if (!d.n.n.nb((String)localObject2, p.cDw())) {
            break;
          }
          ac.i("Finder.FinderPostTask", "moveFileToPost Cover");
          localObject2 = new com.tencent.mm.plugin.finder.loader.m((bqs)localObject1, com.tencent.mm.plugin.finder.storage.m.rDQ);
          localObject3 = p.rQw;
          localObject2 = p.a((com.tencent.mm.plugin.finder.loader.m)localObject2, String.valueOf(this.rMD.getCreateTime()));
          i.lZ(((bqs)localObject1).coverUrl, (String)localObject2);
          ((bqs)localObject1).coverUrl = ((String)localObject2);
          break;
          ac.i(e.TAG, "copyImageThumbFromTmpToPost not exist, generate");
          localObject5 = h.rNr;
          localObject5 = h.de((String)localObject3, 4);
          ac.i(e.TAG, "genVideoThumbFileTmp videoFilePath:" + (String)localObject3 + ", targetWidth:" + ((Point)localObject5).x + ", targetHeight:" + ((Point)localObject5).y);
          e.a((String)localObject3, ((Point)localObject5).x, ((Point)localObject5).y, null, (String)localObject4);
          break label895;
          ac.i("Finder.FinderPostTask", "copy Video failed, copyRet:".concat(String.valueOf(l)));
        }
      }
    }
    label1166:
    AppMethodBeat.o(203505);
  }
  
  private final void k(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167770);
    com.tencent.mm.ac.c.g((a)new g.b(this, paramFinderItem));
    AppMethodBeat.o(167770);
  }
  
  public String acg()
  {
    AppMethodBeat.i(167772);
    String str = "post_" + this.rMD.getLocalId();
    AppMethodBeat.o(167772);
    return str;
  }
  
  public void call()
  {
    AppMethodBeat.i(167774);
    Object localObject1 = this.rMD.getPostInfo();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if ((com.tencent.mm.plugin.finder.storage.b.cyu()) && (ac.getLogLevel() >= 0))
    {
      ac.i("Finder.FinderPostTask", "debug failed");
      aet("failed for debug");
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
      com.tencent.mm.plugin.finder.storage.b.lH(false);
      AppMethodBeat.o(167774);
      return;
    }
    if (((bqt)localObject1).gLY > 5) {}
    for (int i = 1; i != 0; i = 0)
    {
      aet("try to post this feed too many times!");
      AppMethodBeat.o(167774);
      return;
    }
    localObject2 = i.c.ryP;
    i.c.cxf();
    localObject2 = this.rMD;
    Object localObject3 = ((FinderItem)localObject2).getPostInfo();
    ((bqt)localObject3).gLY += 1;
    ((FinderItem)localObject2).setPostInfo((bqt)localObject3);
    localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
    b.a.h((FinderItem)localObject2);
    if (((bqt)localObject1).FfT != 1)
    {
      ac.d("Finder.FinderPostTask", "try post need upload task " + this.rMD.getLocalId());
      localObject1 = this.rMD.getFinderObject();
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if ((localObject1 == null) || (this.rMD.getRefObjectFlag() != 0L)) {
          break label386;
        }
        ac.i("Finder.FinderPostTask", "moveFileToPost");
        localObject1 = p.rQw;
        localObject1 = p.cDw();
        i.aSh((String)localObject1);
        if ((rNm) && (ac.getLogLevel() <= 1))
        {
          ac.i("Finder.FinderPostTask", "debugDeleteFileWhenMoveFile");
          i.cU((String)localObject1, true);
        }
        if ((this.rMD.getMediaExtList().size() != 1) || (((bqs)this.rMD.getMediaExtList().get(0)).FfQ == null)) {
          break label379;
        }
        cCx();
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        b.a.h(this.rMD);
        localObject1 = f.rNg;
        localObject1 = f.cCv();
        localObject2 = new c(this.rMD);
        localObject3 = (com.tencent.mm.loader.g.f)new c(this);
        k.h(localObject2, "processTask");
        k.h(localObject3, "callback");
        ((f)localObject1).rNb.a((com.tencent.mm.loader.g.c)localObject2, (com.tencent.mm.loader.g.f)localObject3);
        AppMethodBeat.o(167774);
        return;
        localObject1 = null;
        break;
        label379:
        cCy();
      }
    }
    label386:
    k(this.rMD);
    AppMethodBeat.o(167774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(167771);
    Object localObject = com.tencent.mm.kernel.g.agQ();
    k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).agi().b(3585, (com.tencent.mm.ak.g)this);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(167771);
      throw paramString;
    }
    localObject = ((ap)paramn).clientId;
    ac.i("Finder.FinderPostTask", "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.rMD.getPostInfo().clientId))
    {
      ac.w("Finder.FinderPostTask", "not my feed!");
      AppMethodBeat.o(167771);
      return;
    }
    this.rMD.trackPost("doPostSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = f.rNg;
      com.tencent.mm.ac.c.g((a)new f.e(f.cCv(), this.rMD.getLocalId(), ((ap)paramn).qYy.id));
      if (this.rMD.getPostInfo().FfX > 0L)
      {
        paramString = i.b.ryD;
        i.b.uC(ce.azH() - this.rMD.getPostInfo().FfX);
      }
      a(com.tencent.mm.loader.g.h.gLN);
      AppMethodBeat.o(167771);
      return;
    }
    a(com.tencent.mm.loader.g.h.gLP);
    if (this.rMD.isPostFailed())
    {
      paramString = f.rNg;
      f.cCv().vi(this.rMD.getLocalId());
    }
    AppMethodBeat.o(167771);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/upload/FinderPostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<c>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/upload/FinderPostTask$tryPost$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.loader.g.f<j>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.g
 * JD-Core Version:    0.7.0.1
 */