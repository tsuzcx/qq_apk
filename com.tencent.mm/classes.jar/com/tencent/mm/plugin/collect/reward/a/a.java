package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.k;
import java.lang.ref.WeakReference;

public abstract class a
  extends p
  implements m
{
  protected WeakReference<Activity> context;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean oaK = false;
  protected boolean wZR = false;
  
  public final void C(Activity paramActivity)
  {
    this.context = new WeakReference(paramActivity);
  }
  
  public final a a(a parama)
  {
    if ((!this.oaK) && (!this.wZR)) {
      parama.g(this);
    }
    return this;
  }
  
  public final a b(a parama)
  {
    if (this.wZR) {
      parama.g(this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, s params);
  
  public final a c(a parama)
  {
    if (this.oaK) {
      parama.g(this);
    }
    return this;
  }
  
  protected boolean drU()
  {
    return true;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.oaK = true;
      if ((drU()) && (this.context != null))
      {
        paramArrayOfByte = (Activity)this.context.get();
        if (paramArrayOfByte != null) {
          k.a(paramArrayOfByte, paramArrayOfByte.getString(a.i.wallet_unknown_err), null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    b(paramInt2, paramInt3, paramString, params);
  }
  
  public static abstract interface a
  {
    public abstract void g(p paramp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.a
 * JD-Core Version:    0.7.0.1
 */