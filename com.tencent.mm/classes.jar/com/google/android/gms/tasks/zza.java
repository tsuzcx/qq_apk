package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza
  extends CancellationToken
{
  private final zzu<Void> zzafh;
  
  zza()
  {
    AppMethodBeat.i(57376);
    this.zzafh = new zzu();
    AppMethodBeat.o(57376);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(57379);
    this.zzafh.trySetResult(null);
    AppMethodBeat.o(57379);
  }
  
  public final boolean isCancellationRequested()
  {
    AppMethodBeat.i(57377);
    boolean bool = this.zzafh.isComplete();
    AppMethodBeat.o(57377);
    return bool;
  }
  
  public final CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener)
  {
    AppMethodBeat.i(57378);
    this.zzafh.addOnSuccessListener(new zzb(this, paramOnTokenCanceledListener));
    AppMethodBeat.o(57378);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.zza
 * JD-Core Version:    0.7.0.1
 */