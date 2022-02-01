package com.tencent.mm.plugin.fingerprint.mgr.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;
import java.util.Map;

public abstract interface i
  extends a
{
  public abstract void a(Context paramContext, f paramf, b paramb);
  
  public abstract void a(Context paramContext, f paramf, d paramd);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle);
  
  public abstract void b(Context paramContext, f paramf, b paramb);
  
  public abstract void cancel();
  
  public abstract Map<String, String> ftA();
  
  public abstract boolean ftP();
  
  public abstract boolean ftQ();
  
  public abstract boolean ftR();
  
  public abstract boolean ftS();
  
  public abstract boolean ftT();
  
  public abstract boolean ftU();
  
  public abstract int ftV();
  
  public abstract com.tencent.mm.plugin.fingerprint.c.d ftW();
  
  public abstract boolean ftX();
  
  public abstract boolean fts();
  
  public abstract boolean hC(Context paramContext);
  
  public abstract boolean hD(Context paramContext);
  
  public abstract boolean isSupport();
  
  public abstract void prepare();
  
  public abstract void s(Object... paramVarArgs);
  
  public abstract void vA(boolean paramBoolean);
  
  public abstract void vB(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.a.i
 * JD-Core Version:    0.7.0.1
 */