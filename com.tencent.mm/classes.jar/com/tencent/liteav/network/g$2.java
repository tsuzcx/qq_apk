package com.tencent.liteav.network;

import android.os.Handler;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

class g$2
  extends Thread
{
  g$2(g paramg, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, g.a parama)
  {
    super(paramString1);
  }
  
  public void run()
  {
    int j = -1;
    Object localObject1 = "";
    int n;
    int i;
    int k;
    label77:
    Object localObject3;
    int m;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      n = Integer.valueOf(this.a).intValue();
      i = 5;
      if (!g.a(this.g, true, this.a, this.b, this.c))
      {
        k = (int)g.a(this.g);
        i = k;
        if (k <= 0)
        {
          k = 1;
          if (k > 0)
          {
            localObject3 = localObject1;
            m = j;
            for (;;)
            {
              try
              {
                localObject4 = new JSONObject();
                localObject3 = localObject1;
                m = j;
                ((JSONObject)localObject4).put("bizid", n);
                localObject3 = localObject1;
                m = j;
                ((JSONObject)localObject4).put("stream_id", this.d);
                localObject3 = localObject1;
                m = j;
                ((JSONObject)localObject4).put("txSecret", this.c);
                localObject3 = localObject1;
                m = j;
                ((JSONObject)localObject4).put("txTime", this.b);
                localObject3 = localObject1;
                m = j;
                ((JSONObject)localObject4).put("type", 1);
                localObject3 = localObject1;
                m = j;
                localObject4 = ((JSONObject)localObject4).toString();
                localObject3 = localObject1;
                m = j;
                localObject5 = (HttpsURLConnection)new URL("https://livepull.myqcloud.com/getpulladdr").openConnection();
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setDoOutput(true);
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setDoInput(true);
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setUseCaches(false);
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setConnectTimeout(5000);
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setReadTimeout(5000);
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setRequestMethod("POST");
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setRequestProperty("Charsert", "UTF-8");
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setRequestProperty("Content-Type", "text/plain;");
                localObject3 = localObject1;
                m = j;
                ((HttpsURLConnection)localObject5).setRequestProperty("Content-Length", String.valueOf(((String)localObject4).length()));
                localObject3 = localObject1;
                m = j;
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: sendHttpRequest[ " + (String)localObject4 + "] retryIndex = " + k);
                localObject3 = localObject1;
                m = j;
                new DataOutputStream(((HttpsURLConnection)localObject5).getOutputStream()).write(((String)localObject4).getBytes());
                localObject3 = localObject1;
                m = j;
                localObject5 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject5).getInputStream()));
                localObject4 = "";
                localObject3 = localObject1;
                m = j;
                localObject6 = ((BufferedReader)localObject5).readLine();
                if (localObject6 != null)
                {
                  localObject3 = localObject1;
                  m = j;
                  localObject4 = (String)localObject4 + (String)localObject6;
                  continue;
                }
                localObject3 = localObject1;
                m = j;
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: receive response, strResponse = " + (String)localObject4);
                localObject3 = localObject1;
                m = j;
                localObject7 = (JSONObject)new JSONTokener((String)localObject4).nextValue();
                i = j;
                localObject3 = localObject1;
                m = j;
                if (((JSONObject)localObject7).has("code"))
                {
                  localObject3 = localObject1;
                  m = j;
                  i = ((JSONObject)localObject7).getInt("code");
                }
                localObject4 = localObject1;
                if (i != 0)
                {
                  localObject4 = localObject1;
                  localObject3 = localObject1;
                  m = i;
                  if (((JSONObject)localObject7).has("message"))
                  {
                    localObject3 = localObject1;
                    m = i;
                    localObject4 = ((JSONObject)localObject7).getString("message");
                  }
                  localObject3 = localObject4;
                  m = i;
                  TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: errorCode = " + i + " errorMessage = " + (String)localObject4);
                }
                localObject3 = localObject4;
                m = i;
                localObject1 = localObject4;
                j = i;
                if (!((JSONObject)localObject7).has("pull_addr")) {
                  break;
                }
                localObject3 = localObject4;
                m = i;
                localObject5 = new Vector();
                localObject3 = localObject4;
                m = i;
                localObject6 = new Vector();
                localObject3 = localObject4;
                m = i;
                localObject1 = ((JSONObject)localObject7).getJSONArray("pull_addr");
                if (localObject1 != null)
                {
                  localObject3 = localObject4;
                  m = i;
                  if (((JSONArray)localObject1).length() != 0) {
                    break label1316;
                  }
                }
                localObject3 = localObject4;
                m = i;
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: no pull_addr");
                localObject3 = localObject4;
                m = i;
                if (this.e != 1) {
                  break label1097;
                }
                localObject3 = localObject4;
                m = i;
                localObject1 = localObject4;
                j = i;
                if (((Vector)localObject6).size() <= 0) {
                  break;
                }
                localObject3 = localObject4;
                m = i;
                g.b(this.g).post(new g.2.1(this, (Vector)localObject6));
                return;
              }
              catch (Exception localException1)
              {
                Object localObject7;
                label850:
                Object localObject8;
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception");
                localObject2 = localObject3;
                j = m;
              }
              localObject3 = localObject4;
              m = i;
              if (j < ((JSONArray)localObject1).length())
              {
                localObject3 = localObject4;
                m = i;
                localObject8 = (JSONObject)((JSONArray)localObject1).get(j);
                if (localObject8 == null) {
                  break label1321;
                }
                localObject3 = localObject4;
                m = i;
                localObject7 = ((JSONObject)localObject8).getString("rtmp_url");
                localObject3 = localObject4;
                m = i;
                if (((JSONObject)localObject8).getInt("proto") != 1) {
                  break label1328;
                }
              }
            }
          }
        }
      }
    }
    label1162:
    label1316:
    label1321:
    label1328:
    for (boolean bool = true;; bool = false)
    {
      Object localObject2;
      for (;;)
      {
        localObject3 = localObject4;
        m = i;
        TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: streamUrl = " + (String)localObject7 + " Q channel = " + bool);
        localObject3 = localObject4;
        m = i;
        localObject8 = TXCCommonUtil.getStreamIDByStreamUrl((String)localObject7);
        if (localObject8 == null) {
          break label1321;
        }
        localObject3 = localObject4;
        m = i;
        if (!((String)localObject8).equalsIgnoreCase(this.d)) {
          break label1321;
        }
        if (bool)
        {
          localObject3 = localObject4;
          m = i;
          ((Vector)localObject5).add(new e((String)localObject7, bool));
          break label1321;
        }
        localObject3 = localObject4;
        m = i;
        ((Vector)localObject6).add(new e((String)localObject7, bool));
        break label1321;
        try
        {
          label1097:
          do
          {
            do
            {
              sleep(1000L, 0);
              k -= 1;
              break;
              localObject3 = localObject4;
              m = i;
              if (this.e != 2) {
                break label1162;
              }
              localObject3 = localObject4;
              m = i;
              localObject2 = localObject4;
              j = i;
            } while (((Vector)localObject5).size() <= 0);
            localObject3 = localObject4;
            m = i;
            g.b(this.g).post(new Runnable()
            {
              public void run()
              {
                if (g.2.this.f != null) {
                  g.2.this.f.a(0, "Success", this.a);
                }
              }
            });
            return;
            localObject3 = localObject4;
            m = i;
            localObject2 = ((Vector)localObject6).iterator();
            for (;;)
            {
              localObject3 = localObject4;
              m = i;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = localObject4;
              m = i;
              ((Vector)localObject5).add((e)((Iterator)localObject2).next());
            }
            localObject3 = localObject4;
            m = i;
            localObject2 = localObject4;
            j = i;
          } while (((Vector)localObject5).size() <= 0);
          localObject3 = localObject4;
          m = i;
          g.b(this.g).post(new g.2.3(this, (Vector)localObject5));
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
      g.b(this.g).post(new g.2.4(this, j, (String)localObject2));
      return;
      k = i;
      break label77;
      n = 0;
      break;
      j = 0;
      break label850;
      j += 1;
      break label850;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.g.2
 * JD-Core Version:    0.7.0.1
 */