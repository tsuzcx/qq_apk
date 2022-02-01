package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.duh;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.view.recyclerview.f;
import d.a.j;
import d.g.b.p;
import d.v;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "isCenterFeed", "", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;ZLcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "changePageTime", "", "getChangePageTime", "()[J", "setChangePageTime", "([J)V", "clickAvatar", "", "getClickAvatar", "()I", "setClickAvatar", "(I)V", "clickComment", "getClickComment", "setClickComment", "clickExpandText", "getClickExpandText", "setClickExpandText", "clickFav", "getClickFav", "setClickFav", "clickFeedMenu", "getClickFeedMenu", "setClickFeedMenu", "clickPoiTimes", "getClickPoiTimes", "setClickPoiTimes", "clickShareMoments", "getClickShareMoments", "setClickShareMoments", "collapseTextTimes", "getCollapseTextTimes", "setCollapseTextTimes", "commentLikeTimes", "getCommentLikeTimes", "setCommentLikeTimes", "complainTimes", "getComplainTimes", "setComplainTimes", "createTimestamp", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "endTime", "getEndTime", "setEndTime", "endVolume", "getEndVolume", "setEndVolume", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "getFeedDataPos", "setFeedDataPos", "getFeedId", "()Z", "setCenterFeed", "(Z)V", "isPause", "setPause", "isSeek", "setSeek", "lastPageIndex", "getLastPageIndex", "setLastPageIndex", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "maxReplayCount", "getMaxReplayCount", "setMaxReplayCount", "netType", "getNetType", "setNetType", "notInterest", "getNotInterest", "setNotInterest", "pageVideoPlayPercent", "", "getPageVideoPlayPercent", "()[I", "setPageVideoPlayPercent", "([I)V", "pageVideoReplayCount", "getPageVideoReplayCount", "setPageVideoReplayCount", "playFormat", "", "getPlayFormat", "()Ljava/lang/String;", "setPlayFormat", "(Ljava/lang/String;)V", "playProgressInfo", "getPlayProgressInfo", "setPlayProgressInfo", "playProgressSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayProgressSet", "()Ljava/util/HashSet;", "setPlayProgressSet", "(Ljava/util/HashSet;)V", "playTime", "getPlayTime", "setPlayTime", "playTimestamp", "getPlayTimestamp", "setPlayTimestamp", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "shareCount", "getShareCount", "setShareCount", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "startVolume", "getStartVolume", "setStartVolume", "stayTime", "getStayTime", "setStayTime", "videoDuration", "getVideoDuration", "setVideoDuration", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "setVideoPlayReporter", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;)V", "viewPageDuration", "getViewPageDuration", "setViewPageDuration", "voiceInfo", "getVoiceInfo", "setVoiceInfo", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "copyRecord", "equals", "other", "hashCode", "onRelease", "", "toString", "Companion", "plugin-finder_release"})
public final class l
{
  private static final String TAG = "Finder.FinderSingleFeedRecord";
  private static final int spG = 1;
  private static final int spH = 2;
  public static final a spI;
  public long dBD;
  public final long dtq;
  public long endTime;
  public final FinderItem feed;
  public int liA;
  public int netType;
  public f rRb;
  BaseFinderFeed sjQ;
  public r snM;
  public long soX;
  public int soY;
  public long[] soZ;
  public HashSet<Integer> spA;
  public int spB;
  public int spC;
  public String spD;
  String spE;
  public boolean spF;
  public long[] spa;
  public int[] spb;
  public int[] spc;
  public int spd;
  public int spe;
  public int spf;
  public int spg;
  public int sph;
  public int spi;
  public int spj;
  public int spk;
  public int spl;
  public int spm;
  public int spn;
  public int spo;
  public int spp;
  public int spq;
  public int spr;
  public int sps;
  public long spt;
  public long spu;
  public long spv;
  public long spw;
  public int spx;
  public int spy;
  public String spz;
  public final long startTime;
  public int videoDuration;
  
  static
  {
    AppMethodBeat.i(203331);
    spI = new a((byte)0);
    TAG = "Finder.FinderSingleFeedRecord";
    spG = 1;
    spH = 2;
    AppMethodBeat.o(203331);
  }
  
  public l(long paramLong1, long paramLong2, FinderItem paramFinderItem, f paramf, boolean paramBoolean, r paramr)
  {
    AppMethodBeat.i(203329);
    this.dtq = paramLong1;
    this.startTime = paramLong2;
    this.feed = paramFinderItem;
    this.rRb = paramf;
    this.spF = paramBoolean;
    this.snM = paramr;
    this.soX = cf.aCM();
    paramFinderItem = new long[9];
    int i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.soZ = paramFinderItem;
    paramFinderItem = new long[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.spa = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.spb = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.spc = paramFinderItem;
    this.spf = 1;
    this.spz = "";
    this.spA = new HashSet();
    this.spD = "";
    this.spE = "";
    this.soZ[0] = this.startTime;
    paramFinderItem = this.snM;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.sqK;
      if (paramFinderItem != null)
      {
        paramFinderItem = (r.b)paramFinderItem.get(Long.valueOf(this.dtq));
        if (paramFinderItem != null)
        {
          this.spw = this.startTime;
          if (paramFinderItem.bfZ) {
            this.spu = this.startTime;
          }
          paramFinderItem = aj.getContext().getSystemService("audio");
          if (paramFinderItem == null)
          {
            paramFinderItem = new v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(203329);
            throw paramFinderItem;
          }
          this.spB = ((AudioManager)paramFinderItem).getStreamVolume(3);
          AppMethodBeat.o(203329);
          return;
        }
      }
    }
    AppMethodBeat.o(203329);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(203327);
    if (this.endTime == 0L) {
      this.endTime = cf.aCM();
    }
    Object localObject = this.feed;
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getMediaList();
      if (localObject != null)
      {
        localObject = (bvf)j.jd((List)localObject);
        if (localObject == null) {}
      }
    }
    r.b localb;
    for (int i = ((bvf)localObject).videoDuration;; i = 0)
    {
      this.videoDuration = i;
      if (this.spF) {
        this.dBD = (this.endTime - this.startTime);
      }
      if (paramr == null) {
        break label625;
      }
      paramr = paramr.sqK;
      if (paramr == null) {
        break label625;
      }
      localb = (r.b)paramr.get(Long.valueOf(this.dtq));
      if (localb == null) {
        break label625;
      }
      if (this.spw != 0L) {
        this.spv += this.endTime - this.spw;
      }
      if (this.spu != 0L) {
        this.spt += this.endTime - this.spu;
      }
      paramr = aj.getContext().getSystemService("audio");
      if (paramr != null) {
        break;
      }
      paramr = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(203327);
      throw paramr;
    }
    this.spC = ((AudioManager)paramr).getStreamVolume(3);
    paramr = aj.getContext().getSystemService("audio");
    if (paramr == null)
    {
      paramr = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(203327);
      throw paramr;
    }
    int j = ((AudioManager)paramr).getStreamMaxVolume(3);
    i = 0;
    if (this.spB != this.spC) {
      i = 1;
    }
    this.spD = (this.spB * 100 / j + '#' + this.spC * 100 / j + '#' + i);
    paramr = h.soM;
    this.netType = h.cDz();
    paramr = ((Iterable)this.spA).iterator();
    while (paramr.hasNext())
    {
      i = ((Number)paramr.next()).intValue();
      localObject = this.spz;
      this.spz = ((String)localObject + i + '#');
    }
    paramr = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
    localObject = com.tencent.mm.plugin.finder.storage.logic.c.aiD(localb.sqP).field_fileFormat;
    paramr = (r)localObject;
    if (localObject == null) {
      paramr = "";
    }
    int m = 0;
    int n = 0;
    int i1 = 0;
    localObject = localb.sqQ;
    int k = i1;
    j = n;
    i = m;
    if (localObject != null)
    {
      localObject = e.axx(((m)localObject).getPath());
      k = i1;
      j = n;
      i = m;
      if (localObject != null)
      {
        j = ((a)localObject).videoBitrate;
        i = ((a)localObject).audioBitrate;
        k = ((a)localObject).frameRate;
      }
    }
    this.spE = (localb.srB + ';' + j + ';' + paramr + ';' + i + ';' + k + ';' + localb.srC + ';' + localb.srD + ';');
    AppMethodBeat.o(203327);
    return;
    label625:
    AppMethodBeat.o(203327);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203334);
    if (this != paramObject)
    {
      if ((paramObject instanceof l))
      {
        paramObject = (l)paramObject;
        if ((this.dtq != paramObject.dtq) || (this.startTime != paramObject.startTime) || (!p.i(this.feed, paramObject.feed)) || (!p.i(this.rRb, paramObject.rRb)) || (this.spF != paramObject.spF) || (!p.i(this.snM, paramObject.snM))) {}
      }
    }
    else
    {
      AppMethodBeat.o(203334);
      return true;
    }
    AppMethodBeat.o(203334);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203332);
    String str = "FinderSingleFeedRecord(feedId=" + this.dtq + ", startTime=" + this.startTime + ", feed=" + this.feed + ", showInfo=" + this.rRb + ", isCenterFeed=" + this.spF + ", videoPlayReporter=" + this.snM + ")";
    AppMethodBeat.o(203332);
    return str;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord$Companion;", "", "()V", "FinderStatsReportFeedTypeRelated", "", "getFinderStatsReportFeedTypeRelated", "()I", "FinderStatsReportFeedTypeStream", "getFinderStatsReportFeedTypeStream", "TAG", "", "getTAG", "()Ljava/lang/String;", "expandNotZeroValue", "", "sb", "Ljava/lang/StringBuffer;", "key", "value", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Long;)V", "printStats", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "trans2Stats", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
  public static final class a
  {
    public static dij a(l paraml, aqy paramaqy)
    {
      int k = 1;
      AppMethodBeat.i(203323);
      p.h(paraml, "record");
      p.h(paramaqy, "contextObj");
      dij localdij = new dij();
      BitSet localBitSet = new BitSet(64);
      localdij.rIZ = paraml.dtq;
      Object localObject1 = paraml.feed;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((FinderItem)localObject1).getObjectNonceId();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localdij.objectNonceId = ((String)localObject1);
      localdij.Hxf = new ly();
      localdij.Hxg = new duh();
      localdij.Hxh = new cgq();
      localObject1 = paraml.feed;
      if (localObject1 != null)
      {
        localObject2 = ((FinderItem)localObject1).field_username;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localdij.rTn = ((String)localObject1);
      localdij.Hxi = paraml.soX;
      if (paramaqy.rTD == 20)
      {
        localObject1 = g.szT;
        localObject1 = g.wW(paraml.dtq);
        if ((localObject1 == null) || (((FinderItem)localObject1).isRelatedItem() != true)) {
          break label266;
        }
      }
      int j;
      label266:
      for (int i = l.cDD();; i = l.cDC())
      {
        localdij.Hxj = i;
        localObject1 = h.soM;
        localdij.sessionBuffer = h.I(paraml.dtq, paramaqy.rTD);
        j = paraml.spf;
        i = 0;
        while (i < j)
        {
          localBitSet.set(i, true);
          i += 1;
        }
      }
      float f;
      label313:
      label327:
      int m;
      if (paraml.sph < 5)
      {
        localBitSet.set(9, true);
        f = (float)paraml.dBD / 1000.0F;
        if (f >= 0.5F) {
          break label569;
        }
        localBitSet.set(21, true);
        paramaqy = paraml.spc;
        int n = paramaqy.length;
        j = 0;
        i = 0;
        if (j >= n) {
          break label740;
        }
        m = paramaqy[j];
        if (m <= i) {
          break label1304;
        }
        i = m;
      }
      label1289:
      label1294:
      label1299:
      label1304:
      for (;;)
      {
        j += 1;
        break label327;
        if (paraml.sph < 10)
        {
          localBitSet.set(10, true);
          break;
        }
        if (paraml.sph < 20)
        {
          localBitSet.set(11, true);
          break;
        }
        if (paraml.sph < 30)
        {
          localBitSet.set(12, true);
          break;
        }
        if (paraml.sph < 40)
        {
          localBitSet.set(13, true);
          break;
        }
        if (paraml.sph < 50)
        {
          localBitSet.set(14, true);
          break;
        }
        if (paraml.sph < 60)
        {
          localBitSet.set(15, true);
          break;
        }
        if (paraml.sph < 70)
        {
          localBitSet.set(16, true);
          break;
        }
        if (paraml.sph < 80)
        {
          localBitSet.set(17, true);
          break;
        }
        if (paraml.sph < 90)
        {
          localBitSet.set(18, true);
          break;
        }
        if (paraml.sph < 100)
        {
          localBitSet.set(19, true);
          break;
        }
        localBitSet.set(20, true);
        break;
        label569:
        if (f < 1.0F)
        {
          localBitSet.set(22, true);
          break label313;
        }
        if (f < 2.0F)
        {
          localBitSet.set(23, true);
          break label313;
        }
        if (f < 3.0F)
        {
          localBitSet.set(24, true);
          break label313;
        }
        if (f < 5.0F)
        {
          localBitSet.set(25, true);
          break label313;
        }
        if (f < 10.0F)
        {
          localBitSet.set(26, true);
          break label313;
        }
        if (f < 20.0F)
        {
          localBitSet.set(27, true);
          break label313;
        }
        if (f < 30.0F)
        {
          localBitSet.set(28, true);
          break label313;
        }
        if (f < 40.0F)
        {
          localBitSet.set(29, true);
          break label313;
        }
        if (f < 50.0F)
        {
          localBitSet.set(30, true);
          break label313;
        }
        localBitSet.set(31, true);
        break label313;
        label740:
        if (i == 0) {
          localBitSet.set(32, true);
        }
        for (;;)
        {
          long l = localBitSet.toLongArray()[0];
          localdij.Hxf.FEM = l;
          localdij.Hxg.zMn = ((int)f);
          localdij.Hxg.HHd = paraml.videoDuration;
          localdij.Hxg.qXg = paraml.dBD;
          localdij.Hxg.HHe = paraml.spv;
          localdij.Hxg.HHf = paraml.spt;
          localdij.Hxh.GZJ = ((int)f);
          localdij.Hxh.GZK = i;
          localdij.Hxh.GZI = paraml.sph;
          paramaqy = paraml.soZ;
          m = paramaqy.length;
          j = 0;
          i = 0;
          while (j < m)
          {
            if (paramaqy[j] > 0L) {
              localdij.Hxh.GZH = i;
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
        localdij.Hxh.GZL = paraml.liA;
        paramaqy = localdij.Hxh;
        if (paraml.liA > 0)
        {
          i = 1;
          paramaqy.GZN = i;
          localdij.Hxh.spi = paraml.spi;
          localdij.Hxh.GZM = paraml.spj;
          localdij.Hxh.GZV = paraml.sps;
          localdij.Hxh.GZT = paraml.soY;
          localdij.Hxh.GZW = paraml.spn;
          localdij.Hxh.GZX = paraml.spl;
          localdij.Hxh.GZY = paraml.spm;
          localdij.Hxh.spn = paraml.spn;
          localdij.Hxh.spo = paraml.spo;
          localdij.Hxh.spp = paraml.spp;
          localdij.Hxh.spq = paraml.spq;
          localdij.Hxh.spr = paraml.spr;
          paramaqy = paraml.feed;
          if (paramaqy != null)
          {
            localObject1 = localdij.Hxh;
            if (paramaqy.getLikeFlag() == 0) {
              break label1289;
            }
            i = 1;
            label1204:
            ((cgq)localObject1).GZP = i;
            localObject1 = localdij.Hxh;
            localObject2 = com.tencent.mm.plugin.finder.api.c.rHn;
            if (!c.a.agZ(paramaqy.getUserName())) {
              break label1294;
            }
            i = 1;
            label1234:
            ((cgq)localObject1).GZO = i;
            localObject1 = localdij.Hxh;
            if (paramaqy.getFavFlag() != 1) {
              break label1299;
            }
          }
        }
        for (i = k;; i = 0)
        {
          ((cgq)localObject1).GZR = i;
          localdij.Hxh.GZU = paraml.spg;
          AppMethodBeat.o(203323);
          return localdij;
          i = 0;
          break;
          i = 0;
          break label1204;
          i = 0;
          break label1234;
        }
      }
    }
    
    public static void a(dij paramdij, String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(203324);
      p.h(paramdij, "stats");
      p.h(paramString, "tag");
      StringBuffer localStringBuffer = new StringBuffer("[Stats]\n");
      Object localObject1 = l.spI;
      a(localStringBuffer, "feedId", Long.valueOf(paramdij.rIZ));
      if (i.DEBUG)
      {
        localStringBuffer.append("strfeedId=" + com.tencent.mm.ad.c.rc(paramdij.rIZ) + '\n');
        localObject1 = d.szI;
        localObject1 = d.a.wT(paramdij.rIZ);
        if (localObject1 != null) {
          localStringBuffer.append("nick=" + ((FinderItem)localObject1).getNickName() + ", desc=" + ((FinderItem)localObject1).getDebugDescription() + '\n');
        }
      }
      localObject1 = l.spI;
      localObject1 = paramdij.Hxg;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((duh)localObject1).HHd);
        a(localStringBuffer, "vidPlayLen", (Integer)localObject1);
        localObject1 = l.spI;
        localObject1 = paramdij.Hxg;
        if (localObject1 == null) {
          break label900;
        }
        localObject1 = Integer.valueOf(((duh)localObject1).zMn);
        label204:
        a(localStringBuffer, "stayTime", (Integer)localObject1);
        localObject1 = l.spI;
        localObject1 = paramdij.Hxg;
        if (localObject1 == null) {
          break label905;
        }
        localObject1 = Long.valueOf(((duh)localObject1).qXg);
        label234:
        a(localStringBuffer, "stayTimeMs", (Long)localObject1);
        localObject1 = l.spI;
        localObject1 = paramdij.Hxg;
        if (localObject1 == null) {
          break label910;
        }
        localObject1 = Long.valueOf(((duh)localObject1).HHe);
        label264:
        a(localStringBuffer, "vidPlayTimeMs", (Long)localObject1);
        localObject1 = l.spI;
        localObject1 = paramdij.Hxg;
        if (localObject1 == null) {
          break label915;
        }
      }
      label900:
      label905:
      label910:
      label915:
      for (localObject1 = Long.valueOf(((duh)localObject1).HHf);; localObject1 = null)
      {
        a(localStringBuffer, "vidPlayingTimeMs", (Long)localObject1);
        localObject1 = l.spI;
        a(localStringBuffer, "share", Integer.valueOf(paramdij.Hxh.GZN));
        localObject1 = l.spI;
        a(localStringBuffer, "forward_times", Integer.valueOf(paramdij.Hxh.GZL));
        localObject1 = l.spI;
        a(localStringBuffer, "feed_stay_time", Integer.valueOf(paramdij.Hxh.GZJ));
        localObject1 = l.spI;
        a(localStringBuffer, "vid_replay_times", Integer.valueOf(paramdij.Hxh.GZK));
        localObject1 = l.spI;
        a(localStringBuffer, "max_vid_play_progress", Integer.valueOf(paramdij.Hxh.GZI));
        localObject1 = l.spI;
        a(localStringBuffer, "pageTurn", Integer.valueOf(paramdij.Hxh.GZH));
        localObject1 = l.spI;
        a(localStringBuffer, "clickComment", Integer.valueOf(paramdij.Hxh.spi));
        localObject1 = l.spI;
        a(localStringBuffer, "clickHead", Integer.valueOf(paramdij.Hxh.GZM));
        localObject1 = l.spI;
        a(localStringBuffer, "likeStatus", Integer.valueOf(paramdij.Hxh.GZP));
        localObject1 = l.spI;
        a(localStringBuffer, "followStatus", Integer.valueOf(paramdij.Hxh.GZO));
        localObject1 = l.spI;
        a(localStringBuffer, "favStatus", Integer.valueOf(paramdij.Hxh.GZR));
        localObject1 = l.spI;
        a(localStringBuffer, "notInterestAction", Integer.valueOf(paramdij.Hxh.GZV));
        localObject1 = l.spI;
        a(localStringBuffer, "fastSlip", Integer.valueOf(paramdij.Hxh.GZS));
        localObject1 = l.spI;
        a(localStringBuffer, "sortId", Integer.valueOf(paramdij.Hxh.GZT));
        localObject1 = l.spI;
        a(localStringBuffer, "maxVidPlayLen", Integer.valueOf(paramdij.Hxh.GZU));
        localObject1 = l.spI;
        a(localStringBuffer, "clickTopicTimes", Integer.valueOf(paramdij.Hxh.GZW));
        localObject1 = l.spI;
        a(localStringBuffer, "expandTextTimes", Integer.valueOf(paramdij.Hxh.GZX));
        localObject1 = l.spI;
        a(localStringBuffer, "shareMomentTimes", Integer.valueOf(paramdij.Hxh.GZY));
        localObject1 = l.spI;
        a(localStringBuffer, "clickPoiTimes", Integer.valueOf(paramdij.Hxh.spn));
        localObject1 = l.spI;
        a(localStringBuffer, "collapseTextTimes", Integer.valueOf(paramdij.Hxh.spo));
        localObject1 = l.spI;
        a(localStringBuffer, "commentLikeTimes", Integer.valueOf(paramdij.Hxh.spp));
        localObject1 = l.spI;
        a(localStringBuffer, "clickFeedMenu", Integer.valueOf(paramdij.Hxh.spq));
        localObject1 = l.spI;
        a(localStringBuffer, "complainTimes", Integer.valueOf(paramdij.Hxh.spr));
        localObject1 = l.spI;
        a(localStringBuffer, "actionTimeMs", Long.valueOf(paramdij.Hxi));
        localObject1 = l.spI;
        a(localStringBuffer, "feedScene", Integer.valueOf(paramdij.Hxj));
        localObject1 = l.spI;
        localObject1 = paramdij.sessionBuffer;
        paramdij = localObject2;
        if (localObject1 != null) {
          paramdij = Integer.valueOf(((String)localObject1).length());
        }
        a(localStringBuffer, "sessionBuffer", paramdij);
        ad.i(paramString, localStringBuffer.toString());
        AppMethodBeat.o(203324);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label204;
        localObject1 = null;
        break label234;
        localObject1 = null;
        break label264;
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Integer paramInteger)
    {
      AppMethodBeat.i(203326);
      p.h(paramStringBuffer, "sb");
      p.h(paramString, "key");
      if (paramInteger == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramInteger + '\n');
        do
        {
          AppMethodBeat.o(203326);
          return;
        } while (paramInteger.intValue() == 0);
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Long paramLong)
    {
      AppMethodBeat.i(203325);
      p.h(paramStringBuffer, "sb");
      p.h(paramString, "key");
      if (paramLong == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramLong + '\n');
        do
        {
          AppMethodBeat.o(203325);
          return;
        } while (paramLong.longValue() == 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.l
 * JD-Core Version:    0.7.0.1
 */