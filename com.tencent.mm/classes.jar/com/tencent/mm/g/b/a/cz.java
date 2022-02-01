package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cz
  extends a
{
  private long dQX;
  private long eeT;
  private String eeu = "";
  private long eev;
  private long eew;
  private long efi = 0L;
  private long efj;
  private long efk;
  private String efl = "";
  private String efm = "";
  private long efn;
  
  public final String RC()
  {
    AppMethodBeat.i(215527);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eew);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efn);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215527);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215528);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.efi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.eeT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionResult:").append(this.efj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.efk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUserName:").append(this.efl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("anchorusername:").append(this.efm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audiencecount:").append(this.efn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215528);
    return localObject;
  }
  
  public final int getId()
  {
    return 19893;
  }
  
  public final cz ja(long paramLong)
  {
    this.eev = paramLong;
    return this;
  }
  
  public final cz jb(long paramLong)
  {
    this.eeT = paramLong;
    return this;
  }
  
  public final cz jc(long paramLong)
  {
    this.eew = paramLong;
    return this;
  }
  
  public final cz jd(long paramLong)
  {
    this.dQX = paramLong;
    return this;
  }
  
  public final cz je(long paramLong)
  {
    this.efj = paramLong;
    return this;
  }
  
  public final cz jf(long paramLong)
  {
    this.efk = paramLong;
    return this;
  }
  
  public final cz jg(long paramLong)
  {
    this.efn = paramLong;
    return this;
  }
  
  public final cz mx(String paramString)
  {
    AppMethodBeat.i(215524);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215524);
    return this;
  }
  
  public final cz my(String paramString)
  {
    AppMethodBeat.i(215525);
    this.efl = t("audienceUserName", paramString, true);
    AppMethodBeat.o(215525);
    return this;
  }
  
  public final cz mz(String paramString)
  {
    AppMethodBeat.i(215526);
    this.efm = t("anchorusername", paramString, true);
    AppMethodBeat.o(215526);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cz
 * JD-Core Version:    0.7.0.1
 */