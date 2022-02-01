package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a
  extends q
  implements m
{
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected WeakReference<Activity> lAM;
  protected boolean qxx = false;
  protected boolean qxy = false;
  
  public final void M(Activity paramActivity)
  {
    this.lAM = new WeakReference(paramActivity);
  }
  
  public final a a(a parama)
  {
    if ((!this.qxx) && (!this.qxy)) {
      parama.g(this);
    }
    return this;
  }
  
  public final a b(a parama)
  {
    if (this.qxy) {
      parama.g(this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, s params);
  
  public final a c(a parama)
  {
    if (this.qxx) {
      parama.g(this);
    }
    return this;
  }
  
  protected boolean czP()
  {
    return true;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.qxx = true;
      if ((czP()) && (this.lAM != null))
      {
        paramArrayOfByte = (Activity)this.lAM.get();
        if (paramArrayOfByte != null) {
          h.a(paramArrayOfByte, paramArrayOfByte.getString(2131768354), null, false, new DialogInterface.OnClickListener()
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