package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class jq
  extends a
{
  public long dWt = 0L;
  private long dYi = 0L;
  private String eCX = "";
  private String eCY = "";
  private String eCZ = "";
  public jq.c eDa;
  public b eDb;
  private String eDc = "";
  public d eDd;
  public e eDe;
  public jq.a eDf;
  private String euy = "";
  
  public final String RC()
  {
    int j = -1;
    AppMethodBeat.i(2608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCZ);
    ((StringBuffer)localObject).append(",");
    if (this.eDa != null)
    {
      i = this.eDa.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.eDb == null) {
        break label287;
      }
      i = this.eDb.value;
      label139:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eDc);
      ((StringBuffer)localObject).append(",");
      if (this.eDd == null) {
        break label292;
      }
      i = this.eDd.value;
      label199:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.eDe == null) {
        break label297;
      }
    }
    label287:
    label292:
    label297:
    for (int i = this.eDe.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eDf != null) {
        i = this.eDf.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
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
  
  public final String RD()
  {
    AppMethodBeat.i(2609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.eCX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.dYi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareTicket:").append(this.eCY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChattingId:").append(this.eCZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsGroupChatting:").append(this.eDa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.eDb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.eDc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgState:").append(this.eDd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScribeState:").append(this.eDe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eDf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(2609);
    return localObject;
  }
  
  public final jq VA()
  {
    AppMethodBeat.i(2604);
    this.dYi = bu.fpO();
    super.bh("ActionTimeStampMs", this.dYi);
    AppMethodBeat.o(2604);
    return this;
  }
  
  public final int getId()
  {
    return 16024;
  }
  
  public final jq sA(String paramString)
  {
    AppMethodBeat.i(2605);
    this.eCY = t("ShareTicket", paramString, true);
    AppMethodBeat.o(2605);
    return this;
  }
  
  public final jq sB(String paramString)
  {
    AppMethodBeat.i(2606);
    this.eCZ = t("ChattingId", paramString, true);
    AppMethodBeat.o(2606);
    return this;
  }
  
  public final jq sC(String paramString)
  {
    AppMethodBeat.i(2607);
    this.eDc = t("SceneNote", paramString, true);
    AppMethodBeat.o(2607);
    return this;
  }
  
  public final jq sy(String paramString)
  {
    AppMethodBeat.i(2602);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(2602);
    return this;
  }
  
  public final jq sz(String paramString)
  {
    AppMethodBeat.i(2603);
    this.eCX = t("PageId", paramString, true);
    AppMethodBeat.o(2603);
    return this;
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2592);
      eDo = new b("SHAREAPPMSG", 0, 1);
      eDp = new b("CLICKAPPMSG", 1, 2);
      eDq = new b("CLICKSUBSCRIBETV", 2, 3);
      eDr = new b("CLICKSTARTGAME", 3, 4);
      eDs = new b[] { eDo, eDp, eDq, eDr };
      AppMethodBeat.o(2592);
    }
    
    private b(int paramInt)
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
      eDx = new d("DEFAULT", 0, 0);
      eDy = new d("DOING", 1, 1);
      eDz = new d("DONE", 2, 2);
      eDA = new d[] { eDx, eDy, eDz };
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
      eDB = new e("DEFAULT", 0, 0);
      eDC = new e("NOTSUBSCRIBE", 1, 1);
      eDD = new e("SUBSCRIBE", 2, 2);
      eDE = new e[] { eDB, eDC, eDD };
      AppMethodBeat.o(2601);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jq
 * JD-Core Version:    0.7.0.1
 */