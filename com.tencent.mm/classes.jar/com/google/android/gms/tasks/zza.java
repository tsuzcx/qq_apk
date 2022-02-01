package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza
  extends CancellationToken
{
  private final zzu<Void> zzafh;
  
  zza()
  {
    AppMethodBeat.i(13375);
    this.zzafh = new zzu();
    AppMethodBeat.o(13375);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(13378);
    this.zzafh.trySetResult(null);
    AppMethodBeat.o(13378);
  }
  
  public final boolean isCancellationRequested()
  {
    AppMethodBeat.i(13376);
    boolean bool = this.zzafh.isComplete();
    AppMethodBeat.o(13376);
    return bool;
  }
  
  public final CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener)
  {
    AppMethodBeat.i(13377);
    this.zzafh.addOnSuccessListener(new zzb(this, paramOnTokenCanceledListener));
    AppMethodBeat.o(13377);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tasks.zza
 * JD-Core Version:    0.7.0.1
 */