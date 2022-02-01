package com.tencent.mm.plugin.comm.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.storage.bl;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract void S(String paramString, long paramLong);
  
  public abstract void Sa(String paramString);
  
  public abstract void a(bl parambl, Runnable paramRunnable);
  
  public abstract void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2);
  
  public abstract void af(bl parambl);
  
  public abstract void ag(bl parambl);
  
  public abstract void ah(bl parambl);
  
  public abstract List<Pair<String, String>> bPI();
  
  public abstract void cE(String paramString, int paramInt);
  
  public abstract void d(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract List<Pair<String, String>> ob(long paramLong);
  
  public abstract List<Pair<String, String>> oc(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.a.b
 * JD-Core Version:    0.7.0.1
 */