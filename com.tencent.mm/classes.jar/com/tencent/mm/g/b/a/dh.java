package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dh
  extends a
{
  private String eiB = "";
  private String err = "";
  private String ezO = "";
  private String ezP = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209115);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezP);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209115);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209116);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostUsername:").append(this.ezO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mentionedDetailInfo:").append(this.ezP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209116);
    return localObject;
  }
  
  public final int getId()
  {
    return 19792;
  }
  
  public final dh oC(String paramString)
  {
    AppMethodBeat.i(209111);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(209111);
    return this;
  }
  
  public final dh oD(String paramString)
  {
    AppMethodBeat.i(209112);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209112);
    return this;
  }
  
  public final dh oE(String paramString)
  {
    AppMethodBeat.i(209113);
    this.ezO = x("PostUsername", paramString, true);
    AppMethodBeat.o(209113);
    return this;
  }
  
  public final dh oF(String paramString)
  {
    AppMethodBeat.i(209114);
    this.ezP = x("mentionedDetailInfo", paramString, true);
    AppMethodBeat.o(209114);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dh
 * JD-Core Version:    0.7.0.1
 */