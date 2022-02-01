package com.tencent.mm.plugin.comm.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.storage.bo;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract void T(String paramString, long paramLong);
  
  public abstract void Wm(String paramString);
  
  public abstract void a(bo parambo, Runnable paramRunnable);
  
  public abstract void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2);
  
  public abstract void af(bo parambo);
  
  public abstract void ag(bo parambo);
  
  public abstract void ah(bo parambo);
  
  public abstract void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract List<Pair<String, String>> bWY();
  
  public abstract void cJ(String paramString, int paramInt);
  
  public abstract List<Pair<String, String>> rN(long paramLong);
  
  public abstract List<Pair<String, String>> rO(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.a.b
 * JD-Core Version:    0.7.0.1
 */