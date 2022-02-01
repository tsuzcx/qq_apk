package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class sc
  extends IEvent
{
  public a fRw;
  public b fRx;
  
  public sc()
  {
    this((byte)0);
  }
  
  private sc(byte paramByte)
  {
    AppMethodBeat.i(94798);
    this.fRw = new a();
    this.fRx = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94798);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public anm fDI;
    public String fEh;
    public ca fNz;
    public dd fQJ;
    public int fRA = 0;
    public List<ca> fRB;
    public String fRC;
    public d fRD;
    public boolean fRE = false;
    public String fRF;
    public String fRy;
    public aoc fRz;
    public String from;
    public long msgId = 0L;
    public String thumbPath;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public String dataPath;
    public dd fQJ;
    public d fRD;
    public c fRG;
    public boolean fRH = false;
    public boolean fRI = false;
    public boolean fRJ = false;
    public long msgId = 0L;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.sc
 * JD-Core Version:    0.7.0.1
 */