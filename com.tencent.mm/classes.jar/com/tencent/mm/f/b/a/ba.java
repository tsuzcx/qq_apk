package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ba
  extends a
{
  private String glA;
  private String glB;
  public long glw;
  public int glx;
  public int gly;
  private String glz;
  
  public ba()
  {
    this.glz = "";
    this.glA = "";
    this.glB = "";
  }
  
  public ba(String paramString)
  {
    AppMethodBeat.i(108282);
    this.glz = "";
    this.glA = "";
    this.glB = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 6) {
          break label138;
        }
        String[] arrayOfString = new String[6];
        Arrays.fill(arrayOfString, 0, 6, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label138:
    for (;;)
    {
      this.glw = Util.getLong(paramString[0], 0L);
      this.glx = Util.getInt(paramString[1], 0);
      this.gly = Util.getInt(paramString[2], 0);
      jy(paramString[3]);
      jz(paramString[4]);
      jA(paramString[5]);
      AppMethodBeat.o(108282);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(108286);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.glw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gly);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(108286);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(108287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.glw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.glx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.gly);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pid:").append(this.glz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("info:").append(this.glA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.glB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108287);
    return localObject;
  }
  
  public final int getId()
  {
    return 18662;
  }
  
  public final ba jA(String paramString)
  {
    AppMethodBeat.i(108285);
    this.glB = z("index", paramString, true);
    AppMethodBeat.o(108285);
    return this;
  }
  
  public final ba jy(String paramString)
  {
    AppMethodBeat.i(108283);
    this.glz = z("pid", paramString, true);
    AppMethodBeat.o(108283);
    return this;
  }
  
  public final ba jz(String paramString)
  {
    AppMethodBeat.i(108284);
    this.glA = z("info", paramString, true);
    AppMethodBeat.o(108284);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ba
 * JD-Core Version:    0.7.0.1
 */