package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ke
  extends a
{
  private String eOG = "";
  public long eTY;
  public long eTZ;
  private String eUa = "";
  public long eUb;
  public long eUc;
  public String eUd = "";
  public long enl;
  public String erU = "";
  
  public final String abV()
  {
    AppMethodBeat.i(201844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eTZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eUa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eUb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eUc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eUd);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(201844);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(201845);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.eOG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeCnt:").append(this.eTY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommCnt:").append(this.eTZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eUa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextAction:").append(this.eUb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCnt:").append(this.eUc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextPublishId:").append(this.eUd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(201845);
    return localObject;
  }
  
  public final int getId()
  {
    return 19750;
  }
  
  public final ke xl(String paramString)
  {
    AppMethodBeat.i(201841);
    this.eOG = x("PublishId", paramString, true);
    AppMethodBeat.o(201841);
    return this;
  }
  
  public final ke xm(String paramString)
  {
    AppMethodBeat.i(201842);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(201842);
    return this;
  }
  
  public final ke xn(String paramString)
  {
    AppMethodBeat.i(201843);
    this.eUa = x("ActionTimeStamp", paramString, true);
    AppMethodBeat.o(201843);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ke
 * JD-Core Version:    0.7.0.1
 */