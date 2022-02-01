package com.tencent.mm.autogen.a;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.event.IEvent;

public final class mf
  extends IEvent
{
  public a hOl;
  
  public mf()
  {
    this((byte)0);
  }
  
  private mf(byte paramByte)
  {
    AppMethodBeat.i(123714);
    this.hOl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(123714);
  }
  
  public static final class a
  {
    public b hOm;
    public DialogInterface.OnClickListener hOn;
    public DialogInterface.OnClickListener hOo;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.mf
 * JD-Core Version:    0.7.0.1
 */