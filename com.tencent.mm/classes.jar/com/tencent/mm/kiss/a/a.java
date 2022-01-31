package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a eKQ;
  public HandlerThread eKP;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(105675);
    eKQ = new a();
    AppMethodBeat.o(105675);
  }
  
  private a()
  {
    AppMethodBeat.i(105674);
    this.eKP = new HandlerThread("InflateThread", 5);
    this.eKP.start();
    this.mHandler = new Handler(this.eKP.getLooper());
    AppMethodBeat.o(105674);
  }
  
  public static a SG()
  {
    return eKQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.a.a
 * JD-Core Version:    0.7.0.1
 */