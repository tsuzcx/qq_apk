package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.enc;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.fmu;
import com.tencent.mm.protocal.protobuf.fmv;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine$onConfigClient$1", "Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizTLRecCardJsEngine$c
  implements com.tencent.mm.plugin.brandservice.ui.c.b
{
  BizTLRecCardJsEngine$c(BizTLRecCardJsEngine paramBizTLRecCardJsEngine, String paramString1, String paramString2) {}
  
  private static final int a(BizTLRecCardJsEngine paramBizTLRecCardJsEngine, String paramString1, int paramInt1, int paramInt2, String paramString2, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(302571);
    s.u(paramBizTLRecCardJsEngine, "this$0");
    s.u(paramString1, "$callback");
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e(BizTLRecCardJsEngine.access$getTAG$cp(), "adRequest callback errType=" + paramInt1 + ", errCode=" + paramInt2);
      paramBizTLRecCardJsEngine = (com.tencent.mm.plugin.ax.c)paramBizTLRecCardJsEngine;
      paramString2 = new JSONObject();
      paramString2.put("err_code", paramInt2);
      paramString2.put("err_msg", "fail");
      paramc = ah.aiuX;
      paramString2 = paramString2.toString();
      s.s(paramString2, "JSONObject().apply {\n   …             }.toString()");
      com.tencent.mm.plugin.ax.c.a.a(paramBizTLRecCardJsEngine, paramString1, paramString2, null, 4);
      AppMethodBeat.o(302571);
      return 0;
    }
    paramString2 = c.c.b(paramc.otC);
    if ((paramString2 instanceof fmv)) {}
    for (paramString2 = (fmv)paramString2; paramString2 == null; paramString2 = null)
    {
      Log.e(BizTLRecCardJsEngine.access$getTAG$cp(), "adRequest resp is null");
      AppMethodBeat.o(302571);
      return 0;
    }
    Log.d(BizTLRecCardJsEngine.access$getTAG$cp(), s.X("adRequest resp data: ", paramString2.YVP));
    paramc = (com.tencent.mm.plugin.ax.c)paramBizTLRecCardJsEngine;
    paramp = new JSONObject();
    paramp.put("err_msg", "ok");
    paramString2 = paramString2.YVP;
    paramBizTLRecCardJsEngine = paramString2;
    if (paramString2 == null) {
      paramBizTLRecCardJsEngine = "";
    }
    paramp.put("data", paramBizTLRecCardJsEngine);
    paramBizTLRecCardJsEngine = ah.aiuX;
    paramBizTLRecCardJsEngine = paramp.toString();
    s.s(paramBizTLRecCardJsEngine, "JSONObject().apply {\n   …             }.toString()");
    com.tencent.mm.plugin.ax.c.a.a(paramc, paramString1, paramBizTLRecCardJsEngine, null, 4);
    AppMethodBeat.o(302571);
    return 0;
  }
  
  private static final void a(BizTLRecCardJsEngine paramBizTLRecCardJsEngine, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(302588);
    s.u(paramBizTLRecCardJsEngine, "this$0");
    s.u(paramString, "$fieldId");
    Object localObject;
    if (paramBizTLRecCardJsEngine.vKW.containsValue(paramString))
    {
      paramBizTLRecCardJsEngine = paramBizTLRecCardJsEngine.context.get();
      ab localab;
      if ((paramBizTLRecCardJsEngine instanceof BizTimeLineUI))
      {
        localObject = (BizTimeLineUI)paramBizTLRecCardJsEngine;
        if ((localObject != null) && (((BizTimeLineUI)localObject).vHY != null))
        {
          paramBizTLRecCardJsEngine = ((BizTimeLineUI)localObject).vHY;
          s.u(paramString, "id");
          paramBizTLRecCardJsEngine = ((Iterable)paramBizTLRecCardJsEngine.vFH).iterator();
          for (;;)
          {
            if (paramBizTLRecCardJsEngine.hasNext())
            {
              localab = (ab)paramBizTLRecCardJsEngine.next();
              if (s.p(localab.getId(), paramString))
              {
                paramBizTLRecCardJsEngine = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
                com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(localab, "", a.a.vNU);
                if ((paramInt >= 0) && (localab.acFJ.abrC.size() > paramInt))
                {
                  paramBizTLRecCardJsEngine = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
                  paramBizTLRecCardJsEngine = (enp)localab.acFJ.abrC.get(paramInt);
                  if (paramBizTLRecCardJsEngine == null)
                  {
                    paramBizTLRecCardJsEngine = null;
                    label178:
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ajc(paramBizTLRecCardJsEngine);
                    paramBizTLRecCardJsEngine = localab;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (paramBizTLRecCardJsEngine != null) {
          ((BizTimeLineUI)localObject).vFK.c(paramBizTLRecCardJsEngine, Math.max(0, paramInt));
        }
        AppMethodBeat.o(302588);
        return;
        localObject = null;
        break;
        paramBizTLRecCardJsEngine = paramBizTLRecCardJsEngine.abse;
        if (paramBizTLRecCardJsEngine == null)
        {
          paramBizTLRecCardJsEngine = null;
          break label178;
        }
        paramBizTLRecCardJsEngine = paramBizTLRecCardJsEngine.YQK;
        break label178;
        paramBizTLRecCardJsEngine = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ajc(localab.acFJ.Zxq);
        paramBizTLRecCardJsEngine = localab;
        continue;
        paramBizTLRecCardJsEngine = null;
      }
    }
    paramString = af.bHl().aq(paramLong, "msgId");
    long l;
    if ((paramString != null) && (paramString.iYf()))
    {
      paramBizTLRecCardJsEngine = paramBizTLRecCardJsEngine.context.get();
      if (!(paramBizTLRecCardJsEngine instanceof BizTimeLineUI)) {
        break label447;
      }
      paramBizTLRecCardJsEngine = (BizTimeLineUI)paramBizTLRecCardJsEngine;
      if (paramBizTLRecCardJsEngine != null) {
        paramBizTLRecCardJsEngine.vFK.c(paramString, 0);
      }
      paramBizTLRecCardJsEngine = paramString.iYp();
      if ((paramBizTLRecCardJsEngine != null) && (paramBizTLRecCardJsEngine.style == 1001) && (paramBizTLRecCardJsEngine.abLO != null))
      {
        paramString = com.tencent.mm.plugin.report.service.h.OAn;
        paramLong = MMSlotKt.now();
        localObject = paramBizTLRecCardJsEngine.abLO.cardId;
        l = paramBizTLRecCardJsEngine.abry;
        paramInt = paramBizTLRecCardJsEngine.style;
        paramBizTLRecCardJsEngine = paramBizTLRecCardJsEngine.abLM;
        if (paramBizTLRecCardJsEngine != null) {
          break label452;
        }
      }
    }
    label447:
    label452:
    for (paramBizTLRecCardJsEngine = null;; paramBizTLRecCardJsEngine = paramBizTLRecCardJsEngine.YSJ)
    {
      paramString.b(21064, new Object[] { Long.valueOf(paramLong), localObject, Long.valueOf(l), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(paramInt), paramBizTLRecCardJsEngine });
      AppMethodBeat.o(302588);
      return;
      paramBizTLRecCardJsEngine = null;
      break;
    }
  }
  
  private static final int b(BizTLRecCardJsEngine paramBizTLRecCardJsEngine, String paramString1, int paramInt1, int paramInt2, String paramString2, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(302576);
    s.u(paramBizTLRecCardJsEngine, "this$0");
    s.u(paramString1, "$callback");
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramBizTLRecCardJsEngine = (com.tencent.mm.plugin.ax.c)paramBizTLRecCardJsEngine;
      paramString2 = new JSONObject();
      paramString2.put("err_code", paramInt2);
      paramString2.put("err_msg", "fail");
      paramc = ah.aiuX;
      paramString2 = paramString2.toString();
      s.s(paramString2, "JSONObject().apply {\n   …             }.toString()");
      com.tencent.mm.plugin.ax.c.a.a(paramBizTLRecCardJsEngine, paramString1, paramString2, null, 4);
      AppMethodBeat.o(302576);
      return 0;
    }
    paramString2 = c.c.b(paramc.otC);
    if ((paramString2 instanceof qw)) {}
    for (paramString2 = (qw)paramString2;; paramString2 = null)
    {
      if (paramString2 != null)
      {
        Log.i(BizTLRecCardJsEngine.access$getTAG$cp(), s.X("canvasRequest resp_json=", paramString2.YVP));
        paramBizTLRecCardJsEngine = (com.tencent.mm.plugin.ax.c)paramBizTLRecCardJsEngine;
        paramString2 = paramString2.YVP;
        s.s(paramString2, "resp.Data");
        com.tencent.mm.plugin.ax.c.a.a(paramBizTLRecCardJsEngine, paramString1, paramString2, null, 4);
      }
      AppMethodBeat.o(302576);
      return 0;
    }
  }
  
  public final void adRequest(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(302622);
    s.u(paramString1, "message");
    s.u(paramString2, "subType");
    s.u(paramString3, "callback");
    Log.d(BizTLRecCardJsEngine.access$getTAG$cp(), "adRequest %s", new Object[] { paramString1 });
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    fmu localfmu = new fmu();
    localfmu.YVO = 3;
    localfmu.YVP = paramString1;
    localfmu.abMX = paramString2;
    localfmu.YVJ = System.currentTimeMillis();
    paramString1 = ah.aiuX;
    locala.otE = ((com.tencent.mm.bx.a)localfmu);
    locala.otF = ((com.tencent.mm.bx.a)new fmv());
    locala.uri = "/cgi-bin/mmbiz-bin/recommend/timelinecard";
    locala.funcId = 2781;
    locala.otG = 0;
    locala.respCmdId = 0;
    com.tencent.mm.am.z.a(locala.bEF(), new BizTLRecCardJsEngine.c..ExternalSyntheticLambda1(this.vLd, paramString3));
    AppMethodBeat.o(302622);
  }
  
  public final void canvasRequest(Number paramNumber, String paramString1, String paramString2)
  {
    AppMethodBeat.i(302627);
    s.u(paramNumber, "businessId");
    s.u(paramString1, "reqJson");
    s.u(paramString2, "callback");
    Log.d(BizTLRecCardJsEngine.access$getTAG$cp(), "canvasRequest %s", new Object[] { paramString1 });
    Object localObject1 = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject1).otE = ((com.tencent.mm.bx.a)new qv());
    ((com.tencent.mm.am.c.a)localObject1).otF = ((com.tencent.mm.bx.a)new qw());
    ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendtimelinecard";
    ((com.tencent.mm.am.c.a)localObject1).funcId = 1085;
    localObject1 = ((com.tencent.mm.am.c.a)localObject1).bEF();
    Object localObject2 = c.b.b(((com.tencent.mm.am.c)localObject1).otB);
    if (localObject2 == null)
    {
      paramNumber = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendTimeLineCardReq");
      AppMethodBeat.o(302627);
      throw paramNumber;
    }
    localObject2 = (qv)localObject2;
    ((qv)localObject2).YVO = paramNumber.intValue();
    ((qv)localObject2).YVP = paramString1;
    ((qv)localObject2).YVJ = System.currentTimeMillis();
    com.tencent.mm.am.z.a((com.tencent.mm.am.c)localObject1, new BizTLRecCardJsEngine.c..ExternalSyntheticLambda0(this.vLd, paramString2));
    AppMethodBeat.o(302627);
  }
  
  public final void deleteCanvasCard(final String paramString)
  {
    AppMethodBeat.i(302615);
    s.u(paramString, "fieldId");
    Log.i(BizTLRecCardJsEngine.access$getTAG$cp(), s.X("deleteCanvasCard ", paramString));
    Object localObject = com.tencent.mm.plugin.biz.b.c.vtp;
    if (com.tencent.mm.plugin.biz.b.c.daD())
    {
      localObject = com.tencent.mm.plugin.biz.b.c.vtp;
      if (com.tencent.mm.plugin.biz.b.c.atj().decodeBool("forbidDeleteCanvasFromJS", false))
      {
        Log.i(BizTLRecCardJsEngine.access$getTAG$cp(), s.X("forbidDeleteCanvasFromJS ", paramString));
        AppMethodBeat.o(302615);
        return;
      }
    }
    if (this.vLd.vKW.containsValue(paramString))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.vLd, paramString));
      localObject = (Long)this.vLd.vKV.get(this.vAA);
      if (localObject != null) {
        break label237;
      }
    }
    label237:
    for (localObject = null;; localObject = String.valueOf(localObject))
    {
      if (Util.isEqual(paramString, (String)localObject))
      {
        this.vLd.ddN().b("destroy", "{target:'" + this.vAA + "'}", null);
        this.vLd.b("destroy", "{target:'" + this.vAA + "'}", null);
      }
      AppMethodBeat.o(302615);
      return;
      af.bHl().yQ(Util.getLong(paramString, -1L));
      break;
    }
  }
  
  public final String getData()
  {
    return this.tHd;
  }
  
  public final Object getInfo(String paramString)
  {
    AppMethodBeat.i(302605);
    s.u(paramString, "key");
    Object localObject;
    switch (paramString.hashCode())
    {
    default: 
    case -192219127: 
    case 1043830850: 
    case 104191100: 
    case 607796817: 
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(302605);
              return null;
            } while (!paramString.equals("recFeedId"));
            localObject = (String)this.vLd.vKW.get(this.vAA);
            paramString = (String)localObject;
            if (localObject == null) {
              paramString = Integer.valueOf(0);
            }
            paramString = String.valueOf(paramString);
            localObject = this.vAA;
            Log.d(BizTLRecCardJsEngine.access$getTAG$cp(), "getInfo canvasId=" + (String)localObject + ", recFeedId=" + paramString);
            AppMethodBeat.o(302605);
            return paramString;
          } while (!paramString.equals("videoChannelIconSize"));
          float f = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.c.fQ(MMApplicationContext.getContext()) / com.tencent.mm.plugin.appbrand.af.i.mn();
          AppMethodBeat.o(302605);
          return Float.valueOf(f);
        } while (!paramString.equals("msgId"));
        localObject = (Long)this.vLd.vKV.get(this.vAA);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = Long.valueOf(0L);
        }
        paramString = String.valueOf(paramString.longValue());
        localObject = this.vAA;
        Log.d(BizTLRecCardJsEngine.access$getTAG$cp(), "getInfo canvasId=" + (String)localObject + ", msgIds=" + paramString);
        AppMethodBeat.o(302605);
        return paramString;
      } while (!paramString.equals("sessionId"));
      paramString = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
      if (paramString != null) {
        break;
      }
    }
    for (int i = 0;; i = paramString.dbB())
    {
      AppMethodBeat.o(302605);
      return Integer.valueOf(i);
      if (!paramString.equals("videoChannelData")) {
        break;
      }
      paramString = com.tencent.mm.plugin.brandservice.model.d.vBI;
      paramString = com.tencent.mm.plugin.brandservice.model.d.dce();
      AppMethodBeat.o(302605);
      return paramString;
      if (!paramString.equals("videoChannelItemWidth")) {
        break;
      }
      paramString = Integer.valueOf(kotlin.h.a.eH(com.tencent.mm.plugin.brandservice.ui.timeline.offenread.c.fP(MMApplicationContext.getContext()) / com.tencent.mm.plugin.appbrand.af.i.mn()));
      localObject = this.vAA;
      i = ((Number)paramString).intValue();
      Log.d(BizTLRecCardJsEngine.access$getTAG$cp(), "getInfo canvasId=" + (String)localObject + ", videoChannelItemWidth=" + i);
      AppMethodBeat.o(302605);
      return paramString;
      if (!paramString.equals("feedBackRecycleCardList")) {
        break;
      }
      paramString = k.ddu();
      AppMethodBeat.o(302605);
      return paramString;
    }
  }
  
  public final void onItemClick(String paramString, int paramInt)
  {
    AppMethodBeat.i(302632);
    s.u(paramString, "fieldId");
    long l = Util.getLong(paramString, 0L);
    Log.i(BizTLRecCardJsEngine.access$getTAG$cp(), "onItemClick fieldId=" + paramString + ", msgId=" + l + ", pos=" + paramInt);
    com.tencent.threadpool.h.ahAA.bm(new BizTLRecCardJsEngine.c..ExternalSyntheticLambda2(this.vLd, paramString, paramInt, l));
    AppMethodBeat.o(302632);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(BizTLRecCardJsEngine paramBizTLRecCardJsEngine, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine.c
 * JD-Core Version:    0.7.0.1
 */