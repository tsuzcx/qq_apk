package com.tencent.mm.plugin.finder.live.olympic.report;

import com.tencent.d.a.a.a.b.b.e;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.d.a.a.a.b.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.f;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/report/OlympicsCertReportUtil;", "", "()V", "TAG", "", "certReportData", "Lcom/tencent/mm/plugin/finder/live/olympic/report/OlympicsCertReportUtil$CertReportData;", "getCommonMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getJoinScene", "getRelayScene", "initCertReport", "", "reportOlympicBanner", "bannerType", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicState;", "isClick", "", "reportOlympicRelayBtn", "reportOlympicSetStatus", "reportOlympicShareBtn", "reportOlympicShareClickChannel", "sharChannel", "Lcom/tencent/mm/plugin/finder/live/olympic/report/OlympicsCertReportUtil$ShareChannel;", "CertReportData", "ShareChannel", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a CRJ;
  private static a CRK;
  
  static
  {
    AppMethodBeat.i(360633);
    CRJ = new a();
    AppMethodBeat.o(360633);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(360575);
    s.u(parama, "certReportData");
    CRK = parama;
    Log.i("OlympicsCertReportUtil", s.X("initCertReport: ", parama));
    AppMethodBeat.o(360575);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(360607);
    s.u(paramb, "sharChannel");
    HashMap localHashMap = eoh();
    ((Map)localHashMap).put("share_type", paramb.id);
    Log.i("OlympicsCertReportUtil", s.X("reportOlympicShareClickChannel reportMap: ", localHashMap));
    ((ce)h.ax(ce.class)).a(q.s.Dvo, (Map)localHashMap);
    AppMethodBeat.o(360607);
  }
  
  public static void b(n.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(360585);
    s.u(paramf, "bannerType");
    HashMap localHashMap = eoh();
    ((Map)localHashMap).put("banner_type", String.valueOf(paramf.id));
    Log.i("OlympicsCertReportUtil", "reportOlympicBanner bannerType: " + paramf + " isClick: " + paramBoolean + " reportMap: " + localHashMap);
    if (paramBoolean)
    {
      ((ce)h.ax(ce.class)).a(q.s.Dvk, (Map)localHashMap);
      AppMethodBeat.o(360585);
      return;
    }
    ((ce)h.ax(ce.class)).a(q.t.Dwy, (Map)localHashMap);
    AppMethodBeat.o(360585);
  }
  
  public static HashMap<String, String> eoh()
  {
    int i = 1;
    AppMethodBeat.i(360616);
    HashMap localHashMap = new HashMap();
    Object localObject2 = (Map)localHashMap;
    Object localObject1 = CRK;
    label43:
    Map localMap;
    if ((localObject1 != null) && (((a)localObject1).CRM == true))
    {
      if (i == 0) {
        break label159;
      }
      localObject1 = "1";
      ((Map)localObject2).put("is_get_certificate", localObject1);
      ((Map)localHashMap).put("relay_sence", eoj());
      ((Map)localHashMap).put("join_sence", eoi());
      localMap = (Map)localHashMap;
      localObject1 = b.CRS;
      localObject1 = b.eom();
      if (localObject1 != null) {
        break label165;
      }
      localObject1 = "";
      label104:
      localMap.put("username", localObject1);
      localMap = (Map)localHashMap;
      localObject1 = b.CRS;
      localObject1 = b.eom();
      if (localObject1 != null) {
        break label182;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localMap.put("finder_username", localObject1);
      AppMethodBeat.o(360616);
      return localHashMap;
      i = 0;
      break;
      label159:
      localObject1 = "0";
      break label43;
      label165:
      localObject2 = ((dwa)localObject1).hLv;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label104;
      }
      localObject1 = "";
      break label104;
      label182:
      localObject2 = ((dwa)localObject1).finderUsername;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  private static String eoi()
  {
    AppMethodBeat.i(360626);
    Object localObject = b.CRS;
    localObject = b.eom();
    if (localObject == null)
    {
      localObject = b.i.ahoK.id;
      AppMethodBeat.o(360626);
      return localObject;
    }
    int i = ((dwa)localObject).abbK;
    b.e.a locala = b.e.ahon;
    if (i == b.e.a.jVX())
    {
      localObject = b.i.ahoN.id;
      AppMethodBeat.o(360626);
      return localObject;
    }
    locala = b.e.ahon;
    if (i == b.e.a.jVY())
    {
      localObject = b.i.ahoM.id;
      AppMethodBeat.o(360626);
      return localObject;
    }
    locala = b.e.ahon;
    if (i == b.e.a.jVZ())
    {
      localObject = b.i.ahoR.id;
      AppMethodBeat.o(360626);
      return localObject;
    }
    locala = b.e.ahon;
    if (i != b.e.a.jWa())
    {
      locala = b.e.ahon;
      if (i == b.e.a.jWb())
      {
        if (((dwa)localObject).abbM)
        {
          localObject = b.i.ahoP.id;
          AppMethodBeat.o(360626);
          return localObject;
        }
        localObject = b.i.ahoO.id;
        AppMethodBeat.o(360626);
        return localObject;
      }
      localObject = b.e.ahon;
      if (i == b.e.a.jWc())
      {
        localObject = b.i.ahoQ.id;
        AppMethodBeat.o(360626);
        return localObject;
      }
    }
    localObject = b.i.ahoK.id;
    AppMethodBeat.o(360626);
    return localObject;
  }
  
  private static String eoj()
  {
    int j = 1;
    AppMethodBeat.i(360629);
    Object localObject = CRK;
    if ((localObject != null) && (((a)localObject).CRM == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = b.i.ahoJ.id;
      AppMethodBeat.o(360629);
      return localObject;
    }
    localObject = CRK;
    if ((localObject != null) && (!((a)localObject).CRL)) {}
    for (i = j; i != 0; i = 0)
    {
      localObject = b.i.ahoL.id;
      AppMethodBeat.o(360629);
      return localObject;
    }
    localObject = eoi();
    AppMethodBeat.o(360629);
    return localObject;
  }
  
  public static void qR(boolean paramBoolean)
  {
    AppMethodBeat.i(360595);
    HashMap localHashMap = eoh();
    Log.i("OlympicsCertReportUtil", "reportOlympicRelayBtn isClick: " + paramBoolean + " reportMap: " + localHashMap);
    if (paramBoolean)
    {
      ((ce)h.ax(ce.class)).a(q.s.Dvn, (Map)localHashMap);
      AppMethodBeat.o(360595);
      return;
    }
    ((ce)h.ax(ce.class)).a(q.t.DwB, (Map)localHashMap);
    AppMethodBeat.o(360595);
  }
  
  public static void qS(boolean paramBoolean)
  {
    AppMethodBeat.i(360601);
    HashMap localHashMap = eoh();
    Log.i("OlympicsCertReportUtil", "reportOlympicShareBtn isClick: " + paramBoolean + " reportMap: " + localHashMap);
    if (paramBoolean)
    {
      ((ce)h.ax(ce.class)).a(q.s.Dvl, (Map)localHashMap);
      AppMethodBeat.o(360601);
      return;
    }
    ((ce)h.ax(ce.class)).a(q.t.Dwz, (Map)localHashMap);
    AppMethodBeat.o(360601);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/report/OlympicsCertReportUtil$CertReportData;", "", "liveId", "", "isRelay", "", "isToucher", "(JZZ)V", "()Z", "getLiveId", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final boolean CRL;
    final boolean CRM;
    private final long liveId;
    
    public a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.liveId = paramLong;
      this.CRL = paramBoolean1;
      this.CRM = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.liveId != paramObject.liveId) {
          return false;
        }
        if (this.CRL != paramObject.CRL) {
          return false;
        }
      } while (this.CRM == paramObject.CRM);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(360581);
      String str = "CertReportData(liveId=" + this.liveId + ", isRelay=" + this.CRL + ", isToucher=" + this.CRM + ')';
      AppMethodBeat.o(360581);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/report/OlympicsCertReportUtil$ShareChannel;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "CHANNEL_FRIEND", "CHANNEL_SNS", "CHANNEL_STATE", "CHANNEL_PHOTO", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    final String id;
    
    static
    {
      AppMethodBeat.i(360594);
      CRN = new b("CHANNEL_FRIEND", 0, "1");
      CRO = new b("CHANNEL_SNS", 1, "2");
      CRP = new b("CHANNEL_STATE", 2, "3");
      CRQ = new b("CHANNEL_PHOTO", 3, "4");
      CRR = new b[] { CRN, CRO, CRP, CRQ };
      AppMethodBeat.o(360594);
    }
    
    private b(String paramString)
    {
      this.id = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.report.a
 * JD-Core Version:    0.7.0.1
 */