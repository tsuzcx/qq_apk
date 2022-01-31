package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class ec
{
  public static int a = 0;
  public final ee b;
  public final eb c;
  private final ea d;
  private final List<dz> e;
  
  public ec(ee paramee, ea paramea, eb parameb, List<dz> paramList)
  {
    this.b = paramee;
    this.d = paramea;
    this.c = parameb;
    this.e = paramList;
  }
  
  private String b(int paramInt, String paramString, dg paramdg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramdg == null) {
      return null;
    }
    label1297:
    for (;;)
    {
      try
      {
        boolean bool;
        Object localObject1;
        Object localObject4;
        Object localObject2;
        Object localObject5;
        dh localdh;
        String str1;
        String str3;
        int j;
        String str2;
        if (this.d == null)
        {
          bool = true;
          localObject1 = this.b;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          continue;
          localObject4 = j.a(this.d, bool);
          localObject2 = this.c;
          if (localObject2 != null) {
            continue;
          }
          localObject2 = "{}";
          localObject5 = dz.a(this.e);
          if (!paramBoolean2) {
            continue;
          }
          localObject2 = "{}";
          localdh = paramdg.b;
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("imei", localdh.a());
          ((HashMap)localObject3).put("imsi", localdh.b());
          ((HashMap)localObject3).put("phonenum", j.c(localdh.d));
          ((HashMap)localObject3).put("qq", j.c(localdh.f));
          ((HashMap)localObject3).put("mac", localdh.c().toLowerCase(Locale.ENGLISH));
          str1 = new JSONObject((Map)localObject3).toString();
          str3 = localdh.f();
          eq.a();
          j = eq.a(paramdg.a);
          str2 = es.c(paramdg);
          paramdg = (dg)localObject1;
        }
        try
        {
          if (((String)localObject1).equals("[]"))
          {
            paramdg = (dg)localObject1;
            if (!str2.equals("{}"))
            {
              paramdg = new JSONObject(str2);
              paramdg.remove("ssid");
              paramdg = "[" + paramdg.toString() + "]";
            }
          }
          localObject1 = paramdg;
        }
        catch (Throwable paramdg)
        {
          StringBuilder localStringBuilder;
          double d1;
          double d2;
          double d3;
          double d4;
          double d5;
          double d6;
          j.a("TxHybridInfo", 6, paramdg.toString());
          continue;
          paramdg = localdh.p;
          continue;
          paramString = paramString + ",\"detectgps\":0";
          continue;
          int i = 203;
          continue;
        }
        Object localObject3 = localdh.j;
        paramdg = (dg)localObject3;
        if (localObject3 != null) {
          paramdg = ((String)localObject3).replace("\"", "");
        }
        localObject3 = paramdg;
        if (paramdg != null) {
          localObject3 = paramdg.replace("|", "");
        }
        localObject3 = (String)localObject3 + "_" + localdh.i;
        if (paramBoolean3)
        {
          paramdg = localdh.a();
          if (paramdg != null)
          {
            i = Math.abs(paramdg.hashCode()) % 1000 + 1001;
            localStringBuilder = new StringBuilder("{\"version\":\"");
            if (localdh.p == null)
            {
              paramdg = "None";
              paramdg = paramdg + "\",\"address\":" + paramInt;
              paramString = paramdg + ",\"source\":" + i + ",\"access_token\":\"" + str3 + "\",\"app_name\":\"" + paramString + "\",\"app_label\":\"" + (String)localObject3 + "\",\"bearing\":1";
              paramdg = paramString + ",\"control\":0";
              paramString = paramdg;
              if (!TextUtils.isEmpty(j.c(localdh.g))) {
                paramString = paramdg + ",\"smallappname\":\"" + j.c(localdh.g) + "\"";
              }
              if (!paramBoolean1) {
                continue;
              }
              paramString = paramString + ",\"detectgps\":1";
              paramString = paramString + ",\"pstat\":" + j;
              paramString = paramString + ",\"wlan\":" + str2;
              paramString = paramString + ",\"attribute\":" + str1 + ",\"location\":" + (String)localObject2 + ",\"cells\":" + (String)localObject4 + ",\"wifis\":" + (String)localObject1 + ",\"bles\":" + (String)localObject5 + "}";
              j.a("TxHybridInfo", 6, "cells:" + (String)localObject4 + ",wifis:" + (String)localObject1 + ",gps:" + (String)localObject2);
              return paramString;
              if (a == this.d.e) {
                break label1297;
              }
              bool = true;
              a = this.d.e;
              continue;
              localObject1 = Collections.unmodifiableList(((ee)localObject1).b);
              continue;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[");
              if (((List)localObject1).size() <= 0)
              {
                ((StringBuilder)localObject2).append("]");
                localObject1 = ((StringBuilder)localObject2).toString();
                continue;
              }
              localObject3 = ((List)localObject1).iterator();
              i = 0;
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (ScanResult)((Iterator)localObject3).next();
                ((List)localObject1).size();
                if (i > 0) {
                  ((StringBuilder)localObject2).append(",");
                }
                ((StringBuilder)localObject2).append("{\"mac\":\"").append(((ScanResult)localObject4).BSSID.replace(":", "")).append("\",");
                ((StringBuilder)localObject2).append("\"rssi\":").append(((ScanResult)localObject4).level).append("}");
                i += 1;
                continue;
              }
              ((StringBuilder)localObject2).append("]");
              localObject1 = ((StringBuilder)localObject2).toString();
              continue;
              localObject3 = ((eb)localObject2).a;
              localObject5 = new StringBuilder();
              d1 = j.a(((Location)localObject3).getLatitude(), 6);
              d2 = j.a(((Location)localObject3).getLongitude(), 6);
              d3 = j.a(((Location)localObject3).getAltitude(), 1);
              d4 = j.a(((Location)localObject3).getAccuracy(), 1);
              d5 = j.a(((Location)localObject3).getBearing(), 1);
              d6 = j.a(((Location)localObject3).getSpeed(), 1);
              ((StringBuilder)localObject5).append("{");
              ((StringBuilder)localObject5).append("\"latitude\":");
              ((StringBuilder)localObject5).append(d1);
              ((StringBuilder)localObject5).append(",\"longitude\":");
              ((StringBuilder)localObject5).append(d2);
              ((StringBuilder)localObject5).append(",\"additional\":");
              ((StringBuilder)localObject5).append("\"" + d3 + "," + d4 + "," + d5 + "," + d6 + "," + ((eb)localObject2).b + "\"");
              ((StringBuilder)localObject5).append(",\"source\":");
              ((StringBuilder)localObject5).append(((eb)localObject2).d - 1);
              ((StringBuilder)localObject5).append("}");
              localObject2 = ((StringBuilder)localObject5).toString();
              continue;
            }
          }
        }
        continue;
        if (localObject1 == null)
        {
          localObject1 = "[]";
          continue;
          bool = false;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
  }
  
  public final String a(int paramInt, String paramString, dg paramdg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return b(paramInt, paramString, paramdg, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public final boolean a()
  {
    return this.c != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.g.ec
 * JD-Core Version:    0.7.0.1
 */