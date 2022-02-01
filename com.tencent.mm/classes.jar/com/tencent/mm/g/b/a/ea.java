package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ea
  extends a
{
  private String eBY = "";
  private long eBZ;
  private long eCa;
  private String eCb = "";
  private long eCc;
  private long eCd;
  private String eCe = "";
  private long eCf;
  private long eCg;
  private long erW;
  private long evI;
  private String exd = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209210);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eBY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evI);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209210);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209211);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessinId:").append(this.eBY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationTimestamp:").append(this.eBZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShootEntranceEndType:").append(this.eCa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsFeedId:").append(this.exd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderFeedId:").append(this.eCb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HaveFinderUsername:").append(this.eCc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HavePostFinderVideo:").append(this.eCd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Wording:").append(this.eCe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntraceExposeMaxTimes:").append(this.eCf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntractExposeTimes:").append(this.eCg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeType:").append(this.evI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209211);
    return localObject;
  }
  
  public final long afk()
  {
    return this.eCc;
  }
  
  public final int getId()
  {
    return 20747;
  }
  
  public final ea lg(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final ea lh(long paramLong)
  {
    this.eBZ = paramLong;
    return this;
  }
  
  public final ea li(long paramLong)
  {
    this.eCa = paramLong;
    return this;
  }
  
  public final ea lj(long paramLong)
  {
    this.eCc = paramLong;
    return this;
  }
  
  public final ea lk(long paramLong)
  {
    this.eCd = paramLong;
    return this;
  }
  
  public final ea ll(long paramLong)
  {
    this.eCf = paramLong;
    return this;
  }
  
  public final ea lm(long paramLong)
  {
    this.eCg = paramLong;
    return this;
  }
  
  public final ea ln(long paramLong)
  {
    this.evI = paramLong;
    return this;
  }
  
  public final ea qm(String paramString)
  {
    AppMethodBeat.i(209206);
    this.eBY = x("SessinId", paramString, true);
    AppMethodBeat.o(209206);
    return this;
  }
  
  public final ea qn(String paramString)
  {
    AppMethodBeat.i(209207);
    this.exd = x("SnsFeedId", paramString, true);
    AppMethodBeat.o(209207);
    return this;
  }
  
  public final ea qo(String paramString)
  {
    AppMethodBeat.i(209208);
    this.eCb = x("FinderFeedId", paramString, true);
    AppMethodBeat.o(209208);
    return this;
  }
  
  public final ea qp(String paramString)
  {
    AppMethodBeat.i(209209);
    this.eCe = x("Wording", paramString, true);
    AppMethodBeat.o(209209);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ea
 * JD-Core Version:    0.7.0.1
 */