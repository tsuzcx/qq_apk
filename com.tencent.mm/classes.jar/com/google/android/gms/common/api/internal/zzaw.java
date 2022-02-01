package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaw
  implements GmsClientEventManager.GmsClientEventState
{
  zzaw(zzav paramzzav) {}
  
  public final Bundle getConnectionHint()
  {
    return null;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(11301);
    boolean bool = this.zzit.isConnected();
    AppMethodBeat.o(11301);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzaw
 * JD-Core Version:    0.7.0.1
 */