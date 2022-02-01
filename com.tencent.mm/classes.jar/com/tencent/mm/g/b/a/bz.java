package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bz
  extends a
{
  private long dUY;
  private String dVa;
  private String dVb;
  private long dVd;
  private String dWX;
  private String eaL;
  private String eaM;
  private long eaN;
  private long eaO;
  private long eaP;
  
  public final String RD()
  {
    AppMethodBeat.i(209247);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209247);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dWX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PoiText:").append(this.eaL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FilterTextItems:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodtab:").append(this.eaN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodopen:").append(this.eaO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FliterPageType:").append(this.eaP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209248);
    return localObject;
  }
  
  public final bz gX(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final bz gY(long paramLong)
  {
    this.eaN = paramLong;
    return this;
  }
  
  public final bz gZ(long paramLong)
  {
    this.eaO = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19996;
  }
  
  public final bz ha(long paramLong)
  {
    this.eaP = paramLong;
    return this;
  }
  
  public final bz hb(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final bz kZ(String paramString)
  {
    AppMethodBeat.i(209242);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209242);
    return this;
  }
  
  public final bz la(String paramString)
  {
    AppMethodBeat.i(209243);
    this.dVb = t("Contextid", paramString, true);
    AppMethodBeat.o(209243);
    return this;
  }
  
  public final bz lb(String paramString)
  {
    AppMethodBeat.i(209244);
    this.dWX = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209244);
    return this;
  }
  
  public final bz lc(String paramString)
  {
    AppMethodBeat.i(209245);
    this.eaL = t("PoiText", paramString, true);
    AppMethodBeat.o(209245);
    return this;
  }
  
  public final bz ld(String paramString)
  {
    AppMethodBeat.i(209246);
    this.eaM = t("FilterTextItems", paramString, true);
    AppMethodBeat.o(209246);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bz
 * JD-Core Version:    0.7.0.1
 */