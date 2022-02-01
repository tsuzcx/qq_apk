package com.tencent.mm.g.a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uu
  extends IEvent
{
  public a ebc;
  
  public uu()
  {
    this((byte)0);
  }
  
  private uu(byte paramByte)
  {
    AppMethodBeat.i(77798);
    this.ebc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(77798);
  }
  
  public static final class a
  {
    public Context context;
    public String ebd;
    public DialogInterface.OnDismissListener ebe;
    public Bundle ebf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.uu
 * JD-Core Version:    0.7.0.1
 */