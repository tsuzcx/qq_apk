package com.tencent.mm.plugin.finder.utils;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveAnchorFlowStats;", "", "()V", "KEY_ID", "", "TAG", "", "flow", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "Lkotlin/collections/ArrayList;", "getFlow", "()Ljava/util/ArrayList;", "historyLog", "getHistoryLog", "()Ljava/lang/String;", "setHistoryLog", "(Ljava/lang/String;)V", "end", "", "delay", "", "logStage", "reportLinkAcceptCloseFail", "reportLinkAcceptCloseSuc", "reportLinkAcceptSdkSuc", "reportLinkAcceptSvrFail", "reportLinkAcceptSvrSuc", "tag", "stage", "extra", "Lcom/tencent/mm/protobuf/ByteString;", "isStart", "", "isEnd", "PercentConversion", "plugin-finder_release"})
public final class ac
{
  private static final String TAG = "Finder.LiveAnchorFlowStats";
  private static final ArrayList<ecj> vYm;
  private static String vYn;
  private static final long vYo = 1552L;
  public static final ac vYp;
  
  static
  {
    AppMethodBeat.i(253754);
    vYp = new ac();
    TAG = "Finder.LiveAnchorFlowStats";
    vYm = new ArrayList();
    vYn = "";
    vYo = 1552L;
    AppMethodBeat.o(253754);
  }
  
  private void a(String paramString, b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject;
      ad.a locala;
      int i;
      try
      {
        AppMethodBeat.i(253746);
        p.h(paramString, "stage");
        if (paramBoolean1)
        {
          vYm.clear();
          localObject = new ecj();
          ((ecj)localObject).id = "";
          ((ecj)localObject).wVT = paramString;
          ((ecj)localObject).Asv = cl.aWy();
          if (!paramBoolean1) {
            break label321;
          }
          locala = ad.vZu;
          i = ad.dDz();
          ((ecj)localObject).type = i;
          ((ecj)localObject).NcA = paramb;
          paramb = a.vYE;
          p.h(localObject, "tag");
          paramb = ((ecj)localObject).wVT;
          locala = ad.vZu;
          if (!p.j(paramb, ad.dDM().name)) {
            break label339;
          }
          a.dDr();
          Log.i(TAG, "reportPost");
          vYm.add(localObject);
          Log.i(TAG, "tag, stage:" + paramString + ", isStart:" + paramBoolean1 + ", isEnd:" + paramBoolean2);
          if (paramBoolean2) {
            com.tencent.f.h.RTc.o((Runnable)b.vYF, 0L);
          }
          AppMethodBeat.o(253746);
          return;
        }
        if (vYm.isEmpty()) {
          break label313;
        }
        localObject = (ecj)j.kt((List)vYm);
        if (localObject != null)
        {
          i = ((ecj)localObject).type;
          localObject = ad.vZu;
          if (i != ad.dDz()) {
            break label313;
          }
          localObject = (ecj)j.kv((List)vYm);
          if (localObject == null) {
            continue;
          }
          i = ((ecj)localObject).type;
          localObject = ad.vZu;
          if (i != ad.dDA()) {
            continue;
          }
          AppMethodBeat.o(253746);
          continue;
        }
        AppMethodBeat.o(253746);
      }
      finally {}
      continue;
      label313:
      AppMethodBeat.o(253746);
      continue;
      label321:
      if (paramBoolean2)
      {
        locala = ad.vZu;
        i = ad.dDA();
        continue;
        label339:
        locala = ad.vZu;
        if (p.j(paramb, ad.dDW().name))
        {
          a.dDs();
          Log.i(TAG, "reportCancel");
        }
        else
        {
          locala = ad.vZu;
          if (p.j(paramb, ad.dDO().name))
          {
            a.dDt();
            a.a((ecj)localObject);
            Log.i(TAG, "reportFailedCreateLive");
          }
          else
          {
            locala = ad.vZu;
            if (p.j(paramb, ad.dDR().name))
            {
              a.dDu();
              a.a((ecj)localObject);
              Log.i(TAG, "reportFailedJoinLive");
            }
            else
            {
              locala = ad.vZu;
              if (p.j(paramb, ad.dDT().name))
              {
                a.dDv();
                Log.i(TAG, "reportFailedEnterRoom");
              }
              else
              {
                locala = ad.vZu;
                if (p.j(paramb, ad.dDV().name))
                {
                  a.dDw();
                  Log.i(TAG, "reportFailedShareFeed");
                }
                else
                {
                  locala = ad.vZu;
                  if (p.j(paramb, ad.dDP().name))
                  {
                    a.dDx();
                    Log.i(TAG, "reportRecheckRealName");
                  }
                  else
                  {
                    locala = ad.vZu;
                    if (p.j(paramb, ad.dDX().name))
                    {
                      a.dDy();
                      Log.i(TAG, "reportSuccLive");
                    }
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static ArrayList<ecj> dDj()
  {
    return vYm;
  }
  
  public static String dDk()
  {
    return vYn;
  }
  
  public static void dDl()
  {
    AppMethodBeat.i(253748);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 60L);
    AppMethodBeat.o(253748);
  }
  
  public static void dDm()
  {
    AppMethodBeat.i(253749);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 61L);
    AppMethodBeat.o(253749);
  }
  
  public static void dDn()
  {
    AppMethodBeat.i(253750);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 62L);
    AppMethodBeat.o(253750);
  }
  
  public static void dDo()
  {
    AppMethodBeat.i(253751);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 63L);
    AppMethodBeat.o(253751);
  }
  
  public static void dDp()
  {
    AppMethodBeat.i(253752);
    com.tencent.mm.plugin.report.service.h.CyF.F(vYo, 64L);
    AppMethodBeat.o(253752);
  }
  
  public final void dDq()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(253753);
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = (ecj)j.kt((List)vYm);
        if (localObject1 != null)
        {
          l1 = ((ecj)localObject1).Asv;
          localObject1 = (ecj)j.kv((List)vYm);
          if (localObject1 == null) {
            break label477;
          }
          l2 = ((ecj)localObject1).Asv;
          l1 = l2 - l1;
          localObject1 = ((Iterable)vYm).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = ((Iterator)localObject1).next();
            int j = i + 1;
            if (i < 0) {
              j.hxH();
            }
            localObject3 = (ecj)localObject3;
            if (i > 0)
            {
              Object localObject4 = vYm.get(i - 1);
              p.g(localObject4, "flow.get(index - 1)");
              localObject4 = (ecj)localObject4;
              l2 = ((ecj)localObject3).Asv;
              long l3 = ((ecj)localObject4).Asv;
              if (l1 == 0L) {
                break label483;
              }
              f = (float)(l2 - l3) * 100.0F / (float)l1;
              localObject3 = new StringBuilder().append(((ecj)localObject3).wVT).append(':').append(((ecj)localObject3).Asv - ((ecj)localObject4).Asv).append("ms,");
              localObject4 = ae.SYK;
              localObject4 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
              p.g(localObject4, "java.lang.String.format(format, *args)");
              localStringBuilder.append((String)localObject4 + "%\n");
              i = j;
              continue;
            }
            localStringBuilder.append("Total Cost:" + l1 + "ms... start at " + ((ecj)localObject3).Asv + "\n " + ((ecj)localObject3).wVT + '\n');
            i = j;
            continue;
          }
          Object localObject3 = new StringBuilder("end at ");
          localObject1 = (ecj)j.kv((List)vYm);
          if (localObject1 != null)
          {
            localObject1 = Long.valueOf(((ecj)localObject1).Asv);
            localStringBuilder.append(localObject1);
            localObject1 = localStringBuilder.toString();
            p.g(localObject1, "flowData.toString()");
            vYn = (String)localObject1;
            Log.i(TAG, String.valueOf(localStringBuilder));
            AppMethodBeat.o(253753);
            return;
          }
          localObject1 = null;
          continue;
        }
        long l1 = 0L;
      }
      finally {}
      continue;
      label477:
      long l2 = 0L;
      continue;
      label483:
      float f = 0.0F;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveAnchorFlowStats$PercentConversion;", "", "()V", "cancel", "", "failedCreateLive", "failedEnterRoom", "failedJoinLive", "failedReason1", "failedReason2", "failedReason3", "failedReason4", "failedReason5", "failedReason6", "failedShareFeed", "id", "post", "recheckRealName", "succLive", "processTag", "", "tag", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "reportCancel", "reportDetailError", "reportErrorCode", "extra", "Lcom/tencent/mm/protocal/protobuf/LiveFailedTagExtra;", "reportFailedCreateLive", "reportFailedEnterRoom", "reportFailedJoinLive", "reportFailedReason1", "reportFailedReason2", "reportFailedReason3", "reportFailedReason4", "reportFailedReason5", "reportFailedReason6", "reportFailedShareFeed", "reportPost", "reportRecheckRealName", "reportSuccLive", "plugin-finder_release"})
  public static final class a
  {
    private static final long id = 1552L;
    private static final long vYA = 42L;
    private static final long vYB = 43L;
    private static final long vYC = 44L;
    private static final long vYD = 45L;
    public static final a vYE;
    private static final long vYq = 10L;
    private static final long vYr = 11L;
    private static final long vYs = 12L;
    private static final long vYt = 13L;
    private static final long vYu = 14L;
    private static final long vYv = 15L;
    private static final long vYw = 16L;
    private static final long vYx = 17L;
    private static final long vYy = 40L;
    private static final long vYz = 41L;
    
    static
    {
      AppMethodBeat.i(253743);
      vYE = new a();
      id = 1552L;
      vYq = 10L;
      vYr = 11L;
      vYs = 12L;
      vYt = 13L;
      vYu = 14L;
      vYv = 15L;
      vYw = 16L;
      vYx = 17L;
      vYy = 40L;
      vYz = 41L;
      vYA = 42L;
      vYB = 43L;
      vYC = 44L;
      vYD = 45L;
      AppMethodBeat.o(253743);
    }
    
    static void a(ecj paramecj)
    {
      AppMethodBeat.i(253742);
      Object localObject = paramecj.NcA;
      if (localObject != null)
      {
        paramecj = (a)new cit();
        localObject = ((b)localObject).toByteArray();
        try
        {
          paramecj.parseFrom((byte[])localObject);
          paramecj = (cit)paramecj;
          if (paramecj == null) {
            break label253;
          }
          switch (paramecj.errCode)
          {
          default: 
            com.tencent.mm.plugin.report.service.h.CyF.F(id, vYD);
            AppMethodBeat.o(253742);
            return;
          }
        }
        catch (Exception paramecj)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramecj });
            paramecj = null;
          }
          com.tencent.mm.plugin.report.service.h.CyF.F(id, vYy);
          AppMethodBeat.o(253742);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.F(id, vYz);
        AppMethodBeat.o(253742);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.F(id, vYA);
        AppMethodBeat.o(253742);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.F(id, vYB);
        AppMethodBeat.o(253742);
        return;
        com.tencent.mm.plugin.report.service.h.CyF.F(id, vYC);
        AppMethodBeat.o(253742);
        return;
        label253:
        AppMethodBeat.o(253742);
        return;
      }
      AppMethodBeat.o(253742);
    }
    
    public static void dDr()
    {
      AppMethodBeat.i(253734);
      com.tencent.mm.plugin.report.service.h.CyF.F(id, vYq);
      AppMethodBeat.o(253734);
    }
    
    public static void dDs()
    {
      AppMethodBeat.i(253735);
      com.tencent.mm.plugin.report.service.h.CyF.F(id, vYr);
      AppMethodBeat.o(253735);
    }
    
    public static void dDt()
    {
      AppMethodBeat.i(253736);
      com.tencent.mm.plugin.report.service.h.CyF.F(id, vYs);
      AppMethodBeat.o(253736);
    }
    
    public static void dDu()
    {
      AppMethodBeat.i(253737);
      com.tencent.mm.plugin.report.service.h.CyF.F(id, vYt);
      AppMethodBeat.o(253737);
    }
    
    public static void dDv()
    {
      AppMethodBeat.i(253738);
      com.tencent.mm.plugin.report.service.h.CyF.F(id, vYu);
      AppMethodBeat.o(253738);
    }
    
    public static void dDw()
    {
      AppMethodBeat.i(253739);
      com.tencent.mm.plugin.report.service.h.CyF.F(id, vYv);
      AppMethodBeat.o(253739);
    }
    
    public static void dDx()
    {
      AppMethodBeat.i(253740);
      com.tencent.mm.plugin.report.service.h.CyF.F(id, vYw);
      AppMethodBeat.o(253740);
    }
    
    public static void dDy()
    {
      AppMethodBeat.i(253741);
      com.tencent.mm.plugin.report.service.h.CyF.F(id, vYx);
      AppMethodBeat.o(253741);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b vYF;
    
    static
    {
      AppMethodBeat.i(253745);
      vYF = new b();
      AppMethodBeat.o(253745);
    }
    
    public final void run()
    {
      AppMethodBeat.i(253744);
      ac.vYp.dDq();
      ac localac = ac.vYp;
      ac.dDj().clear();
      AppMethodBeat.o(253744);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ac
 * JD-Core Version:    0.7.0.1
 */