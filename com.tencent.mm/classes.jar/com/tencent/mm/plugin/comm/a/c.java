package com.tencent.mm.plugin.comm.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.storage.cc;
import java.util.List;

public abstract interface c
  extends a
{
  public abstract void a(cc paramcc, Runnable paramRunnable);
  
  public abstract void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2);
  
  public abstract void aJ(cc paramcc);
  
  public abstract void aK(cc paramcc);
  
  public abstract void aL(cc paramcc);
  
  public abstract void ae(String paramString, long paramLong);
  
  public abstract void amp(String paramString);
  
  public abstract void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void dQ(String paramString, int paramInt);
  
  public abstract List<Pair<String, String>> dsU();
  
  public abstract List<Pair<String, String>> kJ(long paramLong);
  
  public abstract List<Pair<String, String>> kK(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.a.c
 * JD-Core Version:    0.7.0.1
 */