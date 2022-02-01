package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class c
  extends a
{
  public boolean ijs;
  public long ijt;
  public long iju;
  public String ijv;
  public long ijw;
  public long ijx;
  
  public c()
  {
    this.ijt = 0L;
    this.iju = 0L;
    this.ijv = "";
    this.ijw = 0L;
    this.ijx = 0L;
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(368719);
    this.ijt = 0L;
    this.iju = 0L;
    this.ijv = "";
    this.ijw = 0L;
    this.ijx = 0L;
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
      this.ijs = a.getBoolean(paramString[0]);
      ek(Util.getLong(paramString[1], 0L));
      this.iju = Util.getLong(paramString[2], 0L);
      jR(paramString[3]);
      this.ijw = Util.getLong(paramString[4], 0L);
      this.ijx = Util.getLong(paramString[5], 0L);
      AppMethodBeat.o(368719);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368738);
    Object localObject = new StringBuffer();
    if (this.ijs) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iju);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijx);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(368738);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NewMsgOpenWechatBool:").append(this.ijs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastEnterFinderTimeStampMs:").append(this.ijt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderStayTime:").append(this.iju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotTipsId:").append(this.ijv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotCtrlType:").append(this.ijw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotShowType:").append(this.ijx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368740);
    return localObject;
  }
  
  public final c ek(long paramLong)
  {
    AppMethodBeat.i(368730);
    this.ijt = paramLong;
    super.by("LastEnterFinderTimeStampMs", this.ijt);
    AppMethodBeat.o(368730);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final c jR(String paramString)
  {
    AppMethodBeat.i(368736);
    this.ijv = F("FinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(368736);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.c
 * JD-Core Version:    0.7.0.1
 */