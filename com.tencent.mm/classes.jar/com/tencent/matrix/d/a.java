package com.tencent.matrix.d;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashSet;
import java.util.Iterator;

public class a
{
  private static volatile HandlerThread bsP;
  private static volatile Handler bsQ;
  private static HashSet<HandlerThread> bsR = new HashSet();
  
  public static HandlerThread bA(String paramString)
  {
    Object localObject = bsR.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((HandlerThread)((Iterator)localObject).next()).isAlive())
      {
        ((Iterator)localObject).remove();
        b.w("Matrix.HandlerThread", "warning: remove dead handler thread with name %s", new Object[] { paramString });
      }
    }
    localObject = new HandlerThread(paramString);
    ((HandlerThread)localObject).start();
    bsR.add(localObject);
    b.w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", new Object[] { paramString, Integer.valueOf(bsR.size()) });
    return localObject;
  }
  
  public static HandlerThread rt()
  {
    if (bsP != null) {
      return bsP;
    }
    try
    {
      if (bsP == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("default_matrix_thread");
        bsP = localHandlerThread;
        localHandlerThread.start();
        bsQ = new Handler(bsP.getLooper());
        b.w("Matrix.HandlerThread", "create default handler thread, we should use these thread normal", new Object[0]);
      }
      return bsP;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.d.a
 * JD-Core Version:    0.7.0.1
 */