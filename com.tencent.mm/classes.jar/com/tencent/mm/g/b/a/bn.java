package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bn
  extends a
{
  private String eiB = "";
  private String eoz = "";
  private String erH = "";
  private long erW;
  private String err = "";
  private long ers;
  private long ert;
  private long eru;
  private String esK = "";
  private String esL = "";
  private int etc;
  private long etd;
  
  public final String abV()
  {
    AppMethodBeat.i(184145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ers);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ert);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184145);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184146);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickUI:").append(this.esK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.esL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.ers);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.ert);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAll:").append(this.etc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreenCommentsArea:").append(this.etd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184146);
    return localObject;
  }
  
  public final bn eh(long paramLong)
  {
    this.ers = paramLong;
    return this;
  }
  
  public final bn ei(long paramLong)
  {
    this.ert = paramLong;
    return this;
  }
  
  public final bn ej(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final bn ek(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final bn el(long paramLong)
  {
    this.etd = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19017;
  }
  
  public final bn jF(String paramString)
  {
    AppMethodBeat.i(184141);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(184141);
    return this;
  }
  
  public final bn jG(String paramString)
  {
    AppMethodBeat.i(184142);
    this.esK = x("ClickUI", paramString, true);
    AppMethodBeat.o(184142);
    return this;
  }
  
  public final bn jH(String paramString)
  {
    AppMethodBeat.i(184143);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(184143);
    return this;
  }
  
  public final bn jI(String paramString)
  {
    AppMethodBeat.i(184144);
    this.esL = x("FeedUsr", paramString, true);
    AppMethodBeat.o(184144);
    return this;
  }
  
  public final bn jJ(String paramString)
  {
    AppMethodBeat.i(208892);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(208892);
    return this;
  }
  
  public final bn jK(String paramString)
  {
    AppMethodBeat.i(208893);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(208893);
    return this;
  }
  
  public final bn jW(int paramInt)
  {
    this.etc = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bn
 * JD-Core Version:    0.7.0.1
 */