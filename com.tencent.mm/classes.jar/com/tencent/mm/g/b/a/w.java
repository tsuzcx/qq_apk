package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class w
  extends a
{
  public int dHA;
  private String dHB;
  private String dHC;
  private String dHD;
  public long dHy;
  public int dHz;
  
  public w() {}
  
  public w(String paramString)
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
      this.dHy = bs.getLong(paramString[0], 0L);
      this.dHz = bs.getInt(paramString[1], 0);
      this.dHA = bs.getInt(paramString[2], 0);
      fS(paramString[3]);
      fT(paramString[4]);
      fU(paramString[5]);
      AppMethodBeat.o(108282);
      return;
    }
  }
  
  public final String PR()
  {
    AppMethodBeat.i(108286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHD);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(108286);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(108287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.dHy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dHA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pid:").append(this.dHB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("info:").append(this.dHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.dHD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108287);
    return localObject;
  }
  
  public final w fS(String paramString)
  {
    AppMethodBeat.i(108283);
    this.dHB = t("pid", paramString, true);
    AppMethodBeat.o(108283);
    return this;
  }
  
  public final w fT(String paramString)
  {
    AppMethodBeat.i(108284);
    this.dHC = t("info", paramString, true);
    AppMethodBeat.o(108284);
    return this;
  }
  
  public final w fU(String paramString)
  {
    AppMethodBeat.i(108285);
    this.dHD = t("index", paramString, true);
    AppMethodBeat.o(108285);
    return this;
  }
  
  public final int getId()
  {
    return 18662;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.w
 * JD-Core Version:    0.7.0.1
 */