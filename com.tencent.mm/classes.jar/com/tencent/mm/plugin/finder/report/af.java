package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.video.reporter.c;
import com.tencent.mm.plugin.finder.video.reporter.c.b;
import com.tencent.mm.plugin.finder.viewmodel.component.n;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.l;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "isCenterFeed", "", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;ZLcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "changePageTime", "", "getChangePageTime", "()[J", "setChangePageTime", "([J)V", "clickAvatar", "", "getClickAvatar", "()I", "setClickAvatar", "(I)V", "clickComment", "getClickComment", "setClickComment", "clickExpandText", "getClickExpandText", "setClickExpandText", "clickFav", "getClickFav", "setClickFav", "clickFeedMenu", "getClickFeedMenu", "setClickFeedMenu", "clickPoiTimes", "getClickPoiTimes", "setClickPoiTimes", "clickShareMoments", "getClickShareMoments", "setClickShareMoments", "collapseTextTimes", "getCollapseTextTimes", "setCollapseTextTimes", "commentLikeTimes", "getCommentLikeTimes", "setCommentLikeTimes", "complainTimes", "getComplainTimes", "setComplainTimes", "createTimestamp", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "endTime", "getEndTime", "setEndTime", "endVolume", "getEndVolume", "setEndVolume", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "getFeedDataPos", "setFeedDataPos", "getFeedId", "()Z", "setCenterFeed", "(Z)V", "isPause", "setPause", "isSeek", "setSeek", "lastPageIndex", "getLastPageIndex", "setLastPageIndex", "lastPlayTime", "getLastPlayTime", "setLastPlayTime", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "maxReplayCount", "getMaxReplayCount", "setMaxReplayCount", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "netType", "getNetType", "setNetType", "notInterest", "getNotInterest", "setNotInterest", "pageVideoPlayPercent", "", "getPageVideoPlayPercent", "()[I", "setPageVideoPlayPercent", "([I)V", "pageVideoReplayCount", "getPageVideoReplayCount", "setPageVideoReplayCount", "pauseTimes", "getPauseTimes", "setPauseTimes", "playFormat", "", "getPlayFormat", "()Ljava/lang/String;", "setPlayFormat", "(Ljava/lang/String;)V", "playProgressInfo", "getPlayProgressInfo", "setPlayProgressInfo", "playProgressSet", "Ljava/util/Vector;", "getPlayProgressSet", "()Ljava/util/Vector;", "setPlayProgressSet", "(Ljava/util/Vector;)V", "playTime", "getPlayTime", "setPlayTime", "playTimestamp", "getPlayTimestamp", "setPlayTimestamp", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getRvFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setRvFeed", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "shareCount", "getShareCount", "setShareCount", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "startVolume", "getStartVolume", "setStartVolume", "stayTime", "getStayTime", "setStayTime", "videoDuration", "getVideoDuration", "setVideoDuration", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "setVideoPlayReporter", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;)V", "viewPageDuration", "getViewPageDuration", "setViewPageDuration", "voiceInfo", "getVoiceInfo", "setVoiceInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "copyRecord", "equals", "other", "hashCode", "onRelease", "", "toString", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
{
  public static final a FsA;
  private static final int Ftn;
  private static final int Fto;
  private static final String TAG;
  public final FinderItem ANj;
  l AOo;
  c FpB;
  boolean FsB;
  final ca FsC;
  int FsD;
  long[] FsE;
  long[] FsF;
  int[] FsG;
  int[] FsH;
  int FsI;
  int FsJ;
  int FsK;
  int FsL;
  int FsM;
  int FsN;
  int FsO;
  int FsP;
  int FsQ;
  int FsR;
  int FsS;
  int FsT;
  int FsU;
  int FsV;
  long FsW;
  int FsX;
  int FsY;
  int FsZ;
  long Fta;
  long Ftb;
  long Ftc;
  long Ftd;
  int Fte;
  int Ftf;
  String Ftg;
  Vector<Integer> Fth;
  int Fti;
  int Ftj;
  String Ftk;
  String Ftl;
  cc Ftm;
  long endTime;
  public final long feedId;
  long hTS;
  long hlB;
  int netType;
  final long startTime;
  int sve;
  int videoDuration;
  
  static
  {
    AppMethodBeat.i(331392);
    FsA = new a((byte)0);
    TAG = "Finder.FinderSingleFeedRecord";
    Ftn = 1;
    Fto = 2;
    AppMethodBeat.o(331392);
  }
  
  public af(long paramLong1, long paramLong2, FinderItem paramFinderItem, l paraml, boolean paramBoolean, c paramc, ca paramca)
  {
    AppMethodBeat.i(331350);
    this.feedId = paramLong1;
    this.startTime = paramLong2;
    this.ANj = paramFinderItem;
    this.AOo = paraml;
    this.FsB = paramBoolean;
    this.FpB = paramc;
    this.FsC = paramca;
    this.hlB = cn.bDw();
    paramFinderItem = this.ANj;
    int i;
    if (paramFinderItem == null) {
      i = 0;
    }
    int j;
    for (;;)
    {
      j = Math.max(i, 9);
      paramFinderItem = new long[j];
      i = 0;
      while (i < j)
      {
        paramFinderItem[i] = 0L;
        i += 1;
      }
      paramFinderItem = paramFinderItem.getMediaList();
      if (paramFinderItem == null) {
        i = 0;
      } else {
        i = paramFinderItem.size();
      }
    }
    this.FsE = paramFinderItem;
    paramFinderItem = this.ANj;
    if (paramFinderItem == null) {
      i = 0;
    }
    for (;;)
    {
      j = Math.max(i, 9);
      paramFinderItem = new long[j];
      i = 0;
      while (i < j)
      {
        paramFinderItem[i] = 0L;
        i += 1;
      }
      paramFinderItem = paramFinderItem.getMediaList();
      if (paramFinderItem == null) {
        i = 0;
      } else {
        i = paramFinderItem.size();
      }
    }
    this.FsF = paramFinderItem;
    paramFinderItem = this.ANj;
    if (paramFinderItem == null) {
      i = 0;
    }
    for (;;)
    {
      j = Math.max(i, 9);
      paramFinderItem = new int[j];
      i = 0;
      while (i < j)
      {
        paramFinderItem[i] = 0;
        i += 1;
      }
      paramFinderItem = paramFinderItem.getMediaList();
      if (paramFinderItem == null) {
        i = 0;
      } else {
        i = paramFinderItem.size();
      }
    }
    this.FsG = paramFinderItem;
    paramFinderItem = this.ANj;
    if (paramFinderItem == null) {
      i = 0;
    }
    for (;;)
    {
      j = Math.max(i, 9);
      paramFinderItem = new int[j];
      i = 0;
      while (i < j)
      {
        paramFinderItem[i] = 0;
        i += 1;
      }
      paramFinderItem = paramFinderItem.getMediaList();
      if (paramFinderItem == null) {
        i = 0;
      } else {
        i = paramFinderItem.size();
      }
    }
    this.FsH = paramFinderItem;
    this.FsK = 1;
    this.Ftg = "";
    this.Fth = new Vector();
    this.Ftk = "";
    this.Ftl = "";
    this.FsE[0] = this.startTime;
    paramFinderItem = this.FpB;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.Gty;
      if (paramFinderItem != null)
      {
        paramFinderItem = (c.b)paramFinderItem.get(Long.valueOf(this.feedId));
        if (paramFinderItem != null)
        {
          this.Ftd = this.startTime;
          if (paramFinderItem.cJs) {
            this.Ftb = this.startTime;
          }
          paramFinderItem = MMApplicationContext.getContext().getSystemService("audio");
          if (paramFinderItem == null)
          {
            paramFinderItem = new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(331350);
            throw paramFinderItem;
          }
          this.Fti = ((AudioManager)paramFinderItem).getStreamVolume(3);
        }
      }
    }
    AppMethodBeat.o(331350);
  }
  
  private void azX(String paramString)
  {
    AppMethodBeat.i(331362);
    s.u(paramString, "<set-?>");
    this.Ftg = paramString;
    AppMethodBeat.o(331362);
  }
  
  private void azY(String paramString)
  {
    AppMethodBeat.i(331366);
    s.u(paramString, "<set-?>");
    this.Ftk = paramString;
    AppMethodBeat.o(331366);
  }
  
  private void azZ(String paramString)
  {
    AppMethodBeat.i(331371);
    s.u(paramString, "<set-?>");
    this.Ftl = paramString;
    AppMethodBeat.o(331371);
  }
  
  public final void SG(int paramInt)
  {
    this.FsD = paramInt;
  }
  
  public final void SH(int paramInt)
  {
    this.sve = paramInt;
  }
  
  public final void SI(int paramInt)
  {
    this.FsN = paramInt;
  }
  
  public final void SJ(int paramInt)
  {
    this.FsO = paramInt;
  }
  
  public final void SK(int paramInt)
  {
    this.FsP = paramInt;
  }
  
  public final void SL(int paramInt)
  {
    this.FsQ = paramInt;
  }
  
  public final void SM(int paramInt)
  {
    this.FsR = paramInt;
  }
  
  public final void SN(int paramInt)
  {
    this.FsS = paramInt;
  }
  
  public final void SO(int paramInt)
  {
    this.FsT = paramInt;
  }
  
  public final void SP(int paramInt)
  {
    this.FsU = paramInt;
  }
  
  public final void SQ(int paramInt)
  {
    this.FsX = paramInt;
  }
  
  public final void SR(int paramInt)
  {
    this.FsY = paramInt;
  }
  
  public final void SS(int paramInt)
  {
    this.FsZ = paramInt;
  }
  
  public final void a(c arg1)
  {
    AppMethodBeat.i(331576);
    if (this.endTime == 0L) {
      this.endTime = cn.bDw();
    }
    Object localObject1 = this.ANj;
    if (localObject1 == null)
    {
      i = 0;
      this.videoDuration = i;
      localObject1 = this.FsC;
      if (localObject1 != null)
      {
        localObject1 = ((ca)localObject1).ABK;
        if (localObject1 != null) {
          break label253;
        }
        i = 0;
      }
    }
    c.b localb;
    for (;;)
    {
      this.videoDuration = i;
      this.hTS = (this.endTime - this.startTime);
      if (??? == null) {
        break label741;
      }
      ??? = ???.Gty;
      if (??? == null) {
        break label741;
      }
      localb = (c.b)???.get(Long.valueOf(this.feedId));
      if (localb == null) {
        break label741;
      }
      if (this.Ftd != 0L) {
        this.Ftc += this.endTime - this.Ftd;
      }
      if (this.Ftb != 0L) {
        this.Fta += this.endTime - this.Ftb;
      }
      ??? = MMApplicationContext.getContext().getSystemService("audio");
      if (??? != null) {
        break label319;
      }
      ??? = new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(331576);
      throw ???;
      localObject1 = ((FinderItem)localObject1).getMediaList();
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      localObject1 = (dji)p.oL((List)localObject1);
      if (localObject1 == null)
      {
        i = 0;
        break;
      }
      i = ((dji)localObject1).videoDuration;
      break;
      label253:
      localObject1 = ((dne)localObject1).aaUt;
      if (localObject1 == null)
      {
        i = 0;
      }
      else
      {
        localObject1 = ((dnh)localObject1).media;
        if (localObject1 == null)
        {
          i = 0;
        }
        else
        {
          localObject1 = (dnv)p.oL((List)localObject1);
          if (localObject1 == null) {
            i = 0;
          } else {
            i = ((dnv)localObject1).aaUX;
          }
        }
      }
    }
    label319:
    this.Ftj = ((AudioManager)???).getStreamVolume(3);
    ??? = MMApplicationContext.getContext().getSystemService("audio");
    if (??? == null)
    {
      ??? = new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(331576);
      throw ???;
    }
    int j = ((AudioManager)???).getStreamMaxVolume(3);
    int i = 0;
    if (this.Fti != this.Ftj) {
      i = 1;
    }
    azY(this.Fti * 100 / j + '#' + this.Ftj * 100 / j + '#' + i);
    ??? = z.FrZ;
    this.netType = z.bUg();
    synchronized ((Iterable)this.Fth)
    {
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject1).next();
        azX(this.Ftg + localInteger + '#');
      }
    }
    Object localObject3 = ah.aiuX;
    ??? = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
    localObject3 = com.tencent.mm.plugin.finder.storage.logic.e.aAN(localb.GtB).field_fileFormat;
    ??? = (c)localObject3;
    if (localObject3 == null) {
      ??? = "";
    }
    int m = 0;
    int n = 0;
    int i1 = 0;
    localObject3 = localb.GtE;
    int k = i1;
    j = n;
    i = m;
    if (localObject3 != null)
    {
      localObject3 = f.aVX(((x)localObject3).getPath());
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
    azZ(localb.Gul + ';' + j + ';' + ??? + ';' + i + ';' + k + ';' + localb.Gum + ';' + localb.Gun + ';');
    label741:
    AppMethodBeat.o(331576);
  }
  
  public final long[] eNe()
  {
    return this.FsE;
  }
  
  public final int[] eNf()
  {
    return this.FsG;
  }
  
  public final int[] eNg()
  {
    return this.FsH;
  }
  
  public final int eNh()
  {
    return this.FsI;
  }
  
  public final int eNi()
  {
    return this.sve;
  }
  
  public final int eNj()
  {
    return this.FsN;
  }
  
  public final int eNk()
  {
    return this.FsO;
  }
  
  public final int eNl()
  {
    return this.FsP;
  }
  
  public final int eNm()
  {
    return this.FsQ;
  }
  
  public final int eNn()
  {
    return this.FsR;
  }
  
  public final int eNo()
  {
    return this.FsS;
  }
  
  public final int eNp()
  {
    return this.FsT;
  }
  
  public final int eNq()
  {
    return this.FsU;
  }
  
  public final int eNr()
  {
    return this.FsX;
  }
  
  public final int eNs()
  {
    return this.FsY;
  }
  
  public final int eNt()
  {
    return this.FsZ;
  }
  
  public final long eNu()
  {
    return this.Ftb;
  }
  
  public final long eNv()
  {
    return this.Ftd;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(331602);
    if (this == paramObject)
    {
      AppMethodBeat.o(331602);
      return true;
    }
    if (!(paramObject instanceof af))
    {
      AppMethodBeat.o(331602);
      return false;
    }
    paramObject = (af)paramObject;
    if (this.feedId != paramObject.feedId)
    {
      AppMethodBeat.o(331602);
      return false;
    }
    if (this.startTime != paramObject.startTime)
    {
      AppMethodBeat.o(331602);
      return false;
    }
    if (!s.p(this.ANj, paramObject.ANj))
    {
      AppMethodBeat.o(331602);
      return false;
    }
    if (!s.p(this.AOo, paramObject.AOo))
    {
      AppMethodBeat.o(331602);
      return false;
    }
    if (this.FsB != paramObject.FsB)
    {
      AppMethodBeat.o(331602);
      return false;
    }
    if (!s.p(this.FpB, paramObject.FpB))
    {
      AppMethodBeat.o(331602);
      return false;
    }
    if (!s.p(this.FsC, paramObject.FsC))
    {
      AppMethodBeat.o(331602);
      return false;
    }
    AppMethodBeat.o(331602);
    return true;
  }
  
  public final void g(cc paramcc)
  {
    this.Ftm = paramcc;
  }
  
  public final long getFeedId()
  {
    return this.feedId;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void pM(long paramLong)
  {
    this.Ftb = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(331582);
    String str = "FinderSingleFeedRecord(feedId=" + this.feedId + ", startTime=" + this.startTime + ", feed=" + this.ANj + ", showInfo=" + this.AOo + ", isCenterFeed=" + this.FsB + ", videoPlayReporter=" + this.FpB + ", megaVideoFeed=" + this.FsC + ')';
    AppMethodBeat.o(331582);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord$Companion;", "", "()V", "FinderStatsReportFeedTypeRelated", "", "getFinderStatsReportFeedTypeRelated", "()I", "FinderStatsReportFeedTypeStream", "getFinderStatsReportFeedTypeStream", "TAG", "", "getTAG", "()Ljava/lang/String;", "expandNotZeroValue", "", "sb", "Ljava/lang/StringBuffer;", "key", "value", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Long;)V", "printStats", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "trans2Stats", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static fhp a(af paramaf, bui parambui)
    {
      int k = 1;
      AppMethodBeat.i(331105);
      s.u(paramaf, "record");
      s.u(parambui, "contextObj");
      fhp localfhp = new fhp();
      Object localObject3 = new BitSet(64);
      Object localObject1 = paramaf.FsC;
      long l;
      label65:
      Object localObject2;
      label86:
      label110:
      int m;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label514;
        }
        l = paramaf.feedId;
        localfhp.hKN = l;
        localObject1 = paramaf.FsC;
        if (localObject1 != null) {
          break label524;
        }
        localObject2 = null;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = paramaf.ANj;
          if (localObject1 != null) {
            break label534;
          }
          localObject1 = "";
        }
        localfhp.objectNonceId = ((String)localObject1);
        localObject1 = paramaf.FsC;
        if (localObject1 != null) {
          break label557;
        }
        l = 0L;
        label131:
        localfhp.abIp = l;
        localObject1 = paramaf.FsC;
        if (localObject1 != null) {
          break label567;
        }
        localObject1 = "";
        label153:
        localfhp.abIq = ((String)localObject1);
        localfhp.abIh = new ni();
        localfhp.abIi = new fvu();
        localfhp.abIj = new dzj();
        localObject1 = paramaf.FsC;
        if (localObject1 != null) {
          break label609;
        }
        localObject2 = null;
        label210:
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = paramaf.ANj;
          if (localObject1 != null) {
            break label637;
          }
          localObject1 = "";
        }
        label234:
        localfhp.finderUsername = ((String)localObject1);
        localfhp.abIk = paramaf.hlB;
        if (parambui.AJo == 20)
        {
          localObject1 = n.GOb;
          if (!n.fnw().contains(Long.valueOf(localfhp.hKN))) {
            break label660;
          }
          i = af.eNx();
          label285:
          localfhp.abIl = i;
        }
        if (paramaf.FsC != null)
        {
          localObject1 = paramaf.ANj;
          if ((localObject1 == null) || (((FinderItem)localObject1).isReplaceLongVideoToNormal() != true)) {
            break label667;
          }
          i = 1;
          label320:
          if (i == 0) {
            break label672;
          }
        }
        localObject1 = z.FrZ;
        localObject1 = z.p(paramaf.feedId, parambui.AJo);
        label342:
        localfhp.sessionBuffer = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        localfhp.abIn = e.a.at(parambui.AJo, paramaf.feedId);
        localfhp.abIr = paramaf.startTime;
        m = paramaf.FsK;
        if (m <= 0) {}
      }
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        ((BitSet)localObject3).set(i, true);
        if (j >= m)
        {
          label427:
          float f;
          if (paramaf.FsM < 5)
          {
            ((BitSet)localObject3).set(9, true);
            f = (float)paramaf.hTS / 1000.0F;
            if (f >= 0.5F) {
              break label904;
            }
            ((BitSet)localObject3).set(21, true);
          }
          for (;;)
          {
            parambui = paramaf.FsH;
            int i1 = parambui.length;
            i = 0;
            j = 0;
            while (i < i1)
            {
              int n = parambui[i];
              m = i + 1;
              i = m;
              if (n > j)
              {
                j = n;
                i = m;
              }
            }
            localObject1 = Long.valueOf(((ca)localObject1).eDF());
            break;
            label514:
            l = ((Long)localObject1).longValue();
            break label65;
            label524:
            localObject2 = ((ca)localObject1).eDG();
            break label86;
            label534:
            localObject2 = ((FinderItem)localObject1).getObjectNonceId();
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label110;
            }
            localObject1 = "";
            break label110;
            label557:
            l = ((ca)localObject1).bZA();
            break label131;
            label567:
            localObject1 = ((ca)localObject1).ABK;
            if (localObject1 == null)
            {
              localObject1 = "";
              break label153;
            }
            localObject2 = ((dne)localObject1).aahV;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label153;
            }
            localObject1 = "";
            break label153;
            label609:
            localObject1 = ((ca)localObject1).contact;
            if (localObject1 == null)
            {
              localObject2 = null;
              break label210;
            }
            localObject2 = ((FinderContact)localObject1).username;
            break label210;
            label637:
            localObject2 = ((FinderItem)localObject1).field_username;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label234;
            }
            localObject1 = "";
            break label234;
            label660:
            i = af.eNw();
            break label285;
            label667:
            i = 0;
            break label320;
            label672:
            localObject1 = z.FrZ;
            localObject1 = z.p(paramaf.feedId, parambui.AJo);
            break label342;
            if (paramaf.FsM < 10)
            {
              ((BitSet)localObject3).set(10, true);
              break label427;
            }
            if (paramaf.FsM < 20)
            {
              ((BitSet)localObject3).set(11, true);
              break label427;
            }
            if (paramaf.FsM < 30)
            {
              ((BitSet)localObject3).set(12, true);
              break label427;
            }
            if (paramaf.FsM < 40)
            {
              ((BitSet)localObject3).set(13, true);
              break label427;
            }
            if (paramaf.FsM < 50)
            {
              ((BitSet)localObject3).set(14, true);
              break label427;
            }
            if (paramaf.FsM < 60)
            {
              ((BitSet)localObject3).set(15, true);
              break label427;
            }
            if (paramaf.FsM < 70)
            {
              ((BitSet)localObject3).set(16, true);
              break label427;
            }
            if (paramaf.FsM < 80)
            {
              ((BitSet)localObject3).set(17, true);
              break label427;
            }
            if (paramaf.FsM < 90)
            {
              ((BitSet)localObject3).set(18, true);
              break label427;
            }
            if (paramaf.FsM < 100)
            {
              ((BitSet)localObject3).set(19, true);
              break label427;
            }
            ((BitSet)localObject3).set(20, true);
            break label427;
            label904:
            if (f < 1.0F) {
              ((BitSet)localObject3).set(22, true);
            } else if (f < 2.0F) {
              ((BitSet)localObject3).set(23, true);
            } else if (f < 3.0F) {
              ((BitSet)localObject3).set(24, true);
            } else if (f < 5.0F) {
              ((BitSet)localObject3).set(25, true);
            } else if (f < 10.0F) {
              ((BitSet)localObject3).set(26, true);
            } else if (f < 20.0F) {
              ((BitSet)localObject3).set(27, true);
            } else if (f < 30.0F) {
              ((BitSet)localObject3).set(28, true);
            } else if (f < 40.0F) {
              ((BitSet)localObject3).set(29, true);
            } else if (f < 50.0F) {
              ((BitSet)localObject3).set(30, true);
            } else {
              ((BitSet)localObject3).set(31, true);
            }
          }
          switch (j)
          {
          default: 
            ((BitSet)localObject3).set(38, true);
            parambui = ah.aiuX;
          }
          for (;;)
          {
            l = localObject3.toLongArray()[0];
            parambui = localfhp.abIh;
            if (parambui != null) {
              parambui.YPj = l;
            }
            parambui = localfhp.abIi;
            if (parambui != null) {
              parambui.QXQ = ((int)f);
            }
            parambui = localfhp.abIi;
            if (parambui != null) {
              parambui.abTW = paramaf.videoDuration;
            }
            parambui = localfhp.abIi;
            if (parambui != null) {
              parambui.zIy = paramaf.hTS;
            }
            parambui = localfhp.abIi;
            if (parambui != null) {
              parambui.abTX = paramaf.Ftc;
            }
            parambui = localfhp.abIi;
            if (parambui != null) {
              parambui.abTY = paramaf.Fta;
            }
            parambui = localfhp.abIi;
            if (parambui != null)
            {
              parambui.abTZ = paramaf.hTS;
              parambui.ork = paramaf.startTime;
              parambui.abUa = paramaf.endTime;
              parambui.FsW = paramaf.FsW;
              parambui.abUb = paramaf.FsV;
              parambui.abUc = 1;
              parambui = ah.aiuX;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abeh = ((int)f);
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abei = j;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abeg = paramaf.FsM;
            }
            parambui = paramaf.FsE;
            m = parambui.length;
            j = 0;
            i = 0;
            while (j < m)
            {
              if (parambui[j] > 0L)
              {
                localObject1 = localfhp.abIj;
                if (localObject1 != null) {
                  ((dzj)localObject1).abef = i;
                }
              }
              j += 1;
              i += 1;
            }
            ((BitSet)localObject3).set(32, true);
            parambui = ah.aiuX;
            continue;
            ((BitSet)localObject3).set(33, true);
            parambui = ah.aiuX;
            continue;
            ((BitSet)localObject3).set(34, true);
            parambui = ah.aiuX;
            continue;
            ((BitSet)localObject3).set(35, true);
            parambui = ah.aiuX;
            continue;
            ((BitSet)localObject3).set(36, true);
            parambui = ah.aiuX;
            continue;
            ((BitSet)localObject3).set(37, true);
            parambui = ah.aiuX;
          }
          parambui = localfhp.abIj;
          if (parambui != null) {
            parambui.abej = paramaf.sve;
          }
          parambui = localfhp.abIj;
          if (parambui != null)
          {
            if (paramaf.sve > 0)
            {
              i = 1;
              parambui.share = i;
            }
          }
          else
          {
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.FsN = paramaf.FsN;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abek = paramaf.FsO;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.aber = paramaf.FsZ;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abep = paramaf.FsD;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abes = paramaf.FsS;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abet = paramaf.FsQ;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abeu = paramaf.FsR;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.FsS = paramaf.FsS;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.FsT = paramaf.FsT;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.FsU = paramaf.FsU;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.FsX = paramaf.FsX;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.FsY = paramaf.FsY;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abew = paramaf.Ftf;
            }
            localObject1 = paramaf.ANj;
            if (localObject1 != null)
            {
              parambui = localfhp.abIj;
              if (parambui != null)
              {
                if (((FinderItem)localObject1).getLikeFlag() == 0) {
                  break label2063;
                }
                i = 1;
                label1817:
                parambui.abel = i;
              }
              localObject2 = localfhp.abIj;
              if (localObject2 != null)
              {
                parambui = com.tencent.mm.plugin.finder.api.d.AwY;
                localObject3 = ((FinderItem)localObject1).getUserName();
                parambui = ((FinderItem)localObject1).getBizInfo();
                if (parambui != null) {
                  break label2068;
                }
                parambui = null;
                label1857:
                if (!d.a.a((String)localObject3, parambui, false, false, 12)) {
                  break label2076;
                }
                i = 1;
                label1872:
                ((dzj)localObject2).FUX = i;
              }
              parambui = localfhp.abIj;
              if (parambui != null)
              {
                if (((FinderItem)localObject1).getFavFlag() != 1) {
                  break label2081;
                }
                i = 1;
                label1899:
                parambui.aben = i;
              }
              parambui = ah.aiuX;
              parambui = ah.aiuX;
            }
            parambui = localfhp.abIj;
            if (parambui != null) {
              parambui.abeq = paramaf.FsL;
            }
            parambui = paramaf.FsC;
            if (parambui != null)
            {
              paramaf = localfhp.abIj;
              if (paramaf != null)
              {
                if (parambui.getFeedObject().likeFlag == 0) {
                  break label2086;
                }
                i = 1;
                label1961:
                paramaf.abel = i;
              }
              localObject1 = localfhp.abIj;
              if (localObject1 != null)
              {
                paramaf = com.tencent.mm.plugin.finder.api.d.AwY;
                paramaf = parambui.contact;
                if (paramaf != null) {
                  break label2091;
                }
                paramaf = null;
                label1993:
                if (!d.a.a(paramaf, null, false, false, 14)) {
                  break label2099;
                }
                i = 1;
                label2007:
                ((dzj)localObject1).FUX = i;
              }
              paramaf = localfhp.abIj;
              if (paramaf != null) {
                if (parambui.getFeedObject().favFlag != 1) {
                  break label2104;
                }
              }
            }
          }
          label2063:
          label2068:
          label2076:
          label2081:
          label2086:
          label2091:
          label2099:
          label2104:
          for (i = k;; i = 0)
          {
            paramaf.aben = i;
            paramaf = ah.aiuX;
            paramaf = ah.aiuX;
            AppMethodBeat.o(331105);
            return localfhp;
            i = 0;
            break;
            i = 0;
            break label1817;
            parambui = parambui.ADE;
            break label1857;
            i = 0;
            break label1872;
            i = 0;
            break label1899;
            i = 0;
            break label1961;
            paramaf = paramaf.username;
            break label1993;
            i = 0;
            break label2007;
          }
        }
      }
    }
    
    public static void a(fhp paramfhp, String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(331122);
      s.u(paramfhp, "stats");
      s.u(paramString, "tag");
      StringBuffer localStringBuffer = new StringBuffer("[Stats]\n");
      Object localObject1 = af.FsA;
      a(localStringBuffer, "feedId", Long.valueOf(paramfhp.hKN));
      if (BuildInfo.DEBUG)
      {
        localStringBuffer.append("strfeedId=" + com.tencent.mm.ae.d.hF(paramfhp.hKN) + '\n');
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        localObject1 = e.a.jn(paramfhp.hKN);
        if (localObject1 != null) {
          localStringBuffer.append("nick=" + ((FinderItem)localObject1).getNickName() + ", desc=" + ((FinderItem)localObject1).getDebugDescription() + '\n');
        }
      }
      localObject1 = af.FsA;
      localObject1 = paramfhp.abIi;
      if (localObject1 == null)
      {
        localObject1 = null;
        a(localStringBuffer, "vidPlayLen", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIi;
        if (localObject1 != null) {
          break label914;
        }
        localObject1 = null;
        label192:
        a(localStringBuffer, "stayTime", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIi;
        if (localObject1 != null) {
          break label925;
        }
        localObject1 = null;
        label216:
        a(localStringBuffer, "stayTimeMs", (Long)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIi;
        if (localObject1 != null) {
          break label936;
        }
        localObject1 = null;
        label240:
        a(localStringBuffer, "vidPlayTimeMs", (Long)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIi;
        if (localObject1 != null) {
          break label947;
        }
        localObject1 = null;
        label264:
        a(localStringBuffer, "vidPlayingTimeMs", (Long)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label958;
        }
        localObject1 = null;
        label288:
        a(localStringBuffer, "share", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label969;
        }
        localObject1 = null;
        label312:
        a(localStringBuffer, "forward_times", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label980;
        }
        localObject1 = null;
        label336:
        a(localStringBuffer, "feed_stay_time", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label991;
        }
        localObject1 = null;
        label360:
        a(localStringBuffer, "vid_replay_times", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1002;
        }
        localObject1 = null;
        label384:
        a(localStringBuffer, "max_vid_play_progress", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1013;
        }
        localObject1 = null;
        label408:
        a(localStringBuffer, "pageTurn", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1024;
        }
        localObject1 = null;
        label432:
        a(localStringBuffer, "clickComment", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1035;
        }
        localObject1 = null;
        label456:
        a(localStringBuffer, "clickHead", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1046;
        }
        localObject1 = null;
        label480:
        a(localStringBuffer, "likeStatus", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1057;
        }
        localObject1 = null;
        label504:
        a(localStringBuffer, "followStatus", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1068;
        }
        localObject1 = null;
        label528:
        a(localStringBuffer, "favStatus", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1079;
        }
        localObject1 = null;
        label552:
        a(localStringBuffer, "notInterestAction", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1090;
        }
        localObject1 = null;
        label576:
        a(localStringBuffer, "fastSlip", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1101;
        }
        localObject1 = null;
        label600:
        a(localStringBuffer, "sortId", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1112;
        }
        localObject1 = null;
        label624:
        a(localStringBuffer, "maxVidPlayLen", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1123;
        }
        localObject1 = null;
        label648:
        a(localStringBuffer, "clickTopicTimes", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1134;
        }
        localObject1 = null;
        label672:
        a(localStringBuffer, "expandTextTimes", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1145;
        }
        localObject1 = null;
        label696:
        a(localStringBuffer, "shareMomentTimes", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1156;
        }
        localObject1 = null;
        label720:
        a(localStringBuffer, "clickPoiTimes", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1167;
        }
        localObject1 = null;
        label744:
        a(localStringBuffer, "collapseTextTimes", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1178;
        }
        localObject1 = null;
        label768:
        a(localStringBuffer, "commentLikeTimes", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1189;
        }
        localObject1 = null;
        label792:
        a(localStringBuffer, "clickFeedMenu", (Integer)localObject1);
        localObject1 = af.FsA;
        localObject1 = paramfhp.abIj;
        if (localObject1 != null) {
          break label1200;
        }
        localObject1 = null;
        label816:
        a(localStringBuffer, "complainTimes", (Integer)localObject1);
        localObject1 = af.FsA;
        a(localStringBuffer, "actionTimeMs", Long.valueOf(paramfhp.abIk));
        localObject1 = af.FsA;
        a(localStringBuffer, "feedScene", Integer.valueOf(paramfhp.abIl));
        localObject1 = af.FsA;
        paramfhp = paramfhp.sessionBuffer;
        if (paramfhp != null) {
          break label1211;
        }
      }
      label914:
      label925:
      label936:
      label947:
      label1079:
      label1211:
      for (paramfhp = localObject2;; paramfhp = Integer.valueOf(paramfhp.length()))
      {
        a(localStringBuffer, "sessionBuffer", paramfhp);
        Log.i(paramString, localStringBuffer.toString());
        AppMethodBeat.o(331122);
        return;
        localObject1 = Integer.valueOf(((fvu)localObject1).abTW);
        break;
        localObject1 = Integer.valueOf(((fvu)localObject1).QXQ);
        break label192;
        localObject1 = Long.valueOf(((fvu)localObject1).zIy);
        break label216;
        localObject1 = Long.valueOf(((fvu)localObject1).abTX);
        break label240;
        localObject1 = Long.valueOf(((fvu)localObject1).abTY);
        break label264;
        label958:
        localObject1 = Integer.valueOf(((dzj)localObject1).share);
        break label288;
        label969:
        localObject1 = Integer.valueOf(((dzj)localObject1).abej);
        break label312;
        label980:
        localObject1 = Integer.valueOf(((dzj)localObject1).abeh);
        break label336;
        label991:
        localObject1 = Integer.valueOf(((dzj)localObject1).abei);
        break label360;
        label1002:
        localObject1 = Integer.valueOf(((dzj)localObject1).abeg);
        break label384;
        label1013:
        localObject1 = Integer.valueOf(((dzj)localObject1).abef);
        break label408;
        localObject1 = Integer.valueOf(((dzj)localObject1).FsN);
        break label432;
        localObject1 = Integer.valueOf(((dzj)localObject1).abek);
        break label456;
        localObject1 = Integer.valueOf(((dzj)localObject1).abel);
        break label480;
        localObject1 = Integer.valueOf(((dzj)localObject1).FUX);
        break label504;
        localObject1 = Integer.valueOf(((dzj)localObject1).aben);
        break label528;
        localObject1 = Integer.valueOf(((dzj)localObject1).aber);
        break label552;
        label1090:
        localObject1 = Integer.valueOf(((dzj)localObject1).abeo);
        break label576;
        label1101:
        localObject1 = Integer.valueOf(((dzj)localObject1).abep);
        break label600;
        label1112:
        localObject1 = Integer.valueOf(((dzj)localObject1).abeq);
        break label624;
        label1123:
        localObject1 = Integer.valueOf(((dzj)localObject1).abes);
        break label648;
        label1134:
        localObject1 = Integer.valueOf(((dzj)localObject1).abet);
        break label672;
        label1145:
        localObject1 = Integer.valueOf(((dzj)localObject1).abeu);
        break label696;
        localObject1 = Integer.valueOf(((dzj)localObject1).FsS);
        break label720;
        localObject1 = Integer.valueOf(((dzj)localObject1).FsT);
        break label744;
        localObject1 = Integer.valueOf(((dzj)localObject1).FsU);
        break label768;
        localObject1 = Integer.valueOf(((dzj)localObject1).FsX);
        break label792;
        localObject1 = Integer.valueOf(((dzj)localObject1).FsY);
        break label816;
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Integer paramInteger)
    {
      AppMethodBeat.i(331136);
      s.u(paramStringBuffer, "sb");
      s.u(paramString, "key");
      if (paramInteger == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramInteger + '\n');
        do
        {
          AppMethodBeat.o(331136);
          return;
        } while (paramInteger.intValue() == 0);
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Long paramLong)
    {
      AppMethodBeat.i(331129);
      s.u(paramStringBuffer, "sb");
      s.u(paramString, "key");
      if (paramLong == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramLong + '\n');
        do
        {
          AppMethodBeat.o(331129);
          return;
        } while (paramLong.longValue() == 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.af
 * JD-Core Version:    0.7.0.1
 */