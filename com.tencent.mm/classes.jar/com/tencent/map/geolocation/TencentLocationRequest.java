package com.tencent.map.geolocation;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
  private boolean f;
  private long g;
  private int h;
  private String i;
  private String j;
  private Bundle k;
  
  private TencentLocationRequest() {}
  
  public TencentLocationRequest(TencentLocationRequest paramTencentLocationRequest)
  {
    AppMethodBeat.i(136469);
    this.a = paramTencentLocationRequest.a;
    this.b = paramTencentLocationRequest.b;
    this.d = paramTencentLocationRequest.d;
    this.e = paramTencentLocationRequest.e;
    this.g = paramTencentLocationRequest.g;
    this.h = paramTencentLocationRequest.h;
    this.c = paramTencentLocationRequest.c;
    this.f = paramTencentLocationRequest.f;
    this.j = paramTencentLocationRequest.j;
    this.i = paramTencentLocationRequest.i;
    this.k = new Bundle();
    this.k.putAll(paramTencentLocationRequest.k);
    AppMethodBeat.o(136469);
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      if (paramInt != 7) {
        break;
      }
    case 0: 
    case 1: 
    case 3: 
    case 4: 
      return true;
    }
    return false;
  }
  
  public static void copy(TencentLocationRequest paramTencentLocationRequest1, TencentLocationRequest paramTencentLocationRequest2)
  {
    AppMethodBeat.i(136470);
    paramTencentLocationRequest1.a = paramTencentLocationRequest2.a;
    paramTencentLocationRequest1.b = paramTencentLocationRequest2.b;
    paramTencentLocationRequest1.d = paramTencentLocationRequest2.d;
    paramTencentLocationRequest1.e = paramTencentLocationRequest2.e;
    paramTencentLocationRequest1.g = paramTencentLocationRequest2.g;
    paramTencentLocationRequest1.h = paramTencentLocationRequest2.h;
    paramTencentLocationRequest1.f = paramTencentLocationRequest2.f;
    paramTencentLocationRequest1.c = paramTencentLocationRequest2.c;
    paramTencentLocationRequest1.j = paramTencentLocationRequest2.j;
    paramTencentLocationRequest1.i = paramTencentLocationRequest2.i;
    paramTencentLocationRequest1.k.clear();
    paramTencentLocationRequest1.k.putAll(paramTencentLocationRequest2.k);
    AppMethodBeat.o(136470);
  }
  
  public static TencentLocationRequest create()
  {
    AppMethodBeat.i(136471);
    TencentLocationRequest localTencentLocationRequest = new TencentLocationRequest();
    localTencentLocationRequest.a = 10000L;
    localTencentLocationRequest.b = 1;
    localTencentLocationRequest.d = true;
    localTencentLocationRequest.e = false;
    localTencentLocationRequest.f = false;
    localTencentLocationRequest.g = 0L;
    localTencentLocationRequest.h = 2147483647;
    localTencentLocationRequest.c = true;
    localTencentLocationRequest.j = "";
    localTencentLocationRequest.i = "";
    localTencentLocationRequest.k = new Bundle();
    AppMethodBeat.o(136471);
    return localTencentLocationRequest;
  }
  
  public final Bundle getExtras()
  {
    return this.k;
  }
  
  public final long getInterval()
  {
    return this.a;
  }
  
  public final String getPhoneNumber()
  {
    AppMethodBeat.i(136476);
    String str2 = this.k.getString("phoneNumber");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(136476);
    return str1;
  }
  
  public final String getQQ()
  {
    return this.j;
  }
  
  public final int getRequestLevel()
  {
    return this.b;
  }
  
  public final String getSmallAppKey()
  {
    return this.i;
  }
  
  public final long getmExpirationTime()
  {
    return this.g;
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
  
  public final boolean isIndoorLocationMode()
  {
    return this.f;
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
  
  public final TencentLocationRequest setIndoorLocationMode(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public final TencentLocationRequest setInterval(long paramLong)
  {
    AppMethodBeat.i(136472);
    if (paramLong < 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("interval should >= 0");
      AppMethodBeat.o(136472);
      throw localIllegalArgumentException;
    }
    this.a = paramLong;
    AppMethodBeat.o(136472);
    return this;
  }
  
  public final TencentLocationRequest setPhoneNumber(String paramString)
  {
    AppMethodBeat.i(136475);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.k.putString("phoneNumber", str);
    AppMethodBeat.o(136475);
    return this;
  }
  
  public final TencentLocationRequest setQQ(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public final TencentLocationRequest setRequestLevel(int paramInt)
  {
    AppMethodBeat.i(136473);
    if (a(paramInt))
    {
      this.b = paramInt;
      AppMethodBeat.o(136473);
      return this;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("request_level: " + paramInt + " not supported!");
    AppMethodBeat.o(136473);
    throw localIllegalArgumentException;
  }
  
  public final TencentLocationRequest setSmallAppKey(String paramString)
  {
    AppMethodBeat.i(136474);
    if (!TextUtils.isEmpty(paramString)) {
      this.i = paramString;
    }
    AppMethodBeat.o(136474);
    return this;
  }
  
  public final void setmExpirationTime(long paramLong)
  {
    this.g = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(136477);
    String str = "TencentLocationRequest {interval=" + this.a + "ms,level=" + this.b + ",allowCache=" + this.d + ",allowGps=" + this.c + ",allowDirection=" + this.e + ",QQ=" + this.j + "}";
    AppMethodBeat.o(136477);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationRequest
 * JD-Core Version:    0.7.0.1
 */