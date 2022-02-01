package com.tencent.mm.plugin.expt.hellhound.a.f.f;

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
  private long gKH = 0L;
  private int gMJ = 0;
  private long gMK = 0L;
  private long gML = 0L;
  private String gMM = "";
  private String gqC = "";
  private int woN = 0;
  
  private d(int paramInt)
  {
    this.woN = paramInt;
  }
  
  public static boolean aU(int paramInt, String paramString)
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
    paramString = a.aWX(paramString.replace(',', '#'));
    if (paramString != null)
    {
      d locald = new d(paramInt);
      locald.gMJ = Process.myPid();
      locald.gqC = locald.z("PName", ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName, true);
      locald.gKH = a.fBn();
      locald.gML = paramString.size();
      paramInt = 0;
      while (paramInt < paramString.size())
      {
        locald.gMK = paramInt;
        locald.gMM = locald.z("DataContent", (String)paramString.get(paramInt), false);
        locald.bpa();
        paramInt += 1;
      }
    }
    AppMethodBeat.o(122222);
    return true;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(122223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gMJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gML);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMM);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(122223);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(122224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.gMJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.gqC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.gKH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.gMK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.gML);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.gMM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(122224);
    return localObject;
  }
  
  public final int getId()
  {
    return this.woN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.d
 * JD-Core Version:    0.7.0.1
 */