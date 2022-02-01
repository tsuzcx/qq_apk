package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bz
  extends a
{
  private long dWo;
  private String dWq = "";
  private String dWr = "";
  private long dWt;
  private String dYp = "";
  private String ecg = "";
  private String ech = "";
  private long eci;
  private long ecj;
  private long eck;
  
  public final String RC()
  {
    AppMethodBeat.i(189282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ech);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eci);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eck);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189282);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PoiText:").append(this.ecg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FilterTextItems:").append(this.ech);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodtab:").append(this.eci);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodopen:").append(this.ecj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FliterPageType:").append(this.eck);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189283);
    return localObject;
  }
  
  public final int getId()
  {
    return 19996;
  }
  
  public final bz hc(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final bz hd(long paramLong)
  {
    this.eci = paramLong;
    return this;
  }
  
  public final bz he(long paramLong)
  {
    this.ecj = paramLong;
    return this;
  }
  
  public final bz hf(long paramLong)
  {
    this.eck = paramLong;
    return this;
  }
  
  public final bz hg(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final bz lm(String paramString)
  {
    AppMethodBeat.i(189277);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189277);
    return this;
  }
  
  public final bz ln(String paramString)
  {
    AppMethodBeat.i(189278);
    this.dWr = t("Contextid", paramString, true);
    AppMethodBeat.o(189278);
    return this;
  }
  
  public final bz lo(String paramString)
  {
    AppMethodBeat.i(189279);
    this.dYp = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(189279);
    return this;
  }
  
  public final bz lp(String paramString)
  {
    AppMethodBeat.i(189280);
    this.ecg = t("PoiText", paramString, true);
    AppMethodBeat.o(189280);
    return this;
  }
  
  public final bz lq(String paramString)
  {
    AppMethodBeat.i(189281);
    this.ech = t("FilterTextItems", paramString, true);
    AppMethodBeat.o(189281);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bz
 * JD-Core Version:    0.7.0.1
 */