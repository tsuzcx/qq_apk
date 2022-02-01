package com.tencent.magicbrush.handler;

import android.os.Handler;
import com.tencent.magicbrush.utils.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MainThreadHandler
{
  private static native void nativeDoTask(long paramLong1, long paramLong2);
  
  public static void post(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(140003);
    g.atF().post(new a(paramInt, paramLong1, paramLong2, (byte)0));
    AppMethodBeat.o(140003);
  }
  
  static final class a
    implements Runnable
  {
    private long data;
    private int eIY;
    private long eIZ;
    
    private a(int paramInt, long paramLong1, long paramLong2)
    {
      this.eIY = paramInt;
      this.eIZ = paramLong1;
      this.data = paramLong2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(140002);
      if (this.eIY <= 1)
      {
        MainThreadHandler.access$000(this.eIZ, this.data);
        AppMethodBeat.o(140002);
        return;
      }
      MainThreadHandler.post(this.eIZ, this.data, this.eIY - 1);
      AppMethodBeat.o(140002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MainThreadHandler
 * JD-Core Version:    0.7.0.1
 */