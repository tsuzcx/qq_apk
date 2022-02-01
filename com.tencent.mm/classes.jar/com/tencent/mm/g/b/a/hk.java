package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hk
  extends a
{
  public long eLQ;
  public long eLR;
  private String eLS = "";
  private String eLT = "";
  private String eLU = "";
  public int eLV;
  public int eLW;
  public int eLX;
  public int enq;
  private String eoK = "";
  
  public final String abV()
  {
    AppMethodBeat.i(206903);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(206903);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(206904);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatTime:").append(this.eLQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeTime:").append(this.eLR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.eoK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PattedUserName:").append(this.eLS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PatSuffix:").append(this.eLT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomName:").append(this.eLU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeMethod:").append(this.eLV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.eLW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeAction:").append(this.eLX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(206904);
    return localObject;
  }
  
  public final int getId()
  {
    return 20590;
  }
  
  public final hk ve(String paramString)
  {
    AppMethodBeat.i(206899);
    this.eoK = x("UserName", paramString, true);
    AppMethodBeat.o(206899);
    return this;
  }
  
  public final hk vf(String paramString)
  {
    AppMethodBeat.i(206900);
    this.eLS = x("PattedUserName", paramString, true);
    AppMethodBeat.o(206900);
    return this;
  }
  
  public final hk vg(String paramString)
  {
    AppMethodBeat.i(206901);
    this.eLT = x("PatSuffix", paramString, true);
    AppMethodBeat.o(206901);
    return this;
  }
  
  public final hk vh(String paramString)
  {
    AppMethodBeat.i(206902);
    this.eLU = x("ChatRoomName", paramString, true);
    AppMethodBeat.o(206902);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hk
 * JD-Core Version:    0.7.0.1
 */