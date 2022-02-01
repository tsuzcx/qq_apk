package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.fhi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LiveAnchorFlowStats;", "", "()V", "KEY_ID", "", "TAG", "", "flow", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "Lkotlin/collections/ArrayList;", "getFlow", "()Ljava/util/ArrayList;", "historyLog", "getHistoryLog", "()Ljava/lang/String;", "setHistoryLog", "(Ljava/lang/String;)V", "end", "", "delay", "", "logStage", "reportLinkAcceptCloseFail", "reportLinkAcceptCloseSuc", "reportLinkAcceptSdkSuc", "reportLinkAcceptSvrFail", "reportLinkAcceptSvrSuc", "tag", "stage", "extra", "Lcom/tencent/mm/protobuf/ByteString;", "isStart", "", "isEnd", "PercentConversion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
{
  public static final ba Gjt;
  private static final ArrayList<fhi> Gju;
  private static String Gjv;
  private static final long Gjw;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333189);
    Gjt = new ba();
    TAG = "Finder.LiveAnchorFlowStats";
    Gju = new ArrayList();
    Gjv = "";
    Gjw = 1552L;
    AppMethodBeat.o(333189);
  }
  
  private void b(String paramString, b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject;
      bb.a locala;
      try
      {
        AppMethodBeat.i(333128);
        s.u(paramString, "stage");
        if (paramBoolean1)
        {
          Gju.clear();
          localObject = new fhi();
          ((fhi)localObject).id = "";
          ((fhi)localObject).Hsw = paramString;
          ((fhi)localObject).GvM = cn.bDu();
          if (!paramBoolean1) {
            break label328;
          }
          locala = bb.GjM;
          i = bb.fha();
          ((fhi)localObject).type = i;
          ((fhi)localObject).abHV = paramb;
          paramb = a.Gjx;
          s.u(localObject, "tag");
          paramb = ((fhi)localObject).Hsw;
          locala = bb.GjM;
          if (!s.p(paramb, bb.fhs().name)) {
            break label346;
          }
          a.fgS();
          Log.i(TAG, "reportPost");
          Gju.add(localObject);
          Log.i(TAG, "tag, stage:" + paramString + ", isStart:" + paramBoolean1 + ", isEnd:" + paramBoolean2);
          if (paramBoolean2) {
            com.tencent.threadpool.h.ahAA.p(ba..ExternalSyntheticLambda0.INSTANCE, 0L);
          }
          AppMethodBeat.o(333128);
          return;
        }
        if (!Gju.isEmpty())
        {
          localObject = (fhi)p.oL((List)Gju);
          if (localObject == null) {
            break label316;
          }
          i = ((fhi)localObject).type;
          localObject = bb.GjM;
          if (i != bb.fha()) {
            break label316;
          }
          i = 1;
          if (i != 0)
          {
            localObject = (fhi)p.oN((List)Gju);
            if (localObject == null) {
              break label322;
            }
            i = ((fhi)localObject).type;
            localObject = bb.GjM;
            if (i != bb.fhb()) {
              break label322;
            }
            i = 1;
            break label585;
          }
        }
        AppMethodBeat.o(333128);
        continue;
        i = 0;
      }
      finally {}
      label316:
      continue;
      label322:
      int i = 0;
      label328:
      if (paramBoolean2)
      {
        locala = bb.GjM;
        i = bb.fhb();
        continue;
        label346:
        locala = bb.GjM;
        if (s.p(paramb, bb.fhC().name))
        {
          a.fgT();
          Log.i(TAG, "reportCancel");
        }
        else
        {
          locala = bb.GjM;
          if (s.p(paramb, bb.fhu().name))
          {
            a.fgU();
            a.a((fhi)localObject);
            Log.i(TAG, "reportFailedCreateLive");
          }
          else
          {
            locala = bb.GjM;
            if (s.p(paramb, bb.fhx().name))
            {
              a.fgV();
              a.a((fhi)localObject);
              Log.i(TAG, "reportFailedJoinLive");
            }
            else
            {
              locala = bb.GjM;
              if (s.p(paramb, bb.fhz().name))
              {
                a.fgW();
                Log.i(TAG, "reportFailedEnterRoom");
              }
              else
              {
                locala = bb.GjM;
                if (s.p(paramb, bb.fhB().name))
                {
                  a.fgX();
                  Log.i(TAG, "reportFailedShareFeed");
                }
                else
                {
                  locala = bb.GjM;
                  if (s.p(paramb, bb.fhv().name))
                  {
                    a.fgY();
                    Log.i(TAG, "reportRecheckRealName");
                  }
                  else
                  {
                    locala = bb.GjM;
                    if (s.p(paramb, bb.fhD().name))
                    {
                      a.fgZ();
                      Log.i(TAG, "reportSuccLive");
                      continue;
                      label585:
                      if (i != 0) {}
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
  
  public static String fgK()
  {
    return Gjv;
  }
  
  public static void fgL()
  {
    AppMethodBeat.i(333140);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 60L, 1L);
    AppMethodBeat.o(333140);
  }
  
  public static void fgM()
  {
    AppMethodBeat.i(333143);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 61L, 1L);
    AppMethodBeat.o(333143);
  }
  
  public static void fgN()
  {
    AppMethodBeat.i(333150);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 62L, 1L);
    AppMethodBeat.o(333150);
  }
  
  public static void fgO()
  {
    AppMethodBeat.i(333155);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 63L, 1L);
    AppMethodBeat.o(333155);
  }
  
  public static void fgP()
  {
    AppMethodBeat.i(333163);
    com.tencent.mm.plugin.report.service.h.OAn.p(Gjw, 64L, 1L);
    AppMethodBeat.o(333163);
  }
  
  private void fgQ()
  {
    int i = 0;
    label473:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(333175);
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = (fhi)p.oL((List)Gju);
        Object localObject3;
        int j;
        if (localObject1 == null)
        {
          l1 = 0L;
          localObject1 = (fhi)p.oN((List)Gju);
          if (localObject1 == null)
          {
            l2 = 0L;
            l1 = l2 - l1;
            localObject1 = ((Iterable)Gju).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject3 = ((Iterator)localObject1).next();
            j = i + 1;
            if (i < 0) {
              p.kkW();
            }
            localObject3 = (fhi)localObject3;
            if (i <= 0) {
              continue;
            }
            Object localObject4 = Gju.get(i - 1);
            s.s(localObject4, "flow.get(index - 1)");
            localObject4 = (fhi)localObject4;
            l2 = ((fhi)localObject3).GvM;
            long l3 = ((fhi)localObject4).GvM;
            if (l1 == 0L) {
              break label473;
            }
            f = (float)(l2 - l3) * 100.0F / (float)l1;
            localObject3 = new StringBuilder().append(((fhi)localObject3).Hsw).append(':').append(((fhi)localObject3).GvM - ((fhi)localObject4).GvM).append("ms,");
            localObject4 = am.aixg;
            localObject4 = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(f) }, 1));
            s.s(localObject4, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject4 + "%\n");
            i = j;
            continue;
          }
        }
        else
        {
          l1 = ((fhi)localObject1).GvM;
          continue;
        }
        long l2 = ((fhi)localObject1).GvM;
        continue;
        localStringBuilder.append("Total Cost:" + l1 + "ms... start at " + ((fhi)localObject3).GvM + "\n " + ((fhi)localObject3).Hsw + '\n');
        i = j;
        continue;
        localObject1 = (fhi)p.oN((List)Gju);
        if (localObject1 == null)
        {
          localObject1 = null;
          localStringBuilder.append(s.X("end at ", localObject1));
          localObject1 = localStringBuilder.toString();
          s.s(localObject1, "flowData.toString()");
          Gjv = (String)localObject1;
          Log.i(TAG, String.valueOf(localStringBuilder));
          AppMethodBeat.o(333175);
          return;
        }
        long l1 = ((fhi)localObject1).GvM;
        localObject1 = Long.valueOf(l1);
        continue;
        float f = 0.0F;
      }
      finally {}
    }
  }
  
  private static final void fgR()
  {
    AppMethodBeat.i(333180);
    Gjt.fgQ();
    Gju.clear();
    AppMethodBeat.o(333180);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LiveAnchorFlowStats$PercentConversion;", "", "()V", "cancel", "", "failedCreateLive", "failedEnterRoom", "failedJoinLive", "failedReason1", "failedReason2", "failedReason3", "failedReason4", "failedReason5", "failedReason6", "failedShareFeed", "id", "post", "recheckRealName", "succLive", "processTag", "", "tag", "Lcom/tencent/mm/protocal/protobuf/StatFlowTag;", "reportCancel", "reportDetailError", "reportErrorCode", "extra", "Lcom/tencent/mm/protocal/protobuf/LiveFailedTagExtra;", "reportFailedCreateLive", "reportFailedEnterRoom", "reportFailedJoinLive", "reportFailedReason1", "reportFailedReason2", "reportFailedReason3", "reportFailedReason4", "reportFailedReason5", "reportFailedReason6", "reportFailedShareFeed", "reportPost", "reportRecheckRealName", "reportSuccLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final long GjA;
    private static final long GjB;
    private static final long GjC;
    private static final long GjD;
    private static final long GjE;
    private static final long GjF;
    private static final long GjG;
    private static final long GjH;
    private static final long GjI;
    private static final long GjJ;
    private static final long GjK;
    private static final long GjL;
    public static final a Gjx;
    private static final long Gjy;
    private static final long Gjz;
    private static final long id;
    
    static
    {
      AppMethodBeat.i(333390);
      Gjx = new a();
      id = 1552L;
      Gjy = 10L;
      Gjz = 11L;
      GjA = 12L;
      GjB = 13L;
      GjC = 14L;
      GjD = 15L;
      GjE = 16L;
      GjF = 17L;
      GjG = 40L;
      GjH = 41L;
      GjI = 42L;
      GjJ = 43L;
      GjK = 44L;
      GjL = 45L;
      AppMethodBeat.o(333390);
    }
    
    static void a(fhi paramfhi)
    {
      AppMethodBeat.i(333381);
      Object localObject = paramfhi.abHV;
      if (localObject != null)
      {
        paramfhi = (a)new dim();
        localObject = ((b)localObject).toByteArray();
      }
      try
      {
        paramfhi.parseFrom((byte[])localObject);
        paramfhi = (dim)paramfhi;
        if (paramfhi != null) {}
        switch (paramfhi.errCode)
        {
        default: 
          com.tencent.mm.plugin.report.service.h.OAn.p(id, GjL, 1L);
          AppMethodBeat.o(333381);
          return;
        }
      }
      catch (Exception paramfhi)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramfhi });
          paramfhi = null;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(id, GjG, 1L);
        AppMethodBeat.o(333381);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjH, 1L);
      AppMethodBeat.o(333381);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjI, 1L);
      AppMethodBeat.o(333381);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjJ, 1L);
      AppMethodBeat.o(333381);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjK, 1L);
      AppMethodBeat.o(333381);
    }
    
    public static void fgS()
    {
      AppMethodBeat.i(333328);
      com.tencent.mm.plugin.report.service.h.OAn.p(id, Gjy, 1L);
      AppMethodBeat.o(333328);
    }
    
    public static void fgT()
    {
      AppMethodBeat.i(333335);
      com.tencent.mm.plugin.report.service.h.OAn.p(id, Gjz, 1L);
      AppMethodBeat.o(333335);
    }
    
    public static void fgU()
    {
      AppMethodBeat.i(333339);
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjA, 1L);
      AppMethodBeat.o(333339);
    }
    
    public static void fgV()
    {
      AppMethodBeat.i(333345);
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjB, 1L);
      AppMethodBeat.o(333345);
    }
    
    public static void fgW()
    {
      AppMethodBeat.i(333352);
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjC, 1L);
      AppMethodBeat.o(333352);
    }
    
    public static void fgX()
    {
      AppMethodBeat.i(333360);
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjD, 1L);
      AppMethodBeat.o(333360);
    }
    
    public static void fgY()
    {
      AppMethodBeat.i(333368);
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjE, 1L);
      AppMethodBeat.o(333368);
    }
    
    public static void fgZ()
    {
      AppMethodBeat.i(333373);
      com.tencent.mm.plugin.report.service.h.OAn.p(id, GjF, 1L);
      AppMethodBeat.o(333373);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ba
 * JD-Core Version:    0.7.0.1
 */