package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  public long cOc = 0L;
  public int cOd = 0;
  public long cOe = 0L;
  private int cOf = 0;
  private String cOg = "";
  private String cOh = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(56593);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cOc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cOh);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(56593);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(56594);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.cOc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_result:").append(this.cOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_code:").append(this.cOe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session:").append(this.cOf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_ext:").append(this.cOg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session2:").append(this.cOh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(56594);
    return localObject;
  }
  
  public final a eO(String paramString)
  {
    AppMethodBeat.i(56592);
    this.cOh = t("session2", paramString, true);
    AppMethodBeat.o(56592);
    return this;
  }
  
  public final int getId()
  {
    return 15894;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.a
 * JD-Core Version:    0.7.0.1
 */