package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ng
  extends a
{
  private long ekI;
  private String fgl = "";
  private long fgm;
  private long fgn;
  private long fgo;
  private String fgp = "";
  private String fgq = "";
  
  public final ng Aq(String paramString)
  {
    AppMethodBeat.i(226105);
    this.fgl = x("session", paramString, true);
    AppMethodBeat.o(226105);
    return this;
  }
  
  public final ng Ar(String paramString)
  {
    AppMethodBeat.i(226106);
    this.fgp = x("weapp_id", paramString, true);
    AppMethodBeat.o(226106);
    return this;
  }
  
  public final ng As(String paramString)
  {
    AppMethodBeat.i(226107);
    this.fgq = x("weapp_name", paramString, true);
    AppMethodBeat.o(226107);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(226108);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fgl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226108);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226109);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session:").append(this.fgl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.ekI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_type:").append(this.fgm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_sum:").append(this.fgn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_index:").append(this.fgo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_id:").append(this.fgp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_name:").append(this.fgq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226109);
    return localObject;
  }
  
  public final int getId()
  {
    return 21775;
  }
  
  public final ng xE(long paramLong)
  {
    this.ekI = paramLong;
    return this;
  }
  
  public final ng xF(long paramLong)
  {
    this.fgm = paramLong;
    return this;
  }
  
  public final ng xG(long paramLong)
  {
    this.fgn = paramLong;
    return this;
  }
  
  public final ng xH(long paramLong)
  {
    this.fgo = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ng
 * JD-Core Version:    0.7.0.1
 */