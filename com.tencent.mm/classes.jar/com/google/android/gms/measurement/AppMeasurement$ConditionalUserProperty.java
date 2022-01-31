package com.google.android.gms.measurement;

import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzka;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class AppMeasurement$ConditionalUserProperty
{
  @Keep
  @KeepForSdk
  public boolean mActive;
  @Keep
  @KeepForSdk
  public String mAppId;
  @Keep
  @KeepForSdk
  public long mCreationTimestamp;
  @Keep
  public String mExpiredEventName;
  @Keep
  public Bundle mExpiredEventParams;
  @Keep
  @KeepForSdk
  public String mName;
  @Keep
  @KeepForSdk
  public String mOrigin;
  @Keep
  @KeepForSdk
  public long mTimeToLive;
  @Keep
  public String mTimedOutEventName;
  @Keep
  public Bundle mTimedOutEventParams;
  @Keep
  @KeepForSdk
  public String mTriggerEventName;
  @Keep
  @KeepForSdk
  public long mTriggerTimeout;
  @Keep
  public String mTriggeredEventName;
  @Keep
  public Bundle mTriggeredEventParams;
  @Keep
  @KeepForSdk
  public long mTriggeredTimestamp;
  @Keep
  @KeepForSdk
  public Object mValue;
  
  public AppMeasurement$ConditionalUserProperty() {}
  
  public AppMeasurement$ConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
  {
    AppMethodBeat.i(69776);
    Preconditions.checkNotNull(paramConditionalUserProperty);
    this.mAppId = paramConditionalUserProperty.mAppId;
    this.mOrigin = paramConditionalUserProperty.mOrigin;
    this.mCreationTimestamp = paramConditionalUserProperty.mCreationTimestamp;
    this.mName = paramConditionalUserProperty.mName;
    if (paramConditionalUserProperty.mValue != null)
    {
      this.mValue = zzka.zzf(paramConditionalUserProperty.mValue);
      if (this.mValue == null) {
        this.mValue = paramConditionalUserProperty.mValue;
      }
    }
    this.mActive = paramConditionalUserProperty.mActive;
    this.mTriggerEventName = paramConditionalUserProperty.mTriggerEventName;
    this.mTriggerTimeout = paramConditionalUserProperty.mTriggerTimeout;
    this.mTimedOutEventName = paramConditionalUserProperty.mTimedOutEventName;
    if (paramConditionalUserProperty.mTimedOutEventParams != null) {
      this.mTimedOutEventParams = new Bundle(paramConditionalUserProperty.mTimedOutEventParams);
    }
    this.mTriggeredEventName = paramConditionalUserProperty.mTriggeredEventName;
    if (paramConditionalUserProperty.mTriggeredEventParams != null) {
      this.mTriggeredEventParams = new Bundle(paramConditionalUserProperty.mTriggeredEventParams);
    }
    this.mTriggeredTimestamp = paramConditionalUserProperty.mTriggeredTimestamp;
    this.mTimeToLive = paramConditionalUserProperty.mTimeToLive;
    this.mExpiredEventName = paramConditionalUserProperty.mExpiredEventName;
    if (paramConditionalUserProperty.mExpiredEventParams != null) {
      this.mExpiredEventParams = new Bundle(paramConditionalUserProperty.mExpiredEventParams);
    }
    AppMethodBeat.o(69776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty
 * JD-Core Version:    0.7.0.1
 */