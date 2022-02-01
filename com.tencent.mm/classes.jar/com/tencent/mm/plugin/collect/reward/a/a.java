package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a
  extends n
  implements k
{
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected WeakReference<Activity> kwC;
  protected boolean pil = false;
  protected boolean pim = false;
  
  public final void O(Activity paramActivity)
  {
    this.kwC = new WeakReference(paramActivity);
  }
  
  public final a a(a parama)
  {
    if ((!this.pil) && (!this.pim)) {
      parama.g(this);
    }
    return this;
  }
  
  public final a b(a parama)
  {
    if (this.pim) {
      parama.g(this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final a c(a parama)
  {
    if (this.pil) {
      parama.g(this);
    }
    return this;
  }
  
  protected boolean cbV()
  {
    return true;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.pil = true;
      if ((cbV()) && (this.kwC != null))
      {
        paramArrayOfByte = (Activity)this.kwC.get();
        if (paramArrayOfByte != null) {
          h.a(paramArrayOfByte, paramArrayOfByte.getString(2131765901), null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    b(paramInt2, paramInt3, paramString, paramq);
  }
  
  public static abstract interface a
  {
    public abstract void g(n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.a
 * JD-Core Version:    0.7.0.1
 */