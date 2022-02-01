package com.tencent.matrix.trace.e;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public class b
{
  private static final LinkedList<a> dfO = new LinkedList();
  public int dfN = 0;
  private Executor executor;
  public final List<a> list = new LinkedList();
  public long time;
  
  public void J(List<a> paramList) {}
  
  public int Yh()
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
    public String dfR;
    public long dfS;
    public long dfT;
    public int dfU;
    public long dfV;
    public long dfW;
    public long dfX;
    public long dfY;
    public boolean dfp;
    
    public static a Yj()
    {
      synchronized ()
      {
        a locala = (a)b.Yi().poll();
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