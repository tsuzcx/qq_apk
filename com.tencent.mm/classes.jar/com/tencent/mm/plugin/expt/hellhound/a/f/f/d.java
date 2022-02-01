package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class d
  extends a
{
  private String dJv = "";
  private long dRy = 0L;
  private int dSD = 0;
  private long dSE = 0L;
  private long dSF = 0L;
  private String dSG = "";
  private int qqm = 0;
  
  private d(int paramInt)
  {
    this.qqm = paramInt;
  }
  
  public static boolean aO(int paramInt, String paramString)
  {
    AppMethodBeat.i(122222);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(122222);
      return false;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(122222);
      return false;
    }
    paramString = a.arA(paramString.replace(',', '#'));
    if (paramString != null)
    {
      d locald = new d(paramInt);
      locald.dSD = Process.myPid();
      locald.dJv = locald.t("PName", ((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName, true);
      locald.dRy = a.dyH();
      locald.dSF = paramString.size();
      paramInt = 0;
      while (paramInt < paramString.size())
      {
        locald.dSE = paramInt;
        locald.dSG = locald.t("DataContent", (String)paramString.get(paramInt), false);
        locald.aHZ();
        paramInt += 1;
      }
    }
    AppMethodBeat.o(122222);
    return true;
  }
  
  public final String PR()
  {
    AppMethodBeat.i(122223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSG);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(122223);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(122224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dSE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dSF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.dSG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(122224);
    return localObject;
  }
  
  public final int getId()
  {
    return this.qqm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.d
 * JD-Core Version:    0.7.0.1
 */