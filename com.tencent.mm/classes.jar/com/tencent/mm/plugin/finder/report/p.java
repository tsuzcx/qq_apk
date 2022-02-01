package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.h;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.plugin.finder.video.reporter.b.b;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.i;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "", "feedId", "", "startTime", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "isCenterFeed", "", "videoPlayReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "(JJLcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;ZLcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "changePageTime", "", "getChangePageTime", "()[J", "setChangePageTime", "([J)V", "clickAvatar", "", "getClickAvatar", "()I", "setClickAvatar", "(I)V", "clickComment", "getClickComment", "setClickComment", "clickExpandText", "getClickExpandText", "setClickExpandText", "clickFav", "getClickFav", "setClickFav", "clickFeedMenu", "getClickFeedMenu", "setClickFeedMenu", "clickPoiTimes", "getClickPoiTimes", "setClickPoiTimes", "clickShareMoments", "getClickShareMoments", "setClickShareMoments", "collapseTextTimes", "getCollapseTextTimes", "setCollapseTextTimes", "commentLikeTimes", "getCommentLikeTimes", "setCommentLikeTimes", "complainTimes", "getComplainTimes", "setComplainTimes", "createTimestamp", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "endTime", "getEndTime", "setEndTime", "endVolume", "getEndVolume", "setEndVolume", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedDataPos", "getFeedDataPos", "setFeedDataPos", "getFeedId", "()Z", "setCenterFeed", "(Z)V", "isPause", "setPause", "isSeek", "setSeek", "lastPageIndex", "getLastPageIndex", "setLastPageIndex", "lastPlayTime", "getLastPlayTime", "setLastPlayTime", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "maxReplayCount", "getMaxReplayCount", "setMaxReplayCount", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "netType", "getNetType", "setNetType", "notInterest", "getNotInterest", "setNotInterest", "pageVideoPlayPercent", "", "getPageVideoPlayPercent", "()[I", "setPageVideoPlayPercent", "([I)V", "pageVideoReplayCount", "getPageVideoReplayCount", "setPageVideoReplayCount", "pauseTimes", "getPauseTimes", "setPauseTimes", "playFormat", "", "getPlayFormat", "()Ljava/lang/String;", "setPlayFormat", "(Ljava/lang/String;)V", "playProgressInfo", "getPlayProgressInfo", "setPlayProgressInfo", "playProgressSet", "Ljava/util/Vector;", "getPlayProgressSet", "()Ljava/util/Vector;", "setPlayProgressSet", "(Ljava/util/Vector;)V", "playTime", "getPlayTime", "setPlayTime", "playTimestamp", "getPlayTimestamp", "setPlayTimestamp", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "realPlayTimestamp", "getRealPlayTimestamp", "setRealPlayTimestamp", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getRvFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setRvFeed", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "shareCount", "getShareCount", "setShareCount", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getStartTime", "startVolume", "getStartVolume", "setStartVolume", "stayTime", "getStayTime", "setStayTime", "videoDuration", "getVideoDuration", "setVideoDuration", "getVideoPlayReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;", "setVideoPlayReporter", "(Lcom/tencent/mm/plugin/finder/video/reporter/FinderVideoPlayReporter;)V", "viewPageDuration", "getViewPageDuration", "setViewPageDuration", "voiceInfo", "getVoiceInfo", "setVoiceInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "copyRecord", "equals", "other", "hashCode", "onRelease", "", "toString", "Companion", "plugin-finder_release"})
public final class p
{
  private static final String TAG = "Finder.FinderSingleFeedRecord";
  private static final int vgA = 1;
  private static final int vgB = 2;
  public static final a vgC;
  public long dUy;
  public long endTime;
  public final long feedId;
  public int msj;
  public int netType;
  public final long startTime;
  public final FinderItem tHo;
  public i tIw;
  final bm uJO;
  public long uOV;
  public b vdR;
  public int vfP;
  public long[] vfQ;
  public long[] vfR;
  public int[] vfS;
  public int[] vfT;
  public int vfU;
  public int vfV;
  public int vfW;
  public int vfX;
  public int vfY;
  public int vfZ;
  public int vga;
  public int vgb;
  public int vgc;
  public int vgd;
  public int vge;
  public int vgf;
  public int vgg;
  public int vgh;
  long vgi;
  public int vgj;
  public int vgk;
  public int vgl;
  public long vgm;
  public long vgn;
  public long vgo;
  public long vgp;
  public int vgq;
  public int vgr;
  public String vgs;
  public Vector<Integer> vgt;
  public int vgu;
  public int vgv;
  public String vgw;
  String vgx;
  bo vgy;
  public boolean vgz;
  public int videoDuration;
  
  static
  {
    AppMethodBeat.i(250749);
    vgC = new a((byte)0);
    TAG = "Finder.FinderSingleFeedRecord";
    vgA = 1;
    vgB = 2;
    AppMethodBeat.o(250749);
  }
  
  public p(long paramLong1, long paramLong2, FinderItem paramFinderItem, i parami, boolean paramBoolean, b paramb, bm parambm)
  {
    AppMethodBeat.i(250747);
    this.feedId = paramLong1;
    this.startTime = paramLong2;
    this.tHo = paramFinderItem;
    this.tIw = parami;
    this.vgz = paramBoolean;
    this.vdR = paramb;
    this.uJO = parambm;
    this.uOV = cl.aWA();
    paramFinderItem = new long[9];
    int i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.vfQ = paramFinderItem;
    paramFinderItem = new long[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0L;
      i += 1;
    }
    this.vfR = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.vfS = paramFinderItem;
    paramFinderItem = new int[9];
    i = 0;
    while (i < 9)
    {
      paramFinderItem[i] = 0;
      i += 1;
    }
    this.vfT = paramFinderItem;
    this.vfW = 1;
    this.vgs = "";
    this.vgt = new Vector();
    this.vgw = "";
    this.vgx = "";
    this.vfQ[0] = this.startTime;
    paramFinderItem = this.vdR;
    if (paramFinderItem != null)
    {
      paramFinderItem = paramFinderItem.whF;
      if (paramFinderItem != null)
      {
        paramFinderItem = (b.b)paramFinderItem.get(Long.valueOf(this.feedId));
        if (paramFinderItem != null)
        {
          this.vgp = this.startTime;
          if (paramFinderItem.bfW) {
            this.vgn = this.startTime;
          }
          paramFinderItem = MMApplicationContext.getContext().getSystemService("audio");
          if (paramFinderItem == null)
          {
            paramFinderItem = new t("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(250747);
            throw paramFinderItem;
          }
          this.vgu = ((AudioManager)paramFinderItem).getStreamVolume(3);
          AppMethodBeat.o(250747);
          return;
        }
      }
    }
    AppMethodBeat.o(250747);
  }
  
  public final void Fh(long paramLong)
  {
    this.vgn = paramLong;
  }
  
  public final void KA(int paramInt)
  {
    this.vgj = paramInt;
  }
  
  public final void KB(int paramInt)
  {
    this.vgk = paramInt;
  }
  
  public final void Kz(int paramInt)
  {
    this.vgg = paramInt;
  }
  
  public final void a(b arg1)
  {
    AppMethodBeat.i(250745);
    if (this.endTime == 0L) {
      this.endTime = cl.aWA();
    }
    Object localObject1 = this.tHo;
    if (localObject1 != null)
    {
      localObject1 = ((FinderItem)localObject1).getMediaList();
      if (localObject1 != null)
      {
        localObject1 = (cjl)j.kt((List)localObject1);
        if (localObject1 != null)
        {
          i = ((cjl)localObject1).videoDuration;
          this.videoDuration = i;
          localObject1 = this.uJO;
          if (localObject1 != null)
          {
            localObject1 = ((bm)localObject1).tuP;
            if (localObject1 == null) {
              break label296;
            }
            localObject1 = ((cng)localObject1).MtG;
            if (localObject1 == null) {
              break label296;
            }
            localObject1 = ((cnl)localObject1).media;
            if (localObject1 == null) {
              break label296;
            }
            localObject1 = (cod)j.kt((List)localObject1);
            if (localObject1 == null) {
              break label296;
            }
          }
        }
      }
    }
    b.b localb;
    label296:
    for (int i = ((cod)localObject1).Mur;; i = 0)
    {
      this.videoDuration = i;
      if (this.vgz) {
        this.dUy = (this.endTime - this.startTime);
      }
      if (??? == null) {
        break label732;
      }
      ??? = ???.whF;
      if (??? == null) {
        break label732;
      }
      localb = (b.b)???.get(Long.valueOf(this.feedId));
      if (localb == null) {
        break label732;
      }
      if (this.vgp != 0L) {
        this.vgo += this.endTime - this.vgp;
      }
      if (this.vgn != 0L) {
        this.vgm += this.endTime - this.vgn;
      }
      ??? = MMApplicationContext.getContext().getSystemService("audio");
      if (??? != null) {
        break label301;
      }
      ??? = new t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(250745);
      throw ???;
      i = 0;
      break;
    }
    label301:
    this.vgv = ((AudioManager)???).getStreamVolume(3);
    ??? = MMApplicationContext.getContext().getSystemService("audio");
    if (??? == null)
    {
      ??? = new t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(250745);
      throw ???;
    }
    int j = ((AudioManager)???).getStreamMaxVolume(3);
    i = 0;
    if (this.vgu != this.vgv) {
      i = 1;
    }
    this.vgw = (this.vgu * 100 / j + '#' + this.vgv * 100 / j + '#' + i);
    ??? = k.vfA;
    this.netType = k.dod();
    synchronized ((Iterable)this.vgt)
    {
      localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject1).next();
        String str = this.vgs;
        this.vgs = (str + localInteger + '#');
      }
    }
    Object localObject3 = x.SXb;
    ??? = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
    localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.avH(localb.whM).field_fileFormat;
    ??? = (b)localObject3;
    if (localObject3 == null) {
      ??? = "";
    }
    int m = 0;
    int n = 0;
    int i1 = 0;
    localObject3 = localb.whP;
    int k = i1;
    j = n;
    i = m;
    if (localObject3 != null)
    {
      localObject3 = com.tencent.mm.plugin.sight.base.e.aNx(((s)localObject3).getPath());
      k = i1;
      j = n;
      i = m;
      if (localObject3 != null)
      {
        j = ((a)localObject3).videoBitrate;
        i = ((a)localObject3).audioBitrate;
        k = ((a)localObject3).frameRate;
      }
    }
    this.vgx = (localb.wiz + ';' + j + ';' + ??? + ';' + i + ';' + k + ';' + localb.wiA + ';' + localb.wiB + ';');
    AppMethodBeat.o(250745);
    return;
    label732:
    AppMethodBeat.o(250745);
  }
  
  public final long[] doi()
  {
    return this.vfQ;
  }
  
  public final int[] doj()
  {
    return this.vfS;
  }
  
  public final int[] dok()
  {
    return this.vfT;
  }
  
  public final int dol()
  {
    return this.vfU;
  }
  
  public final int dom()
  {
    return this.vgg;
  }
  
  public final int don()
  {
    return this.vgj;
  }
  
  public final int doo()
  {
    return this.vgk;
  }
  
  public final long dop()
  {
    return this.vgn;
  }
  
  public final long doq()
  {
    return this.vgp;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250752);
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((this.feedId != paramObject.feedId) || (this.startTime != paramObject.startTime) || (!kotlin.g.b.p.j(this.tHo, paramObject.tHo)) || (!kotlin.g.b.p.j(this.tIw, paramObject.tIw)) || (this.vgz != paramObject.vgz) || (!kotlin.g.b.p.j(this.vdR, paramObject.vdR)) || (!kotlin.g.b.p.j(this.uJO, paramObject.uJO))) {}
      }
    }
    else
    {
      AppMethodBeat.o(250752);
      return true;
    }
    AppMethodBeat.o(250752);
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
    AppMethodBeat.i(250750);
    String str = "FinderSingleFeedRecord(feedId=" + this.feedId + ", startTime=" + this.startTime + ", feed=" + this.tHo + ", showInfo=" + this.tIw + ", isCenterFeed=" + this.vgz + ", videoPlayReporter=" + this.vdR + ", megaVideoFeed=" + this.uJO + ")";
    AppMethodBeat.o(250750);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord$Companion;", "", "()V", "FinderStatsReportFeedTypeRelated", "", "getFinderStatsReportFeedTypeRelated", "()I", "FinderStatsReportFeedTypeStream", "getFinderStatsReportFeedTypeStream", "TAG", "", "getTAG", "()Ljava/lang/String;", "expandNotZeroValue", "", "sb", "Ljava/lang/StringBuffer;", "key", "value", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Integer;)V", "", "(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/Long;)V", "printStats", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "tag", "trans2Stats", "record", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"})
  public static final class a
  {
    public static ecq a(p paramp, bbn parambbn)
    {
      int k = 1;
      AppMethodBeat.i(250741);
      kotlin.g.b.p.h(paramp, "record");
      kotlin.g.b.p.h(parambbn, "contextObj");
      ecq localecq = new ecq();
      BitSet localBitSet = new BitSet(64);
      Object localObject1 = paramp.uJO;
      long l;
      Object localObject2;
      label110:
      int i;
      if (localObject1 != null)
      {
        l = ((bm)localObject1).dkW();
        localecq.hFK = l;
        localObject1 = paramp.uJO;
        if (localObject1 != null)
        {
          localObject2 = ((bm)localObject1).dkX();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = paramp.tHo;
          if (localObject1 == null) {
            break label493;
          }
          localObject1 = ((FinderItem)localObject1).getObjectNonceId();
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localecq.objectNonceId = ((String)localObject2);
        localObject1 = paramp.uJO;
        if (localObject1 == null) {
          break label499;
        }
        l = ((bm)localObject1).lT();
        label148:
        localecq.NcU = l;
        localObject1 = paramp.uJO;
        if (localObject1 != null)
        {
          localObject1 = ((bm)localObject1).tuP;
          if (localObject1 != null)
          {
            localObject2 = ((cng)localObject1).LOd;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label198;
            }
          }
        }
        localObject1 = "";
        label198:
        localecq.NcV = ((String)localObject1);
        localecq.NcM = new mp();
        localecq.NcN = new epf();
        localecq.NcO = new cxr();
        localObject1 = paramp.uJO;
        if (localObject1 != null)
        {
          localObject1 = ((bm)localObject1).contact;
          if (localObject1 != null)
          {
            localObject2 = ((FinderContact)localObject1).username;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label298;
            }
          }
        }
        localObject1 = paramp.tHo;
        if (localObject1 == null) {
          break label505;
        }
        localObject1 = ((FinderItem)localObject1).field_username;
        label298:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localecq.finderUsername = ((String)localObject2);
        localecq.NcP = paramp.uOV;
        if (parambbn.tCE == 20)
        {
          localObject1 = h.vGk;
          localObject1 = h.FH(paramp.feedId);
          if ((localObject1 == null) || (((FinderItem)localObject1).isRelatedItem() != true)) {
            break label511;
          }
          i = p.dos();
          label368:
          localecq.NcQ = i;
        }
        if (paramp.uJO != null)
        {
          localObject1 = paramp.tHo;
          if ((localObject1 == null) || (((FinderItem)localObject1).isReplaceLongVideoToNormal() != true)) {
            break label518;
          }
        }
        localObject1 = k.vfA;
      }
      int j;
      for (localObject1 = k.G(paramp.feedId, parambbn.tCE);; localObject1 = k.H(paramp.feedId, parambbn.tCE))
      {
        localecq.sessionBuffer = ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        localecq.NcS = e.a.ak(parambbn.tCE, paramp.feedId);
        localecq.NcW = paramp.startTime;
        j = paramp.vfW;
        i = 0;
        while (i < j)
        {
          localBitSet.set(i, true);
          i += 1;
        }
        l = paramp.feedId;
        break;
        label493:
        localObject1 = null;
        break label110;
        label499:
        l = 0L;
        break label148;
        label505:
        localObject1 = null;
        break label298;
        label511:
        i = p.dor();
        break label368;
        label518:
        localObject1 = k.vfA;
      }
      float f;
      label579:
      label593:
      int m;
      if (paramp.vfY < 5)
      {
        localBitSet.set(9, true);
        f = (float)paramp.dUy / 1000.0F;
        if (f >= 0.5F) {
          break label835;
        }
        localBitSet.set(21, true);
        parambbn = paramp.vfT;
        int n = parambbn.length;
        j = 0;
        i = 0;
        if (j >= n) {
          break label1011;
        }
        m = parambbn[j];
        if (m <= i) {
          break label1944;
        }
        i = m;
      }
      label1924:
      label1929:
      label1934:
      label1939:
      label1944:
      for (;;)
      {
        j += 1;
        break label593;
        if (paramp.vfY < 10)
        {
          localBitSet.set(10, true);
          break;
        }
        if (paramp.vfY < 20)
        {
          localBitSet.set(11, true);
          break;
        }
        if (paramp.vfY < 30)
        {
          localBitSet.set(12, true);
          break;
        }
        if (paramp.vfY < 40)
        {
          localBitSet.set(13, true);
          break;
        }
        if (paramp.vfY < 50)
        {
          localBitSet.set(14, true);
          break;
        }
        if (paramp.vfY < 60)
        {
          localBitSet.set(15, true);
          break;
        }
        if (paramp.vfY < 70)
        {
          localBitSet.set(16, true);
          break;
        }
        if (paramp.vfY < 80)
        {
          localBitSet.set(17, true);
          break;
        }
        if (paramp.vfY < 90)
        {
          localBitSet.set(18, true);
          break;
        }
        if (paramp.vfY < 100)
        {
          localBitSet.set(19, true);
          break;
        }
        localBitSet.set(20, true);
        break;
        label835:
        if (f < 1.0F)
        {
          localBitSet.set(22, true);
          break label579;
        }
        if (f < 2.0F)
        {
          localBitSet.set(23, true);
          break label579;
        }
        if (f < 3.0F)
        {
          localBitSet.set(24, true);
          break label579;
        }
        if (f < 5.0F)
        {
          localBitSet.set(25, true);
          break label579;
        }
        if (f < 10.0F)
        {
          localBitSet.set(26, true);
          break label579;
        }
        if (f < 20.0F)
        {
          localBitSet.set(27, true);
          break label579;
        }
        if (f < 30.0F)
        {
          localBitSet.set(28, true);
          break label579;
        }
        if (f < 40.0F)
        {
          localBitSet.set(29, true);
          break label579;
        }
        if (f < 50.0F)
        {
          localBitSet.set(30, true);
          break label579;
        }
        localBitSet.set(31, true);
        break label579;
        label1011:
        if (i == 0) {
          localBitSet.set(32, true);
        }
        for (;;)
        {
          l = localBitSet.toLongArray()[0];
          parambbn = localecq.NcM;
          if (parambbn != null) {
            parambbn.KQT = l;
          }
          parambbn = localecq.NcN;
          if (parambbn != null) {
            parambbn.ElR = ((int)f);
          }
          parambbn = localecq.NcN;
          if (parambbn != null) {
            parambbn.Nnc = paramp.videoDuration;
          }
          parambbn = localecq.NcN;
          if (parambbn != null) {
            parambbn.sGB = paramp.dUy;
          }
          parambbn = localecq.NcN;
          if (parambbn != null) {
            parambbn.Nnd = paramp.vgo;
          }
          parambbn = localecq.NcN;
          if (parambbn != null) {
            parambbn.Nne = paramp.vgm;
          }
          parambbn = localecq.NcN;
          if (parambbn != null)
          {
            parambbn.Nnf = paramp.dUy;
            parambbn.iJF = paramp.startTime;
            parambbn.Nng = paramp.endTime;
            parambbn.vgi = paramp.vgi;
            parambbn.Nnh = paramp.vgh;
            parambbn.Nni = 1;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCg = ((int)f);
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCh = i;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCf = paramp.vfY;
          }
          parambbn = paramp.vfQ;
          m = parambbn.length;
          j = 0;
          i = 0;
          while (j < m)
          {
            if (parambbn[j] > 0L)
            {
              localObject1 = localecq.NcO;
              if (localObject1 != null) {
                ((cxr)localObject1).MCe = i;
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
        parambbn = localecq.NcO;
        if (parambbn != null) {
          parambbn.MCi = paramp.msj;
        }
        parambbn = localecq.NcO;
        if (parambbn != null)
        {
          if (paramp.msj > 0)
          {
            i = 1;
            parambbn.MCk = i;
          }
        }
        else
        {
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.vfZ = paramp.vfZ;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCj = paramp.vga;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCr = paramp.vgl;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCp = paramp.vfP;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCs = paramp.vge;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCt = paramp.vgc;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCu = paramp.vgd;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.vge = paramp.vge;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.vgf = paramp.vgf;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.vgg = paramp.vgg;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.vgj = paramp.vgj;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.vgk = paramp.vgk;
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCw = paramp.vgr;
          }
          parambbn = paramp.tHo;
          if (parambbn != null)
          {
            localObject1 = localecq.NcO;
            if (localObject1 != null)
            {
              if (parambbn.getLikeFlag() == 0) {
                break label1909;
              }
              i = 1;
              label1699:
              ((cxr)localObject1).MCl = i;
            }
            localObject1 = localecq.NcO;
            if (localObject1 != null)
            {
              localObject2 = c.tsp;
              if (!c.a.asJ(parambbn.getUserName())) {
                break label1914;
              }
              i = 1;
              label1734:
              ((cxr)localObject1).vPj = i;
            }
            localObject1 = localecq.NcO;
            if (localObject1 != null)
            {
              if (parambbn.getFavFlag() != 1) {
                break label1919;
              }
              i = 1;
              label1762:
              ((cxr)localObject1).MCn = i;
            }
          }
          parambbn = localecq.NcO;
          if (parambbn != null) {
            parambbn.MCq = paramp.vfX;
          }
          parambbn = paramp.uJO;
          if (parambbn != null)
          {
            paramp = localecq.NcO;
            if (paramp != null)
            {
              if (parambbn.getFeedObject().likeFlag == 0) {
                break label1924;
              }
              i = 1;
              label1817:
              paramp.MCl = i;
            }
            localObject1 = localecq.NcO;
            if (localObject1 != null)
            {
              paramp = c.tsp;
              paramp = parambbn.contact;
              if (paramp == null) {
                break label1929;
              }
              paramp = paramp.username;
              label1852:
              if (!c.a.asJ(paramp)) {
                break label1934;
              }
              i = 1;
              label1861:
              ((cxr)localObject1).vPj = i;
            }
            paramp = localecq.NcO;
            if (paramp != null) {
              if (parambbn.getFeedObject().favFlag != 1) {
                break label1939;
              }
            }
          }
        }
        for (i = k;; i = 0)
        {
          paramp.MCn = i;
          AppMethodBeat.o(250741);
          return localecq;
          i = 0;
          break;
          label1909:
          i = 0;
          break label1699;
          label1914:
          i = 0;
          break label1734;
          label1919:
          i = 0;
          break label1762;
          i = 0;
          break label1817;
          paramp = null;
          break label1852;
          i = 0;
          break label1861;
        }
      }
    }
    
    public static void a(ecq paramecq, String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(250742);
      kotlin.g.b.p.h(paramecq, "stats");
      kotlin.g.b.p.h(paramString, "tag");
      StringBuffer localStringBuffer = new StringBuffer("[Stats]\n");
      Object localObject1 = p.vgC;
      a(localStringBuffer, "feedId", Long.valueOf(paramecq.hFK));
      if (BuildInfo.DEBUG)
      {
        localStringBuffer.append("strfeedId=" + com.tencent.mm.ac.d.zs(paramecq.hFK) + '\n');
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        localObject1 = e.a.Fy(paramecq.hFK);
        if (localObject1 != null) {
          localStringBuffer.append("nick=" + ((FinderItem)localObject1).getNickName() + ", desc=" + ((FinderItem)localObject1).getDebugDescription() + '\n');
        }
      }
      localObject1 = p.vgC;
      localObject1 = paramecq.NcN;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((epf)localObject1).Nnc);
        a(localStringBuffer, "vidPlayLen", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcN;
        if (localObject1 == null) {
          break label1084;
        }
        localObject1 = Integer.valueOf(((epf)localObject1).ElR);
        label204:
        a(localStringBuffer, "stayTime", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcN;
        if (localObject1 == null) {
          break label1089;
        }
        localObject1 = Long.valueOf(((epf)localObject1).sGB);
        label234:
        a(localStringBuffer, "stayTimeMs", (Long)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcN;
        if (localObject1 == null) {
          break label1094;
        }
        localObject1 = Long.valueOf(((epf)localObject1).Nnd);
        label264:
        a(localStringBuffer, "vidPlayTimeMs", (Long)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcN;
        if (localObject1 == null) {
          break label1099;
        }
        localObject1 = Long.valueOf(((epf)localObject1).Nne);
        label294:
        a(localStringBuffer, "vidPlayingTimeMs", (Long)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1104;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCk);
        label324:
        a(localStringBuffer, "share", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1109;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCi);
        label354:
        a(localStringBuffer, "forward_times", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1114;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCg);
        label384:
        a(localStringBuffer, "feed_stay_time", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1119;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCh);
        label414:
        a(localStringBuffer, "vid_replay_times", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1124;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCf);
        label444:
        a(localStringBuffer, "max_vid_play_progress", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1129;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCe);
        label474:
        a(localStringBuffer, "pageTurn", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1134;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).vfZ);
        label504:
        a(localStringBuffer, "clickComment", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1139;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCj);
        label534:
        a(localStringBuffer, "clickHead", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1144;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCl);
        label564:
        a(localStringBuffer, "likeStatus", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1149;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).vPj);
        label594:
        a(localStringBuffer, "followStatus", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1154;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCn);
        label624:
        a(localStringBuffer, "favStatus", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1159;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCr);
        label654:
        a(localStringBuffer, "notInterestAction", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1164;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCo);
        label684:
        a(localStringBuffer, "fastSlip", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1169;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCp);
        label714:
        a(localStringBuffer, "sortId", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1174;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCq);
        label744:
        a(localStringBuffer, "maxVidPlayLen", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1179;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCs);
        label774:
        a(localStringBuffer, "clickTopicTimes", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1184;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCt);
        label804:
        a(localStringBuffer, "expandTextTimes", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1189;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).MCu);
        label834:
        a(localStringBuffer, "shareMomentTimes", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1194;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).vge);
        label864:
        a(localStringBuffer, "clickPoiTimes", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1199;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).vgf);
        label894:
        a(localStringBuffer, "collapseTextTimes", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1204;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).vgg);
        label924:
        a(localStringBuffer, "commentLikeTimes", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1209;
        }
        localObject1 = Integer.valueOf(((cxr)localObject1).vgj);
        label954:
        a(localStringBuffer, "clickFeedMenu", (Integer)localObject1);
        localObject1 = p.vgC;
        localObject1 = paramecq.NcO;
        if (localObject1 == null) {
          break label1214;
        }
      }
      label1084:
      label1214:
      for (localObject1 = Integer.valueOf(((cxr)localObject1).vgk);; localObject1 = null)
      {
        a(localStringBuffer, "complainTimes", (Integer)localObject1);
        localObject1 = p.vgC;
        a(localStringBuffer, "actionTimeMs", Long.valueOf(paramecq.NcP));
        localObject1 = p.vgC;
        a(localStringBuffer, "feedScene", Integer.valueOf(paramecq.NcQ));
        localObject1 = p.vgC;
        localObject1 = paramecq.sessionBuffer;
        paramecq = localObject2;
        if (localObject1 != null) {
          paramecq = Integer.valueOf(((String)localObject1).length());
        }
        a(localStringBuffer, "sessionBuffer", paramecq);
        Log.i(paramString, localStringBuffer.toString());
        AppMethodBeat.o(250742);
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
      AppMethodBeat.i(250744);
      kotlin.g.b.p.h(paramStringBuffer, "sb");
      kotlin.g.b.p.h(paramString, "key");
      if (paramInteger == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramInteger + '\n');
        do
        {
          AppMethodBeat.o(250744);
          return;
        } while (paramInteger.intValue() == 0);
      }
    }
    
    private static void a(StringBuffer paramStringBuffer, String paramString, Long paramLong)
    {
      AppMethodBeat.i(250743);
      kotlin.g.b.p.h(paramStringBuffer, "sb");
      kotlin.g.b.p.h(paramString, "key");
      if (paramLong == null) {}
      for (;;)
      {
        paramStringBuffer.append(paramString + '=' + paramLong + '\n');
        do
        {
          AppMethodBeat.o(250743);
          return;
        } while (paramLong.longValue() == 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p
 * JD-Core Version:    0.7.0.1
 */