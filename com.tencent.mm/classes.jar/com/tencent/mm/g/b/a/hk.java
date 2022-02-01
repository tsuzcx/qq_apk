package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hk
  extends a
{
  private int dHQ;
  private int dJu;
  private String dLe;
  private String dLh;
  private String dMw;
  private String dPs;
  private long dkQ;
  private long eii;
  private int hIL;
  private long hNd;
  private String hxU;
  private long iCq;
  private String iRQ;
  private String iRR;
  private int ilQ;
  private String iwy;
  
  public final String PV()
  {
    AppMethodBeat.i(203708);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dLh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hxU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hIL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hNd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eii);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203708);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203709);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedID:").append(this.dLh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dHQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionValue:").append(this.hxU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionCurrentVersion:").append(this.hIL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.hNd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.eii);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.dPs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.ilQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.iwy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("videoDurationTime:").append(this.iCq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dkQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.iRQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedContextId:").append(this.iRR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203709);
    return localObject;
  }
  
  public final hk YP(String paramString)
  {
    AppMethodBeat.i(203699);
    this.dLh = t("FeedID", paramString, true);
    AppMethodBeat.o(203699);
    return this;
  }
  
  public final hk YR(String paramString)
  {
    AppMethodBeat.i(203700);
    this.hxU = t("ActionValue", paramString, true);
    AppMethodBeat.o(203700);
    return this;
  }
  
  public final hk YS(String paramString)
  {
    AppMethodBeat.i(203702);
    this.dPs = t("sessionID", paramString, true);
    AppMethodBeat.o(203702);
    return this;
  }
  
  public final hk Za(String paramString)
  {
    AppMethodBeat.i(203703);
    this.iwy = t("sessionBuffer", paramString, true);
    AppMethodBeat.o(203703);
    return this;
  }
  
  public final hk Zd(String paramString)
  {
    AppMethodBeat.i(203704);
    this.iRQ = t("ClickFeedId", paramString, true);
    AppMethodBeat.o(203704);
    return this;
  }
  
  public final hk Ze(String paramString)
  {
    AppMethodBeat.i(203705);
    this.iRR = t("ClickFeedContextId", paramString, true);
    AppMethodBeat.o(203705);
    return this;
  }
  
  public final hk Zf(String paramString)
  {
    AppMethodBeat.i(203706);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203706);
    return this;
  }
  
  public final hk Zg(String paramString)
  {
    AppMethodBeat.i(203707);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(203707);
    return this;
  }
  
  public final hk ch(int paramInt)
  {
    this.dHQ = paramInt;
    return this;
  }
  
  public final int getId()
  {
    return 18054;
  }
  
  public final hk kI(int paramInt)
  {
    this.ilQ = paramInt;
    return this;
  }
  
  public final hk kg(int paramInt)
  {
    this.hIL = paramInt;
    return this;
  }
  
  public final hk yg(long paramLong)
  {
    AppMethodBeat.i(203701);
    this.eii = paramLong;
    super.bb("ActionTimeStampMs", this.eii);
    AppMethodBeat.o(203701);
    return this;
  }
  
  public final hk yh(long paramLong)
  {
    this.iCq = paramLong;
    return this;
  }
  
  public final hk yi(long paramLong)
  {
    this.dkQ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hk
 * JD-Core Version:    0.7.0.1
 */