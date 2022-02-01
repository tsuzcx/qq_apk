package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public String appId = "";
  public boolean cQL = true;
  public String cQO = "";
  public String cRZ = "";
  public int cSh = 0;
  public int cZi = 0;
  public String filePath = "";
  public long fileSize = 0L;
  public int fromScene = 0;
  public e htA;
  public boolean htB = false;
  public boolean htC = false;
  public int htm = 0;
  public boolean htn = false;
  public long hto = 0L;
  public double htp = 1.0D;
  public double htq = 1.0D;
  public long htr = 0L;
  public long hts = 0L;
  public long htt = 0L;
  public long htu = 0L;
  public long htv = 0L;
  public long htw = 0L;
  public long htx = 0L;
  public String hty = null;
  public String htz = null;
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
    if ((this.cQO != null) && (this.cQO.equalsIgnoreCase(paramb.cQO)) && (this.cRZ != null) && (this.cRZ.equalsIgnoreCase(paramb.cRZ)))
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
    this.cQO = paramb.cQO;
    this.cRZ = paramb.cRZ;
    if (!TextUtils.isEmpty(paramb.filePath)) {
      this.filePath = paramb.filePath;
    }
    this.cSh = paramb.cSh;
    this.htm = paramb.htm;
    this.htn = paramb.htn;
    this.loop = paramb.loop;
    this.fromScene = paramb.fromScene;
    this.processName = paramb.processName;
    this.htp = paramb.htp;
    this.appId = paramb.appId;
    if (paramb.htA != null) {
      this.htA = paramb.htA;
    }
    this.fileSize = paramb.fileSize;
    this.htq = paramb.htq;
    AppMethodBeat.o(136978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.b
 * JD-Core Version:    0.7.0.1
 */