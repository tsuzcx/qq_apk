package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class br
  extends a
{
  public int iui;
  public int iuj;
  public long iuk;
  public int iul;
  public int ium;
  public long iun;
  public int iuo;
  public int iup;
  
  public final String aIE()
  {
    AppMethodBeat.i(368834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iui);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iul);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ium);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iun);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iup);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368834);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368841);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("HitCacheCount:").append(this.iui);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessCount:").append(this.iuj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessCost:").append(this.iuk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessDecodeCount:").append(this.iul);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CacheHitPercent:").append(this.ium);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiVersion:").append(this.iun);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurEmojiCacheCount:").append(this.iuo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiTextCount:").append(this.iup);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368841);
    return localObject;
  }
  
  public final int getId()
  {
    return 23817;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.br
 * JD-Core Version:    0.7.0.1
 */