package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class bv
  extends a
{
  public long dQj;
  public long dQk;
  public String dQl;
  public boolean dQm;
  
  public bv()
  {
    this.dQj = 0L;
    this.dQk = 0L;
    this.dQl = "";
  }
  
  public bv(String paramString)
  {
    AppMethodBeat.i(121765);
    this.dQj = 0L;
    this.dQk = 0L;
    this.dQl = "";
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
      this.dQj = bt.getLong(paramString[0], 0L);
      eY(bt.getLong(paramString[1], 0L));
      ix(paramString[2]);
      this.dQm = a.getBoolean(paramString[3]);
      AppMethodBeat.o(121765);
      return;
    }
  }
  
  private bv eY(long paramLong)
  {
    AppMethodBeat.i(121766);
    this.dQk = paramLong;
    super.bc("StartTimeStampSec", this.dQk);
    AppMethodBeat.o(121766);
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(121769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQl);
    ((StringBuffer)localObject).append(",");
    if (this.dQm) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(121769);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(121770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptFlag:").append(this.dQj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.dQk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Roomname:").append(this.dQl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hardcodeExptBool:").append(this.dQm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121770);
    return localObject;
  }
  
  public final bv Qz()
  {
    AppMethodBeat.i(121767);
    bv localbv = eY(bt.aGK());
    AppMethodBeat.o(121767);
    return localbv;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final bv ix(String paramString)
  {
    AppMethodBeat.i(121768);
    this.dQl = t("Roomname", paramString, true);
    AppMethodBeat.o(121768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bv
 * JD-Core Version:    0.7.0.1
 */