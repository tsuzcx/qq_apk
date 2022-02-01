package com.tencent.mm.g.a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class td
  extends b
{
  public a dwb;
  
  public td()
  {
    this((byte)0);
  }
  
  private td(byte paramByte)
  {
    AppMethodBeat.i(77798);
    this.dwb = new a();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(77798);
  }
  
  public static final class a
  {
    public Context context;
    public String dwc;
    public DialogInterface.OnDismissListener dwd;
    public Bundle dwe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.td
 * JD-Core Version:    0.7.0.1
 */