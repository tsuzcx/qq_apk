package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private final String c = "https://tcdns.myqcloud.com/queryip";
  private final String d = "https://tcdnsipv6.myqcloud.com/queryip";
  private final String e = "forward_stream";
  private final String f = "forward_num";
  private final String g = "request_type";
  private final String h = "sdk_version";
  private final String i = "51451748-d8f2-4629-9071-db2983aa7251";
  private final int j = 5;
  private final int k = 2;
  private Thread l = null;
  
  private a a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(15391);
    a locala = new a();
    try
    {
      locala.a = paramJSONObject.getString("ip");
      locala.b = paramJSONObject.getString("port");
      locala.e = 0;
      locala.c = false;
      locala.d = c(locala.a);
      if ((paramJSONObject.has("type")) && (paramJSONObject.getInt("type") == 2)) {
        locala.c = true;
      }
      AppMethodBeat.o(15391);
      return locala;
    }
    catch (JSONException paramJSONObject)
    {
      TXCLog.e("TXCIntelligentRoute", "get ip record from json object failed.", paramJSONObject);
      AppMethodBeat.o(15391);
    }
    return null;
  }
  
  private String a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(229599);
    StringBuffer localStringBuffer = new StringBuffer("");
    try
    {
      paramString1 = b(paramString1, paramInt, paramString2);
      if (paramString1 == null)
      {
        AppMethodBeat.o(229599);
        return "";
      }
      paramString1 = new BufferedReader(new InputStreamReader(paramString1));
      for (;;)
      {
        paramString2 = paramString1.readLine();
        if (paramString2 == null) {
          break;
        }
        localStringBuffer.append(paramString2);
      }
      return paramString1;
    }
    catch (IOException paramString1)
    {
      TXCLog.e("TXCIntelligentRoute", "get json string from url failed.", paramString1);
      paramString1 = localStringBuffer.toString();
      AppMethodBeat.o(229599);
    }
  }
  
  private ArrayList<a> a(String paramString)
  {
    int i1 = 0;
    AppMethodBeat.i(15390);
    Object localObject = new ArrayList();
    for (;;)
    {
      int m;
      int n;
      try
      {
        paramString = new JSONObject(paramString);
        m = paramString.getInt("state");
        if (m != 0)
        {
          AppMethodBeat.o(15390);
          return null;
        }
        paramString = paramString.getJSONObject("content").getJSONArray("list");
        if (paramString == null)
        {
          AppMethodBeat.o(15390);
          return null;
        }
        m = 0;
        n = i1;
        a locala;
        if (m < paramString.length())
        {
          locala = a((JSONObject)paramString.opt(m));
          if ((locala == null) || (!locala.c)) {
            break label331;
          }
          ((ArrayList)localObject).add(locala);
          break label331;
        }
        if (n < paramString.length())
        {
          locala = a((JSONObject)paramString.opt(n));
          if ((locala == null) || (locala.c)) {
            break label338;
          }
          ((ArrayList)localObject).add(locala);
          break label338;
        }
        if ((com.tencent.liteav.basic.d.c.a().a("Network", "EnableRouteOptimize") == 1L) && (k.a().c()))
        {
          paramString = a((ArrayList)localObject, true);
          localObject = paramString;
          paramString = (String)localObject;
        }
      }
      catch (JSONException localJSONException1)
      {
        long l1;
        long l2;
        paramString = (String)localObject;
        TXCLog.e("TXCIntelligentRoute", "get records from json string failed.", localJSONException1);
        AppMethodBeat.o(15390);
        return paramString;
      }
      try
      {
        a((ArrayList)localObject);
        AppMethodBeat.o(15390);
        return localObject;
      }
      catch (JSONException localJSONException2)
      {
        continue;
        continue;
      }
      l1 = com.tencent.liteav.basic.d.c.a().a("Network", "RouteSamplingMaxCount");
      if (l1 >= 1L)
      {
        l2 = k.a().a("51451748-d8f2-4629-9071-db2983aa7251");
        if (l2 <= l1)
        {
          paramString = a((ArrayList)localObject, false);
          localObject = paramString;
          paramString = (String)localObject;
          k.a().a("51451748-d8f2-4629-9071-db2983aa7251", l2 + 1L);
          paramString = (String)localObject;
          a((ArrayList)localObject);
          AppMethodBeat.o(15390);
          return localObject;
        }
      }
      label331:
      m += 1;
      continue;
      label338:
      n += 1;
    }
  }
  
  private ArrayList<a> a(ArrayList<a> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(15394);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(15394);
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
    label253:
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
          break label253;
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
    int m = ((ArrayList)localObject1).size();
    if (m > 0)
    {
      localObject2 = (a)((ArrayList)localObject1).get(m - 1);
      if ((localObject2 != null) && (!c(((a)localObject2).a)) && (paramArrayList != null)) {
        ((ArrayList)localObject1).add(paramArrayList);
      }
    }
    AppMethodBeat.o(15394);
    return localObject1;
  }
  
  private void a(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(15395);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      a locala;
      for (paramArrayList = ""; localIterator.hasNext(); paramArrayList = paramArrayList + " \n Nearest IP: " + locala.a + " Port: " + locala.b + " Q Channel: " + locala.c) {
        locala = (a)localIterator.next();
      }
      TXCLog.e("TXCIntelligentRoute", paramArrayList);
    }
    AppMethodBeat.o(15395);
  }
  
  private InputStream b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(229603);
    paramString2 = new URL(paramString2).openConnection();
    for (;;)
    {
      try
      {
        paramString2 = (HttpURLConnection)paramString2;
        paramString2.setRequestMethod("GET");
        paramString2.setRequestProperty("forward_stream", paramString1);
        paramString2.setRequestProperty("forward_num", "2");
        paramString2.setRequestProperty("sdk_version", TXCCommonUtil.getSDKVersionStr());
        if (paramInt != 1) {
          continue;
        }
        paramString2.setRequestProperty("request_type", "1");
      }
      catch (Exception paramString1)
      {
        TXCLog.e("TXCIntelligentRoute", "http failed.", paramString1);
        paramString1 = null;
        continue;
        paramString2.setRequestProperty("request_type", "3");
        continue;
      }
      if (this.b > 0)
      {
        paramString2.setConnectTimeout(this.b * 1000);
        paramString2.setReadTimeout(this.b * 1000);
      }
      paramString2.connect();
      if (paramString2.getResponseCode() != 200) {
        continue;
      }
      paramString1 = paramString2.getInputStream();
      AppMethodBeat.o(229603);
      return paramString1;
      if (paramInt != 2) {
        continue;
      }
      paramString2.setRequestProperty("request_type", "2");
    }
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(15392);
    if (paramString.split(":").length > 1)
    {
      AppMethodBeat.o(15392);
      return true;
    }
    AppMethodBeat.o(15392);
    return false;
  }
  
  private boolean c(String paramString)
  {
    AppMethodBeat.i(15393);
    if (b(paramString))
    {
      AppMethodBeat.o(15393);
      return false;
    }
    if (paramString != null)
    {
      paramString = paramString.split("[.]");
      int n = paramString.length;
      int m = 0;
      while (m < n)
      {
        if (!d(paramString[m]))
        {
          AppMethodBeat.o(15393);
          return true;
        }
        m += 1;
      }
    }
    AppMethodBeat.o(15393);
    return false;
  }
  
  private boolean d(String paramString)
  {
    AppMethodBeat.i(229621);
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(229621);
    return bool;
  }
  
  public void a(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15387);
    this.l = new Thread("TXCPushRoute")
    {
      public void run()
      {
        AppMethodBeat.i(15469);
        if (c.this.a == null)
        {
          AppMethodBeat.o(15469);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (;;)
        {
          Object localObject3 = localArrayList;
          if (i < 7) {
            if (i >= 5) {
              break label131;
            }
          }
          for (localObject3 = "https://tcdns.myqcloud.com/queryip";; localObject3 = "https://tcdnsipv6.myqcloud.com/queryip")
          {
            Object localObject2 = localArrayList;
            try
            {
              localObject3 = c.a(c.this, paramString, paramInt, (String)localObject3);
              try
              {
                localObject2 = new JSONObject((String)localObject3);
                if (!((JSONObject)localObject2).has("use")) {
                  break;
                }
                int j = ((JSONObject)localObject2).getInt("use");
                if (j != 0) {
                  break;
                }
                localObject3 = localArrayList;
              }
              catch (Exception localException2)
              {
                do
                {
                  localObject2 = localArrayList;
                  TXCLog.e("TXCIntelligentRoute", "get value from json failed.", localException2);
                  localObject2 = localArrayList;
                  localArrayList = c.a(c.this, (String)localObject3);
                  if (localArrayList == null) {
                    break;
                  }
                  localObject3 = localArrayList;
                  localObject2 = localArrayList;
                } while (localArrayList.size() > 0);
                localObject2 = localArrayList;
                sleep(1000L, 0);
              }
              c.this.a.onFetchDone(0, (ArrayList)localObject3);
              AppMethodBeat.o(15469);
              return;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                label131:
                TXCLog.e("TXCIntelligentRoute", "get json string failed.", localException1);
                Object localObject1 = localObject2;
              }
            }
          }
          i += 1;
        }
      }
    };
    this.l.start();
    AppMethodBeat.o(15387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.network.c
 * JD-Core Version:    0.7.0.1
 */