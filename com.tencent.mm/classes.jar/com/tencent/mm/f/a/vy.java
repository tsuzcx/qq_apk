package com.tencent.mm.f.a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vy
  extends IEvent
{
  public a fUZ;
  
  public vy()
  {
    this((byte)0);
  }
  
  private vy(byte paramByte)
  {
    AppMethodBeat.i(77798);
    this.fUZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(77798);
  }
  
  public static final class a
  {
    public Context context;
    public String fVa;
    public DialogInterface.OnDismissListener fVb;
    public Bundle fVc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.vy
 * JD-Core Version:    0.7.0.1
 */