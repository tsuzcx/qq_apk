package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ah
  extends a
{
  public long iob;
  public long ioc;
  public long iod;
  public long ioe;
  public long iof;
  
  public ah()
  {
    this.iob = 0L;
    this.ioc = 0L;
    this.iod = 0L;
    this.ioe = 0L;
    this.iof = 0L;
  }
  
  public ah(String paramString)
  {
    AppMethodBeat.i(368576);
    this.iob = 0L;
    this.ioc = 0L;
    this.iod = 0L;
    this.ioe = 0L;
    this.iof = 0L;
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
      this.iob = Util.getLong(paramString[0], 0L);
      this.ioc = Util.getLong(paramString[1], 0L);
      this.iod = Util.getLong(paramString[2], 0L);
      this.ioe = Util.getLong(paramString[3], 0L);
      this.iof = Util.getLong(paramString[4], 0L);
      AppMethodBeat.o(368576);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368586);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iob);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iod);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iof);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368586);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368595);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ds:").append(this.iob);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderSyncCount:").append(this.ioc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveSyncCount:").append(this.iod);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mixSyncCount:").append(this.ioe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalSync:").append(this.iof);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368595);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ah
 * JD-Core Version:    0.7.0.1
 */