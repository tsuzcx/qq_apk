package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class qo
  extends a
{
  private String gmF = "";
  public long gnP = 0L;
  private long gqi = 0L;
  private String hkG = "";
  private String hkH = "";
  private String hkI = "";
  public qo.c hkJ;
  public b hkK;
  private String hkL = "";
  public qo.d hkM;
  public qo.e hkN;
  public qo.a hkO;
  
  public final qo Hv(String paramString)
  {
    AppMethodBeat.i(2602);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(2602);
    return this;
  }
  
  public final qo Hw(String paramString)
  {
    AppMethodBeat.i(2603);
    this.hkG = z("PageId", paramString, true);
    AppMethodBeat.o(2603);
    return this;
  }
  
  public final qo Hx(String paramString)
  {
    AppMethodBeat.i(2605);
    this.hkH = z("ShareTicket", paramString, true);
    AppMethodBeat.o(2605);
    return this;
  }
  
  public final qo Hy(String paramString)
  {
    AppMethodBeat.i(2606);
    this.hkI = z("ChattingId", paramString, true);
    AppMethodBeat.o(2606);
    return this;
  }
  
  public final qo Hz(String paramString)
  {
    AppMethodBeat.i(2607);
    this.hkL = z("SceneNote", paramString, true);
    AppMethodBeat.o(2607);
    return this;
  }
  
  public final String agH()
  {
    int j = -1;
    AppMethodBeat.i(2608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hkG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hkH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hkI);
    ((StringBuffer)localObject).append(",");
    if (this.hkJ != null)
    {
      i = this.hkJ.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.hkK == null) {
        break label287;
      }
      i = this.hkK.value;
      label139:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hkL);
      ((StringBuffer)localObject).append(",");
      if (this.hkM == null) {
        break label292;
      }
      i = this.hkM.value;
      label199:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.hkN == null) {
        break label297;
      }
    }
    label287:
    label292:
    label297:
    for (int i = this.hkN.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.hkO != null) {
        i = this.hkO.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
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
  
  public final String agI()
  {
    AppMethodBeat.i(2609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.hkG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.gqi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareTicket:").append(this.hkH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChattingId:").append(this.hkI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsGroupChatting:").append(this.hkJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.hkK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.hkL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgState:").append(this.hkM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScribeState:").append(this.hkN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.hkO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(2609);
    return localObject;
  }
  
  public final qo aoX()
  {
    AppMethodBeat.i(2604);
    this.gqi = Util.nowMilliSecond();
    super.bm("ActionTimeStampMs", this.gqi);
    AppMethodBeat.o(2604);
    return this;
  }
  
  public final int getId()
  {
    return 16024;
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2592);
      hkX = new b("SHAREAPPMSG", 0, 1);
      hkY = new b("CLICKAPPMSG", 1, 2);
      hkZ = new b("CLICKSUBSCRIBETV", 2, 3);
      hla = new b("CLICKSTARTGAME", 3, 4);
      hlb = new b[] { hkX, hkY, hkZ, hla };
      AppMethodBeat.o(2592);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qo
 * JD-Core Version:    0.7.0.1
 */