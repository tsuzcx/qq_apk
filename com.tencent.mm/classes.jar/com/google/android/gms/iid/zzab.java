package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzab
  extends zzz<Bundle>
{
  zzab(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 1, paramBundle);
  }
  
  final void zzh(Bundle paramBundle)
  {
    AppMethodBeat.i(2482);
    Object localObject = paramBundle.getBundle("data");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = Bundle.EMPTY;
    }
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      localObject = String.valueOf(this);
      String str = String.valueOf(paramBundle);
      new StringBuilder(String.valueOf(localObject).length() + 16 + String.valueOf(str).length()).append("Finishing ").append((String)localObject).append(" with ").append(str);
    }
    this.zzcl.setResult(paramBundle);
    AppMethodBeat.o(2482);
  }
  
  final boolean zzu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.iid.zzab
 * JD-Core Version:    0.7.0.1
 */