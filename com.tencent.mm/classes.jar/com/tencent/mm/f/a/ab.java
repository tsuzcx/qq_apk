package com.tencent.mm.f.a;

import androidx.core.app.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ab
  extends IEvent
{
  public a fvE;
  
  public ab()
  {
    this((byte)0);
  }
  
  private ab(byte paramByte)
  {
    AppMethodBeat.i(19788);
    this.fvE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19788);
  }
  
  public static final class a
  {
    public e.f fvF;
    public String title;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ab
 * JD-Core Version:    0.7.0.1
 */