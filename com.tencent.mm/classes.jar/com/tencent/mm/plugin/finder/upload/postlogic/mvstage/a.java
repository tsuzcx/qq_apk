package com.tencent.mm.plugin.finder.upload.postlogic.mvstage;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.plugin.vlog.model.k;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.c;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/mvstage/MvMediaProcessStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "mainFinderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "TAG", "", "getMainFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getAudioQualityLevel", "", "input", "bitrate", "samplerate", "channels", "", "enableAuQA", "", "useOriAu", "getStageType", "onFailed", "", "nextStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "onSuccess", "onWait", "saveToDb", "start", "updateProgress", "avgProgress", "index", "size", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  public final FinderItem GeK;
  final String TAG;
  
  public a(FinderItem paramFinderItem)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343244);
    this.GeK = paramFinderItem;
    this.TAG = "LogPost.MvMediaProcessStage";
    AppMethodBeat.o(343244);
  }
  
  private final void feB()
  {
    AppMethodBeat.i(343258);
    d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    d.a.u(this.GeK);
    AppMethodBeat.o(343258);
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343364);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343364);
  }
  
  public final void e(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(343347);
    if (paramFloat > 1.0F) {}
    for (float f = 1.0F;; f = paramFloat)
    {
      f *= (1.0F + paramInt1) / paramInt2;
      Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      int i = (int)(com.tencent.mm.plugin.finder.storage.d.eQF() * f);
      Log.i(this.TAG, "feed " + this.GeK.getLocalId() + " updateProgress " + paramFloat + ", " + f + ", " + i + ", index:" + paramInt1 + ", size:" + paramInt2);
      if (this.GeK.getPostInfo().aaPw < i)
      {
        this.GeK.getPostInfo().aaPw = i;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        d.a.v(this.GeK);
      }
      localObject = new ic();
      ((ic)localObject).hJy.localId = this.GeK.getLocalId();
      ((ic)localObject).hJy.progress = this.GeK.getPostInfo().aaPw;
      ((ic)localObject).publish();
      AppMethodBeat.o(343347);
      return;
    }
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343379);
    s.u(parame, "nextStage");
    parame = com.tencent.mm.plugin.finder.report.ah.d.Ftw;
    com.tencent.mm.plugin.finder.report.ah.d.tF(this.GeK.isLongVideo());
    AppMethodBeat.o(343379);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343392);
    s.u(parame, "nextStage");
    parame = com.tencent.mm.plugin.finder.report.ah.d.Ftw;
    com.tencent.mm.plugin.finder.report.ah.d.tF(this.GeK.isLongVideo());
    AppMethodBeat.o(343392);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    AppMethodBeat.i(343327);
    this.GeK.trackPost("mediaProcess");
    Object localObject1 = this.GeK.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 2;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((com.tencent.mm.plugin.finder.storage.d.eQH()) && (Log.getLogLevel() >= 0))
    {
      Log.i(this.TAG, "debug blocking, sleep.....");
      Thread.sleep(30000L);
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    Object localObject4;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eQB().bmg()).intValue() == 1)
    {
      localObject1 = this.GeK;
      localObject4 = f.Gfh;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new f((FinderItem)localObject1, f.fev());
      AppMethodBeat.o(343327);
      return localObject1;
    }
    localObject1 = this.GeK.getFeedObject().objectDesc;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((FinderObjectDesc)localObject1).mvInfo)
    {
      localObject1 = this.GeK;
      localObject4 = f.Gfh;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new f((FinderItem)localObject1, f.fev());
      AppMethodBeat.o(343327);
      return localObject1;
    }
    if (((bol)localObject1).ZWM == 1)
    {
      localObject1 = ((bol)localObject1).ZWL;
      s.s(localObject1, "mvInfo.ordered_track_list_flex_clip");
      localObject1 = (List)localObject1;
      localObject4 = new LinkedList();
      localObject5 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject5).iterator();
    }
    label262:
    Object localObject6;
    label344:
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label346;
      }
      localObject6 = ((Iterator)localObject5).next();
      if (((boq)localObject6).refObjectId == 0L) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label344;
        }
        ((Collection)localObject1).add(localObject6);
        break label262;
        localObject1 = ((bol)localObject1).ZWI;
        s.s(localObject1, "mvInfo.orderedTrackList");
        localObject1 = (List)localObject1;
        break;
      }
    }
    label346:
    ((LinkedList)localObject4).addAll((Collection)localObject1);
    localObject1 = ((Iterable)localObject4).iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label448;
      }
      localObject5 = (boq)((Iterator)localObject1).next();
      localObject6 = ((Iterable)this.GeK.getClipListExt()).iterator();
      if (((Iterator)localObject6).hasNext()) {
        if (!s.p(((FinderItem)((Iterator)localObject6).next()).getObjectNonceId(), ((boq)localObject5).ZWZ)) {
          break;
        }
      }
    }
    label448:
    Log.i(this.TAG, s.X("processTracks size:", Integer.valueOf(((LinkedList)localObject4).size())));
    final int n = ((LinkedList)localObject4).size();
    Object localObject5 = ((Iterable)localObject4).iterator();
    final int i = 0;
    for (;;)
    {
      int j;
      Object localObject8;
      label586:
      int k;
      label631:
      float f1;
      float f2;
      Object localObject7;
      float f3;
      label815:
      label821:
      label877:
      final long l1;
      Object localObject9;
      label1200:
      label1203:
      Object localObject10;
      Object localObject11;
      Object localObject12;
      int m;
      if (((Iterator)localObject5).hasNext())
      {
        localObject1 = ((Iterator)localObject5).next();
        j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        localObject8 = (boq)localObject1;
        localObject4 = ((Iterable)this.GeK.getClipListExt()).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            localObject1 = ((Iterator)localObject4).next();
            if (s.p(((FinderItem)localObject1).getObjectNonceId(), ((boq)localObject8).ZWZ))
            {
              localObject6 = (FinderItem)localObject1;
              if (localObject6 == null) {
                break label3375;
              }
              if (localObject8 == null) {
                break label815;
              }
              localObject1 = ((boq)localObject8).ZXf;
              if ((localObject1 == null) || (((LinkedList)localObject1).contains(Integer.valueOf(1)) != true)) {
                break label815;
              }
              k = 1;
              if (k == 0) {
                break label877;
              }
              localObject1 = ((FinderItem)localObject6).getCropInfo(0);
              if (localObject1 != null)
              {
                localObject4 = bm.GlZ;
                localObject4 = bm.a(new n((dji)localObject1, com.tencent.mm.plugin.finder.storage.v.FKY, null, null, 12), String.valueOf(System.currentTimeMillis()));
                f1 = ((dji)localObject1).width;
                f2 = ((dji)localObject1).height;
                localObject7 = com.tencent.mm.plugin.finder.storage.d.FAy;
                i = com.tencent.mm.plugin.finder.storage.d.eQp();
                localObject7 = com.tencent.mm.plugin.finder.storage.d.FAy;
                k = com.tencent.mm.plugin.finder.storage.d.eQo();
                f3 = Math.min(i * 1.0F / f1, k * 1.0F / f2);
                if (f3 <= 1.0F) {
                  break label821;
                }
                y.O(((dji)localObject1).url, (String)localObject4, false);
              }
            }
          }
        }
        for (;;)
        {
          ((dji)localObject1).url = ((String)localObject4);
          ((dji)localObject1).mediaId = MD5Util.getMD5String(((dji)localObject1).url);
          localObject4 = new LinkedList();
          ((LinkedList)localObject4).add(localObject1);
          localObject1 = ah.aiuX;
          ((FinderItem)localObject6).setMediaList((LinkedList)localObject4);
          feB();
          i = j;
          break;
          localObject1 = null;
          break label586;
          k = 0;
          break label631;
          i = (int)(f1 * f3);
          k = (int)(f2 * f3);
          BitmapUtil.saveBitmapToImage(BitmapUtil.scaleBitmap(BitmapUtil.decodeFile(((dji)localObject1).url), f3, f3), 100, Bitmap.CompressFormat.JPEG, (String)localObject4, false);
          ((dji)localObject1).width = i;
          ((dji)localObject1).height = k;
        }
        localObject1 = ((FinderItem)localObject6).getFinderObject().objectDesc;
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          localObject7 = ((FinderItem)localObject6).getCropInfo(0);
          if (localObject7 != null) {
            break;
          }
          Log.i(this.TAG, "cannot get local finder media");
          localObject1 = this.GeK;
          localObject4 = f.Gfh;
          localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new f((FinderItem)localObject1, f.fev());
          AppMethodBeat.o(343327);
          return localObject1;
          localObject1 = ((FinderObjectDesc)localObject1).media;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = (FinderMedia)((LinkedList)localObject1).getFirst();
          }
        }
        localObject4 = ((dji)localObject7).EDC;
        if (localObject4 == null) {}
        for (k = 0;; k = ((dju)localObject4).retryCount)
        {
          localObject4 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (k <= com.tencent.mm.plugin.finder.storage.d.eQD()) {
            break;
          }
          localObject1 = this.GeK;
          localObject4 = f.Gfh;
          localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new f((FinderItem)localObject1, f.fev());
          AppMethodBeat.o(343327);
          return localObject1;
        }
        if ((localObject8 != null) && (localObject1 != null))
        {
          l1 = Util.currentTicks();
          localObject4 = ((dji)localObject7).EDC;
          if (localObject4 != null)
          {
            localObject9 = ((dji)localObject7).EDC;
            if (localObject9 == null)
            {
              k = 0;
              ((dju)localObject4).retryCount = (k + 1);
            }
          }
          else
          {
            feB();
            localObject4 = ((FinderMedia)localObject1).url;
            if (localObject4 != null) {
              break label1200;
            }
            localObject4 = "";
          }
          for (;;)
          {
            if (y.ZC((String)localObject4)) {
              break label1203;
            }
            Log.i(this.TAG, s.X("start process mv, file not exist:", localObject4));
            localObject1 = this.GeK;
            localObject4 = f.Gfh;
            localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new f((FinderItem)localObject1, f.fev());
            AppMethodBeat.o(343327);
            return localObject1;
            k = ((dju)localObject9).retryCount;
            break;
          }
          f1 = ((FinderMedia)localObject1).width;
          f2 = ((FinderMedia)localObject1).height;
          k = ((FinderMedia)localObject1).videoDuration;
          long l2 = ((boq)localObject8).TBO;
          long l3 = l2 + ((boq)localObject8).ZWY;
          localObject10 = MultiMediaVideoChecker.ObB.cI((String)localObject4, true);
          Log.i(this.TAG, "start process mv, size:[" + f1 + ',' + f2 + "], videoDuration:" + k + ", clipRange:[" + l2 + ',' + l3 + "], path:" + (String)localObject4);
          Log.i(this.TAG, s.X("start process mv, videoInfo:", localObject10));
          if (localObject10 == null)
          {
            Log.i(this.TAG, "start process mv, fail to get origin video info");
            localObject1 = this.GeK;
            localObject4 = f.Gfh;
            localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new f((FinderItem)localObject1, f.fev());
            AppMethodBeat.o(343327);
            return localObject1;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          localObject8 = com.tencent.mm.plugin.finder.storage.d.ePV();
          Log.i(this.TAG, s.X("process mv videoParams ", localObject8));
          localObject1 = new FinderMediaReportObject();
          ((FinderMediaReportObject)localObject1).mediaType = ((dji)localObject7).mediaType;
          ((FinderMediaReportObject)localObject1).origin = new FinderMediaReportInfo();
          ((FinderMediaReportObject)localObject1).multiMediaInfo = new LinkedList();
          localObject9 = new FinderMediaReportInfo();
          ((FinderMediaReportInfo)localObject9).fileSize = ((int)y.bEl((String)localObject4));
          ((FinderMediaReportInfo)localObject9).width = ((int)f1);
          ((FinderMediaReportInfo)localObject9).height = ((int)f2);
          ((FinderMediaReportInfo)localObject9).videoBitrate = ((MultiMediaVideoChecker.a)localObject10).bitrate;
          ((FinderMediaReportInfo)localObject9).videoDuration = k;
          ((FinderMediaReportInfo)localObject9).audioBitrate = ((MultiMediaVideoChecker.a)localObject10).audioBitrate;
          ((FinderMediaReportInfo)localObject9).fps = ((int)((MultiMediaVideoChecker.a)localObject10).eGw);
          Log.i(this.TAG, s.X("put multiMediaInfo:", localObject9));
          ((FinderMediaReportObject)localObject1).multiMediaInfo.add(localObject9);
          localObject9 = new com.tencent.mm.plugin.finder.loader.v((dji)localObject7, com.tencent.mm.plugin.finder.storage.v.FLB, 0, null, 12);
          localObject11 = bm.GlZ;
          localObject9 = bm.a((com.tencent.mm.plugin.finder.loader.v)localObject9, String.valueOf(System.currentTimeMillis()));
          localObject11 = new ad((String)localObject4, 2);
          localObject12 = new ac(p.listOf(localObject11));
          ((ac)localObject12).bs(l2, l3);
          localObject4 = new Rect();
          m = ((MultiMediaVideoChecker.a)localObject10).width;
          k = ((MultiMediaVideoChecker.a)localObject10).height;
          if ((((MultiMediaVideoChecker.a)localObject10).hYK != 90) && (((MultiMediaVideoChecker.a)localObject10).hYK != 270)) {
            break label3372;
          }
          m = ((MultiMediaVideoChecker.a)localObject10).height;
          k = ((MultiMediaVideoChecker.a)localObject10).width;
        }
      }
      label2840:
      label3226:
      label3232:
      label3242:
      label3372:
      for (;;)
      {
        ((ad)localObject11).UaF.yok.set(0, 0, m, k);
        ((ac)localObject12).mu(m, k);
        ((Rect)localObject4).set(0, 0, m, k);
        ((ac)localObject12).F((Rect)localObject4);
        ((ac)localObject12).FO(false);
        localObject10 = new com.tencent.mm.plugin.vlog.model.f((ac)localObject12);
        ((com.tencent.mm.plugin.vlog.model.f)localObject10).a((String)localObject9, (VideoTransPara)localObject8, new Size(m, k), (Rect)localObject4, true, true);
        localObject4 = ((com.tencent.mm.plugin.vlog.model.f)localObject10).hQn();
        ((afb)localObject4).TYB.outputPath = ((String)localObject9);
        localObject11 = ((afb)localObject4).TYB;
        localObject12 = new com.tencent.mm.plugin.vlog.model.e();
        ((com.tencent.mm.plugin.vlog.model.e)localObject12).ybL = 3;
        localObject10 = ((dji)localObject7).EDC;
        if (localObject10 == null) {}
        for (k = 0;; k = ((dju)localObject10).retryCount)
        {
          ((com.tencent.mm.plugin.vlog.model.e)localObject12).retryCount = k;
          localObject10 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (com.tencent.mm.plugin.finder.storage.d.ePX()) {
            ((com.tencent.mm.plugin.vlog.model.e)localObject12).a(true, (VideoTransPara)localObject8);
          }
          ((com.tencent.mm.plugin.vlog.model.e)localObject12).aJ((kotlin.g.a.b)new a(new ah.c(), this, i, n));
          final Object localObject13 = new Object();
          final ah.a locala = new ah.a();
          localObject10 = new kotlin.g.b.ah.d();
          ((kotlin.g.b.ah.d)localObject10).aixb = -1;
          f2 = com.tencent.mm.plugin.vlog.model.e.a((com.tencent.mm.plugin.vlog.model.e)localObject12, (afb)localObject4, (kotlin.g.a.b)new b((kotlin.g.b.ah.d)localObject10, this, l1, (FinderMediaReportObject)localObject1, (String)localObject9, (afc)localObject11, (VideoTransPara)localObject8, (afb)localObject4, localObject13, locala));
          try
          {
            if (!locala.aiwY)
            {
              Log.i(this.TAG, "wait");
              localObject13.wait();
              Log.i(this.TAG, s.X("notify ", Integer.valueOf(((kotlin.g.b.ah.d)localObject10).aixb)));
            }
            localObject4 = ah.aiuX;
            localObject4 = MultiMediaVideoChecker.ObB.cI((String)localObject9, true);
            Log.i(this.TAG, "remux finished, ret:" + ((kotlin.g.b.ah.d)localObject10).aixb + ", videoQuality:" + f2 + ", outputVideoInfo:" + localObject4);
            localObject11 = this.GeK.field_reportObject;
            if (localObject11 != null) {
              ((FinderFeedReportObject)localObject11).mpError = ((kotlin.g.b.ah.d)localObject10).aixb;
            }
            feB();
            if ((((kotlin.g.b.ah.d)localObject10).aixb >= 0) && (localObject4 != null) && (((MultiMediaVideoChecker.a)localObject4).width >= 0) && (((MultiMediaVideoChecker.a)localObject4).height >= 0) && (((MultiMediaVideoChecker.a)localObject4).duration >= 0L)) {
              break;
            }
            localObject1 = this.GeK;
            localObject4 = f.Gfh;
            localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new f((FinderItem)localObject1, f.fev());
            AppMethodBeat.o(343327);
            return localObject1;
          }
          finally
          {
            AppMethodBeat.o(343327);
          }
        }
        e(1.0F, i, n);
        ((dji)localObject7).width = ((MultiMediaVideoChecker.a)localObject4).width;
        ((dji)localObject7).height = ((MultiMediaVideoChecker.a)localObject4).height;
        i = ((VideoTransPara)localObject8).oCa;
        k = (int)(((dji)localObject7).height / ((dji)localObject7).width * i);
        localObject10 = com.tencent.mm.plugin.finder.upload.f.GbE.ao((String)localObject9, i, k);
        localObject11 = com.tencent.mm.plugin.finder.storage.d.FAy;
        label2294:
        boolean bool;
        if (com.tencent.mm.plugin.finder.storage.d.eTA())
        {
          localObject11 = com.tencent.mm.plugin.finder.storage.d.FAy;
          k = AdaptiveAdjustBitrate.getVideoImageQuality(com.tencent.mm.plugin.finder.storage.d.ePY(), 0, i, k, 0.8F);
          bool = false;
          if (((c)h.ax(c.class)).a(c.a.zjq, 0) == 1) {
            bool = true;
          }
          f1 = ((VideoTransPara)localObject8).audioBitrate;
          f3 = ((VideoTransPara)localObject8).audioSampleRate;
          i = ((VideoTransPara)localObject8).audioChannelCount;
          s.u(localObject9, "input");
          localObject8 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (!com.tencent.mm.plugin.finder.storage.d.eTA()) {
            break label3137;
          }
          f1 = AdaptiveAdjustBitrate.b((String)localObject9, f1, f3, i, bool, true);
          label2375:
          Log.i(this.TAG, s.X("qipengfeng, audio quality level: ", Float.valueOf(f1)));
          ((dji)localObject7).aaPt = localObject2;
          ((dji)localObject7).url = ((String)localObject9);
          ((dji)localObject7).thumbUrl = ((String)localObject10);
          ((dji)localObject7).aaPf = false;
          ((dji)localObject7).mediaId = MD5Util.getMD5String(((dji)localObject7).url);
          ((dji)localObject7).fileSize = ((int)y.bEl((String)localObject9));
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            ((FinderMediaReportObject)localObject3).target = new FinderMediaReportInfo();
          }
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            break label3142;
          }
          localObject3 = null;
          label2482:
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).fileSize = ((dji)localObject7).fileSize;
          }
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null)
          {
            localObject8 = ((dji)localObject7).aaPt;
            if (localObject8 != null) {
              break label3152;
            }
            i = 0;
            label2524:
            ((FinderMediaReportObject)localObject3).videoFinalSize = i;
          }
          localObject3 = ((dji)localObject7).aaDI;
          if (localObject3 != null) {
            ((afb)localObject3).Znj = false;
          }
          if (((dji)localObject7).codec_info == null) {
            ((dji)localObject7).codec_info = new boy();
          }
          localObject3 = ((dji)localObject7).codec_info;
          if (localObject3 != null)
          {
            ((boy)localObject3).ZXq = f2;
            ((boy)localObject3).ZXs = 0.0F;
            ((boy)localObject3).ZXt = k;
            localObject8 = ((dji)localObject7).aaDI;
            if (localObject8 != null) {
              break label3180;
            }
            i = 0;
            label2616:
            if (i <= 0) {
              break label3226;
            }
            bool = true;
            label2624:
            ((boy)localObject3).ZXv = bool;
            Log.i(this.TAG, "codec_info video_score:" + ((boy)localObject3).ZXq + ",video_cover_score:" + ((boy)localObject3).ZXr + ",video_audio_score:" + ((boy)localObject3).ZXs + ",thumb_score:" + ((boy)localObject3).ZXt + ",hdimg_score:" + ((boy)localObject3).ZXu + ",has_stickers:" + ((boy)localObject3).ZXv);
            localObject3 = ah.aiuX;
          }
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            break label3232;
          }
          localObject3 = null;
          label2749:
          if (localObject3 == null)
          {
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null) {
              ((FinderMediaReportObject)localObject3).codecInfo = ((dji)localObject7).codec_info;
            }
          }
          ((dji)localObject7).videoDuration = kotlin.h.a.eH((float)((MultiMediaVideoChecker.a)localObject4).duration / 1000.0F);
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            break label3242;
          }
          localObject3 = null;
          label2809:
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
          }
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            break label3252;
          }
          localObject3 = null;
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).width = ((MultiMediaVideoChecker.a)localObject4).width;
          }
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            break label3262;
          }
          localObject3 = null;
          label2870:
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).height = ((MultiMediaVideoChecker.a)localObject4).height;
          }
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            break label3272;
          }
          localObject3 = null;
          label2900:
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
          }
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            break label3282;
          }
          localObject3 = null;
          label2930:
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
          }
          localObject3 = ((dji)localObject7).aaPt;
          if (localObject3 != null) {
            break label3292;
          }
        }
        label3137:
        label3142:
        label3152:
        label3282:
        label3292:
        for (Object localObject3 = null;; localObject3 = ((FinderMediaReportObject)localObject3).target)
        {
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).fps = ((int)((MultiMediaVideoChecker.a)localObject4).eGw);
          }
          localObject3 = new LinkedList();
          ((LinkedList)localObject3).add(localObject7);
          localObject4 = ah.aiuX;
          ((FinderItem)localObject6).setMediaList((LinkedList)localObject3);
          localObject3 = ((FinderItem)localObject6).field_reportObject;
          if (localObject3 != null)
          {
            ((FinderFeedReportObject)localObject3).remuxEndTime = cn.bDw();
            ((FinderFeedReportObject)localObject3).remuxType = 2;
            localObject3 = ah.aiuX;
            localObject3 = ah.aiuX;
          }
          Log.i(this.TAG, "processList url " + ((dji)localObject7).url + " thumbUrl: " + ((dji)localObject7).thumbUrl + " newMd5: " + MD5Util.getMD5String(((dji)localObject7).url) + " size:" + Util.getSizeKB(y.bEl(((dji)localObject7).url)));
          feB();
          i = j;
          break;
          k = 0;
          break label2294;
          f1 = 0.0F;
          break label2375;
          localObject3 = ((FinderMediaReportObject)localObject3).target;
          break label2482;
          localObject8 = ((FinderMediaReportObject)localObject8).target;
          if (localObject8 == null)
          {
            i = 0;
            break label2524;
          }
          i = ((FinderMediaReportInfo)localObject8).fileSize;
          break label2524;
          label3180:
          localObject8 = ((afb)localObject8).TYC;
          if (localObject8 == null)
          {
            i = 0;
            break label2616;
          }
          localObject8 = ((afa)localObject8).Znd;
          if (localObject8 == null)
          {
            i = 0;
            break label2616;
          }
          i = ((LinkedList)localObject8).size();
          break label2616;
          bool = false;
          break label2624;
          localObject3 = ((FinderMediaReportObject)localObject3).codecInfo;
          break label2749;
          localObject3 = ((FinderMediaReportObject)localObject3).target;
          break label2809;
          localObject3 = ((FinderMediaReportObject)localObject3).target;
          break label2840;
          localObject3 = ((FinderMediaReportObject)localObject3).target;
          break label2870;
          localObject3 = ((FinderMediaReportObject)localObject3).target;
          break label2900;
          localObject3 = ((FinderMediaReportObject)localObject3).target;
          break label2930;
        }
        label3252:
        label3262:
        label3272:
        Log.i(this.TAG, "error cannot get mvTrack and mvMedia");
        localObject3 = this.GeK;
        localObject4 = f.Gfh;
        localObject3 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new f((FinderItem)localObject3, f.fev());
        AppMethodBeat.o(343327);
        return localObject3;
        localObject3 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new e(this.GeK);
        AppMethodBeat.o(343327);
        return localObject3;
      }
      label3375:
      i = j;
    }
  }
  
  public final int fer()
  {
    return 2;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    a(ah.c paramc, a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<k, ah>
  {
    b(kotlin.g.b.ah.d paramd, a parama, long paramLong, FinderMediaReportObject paramFinderMediaReportObject, String paramString, afc paramafc, VideoTransPara paramVideoTransPara, afb paramafb, Object paramObject, ah.a parama1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.mvstage.a
 * JD-Core Version:    0.7.0.1
 */