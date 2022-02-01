package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class c
  extends a
{
  public boolean gdc;
  public long gdd;
  public long gde;
  public String gdf;
  public long gdg;
  public long gdh;
  
  public c()
  {
    this.gdd = 0L;
    this.gde = 0L;
    this.gdf = "";
    this.gdg = 0L;
    this.gdh = 0L;
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(239971);
    this.gdd = 0L;
    this.gde = 0L;
    this.gdf = "";
    this.gdg = 0L;
    this.gdh = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 6) {
          break label152;
        }
        String[] arrayOfString = new String[6];
        Arrays.fill(arrayOfString, 0, 6, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label152:
    for (;;)
    {
      this.gdc = a.getBoolean(paramString[0]);
      bU(Util.getLong(paramString[1], 0L));
      this.gde = Util.getLong(paramString[2], 0L);
      iv(paramString[3]);
      this.gdg = Util.getLong(paramString[4], 0L);
      this.gdh = Util.getLong(paramString[5], 0L);
      AppMethodBeat.o(239971);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(239977);
    Object localObject = new StringBuffer();
    if (this.gdc) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gde);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdh);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(239977);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(239980);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NewMsgOpenWechatBool:").append(this.gdc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastEnterFinderTimeStampMs:").append(this.gdd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderStayTime:").append(this.gde);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotTipsId:").append(this.gdf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotCtrlType:").append(this.gdg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotShowType:").append(this.gdh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(239980);
    return localObject;
  }
  
  public final c bU(long paramLong)
  {
    AppMethodBeat.i(239973);
    this.gdd = paramLong;
    super.bm("LastEnterFinderTimeStampMs", this.gdd);
    AppMethodBeat.o(239973);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final c iv(String paramString)
  {
    AppMethodBeat.i(239975);
    this.gdf = z("FinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(239975);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.c
 * JD-Core Version:    0.7.0.1
 */