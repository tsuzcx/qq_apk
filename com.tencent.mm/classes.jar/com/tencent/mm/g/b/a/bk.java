package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bk
  extends a
{
  private String eiB = "";
  private String err = "";
  private long erw;
  private String esB = "";
  private String esC = "";
  private String esD = "";
  private long esE;
  private long esF;
  private long esG;
  
  public final String abV()
  {
    AppMethodBeat.i(208883);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esG);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208883);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208884);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PosterUsername:").append(this.esB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ViewerUsername:").append(this.esC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MentionedUsername:").append(this.esD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("recommendtype:").append(this.esE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("likecnt:").append(this.esF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commcnt:").append(this.esG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208884);
    return localObject;
  }
  
  public final bk dL(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final bk dM(long paramLong)
  {
    this.esE = paramLong;
    return this;
  }
  
  public final bk dN(long paramLong)
  {
    this.esF = paramLong;
    return this;
  }
  
  public final bk dO(long paramLong)
  {
    this.esG = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19793;
  }
  
  public final bk jo(String paramString)
  {
    AppMethodBeat.i(208878);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(208878);
    return this;
  }
  
  public final bk jp(String paramString)
  {
    AppMethodBeat.i(208879);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(208879);
    return this;
  }
  
  public final bk jq(String paramString)
  {
    AppMethodBeat.i(208880);
    this.esB = x("PosterUsername", paramString, true);
    AppMethodBeat.o(208880);
    return this;
  }
  
  public final bk jr(String paramString)
  {
    AppMethodBeat.i(208881);
    this.esC = x("ViewerUsername", paramString, true);
    AppMethodBeat.o(208881);
    return this;
  }
  
  public final bk js(String paramString)
  {
    AppMethodBeat.i(208882);
    this.esD = x("MentionedUsername", paramString, true);
    AppMethodBeat.o(208882);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bk
 * JD-Core Version:    0.7.0.1
 */