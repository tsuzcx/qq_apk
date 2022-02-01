package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aj
  extends a
{
  public String eiB = "";
  public long eoA;
  public long eoq;
  public long eor;
  public long eos;
  public long eot;
  public long eou;
  public long eov;
  public long eow;
  public long eox;
  private String eoy = "";
  public String eoz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(208838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eor);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eos);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eot);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eou);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eov);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eow);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eox);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208838);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReddotFlag:").append(this.eoq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.eor);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocationPermission:").append(this.eos);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FollowInitPosition:").append(this.eot);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendInitPosition:").append(this.eou);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LBSInitPosition:").append(this.eov);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotInitPosition:").append(this.eow);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTab:").append(this.eox);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterRedDotId:").append(this.eoy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoRefresh:").append(this.eoA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208839);
    return localObject;
  }
  
  public final int getId()
  {
    return 19025;
  }
  
  public final aj ip(String paramString)
  {
    AppMethodBeat.i(208837);
    this.eoy = x("EnterRedDotId", paramString, true);
    AppMethodBeat.o(208837);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aj
 * JD-Core Version:    0.7.0.1
 */