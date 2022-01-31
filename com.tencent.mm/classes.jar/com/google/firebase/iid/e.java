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
    AppMethodBeat.i(108715);
    Bundle localBundle = paramBundle.getBundle("data");
    paramBundle = localBundle;
    if (localBundle == null) {
      paramBundle = Bundle.EMPTY;
    }
    n(paramBundle);
    AppMethodBeat.o(108715);
  }
  
  final boolean zzw()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.firebase.iid.e
 * JD-Core Version:    0.7.0.1
 */