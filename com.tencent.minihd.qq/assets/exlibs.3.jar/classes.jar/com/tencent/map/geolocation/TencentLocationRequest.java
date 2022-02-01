package com.tencent.map.geolocation;

import android.os.Bundle;
import com.tencent.map.geolocation.internal.TencentExtraKeys;

public final class TencentLocationRequest
{
  public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
  public static final int REQUEST_LEVEL_FORMATTED_ADDRESS = 5;
  public static final int REQUEST_LEVEL_GEO = 0;
  public static final int REQUEST_LEVEL_NAME = 1;
  public static final int REQUEST_LEVEL_POI = 4;
  private long a;
  private int b;
  private boolean c;
  private boolean d;
  private long e;
  private int f;
  private String g;
  private Bundle h;
  
  private TencentLocationRequest() {}
  
  public TencentLocationRequest(TencentLocationRequest paramTencentLocationRequest)
  {
    this.a = paramTencentLocationRequest.a;
    this.b = paramTencentLocationRequest.b;
    this.c = paramTencentLocationRequest.c;
    this.d = paramTencentLocationRequest.d;
    this.e = paramTencentLocationRequest.e;
    this.f = paramTencentLocationRequest.f;
    this.g = paramTencentLocationRequest.g;
    this.h = new Bundle();
    this.h.putAll(paramTencentLocationRequest.h);
  }
  
  public static void copy(TencentLocationRequest paramTencentLocationRequest1, TencentLocationRequest paramTencentLocationRequest2)
  {
    paramTencentLocationRequest1.a = paramTencentLocationRequest2.a;
    paramTencentLocationRequest1.b = paramTencentLocationRequest2.b;
    paramTencentLocationRequest1.c = paramTencentLocationRequest2.c;
    paramTencentLocationRequest1.d = paramTencentLocationRequest2.d;
    paramTencentLocationRequest1.e = paramTencentLocationRequest2.e;
    paramTencentLocationRequest1.f = paramTencentLocationRequest2.f;
    paramTencentLocationRequest1.g = paramTencentLocationRequest2.g;
    paramTencentLocationRequest1.h.clear();
    paramTencentLocationRequest1.h.putAll(paramTencentLocationRequest2.h);
  }
  
  public static TencentLocationRequest create()
  {
    TencentLocationRequest localTencentLocationRequest = new TencentLocationRequest();
    localTencentLocationRequest.a = 10000L;
    localTencentLocationRequest.b = 1;
    localTencentLocationRequest.c = true;
    localTencentLocationRequest.d = false;
    localTencentLocationRequest.e = 9223372036854775807L;
    localTencentLocationRequest.f = 2147483647;
    localTencentLocationRequest.g = "";
    localTencentLocationRequest.h = new Bundle();
    return localTencentLocationRequest;
  }
  
  public final Bundle getExtras()
  {
    return this.h;
  }
  
  public final long getInterval()
  {
    return this.a;
  }
  
  public final String getQQ()
  {
    return this.g;
  }
  
  public final int getRequestLevel()
  {
    return this.b;
  }
  
  public final boolean isAllowCache()
  {
    return this.c;
  }
  
  public final boolean isAllowDirection()
  {
    return this.d;
  }
  
  public final TencentLocationRequest setAllowCache(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAllowDirection(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setInterval(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("interval should >= 0");
    }
    this.a = paramLong;
    return this;
  }
  
  public final TencentLocationRequest setQQ(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public final TencentLocationRequest setRequestLevel(int paramInt)
  {
    if (TencentExtraKeys.isAllowedLevel(paramInt))
    {
      this.b = paramInt;
      return this;
    }
    throw new IllegalArgumentException("unknown request_level: " + paramInt);
  }
  
  public final String toString()
  {
    return "TencentLocationRequest {interval=" + this.a + "ms,level=" + this.b + ",allowCache=" + this.c + ",allowGps=" + TencentExtraKeys.isAllowGps(this) + ",allowDirection=" + this.d + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationRequest
 * JD-Core Version:    0.7.0.1
 */