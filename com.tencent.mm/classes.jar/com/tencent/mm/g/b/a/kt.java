package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kt
  extends a
{
  public long eXk = 0L;
  public long eXl = 0L;
  private String eXm = "";
  public long eXn = 0L;
  private String eXo = "";
  private String eXp = "";
  public long ejA = 0L;
  private String eoC = "";
  private String erD = "";
  public long eua = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(187800);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eXk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eua);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187800);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187801);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionScene:").append(this.eXk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSource:").append(this.eXl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorUsername:").append(this.eXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.erD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorType:").append(this.eXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatedCommentID:").append(this.eXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eoC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.eXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eua);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187801);
    return localObject;
  }
  
  public final int getId()
  {
    return 21192;
  }
  
  public final kt yh(String paramString)
  {
    AppMethodBeat.i(187795);
    this.eXm = x("FeedAuthorUsername", paramString, true);
    AppMethodBeat.o(187795);
    return this;
  }
  
  public final kt yi(String paramString)
  {
    AppMethodBeat.i(187796);
    this.erD = x("FeedID", paramString, true);
    AppMethodBeat.o(187796);
    return this;
  }
  
  public final kt yj(String paramString)
  {
    AppMethodBeat.i(187797);
    this.eXo = x("CreatedCommentID", paramString, true);
    AppMethodBeat.o(187797);
    return this;
  }
  
  public final kt yk(String paramString)
  {
    AppMethodBeat.i(187798);
    this.eoC = x("SessionID", paramString, true);
    AppMethodBeat.o(187798);
    return this;
  }
  
  public final kt yl(String paramString)
  {
    AppMethodBeat.i(187799);
    this.eXp = x("QueryKey", paramString, true);
    AppMethodBeat.o(187799);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kt
 * JD-Core Version:    0.7.0.1
 */