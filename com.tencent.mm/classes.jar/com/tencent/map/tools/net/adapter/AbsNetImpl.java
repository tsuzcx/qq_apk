package com.tencent.map.tools.net.adapter;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

public abstract class AbsNetImpl
  implements NetAdapter
{
  private static final String TAG = "NetImpl";
  private boolean mForceHttps = true;
  protected Bundle mParams;
  
  protected static String parseCharset(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i];
        if (!str1.contains("charset")) {
          break label69;
        }
        paramString = str1.split("=");
        str1 = str2;
        if (paramString.length > 1) {
          str1 = paramString[1].trim();
        }
      }
      return str1;
      label69:
      i += 1;
    }
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    try
    {
      paramString1 = onGetRequest(paramString1, paramString2, paramInt1, paramInt2, paramHashMap, paramHttpCanceler);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return new NetResponse(paramString1);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    try
    {
      paramString1 = onPostRequest(paramString1, paramString2, paramArrayOfByte, paramInt1, paramHashMap, paramHttpCanceler, paramInt2);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return new NetResponse(paramString1);
  }
  
  public NetResponse doPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      paramString1 = onPostNoBuffer(paramString1, paramString2, paramArrayOfByte);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return new NetResponse(paramString1);
  }
  
  public void doRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler)
  {
    try
    {
      onRangePost(paramString1, paramArrayOfByte, paramString2, paramString3, paramString4, paramString5, paramHttpCanceler);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void initNet(Context paramContext)
  {
    try
    {
      onCreateNet(paramContext, this.mParams);
      return;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("initNet error:").append(paramContext.toString());
    }
  }
  
  public boolean isForceHttps()
  {
    return this.mForceHttps;
  }
  
  protected abstract void onCreateNet(Context paramContext, Bundle paramBundle);
  
  protected abstract NetResponse onGetRequest(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler);
  
  protected abstract NetResponse onPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  protected abstract NetResponse onPostRequest(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler, int paramInt2);
  
  protected abstract void onRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler);
  
  public void setArguments(Bundle paramBundle)
  {
    this.mParams = paramBundle;
  }
  
  public void setForceHttps(boolean paramBoolean)
  {
    this.mForceHttps = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.tools.net.adapter.AbsNetImpl
 * JD-Core Version:    0.7.0.1
 */