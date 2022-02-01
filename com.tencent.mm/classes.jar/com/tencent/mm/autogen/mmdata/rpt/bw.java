package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class bw
  extends a
{
  public int ipB;
  public long iqv;
  private String iqx;
  public long iuE;
  public int iuF;
  private String iuG;
  private String iuz;
  
  public bw()
  {
    this.iuz = "";
    this.iuG = "";
    this.iqx = "";
  }
  
  public bw(String paramString)
  {
    AppMethodBeat.i(108282);
    this.iuz = "";
    this.iuG = "";
    this.iqx = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 7) {
          break label150;
        }
        String[] arrayOfString = new String[7];
        Arrays.fill(arrayOfString, 0, 7, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label150:
    for (;;)
    {
      this.iuE = Util.getLong(paramString[0], 0L);
      this.iuF = Util.getInt(paramString[1], 0);
      this.ipB = Util.getInt(paramString[2], 0);
      lg(paramString[3]);
      lh(paramString[4]);
      li(paramString[5]);
      this.iqv = Util.getLong(paramString[6], 0L);
      AppMethodBeat.o(108282);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(108286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqv);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(108286);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(108287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.iuE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ipB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pid:").append(this.iuz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("info:").append(this.iuG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.iqx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("entrance_scene:").append(this.iqv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108287);
    return localObject;
  }
  
  public final int getId()
  {
    return 18662;
  }
  
  public final bw lg(String paramString)
  {
    AppMethodBeat.i(108283);
    this.iuz = F("pid", paramString, true);
    AppMethodBeat.o(108283);
    return this;
  }
  
  public final bw lh(String paramString)
  {
    AppMethodBeat.i(108284);
    this.iuG = F("info", paramString, true);
    AppMethodBeat.o(108284);
    return this;
  }
  
  public final bw li(String paramString)
  {
    AppMethodBeat.i(108285);
    this.iqx = F("index", paramString, true);
    AppMethodBeat.o(108285);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bw
 * JD-Core Version:    0.7.0.1
 */