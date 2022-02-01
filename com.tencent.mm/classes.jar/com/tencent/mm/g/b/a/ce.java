package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ce
  extends a
{
  private String eiC = "";
  private String erU = "";
  private String erV = "";
  private String err = "";
  private long ery;
  private String evb = "";
  private long evc;
  private String evd = "";
  private long eve;
  private long evf;
  
  public final String abV()
  {
    AppMethodBeat.i(208984);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eve);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208984);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208985);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.erV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodUsername:").append(this.evb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodFeedCnt:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFlodFeedItems:").append(this.evd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoreTabClickTimestamp:").append(this.eve);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopTabClickTimestamp:").append(this.evf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208985);
    return localObject;
  }
  
  public final String ada()
  {
    return this.evd;
  }
  
  public final ce fF(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final ce fG(long paramLong)
  {
    this.evc = paramLong;
    return this;
  }
  
  public final ce fH(long paramLong)
  {
    this.eve = paramLong;
    return this;
  }
  
  public final ce fI(long paramLong)
  {
    this.evf = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20027;
  }
  
  public final ce ll(String paramString)
  {
    AppMethodBeat.i(208978);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(208978);
    return this;
  }
  
  public final ce lm(String paramString)
  {
    AppMethodBeat.i(208979);
    this.erV = x("Contextid", paramString, true);
    AppMethodBeat.o(208979);
    return this;
  }
  
  public final ce ln(String paramString)
  {
    AppMethodBeat.i(208980);
    this.eiC = x("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208980);
    return this;
  }
  
  public final ce lo(String paramString)
  {
    AppMethodBeat.i(208981);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(208981);
    return this;
  }
  
  public final ce lp(String paramString)
  {
    AppMethodBeat.i(208982);
    this.evb = x("FlodUsername", paramString, true);
    AppMethodBeat.o(208982);
    return this;
  }
  
  public final ce lq(String paramString)
  {
    AppMethodBeat.i(208983);
    this.evd = x("AllFlodFeedItems", paramString, true);
    AppMethodBeat.o(208983);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ce
 * JD-Core Version:    0.7.0.1
 */