package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class hl
  extends a
{
  public long eLY;
  public long eLZ;
  public String eMa;
  public boolean eMb;
  
  public hl()
  {
    this.eLY = 0L;
    this.eLZ = 0L;
    this.eMa = "";
  }
  
  public hl(String paramString)
  {
    AppMethodBeat.i(121765);
    this.eLY = 0L;
    this.eLZ = 0L;
    this.eMa = "";
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
      this.eLY = Util.getLong(paramString[0], 0L);
      qQ(Util.getLong(paramString[1], 0L));
      vi(paramString[2]);
      this.eMb = a.getBoolean(paramString[3]);
      AppMethodBeat.o(121765);
      return;
    }
  }
  
  private hl qQ(long paramLong)
  {
    AppMethodBeat.i(121766);
    this.eLZ = paramLong;
    super.bk("StartTimeStampSec", this.eLZ);
    AppMethodBeat.o(121766);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(121769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eLY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMa);
    ((StringBuffer)localObject).append(",");
    if (this.eMb) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(121769);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptFlag:").append(this.eLY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.eLZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Roomname:").append(this.eMa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hardcodeExptBool:").append(this.eMb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121770);
    return localObject;
  }
  
  public final hl agZ()
  {
    AppMethodBeat.i(121767);
    hl localhl = qQ(Util.nowSecond());
    AppMethodBeat.o(121767);
    return localhl;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final hl vi(String paramString)
  {
    AppMethodBeat.i(121768);
    this.eMa = x("Roomname", paramString, true);
    AppMethodBeat.o(121768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hl
 * JD-Core Version:    0.7.0.1
 */