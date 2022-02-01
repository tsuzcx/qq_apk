package com.tencent.mm.al;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b
{
  public String appId = "";
  public int currentTime = 0;
  public String filePath = "";
  public long fileSize = 0L;
  public boolean fmC = true;
  public String fmF = "";
  public String fnV = "";
  public int fod = 0;
  public int fromScene = 0;
  public boolean loop = false;
  public int lzH = 0;
  public boolean lzI = false;
  public long lzJ = 0L;
  public double lzK = 1.0D;
  public double lzL = 1.0D;
  public long lzM = 0L;
  public long lzN = 0L;
  public long lzO = 0L;
  public long lzP = 0L;
  public long lzQ = 0L;
  public long lzR = 0L;
  public long lzS = 0L;
  public String lzT = null;
  public String lzU = null;
  public e lzV;
  public boolean lzW = false;
  public boolean lzX = false;
  public ByteBuffer lzY;
  public String processName = "";
  
  public final boolean j(b paramb)
  {
    AppMethodBeat.i(136977);
    if (paramb == null)
    {
      AppMethodBeat.o(136977);
      return false;
    }
    if ((this.fmF != null) && (this.fmF.equalsIgnoreCase(paramb.fmF)) && (this.fnV != null) && (this.fnV.equalsIgnoreCase(paramb.fnV)))
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
    this.fmF = paramb.fmF;
    this.fnV = paramb.fnV;
    if (!TextUtils.isEmpty(paramb.filePath)) {
      this.filePath = paramb.filePath;
    }
    this.fod = paramb.fod;
    this.lzH = paramb.lzH;
    this.lzI = paramb.lzI;
    this.loop = paramb.loop;
    this.fromScene = paramb.fromScene;
    this.processName = paramb.processName;
    this.lzK = paramb.lzK;
    this.appId = paramb.appId;
    if (paramb.lzV != null) {
      this.lzV = paramb.lzV;
    }
    this.fileSize = paramb.fileSize;
    this.lzL = paramb.lzL;
    AppMethodBeat.o(136978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.al.b
 * JD-Core Version:    0.7.0.1
 */