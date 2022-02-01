package com.tencent.mm.plugin.forcenotify.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.storage.MAutoStorage;

public abstract interface b
  extends a, q, y<de>
{
  public abstract void aS(String paramString, int paramInt);
  
  public abstract void axA(String paramString);
  
  public abstract long axB(String paramString);
  
  public abstract boolean axC(String paramString);
  
  public abstract boolean dMl();
  
  public abstract MAutoStorage dMm();
  
  public abstract void fQ(Context paramContext);
  
  public abstract boolean hasError();
  
  public abstract void ps(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.a.b
 * JD-Core Version:    0.7.0.1
 */