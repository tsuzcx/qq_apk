package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class uj
  extends a
{
  private String iXJ = "";
  private String imT = "";
  public long iqr = 0L;
  private long izS = 0L;
  private String jGI = "";
  private String jGJ = "";
  private String jGK = "";
  public c jGL;
  public b jGM;
  public d jGN;
  public e jGO;
  public a jGP;
  
  public final uj Ad(String paramString)
  {
    AppMethodBeat.i(2602);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(2602);
    return this;
  }
  
  public final uj Ae(String paramString)
  {
    AppMethodBeat.i(2603);
    this.jGI = F("PageId", paramString, true);
    AppMethodBeat.o(2603);
    return this;
  }
  
  public final uj Af(String paramString)
  {
    AppMethodBeat.i(2605);
    this.jGJ = F("ShareTicket", paramString, true);
    AppMethodBeat.o(2605);
    return this;
  }
  
  public final uj Ag(String paramString)
  {
    AppMethodBeat.i(2606);
    this.jGK = F("ChattingId", paramString, true);
    AppMethodBeat.o(2606);
    return this;
  }
  
  public final uj Ah(String paramString)
  {
    AppMethodBeat.i(2607);
    this.iXJ = F("SceneNote", paramString, true);
    AppMethodBeat.o(2607);
    return this;
  }
  
  public final String aIE()
  {
    int j = -1;
    AppMethodBeat.i(2608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jGI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jGJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jGK);
    ((StringBuffer)localObject).append(",");
    if (this.jGL != null)
    {
      i = this.jGL.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.jGM == null) {
        break label287;
      }
      i = this.jGM.value;
      label139:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iXJ);
      ((StringBuffer)localObject).append(",");
      if (this.jGN == null) {
        break label292;
      }
      i = this.jGN.value;
      label199:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.jGO == null) {
        break label297;
      }
    }
    label287:
    label292:
    label297:
    for (int i = this.jGO.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.jGP != null) {
        i = this.jGP.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
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
  
  public final String aIF()
  {
    AppMethodBeat.i(2609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.jGI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.izS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareTicket:").append(this.jGJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChattingId:").append(this.jGK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsGroupChatting:").append(this.jGL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.jGM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.iXJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgState:").append(this.jGN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScribeState:").append(this.jGO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jGP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(2609);
    return localObject;
  }
  
  public final uj aJl()
  {
    AppMethodBeat.i(2604);
    this.izS = Util.nowMilliSecond();
    super.by("ActionTimeStampMs", this.izS);
    AppMethodBeat.o(2604);
    return this;
  }
  
  public final int getId()
  {
    return 16024;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2589);
      jGQ = new a("undefined", 0, 0);
      jGR = new a("normal", 1, 1000);
      jGS = new a("plugin", 2, 1001);
      jGT = new a("wxstore", 3, 1002);
      jGU = new a("merchant", 4, 1003);
      jGV = new a("wagame", 5, 1004);
      jGW = new a("gift", 6, 1005);
      jGX = new a[] { jGQ, jGR, jGS, jGT, jGU, jGV, jGW };
      AppMethodBeat.o(2589);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a pk(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return jGQ;
      case 1000: 
        return jGR;
      case 1001: 
        return jGS;
      case 1002: 
        return jGT;
      case 1003: 
        return jGU;
      case 1004: 
        return jGV;
      }
      return jGW;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2592);
      jGY = new b("SHAREAPPMSG", 0, 1);
      jGZ = new b("CLICKAPPMSG", 1, 2);
      jHa = new b("CLICKSUBSCRIBETV", 2, 3);
      jHb = new b("CLICKSTARTGAME", 3, 4);
      jHc = new b[] { jGY, jGZ, jHa, jHb };
      AppMethodBeat.o(2592);
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
      AppMethodBeat.i(2595);
      jHd = new c("DEFAULT", 0, 0);
      jHe = new c("YES", 1, 1);
      jHf = new c("NO", 2, 2);
      jHg = new c[] { jHd, jHe, jHf };
      AppMethodBeat.o(2595);
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
      AppMethodBeat.i(2598);
      jHh = new d("DEFAULT", 0, 0);
      jHi = new d("DOING", 1, 1);
      jHj = new d("DONE", 2, 2);
      jHk = new d[] { jHh, jHi, jHj };
      AppMethodBeat.o(2598);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2601);
      jHl = new e("DEFAULT", 0, 0);
      jHm = new e("NOTSUBSCRIBE", 1, 1);
      jHn = new e("SUBSCRIBE", 2, 2);
      jHo = new e[] { jHl, jHm, jHn };
      AppMethodBeat.o(2601);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.uj
 * JD-Core Version:    0.7.0.1
 */