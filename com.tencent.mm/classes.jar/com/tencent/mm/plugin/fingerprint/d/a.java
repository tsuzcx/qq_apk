package com.tencent.mm.plugin.fingerprint.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import java.util.Map;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract int a(c paramc);
  
  public abstract int a(c paramc, boolean paramBoolean);
  
  public abstract void a(oe paramoe, int paramInt);
  
  public abstract void a(oe paramoe, int paramInt, String paramString);
  
  public abstract void a(i parami);
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);
  
  public abstract void cRS();
  
  public abstract boolean cRT();
  
  public abstract boolean cRU();
  
  public abstract boolean cRV();
  
  public abstract boolean cRW();
  
  public abstract String cRX();
  
  public abstract boolean cRY();
  
  public abstract boolean cRZ();
  
  public abstract void cSa();
  
  public abstract boolean cSb();
  
  public abstract boolean cSc();
  
  public abstract Map<String, String> cSd();
  
  public abstract Map<String, String> cSe();
  
  public abstract boolean cSf();
  
  public abstract boolean cSg();
  
  public abstract boolean cSh();
  
  public abstract void ff(Context paramContext);
  
  public abstract void mC(boolean paramBoolean);
  
  public abstract void mD(boolean paramBoolean);
  
  public abstract int type();
  
  public abstract void userCancel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.d.a
 * JD-Core Version:    0.7.0.1
 */