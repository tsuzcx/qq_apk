package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class u
  extends a
{
  private String dJA;
  private String dJB;
  public long dJw;
  public int dJx;
  public int dJy;
  private String dJz;
  
  public u() {}
  
  public u(String paramString)
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
      this.dJw = bt.getLong(paramString[0], 0L);
      this.dJx = bt.getInt(paramString[1], 0);
      this.dJy = bt.getInt(paramString[2], 0);
      gb(paramString[3]);
      gc(paramString[4]);
      gd(paramString[5]);
      AppMethodBeat.o(108282);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(108286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJB);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(108286);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(108287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.dJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dJy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pid:").append(this.dJz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("info:").append(this.dJA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.dJB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108287);
    return localObject;
  }
  
  public final u gb(String paramString)
  {
    AppMethodBeat.i(108283);
    this.dJz = t("pid", paramString, true);
    AppMethodBeat.o(108283);
    return this;
  }
  
  public final u gc(String paramString)
  {
    AppMethodBeat.i(108284);
    this.dJA = t("info", paramString, true);
    AppMethodBeat.o(108284);
    return this;
  }
  
  public final u gd(String paramString)
  {
    AppMethodBeat.i(108285);
    this.dJB = t("index", paramString, true);
    AppMethodBeat.o(108285);
    return this;
  }
  
  public final int getId()
  {
    return 18662;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.u
 * JD-Core Version:    0.7.0.1
 */