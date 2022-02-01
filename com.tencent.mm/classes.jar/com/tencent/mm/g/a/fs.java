package com.tencent.mm.g.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fs
  extends b
{
  public a dqZ;
  public b dra;
  
  public fs()
  {
    this((byte)0);
  }
  
  private fs(byte paramByte)
  {
    AppMethodBeat.i(19806);
    this.dqZ = new a();
    this.dra = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(19806);
  }
  
  public static final class a
  {
    public String[] drb;
  }
  
  public static final class b
  {
    public int dqH = 0;
    public MatrixCursor drc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.fs
 * JD-Core Version:    0.7.0.1
 */