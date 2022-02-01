package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.view.recyclerview.f;
import d.g.b.p;
import d.l;
import d.v;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "isCenterFeed", "", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;ZLcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "changePageTime", "", "getChangePageTime", "()[J", "setChangePageTime", "([J)V", "clickAvatar", "", "getClickAvatar", "()I", "setClickAvatar", "(I)V", "clickComment", "getClickComment", "setClickComment", "clickExpandText", "getClickExpandText", "setClickExpandText", "clickFav", "getClickFav", "setClickFav", "clickFeedMenu", "getClickFeedMenu", "setClickFeedMenu", "clickPoiTimes", "getClickPoiTimes", "setClickPoiTimes", "clickShareMoments", "getClickShareMoments", "setClickShareMoments", "collapseTextTimes", "getCollapseTextTimes", "setCollapseTextTimes", "commentLikeTimes", "getCommentLikeTimes", "setCommentLikeTimes", "complainTimes", "getComplainTimes", "setComplainTimes", "createTimestamp", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "endTime", "getEndTime", "setEndTime", "endVolume", "getEndVolume", "setEndVolume", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "getFeedDataPos", "setFeedDataPos", "getFeedId", "()Z", "setCenterFeed", "(Z)V", "isPause", "setPause", "isSeek", "setSeek", "lastPageIndex", "getLastPageIndex", "setLastPageIndex", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "maxReplayCount", "getMaxReplayCount", "setMaxReplayCount", "netType", "getNetType", "setNetType", "notInterest", "getNotInterest", "setNotInterest", "pageVideoPlayPercent", "", "getPageVideoPlayPercent", "()[I", "setPageVideoPlayPercent", "([I)V", "pageVideoReplayCount", "getPageVideoReplayCount", "setPageVideoReplayCount", "playFormat", "", "getPlayFormat", "()Ljava/lang/String;", "setPlayFormat", "(Ljava/lang/String;)V", "playProgressInfo", "getPlayProgressInfo", "setPlayProgressInfo", "playProgressSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayProgressSet", "()Ljava/util/HashSet;", "setPlayProgressSet", "(Ljava/util/HashSet;)V", "playTime", "getPlayTime", "setPlayTime", "playTimestamp", "getPlayTimestamp", "setPlayTimestamp", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "shareCount", "getShareCount", "setShareCount", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "startVolume", "getStartVolume", "setStartVolume", "stayTime", "getStayTime", "setStayTime", "videoDuration", "getVideoDuration", "setVideoDuration", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "setVideoPlayReporter", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;)V", "viewPageDuration", "getViewPageDuration", "setViewPageDuration", "voiceInfo", "getVoiceInfo", "setVoiceInfo", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "copyRecord", "equals", "other", "hashCode", "onRelease", "", "toString", "Companion", "plugin-finder_release"})
public final class m
{
  private static final String TAG = "Finder.FinderSingleFeedRecord";
  private static final int szR = 1;
  private static final int szS = 2;
  public static final a szT;
  public long dCI;
  public final long duw;
  public long endTime;
  public final FinderItem feed;
  public int lmm;
  public int netType;
  public f rZD;
  BaseFinderFeed ssN;
  public final long startTime;
  public s sxD;
  public int szA;
  public int szB;
  public int szC;
  public int szD;
  public long szE;
  public long szF;
  public long szG;
  public long szH;
  public int szI;
  public int szJ;
  public String szK;
  public HashSet<Integer> szL;
  public int szM;
  public int szN;
  public String szO;
  String szP;
  public boolean szQ;
  public long szi;
  public int szj;
  public long[] szk;
  public long[] szl;
  public int[] szm;
  public int[] szn;
  public int szo;
  public int szp;
  public int szq;
  public int szr;
  public int szs;
  public int szt;
  public int szu;
  public int szv;
  public int szw;
  public int szx;
  public int szy;
  public int szz;
  public int videoDuration;
  
  static
  {
    AppMethodBeat.i(203890);
    szT = new a((byte)0);
    TAG = "Finder.FinderSingleFeedRecord";
    szR = 1;
    szS = 2;
    AppMethodBeat.o(203890);
  }
  
  public m(long paramLong1, long paramLong2, FinderItem paramFinderItem, f paramf, boolean paramBoolean, s params)
  {
    AppMethodBeat.i(203888);
    this.duw = paramLong1;
    this.startTime = paramLong2;
    this.feed = paramFinderItem;
    this.rZD = paramf;
    this.szQ = paramBoolean;
    this.sxD = params;
    this.szi = ch.aDc();
    paramFinderItem = new long[9];
    int i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.szk = paramFinderItem;
    paramFinderItem = new long[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.szl = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.szm = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.szn = paramFinderItem;
    this.szq = 1;
    this.szK = "";
    this.szL = new HashSet();
    this.szO = "";
    this.szP = "";
    this.szk[0] = this.startTime;
    paramFinderItem = this.sxD;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.DQY;
      if (paramFinderItem != null)
      {
        paramFinderItem = (s.b)paramFinderItem.get(Long.valueOf(this.duw));
        if (paramFinderItem != null)
        {
          this.szH = this.startTime;
          if (paramFinderItem.bfZ) {
            this.szF = this.startTime;
          }
          paramFinderItem = ak.getContext().getSystemService("audio");
          if (paramFinderItem == null)
          {
            paramFinderItem = new v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(203888);
            throw paramFinderItem;
          }
          this.szM = ((AudioManager)paramFinderItem).getStreamVolume(3);
          AppMethodBeat.o(203888);
          return;
        }
      }
    }
    AppMethodBeat.o(203888);
  }
  
  public final void a(s params)
  {
    AppMethodBeat.i(203886);
    if (this.endTime == 0L) {
      this.endTime = ch.aDc();
    }
    Object localObject = this.feed;
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getMediaList();
      if (localObject != null)
      {
        localObject = (bvz)d.a.j.jm((List)localObject);
        if (localObject == null) {}
      }
    }
    s.b localb;
    for (int i = ((bvz)localObject).videoDuration;; i = 0)
    {
      this.videoDuration = i;
      if (this.szQ) {
        this.dCI = (this.endTime - this.startTime);
      }
      if (params == null) {
        break label625;
      }
      params = params.DQY;
      if (params == null) {
        break label625;
      }
      localb = (s.b)params.get(Long.valueOf(this.duw));
      if (localb == null) {
        break label625;
      }
      if (this.szH != 0L) {
        this.szG += this.endTime - this.szH;
      }
      if (this.szF != 0L) {
        this.szE += this.endTime - this.szF;
      }
      params = ak.getContext().getSystemService("audio");
      if (params != null) {
        break;
      }
      params = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(203886);
      throw params;
    }
    this.szN = ((AudioManager)params).getStreamVolume(3);
    params = ak.getContext().getSystemService("audio");
    if (params == null)
    {
      params = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(203886);
      throw params;
    }
    int j = ((AudioManager)params).getStreamMaxVolume(3);
    i = 0;
    if (this.szM != this.szN) {
      i = 1;
    }
    this.szO = (this.szM * 100 / j + '#' + this.szN * 100 / j + '#' + i);
    params = i.syT;
    this.netType = i.cFu();
    params = ((Iterable)this.szL).iterator();
    while (params.hasNext())
    {
      i = ((Number)params.next()).intValue();
      localObject = this.szK;
      this.szK = ((String)localObject + i + '#');
    }
    params = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
    localObject = com.tencent.mm.plugin.finder.storage.logic.c.ajA(localb.sBa).field_fileFormat;
    params = (s)localObject;
    if (localObject == null) {
      params = "";
    }
    int m = 0;
    int n = 0;
    int i1 = 0;
    localObject = localb.sBb;
    int k = i1;
    j = n;
    i = m;
    if (localObject != null)
    {
      localObject = e.ayN(((com.tencent.mm.plugin.finder.loader.m)localObject).getPath());
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
    this.szP = (localb.sBL + ';' + j + ';' + params + ';' + i + ';' + k + ';' + localb.sBM + ';' + localb.sBN + ';');
    AppMethodBeat.o(203886);
    return;
    label625:
    AppMethodBeat.o(203886);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203893);
    if (this != paramObject)
    {
      if ((paramObject instanceof m))
      {
        paramObject = (m)paramObject;
        if ((this.duw != paramObject.duw) || (this.startTime != paramObject.startTime) || (!p.i(this.feed, paramObject.feed)) || (!p.i(this.rZD, paramObject.rZD)) || (this.szQ != paramObject.szQ) || (!p.i(this.sxD, paramObject.sxD))) {}
      }
    }
    else
    {
      AppMethodBeat.o(203893);
      return true;
    }
    AppMethodBeat.o(203893);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203891);
    String str = "FinderSingleFeedRecord(feedId=" + this.duw + ", startTime=" + this.startTime + ", feed=" + this.feed + ", showInfo=" + this.rZD + ", isCenterFeed=" + this.szQ + ", videoPlayReporter=" + this.sxD + ")";
    AppMethodBeat.o(203891);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord$Companion;", "", "()V", "FinderStatsReportFeedTypeRelated", "", "getFinderStatsReportFeedTypeRelated", "()I", "FinderStatsReportFeedTypeStream", "getFinderStatsReportFeedTypeStream", "TAG", "", "getTAG", "()Ljava/lang/String;", "expandNotZeroValue", "", "sb", "Ljava/lang/StringBuffer;", "key", "value", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Long;)V", "printStats", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "trans2Stats", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
  public static final class a
  {
    public static dje a(m paramm, arn paramarn)
    {
      int k = 1;
      AppMethodBeat.i(203882);
      p.h(paramm, "record");
      p.h(paramarn, "contextObj");
      dje localdje = new dje();
      BitSet localBitSet = new BitSet(64);
      localdje.rRn = paramm.duw;
      Object localObject1 = paramm.feed;
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
      localdje.objectNonceId = ((String)localObject1);
      localdje.HQO = new ly();
      localdje.HQP = new dve();
      localdje.HQQ = new chk();
      localObject1 = paramm.feed;
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
      localdje.sbR = ((String)localObject1);
      localdje.HQR = paramm.szi;
      if (paramarn.sch == 20)
      {
        localObject1 = g.sKQ;
        localObject1 = g.xn(paramm.duw);
        if ((localObject1 == null) || (((FinderItem)localObject1).isRelatedItem() != true)) {
          break label296;
        }
      }
      int j;
      label296:
      for (int i = m.cFz();; i = m.cFy())
      {
        localdje.HQS = i;
        localObject1 = i.syT;
        localdje.sessionBuffer = i.I(paramm.duw, paramarn.sch);
        localObject1 = d.sKD;
        localdje.HQU = d.a.ae(paramarn.sch, paramm.duw);
        localdje.OzM = paramm.startTime;
        j = paramm.szq;
        i = 0;
        while (i < j)
        {
          localBitSet.set(i, true);
          i += 1;
        }
      }
      float f;
      label343:
      label357:
      int m;
      if (paramm.szs < 5)
      {
        localBitSet.set(9, true);
        f = (float)paramm.dCI / 1000.0F;
        if (f >= 0.5F) {
          break label599;
        }
        localBitSet.set(21, true);
        paramarn = paramm.szn;
        int n = paramarn.length;
        j = 0;
        i = 0;
        if (j >= n) {
          break label770;
        }
        m = paramarn[j];
        if (m <= i) {
          break label1500;
        }
        i = m;
      }
      label599:
      label1495:
      label1500:
      for (;;)
      {
        j += 1;
        break label357;
        if (paramm.szs < 10)
        {
          localBitSet.set(10, true);
          break;
        }
        if (paramm.szs < 20)
        {
          localBitSet.set(11, true);
          break;
        }
        if (paramm.szs < 30)
        {
          localBitSet.set(12, true);
          break;
        }
        if (paramm.szs < 40)
        {
          localBitSet.set(13, true);
          break;
        }
        if (paramm.szs < 50)
        {
          localBitSet.set(14, true);
          break;
        }
        if (paramm.szs < 60)
        {
          localBitSet.set(15, true);
          break;
        }
        if (paramm.szs < 70)
        {
          localBitSet.set(16, true);
          break;
        }
        if (paramm.szs < 80)
        {
          localBitSet.set(17, true);
          break;
        }
        if (paramm.szs < 90)
        {
          localBitSet.set(18, true);
          break;
        }
        if (paramm.szs < 100)
        {
          localBitSet.set(19, true);
          break;
        }
        localBitSet.set(20, true);
        break;
        if (f < 1.0F)
        {
          localBitSet.set(22, true);
          break label343;
        }
        if (f < 2.0F)
        {
          localBitSet.set(23, true);
          break label343;
        }
        if (f < 3.0F)
        {
          localBitSet.set(24, true);
          break label343;
        }
        if (f < 5.0F)
        {
          localBitSet.set(25, true);
          break label343;
        }
        if (f < 10.0F)
        {
          localBitSet.set(26, true);
          break label343;
        }
        if (f < 20.0F)
        {
          localBitSet.set(27, true);
          break label343;
        }
        if (f < 30.0F)
        {
          localBitSet.set(28, true);
          break label343;
        }
        if (f < 40.0F)
        {
          localBitSet.set(29, true);
          break label343;
        }
        if (f < 50.0F)
        {
          localBitSet.set(30, true);
          break label343;
        }
        localBitSet.set(31, true);
        break label343;
        if (i == 0) {
          localBitSet.set(32, true);
        }
        for (;;)
        {
          long l = localBitSet.toLongArray()[0];
          paramarn = localdje.HQO;
          if (paramarn != null) {
            paramarn.FXh = l;
          }
          paramarn = localdje.HQP;
          if (paramarn != null) {
            paramarn.Adu = ((int)f);
          }
          paramarn = localdje.HQP;
          if (paramarn != null) {
            paramarn.IaQ = paramm.videoDuration;
          }
          paramarn = localdje.HQP;
          if (paramarn != null) {
            paramarn.rfl = paramm.dCI;
          }
          paramarn = localdje.HQP;
          if (paramarn != null) {
            paramarn.IaR = paramm.szG;
          }
          paramarn = localdje.HQP;
          if (paramarn != null) {
            paramarn.IaS = paramm.szE;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htk = ((int)f);
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htl = i;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htj = paramm.szs;
          }
          paramarn = paramm.szk;
          m = paramarn.length;
          j = 0;
          i = 0;
          while (j < m)
          {
            if (paramarn[j] > 0L)
            {
              localObject1 = localdje.HQQ;
              if (localObject1 != null) {
                ((chk)localObject1).Hti = i;
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
        paramarn = localdje.HQQ;
        if (paramarn != null) {
          paramarn.Htm = paramm.lmm;
        }
        paramarn = localdje.HQQ;
        if (paramarn != null)
        {
          if (paramm.lmm > 0)
          {
            i = 1;
            paramarn.Hto = i;
          }
        }
        else
        {
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.szt = paramm.szt;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htn = paramm.szu;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htv = paramm.szD;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htt = paramm.szj;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htw = paramm.szy;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htx = paramm.szw;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Hty = paramm.szx;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.szy = paramm.szy;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.szz = paramm.szz;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.szA = paramm.szA;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.szB = paramm.szB;
          }
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.szC = paramm.szC;
          }
          paramarn = paramm.feed;
          if (paramarn != null)
          {
            localObject1 = localdje.HQQ;
            if (localObject1 != null)
            {
              if (paramarn.getLikeFlag() == 0) {
                break label1485;
              }
              i = 1;
              label1384:
              ((chk)localObject1).Htp = i;
            }
            localObject1 = localdje.HQQ;
            if (localObject1 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.api.c.rPy;
              if (!c.a.ahW(paramarn.getUserName())) {
                break label1490;
              }
              i = 1;
              ((chk)localObject1).sSH = i;
            }
            localObject1 = localdje.HQQ;
            if (localObject1 != null) {
              if (paramarn.getFavFlag() != 1) {
                break label1495;
              }
            }
          }
        }
        for (i = k;; i = 0)
        {
          ((chk)localObject1).Htr = i;
          paramarn = localdje.HQQ;
          if (paramarn != null) {
            paramarn.Htu = paramm.szr;
          }
          AppMethodBeat.o(203882);
          return localdje;
          i = 0;
          break;
          i = 0;
          break label1384;
          i = 0;
          break label1419;
        }
      }
    }
    
    public static void a(dje paramdje, String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(203883);
      p.h(paramdje, "stats");
      p.h(paramString, "tag");
      StringBuffer localStringBuffer = new StringBuffer("[Stats]\n");
      Object localObject1 = m.szT;
      a(localStringBuffer, "feedId", Long.valueOf(paramdje.rRn));
      if (com.tencent.mm.sdk.platformtools.j.DEBUG)
      {
        localStringBuffer.append("strfeedId=" + com.tencent.mm.ac.c.rp(paramdje.rRn) + '\n');
        localObject1 = d.sKD;
        localObject1 = d.a.xk(paramdje.rRn);
        if (localObject1 != null) {
          localStringBuffer.append("nick=" + ((FinderItem)localObject1).getNickName() + ", desc=" + ((FinderItem)localObject1).getDebugDescription() + '\n');
        }
      }
      localObject1 = m.szT;
      localObject1 = paramdje.HQP;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((dve)localObject1).IaQ);
        a(localStringBuffer, "vidPlayLen", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQP;
        if (localObject1 == null) {
          break label1084;
        }
        localObject1 = Integer.valueOf(((dve)localObject1).Adu);
        label204:
        a(localStringBuffer, "stayTime", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQP;
        if (localObject1 == null) {
          break label1089;
        }
        localObject1 = Long.valueOf(((dve)localObject1).rfl);
        label234:
        a(localStringBuffer, "stayTimeMs", (Long)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQP;
        if (localObject1 == null) {
          break label1094;
        }
        localObject1 = Long.valueOf(((dve)localObject1).IaR);
        label264:
        a(localStringBuffer, "vidPlayTimeMs", (Long)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQP;
        if (localObject1 == null) {
          break label1099;
        }
        localObject1 = Long.valueOf(((dve)localObject1).IaS);
        label294:
        a(localStringBuffer, "vidPlayingTimeMs", (Long)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1104;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Hto);
        label324:
        a(localStringBuffer, "share", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1109;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htm);
        label354:
        a(localStringBuffer, "forward_times", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1114;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htk);
        label384:
        a(localStringBuffer, "feed_stay_time", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1119;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htl);
        label414:
        a(localStringBuffer, "vid_replay_times", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1124;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htj);
        label444:
        a(localStringBuffer, "max_vid_play_progress", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1129;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Hti);
        label474:
        a(localStringBuffer, "pageTurn", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1134;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).szt);
        label504:
        a(localStringBuffer, "clickComment", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1139;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htn);
        label534:
        a(localStringBuffer, "clickHead", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1144;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htp);
        label564:
        a(localStringBuffer, "likeStatus", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1149;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).sSH);
        label594:
        a(localStringBuffer, "followStatus", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1154;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htr);
        label624:
        a(localStringBuffer, "favStatus", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1159;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htv);
        label654:
        a(localStringBuffer, "notInterestAction", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1164;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Hts);
        label684:
        a(localStringBuffer, "fastSlip", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1169;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htt);
        label714:
        a(localStringBuffer, "sortId", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1174;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htu);
        label744:
        a(localStringBuffer, "maxVidPlayLen", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1179;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htw);
        label774:
        a(localStringBuffer, "clickTopicTimes", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1184;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Htx);
        label804:
        a(localStringBuffer, "expandTextTimes", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1189;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).Hty);
        label834:
        a(localStringBuffer, "shareMomentTimes", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1194;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).szy);
        label864:
        a(localStringBuffer, "clickPoiTimes", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1199;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).szz);
        label894:
        a(localStringBuffer, "collapseTextTimes", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1204;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).szA);
        label924:
        a(localStringBuffer, "commentLikeTimes", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1209;
        }
        localObject1 = Integer.valueOf(((chk)localObject1).szB);
        label954:
        a(localStringBuffer, "clickFeedMenu", (Integer)localObject1);
        localObject1 = m.szT;
        localObject1 = paramdje.HQQ;
        if (localObject1 == null) {
          break label1214;
        }
      }
      label1084:
      label1214:
      for (localObject1 = Integer.valueOf(((chk)localObject1).szC);; localObject1 = null)
      {
        a(localStringBuffer, "complainTimes", (Integer)localObject1);
        localObject1 = m.szT;
        a(localStringBuffer, "actionTimeMs", Long.valueOf(paramdje.HQR));
        localObject1 = m.szT;
        a(localStringBuffer, "feedScene", Integer.valueOf(paramdje.HQS));
        localObject1 = m.szT;
        localObject1 = paramdje.sessionBuffer;
        paramdje = localObject2;
        if (localObject1 != null) {
          paramdje = Integer.valueOf(((String)localObject1).length());
        }
        a(localStringBuffer, "sessionBuffer", paramdje);
        ae.i(paramString, localStringBuffer.toString());
        AppMethodBeat.o(203883);
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
      AppMethodBeat.i(203885);
      p.h(paramStringBuffer, "sb");
      p.h(paramString, "key");
      if (paramInteger == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramInteger + '\n');
        do
        {
          AppMethodBeat.o(203885);
          return;
        } while (paramInteger.intValue() == 0);
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Long paramLong)
    {
      AppMethodBeat.i(203884);
      p.h(paramStringBuffer, "sb");
      p.h(paramString, "key");
      if (paramLong == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramLong + '\n');
        do
        {
          AppMethodBeat.o(203884);
          return;
        } while (paramLong.longValue() == 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m
 * JD-Core Version:    0.7.0.1
 */