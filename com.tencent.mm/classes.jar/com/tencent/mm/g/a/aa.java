package com.tencent.mm.g.a;

import android.support.v4.app.s.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aa
  extends IEvent
{
  public a dCY;
  
  public aa()
  {
    this((byte)0);
  }
  
  private aa(byte paramByte)
  {
    AppMethodBeat.i(19788);
    this.dCY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19788);
  }
  
  public static final class a
  {
    public s.e dCZ;
    public String title;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.aa
 * JD-Core Version:    0.7.0.1
 */