package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class z
  extends a
{
  public int ggl;
  public int ggm;
  public int ggn;
  public int ggo;
  public int ggp;
  
  public z()
  {
    this.ggl = 0;
    this.ggm = 0;
    this.ggn = 0;
    this.ggo = 0;
    this.ggp = 0;
  }
  
  public z(String paramString)
  {
    AppMethodBeat.i(280998);
    this.ggl = 0;
    this.ggm = 0;
    this.ggn = 0;
    this.ggo = 0;
    this.ggp = 0;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 5) {
          break label140;
        }
        String[] arrayOfString = new String[5];
        Arrays.fill(arrayOfString, 0, 5, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label140:
    for (;;)
    {
      this.ggl = Util.getInt(paramString[0], 0);
      this.ggm = Util.getInt(paramString[1], 0);
      this.ggn = Util.getInt(paramString[2], 0);
      this.ggo = Util.getInt(paramString[3], 0);
      this.ggp = Util.getInt(paramString[4], 0);
      AppMethodBeat.o(280998);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(281002);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggp);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(281002);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(281004);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.ggm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailedTime:").append(this.ggn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MergeSession:").append(this.ggo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalSession:").append(this.ggp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(281004);
    return localObject;
  }
  
  public final int getId()
  {
    return 22772;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.z
 * JD-Core Version:    0.7.0.1
 */