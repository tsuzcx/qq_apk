package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cp
  extends a
{
  private String dTr = "";
  private long eep = 0L;
  private long eeq = 0L;
  private long eer = 0L;
  private long ees = 0L;
  private long eet = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(186325);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eep);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eer);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ees);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eet);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(186325);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(186326);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenPictureTime:").append(this.eep);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenPictureType:").append(this.eeq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeIconTime:").append(this.eer);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PictureConcluding:").append(this.ees);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconType:").append(this.eet);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186326);
    return localObject;
  }
  
  public final long SR()
  {
    return this.eep;
  }
  
  public final long SS()
  {
    return this.eer;
  }
  
  public final long ST()
  {
    return this.eet;
  }
  
  public final int getId()
  {
    return 19776;
  }
  
  public final String getSessionId()
  {
    return this.dTr;
  }
  
  public final cp ie(long paramLong)
  {
    this.eep = paramLong;
    return this;
  }
  
  public final cp jdMethod_if(long paramLong)
  {
    this.eeq = paramLong;
    return this;
  }
  
  public final cp ig(long paramLong)
  {
    this.eer = paramLong;
    return this;
  }
  
  public final cp ih(long paramLong)
  {
    this.ees = paramLong;
    return this;
  }
  
  public final cp ii(long paramLong)
  {
    this.eet = paramLong;
    return this;
  }
  
  public final cp mg(String paramString)
  {
    AppMethodBeat.i(186324);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(186324);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cp
 * JD-Core Version:    0.7.0.1
 */