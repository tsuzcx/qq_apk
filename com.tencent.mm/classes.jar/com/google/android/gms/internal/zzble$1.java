package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzble$1
  extends ContentObserver
{
  zzble$1(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    zzble.zzUG().set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzble.1
 * JD-Core Version:    0.7.0.1
 */