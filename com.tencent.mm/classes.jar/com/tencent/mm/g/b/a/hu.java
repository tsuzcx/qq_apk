package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hu
  extends a
{
  public long eLQ;
  private String eLS = "";
  private String eLT = "";
  public int eLV;
  public int eLX;
  public long eMu;
  public int eMv;
  public int eMw;
  public int eMx;
  public int eMy;
  private String enA = "";
  public int enq;
  public int eqN;
  private String etW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(206909);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMy);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(206909);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(206910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.eLQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.eLS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomName:").append(this.enA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.eqN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeInterval:").append(this.eMu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHitLocalFrequency:").append(this.eMv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCreateNewChat:").append(this.eMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSequence:").append(this.eMx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.eLT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.eLX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.eLV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEducationGuidance:").append(this.eMy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(206910);
    return localObject;
  }
  
  public final int getId()
  {
    return 19878;
  }
  
  public final hu vA(String paramString)
  {
    AppMethodBeat.i(206908);
    this.eLT = x("PatSuffix", paramString, true);
    AppMethodBeat.o(206908);
    return this;
  }
  
  public final hu vx(String paramString)
  {
    AppMethodBeat.i(206905);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(206905);
    return this;
  }
  
  public final hu vy(String paramString)
  {
    AppMethodBeat.i(206906);
    this.eLS = x("PattedUserName", paramString, true);
    AppMethodBeat.o(206906);
    return this;
  }
  
  public final hu vz(String paramString)
  {
    AppMethodBeat.i(206907);
    this.enA = x("ChatroomName", paramString, true);
    AppMethodBeat.o(206907);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hu
 * JD-Core Version:    0.7.0.1
 */