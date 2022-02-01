package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kc
  extends a
{
  public long gLF;
  private String gLH = "";
  private String gLI = "";
  public int gLK;
  public int gLM;
  public long gMB;
  public int gMC;
  public int gMD;
  public int gME;
  public int gMF;
  public int ggl;
  public int ggm;
  private String giD = "";
  private String gqd = "";
  
  public final kc Ba(String paramString)
  {
    AppMethodBeat.i(186597);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(186597);
    return this;
  }
  
  public final kc Bb(String paramString)
  {
    AppMethodBeat.i(186598);
    this.gLH = z("PattedUserName", paramString, true);
    AppMethodBeat.o(186598);
    return this;
  }
  
  public final kc Bc(String paramString)
  {
    AppMethodBeat.i(186599);
    this.giD = z("ChatroomName", paramString, true);
    AppMethodBeat.o(186599);
    return this;
  }
  
  public final kc Bd(String paramString)
  {
    AppMethodBeat.i(186600);
    this.gLI = z("PatSuffix", paramString, true);
    AppMethodBeat.o(186600);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(186601);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gME);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(186601);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(186602);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.gLF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.gLH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomName:").append(this.giD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.ggm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeInterval:").append(this.gMB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHitLocalFrequency:").append(this.gMC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCreateNewChat:").append(this.gMD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSequence:").append(this.gME);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.gLI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.gLM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.gLK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEducationGuidance:").append(this.gMF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186602);
    return localObject;
  }
  
  public final int getId()
  {
    return 19878;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kc
 * JD-Core Version:    0.7.0.1
 */