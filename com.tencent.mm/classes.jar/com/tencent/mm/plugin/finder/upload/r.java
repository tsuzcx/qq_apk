package com.tencent.mm.plugin.finder.upload;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.c;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.h.a;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "mainFinderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getMainFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setMainFinderObj", "failTask", "", "getAudioQualityLevel", "", "input", "", "bitrate", "samplerate", "channels", "", "enableAuQA", "", "useOriAu", "saveToDb", "start", "uniqueId", "updateProgress", "avgProgress", "index", "size", "Companion", "plugin-finder_release"})
public final class r
  extends j
{
  public static final a ABk;
  FinderItem ABj;
  
  static
  {
    AppMethodBeat.i(282865);
    ABk = new a((byte)0);
    AppMethodBeat.o(282865);
  }
  
  public r(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(282864);
    this.ABj = paramFinderItem;
    AppMethodBeat.o(282864);
  }
  
  private final void ecm()
  {
    AppMethodBeat.i(282861);
    c.a locala = c.AnK;
    c.a.r(this.ABj);
    AppMethodBeat.o(282861);
  }
  
  private final void ect()
  {
    AppMethodBeat.i(282862);
    Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "failTask");
    a(com.tencent.mm.loader.g.j.kQe);
    AppMethodBeat.o(282862);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(282863);
    long l = this.ABj.getLocalId();
    AppMethodBeat.o(282863);
    return String.valueOf(l);
  }
  
  public final void d(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(282860);
    if (paramFloat > 1.0F) {}
    for (float f = 1.0F;; f = paramFloat)
    {
      f *= (1.0F + paramInt1) / paramInt2;
      Object localObject = d.AjH;
      int i = (int)(d.dSr() * f);
      Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "feed " + this.ABj.getLocalId() + " updateProgress " + paramFloat + ", " + f + ", " + i + ", index:" + paramInt1 + ", size:" + paramInt2);
      if (this.ABj.getPostInfo().TAi < i)
      {
        this.ABj.getPostInfo().TAi = i;
        localObject = c.AnK;
        c.a.s(this.ABj);
      }
      localObject = EventCenter.instance;
      hr localhr = new hr();
      localhr.fEI.localId = this.ABj.getLocalId();
      localhr.fEI.progress = this.ABj.getPostInfo().TAi;
      ((EventCenter)localObject).publish((IEvent)localhr);
      AppMethodBeat.o(282860);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(282859);
    this.ABj.trackPost("mediaProcess");
    Object localObject1 = this.ABj.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 2;
    }
    localObject1 = d.AjH;
    if ((d.dSt()) && (Log.getLogLevel() >= 0))
    {
      Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "debug blocking, sleep.....");
      Thread.sleep(30000L);
    }
    localObject1 = d.AjH;
    if (((Number)d.dSo().aSr()).intValue() == 1)
    {
      ect();
      AppMethodBeat.o(282859);
      return;
    }
    localObject1 = this.ABj.getFeedObject().objectDesc;
    if (localObject1 != null) {}
    for (localObject1 = ((FinderObjectDesc)localObject1).mvInfo; localObject1 == null; localObject1 = null)
    {
      ect();
      AppMethodBeat.o(282859);
      return;
    }
    Object localObject4;
    if (((bdp)localObject1).SOF == 1)
    {
      localObject1 = ((bdp)localObject1).SOE;
      p.j(localObject1, "mvInfo.ordered_track_list_flex_clip");
      localObject1 = (List)localObject1;
      localObject4 = new LinkedList();
      localObject5 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject5).iterator();
    }
    label208:
    Object localObject6;
    label290:
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label292;
      }
      localObject6 = ((Iterator)localObject5).next();
      if (((bdt)localObject6).refObjectId == 0L) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label290;
        }
        ((Collection)localObject1).add(localObject6);
        break label208;
        localObject1 = ((bdp)localObject1).SOB;
        p.j(localObject1, "mvInfo.orderedTrackList");
        localObject1 = (List)localObject1;
        break;
      }
    }
    label292:
    ((LinkedList)localObject4).addAll((Collection)localObject1);
    localObject1 = ((Iterable)localObject4).iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label394;
      }
      localObject5 = (bdt)((Iterator)localObject1).next();
      localObject6 = ((Iterable)this.ABj.getClipListExt()).iterator();
      if (((Iterator)localObject6).hasNext()) {
        if (!p.h(((FinderItem)((Iterator)localObject6).next()).getObjectNonceId(), ((bdt)localObject5).SOS)) {
          break;
        }
      }
    }
    label394:
    Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "processTracks size:" + ((LinkedList)localObject4).size());
    final int n = ((LinkedList)localObject4).size();
    Object localObject5 = ((Iterable)localObject4).iterator();
    final int i = 0;
    for (;;)
    {
      int j;
      Object localObject8;
      label537:
      float f1;
      float f2;
      Object localObject7;
      int k;
      float f3;
      label757:
      final long l1;
      label813:
      Object localObject9;
      if (((Iterator)localObject5).hasNext())
      {
        localObject1 = ((Iterator)localObject5).next();
        j = i + 1;
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject8 = (bdt)localObject1;
        localObject4 = ((Iterable)this.ABj.getClipListExt()).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            localObject1 = ((Iterator)localObject4).next();
            if (p.h(((FinderItem)localObject1).getObjectNonceId(), ((bdt)localObject8).SOS))
            {
              localObject6 = (FinderItem)localObject1;
              if (localObject6 == null) {
                break label3076;
              }
              if (localObject8 == null) {
                break label813;
              }
              localObject1 = ((bdt)localObject8).SOY;
              if ((localObject1 == null) || (((LinkedList)localObject1).contains(Integer.valueOf(1)) != true)) {
                break label813;
              }
              localObject1 = ((FinderItem)localObject6).getCropInfo(0);
              if (localObject1 != null)
              {
                localObject4 = av.AJz;
                localObject4 = av.a(new com.tencent.mm.plugin.finder.loader.r((csg)localObject1, com.tencent.mm.plugin.finder.storage.u.Aly, null, null, 12), String.valueOf(System.currentTimeMillis()));
                f1 = ((csg)localObject1).width;
                f2 = ((csg)localObject1).height;
                localObject7 = d.AjH;
                i = d.dSc();
                localObject7 = d.AjH;
                k = d.dSb();
                f3 = Math.min(i * 1.0F / f1, k * 1.0F / f2);
                if (f3 <= 1.0F) {
                  break label757;
                }
                com.tencent.mm.vfs.u.on(((csg)localObject1).url, (String)localObject4);
              }
            }
          }
        }
        for (;;)
        {
          ((csg)localObject1).url = ((String)localObject4);
          ((csg)localObject1).mediaId = MD5Util.getMD5String(((csg)localObject1).url);
          localObject4 = new LinkedList();
          ((LinkedList)localObject4).add(localObject1);
          localObject1 = x.aazN;
          ((FinderItem)localObject6).setMediaList((LinkedList)localObject4);
          ecm();
          i = j;
          break;
          localObject1 = null;
          break label537;
          i = (int)(f1 * f3);
          k = (int)(f2 * f3);
          BitmapUtil.saveBitmapToImage(BitmapUtil.scaleBitmap(BitmapUtil.decodeFile(((csg)localObject1).url), f3, f3), 100, Bitmap.CompressFormat.JPEG, (String)localObject4, false);
          ((csg)localObject1).width = i;
          ((csg)localObject1).height = k;
        }
        localObject1 = ((FinderItem)localObject6).getFinderObject().objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).media;
          if (localObject1 == null) {}
        }
        for (localObject4 = (FinderMedia)((LinkedList)localObject1).getFirst();; localObject4 = null)
        {
          localObject7 = ((FinderItem)localObject6).getCropInfo(0);
          if (localObject7 != null) {
            break;
          }
          Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "cannot get local finder media");
          ect();
          AppMethodBeat.o(282859);
          return;
        }
        localObject1 = ((csg)localObject7).zBo;
        if (localObject1 != null) {}
        for (k = ((css)localObject1).retryCount;; k = 0)
        {
          localObject1 = d.AjH;
          if (k <= d.dSp()) {
            break;
          }
          ect();
          AppMethodBeat.o(282859);
          return;
        }
        if ((localObject8 != null) && (localObject4 != null))
        {
          l1 = Util.currentTicks();
          localObject1 = ((csg)localObject7).zBo;
          if (localObject1 != null)
          {
            localObject9 = ((csg)localObject7).zBo;
            if (localObject9 != null)
            {
              k = ((css)localObject9).retryCount;
              label981:
              ((css)localObject1).retryCount = (k + 1);
            }
          }
          else
          {
            ecm();
            localObject1 = ((FinderMedia)localObject4).url;
            if (localObject1 != null) {
              break label3073;
            }
            localObject1 = "";
          }
        }
      }
      label3073:
      for (;;)
      {
        p.j(localObject1, "mvMedia.url ?: \"\"");
        if (!com.tencent.mm.vfs.u.agG((String)localObject1))
        {
          Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "start process mv, file not exist:".concat(String.valueOf(localObject1)));
          ect();
          AppMethodBeat.o(282859);
          return;
          k = 0;
          break label981;
        }
        f1 = ((FinderMedia)localObject4).width;
        f2 = ((FinderMedia)localObject4).height;
        k = ((FinderMedia)localObject4).videoDuration;
        long l2 = ((bdt)localObject8).MSG;
        long l3 = l2 + ((bdt)localObject8).SOR;
        localObject4 = MultiMediaVideoChecker.NmA.cO((String)localObject1, true);
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "start process mv, size:[" + f1 + ',' + f2 + "], videoDuration:" + k + ", clipRange:[" + l2 + ',' + l3 + "], path:" + (String)localObject1);
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "start process mv, videoInfo:".concat(String.valueOf(localObject4)));
        if (localObject4 == null)
        {
          Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "start process mv, fail to get origin video info");
          ect();
          AppMethodBeat.o(282859);
          return;
        }
        localObject8 = d.AjH;
        localObject9 = d.dRJ();
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "process mv videoParams ".concat(String.valueOf(localObject9)));
        localObject8 = new FinderMediaReportObject();
        ((FinderMediaReportObject)localObject8).mediaType = ((csg)localObject7).mediaType;
        ((FinderMediaReportObject)localObject8).origin = new FinderMediaReportInfo();
        ((FinderMediaReportObject)localObject8).multiMediaInfo = new LinkedList();
        Object localObject10 = new FinderMediaReportInfo();
        ((FinderMediaReportInfo)localObject10).fileSize = ((int)com.tencent.mm.vfs.u.bBQ((String)localObject1));
        ((FinderMediaReportInfo)localObject10).width = ((int)f1);
        ((FinderMediaReportInfo)localObject10).height = ((int)f2);
        ((FinderMediaReportInfo)localObject10).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
        ((FinderMediaReportInfo)localObject10).videoDuration = k;
        ((FinderMediaReportInfo)localObject10).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
        ((FinderMediaReportInfo)localObject10).fps = ((int)((MultiMediaVideoChecker.a)localObject4).cLa);
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "put multiMediaInfo:".concat(String.valueOf(localObject10)));
        ((FinderMediaReportObject)localObject8).multiMediaInfo.add(localObject10);
        localObject10 = new aa((csg)localObject7, com.tencent.mm.plugin.finder.storage.u.AlL, 0, null, 12);
        Object localObject11 = av.AJz;
        localObject10 = av.a((aa)localObject10, String.valueOf(System.currentTimeMillis()));
        localObject11 = new ad((String)localObject1, 2);
        ((ad)localObject11).Sn(l2);
        ((ad)localObject11).So(l3);
        final Object localObject12 = new ac(kotlin.a.j.listOf(localObject11));
        ((ac)localObject12).aG(l2, l3);
        localObject1 = new Rect();
        int m = ((MultiMediaVideoChecker.a)localObject4).width;
        k = ((MultiMediaVideoChecker.a)localObject4).height;
        if ((((MultiMediaVideoChecker.a)localObject4).fSM == 90) || (((MultiMediaVideoChecker.a)localObject4).fSM == 270))
        {
          m = ((MultiMediaVideoChecker.a)localObject4).height;
          k = ((MultiMediaVideoChecker.a)localObject4).width;
        }
        for (;;)
        {
          ((ad)localObject11).Nnd.vcr.set(0, 0, m, k);
          ((ac)localObject12).kH(m, k);
          ((Rect)localObject1).set(0, 0, m, k);
          ((ac)localObject12).x((Rect)localObject1);
          ((ac)localObject12).Ap(false);
          localObject4 = new g((ac)localObject12);
          ((g)localObject4).a((String)localObject10, (VideoTransPara)localObject9, new Size(m, k), (Rect)localObject1, true, true);
          localObject1 = ((g)localObject4).gsR();
          ((acu)localObject1).NkX.uVk = ((String)localObject10);
          localObject4 = ((acu)localObject1).NkX;
          localObject11 = new com.tencent.mm.plugin.vlog.model.f();
          ((com.tencent.mm.plugin.vlog.model.f)localObject11).wwk = 3;
          localObject12 = ((csg)localObject7).zBo;
          if (localObject12 != null) {}
          for (k = ((css)localObject12).retryCount;; k = 0)
          {
            ((com.tencent.mm.plugin.vlog.model.f)localObject11).retryCount = k;
            localObject12 = d.AjH;
            if (d.dRL()) {
              ((com.tencent.mm.plugin.vlog.model.f)localObject11).a(true, (VideoTransPara)localObject9);
            }
            localObject12 = new aa.c();
            ((aa.c)localObject12).aaBz = 0.0F;
            ((com.tencent.mm.plugin.vlog.model.f)localObject11).Z((kotlin.g.a.b)new b((aa.c)localObject12, i, this, n));
            localObject12 = new Object();
            final aa.a locala = new aa.a();
            locala.aaBx = false;
            aa.d locald = new aa.d();
            locald.aaBA = -1;
            f2 = ((com.tencent.mm.plugin.vlog.model.f)localObject11).a((acu)localObject1, (kotlin.g.a.b)new c(locald, l1, (FinderMediaReportObject)localObject8, (String)localObject10, (acv)localObject4, (VideoTransPara)localObject9, (acu)localObject1, localObject12, locala, this, n));
            try
            {
              if (!locala.aaBx)
              {
                Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "wait");
                localObject12.wait();
                Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "notify " + locald.aaBA);
              }
              localObject1 = x.aazN;
              localObject4 = MultiMediaVideoChecker.NmA.cO((String)localObject10, true);
              Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "remux finished, ret:" + locald.aaBA + ", videoQuality:" + f2 + ", outputVideoInfo:" + localObject4);
              if ((locald.aaBA >= 0) && (localObject4 != null) && (((MultiMediaVideoChecker.a)localObject4).width >= 0) && (((MultiMediaVideoChecker.a)localObject4).height >= 0) && (((MultiMediaVideoChecker.a)localObject4).duration >= 0L)) {
                break;
              }
              ect();
              AppMethodBeat.o(282859);
              return;
            }
            finally
            {
              AppMethodBeat.o(282859);
            }
          }
          d(1.0F, i, n);
          ((csg)localObject7).width = ((MultiMediaVideoChecker.a)localObject4).width;
          ((csg)localObject7).height = ((MultiMediaVideoChecker.a)localObject4).height;
          i = ((VideoTransPara)localObject9).lJy;
          k = (int)(((csg)localObject7).height / ((csg)localObject7).width * i);
          Object localObject3 = f.AzZ.aj((String)localObject10, i, k);
          localObject11 = d.AjH;
          label2102:
          boolean bool;
          if (d.dVd())
          {
            localObject11 = d.AjH;
            i = AdaptiveAdjustBitrate.getVideoImageQuality(d.dRM(), 0, i, k, 0.8F);
            bool = false;
            if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQH, 0) == 1) {
              bool = true;
            }
            f1 = ((VideoTransPara)localObject9).audioBitrate;
            f3 = ((VideoTransPara)localObject9).audioSampleRate;
            k = ((VideoTransPara)localObject9).audioChannelCount;
            p.k(localObject10, "input");
            localObject9 = d.AjH;
            if (!d.dVd()) {
              break label3010;
            }
            f1 = AdaptiveAdjustBitrate.a((String)localObject10, f1, f3, k, bool, true);
            label2183:
            Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "qipengfeng, audio quality level: ".concat(String.valueOf(f1)));
            ((csg)localObject7).TAf = ((FinderMediaReportObject)localObject8);
            ((csg)localObject7).url = ((String)localObject10);
            ((csg)localObject7).thumbUrl = ((String)localObject3);
            ((csg)localObject7).TzU = false;
            ((csg)localObject7).mediaId = MD5Util.getMD5String(((csg)localObject7).url);
            ((csg)localObject7).fileSize = ((int)com.tencent.mm.vfs.u.bBQ((String)localObject10));
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null) {
              ((FinderMediaReportObject)localObject3).target = new FinderMediaReportInfo();
            }
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).fileSize = ((csg)localObject7).fileSize;
              }
            }
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null)
            {
              localObject8 = ((csg)localObject7).TAf;
              if (localObject8 == null) {
                break label3015;
              }
              localObject8 = ((FinderMediaReportObject)localObject8).target;
              if (localObject8 == null) {
                break label3015;
              }
              k = ((FinderMediaReportInfo)localObject8).fileSize;
              label2350:
              ((FinderMediaReportObject)localObject3).videoFinalSize = k;
            }
            localObject3 = ((csg)localObject7).TpG;
            if (localObject3 != null) {
              ((acu)localObject3).Sox = false;
            }
            if (((csg)localObject7).codec_info == null) {
              ((csg)localObject7).codec_info = new bea();
            }
            localObject3 = ((csg)localObject7).codec_info;
            if (localObject3 != null)
            {
              ((bea)localObject3).SPf = f2;
              ((bea)localObject3).SPh = 0.0F;
              ((bea)localObject3).SPi = i;
              localObject8 = ((csg)localObject7).TpG;
              if (localObject8 == null) {
                break label3021;
              }
              localObject8 = ((acu)localObject8).NkY;
              if (localObject8 == null) {
                break label3021;
              }
              localObject8 = ((act)localObject8).Sor;
              if (localObject8 == null) {
                break label3021;
              }
              i = ((LinkedList)localObject8).size();
              label2470:
              if (i <= 0) {
                break label3027;
              }
              bool = true;
              label2478:
              ((bea)localObject3).SPk = bool;
              Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "codec_info video_score:" + ((bea)localObject3).SPf + ",video_cover_score:" + ((bea)localObject3).SPg + ",video_audio_score:" + ((bea)localObject3).SPh + ",thumb_score:" + ((bea)localObject3).SPi + ",hdimg_score:" + ((bea)localObject3).SPj + ",has_stickers:" + ((bea)localObject3).SPk);
              localObject3 = x.aazN;
            }
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 == null) {
              break label3033;
            }
          }
          label3010:
          label3015:
          label3021:
          label3027:
          label3033:
          for (localObject3 = ((FinderMediaReportObject)localObject3).codecInfo;; localObject3 = null)
          {
            if (localObject3 == null)
            {
              localObject3 = ((csg)localObject7).TAf;
              if (localObject3 != null) {
                ((FinderMediaReportObject)localObject3).codecInfo = ((csg)localObject7).codec_info;
              }
            }
            ((csg)localObject7).videoDuration = a.dm((float)((MultiMediaVideoChecker.a)localObject4).duration / 1000.0F);
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
              }
            }
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).width = ((MultiMediaVideoChecker.a)localObject4).width;
              }
            }
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).height = ((MultiMediaVideoChecker.a)localObject4).height;
              }
            }
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
              }
            }
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
              }
            }
            localObject3 = ((csg)localObject7).TAf;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).fps = ((int)((MultiMediaVideoChecker.a)localObject4).cLa);
              }
            }
            localObject3 = new LinkedList();
            ((LinkedList)localObject3).add(localObject7);
            localObject4 = x.aazN;
            ((FinderItem)localObject6).setMediaList((LinkedList)localObject3);
            localObject3 = ((FinderItem)localObject6).field_reportObject;
            if (localObject3 != null)
            {
              ((FinderFeedReportObject)localObject3).remuxEndTime = cm.bfE();
              ((FinderFeedReportObject)localObject3).remuxType = 2;
              localObject3 = x.aazN;
            }
            Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "processList url " + ((csg)localObject7).url + " thumbUrl: " + ((csg)localObject7).thumbUrl + " newMd5: " + MD5Util.getMD5String(((csg)localObject7).url) + " size:" + Util.getSizeKB(com.tencent.mm.vfs.u.bBQ(((csg)localObject7).url)));
            ecm();
            i = j;
            break;
            i = 0;
            break label2102;
            f1 = 0.0F;
            break label2183;
            k = 0;
            break label2350;
            i = 0;
            break label2470;
            bool = false;
            break label2478;
          }
          Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "error cannot get mvTrack and mvMedia");
          ect();
          AppMethodBeat.o(282859);
          return;
          a(com.tencent.mm.loader.g.j.kQd);
          AppMethodBeat.o(282859);
          return;
        }
      }
      label3076:
      i = j;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$start$3$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<Float, x>
  {
    b(aa.c paramc, int paramInt1, r paramr, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$start$3$videoQuality$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.vlog.model.l, x>
  {
    c(aa.d paramd, long paramLong, FinderMediaReportObject paramFinderMediaReportObject, String paramString, acv paramacv, VideoTransPara paramVideoTransPara, acu paramacu, Object paramObject, aa.a parama, r paramr, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.r
 * JD-Core Version:    0.7.0.1
 */