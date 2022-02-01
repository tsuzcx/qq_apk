package com.google.firebase.iid;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends c<Bundle>
{
  e(int paramInt, Bundle paramBundle)
  {
    super(paramInt, 1, paramBundle);
  }
  
  final void zzb(Bundle paramBundle)
  {
    AppMethodBeat.i(4151);
    Bundle localBundle = paramBundle.getBundle("data");
    paramBundle = localBundle;
    if (localBundle == null) {
      paramBundle = Bundle.EMPTY;
    }
    aO(paramBundle);
    AppMethodBeat.o(4151);
  }
  
  final boolean zzw()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.e
 * JD-Core Version:    0.7.0.1
 */