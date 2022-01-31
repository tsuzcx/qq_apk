package com.facebook;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookSdk$5
  implements Runnable
{
  FacebookSdk$5(Context paramContext, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(71604);
    FacebookSdk.publishInstallAndWaitForResponse(this.val$applicationContext, this.val$applicationId);
    AppMethodBeat.o(71604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.FacebookSdk.5
 * JD-Core Version:    0.7.0.1
 */