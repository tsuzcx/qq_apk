package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.al;

public abstract class c
  extends com.tencent.mm.ai.m
  implements k
{
  protected Activity activity;
  protected f callback;
  protected f mKW;
  protected b rr;
  
  public final c U(Activity paramActivity)
  {
    this.activity = paramActivity;
    return this;
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  protected abstract void bAR();
  
  public final void c(f paramf)
  {
    this.callback = paramf;
    com.tencent.mm.plugin.freewifi.m.Oz("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    aw.Rc().a(this, 0);
  }
  
  public int doScene(e parame, f paramf)
  {
    this.mKW = paramf;
    return dispatch(parame, this.rr, this);
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.plugin.freewifi.m.Oz("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + paramInt2 + "," + paramInt3 + "]");
    if (this.mKW != null) {
      this.mKW.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((this.activity != null) && (this.activity.isFinishing())) {}
    while (this.callback == null) {
      return;
    }
    al.d(new c.1(this, paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.c
 * JD-Core Version:    0.7.0.1
 */