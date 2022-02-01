package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class gr
  extends a
{
  public long dKe = 0L;
  private String eag;
  private String eih;
  private long eii = 0L;
  private String eij;
  private String eik;
  public gr.c eil;
  public b eim;
  private String ein;
  public gr.d eio;
  public gr.e eip;
  public a eiq;
  
  public final String PV()
  {
    int j = -1;
    AppMethodBeat.i(2608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eih);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eii);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eij);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eik);
    ((StringBuffer)localObject).append(",");
    if (this.eil != null)
    {
      i = this.eil.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.eim == null) {
        break label287;
      }
      i = this.eim.value;
      label139:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ein);
      ((StringBuffer)localObject).append(",");
      if (this.eio == null) {
        break label292;
      }
      i = this.eio.value;
      label199:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.eip == null) {
        break label297;
      }
    }
    label287:
    label292:
    label297:
    for (int i = this.eip.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eiq != null) {
        i = this.eiq.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(2608);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label139;
      i = -1;
      break label199;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(2609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.eih);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.eii);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareTicket:").append(this.eij);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChattingId:").append(this.eik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsGroupChatting:").append(this.eil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eim);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.ein);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgState:").append(this.eio);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScribeState:").append(this.eip);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eiq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(2609);
    return localObject;
  }
  
  public final gr Sm()
  {
    AppMethodBeat.i(2604);
    this.eii = bt.eGO();
    super.bb("ActionTimeStampMs", this.eii);
    AppMethodBeat.o(2604);
    return this;
  }
  
  public final int getId()
  {
    return 16024;
  }
  
  public final gr mr(String paramString)
  {
    AppMethodBeat.i(2602);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(2602);
    return this;
  }
  
  public final gr ms(String paramString)
  {
    AppMethodBeat.i(2603);
    this.eih = t("PageId", paramString, true);
    AppMethodBeat.o(2603);
    return this;
  }
  
  public final gr mt(String paramString)
  {
    AppMethodBeat.i(2605);
    this.eij = t("ShareTicket", paramString, true);
    AppMethodBeat.o(2605);
    return this;
  }
  
  public final gr mu(String paramString)
  {
    AppMethodBeat.i(2606);
    this.eik = t("ChattingId", paramString, true);
    AppMethodBeat.o(2606);
    return this;
  }
  
  public final gr mv(String paramString)
  {
    AppMethodBeat.i(2607);
    this.ein = t("SceneNote", paramString, true);
    AppMethodBeat.o(2607);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2589);
      eir = new a("undefined", 0, 0);
      eis = new a("normal", 1, 1000);
      eit = new a("plugin", 2, 1001);
      eiu = new a("wxstore", 3, 1002);
      eiv = new a("merchant", 4, 1003);
      eiw = new a("wagame", 5, 1004);
      eix = new a("gift", 6, 1005);
      eiy = new a[] { eir, eis, eit, eiu, eiv, eiw, eix };
      AppMethodBeat.o(2589);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jy(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return eir;
      case 1000: 
        return eis;
      case 1001: 
        return eit;
      case 1002: 
        return eiu;
      case 1003: 
        return eiv;
      case 1004: 
        return eiw;
      }
      return eix;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2592);
      eiz = new b("SHAREAPPMSG", 0, 1);
      eiA = new b("CLICKAPPMSG", 1, 2);
      eiB = new b("CLICKSUBSCRIBETV", 2, 3);
      eiC = new b("CLICKSTARTGAME", 3, 4);
      eiD = new b[] { eiz, eiA, eiB, eiC };
      AppMethodBeat.o(2592);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gr
 * JD-Core Version:    0.7.0.1
 */