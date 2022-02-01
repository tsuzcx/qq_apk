package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.video.reporter.d.b;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "isCenterFeed", "", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;ZLcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "changePageTime", "", "getChangePageTime", "()[J", "setChangePageTime", "([J)V", "clickAvatar", "", "getClickAvatar", "()I", "setClickAvatar", "(I)V", "clickComment", "getClickComment", "setClickComment", "clickExpandText", "getClickExpandText", "setClickExpandText", "clickFav", "getClickFav", "setClickFav", "clickFeedMenu", "getClickFeedMenu", "setClickFeedMenu", "clickPoiTimes", "getClickPoiTimes", "setClickPoiTimes", "clickShareMoments", "getClickShareMoments", "setClickShareMoments", "collapseTextTimes", "getCollapseTextTimes", "setCollapseTextTimes", "commentLikeTimes", "getCommentLikeTimes", "setCommentLikeTimes", "complainTimes", "getComplainTimes", "setComplainTimes", "createTimestamp", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "endTime", "getEndTime", "setEndTime", "endVolume", "getEndVolume", "setEndVolume", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "getFeedDataPos", "setFeedDataPos", "getFeedId", "()Z", "setCenterFeed", "(Z)V", "isPause", "setPause", "isSeek", "setSeek", "lastPageIndex", "getLastPageIndex", "setLastPageIndex", "lastPlayTime", "getLastPlayTime", "setLastPlayTime", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "maxReplayCount", "getMaxReplayCount", "setMaxReplayCount", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "netType", "getNetType", "setNetType", "notInterest", "getNotInterest", "setNotInterest", "pageVideoPlayPercent", "", "getPageVideoPlayPercent", "()[I", "setPageVideoPlayPercent", "([I)V", "pageVideoReplayCount", "getPageVideoReplayCount", "setPageVideoReplayCount", "pauseTimes", "getPauseTimes", "setPauseTimes", "playFormat", "", "getPlayFormat", "()Ljava/lang/String;", "setPlayFormat", "(Ljava/lang/String;)V", "playProgressInfo", "getPlayProgressInfo", "setPlayProgressInfo", "playProgressSet", "Ljava/util/Vector;", "getPlayProgressSet", "()Ljava/util/Vector;", "setPlayProgressSet", "(Ljava/util/Vector;)V", "playTime", "getPlayTime", "setPlayTime", "playTimestamp", "getPlayTimestamp", "setPlayTimestamp", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getRvFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setRvFeed", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "shareCount", "getShareCount", "setShareCount", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "startVolume", "getStartVolume", "setStartVolume", "stayTime", "getStayTime", "setStayTime", "videoDuration", "getVideoDuration", "setVideoDuration", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "setVideoPlayReporter", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;)V", "viewPageDuration", "getViewPageDuration", "setViewPageDuration", "voiceInfo", "getVoiceInfo", "setVoiceInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "copyRecord", "equals", "other", "hashCode", "onRelease", "", "toString", "Companion", "plugin-finder_release"})
public final class t
{
  private static final String TAG = "Finder.FinderSingleFeedRecord";
  private static final int zXI = 1;
  private static final int zXJ = 2;
  public static final a zXK;
  long endTime;
  long fOa;
  public final long feedId;
  long fhq;
  int netType;
  int pqr;
  final long startTime;
  int videoDuration;
  public final FinderItem xpY;
  com.tencent.mm.view.recyclerview.j xrf;
  com.tencent.mm.plugin.finder.video.reporter.d zUT;
  int zWX;
  long[] zWY;
  long[] zWZ;
  String zXA;
  Vector<Integer> zXB;
  int zXC;
  int zXD;
  String zXE;
  String zXF;
  bu zXG;
  boolean zXH;
  int[] zXa;
  int[] zXb;
  int zXc;
  int zXd;
  int zXe;
  int zXf;
  int zXg;
  int zXh;
  int zXi;
  int zXj;
  int zXk;
  int zXl;
  int zXm;
  int zXn;
  int zXo;
  int zXp;
  long zXq;
  int zXr;
  int zXs;
  int zXt;
  long zXu;
  long zXv;
  long zXw;
  long zXx;
  int zXy;
  int zXz;
  final bs zvv;
  
  static
  {
    AppMethodBeat.i(290304);
    zXK = new a((byte)0);
    TAG = "Finder.FinderSingleFeedRecord";
    zXI = 1;
    zXJ = 2;
    AppMethodBeat.o(290304);
  }
  
  public t(long paramLong1, long paramLong2, FinderItem paramFinderItem, com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean, com.tencent.mm.plugin.finder.video.reporter.d paramd, bs parambs)
  {
    AppMethodBeat.i(290302);
    this.feedId = paramLong1;
    this.startTime = paramLong2;
    this.xpY = paramFinderItem;
    this.xrf = paramj;
    this.zXH = paramBoolean;
    this.zUT = paramd;
    this.zvv = parambs;
    this.fhq = cm.bfE();
    paramFinderItem = new long[9];
    int i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.zWY = paramFinderItem;
    paramFinderItem = new long[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.zWZ = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.zXa = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.zXb = paramFinderItem;
    this.zXe = 1;
    this.zXA = "";
    this.zXB = new Vector();
    this.zXE = "";
    this.zXF = "";
    this.zWY[0] = this.startTime;
    paramFinderItem = this.zUT;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.ARv;
      if (paramFinderItem != null)
      {
        paramFinderItem = (d.b)paramFinderItem.get(Long.valueOf(this.feedId));
        if (paramFinderItem != null)
        {
          this.zXx = this.startTime;
          if (paramFinderItem.aPw) {
            this.zXv = this.startTime;
          }
          paramFinderItem = MMApplicationContext.getContext().getSystemService("audio");
          if (paramFinderItem == null)
          {
            paramFinderItem = new kotlin.t("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(290302);
            throw paramFinderItem;
          }
          this.zXC = ((AudioManager)paramFinderItem).getStreamVolume(3);
          AppMethodBeat.o(290302);
          return;
        }
      }
    }
    AppMethodBeat.o(290302);
  }
  
  public final void Mq(long paramLong)
  {
    this.zXv = paramLong;
  }
  
  public final void PC(int paramInt)
  {
    this.pqr = paramInt;
  }
  
  public final void PD(int paramInt)
  {
    this.zXh = paramInt;
  }
  
  public final void PE(int paramInt)
  {
    this.zXi = paramInt;
  }
  
  public final void PF(int paramInt)
  {
    this.zXj = paramInt;
  }
  
  public final void PG(int paramInt)
  {
    this.zXk = paramInt;
  }
  
  public final void PH(int paramInt)
  {
    this.zXl = paramInt;
  }
  
  public final void PI(int paramInt)
  {
    this.zXm = paramInt;
  }
  
  public final void PJ(int paramInt)
  {
    this.zXn = paramInt;
  }
  
  public final void PK(int paramInt)
  {
    this.zXo = paramInt;
  }
  
  public final void PL(int paramInt)
  {
    this.zXr = paramInt;
  }
  
  public final void PM(int paramInt)
  {
    this.zXs = paramInt;
  }
  
  public final void PN(int paramInt)
  {
    this.zXt = paramInt;
  }
  
  public final void a(com.tencent.mm.plugin.finder.video.reporter.d arg1)
  {
    AppMethodBeat.i(290300);
    if (this.endTime == 0L) {
      this.endTime = cm.bfE();
    }
    Object localObject1 = this.xpY;
    if (localObject1 != null)
    {
      localObject1 = ((FinderItem)localObject1).getMediaList();
      if (localObject1 != null)
      {
        localObject1 = (csg)kotlin.a.j.lp((List)localObject1);
        if (localObject1 != null)
        {
          i = ((csg)localObject1).videoDuration;
          this.videoDuration = i;
          localObject1 = this.zvv;
          if (localObject1 != null)
          {
            localObject1 = ((bs)localObject1).xcy;
            if (localObject1 == null) {
              break label289;
            }
            localObject1 = ((cvy)localObject1).TEM;
            if (localObject1 == null) {
              break label289;
            }
            localObject1 = ((cwc)localObject1).media;
            if (localObject1 == null) {
              break label289;
            }
            localObject1 = (cwq)kotlin.a.j.lp((List)localObject1);
            if (localObject1 == null) {
              break label289;
            }
          }
        }
      }
    }
    d.b localb;
    label289:
    for (int i = ((cwq)localObject1).TFq;; i = 0)
    {
      this.videoDuration = i;
      this.fOa = (this.endTime - this.startTime);
      if (??? == null) {
        break label727;
      }
      ??? = ???.ARv;
      if (??? == null) {
        break label727;
      }
      localb = (d.b)???.get(Long.valueOf(this.feedId));
      if (localb == null) {
        break label727;
      }
      if (this.zXx != 0L) {
        this.zXw += this.endTime - this.zXx;
      }
      if (this.zXv != 0L) {
        this.zXu += this.endTime - this.zXv;
      }
      ??? = MMApplicationContext.getContext().getSystemService("audio");
      if (??? != null) {
        break label294;
      }
      ??? = new kotlin.t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(290300);
      throw ???;
      i = 0;
      break;
    }
    label294:
    this.zXD = ((AudioManager)???).getStreamVolume(3);
    ??? = MMApplicationContext.getContext().getSystemService("audio");
    if (??? == null)
    {
      ??? = new kotlin.t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(290300);
      throw ???;
    }
    int j = ((AudioManager)???).getStreamMaxVolume(3);
    i = 0;
    if (this.zXC != this.zXD) {
      i = 1;
    }
    this.zXE = (this.zXC * 100 / j + '#' + this.zXD * 100 / j + '#' + i);
    ??? = n.zWF;
    this.netType = n.bvR();
    synchronized ((Iterable)this.zXB)
    {
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject1).next();
        String str = this.zXA;
        this.zXA = (str + localInteger + '#');
      }
    }
    Object localObject3 = x.aazN;
    ??? = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
    localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.aEU(localb.ARC).field_fileFormat;
    ??? = (com.tencent.mm.plugin.finder.video.reporter.d)localObject3;
    if (localObject3 == null) {
      ??? = "";
    }
    int m = 0;
    int n = 0;
    int i1 = 0;
    localObject3 = localb.ARF;
    int k = i1;
    j = n;
    i = m;
    if (localObject3 != null)
    {
      localObject3 = f.aYg(((ac)localObject3).getPath());
      k = i1;
      j = n;
      i = m;
      if (localObject3 != null)
      {
        j = ((b)localObject3).videoBitrate;
        i = ((b)localObject3).audioBitrate;
        k = ((b)localObject3).frameRate;
      }
    }
    this.zXF = (localb.ASo + ';' + j + ';' + ??? + ';' + i + ';' + k + ';' + localb.ASp + ';' + localb.ASq + ';');
    AppMethodBeat.o(290300);
    return;
    label727:
    AppMethodBeat.o(290300);
  }
  
  public final long[] dPH()
  {
    return this.zWY;
  }
  
  public final int[] dPI()
  {
    return this.zXa;
  }
  
  public final int[] dPJ()
  {
    return this.zXb;
  }
  
  public final int dPK()
  {
    return this.zXc;
  }
  
  public final int dPL()
  {
    return this.pqr;
  }
  
  public final int dPM()
  {
    return this.zXh;
  }
  
  public final int dPN()
  {
    return this.zXi;
  }
  
  public final int dPO()
  {
    return this.zXj;
  }
  
  public final int dPP()
  {
    return this.zXk;
  }
  
  public final int dPQ()
  {
    return this.zXl;
  }
  
  public final int dPR()
  {
    return this.zXm;
  }
  
  public final int dPS()
  {
    return this.zXn;
  }
  
  public final int dPT()
  {
    return this.zXo;
  }
  
  public final int dPU()
  {
    return this.zXr;
  }
  
  public final int dPV()
  {
    return this.zXs;
  }
  
  public final int dPW()
  {
    return this.zXt;
  }
  
  public final long dPX()
  {
    return this.zXv;
  }
  
  public final long dPY()
  {
    return this.zXx;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(290307);
    if (this != paramObject)
    {
      if ((paramObject instanceof t))
      {
        paramObject = (t)paramObject;
        if ((this.feedId != paramObject.feedId) || (this.startTime != paramObject.startTime) || (!p.h(this.xpY, paramObject.xpY)) || (!p.h(this.xrf, paramObject.xrf)) || (this.zXH != paramObject.zXH) || (!p.h(this.zUT, paramObject.zUT)) || (!p.h(this.zvv, paramObject.zvv))) {}
      }
    }
    else
    {
      AppMethodBeat.o(290307);
      return true;
    }
    AppMethodBeat.o(290307);
    return false;
  }
  
  public final long getFeedId()
  {
    return this.feedId;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(290305);
    String str = "FinderSingleFeedRecord(feedId=" + this.feedId + ", startTime=" + this.startTime + ", feed=" + this.xpY + ", showInfo=" + this.xrf + ", isCenterFeed=" + this.zXH + ", videoPlayReporter=" + this.zUT + ", megaVideoFeed=" + this.zvv + ")";
    AppMethodBeat.o(290305);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord$Companion;", "", "()V", "FinderStatsReportFeedTypeRelated", "", "getFinderStatsReportFeedTypeRelated", "()I", "FinderStatsReportFeedTypeStream", "getFinderStatsReportFeedTypeStream", "TAG", "", "getTAG", "()Ljava/lang/String;", "expandNotZeroValue", "", "sb", "Ljava/lang/StringBuffer;", "key", "value", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Long;)V", "printStats", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "trans2Stats", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
  public static final class a
  {
    public static emr a(t paramt, bid parambid)
    {
      int k = 1;
      AppMethodBeat.i(288212);
      p.k(paramt, "record");
      p.k(parambid, "contextObj");
      emr localemr = new emr();
      BitSet localBitSet = new BitSet(64);
      Object localObject1 = paramt.zvv;
      long l;
      Object localObject2;
      label110:
      int i;
      if (localObject1 != null)
      {
        l = ((bs)localObject1).dKW();
        localemr.xbk = l;
        localObject1 = paramt.zvv;
        if (localObject1 != null)
        {
          localObject2 = ((bs)localObject1).dKX();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = paramt.xpY;
          if (localObject1 == null) {
            break label487;
          }
          localObject1 = ((FinderItem)localObject1).getObjectNonceId();
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localemr.objectNonceId = ((String)localObject2);
        localObject1 = paramt.zvv;
        if (localObject1 == null) {
          break label493;
        }
        l = ((bs)localObject1).mf();
        label148:
        localemr.Upr = l;
        localObject1 = paramt.zvv;
        if (localObject1 != null)
        {
          localObject1 = ((bs)localObject1).xcy;
          if (localObject1 != null)
          {
            localObject2 = ((cvy)localObject1).SWw;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label198;
            }
          }
        }
        localObject1 = "";
        label198:
        localemr.Ups = ((String)localObject1);
        localemr.Upj = new mf();
        localemr.Upk = new ezq();
        localemr.Upl = new dhb();
        localObject1 = paramt.zvv;
        if (localObject1 != null)
        {
          localObject1 = ((bs)localObject1).contact;
          if (localObject1 != null)
          {
            localObject2 = ((FinderContact)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label298;
            }
          }
        }
        localObject1 = paramt.xpY;
        if (localObject1 == null) {
          break label499;
        }
        localObject1 = ((FinderItem)localObject1).field_username;
        label298:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localemr.finderUsername = ((String)localObject2);
        localemr.Upm = paramt.fhq;
        if (parambid.xkX == 20)
        {
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.n.Bja;
          if (!com.tencent.mm.plugin.finder.viewmodel.component.n.ekw().contains(Long.valueOf(localemr.xbk))) {
            break label505;
          }
          i = t.dQa();
          label362:
          localemr.Upn = i;
        }
        if (paramt.zvv != null)
        {
          localObject1 = paramt.xpY;
          if ((localObject1 == null) || (((FinderItem)localObject1).isReplaceLongVideoToNormal() != true)) {
            break label512;
          }
        }
        localObject1 = n.zWF;
      }
      int j;
      for (localObject1 = n.N(paramt.feedId, parambid.xkX);; localObject1 = n.N(paramt.feedId, parambid.xkX))
      {
        localemr.sessionBuffer = ((String)localObject1);
        localObject1 = e.AmW;
        localemr.Upp = e.a.an(parambid.xkX, paramt.feedId);
        localemr.Upt = paramt.startTime;
        j = paramt.zXe;
        i = 0;
        while (i < j)
        {
          localBitSet.set(i, true);
          i += 1;
        }
        l = paramt.feedId;
        break;
        label487:
        localObject1 = null;
        break label110;
        label493:
        l = 0L;
        break label148;
        label499:
        localObject1 = null;
        break label298;
        label505:
        i = t.dPZ();
        break label362;
        label512:
        localObject1 = n.zWF;
      }
      float f;
      label573:
      label587:
      int m;
      if (paramt.zXg < 5)
      {
        localBitSet.set(9, true);
        f = (float)paramt.fOa / 1000.0F;
        if (f >= 0.5F) {
          break label829;
        }
        localBitSet.set(21, true);
        parambid = paramt.zXb;
        int n = parambid.length;
        j = 0;
        i = 0;
        if (j >= n) {
          break label1007;
        }
        m = parambid[j];
        if (m <= i) {
          break label1940;
        }
        i = m;
      }
      label1920:
      label1925:
      label1930:
      label1935:
      label1940:
      for (;;)
      {
        j += 1;
        break label587;
        if (paramt.zXg < 10)
        {
          localBitSet.set(10, true);
          break;
        }
        if (paramt.zXg < 20)
        {
          localBitSet.set(11, true);
          break;
        }
        if (paramt.zXg < 30)
        {
          localBitSet.set(12, true);
          break;
        }
        if (paramt.zXg < 40)
        {
          localBitSet.set(13, true);
          break;
        }
        if (paramt.zXg < 50)
        {
          localBitSet.set(14, true);
          break;
        }
        if (paramt.zXg < 60)
        {
          localBitSet.set(15, true);
          break;
        }
        if (paramt.zXg < 70)
        {
          localBitSet.set(16, true);
          break;
        }
        if (paramt.zXg < 80)
        {
          localBitSet.set(17, true);
          break;
        }
        if (paramt.zXg < 90)
        {
          localBitSet.set(18, true);
          break;
        }
        if (paramt.zXg < 100)
        {
          localBitSet.set(19, true);
          break;
        }
        localBitSet.set(20, true);
        break;
        label829:
        if (f < 1.0F)
        {
          localBitSet.set(22, true);
          break label573;
        }
        if (f < 2.0F)
        {
          localBitSet.set(23, true);
          break label573;
        }
        if (f < 3.0F)
        {
          localBitSet.set(24, true);
          break label573;
        }
        if (f < 5.0F)
        {
          localBitSet.set(25, true);
          break label573;
        }
        if (f < 10.0F)
        {
          localBitSet.set(26, true);
          break label573;
        }
        if (f < 20.0F)
        {
          localBitSet.set(27, true);
          break label573;
        }
        if (f < 30.0F)
        {
          localBitSet.set(28, true);
          break label573;
        }
        if (f < 40.0F)
        {
          localBitSet.set(29, true);
          break label573;
        }
        if (f < 50.0F)
        {
          localBitSet.set(30, true);
          break label573;
        }
        localBitSet.set(31, true);
        break label573;
        label1007:
        if (i == 0) {
          localBitSet.set(32, true);
        }
        for (;;)
        {
          l = localBitSet.toLongArray()[0];
          parambid = localemr.Upj;
          if (parambid != null) {
            parambid.RRR = l;
          }
          parambid = localemr.Upk;
          if (parambid != null) {
            parambid.KyZ = ((int)f);
          }
          parambid = localemr.Upk;
          if (parambid != null) {
            parambid.UzT = paramt.videoDuration;
          }
          parambid = localemr.Upk;
          if (parambid != null) {
            parambid.wmw = paramt.fOa;
          }
          parambid = localemr.Upk;
          if (parambid != null) {
            parambid.UzU = paramt.zXw;
          }
          parambid = localemr.Upk;
          if (parambid != null) {
            parambid.UzV = paramt.zXu;
          }
          parambid = localemr.Upk;
          if (parambid != null)
          {
            parambid.UzW = paramt.fOa;
            parambid.lzJ = paramt.startTime;
            parambid.UzX = paramt.endTime;
            parambid.zXq = paramt.zXq;
            parambid.UzY = paramt.zXp;
            parambid.UzZ = 1;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNM = ((int)f);
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNN = i;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNL = paramt.zXg;
          }
          parambid = paramt.zWY;
          m = parambid.length;
          j = 0;
          i = 0;
          while (j < m)
          {
            if (parambid[j] > 0L)
            {
              localObject1 = localemr.Upl;
              if (localObject1 != null) {
                ((dhb)localObject1).TNK = i;
              }
            }
            j += 1;
            i += 1;
          }
          if (i == 1) {
            localBitSet.set(33, true);
          } else if (i == 2) {
            localBitSet.set(34, true);
          } else if (i == 3) {
            localBitSet.set(35, true);
          } else if (i == 4) {
            localBitSet.set(36, true);
          } else if (i == 5) {
            localBitSet.set(37, true);
          } else {
            localBitSet.set(38, true);
          }
        }
        parambid = localemr.Upl;
        if (parambid != null) {
          parambid.TNO = paramt.pqr;
        }
        parambid = localemr.Upl;
        if (parambid != null)
        {
          if (paramt.pqr > 0)
          {
            i = 1;
            parambid.TNQ = i;
          }
        }
        else
        {
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.zXh = paramt.zXh;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNP = paramt.zXi;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNX = paramt.zXt;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNV = paramt.zWX;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNY = paramt.zXm;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNZ = paramt.zXk;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TOa = paramt.zXl;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.zXm = paramt.zXm;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.zXn = paramt.zXn;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.zXo = paramt.zXo;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.zXr = paramt.zXr;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.zXs = paramt.zXs;
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TOc = paramt.zXz;
          }
          parambid = paramt.xpY;
          if (parambid != null)
          {
            localObject1 = localemr.Upl;
            if (localObject1 != null)
            {
              if (parambid.getLikeFlag() == 0) {
                break label1905;
              }
              i = 1;
              label1695:
              ((dhb)localObject1).TNR = i;
            }
            localObject1 = localemr.Upl;
            if (localObject1 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
              if (!d.a.aAN(parambid.getUserName())) {
                break label1910;
              }
              i = 1;
              label1730:
              ((dhb)localObject1).AvX = i;
            }
            localObject1 = localemr.Upl;
            if (localObject1 != null)
            {
              if (parambid.getFavFlag() != 1) {
                break label1915;
              }
              i = 1;
              label1758:
              ((dhb)localObject1).TNT = i;
            }
          }
          parambid = localemr.Upl;
          if (parambid != null) {
            parambid.TNW = paramt.zXf;
          }
          parambid = paramt.zvv;
          if (parambid != null)
          {
            paramt = localemr.Upl;
            if (paramt != null)
            {
              if (parambid.getFeedObject().likeFlag == 0) {
                break label1920;
              }
              i = 1;
              label1813:
              paramt.TNR = i;
            }
            localObject1 = localemr.Upl;
            if (localObject1 != null)
            {
              paramt = com.tencent.mm.plugin.finder.api.d.wZQ;
              paramt = parambid.contact;
              if (paramt == null) {
                break label1925;
              }
              paramt = paramt.username;
              label1848:
              if (!d.a.aAN(paramt)) {
                break label1930;
              }
              i = 1;
              label1857:
              ((dhb)localObject1).AvX = i;
            }
            paramt = localemr.Upl;
            if (paramt != null) {
              if (parambid.getFeedObject().favFlag != 1) {
                break label1935;
              }
            }
          }
        }
        for (i = k;; i = 0)
        {
          paramt.TNT = i;
          AppMethodBeat.o(288212);
          return localemr;
          i = 0;
          break;
          label1905:
          i = 0;
          break label1695;
          label1910:
          i = 0;
          break label1730;
          label1915:
          i = 0;
          break label1758;
          i = 0;
          break label1813;
          paramt = null;
          break label1848;
          i = 0;
          break label1857;
        }
      }
    }
    
    public static void a(emr paramemr, String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(288213);
      p.k(paramemr, "stats");
      p.k(paramString, "tag");
      StringBuffer localStringBuffer = new StringBuffer("[Stats]\n");
      Object localObject1 = t.zXK;
      a(localStringBuffer, "feedId", Long.valueOf(paramemr.xbk));
      if (BuildInfo.DEBUG)
      {
        localStringBuffer.append("strfeedId=" + com.tencent.mm.ae.d.Fw(paramemr.xbk) + '\n');
        localObject1 = e.AmW;
        localObject1 = e.a.MH(paramemr.xbk);
        if (localObject1 != null) {
          localStringBuffer.append("nick=" + ((FinderItem)localObject1).getNickName() + ", desc=" + ((FinderItem)localObject1).getDebugDescription() + '\n');
        }
      }
      localObject1 = t.zXK;
      localObject1 = paramemr.Upk;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ezq)localObject1).UzT);
        a(localStringBuffer, "vidPlayLen", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upk;
        if (localObject1 == null) {
          break label1084;
        }
        localObject1 = Integer.valueOf(((ezq)localObject1).KyZ);
        label204:
        a(localStringBuffer, "stayTime", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upk;
        if (localObject1 == null) {
          break label1089;
        }
        localObject1 = Long.valueOf(((ezq)localObject1).wmw);
        label234:
        a(localStringBuffer, "stayTimeMs", (Long)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upk;
        if (localObject1 == null) {
          break label1094;
        }
        localObject1 = Long.valueOf(((ezq)localObject1).UzU);
        label264:
        a(localStringBuffer, "vidPlayTimeMs", (Long)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upk;
        if (localObject1 == null) {
          break label1099;
        }
        localObject1 = Long.valueOf(((ezq)localObject1).UzV);
        label294:
        a(localStringBuffer, "vidPlayingTimeMs", (Long)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1104;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNQ);
        label324:
        a(localStringBuffer, "share", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1109;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNO);
        label354:
        a(localStringBuffer, "forward_times", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1114;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNM);
        label384:
        a(localStringBuffer, "feed_stay_time", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1119;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNN);
        label414:
        a(localStringBuffer, "vid_replay_times", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1124;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNL);
        label444:
        a(localStringBuffer, "max_vid_play_progress", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1129;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNK);
        label474:
        a(localStringBuffer, "pageTurn", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1134;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).zXh);
        label504:
        a(localStringBuffer, "clickComment", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1139;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNP);
        label534:
        a(localStringBuffer, "clickHead", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1144;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNR);
        label564:
        a(localStringBuffer, "likeStatus", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1149;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).AvX);
        label594:
        a(localStringBuffer, "followStatus", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1154;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNT);
        label624:
        a(localStringBuffer, "favStatus", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1159;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNX);
        label654:
        a(localStringBuffer, "notInterestAction", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1164;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNU);
        label684:
        a(localStringBuffer, "fastSlip", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1169;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNV);
        label714:
        a(localStringBuffer, "sortId", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1174;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNW);
        label744:
        a(localStringBuffer, "maxVidPlayLen", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1179;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNY);
        label774:
        a(localStringBuffer, "clickTopicTimes", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1184;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TNZ);
        label804:
        a(localStringBuffer, "expandTextTimes", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1189;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).TOa);
        label834:
        a(localStringBuffer, "shareMomentTimes", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1194;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).zXm);
        label864:
        a(localStringBuffer, "clickPoiTimes", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1199;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).zXn);
        label894:
        a(localStringBuffer, "collapseTextTimes", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1204;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).zXo);
        label924:
        a(localStringBuffer, "commentLikeTimes", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1209;
        }
        localObject1 = Integer.valueOf(((dhb)localObject1).zXr);
        label954:
        a(localStringBuffer, "clickFeedMenu", (Integer)localObject1);
        localObject1 = t.zXK;
        localObject1 = paramemr.Upl;
        if (localObject1 == null) {
          break label1214;
        }
      }
      label1084:
      label1214:
      for (localObject1 = Integer.valueOf(((dhb)localObject1).zXs);; localObject1 = null)
      {
        a(localStringBuffer, "complainTimes", (Integer)localObject1);
        localObject1 = t.zXK;
        a(localStringBuffer, "actionTimeMs", Long.valueOf(paramemr.Upm));
        localObject1 = t.zXK;
        a(localStringBuffer, "feedScene", Integer.valueOf(paramemr.Upn));
        localObject1 = t.zXK;
        localObject1 = paramemr.sessionBuffer;
        paramemr = localObject2;
        if (localObject1 != null) {
          paramemr = Integer.valueOf(((String)localObject1).length());
        }
        a(localStringBuffer, "sessionBuffer", paramemr);
        Log.i(paramString, localStringBuffer.toString());
        AppMethodBeat.o(288213);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label204;
        label1089:
        localObject1 = null;
        break label234;
        label1094:
        localObject1 = null;
        break label264;
        label1099:
        localObject1 = null;
        break label294;
        label1104:
        localObject1 = null;
        break label324;
        label1109:
        localObject1 = null;
        break label354;
        label1114:
        localObject1 = null;
        break label384;
        label1119:
        localObject1 = null;
        break label414;
        label1124:
        localObject1 = null;
        break label444;
        label1129:
        localObject1 = null;
        break label474;
        label1134:
        localObject1 = null;
        break label504;
        label1139:
        localObject1 = null;
        break label534;
        label1144:
        localObject1 = null;
        break label564;
        label1149:
        localObject1 = null;
        break label594;
        localObject1 = null;
        break label624;
        localObject1 = null;
        break label654;
        localObject1 = null;
        break label684;
        localObject1 = null;
        break label714;
        localObject1 = null;
        break label744;
        localObject1 = null;
        break label774;
        localObject1 = null;
        break label804;
        localObject1 = null;
        break label834;
        localObject1 = null;
        break label864;
        localObject1 = null;
        break label894;
        localObject1 = null;
        break label924;
        localObject1 = null;
        break label954;
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Integer paramInteger)
    {
      AppMethodBeat.i(288215);
      p.k(paramStringBuffer, "sb");
      p.k(paramString, "key");
      if (paramInteger == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramInteger + '\n');
        do
        {
          AppMethodBeat.o(288215);
          return;
        } while (paramInteger.intValue() == 0);
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Long paramLong)
    {
      AppMethodBeat.i(288214);
      p.k(paramStringBuffer, "sb");
      p.k(paramString, "key");
      if (paramLong == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramLong + '\n');
        do
        {
          AppMethodBeat.o(288214);
          return;
        } while (paramLong.longValue() == 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.t
 * JD-Core Version:    0.7.0.1
 */