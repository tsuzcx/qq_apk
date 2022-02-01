package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jn
  extends a
{
  private String gLe = "";
  private String gLf = "";
  private long gLg = 0L;
  private long gLh = 0L;
  private long gLi = 0L;
  private String gLj = "";
  private String gLk = "";
  private String gLl = "";
  private String gLm = "";
  private long gef = 0L;
  private String glu = "";
  private String glv = "";
  private long goe = 0L;
  private long gqZ = 0L;
  private long gto = 0L;
  
  public final jn AA(String paramString)
  {
    AppMethodBeat.i(104430);
    this.gLl = z("IsLocal2", paramString, true);
    AppMethodBeat.o(104430);
    return this;
  }
  
  public final jn AB(String paramString)
  {
    AppMethodBeat.i(224908);
    this.gLm = z("ChatID", paramString, true);
    AppMethodBeat.o(224908);
    return this;
  }
  
  public final jn Au(String paramString)
  {
    AppMethodBeat.i(104424);
    this.gLe = z("SourcePid", paramString, true);
    AppMethodBeat.o(104424);
    return this;
  }
  
  public final jn Av(String paramString)
  {
    AppMethodBeat.i(104425);
    this.gLf = z("SourceMd5", paramString, true);
    AppMethodBeat.o(104425);
    return this;
  }
  
  public final jn Aw(String paramString)
  {
    AppMethodBeat.i(104426);
    this.glu = z("Pid", paramString, true);
    AppMethodBeat.o(104426);
    return this;
  }
  
  public final jn Ax(String paramString)
  {
    AppMethodBeat.i(104427);
    this.glv = z("Md5", paramString, true);
    AppMethodBeat.o(104427);
    return this;
  }
  
  public final jn Ay(String paramString)
  {
    AppMethodBeat.i(104428);
    this.gLj = z("IsFree2", paramString, true);
    AppMethodBeat.o(104428);
    return this;
  }
  
  public final jn Az(String paramString)
  {
    AppMethodBeat.i(104429);
    this.gLk = z("Type2", paramString, true);
    AppMethodBeat.o(104429);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(104431);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gto);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLm);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(104431);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(104432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gto);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourcePid:").append(this.gLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceMd5:").append(this.gLf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.glu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.glv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.gqZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxRowCount:").append(this.gLg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree:").append(this.gLh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.gLi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree2:").append(this.gLj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type2:").append(this.gLk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal2:").append(this.gLl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatID:").append(this.gLm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(104432);
    return localObject;
  }
  
  public final jn amb()
  {
    this.gLg = 4L;
    return this;
  }
  
  public final String amc()
  {
    return this.gLj;
  }
  
  public final String amd()
  {
    return this.gLk;
  }
  
  public final String ame()
  {
    return this.gLl;
  }
  
  public final int getId()
  {
    return 18739;
  }
  
  public final String getMd5()
  {
    return this.glv;
  }
  
  public final String getPid()
  {
    return this.glu;
  }
  
  public final jn uu(long paramLong)
  {
    this.gto = paramLong;
    return this;
  }
  
  public final jn uv(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final jn uw(long paramLong)
  {
    this.gqZ = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jn
 * JD-Core Version:    0.7.0.1
 */