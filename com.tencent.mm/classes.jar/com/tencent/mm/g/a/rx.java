package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.z;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bv;
import java.util.List;

public final class rx
  extends b
{
  public a dHz;
  
  public rx()
  {
    this((byte)0);
  }
  
  private rx(byte paramByte)
  {
    AppMethodBeat.i(149887);
    this.dHz = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(149887);
  }
  
  public static final class a
  {
    public Context context;
    public List<bv> dFX;
    public boolean dHA = false;
    public z dHB;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.rx
 * JD-Core Version:    0.7.0.1
 */