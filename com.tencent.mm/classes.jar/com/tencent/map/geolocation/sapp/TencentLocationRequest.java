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
  public boolean mIndoorLocationMode;
  public long mInterval;
  public int mNumUpdates;
  public String mQQ;
  public int mRequestLevel;
  public String mSmallAppKey;
  
  public TencentLocationRequest() {}
  
  public TencentLocationRequest(TencentLocationRequest paramTencentLocationRequest)
  {
    AppMethodBeat.i(254924);
    this.mInterval = paramTencentLocationRequest.mInterval;
    this.mRequestLevel = paramTencentLocationRequest.mRequestLevel;
    this.mAllowCache = paramTencentLocationRequest.mAllowCache;
    this.mAllowDirection = paramTencentLocationRequest.mAllowDirection;
    this.mExpirationTime = paramTencentLocationRequest.mExpirationTime;
    this.mNumUpdates = paramTencentLocationRequest.mNumUpdates;
    this.mAllowGps = paramTencentLocationRequest.mAllowGps;
    this.mIndoorLocationMode = paramTencentLocationRequest.mIndoorLocationMode;
    this.mQQ = paramTencentLocationRequest.mQQ;
    this.mSmallAppKey = paramTencentLocationRequest.mSmallAppKey;
    this.mExtras = new Bundle();
    this.mExtras.putAll(paramTencentLocationRequest.mExtras);
    AppMethodBeat.o(254924);
  }
  
  public static void copy(TencentLocationRequest paramTencentLocationRequest1, TencentLocationRequest paramTencentLocationRequest2)
  {
    AppMethodBeat.i(254926);
    paramTencentLocationRequest1.mInterval = paramTencentLocationRequest2.mInterval;
    paramTencentLocationRequest1.mRequestLevel = paramTencentLocationRequest2.mRequestLevel;
    paramTencentLocationRequest1.mAllowCache = paramTencentLocationRequest2.mAllowCache;
    paramTencentLocationRequest1.mAllowDirection = paramTencentLocationRequest2.mAllowDirection;
    paramTencentLocationRequest1.mExpirationTime = paramTencentLocationRequest2.mExpirationTime;
    paramTencentLocationRequest1.mNumUpdates = paramTencentLocationRequest2.mNumUpdates;
    paramTencentLocationRequest1.mIndoorLocationMode = paramTencentLocationRequest2.mIndoorLocationMode;
    paramTencentLocationRequest1.mAllowGps = paramTencentLocationRequest2.mAllowGps;
    paramTencentLocationRequest1.mQQ = paramTencentLocationRequest2.mQQ;
    paramTencentLocationRequest1.mSmallAppKey = paramTencentLocationRequest2.mSmallAppKey;
    paramTencentLocationRequest1.mExtras.clear();
    paramTencentLocationRequest1.mExtras.putAll(paramTencentLocationRequest2.mExtras);
    AppMethodBeat.o(254926);
  }
  
  public static TencentLocationRequest create()
  {
    AppMethodBeat.i(254928);
    TencentLocationRequest localTencentLocationRequest = new TencentLocationRequest();
    localTencentLocationRequest.mInterval = 10000L;
    localTencentLocationRequest.mRequestLevel = 1;
    localTencentLocationRequest.mAllowCache = true;
    localTencentLocationRequest.mAllowDirection = false;
    localTencentLocationRequest.mIndoorLocationMode = false;
    localTencentLocationRequest.mExpirationTime = 0L;
    localTencentLocationRequest.mNumUpdates = 2147483647;
    localTencentLocationRequest.mAllowGps = true;
    localTencentLocationRequest.mQQ = "";
    localTencentLocationRequest.mSmallAppKey = "";
    localTencentLocationRequest.mExtras = new Bundle();
    AppMethodBeat.o(254928);
    return localTencentLocationRequest;
  }
  
  private boolean isAllowedLevel(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4) || (paramInt == 7);
  }
  
  public final Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public final long getInterval()
  {
    return this.mInterval;
  }
  
  public final String getPhoneNumber()
  {
    AppMethodBeat.i(254939);
    String str2 = this.mExtras.getString("phoneNumber");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(254939);
    return str1;
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
  
  public final TencentLocationRequest setIndoorLocationMode(boolean paramBoolean)
  {
    this.mIndoorLocationMode = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setInterval(long paramLong)
  {
    AppMethodBeat.i(254931);
    if (paramLong >= 0L)
    {
      this.mInterval = paramLong;
      AppMethodBeat.o(254931);
      return this;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("interval should >= 0");
    AppMethodBeat.o(254931);
    throw localIllegalArgumentException;
  }
  
  public final TencentLocationRequest setPhoneNumber(String paramString)
  {
    AppMethodBeat.i(254937);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mExtras.putString("phoneNumber", str);
    AppMethodBeat.o(254937);
    return this;
  }
  
  public final TencentLocationRequest setQQ(String paramString)
  {
    this.mQQ = paramString;
    return this;
  }
  
  public final TencentLocationRequest setRequestLevel(int paramInt)
  {
    AppMethodBeat.i(254932);
    if (isAllowedLevel(paramInt))
    {
      this.mRequestLevel = paramInt;
      AppMethodBeat.o(254932);
      return this;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("request_level: " + paramInt + " not supported!");
    AppMethodBeat.o(254932);
    throw localIllegalArgumentException;
  }
  
  public final TencentLocationRequest setSmallAppKey(String paramString)
  {
    AppMethodBeat.i(254935);
    if (!TextUtils.isEmpty(paramString)) {
      this.mSmallAppKey = paramString;
    }
    AppMethodBeat.o(254935);
    return this;
  }
  
  public final void setmExpirationTime(long paramLong)
  {
    this.mExpirationTime = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(254943);
    String str = "TencentLocationRequest {interval=" + this.mInterval + "ms,level=" + this.mRequestLevel + ",allowCache=" + this.mAllowCache + ",allowGps=" + this.mAllowGps + ",allowDirection=" + this.mAllowDirection + ",QQ=" + this.mQQ + "}";
    AppMethodBeat.o(254943);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.sapp.TencentLocationRequest
 * JD-Core Version:    0.7.0.1
 */