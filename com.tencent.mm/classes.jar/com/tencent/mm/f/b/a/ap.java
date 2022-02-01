package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ap
  extends a
{
  public long geB;
  public long gjp;
  public long gjq;
  public long gjr;
  public long gjs;
  public long gjt;
  public long gju;
  public long gjv;
  
  public final String agH()
  {
    AppMethodBeat.i(271040);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjv);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(271040);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(271041);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("biz_type:").append(this.gjp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("auth_type:").append(this.gjq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selection_type:").append(this.gjr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selection_count:").append(this.gjs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selection_fri_count:").append(this.gjt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("origin_list_fri_count:").append(this.gju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("submit_fri_count:").append(this.gjv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(271041);
    return localObject;
  }
  
  public final int getId()
  {
    return 22666;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ap
 * JD-Core Version:    0.7.0.1
 */