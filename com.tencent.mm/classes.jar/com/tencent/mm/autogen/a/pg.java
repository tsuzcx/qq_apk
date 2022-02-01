package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class pg
  extends IEvent
{
  public a hSn;
  public b hSo;
  
  public pg()
  {
    this((byte)0);
  }
  
  private pg(byte paramByte)
  {
    AppMethodBeat.i(89749);
    this.hSn = new a();
    this.hSo = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89749);
  }
  
  public static final class a
  {
    public int hHC = 0;
    public boolean hRY = false;
    public int hSp = 0;
    public int hSq = 0;
    public String hSr;
    public String hSs;
    public float latitude = 0.0F;
    public float longitude = 0.0F;
  }
  
  public static final class b
  {
    public int hHC = 0;
    public boolean hSt = false;
    public List<dgy> hSu;
    public int hSv = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pg
 * JD-Core Version:    0.7.0.1
 */