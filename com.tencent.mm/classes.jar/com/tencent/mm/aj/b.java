package com.tencent.mm.aj;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public String appId = "";
  public boolean cTo = true;
  public String cTr = "";
  public String cUD = "";
  public int cUL = 0;
  public int dbJ = 0;
  public String filePath = "";
  public long fileSize = 0L;
  public int fromScene = 0;
  public int gSM = 0;
  public boolean gSN = false;
  public long gSP = 0L;
  public double gSQ = 1.0D;
  public double gSR = 1.0D;
  public long gSS = 0L;
  public long gST = 0L;
  public long gSU = 0L;
  public long gSV = 0L;
  public long gSW = 0L;
  public long gSX = 0L;
  public long gSY = 0L;
  public String gSZ = null;
  public String gTa = null;
  public e gTb;
  public boolean gTc = false;
  public boolean gTd = false;
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
    if ((this.cTr != null) && (this.cTr.equalsIgnoreCase(paramb.cTr)) && (this.cUD != null) && (this.cUD.equalsIgnoreCase(paramb.cUD)))
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
    this.cTr = paramb.cTr;
    this.cUD = paramb.cUD;
    if (!TextUtils.isEmpty(paramb.filePath)) {
      this.filePath = paramb.filePath;
    }
    this.cUL = paramb.cUL;
    this.gSM = paramb.gSM;
    this.gSN = paramb.gSN;
    this.loop = paramb.loop;
    this.fromScene = paramb.fromScene;
    this.processName = paramb.processName;
    this.gSQ = paramb.gSQ;
    this.appId = paramb.appId;
    if (paramb.gTb != null) {
      this.gTb = paramb.gTb;
    }
    this.fileSize = paramb.fileSize;
    this.gSR = paramb.gSR;
    AppMethodBeat.o(136978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.b
 * JD-Core Version:    0.7.0.1
 */