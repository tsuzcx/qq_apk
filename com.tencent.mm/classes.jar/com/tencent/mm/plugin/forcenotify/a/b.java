package com.tencent.mm.plugin.forcenotify.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.j;

public abstract interface b
  extends a, q, y<cv>
{
  public abstract void aM(String paramString, int paramInt);
  
  public abstract void akv(String paramString);
  
  public abstract long akw(String paramString);
  
  public abstract boolean akx(String paramString);
  
  public abstract boolean cTc();
  
  public abstract j cTd();
  
  public abstract void fk(Context paramContext);
  
  public abstract boolean hasError();
  
  public abstract void mL(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.a.b
 * JD-Core Version:    0.7.0.1
 */