package com.tencent.mm.f.a;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.event.IEvent;

public final class lb
  extends IEvent
{
  public a fIK;
  
  public lb()
  {
    this((byte)0);
  }
  
  private lb(byte paramByte)
  {
    AppMethodBeat.i(123714);
    this.fIK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(123714);
  }
  
  public static final class a
  {
    public b fIL;
    public DialogInterface.OnClickListener fIM;
    public DialogInterface.OnClickListener fIN;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.lb
 * JD-Core Version:    0.7.0.1
 */