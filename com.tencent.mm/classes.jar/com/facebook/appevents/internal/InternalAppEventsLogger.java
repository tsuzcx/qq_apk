package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.util.Currency;

class InternalAppEventsLogger
  extends AppEventsLogger
{
  InternalAppEventsLogger(Context paramContext)
  {
    this(Utility.getActivityName(paramContext), null, null);
    AppMethodBeat.i(72211);
    AppMethodBeat.o(72211);
  }
  
  InternalAppEventsLogger(String paramString1, String paramString2, AccessToken paramAccessToken)
  {
    super(paramString1, paramString2, paramAccessToken);
  }
  
  public void logEventImplicitly(String paramString, BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(72213);
    super.logEventImplicitly(paramString, paramBigDecimal, paramCurrency, paramBundle);
    AppMethodBeat.o(72213);
  }
  
  public void logPurchaseImplicitlyInternal(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle)
  {
    AppMethodBeat.i(72212);
    super.logPurchaseImplicitlyInternal(paramBigDecimal, paramCurrency, paramBundle);
    AppMethodBeat.o(72212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.internal.InternalAppEventsLogger
 * JD-Core Version:    0.7.0.1
 */