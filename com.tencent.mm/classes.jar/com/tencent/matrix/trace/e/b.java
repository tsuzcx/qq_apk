package com.tencent.matrix.trace.e;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public class b
{
  private static final LinkedList<a> dbM = new LinkedList();
  public int dbL = 0;
  private Executor executor;
  public final List<a> list = new LinkedList();
  public long time;
  
  public void L(List<a> paramList) {}
  
  public int TD()
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
    public String dbP;
    public long dbQ;
    public long dbR;
    public int dbS;
    public long dbT;
    public long dbU;
    public long dbV;
    public long dbW;
    public boolean dbn;
    
    public static a TF()
    {
      synchronized ()
      {
        a locala = (a)b.TE().poll();
        ??? = locala;
        if (locala == null) {
          ??? = new a();
        }
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.e.b
 * JD-Core Version:    0.7.0.1
 */