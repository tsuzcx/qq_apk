package com.tencent.magicbrush.handler;

import android.os.Handler;
import androidx.annotation.Keep;
import com.tencent.magicbrush.utils.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class MainThreadHandler
{
  private static native void nativeDoTask(long paramLong1, long paramLong2);
  
  @Keep
  public static void post(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(140003);
    g.Ta().post(new a(paramInt, paramLong1, paramLong2, (byte)0));
    AppMethodBeat.o(140003);
  }
  
  static final class a
    implements Runnable
  {
    private int cND;
    private long cNE;
    private long data;
    
    private a(int paramInt, long paramLong1, long paramLong2)
    {
      this.cND = paramInt;
      this.cNE = paramLong1;
      this.data = paramLong2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(140002);
      if (this.cND <= 1)
      {
        MainThreadHandler.access$000(this.cNE, this.data);
        AppMethodBeat.o(140002);
        return;
      }
      MainThreadHandler.post(this.cNE, this.data, this.cND - 1);
      AppMethodBeat.o(140002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MainThreadHandler
 * JD-Core Version:    0.7.0.1
 */