package com.google.firebase.iid;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends c<Void>
{
  public b(int paramInt, Bundle paramBundle)
  {
    super(paramInt, 2, paramBundle);
  }
  
  final void zzb(Bundle paramBundle)
  {
    AppMethodBeat.i(4150);
    if (paramBundle.getBoolean("ack", false))
    {
      aO(null);
      AppMethodBeat.o(4150);
      return;
    }
    a(new d(4, "Invalid response to one way request"));
    AppMethodBeat.o(4150);
  }
  
  final boolean zzw()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.b
 * JD-Core Version:    0.7.0.1
 */