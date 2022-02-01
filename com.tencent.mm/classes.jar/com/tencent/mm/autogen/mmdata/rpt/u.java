package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class u
  extends a
{
  public String imd = "";
  public long ime;
  public long imf;
  public long imh;
  public long imi;
  public long imj;
  public long imk;
  private long iml;
  public long imm;
  public long imn;
  public long imo;
  public long imp;
  public long imq;
  
  public final String aIE()
  {
    AppMethodBeat.i(368615);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ime);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iml);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368615);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368620);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.imd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.ime);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("background_status:").append(this.imf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_cnt:").append(this.imh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("brand_cnt:").append(this.imi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("file_cnt:").append(this.imj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("note_cnt:").append(this.imk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mpvideo_cnt:").append(this.iml);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finder_cnt:").append(this.imm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_cnt:").append(this.imn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myweapp_cnt:").append(this.imo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("music_cnt:").append(this.imp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.imq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368620);
    return localObject;
  }
  
  public final int getId()
  {
    return 21927;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.u
 * JD-Core Version:    0.7.0.1
 */