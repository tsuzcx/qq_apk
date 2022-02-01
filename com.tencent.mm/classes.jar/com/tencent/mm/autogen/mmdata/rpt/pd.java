package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pd
  extends a
{
  public long iIf = 0L;
  public long jjn = 0L;
  public String jkB = "";
  public long jkC = 0L;
  public long jll = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(118522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jkB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jll);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118522);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118523);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StoryId:").append(this.jkB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.iIf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.jjn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.jkC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAlbumStarButton:").append(this.jll);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118523);
    return localObject;
  }
  
  public final int getId()
  {
    return 17090;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pd
 * JD-Core Version:    0.7.0.1
 */