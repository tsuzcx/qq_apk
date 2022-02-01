package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ic;
import com.tencent.mm.autogen.a.iq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
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
import com.tencent.mm.sdk.event.IListener;
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
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftMediaProcessStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "cancel", "", "getCancel", "()Z", "setCancel", "(Z)V", "curExporter", "Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "getCurExporter", "()Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "setCurExporter", "(Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;)V", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "draftModifyListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderDraftModifyEvent;", "getDraftModifyListener", "()Lcom/tencent/mm/sdk/event/IListener;", "mainFinderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getMainFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getAudioQualityLevel", "", "input", "bitrate", "samplerate", "channels", "", "enableAuQA", "useOriAu", "getStageType", "onFailed", "", "nextStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "onSuccess", "onWait", "run", "saveToDb", "start", "updateProgress", "avgProgress", "index", "size", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  final com.tencent.mm.plugin.finder.storage.i ABX;
  private final FinderItem GeK;
  com.tencent.mm.plugin.vlog.model.e Gee;
  private final IListener<iq> Gef;
  final String TAG;
  boolean cancel;
  
  public i(com.tencent.mm.plugin.finder.storage.i parami)
  {
    super(j.e(parami));
    AppMethodBeat.i(343042);
    this.ABX = parami;
    this.TAG = "LogPost.MvDraftMediaProcessStage";
    this.GeK = this.ABX.eYK();
    this.Gef = ((IListener)new MvDraftMediaProcessStage.draftModifyListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(343042);
  }
  
  private final void feB()
  {
    AppMethodBeat.i(343103);
    com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    com.tencent.mm.plugin.finder.storage.logic.c.g(this.ABX);
    AppMethodBeat.o(343103);
  }
  
  private final com.tencent.mm.plugin.finder.upload.postlogic.base.e fex()
  {
    AppMethodBeat.i(343097);
    this.GeK.trackPost("mediaProcess");
    Object localObject1 = this.GeK.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 2;
    }
    localObject1 = d.FAy;
    if ((d.eQH()) && (Log.getLogLevel() >= 0))
    {
      Log.i(this.TAG, "debug blocking, sleep.....");
      Thread.sleep(30000L);
    }
    localObject1 = d.FAy;
    Object localObject4;
    if (((Number)d.eQB().bmg()).intValue() == 1)
    {
      localObject1 = this.ABX;
      localObject4 = c.GdZ;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
      AppMethodBeat.o(343097);
      return localObject1;
    }
    localObject1 = j.FKc;
    if (!j.pX(this.ABX.field_localId))
    {
      Log.i(this.TAG, s.X("start but not exist: ", Long.valueOf(this.ABX.field_localId)));
      localObject1 = this.ABX;
      localObject4 = c.GdZ;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.feu());
      AppMethodBeat.o(343097);
      return localObject1;
    }
    localObject1 = this.GeK.getFeedObject().objectDesc;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((FinderObjectDesc)localObject1).mvInfo)
    {
      localObject1 = this.ABX;
      localObject4 = c.GdZ;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
      AppMethodBeat.o(343097);
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
    label338:
    Object localObject6;
    label420:
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label422;
      }
      localObject6 = ((Iterator)localObject5).next();
      if (((boq)localObject6).refObjectId == 0L) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label420;
        }
        ((Collection)localObject1).add(localObject6);
        break label338;
        localObject1 = ((bol)localObject1).ZWI;
        s.s(localObject1, "mvInfo.orderedTrackList");
        localObject1 = (List)localObject1;
        break;
      }
    }
    label422:
    ((LinkedList)localObject4).addAll((Collection)localObject1);
    localObject1 = ((Iterable)localObject4).iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label524;
      }
      localObject5 = (boq)((Iterator)localObject1).next();
      localObject6 = ((Iterable)this.GeK.getClipListExt()).iterator();
      if (((Iterator)localObject6).hasNext()) {
        if (!s.p(((FinderItem)((Iterator)localObject6).next()).getObjectNonceId(), ((boq)localObject5).ZWZ)) {
          break;
        }
      }
    }
    label524:
    Log.i(this.TAG, s.X("processTracks size:", Integer.valueOf(((LinkedList)localObject4).size())));
    final int n = ((LinkedList)localObject4).size();
    Object localObject5 = ((Iterable)localObject4).iterator();
    final int i = 0;
    label662:
    label3487:
    for (;;)
    {
      int j;
      Object localObject8;
      int k;
      label707:
      float f1;
      float f2;
      Object localObject7;
      float f3;
      label891:
      final long l2;
      label953:
      Object localObject9;
      label1276:
      label1279:
      long l3;
      long l1;
      Object localObject10;
      Object localObject11;
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
                break label3774;
              }
              if (localObject8 == null) {
                break label891;
              }
              localObject1 = ((boq)localObject8).ZXf;
              if ((localObject1 == null) || (((LinkedList)localObject1).contains(Integer.valueOf(1)) != true)) {
                break label891;
              }
              k = 1;
              if (k == 0) {
                break label953;
              }
              localObject1 = ((FinderItem)localObject6).getCropInfo(0);
              if (localObject1 != null)
              {
                localObject4 = bm.GlZ;
                localObject4 = bm.a(new n((dji)localObject1, com.tencent.mm.plugin.finder.storage.v.FKY, null, null, 12), String.valueOf(System.currentTimeMillis()));
                f1 = ((dji)localObject1).width;
                f2 = ((dji)localObject1).height;
                localObject7 = d.FAy;
                i = d.eQp();
                localObject7 = d.FAy;
                k = d.eQo();
                f3 = Math.min(i * 1.0F / f1, k * 1.0F / f2);
                if (f3 <= 1.0F) {
                  break label897;
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
          break label662;
          k = 0;
          break label707;
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
          localObject1 = this.ABX;
          localObject4 = c.GdZ;
          localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
          AppMethodBeat.o(343097);
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
          localObject4 = d.FAy;
          if (k <= d.eQD()) {
            break;
          }
          localObject1 = this.ABX;
          localObject4 = c.GdZ;
          localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
          AppMethodBeat.o(343097);
          return localObject1;
        }
        if ((localObject8 != null) && (localObject1 != null))
        {
          l2 = Util.currentTicks();
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
              break label1276;
            }
            localObject4 = "";
          }
          for (;;)
          {
            if (y.ZC((String)localObject4)) {
              break label1279;
            }
            Log.i(this.TAG, s.X("start process mv, file not exist:", localObject4));
            localObject1 = this.ABX;
            localObject4 = c.GdZ;
            localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
            AppMethodBeat.o(343097);
            return localObject1;
            k = ((dju)localObject9).retryCount;
            break;
          }
          f1 = ((FinderMedia)localObject1).width;
          f2 = ((FinderMedia)localObject1).height;
          k = ((FinderMedia)localObject1).videoDuration;
          l3 = ((boq)localObject8).TBO;
          l1 = ((boq)localObject8).ZWY + l3;
          localObject10 = MultiMediaVideoChecker.ObB.cI((String)localObject4, true);
          Log.i(this.TAG, "start process mv, size:[" + f1 + ',' + f2 + "], videoDuration:" + k + ", clipRange:[" + l3 + ',' + l1 + "], path:" + (String)localObject4);
          Log.i(this.TAG, s.X("start process mv, videoInfo:", localObject10));
          if (localObject10 == null)
          {
            Log.i(this.TAG, "start process mv, fail to get origin video info");
            localObject1 = this.ABX;
            localObject4 = c.GdZ;
            localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.fev());
            AppMethodBeat.o(343097);
            return localObject1;
          }
          localObject1 = d.FAy;
          localObject8 = d.ePV();
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
          if (l1 - l3 > 0L) {
            break label3771;
          }
          l1 = Math.min(((ad)localObject11).UaI.UjZ, 300000L) + l3;
          Log.i(this.TAG, "process mv fix duration [" + l3 + ", " + l1 + ']');
        }
      }
      label2601:
      label3116:
      label3771:
      for (;;)
      {
        final Object localObject12 = new ac(p.listOf(localObject11));
        ((ac)localObject12).bs(l3, l1);
        localObject4 = new Rect();
        int m = ((MultiMediaVideoChecker.a)localObject10).width;
        k = ((MultiMediaVideoChecker.a)localObject10).height;
        if ((((MultiMediaVideoChecker.a)localObject10).hYK == 90) || (((MultiMediaVideoChecker.a)localObject10).hYK == 270))
        {
          m = ((MultiMediaVideoChecker.a)localObject10).height;
          k = ((MultiMediaVideoChecker.a)localObject10).width;
        }
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
          localObject10 = ((afb)localObject4).TYB;
          localObject11 = new com.tencent.mm.plugin.vlog.model.e();
          ((com.tencent.mm.plugin.vlog.model.e)localObject11).ybL = 3;
          localObject12 = ((dji)localObject7).EDC;
          if (localObject12 == null) {}
          for (k = 0;; k = ((dju)localObject12).retryCount)
          {
            ((com.tencent.mm.plugin.vlog.model.e)localObject11).retryCount = k;
            localObject12 = d.FAy;
            if (d.ePX()) {
              ((com.tencent.mm.plugin.vlog.model.e)localObject11).a(true, (VideoTransPara)localObject8);
            }
            ((com.tencent.mm.plugin.vlog.model.e)localObject11).aJ((kotlin.g.a.b)new a(new ah.c(), this, i, n));
            this.Gee = ((com.tencent.mm.plugin.vlog.model.e)localObject11);
            if (!this.cancel) {
              break;
            }
            Log.i(this.TAG, "run canceled " + this.ABX.field_localId + ", " + this.ABX.field_objectId);
            localObject1 = this.ABX;
            localObject4 = c.GdZ;
            localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.few());
            AppMethodBeat.o(343097);
            return localObject1;
          }
          localObject12 = new Object();
          final ah.a locala = new ah.a();
          ah.d locald = new ah.d();
          locald.aixb = -1;
          f2 = com.tencent.mm.plugin.vlog.model.e.a((com.tencent.mm.plugin.vlog.model.e)localObject11, (afb)localObject4, (kotlin.g.a.b)new b(locald, this, l2, (FinderMediaReportObject)localObject1, (String)localObject9, (afc)localObject10, (VideoTransPara)localObject8, (afb)localObject4, localObject12, locala));
          try
          {
            if (!locala.aiwY)
            {
              Log.i(this.TAG, "wait");
              localObject12.wait();
              Log.i(this.TAG, s.X("notify ", Integer.valueOf(locald.aixb)));
            }
            localObject4 = ah.aiuX;
            this.Gee = null;
            if (this.cancel)
            {
              Log.i(this.TAG, "run2 canceled " + this.ABX.field_localId + ", " + this.ABX.field_objectId);
              localObject1 = this.ABX;
              localObject4 = c.GdZ;
              localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.few());
              AppMethodBeat.o(343097);
              return localObject1;
            }
          }
          finally
          {
            AppMethodBeat.o(343097);
          }
          localObject4 = MultiMediaVideoChecker.ObB.cI((String)localObject9, true);
          Log.i(this.TAG, "remux finished, ret:" + locald.aixb + ", videoQuality:" + f2 + ", outputVideoInfo:" + localObject4);
          if ((locald.aixb < 0) || (localObject4 == null) || (((MultiMediaVideoChecker.a)localObject4).width < 0) || (((MultiMediaVideoChecker.a)localObject4).height < 0) || (((MultiMediaVideoChecker.a)localObject4).duration < 0L))
          {
            localObject3 = this.ABX;
            localObject4 = c.GdZ;
            localObject3 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject3, c.fev());
            AppMethodBeat.o(343097);
            return localObject3;
          }
          e(1.0F, i, n);
          ((dji)localObject7).width = ((MultiMediaVideoChecker.a)localObject4).width;
          ((dji)localObject7).height = ((MultiMediaVideoChecker.a)localObject4).height;
          i = ((VideoTransPara)localObject8).oCa;
          k = (int)(((dji)localObject7).height / ((dji)localObject7).width * i);
          localObject10 = com.tencent.mm.plugin.finder.upload.f.GbE.ao((String)localObject9, i, k);
          localObject11 = d.FAy;
          boolean bool;
          if (d.eTA())
          {
            localObject11 = d.FAy;
            k = AdaptiveAdjustBitrate.getVideoImageQuality(d.ePY(), 0, i, k, 0.8F);
            bool = false;
            if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjq, 0) == 1) {
              bool = true;
            }
            f1 = ((VideoTransPara)localObject8).audioBitrate;
            f3 = ((VideoTransPara)localObject8).audioSampleRate;
            i = ((VideoTransPara)localObject8).audioChannelCount;
            s.u(localObject9, "input");
            localObject8 = d.FAy;
            if (!d.eTA()) {
              break label3444;
            }
            f1 = AdaptiveAdjustBitrate.b((String)localObject9, f1, f3, i, bool, true);
            label2682:
            Log.i(this.TAG, s.X("qipengfeng, audio quality level: ", Float.valueOf(f1)));
            ((dji)localObject7).aaPt = ((FinderMediaReportObject)localObject3);
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
              break label3449;
            }
            localObject3 = null;
            label2789:
            if (localObject3 != null) {
              ((FinderMediaReportInfo)localObject3).fileSize = ((dji)localObject7).fileSize;
            }
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null)
            {
              localObject8 = ((dji)localObject7).aaPt;
              if (localObject8 != null) {
                break label3459;
              }
              i = 0;
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
                break label3487;
              }
              i = 0;
              label2923:
              if (i <= 0) {
                break label3533;
              }
              bool = true;
              label2931:
              ((boy)localObject3).ZXv = bool;
              Log.i(this.TAG, "codec_info video_score:" + ((boy)localObject3).ZXq + ",video_cover_score:" + ((boy)localObject3).ZXr + ",video_audio_score:" + ((boy)localObject3).ZXs + ",thumb_score:" + ((boy)localObject3).ZXt + ",hdimg_score:" + ((boy)localObject3).ZXu + ",has_stickers:" + ((boy)localObject3).ZXv);
              localObject3 = ah.aiuX;
            }
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null) {
              break label3539;
            }
            localObject3 = null;
            label3056:
            if (localObject3 == null)
            {
              localObject3 = ((dji)localObject7).aaPt;
              if (localObject3 != null) {
                ((FinderMediaReportObject)localObject3).codecInfo = ((dji)localObject7).codec_info;
              }
            }
            ((dji)localObject7).videoDuration = a.eH((float)((MultiMediaVideoChecker.a)localObject4).duration / 1000.0F);
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null) {
              break label3549;
            }
            localObject3 = null;
            if (localObject3 != null) {
              ((FinderMediaReportInfo)localObject3).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
            }
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null) {
              break label3559;
            }
            localObject3 = null;
            label3147:
            if (localObject3 != null) {
              ((FinderMediaReportInfo)localObject3).width = ((MultiMediaVideoChecker.a)localObject4).width;
            }
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null) {
              break label3569;
            }
            localObject3 = null;
            label3177:
            if (localObject3 != null) {
              ((FinderMediaReportInfo)localObject3).height = ((MultiMediaVideoChecker.a)localObject4).height;
            }
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null) {
              break label3579;
            }
            localObject3 = null;
            if (localObject3 != null) {
              ((FinderMediaReportInfo)localObject3).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
            }
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null) {
              break label3589;
            }
            localObject3 = null;
            if (localObject3 != null) {
              ((FinderMediaReportInfo)localObject3).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
            }
            localObject3 = ((dji)localObject7).aaPt;
            if (localObject3 != null) {
              break label3599;
            }
          }
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
            break label2601;
            label3444:
            f1 = 0.0F;
            break label2682;
            label3449:
            localObject3 = ((FinderMediaReportObject)localObject3).target;
            break label2789;
            localObject8 = ((FinderMediaReportObject)localObject8).target;
            if (localObject8 == null)
            {
              i = 0;
              break label2831;
            }
            i = ((FinderMediaReportInfo)localObject8).fileSize;
            break label2831;
            localObject8 = ((afb)localObject8).TYC;
            if (localObject8 == null)
            {
              i = 0;
              break label2923;
            }
            localObject8 = ((afa)localObject8).Znd;
            if (localObject8 == null)
            {
              i = 0;
              break label2923;
            }
            i = ((LinkedList)localObject8).size();
            break label2923;
            label3533:
            bool = false;
            break label2931;
            label3539:
            localObject3 = ((FinderMediaReportObject)localObject3).codecInfo;
            break label3056;
            label3549:
            localObject3 = ((FinderMediaReportObject)localObject3).target;
            break label3116;
            label3559:
            localObject3 = ((FinderMediaReportObject)localObject3).target;
            break label3147;
            label3569:
            localObject3 = ((FinderMediaReportObject)localObject3).target;
            break label3177;
            label3579:
            localObject3 = ((FinderMediaReportObject)localObject3).target;
            break label3207;
            localObject3 = ((FinderMediaReportObject)localObject3).target;
            break label3237;
          }
          Log.i(this.TAG, "error cannot get mvTrack and mvMedia");
          localObject3 = this.ABX;
          localObject4 = c.GdZ;
          localObject3 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject3, c.fev());
          AppMethodBeat.o(343097);
          return localObject3;
          if (this.cancel)
          {
            Log.i(this.TAG, "run3 canceled " + this.ABX.field_localId + ", " + this.ABX.field_objectId);
            localObject3 = this.ABX;
            localObject4 = c.GdZ;
            localObject3 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((com.tencent.mm.plugin.finder.storage.i)localObject3, c.few());
            AppMethodBeat.o(343097);
            return localObject3;
          }
          localObject3 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new k(this.ABX);
          AppMethodBeat.o(343097);
          return localObject3;
        }
      }
      label3237:
      label3774:
      i = j;
    }
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343128);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343128);
  }
  
  public final void e(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(343121);
    if (paramFloat > 1.0F) {}
    for (float f = 1.0F;; f = paramFloat)
    {
      f *= (1.0F + paramInt1) / paramInt2;
      Object localObject = d.FAy;
      int i = (int)(d.eQF() * f);
      Log.i(this.TAG, "feed " + this.ABX.field_localId + " updateProgress " + paramFloat + ", " + f + ", " + i + ", index:" + paramInt1 + ", size:" + paramInt2);
      if (this.GeK.getPostInfo().aaPw < i)
      {
        this.GeK.getPostInfo().aaPw = i;
        feB();
      }
      localObject = new ic();
      ((ic)localObject).hJy.localId = this.ABX.field_localId;
      ((ic)localObject).hJy.progress = this.GeK.getPostInfo().aaPw;
      ((ic)localObject).publish();
      AppMethodBeat.o(343121);
      return;
    }
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343135);
    s.u(parame, "nextStage");
    parame = i.c.FoQ;
    i.c.tF(this.GeK.isLongVideo());
    AppMethodBeat.o(343135);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343139);
    s.u(parame, "nextStage");
    parame = i.c.FoQ;
    i.c.tF(this.GeK.isLongVideo());
    AppMethodBeat.o(343139);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    AppMethodBeat.i(343111);
    this.Gef.alive();
    com.tencent.mm.plugin.finder.upload.postlogic.base.e locale = fex();
    this.Gef.dead();
    AppMethodBeat.o(343111);
    return locale;
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
    a(ah.c paramc, i parami, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.vlog.model.k, ah>
  {
    b(ah.d paramd, i parami, long paramLong, FinderMediaReportObject paramFinderMediaReportObject, String paramString, afc paramafc, VideoTransPara paramVideoTransPara, afb paramafb, Object paramObject, ah.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.i
 * JD-Core Version:    0.7.0.1
 */