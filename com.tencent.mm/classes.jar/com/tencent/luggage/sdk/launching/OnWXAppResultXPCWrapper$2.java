package com.tencent.luggage.sdk.launching;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class OnWXAppResultXPCWrapper$2
  implements b<R>
{
  OnWXAppResultXPCWrapper$2(OnWXAppResultXPCWrapper paramOnWXAppResultXPCWrapper) {}
  
  public final void b(R paramR)
  {
    AppMethodBeat.i(101670);
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("parcel", new OnWXAppResultXPCWrapper.SafeParcelableWrapper(paramR));
    OnWXAppResultXPCWrapper.a(this.bEX).send(-1, localBundle);
    AppMethodBeat.o(101670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.2
 * JD-Core Version:    0.7.0.1
 */