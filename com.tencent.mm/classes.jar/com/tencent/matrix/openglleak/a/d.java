package com.tencent.matrix.openglleak.a;

import android.os.HandlerThread;

public final class d
  extends HandlerThread
{
  private static final d eYe = new d("GpuResLeakMonitor");
  
  private d(String paramString)
  {
    super(paramString);
  }
  
  public static d ayV()
  {
    return eYe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.a.d
 * JD-Core Version:    0.7.0.1
 */