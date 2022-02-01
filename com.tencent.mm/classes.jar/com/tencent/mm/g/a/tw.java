package com.tencent.mm.g.a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class tw
  extends b
{
  public a dJp;
  
  public tw()
  {
    this((byte)0);
  }
  
  private tw(byte paramByte)
  {
    AppMethodBeat.i(77798);
    this.dJp = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(77798);
  }
  
  public static final class a
  {
    public Context context;
    public String dJq;
    public DialogInterface.OnDismissListener dJr;
    public Bundle dJs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.tw
 * JD-Core Version:    0.7.0.1
 */