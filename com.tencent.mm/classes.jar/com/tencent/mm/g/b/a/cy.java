package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cy
  extends a
{
  private long emk;
  private long enl;
  private String etN = "";
  private String etO = "";
  private int etP;
  private String etQ = "";
  private long etR;
  private String ewV = "";
  private long ews;
  private String eyL = "";
  
  public final String abV()
  {
    AppMethodBeat.i(220180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ews);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewV);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220180);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220181);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrname:").append(this.etN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderWxAppInfo:").append(this.etO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPrivate:").append(this.etP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.etQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.etR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionJson:").append(this.eyL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceScene:").append(this.ews);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConnectCount:").append(this.emk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConnectDuration:").append(this.ewV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220181);
    return localObject;
  }
  
  public final String acG()
  {
    return this.etN;
  }
  
  public final String acH()
  {
    return this.etO;
  }
  
  public final int acI()
  {
    return this.etP;
  }
  
  public final String acJ()
  {
    return this.etQ;
  }
  
  public final long acK()
  {
    return this.etR;
  }
  
  public final long acL()
  {
    return this.enl;
  }
  
  public final long adn()
  {
    return this.ews;
  }
  
  public final String aeO()
  {
    return this.eyL;
  }
  
  public final int getId()
  {
    return 21017;
  }
  
  public final cy iC(long paramLong)
  {
    AppMethodBeat.i(220178);
    this.etR = paramLong;
    super.bi("ActionTimeMs", this.etR);
    AppMethodBeat.o(220178);
    return this;
  }
  
  public final cy iD(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final cy iE(long paramLong)
  {
    this.ews = paramLong;
    return this;
  }
  
  public final cy kA(int paramInt)
  {
    this.etP = paramInt;
    return this;
  }
  
  public final cy ob(String paramString)
  {
    AppMethodBeat.i(220175);
    this.etN = x("FinderUsrname", paramString, true);
    AppMethodBeat.o(220175);
    return this;
  }
  
  public final cy oc(String paramString)
  {
    AppMethodBeat.i(220176);
    this.etO = x("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(220176);
    return this;
  }
  
  public final cy od(String paramString)
  {
    AppMethodBeat.i(220177);
    this.etQ = x("FinderSessionId", paramString, true);
    AppMethodBeat.o(220177);
    return this;
  }
  
  public final cy oe(String paramString)
  {
    AppMethodBeat.i(220179);
    this.eyL = x("ActionJson", paramString, true);
    AppMethodBeat.o(220179);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cy
 * JD-Core Version:    0.7.0.1
 */