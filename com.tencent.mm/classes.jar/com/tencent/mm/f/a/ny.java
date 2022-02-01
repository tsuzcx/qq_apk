package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ny
  extends IEvent
{
  public a fMD;
  public b fME;
  
  public ny()
  {
    this((byte)0);
  }
  
  private ny(byte paramByte)
  {
    AppMethodBeat.i(89749);
    this.fMD = new a();
    this.fME = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89749);
  }
  
  public static final class a
  {
    public int fCN = 0;
    public int fMF = 0;
    public int fMG = 0;
    public String fMH;
    public String fMI;
    public boolean fMo = false;
    public float latitude = 0.0F;
    public float longitude = 0.0F;
  }
  
  public static final class b
  {
    public int fCN = 0;
    public boolean fMJ = false;
    public List<cqe> fMK;
    public int fML = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ny
 * JD-Core Version:    0.7.0.1
 */