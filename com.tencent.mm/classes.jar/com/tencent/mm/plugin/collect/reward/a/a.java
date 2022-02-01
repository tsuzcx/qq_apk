package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.al.n;
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
  protected WeakReference<Activity> ktm;
  protected boolean pbG = false;
  protected boolean pbH = false;
  
  public final void N(Activity paramActivity)
  {
    this.ktm = new WeakReference(paramActivity);
  }
  
  public final a a(a parama)
  {
    if ((!this.pbG) && (!this.pbH)) {
      parama.g(this);
    }
    return this;
  }
  
  public final a b(a parama)
  {
    if (this.pbH) {
      parama.g(this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public final a c(a parama)
  {
    if (this.pbG) {
      parama.g(this);
    }
    return this;
  }
  
  protected boolean caG()
  {
    return true;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.pbG = true;
      if ((caG()) && (this.ktm != null))
      {
        paramArrayOfByte = (Activity)this.ktm.get();
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