package com.tencent.mm.plugin.gamelife.a;

import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.List;
import java.util.Map;

public abstract interface b
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(String paramString, b.a parama);
  
  public abstract void a(String paramString, c paramc);
  
  public abstract void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, b paramb);
  
  public abstract void a(List<String> paramList, c paramc);
  
  public abstract a aAR(String paramString);
  
  public abstract void aAS(String paramString);
  
  public abstract void l(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void m(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public static abstract interface b
  {
    public abstract void mM(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void aj(Map<String, a> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.a.b
 * JD-Core Version:    0.7.0.1
 */