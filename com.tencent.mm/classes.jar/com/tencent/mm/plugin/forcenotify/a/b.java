package com.tencent.mm.plugin.forcenotify.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.ac;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.storage.MAutoStorage;

public abstract interface b
  extends a, ac<db>, t
{
  public abstract void aHn(String paramString);
  
  public abstract boolean aHo(String paramString);
  
  public abstract boolean aHp(String paramString);
  
  public abstract String aHq(String paramString);
  
  public abstract long aHr(String paramString);
  
  public abstract boolean aHs(String paramString);
  
  public abstract void bk(String paramString, int paramInt);
  
  public abstract MAutoStorage eqe();
  
  public abstract void rM(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.a.b
 * JD-Core Version:    0.7.0.1
 */