package com.tencent.mm.plugin.expt.hellhound.ext.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.gy;
import com.tencent.mm.autogen.mmdata.rpt.sb;
import com.tencent.mm.autogen.mmdata.rpt.sc;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.d.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.d.d;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport$Companion;", "", "()V", "TAG", "", "startTimeOnCreate", "", "getStartTimeOnCreate", "()J", "setStartTimeOnCreate", "(J)V", "startTimeProfileTimeLine", "getStartTimeProfileTimeLine", "setStartTimeProfileTimeLine", "report19943", "", "statistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "report19944", "feed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "report19945", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "report21053OnClickOnSnsAd", "feedId", "liveId", "userName", "pos", "reportGiftOnReturn", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  private static final void a(gy paramgy)
  {
    AppMethodBeat.i(300305);
    s.u(paramgy, "$struct");
    paramgy.bMH();
    Log.i("HABBYGE-MALI.HellFinderReport", "report[19943]: sessionId=" + paramgy.ijk + ", page=" + paramgy.iLJ + ", enterTimeMs=" + paramgy.iGN + ", exitTimeMs=" + paramgy.izc + ", stayTimeMs=" + paramgy.ipo + ", sid=" + paramgy.iLK + ", reportType=" + paramgy.iLL + ", contextId=" + paramgy.ipU + ", finderContextId=" + paramgy.iLM + ", extraInfo=" + paramgy.iwJ + ",  enterSourceInfo=" + paramgy.iwK);
    AppMethodBeat.o(300305);
  }
  
  private static final void a(sb paramsb, a parama)
  {
    AppMethodBeat.i(300318);
    s.u(paramsb, "$struct");
    s.u(parama, "$clickFeed");
    paramsb.gNE();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report[19945]:\nsessionId=").append(paramsb.ijk).append("\nclickFeedId=").append(paramsb.izW).append("\nposition=").append(parama.position).append("\nnickName=").append(parama.nickName).append("\nscene=").append(paramsb.imW).append("\nupdateTimeMs=").append(paramsb.jxg).append("\nclickTimeMs=").append(paramsb.jxh).append("\nitemExposureAreaWeigth=").append(paramsb.jxi).append("\nscreenExposureAreaWeigth=").append(paramsb.jxj).append("\nitemDirection=").append(paramsb.jxk).append("\nitemIndex=").append(paramsb.jxl).append("\nshotScreenJson=");
    localStringBuilder.append(paramsb.jxm).append("\ncontextId=").append(paramsb.ipT).append("\nitemBufffer=").append(paramsb.jxn).append("\nitemArrayIndex=").append(paramsb.jxo);
    Log.i("HABBYGE-MALI.HellFinderReport", localStringBuilder.toString());
    AppMethodBeat.o(300318);
  }
  
  private static final void a(sc paramsc, com.tencent.mm.plugin.expt.hellhound.ext.b.d.i parami)
  {
    AppMethodBeat.i(300313);
    s.u(paramsc, "$struct");
    s.u(parami, "$feed");
    paramsc.gNE();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report[19944]:\nsessionId=").append(paramsc.ijk).append("\nfeedId=").append(paramsc.ivZ).append("\nname=").append(parami.nickName).append("\nstartExposureMs=").append(paramsc.jxp).append("\nendExposureMs=").append(paramsc.jxq).append("\nitemExposureTimeMs=").append(paramsc.jxs).append("\nscreenExposureAreaWeigth=").append(paramsc.jxj).append("\ndisAppearType=").append(paramsc.jxr).append("\ncontextId=").append(paramsc.ipT).append("\nscene=").append(paramsc.imW).append("\nupdataTimeMs=").append(paramsc.jxg).append("\nitemPos=");
    localStringBuilder.append(paramsc.jxt).append("\nitemArrayIndex=").append(paramsc.jxo).append("\nitemBufffer=").append(paramsc.jxn).append("\nitemExposureAreaWeigth=").append(paramsc.jxi);
    Log.i("HABBYGE-MALI.HellFinderReport", localStringBuilder.toString());
    AppMethodBeat.o(300313);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(300273);
    s.u(paramb, "statistics");
    gy localgy = new gy();
    localgy.ijk = localgy.F("SessionId", paramb.sessionId, true);
    localgy.ro(com.tencent.mm.plugin.expt.hellhound.core.b.ara(paramb.hJW));
    localgy.fa(paramb.zIz);
    localgy.fb(paramb.zIA);
    localgy.eZ(paramb.zIy);
    localgy.ipU = localgy.F("ClickTabContextId", paramb.zIB, true);
    localgy.iLM = localgy.F("FinderContextID", com.tencent.mm.plugin.expt.hellhound.core.b.bys(), true);
    Object localObject2;
    Object localObject1;
    if (s.p(localgy.iLJ, "FinderTopicFeedUI"))
    {
      localObject2 = localgy.iLJ;
      if (paramb.zID)
      {
        localObject1 = "_POI";
        localgy.ro(s.X((String)localObject2, localObject1));
      }
    }
    else
    {
      localgy.iLK = localgy.F("Sid", paramb.zIC, true);
      localgy.iLL = paramb.hYb;
      localObject1 = paramb.extraInfo;
      if (localObject1 != null) {
        break label266;
      }
      localObject1 = null;
      label182:
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = d.zIX;
        localObject2 = d.dKW();
      }
      localgy.iwJ = localgy.F("ExtraInfo", (String)localObject2, true);
      paramb = paramb.zIE;
      if (paramb != null) {
        break label281;
      }
      paramb = "";
    }
    for (;;)
    {
      localgy.iwK = localgy.F("enterSourceInfo", paramb, true);
      com.tencent.threadpool.h.ahAA.bp(new a.a..ExternalSyntheticLambda0(localgy));
      AppMethodBeat.o(300273);
      return;
      localObject1 = "";
      break;
      label266:
      localObject1 = n.m((String)localObject1, ",", ";", false);
      break label182;
      label281:
      localObject1 = n.m(paramb, ",", ";", false);
      paramb = (b)localObject1;
      if (localObject1 == null) {
        paramb = "";
      }
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(300294);
    s.u(parama, "clickFeed");
    sb localsb = new sb();
    localsb.ijk = localsb.F("SessionId", parama.sessionId, true);
    localsb.izW = localsb.F("ClickFeedId", parama.zIG, true);
    localsb.imW = parama.scene;
    localsb.fr(parama.zIH);
    localsb.fs(parama.zII);
    Object localObject;
    float f2;
    if (parama.zIJ <= 0.0F)
    {
      f1 = 100.0F;
      localObject = am.aixg;
      localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      localsb.jxi = localsb.F("ItemExposureAreaWeigth", (String)localObject, true);
      if (parama.zIK > 0.0F) {
        break label344;
      }
      f1 = parama.width;
      f2 = parama.height;
      localObject = c.zGj;
    }
    label344:
    for (float f1 = f1 * f2 * 100.0F / c.dKy();; f1 = parama.zIK)
    {
      localObject = am.aixg;
      localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      localsb.jxj = localsb.F("ScreenExposureAreaWeigth", (String)localObject, true);
      localsb.jxk = parama.zIL;
      localsb.jxl = parama.zIM;
      localsb.jxm = localsb.F("ShotScreenJson", com.tencent.mm.plugin.expt.hellhound.core.b.arb(parama.zIN), true);
      localsb.ipT = localsb.F("ContextId", parama.zIO, true);
      localsb.jxn = localsb.F("ItemBufffer", parama.zIP, true);
      localsb.jxo = parama.zIQ;
      com.tencent.threadpool.h.ahAA.bp(new a.a..ExternalSyntheticLambda1(localsb, parama));
      AppMethodBeat.o(300294);
      return;
      f1 = parama.zIJ;
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.expt.hellhound.ext.b.d.i parami)
  {
    AppMethodBeat.i(300286);
    s.u(parami, "feed");
    sc localsc = new sc();
    localsc.ijk = localsc.F("SessionId", parami.sessionId, true);
    localsc.ivZ = localsc.F("FeedId", parami.feedId, true);
    localsc.jxp = parami.zJr;
    localsc.jxq = parami.zJs;
    localsc.jxr = parami.zJt;
    Object localObject;
    float f2;
    if (parami.zIJ <= 0.0F)
    {
      f1 = 100.0F;
      localObject = am.aixg;
      localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      localsc.jxi = localsc.F("ItemExposureAreaWeigth", (String)localObject, true);
      if (localsc.jxr == -1) {
        localsc.jxr = 0;
      }
      if (parami.zIK > 0.0F) {
        break label354;
      }
      f1 = parami.width;
      f2 = parami.height;
      localObject = c.zGj;
    }
    label354:
    for (float f1 = f1 * f2 * 100.0F / c.dKy();; f1 = parami.zIK)
    {
      localObject = am.aixg;
      localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      localsc.jxj = localsc.F("ScreenExposureAreaWeigth", (String)localObject, true);
      localsc.ipT = localsc.F("ContextId", parami.zIO, true);
      localsc.imW = parami.scene;
      localsc.ft(parami.zIH);
      localsc.fu(parami.zJu);
      localsc.jxt = parami.zJv;
      localsc.jxo = parami.dpP;
      localsc.jxn = localsc.F("ItemBufffer", parami.zIP, true);
      com.tencent.threadpool.h.ahAA.bp(new a.a..ExternalSyntheticLambda2(localsc, parami));
      AppMethodBeat.o(300286);
      return;
      f1 = parami.zIJ;
      break;
    }
  }
  
  public static void reportGiftOnReturn()
  {
    AppMethodBeat.i(300298);
    c.a locala = c.zGj;
    if (!c.dKq())
    {
      AppMethodBeat.o(300298);
      return;
    }
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).reportGiftOnReturn();
    AppMethodBeat.o(300298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a
 * JD-Core Version:    0.7.0.1
 */