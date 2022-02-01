package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class ef
  extends a
{
  public long ejp;
  public long ejq;
  public String ejr;
  public boolean ejs;
  
  public ef()
  {
    this.ejp = 0L;
    this.ejq = 0L;
    this.ejr = "";
  }
  
  public ef(String paramString)
  {
    AppMethodBeat.i(121765);
    this.ejp = 0L;
    this.ejq = 0L;
    this.ejr = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 4) {
          break label117;
        }
        String[] arrayOfString = new String[4];
        Arrays.fill(arrayOfString, 0, 4, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label117:
    for (;;)
    {
      this.ejp = bu.getLong(paramString[0], 0L);
      kh(bu.getLong(paramString[1], 0L));
      nP(paramString[2]);
      this.ejs = a.getBoolean(paramString[3]);
      AppMethodBeat.o(121765);
      return;
    }
  }
  
  private ef kh(long paramLong)
  {
    AppMethodBeat.i(121766);
    this.ejq = paramLong;
    super.bi("StartTimeStampSec", this.ejq);
    AppMethodBeat.o(121766);
    return this;
  }
  
  public final String RC()
  {
    AppMethodBeat.i(121769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejr);
    ((StringBuffer)localObject).append(",");
    if (this.ejs) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(121769);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptFlag:").append(this.ejp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.ejq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Roomname:").append(this.ejr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hardcodeExptBool:").append(this.ejs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121770);
    return localObject;
  }
  
  public final ef To()
  {
    AppMethodBeat.i(121767);
    ef localef = kh(bu.aRi());
    AppMethodBeat.o(121767);
    return localef;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final ef nP(String paramString)
  {
    AppMethodBeat.i(121768);
    this.ejr = t("Roomname", paramString, true);
    AppMethodBeat.o(121768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ef
 * JD-Core Version:    0.7.0.1
 */