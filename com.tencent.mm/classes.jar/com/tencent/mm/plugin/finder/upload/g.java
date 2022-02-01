package com.tencent.mm.plugin.finder.upload;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.report.e.b;
import com.tencent.mm.plugin.finder.report.e.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.v;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "call", "", "checkIfNeedMarkDelete", "preUrl", "", "clearPostFile", "doPostScene", "feedObject", "isToManyTry", "", "postinfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "moveFileToPost", "moveFileToPostForNormal", "moveFileToPostForVLog", "notifyError", "errType", "", "errCode", "errMsg", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "tryPost", "postInfo", "uniqueId", "updateTryCount", "Companion", "plugin-finder_release"})
public class g
  extends com.tencent.mm.loader.g.c
  implements com.tencent.mm.al.g
{
  private static boolean qRl;
  public static final a qRm;
  FinderItem qQF;
  
  static
  {
    AppMethodBeat.i(167777);
    qRm = new a((byte)0);
    AppMethodBeat.o(167777);
  }
  
  public g(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167776);
    this.qQF = paramFinderItem;
    AppMethodBeat.o(167776);
  }
  
  private final void ZH(String paramString)
  {
    AppMethodBeat.i(167773);
    ad.w("Finder.FinderPostTask", "post failed, errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), paramString });
    this.qQF.setPostFailed();
    paramString = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    b.a.g(this.qQF);
    a(com.tencent.mm.loader.g.h.glb);
    paramString = f.qRf;
    f.crB().qL(this.qQF.getLocalId());
    paramString = e.c.qFV;
    e.c.cnI();
    AppMethodBeat.o(167773);
  }
  
  private static void ZI(String paramString)
  {
    AppMethodBeat.i(167775);
    Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
    if (d.n.n.mA(paramString, com.tencent.mm.plugin.finder.utils.k.csd()))
    {
      localObject = e.qQW;
      e.ZG(paramString);
    }
    AppMethodBeat.o(167775);
  }
  
  private final void fVJ()
  {
    AppMethodBeat.i(199528);
    Object localObject1 = ((bmd)this.qQF.getMediaExtList().get(0)).LzL.LwS;
    d.g.b.k.g(localObject1, "compositionInfo.tracks");
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ebw)((Iterator)localObject1).next();
      if (i.eK(((ebw)localObject2).path))
      {
        localObject3 = ((ebw)localObject2).path;
        d.g.b.k.g(localObject3, "it.path");
        Object localObject4 = com.tencent.mm.plugin.finder.utils.k.qTp;
        if (!d.n.n.mA((String)localObject3, com.tencent.mm.plugin.finder.utils.k.csd()))
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.k.qTp;
          localObject3 = com.tencent.mm.plugin.finder.utils.k.aVH(ai.du(((ebw)localObject2).path) + ((ebw)localObject2).hashCode());
          i.lC(((ebw)localObject2).path, (String)localObject3);
          ad.i("Finder.FinderPostTask", "copy " + ((ebw)localObject2).path + " to " + (String)localObject3 + "  real:" + i.k((String)localObject3, false) + ",result:" + i.eK((String)localObject3));
          if (i.eK((String)localObject3))
          {
            if (((ebw)localObject2).LqD == 1)
            {
              localObject4 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
              com.tencent.mm.plugin.recordvideo.e.b.aVM(((ebw)localObject2).path);
            }
            ((ebw)localObject2).path = ((String)localObject3);
          }
        }
      }
    }
    localObject1 = ((bmd)this.qQF.getMediaExtList().get(0)).thumbUrl;
    if (i.eK((String)localObject1))
    {
      d.g.b.k.g(localObject1, "thumbPath");
      localObject2 = com.tencent.mm.plugin.finder.utils.k.qTp;
      if (!d.n.n.mA((String)localObject1, com.tencent.mm.plugin.finder.utils.k.csd()))
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.k.qTp;
        localObject2 = com.tencent.mm.plugin.finder.utils.k.aVH(ai.du((String)localObject1) + ((String)localObject1).hashCode());
        i.lC((String)localObject1, (String)localObject2);
        ad.i("Finder.FinderPostTask", "copy thumb" + (String)localObject1 + " to " + (String)localObject2 + "  real:" + i.k((String)localObject2, false) + ",result:" + i.eK((String)localObject2));
        if (i.eK((String)localObject2))
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
          com.tencent.mm.plugin.recordvideo.e.b.aVM((String)localObject1);
          ((bmd)this.qQF.getMediaExtList().get(0)).thumbUrl = ((String)localObject2);
        }
      }
    }
    AppMethodBeat.o(199528);
  }
  
  private final void fVK()
  {
    AppMethodBeat.i(199529);
    Iterator localIterator = ((Iterable)this.qQF.getMediaList()).iterator();
    int i = 0;
    label683:
    label703:
    label1262:
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        d.a.j.fvx();
      }
      localObject1 = (bmd)localObject1;
      boolean bool1 = i.eK(((bmd)localObject1).url);
      boolean bool2 = i.eK(((bmd)localObject1).thumbUrl);
      boolean bool3 = i.eK(((bmd)localObject1).coverUrl);
      Object localObject2 = ai.du(((bmd)localObject1).url);
      ad.i("Finder.FinderPostTask", "moveFileToPost, mediaId: " + (String)localObject2 + ", fileExist:" + bool1 + ", thumbExist:" + bool2 + ", before url: " + ((bmd)localObject1).url + ", " + ((bmd)localObject1).thumbUrl + ", " + ((bmd)localObject1).coverUrl);
      if ((bool1) || (bool2)) {
        switch (((bmd)localObject1).mediaType)
        {
        }
      }
      label895:
      label1279:
      for (;;)
      {
        ad.i("Finder.FinderPostTask", "moveFileToPost, after mediaId: " + ((bmd)localObject1).mediaId + ", url: " + ((bmd)localObject1).url + ", " + ((bmd)localObject1).thumbUrl + ", " + ((bmd)localObject1).coverUrl);
        i += 1;
        break;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if ((bool1) && (bool2))
        {
          localObject2 = ((bmd)localObject1).thumbUrl;
          d.g.b.k.g(localObject2, "it.thumbUrl");
          localObject3 = com.tencent.mm.plugin.finder.utils.k.qTp;
          if (!d.n.n.mA((String)localObject2, com.tencent.mm.plugin.finder.utils.k.csd()))
          {
            ad.i("Finder.FinderPostTask", "moveFileToPost Image thumb");
            localObject2 = e.qQW;
            localObject2 = ((bmd)localObject1).url;
            d.g.b.k.g(localObject2, "it.url");
            localObject3 = ((bmd)localObject1).thumbUrl;
            d.g.b.k.g(localObject3, "it.thumbUrl");
            d.g.b.k.h(localObject2, "imagePath");
            d.g.b.k.h(localObject3, "thumbOriginPath");
            localObject4 = com.tencent.mm.plugin.finder.utils.k.qTp;
            d.g.b.k.h(localObject2, "imagePath");
            localObject4 = com.tencent.mm.plugin.finder.utils.k.csd() + "image_" + ai.du((String)localObject2) + "_" + i.aMO((String)localObject2) + "_thumb";
            ad.i(e.TAG, "copyImageThumbFromTmpToPost, imagePath:" + (String)localObject2 + ", thumbOriginPath:" + (String)localObject3 + ", thumbPostPath:" + (String)localObject4);
            localObject5 = h.qRq;
            if (!h.ZJ((String)localObject3)) {
              break label683;
            }
            ad.i(e.TAG, "copyImageThumbFromTmpToPost exist, copy");
            i.lC((String)localObject3, (String)localObject4);
          }
        }
        long l;
        for (;;)
        {
          if (i.eK((String)localObject4)) {
            ((bmd)localObject1).thumbUrl = ((String)localObject4);
          }
          if (!bool1) {
            break;
          }
          localObject2 = ((bmd)localObject1).url;
          d.g.b.k.g(localObject2, "it.url");
          localObject3 = com.tencent.mm.plugin.finder.utils.k.qTp;
          if (d.n.n.mA((String)localObject2, com.tencent.mm.plugin.finder.utils.k.csd())) {
            break;
          }
          ad.i("Finder.FinderPostTask", "moveFileToPost Image");
          localObject2 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject1, com.tencent.mm.plugin.finder.storage.h.qJY);
          localObject3 = com.tencent.mm.plugin.finder.utils.k.qTp;
          localObject2 = com.tencent.mm.plugin.finder.utils.k.a((com.tencent.mm.plugin.finder.loader.f)localObject2, String.valueOf(this.qQF.getCreateTime()));
          l = i.lC(((bmd)localObject1).url, (String)localObject2);
          if (!i.eK((String)localObject2)) {
            break label703;
          }
          ((bmd)localObject1).url = ((String)localObject2);
          ((bmd)localObject1).mediaId = ai.du(((bmd)localObject1).url);
          break;
          ad.i(e.TAG, "copyImageThumbFromTmpToPost not exist, generate");
          e.mC((String)localObject2, (String)localObject4);
        }
        ad.i("Finder.FinderPostTask", "copy Image failed, copyRet:".concat(String.valueOf(l)));
        continue;
        if (!this.qQF.isNeedCrop(i))
        {
          if ((bool1) && (bool2))
          {
            ad.i("Finder.FinderPostTask", "moveFileToPost Video thumb");
            localObject2 = ((bmd)localObject1).thumbUrl;
            localObject3 = e.qQW;
            localObject3 = ((bmd)localObject1).url;
            d.g.b.k.g(localObject3, "it.url");
            localObject5 = ((bmd)localObject1).thumbUrl;
            d.g.b.k.g(localObject5, "it.thumbUrl");
            d.g.b.k.h(localObject3, "videoFilePath");
            d.g.b.k.h(localObject5, "thumbOriginPath");
            localObject4 = com.tencent.mm.plugin.finder.utils.k.qTp;
            localObject4 = com.tencent.mm.plugin.finder.utils.k.ZY((String)localObject3);
            ad.i(e.TAG, "copyVideoThumbFileToPost, videoFilePath:" + (String)localObject3 + ", thumbOriginPath:" + (String)localObject5 + ", thumbPostPath:" + (String)localObject4);
            h localh = h.qRq;
            if (!h.ZJ((String)localObject5)) {
              break label1166;
            }
            ad.i(e.TAG, "copyImageThumbFromTmpToPost exist, copy");
            i.lC((String)localObject5, (String)localObject4);
            if (i.eK((String)localObject4))
            {
              ((bmd)localObject1).thumbUrl = ((String)localObject4);
              if ((d.g.b.k.g(localObject2, ((bmd)localObject1).thumbUrl) ^ true))
              {
                d.g.b.k.g(localObject2, "preUrl");
                ZI((String)localObject2);
              }
            }
          }
          if (bool1)
          {
            ad.i("Finder.FinderPostTask", "moveFileToPost Video");
            localObject2 = new com.tencent.mm.plugin.finder.loader.l((bmd)localObject1, com.tencent.mm.plugin.finder.storage.h.KXa, 0, null, 12);
            localObject3 = com.tencent.mm.plugin.finder.utils.k.qTp;
            localObject2 = com.tencent.mm.plugin.finder.utils.k.a((com.tencent.mm.plugin.finder.loader.l)localObject2, String.valueOf(this.qQF.getCreateTime()));
            l = i.lC(((bmd)localObject1).url, (String)localObject2);
            if (!i.eK((String)localObject2)) {
              break label1262;
            }
            if ((d.g.b.k.g(localObject2, ((bmd)localObject1).url) ^ true))
            {
              localObject3 = ((bmd)localObject1).url;
              d.g.b.k.g(localObject3, "it.url");
              ZI((String)localObject3);
            }
            ((bmd)localObject1).url = ((String)localObject2);
            ((bmd)localObject1).mediaId = ai.du(((bmd)localObject1).url);
          }
        }
        for (;;)
        {
          if (!bool3) {
            break label1279;
          }
          localObject2 = ((bmd)localObject1).coverUrl;
          d.g.b.k.g(localObject2, "it.coverUrl");
          localObject3 = com.tencent.mm.plugin.finder.utils.k.qTp;
          if (!d.n.n.mA((String)localObject2, com.tencent.mm.plugin.finder.utils.k.csd())) {
            break;
          }
          ad.i("Finder.FinderPostTask", "moveFileToPost Cover");
          localObject2 = new com.tencent.mm.plugin.finder.loader.n((bmd)localObject1, com.tencent.mm.plugin.finder.storage.h.qJY);
          localObject3 = com.tencent.mm.plugin.finder.utils.k.qTp;
          localObject2 = com.tencent.mm.plugin.finder.utils.k.a((com.tencent.mm.plugin.finder.loader.n)localObject2, String.valueOf(this.qQF.getCreateTime()));
          i.lC(((bmd)localObject1).coverUrl, (String)localObject2);
          ((bmd)localObject1).coverUrl = ((String)localObject2);
          break;
          ad.i(e.TAG, "copyImageThumbFromTmpToPost not exist, generate");
          localObject5 = h.qRq;
          localObject5 = h.cY((String)localObject3, 4);
          ad.i(e.TAG, "genVideoThumbFileTmp videoFilePath:" + (String)localObject3 + ", targetWidth:" + ((Point)localObject5).x + ", targetHeight:" + ((Point)localObject5).y);
          e.a((String)localObject3, ((Point)localObject5).x, ((Point)localObject5).y, null, (String)localObject4);
          break label895;
          ad.i("Finder.FinderPostTask", "copy Video failed, copyRet:".concat(String.valueOf(l)));
        }
      }
    }
    label1166:
    AppMethodBeat.o(199529);
  }
  
  private final void j(final FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167770);
    com.tencent.mm.ad.c.g((a)new b(this, paramFinderItem));
    AppMethodBeat.o(167770);
  }
  
  public String abi()
  {
    AppMethodBeat.i(167772);
    String str = "post_" + this.qQF.getLocalId();
    AppMethodBeat.o(167772);
    return str;
  }
  
  public void call()
  {
    AppMethodBeat.i(167774);
    Object localObject1 = this.qQF.getPostInfo();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if ((com.tencent.mm.plugin.finder.storage.b.coX()) && (ad.getLogLevel() >= 0))
    {
      ad.i("Finder.FinderPostTask", "debug failed");
      ZH("failed for debug");
      localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
      com.tencent.mm.plugin.finder.storage.b.ld(false);
      AppMethodBeat.o(167774);
      return;
    }
    if (((bme)localObject1).gll > 5) {}
    for (int i = 1; i != 0; i = 0)
    {
      ZH("try to post this feed too many times!");
      AppMethodBeat.o(167774);
      return;
    }
    localObject2 = e.c.qFV;
    e.c.cnJ();
    localObject2 = this.qQF;
    Object localObject3 = ((FinderItem)localObject2).getPostInfo();
    ((bme)localObject3).gll += 1;
    ((FinderItem)localObject2).setPostInfo((bme)localObject3);
    localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    b.a.g((FinderItem)localObject2);
    if (((bme)localObject1).DJF != 1)
    {
      ad.d("Finder.FinderPostTask", "try post need upload task " + this.qQF.getLocalId());
      localObject1 = this.qQF.getFinderObject();
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if ((localObject1 == null) || (this.qQF.getRefObjectFlag() != 0L)) {
          break label386;
        }
        ad.i("Finder.FinderPostTask", "moveFileToPost");
        localObject1 = com.tencent.mm.plugin.finder.utils.k.qTp;
        localObject1 = com.tencent.mm.plugin.finder.utils.k.csd();
        i.aMF((String)localObject1);
        if ((qRl) && (ad.getLogLevel() <= 1))
        {
          ad.i("Finder.FinderPostTask", "debugDeleteFileWhenMoveFile");
          i.cO((String)localObject1, true);
        }
        if ((this.qQF.getMediaExtList().size() != 1) || (((bmd)this.qQF.getMediaExtList().get(0)).LzL == null)) {
          break label379;
        }
        fVJ();
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        b.a.g(this.qQF);
        localObject1 = f.qRf;
        localObject1 = f.crB();
        localObject2 = new c(this.qQF);
        localObject3 = (com.tencent.mm.loader.g.f)new c(this);
        d.g.b.k.h(localObject2, "processTask");
        d.g.b.k.h(localObject3, "callback");
        ((f)localObject1).qRa.a((com.tencent.mm.loader.g.c)localObject2, (com.tencent.mm.loader.g.f)localObject3);
        AppMethodBeat.o(167774);
        return;
        localObject1 = null;
        break;
        label379:
        fVK();
      }
    }
    label386:
    j(this.qQF);
    AppMethodBeat.o(167774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(167771);
    Object localObject = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aeS().b(3585, (com.tencent.mm.al.g)this);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
      AppMethodBeat.o(167771);
      throw paramString;
    }
    localObject = ((x)paramn).clientId;
    ad.i("Finder.FinderPostTask", "errType %d, errCode %d, errMsg %s, clientId %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localObject });
    if (!((String)localObject).equals(this.qQF.getPostInfo().clientId))
    {
      ad.w("Finder.FinderPostTask", "not my feed!");
      AppMethodBeat.o(167771);
      return;
    }
    this.qQF.trackPost("doPostSceneEnd");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = f.qRf;
      com.tencent.mm.ad.c.g((a)new f.e(f.crB(), this.qQF.getLocalId(), ((x)paramn).qps.id));
      if (this.qQF.getPostInfo().DJJ > 0L)
      {
        paramString = e.b.qFJ;
        e.b.qr(ce.asQ() - this.qQF.getPostInfo().DJJ);
      }
      a(com.tencent.mm.loader.g.h.gla);
      AppMethodBeat.o(167771);
      return;
    }
    a(com.tencent.mm.loader.g.h.glc);
    if (this.qQF.isPostFailed())
    {
      paramString = f.qRf;
      f.crB().qL(this.qQF.getLocalId());
    }
    AppMethodBeat.o(167771);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask$Companion;", "", "()V", "TAG", "", "debugDeleteFileWhenMoveFile", "", "getDebugDeleteFileWhenMoveFile", "()Z", "setDebugDeleteFileWhenMoveFile", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(g paramg, FinderItem paramFinderItem)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/FinderPostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<c>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/FinderPostTask$tryPost$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.loader.g.f<j>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.g
 * JD-Core Version:    0.7.0.1
 */