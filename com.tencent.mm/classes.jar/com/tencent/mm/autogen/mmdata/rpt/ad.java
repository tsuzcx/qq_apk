package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ad
  extends a
{
  public int imW;
  public int inj;
  public int ink;
  public int inl;
  public int inm;
  
  public ad()
  {
    this.imW = 0;
    this.inj = 0;
    this.ink = 0;
    this.inl = 0;
    this.inm = 0;
  }
  
  public ad(String paramString)
  {
    AppMethodBeat.i(368617);
    this.imW = 0;
    this.inj = 0;
    this.ink = 0;
    this.inl = 0;
    this.inm = 0;
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
      this.imW = Util.getInt(paramString[0], 0);
      this.inj = Util.getInt(paramString[1], 0);
      this.ink = Util.getInt(paramString[2], 0);
      this.inl = Util.getInt(paramString[3], 0);
      this.inm = Util.getInt(paramString[4], 0);
      AppMethodBeat.o(368617);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368626);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ink);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368626);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368633);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.inj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailedTime:").append(this.ink);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MergeSession:").append(this.inl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalSession:").append(this.inm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368633);
    return localObject;
  }
  
  public final int getId()
  {
    return 22772;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ad
 * JD-Core Version:    0.7.0.1
 */