package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fm
  extends a
{
  public long gAK;
  public String gAL = "";
  public String gAM = "";
  public long gAN;
  public long gAO;
  public long gAP;
  public String gAQ = "";
  public String gAR = "";
  public long gAS;
  public long gdk;
  public long gef;
  public String git = "";
  public String giv = "";
  public String giw = "";
  public String giy = "";
  public long gnP;
  
  public final String agH()
  {
    AppMethodBeat.i(212483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.git);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAS);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(212483);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(212485);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.git);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasReddot:").append(this.gAK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HitWordList:").append(this.gAL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HitWordVersion:").append(this.gAM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.giv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.giw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.gAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.giy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.gdk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgContentLength:").append(this.gAO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubScene:").append(this.gAP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowHitWord:").append(this.gAQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MatchTypeList:").append(this.gAR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MatchResult:").append(this.gAS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(212485);
    return localObject;
  }
  
  public final int getId()
  {
    return 20257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fm
 * JD-Core Version:    0.7.0.1
 */