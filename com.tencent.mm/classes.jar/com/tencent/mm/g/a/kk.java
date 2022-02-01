package com.tencent.mm.g.a;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.event.IEvent;

public final class kk
  extends IEvent
{
  public a dPw;
  
  public kk()
  {
    this((byte)0);
  }
  
  private kk(byte paramByte)
  {
    AppMethodBeat.i(123714);
    this.dPw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(123714);
  }
  
  public static final class a
  {
    public b dPx;
    public DialogInterface.OnClickListener dPy;
    public DialogInterface.OnClickListener dPz;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.kk
 * JD-Core Version:    0.7.0.1
 */