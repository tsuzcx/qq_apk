package com.tencent.mm.g.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.util.List;

public final class fs
  extends b
{
  public a drS;
  public b drT;
  
  public fs()
  {
    this((byte)0);
  }
  
  private fs(byte paramByte)
  {
    AppMethodBeat.i(116017);
    this.drS = new a();
    this.drT = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(116017);
  }
  
  public static final class a
  {
    public Cursor drU;
  }
  
  public static final class b
  {
    public String drV;
    public int drW;
    public String drX;
    public long drY;
    public int drZ;
    public List dsa;
    public List dsb;
    public int dsc;
    public int dsd;
    public int mediaType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.fs
 * JD-Core Version:    0.7.0.1
 */