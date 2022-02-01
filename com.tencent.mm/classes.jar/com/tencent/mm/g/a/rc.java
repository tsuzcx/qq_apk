package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bl;
import java.util.List;

public final class rc
  extends b
{
  public a dwG;
  
  public rc()
  {
    this((byte)0);
  }
  
  private rc(byte paramByte)
  {
    AppMethodBeat.i(149887);
    this.dwG = new a();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(149887);
  }
  
  public static final class a
  {
    public Context context;
    public List<bl> dvg;
    public boolean dwH = false;
    public z dwI;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.rc
 * JD-Core Version:    0.7.0.1
 */