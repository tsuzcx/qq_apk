package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class s
  extends a
{
  public long gfA;
  public long gfB;
  public long gfC;
  public long gfD;
  public long gfE;
  public long gfF;
  private long gfG;
  public long gfH;
  public long gfI;
  public long gfJ;
  public long gfK;
  public long gfL;
  public String gfz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(214782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(214782);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(214785);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("session_id:").append(this.gfz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.gfA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("background_status:").append(this.gfB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("weapp_cnt:").append(this.gfC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("brand_cnt:").append(this.gfD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("file_cnt:").append(this.gfE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("note_cnt:").append(this.gfF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mpvideo_cnt:").append(this.gfG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finder_cnt:").append(this.gfH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("live_cnt:").append(this.gfI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myweapp_cnt:").append(this.gfJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("music_cnt:").append(this.gfK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.gfL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(214785);
    return localObject;
  }
  
  public final int getId()
  {
    return 21927;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.s
 * JD-Core Version:    0.7.0.1
 */