package com.tencent.mm.g.a;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.event.IEvent;

public final class rk
  extends IEvent
{
  public a dXZ;
  
  public rk()
  {
    this((byte)0);
  }
  
  private rk(byte paramByte)
  {
    AppMethodBeat.i(19827);
    this.dXZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19827);
  }
  
  public static final class a
  {
    public a dYa;
    public EditText dYb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.rk
 * JD-Core Version:    0.7.0.1
 */