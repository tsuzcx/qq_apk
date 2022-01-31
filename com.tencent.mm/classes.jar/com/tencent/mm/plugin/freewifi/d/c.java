package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ai;

public abstract class c
  extends com.tencent.mm.ah.m
  implements k
{
  protected Activity activity;
  protected b dmK;
  protected f dmL;
  protected f kpj;
  
  public final c A(Activity paramActivity)
  {
    this.activity = paramActivity;
    return this;
  }
  
  public final int a(e parame, f paramf)
  {
    this.kpj = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.plugin.freewifi.m.Dr("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + paramInt2 + "," + paramInt3 + "]");
    if (this.kpj != null) {
      this.kpj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((this.activity != null) && (this.activity.isFinishing())) {}
    while (this.dmL == null) {
      return;
    }
    ai.d(new c.1(this, paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte));
  }
  
  protected abstract void aUp();
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public final void b(f paramf)
  {
    this.dmL = paramf;
    com.tencent.mm.plugin.freewifi.m.Dr("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    au.Dk().a(this, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.c
 * JD-Core Version:    0.7.0.1
 */