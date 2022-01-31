package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class dd
  extends a
{
  public long cRG = 0L;
  private String cZA;
  private String dem;
  private long den = 0L;
  private String deo;
  private String dep;
  public dd.c deq;
  public b der;
  private String des;
  public dd.d det;
  public dd.e deu;
  public a dev;
  
  public final String Ff()
  {
    int j = -1;
    AppMethodBeat.i(51117);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dem);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.den);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dep);
    ((StringBuffer)localObject).append(",");
    if (this.deq != null)
    {
      i = this.deq.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.der == null) {
        break label285;
      }
      i = this.der.value;
      label138:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cRG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.des);
      ((StringBuffer)localObject).append(",");
      if (this.det == null) {
        break label290;
      }
      i = this.det.value;
      label198:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.deu == null) {
        break label295;
      }
    }
    label285:
    label290:
    label295:
    for (int i = this.deu.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.dev != null) {
        i = this.dev.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(51117);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label138;
      i = -1;
      break label198;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(51118);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.dem);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.den);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareTicket:").append(this.deo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChattingId:").append(this.dep);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsGroupChatting:").append(this.deq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.der);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.des);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgState:").append(this.det);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScribeState:").append(this.deu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.dev);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(51118);
    return localObject;
  }
  
  public final dd Hl()
  {
    AppMethodBeat.i(51113);
    this.den = bo.aoy();
    super.az("ActionTimeStampMs", this.den);
    AppMethodBeat.o(51113);
    return this;
  }
  
  public final int getId()
  {
    return 16024;
  }
  
  public final dd iu(String paramString)
  {
    AppMethodBeat.i(51111);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(51111);
    return this;
  }
  
  public final dd iv(String paramString)
  {
    AppMethodBeat.i(51112);
    this.dem = t("PageId", paramString, true);
    AppMethodBeat.o(51112);
    return this;
  }
  
  public final dd iw(String paramString)
  {
    AppMethodBeat.i(51114);
    this.deo = t("ShareTicket", paramString, true);
    AppMethodBeat.o(51114);
    return this;
  }
  
  public final dd ix(String paramString)
  {
    AppMethodBeat.i(51115);
    this.dep = t("ChattingId", paramString, true);
    AppMethodBeat.o(51115);
    return this;
  }
  
  public final dd iy(String paramString)
  {
    AppMethodBeat.i(51116);
    this.des = t("SceneNote", paramString, true);
    AppMethodBeat.o(51116);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(51098);
      dew = new a("undefined", 0, 0);
      dex = new a("normal", 1, 1000);
      dey = new a("plugin", 2, 1001);
      dez = new a("wxstore", 3, 1002);
      deA = new a("merchant", 4, 1003);
      deB = new a("wagame", 5, 1004);
      deC = new a("gift", 6, 1005);
      deD = new a[] { dew, dex, dey, dez, deA, deB, deC };
      AppMethodBeat.o(51098);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a hn(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return dew;
      case 1000: 
        return dex;
      case 1001: 
        return dey;
      case 1002: 
        return dez;
      case 1003: 
        return deA;
      case 1004: 
        return deB;
      }
      return deC;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(51101);
      deE = new b("SHAREAPPMSG", 0, 1);
      deF = new b("CLICKAPPMSG", 1, 2);
      deG = new b("CLICKSUBSCRIBETV", 2, 3);
      deH = new b("CLICKSTARTGAME", 3, 4);
      deI = new b[] { deE, deF, deG, deH };
      AppMethodBeat.o(51101);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dd
 * JD-Core Version:    0.7.0.1
 */