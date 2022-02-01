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
  private String dXm = "";
  private long egV = 0L;
  private int eij = 0;
  private long eik = 0L;
  private long eil = 0L;
  private String eim = "";
  private int qZo = 0;
  
  private d(int paramInt)
  {
    this.qZo = paramInt;
  }
  
  public static boolean aR(int paramInt, String paramString)
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
    paramString = a.awA(paramString.replace(',', '#'));
    if (paramString != null)
    {
      d locald = new d(paramInt);
      locald.eij = Process.myPid();
      locald.dXm = locald.t("PName", ((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName, true);
      locald.egV = a.dJZ();
      locald.eil = paramString.size();
      paramInt = 0;
      while (paramInt < paramString.size())
      {
        locald.eik = paramInt;
        locald.eim = locald.t("DataContent", (String)paramString.get(paramInt), false);
        locald.aLk();
        paramInt += 1;
      }
    }
    AppMethodBeat.o(122222);
    return true;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(122223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eij);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eik);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eil);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eim);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(122223);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(122224);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.eij);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.egV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.eik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.eil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.eim);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(122224);
    return localObject;
  }
  
  public final int getId()
  {
    return this.qZo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.d
 * JD-Core Version:    0.7.0.1
 */