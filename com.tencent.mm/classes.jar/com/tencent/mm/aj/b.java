package com.tencent.mm.aj;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public String appId = "";
  public boolean dcb = true;
  public String dce = "";
  public String ddp = "";
  public int ddx = 0;
  public int dkA = 0;
  public String filePath = "";
  public long fileSize = 0L;
  public int fromScene = 0;
  public int hLE = 0;
  public boolean hLF = false;
  public long hLG = 0L;
  public double hLH = 1.0D;
  public double hLI = 1.0D;
  public long hLJ = 0L;
  public long hLK = 0L;
  public long hLL = 0L;
  public long hLM = 0L;
  public long hLN = 0L;
  public long hLO = 0L;
  public long hLP = 0L;
  public String hLQ = null;
  public String hLR = null;
  public e hLS;
  public boolean hLT = false;
  public boolean hLU = false;
  public boolean loop = false;
  public String processName = "";
  
  public final boolean e(b paramb)
  {
    AppMethodBeat.i(136977);
    if (paramb == null)
    {
      AppMethodBeat.o(136977);
      return false;
    }
    if ((this.dce != null) && (this.dce.equalsIgnoreCase(paramb.dce)) && (this.ddp != null) && (this.ddp.equalsIgnoreCase(paramb.ddp)))
    {
      AppMethodBeat.o(136977);
      return true;
    }
    AppMethodBeat.o(136977);
    return false;
  }
  
  public final void f(b paramb)
  {
    AppMethodBeat.i(136978);
    this.dce = paramb.dce;
    this.ddp = paramb.ddp;
    if (!TextUtils.isEmpty(paramb.filePath)) {
      this.filePath = paramb.filePath;
    }
    this.ddx = paramb.ddx;
    this.hLE = paramb.hLE;
    this.hLF = paramb.hLF;
    this.loop = paramb.loop;
    this.fromScene = paramb.fromScene;
    this.processName = paramb.processName;
    this.hLH = paramb.hLH;
    this.appId = paramb.appId;
    if (paramb.hLS != null) {
      this.hLS = paramb.hLS;
    }
    this.fileSize = paramb.fileSize;
    this.hLI = paramb.hLI;
    AppMethodBeat.o(136978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.b
 * JD-Core Version:    0.7.0.1
 */