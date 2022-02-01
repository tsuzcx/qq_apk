package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bu;
import java.util.List;

public final class rw
  extends b
{
  public a dGt;
  
  public rw()
  {
    this((byte)0);
  }
  
  private rw(byte paramByte)
  {
    AppMethodBeat.i(149887);
    this.dGt = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(149887);
  }
  
  public static final class a
  {
    public Context context;
    public List<bu> dES;
    public boolean dGu = false;
    public z dGv;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.rw
 * JD-Core Version:    0.7.0.1
 */