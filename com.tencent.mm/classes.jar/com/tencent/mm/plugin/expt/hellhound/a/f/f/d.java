package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class d
  extends a
{
  private String dYD = "";
  private long eiF = 0L;
  private int ejT = 0;
  private long ejU = 0L;
  private long ejV = 0L;
  private String ejW = "";
  private int rhu = 0;
  
  private d(int paramInt)
  {
    this.rhu = paramInt;
  }
  
  public static boolean aQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(122222);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(122222);
      return false;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(122222);
      return false;
    }
    paramString = a.axP(paramString.replace(',', '#'));
    if (paramString != null)
    {
      d locald = new d(paramInt);
      locald.ejT = Process.myPid();
      locald.dYD = locald.t("PName", ((h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName, true);
      locald.eiF = a.dNr();
      locald.ejV = paramString.size();
      paramInt = 0;
      while (paramInt < paramString.size())
      {
        locald.ejU = paramInt;
        locald.ejW = locald.t("DataContent", (String)paramString.get(paramInt), false);
        locald.aLH();
        paramInt += 1;
      }
    }
    AppMethodBeat.o(122222);
    return true;
  }
  
  public final String RC()
  {
    AppMethodBeat.i(122223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(122223);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(122224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.ejT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.eiF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.ejU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.ejV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.ejW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(122224);
    return localObject;
  }
  
  public final int getId()
  {
    return this.rhu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.d
 * JD-Core Version:    0.7.0.1
 */