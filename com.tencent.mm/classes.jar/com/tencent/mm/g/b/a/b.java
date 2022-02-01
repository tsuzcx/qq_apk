package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class b
  extends a
{
  public boolean eiJ;
  public long eiK;
  public long eiL;
  public String eiM;
  public long eiN;
  public long eiO;
  
  public b()
  {
    this.eiK = 0L;
    this.eiL = 0L;
    this.eiM = "";
    this.eiN = 0L;
    this.eiO = 0L;
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(238823);
    this.eiK = 0L;
    this.eiL = 0L;
    this.eiM = "";
    this.eiN = 0L;
    this.eiO = 0L;
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
      this.eiJ = a.getBoolean(paramString[0]);
      bF(Util.getLong(paramString[1], 0L));
      this.eiL = Util.getLong(paramString[2], 0L);
      hF(paramString[3]);
      this.eiN = Util.getLong(paramString[4], 0L);
      this.eiO = Util.getLong(paramString[5], 0L);
      AppMethodBeat.o(238823);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(238826);
    Object localObject = new StringBuffer();
    if (this.eiJ) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiO);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(238826);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238827);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NewMsgOpenWechatBool:").append(this.eiJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastEnterFinderTimeStampMs:").append(this.eiK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderStayTime:").append(this.eiL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotTipsId:").append(this.eiM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotCtrlType:").append(this.eiN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotShowType:").append(this.eiO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238827);
    return localObject;
  }
  
  public final b bF(long paramLong)
  {
    AppMethodBeat.i(238824);
    this.eiK = paramLong;
    super.bj("LastEnterFinderTimeStampMs", this.eiK);
    AppMethodBeat.o(238824);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final b hF(String paramString)
  {
    AppMethodBeat.i(238825);
    this.eiM = x("FinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(238825);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.b
 * JD-Core Version:    0.7.0.1
 */