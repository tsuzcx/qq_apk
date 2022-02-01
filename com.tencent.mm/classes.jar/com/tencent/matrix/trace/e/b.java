package com.tencent.matrix.trace.e;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public class b
{
  private static final LinkedList<a> czJ = new LinkedList();
  public int czI = 0;
  private Executor executor;
  public final List<a> list = new LinkedList();
  public long time;
  
  public void F(List<a> paramList) {}
  
  public int HM()
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
    public String czM;
    public long czN;
    public long czO;
    public int czP;
    public long czQ;
    public long czR;
    public long czS;
    public long czT;
    public boolean czk;
    
    public static a HO()
    {
      synchronized ()
      {
        a locala = (a)b.HN().poll();
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