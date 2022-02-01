package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

public abstract interface NetAdapter
{
  public abstract boolean cancel();
  
  public abstract NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler);
  
  public abstract NetResponse doPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  public abstract void doRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler);
  
  public abstract void initNet(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.NetAdapter
 * JD-Core Version:    0.7.0.1
 */