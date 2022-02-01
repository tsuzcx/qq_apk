package com.tencent.mm.plugin.finder.utils;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.protocal.protobuf.emk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveAnchorFlowStats;", "", "()V", "KEY_ID", "", "TAG", "", "flow", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "Lkotlin/collections/ArrayList;", "getFlow", "()Ljava/util/ArrayList;", "historyLog", "getHistoryLog", "()Ljava/lang/String;", "setHistoryLog", "(Ljava/lang/String;)V", "end", "", "delay", "", "logStage", "reportLinkAcceptCloseFail", "reportLinkAcceptCloseSuc", "reportLinkAcceptSdkSuc", "reportLinkAcceptSvrFail", "reportLinkAcceptSvrSuc", "tag", "stage", "extra", "Lcom/tencent/mm/protobuf/ByteString;", "isStart", "", "isEnd", "PercentConversion", "plugin-finder_release"})
public final class ao
{
  private static final ArrayList<emk> AGU;
  private static String AGV;
  private static final long AGW = 1552L;
  public static final ao AGX;
  private static final String TAG = "Finder.LiveAnchorFlowStats";
  
  static
  {
    AppMethodBeat.i(223420);
    AGX = new ao();
    TAG = "Finder.LiveAnchorFlowStats";
    AGU = new ArrayList();
    AGV = "";
    AGW = 1552L;
    AppMethodBeat.o(223420);
  }
  
  private void b(String paramString, b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject;
      ap.a locala;
      int i;
      try
      {
        AppMethodBeat.i(223403);
        p.k(paramString, "stage");
        if (paramBoolean1)
        {
          AGU.clear();
          localObject = new emk();
          ((emk)localObject).id = "";
          ((emk)localObject).BHO = paramString;
          ((emk)localObject).GhA = cm.bfC();
          if (!paramBoolean1) {
            break label321;
          }
          locala = ap.AIh;
          i = ap.efd();
          ((emk)localObject).type = i;
          ((emk)localObject).UoX = paramb;
          paramb = a.AHm;
          p.k(localObject, "tag");
          paramb = ((emk)localObject).BHO;
          locala = ap.AIh;
          if (!p.h(paramb, ap.efv().name)) {
            break label339;
          }
          a.eeV();
          Log.i(TAG, "reportPost");
          AGU.add(localObject);
          Log.i(TAG, "tag, stage:" + paramString + ", isStart:" + paramBoolean1 + ", isEnd:" + paramBoolean2);
          if (paramBoolean2) {
            com.tencent.e.h.ZvG.o((Runnable)b.AHn, 0L);
          }
          AppMethodBeat.o(223403);
          return;
        }
        if (AGU.isEmpty()) {
          break label313;
        }
        localObject = (emk)j.lp((List)AGU);
        if (localObject != null)
        {
          i = ((emk)localObject).type;
          localObject = ap.AIh;
          if (i != ap.efd()) {
            break label313;
          }
          localObject = (emk)j.lr((List)AGU);
          if (localObject == null) {
            continue;
          }
          i = ((emk)localObject).type;
          localObject = ap.AIh;
          if (i != ap.efe()) {
            continue;
          }
          AppMethodBeat.o(223403);
          continue;
        }
        AppMethodBeat.o(223403);
      }
      finally {}
      continue;
      label313:
      AppMethodBeat.o(223403);
      continue;
      label321:
      if (paramBoolean2)
      {
        locala = ap.AIh;
        i = ap.efe();
        continue;
        label339:
        locala = ap.AIh;
        if (p.h(paramb, ap.efF().name))
        {
          a.eeW();
          Log.i(TAG, "reportCancel");
        }
        else
        {
          locala = ap.AIh;
          if (p.h(paramb, ap.efx().name))
          {
            a.eeX();
            a.a((emk)localObject);
            Log.i(TAG, "reportFailedCreateLive");
          }
          else
          {
            locala = ap.AIh;
            if (p.h(paramb, ap.efA().name))
            {
              a.eeY();
              a.a((emk)localObject);
              Log.i(TAG, "reportFailedJoinLive");
            }
            else
            {
              locala = ap.AIh;
              if (p.h(paramb, ap.efC().name))
              {
                a.eeZ();
                Log.i(TAG, "reportFailedEnterRoom");
              }
              else
              {
                locala = ap.AIh;
                if (p.h(paramb, ap.efE().name))
                {
                  a.efa();
                  Log.i(TAG, "reportFailedShareFeed");
                }
                else
                {
                  locala = ap.AIh;
                  if (p.h(paramb, ap.efy().name))
                  {
                    a.efb();
                    Log.i(TAG, "reportRecheckRealName");
                  }
                  else
                  {
                    locala = ap.AIh;
                    if (p.h(paramb, ap.efG().name))
                    {
                      a.efc();
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
  
  public static ArrayList<emk> eeN()
  {
    return AGU;
  }
  
  public static String eeO()
  {
    return AGV;
  }
  
  public static void eeP()
  {
    AppMethodBeat.i(223409);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 60L);
    AppMethodBeat.o(223409);
  }
  
  public static void eeQ()
  {
    AppMethodBeat.i(223412);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 61L);
    AppMethodBeat.o(223412);
  }
  
  public static void eeR()
  {
    AppMethodBeat.i(223414);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 62L);
    AppMethodBeat.o(223414);
  }
  
  public static void eeS()
  {
    AppMethodBeat.i(223415);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 63L);
    AppMethodBeat.o(223415);
  }
  
  public static void eeT()
  {
    AppMethodBeat.i(223416);
    com.tencent.mm.plugin.report.service.h.IzE.F(AGW, 64L);
    AppMethodBeat.o(223416);
  }
  
  public final void eeU()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(223418);
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = (emk)j.lp((List)AGU);
        if (localObject1 != null)
        {
          l1 = ((emk)localObject1).GhA;
          localObject1 = (emk)j.lr((List)AGU);
          if (localObject1 == null) {
            break label477;
          }
          l2 = ((emk)localObject1).GhA;
          l1 = l2 - l1;
          localObject1 = ((Iterable)AGU).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = ((Iterator)localObject1).next();
            int j = i + 1;
            if (i < 0) {
              j.iBO();
            }
            localObject3 = (emk)localObject3;
            if (i > 0)
            {
              Object localObject4 = AGU.get(i - 1);
              p.j(localObject4, "flow.get(index - 1)");
              localObject4 = (emk)localObject4;
              l2 = ((emk)localObject3).GhA;
              long l3 = ((emk)localObject4).GhA;
              if (l1 == 0L) {
                break label483;
              }
              f = (float)(l2 - l3) * 100.0F / (float)l1;
              localObject3 = new StringBuilder().append(((emk)localObject3).BHO).append(':').append(((emk)localObject3).GhA - ((emk)localObject4).GhA).append("ms,");
              localObject4 = af.aaBG;
              localObject4 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
              p.j(localObject4, "java.lang.String.format(format, *args)");
              localStringBuilder.append((String)localObject4 + "%\n");
              i = j;
              continue;
            }
            localStringBuilder.append("Total Cost:" + l1 + "ms... start at " + ((emk)localObject3).GhA + "\n " + ((emk)localObject3).BHO + '\n');
            i = j;
            continue;
          }
          Object localObject3 = new StringBuilder("end at ");
          localObject1 = (emk)j.lr((List)AGU);
          if (localObject1 != null)
          {
            localObject1 = Long.valueOf(((emk)localObject1).GhA);
            localStringBuilder.append(localObject1);
            localObject1 = localStringBuilder.toString();
            p.j(localObject1, "flowData.toString()");
            AGV = (String)localObject1;
            Log.i(TAG, String.valueOf(localStringBuilder));
            AppMethodBeat.o(223418);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveAnchorFlowStats$PercentConversion;", "", "()V", "cancel", "", "failedCreateLive", "failedEnterRoom", "failedJoinLive", "failedReason1", "failedReason2", "failedReason3", "failedReason4", "failedReason5", "failedReason6", "failedShareFeed", "id", "post", "recheckRealName", "succLive", "processTag", "", "tag", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "reportCancel", "reportDetailError", "reportErrorCode", "extra", "Lcom/tencent/mm/protocal/protobuf/LiveFailedTagExtra;", "reportFailedCreateLive", "reportFailedEnterRoom", "reportFailedJoinLive", "reportFailedReason1", "reportFailedReason2", "reportFailedReason3", "reportFailedReason4", "reportFailedReason5", "reportFailedReason6", "reportFailedShareFeed", "reportPost", "reportRecheckRealName", "reportSuccLive", "plugin-finder_release"})
  public static final class a
  {
    private static final long AGY = 10L;
    private static final long AGZ = 11L;
    private static final long AHa = 12L;
    private static final long AHb = 13L;
    private static final long AHc = 14L;
    private static final long AHd = 15L;
    private static final long AHe = 16L;
    private static final long AHf = 17L;
    private static final long AHg = 40L;
    private static final long AHh = 41L;
    private static final long AHi = 42L;
    private static final long AHj = 43L;
    private static final long AHk = 44L;
    private static final long AHl = 45L;
    public static final a AHm;
    private static final long id = 1552L;
    
    static
    {
      AppMethodBeat.i(288813);
      AHm = new a();
      id = 1552L;
      AGY = 10L;
      AGZ = 11L;
      AHa = 12L;
      AHb = 13L;
      AHc = 14L;
      AHd = 15L;
      AHe = 16L;
      AHf = 17L;
      AHg = 40L;
      AHh = 41L;
      AHi = 42L;
      AHj = 43L;
      AHk = 44L;
      AHl = 45L;
      AppMethodBeat.o(288813);
    }
    
    static void a(emk paramemk)
    {
      AppMethodBeat.i(288811);
      Object localObject = paramemk.UoX;
      if (localObject != null)
      {
        paramemk = (a)new cro();
        localObject = ((b)localObject).toByteArray();
        try
        {
          paramemk.parseFrom((byte[])localObject);
          paramemk = (cro)paramemk;
          if (paramemk == null) {
            break label253;
          }
          switch (paramemk.errCode)
          {
          default: 
            com.tencent.mm.plugin.report.service.h.IzE.F(id, AHl);
            AppMethodBeat.o(288811);
            return;
          }
        }
        catch (Exception paramemk)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramemk });
            paramemk = null;
          }
          com.tencent.mm.plugin.report.service.h.IzE.F(id, AHg);
          AppMethodBeat.o(288811);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.F(id, AHh);
        AppMethodBeat.o(288811);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.F(id, AHi);
        AppMethodBeat.o(288811);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.F(id, AHj);
        AppMethodBeat.o(288811);
        return;
        com.tencent.mm.plugin.report.service.h.IzE.F(id, AHk);
        AppMethodBeat.o(288811);
        return;
        label253:
        AppMethodBeat.o(288811);
        return;
      }
      AppMethodBeat.o(288811);
    }
    
    public static void eeV()
    {
      AppMethodBeat.i(288803);
      com.tencent.mm.plugin.report.service.h.IzE.F(id, AGY);
      AppMethodBeat.o(288803);
    }
    
    public static void eeW()
    {
      AppMethodBeat.i(288804);
      com.tencent.mm.plugin.report.service.h.IzE.F(id, AGZ);
      AppMethodBeat.o(288804);
    }
    
    public static void eeX()
    {
      AppMethodBeat.i(288805);
      com.tencent.mm.plugin.report.service.h.IzE.F(id, AHa);
      AppMethodBeat.o(288805);
    }
    
    public static void eeY()
    {
      AppMethodBeat.i(288806);
      com.tencent.mm.plugin.report.service.h.IzE.F(id, AHb);
      AppMethodBeat.o(288806);
    }
    
    public static void eeZ()
    {
      AppMethodBeat.i(288807);
      com.tencent.mm.plugin.report.service.h.IzE.F(id, AHc);
      AppMethodBeat.o(288807);
    }
    
    public static void efa()
    {
      AppMethodBeat.i(288808);
      com.tencent.mm.plugin.report.service.h.IzE.F(id, AHd);
      AppMethodBeat.o(288808);
    }
    
    public static void efb()
    {
      AppMethodBeat.i(288809);
      com.tencent.mm.plugin.report.service.h.IzE.F(id, AHe);
      AppMethodBeat.o(288809);
    }
    
    public static void efc()
    {
      AppMethodBeat.i(288810);
      com.tencent.mm.plugin.report.service.h.IzE.F(id, AHf);
      AppMethodBeat.o(288810);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b AHn;
    
    static
    {
      AppMethodBeat.i(269818);
      AHn = new b();
      AppMethodBeat.o(269818);
    }
    
    public final void run()
    {
      AppMethodBeat.i(269817);
      ao.AGX.eeU();
      ao localao = ao.AGX;
      ao.eeN().clear();
      AppMethodBeat.o(269817);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ao
 * JD-Core Version:    0.7.0.1
 */