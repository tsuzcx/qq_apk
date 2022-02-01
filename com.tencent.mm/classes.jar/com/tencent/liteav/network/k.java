package com.tencent.liteav.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

public class k
{
  protected static k a;
  private Context b = null;
  private long c = 3L;
  
  static
  {
    AppMethodBeat.i(229582);
    a = new k();
    AppMethodBeat.o(229582);
  }
  
  private a a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(229569);
    if (b(paramString))
    {
      AppMethodBeat.o(229569);
      return null;
    }
    try
    {
      Object localObject = this.b.getSharedPreferences("com.tencent.liteav.network", 0).getString("34238512-C08C-4931-A000-40E1D8B5BA5B", "");
      boolean bool = b((String)localObject);
      if (bool)
      {
        AppMethodBeat.o(229569);
        return null;
      }
      localObject = new JSONObject((String)localObject).optJSONObject(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(229569);
        return null;
      }
      if (paramBoolean) {}
      for (paramString = "DomainArrayData";; paramString = "OriginArrayData")
      {
        localObject = ((JSONObject)localObject).optJSONArray(paramString);
        if (localObject != null) {
          break;
        }
        AppMethodBeat.o(229569);
        return null;
      }
      int i = ((JSONArray)localObject).length();
      long l = i;
      if (l == 0L)
      {
        AppMethodBeat.o(229569);
        return null;
      }
      paramString = "";
      float f4 = 0.0F;
      float f3 = 0.0F;
      float f2 = 0.0F;
      float f1 = 0.0F;
      i = 0;
      while (i < l)
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        f4 += (float)localJSONObject.optLong("networkRTT");
        f3 = (float)(f3 + localJSONObject.optDouble("avgBlockCnt"));
        f2 = (float)(f2 + localJSONObject.optDouble("avgVideoQue"));
        f1 = (float)(f1 + localJSONObject.optDouble("avgAudioQue"));
        paramString = String.format("%s \n isDomainAddressBetter：itemData domain = %b NetworkRTT = %d avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(localJSONObject.optLong("networkRTT")), Double.valueOf(localJSONObject.optDouble("avgBlockCnt")), Double.valueOf(localJSONObject.optDouble("avgVideoQue")), Double.valueOf(localJSONObject.optDouble("avgAudioQue")) });
        i += 1;
      }
      f4 /= (float)l;
      f3 /= (float)l;
      f2 /= (float)l;
      f1 /= (float)l;
      paramString = new a();
      paramString.a = f4;
      paramString.b = f3;
      paramString.c = f2;
      paramString.d = f1;
      paramString.e = l;
      AppMethodBeat.o(229569);
      return paramString;
    }
    catch (Exception paramString)
    {
      TXCLog.e("UploadQualityData", "get quality data failed.", paramString);
      AppMethodBeat.o(229569);
    }
    return null;
  }
  
  public static k a()
  {
    return a;
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(229575);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(229575);
      return true;
    }
    AppMethodBeat.o(229575);
    return false;
  }
  
  private JSONObject c(String paramString)
  {
    AppMethodBeat.i(229578);
    if (!b(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        AppMethodBeat.o(229578);
        return paramString;
      }
      catch (Exception paramString)
      {
        TXCLog.e("UploadQualityData", "failed to parse json string", paramString);
      }
    }
    paramString = new JSONObject();
    AppMethodBeat.o(229578);
    return paramString;
  }
  
  private void d()
  {
    AppMethodBeat.i(229579);
    this.c = c.a().a("Network", "QualityDataCacheCount");
    if ((this.c == -1L) || (this.c < 3L)) {
      this.c = 3L;
    }
    AppMethodBeat.o(229579);
  }
  
  public long a(String paramString)
  {
    AppMethodBeat.i(229613);
    if (this.b != null)
    {
      long l = this.b.getSharedPreferences("com.tencent.liteav.network", 0).getLong(paramString, 0L);
      AppMethodBeat.o(229613);
      return l;
    }
    AppMethodBeat.o(229613);
    return 0L;
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(229585);
    if (this.b == null) {
      this.b = paramContext.getApplicationContext();
    }
    AppMethodBeat.o(229585);
  }
  
  public void a(String paramString, long paramLong)
  {
    AppMethodBeat.i(229617);
    if (this.b != null) {
      this.b.getSharedPreferences("com.tencent.liteav.network", 0).edit().putLong(paramString, paramLong).commit();
    }
    AppMethodBeat.o(229617);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(229600);
    if (c.a().a("Network", "QualityDataCacheCount") > 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(229600);
      return;
    }
    TXCLog.e("UploadQualityData", String.format("updateQualityData: accessID = %s serverType = %d totalTime = %d networkRTT = %d avgBlockCnt = %f avgVideoQue = %f avgAudioQue = %f", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    if (b(paramString))
    {
      AppMethodBeat.o(229600);
      return;
    }
    String str;
    try
    {
      localSharedPreferences = this.b.getSharedPreferences("com.tencent.liteav.network", 0);
      localJSONObject2 = c(localSharedPreferences.getString("34238512-C08C-4931-A000-40E1D8B5BA5B", ""));
      localJSONObject1 = localJSONObject2.optJSONObject(paramString);
      if (localJSONObject1 != null) {
        break label410;
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
      TXCLog.e("UploadQualityData", "build json object failed.", paramString);
      AppMethodBeat.o(229600);
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
      AppMethodBeat.o(229600);
      return;
      label410:
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
    AppMethodBeat.i(229591);
    try
    {
      if (this.b != null)
      {
        int i = h.e(this.b);
        if (i == 0)
        {
          AppMethodBeat.o(229591);
          return "";
        }
        if (i == 1)
        {
          AppMethodBeat.o(229591);
          return "wifi:";
        }
        if (i == 2)
        {
          AppMethodBeat.o(229591);
          return "4g:";
        }
        if (i == 3)
        {
          AppMethodBeat.o(229591);
          return "3g:";
        }
        if (i == 4)
        {
          AppMethodBeat.o(229591);
          return "2g:";
        }
        if (i == 5)
        {
          AppMethodBeat.o(229591);
          return "ethernet:";
        }
        if (i == 6)
        {
          AppMethodBeat.o(229591);
          return "5g:";
        }
        AppMethodBeat.o(229591);
        return "xg:";
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("UploadQualityData", "get network type failed." + localException.getMessage());
      AppMethodBeat.o(229591);
    }
    return "";
  }
  
  public boolean c()
  {
    AppMethodBeat.i(229608);
    d();
    Object localObject1 = b();
    Object localObject2 = "isDomainAddressBetter: accessID = " + (String)localObject1 + " minQualityDataCount = " + this.c;
    a locala1 = a((String)localObject1, true);
    a locala2 = a((String)localObject1, false);
    localObject1 = localObject2;
    if (locala1 != null) {
      localObject1 = String.format("%s \n isDomainAddressBetter：domainQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { localObject2, Long.valueOf(locala1.e), Float.valueOf(locala1.a), Float.valueOf(locala1.b), Float.valueOf(locala1.c), Float.valueOf(locala1.d) });
    }
    localObject2 = localObject1;
    if (locala2 != null) {
      localObject2 = String.format("%s \n isDomainAddressBetter：originQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[] { localObject1, Long.valueOf(locala2.e), Float.valueOf(locala2.a), Float.valueOf(locala2.b), Float.valueOf(locala2.c), Float.valueOf(locala2.d) });
    }
    TXCLog.e("UploadQualityData", (String)localObject2);
    if ((locala1 == null) || (locala1.e < this.c) || (locala2 == null) || (locala2.e < this.c))
    {
      AppMethodBeat.o(229608);
      return false;
    }
    if ((locala1.b < locala2.b) && (locala1.c < locala2.c) && (locala1.d < locala2.d))
    {
      AppMethodBeat.o(229608);
      return true;
    }
    AppMethodBeat.o(229608);
    return false;
  }
  
  protected class a
  {
    public float a = 0.0F;
    public float b = 0.0F;
    public float c = 0.0F;
    public float d = 0.0F;
    public long e = 0L;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.network.k
 * JD-Core Version:    0.7.0.1
 */