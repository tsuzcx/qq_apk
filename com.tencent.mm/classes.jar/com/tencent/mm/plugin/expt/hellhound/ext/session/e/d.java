package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class d
  extends a
{
  private String iAp = "";
  private long iZX = 0L;
  private int jcB = 0;
  private long jcC = 0L;
  private long jcD = 0L;
  private String jcE = "";
  private int zKS = 0;
  
  private d(int paramInt)
  {
    this.zKS = paramInt;
  }
  
  public static boolean bo(int paramInt, String paramString)
  {
    AppMethodBeat.i(122222);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(122222);
      return false;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(122222);
      return false;
    }
    paramString = a.aUn(paramString.replace(',', '#'));
    if (paramString != null)
    {
      d locald = new d(paramInt);
      locald.jcB = Process.myPid();
      locald.iAp = locald.F("PName", ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName, true);
      locald.iZX = a.gNH();
      locald.jcD = paramString.size();
      paramInt = 0;
      while (paramInt < paramString.size())
      {
        locald.jcC = paramInt;
        locald.jcE = locald.F("DataContent", (String)paramString.get(paramInt), false);
        locald.bMH();
        paramInt += 1;
      }
    }
    AppMethodBeat.o(122222);
    return true;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(122223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jcB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcE);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(122223);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(122224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.jcB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.iAp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.iZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.jcC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.jcD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.jcE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(122224);
    return localObject;
  }
  
  public final int getId()
  {
    return this.zKS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.d
 * JD-Core Version:    0.7.0.1
 */