package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public String appId = "";
  public boolean ddd = true;
  public String ddg = "";
  public String der = "";
  public int dez = 0;
  public int dlC = 0;
  public String filePath = "";
  public long fileSize = 0L;
  public int fromScene = 0;
  public double hOA = 1.0D;
  public double hOB = 1.0D;
  public long hOC = 0L;
  public long hOD = 0L;
  public long hOE = 0L;
  public long hOF = 0L;
  public long hOG = 0L;
  public long hOH = 0L;
  public long hOI = 0L;
  public String hOJ = null;
  public String hOK = null;
  public e hOL;
  public boolean hOM = false;
  public boolean hON = false;
  public int hOx = 0;
  public boolean hOy = false;
  public long hOz = 0L;
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
    if ((this.ddg != null) && (this.ddg.equalsIgnoreCase(paramb.ddg)) && (this.der != null) && (this.der.equalsIgnoreCase(paramb.der)))
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
    this.ddg = paramb.ddg;
    this.der = paramb.der;
    if (!TextUtils.isEmpty(paramb.filePath)) {
      this.filePath = paramb.filePath;
    }
    this.dez = paramb.dez;
    this.hOx = paramb.hOx;
    this.hOy = paramb.hOy;
    this.loop = paramb.loop;
    this.fromScene = paramb.fromScene;
    this.processName = paramb.processName;
    this.hOA = paramb.hOA;
    this.appId = paramb.appId;
    if (paramb.hOL != null) {
      this.hOL = paramb.hOL;
    }
    this.fileSize = paramb.fileSize;
    this.hOB = paramb.hOB;
    AppMethodBeat.o(136978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ai.b
 * JD-Core Version:    0.7.0.1
 */