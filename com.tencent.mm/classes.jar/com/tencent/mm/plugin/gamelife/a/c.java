package com.tencent.mm.plugin.gamelife.a;

import android.content.Context;
import com.tencent.mm.plugin.gamelife.e.b;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.List;

public abstract interface c
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(Context paramContext, com.tencent.mm.plugin.gamelife.e.a parama);
  
  public abstract void a(a parama);
  
  public abstract String aEB(String paramString);
  
  public abstract void aEy(String paramString);
  
  public abstract int aEz(String paramString);
  
  public abstract boolean aKG(String paramString);
  
  public abstract int eAi();
  
  public abstract b eAj();
  
  public abstract e eAk();
  
  public abstract boolean hk(String paramString1, String paramString2);
  
  public abstract void l(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void m(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public static abstract interface a
  {
    public abstract void fx(List<com.tencent.mm.plugin.gamelife.e.a> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.a.c
 * JD-Core Version:    0.7.0.1
 */