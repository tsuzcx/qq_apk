package com.tencent.mm.g.a;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ik
  extends com.tencent.mm.sdk.b.b
{
  public a cxM;
  
  public ik()
  {
    this((byte)0);
  }
  
  private ik(byte paramByte)
  {
    AppMethodBeat.i(105574);
    this.cxM = new a();
    this.ymq = false;
    this.callback = null;
    AppMethodBeat.o(105574);
  }
  
  public static final class a
  {
    public com.tencent.mm.protocal.b.a.b cxN;
    public DialogInterface.OnClickListener cxO;
    public DialogInterface.OnClickListener cxP;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ik
 * JD-Core Version:    0.7.0.1
 */