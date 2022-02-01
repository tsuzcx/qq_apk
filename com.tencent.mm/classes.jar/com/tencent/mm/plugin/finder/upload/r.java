package com.tencent.mm.plugin.finder.upload;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.g.b.z.c;
import kotlin.g.b.z.d;
import kotlin.h.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "mainFinderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getMainFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setMainFinderObj", "failTask", "", "getAudioQualityLevel", "", "input", "", "bitrate", "samplerate", "channels", "", "enableAuQA", "", "useOriAu", "saveToDb", "start", "uniqueId", "updateProgress", "avgProgress", "index", "size", "Companion", "plugin-finder_release"})
public final class r
  extends j
{
  public static final a vTH;
  FinderItem vTG;
  
  static
  {
    AppMethodBeat.i(253147);
    vTH = new a((byte)0);
    AppMethodBeat.o(253147);
  }
  
  public r(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(253146);
    this.vTG = paramFinderItem;
    AppMethodBeat.o(253146);
  }
  
  private final void dBc()
  {
    AppMethodBeat.i(253143);
    c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    c.a.q(this.vTG);
    AppMethodBeat.o(253143);
  }
  
  private final void dBl()
  {
    AppMethodBeat.i(253144);
    Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "failTask");
    a(com.tencent.mm.loader.g.j.ibx);
    AppMethodBeat.o(253144);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(253145);
    long l = this.vTG.getLocalId();
    AppMethodBeat.o(253145);
    return String.valueOf(l);
  }
  
  public final void d(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253142);
    if (paramFloat > 1.0F) {}
    for (float f = 1.0F;; f = paramFloat)
    {
      f *= (1.0F + paramInt1) / paramInt2;
      Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      int i = (int)(com.tencent.mm.plugin.finder.storage.c.drd() * f);
      Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "feed " + this.vTG.getLocalId() + " updateProgress " + paramFloat + ", " + f + ", " + i + ", index:" + paramInt1 + ", size:" + paramInt2);
      if (this.vTG.getPostInfo().Mpc < i)
      {
        this.vTG.getPostInfo().Mpc = i;
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.r(this.vTG);
      }
      localObject = EventCenter.instance;
      hk localhk = new hk();
      localhk.dLT.localId = this.vTG.getLocalId();
      localhk.dLT.progress = this.vTG.getPostInfo().Mpc;
      ((EventCenter)localObject).publish((IEvent)localhk);
      AppMethodBeat.o(253142);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(253141);
    this.vTG.trackPost("mediaProcess");
    Object localObject1 = this.vTG.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 2;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if ((com.tencent.mm.plugin.finder.storage.c.drf()) && (Log.getLogLevel() >= 0))
    {
      Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "debug blocking, sleep.....");
      Thread.sleep(30000L);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dra().value()).intValue() == 1)
    {
      dBl();
      AppMethodBeat.o(253141);
      return;
    }
    localObject1 = this.vTG.getFeedObject().objectDesc;
    if (localObject1 != null) {}
    for (localObject1 = ((FinderObjectDesc)localObject1).mvInfo; localObject1 == null; localObject1 = null)
    {
      dBl();
      AppMethodBeat.o(253141);
      return;
    }
    Object localObject4 = new LinkedList();
    localObject1 = ((axw)localObject1).LId;
    p.g(localObject1, "mvInfo.orderedTrackList");
    Object localObject5 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject5 = ((Iterable)localObject5).iterator();
    label249:
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = ((Iterator)localObject5).next();
      if (((axz)localObject6).refObjectId == 0L) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label249;
        }
        ((Collection)localObject1).add(localObject6);
        break;
      }
    }
    ((LinkedList)localObject4).addAll((Collection)localObject1);
    localObject1 = ((Iterable)localObject4).iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label353;
      }
      localObject5 = (axz)((Iterator)localObject1).next();
      localObject6 = ((Iterable)this.vTG.getClipListExt()).iterator();
      if (((Iterator)localObject6).hasNext()) {
        if (!p.j(((FinderItem)((Iterator)localObject6).next()).getObjectNonceId(), ((axz)localObject5).LIm)) {
          break;
        }
      }
    }
    label353:
    Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "processTracks size:" + ((LinkedList)localObject4).size());
    final int n = ((LinkedList)localObject4).size();
    Object localObject6 = ((Iterable)localObject4).iterator();
    final int i = 0;
    label643:
    label2205:
    label2213:
    for (;;)
    {
      int j;
      FinderItem localFinderItem;
      label557:
      cjl localcjl;
      label631:
      label637:
      int k;
      final long l1;
      Object localObject7;
      if (((Iterator)localObject6).hasNext())
      {
        localObject1 = ((Iterator)localObject6).next();
        j = i + 1;
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject4 = (axz)localObject1;
        localObject5 = ((Iterable)this.vTG.getClipListExt()).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject1 = ((Iterator)localObject5).next();
          if (p.j(((FinderItem)localObject1).getObjectNonceId(), ((axz)localObject4).LIm))
          {
            localFinderItem = (FinderItem)localObject1;
            if (localFinderItem == null) {
              break label2811;
            }
            localObject1 = localFinderItem.getFinderObject().objectDesc;
            if (localObject1 == null) {
              break label631;
            }
            localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
            if (localObject1 == null) {
              break label631;
            }
            localObject1 = ((axw)localObject1).LId;
            if (localObject1 == null) {
              break label631;
            }
            localObject1 = (axz)((LinkedList)localObject1).getFirst();
            localObject4 = localFinderItem.getFinderObject().objectDesc;
            if (localObject4 == null) {
              break label637;
            }
            localObject4 = ((FinderObjectDesc)localObject4).media;
            if (localObject4 == null) {
              break label637;
            }
          }
        }
        for (localObject5 = (FinderMedia)((LinkedList)localObject4).getFirst();; localObject5 = null)
        {
          localcjl = localFinderItem.getCropInfo(0);
          if (localcjl != null) {
            break label643;
          }
          Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "cannot get local finder media");
          dBl();
          AppMethodBeat.o(253141);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label557;
        }
        localObject4 = localcjl.uOR;
        if (localObject4 != null) {}
        for (k = ((cjx)localObject4).retryCount;; k = 0)
        {
          localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (k <= com.tencent.mm.plugin.finder.storage.c.drb()) {
            break;
          }
          dBl();
          AppMethodBeat.o(253141);
          return;
        }
        if ((localObject1 != null) && (localObject5 != null))
        {
          l1 = Util.currentTicks();
          localObject4 = localcjl.uOR;
          if (localObject4 != null)
          {
            localObject7 = localcjl.uOR;
            if (localObject7 != null)
            {
              k = ((cjx)localObject7).retryCount;
              label737:
              ((cjx)localObject4).retryCount = (k + 1);
            }
          }
          else
          {
            dBc();
            localObject4 = ((FinderMedia)localObject5).url;
            if (localObject4 != null) {
              break label2808;
            }
            localObject4 = "";
          }
        }
      }
      label1837:
      label2745:
      label2750:
      label2756:
      label2762:
      label2768:
      label2808:
      for (;;)
      {
        p.g(localObject4, "mvMedia.url ?: \"\"");
        if (!com.tencent.mm.vfs.s.YS((String)localObject4))
        {
          Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "start process mv, file not exist:".concat(String.valueOf(localObject4)));
          dBl();
          AppMethodBeat.o(253141);
          return;
          k = 0;
          break label737;
        }
        float f1 = ((FinderMedia)localObject5).width;
        float f2 = ((FinderMedia)localObject5).height;
        k = ((FinderMedia)localObject5).videoDuration;
        long l2 = ((axz)localObject1).Ghw;
        long l3 = l2 + ((axz)localObject1).LIl;
        Object localObject8 = MultiMediaVideoChecker.GyY.cA((String)localObject4, true);
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "start process mv, size:[" + f1 + ',' + f2 + "], videoDuration:" + k + ", clipRange:[" + l2 + ',' + l3 + "], path:" + (String)localObject4);
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "start process mv, videoInfo:".concat(String.valueOf(localObject8)));
        if (localObject8 == null)
        {
          Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "start process mv, fail to get origin video info");
          dBl();
          AppMethodBeat.o(253141);
          return;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        localObject5 = com.tencent.mm.plugin.finder.storage.c.dqx();
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "process mv videoParams ".concat(String.valueOf(localObject5)));
        localObject1 = new FinderMediaReportObject();
        ((FinderMediaReportObject)localObject1).mediaType = localcjl.mediaType;
        ((FinderMediaReportObject)localObject1).origin = new FinderMediaReportInfo();
        ((FinderMediaReportObject)localObject1).multiMediaInfo = new LinkedList();
        localObject7 = new FinderMediaReportInfo();
        ((FinderMediaReportInfo)localObject7).fileSize = ((int)com.tencent.mm.vfs.s.boW((String)localObject4));
        ((FinderMediaReportInfo)localObject7).width = ((int)f1);
        ((FinderMediaReportInfo)localObject7).height = ((int)f2);
        ((FinderMediaReportInfo)localObject7).videoBitrate = ((MultiMediaVideoChecker.a)localObject8).bitrate;
        ((FinderMediaReportInfo)localObject7).videoDuration = k;
        ((FinderMediaReportInfo)localObject7).audioBitrate = ((MultiMediaVideoChecker.a)localObject8).audioBitrate;
        ((FinderMediaReportInfo)localObject7).fps = ((int)((MultiMediaVideoChecker.a)localObject8).cKu);
        Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "put multiMediaInfo:".concat(String.valueOf(localObject7)));
        ((FinderMediaReportObject)localObject1).multiMediaInfo.add(localObject7);
        localObject7 = new com.tencent.mm.plugin.finder.loader.s(localcjl, com.tencent.mm.plugin.finder.storage.x.vEA, 0, null, 12);
        Object localObject9 = al.waC;
        localObject7 = al.a((com.tencent.mm.plugin.finder.loader.s)localObject7, String.valueOf(System.currentTimeMillis()));
        localObject9 = new ad((String)localObject4, 2);
        final Object localObject10 = new ac(kotlin.a.j.listOf(localObject9));
        ((ac)localObject10).at(l2, l3);
        localObject4 = new Rect();
        int m = ((MultiMediaVideoChecker.a)localObject8).width;
        k = ((MultiMediaVideoChecker.a)localObject8).height;
        if ((((MultiMediaVideoChecker.a)localObject8).dYT == 90) || (((MultiMediaVideoChecker.a)localObject8).dYT == 270))
        {
          m = ((MultiMediaVideoChecker.a)localObject8).height;
          k = ((MultiMediaVideoChecker.a)localObject8).width;
        }
        for (;;)
        {
          ((ad)localObject9).Gzx.rwL.set(0, 0, m, k);
          ((ac)localObject10).jt(m, k);
          ((Rect)localObject4).set(0, 0, m, k);
          ((ac)localObject10).q((Rect)localObject4);
          ((ac)localObject10).wB(false);
          localObject8 = new com.tencent.mm.plugin.vlog.model.g((ac)localObject10);
          ((com.tencent.mm.plugin.vlog.model.g)localObject8).a((String)localObject7, (VideoTransPara)localObject5, new Size(m, k), (Rect)localObject4, true, true);
          localObject4 = ((com.tencent.mm.plugin.vlog.model.g)localObject8).fAQ();
          ((acn)localObject4).Gxw.rpE = ((String)localObject7);
          localObject8 = ((acn)localObject4).Gxw;
          localObject9 = new com.tencent.mm.plugin.vlog.model.f();
          localObject10 = localcjl.uOR;
          if (localObject10 != null) {}
          for (k = ((cjx)localObject10).retryCount;; k = 0)
          {
            ((com.tencent.mm.plugin.vlog.model.f)localObject9).retryCount = k;
            localObject10 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dqB()) {
              ((com.tencent.mm.plugin.vlog.model.f)localObject9).r((VideoTransPara)localObject5);
            }
            localObject10 = new z.c();
            ((z.c)localObject10).SYD = 0.0F;
            ((com.tencent.mm.plugin.vlog.model.f)localObject9).N((kotlin.g.a.b)new b((z.c)localObject10, i, this, n));
            localObject10 = new Object();
            final z.a locala = new z.a();
            locala.SYB = false;
            z.d locald = new z.d();
            locald.SYE = -1;
            f2 = ((com.tencent.mm.plugin.vlog.model.f)localObject9).a((acn)localObject4, (kotlin.g.a.b)new c(locald, l1, (FinderMediaReportObject)localObject1, (String)localObject7, (aco)localObject8, (VideoTransPara)localObject5, (acn)localObject4, localObject10, locala, this, n));
            try
            {
              if (!locala.SYB)
              {
                Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "wait");
                localObject10.wait();
                Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "notify " + locald.SYE);
              }
              localObject4 = kotlin.x.SXb;
              localObject4 = MultiMediaVideoChecker.GyY.cA((String)localObject7, true);
              Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "remux finished, ret:" + locald.SYE + ", videoQuality:" + f2 + ", outputVideoInfo:" + localObject4);
              if ((locald.SYE >= 0) && (localObject4 != null) && (((MultiMediaVideoChecker.a)localObject4).width >= 0) && (((MultiMediaVideoChecker.a)localObject4).height >= 0) && (((MultiMediaVideoChecker.a)localObject4).duration >= 0L)) {
                break;
              }
              dBl();
              AppMethodBeat.o(253141);
              return;
            }
            finally
            {
              AppMethodBeat.o(253141);
            }
          }
          d(1.0F, i, n);
          localcjl.width = ((MultiMediaVideoChecker.a)localObject4).width;
          localcjl.height = ((MultiMediaVideoChecker.a)localObject4).height;
          i = ((VideoTransPara)localObject5).iTf;
          k = (int)(localcjl.height / localcjl.width * i);
          localObject8 = f.vSz.ag((String)localObject7, i, k);
          localObject9 = com.tencent.mm.plugin.finder.storage.c.vCb;
          boolean bool;
          if (com.tencent.mm.plugin.finder.storage.c.dtU())
          {
            localObject9 = com.tencent.mm.plugin.finder.storage.c.vCb;
            i = AdaptiveAdjustBitrate.getVideoImageQuality(com.tencent.mm.plugin.finder.storage.c.dqC(), 0, i, k, 0.8F);
            bool = false;
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgM, 0) == 1) {
              bool = true;
            }
            f1 = ((VideoTransPara)localObject5).audioBitrate;
            float f3 = ((VideoTransPara)localObject5).audioSampleRate;
            k = ((VideoTransPara)localObject5).audioChannelCount;
            p.h(localObject7, "input");
            localObject5 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!com.tencent.mm.plugin.finder.storage.c.dtU()) {
              break label2745;
            }
            f1 = AdaptiveAdjustBitrate.a((String)localObject7, f1, f3, k, bool, true);
            label1918:
            Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "qipengfeng, audio quality level: ".concat(String.valueOf(f1)));
            localcjl.MoZ = localObject2;
            localcjl.url = ((String)localObject7);
            localcjl.thumbUrl = ((String)localObject8);
            localcjl.MoO = false;
            localcjl.mediaId = MD5Util.getMD5String(localcjl.url);
            localcjl.fileSize = ((int)com.tencent.mm.vfs.s.boW((String)localObject7));
            localObject3 = localcjl.MoZ;
            if (localObject3 != null) {
              ((FinderMediaReportObject)localObject3).target = new FinderMediaReportInfo();
            }
            localObject3 = localcjl.MoZ;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).fileSize = localcjl.fileSize;
              }
            }
            localObject3 = localcjl.MoZ;
            if (localObject3 != null)
            {
              localObject5 = localcjl.MoZ;
              if (localObject5 == null) {
                break label2750;
              }
              localObject5 = ((FinderMediaReportObject)localObject5).target;
              if (localObject5 == null) {
                break label2750;
              }
              k = ((FinderMediaReportInfo)localObject5).fileSize;
              ((FinderMediaReportObject)localObject3).videoFinalSize = k;
            }
            localObject3 = localcjl.MfU;
            if (localObject3 != null) {
              ((acn)localObject3).Lng = false;
            }
            if (localcjl.codec_info == null) {
              localcjl.codec_info = new ayg();
            }
            localObject3 = localcjl.codec_info;
            if (localObject3 != null)
            {
              ((ayg)localObject3).LIt = f2;
              ((ayg)localObject3).LIv = 0.0F;
              ((ayg)localObject3).LIw = i;
              localObject5 = localcjl.MfU;
              if (localObject5 == null) {
                break label2756;
              }
              localObject5 = ((acn)localObject5).Gxx;
              if (localObject5 == null) {
                break label2756;
              }
              localObject5 = ((acm)localObject5).Lna;
              if (localObject5 == null) {
                break label2756;
              }
              i = ((LinkedList)localObject5).size();
              if (i <= 0) {
                break label2762;
              }
              bool = true;
              ((ayg)localObject3).LIy = bool;
              Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "codec_info video_score:" + ((ayg)localObject3).LIt + ",video_cover_score:" + ((ayg)localObject3).LIu + ",video_audio_score:" + ((ayg)localObject3).LIv + ",thumb_score:" + ((ayg)localObject3).LIw + ",hdimg_score:" + ((ayg)localObject3).LIx + ",has_stickers:" + ((ayg)localObject3).LIy);
              localObject3 = kotlin.x.SXb;
            }
            localObject3 = localcjl.MoZ;
            if (localObject3 == null) {
              break label2768;
            }
          }
          for (Object localObject3 = ((FinderMediaReportObject)localObject3).codecInfo;; localObject3 = null)
          {
            if (localObject3 == null)
            {
              localObject3 = localcjl.MoZ;
              if (localObject3 != null) {
                ((FinderMediaReportObject)localObject3).codecInfo = localcjl.codec_info;
              }
            }
            localcjl.videoDuration = a.cR((float)((MultiMediaVideoChecker.a)localObject4).duration / 1000.0F);
            localObject3 = localcjl.MoZ;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
              }
            }
            localObject3 = localcjl.MoZ;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).width = ((MultiMediaVideoChecker.a)localObject4).width;
              }
            }
            localObject3 = localcjl.MoZ;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).height = ((MultiMediaVideoChecker.a)localObject4).height;
              }
            }
            localObject3 = localcjl.MoZ;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
              }
            }
            localObject3 = localcjl.MoZ;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
              }
            }
            localObject3 = localcjl.MoZ;
            if (localObject3 != null)
            {
              localObject3 = ((FinderMediaReportObject)localObject3).target;
              if (localObject3 != null) {
                ((FinderMediaReportInfo)localObject3).fps = ((int)((MultiMediaVideoChecker.a)localObject4).cKu);
              }
            }
            localObject3 = new LinkedList();
            ((LinkedList)localObject3).add(localcjl);
            localObject4 = kotlin.x.SXb;
            localFinderItem.setMediaList((LinkedList)localObject3);
            localObject3 = localFinderItem.field_reportObject;
            if (localObject3 != null)
            {
              ((FinderFeedReportObject)localObject3).remuxEndTime = cl.aWA();
              ((FinderFeedReportObject)localObject3).remuxType = 2;
              localObject3 = kotlin.x.SXb;
            }
            Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "processList url " + localcjl.url + " thumbUrl: " + localcjl.thumbUrl + " newMd5: " + MD5Util.getMD5String(localcjl.url) + " size:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(localcjl.url)));
            dBc();
            i = j;
            break;
            i = 0;
            break label1837;
            f1 = 0.0F;
            break label1918;
            k = 0;
            break label2085;
            i = 0;
            break label2205;
            bool = false;
            break label2213;
          }
          Log.i("Finder.LogPost.MusicMvFinderMediaProcessTask", "error cannot get mvTrack and mvMedia");
          dBl();
          AppMethodBeat.o(253141);
          return;
          a(com.tencent.mm.loader.g.j.ibw);
          AppMethodBeat.o(253141);
          return;
        }
      }
      label2085:
      label2811:
      i = j;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$start$3$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<Float, kotlin.x>
  {
    b(z.c paramc, int paramInt1, r paramr, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask$start$3$videoQuality$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    c(z.d paramd, long paramLong, FinderMediaReportObject paramFinderMediaReportObject, String paramString, aco paramaco, VideoTransPara paramVideoTransPara, acn paramacn, Object paramObject, z.a parama, r paramr, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.r
 * JD-Core Version:    0.7.0.1
 */