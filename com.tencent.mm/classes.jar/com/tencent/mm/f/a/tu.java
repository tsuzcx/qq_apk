package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class tu
  extends IEvent
{
  public a fTd;
  
  public tu()
  {
    this((byte)0);
  }
  
  private tu(byte paramByte)
  {
    AppMethodBeat.i(149887);
    this.fTd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149887);
  }
  
  public static final class a
  {
    public Context context;
    public List<ca> fRB;
    public boolean fTe = false;
    public z fTf;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.tu
 * JD-Core Version:    0.7.0.1
 */