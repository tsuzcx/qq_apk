package com.tencent.mm.ag;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public String appId = "";
  public boolean cer = true;
  public String ceu = "";
  public String cfG = "";
  public int cmU = 0;
  public String filePath = "";
  public long fileSize = 0L;
  public int fqW = 0;
  public boolean fqX = false;
  public boolean fqY = false;
  public long fqZ = 0L;
  public double fra = 1.0D;
  public long frb = 0L;
  public long frc = 0L;
  public long frd = 0L;
  public long fre = 0L;
  public long frf = 0L;
  public long frg = 0L;
  public long frh = 0L;
  public e fri;
  public boolean frj = false;
  public boolean frk = false;
  public int fromScene = 0;
  public String processName = "";
  public int startTime = 0;
  
  public final boolean e(b paramb)
  {
    AppMethodBeat.i(137228);
    if (paramb == null)
    {
      AppMethodBeat.o(137228);
      return false;
    }
    if ((this.ceu != null) && (this.ceu.equalsIgnoreCase(paramb.ceu)) && (this.cfG != null) && (this.cfG.equalsIgnoreCase(paramb.cfG)))
    {
      AppMethodBeat.o(137228);
      return true;
    }
    AppMethodBeat.o(137228);
    return false;
  }
  
  public final void f(b paramb)
  {
    AppMethodBeat.i(137229);
    this.ceu = paramb.ceu;
    this.cfG = paramb.cfG;
    if (!TextUtils.isEmpty(paramb.filePath)) {
      this.filePath = paramb.filePath;
    }
    this.startTime = paramb.startTime;
    this.fqW = paramb.fqW;
    this.fqX = paramb.fqX;
    this.fqY = paramb.fqY;
    this.fromScene = paramb.fromScene;
    this.processName = paramb.processName;
    this.fra = paramb.fra;
    this.appId = paramb.appId;
    if (paramb.fri != null) {
      this.fri = paramb.fri;
    }
    this.fileSize = paramb.fileSize;
    AppMethodBeat.o(137229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.b
 * JD-Core Version:    0.7.0.1
 */