package com.tencent.map.geolocation.sapp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TencentLocationRequest
{
  public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
  public static final int REQUEST_LEVEL_GEO = 0;
  public static final int REQUEST_LEVEL_NAME = 1;
  public static final int REQUEST_LEVEL_POI = 4;
  public boolean mAllowCache;
  public boolean mAllowDirection;
  public boolean mAllowGps;
  public long mExpirationTime;
  public Bundle mExtras;
  public boolean mForeginRequest;
  public boolean mIndoorLocationMode;
  public long mInterval;
  public int mNumUpdates;
  public String mQQ;
  public int mRequestLevel;
  public String mSmallAppKey;
  
  public TencentLocationRequest() {}
  
  public TencentLocationRequest(TencentLocationRequest paramTencentLocationRequest)
  {
    AppMethodBeat.i(210865);
    this.mInterval = paramTencentLocationRequest.mInterval;
    this.mRequestLevel = paramTencentLocationRequest.mRequestLevel;
    this.mAllowCache = paramTencentLocationRequest.mAllowCache;
    this.mAllowDirection = paramTencentLocationRequest.mAllowDirection;
    this.mExpirationTime = paramTencentLocationRequest.mExpirationTime;
    this.mNumUpdates = paramTencentLocationRequest.mNumUpdates;
    this.mAllowGps = paramTencentLocationRequest.mAllowGps;
    this.mIndoorLocationMode = paramTencentLocationRequest.mIndoorLocationMode;
    this.mForeginRequest = paramTencentLocationRequest.mForeginRequest;
    this.mQQ = paramTencentLocationRequest.mQQ;
    this.mSmallAppKey = paramTencentLocationRequest.mSmallAppKey;
    this.mExtras = new Bundle();
    this.mExtras.putAll(paramTencentLocationRequest.mExtras);
    AppMethodBeat.o(210865);
  }
  
  public static void copy(TencentLocationRequest paramTencentLocationRequest1, TencentLocationRequest paramTencentLocationRequest2)
  {
    AppMethodBeat.i(210871);
    paramTencentLocationRequest1.mInterval = paramTencentLocationRequest2.mInterval;
    paramTencentLocationRequest1.mRequestLevel = paramTencentLocationRequest2.mRequestLevel;
    paramTencentLocationRequest1.mAllowCache = paramTencentLocationRequest2.mAllowCache;
    paramTencentLocationRequest1.mAllowDirection = paramTencentLocationRequest2.mAllowDirection;
    paramTencentLocationRequest1.mExpirationTime = paramTencentLocationRequest2.mExpirationTime;
    paramTencentLocationRequest1.mNumUpdates = paramTencentLocationRequest2.mNumUpdates;
    paramTencentLocationRequest1.mIndoorLocationMode = paramTencentLocationRequest2.mIndoorLocationMode;
    paramTencentLocationRequest1.mForeginRequest = paramTencentLocationRequest2.mForeginRequest;
    paramTencentLocationRequest1.mAllowGps = paramTencentLocationRequest2.mAllowGps;
    paramTencentLocationRequest1.mQQ = paramTencentLocationRequest2.mQQ;
    paramTencentLocationRequest1.mSmallAppKey = paramTencentLocationRequest2.mSmallAppKey;
    paramTencentLocationRequest1.mExtras.clear();
    paramTencentLocationRequest1.mExtras.putAll(paramTencentLocationRequest2.mExtras);
    AppMethodBeat.o(210871);
  }
  
  public static TencentLocationRequest create()
  {
    AppMethodBeat.i(210877);
    TencentLocationRequest localTencentLocationRequest = new TencentLocationRequest();
    localTencentLocationRequest.mInterval = 10000L;
    localTencentLocationRequest.mRequestLevel = 1;
    localTencentLocationRequest.mAllowCache = true;
    localTencentLocationRequest.mAllowDirection = false;
    localTencentLocationRequest.mIndoorLocationMode = false;
    localTencentLocationRequest.mForeginRequest = false;
    localTencentLocationRequest.mExpirationTime = 0L;
    localTencentLocationRequest.mNumUpdates = 2147483647;
    localTencentLocationRequest.mAllowGps = true;
    localTencentLocationRequest.mQQ = "";
    localTencentLocationRequest.mSmallAppKey = "";
    localTencentLocationRequest.mExtras = new Bundle();
    AppMethodBeat.o(210877);
    return localTencentLocationRequest;
  }
  
  private boolean isAllowedLevel(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4) || (paramInt == 7);
  }
  
  public final String getAndroidId()
  {
    AppMethodBeat.i(210936);
    String str2 = this.mExtras.getString("androidId");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(210936);
    return str1;
  }
  
  public final Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public final long getInterval()
  {
    return this.mInterval;
  }
  
  public final String getQQ()
  {
    return this.mQQ;
  }
  
  public final int getRequestLevel()
  {
    return this.mRequestLevel;
  }
  
  public final String getSmallAppKey()
  {
    return this.mSmallAppKey;
  }
  
  public final long getmExpirationTime()
  {
    return this.mExpirationTime;
  }
  
  public final boolean isAllowCache()
  {
    return this.mAllowCache;
  }
  
  public final boolean isAllowDirection()
  {
    return this.mAllowDirection;
  }
  
  public final boolean isAllowGPS()
  {
    return this.mAllowGps;
  }
  
  public final boolean isForeginRequest()
  {
    return this.mForeginRequest;
  }
  
  public final boolean isIndoorLocationMode()
  {
    return this.mIndoorLocationMode;
  }
  
  public final TencentLocationRequest setAllowCache(boolean paramBoolean)
  {
    this.mAllowCache = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAllowDirection(boolean paramBoolean)
  {
    this.mAllowDirection = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAllowGPS(boolean paramBoolean)
  {
    this.mAllowGps = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAndroidId(String paramString)
  {
    AppMethodBeat.i(210932);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mExtras.putString("androidId", str);
    AppMethodBeat.o(210932);
    return this;
  }
  
  public final TencentLocationRequest setForeginRequest(boolean paramBoolean)
  {
    this.mForeginRequest = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setIndoorLocationMode(boolean paramBoolean)
  {
    this.mIndoorLocationMode = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setInterval(long paramLong)
  {
    AppMethodBeat.i(210886);
    if (paramLong >= 0L)
    {
      this.mInterval = paramLong;
      AppMethodBeat.o(210886);
      return this;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("interval should >= 0");
    AppMethodBeat.o(210886);
    throw localIllegalArgumentException;
  }
  
  public final TencentLocationRequest setQQ(String paramString)
  {
    this.mQQ = paramString;
    return this;
  }
  
  public final TencentLocationRequest setRequestLevel(int paramInt)
  {
    AppMethodBeat.i(210893);
    if (isAllowedLevel(paramInt))
    {
      this.mRequestLevel = paramInt;
      AppMethodBeat.o(210893);
      return this;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("request_level: " + paramInt + " not supported!");
    AppMethodBeat.o(210893);
    throw localIllegalArgumentException;
  }
  
  public final TencentLocationRequest setSmallAppKey(String paramString)
  {
    AppMethodBeat.i(210922);
    if (!TextUtils.isEmpty(paramString)) {
      this.mSmallAppKey = paramString;
    }
    AppMethodBeat.o(210922);
    return this;
  }
  
  public final void setmExpirationTime(long paramLong)
  {
    this.mExpirationTime = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210964);
    String str = "TencentLocationRequest {interval=" + this.mInterval + "ms,level=" + this.mRequestLevel + ",allowCache=" + this.mAllowCache + ",allowGps=" + this.mAllowGps + ",allowDirection=" + this.mAllowDirection + ",QQ=" + this.mQQ + ",isForeginRequest=" + this.mForeginRequest + "}";
    AppMethodBeat.o(210964);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationRequest
 * JD-Core Version:    0.7.0.1
 */