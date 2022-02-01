package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class rg
{
  public static ConcurrentHashMap<String, ft[]> a;
  public static final String f = "china";
  public static final String g = "inland";
  public static final String h = "taiwan";
  public static final String i = "outOfChina";
  private static volatile rg k;
  private static final String m = "124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666";
  private static final String n = "124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666";
  private static final String o = "121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:121.959229,21.677848";
  public String b;
  public String c;
  public boolean d;
  public volatile boolean e;
  public AtomicInteger j;
  private ReentrantReadWriteLock l;
  
  static
  {
    AppMethodBeat.i(223306);
    a = new ConcurrentHashMap();
    AppMethodBeat.o(223306);
  }
  
  private rg()
  {
    AppMethodBeat.i(223169);
    this.l = new ReentrantReadWriteLock();
    this.b = null;
    this.c = null;
    this.d = false;
    this.j = new AtomicInteger(0);
    AppMethodBeat.o(223169);
  }
  
  public static rg a()
  {
    AppMethodBeat.i(223181);
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new rg();
      }
      rg localrg = k;
      AppMethodBeat.o(223181);
      return localrg;
    }
    finally
    {
      AppMethodBeat.o(223181);
    }
  }
  
  private void a(Context paramContext)
  {
    AppMethodBeat.i(223193);
    if ((this.d) || (this.e))
    {
      AppMethodBeat.o(223193);
      return;
    }
    if (paramContext != null)
    {
      this.b = (paramContext.getFilesDir() + "/frontiers.dat");
      this.c = (this.b + ".bak");
    }
    jw.a(new jw.g()
    {
      private Boolean a()
      {
        AppMethodBeat.i(222879);
        rg.a(rg.this, true);
        Object localObject;
        if (rg.a(rg.this).getAndIncrement() <= 0)
        {
          localObject = rg.this.b();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label118;
          }
          localObject = rg.d("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
          rg.c().put("china", localObject);
          localObject = rg.d("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
          rg.c().put("inland", localObject);
          localObject = rg.d("121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:121.959229,21.677848");
          rg.c().put("taiwan", localObject);
        }
        for (;;)
        {
          rg.a(rg.this, false);
          rg.b(rg.this);
          localObject = Boolean.TRUE;
          AppMethodBeat.o(222879);
          return localObject;
          label118:
          rg.b((String)localObject);
        }
      }
    }).a(Boolean.FALSE);
    AppMethodBeat.o(223193);
  }
  
  public static boolean a(ft paramft, ft[] paramArrayOfft)
  {
    int i4;
    if ((paramArrayOfft == null) || (paramArrayOfft.length < 3)) {
      i4 = 0;
    }
    int i1;
    int i3;
    do
    {
      return i4;
      i2 = paramArrayOfft.length;
      i1 = 0;
      i3 = 0;
      i2 -= 1;
      i4 = i3;
    } while (i1 >= paramArrayOfft.length);
    if ((paramArrayOfft[i1].b >= paramft.b) || (paramArrayOfft[i2].b < paramft.b))
    {
      i4 = i3;
      if (paramArrayOfft[i2].b < paramft.b)
      {
        i4 = i3;
        if (paramArrayOfft[i1].b < paramft.b) {}
      }
    }
    else if (paramArrayOfft[i1].c > paramft.c)
    {
      i4 = i3;
      if (paramArrayOfft[i2].c > paramft.c) {}
    }
    else
    {
      double d1 = paramArrayOfft[i1].c;
      double d2 = (paramft.b - paramArrayOfft[i1].b) / (paramArrayOfft[i2].b - paramArrayOfft[i1].b);
      if ((paramArrayOfft[i2].c - paramArrayOfft[i1].c) * d2 + d1 >= paramft.c) {
        break label238;
      }
    }
    label238:
    for (int i2 = 1;; i2 = 0)
    {
      i4 = i3 ^ i2;
      i2 = i1;
      i1 += 1;
      i3 = i4;
      break;
    }
  }
  
  public static boolean a(ft[] paramArrayOfft1, ft[] paramArrayOfft2)
  {
    AppMethodBeat.i(223245);
    int i4 = paramArrayOfft1.length;
    int i1 = 0;
    int i2 = 0;
    if (i1 < i4)
    {
      i2 |= a(paramArrayOfft1[i1], paramArrayOfft2);
      if (i2 == 0) {}
    }
    for (i1 = 1;; i1 = 0)
    {
      int i5 = paramArrayOfft2.length;
      i2 = 0;
      i4 = 0;
      boolean bool = false;
      for (;;)
      {
        if (i2 < i5)
        {
          bool |= a(paramArrayOfft2[i2], paramArrayOfft1);
          if (bool) {
            i4 = 1;
          }
          int i3;
          i2 += 1;
          continue;
          i1 += 1;
          break;
        }
      }
      if ((i1 != 0) || (i4 != 0))
      {
        AppMethodBeat.o(223245);
        return true;
      }
      AppMethodBeat.o(223245);
      return false;
    }
  }
  
  /* Error */
  public static int b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 147
    //   4: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ifnull +10 -> 18
    //   11: aload_0
    //   12: invokevirtual 153	java/lang/String:length	()I
    //   15: ifne +10 -> 25
    //   18: ldc 147
    //   20: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: new 155	org/json/JSONObject
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 158	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 162	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   38: astore_3
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_2
    //   42: istore_1
    //   43: aload_3
    //   44: invokeinterface 168 1 0
    //   49: ifeq +76 -> 125
    //   52: aload_3
    //   53: invokeinterface 172 1 0
    //   58: checkcast 149	java/lang/String
    //   61: astore 4
    //   63: ldc 174
    //   65: aload 4
    //   67: invokevirtual 178	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +13 -> 83
    //   73: aload_0
    //   74: aload 4
    //   76: invokevirtual 181	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   79: istore_2
    //   80: goto -39 -> 41
    //   83: aload_0
    //   84: aload 4
    //   86: invokevirtual 185	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 188	com/tencent/mapsdk/internal/rg:e	(Ljava/lang/String;)[Lcom/tencent/mapsdk/internal/ft;
    //   92: astore 5
    //   94: iload_1
    //   95: istore_2
    //   96: aload 5
    //   98: ifnull -57 -> 41
    //   101: getstatic 57	com/tencent/mapsdk/internal/rg:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   104: aload 4
    //   106: aload 5
    //   108: invokevirtual 192	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: iload_1
    //   113: istore_2
    //   114: goto -73 -> 41
    //   117: astore_0
    //   118: ldc 147
    //   120: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: iload_1
    //   124: ireturn
    //   125: getstatic 57	com/tencent/mapsdk/internal/rg:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   128: ldc 13
    //   130: invokevirtual 195	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   133: ifne +23 -> 156
    //   136: ldc 27
    //   138: invokestatic 188	com/tencent/mapsdk/internal/rg:e	(Ljava/lang/String;)[Lcom/tencent/mapsdk/internal/ft;
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull +13 -> 156
    //   146: getstatic 57	com/tencent/mapsdk/internal/rg:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   149: ldc 13
    //   151: aload_0
    //   152: invokevirtual 192	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: getstatic 57	com/tencent/mapsdk/internal/rg:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   159: ldc 16
    //   161: invokevirtual 195	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   164: ifne +23 -> 187
    //   167: ldc 30
    //   169: invokestatic 188	com/tencent/mapsdk/internal/rg:e	(Ljava/lang/String;)[Lcom/tencent/mapsdk/internal/ft;
    //   172: astore_0
    //   173: aload_0
    //   174: ifnull +13 -> 187
    //   177: getstatic 57	com/tencent/mapsdk/internal/rg:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   180: ldc 16
    //   182: aload_0
    //   183: invokevirtual 192	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: getstatic 57	com/tencent/mapsdk/internal/rg:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   190: ldc 19
    //   192: invokevirtual 195	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   195: ifne +23 -> 218
    //   198: ldc 33
    //   200: invokestatic 188	com/tencent/mapsdk/internal/rg:e	(Ljava/lang/String;)[Lcom/tencent/mapsdk/internal/ft;
    //   203: astore_0
    //   204: aload_0
    //   205: ifnull +13 -> 218
    //   208: getstatic 57	com/tencent/mapsdk/internal/rg:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   211: ldc 19
    //   213: aload_0
    //   214: invokevirtual 192	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: goto -100 -> 118
    //   221: astore_0
    //   222: goto -104 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramString	String
    //   1	123	1	i1	int
    //   40	74	2	i2	int
    //   38	15	3	localIterator	java.util.Iterator
    //   61	44	4	str	String
    //   92	15	5	arrayOfft	ft[]
    // Exception table:
    //   from	to	target	type
    //   43	80	117	finally
    //   83	94	117	finally
    //   101	112	117	finally
    //   125	142	117	finally
    //   146	156	117	finally
    //   156	173	117	finally
    //   177	187	117	finally
    //   187	204	117	finally
    //   208	218	117	finally
    //   25	39	221	finally
  }
  
  public static ft[] c(String paramString)
  {
    AppMethodBeat.i(223222);
    paramString = (ft[])a.get(paramString);
    AppMethodBeat.o(223222);
    return paramString;
  }
  
  private void d()
  {
    AppMethodBeat.i(223257);
    if (this.j.decrementAndGet() == 0)
    {
      a.clear();
      this.d = false;
    }
    AppMethodBeat.o(223257);
  }
  
  private static ft[] e(String paramString)
  {
    AppMethodBeat.i(223211);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(223211);
      return null;
    }
    paramString = paramString.split(":");
    if (paramString.length == 0)
    {
      AppMethodBeat.o(223211);
      return null;
    }
    ft[] arrayOfft = new ft[paramString.length];
    int i1 = 0;
    while (i1 < paramString.length)
    {
      String[] arrayOfString = paramString[i1].split(",");
      arrayOfft[i1] = x.b(new GeoPoint((int)(Double.parseDouble(arrayOfString[1]) * 1000000.0D), (int)(Double.parseDouble(arrayOfString[0]) * 1000000.0D)));
      i1 += 1;
    }
    AppMethodBeat.o(223211);
    return arrayOfft;
  }
  
  public final boolean a(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(223316);
    this.l.writeLock().lock();
    File localFile1 = new File(this.b);
    File localFile2 = new File(this.c);
    if ((localFile2.exists()) && (!localFile2.delete()))
    {
      localFile2.deleteOnExit();
      AppMethodBeat.o(223316);
      return false;
    }
    try
    {
      if (localFile1.exists())
      {
        boolean bool = localFile1.renameTo(localFile2);
        if (!bool)
        {
          kb.a(null);
          localFile2.renameTo(localFile1);
          this.l.writeLock().unlock();
          AppMethodBeat.o(223316);
          return false;
        }
      }
      localFileOutputStream = new FileOutputStream(localFile1);
      kb.a(paramString);
    }
    finally
    {
      try
      {
        localFileOutputStream.write(paramString.getBytes("UTF-8"));
        localFileOutputStream.flush();
        kb.a(localFileOutputStream);
        localFile2.delete();
        this.l.writeLock().unlock();
        AppMethodBeat.o(223316);
        return true;
      }
      finally
      {
        for (;;)
        {
          FileOutputStream localFileOutputStream;
          paramString = localFileOutputStream;
        }
      }
      paramString = finally;
      paramString = localObject;
    }
    localFile2.renameTo(localFile1);
    this.l.writeLock().unlock();
    AppMethodBeat.o(223316);
    return false;
  }
  
  public final String b()
  {
    AppMethodBeat.i(223327);
    this.l.readLock().lock();
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(this.b));
      String str;
      Closeable localCloseable;
      kb.a(localCloseable);
    }
    finally
    {
      try
      {
        str = new String(kb.b(localFileInputStream), "UTF-8");
        kb.a(localFileInputStream);
        this.l.readLock().unlock();
        AppMethodBeat.o(223327);
        return str;
      }
      finally
      {
        break label75;
      }
      localObject1 = finally;
      localCloseable = null;
    }
    label75:
    this.l.readLock().unlock();
    AppMethodBeat.o(223327);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rg
 * JD-Core Version:    0.7.0.1
 */