package com.tencent.liteav.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
{
  protected static i a = new i();
  private Context b = null;
  private long c = 3L;
  
  private i.a a(String paramString, boolean paramBoolean)
  {
    if (b(paramString)) {
      return null;
    }
    try
    {
      localObject5 = this.b.getSharedPreferences("com.tencent.liteav.network", 0).getString("34238512-C08C-4931-A000-40E1D8B5BA5B", "");
      if (b((String)localObject5)) {
        return null;
      }
      localObject5 = new JSONObject((String)localObject5).optJSONObject(paramString);
      if (localObject5 != null) {
        break label323;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Object localObject5;
      long l;
      return null;
    }
    localObject5 = ((JSONObject)localObject5).optJSONArray(paramString);
    if (localObject5 == null) {
      return null;
    }
    l = ((JSONArray)localObject5).length();
    if (l == 0L) {
      return null;
    }
    for (;;)
    {
      int i;
      float f4;
      float f3;
      float f2;
      float f1;
      if (i < l)
      {
        JSONObject localJSONObject = ((JSONArray)localObject5).getJSONObject(i);
        Object localObject4;
        localObject4 += (float)localJSONObject.optLong("networkRTT");
        Object localObject3;
        f3 = (float)(localObject3 + localJSONObject.optDouble("avgBlockCnt"));
        Object localObject2;
        f2 = (float)(localObject2 + localJSONObject.optDouble("avgVideoQue"));
        Object localObject1;
        f1 = (float)(localObject1 + localJSONObject.optDouble("avgAudioQue"));
        paramString = String.format("%s \n isDomainAddressBetter：itemData domain = %b NetworkRTT = %d avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(localJSONObject.optLong("networkRTT")), Double.valueOf(localJSONObject.optDouble("avgBlockCnt")), Double.valueOf(localJSONObject.optDouble("avgVideoQue")), Double.valueOf(localJSONObject.optDouble("avgAudioQue")) });
        i += 1;
      }
      else
      {
        f4 /= (float)l;
        f3 /= (float)l;
        f2 /= (float)l;
        f1 /= (float)l;
        paramString = new i.a(this);
        paramString.a = f4;
        paramString.b = f3;
        paramString.c = f2;
        paramString.d = f1;
        paramString.e = l;
        return paramString;
        label323:
        if (paramBoolean)
        {
          paramString = "DomainArrayData";
          break;
        }
        paramString = "OriginArrayData";
        break;
        paramString = "";
        f4 = 0.0F;
        f3 = 0.0F;
        f2 = 0.0F;
        f1 = 0.0F;
        i = 0;
      }
    }
  }
  
  public static i a()
  {
    return a;
  }
  
  private boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  private JSONObject c(String paramString)
  {
    if (!b(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return new JSONObject();
  }
  
  private void d()
  {
    this.c = b.a().a("Network", "QualityDataCacheCount");
    if ((this.c == -1L) || (this.c < 3L)) {
      this.c = 3L;
    }
  }
  
  public long a(String paramString)
  {
    long l = 0L;
    if (this.b != null) {
      l = this.b.getSharedPreferences("com.tencent.liteav.network", 0).getLong(paramString, 0L);
    }
    return l;
  }
  
  public void a(Context paramContext)
  {
    if (this.b == null) {
      this.b = paramContext.getApplicationContext();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.b != null) {
      this.b.getSharedPreferences("com.tencent.liteav.network", 0).edit().putLong(paramString, paramLong).commit();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i;
    if (b.a().a("Network", "QualityDataCacheCount") > 0L)
    {
      i = 1;
      if (i != 0) {
        break label30;
      }
    }
    label30:
    do
    {
      return;
      i = 0;
      break;
      TXCLog.e("UploadQualityData", String.format("updateQualityData: accessID = %s serverType = %d totalTime = %d networkRTT = %d avgBlockCnt = %f avgVideoQue = %f avgAudioQue = %f", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    } while (b(paramString));
    String str;
    try
    {
      localSharedPreferences = this.b.getSharedPreferences("com.tencent.liteav.network", 0);
      localJSONObject2 = c(localSharedPreferences.getString("34238512-C08C-4931-A000-40E1D8B5BA5B", ""));
      localJSONObject1 = localJSONObject2.optJSONObject(paramString);
      if (localJSONObject1 != null) {
        break label376;
      }
      localJSONObject1 = new JSONObject();
    }
    catch (Exception paramString)
    {
      SharedPreferences localSharedPreferences;
      JSONObject localJSONObject2;
      JSONObject localJSONObject1;
      int j;
      JSONArray localJSONArray;
      return;
    }
    Object localObject2 = localJSONObject1.optJSONArray(str);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONArray();
    }
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("totalTime", paramLong2);
    ((JSONObject)localObject2).put("networkRTT", paramLong3);
    ((JSONObject)localObject2).put("avgBlockCnt", paramFloat1);
    ((JSONObject)localObject2).put("avgVideoQue", paramFloat2);
    ((JSONObject)localObject2).put("avgAudioQue", paramFloat3);
    ((JSONArray)localObject1).put(localObject2);
    j = ((JSONArray)localObject1).length();
    if (j > this.c)
    {
      localJSONArray = new JSONArray();
      i = (int)(j - this.c);
      for (;;)
      {
        localObject2 = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(((JSONArray)localObject1).get(i));
        i += 1;
      }
    }
    for (;;)
    {
      localJSONObject1.put(str, localObject2);
      localJSONObject2.put(paramString, localJSONObject1);
      paramString = localJSONObject2.toString();
      localSharedPreferences.edit().putString("34238512-C08C-4931-A000-40E1D8B5BA5B", paramString).commit();
      return;
      label376:
      if (paramLong1 == 3L)
      {
        str = "DomainArrayData";
        break;
      }
      str = "OriginArrayData";
      break;
      localObject2 = localObject1;
    }
  }
  
  public String b()
  {
    try
    {
      if (this.b != null)
      {
        int i = a.c(this.b);
        if (i == 255) {
          return "";
        }
        if (i == 1)
        {
          Object localObject = (WifiManager)this.b.getSystemService("wifi");
          if (localObject != null)
          {
            localObject = ((WifiManager)localObject).getConnectionInfo();
            if (localObject != null)
            {
              localObject = "wifi:" + ((WifiInfo)localObject).getSSID();
              return localObject;
            }
          }
        }
        else
        {
          if (i == 2) {
            return "4g:";
          }
          if (i == 3) {
            return "3g:";
          }
          if (i == 4) {
            return "2g:";
          }
          if (i == 5) {
            return "ethernet:";
          }
          return "xg:";
        }
      }
    }
    catch (Exception localException) {}
    return "";
  }
  
  public boolean c()
  {
    d();
    Object localObject1 = b();
    Object localObject2 = "isDomainAddressBetter: accessID = " + (String)localObject1 + " minQualityDataCount = " + this.c;
    i.a locala1 = a((String)localObject1, true);
    i.a locala2 = a((String)localObject1, false);
    localObject1 = localObject2;
    if (locala1 != null) {
      localObject1 = String.format("%s \n isDomainAddressBetter：domainQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { localObject2, Long.valueOf(locala1.e), Float.valueOf(locala1.a), Float.valueOf(locala1.b), Float.valueOf(locala1.c), Float.valueOf(locala1.d) });
    }
    localObject2 = localObject1;
    if (locala2 != null) {
      localObject2 = String.format("%s \n isDomainAddressBetter：originQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { localObject1, Long.valueOf(locala2.e), Float.valueOf(locala2.a), Float.valueOf(locala2.b), Float.valueOf(locala2.c), Float.valueOf(locala2.d) });
    }
    TXCLog.e("UploadQualityData", (String)localObject2);
    if ((locala1 == null) || (locala1.e < this.c) || (locala2 == null) || (locala2.e < this.c)) {
      return false;
    }
    return (locala1.b < locala2.b) && (locala1.c < locala2.c) && (locala1.d < locala2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.network.i
 * JD-Core Version:    0.7.0.1
 */