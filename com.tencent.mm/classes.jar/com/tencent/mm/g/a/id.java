package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class id
  extends b
{
  public a dvK;
  
  public id()
  {
    this((byte)0);
  }
  
  private id(byte paramByte)
  {
    AppMethodBeat.i(116030);
    this.dvK = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116030);
  }
  
  public static final class a
  {
    public int actionCode;
    public String appId;
    public Context context;
    public String extMsg;
    public String messageAction;
    public String messageExt;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.id
 * JD-Core Version:    0.7.0.1
 */