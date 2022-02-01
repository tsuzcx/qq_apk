package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cn
  extends a
{
  public long dTq = 0L;
  public long eei = 0L;
  public long eej = 0L;
  public long eek = 0L;
  public long eel = 0L;
  public long eem = 0L;
  private String een = "";
  public long eeo = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(149910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eei);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eej);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eek);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eel);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eem);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.een);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeo);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149910);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Content:").append(this.eei);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChangeAmountTimes:").append(this.eej);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonTimes:").append(this.eek);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddCustonEmoticonTimes:").append(this.eel);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddSelfieEmoticonFormBoardTimes:").append(this.eem);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmoticonMd5:").append(this.een);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddShopEmoticonTimes:").append(this.eeo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149911);
    return localObject;
  }
  
  public final int getId()
  {
    return 16724;
  }
  
  public final cn md(String paramString)
  {
    AppMethodBeat.i(149909);
    this.een = t("EmoticonMd5", paramString, true);
    AppMethodBeat.o(149909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cn
 * JD-Core Version:    0.7.0.1
 */