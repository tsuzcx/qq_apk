package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qg
  extends a
{
  private long hjv = 0L;
  public int hjw = -1;
  private long hjx = 0L;
  private String hjy = "";
  private int hjz = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(187010);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hjv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjz);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(187010);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(187011);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("host_id:").append(this.hjv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("steam_type:").append(this.hjw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("room_id:").append(this.hjx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stream_id:").append(this.hjy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stream_duration:").append(this.hjz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187011);
    return localObject;
  }
  
  public final int getId()
  {
    return 22049;
  }
  
  public final qg oZ(int paramInt)
  {
    this.hjw = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qg
 * JD-Core Version:    0.7.0.1
 */