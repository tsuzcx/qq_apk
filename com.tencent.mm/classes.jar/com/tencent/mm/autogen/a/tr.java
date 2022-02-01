package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.cc;
import java.util.List;

public final class tr
  extends IEvent
{
  public a hXt;
  public b hXu;
  
  public tr()
  {
    this((byte)0);
  }
  
  private tr(byte paramByte)
  {
    AppMethodBeat.i(94798);
    this.hXt = new a();
    this.hXu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94798);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public String from;
    public String hIX;
    public arf hIy;
    public cc hTm;
    public dn hWG;
    public d hXA;
    public boolean hXB = false;
    public String hXC;
    public String hXv;
    public arv hXw;
    public int hXx = 0;
    public List<cc> hXy;
    public String hXz;
    public long msgId = 0L;
    public String thumbPath;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public String dataPath;
    public dn hWG;
    public d hXA;
    public c hXD;
    public boolean hXE = false;
    public boolean hXF = false;
    public boolean hXG = false;
    public long msgId = 0L;
    public String thumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tr
 * JD-Core Version:    0.7.0.1
 */