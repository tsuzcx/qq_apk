package com.tencent.matrix.trace.e;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public class b
{
  private static final LinkedList<a> ffd = new LinkedList();
  private Executor executor;
  private int ffc = 0;
  private final List<a> list = new LinkedList();
  public long time;
  
  public final void a(String paramString, long paramLong1, int paramInt, boolean paramBoolean, long paramLong2)
  {
    paramLong1 = (paramLong1 - paramLong2) / 1000000L;
    a(paramString, paramLong1, paramLong1, paramInt, paramBoolean);
  }
  
  @Deprecated
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  public final void a(final String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    a locala = a.azU();
    locala.ffg = paramString;
    locala.ffh = paramLong1;
    locala.ffi = paramLong2;
    locala.ffj = paramInt;
    locala.feD = paramBoolean;
    locala.ffk = paramLong3;
    locala.ffl = paramLong4;
    locala.ffm = paramLong5;
    locala.ffn = paramLong6;
    this.list.add(locala);
    if ((this.list.size() >= this.ffc) && (hI() != null))
    {
      paramString = new LinkedList(this.list);
      this.list.clear();
      hI().execute(new Runnable()
      {
        public final void run()
        {
          b.this.bj(paramString);
          Iterator localIterator = paramString.iterator();
          while (localIterator.hasNext())
          {
            b.a locala = (b.a)localIterator.next();
            if (b.azT().size() <= 1000)
            {
              locala.ffg = "";
              locala.ffh = 0L;
              locala.ffi = 0L;
              locala.ffj = 0;
              locala.feD = false;
              locala.ffk = 0L;
              locala.ffl = 0L;
              locala.ffm = 0L;
              locala.ffn = 0L;
              synchronized (b.azT())
              {
                b.azT().add(locala);
              }
            }
          }
        }
      });
    }
  }
  
  public int azS()
  {
    return 0;
  }
  
  public void b(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public void bj(List<a> paramList) {}
  
  public Executor hI()
  {
    return this.executor;
  }
  
  public static final class a
  {
    public boolean feD;
    public String ffg;
    public long ffh;
    public long ffi;
    public int ffj;
    public long ffk;
    public long ffl;
    public long ffm;
    public long ffn;
    
    public static a azU()
    {
      synchronized ()
      {
        a locala = (a)b.azT().poll();
        ??? = locala;
        if (locala == null) {
          ??? = new a();
        }
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.e.b
 * JD-Core Version:    0.7.0.1
 */