package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b
{
  public String appId = "";
  public int dCS = 0;
  public boolean dtU = true;
  public String dtX = "";
  public String dvn = "";
  public int dvv = 0;
  public String filePath = "";
  public long fileSize = 0L;
  public int fromScene = 0;
  public int iJD = 0;
  public boolean iJE = false;
  public long iJF = 0L;
  public double iJG = 1.0D;
  public double iJH = 1.0D;
  public long iJI = 0L;
  public long iJJ = 0L;
  public long iJK = 0L;
  public long iJL = 0L;
  public long iJM = 0L;
  public long iJN = 0L;
  public long iJO = 0L;
  public String iJP = null;
  public String iJQ = null;
  public e iJR;
  public boolean iJS = false;
  public boolean iJT = false;
  public ByteBuffer iJU;
  public boolean loop = false;
  public String processName = "";
  
  public final boolean j(b paramb)
  {
    AppMethodBeat.i(136977);
    if (paramb == null)
    {
      AppMethodBeat.o(136977);
      return false;
    }
    if ((this.dtX != null) && (this.dtX.equalsIgnoreCase(paramb.dtX)) && (this.dvn != null) && (this.dvn.equalsIgnoreCase(paramb.dvn)))
    {
      AppMethodBeat.o(136977);
      return true;
    }
    AppMethodBeat.o(136977);
    return false;
  }
  
  public final void k(b paramb)
  {
    AppMethodBeat.i(136978);
    this.dtX = paramb.dtX;
    this.dvn = paramb.dvn;
    if (!TextUtils.isEmpty(paramb.filePath)) {
      this.filePath = paramb.filePath;
    }
    this.dvv = paramb.dvv;
    this.iJD = paramb.iJD;
    this.iJE = paramb.iJE;
    this.loop = paramb.loop;
    this.fromScene = paramb.fromScene;
    this.processName = paramb.processName;
    this.iJG = paramb.iJG;
    this.appId = paramb.appId;
    if (paramb.iJR != null) {
      this.iJR = paramb.iJR;
    }
    this.fileSize = paramb.fileSize;
    this.iJH = paramb.iJH;
    AppMethodBeat.o(136978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.b
 * JD-Core Version:    0.7.0.1
 */