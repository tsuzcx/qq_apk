package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class rc
  extends IEvent
{
  public a dXF;
  public b dXG;
  
  public rc()
  {
    this((byte)0);
  }
  
  private rc(byte paramByte)
  {
    AppMethodBeat.i(94798);
    this.dXF = new a();
    this.dXG = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94798);
  }
  
  public static final class a
  {
    public Context context;
    public aml dKT;
    public String dLs;
    public ca dTX;
    public cz dWX;
    public String dXH;
    public anb dXI;
    public int dXJ = 0;
    public List<ca> dXK;
    public String dXL;
    public d dXM;
    public boolean dXN = false;
    public String dXO;
    public String desc;
    public String from;
    public long msgId = 0L;
    public String thumbPath;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public cz dWX;
    public d dXM;
    public c dXP;
    public boolean dXQ = false;
    public boolean dXR = false;
    public boolean dXS = false;
    public String dataPath;
    public long msgId = 0L;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.rc
 * JD-Core Version:    0.7.0.1
 */