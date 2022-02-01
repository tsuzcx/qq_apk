package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;

public final class as
{
  private static ArrayList a = new ArrayList();
  private Handler b;
  private a c;
  
  private as(int paramInt)
  {
    HandlerThread localHandlerThread = new HandlerThread("index:" + paramInt, 5);
    localHandlerThread.setDaemon(true);
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public static as a()
  {
    ax.a("ParallelThreadHandler", "getParallelThreadHandler ...");
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      localas = (as)a.get(i);
      a locala = localas.c;
      if ((locala == null) || (locala.d))
      {
        ax.a("ParallelThreadHandler", "getParallelThreadHandler found index:" + i);
        return localas;
      }
      i += 1;
    }
    as localas = new as(j);
    a.add(localas);
    ax.a("ParallelThreadHandler", "getParallelThreadHandler create new. size:" + a.size());
    return localas;
  }
  
  public final boolean a(a parama)
  {
    this.c = parama;
    return this.b.post(parama);
  }
  
  public static abstract class a
    implements Runnable
  {
    public volatile boolean d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.as
 * JD-Core Version:    0.7.0.1
 */