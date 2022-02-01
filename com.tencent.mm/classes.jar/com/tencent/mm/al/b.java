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
  public int fromScene = 0;
  public boolean hqN = true;
  public String hqQ = "";
  public String hsg = "";
  public boolean loop = false;
  public int ori = 0;
  public boolean orj = false;
  public long ork = 0L;
  public double orl = 1.0D;
  public double orm = 1.0D;
  public long orn = 0L;
  public long oro = 0L;
  public long orp = 0L;
  public long orq = 0L;
  public long orr = 0L;
  public long ors = 0L;
  public long ort = 0L;
  public String oru = null;
  public String orv = null;
  public e orw;
  public boolean orx = false;
  public boolean ory = false;
  public ByteBuffer orz;
  public String processName = "";
  public int startTime = 0;
  
  public final boolean j(b paramb)
  {
    AppMethodBeat.i(136977);
    if (paramb == null)
    {
      AppMethodBeat.o(136977);
      return false;
    }
    if ((this.hqQ != null) && (this.hqQ.equalsIgnoreCase(paramb.hqQ)) && (this.hsg != null) && (this.hsg.equalsIgnoreCase(paramb.hsg)))
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
    this.hqQ = paramb.hqQ;
    this.hsg = paramb.hsg;
    if (!TextUtils.isEmpty(paramb.filePath)) {
      this.filePath = paramb.filePath;
    }
    this.startTime = paramb.startTime;
    this.ori = paramb.ori;
    this.orj = paramb.orj;
    this.loop = paramb.loop;
    this.fromScene = paramb.fromScene;
    this.processName = paramb.processName;
    this.orl = paramb.orl;
    this.appId = paramb.appId;
    if (paramb.orw != null) {
      this.orw = paramb.orw;
    }
    this.fileSize = paramb.fileSize;
    this.orm = paramb.orm;
    AppMethodBeat.o(136978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.al.b
 * JD-Core Version:    0.7.0.1
 */