package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class d
  extends a
{
  private long eLd = 0L;
  private int eMF = 0;
  private long eMG = 0L;
  private long eMH = 0L;
  private String eMI = "";
  private String euw = "";
  private int sIQ = 0;
  
  private d(int paramInt)
  {
    this.sIQ = paramInt;
  }
  
  public static boolean aV(int paramInt, String paramString)
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
    paramString = a.aMr(paramString.replace(',', '#'));
    if (paramString != null)
    {
      d locald = new d(paramInt);
      locald.eMF = Process.myPid();
      locald.euw = locald.x("PName", ((h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName, true);
      locald.eLd = a.eOr();
      locald.eMH = paramString.size();
      paramInt = 0;
      while (paramInt < paramString.size())
      {
        locald.eMG = paramInt;
        locald.eMI = locald.x("DataContent", (String)paramString.get(paramInt), false);
        locald.bfK();
        paramInt += 1;
      }
    }
    AppMethodBeat.o(122222);
    return true;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(122223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eMF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eMI);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(122223);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(122224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.eMF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.euw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.eLd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.eMG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.eMH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.eMI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(122224);
    return localObject;
  }
  
  public final int getId()
  {
    return this.sIQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.d
 * JD-Core Version:    0.7.0.1
 */