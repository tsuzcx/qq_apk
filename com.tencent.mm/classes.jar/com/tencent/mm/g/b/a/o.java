package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class o
  extends a
{
  public String ekH = "";
  public long ekI;
  public long ekJ;
  public long ekK;
  public long ekL;
  public long ekM;
  public long ekN;
  private long ekO;
  public long ekP;
  public long ekQ;
  
  public final String abV()
  {
    AppMethodBeat.i(238089);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ekH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekQ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(238089);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238090);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.ekH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.ekI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("background_status:").append(this.ekJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_cnt:").append(this.ekK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("brand_cnt:").append(this.ekL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("file_cnt:").append(this.ekM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("note_cnt:").append(this.ekN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mpvideo_cnt:").append(this.ekO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finder_cnt:").append(this.ekP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_cnt:").append(this.ekQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238090);
    return localObject;
  }
  
  public final int getId()
  {
    return 21927;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.o
 * JD-Core Version:    0.7.0.1
 */