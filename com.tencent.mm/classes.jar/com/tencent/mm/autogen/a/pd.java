package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class pd
  extends IEvent
{
  public a hRZ;
  public b hSa;
  
  public pd()
  {
    this((byte)0);
  }
  
  private pd(byte paramByte)
  {
    AppMethodBeat.i(116459);
    this.hRZ = new a();
    this.hSa = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116459);
  }
  
  public static final class a
  {
    public boolean hRY = false;
    public List<String> hSb;
    public String topic;
  }
  
  public static final class b
  {
    public String hBy;
    public int hSc;
    public List<String> hSd;
    public List<String> hSe;
    public List<String> hSf;
    public List<String> hSg;
    public List<String> hSh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pd
 * JD-Core Version:    0.7.0.1
 */