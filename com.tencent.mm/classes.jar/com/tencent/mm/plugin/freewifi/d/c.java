package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class c
  extends n
  implements k
{
  protected Activity activity;
  protected f callback;
  protected b rr;
  protected f tnv;
  
  public final c aq(Activity paramActivity)
  {
    this.activity = paramActivity;
    return this;
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public final void c(f paramf)
  {
    this.callback = paramf;
    m.ajN("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    ba.aiU().a(this, 0);
  }
  
  protected abstract void cRG();
  
  public int doScene(e parame, f paramf)
  {
    this.tnv = paramf;
    return dispatch(parame, this.rr, this);
  }
  
  public void onGYNetEnd(final int paramInt1, final int paramInt2, final int paramInt3, final String paramString, final com.tencent.mm.network.q paramq, final byte[] paramArrayOfByte)
  {
    m.ajN("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + paramInt2 + "," + paramInt3 + "]");
    if (this.tnv != null) {
      this.tnv.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((this.activity != null) && (this.activity.isFinishing())) {}
    while (this.callback == null) {
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24847);
        c.this.b(paramInt1, paramInt2, paramInt3, paramString);
        if (c.this.callback != null) {
          c.this.callback.onSceneEnd(paramInt2, paramInt3, paramString, c.this);
        }
        AppMethodBeat.o(24847);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.c
 * JD-Core Version:    0.7.0.1
 */