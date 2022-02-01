package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.z;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class st
  extends IEvent
{
  public a dZk;
  
  public st()
  {
    this((byte)0);
  }
  
  private st(byte paramByte)
  {
    AppMethodBeat.i(149887);
    this.dZk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149887);
  }
  
  public static final class a
  {
    public Context context;
    public List<ca> dXK;
    public boolean dZl = false;
    public z dZm;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.st
 * JD-Core Version:    0.7.0.1
 */