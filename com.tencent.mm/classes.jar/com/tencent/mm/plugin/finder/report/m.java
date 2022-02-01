package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "isCenterFeed", "", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;ZLcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;)V", "changePageTime", "", "getChangePageTime", "()[J", "setChangePageTime", "([J)V", "clickAvatar", "", "getClickAvatar", "()I", "setClickAvatar", "(I)V", "clickComment", "getClickComment", "setClickComment", "clickExpandText", "getClickExpandText", "setClickExpandText", "clickFav", "getClickFav", "setClickFav", "clickFeedMenu", "getClickFeedMenu", "setClickFeedMenu", "clickPoiTimes", "getClickPoiTimes", "setClickPoiTimes", "clickShareMoments", "getClickShareMoments", "setClickShareMoments", "collapseTextTimes", "getCollapseTextTimes", "setCollapseTextTimes", "commentLikeTimes", "getCommentLikeTimes", "setCommentLikeTimes", "complainTimes", "getComplainTimes", "setComplainTimes", "createTimestamp", "getCreateTimestamp", "()J", "endTime", "getEndTime", "setEndTime", "(J)V", "endVolume", "getEndVolume", "setEndVolume", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "getFeedDataPos", "setFeedDataPos", "getFeedId", "()Z", "setCenterFeed", "(Z)V", "isPause", "setPause", "isSeek", "setSeek", "lastPageIndex", "getLastPageIndex", "setLastPageIndex", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "maxReplayCount", "getMaxReplayCount", "setMaxReplayCount", "netType", "getNetType", "setNetType", "notInterest", "getNotInterest", "setNotInterest", "pageVideoPlayPercent", "", "getPageVideoPlayPercent", "()[I", "setPageVideoPlayPercent", "([I)V", "pageVideoReplayCount", "getPageVideoReplayCount", "setPageVideoReplayCount", "playProgressInfo", "", "getPlayProgressInfo", "()Ljava/lang/String;", "setPlayProgressInfo", "(Ljava/lang/String;)V", "playProgressSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlayProgressSet", "()Ljava/util/HashSet;", "setPlayProgressSet", "(Ljava/util/HashSet;)V", "playTime", "getPlayTime", "setPlayTime", "playTimestamp", "getPlayTimestamp", "setPlayTimestamp", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "shareCount", "getShareCount", "setShareCount", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "startVolume", "getStartVolume", "setStartVolume", "stayTime", "getStayTime", "setStayTime", "videoDuration", "getVideoDuration", "setVideoDuration", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;", "setVideoPlayReporter", "(Lcom/tencent/mm/plugin/finder/report/FinderVideoPlayReporter;)V", "viewPageDuration", "getViewPageDuration", "setViewPageDuration", "voiceInfo", "getVoiceInfo", "setVoiceInfo", "onRelease", "", "Companion", "plugin-finder_release"})
public final class m
{
  public static final a KVt;
  private static final String TAG = "Finder.FinderSingleFeedRecord";
  f KMj;
  int KUQ;
  long[] KUR;
  long[] KUS;
  int[] KUT;
  int[] KUU;
  int KUV;
  int KUW;
  int KUX;
  int KUY;
  int KUZ;
  private g KUy;
  int KVa;
  int KVb;
  int KVc;
  int KVd;
  int KVe;
  int KVf;
  int KVg;
  int KVh;
  int KVi;
  long KVj;
  long KVk;
  int KVl;
  int KVm;
  String KVn;
  HashSet<Integer> KVo;
  private int KVp;
  private int KVq;
  String KVr;
  private boolean KVs;
  int clickComment;
  long dsf;
  long endTime;
  final FinderItem feed;
  final long feedId;
  int maxPageIndex;
  int netType;
  long qGD;
  long qGR;
  int shareCount;
  final long startTime;
  int videoDuration;
  final long yLW;
  
  static
  {
    AppMethodBeat.i(198844);
    KVt = new a((byte)0);
    TAG = "Finder.FinderSingleFeedRecord";
    AppMethodBeat.o(198844);
  }
  
  public m(long paramLong1, long paramLong2, FinderItem paramFinderItem, f paramf, boolean paramBoolean, g paramg)
  {
    AppMethodBeat.i(198842);
    this.feedId = paramLong1;
    this.startTime = paramLong2;
    this.feed = paramFinderItem;
    this.KMj = paramf;
    this.KVs = paramBoolean;
    this.KUy = paramg;
    this.yLW = ce.asS();
    paramFinderItem = new long[9];
    int i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.KUR = paramFinderItem;
    paramFinderItem = new long[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.KUS = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.KUT = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.KUU = paramFinderItem;
    this.maxPageIndex = 1;
    this.KVn = "";
    this.KVo = new HashSet();
    this.KVr = "";
    this.KUR[0] = this.startTime;
    paramFinderItem = this.KUy;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.KVw;
      if (paramFinderItem != null)
      {
        paramFinderItem = (g.b)paramFinderItem.get(Long.valueOf(this.feedId));
        if (paramFinderItem != null)
        {
          this.KVk = this.startTime;
          if (paramFinderItem.aUR) {
            this.KVj = this.startTime;
          }
          paramFinderItem = aj.getContext().getSystemService("audio");
          if (paramFinderItem == null)
          {
            paramFinderItem = new v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(198842);
            throw paramFinderItem;
          }
          this.KVp = ((AudioManager)paramFinderItem).getStreamVolume(3);
          AppMethodBeat.o(198842);
          return;
        }
      }
    }
    AppMethodBeat.o(198842);
  }
  
  public final void a(g paramg)
  {
    int j = 0;
    AppMethodBeat.i(198840);
    if (this.endTime == 0L) {
      this.endTime = ce.asS();
    }
    Object localObject = this.feed;
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getMediaList();
      if (localObject != null)
      {
        localObject = (bmd)j.iz((List)localObject);
        if (localObject == null) {}
      }
    }
    for (int i = ((bmd)localObject).videoDuration;; i = 0)
    {
      this.videoDuration = i;
      if (this.KVs) {
        this.dsf = (this.endTime - this.startTime);
      }
      if (paramg == null) {
        break label432;
      }
      paramg = paramg.KVw;
      if ((paramg == null) || ((g.b)paramg.get(Long.valueOf(this.feedId)) == null)) {
        break label432;
      }
      if (this.KVk != 0L) {
        this.qGD += this.endTime - this.KVk;
      }
      if (this.KVj != 0L) {
        this.qGR += this.endTime - this.KVj;
      }
      paramg = aj.getContext().getSystemService("audio");
      if (paramg != null) {
        break;
      }
      paramg = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(198840);
      throw paramg;
    }
    this.KVq = ((AudioManager)paramg).getStreamVolume(3);
    paramg = aj.getContext().getSystemService("audio");
    if (paramg == null)
    {
      paramg = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(198840);
      throw paramg;
    }
    int k = ((AudioManager)paramg).getStreamMaxVolume(3);
    i = j;
    if (this.KVp != this.KVq) {
      i = 1;
    }
    this.KVr = (this.KVp * 100 / k + '#' + this.KVq * 100 / k + '#' + i);
    paramg = b.qFq;
    this.netType = b.fTW();
    paramg = ((Iterable)this.KVo).iterator();
    while (paramg.hasNext())
    {
      i = ((Number)paramg.next()).intValue();
      localObject = this.KVn;
      this.KVn = ((String)localObject + i + '#');
    }
    AppMethodBeat.o(198840);
    return;
    label432:
    AppMethodBeat.o(198840);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "expandNotZeroValue", "", "sb", "Ljava/lang/StringBuffer;", "key", "value", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Long;)V", "printStats", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "trans2Stats", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(cxk paramcxk, String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(198837);
      k.h(paramcxk, "stats");
      k.h(paramString, "tag");
      StringBuffer localStringBuffer = new StringBuffer("[Stats]\n");
      Object localObject1 = m.KVt;
      a(localStringBuffer, "feedId", Long.valueOf(paramcxk.objectId));
      localObject1 = m.KVt;
      localObject1 = paramcxk.valFeature;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((djb)localObject1).Ezl);
        a(localStringBuffer, "vidPlayLen", (Integer)localObject1);
        localObject1 = m.KVt;
        localObject1 = paramcxk.valFeature;
        if (localObject1 == null) {
          break label701;
        }
        localObject1 = Integer.valueOf(((djb)localObject1).xil);
        label98:
        a(localStringBuffer, "stayTime", (Integer)localObject1);
        localObject1 = m.KVt;
        localObject1 = paramcxk.valFeature;
        if (localObject1 == null) {
          break label706;
        }
        localObject1 = Long.valueOf(((djb)localObject1).xBr);
        label127:
        a(localStringBuffer, "stayTimeMs", (Long)localObject1);
        localObject1 = m.KVt;
        localObject1 = paramcxk.valFeature;
        if (localObject1 == null) {
          break label711;
        }
      }
      label701:
      label706:
      label711:
      for (localObject1 = Long.valueOf(((djb)localObject1).LAn);; localObject1 = null)
      {
        a(localStringBuffer, "vidPlayTimeMs", (Long)localObject1);
        localObject1 = m.KVt;
        djb localdjb = paramcxk.valFeature;
        localObject1 = localObject2;
        if (localdjb != null) {
          localObject1 = Long.valueOf(localdjb.LAo);
        }
        a(localStringBuffer, "vidPlayingTimeMs", (Long)localObject1);
        localObject1 = m.KVt;
        a(localStringBuffer, "share", Integer.valueOf(paramcxk.orgVal.DTH));
        localObject1 = m.KVt;
        a(localStringBuffer, "forward_times", Integer.valueOf(paramcxk.orgVal.DTF));
        localObject1 = m.KVt;
        a(localStringBuffer, "feed_stay_time", Integer.valueOf(paramcxk.orgVal.DTD));
        localObject1 = m.KVt;
        a(localStringBuffer, "vid_replay_times", Integer.valueOf(paramcxk.orgVal.DTE));
        localObject1 = m.KVt;
        a(localStringBuffer, "max_vid_play_progress", Integer.valueOf(paramcxk.orgVal.DTC));
        localObject1 = m.KVt;
        a(localStringBuffer, "pageTurn", Integer.valueOf(paramcxk.orgVal.DTB));
        localObject1 = m.KVt;
        a(localStringBuffer, "clickComment", Integer.valueOf(paramcxk.orgVal.clickComment));
        localObject1 = m.KVt;
        a(localStringBuffer, "clickHead", Integer.valueOf(paramcxk.orgVal.DTG));
        localObject1 = m.KVt;
        a(localStringBuffer, "likeStatus", Integer.valueOf(paramcxk.orgVal.LzR));
        localObject1 = m.KVt;
        a(localStringBuffer, "followStatus", Integer.valueOf(paramcxk.orgVal.LzQ));
        localObject1 = m.KVt;
        a(localStringBuffer, "favStatus", Integer.valueOf(paramcxk.orgVal.LzT));
        localObject1 = m.KVt;
        a(localStringBuffer, "notInterestAction", Integer.valueOf(paramcxk.orgVal.LzX));
        localObject1 = m.KVt;
        a(localStringBuffer, "fastSlip", Integer.valueOf(paramcxk.orgVal.LzU));
        localObject1 = m.KVt;
        a(localStringBuffer, "sortId", Integer.valueOf(paramcxk.orgVal.LzV));
        localObject1 = m.KVt;
        a(localStringBuffer, "maxVidPlayLen", Integer.valueOf(paramcxk.orgVal.LzW));
        localObject1 = m.KVt;
        a(localStringBuffer, "clickTopicTimes", Integer.valueOf(paramcxk.orgVal.LzY));
        localObject1 = m.KVt;
        a(localStringBuffer, "expandTextTimes", Integer.valueOf(paramcxk.orgVal.LzZ));
        localObject1 = m.KVt;
        a(localStringBuffer, "shareMomentTimes", Integer.valueOf(paramcxk.orgVal.LAa));
        localObject1 = m.KVt;
        a(localStringBuffer, "clickPoiTimes", Integer.valueOf(paramcxk.orgVal.KVd));
        localObject1 = m.KVt;
        a(localStringBuffer, "collapseTextTimes", Integer.valueOf(paramcxk.orgVal.KVe));
        localObject1 = m.KVt;
        a(localStringBuffer, "commentLikeTimes", Integer.valueOf(paramcxk.orgVal.KVf));
        localObject1 = m.KVt;
        a(localStringBuffer, "clickFeedMenu", Integer.valueOf(paramcxk.orgVal.KVg));
        localObject1 = m.KVt;
        a(localStringBuffer, "complainTimes", Integer.valueOf(paramcxk.orgVal.KVh));
        ad.i(paramString, localStringBuffer.toString());
        AppMethodBeat.o(198837);
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
      AppMethodBeat.i(198839);
      k.h(paramStringBuffer, "sb");
      k.h(paramString, "key");
      if (paramInteger == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramInteger + '\n');
        do
        {
          AppMethodBeat.o(198839);
          return;
        } while (paramInteger.intValue() == 0);
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Long paramLong)
    {
      AppMethodBeat.i(198838);
      k.h(paramStringBuffer, "sb");
      k.h(paramString, "key");
      if (paramLong == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramLong + '\n');
        do
        {
          AppMethodBeat.o(198838);
          return;
        } while (paramLong.longValue() == 0L);
      }
    }
    
    public static cxk b(m paramm)
    {
      int k = 1;
      AppMethodBeat.i(198836);
      k.h(paramm, "record");
      cxk localcxk = new cxk();
      Object localObject3 = new BitSet(64);
      localcxk.objectId = paramm.feedId;
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
      localcxk.objectNonceId = ((String)localObject1);
      localcxk.bitFeature = new li();
      localcxk.valFeature = new djb();
      localcxk.orgVal = new bxf();
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
      localcxk.finderUsername = ((String)localObject1);
      int j = paramm.maxPageIndex;
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
      if (paramm.KUY < 5)
      {
        ((BitSet)localObject3).set(9, true);
        f = (float)paramm.dsf / 1000.0F;
        if (f >= 0.5F) {
          break label481;
        }
        ((BitSet)localObject3).set(21, true);
        localObject1 = paramm.KUU;
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
        if (paramm.KUY < 10)
        {
          ((BitSet)localObject3).set(10, true);
          break;
        }
        if (paramm.KUY < 20)
        {
          ((BitSet)localObject3).set(11, true);
          break;
        }
        if (paramm.KUY < 30)
        {
          ((BitSet)localObject3).set(12, true);
          break;
        }
        if (paramm.KUY < 40)
        {
          ((BitSet)localObject3).set(13, true);
          break;
        }
        if (paramm.KUY < 50)
        {
          ((BitSet)localObject3).set(14, true);
          break;
        }
        if (paramm.KUY < 60)
        {
          ((BitSet)localObject3).set(15, true);
          break;
        }
        if (paramm.KUY < 70)
        {
          ((BitSet)localObject3).set(16, true);
          break;
        }
        if (paramm.KUY < 80)
        {
          ((BitSet)localObject3).set(17, true);
          break;
        }
        if (paramm.KUY < 90)
        {
          ((BitSet)localObject3).set(18, true);
          break;
        }
        if (paramm.KUY < 100)
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
          localcxk.bitFeature.CGQ = l;
          localcxk.valFeature.xil = ((int)f);
          localcxk.valFeature.Ezl = paramm.videoDuration;
          localcxk.valFeature.xBr = paramm.dsf;
          localcxk.valFeature.LAn = paramm.qGD;
          localcxk.valFeature.LAo = paramm.qGR;
          localcxk.orgVal.DTD = ((int)f);
          localcxk.orgVal.DTE = i;
          localcxk.orgVal.DTC = paramm.KUY;
          localObject1 = paramm.KUR;
          m = localObject1.length;
          j = 0;
          i = 0;
          while (j < m)
          {
            if (localObject1[j] > 0L) {
              localcxk.orgVal.DTB = i;
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
        localcxk.orgVal.DTF = paramm.shareCount;
        localObject1 = localcxk.orgVal;
        if (paramm.shareCount > 0)
        {
          i = 1;
          ((bxf)localObject1).DTH = i;
          localcxk.orgVal.clickComment = paramm.clickComment;
          localcxk.orgVal.DTG = paramm.KUZ;
          localcxk.orgVal.LzX = paramm.KVi;
          localcxk.orgVal.LzV = paramm.KUQ;
          localcxk.orgVal.LzY = paramm.KVd;
          localcxk.orgVal.LzZ = paramm.KVb;
          localcxk.orgVal.LAa = paramm.KVc;
          localcxk.orgVal.KVd = paramm.KVd;
          localcxk.orgVal.KVe = paramm.KVe;
          localcxk.orgVal.KVf = paramm.KVf;
          localcxk.orgVal.KVg = paramm.KVg;
          localcxk.orgVal.KVh = paramm.KVh;
          localObject1 = paramm.feed;
          if (localObject1 != null)
          {
            localObject2 = localcxk.orgVal;
            if (((FinderItem)localObject1).getLikeFlag() != 1) {
              break label1215;
            }
            i = 1;
            label1127:
            ((bxf)localObject2).LzR = i;
            localObject2 = localcxk.orgVal;
            localObject3 = com.tencent.mm.plugin.finder.api.b.qnX;
            if (!b.a.YO(((FinderItem)localObject1).getUserName())) {
              break label1220;
            }
            i = 1;
            ((bxf)localObject2).LzQ = i;
            localObject2 = localcxk.orgVal;
            if (((FinderItem)localObject1).getFavFlag() != 1) {
              break label1225;
            }
          }
        }
        for (i = k;; i = 0)
        {
          ((bxf)localObject2).LzT = i;
          localcxk.orgVal.LzW = paramm.KUX;
          AppMethodBeat.o(198836);
          return localcxk;
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
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m
 * JD-Core Version:    0.7.0.1
 */