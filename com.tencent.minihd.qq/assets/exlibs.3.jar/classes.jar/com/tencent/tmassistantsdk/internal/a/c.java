package com.tencent.tmassistantsdk.internal.a;

import com.tencent.tmassistantbase.a.a;
import com.tencent.tmassistantbase.a.e;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public int a = -1;
  public String b = "";
  public int c = 0;
  public String d = "";
  public int e = 0;
  public String f = "";
  public long g = 0L;
  public long h = 0L;
  public int i = 0;
  public byte[] j = null;
  
  public c(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.b = paramString1;
    if (this.b == null) {
      this.b = "";
    }
    this.c = paramInt1;
    this.d = paramString2;
    if (this.d == null) {
      this.d = "";
    }
    this.e = paramInt2;
    this.f = paramString3;
    if (this.f == null) {
      this.f = "";
    }
    this.g = paramLong1;
    this.h = paramLong2;
    this.i = paramInt3;
    this.j = paramArrayOfByte;
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    paramArrayOfByte = new e().a(paramArrayOfByte, "&-*)Wb5_U,[^!9'+".getBytes());
    if (paramArrayOfByte != null) {}
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      if (paramArrayOfByte == null) {
        break label172;
      }
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        break label172;
      }
      str1 = paramArrayOfByte.getString("mHostPackageName");
      k = paramArrayOfByte.getInt("mHostVersion");
      str2 = paramArrayOfByte.getString("mHostUserIdentity");
      m = paramArrayOfByte.getInt("mDataItemType");
      str3 = paramArrayOfByte.getString("mDataItemAction");
      l1 = paramArrayOfByte.getLong("mDataItemStartTime");
      l2 = paramArrayOfByte.getLong("mDataItemEndTime");
      n = paramArrayOfByte.getInt("mDataItemVersion");
      if (n < 1) {
        break label182;
      }
      paramArrayOfByte = paramArrayOfByte.getString("mIPCData");
      if (paramArrayOfByte == null) {
        break label182;
      }
      paramArrayOfByte = a.a(paramArrayOfByte, 0);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      String str1;
      int k;
      String str2;
      int m;
      String str3;
      long l1;
      long l2;
      int n;
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        paramArrayOfByte = null;
      }
    }
    paramArrayOfByte = new c(str1, k, str2, m, str3, l1, l2, n, paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public byte[] a()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("mHostPackageName", this.b);
      ((JSONObject)localObject).put("mHostVersion", this.c);
      ((JSONObject)localObject).put("mHostUserIdentity", this.d);
      ((JSONObject)localObject).put("mDataItemType", this.e);
      ((JSONObject)localObject).put("mDataItemAction", this.f);
      ((JSONObject)localObject).put("mDataItemStartTime", this.g);
      ((JSONObject)localObject).put("mDataItemEndTime", this.h);
      ((JSONObject)localObject).put("mDataItemVersion", this.i);
      if ((this.i >= 1) && (this.j != null))
      {
        String str = a.b(this.j, 0);
        if (str != null) {
          ((JSONObject)localObject).put("mIPCData", str);
        }
      }
      localObject = ((JSONObject)localObject).toString();
      if (localObject != null)
      {
        localObject = ((String)localObject).getBytes("UTF-8");
        if (localObject != null)
        {
          localObject = new e().b((byte[])localObject, "&-*)Wb5_U,[^!9'+".getBytes());
          return localObject;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.a.c
 * JD-Core Version:    0.7.0.1
 */