package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class ae
  extends a
{
  public long cUc;
  public long cUd;
  public String cUe;
  public boolean cUf;
  
  public ae()
  {
    this.cUc = 0L;
    this.cUd = 0L;
    this.cUe = "";
  }
  
  public ae(String paramString)
  {
    AppMethodBeat.i(73303);
    this.cUc = 0L;
    this.cUd = 0L;
    this.cUe = "";
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
      this.cUc = bo.getLong(paramString[0], 0L);
      bz(bo.getLong(paramString[1], 0L));
      fz(paramString[2]);
      this.cUf = a.getBoolean(paramString[3]);
      AppMethodBeat.o(73303);
      return;
    }
  }
  
  private ae bz(long paramLong)
  {
    AppMethodBeat.i(73304);
    this.cUd = paramLong;
    super.aA("StartTimeStampSec", this.cUd);
    AppMethodBeat.o(73304);
    return this;
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(73307);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUe);
    ((StringBuffer)localObject).append(",");
    if (this.cUf) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(73307);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73308);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptFlag:").append(this.cUc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.cUd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Roomname:").append(this.cUe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hardcodeExptBool:").append(this.cUf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73308);
    return localObject;
  }
  
  public final ae Fm()
  {
    AppMethodBeat.i(73305);
    ae localae = bz(bo.aox());
    AppMethodBeat.o(73305);
    return localae;
  }
  
  public final ae fz(String paramString)
  {
    AppMethodBeat.i(73306);
    this.cUe = t("Roomname", paramString, true);
    AppMethodBeat.o(73306);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ae
 * JD-Core Version:    0.7.0.1
 */