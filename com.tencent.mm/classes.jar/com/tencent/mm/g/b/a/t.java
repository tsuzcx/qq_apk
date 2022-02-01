package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class t
  extends a
{
  public String dTr = "";
  public long dUk;
  public long dUl;
  public long dUm;
  public long dUn;
  public long dUo;
  public long dUp;
  public long dUq;
  public long dUr;
  private String dUs = "";
  public String dUt = "";
  public long dUu;
  
  public final String RC()
  {
    AppMethodBeat.i(189059);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUu);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189059);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189060);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ReddotFlag:").append(this.dUk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.dUl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocationPermission:").append(this.dUm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FollowInitPosition:").append(this.dUn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendInitPosition:").append(this.dUo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LBSInitPosition:").append(this.dUp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HotInitPosition:").append(this.dUq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTab:").append(this.dUr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterRedDotId:").append(this.dUs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoRefresh:").append(this.dUu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189060);
    return localObject;
  }
  
  public final t gU(String paramString)
  {
    AppMethodBeat.i(189058);
    this.dUs = t("EnterRedDotId", paramString, true);
    AppMethodBeat.o(189058);
    return this;
  }
  
  public final int getId()
  {
    return 19025;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.t
 * JD-Core Version:    0.7.0.1
 */