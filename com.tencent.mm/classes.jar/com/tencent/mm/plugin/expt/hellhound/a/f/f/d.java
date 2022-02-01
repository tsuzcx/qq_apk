package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class d
  extends a
{
  private String dKv = "";
  private long dPH = 0L;
  private int dQO = 0;
  private long dQP = 0L;
  private long dQQ = 0L;
  private String dQR = "";
  private int pHF = 0;
  
  private d(int paramInt)
  {
    this.pHF = paramInt;
  }
  
  public static boolean aL(int paramInt, String paramString)
  {
    AppMethodBeat.i(122222);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(122222);
      return false;
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(122222);
      return false;
    }
    paramString = a.amt(paramString.replace(',', '#'));
    if (paramString != null)
    {
      d locald = new d(paramInt);
      locald.dQO = Process.myPid();
      locald.dKv = locald.t("PName", ((h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName, true);
      locald.dPH = a.dkE();
      locald.dQQ = paramString.size();
      paramInt = 0;
      while (paramInt < paramString.size())
      {
        locald.dQP = paramInt;
        locald.dQR = locald.t("DataContent", (String)paramString.get(paramInt), false);
        locald.aBj();
        paramInt += 1;
      }
    }
    AppMethodBeat.o(122222);
    return true;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(122223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQR);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(122223);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(122224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.dQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dKv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.dQR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(122224);
    return localObject;
  }
  
  public final int getId()
  {
    return this.pHF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.d
 * JD-Core Version:    0.7.0.1
 */