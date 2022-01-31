package com.google.android.gms.internal;

import android.support.v4.f.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Set;

public final class zzaab
{
  private final a<zzzz<?>, ConnectionResult> zzayL = new a();
  private final TaskCompletionSource<Void> zzazS = new TaskCompletionSource();
  private int zzazT;
  private boolean zzazU = false;
  
  public zzaab(Iterable<? extends zzc<?>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      zzc localzzc = (zzc)paramIterable.next();
      this.zzayL.put(localzzc.getApiKey(), null);
    }
    this.zzazT = this.zzayL.keySet().size();
  }
  
  public final Task<Void> getTask()
  {
    return this.zzazS.getTask();
  }
  
  public final void zza(zzzz<?> paramzzzz, ConnectionResult paramConnectionResult)
  {
    this.zzayL.put(paramzzzz, paramConnectionResult);
    this.zzazT -= 1;
    if (!paramConnectionResult.isSuccess()) {
      this.zzazU = true;
    }
    if (this.zzazT == 0)
    {
      if (this.zzazU)
      {
        paramzzzz = new zzb(this.zzayL);
        this.zzazS.setException(paramzzzz);
      }
    }
    else {
      return;
    }
    this.zzazS.setResult(null);
  }
  
  public final void zzvA()
  {
    this.zzazS.setResult(null);
  }
  
  public final Set<zzzz<?>> zzvz()
  {
    return this.zzayL.keySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaab
 * JD-Core Version:    0.7.0.1
 */