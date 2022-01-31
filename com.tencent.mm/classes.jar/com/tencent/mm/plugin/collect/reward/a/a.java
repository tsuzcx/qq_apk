package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a
  extends m
  implements k
{
  protected String aox;
  protected int errCode = 0;
  protected int errType = 0;
  protected WeakReference<Activity> ggz;
  protected boolean iHX = false;
  protected boolean iHY = false;
  
  public final a a(a.a parama)
  {
    if ((!this.iHX) && (!this.iHY)) {
      parama.i(this);
    }
    return this;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.iHX = true;
      if ((aED()) && (this.ggz != null))
      {
        paramArrayOfByte = (Activity)this.ggz.get();
        if (paramArrayOfByte != null) {
          h.a(paramArrayOfByte, paramArrayOfByte.getString(a.i.wallet_unknown_err), null, false, new a.1(this));
        }
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.aox = paramString;
    b(paramInt2, paramInt3, paramString, paramq);
  }
  
  protected boolean aED()
  {
    return true;
  }
  
  public final a b(a.a parama)
  {
    if (this.iHY) {
      parama.i(this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final a c(a.a parama)
  {
    if (this.iHX) {
      parama.i(this);
    }
    return this;
  }
  
  public final void w(Activity paramActivity)
  {
    this.ggz = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.a
 * JD-Core Version:    0.7.0.1
 */