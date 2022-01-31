package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzaao
  implements Releasable, Result
{
  protected final DataHolder zzaBi;
  protected final Status zzair;
  
  protected zzaao(DataHolder paramDataHolder, Status paramStatus)
  {
    this.zzair = paramStatus;
    this.zzaBi = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
  
  public void release()
  {
    if (this.zzaBi != null) {
      this.zzaBi.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzaao
 * JD-Core Version:    0.7.0.1
 */