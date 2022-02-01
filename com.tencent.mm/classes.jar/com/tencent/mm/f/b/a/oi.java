package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oi
  extends a
{
  private String gcU = "";
  private int ggl;
  private String gjj = "";
  private String gqm = "";
  private long hbr;
  private long hbs;
  private String hbt = "";
  private String hbu = "";
  private int hbv;
  private int hbw;
  private String hbx = "";
  private String hby = "";
  private int hbz;
  
  public final oi AK(long paramLong)
  {
    AppMethodBeat.i(252621);
    this.hbr = paramLong;
    super.bk("UpdataTimeMs", this.hbr);
    AppMethodBeat.o(252621);
    return this;
  }
  
  public final oi AL(long paramLong)
  {
    AppMethodBeat.i(252626);
    this.hbs = paramLong;
    super.bk("ClickTimeMs", this.hbs);
    AppMethodBeat.o(252626);
    return this;
  }
  
  public final oi Fh(String paramString)
  {
    AppMethodBeat.i(252613);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(252613);
    return this;
  }
  
  public final oi Fi(String paramString)
  {
    AppMethodBeat.i(252615);
    this.gqm = z("ClickFeedId", paramString, true);
    AppMethodBeat.o(252615);
    return this;
  }
  
  public final oi Fj(String paramString)
  {
    AppMethodBeat.i(252629);
    this.hbt = z("ItemExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(252629);
    return this;
  }
  
  public final oi Fk(String paramString)
  {
    AppMethodBeat.i(252630);
    this.hbu = z("ScreenExposureAreaWeigth", paramString, true);
    AppMethodBeat.o(252630);
    return this;
  }
  
  public final oi Fl(String paramString)
  {
    AppMethodBeat.i(252631);
    this.hbx = z("ShotScreenJson", paramString, true);
    AppMethodBeat.o(252631);
    return this;
  }
  
  public final oi Fm(String paramString)
  {
    AppMethodBeat.i(252632);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(252632);
    return this;
  }
  
  public final oi Fn(String paramString)
  {
    AppMethodBeat.i(252633);
    this.hby = z("ItemBufffer", paramString, true);
    AppMethodBeat.o(252633);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(252634);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hby);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbz);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(252634);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(252637);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.gqm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdataTimeMs:").append(this.hbr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeMs:").append(this.hbs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemExposureAreaWeigth:").append(this.hbt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenExposureAreaWeigth:").append(this.hbu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemDirection:").append(this.hbv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemIndex:").append(this.hbw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShotScreenJson:").append(this.hbx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemBufffer:").append(this.hby);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemArrayIndex:").append(this.hbz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(252637);
    return localObject;
  }
  
  public final String agX()
  {
    return this.gjj;
  }
  
  public final String aog()
  {
    return this.gqm;
  }
  
  public final long aoh()
  {
    return this.hbr;
  }
  
  public final long aoi()
  {
    return this.hbs;
  }
  
  public final String aoj()
  {
    return this.hbt;
  }
  
  public final String aok()
  {
    return this.hbu;
  }
  
  public final int aol()
  {
    return this.hbv;
  }
  
  public final int aom()
  {
    return this.hbw;
  }
  
  public final String aon()
  {
    return this.hbx;
  }
  
  public final String aoo()
  {
    return this.hby;
  }
  
  public final int aop()
  {
    return this.hbz;
  }
  
  public final int getId()
  {
    return 19945;
  }
  
  public final int getScene()
  {
    return this.ggl;
  }
  
  public final String getSessionId()
  {
    return this.gcU;
  }
  
  public final oi oe(int paramInt)
  {
    this.ggl = paramInt;
    return this;
  }
  
  public final oi of(int paramInt)
  {
    this.hbv = paramInt;
    return this;
  }
  
  public final oi og(int paramInt)
  {
    this.hbw = paramInt;
    return this;
  }
  
  public final oi oh(int paramInt)
  {
    this.hbz = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oi
 * JD-Core Version:    0.7.0.1
 */