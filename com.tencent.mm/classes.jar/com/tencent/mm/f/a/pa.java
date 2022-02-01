package com.tencent.mm.f.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pa
  extends IEvent
{
  public a fNS;
  public b fNT;
  
  public pa()
  {
    this((byte)0);
  }
  
  private pa(byte paramByte)
  {
    AppMethodBeat.i(127408);
    this.fNS = new a();
    this.fNT = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127408);
  }
  
  public static final class a
  {
    public Context context;
    public int fEi = 0;
    public int fEj = 0;
    public String fNI;
    public Bundle fNN;
    public int fNO = 0;
    public String fNU;
    public long fNV = 0L;
    public String jsonString;
    public int type = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.pa
 * JD-Core Version:    0.7.0.1
 */