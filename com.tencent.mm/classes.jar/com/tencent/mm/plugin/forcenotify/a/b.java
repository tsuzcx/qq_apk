package com.tencent.mm.plugin.forcenotify.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.e.j;

public abstract interface b
  extends a, p, v<cu>
{
  public abstract void aH(String paramString, int paramInt);
  
  public abstract void aeZ(String paramString);
  
  public abstract long afa(String paramString);
  
  public abstract boolean afb(String paramString);
  
  public abstract boolean cIi();
  
  public abstract j cIj();
  
  public abstract void fd(Context paramContext);
  
  public abstract boolean hasError();
  
  public abstract void mq(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.a.b
 * JD-Core Version:    0.7.0.1
 */