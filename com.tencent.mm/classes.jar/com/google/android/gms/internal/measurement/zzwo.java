package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzwo
  extends ContentObserver
{
  zzwo(Handler paramHandler)
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(2275);
    zzwn.zzrs().set(true);
    AppMethodBeat.o(2275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwo
 * JD-Core Version:    0.7.0.1
 */