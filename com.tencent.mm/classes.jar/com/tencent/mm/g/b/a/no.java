package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class no
  extends a
{
  private String eJx = "";
  public long erW = 0L;
  private long eub = 0L;
  private String fhA = "";
  public d fhB;
  public e fhC;
  public no.a fhD;
  private String fhv = "";
  private String fhw = "";
  private String fhx = "";
  public c fhy;
  public no.b fhz;
  
  public final no AJ(String paramString)
  {
    AppMethodBeat.i(2602);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(2602);
    return this;
  }
  
  public final no AK(String paramString)
  {
    AppMethodBeat.i(2603);
    this.fhv = x("PageId", paramString, true);
    AppMethodBeat.o(2603);
    return this;
  }
  
  public final no AL(String paramString)
  {
    AppMethodBeat.i(2605);
    this.fhw = x("ShareTicket", paramString, true);
    AppMethodBeat.o(2605);
    return this;
  }
  
  public final no AM(String paramString)
  {
    AppMethodBeat.i(2606);
    this.fhx = x("ChattingId", paramString, true);
    AppMethodBeat.o(2606);
    return this;
  }
  
  public final no AN(String paramString)
  {
    AppMethodBeat.i(2607);
    this.fhA = x("SceneNote", paramString, true);
    AppMethodBeat.o(2607);
    return this;
  }
  
  public final String abV()
  {
    int j = -1;
    AppMethodBeat.i(2608);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fhv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eub);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fhw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fhx);
    ((StringBuffer)localObject).append(",");
    if (this.fhy != null)
    {
      i = this.fhy.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.fhz == null) {
        break label287;
      }
      i = this.fhz.value;
      label139:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fhA);
      ((StringBuffer)localObject).append(",");
      if (this.fhB == null) {
        break label292;
      }
      i = this.fhB.value;
      label199:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.fhC == null) {
        break label297;
      }
    }
    label287:
    label292:
    label297:
    for (int i = this.fhC.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.fhD != null) {
        i = this.fhD.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
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
  
  public final String abW()
  {
    AppMethodBeat.i(2609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.fhv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.eub);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareTicket:").append(this.fhw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChattingId:").append(this.fhx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsGroupChatting:").append(this.fhy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventId:").append(this.fhz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneNote:").append(this.fhA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgState:").append(this.fhB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScribeState:").append(this.fhC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.fhD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(2609);
    return localObject;
  }
  
  public final no ajq()
  {
    AppMethodBeat.i(2604);
    this.eub = Util.nowMilliSecond();
    super.bj("ActionTimeStampMs", this.eub);
    AppMethodBeat.o(2604);
    return this;
  }
  
  public final int getId()
  {
    return 16024;
  }
  
  public static enum c
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(2595);
      fhR = new c("DEFAULT", 0, 0);
      fhS = new c("YES", 1, 1);
      fhT = new c("NO", 2, 2);
      fhU = new c[] { fhR, fhS, fhT };
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
      fhV = new d("DEFAULT", 0, 0);
      fhW = new d("DOING", 1, 1);
      fhX = new d("DONE", 2, 2);
      fhY = new d[] { fhV, fhW, fhX };
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
      fhZ = new e("DEFAULT", 0, 0);
      fia = new e("NOTSUBSCRIBE", 1, 1);
      fib = new e("SUBSCRIBE", 2, 2);
      fic = new e[] { fhZ, fia, fib };
      AppMethodBeat.o(2601);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.no
 * JD-Core Version:    0.7.0.1
 */