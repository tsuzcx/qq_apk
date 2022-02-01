package com.tencent.mm.plugin.comm.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.storage.ca;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract List<Pair<String, String>> Ci(long paramLong);
  
  public abstract List<Pair<String, String>> Cj(long paramLong);
  
  public abstract void Z(String paramString, long paramLong);
  
  public abstract void a(ca paramca, Runnable paramRunnable);
  
  public abstract void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2);
  
  public abstract void akR(String paramString);
  
  public abstract void as(ca paramca);
  
  public abstract void at(ca paramca);
  
  public abstract void au(ca paramca);
  
  public abstract void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract List<Pair<String, String>> cAL();
  
  public abstract void cV(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.a.b
 * JD-Core Version:    0.7.0.1
 */