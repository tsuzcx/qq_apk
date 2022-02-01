package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class c
  extends q
  implements com.tencent.mm.network.m
{
  protected Activity activity;
  protected i callback;
  protected d rr;
  protected i wPq;
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public final c ap(Activity paramActivity)
  {
    this.activity = paramActivity;
    return this;
  }
  
  public final void c(i parami)
  {
    this.callback = parami;
    com.tencent.mm.plugin.freewifi.m.axP("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
    bg.azz().a(this, 0);
  }
  
  protected abstract void dNu();
  
  public int doScene(g paramg, i parami)
  {
    this.wPq = parami;
    return dispatch(paramg, this.rr, this);
  }
  
  public void onGYNetEnd(final int paramInt1, final int paramInt2, final int paramInt3, final String paramString, final s params, final byte[] paramArrayOfByte)
  {
    com.tencent.mm.plugin.freewifi.m.axP("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + paramInt2 + "," + paramInt3 + "]");
    if (this.wPq != null) {
      this.wPq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if ((this.activity != null) && (this.activity.isFinishing())) {}
    while (this.callback == null) {
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24847);
        c.this.a(paramInt1, paramInt2, paramInt3, paramString);
        if (c.this.callback != null) {
          c.this.callback.onSceneEnd(paramInt2, paramInt3, paramString, c.this);
        }
        AppMethodBeat.o(24847);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.c
 * JD-Core Version:    0.7.0.1
 */