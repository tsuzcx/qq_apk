package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class px
  extends IEvent
{
  public a fOD;
  
  public px()
  {
    this((byte)0);
  }
  
  private px(byte paramByte)
  {
    AppMethodBeat.i(127409);
    this.fOD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127409);
  }
  
  public static final class a
  {
    public Context context;
    public Bundle fNN;
    public boolean fNQ = true;
    public String fOE;
    public long msgId = -1L;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.px
 * JD-Core Version:    0.7.0.1
 */