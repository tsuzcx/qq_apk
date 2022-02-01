package com.tencent.mm.plugin.finder.upload;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.g.a.he;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.o.b;
import com.tencent.mm.plugin.finder.report.o.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.dqr;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.q;
import d.g.b.y.a;
import d.g.b.y.c;
import d.g.b.y.d;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "call", "", "exportMedia", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "remuxComposition", "Lkotlin/Pair;", "", "", "startRemuxerTick", "", "index", "outputPath", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", "bitrate", "localFinderMedia", "musicPath", "mixType", "onUpdateProgress", "Lkotlin/Function1;", "uniqueId", "updateMedia", "localMedia", "reportObject", "audioQuality", "videoQuality", "updateProgress", "avgProgress", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "Finder.LogPost.FinderMediaProcessTask";
  public static final a sTS;
  FinderItem sTR;
  
  static
  {
    AppMethodBeat.i(167735);
    sTS = new a((byte)0);
    TAG = "Finder.LogPost.FinderMediaProcessTask";
    AppMethodBeat.o(167735);
  }
  
  public c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167734);
    this.sTR = paramFinderItem;
    AppMethodBeat.o(167734);
  }
  
  private final int a(final long paramLong, final int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, final int paramInt5, int paramInt6, final VideoTransPara paramVideoTransPara, bvz parambvz, final FinderMediaReportObject paramFinderMediaReportObject, String paramString2, int paramInt7, d.g.a.b<? super Float, z> paramb)
  {
    AppMethodBeat.i(204944);
    locald = new y.d();
    locald.NiW = -1;
    localObject4 = new Object();
    final y.a locala = new y.a();
    locala.NiT = false;
    for (;;)
    {
      try
      {
        Object localObject2 = parambvz.url;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = parambvz.stz;
        if (localObject2 != null)
        {
          localObject3 = ((bwj)localObject2).Hjn;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = new dwz();
        }
        localObject2 = a.a((dwz)localObject2);
        int i = paramVideoTransPara.audioBitrate;
        int j = paramVideoTransPara.audioSampleRate;
        int k = paramVideoTransPara.audioChannelCount;
        int m = paramVideoTransPara.fps;
        Object localObject3 = parambvz.stz;
        if (localObject3 != null)
        {
          l1 = ((bwj)localObject3).dez;
          parambvz = parambvz.stz;
          if (parambvz == null) {
            continue;
          }
          l2 = parambvz.hwE;
          paramString1 = new com.tencent.mm.plugin.finder.video.l(paramString2, (String)localObject1, paramInt7, paramString1, (Rect)localObject2, paramInt4, paramInt5, paramInt6, i, j, k, m, l1, l2, paramVideoTransPara.hpl, (d.g.a.b)new e(paramb), (d.g.a.b)new f(this, locald, paramInt1, paramFinderMediaReportObject, paramLong, paramInt4, paramInt5, paramVideoTransPara, localObject4, locala), paramInt2, paramInt3);
          paramString1.aue();
        }
      }
      catch (Throwable paramString1)
      {
        long l1;
        long l2;
        ae.printErrStackTrace(TAG, paramString1, "create remuxer failed", new Object[0]);
        paramString1 = o.b.sAp;
        o.b.cFD();
        a(com.tencent.mm.loader.g.j.hiz);
        paramInt1 = locald.NiW;
        AppMethodBeat.o(204944);
        return paramInt1;
      }
      try
      {
        if (!locala.NiT)
        {
          ae.i(TAG, "wait ".concat(String.valueOf(paramInt1)));
          localObject4.wait();
          ae.i(TAG, "notify " + paramInt1 + ", " + locald.NiW);
        }
        paramString1 = z.Nhr;
        paramInt1 = locald.NiW;
        AppMethodBeat.o(204944);
        return paramInt1;
      }
      finally
      {
        AppMethodBeat.o(204944);
      }
      l1 = 0L;
      continue;
      l2 = 0L;
    }
  }
  
  private final d.o<Integer, Float> a(final long paramLong, final int paramInt, String paramString, final VideoTransPara paramVideoTransPara, final bvz parambvz, final FinderMediaReportObject paramFinderMediaReportObject)
  {
    AppMethodBeat.i(204945);
    ae.i(TAG, "remuxComposition outputPath:".concat(String.valueOf(paramString)));
    Object localObject2 = parambvz.HiW;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new aaq();
    }
    d.g.b.p.g(localObject1, "media.videoCompositionInfo ?: CompositionInfo()");
    final y.d locald = new y.d();
    locald.NiW = -1;
    if (localObject1 != null)
    {
      localObject3 = ((aaq)localObject1).BWx;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = new aar();
    }
    ((aar)localObject2).pYH = paramString;
    localObject3 = new Object();
    final y.a locala = new y.a();
    locala.NiT = false;
    com.tencent.mm.plugin.vlog.model.d locald1 = new com.tencent.mm.plugin.vlog.model.d();
    parambvz = parambvz.stz;
    if (parambvz != null) {}
    for (int i = parambvz.retryCount;; i = 0)
    {
      locald1.retryCount = i;
      locald1.vOG = true;
      parambvz = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cGW()) {
        locald1.r(paramVideoTransPara);
      }
      parambvz = new y.c();
      parambvz.NiV = 0.0F;
      parambvz = (d.g.a.b)new c(this, parambvz);
      d.g.b.p.h(parambvz, "callback");
      locald1.BWt = parambvz;
      float f = locald1.a((aaq)localObject1, (d.g.a.b)new d(this, locald, paramInt, paramFinderMediaReportObject, paramLong, paramString, (aar)localObject2, paramVideoTransPara, (aaq)localObject1, localObject3, locala));
      try
      {
        if (!locala.NiT)
        {
          ae.i(TAG, "wait ".concat(String.valueOf(paramInt)));
          localObject3.wait();
          ae.i(TAG, "notify " + paramInt + ", " + locald.NiW);
        }
        paramString = z.Nhr;
        paramString = new d.o(Integer.valueOf(locald.NiW), Float.valueOf(f));
        AppMethodBeat.o(204945);
        return paramString;
      }
      finally
      {
        AppMethodBeat.o(204945);
      }
    }
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(167732);
    long l = this.sTR.getLocalId();
    AppMethodBeat.o(167732);
    return String.valueOf(l);
  }
  
  public final void bc(float paramFloat)
  {
    AppMethodBeat.i(167733);
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i = (int)(com.tencent.mm.plugin.finder.storage.b.cHs() * f);
    ae.i(TAG, "feed " + this.sTR.getLocalId() + " updateProgress  " + f + ", " + i);
    if (this.sTR.getPostInfo().Hjb < i)
    {
      this.sTR.getPostInfo().Hjb = i;
      localObject = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      com.tencent.mm.plugin.finder.storage.logic.b.a.i(this.sTR);
    }
    localObject = com.tencent.mm.sdk.b.a.IvT;
    he localhe = new he();
    localhe.duD.doE = this.sTR.getLocalId();
    localhe.duD.progress = this.sTR.getPostInfo().Hjb;
    ((com.tencent.mm.sdk.b.a)localObject).l((com.tencent.mm.sdk.b.b)localhe);
    AppMethodBeat.o(167733);
  }
  
  public final void call()
  {
    AppMethodBeat.i(167731);
    this.sTR.trackPost("mediaProcess");
    Object localObject1 = this.sTR.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 2;
    }
    Object localObject5 = (List)new ArrayList();
    localObject1 = (Iterable)this.sTR.getMediaList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.gkd();
      }
      localObject3 = (bvz)localObject3;
      if ((this.sTR.isNeedCrop(i)) && (this.sTR.getCropInfo(i) != null)) {
        ((List)localObject5).add(localObject3);
      }
      if ((this.sTR.isNeedVideoCompositionPlay(i)) && (this.sTR.getCropInfo(i) != null)) {
        ((List)localObject5).add(localObject3);
      }
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((com.tencent.mm.plugin.finder.storage.b.cHu()) && (ae.getLogLevel() >= 0))
    {
      ae.i(TAG, "debug blocking, sleep.....");
      Thread.sleep(30000L);
    }
    if (((List)localObject5).size() <= 0)
    {
      ae.i(TAG, "nothing need to be processed");
      bc(1.0F);
      a(com.tencent.mm.loader.g.j.hiy);
      AppMethodBeat.o(167731);
      return;
    }
    ae.i(TAG, "process media count " + ((List)localObject5).size());
    localObject1 = o.c.sAI;
    o.c.cFM();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    final VideoTransPara localVideoTransPara = com.tencent.mm.plugin.finder.storage.b.cGU();
    ae.i(TAG, "FinderMediaProcessTask videoParams ".concat(String.valueOf(localVideoTransPara)));
    Iterator localIterator = ((Iterable)localObject5).iterator();
    final int j = 0;
    int m;
    bvz localbvz;
    boolean bool5;
    Object localObject7;
    Object localObject6;
    Object localObject4;
    label745:
    label756:
    long l2;
    int n;
    int i1;
    int i2;
    int i3;
    label963:
    label1007:
    boolean bool4;
    label1044:
    label1069:
    label1103:
    Object localObject8;
    label1176:
    label1237:
    boolean bool2;
    float f3;
    float f4;
    int i7;
    boolean bool3;
    label1337:
    float f2;
    int k;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      m = j + 1;
      if (j < 0) {
        d.a.j.gkd();
      }
      localbvz = (bvz)localObject1;
      localObject1 = localbvz.stz;
      if (localObject1 != null) {}
      for (i = ((bwj)localObject1).retryCount;; i = 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (i <= com.tencent.mm.plugin.finder.storage.b.cHq()) {
          break;
        }
        a(com.tencent.mm.loader.g.j.hiz);
        AppMethodBeat.o(167731);
        return;
      }
      localObject1 = localbvz.stz;
      if (localObject1 != null)
      {
        localObject3 = localbvz.stz;
        if (localObject3 == null) {
          break label745;
        }
      }
      for (i = ((bwj)localObject3).retryCount;; i = 0)
      {
        ((bwj)localObject1).retryCount = (i + 1);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        com.tencent.mm.plugin.finder.storage.logic.b.a.i(this.sTR);
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        bool5 = com.tencent.mm.plugin.finder.utils.p.d(localbvz);
        localObject7 = new FinderMediaReportObject();
        ((FinderMediaReportObject)localObject7).mediaType = localbvz.mediaType;
        ((FinderMediaReportObject)localObject7).origin = new FinderMediaReportInfo();
        ((FinderMediaReportObject)localObject7).multiMediaInfo = new LinkedList();
        localObject1 = localbvz.HiW;
        if (localObject1 == null) {
          break label756;
        }
        localObject1 = ((aaq)localObject1).GrU;
        if (localObject1 == null) {
          break label756;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject6 = (dpj)((Iterator)localObject1).next();
          localObject3 = new FinderMediaReportInfo();
          ((FinderMediaReportInfo)localObject3).fileSize = ((int)com.tencent.mm.vfs.o.aZR(((dpj)localObject6).path));
          localObject4 = MultiMediaVideoChecker.BXt;
          localObject6 = ((dpj)localObject6).path;
          d.g.b.p.g(localObject6, "track.path");
          localObject4 = ((MultiMediaVideoChecker)localObject4).aED((String)localObject6);
          if (localObject4 != null)
          {
            ((FinderMediaReportInfo)localObject3).width = ((MultiMediaVideoChecker.a)localObject4).width;
            ((FinderMediaReportInfo)localObject3).height = ((MultiMediaVideoChecker.a)localObject4).height;
            ((FinderMediaReportInfo)localObject3).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
            ((FinderMediaReportInfo)localObject3).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
            ((FinderMediaReportInfo)localObject3).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
            ((FinderMediaReportInfo)localObject3).fps = ((int)((MultiMediaVideoChecker.a)localObject4).cwp);
            ae.i(TAG, "put multiMediaInfo:".concat(String.valueOf(localObject4)));
            localObject4 = z.Nhr;
          }
          ((FinderMediaReportObject)localObject7).multiMediaInfo.add(localObject3);
        }
      }
      localObject1 = z.Nhr;
      l2 = bu.HQ();
      localObject1 = new m(localbvz, com.tencent.mm.plugin.finder.storage.r.sJH, 0, null, 12);
      localObject3 = com.tencent.mm.plugin.finder.utils.r.sYn;
      localObject6 = com.tencent.mm.plugin.finder.utils.r.a((m)localObject1, String.valueOf(this.sTR.getCreateTime()));
      localObject4 = null;
      n = 1;
      i1 = 2;
      i2 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIf, 0);
      i3 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qPn, 1);
      localObject1 = localbvz.HiW;
      if (localObject1 != null)
      {
        localObject1 = ((aaq)localObject1).GrU;
        if (localObject1 != null)
        {
          localObject1 = (dpj)d.a.j.jm((List)localObject1);
          localObject3 = localbvz.HiW;
          if (localObject3 == null) {
            break label3890;
          }
          localObject3 = ((aaq)localObject3).GrU;
          if ((localObject3 == null) || (((LinkedList)localObject3).size() != 1)) {
            break label3890;
          }
          localObject3 = localbvz.HiW;
          if (localObject3 == null) {
            break label3866;
          }
          localObject3 = ((aaq)localObject3).BWy;
          if (localObject3 == null) {
            break label3866;
          }
          localObject3 = ((aap)localObject3).GrR;
          if (localObject3 == null) {
            break label3866;
          }
          i = ((LinkedList)localObject3).size();
          if (i != 0) {
            break label3890;
          }
          localObject3 = localbvz.HiW;
          if ((localObject3 == null) || (((aaq)localObject3).BXL)) {
            break label3890;
          }
          localObject3 = localbvz.HiW;
          if (localObject3 == null) {
            break label3872;
          }
          localObject3 = ((aaq)localObject3).GrZ;
          if ((localObject3 != null) || (localObject1 == null)) {
            break label3890;
          }
          if (((dpj)localObject1).HWK != null)
          {
            localObject3 = ((dpj)localObject1).HWK;
            if (localObject3 == null) {
              break label3878;
            }
            localObject3 = ((dqr)localObject3).path;
            localObject3 = (CharSequence)localObject3;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label3884;
            }
            i = 1;
            if (i == 0) {
              break label3890;
            }
          }
          if (((dpj)localObject1).hlm - ((dpj)localObject1).startTimeMs != ((dpj)localObject1).HWI - ((dpj)localObject1).HWH) {
            break label3890;
          }
          bool4 = true;
          localObject3 = TAG;
          localObject8 = new StringBuilder("process: config: ").append(i2).append(", checkNoNeedRemux:").append(i3).append(", trackSize: ");
          localObject1 = localbvz.HiW;
          if (localObject1 == null) {
            break label3896;
          }
          localObject1 = ((aaq)localObject1).GrU;
          if (localObject1 == null) {
            break label3896;
          }
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
          localObject8 = ((StringBuilder)localObject8).append(localObject1).append(", editSize: ");
          localObject1 = localbvz.HiW;
          if (localObject1 == null) {
            break label3902;
          }
          localObject1 = ((aaq)localObject1).BWy;
          if (localObject1 == null) {
            break label3902;
          }
          localObject1 = ((aap)localObject1).GrR;
          if (localObject1 == null) {
            break label3902;
          }
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
          ae.i((String)localObject3, localObject1 + ", videoIsNoEffect:" + bool4);
          bool2 = false;
          if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qKS, 0) == 1) {
            bool2 = true;
          }
          f3 = localVideoTransPara.audioBitrate / 1000.0F;
          f4 = localVideoTransPara.audioSampleRate;
          i7 = localVideoTransPara.audioChannelCount;
          localObject1 = localbvz.HiW;
          if (localObject1 == null) {
            break label3908;
          }
          bool3 = ((aaq)localObject1).BXK;
          f2 = 0.0F;
          k = i1;
          if (i3 == 1)
          {
            k = i1;
            if (bool4)
            {
              localObject1 = localbvz.HiW;
              if (localObject1 != null)
              {
                localObject1 = ((aaq)localObject1).GrU;
                if (localObject1 != null)
                {
                  localObject1 = (dpj)((LinkedList)localObject1).get(0);
                  if (localObject1 != null) {
                    break label6752;
                  }
                }
              }
              localObject1 = new dpj();
            }
          }
        }
      }
    }
    label1478:
    label2911:
    label6752:
    for (;;)
    {
      d.g.b.p.g(localObject1, "it.videoCompositionInfo?…et(0) ?: TrackInfoProto()");
      localObject3 = MultiMediaVideoChecker.BXt;
      localObject8 = ((dpj)localObject1).path;
      d.g.b.p.g(localObject8, "track.path");
      localObject3 = ((MultiMediaVideoChecker)localObject3).aED((String)localObject8);
      label1510:
      boolean bool1;
      long l1;
      label2273:
      float f1;
      if (localObject3 != null) {
        if ((((MultiMediaVideoChecker.a)localObject3).dHi == 90) || (((MultiMediaVideoChecker.a)localObject3).dHi == 270))
        {
          i = ((MultiMediaVideoChecker.a)localObject3).height;
          double d = i;
          if ((((MultiMediaVideoChecker.a)localObject3).dHi != 90) && (((MultiMediaVideoChecker.a)localObject3).dHi != 270)) {
            break label3924;
          }
          i = ((MultiMediaVideoChecker.a)localObject3).width;
          d = 1.0D * d / i;
          ae.i(TAG, "origin videoInfo:" + localObject3 + ", videoParams:" + localVideoTransPara + ", videoRatio:" + d);
          localObject8 = TAG;
          localObject9 = new StringBuilder("videoRatio in range:");
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
          localObject9 = ((StringBuilder)localObject9).append(com.tencent.mm.plugin.finder.storage.b.cIH().contains((Comparable)Double.valueOf(d))).append(", finderVideoRatioRange:");
          localb = com.tencent.mm.plugin.finder.storage.b.sHP;
          ae.i((String)localObject8, com.tencent.mm.plugin.finder.storage.b.cIH());
          if ((((MultiMediaVideoChecker.a)localObject3).wfj) || (((MultiMediaVideoChecker.a)localObject3).bitrate > localVideoTransPara.videoBitrate) || (((MultiMediaVideoChecker.a)localObject3).cwp > localVideoTransPara.fps)) {
            break label3934;
          }
          localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (!com.tencent.mm.plugin.finder.storage.b.cIH().contains((Comparable)Double.valueOf(d))) {
            break label3934;
          }
          bool1 = true;
          localObject3 = localbvz.HiW;
          if (localObject3 == null) {
            break label3946;
          }
          localObject3 = ((aaq)localObject3).hoZ;
          boolean bool6 = bu.isNullOrNil((String)localObject3);
          ae.i(TAG, "isVideoSizeMatch:" + bool1 + "， noMusic:" + bool6);
          k = i1;
          if (bool1)
          {
            k = i1;
            if (bool6)
            {
              localObject3 = new Rect();
              localObject8 = new Rect();
              localObject9 = ((dpj)localObject1).HWJ.Gup;
              d.g.b.p.g(localObject9, "track.cropInfo.cropRect");
              com.tencent.mm.plugin.vlog.model.f.a((csy)localObject9, (Rect)localObject3);
              localObject9 = ((dpj)localObject1).HWJ.Gur;
              d.g.b.p.g(localObject9, "track.cropInfo.contentRect");
              com.tencent.mm.plugin.vlog.model.f.a((csy)localObject9, (Rect)localObject8);
              ae.i(TAG, "cropRect:" + localObject3 + ", contentRect:" + localObject8 + ", track:[" + ((dpj)localObject1).HWH + ", " + ((dpj)localObject1).HWI + ", " + ((dpj)localObject1).Cec + ']');
              k = i1;
              if (((dpj)localObject1).HWH == 0L)
              {
                k = i1;
                if (((dpj)localObject1).Cec - ((dpj)localObject1).HWI <= 10L)
                {
                  k = i1;
                  if (((dpj)localObject1).Cec <= localVideoTransPara.duration * 1000)
                  {
                    k = i1;
                    if (d.g.b.p.i(localObject3, localObject8))
                    {
                      ae.i(TAG, "no need remux!!!");
                      k = 3;
                      com.tencent.mm.vfs.o.mF(((dpj)localObject1).path, (String)localObject6);
                      localObject1 = o.b.sAp;
                      o.b.cFF();
                    }
                  }
                }
              }
            }
          }
          if (k == 3) {
            break label6743;
          }
          localObject1 = localbvz.HiW;
          if (localObject1 != null)
          {
            localObject1 = ((aaq)localObject1).GrU;
            if (localObject1 != null)
            {
              localObject1 = (dpj)((LinkedList)localObject1).get(0);
              if (localObject1 != null) {
                break label6740;
              }
            }
          }
          localObject1 = new dpj();
          d.g.b.p.g(localObject1, "it.videoCompositionInfo?…et(0) ?: TrackInfoProto()");
          if (!bool4) {
            break label6734;
          }
          localObject3 = new Rect();
          localObject8 = new Rect();
          localObject9 = ((dpj)localObject1).HWJ.Gup;
          d.g.b.p.g(localObject9, "track.cropInfo.cropRect");
          com.tencent.mm.plugin.vlog.model.f.a((csy)localObject9, (Rect)localObject3);
          localObject9 = ((dpj)localObject1).HWJ.Gur;
          d.g.b.p.g(localObject9, "track.cropInfo.contentRect");
          com.tencent.mm.plugin.vlog.model.f.a((csy)localObject9, (Rect)localObject8);
          bool1 = ((Rect)localObject8).contains((Rect)localObject3);
          ae.i(TAG, "process: crop: " + localObject3 + ", content: " + localObject8);
          if ((i2 != 1) || (!bool4) || (!bool1)) {
            break label6723;
          }
          ae.i(TAG, "process, force use normal video");
          i1 = SightVideoJNI.getMp4RotateVFS(((dpj)localObject1).path);
          localObject3 = localbvz.stz;
          if (localObject3 != null)
          {
            localObject4 = localbvz.HiW;
            if (localObject4 == null) {
              break label3952;
            }
            l1 = ((aaq)localObject4).GrV;
            ((bwj)localObject3).dez = ((int)(l1 + ((dpj)localObject1).HWH));
          }
          localObject3 = localbvz.stz;
          if (localObject3 != null)
          {
            localObject4 = localbvz.HiW;
            if (localObject4 == null) {
              break label3958;
            }
            l1 = ((aaq)localObject4).GrW;
            ((bwj)localObject3).hwE = ((int)(l1 + ((dpj)localObject1).HWH));
          }
          f1 = ((dpj)localObject1).BXQ;
          f2 = ((dpj)localObject1).BXS;
          i = ((Number)((dpj)localObject1).HWJ.Gur.Hme.get(2)).intValue();
          localObject3 = ((dpj)localObject1).HWJ.Gur.Hme.get(0);
          d.g.b.p.g(localObject3, "track.cropInfo.contentRect.values[0]");
          f1 = 1.0F * (f1 * f2) / (i - ((Number)localObject3).intValue());
          localObject3 = new dwz();
          i = ((Number)((dpj)localObject1).HWJ.Gup.Hme.get(0)).intValue();
          localObject4 = ((dpj)localObject1).HWJ.Gur.Hme.get(0);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[0]");
          ((dwz)localObject3).left = ((int)((i - ((Number)localObject4).intValue()) * f1));
          i = ((Number)((dpj)localObject1).HWJ.Gup.Hme.get(1)).intValue();
          localObject4 = ((dpj)localObject1).HWJ.Gur.Hme.get(1);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[1]");
          ((dwz)localObject3).bottom = ((int)((i - ((Number)localObject4).intValue()) * f1));
          i = ((Number)((dpj)localObject1).HWJ.Gup.Hme.get(2)).intValue();
          localObject4 = ((dpj)localObject1).HWJ.Gur.Hme.get(0);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[0]");
          ((dwz)localObject3).right = ((int)((i - ((Number)localObject4).intValue()) * f1));
          i = ((Number)((dpj)localObject1).HWJ.Gup.Hme.get(3)).intValue();
          localObject4 = ((dpj)localObject1).HWJ.Gur.Hme.get(1);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[1]");
          ((dwz)localObject3).top = ((int)((i - ((Number)localObject4).intValue()) * f1));
          localObject4 = z.Nhr;
          localObject4 = localbvz.stz;
          if (localObject4 != null) {
            ((bwj)localObject4).Hjn = ((dwz)localObject3);
          }
          i = ((Number)((dpj)localObject1).HWJ.Gur.Hme.get(2)).intValue();
          localObject4 = ((dpj)localObject1).HWJ.Gur.Hme.get(0);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[0]");
          i2 = (int)((i - ((Number)localObject4).intValue()) * f1);
          i = ((Number)((dpj)localObject1).HWJ.Gur.Hme.get(3)).intValue();
          localObject4 = ((dpj)localObject1).HWJ.Gur.Hme.get(1);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[1]");
          i3 = (int)((i - ((Number)localObject4).intValue()) * f1);
          localObject4 = localbvz.stz;
          if (localObject4 == null) {
            break label3964;
          }
          localObject4 = ((bwj)localObject4).Hjn;
          if (localObject4 == null) {
            break label3964;
          }
          i = ((dwz)localObject4).right;
          localObject4 = localbvz.stz;
          if (localObject4 == null) {
            break label3970;
          }
          localObject4 = ((bwj)localObject4).Hjn;
          if (localObject4 == null) {
            break label3970;
          }
          n = ((dwz)localObject4).left;
          f1 = i - n;
          localObject4 = localbvz.HiW;
          if (localObject4 == null) {
            break label3976;
          }
          localObject4 = ((aaq)localObject4).BWx;
          if (localObject4 == null) {
            break label3976;
          }
          i = ((aar)localObject4).targetWidth;
          f2 = 1.0F * f1 / i;
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          localObject4 = localbvz.stz;
          if (localObject4 != null)
          {
            localObject8 = localbvz.HiW;
            if (localObject8 == null) {
              break label3982;
            }
            localObject8 = ((aaq)localObject8).BWx;
            if (localObject8 == null) {
              break label3982;
            }
            i = ((aar)localObject8).targetWidth;
            ((bwj)localObject4).width = ((int)(i * f1));
          }
          localObject4 = localbvz.stz;
          if (localObject4 != null)
          {
            localObject8 = localbvz.HiW;
            if (localObject8 == null) {
              break label3988;
            }
            localObject8 = ((aaq)localObject8).BWx;
            if (localObject8 == null) {
              break label3988;
            }
            i = ((aar)localObject8).targetHeight;
            label3067:
            ((bwj)localObject4).height = ((int)(f1 * i));
          }
          if (i1 != 90) {
            break label3994;
          }
          localObject4 = new dwz();
          ((dwz)localObject4).left = ((dwz)localObject3).bottom;
          ((dwz)localObject4).top = ((dwz)localObject3).right;
          ((dwz)localObject4).right = ((dwz)localObject3).top;
          ((dwz)localObject4).bottom = ((dwz)localObject3).left;
          localObject3 = localbvz.stz;
          if (localObject3 != null) {
            ((bwj)localObject3).Hjn = ((dwz)localObject4);
          }
          localbvz.url = ((dpj)localObject1).path;
          localObject1 = localbvz.HiW;
          if (localObject1 != null)
          {
            localObject3 = ((aaq)localObject1).hoZ;
            localObject1 = localObject3;
            if (localObject3 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          localObject3 = localbvz.HiW;
          if (localObject3 == null) {
            break label4176;
          }
          bool1 = ((aaq)localObject3).BXK;
          if (bu.isNullOrNil((String)localObject1)) {
            break label4182;
          }
          i = 1;
          if (!bool1) {
            break label4194;
          }
          if (i == 0) {
            break label4188;
          }
          i = 3;
          localObject4 = TAG;
          localObject8 = new StringBuilder("process, time: [");
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label4211;
          }
          localObject3 = Integer.valueOf(((bwj)localObject3).dez);
          localObject8 = ((StringBuilder)localObject8).append(localObject3).append(", ");
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label4217;
          }
          localObject3 = Integer.valueOf(((bwj)localObject3).hwE);
          label3313:
          localObject8 = ((StringBuilder)localObject8).append(localObject3).append("], size: [");
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label4223;
          }
          localObject3 = Integer.valueOf(((bwj)localObject3).width);
          localObject8 = ((StringBuilder)localObject8).append(localObject3).append(", ");
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label4229;
          }
          localObject3 = Integer.valueOf(((bwj)localObject3).height);
          localObject8 = ((StringBuilder)localObject8).append(localObject3).append("], crop: [");
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label4235;
          }
          localObject3 = ((bwj)localObject3).Hjn;
          if (localObject3 == null) {
            break label4235;
          }
          localObject3 = Integer.valueOf(((dwz)localObject3).left);
          label3435:
          localObject8 = ((StringBuilder)localObject8).append(localObject3).append(", ");
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label4241;
          }
          localObject3 = ((bwj)localObject3).Hjn;
          if (localObject3 == null) {
            break label4241;
          }
          localObject3 = Integer.valueOf(((dwz)localObject3).top);
          localObject8 = ((StringBuilder)localObject8).append(localObject3).append(", ");
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label4247;
          }
          localObject3 = ((bwj)localObject3).Hjn;
          if (localObject3 == null) {
            break label4247;
          }
          localObject3 = Integer.valueOf(((dwz)localObject3).right);
          localObject8 = ((StringBuilder)localObject8).append(localObject3).append(", ");
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label4253;
          }
          localObject3 = ((bwj)localObject3).Hjn;
          if (localObject3 == null) {
            break label4253;
          }
        }
      }
      for (localObject3 = Integer.valueOf(((dwz)localObject3).bottom);; localObject3 = null)
      {
        ae.i((String)localObject4, localObject3 + "], mixType: " + i);
        bool1 = true;
        n = i;
        if (!bool1) {
          break label6307;
        }
        localObject3 = ((FinderMediaReportObject)localObject7).origin;
        if (localObject3 != null) {
          ((FinderMediaReportInfo)localObject3).fileSize = ((int)com.tencent.mm.vfs.o.aZR(localbvz.url));
        }
        localObject8 = MultiMediaVideoChecker.BXt;
        localObject4 = localbvz.url;
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
        localObject8 = ((MultiMediaVideoChecker)localObject8).aED((String)localObject3);
        i1 = 0;
        i2 = 0;
        if (localObject8 != null)
        {
          localObject3 = ((FinderMediaReportObject)localObject7).origin;
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject8).duration);
          }
          localObject3 = ((FinderMediaReportObject)localObject7).origin;
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).width = ((MultiMediaVideoChecker.a)localObject8).width;
          }
          localObject3 = ((FinderMediaReportObject)localObject7).origin;
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).height = ((MultiMediaVideoChecker.a)localObject8).height;
          }
          localObject3 = ((FinderMediaReportObject)localObject7).origin;
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).videoBitrate = ((MultiMediaVideoChecker.a)localObject8).bitrate;
          }
          localObject3 = ((FinderMediaReportObject)localObject7).origin;
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).audioBitrate = ((MultiMediaVideoChecker.a)localObject8).audioBitrate;
          }
          localObject3 = ((FinderMediaReportObject)localObject7).origin;
          if (localObject3 != null) {
            ((FinderMediaReportInfo)localObject3).fps = ((int)((MultiMediaVideoChecker.a)localObject8).cwp);
          }
          i1 = ((MultiMediaVideoChecker.a)localObject8).width;
          i2 = ((MultiMediaVideoChecker.a)localObject8).height;
          localObject3 = z.Nhr;
        }
        if (localObject8 != null) {
          break label4259;
        }
        a(com.tencent.mm.loader.g.j.hiz);
        AppMethodBeat.o(167731);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label963;
        localObject3 = null;
        break label1007;
        localObject3 = null;
        break label1044;
        i = 0;
        break label1069;
        bool4 = false;
        break label1103;
        localObject1 = null;
        break label1176;
        localObject1 = null;
        break label1237;
        bool3 = false;
        break label1337;
        i = ((MultiMediaVideoChecker.a)localObject3).width;
        break label1478;
        i = ((MultiMediaVideoChecker.a)localObject3).height;
        break label1510;
        bool1 = false;
        break label1696;
        bool1 = false;
        break label1696;
        label3946:
        localObject3 = null;
        break label1715;
        label3952:
        l1 = 0L;
        break label2273;
        label3958:
        l1 = 0L;
        break label2318;
        label3964:
        i = 0;
        break label2880;
        n = 0;
        break label2911;
        i = 1;
        break label2949;
        i = 0;
        break label3013;
        i = 0;
        break label3067;
        if (i1 == 180)
        {
          localObject4 = new dwz();
          ((dwz)localObject4).left = (i2 - ((dwz)localObject3).right);
          ((dwz)localObject4).top = (i3 - ((dwz)localObject3).bottom);
          ((dwz)localObject4).right = (i2 - ((dwz)localObject3).left);
          ((dwz)localObject4).bottom = (i3 - ((dwz)localObject3).top);
          localObject3 = localbvz.stz;
          if (localObject3 == null) {
            break label3153;
          }
          ((bwj)localObject3).Hjn = ((dwz)localObject4);
          break label3153;
        }
        if (i1 != 270) {
          break label3153;
        }
        localObject4 = new dwz();
        ((dwz)localObject4).left = (i3 - ((dwz)localObject3).top);
        ((dwz)localObject4).top = (i2 - ((dwz)localObject3).left);
        ((dwz)localObject4).right = (i3 - ((dwz)localObject3).bottom);
        ((dwz)localObject4).bottom = (i2 - ((dwz)localObject3).right);
        localObject3 = localbvz.stz;
        if (localObject3 == null) {
          break label3153;
        }
        ((bwj)localObject3).Hjn = ((dwz)localObject4);
        break label3153;
        bool1 = false;
        break label3214;
        i = 0;
        break label3225;
        i = 1;
        break label3238;
        label4194:
        if (i != 0)
        {
          i = 2;
          break label3238;
        }
        i = 0;
        break label3238;
        label4211:
        localObject3 = null;
        break label3277;
        label4217:
        localObject3 = null;
        break label3313;
        label4223:
        localObject3 = null;
        break label3350;
        localObject3 = null;
        break label3386;
        localObject3 = null;
        break label3435;
        localObject3 = null;
        break label3483;
        localObject3 = null;
        break label3531;
      }
      Object localObject9 = new y.c();
      ((y.c)localObject9).NiV = 0.0F;
      i3 = SightVideoJNI.getMp4RotateVFS(localbvz.url);
      localObject3 = localbvz.stz;
      label4322:
      int i6;
      if (localObject3 != null)
      {
        i = ((bwj)localObject3).width;
        localObject3 = localbvz.stz;
        if (localObject3 == null) {
          break label4942;
        }
        k = ((bwj)localObject3).height;
        if ((i3 != 90) && (i3 != 270)) {
          break label6720;
        }
        localObject3 = localbvz.stz;
        if (localObject3 == null) {
          break label4948;
        }
        i = ((bwj)localObject3).height;
        localObject3 = localbvz.stz;
        if (localObject3 == null) {
          break label4954;
        }
        k = ((bwj)localObject3).width;
        i6 = localVideoTransPara.videoBitrate;
        localObject3 = o.b.sAp;
        o.b.cFC();
        ae.i(TAG, "video rotate:" + i3 + ", width:" + i + ", height:" + k + " url " + localbvz.url + " thumbUrl: " + localbvz.thumbUrl + " size:" + bu.sL(com.tencent.mm.vfs.o.aZR(localbvz.url)));
        localObject4 = localbvz.url;
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
        f1 = (float)((MultiMediaVideoChecker.a)localObject8).duration;
        localObject4 = localbvz.stz;
        if (localObject4 == null) {
          break label4960;
        }
      }
      label4960:
      for (i3 = ((bwj)localObject4).dez;; i3 = 0)
      {
        f2 = i3 / 1000.0F;
        d.g.b.p.g(localVideoTransPara, "videoParams");
        localObject8 = a.a((String)localObject3, i, k, f1, f2, localVideoTransPara);
        int i5 = i;
        int i4 = k;
        i3 = i6;
        if (((c.a.a)localObject8).errCode == 0)
        {
          i5 = i;
          i4 = k;
          i3 = i6;
          if (((c.a.a)localObject8).width > 0)
          {
            i5 = i;
            i4 = k;
            i3 = i6;
            if (((c.a.a)localObject8).height > 0)
            {
              i5 = i;
              i4 = k;
              i3 = i6;
              if (((c.a.a)localObject8).bitrate > 0)
              {
                i5 = ((c.a.a)localObject8).width;
                i4 = ((c.a.a)localObject8).height;
                i3 = ((c.a.a)localObject8).bitrate;
                ae.i(TAG, "video abaResult, width:" + i5 + ", height:" + i4 + ", " + i3);
              }
            }
          }
        }
        if ((((c.a.a)localObject8).sTT == null) || (((c.a.a)localObject8).sTT.length < 28)) {
          break label6715;
        }
        f1 = localObject8.sTT[27];
        localObject4 = localbvz.url;
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = "";
        }
        f2 = a.a((String)localObject3, f3, f4, i7, bool2, bool3);
        ae.i(TAG, "qipengfeng, audio quality level: " + f2 + ", bitrate:" + f3 + ", samplerate:" + f4 + ", channels:" + i7 + ", enableAuQA:" + bool2 + ", useOriAu:" + bool3);
        i = a(l2, j, (String)localObject6, i1, i2, com.tencent.mm.plugin.mmsight.d.KG(i5), com.tencent.mm.plugin.mmsight.d.KG(i4), i3, localVideoTransPara, localbvz, (FinderMediaReportObject)localObject7, (String)localObject1, n, (d.g.a.b)new b((y.c)localObject9, j, this, localVideoTransPara, (List)localObject5));
        bu.aO(l2);
        if (i >= 0) {
          break label4966;
        }
        a(com.tencent.mm.loader.g.j.hiz);
        AppMethodBeat.o(167731);
        return;
        i = 0;
        break;
        k = 0;
        break label4322;
        i = 0;
        break label4356;
        k = 0;
        break label4375;
      }
      label4966:
      localObject3 = MultiMediaVideoChecker.BXt.aED((String)localObject6);
      if ((localObject3 == null) || (((MultiMediaVideoChecker.a)localObject3).width <= 0) || (((MultiMediaVideoChecker.a)localObject3).height <= 0) || (((MultiMediaVideoChecker.a)localObject3).cwp <= 0.0F))
      {
        localObject4 = TAG;
        localObject5 = new StringBuilder("normal video remuxVideo file error: ");
        if (localObject3 != null)
        {
          localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject3).width);
          localObject5 = ((StringBuilder)localObject5).append(localObject1).append(' ');
          if (localObject3 == null) {
            break label5119;
          }
        }
        label5119:
        for (localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject3).height);; localObject1 = null)
        {
          ae.i((String)localObject4, localObject1);
          localObject1 = o.b.sAp;
          o.b.cFD();
          localObject1 = o.b.sAp;
          o.b.cFE();
          a(com.tencent.mm.loader.g.j.hiz);
          AppMethodBeat.o(167731);
          return;
          localObject1 = null;
          break;
        }
      }
      if (((c.a.a)localObject8).sTT != null) {}
      for (;;)
      {
        try
        {
          SightVideoJNI.addReportMetadata((String)localObject6, ((c.a.a)localObject8).sTT, localVideoTransPara.hYi, 0);
          f3 = f2;
          i = 1;
          f2 = f1;
          f1 = f3;
        }
        catch (Throwable localThrowable)
        {
          f3 = f1;
          f1 = f2;
          i = 1;
          f2 = f3;
          continue;
        }
        bc(1.0F);
        localObject3 = this.sTR.getMediaList();
        localObject4 = ((Iterable)localObject3).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject1 = ((Iterator)localObject4).next();
          localObject8 = (bvz)localObject1;
          if (!d.g.b.p.i(localbvz.mediaId, ((bvz)localObject8).mediaId)) {
            continue;
          }
          localObject4 = (bvz)localObject1;
          if (localObject4 == null) {
            break label6678;
          }
          d.g.b.p.g(localVideoTransPara, "videoParams");
          d.g.b.p.h(localVideoTransPara, "videoParams");
          d.g.b.p.h(localbvz, "localMedia");
          d.g.b.p.h(localObject6, "outputPath");
          d.g.b.p.h(localObject4, "media");
          d.g.b.p.h(localObject7, "reportObject");
          k = localVideoTransPara.hYh;
          n = (int)(localbvz.height / localbvz.width * k);
          localObject1 = f.sUp;
          d.g.b.p.h(localObject6, "input");
          localObject1 = com.tencent.mm.plugin.finder.utils.r.sYn;
          localObject1 = com.tencent.mm.plugin.finder.utils.r.akc((String)localObject6);
          ae.i(f.TAG, "genVideoThumbFileForPost input:" + (String)localObject6 + ", targetWidth:" + k + ", targetHeight:" + n + ", thumbRect:" + null + ", dstPath:" + (String)localObject1);
          localObject1 = f.a((String)localObject6, k, n, null, (String)localObject1);
          localObject8 = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (!com.tencent.mm.plugin.finder.storage.b.cKd()) {
            break label6648;
          }
          localObject8 = com.tencent.mm.plugin.finder.storage.b.sHP;
          k = AdaptiveAdjustBitrate.getVideoImageQuality(com.tencent.mm.plugin.finder.storage.b.cGX(), 0, k, n, 0.8F);
          ((bvz)localObject4).HiY = ((FinderMediaReportObject)localObject7);
          ((bvz)localObject4).url = ((String)localObject6);
          ((bvz)localObject4).thumbUrl = ((String)localObject1);
          ((bvz)localObject4).HiV = false;
          ((bvz)localObject4).mediaId = aj.ej(localbvz.url);
          ((bvz)localObject4).fileSize = ((int)com.tencent.mm.vfs.o.aZR((String)localObject6));
          localObject1 = ((bvz)localObject4).HiY;
          if (localObject1 != null) {
            ((FinderMediaReportObject)localObject1).target = new FinderMediaReportInfo();
          }
          localObject1 = ((bvz)localObject4).HiY;
          if (localObject1 != null)
          {
            localObject1 = ((FinderMediaReportObject)localObject1).target;
            if (localObject1 != null) {
              ((FinderMediaReportInfo)localObject1).fileSize = ((bvz)localObject4).fileSize;
            }
          }
          localObject1 = ((bvz)localObject4).HiY;
          if (localObject1 != null)
          {
            localObject7 = ((bvz)localObject4).HiY;
            if (localObject7 == null) {
              break label6654;
            }
            localObject7 = ((FinderMediaReportObject)localObject7).target;
            if (localObject7 == null) {
              break label6654;
            }
            n = ((FinderMediaReportInfo)localObject7).fileSize;
            ((FinderMediaReportObject)localObject1).videoFinalSize = n;
          }
          localObject1 = ((bvz)localObject4).HiW;
          if (localObject1 != null) {
            ((aaq)localObject1).GrX = false;
          }
          if (((bvz)localObject4).codec_info == null) {
            ((bvz)localObject4).codec_info = new apo();
          }
          localObject1 = ((bvz)localObject4).codec_info;
          if (localObject1 != null)
          {
            ((apo)localObject1).GGC = f2;
            ((apo)localObject1).GGE = f1;
            ((apo)localObject1).GGF = k;
            localObject7 = ((bvz)localObject4).HiW;
            if (localObject7 == null) {
              break label6660;
            }
            localObject7 = ((aaq)localObject7).BWy;
            if (localObject7 == null) {
              break label6660;
            }
            localObject7 = ((aap)localObject7).GrR;
            if (localObject7 == null) {
              break label6660;
            }
            k = ((LinkedList)localObject7).size();
            if (k <= 0) {
              break label6666;
            }
            bool1 = true;
            ((apo)localObject1).GGH = bool1;
            ae.i(TAG, "codec_info video_score:" + ((apo)localObject1).GGC + ",video_cover_score:" + ((apo)localObject1).GGD + ",video_audio_score:" + ((apo)localObject1).GGE + ",thumb_score:" + ((apo)localObject1).GGF + ",hdimg_score:" + ((apo)localObject1).GGG + ",has_stickers:" + ((apo)localObject1).GGH);
          }
          localObject1 = ((bvz)localObject4).HiY;
          if (localObject1 == null) {
            break label6672;
          }
          localObject1 = ((FinderMediaReportObject)localObject1).codecInfo;
          if (localObject1 == null)
          {
            localObject1 = ((bvz)localObject4).HiY;
            if (localObject1 != null) {
              ((FinderMediaReportObject)localObject1).codecInfo = ((bvz)localObject4).codec_info;
            }
          }
          localObject1 = MultiMediaVideoChecker.BXt.aED((String)localObject6);
          if (localObject1 != null)
          {
            ((bvz)localObject4).videoDuration = d.h.a.cm((float)((MultiMediaVideoChecker.a)localObject1).duration / 1000.0F);
            localObject6 = ((bvz)localObject4).HiY;
            if (localObject6 != null)
            {
              localObject6 = ((FinderMediaReportObject)localObject6).target;
              if (localObject6 != null) {
                ((FinderMediaReportInfo)localObject6).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject1).duration);
              }
            }
            localObject6 = ((bvz)localObject4).HiY;
            if (localObject6 != null)
            {
              localObject6 = ((FinderMediaReportObject)localObject6).target;
              if (localObject6 != null) {
                ((FinderMediaReportInfo)localObject6).width = ((MultiMediaVideoChecker.a)localObject1).width;
              }
            }
            localObject6 = ((bvz)localObject4).HiY;
            if (localObject6 != null)
            {
              localObject6 = ((FinderMediaReportObject)localObject6).target;
              if (localObject6 != null) {
                ((FinderMediaReportInfo)localObject6).height = ((MultiMediaVideoChecker.a)localObject1).height;
              }
            }
            localObject6 = ((bvz)localObject4).HiY;
            if (localObject6 != null)
            {
              localObject6 = ((FinderMediaReportObject)localObject6).target;
              if (localObject6 != null) {
                ((FinderMediaReportInfo)localObject6).videoBitrate = ((MultiMediaVideoChecker.a)localObject1).bitrate;
              }
            }
            localObject6 = ((bvz)localObject4).HiY;
            if (localObject6 != null)
            {
              localObject6 = ((FinderMediaReportObject)localObject6).target;
              if (localObject6 != null) {
                ((FinderMediaReportInfo)localObject6).audioBitrate = ((MultiMediaVideoChecker.a)localObject1).audioBitrate;
              }
            }
            localObject4 = ((bvz)localObject4).HiY;
            if (localObject4 != null)
            {
              localObject4 = ((FinderMediaReportObject)localObject4).target;
              if (localObject4 != null) {
                ((FinderMediaReportInfo)localObject4).fps = ((int)((MultiMediaVideoChecker.a)localObject1).cwp);
              }
            }
          }
          ae.i(TAG, "processList index " + j + " url " + localbvz.url + " thumbUrl: " + localbvz.thumbUrl + " newMd5: " + aj.ej(localbvz.url) + " size:" + bu.sL(com.tencent.mm.vfs.o.aZR(localbvz.url)));
          this.sTR.setMediaList((LinkedList)localObject3);
          localObject1 = this.sTR.field_reportObject;
          if (localObject1 != null)
          {
            ((FinderFeedReportObject)localObject1).remuxEndTime = ch.aDc();
            ((FinderFeedReportObject)localObject1).remuxType = i;
            localObject1 = z.Nhr;
          }
          ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().b(this.sTR.getLocalId(), this.sTR);
          j = m;
          break;
          d.g.b.p.g(localVideoTransPara, "videoParams");
          localObject2 = a(l2, j, (String)localObject6, localVideoTransPara, localbvz, (FinderMediaReportObject)localObject7);
          i = ((Number)((d.o)localObject2).first).intValue();
          f2 = ((Number)((d.o)localObject2).second).floatValue();
          if (i < 0)
          {
            a(com.tencent.mm.loader.g.j.hiz);
            AppMethodBeat.o(167731);
            return;
          }
          localObject3 = MultiMediaVideoChecker.BXt.aED((String)localObject6);
          if ((localObject3 == null) || (((MultiMediaVideoChecker.a)localObject3).width <= 0) || (((MultiMediaVideoChecker.a)localObject3).height <= 0) || (((MultiMediaVideoChecker.a)localObject3).cwp <= 0.0F))
          {
            localObject4 = TAG;
            localObject5 = new StringBuilder("remuxVideo file error: ");
            if (localObject3 != null)
            {
              localObject2 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject3).width);
              localObject5 = ((StringBuilder)localObject5).append(localObject2).append(' ');
              if (localObject3 == null) {
                break label6515;
              }
            }
            label6515:
            for (localObject2 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject3).height);; localObject2 = null)
            {
              ae.i((String)localObject4, localObject2);
              a(com.tencent.mm.loader.g.j.hiz);
              AppMethodBeat.o(167731);
              return;
              localObject2 = null;
              break;
            }
          }
          localObject3 = localbvz.url;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          f1 = a.a((String)localObject2, f3, f4, i7, bool2, bool3);
          ae.i(TAG, "qipengfeng, audio quality level: " + f1 + ", bitrate:" + f3 + ", samplerate:" + f4 + ", channels:" + i7 + ", enableAuQA:" + bool2 + ", useOriAu:" + bool3);
          i = k;
          continue;
        }
        Object localObject2 = null;
        continue;
        label6648:
        k = 0;
        continue;
        label6654:
        n = 0;
        continue;
        k = 0;
        continue;
        bool1 = false;
        continue;
        localObject2 = null;
        continue;
        j = m;
        break;
        a(com.tencent.mm.loader.g.j.hiy);
        AppMethodBeat.o(167731);
        return;
        f3 = f1;
        f1 = f2;
        i = 1;
        f2 = f3;
        continue;
        f1 = 0.0F;
        break label4738;
        break label4375;
        bool1 = bool5;
        localObject2 = localObject4;
        break label3612;
        bool1 = false;
        break label2207;
        break label2082;
        f1 = 0.0F;
        i = k;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion;", "", "()V", "RemuxTypeNoNeedRemux", "", "RemuxTypeNormalVideo", "RemuxTypeTavkit", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkRemuxVideo", "path", "width", "height", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "localId", "", "convertViewRect", "Landroid/graphics/Rect;", "viewRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "getABAResult", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "input", "durationSec", "", "startTimeSec", "videoTransPara", "getAudioQualityLevel", "bitrate", "samplerate", "channels", "enableAuQA", "", "useOriAu", "ABAResult", "plugin-finder_release"})
  public static final class a
  {
    public static float a(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(204939);
      d.g.b.p.h(paramString, "input");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cKd())
      {
        paramFloat1 = AdaptiveAdjustBitrate.b(paramString, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(204939);
        return paramFloat1;
      }
      AppMethodBeat.o(204939);
      return 0.0F;
    }
    
    public static int a(String paramString, int paramInt1, int paramInt2, VideoTransPara paramVideoTransPara, long paramLong)
    {
      AppMethodBeat.i(167727);
      d.g.b.p.h(paramVideoTransPara, "videoParams");
      long l = com.tencent.mm.vfs.o.aZR(paramString);
      Object localObject = o.b.sAp;
      o.b.wQ(l);
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (l > com.tencent.mm.plugin.finder.storage.b.cHb())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cJQ() != 1)
        {
          ae.i(c.access$getTAG$cp(), "checkRemuxVideo need remux zip");
          localObject = o.b.sAp;
          o.b.cFG();
          l = bu.HQ();
          localObject = paramString + ".remux";
          paramInt1 = SightVideoJNI.remuxingVFS(paramString, (String)localObject, paramInt1, paramInt2, paramVideoTransPara.videoBitrate, com.tencent.mm.plugin.sight.base.c.zhl, 8, 2, 25.0F, paramVideoTransPara.fps, null, 0, com.tencent.mm.plugin.sight.base.c.zhk, 0, 51);
          ae.i(c.access$getTAG$cp(), "checkRemuxVideo remux cost:" + bu.aO(l) + "ms, ret:" + paramInt1 + " localId:" + paramLong);
          paramVideoTransPara = o.b.sAp;
          o.b.wR(bu.aO(l));
          if (paramInt1 >= 0)
          {
            com.tencent.mm.vfs.o.mG((String)localObject, paramString);
            paramLong = com.tencent.mm.vfs.o.aZR((String)localObject);
            paramString = o.b.sAp;
            o.b.wS(paramLong);
            paramString = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (paramLong > com.tencent.mm.plugin.finder.storage.b.cHb())
            {
              AppMethodBeat.o(167727);
              return -3;
            }
            AppMethodBeat.o(167727);
            return 0;
          }
          paramString = o.b.sAp;
          o.b.cFH();
          AppMethodBeat.o(167727);
          return -2;
        }
      }
      ae.i(c.access$getTAG$cp(), "checkRemuxVideo, no need remux");
      AppMethodBeat.o(167727);
      return 0;
    }
    
    public static Rect a(dwz paramdwz)
    {
      AppMethodBeat.i(167726);
      d.g.b.p.h(paramdwz, "viewRect");
      paramdwz = new Rect(paramdwz.left, paramdwz.top, paramdwz.right, paramdwz.bottom);
      AppMethodBeat.o(167726);
      return paramdwz;
    }
    
    public static a a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, VideoTransPara paramVideoTransPara)
    {
      AppMethodBeat.i(167728);
      d.g.b.p.h(paramString, "input");
      d.g.b.p.h(paramVideoTransPara, "videoTransPara");
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (!com.tencent.mm.plugin.finder.storage.b.cGW()) {
            continue;
          }
          paramString = AdaptiveAdjustBitrate.a(paramString, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, paramFloat1 / 1000.0F, paramFloat2 / 1000.0F, 4, paramVideoTransPara.hYk, paramVideoTransPara.hYl, paramVideoTransPara.hYm, paramVideoTransPara.hYn, paramVideoTransPara.hYo, paramVideoTransPara.hYp, paramVideoTransPara.hYq, false);
          j = paramVideoTransPara.videoBitrate;
          i = -1;
          if (paramString == null) {
            break label245;
          }
          j = paramString[0] * 1000;
          i = 0;
          ae.i(c.access$getTAG$cp(), "getABAResult use videoBitrate:".concat(String.valueOf(j)));
        }
        catch (Throwable paramString)
        {
          int j;
          paramString = new a(-1, 0, 0, 0, null);
          AppMethodBeat.o(167728);
          return paramString;
        }
        ae.i(c.access$getTAG$cp(), "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + paramInt1);
        if (com.tencent.mm.modelvideo.o.aNi() != null) {
          e.q(paramString);
        }
        paramString = new a(i, k, paramInt1, j, paramString);
        AppMethodBeat.o(167728);
        return paramString;
        label245:
        while ((paramString == null) || (paramString[5] <= 0))
        {
          k = paramInt1;
          paramInt1 = paramInt2;
          break;
        }
        int k = paramString[1];
        paramInt1 = paramString[2];
        int i = 0;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final int bitrate;
      public final int errCode;
      public final int height;
      public final int[] sTT;
      public final int width;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
      {
        this.errCode = paramInt1;
        this.width = paramInt2;
        this.height = paramInt3;
        this.bitrate = paramInt4;
        this.sTT = paramArrayOfInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(167725);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!d.g.b.p.i(this.sTT, paramObject.sTT))) {}
          }
        }
        else
        {
          AppMethodBeat.o(167725);
          return true;
        }
        AppMethodBeat.o(167725);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(167724);
        int j = this.errCode;
        int k = this.width;
        int m = this.height;
        int n = this.bitrate;
        int[] arrayOfInt = this.sTT;
        if (arrayOfInt != null) {}
        for (int i = Arrays.hashCode(arrayOfInt);; i = 0)
        {
          AppMethodBeat.o(167724);
          return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(167723);
        String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.sTT) + ")";
        AppMethodBeat.o(167723);
        return str;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$call$2$3"})
  static final class b
    extends q
    implements d.g.a.b<Float, z>
  {
    b(y.c paramc, int paramInt, c paramc1, VideoTransPara paramVideoTransPara, List paramList)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<Float, z>
  {
    c(c paramc, y.c paramc1)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(c paramc, y.d paramd, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, aar paramaar, VideoTransPara paramVideoTransPara, aaq paramaaq, Object paramObject, y.a parama)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<Float, z>
  {
    e(d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<String, z>
  {
    f(c paramc, y.d paramd, int paramInt1, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, int paramInt2, int paramInt3, VideoTransPara paramVideoTransPara, Object paramObject, y.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.c
 * JD-Core Version:    0.7.0.1
 */