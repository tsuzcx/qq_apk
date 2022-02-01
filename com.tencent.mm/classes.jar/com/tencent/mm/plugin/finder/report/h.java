package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.lo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.recyclerview.f;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "isCenterFeed", "", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;ZLcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;)V", "changePageTime", "", "getChangePageTime", "()[J", "setChangePageTime", "([J)V", "clickAvatar", "", "getClickAvatar", "()I", "setClickAvatar", "(I)V", "clickComment", "getClickComment", "setClickComment", "clickExpandText", "getClickExpandText", "setClickExpandText", "clickFav", "getClickFav", "setClickFav", "clickFeedMenu", "getClickFeedMenu", "setClickFeedMenu", "clickPoiTimes", "getClickPoiTimes", "setClickPoiTimes", "clickShareMoments", "getClickShareMoments", "setClickShareMoments", "collapseTextTimes", "getCollapseTextTimes", "setCollapseTextTimes", "commentLikeTimes", "getCommentLikeTimes", "setCommentLikeTimes", "complainTimes", "getComplainTimes", "setComplainTimes", "createTimestamp", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "endTime", "getEndTime", "setEndTime", "endVolume", "getEndVolume", "setEndVolume", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "getFeedDataPos", "setFeedDataPos", "getFeedId", "()Z", "setCenterFeed", "(Z)V", "isPause", "setPause", "isSeek", "setSeek", "lastPageIndex", "getLastPageIndex", "setLastPageIndex", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "maxReplayCount", "getMaxReplayCount", "setMaxReplayCount", "netType", "getNetType", "setNetType", "notInterest", "getNotInterest", "setNotInterest", "pageVideoPlayPercent", "", "getPageVideoPlayPercent", "()[I", "setPageVideoPlayPercent", "([I)V", "pageVideoReplayCount", "getPageVideoReplayCount", "setPageVideoReplayCount", "playProgressInfo", "", "getPlayProgressInfo", "()Ljava/lang/String;", "setPlayProgressInfo", "(Ljava/lang/String;)V", "playProgressSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayProgressSet", "()Ljava/util/HashSet;", "setPlayProgressSet", "(Ljava/util/HashSet;)V", "playTime", "getPlayTime", "setPlayTime", "playTimestamp", "getPlayTimestamp", "setPlayTimestamp", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "shareCount", "getShareCount", "setShareCount", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "startVolume", "getStartVolume", "setStartVolume", "stayTime", "getStayTime", "setStayTime", "videoDuration", "getVideoDuration", "setVideoDuration", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "setVideoPlayReporter", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;)V", "viewPageDuration", "getViewPageDuration", "setViewPageDuration", "voiceInfo", "getVoiceInfo", "setVoiceInfo", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "copyRecord", "equals", "other", "hashCode", "onRelease", "", "toString", "Companion", "plugin-finder_release"})
public final class h
{
  private static final String TAG = "Finder.FinderSingleFeedRecord";
  public static final a ryk;
  public final long dig;
  public long dpQ;
  public long endTime;
  public final FinderItem feed;
  public int kLX;
  public int netType;
  public f rdF;
  public m rwW;
  public long rxC;
  public int rxD;
  public long[] rxE;
  public long[] rxF;
  public int[] rxG;
  public int[] rxH;
  public int rxI;
  public int rxJ;
  public int rxK;
  public int rxL;
  public int rxM;
  public int rxN;
  public int rxO;
  public int rxP;
  public int rxQ;
  public int rxR;
  public int rxS;
  public int rxT;
  public int rxU;
  public int rxV;
  public int rxW;
  public int rxX;
  public long rxY;
  public long rxZ;
  public long rya;
  public long ryb;
  public int ryc;
  public int ryd;
  public String rye;
  public HashSet<Integer> ryf;
  public int ryg;
  public int ryh;
  public String ryi;
  public boolean ryj;
  public final long startTime;
  public int videoDuration;
  
  static
  {
    AppMethodBeat.i(202791);
    ryk = new a((byte)0);
    TAG = "Finder.FinderSingleFeedRecord";
    AppMethodBeat.o(202791);
  }
  
  public h(long paramLong1, long paramLong2, FinderItem paramFinderItem, f paramf, boolean paramBoolean, m paramm)
  {
    AppMethodBeat.i(202789);
    this.dig = paramLong1;
    this.startTime = paramLong2;
    this.feed = paramFinderItem;
    this.rdF = paramf;
    this.ryj = paramBoolean;
    this.rwW = paramm;
    this.rxC = ce.azJ();
    paramFinderItem = new long[9];
    int i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.rxE = paramFinderItem;
    paramFinderItem = new long[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.rxF = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.rxG = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.rxH = paramFinderItem;
    this.rxK = 1;
    this.rye = "";
    this.ryf = new HashSet();
    this.ryi = "";
    this.rxE[0] = this.startTime;
    paramFinderItem = this.rwW;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.rzb;
      if (paramFinderItem != null)
      {
        paramFinderItem = (m.b)paramFinderItem.get(Long.valueOf(this.dig));
        if (paramFinderItem != null)
        {
          this.ryb = this.startTime;
          if (paramFinderItem.aVE) {
            this.rxZ = this.startTime;
          }
          paramFinderItem = ai.getContext().getSystemService("audio");
          if (paramFinderItem == null)
          {
            paramFinderItem = new v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(202789);
            throw paramFinderItem;
          }
          this.ryg = ((AudioManager)paramFinderItem).getStreamVolume(3);
          AppMethodBeat.o(202789);
          return;
        }
      }
    }
    AppMethodBeat.o(202789);
  }
  
  public final void a(m paramm)
  {
    int j = 0;
    AppMethodBeat.i(202787);
    if (this.endTime == 0L) {
      this.endTime = ce.azJ();
    }
    Object localObject = this.feed;
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getMediaList();
      if (localObject != null)
      {
        localObject = (bqs)j.iP((List)localObject);
        if (localObject == null) {}
      }
    }
    for (int i = ((bqs)localObject).videoDuration;; i = 0)
    {
      this.videoDuration = i;
      if (this.ryj) {
        this.dpQ = (this.endTime - this.startTime);
      }
      if (paramm == null) {
        break label432;
      }
      paramm = paramm.rzb;
      if ((paramm == null) || ((m.b)paramm.get(Long.valueOf(this.dig)) == null)) {
        break label432;
      }
      if (this.ryb != 0L) {
        this.rya += this.endTime - this.ryb;
      }
      if (this.rxZ != 0L) {
        this.rxY += this.endTime - this.rxZ;
      }
      paramm = ai.getContext().getSystemService("audio");
      if (paramm != null) {
        break;
      }
      paramm = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(202787);
      throw paramm;
    }
    this.ryh = ((AudioManager)paramm).getStreamVolume(3);
    paramm = ai.getContext().getSystemService("audio");
    if (paramm == null)
    {
      paramm = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(202787);
      throw paramm;
    }
    int k = ((AudioManager)paramm).getStreamMaxVolume(3);
    i = j;
    if (this.ryg != this.ryh) {
      i = 1;
    }
    this.ryi = (this.ryg * 100 / k + '#' + this.ryh * 100 / k + '#' + i);
    paramm = d.rxr;
    this.netType = d.cwU();
    paramm = ((Iterable)this.ryf).iterator();
    while (paramm.hasNext())
    {
      i = ((Number)paramm.next()).intValue();
      localObject = this.rye;
      this.rye = ((String)localObject + i + '#');
    }
    AppMethodBeat.o(202787);
    return;
    label432:
    AppMethodBeat.o(202787);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202794);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((this.dig != paramObject.dig) || (this.startTime != paramObject.startTime) || (!k.g(this.feed, paramObject.feed)) || (!k.g(this.rdF, paramObject.rdF)) || (this.ryj != paramObject.ryj) || (!k.g(this.rwW, paramObject.rwW))) {}
      }
    }
    else
    {
      AppMethodBeat.o(202794);
      return true;
    }
    AppMethodBeat.o(202794);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202792);
    String str = "FinderSingleFeedRecord(feedId=" + this.dig + ", startTime=" + this.startTime + ", feed=" + this.feed + ", showInfo=" + this.rdF + ", isCenterFeed=" + this.ryj + ", videoPlayReporter=" + this.rwW + ")";
    AppMethodBeat.o(202792);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "expandNotZeroValue", "", "sb", "Ljava/lang/StringBuffer;", "key", "value", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Long;)V", "printStats", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "trans2Stats", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(dcw paramdcw, String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(202784);
      k.h(paramdcw, "stats");
      k.h(paramString, "tag");
      StringBuffer localStringBuffer = new StringBuffer("[Stats]\n");
      Object localObject1 = h.ryk;
      a(localStringBuffer, "feedId", Long.valueOf(paramdcw.qXP));
      localObject1 = h.ryk;
      localObject1 = paramdcw.FMy;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((doq)localObject1).FWn);
        a(localStringBuffer, "vidPlayLen", (Integer)localObject1);
        localObject1 = h.ryk;
        localObject1 = paramdcw.FMy;
        if (localObject1 == null) {
          break label701;
        }
        localObject1 = Integer.valueOf(((doq)localObject1).yuZ);
        label98:
        a(localStringBuffer, "stayTime", (Integer)localObject1);
        localObject1 = h.ryk;
        localObject1 = paramdcw.FMy;
        if (localObject1 == null) {
          break label706;
        }
        localObject1 = Long.valueOf(((doq)localObject1).qoj);
        label127:
        a(localStringBuffer, "stayTimeMs", (Long)localObject1);
        localObject1 = h.ryk;
        localObject1 = paramdcw.FMy;
        if (localObject1 == null) {
          break label711;
        }
      }
      label701:
      label706:
      label711:
      for (localObject1 = Long.valueOf(((doq)localObject1).FWo);; localObject1 = null)
      {
        a(localStringBuffer, "vidPlayTimeMs", (Long)localObject1);
        localObject1 = h.ryk;
        doq localdoq = paramdcw.FMy;
        localObject1 = localObject2;
        if (localdoq != null) {
          localObject1 = Long.valueOf(localdoq.FWp);
        }
        a(localStringBuffer, "vidPlayingTimeMs", (Long)localObject1);
        localObject1 = h.ryk;
        a(localStringBuffer, "share", Integer.valueOf(paramdcw.FMz.Fqd));
        localObject1 = h.ryk;
        a(localStringBuffer, "forward_times", Integer.valueOf(paramdcw.FMz.Fqb));
        localObject1 = h.ryk;
        a(localStringBuffer, "feed_stay_time", Integer.valueOf(paramdcw.FMz.FpZ));
        localObject1 = h.ryk;
        a(localStringBuffer, "vid_replay_times", Integer.valueOf(paramdcw.FMz.Fqa));
        localObject1 = h.ryk;
        a(localStringBuffer, "max_vid_play_progress", Integer.valueOf(paramdcw.FMz.FpY));
        localObject1 = h.ryk;
        a(localStringBuffer, "pageTurn", Integer.valueOf(paramdcw.FMz.FpX));
        localObject1 = h.ryk;
        a(localStringBuffer, "clickComment", Integer.valueOf(paramdcw.FMz.rxN));
        localObject1 = h.ryk;
        a(localStringBuffer, "clickHead", Integer.valueOf(paramdcw.FMz.Fqc));
        localObject1 = h.ryk;
        a(localStringBuffer, "likeStatus", Integer.valueOf(paramdcw.FMz.Fqf));
        localObject1 = h.ryk;
        a(localStringBuffer, "followStatus", Integer.valueOf(paramdcw.FMz.Fqe));
        localObject1 = h.ryk;
        a(localStringBuffer, "favStatus", Integer.valueOf(paramdcw.FMz.Fqh));
        localObject1 = h.ryk;
        a(localStringBuffer, "notInterestAction", Integer.valueOf(paramdcw.FMz.Fql));
        localObject1 = h.ryk;
        a(localStringBuffer, "fastSlip", Integer.valueOf(paramdcw.FMz.Fqi));
        localObject1 = h.ryk;
        a(localStringBuffer, "sortId", Integer.valueOf(paramdcw.FMz.Fqj));
        localObject1 = h.ryk;
        a(localStringBuffer, "maxVidPlayLen", Integer.valueOf(paramdcw.FMz.Fqk));
        localObject1 = h.ryk;
        a(localStringBuffer, "clickTopicTimes", Integer.valueOf(paramdcw.FMz.Fqm));
        localObject1 = h.ryk;
        a(localStringBuffer, "expandTextTimes", Integer.valueOf(paramdcw.FMz.Fqn));
        localObject1 = h.ryk;
        a(localStringBuffer, "shareMomentTimes", Integer.valueOf(paramdcw.FMz.Fqo));
        localObject1 = h.ryk;
        a(localStringBuffer, "clickPoiTimes", Integer.valueOf(paramdcw.FMz.rxS));
        localObject1 = h.ryk;
        a(localStringBuffer, "collapseTextTimes", Integer.valueOf(paramdcw.FMz.rxT));
        localObject1 = h.ryk;
        a(localStringBuffer, "commentLikeTimes", Integer.valueOf(paramdcw.FMz.rxU));
        localObject1 = h.ryk;
        a(localStringBuffer, "clickFeedMenu", Integer.valueOf(paramdcw.FMz.rxV));
        localObject1 = h.ryk;
        a(localStringBuffer, "complainTimes", Integer.valueOf(paramdcw.FMz.rxW));
        ac.i(paramString, localStringBuffer.toString());
        AppMethodBeat.o(202784);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label98;
        localObject1 = null;
        break label127;
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Integer paramInteger)
    {
      AppMethodBeat.i(202786);
      k.h(paramStringBuffer, "sb");
      k.h(paramString, "key");
      if (paramInteger == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramInteger + '\n');
        do
        {
          AppMethodBeat.o(202786);
          return;
        } while (paramInteger.intValue() == 0);
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Long paramLong)
    {
      AppMethodBeat.i(202785);
      k.h(paramStringBuffer, "sb");
      k.h(paramString, "key");
      if (paramLong == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramLong + '\n');
        do
        {
          AppMethodBeat.o(202785);
          return;
        } while (paramLong.longValue() == 0L);
      }
    }
    
    public static dcw b(h paramh)
    {
      int k = 1;
      AppMethodBeat.i(202783);
      k.h(paramh, "record");
      dcw localdcw = new dcw();
      Object localObject3 = new BitSet(64);
      localdcw.qXP = paramh.dig;
      Object localObject1 = paramh.feed;
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
      localdcw.objectNonceId = ((String)localObject1);
      localdcw.FMx = new lo();
      localdcw.FMy = new doq();
      localdcw.FMz = new cbz();
      localObject1 = paramh.feed;
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
      localdcw.rfC = ((String)localObject1);
      int j = paramh.rxK;
      int i = 0;
      while (i < j)
      {
        ((BitSet)localObject3).set(i, true);
        i += 1;
      }
      float f;
      label227:
      label242:
      int m;
      if (paramh.rxM < 5)
      {
        ((BitSet)localObject3).set(9, true);
        f = (float)paramh.dpQ / 1000.0F;
        if (f >= 0.5F) {
          break label481;
        }
        ((BitSet)localObject3).set(21, true);
        localObject1 = paramh.rxH;
        int n = localObject1.length;
        j = 0;
        i = 0;
        if (j >= n) {
          break label659;
        }
        m = localObject1[j];
        if (m <= i) {
          break label1230;
        }
        i = m;
      }
      label659:
      label1215:
      label1220:
      label1225:
      label1230:
      for (;;)
      {
        j += 1;
        break label242;
        if (paramh.rxM < 10)
        {
          ((BitSet)localObject3).set(10, true);
          break;
        }
        if (paramh.rxM < 20)
        {
          ((BitSet)localObject3).set(11, true);
          break;
        }
        if (paramh.rxM < 30)
        {
          ((BitSet)localObject3).set(12, true);
          break;
        }
        if (paramh.rxM < 40)
        {
          ((BitSet)localObject3).set(13, true);
          break;
        }
        if (paramh.rxM < 50)
        {
          ((BitSet)localObject3).set(14, true);
          break;
        }
        if (paramh.rxM < 60)
        {
          ((BitSet)localObject3).set(15, true);
          break;
        }
        if (paramh.rxM < 70)
        {
          ((BitSet)localObject3).set(16, true);
          break;
        }
        if (paramh.rxM < 80)
        {
          ((BitSet)localObject3).set(17, true);
          break;
        }
        if (paramh.rxM < 90)
        {
          ((BitSet)localObject3).set(18, true);
          break;
        }
        if (paramh.rxM < 100)
        {
          ((BitSet)localObject3).set(19, true);
          break;
        }
        ((BitSet)localObject3).set(20, true);
        break;
        label481:
        if (f < 1.0F)
        {
          ((BitSet)localObject3).set(22, true);
          break label227;
        }
        if (f < 2.0F)
        {
          ((BitSet)localObject3).set(23, true);
          break label227;
        }
        if (f < 3.0F)
        {
          ((BitSet)localObject3).set(24, true);
          break label227;
        }
        if (f < 5.0F)
        {
          ((BitSet)localObject3).set(25, true);
          break label227;
        }
        if (f < 10.0F)
        {
          ((BitSet)localObject3).set(26, true);
          break label227;
        }
        if (f < 20.0F)
        {
          ((BitSet)localObject3).set(27, true);
          break label227;
        }
        if (f < 30.0F)
        {
          ((BitSet)localObject3).set(28, true);
          break label227;
        }
        if (f < 40.0F)
        {
          ((BitSet)localObject3).set(29, true);
          break label227;
        }
        if (f < 50.0F)
        {
          ((BitSet)localObject3).set(30, true);
          break label227;
        }
        ((BitSet)localObject3).set(31, true);
        break label227;
        if (i == 0) {
          ((BitSet)localObject3).set(32, true);
        }
        for (;;)
        {
          long l = localObject3.toLongArray()[0];
          localdcw.FMx.DZq = l;
          localdcw.FMy.yuZ = ((int)f);
          localdcw.FMy.FWn = paramh.videoDuration;
          localdcw.FMy.qoj = paramh.dpQ;
          localdcw.FMy.FWo = paramh.rya;
          localdcw.FMy.FWp = paramh.rxY;
          localdcw.FMz.FpZ = ((int)f);
          localdcw.FMz.Fqa = i;
          localdcw.FMz.FpY = paramh.rxM;
          localObject1 = paramh.rxE;
          m = localObject1.length;
          j = 0;
          i = 0;
          while (j < m)
          {
            if (localObject1[j] > 0L) {
              localdcw.FMz.FpX = i;
            }
            j += 1;
            i += 1;
          }
          if (i == 1) {
            ((BitSet)localObject3).set(33, true);
          } else if (i == 2) {
            ((BitSet)localObject3).set(34, true);
          } else if (i == 3) {
            ((BitSet)localObject3).set(35, true);
          } else if (i == 4) {
            ((BitSet)localObject3).set(36, true);
          } else if (i == 5) {
            ((BitSet)localObject3).set(37, true);
          } else {
            ((BitSet)localObject3).set(38, true);
          }
        }
        localdcw.FMz.Fqb = paramh.kLX;
        localObject1 = localdcw.FMz;
        if (paramh.kLX > 0)
        {
          i = 1;
          ((cbz)localObject1).Fqd = i;
          localdcw.FMz.rxN = paramh.rxN;
          localdcw.FMz.Fqc = paramh.rxO;
          localdcw.FMz.Fql = paramh.rxX;
          localdcw.FMz.Fqj = paramh.rxD;
          localdcw.FMz.Fqm = paramh.rxS;
          localdcw.FMz.Fqn = paramh.rxQ;
          localdcw.FMz.Fqo = paramh.rxR;
          localdcw.FMz.rxS = paramh.rxS;
          localdcw.FMz.rxT = paramh.rxT;
          localdcw.FMz.rxU = paramh.rxU;
          localdcw.FMz.rxV = paramh.rxV;
          localdcw.FMz.rxW = paramh.rxW;
          localObject1 = paramh.feed;
          if (localObject1 != null)
          {
            localObject2 = localdcw.FMz;
            if (((FinderItem)localObject1).getLikeFlag() != 1) {
              break label1215;
            }
            i = 1;
            label1127:
            ((cbz)localObject2).Fqf = i;
            localObject2 = localdcw.FMz;
            localObject3 = b.qWt;
            if (!b.a.adk(((FinderItem)localObject1).getUserName())) {
              break label1220;
            }
            i = 1;
            ((cbz)localObject2).Fqe = i;
            localObject2 = localdcw.FMz;
            if (((FinderItem)localObject1).getFavFlag() != 1) {
              break label1225;
            }
          }
        }
        for (i = k;; i = 0)
        {
          ((cbz)localObject2).Fqh = i;
          localdcw.FMz.Fqk = paramh.rxL;
          AppMethodBeat.o(202783);
          return localdcw;
          i = 0;
          break;
          i = 0;
          break label1127;
          i = 0;
          break label1158;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.h
 * JD-Core Version:    0.7.0.1
 */