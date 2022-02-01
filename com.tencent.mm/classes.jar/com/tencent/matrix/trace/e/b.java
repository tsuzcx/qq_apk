package com.tencent.matrix.trace.e;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public class b
{
  private static final LinkedList<a> cKF = new LinkedList();
  public int cKE = 0;
  private Executor executor;
  public final List<a> list = new LinkedList();
  public long time;
  
  public void F(List<a> paramList) {}
  
  public int Jh()
  {
    return 0;
  }
  
  @Deprecated
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public Executor getExecutor()
  {
    return this.executor;
  }
  
  public static final class a
  {
    public String cKI;
    public long cKJ;
    public long cKK;
    public int cKL;
    public long cKM;
    public long cKN;
    public long cKO;
    public long cKP;
    public boolean cKg;
    
    public static a Jj()
    {
      synchronized ()
      {
        a locala = (a)b.Ji().poll();
        ??? = locala;
        if (locala == null) {
          ??? = new a();
        }
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.e.b
 * JD-Core Version:    0.7.0.1
 */