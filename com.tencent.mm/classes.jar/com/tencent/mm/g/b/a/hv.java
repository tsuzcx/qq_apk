package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class hv
  extends a
{
  public long dHY = 0L;
  public long dQE = 0L;
  public String dZT = "";
  public long eaM = 0L;
  public String ecm = "";
  public long eco = 0L;
  public long edd = 0L;
  private long edv = 0L;
  public long edw = 0L;
  public long edx = 0L;
  public long eeY;
  public long eez = 0L;
  public a eia;
  public long eib = 0L;
  public c eic;
  public b eid;
  public long eie = 0L;
  private long eif = 0L;
  private long eig = 0L;
  private long eih = 0L;
  public long eii;
  public long eij;
  public long eik;
  public long eil;
  public d eim;
  public long ein;
  
  public final String PR()
  {
    int j = -1;
    AppMethodBeat.i(43722);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    if (this.eia != null)
    {
      i = this.eia.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eco);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eib);
      ((StringBuffer)localObject).append(",");
      if (this.eic == null) {
        break label497;
      }
      i = this.eic.value;
      label202:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.eid == null) {
        break label502;
      }
    }
    label497:
    label502:
    for (int i = this.eid.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dQE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eie);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eif);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eig);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.edd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eih);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eez);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eii);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eij);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eik);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eil);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eim != null) {
        i = this.eim.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ein);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eeY);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(43722);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label202;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eia);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PkgSize:").append(this.eib);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLaunchSync:").append(this.eic);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsContactSync:").append(this.eid);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasDownloadCode:").append(this.eie);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstDownload:").append(this.eif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchType:").append(this.eig);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.edd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NonUICostTimeMs:").append(this.eih);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("initProcess:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchReadyT:").append(this.eii);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageReadyT:").append(this.eij);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIReadyT:").append(this.eik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestType:").append(this.eil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isCheckJsApiInfoSync:").append(this.eim);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("checkJsApiInfoReadyT:").append(this.ein);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.eeY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43723);
    return localObject;
  }
  
  public final hv Tb()
  {
    AppMethodBeat.i(43720);
    this.edx = bs.eWj();
    super.bd("EndTimeStampMs", this.edx);
    AppMethodBeat.o(43720);
    return this;
  }
  
  public final int getId()
  {
    return 15766;
  }
  
  public final hv np(long paramLong)
  {
    AppMethodBeat.i(43718);
    this.edv = paramLong;
    super.bc("CostTimeMs", this.edv);
    AppMethodBeat.o(43718);
    return this;
  }
  
  public final hv nq(long paramLong)
  {
    AppMethodBeat.i(43719);
    this.edw = paramLong;
    super.bd("StartTimeStampMs", this.edw);
    AppMethodBeat.o(43719);
    return this;
  }
  
  public final hv nr(long paramLong)
  {
    AppMethodBeat.i(43721);
    this.eih = paramLong;
    super.bc("NonUICostTimeMs", this.eih);
    AppMethodBeat.o(43721);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43711);
      eio = new a("release", 0, 1);
      eip = new a("debug", 1, 2);
      eiq = new a("demo", 2, 3);
      eir = new a[] { eio, eip, eiq };
      AppMethodBeat.o(43711);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a ji(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return eio;
      case 2: 
        return eip;
      }
      return eiq;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43714);
      eis = new b("sync", 0, 0);
      eit = new b("unsync", 1, 1);
      eiu = new b[] { eis, eit };
      AppMethodBeat.o(43714);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43717);
      eiv = new c("sync", 0, 0);
      eiw = new c("unsync", 1, 1);
      eix = new c[] { eiv, eiw };
      AppMethodBeat.o(43717);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(186204);
      eiy = new d("sync", 0, 0);
      eiz = new d("unsync", 1, 1);
      eiA = new d[] { eiy, eiz };
      AppMethodBeat.o(186204);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hv
 * JD-Core Version:    0.7.0.1
 */