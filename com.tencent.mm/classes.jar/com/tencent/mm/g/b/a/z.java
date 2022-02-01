package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class z
  extends a
{
  public long dUB;
  public int dUC;
  public int dUD;
  private String dUE;
  private String dUF;
  private String dUG;
  
  public z() {}
  
  public z(String paramString)
  {
    AppMethodBeat.i(108282);
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 6) {
          break label120;
        }
        String[] arrayOfString = new String[6];
        Arrays.fill(arrayOfString, 0, 6, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label120:
    for (;;)
    {
      this.dUB = bt.getLong(paramString[0], 0L);
      this.dUC = bt.getInt(paramString[1], 0);
      this.dUD = bt.getInt(paramString[2], 0);
      gU(paramString[3]);
      gV(paramString[4]);
      gW(paramString[5]);
      AppMethodBeat.o(108282);
      return;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(108286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUG);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(108286);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(108287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.dUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dUD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pid:").append(this.dUE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("info:").append(this.dUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.dUG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108287);
    return localObject;
  }
  
  public final z gU(String paramString)
  {
    AppMethodBeat.i(108283);
    this.dUE = t("pid", paramString, true);
    AppMethodBeat.o(108283);
    return this;
  }
  
  public final z gV(String paramString)
  {
    AppMethodBeat.i(108284);
    this.dUF = t("info", paramString, true);
    AppMethodBeat.o(108284);
    return this;
  }
  
  public final z gW(String paramString)
  {
    AppMethodBeat.i(108285);
    this.dUG = t("index", paramString, true);
    AppMethodBeat.o(108285);
    return this;
  }
  
  public final int getId()
  {
    return 18662;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.z
 * JD-Core Version:    0.7.0.1
 */