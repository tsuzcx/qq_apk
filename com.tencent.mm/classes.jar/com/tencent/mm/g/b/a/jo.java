package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class jo
  extends a
{
  public long dVd = 0L;
  private long dWQ = 0L;
  private String eBo;
  private String eBp;
  private String eBq;
  public c eBr;
  public b eBs;
  private String eBt;
  public d eBu;
  public e eBv;
  public a eBw;
  private String esR;
  
  public final String RD()
  {
    int j = -1;
    AppMethodBeat.i(2608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBq);
    ((StringBuffer)localObject).append(",");
    if (this.eBr != null)
    {
      i = this.eBr.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.eBs == null) {
        break label287;
      }
      i = this.eBs.value;
      label139:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dVd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eBt);
      ((StringBuffer)localObject).append(",");
      if (this.eBu == null) {
        break label292;
      }
      i = this.eBu.value;
      label199:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.eBv == null) {
        break label297;
      }
    }
    label287:
    label292:
    label297:
    for (int i = this.eBv.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eBw != null) {
        i = this.eBw.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
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
  
  public final String RE()
  {
    AppMethodBeat.i(2609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.eBo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.dWQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareTicket:").append(this.eBp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChattingId:").append(this.eBq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsGroupChatting:").append(this.eBr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eBs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.eBt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgState:").append(this.eBu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScribeState:").append(this.eBv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eBw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(2609);
    return localObject;
  }
  
  public final jo Vs()
  {
    AppMethodBeat.i(2604);
    this.dWQ = bt.flT();
    super.bg("ActionTimeStampMs", this.dWQ);
    AppMethodBeat.o(2604);
    return this;
  }
  
  public final int getId()
  {
    return 16024;
  }
  
  public final jo sd(String paramString)
  {
    AppMethodBeat.i(2602);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(2602);
    return this;
  }
  
  public final jo se(String paramString)
  {
    AppMethodBeat.i(2603);
    this.eBo = t("PageId", paramString, true);
    AppMethodBeat.o(2603);
    return this;
  }
  
  public final jo sf(String paramString)
  {
    AppMethodBeat.i(2605);
    this.eBp = t("ShareTicket", paramString, true);
    AppMethodBeat.o(2605);
    return this;
  }
  
  public final jo sg(String paramString)
  {
    AppMethodBeat.i(2606);
    this.eBq = t("ChattingId", paramString, true);
    AppMethodBeat.o(2606);
    return this;
  }
  
  public final jo sh(String paramString)
  {
    AppMethodBeat.i(2607);
    this.eBt = t("SceneNote", paramString, true);
    AppMethodBeat.o(2607);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2589);
      eBx = new a("undefined", 0, 0);
      eBy = new a("normal", 1, 1000);
      eBz = new a("plugin", 2, 1001);
      eBA = new a("wxstore", 3, 1002);
      eBB = new a("merchant", 4, 1003);
      eBC = new a("wagame", 5, 1004);
      eBD = new a("gift", 6, 1005);
      eBE = new a[] { eBx, eBy, eBz, eBA, eBB, eBC, eBD };
      AppMethodBeat.o(2589);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jT(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return eBx;
      case 1000: 
        return eBy;
      case 1001: 
        return eBz;
      case 1002: 
        return eBA;
      case 1003: 
        return eBB;
      case 1004: 
        return eBC;
      }
      return eBD;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2592);
      eBF = new b("SHAREAPPMSG", 0, 1);
      eBG = new b("CLICKAPPMSG", 1, 2);
      eBH = new b("CLICKSUBSCRIBETV", 2, 3);
      eBI = new b("CLICKSTARTGAME", 3, 4);
      eBJ = new b[] { eBF, eBG, eBH, eBI };
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
      eBK = new c("DEFAULT", 0, 0);
      eBL = new c("YES", 1, 1);
      eBM = new c("NO", 2, 2);
      eBN = new c[] { eBK, eBL, eBM };
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
      eBO = new d("DEFAULT", 0, 0);
      eBP = new d("DOING", 1, 1);
      eBQ = new d("DONE", 2, 2);
      eBR = new d[] { eBO, eBP, eBQ };
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
      eBS = new e("DEFAULT", 0, 0);
      eBT = new e("NOTSUBSCRIBE", 1, 1);
      eBU = new e("SUBSCRIBE", 2, 2);
      eBV = new e[] { eBS, eBT, eBU };
      AppMethodBeat.o(2601);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jo
 * JD-Core Version:    0.7.0.1
 */