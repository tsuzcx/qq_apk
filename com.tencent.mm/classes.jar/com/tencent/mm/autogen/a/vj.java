package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.z;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.cc;
import java.util.List;

public final class vj
  extends IEvent
{
  public a hZb;
  
  public vj()
  {
    this((byte)0);
  }
  
  private vj(byte paramByte)
  {
    AppMethodBeat.i(149887);
    this.hZb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149887);
  }
  
  public static final class a
  {
    public Context context;
    public List<cc> hXy;
    public boolean hZc = false;
    public z hZd;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vj
 * JD-Core Version:    0.7.0.1
 */