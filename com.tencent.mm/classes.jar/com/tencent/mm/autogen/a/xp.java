package com.tencent.mm.autogen.a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xp
  extends IEvent
{
  public a iaW;
  
  public xp()
  {
    this((byte)0);
  }
  
  private xp(byte paramByte)
  {
    AppMethodBeat.i(77798);
    this.iaW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(77798);
  }
  
  public static final class a
  {
    public Context context;
    public String iaX;
    public DialogInterface.OnDismissListener iaY;
    public Bundle iaZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.xp
 * JD-Core Version:    0.7.0.1
 */