package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a
  extends q
  implements m
{
  protected WeakReference<Activity> context;
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected boolean tWx = false;
  protected boolean tWy = false;
  
  public final void N(Activity paramActivity)
  {
    this.context = new WeakReference(paramActivity);
  }
  
  public final a a(a parama)
  {
    if ((!this.tWx) && (!this.tWy)) {
      parama.g(this);
    }
    return this;
  }
  
  public final a b(a parama)
  {
    if (this.tWy) {
      parama.g(this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, s params);
  
  public final a c(a parama)
  {
    if (this.tWx) {
      parama.g(this);
    }
    return this;
  }
  
  protected boolean cOp()
  {
    return true;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.tWx = true;
      if ((cOp()) && (this.context != null))
      {
        paramArrayOfByte = (Activity)this.context.get();
        if (paramArrayOfByte != null) {
          h.a(paramArrayOfByte, paramArrayOfByte.getString(a.i.wallet_unknown_err), null, false, new DialogInterface.OnClickListener()
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
    public abstract void g(q paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.a
 * JD-Core Version:    0.7.0.1
 */