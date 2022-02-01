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
  protected WeakReference<Activity> jyt;
  protected boolean nUQ = false;
  protected boolean nUR = false;
  
  public final void N(Activity paramActivity)
  {
    this.jyt = new WeakReference(paramActivity);
  }
  
  public final a a(a parama)
  {
    if ((!this.nUQ) && (!this.nUR)) {
      parama.h(this);
    }
    return this;
  }
  
  public final a b(a parama)
  {
    if (this.nUR) {
      parama.h(this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  protected boolean bON()
  {
    return true;
  }
  
  public final a c(a parama)
  {
    if (this.nUQ) {
      parama.h(this);
    }
    return this;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.nUQ = true;
      if ((bON()) && (this.jyt != null))
      {
        paramArrayOfByte = (Activity)this.jyt.get();
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
    public abstract void h(n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.a
 * JD-Core Version:    0.7.0.1
 */