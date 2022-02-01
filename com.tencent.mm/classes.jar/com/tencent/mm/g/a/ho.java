package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ho
  extends b
{
  public a dlk;
  
  public ho()
  {
    this((byte)0);
  }
  
  private ho(byte paramByte)
  {
    AppMethodBeat.i(116030);
    this.dlk = new a();
    this.ESR = false;
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
 * Qualified Name:     com.tencent.mm.g.a.ho
 * JD-Core Version:    0.7.0.1
 */