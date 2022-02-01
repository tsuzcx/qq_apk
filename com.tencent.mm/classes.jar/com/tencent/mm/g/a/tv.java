package com.tencent.mm.g.a;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class tv
  extends b
{
  public a dIl;
  
  public tv()
  {
    this((byte)0);
  }
  
  private tv(byte paramByte)
  {
    AppMethodBeat.i(77798);
    this.dIl = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(77798);
  }
  
  public static final class a
  {
    public Context context;
    public String dIm;
    public DialogInterface.OnDismissListener dIn;
    public Bundle dIo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.tv
 * JD-Core Version:    0.7.0.1
 */