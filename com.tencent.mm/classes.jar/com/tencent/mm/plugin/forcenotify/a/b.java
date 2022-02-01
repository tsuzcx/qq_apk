package com.tencent.mm.plugin.forcenotify.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.j;

public abstract interface b
  extends a, q, x<cv>
{
  public abstract void aJ(String paramString, int paramInt);
  
  public abstract void ajx(String paramString);
  
  public abstract long ajy(String paramString);
  
  public abstract boolean ajz(String paramString);
  
  public abstract boolean cQx();
  
  public abstract j cQy();
  
  public abstract void fg(Context paramContext);
  
  public abstract boolean hasError();
  
  public abstract void mH(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.a.b
 * JD-Core Version:    0.7.0.1
 */