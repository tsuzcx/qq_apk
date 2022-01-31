package com.tencent.mm.plugin.forcenotify.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.e.j;

public abstract interface b
  extends a, o, s<cm>
{
  public abstract void Ol(String paramString);
  
  public abstract long Om(String paramString);
  
  public abstract boolean On(String paramString);
  
  public abstract void an(String paramString, int paramInt);
  
  public abstract boolean bzH();
  
  public abstract j bzI();
  
  public abstract void dW(Context paramContext);
  
  public abstract void hO(boolean paramBoolean);
  
  public abstract boolean hasError();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.a.b
 * JD-Core Version:    0.7.0.1
 */