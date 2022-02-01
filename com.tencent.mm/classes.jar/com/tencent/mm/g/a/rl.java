package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.z;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bo;
import java.util.List;

public final class rl
  extends b
{
  public a dut;
  
  public rl()
  {
    this((byte)0);
  }
  
  private rl(byte paramByte)
  {
    AppMethodBeat.i(149887);
    this.dut = new a();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(149887);
  }
  
  public static final class a
  {
    public Context context;
    public List<bo> dsS;
    public boolean duu = false;
    public z duv;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.rl
 * JD-Core Version:    0.7.0.1
 */