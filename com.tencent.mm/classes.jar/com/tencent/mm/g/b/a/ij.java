package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class ij
  extends a
{
  public long dHY = 0L;
  private long dJh = 0L;
  private String ecm;
  private String ekm;
  private String ekn;
  private String eko;
  public c ekp;
  public b ekq;
  private String ekr;
  public d eks;
  public e ekt;
  public a eku;
  
  public final String PR()
  {
    int j = -1;
    AppMethodBeat.i(2608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eko);
    ((StringBuffer)localObject).append(",");
    if (this.ekp != null)
    {
      i = this.ekp.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.ekq == null) {
        break label287;
      }
      i = this.ekq.value;
      label139:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dHY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ekr);
      ((StringBuffer)localObject).append(",");
      if (this.eks == null) {
        break label292;
      }
      i = this.eks.value;
      label199:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.ekt == null) {
        break label297;
      }
    }
    label287:
    label292:
    label297:
    for (int i = this.ekt.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eku != null) {
        i = this.eku.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
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
  
  public final String PS()
  {
    AppMethodBeat.i(2609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.ekm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.dJh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareTicket:").append(this.ekn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChattingId:").append(this.eko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsGroupChatting:").append(this.ekp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.ekq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.ekr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgState:").append(this.eks);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScribeState:").append(this.ekt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eku);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(2609);
    return localObject;
  }
  
  public final ij Tf()
  {
    AppMethodBeat.i(2604);
    this.dJh = bs.eWj();
    super.bd("ActionTimeStampMs", this.dJh);
    AppMethodBeat.o(2604);
    return this;
  }
  
  public final int getId()
  {
    return 16024;
  }
  
  public final ij pA(String paramString)
  {
    AppMethodBeat.i(2606);
    this.eko = t("ChattingId", paramString, true);
    AppMethodBeat.o(2606);
    return this;
  }
  
  public final ij pB(String paramString)
  {
    AppMethodBeat.i(2607);
    this.ekr = t("SceneNote", paramString, true);
    AppMethodBeat.o(2607);
    return this;
  }
  
  public final ij px(String paramString)
  {
    AppMethodBeat.i(2602);
    this.ecm = t("AppId", paramString, true);
    AppMethodBeat.o(2602);
    return this;
  }
  
  public final ij py(String paramString)
  {
    AppMethodBeat.i(2603);
    this.ekm = t("PageId", paramString, true);
    AppMethodBeat.o(2603);
    return this;
  }
  
  public final ij pz(String paramString)
  {
    AppMethodBeat.i(2605);
    this.ekn = t("ShareTicket", paramString, true);
    AppMethodBeat.o(2605);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2589);
      ekv = new a("undefined", 0, 0);
      ekw = new a("normal", 1, 1000);
      ekx = new a("plugin", 2, 1001);
      eky = new a("wxstore", 3, 1002);
      ekz = new a("merchant", 4, 1003);
      ekA = new a("wagame", 5, 1004);
      ekB = new a("gift", 6, 1005);
      ekC = new a[] { ekv, ekw, ekx, eky, ekz, ekA, ekB };
      AppMethodBeat.o(2589);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jw(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return ekv;
      case 1000: 
        return ekw;
      case 1001: 
        return ekx;
      case 1002: 
        return eky;
      case 1003: 
        return ekz;
      case 1004: 
        return ekA;
      }
      return ekB;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2592);
      ekD = new b("SHAREAPPMSG", 0, 1);
      ekE = new b("CLICKAPPMSG", 1, 2);
      ekF = new b("CLICKSUBSCRIBETV", 2, 3);
      ekG = new b("CLICKSTARTGAME", 3, 4);
      ekH = new b[] { ekD, ekE, ekF, ekG };
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
      ekI = new c("DEFAULT", 0, 0);
      ekJ = new c("YES", 1, 1);
      ekK = new c("NO", 2, 2);
      ekL = new c[] { ekI, ekJ, ekK };
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
      ekM = new d("DEFAULT", 0, 0);
      ekN = new d("DOING", 1, 1);
      ekO = new d("DONE", 2, 2);
      ekP = new d[] { ekM, ekN, ekO };
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
      ekQ = new e("DEFAULT", 0, 0);
      ekR = new e("NOTSUBSCRIBE", 1, 1);
      ekS = new e("SUBSCRIBE", 2, 2);
      ekT = new e[] { ekQ, ekR, ekS };
      AppMethodBeat.o(2601);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ij
 * JD-Core Version:    0.7.0.1
 */