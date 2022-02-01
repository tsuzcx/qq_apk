package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class np
  extends a
{
  public long gZP = 0L;
  public long gZQ = 0L;
  private String gZR = "";
  public long gZS = 0L;
  private String gZT = "";
  private String gZU = "";
  public long gef = 0L;
  private String gjO = "";
  private String glD = "";
  public long gqh = 0L;
  
  public final np EA(String paramString)
  {
    AppMethodBeat.i(211621);
    this.glD = z("FeedID", paramString, true);
    AppMethodBeat.o(211621);
    return this;
  }
  
  public final np EB(String paramString)
  {
    AppMethodBeat.i(211622);
    this.gZT = z("CreatedCommentID", paramString, true);
    AppMethodBeat.o(211622);
    return this;
  }
  
  public final np EC(String paramString)
  {
    AppMethodBeat.i(211623);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(211623);
    return this;
  }
  
  public final np ED(String paramString)
  {
    AppMethodBeat.i(211625);
    this.gZU = z("QueryKey", paramString, true);
    AppMethodBeat.o(211625);
    return this;
  }
  
  public final np Ez(String paramString)
  {
    AppMethodBeat.i(211620);
    this.gZR = z("FeedAuthorUsername", paramString, true);
    AppMethodBeat.o(211620);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(211627);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gZP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqh);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(211627);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(211628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionScene:").append(this.gZP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSource:").append(this.gZQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorUsername:").append(this.gZR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedID:").append(this.glD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedAuthorType:").append(this.gZS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatedCommentID:").append(this.gZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.gZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.gqh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211628);
    return localObject;
  }
  
  public final int getId()
  {
    return 21192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.np
 * JD-Core Version:    0.7.0.1
 */