package com.tencent.mm.f.a;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.event.IEvent;

public final class sj
  extends IEvent
{
  public a fRQ;
  
  public sj()
  {
    this((byte)0);
  }
  
  private sj(byte paramByte)
  {
    AppMethodBeat.i(19827);
    this.fRQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19827);
  }
  
  public static final class a
  {
    public a fRR;
    public EditText fRS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.a.sj
 * JD-Core Version:    0.7.0.1
 */