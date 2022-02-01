package com.tencent.mm.f.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ol
  extends IEvent
{
  public a fNm;
  
  public ol()
  {
    this((byte)0);
  }
  
  private ol(byte paramByte)
  {
    AppMethodBeat.i(116036);
    this.fNm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116036);
  }
  
  public static final class a
  {
    public Activity activity;
    public int fNk = 0;
    public Bundle fNn;
    public String fwI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ol
 * JD-Core Version:    0.7.0.1
 */