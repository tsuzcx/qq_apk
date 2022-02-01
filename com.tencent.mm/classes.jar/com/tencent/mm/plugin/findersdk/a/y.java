package com.tencent.mm.plugin.findersdk.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx.a;
import java.util.List;

public abstract interface y
  extends a
{
  public abstract void a(ch paramch);
  
  public abstract void a(String paramString, long paramLong1, long paramLong2, long paramLong3, a parama);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString, Boolean paramBoolean);
  
  public abstract void a(String paramString, Long paramLong);
  
  public abstract void a(String paramString, Long paramLong1, Long paramLong2, a parama);
  
  public abstract void a(String paramString1, String paramString2, a parama);
  
  public abstract ch aAl(String paramString);
  
  public abstract ch aAm(String paramString);
  
  public abstract ch aAn(String paramString);
  
  public abstract ch aAo(String paramString);
  
  public abstract boolean aAp(String paramString);
  
  public abstract void b(String paramString, a parama);
  
  public abstract void b(String paramString1, String paramString2, a parama);
  
  public abstract void c(String paramString, a parama);
  
  public abstract void c(String paramString1, String paramString2, a parama);
  
  public abstract void ePr();
  
  public abstract String ePs();
  
  public abstract bx.a ePt();
  
  public abstract List<au> ePu();
  
  public abstract void f(List<String> paramList, long paramLong);
  
  public abstract void l(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void m(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public static abstract interface a
  {
    public abstract void onDone(ch paramch);
  }
  
  public static abstract interface b
  {
    public abstract void onDone(List<ch> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.y
 * JD-Core Version:    0.7.0.1
 */