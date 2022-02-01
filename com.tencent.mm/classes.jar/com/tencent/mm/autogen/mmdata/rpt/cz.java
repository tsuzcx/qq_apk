package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cz
  extends a
{
  public String ijk = "";
  public long iuA;
  public String ivZ = "";
  public String iyj = "";
  public String iyk = "";
  public String iyl = "";
  public long iym;
  public long iyn;
  public long iyo;
  
  public final String aIE()
  {
    AppMethodBeat.i(368105);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iym);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368105);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368111);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PosterUsername:").append(this.iyj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ViewerUsername:").append(this.iyk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MentionedUsername:").append(this.iyl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("recommendtype:").append(this.iym);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("likecnt:").append(this.iyn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commcnt:").append(this.iyo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368111);
    return localObject;
  }
  
  public final int getId()
  {
    return 19793;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cz
 * JD-Core Version:    0.7.0.1
 */