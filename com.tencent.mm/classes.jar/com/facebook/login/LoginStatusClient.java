package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginStatusClient
  extends PlatformServiceClient
{
  static final long DEFAULT_TOAST_DURATION_MS = 5000L;
  private final String graphApiVersion;
  private final String loggerRef;
  private final long toastDurationMs;
  
  LoginStatusClient(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    super(paramContext, 65546, 65547, 20170411, paramString1);
    this.loggerRef = paramString2;
    this.graphApiVersion = paramString3;
    this.toastDurationMs = paramLong;
  }
  
  public final void populateRequestBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(7953);
    paramBundle.putString("com.facebook.platform.extra.LOGGER_REF", this.loggerRef);
    paramBundle.putString("com.facebook.platform.extra.GRAPH_API_VERSION", this.graphApiVersion);
    paramBundle.putLong("com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS", this.toastDurationMs);
    AppMethodBeat.o(7953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.login.LoginStatusClient
 * JD-Core Version:    0.7.0.1
 */