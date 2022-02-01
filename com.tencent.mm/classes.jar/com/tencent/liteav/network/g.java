package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;
import java.util.Vector<Lcom.tencent.liteav.network.e;>;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class g
{
  private final int a;
  private final int b;
  private String c;
  private String d;
  private int e;
  private String f;
  private Handler g;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(15413);
    this.a = 5;
    this.b = 2;
    this.c = "";
    this.d = "";
    this.e = 0;
    this.f = "";
    if (paramContext != null) {
      this.g = new Handler(paramContext.getMainLooper());
    }
    AppMethodBeat.o(15413);
  }
  
  private String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(15418);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(15418);
      return null;
    }
    paramString1 = paramString1.toLowerCase();
    paramString2 = paramString2.split("[?&]");
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramString2[i];
      if (localObject1.indexOf("=") != -1)
      {
        Object localObject2 = localObject1.split("[=]");
        if (localObject2.length == 2)
        {
          localObject1 = localObject2[0];
          localObject2 = localObject2[1];
          if ((localObject1 != null) && (localObject1.toLowerCase().equalsIgnoreCase(paramString1)))
          {
            AppMethodBeat.o(15418);
            return localObject2;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(15418);
    return "";
  }
  
  private void a(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final int paramInt, final a parama)
  {
    AppMethodBeat.i(15417);
    new Thread("getRTMPAccUrl")
    {
      public void run()
      {
        AppMethodBeat.i(15454);
        final int j = -1;
        int m;
        int i;
        int k;
        int n;
        label82:
        int i1;
        Object localObject1;
        Object localObject3;
        if ((paramString2 != null) && (!paramString2.isEmpty()))
        {
          m = Integer.valueOf(paramString2).intValue();
          i = 5;
          if (!g.a(g.this, true, paramString2, paramString4, paramString3))
          {
            k = (int)g.a(g.this);
            i = k;
            if (k <= 0)
            {
              i = 1;
              n = 1;
              i1 = i + n;
              localObject1 = "";
              if (i1 > 0)
              {
                localObject3 = localObject1;
                k = j;
              }
            }
          }
        }
        for (;;)
        {
          Object localObject2;
          for (;;)
          {
            Object localObject5;
            Object localObject6;
            try
            {
              localObject4 = new JSONObject();
              localObject3 = localObject1;
              k = j;
              ((JSONObject)localObject4).put("bizid", m);
              localObject3 = localObject1;
              k = j;
              ((JSONObject)localObject4).put("stream_id", paramString1);
              localObject3 = localObject1;
              k = j;
              ((JSONObject)localObject4).put("txSecret", paramString3);
              localObject3 = localObject1;
              k = j;
              ((JSONObject)localObject4).put("txTime", paramString4);
              localObject3 = localObject1;
              k = j;
              ((JSONObject)localObject4).put("type", 1);
              localObject3 = localObject1;
              k = j;
              localObject5 = ((JSONObject)localObject4).toString();
              if (i1 <= n) {
                break label1329;
              }
              localObject4 = "https://livepull.myqcloud.com/getpulladdr";
              localObject3 = localObject1;
              k = j;
              localObject4 = (HttpsURLConnection)new URL((String)localObject4).openConnection();
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setDoOutput(true);
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setDoInput(true);
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setUseCaches(false);
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setConnectTimeout(5000);
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setReadTimeout(5000);
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setRequestMethod("POST");
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setRequestProperty("Charsert", "UTF-8");
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setRequestProperty("Content-Type", "text/plain;");
              localObject3 = localObject1;
              k = j;
              ((HttpsURLConnection)localObject4).setRequestProperty("Content-Length", String.valueOf(((String)localObject5).length()));
              localObject3 = localObject1;
              k = j;
              TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: sendHttpRequest[ " + (String)localObject5 + "] retryIndex = " + i1);
              localObject3 = localObject1;
              k = j;
              new DataOutputStream(((HttpsURLConnection)localObject4).getOutputStream()).write(((String)localObject5).getBytes());
              localObject3 = localObject1;
              k = j;
              localObject5 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject4).getInputStream()));
              localObject4 = "";
              localObject3 = localObject1;
              k = j;
              localObject6 = ((BufferedReader)localObject5).readLine();
              if (localObject6 != null)
              {
                localObject3 = localObject1;
                k = j;
                localObject4 = (String)localObject4 + (String)localObject6;
                continue;
              }
              localObject3 = localObject1;
              k = j;
              TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: receive response, strResponse = ".concat(String.valueOf(localObject4)));
              localObject3 = localObject1;
              k = j;
              Object localObject7 = (JSONObject)new JSONTokener((String)localObject4).nextValue();
              i = j;
              localObject3 = localObject1;
              k = j;
              if (((JSONObject)localObject7).has("code"))
              {
                localObject3 = localObject1;
                k = j;
                i = ((JSONObject)localObject7).getInt("code");
              }
              localObject4 = localObject1;
              if (i != 0)
              {
                localObject4 = localObject1;
                localObject3 = localObject1;
                k = i;
                if (((JSONObject)localObject7).has("message"))
                {
                  localObject3 = localObject1;
                  k = i;
                  localObject4 = ((JSONObject)localObject7).getString("message");
                }
                localObject3 = localObject4;
                k = i;
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: errorCode = " + i + " errorMessage = " + (String)localObject4);
              }
              localObject3 = localObject4;
              k = i;
              localObject1 = localObject4;
              j = i;
              if (((JSONObject)localObject7).has("pull_addr"))
              {
                localObject3 = localObject4;
                k = i;
                localObject5 = new Vector();
                localObject3 = localObject4;
                k = i;
                localObject6 = new Vector();
                localObject3 = localObject4;
                k = i;
                localObject1 = ((JSONObject)localObject7).getJSONArray("pull_addr");
                if (localObject1 != null)
                {
                  localObject3 = localObject4;
                  k = i;
                  if (((JSONArray)localObject1).length() != 0) {}
                }
                else
                {
                  localObject3 = localObject4;
                  k = i;
                  TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: no pull_addr");
                  localObject3 = localObject4;
                  k = i;
                  if (paramInt != 1) {
                    break label1099;
                  }
                  localObject3 = localObject4;
                  k = i;
                  localObject1 = localObject4;
                  j = i;
                  if (((Vector)localObject6).size() <= 0) {
                    break label1083;
                  }
                  localObject3 = localObject4;
                  k = i;
                  g.b(g.this).post(new Runnable()
                  {
                    public void run()
                    {
                      AppMethodBeat.i(15399);
                      if (g.2.this.f != null) {
                        g.2.this.f.a(0, "Success", this.a);
                      }
                      AppMethodBeat.o(15399);
                    }
                  });
                  AppMethodBeat.o(15454);
                  return;
                }
                j = 0;
                localObject3 = localObject4;
                k = i;
                if (j >= ((JSONArray)localObject1).length()) {
                  continue;
                }
                localObject3 = localObject4;
                k = i;
                Object localObject8 = (JSONObject)((JSONArray)localObject1).get(j);
                if (localObject8 == null) {
                  break label1337;
                }
                localObject3 = localObject4;
                k = i;
                localObject7 = ((JSONObject)localObject8).getString("rtmp_url");
                localObject3 = localObject4;
                k = i;
                if (((JSONObject)localObject8).getInt("proto") != 1) {
                  break label1344;
                }
                bool = true;
                localObject3 = localObject4;
                k = i;
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: streamUrl = " + (String)localObject7 + " Q channel = " + bool);
                localObject3 = localObject4;
                k = i;
                localObject8 = TXCCommonUtil.getStreamIDByStreamUrl((String)localObject7);
                if (localObject8 == null) {
                  break label1337;
                }
                localObject3 = localObject4;
                k = i;
                if (!((String)localObject8).equalsIgnoreCase(paramString1)) {
                  break label1337;
                }
                if (bool)
                {
                  localObject3 = localObject4;
                  k = i;
                  ((Vector)localObject5).add(new e((String)localObject7, bool));
                }
                else
                {
                  localObject3 = localObject4;
                  k = i;
                  ((Vector)localObject6).add(new e((String)localObject7, bool));
                }
              }
            }
            catch (Exception localException1)
            {
              TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception:" + localException1.toString());
              j = k;
              localObject2 = localObject3;
            }
            try
            {
              label1083:
              label1099:
              do
              {
                do
                {
                  sleep(1000L, 0);
                  i1 -= 1;
                  break;
                  localObject3 = localObject4;
                  k = i;
                  if (paramInt != 2) {
                    break label1167;
                  }
                  localObject3 = localObject4;
                  k = i;
                  localObject2 = localObject4;
                  j = i;
                } while (((Vector)localObject5).size() <= 0);
                localObject3 = localObject4;
                k = i;
                g.b(g.this).post(new Runnable()
                {
                  public void run()
                  {
                    AppMethodBeat.i(15309);
                    if (g.2.this.f != null) {
                      g.2.this.f.a(0, "Success", this.a);
                    }
                    AppMethodBeat.o(15309);
                  }
                });
                AppMethodBeat.o(15454);
                return;
                localObject3 = localObject4;
                k = i;
                localObject2 = ((Vector)localObject6).iterator();
                for (;;)
                {
                  localObject3 = localObject4;
                  k = i;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localObject3 = localObject4;
                  k = i;
                  ((Vector)localObject5).add((e)((Iterator)localObject2).next());
                }
                localObject3 = localObject4;
                k = i;
                localObject2 = localObject4;
                j = i;
              } while (((Vector)localObject5).size() <= 0);
              label1167:
              localObject3 = localObject4;
              k = i;
              g.b(g.this).post(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(15308);
                  if (g.2.this.f != null) {
                    g.2.this.f.a(0, "Success", this.a);
                  }
                  AppMethodBeat.o(15308);
                }
              });
              AppMethodBeat.o(15454);
              return;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception sleep");
              }
            }
          }
          g.b(g.this).post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(15398);
              if (g.2.this.f != null) {
                g.2.this.f.a(j, this.b, null);
              }
              AppMethodBeat.o(15398);
            }
          });
          AppMethodBeat.o(15454);
          return;
          n = 2;
          break label82;
          m = 0;
          break;
          label1329:
          Object localObject4 = "https://livepullipv6.myqcloud.com/getpulladdr";
          continue;
          label1337:
          j += 1;
          continue;
          label1344:
          boolean bool = false;
        }
      }
    }.start();
    AppMethodBeat.o(15417);
  }
  
  private boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(15415);
    if (paramBoolean)
    {
      if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramString2 != null) && (!paramString2.isEmpty()) && (paramString3 != null) && (!paramString3.isEmpty()))
      {
        AppMethodBeat.o(15415);
        return true;
      }
      AppMethodBeat.o(15415);
      return false;
    }
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      AppMethodBeat.o(15415);
      return true;
    }
    AppMethodBeat.o(15415);
    return false;
  }
  
  private long e()
  {
    AppMethodBeat.i(15416);
    long l = c.a().a("Network", "AccRetryCountWithoutSecret");
    AppMethodBeat.o(15416);
    return l;
  }
  
  public int a(final String paramString, int paramInt, final a parama)
  {
    AppMethodBeat.i(15414);
    this.c = "";
    this.d = "";
    this.e = 0;
    this.f = "";
    if ((paramString == null) || (paramString.isEmpty()))
    {
      TXCLog.i("TXRTMPAccUrlFetcher", "getAccerateStreamPlayUrl input playUrl is empty");
      AppMethodBeat.o(15414);
      return -1;
    }
    final String str1 = TXCCommonUtil.getStreamIDByStreamUrl(paramString);
    if ((str1 == null) || (str1.isEmpty()))
    {
      TXCLog.i("TXRTMPAccUrlFetcher", "getAccerateStreamPlayUrl streamID is empty");
      AppMethodBeat.o(15414);
      return -2;
    }
    final String str2 = a("bizid", paramString);
    final String str3 = a("txSecret", paramString);
    paramString = a("txTime", paramString);
    if (e() <= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (!a(bool, str2, paramString, str3))
      {
        AppMethodBeat.o(15414);
        return -3;
      }
      a(str1, str2, str3, paramString, paramInt, new a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString, Vector<e> paramAnonymousVector)
        {
          AppMethodBeat.i(15422);
          g.a(g.this, str1);
          g.b(g.this, str2);
          g.a(g.this, paramAnonymousInt);
          g.c(g.this, paramAnonymousString);
          if ((paramAnonymousVector != null) && (!paramAnonymousVector.isEmpty()))
          {
            Vector localVector = new Vector();
            Iterator localIterator = paramAnonymousVector.iterator();
            Object localObject;
            while (localIterator.hasNext())
            {
              e locale = (e)localIterator.next();
              localObject = str1;
              paramAnonymousVector = (Vector<e>)localObject;
              if (((String)localObject).indexOf("?") != -1) {
                paramAnonymousVector = ((String)localObject).substring(0, ((String)localObject).indexOf("?"));
              }
              localVector.add(new e(paramAnonymousVector + "?txSecret=" + str3 + "&txTime=" + paramString + "&bizid=" + str2, locale.b));
            }
            if (parama != null)
            {
              paramAnonymousVector = localVector.iterator();
              while (paramAnonymousVector.hasNext())
              {
                localObject = (e)paramAnonymousVector.next();
                TXCLog.e("TXRTMPAccUrlFetcher", "accurl = " + str1 + " quic = " + ((e)localObject).b);
              }
              parama.a(paramAnonymousInt, paramAnonymousString, localVector);
            }
            AppMethodBeat.o(15422);
            return;
          }
          if (parama != null) {
            parama.a(paramAnonymousInt, paramAnonymousString, null);
          }
          AppMethodBeat.o(15422);
        }
      });
      AppMethodBeat.o(15414);
      return 0;
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString, Vector<e> paramVector);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.g
 * JD-Core Version:    0.7.0.1
 */