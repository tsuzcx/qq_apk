package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.auth-api-phone.zzj;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SmsRetriever
{
  public static final String EXTRA_SMS_MESSAGE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE";
  public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";
  public static final String SMS_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_RETRIEVED";
  
  public static SmsRetrieverClient getClient(Activity paramActivity)
  {
    AppMethodBeat.i(929);
    paramActivity = new zzj(paramActivity);
    AppMethodBeat.o(929);
    return paramActivity;
  }
  
  public static SmsRetrieverClient getClient(Context paramContext)
  {
    AppMethodBeat.i(928);
    paramContext = new zzj(paramContext);
    AppMethodBeat.o(928);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.phone.SmsRetriever
 * JD-Core Version:    0.7.0.1
 */