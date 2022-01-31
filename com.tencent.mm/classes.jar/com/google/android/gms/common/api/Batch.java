package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzaaf;
import java.util.List;

public final class Batch
  extends zzaaf<BatchResult>
{
  private int zzayM;
  private boolean zzayN;
  private boolean zzayO;
  private final PendingResult<?>[] zzayP;
  private final Object zzrJ = new Object();
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    this.zzayM = paramList.size();
    this.zzayP = new PendingResult[this.zzayM];
    if (paramList.isEmpty()) {
      zzb(new BatchResult(Status.zzazx, this.zzayP));
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramGoogleApiClient = (PendingResult)paramList.get(i);
        this.zzayP[i] = paramGoogleApiClient;
        paramGoogleApiClient.zza(new PendingResult.zza()
        {
          public void zzy(Status paramAnonymousStatus)
          {
            for (;;)
            {
              synchronized (Batch.zza(Batch.this))
              {
                if (Batch.this.isCanceled()) {
                  return;
                }
                if (paramAnonymousStatus.isCanceled())
                {
                  Batch.zza(Batch.this, true);
                  Batch.zzb(Batch.this);
                  if (Batch.zzc(Batch.this) == 0)
                  {
                    if (!Batch.zzd(Batch.this)) {
                      break;
                    }
                    Batch.zze(Batch.this);
                  }
                  return;
                }
              }
              if (!paramAnonymousStatus.isSuccess()) {
                Batch.zzb(Batch.this, true);
              }
            }
            if (Batch.zzf(Batch.this)) {}
            for (paramAnonymousStatus = new Status(13);; paramAnonymousStatus = Status.zzazx)
            {
              Batch.this.zzb(new BatchResult(paramAnonymousStatus, Batch.zzg(Batch.this)));
              break;
            }
          }
        });
        i += 1;
      }
    }
  }
  
  public final void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.zzayP;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }
  
  public final BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.zzayP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * JD-Core Version:    0.7.0.1
 */