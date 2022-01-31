package com.tencent.map.geolocation;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.map.geolocation.internal.TencentExtraKeys;

public final class TencentLocationRequest
{
  public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
  public static final int REQUEST_LEVEL_GEO = 0;
  public static final int REQUEST_LEVEL_NAME = 1;
  public static final int REQUEST_LEVEL_POI = 4;
  private long a;
  private int b;
  private boolean c;
  private boolean d;
  private boolean e;
  private long f;
  private int g;
  private String h;
  private String i;
  private Bundle j;
  
  private TencentLocationRequest() {}
  
  public TencentLocationRequest(TencentLocationRequest paramTencentLocationRequest)
  {
    this.a = paramTencentLocationRequest.a;
    this.b = paramTencentLocationRequest.b;
    this.d = paramTencentLocationRequest.d;
    this.e = paramTencentLocationRequest.e;
    this.f = paramTencentLocationRequest.f;
    this.g = paramTencentLocationRequest.g;
    this.c = paramTencentLocationRequest.c;
    this.i = paramTencentLocationRequest.i;
    this.h = paramTencentLocationRequest.h;
    this.j = new Bundle();
    this.j.putAll(paramTencentLocationRequest.j);
  }
  
  public static void copy(TencentLocationRequest paramTencentLocationRequest1, TencentLocationRequest paramTencentLocationRequest2)
  {
    paramTencentLocationRequest1.a = paramTencentLocationRequest2.a;
    paramTencentLocationRequest1.b = paramTencentLocationRequest2.b;
    paramTencentLocationRequest1.d = paramTencentLocationRequest2.d;
    paramTencentLocationRequest1.e = paramTencentLocationRequest2.e;
    paramTencentLocationRequest1.f = paramTencentLocationRequest2.f;
    paramTencentLocationRequest1.g = paramTencentLocationRequest2.g;
    paramTencentLocationRequest1.c = paramTencentLocationRequest2.c;
    paramTencentLocationRequest1.i = paramTencentLocationRequest2.i;
    paramTencentLocationRequest1.h = paramTencentLocationRequest2.h;
    paramTencentLocationRequest1.j.clear();
    paramTencentLocationRequest1.j.putAll(paramTencentLocationRequest2.j);
  }
  
  public static TencentLocationRequest create()
  {
    TencentLocationRequest localTencentLocationRequest = new TencentLocationRequest();
    localTencentLocationRequest.a = 10000L;
    localTencentLocationRequest.b = 1;
    localTencentLocationRequest.d = true;
    localTencentLocationRequest.e = false;
    localTencentLocationRequest.f = 9223372036854775807L;
    localTencentLocationRequest.g = 2147483647;
    localTencentLocationRequest.c = true;
    localTencentLocationRequest.i = "";
    localTencentLocationRequest.h = "";
    localTencentLocationRequest.j = new Bundle();
    return localTencentLocationRequest;
  }
  
  public final Bundle getExtras()
  {
    return this.j;
  }
  
  public final long getInterval()
  {
    return this.a;
  }
  
  public final String getPhoneNumber()
  {
    String str2 = this.j.getString("phoneNumber");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getQQ()
  {
    return this.i;
  }
  
  public final int getRequestLevel()
  {
    return this.b;
  }
  
  public final String getSmallAppKey()
  {
    return this.h;
  }
  
  public final boolean isAllowCache()
  {
    return this.d;
  }
  
  public final boolean isAllowDirection()
  {
    return this.e;
  }
  
  public final boolean isAllowGPS()
  {
    return this.c;
  }
  
  public final TencentLocationRequest setAllowCache(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAllowDirection(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setAllowGPS(boolean paramBoolean)
  {
    this.c = paramBoolean;
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
  
  public final TencentLocationRequest setPhoneNumber(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.j.putString("phoneNumber", str);
    return this;
  }
  
  public final TencentLocationRequest setQQ(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public final TencentLocationRequest setRequestLevel(int paramInt)
  {
    if (TencentExtraKeys.isAllowedLevel(paramInt))
    {
      this.b = paramInt;
      return this;
    }
    throw new IllegalArgumentException("request_level: " + paramInt + " not supported!");
  }
  
  public final TencentLocationRequest setSmallAppKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.h = paramString;
    }
    return this;
  }
  
  public final String toString()
  {
    return "TencentLocationRequest {interval=" + this.a + "ms,level=" + this.b + ",allowCache=" + this.d + ",allowGps=" + this.c + ",allowDirection=" + this.e + ",QQ=" + this.i + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationRequest
 * JD-Core Version:    0.7.0.1
 */