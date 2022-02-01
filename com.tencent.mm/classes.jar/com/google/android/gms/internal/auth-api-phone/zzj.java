package com.google.android.gms.internal.auth-api-phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzj
  extends SmsRetrieverClient
{
  public zzj(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public zzj(Context paramContext)
  {
    super(paramContext);
  }
  
  public final Task<Void> startSmsRetriever()
  {
    AppMethodBeat.i(940);
    Task localTask = doWrite(new zzk(this));
    AppMethodBeat.o(940);
    return localTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api-phone.zzj
 * JD-Core Version:    0.7.0.1
 */