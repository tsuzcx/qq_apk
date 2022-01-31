package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.liteav.network.a;>;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c
{
  public b a = null;
  public int b = 5;
  private final String c = "http://tcdns.myqcloud.com/queryip";
  private final String d = "forward_stream";
  private final String e = "forward_num";
  private final String f = "request_type";
  private final String g = "sdk_version";
  private final String h = "51451748-d8f2-4629-9071-db2983aa7251";
  private Thread i = null;
  
  private a a(JSONObject paramJSONObject)
  {
    a locala = new a();
    try
    {
      locala.a = paramJSONObject.getString("ip");
      locala.b = paramJSONObject.getString("port");
      locala.e = 0;
      locala.c = false;
      locala.d = b(locala.a);
      if ((paramJSONObject.has("type")) && (paramJSONObject.getInt("type") == 2)) {
        locala.c = true;
      }
      return locala;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  private ArrayList<a> a(String paramString)
  {
    int m = 0;
    Object localObject = new ArrayList();
    for (;;)
    {
      int j;
      int k;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("state") != 0) {
          return null;
        }
        paramString = paramString.getJSONObject("content").getJSONArray("list");
        if (paramString == null) {
          break label278;
        }
        j = 0;
        k = m;
        a locala;
        if (j < paramString.length())
        {
          locala = a((JSONObject)paramString.opt(j));
          if ((locala == null) || (!locala.c)) {
            break label280;
          }
          ((ArrayList)localObject).add(locala);
          break label280;
        }
        if (k < paramString.length())
        {
          locala = a((JSONObject)paramString.opt(k));
          if ((locala == null) || (locala.c)) {
            break label287;
          }
          ((ArrayList)localObject).add(locala);
          break label287;
        }
        if ((com.tencent.liteav.basic.e.b.a().a("Network", "EnableRouteOptimize") == 1L) && (i.a().c()))
        {
          paramString = a((ArrayList)localObject, true);
          localObject = paramString;
          paramString = (String)localObject;
          try
          {
            a((ArrayList)localObject);
            return localObject;
          }
          catch (JSONException localJSONException)
          {
            return paramString;
          }
        }
        long l1 = com.tencent.liteav.basic.e.b.a().a("Network", "RouteSamplingMaxCount");
        if (l1 >= 1L)
        {
          long l2 = i.a().a("51451748-d8f2-4629-9071-db2983aa7251");
          if (l2 <= l1)
          {
            paramString = a(localJSONException, false);
            str = paramString;
            paramString = str;
            i.a().a("51451748-d8f2-4629-9071-db2983aa7251", l2 + 1L);
            paramString = str;
            a(str);
            return str;
          }
        }
      }
      catch (JSONException paramString)
      {
        String str;
        return str;
      }
      continue;
      label278:
      return null;
      label280:
      j += 1;
      continue;
      label287:
      k += 1;
    }
  }
  
  private ArrayList<a> a(ArrayList<a> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = null;
    while (localIterator.hasNext())
    {
      localObject1 = (a)localIterator.next();
      if (((a)localObject1).c) {
        ((ArrayList)localObject2).add(localObject1);
      } else if (((a)localObject1).d) {
        paramArrayList = (ArrayList<a>)localObject1;
      } else {
        localArrayList.add(localObject1);
      }
    }
    Object localObject1 = new ArrayList();
    label241:
    while ((((ArrayList)localObject2).size() > 0) || (localArrayList.size() > 0))
    {
      if (paramBoolean)
      {
        if (paramArrayList != null) {
          ((ArrayList)localObject1).add(paramArrayList);
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          ((ArrayList)localObject1).add(((ArrayList)localObject2).get(0));
          ((ArrayList)localObject2).remove(0);
        }
      }
      for (;;)
      {
        if (localArrayList.size() <= 0) {
          break label241;
        }
        ((ArrayList)localObject1).add(localArrayList.get(0));
        localArrayList.remove(0);
        break;
        if (((ArrayList)localObject2).size() > 0)
        {
          ((ArrayList)localObject1).add(((ArrayList)localObject2).get(0));
          ((ArrayList)localObject2).remove(0);
        }
        if (paramArrayList != null) {
          ((ArrayList)localObject1).add(paramArrayList);
        }
      }
    }
    int j = ((ArrayList)localObject1).size();
    if (j > 0)
    {
      localObject2 = (a)((ArrayList)localObject1).get(j - 1);
      if ((localObject2 != null) && (!b(((a)localObject2).a)) && (paramArrayList != null)) {
        ((ArrayList)localObject1).add(paramArrayList);
      }
    }
    return localObject1;
  }
  
  private void a(ArrayList<a> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      a locala;
      for (paramArrayList = ""; localIterator.hasNext(); paramArrayList = paramArrayList + " \n Nearest IP: " + locala.a + " Port: " + locala.b + " Q Channel: " + locala.c) {
        locala = (a)localIterator.next();
      }
      TXCLog.e("TXCIntelligentRoute", paramArrayList);
    }
  }
  
  private String b(String paramString, int paramInt)
  {
    localStringBuffer = new StringBuffer("");
    try
    {
      paramString = c(paramString, paramInt);
      if (paramString == null) {
        return "";
      }
      paramString = new BufferedReader(new InputStreamReader(paramString));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuffer.append(str);
      }
      return localStringBuffer.toString();
    }
    catch (IOException paramString) {}
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int k;
    int j;
    if (paramString != null)
    {
      paramString = paramString.split("[.]");
      k = paramString.length;
      j = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (j < k)
      {
        if (!c(paramString[j])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  private InputStream c(String paramString, int paramInt)
  {
    Object localObject = new URL("http://tcdns.myqcloud.com/queryip").openConnection();
    try
    {
      localObject = (HttpURLConnection)localObject;
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      ((HttpURLConnection)localObject).setRequestProperty("forward_stream", paramString);
      ((HttpURLConnection)localObject).setRequestProperty("forward_num", "2");
      ((HttpURLConnection)localObject).setRequestProperty("sdk_version", TXCCommonUtil.getSDKVersionStr());
      if (paramInt == 1) {
        ((HttpURLConnection)localObject).setRequestProperty("request_type", "1");
      }
      for (;;)
      {
        if (this.b > 0)
        {
          ((HttpURLConnection)localObject).setConnectTimeout(this.b * 1000);
          ((HttpURLConnection)localObject).setReadTimeout(this.b * 1000);
        }
        ((HttpURLConnection)localObject).connect();
        if (((HttpURLConnection)localObject).getResponseCode() != 200) {
          break;
        }
        return ((HttpURLConnection)localObject).getInputStream();
        if (paramInt == 2) {
          ((HttpURLConnection)localObject).setRequestProperty("request_type", "2");
        } else {
          ((HttpURLConnection)localObject).setRequestProperty("request_type", "3");
        }
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  private boolean c(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public void a(String paramString, int paramInt)
  {
    this.i = new c.1(this, "TXCPushRoute", paramString, paramInt);
    this.i.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.network.c
 * JD-Core Version:    0.7.0.1
 */