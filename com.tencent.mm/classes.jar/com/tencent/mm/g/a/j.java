package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class j
  extends b
{
  public a cmo;
  public j.b cmp;
  
  public j()
  {
    this((byte)0);
  }
  
  private j(byte paramByte)
  {
    AppMethodBeat.i(77529);
    this.cmo = new a();
    this.cmp = new j.b();
    this.ymq = false;
    this.callback = null;
    AppMethodBeat.o(77529);
  }
  
  public static final class a
  {
    public int actionCode;
    public String cmq;
    public boolean cmr;
    public boolean cms;
    public Context context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.j
 * JD-Core Version:    0.7.0.1
 */