package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a
  extends m
  implements k
{
  protected int errCode = 0;
  protected String errMsg;
  protected int errType = 0;
  protected WeakReference<Activity> hyV;
  protected boolean kOC = false;
  protected boolean kOD = false;
  
  public final a a(a.a parama)
  {
    if ((!this.kOC) && (!this.kOD)) {
      parama.h(this);
    }
    return this;
  }
  
  public final a b(a.a parama)
  {
    if (this.kOD) {
      parama.h(this);
    }
    return this;
  }
  
  protected abstract void b(int paramInt1, int paramInt2, String paramString, q paramq);
  
  protected boolean bhR()
  {
    return true;
  }
  
  public final a c(a.a parama)
  {
    if (this.kOC) {
      parama.h(this);
    }
    return this;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.kOC = true;
      if ((bhR()) && (this.hyV != null))
      {
        paramArrayOfByte = (Activity)this.hyV.get();
        if (paramArrayOfByte != null) {
          h.a(paramArrayOfByte, paramArrayOfByte.getString(2131305682), null, false, new a.1(this));
        }
      }
    }
    this.errCode = paramInt3;
    this.errType = paramInt2;
    this.errMsg = paramString;
    b(paramInt2, paramInt3, paramString, paramq);
  }
  
  public final void z(Activity paramActivity)
  {
    this.hyV = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.a
 * JD-Core Version:    0.7.0.1
 */