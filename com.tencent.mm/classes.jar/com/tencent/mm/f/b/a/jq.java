package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jq
  extends a
{
  public long gLF;
  public long gLG;
  private String gLH = "";
  private String gLI = "";
  private String gLJ = "";
  public int gLK;
  public int gLL;
  public int gLM;
  public int ggl;
  private String gjX = "";
  
  public final jq AD(String paramString)
  {
    AppMethodBeat.i(186586);
    this.gjX = z("UserName", paramString, true);
    AppMethodBeat.o(186586);
    return this;
  }
  
  public final jq AE(String paramString)
  {
    AppMethodBeat.i(186587);
    this.gLH = z("PattedUserName", paramString, true);
    AppMethodBeat.o(186587);
    return this;
  }
  
  public final jq AF(String paramString)
  {
    AppMethodBeat.i(186588);
    this.gLI = z("PatSuffix", paramString, true);
    AppMethodBeat.o(186588);
    return this;
  }
  
  public final jq AG(String paramString)
  {
    AppMethodBeat.i(186589);
    this.gLJ = z("ChatRoomName", paramString, true);
    AppMethodBeat.o(186589);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(186590);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLM);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(186590);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(186591);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.gLF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeTime:").append(this.gLG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.gjX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.gLH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.gLI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomName:").append(this.gLJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.gLK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.gLL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.gLM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186591);
    return localObject;
  }
  
  public final int getId()
  {
    return 20590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jq
 * JD-Core Version:    0.7.0.1
 */