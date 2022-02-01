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
  private final String d = "forward_stream";
  private final String e = "forward_num";
  private final String f = "request_type";
  private final String g = "sdk_version";
  private final String h = "51451748-d8f2-4629-9071-db2983aa7251";
  private Thread i = null;
  
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
      locala.d = b(locala.a);
      if ((paramJSONObject.has("type")) && (paramJSONObject.getInt("type") == 2)) {
        locala.c = true;
      }
      AppMethodBeat.o(15391);
      return locala;
    }
    catch (JSONException paramJSONObject)
    {
      AppMethodBeat.o(15391);
    }
    return null;
  }
  
  private ArrayList<a> a(String paramString)
  {
    int m = 0;
    AppMethodBeat.i(15390);
    Object localObject = new ArrayList();
    for (;;)
    {
      int j;
      int k;
      try
      {
        paramString = new JSONObject(paramString);
        j = paramString.getInt("state");
        if (j != 0)
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
        j = 0;
        k = m;
        a locala;
        if (j < paramString.length())
        {
          locala = a((JSONObject)paramString.opt(j));
          if ((locala == null) || (!locala.c)) {
            break label321;
          }
          ((ArrayList)localObject).add(locala);
          break label321;
        }
        if (k < paramString.length())
        {
          locala = a((JSONObject)paramString.opt(k));
          if ((locala == null) || (locala.c)) {
            break label328;
          }
          ((ArrayList)localObject).add(locala);
          break label328;
        }
        if ((com.tencent.liteav.basic.e.b.a().a("Network", "EnableRouteOptimize") == 1L) && (i.a().c()))
        {
          paramString = a((ArrayList)localObject, true);
          localObject = paramString;
          paramString = (String)localObject;
        }
      }
      catch (JSONException paramString)
      {
        long l1;
        long l2;
        paramString = (String)localObject;
        AppMethodBeat.o(15390);
        return paramString;
      }
      try
      {
        a((ArrayList)localObject);
        AppMethodBeat.o(15390);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        continue;
        continue;
      }
      l1 = com.tencent.liteav.basic.e.b.a().a("Network", "RouteSamplingMaxCount");
      if (l1 >= 1L)
      {
        l2 = i.a().a("51451748-d8f2-4629-9071-db2983aa7251");
        if (l2 <= l1)
        {
          paramString = a((ArrayList)localObject, false);
          localObject = paramString;
          paramString = (String)localObject;
          i.a().a("51451748-d8f2-4629-9071-db2983aa7251", l2 + 1L);
          paramString = (String)localObject;
          a((ArrayList)localObject);
          AppMethodBeat.o(15390);
          return localObject;
        }
      }
      label321:
      j += 1;
      continue;
      label328:
      k += 1;
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
    int j = ((ArrayList)localObject1).size();
    if (j > 0)
    {
      localObject2 = (a)((ArrayList)localObject1).get(j - 1);
      if ((localObject2 != null) && (!b(((a)localObject2).a)) && (paramArrayList != null)) {
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
  
  private String b(String paramString, int paramInt)
  {
    AppMethodBeat.i(15388);
    StringBuffer localStringBuffer = new StringBuffer("");
    try
    {
      paramString = c(paramString, paramInt);
      if (paramString == null)
      {
        AppMethodBeat.o(15388);
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
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString = localStringBuffer.toString();
      AppMethodBeat.o(15388);
    }
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(15392);
    if (paramString != null)
    {
      paramString = paramString.split("[.]");
      int k = paramString.length;
      int j = 0;
      while (j < k)
      {
        if (!c(paramString[j]))
        {
          AppMethodBeat.o(15392);
          return true;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(15392);
    return false;
  }
  
  private InputStream c(String paramString, int paramInt)
  {
    AppMethodBeat.i(15389);
    Object localObject = new URL("https://tcdns.myqcloud.com/queryip").openConnection();
    for (;;)
    {
      try
      {
        localObject = (HttpURLConnection)localObject;
        ((HttpURLConnection)localObject).setRequestMethod("GET");
        ((HttpURLConnection)localObject).setRequestProperty("forward_stream", paramString);
        ((HttpURLConnection)localObject).setRequestProperty("forward_num", "2");
        ((HttpURLConnection)localObject).setRequestProperty("sdk_version", TXCCommonUtil.getSDKVersionStr());
        if (paramInt != 1) {
          continue;
        }
        ((HttpURLConnection)localObject).setRequestProperty("request_type", "1");
        if (this.b > 0)
        {
          ((HttpURLConnection)localObject).setConnectTimeout(this.b * 1000);
          ((HttpURLConnection)localObject).setReadTimeout(this.b * 1000);
        }
        ((HttpURLConnection)localObject).connect();
        if (((HttpURLConnection)localObject).getResponseCode() != 200) {
          continue;
        }
        paramString = ((HttpURLConnection)localObject).getInputStream();
      }
      catch (Exception paramString)
      {
        paramString = null;
        continue;
      }
      AppMethodBeat.o(15389);
      return paramString;
      if (paramInt == 2) {
        ((HttpURLConnection)localObject).setRequestProperty("request_type", "2");
      } else {
        ((HttpURLConnection)localObject).setRequestProperty("request_type", "3");
      }
    }
  }
  
  private boolean c(String paramString)
  {
    AppMethodBeat.i(15393);
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(15393);
    return bool;
  }
  
  public void a(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(15387);
    this.i = new Thread("TXCPushRoute")
    {
      public void run()
      {
        AppMethodBeat.i(15469);
        if (c.this.a == null)
        {
          AppMethodBeat.o(15469);
          return;
        }
        ArrayList localArrayList1 = new ArrayList();
        int i = 0;
        for (;;)
        {
          Object localObject3 = localArrayList1;
          Object localObject2;
          if (i < 5) {
            localObject2 = localArrayList1;
          }
          try
          {
            localObject3 = c.a(c.this, paramString, paramInt);
            try
            {
              localObject2 = new JSONObject((String)localObject3);
              if (!((JSONObject)localObject2).has("use")) {
                break label121;
              }
              int j = ((JSONObject)localObject2).getInt("use");
              if (j != 0) {
                break label121;
              }
              localObject3 = localArrayList1;
            }
            catch (Exception localException2)
            {
              do
              {
                localArrayList2 = localArrayList1;
                localArrayList1 = c.a(c.this, (String)localObject3);
                if (localArrayList1 == null) {
                  break;
                }
                localObject3 = localArrayList1;
                localArrayList2 = localArrayList1;
              } while (localArrayList1.size() > 0);
              localArrayList2 = localArrayList1;
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
              label121:
              ArrayList localArrayList2;
              Object localObject1 = localArrayList2;
            }
          }
          i += 1;
        }
      }
    };
    this.i.start();
    AppMethodBeat.o(15387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.c
 * JD-Core Version:    0.7.0.1
 */