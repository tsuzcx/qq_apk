package com.tencent.mm.plugin.forcenotify.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.e.j;

public abstract interface b
  extends a, p, v<cs>
{
  public abstract void aD(String paramString, int paramInt);
  
  public abstract void aah(String paramString);
  
  public abstract long aai(String paramString);
  
  public abstract boolean aaj(String paramString);
  
  public abstract boolean cuW();
  
  public abstract j cuX();
  
  public abstract void eQ(Context paramContext);
  
  public abstract boolean hasError();
  
  public abstract void ly(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.a.b
 * JD-Core Version:    0.7.0.1
 */