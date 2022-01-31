package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.Nullable;

public final class dr
{
  public static final TencentLocationListener a = new TencentLocationListener()
  {
    public final void onLocationChanged(TencentLocation paramAnonymousTencentLocation, int paramAnonymousInt, String paramAnonymousString) {}
    
    public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2) {}
  };
  private static SparseArray<String> n;
  private ea A;
  private ee B;
  private ee C;
  private eb D;
  private final dg E;
  private TencentLocationListener F;
  private volatile boolean G;
  private volatile double H;
  private long I;
  private final Object J;
  private double K;
  private double L;
  private em M;
  private long N;
  private String O;
  private volatile boolean P;
  private cn Q;
  private byte[] R;
  public int b;
  public dx c;
  public volatile int d;
  public dh e;
  public List<TencentLocationListener> f;
  public long g;
  public volatile long h;
  public volatile int i;
  public final TencentLocationRequest j;
  public em k;
  public int l;
  public volatile dr.b m;
  private dr.a o;
  private dr.c p;
  private Handler q;
  private dn r;
  private dt s;
  private boolean t;
  private dq u;
  private dp v;
  private dl w;
  private ds x;
  private dv y;
  private dw z;
  
  static
  {
    Object localObject = new SparseArray();
    n = (SparseArray)localObject;
    ((SparseArray)localObject).put(0, "OK");
    n.put(1, "ERROR_NETWORK");
    n.put(2, "ERROR_NOCELL&WIFI_LOCATIONSWITCHOFF");
    n.put(4, "DEFLECT_FAILED");
    n.put(404, "ERROR_SERVER_NOT_LOCATION");
    localObject = new HashMap();
    ((HashMap)localObject).put("https", "true");
    ((HashMap)localObject).put("up_apps", "true");
    ((HashMap)localObject).put("up_wifis", "true");
    ((HashMap)localObject).put("start_daemon", "true");
    ((HashMap)localObject).put("up_daemon_delay", "300000");
    ((HashMap)localObject).put("gps_kalman", "false");
    ((HashMap)localObject).put("callback_wifis", "true");
    ((HashMap)localObject).put("min_wifi_scan_interval", "8000");
    ((HashMap)localObject).put("collect_bles", "true");
    ((HashMap)localObject).put("start_event_track", "true");
    ((HashMap)localObject).put("f_coll_item", "2");
    ((HashMap)localObject).put("f_coll_up_net", "w");
    dd.a((HashMap)localObject);
  }
  
  /* Error */
  public dr(dg paramdg)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokespecial 165	java/lang/Object:<init>	()V
    //   6: aload_0
    //   7: iconst_1
    //   8: putfield 167	c/t/m/g/dr:b	I
    //   11: aload_0
    //   12: lconst_0
    //   13: putfield 169	c/t/m/g/dr:g	J
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 171	c/t/m/g/dr:G	Z
    //   21: aload_0
    //   22: lconst_0
    //   23: putfield 173	c/t/m/g/dr:h	J
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 175	c/t/m/g/dr:i	I
    //   31: aload_0
    //   32: dconst_0
    //   33: putfield 177	c/t/m/g/dr:H	D
    //   36: aload_0
    //   37: new 4	java/lang/Object
    //   40: dup
    //   41: invokespecial 165	java/lang/Object:<init>	()V
    //   44: putfield 179	c/t/m/g/dr:J	Ljava/lang/Object;
    //   47: aload_0
    //   48: invokestatic 185	com/tencent/map/geolocation/TencentLocationRequest:create	()Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   51: putfield 187	c/t/m/g/dr:j	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   54: aload_0
    //   55: sipush 404
    //   58: putfield 189	c/t/m/g/dr:l	I
    //   61: aload_0
    //   62: getstatic 191	c/t/m/g/dr$b:d	Lc/t/m/g/dr$b;
    //   65: putfield 193	c/t/m/g/dr:m	Lc/t/m/g/dr$b;
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 195	c/t/m/g/dr:P	Z
    //   73: aload_0
    //   74: iconst_0
    //   75: newarray byte
    //   77: putfield 197	c/t/m/g/dr:R	[B
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 199	c/t/m/g/dr:d	I
    //   85: aload_0
    //   86: aload_1
    //   87: putfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   90: invokestatic 207	com/tencent/map/geolocation/TencentLocationManagerOptions:isLoadLibraryEnabled	()Z
    //   93: ifeq +8 -> 101
    //   96: ldc 209
    //   98: invokestatic 215	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   101: invokestatic 219	com/tencent/map/geolocation/TencentLocationManagerOptions:getKey	()Ljava/lang/String;
    //   104: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +13 -> 120
    //   110: aload_0
    //   111: getfield 227	c/t/m/g/dr:e	Lc/t/m/g/dh;
    //   114: invokestatic 219	com/tencent/map/geolocation/TencentLocationManagerOptions:getKey	()Ljava/lang/String;
    //   117: putfield 231	c/t/m/g/dh:h	Ljava/lang/String;
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   125: getfield 235	c/t/m/g/dg:b	Lc/t/m/g/dh;
    //   128: putfield 227	c/t/m/g/dr:e	Lc/t/m/g/dh;
    //   131: aload_0
    //   132: getfield 227	c/t/m/g/dr:e	Lc/t/m/g/dh;
    //   135: getfield 231	c/t/m/g/dh:h	Ljava/lang/String;
    //   138: invokestatic 240	c/t/m/g/j:c	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 4
    //   143: aload_0
    //   144: aload 4
    //   146: invokestatic 242	c/t/m/g/dr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   149: putfield 244	c/t/m/g/dr:O	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 244	c/t/m/g/dr:O	Ljava/lang/String;
    //   156: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +74 -> 233
    //   162: ldc 246
    //   164: bipush 6
    //   166: new 248	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 250
    //   172: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload 4
    //   177: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 258
    //   183: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_0
    //   193: iconst_2
    //   194: putfield 199	c/t/m/g/dr:d	I
    //   197: return
    //   198: astore_1
    //   199: ldc_w 266
    //   202: ldc_w 268
    //   205: aload_1
    //   206: invokestatic 271	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_0
    //   210: iconst_3
    //   211: putfield 199	c/t/m/g/dr:d	I
    //   214: return
    //   215: astore 4
    //   217: ldc_w 273
    //   220: bipush 6
    //   222: aload 4
    //   224: invokevirtual 274	java/lang/Throwable:toString	()Ljava/lang/String;
    //   227: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: goto -110 -> 120
    //   233: aload_0
    //   234: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   237: aload_0
    //   238: invokevirtual 277	c/t/m/g/dg:a	(Ljava/lang/Object;)V
    //   241: aload_0
    //   242: new 279	c/t/m/g/dw
    //   245: dup
    //   246: invokespecial 280	c/t/m/g/dw:<init>	()V
    //   249: putfield 282	c/t/m/g/dr:z	Lc/t/m/g/dw;
    //   252: aload_0
    //   253: new 284	java/util/concurrent/CopyOnWriteArrayList
    //   256: dup
    //   257: invokespecial 285	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   260: putfield 287	c/t/m/g/dr:f	Ljava/util/List;
    //   263: aload_0
    //   264: new 289	c/t/m/g/ds
    //   267: dup
    //   268: aload_0
    //   269: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   272: invokespecial 291	c/t/m/g/ds:<init>	(Lc/t/m/g/dg;)V
    //   275: putfield 293	c/t/m/g/dr:x	Lc/t/m/g/ds;
    //   278: aload_0
    //   279: new 295	c/t/m/g/dv
    //   282: dup
    //   283: aload_0
    //   284: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   287: invokespecial 296	c/t/m/g/dv:<init>	(Lc/t/m/g/dg;)V
    //   290: putfield 298	c/t/m/g/dr:y	Lc/t/m/g/dv;
    //   293: aload_0
    //   294: aload_1
    //   295: getfield 301	c/t/m/g/dg:a	Landroid/content/Context;
    //   298: invokestatic 306	c/t/m/g/dp:a	(Landroid/content/Context;)Lc/t/m/g/dp;
    //   301: putfield 308	c/t/m/g/dr:v	Lc/t/m/g/dp;
    //   304: getstatic 313	android/os/Build$VERSION:SDK_INT	I
    //   307: bipush 21
    //   309: if_icmplt +21 -> 330
    //   312: aload_0
    //   313: new 315	c/t/m/g/dl
    //   316: dup
    //   317: aload_0
    //   318: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   321: getfield 301	c/t/m/g/dg:a	Landroid/content/Context;
    //   324: invokespecial 318	c/t/m/g/dl:<init>	(Landroid/content/Context;)V
    //   327: putfield 320	c/t/m/g/dr:w	Lc/t/m/g/dl;
    //   330: getstatic 313	android/os/Build$VERSION:SDK_INT	I
    //   333: bipush 18
    //   335: if_icmplt +114 -> 449
    //   338: iconst_1
    //   339: istore_2
    //   340: aload_0
    //   341: iload_2
    //   342: putfield 322	c/t/m/g/dr:t	Z
    //   345: aload_0
    //   346: getfield 322	c/t/m/g/dr:t	Z
    //   349: ifeq +120 -> 469
    //   352: aload_0
    //   353: aconst_null
    //   354: putfield 324	c/t/m/g/dr:r	Lc/t/m/g/dn;
    //   357: aload_0
    //   358: aload_0
    //   359: invokespecial 327	c/t/m/g/dr:j	()Lc/t/m/g/dx;
    //   362: putfield 329	c/t/m/g/dr:c	Lc/t/m/g/dx;
    //   365: aload_0
    //   366: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   369: invokevirtual 331	c/t/m/g/dg:b	()Z
    //   372: ifne +82 -> 454
    //   375: ldc 246
    //   377: bipush 6
    //   379: ldc_w 333
    //   382: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aconst_null
    //   386: astore_1
    //   387: aload_0
    //   388: aload_1
    //   389: putfield 335	c/t/m/g/dr:s	Lc/t/m/g/dt;
    //   392: aload_0
    //   393: aload_0
    //   394: invokespecial 338	c/t/m/g/dr:i	()Lc/t/m/g/dq;
    //   397: putfield 340	c/t/m/g/dr:u	Lc/t/m/g/dq;
    //   400: aload_0
    //   401: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   404: getfield 301	c/t/m/g/dg:a	Landroid/content/Context;
    //   407: ldc_w 342
    //   410: aload_0
    //   411: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   414: getfield 235	c/t/m/g/dg:b	Lc/t/m/g/dh;
    //   417: invokevirtual 344	c/t/m/g/dh:d	()Ljava/lang/String;
    //   420: invokestatic 347	c/t/m/g/dd:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload_0
    //   424: getfield 244	c/t/m/g/dr:O	Ljava/lang/String;
    //   427: invokestatic 349	c/t/m/g/dd:a	(Ljava/lang/String;)V
    //   430: invokestatic 352	c/t/m/g/dd:a	()Lc/t/m/g/dd;
    //   433: aload_0
    //   434: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   437: getfield 355	c/t/m/g/dg:h	Lcom/tencent/map/geolocation/internal/TencentHttpClient;
    //   440: checkcast 357	c/t/m/g/dc
    //   443: putfield 360	c/t/m/g/dd:a	Lc/t/m/g/dc;
    //   446: return
    //   447: astore_1
    //   448: return
    //   449: iconst_0
    //   450: istore_2
    //   451: goto -111 -> 340
    //   454: new 362	c/t/m/g/dt
    //   457: dup
    //   458: aload_0
    //   459: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   462: invokespecial 363	c/t/m/g/dt:<init>	(Lc/t/m/g/dg;)V
    //   465: astore_1
    //   466: goto -79 -> 387
    //   469: aload_0
    //   470: aconst_null
    //   471: putfield 335	c/t/m/g/dr:s	Lc/t/m/g/dt;
    //   474: aload_0
    //   475: aload_0
    //   476: invokespecial 327	c/t/m/g/dr:j	()Lc/t/m/g/dx;
    //   479: putfield 329	c/t/m/g/dr:c	Lc/t/m/g/dx;
    //   482: aload_0
    //   483: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   486: invokevirtual 331	c/t/m/g/dg:b	()Z
    //   489: ifne +31 -> 520
    //   492: ldc 246
    //   494: bipush 6
    //   496: ldc_w 365
    //   499: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload_3
    //   503: astore_1
    //   504: aload_0
    //   505: aload_1
    //   506: putfield 324	c/t/m/g/dr:r	Lc/t/m/g/dn;
    //   509: aload_0
    //   510: aload_0
    //   511: invokespecial 338	c/t/m/g/dr:i	()Lc/t/m/g/dq;
    //   514: putfield 340	c/t/m/g/dr:u	Lc/t/m/g/dq;
    //   517: goto -117 -> 400
    //   520: new 367	c/t/m/g/dn
    //   523: dup
    //   524: aload_0
    //   525: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   528: invokespecial 368	c/t/m/g/dn:<init>	(Lc/t/m/g/dg;)V
    //   531: astore_1
    //   532: goto -28 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	dr
    //   0	535	1	paramdg	dg
    //   339	112	2	bool	boolean
    //   1	502	3	localObject	Object
    //   141	35	4	str	String
    //   215	8	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   96	101	198	java/lang/Throwable
    //   101	120	215	java/lang/Throwable
    //   400	446	447	java/lang/Throwable
  }
  
  private static String a(String paramString)
  {
    int i1 = 1;
    if (paramString.contains(",")) {}
    try
    {
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length <= 1) || (paramString[0] == null) || (paramString[1] == null) || (e.w(paramString[0], paramString[1]) <= 0)) {
        break label86;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      return null;
    }
    i1 = e.v(paramString);
    if (i1 >= 0) {
      return Integer.toString(i1);
    }
    return "";
    while (i1 != 0)
    {
      return paramString[0];
      label86:
      i1 = 0;
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1;
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      localObject1 = null;
      localObject2 = null;
    }
    for (;;)
    {
      Object localObject4;
      Object localObject3;
      if (this.p != null)
      {
        Message localMessage = this.p.obtainMessage(3102);
        localObject4 = localMessage.getData();
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = new Bundle();
        }
        ((Bundle)localObject3).clear();
        ((Bundle)localObject3).putString("name", (String)localObject2);
        ((Bundle)localObject3).putInt("status", paramInt2);
        ((Bundle)localObject3).putString("desc", (String)localObject1);
        localMessage.setData((Bundle)localObject3);
        localMessage.sendToTarget();
      }
      return;
      switch (paramInt2)
      {
      default: 
        localObject1 = "unknown";
        localObject2 = "gps";
        break;
      case 1: 
        localObject1 = "gps enabled";
        localObject2 = "gps";
        break;
      case 0: 
        localObject1 = "gps disabled";
        localObject2 = "gps";
        continue;
        switch (paramInt2)
        {
        default: 
          localObject1 = "unknown";
          localObject2 = "gps";
          break;
        case 3: 
          localObject1 = "gps available";
          localObject2 = "gps";
          break;
        case 4: 
          localObject1 = "gps unavailable";
          localObject2 = "gps";
          continue;
          localObject3 = "cell";
          if (paramInt2 == 1) {
            localObject1 = "cell enabled";
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (!en.a) {
              break label412;
            }
            localObject1 = "location permission denied";
            localObject2 = "cell";
            paramInt2 = 2;
            break;
            if (paramInt2 == 0) {
              localObject1 = "cell disabled";
            } else {
              localObject1 = "unknown";
            }
          }
          localObject4 = "wifi";
          switch (paramInt2)
          {
          case 2: 
          case 3: 
          case 4: 
          default: 
            localObject1 = "unknown";
          }
          for (;;)
          {
            localObject2 = localObject1;
            localObject3 = localObject4;
            if (paramInt2 == 5) {
              break label412;
            }
            localObject2 = localObject1;
            localObject3 = localObject4;
            if (!es.a) {
              break label412;
            }
            localObject1 = "location permission denied";
            localObject2 = "wifi";
            paramInt2 = 2;
            break;
            localObject1 = "wifi disabled";
            continue;
            localObject1 = "wifi enabled";
            continue;
            localObject1 = "location service switch is off";
          }
          label412:
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        break;
      }
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.o != null)
    {
      this.o.removeMessages(paramInt);
      this.o.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(int paramInt, em paramem)
  {
    int i2 = 1;
    if (paramem == null) {
      return;
    }
    if ((paramInt == 0) && (paramem.getLatitude() != 0.0D) && (paramem.getLongitude() != 0.0D)) {
      if ((this.b != 1) || (!eo.a(paramem.getLatitude(), paramem.getLongitude()))) {
        break label438;
      }
    }
    label156:
    label433:
    label438:
    for (int i1 = 1;; i1 = 0)
    {
      em.a(paramem, i1);
      boolean bool;
      if (g())
      {
        if ((paramem.getAccuracy() < 5000.0F) && (paramem.getAccuracy() > 0.0F))
        {
          this.z.a(paramem);
          bool = this.G;
        }
        this.K = paramem.getLatitude();
        this.L = paramem.getLongitude();
        if (this.F != null)
        {
          i1 = 1;
          if ((i1 != 0) && (this.j.getInterval() > 0L)) {
            a(11999, this.j.getInterval());
          }
          if ((this.l == 0) || (paramInt != 0)) {
            break label433;
          }
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        this.l = paramInt;
        this.k = paramem;
        if (this.j.getInterval() == 0L)
        {
          if (this.F != null) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if ((paramInt == 0) || ("gps" == this.k.getProvider())) {
              break label402;
            }
            a(11998);
            return;
            i1 = 0;
            break;
            if ((paramInt != 0) || (paramem.getLatitude() == 0.0D) || (paramem.getLongitude() == 0.0D) || (Math.abs(paramem.getLatitude() - this.K) < 1.0E-008D) || (Math.abs(paramem.getLongitude() - this.L) < 1.0E-008D)) {
              break label156;
            }
            if (!this.z.a(paramem, this.E, this.u.b()))
            {
              j.a("TxLocationManagerImpl", 4, "discard " + paramem);
              return;
            }
            this.K = paramem.getLatitude();
            this.L = paramem.getLongitude();
            if ((paramem.getAccuracy() >= 5000.0F) || (paramem.getAccuracy() <= 0.0F)) {
              break label156;
            }
            this.z.a(paramem);
            this.z.a(paramem);
            bool = this.G;
            break label156;
          }
        }
        if (i1 == 0) {
          break;
        }
        if (this.F != null) {}
        for (paramInt = i2; paramInt != 0; paramInt = 0)
        {
          a(11998);
          return;
        }
        break;
      }
    }
  }
  
  /* Error */
  private void a(Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 197	c/t/m/g/dr:R	[B
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: invokestatic 569	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   12: ifnonnull +6 -> 18
    //   15: invokestatic 572	android/os/Looper:prepare	()V
    //   18: aload_0
    //   19: getfield 408	c/t/m/g/dr:p	Lc/t/m/g/dr$c;
    //   22: ifnonnull +1983 -> 2005
    //   25: iconst_1
    //   26: istore_2
    //   27: iload_2
    //   28: ifne +14 -> 42
    //   31: aload_0
    //   32: getfield 408	c/t/m/g/dr:p	Lc/t/m/g/dr$c;
    //   35: invokevirtual 575	c/t/m/g/dr$c:getLooper	()Landroid/os/Looper;
    //   38: aload_1
    //   39: if_acmpeq +16 -> 55
    //   42: aload_0
    //   43: new 14	c/t/m/g/dr$c
    //   46: dup
    //   47: aload_0
    //   48: aload_1
    //   49: invokespecial 578	c/t/m/g/dr$c:<init>	(Lc/t/m/g/dr;Landroid/os/Looper;)V
    //   52: putfield 408	c/t/m/g/dr:p	Lc/t/m/g/dr$c;
    //   55: aload_0
    //   56: getfield 408	c/t/m/g/dr:p	Lc/t/m/g/dr$c;
    //   59: aconst_null
    //   60: invokevirtual 581	c/t/m/g/dr$c:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   63: aload_0
    //   64: getfield 583	c/t/m/g/dr:q	Landroid/os/Handler;
    //   67: ifnull +16 -> 83
    //   70: aload_0
    //   71: getfield 583	c/t/m/g/dr:q	Landroid/os/Handler;
    //   74: invokevirtual 586	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   77: invokestatic 589	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   80: if_acmpeq +17 -> 97
    //   83: aload_0
    //   84: new 585	android/os/Handler
    //   87: dup
    //   88: invokestatic 589	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   91: invokespecial 591	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   94: putfield 583	c/t/m/g/dr:q	Landroid/os/Handler;
    //   97: aload_0
    //   98: invokespecial 593	c/t/m/g/dr:e	()V
    //   101: aload_0
    //   102: getfield 483	c/t/m/g/dr:o	Lc/t/m/g/dr$a;
    //   105: ifnonnull +933 -> 1038
    //   108: aload_0
    //   109: new 10	c/t/m/g/dr$a
    //   112: dup
    //   113: aload_0
    //   114: invokestatic 596	c/t/m/g/dg:d	()Landroid/os/HandlerThread;
    //   117: invokevirtual 599	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   120: invokespecial 600	c/t/m/g/dr$a:<init>	(Lc/t/m/g/dr;Landroid/os/Looper;)V
    //   123: putfield 483	c/t/m/g/dr:o	Lc/t/m/g/dr$a;
    //   126: aload_0
    //   127: getfield 187	c/t/m/g/dr:j	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   130: invokevirtual 603	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   133: ldc_w 605
    //   136: iconst_1
    //   137: invokevirtual 609	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   140: istore 4
    //   142: getstatic 611	c/t/m/g/dr$b:b	Lc/t/m/g/dr$b;
    //   145: aload_0
    //   146: getfield 193	c/t/m/g/dr:m	Lc/t/m/g/dr$b;
    //   149: if_acmpne +905 -> 1054
    //   152: iconst_1
    //   153: istore_3
    //   154: aload_0
    //   155: getfield 483	c/t/m/g/dr:o	Lc/t/m/g/dr$a;
    //   158: astore 5
    //   160: aload_0
    //   161: getfield 298	c/t/m/g/dr:y	Lc/t/m/g/dv;
    //   164: astore_1
    //   165: aload_1
    //   166: getfield 613	c/t/m/g/dv:g	Z
    //   169: ifne +46 -> 215
    //   172: aload_1
    //   173: iconst_1
    //   174: putfield 613	c/t/m/g/dv:g	Z
    //   177: aload_1
    //   178: aload 5
    //   180: putfield 615	c/t/m/g/dv:i	Landroid/os/Handler;
    //   183: aload_1
    //   184: iload_3
    //   185: putfield 617	c/t/m/g/dv:h	Z
    //   188: aload_1
    //   189: getfield 619	c/t/m/g/dv:b	Lc/t/m/g/dg;
    //   192: getfield 622	c/t/m/g/dg:c	Ljava/util/concurrent/ExecutorService;
    //   195: new 624	c/t/m/g/dv$1
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 627	c/t/m/g/dv$1:<init>	(Lc/t/m/g/dv;)V
    //   203: invokeinterface 633 2 0
    //   208: aload_1
    //   209: invokestatic 638	android/os/SystemClock:elapsedRealtime	()J
    //   212: putfield 640	c/t/m/g/dv:f	J
    //   215: aload_0
    //   216: getfield 322	c/t/m/g/dr:t	Z
    //   219: ifeq +875 -> 1094
    //   222: iload 4
    //   224: ifeq +143 -> 367
    //   227: aload_0
    //   228: getfield 335	c/t/m/g/dr:s	Lc/t/m/g/dt;
    //   231: ifnull +828 -> 1059
    //   234: iconst_1
    //   235: istore_2
    //   236: goto +1741 -> 1977
    //   239: iload_2
    //   240: ifeq +127 -> 367
    //   243: aload_0
    //   244: getfield 335	c/t/m/g/dr:s	Lc/t/m/g/dt;
    //   247: astore_1
    //   248: aload_1
    //   249: getfield 641	c/t/m/g/dt:a	Z
    //   252: ifne +115 -> 367
    //   255: aload_1
    //   256: aload 5
    //   258: putfield 642	c/t/m/g/dt:i	Landroid/os/Handler;
    //   261: aload_1
    //   262: getfield 644	c/t/m/g/dt:j	Ljava/util/List;
    //   265: ifnonnull +14 -> 279
    //   268: aload_1
    //   269: new 646	java/util/ArrayList
    //   272: dup
    //   273: invokespecial 647	java/util/ArrayList:<init>	()V
    //   276: putfield 644	c/t/m/g/dt:j	Ljava/util/List;
    //   279: aload_1
    //   280: new 598	android/os/HandlerThread
    //   283: dup
    //   284: ldc_w 649
    //   287: invokespecial 650	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   290: putfield 653	c/t/m/g/dt:f	Landroid/os/HandlerThread;
    //   293: aload_1
    //   294: getfield 653	c/t/m/g/dt:f	Landroid/os/HandlerThread;
    //   297: ifnull +70 -> 367
    //   300: aload_1
    //   301: getfield 642	c/t/m/g/dt:i	Landroid/os/Handler;
    //   304: astore 7
    //   306: aload 7
    //   308: ifnull +59 -> 367
    //   311: aload_1
    //   312: getfield 653	c/t/m/g/dt:f	Landroid/os/HandlerThread;
    //   315: invokevirtual 656	android/os/HandlerThread:start	()V
    //   318: aload_1
    //   319: new 658	c/t/m/g/dt$a
    //   322: dup
    //   323: aload_1
    //   324: aload_1
    //   325: getfield 653	c/t/m/g/dt:f	Landroid/os/HandlerThread;
    //   328: invokevirtual 599	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   331: iconst_0
    //   332: invokespecial 661	c/t/m/g/dt$a:<init>	(Lc/t/m/g/dt;Landroid/os/Looper;B)V
    //   335: putfield 664	c/t/m/g/dt:g	Lc/t/m/g/dt$a;
    //   338: aload_1
    //   339: getfield 664	c/t/m/g/dt:g	Lc/t/m/g/dt$a;
    //   342: new 666	c/t/m/g/dt$1
    //   345: dup
    //   346: aload_1
    //   347: invokespecial 669	c/t/m/g/dt$1:<init>	(Lc/t/m/g/dt;)V
    //   350: invokevirtual 673	c/t/m/g/dt$a:post	(Ljava/lang/Runnable;)Z
    //   353: pop
    //   354: iload_3
    //   355: ifne +12 -> 367
    //   358: aload_1
    //   359: getfield 664	c/t/m/g/dt:g	Lc/t/m/g/dt$a;
    //   362: iconst_0
    //   363: invokevirtual 677	c/t/m/g/dt$a:sendEmptyMessage	(I)Z
    //   366: pop
    //   367: iload 4
    //   369: ifeq +66 -> 435
    //   372: aload_0
    //   373: getfield 329	c/t/m/g/dr:c	Lc/t/m/g/dx;
    //   376: ifnull +889 -> 1265
    //   379: iconst_1
    //   380: istore_2
    //   381: goto +1610 -> 1991
    //   384: iload_2
    //   385: ifeq +50 -> 435
    //   388: aload_0
    //   389: getfield 329	c/t/m/g/dr:c	Lc/t/m/g/dx;
    //   392: aload_0
    //   393: getfield 227	c/t/m/g/dr:e	Lc/t/m/g/dh;
    //   396: getfield 679	c/t/m/g/dh:k	J
    //   399: putfield 683	c/t/m/g/dx:j	J
    //   402: aload_0
    //   403: getfield 329	c/t/m/g/dr:c	Lc/t/m/g/dx;
    //   406: astore 8
    //   408: aload_0
    //   409: getfield 408	c/t/m/g/dr:p	Lc/t/m/g/dr$c;
    //   412: astore 9
    //   414: aload 8
    //   416: getfield 685	c/t/m/g/dx:k	[B
    //   419: astore 7
    //   421: aload 7
    //   423: monitorenter
    //   424: aload 8
    //   426: getfield 686	c/t/m/g/dx:a	Z
    //   429: ifeq +846 -> 1275
    //   432: aload 7
    //   434: monitorexit
    //   435: aload_0
    //   436: getfield 340	c/t/m/g/dr:u	Lc/t/m/g/dq;
    //   439: ifnull +976 -> 1415
    //   442: iconst_1
    //   443: istore_2
    //   444: iload_2
    //   445: ifeq +187 -> 632
    //   448: aload_0
    //   449: getfield 187	c/t/m/g/dr:j	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   452: invokevirtual 689	com/tencent/map/geolocation/TencentLocationRequest:isAllowGPS	()Z
    //   455: ifeq +177 -> 632
    //   458: aload 5
    //   460: ifnull +960 -> 1420
    //   463: iconst_1
    //   464: istore_2
    //   465: iload_2
    //   466: ifeq +166 -> 632
    //   469: aload_0
    //   470: getfield 340	c/t/m/g/dr:u	Lc/t/m/g/dq;
    //   473: astore_1
    //   474: aload_0
    //   475: getfield 167	c/t/m/g/dr:b	I
    //   478: iconst_1
    //   479: if_icmpne +946 -> 1425
    //   482: iconst_1
    //   483: istore 4
    //   485: aload_1
    //   486: iload 4
    //   488: putfield 691	c/t/m/g/dq:l	Z
    //   491: aload_0
    //   492: getfield 340	c/t/m/g/dr:u	Lc/t/m/g/dq;
    //   495: astore 7
    //   497: aload 7
    //   499: getfield 693	c/t/m/g/dq:k	Z
    //   502: ifne +130 -> 632
    //   505: aload 7
    //   507: iconst_1
    //   508: putfield 693	c/t/m/g/dq:k	Z
    //   511: aload 7
    //   513: lconst_0
    //   514: putfield 695	c/t/m/g/dq:d	J
    //   517: aload 5
    //   519: ifnonnull +912 -> 1431
    //   522: aconst_null
    //   523: astore_1
    //   524: aload 7
    //   526: getfield 698	c/t/m/g/dq:n	Lc/t/m/g/dq$a;
    //   529: ifnull +15 -> 544
    //   532: aload 7
    //   534: getfield 698	c/t/m/g/dq:n	Lc/t/m/g/dq$a;
    //   537: invokevirtual 701	c/t/m/g/dq$a:getLooper	()Landroid/os/Looper;
    //   540: aload_1
    //   541: if_acmpeq +22 -> 563
    //   544: aload_1
    //   545: ifnull +18 -> 563
    //   548: aload 7
    //   550: new 700	c/t/m/g/dq$a
    //   553: dup
    //   554: aload 7
    //   556: aload_1
    //   557: invokespecial 704	c/t/m/g/dq$a:<init>	(Lc/t/m/g/dq;Landroid/os/Looper;)V
    //   560: putfield 698	c/t/m/g/dq:n	Lc/t/m/g/dq$a;
    //   563: iload_3
    //   564: ifne +910 -> 1474
    //   567: aload 7
    //   569: getfield 707	c/t/m/g/dq:o	Landroid/location/LocationManager;
    //   572: ldc_w 449
    //   575: ldc2_w 708
    //   578: fconst_0
    //   579: aload 7
    //   581: aload 7
    //   583: getfield 698	c/t/m/g/dq:n	Lc/t/m/g/dq$a;
    //   586: invokevirtual 701	c/t/m/g/dq$a:getLooper	()Landroid/os/Looper;
    //   589: invokevirtual 715	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   592: aload 7
    //   594: getfield 707	c/t/m/g/dq:o	Landroid/location/LocationManager;
    //   597: aload 7
    //   599: invokevirtual 719	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   602: pop
    //   603: aload 7
    //   605: invokevirtual 549	c/t/m/g/dq:b	()Z
    //   608: ifeq +14 -> 622
    //   611: aload 7
    //   613: iconst_4
    //   614: putfield 720	c/t/m/g/dq:b	I
    //   617: aload 7
    //   619: invokevirtual 722	c/t/m/g/dq:c	()V
    //   622: ldc_w 724
    //   625: iconst_4
    //   626: ldc_w 726
    //   629: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: iload_3
    //   633: ifeq +981 -> 1614
    //   636: aload_0
    //   637: getfield 298	c/t/m/g/dr:y	Lc/t/m/g/dv;
    //   640: astore_1
    //   641: aload_0
    //   642: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   645: invokevirtual 728	c/t/m/g/dg:e	()Ljava/lang/String;
    //   648: astore 7
    //   650: aload 7
    //   652: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   655: istore 4
    //   657: iload 4
    //   659: ifeq +851 -> 1510
    //   662: aload 5
    //   664: ifnull +1271 -> 1935
    //   667: iconst_1
    //   668: istore_2
    //   669: iload_2
    //   670: ifeq +364 -> 1034
    //   673: invokestatic 733	c/t/m/g/de:a	()Lc/t/m/g/de;
    //   676: ldc 147
    //   678: invokevirtual 735	c/t/m/g/de:b	(Ljava/lang/String;)I
    //   681: istore_2
    //   682: iload_2
    //   683: iconst_1
    //   684: if_icmpeq +8 -> 692
    //   687: iload_2
    //   688: iconst_2
    //   689: if_icmpne +28 -> 717
    //   692: aload_0
    //   693: getfield 737	c/t/m/g/dr:Q	Lc/t/m/g/cn;
    //   696: ifnonnull +21 -> 717
    //   699: aload_0
    //   700: new 739	c/t/m/g/cn
    //   703: dup
    //   704: aload_0
    //   705: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   708: getfield 301	c/t/m/g/dg:a	Landroid/content/Context;
    //   711: invokespecial 740	c/t/m/g/cn:<init>	(Landroid/content/Context;)V
    //   714: putfield 737	c/t/m/g/dr:Q	Lc/t/m/g/cn;
    //   717: aload_0
    //   718: getfield 737	c/t/m/g/dr:Q	Lc/t/m/g/cn;
    //   721: ifnull +313 -> 1034
    //   724: aload 5
    //   726: ifnull +308 -> 1034
    //   729: ldc 246
    //   731: iconst_4
    //   732: new 248	java/lang/StringBuilder
    //   735: dup
    //   736: ldc_w 742
    //   739: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   742: iload_2
    //   743: invokevirtual 745	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   746: ldc_w 747
    //   749: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: iload_3
    //   753: invokevirtual 750	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   756: ldc_w 752
    //   759: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: iload_2
    //   769: iconst_2
    //   770: if_icmpeq +12 -> 782
    //   773: iload_2
    //   774: iconst_1
    //   775: if_icmpne +259 -> 1034
    //   778: iload_3
    //   779: ifne +255 -> 1034
    //   782: aload_0
    //   783: getfield 737	c/t/m/g/dr:Q	Lc/t/m/g/cn;
    //   786: astore 7
    //   788: aload_0
    //   789: invokespecial 755	c/t/m/g/dr:d	()Lc/t/m/g/co;
    //   792: astore 8
    //   794: aload 7
    //   796: getfield 757	c/t/m/g/cn:a	[B
    //   799: astore_1
    //   800: aload_1
    //   801: monitorenter
    //   802: aload 7
    //   804: getfield 760	c/t/m/g/cn:c	Lc/t/m/g/ct;
    //   807: ifnull +100 -> 907
    //   810: aload 8
    //   812: aload 7
    //   814: getfield 762	c/t/m/g/cn:b	Landroid/content/Context;
    //   817: putfield 765	c/t/m/g/co:a	Landroid/content/Context;
    //   820: aload 7
    //   822: getfield 760	c/t/m/g/cn:c	Lc/t/m/g/ct;
    //   825: aload 8
    //   827: putfield 770	c/t/m/g/ct:c	Lc/t/m/g/co;
    //   830: ldc_w 772
    //   833: new 248	java/lang/StringBuilder
    //   836: dup
    //   837: ldc_w 774
    //   840: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   843: aload 8
    //   845: getfield 776	c/t/m/g/co:c	Ljava/lang/String;
    //   848: invokestatic 777	c/t/m/g/co:a	(Ljava/lang/String;)Ljava/lang/String;
    //   851: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: ldc_w 779
    //   857: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload 8
    //   862: getfield 781	c/t/m/g/co:b	Ljava/lang/String;
    //   865: invokestatic 777	c/t/m/g/co:a	(Ljava/lang/String;)Ljava/lang/String;
    //   868: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: ldc_w 381
    //   874: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: getstatic 786	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   880: invokestatic 777	c/t/m/g/co:a	(Ljava/lang/String;)Ljava/lang/String;
    //   883: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: ldc_w 381
    //   889: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: getstatic 789	android/os/Build:MODEL	Ljava/lang/String;
    //   895: invokestatic 777	c/t/m/g/co:a	(Ljava/lang/String;)Ljava/lang/String;
    //   898: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokestatic 793	c/t/m/g/cq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: aload_1
    //   908: monitorexit
    //   909: aload_0
    //   910: getfield 737	c/t/m/g/dr:Q	Lc/t/m/g/cn;
    //   913: ldc_w 795
    //   916: invokestatic 733	c/t/m/g/de:a	()Lc/t/m/g/de;
    //   919: ldc 151
    //   921: invokevirtual 797	c/t/m/g/de:e	(Ljava/lang/String;)Ljava/lang/String;
    //   924: invokevirtual 798	c/t/m/g/cn:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   927: aload_0
    //   928: getfield 737	c/t/m/g/dr:Q	Lc/t/m/g/cn;
    //   931: astore 8
    //   933: aload 5
    //   935: invokevirtual 586	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   938: astore 5
    //   940: aload 8
    //   942: getfield 757	c/t/m/g/cn:a	[B
    //   945: astore 7
    //   947: aload 7
    //   949: monitorenter
    //   950: aload 8
    //   952: invokevirtual 799	c/t/m/g/cn:c	()V
    //   955: aload 8
    //   957: getfield 760	c/t/m/g/cn:c	Lc/t/m/g/ct;
    //   960: ifnull +71 -> 1031
    //   963: aload 5
    //   965: astore_1
    //   966: aload 5
    //   968: ifnonnull +35 -> 1003
    //   971: aload 8
    //   973: new 598	android/os/HandlerThread
    //   976: dup
    //   977: ldc_w 801
    //   980: invokespecial 650	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   983: putfield 803	c/t/m/g/cn:d	Landroid/os/HandlerThread;
    //   986: aload 8
    //   988: getfield 803	c/t/m/g/cn:d	Landroid/os/HandlerThread;
    //   991: invokevirtual 656	android/os/HandlerThread:start	()V
    //   994: aload 8
    //   996: getfield 803	c/t/m/g/cn:d	Landroid/os/HandlerThread;
    //   999: invokevirtual 599	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1002: astore_1
    //   1003: aload 8
    //   1005: getfield 760	c/t/m/g/cn:c	Lc/t/m/g/ct;
    //   1008: astore 8
    //   1010: aload 8
    //   1012: getfield 807	c/t/m/g/cs:b	[B
    //   1015: astore 5
    //   1017: aload 5
    //   1019: monitorenter
    //   1020: aload 8
    //   1022: getfield 808	c/t/m/g/cs:a	Z
    //   1025: ifeq +922 -> 1947
    //   1028: aload 5
    //   1030: monitorexit
    //   1031: aload 7
    //   1033: monitorexit
    //   1034: aload 6
    //   1036: monitorexit
    //   1037: return
    //   1038: aload_0
    //   1039: getfield 483	c/t/m/g/dr:o	Lc/t/m/g/dr$a;
    //   1042: invokevirtual 810	c/t/m/g/dr$a:a	()V
    //   1045: goto -919 -> 126
    //   1048: astore_1
    //   1049: aload 6
    //   1051: monitorexit
    //   1052: aload_1
    //   1053: athrow
    //   1054: iconst_0
    //   1055: istore_3
    //   1056: goto -902 -> 154
    //   1059: iconst_0
    //   1060: istore_2
    //   1061: goto +916 -> 1977
    //   1064: iconst_0
    //   1065: istore_2
    //   1066: goto -827 -> 239
    //   1069: astore 7
    //   1071: aload_1
    //   1072: new 658	c/t/m/g/dt$a
    //   1075: dup
    //   1076: aload_1
    //   1077: aload_1
    //   1078: getfield 642	c/t/m/g/dt:i	Landroid/os/Handler;
    //   1081: invokevirtual 586	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1084: iconst_0
    //   1085: invokespecial 661	c/t/m/g/dt$a:<init>	(Lc/t/m/g/dt;Landroid/os/Looper;B)V
    //   1088: putfield 664	c/t/m/g/dt:g	Lc/t/m/g/dt$a;
    //   1091: goto -753 -> 338
    //   1094: iload 4
    //   1096: ifeq -729 -> 367
    //   1099: aload_0
    //   1100: getfield 324	c/t/m/g/dr:r	Lc/t/m/g/dn;
    //   1103: ifnull +152 -> 1255
    //   1106: iconst_1
    //   1107: istore_2
    //   1108: goto +902 -> 2010
    //   1111: iload_2
    //   1112: ifeq -745 -> 367
    //   1115: aload_0
    //   1116: getfield 324	c/t/m/g/dr:r	Lc/t/m/g/dn;
    //   1119: astore_1
    //   1120: aload_1
    //   1121: getfield 811	c/t/m/g/dn:a	Z
    //   1124: ifne -757 -> 367
    //   1127: aload_1
    //   1128: iconst_1
    //   1129: putfield 811	c/t/m/g/dn:a	Z
    //   1132: aload_1
    //   1133: new 598	android/os/HandlerThread
    //   1136: dup
    //   1137: ldc_w 813
    //   1140: invokespecial 650	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1143: putfield 815	c/t/m/g/dn:h	Landroid/os/HandlerThread;
    //   1146: aload_1
    //   1147: getfield 815	c/t/m/g/dn:h	Landroid/os/HandlerThread;
    //   1150: invokevirtual 656	android/os/HandlerThread:start	()V
    //   1153: aload_1
    //   1154: new 817	c/t/m/g/dn$a
    //   1157: dup
    //   1158: aload_1
    //   1159: aload_1
    //   1160: getfield 815	c/t/m/g/dn:h	Landroid/os/HandlerThread;
    //   1163: invokevirtual 599	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1166: iconst_0
    //   1167: invokespecial 820	c/t/m/g/dn$a:<init>	(Lc/t/m/g/dn;Landroid/os/Looper;B)V
    //   1170: putfield 823	c/t/m/g/dn:i	Lc/t/m/g/dn$a;
    //   1173: aload_1
    //   1174: getfield 823	c/t/m/g/dn:i	Lc/t/m/g/dn$a;
    //   1177: iconst_0
    //   1178: ldc2_w 824
    //   1181: invokevirtual 826	c/t/m/g/dn$a:sendEmptyMessageDelayed	(IJ)Z
    //   1184: pop
    //   1185: aload_1
    //   1186: getfield 827	c/t/m/g/dn:b	Lc/t/m/g/dg;
    //   1189: invokestatic 830	c/t/m/g/en:a	(Lc/t/m/g/dg;)Landroid/telephony/CellLocation;
    //   1192: astore 7
    //   1194: aload_1
    //   1195: aload 7
    //   1197: invokevirtual 833	c/t/m/g/dn:a	(Landroid/telephony/CellLocation;)Z
    //   1200: ifeq +35 -> 1235
    //   1203: aload_1
    //   1204: getfield 827	c/t/m/g/dn:b	Lc/t/m/g/dg;
    //   1207: aload 7
    //   1209: aconst_null
    //   1210: invokestatic 838	c/t/m/g/ea:a	(Lc/t/m/g/dg;Landroid/telephony/CellLocation;Landroid/telephony/SignalStrength;)Lc/t/m/g/ea;
    //   1213: astore 8
    //   1215: aload 8
    //   1217: ifnull +18 -> 1235
    //   1220: aload_1
    //   1221: aload 7
    //   1223: putfield 841	c/t/m/g/dn:d	Landroid/telephony/CellLocation;
    //   1226: aload_1
    //   1227: getfield 827	c/t/m/g/dn:b	Lc/t/m/g/dg;
    //   1230: aload 8
    //   1232: invokevirtual 843	c/t/m/g/dg:b	(Ljava/lang/Object;)V
    //   1235: aload_1
    //   1236: sipush 273
    //   1239: invokevirtual 844	c/t/m/g/dn:a	(I)V
    //   1242: ldc_w 846
    //   1245: iconst_4
    //   1246: ldc_w 726
    //   1249: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1252: goto -885 -> 367
    //   1255: iconst_0
    //   1256: istore_2
    //   1257: goto +753 -> 2010
    //   1260: iconst_0
    //   1261: istore_2
    //   1262: goto -151 -> 1111
    //   1265: iconst_0
    //   1266: istore_2
    //   1267: goto +724 -> 1991
    //   1270: iconst_0
    //   1271: istore_2
    //   1272: goto -888 -> 384
    //   1275: aload 8
    //   1277: iconst_1
    //   1278: putfield 686	c/t/m/g/dx:a	Z
    //   1281: iload_3
    //   1282: putstatic 848	c/t/m/g/dx:d	Z
    //   1285: aload 8
    //   1287: aload 5
    //   1289: putfield 850	c/t/m/g/dx:e	Landroid/os/Handler;
    //   1292: aload 8
    //   1294: getfield 850	c/t/m/g/dx:e	Landroid/os/Handler;
    //   1297: ifnonnull +106 -> 1403
    //   1300: aconst_null
    //   1301: astore_1
    //   1302: aload 8
    //   1304: getfield 853	c/t/m/g/dx:f	Lc/t/m/g/dx$a;
    //   1307: ifnull +15 -> 1322
    //   1310: aload 8
    //   1312: getfield 853	c/t/m/g/dx:f	Lc/t/m/g/dx$a;
    //   1315: invokevirtual 856	c/t/m/g/dx$a:getLooper	()Landroid/os/Looper;
    //   1318: aload_1
    //   1319: if_acmpeq +39 -> 1358
    //   1322: aload 8
    //   1324: getfield 853	c/t/m/g/dx:f	Lc/t/m/g/dx$a;
    //   1327: ifnull +12 -> 1339
    //   1330: aload 8
    //   1332: getfield 853	c/t/m/g/dx:f	Lc/t/m/g/dx$a;
    //   1335: aconst_null
    //   1336: invokevirtual 857	c/t/m/g/dx$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   1339: aload_1
    //   1340: ifnull +18 -> 1358
    //   1343: aload 8
    //   1345: new 855	c/t/m/g/dx$a
    //   1348: dup
    //   1349: aload 8
    //   1351: aload_1
    //   1352: invokespecial 860	c/t/m/g/dx$a:<init>	(Lc/t/m/g/dx;Landroid/os/Looper;)V
    //   1355: putfield 853	c/t/m/g/dx:f	Lc/t/m/g/dx$a;
    //   1358: aload 9
    //   1360: aload 8
    //   1362: getfield 863	c/t/m/g/dx:h	Ljava/lang/Runnable;
    //   1365: invokevirtual 864	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1368: pop
    //   1369: getstatic 848	c/t/m/g/dx:d	Z
    //   1372: ifne +9 -> 1381
    //   1375: aload 8
    //   1377: lconst_0
    //   1378: invokevirtual 867	c/t/m/g/dx:a	(J)V
    //   1381: ldc_w 869
    //   1384: iconst_4
    //   1385: ldc_w 726
    //   1388: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1391: aload 7
    //   1393: monitorexit
    //   1394: goto -959 -> 435
    //   1397: astore_1
    //   1398: aload 7
    //   1400: monitorexit
    //   1401: aload_1
    //   1402: athrow
    //   1403: aload 8
    //   1405: getfield 850	c/t/m/g/dx:e	Landroid/os/Handler;
    //   1408: invokevirtual 586	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1411: astore_1
    //   1412: goto -110 -> 1302
    //   1415: iconst_0
    //   1416: istore_2
    //   1417: goto -973 -> 444
    //   1420: iconst_0
    //   1421: istore_2
    //   1422: goto -957 -> 465
    //   1425: iconst_0
    //   1426: istore 4
    //   1428: goto -943 -> 485
    //   1431: aload 5
    //   1433: invokevirtual 586	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1436: astore_1
    //   1437: goto -913 -> 524
    //   1440: astore_1
    //   1441: iconst_1
    //   1442: putstatic 465	c/t/m/g/en:a	Z
    //   1445: ldc_w 724
    //   1448: ldc_w 871
    //   1451: aload_1
    //   1452: invokestatic 271	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1455: goto -863 -> 592
    //   1458: astore_1
    //   1459: ldc_w 724
    //   1462: bipush 6
    //   1464: aload_1
    //   1465: invokevirtual 274	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1468: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1471: goto -868 -> 603
    //   1474: aload 7
    //   1476: getfield 707	c/t/m/g/dq:o	Landroid/location/LocationManager;
    //   1479: ldc_w 873
    //   1482: ldc2_w 874
    //   1485: fconst_1
    //   1486: aload 7
    //   1488: invokevirtual 878	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   1491: goto -888 -> 603
    //   1494: astore_1
    //   1495: ldc_w 724
    //   1498: bipush 6
    //   1500: aload_1
    //   1501: invokevirtual 274	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1504: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1507: goto -904 -> 603
    //   1510: ldc_w 880
    //   1513: bipush 6
    //   1515: aload 7
    //   1517: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1520: aload 7
    //   1522: ldc_w 882
    //   1525: invokevirtual 886	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1528: invokestatic 889	c/t/m/g/j:b	([B)[B
    //   1531: astore 8
    //   1533: aload 8
    //   1535: iconst_2
    //   1536: invokestatic 892	com/tencent/tencentmap/lbssdk/service/e:o	([BI)I
    //   1539: pop
    //   1540: ldc_w 880
    //   1543: bipush 6
    //   1545: new 248	java/lang/StringBuilder
    //   1548: dup
    //   1549: ldc_w 894
    //   1552: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1555: aload 8
    //   1557: arraylength
    //   1558: invokevirtual 745	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1561: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1567: new 896	c/t/m/g/dv$a
    //   1570: dup
    //   1571: iconst_2
    //   1572: aload 8
    //   1574: ldc_w 898
    //   1577: aconst_null
    //   1578: invokespecial 901	c/t/m/g/dv$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
    //   1581: astore 8
    //   1583: aload 8
    //   1585: aload 7
    //   1587: putfield 902	c/t/m/g/dv$a:b	Ljava/lang/String;
    //   1590: aload_1
    //   1591: aload 8
    //   1593: invokevirtual 905	c/t/m/g/dv:a	(Lc/t/m/g/dv$a;)Z
    //   1596: pop
    //   1597: goto -935 -> 662
    //   1600: astore_1
    //   1601: ldc_w 880
    //   1604: ldc_w 405
    //   1607: aload_1
    //   1608: invokestatic 271	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1611: goto -949 -> 662
    //   1614: invokestatic 733	c/t/m/g/de:a	()Lc/t/m/g/de;
    //   1617: ldc 143
    //   1619: invokevirtual 908	c/t/m/g/de:d	(Ljava/lang/String;)Z
    //   1622: ifne +8 -> 1630
    //   1625: aload_0
    //   1626: aconst_null
    //   1627: putfield 320	c/t/m/g/dr:w	Lc/t/m/g/dl;
    //   1630: aload_0
    //   1631: getfield 320	c/t/m/g/dr:w	Lc/t/m/g/dl;
    //   1634: ifnull +240 -> 1874
    //   1637: iconst_1
    //   1638: istore_2
    //   1639: goto +385 -> 2024
    //   1642: iload_2
    //   1643: ifeq +65 -> 1708
    //   1646: aload_0
    //   1647: getfield 320	c/t/m/g/dr:w	Lc/t/m/g/dl;
    //   1650: astore 8
    //   1652: aload 8
    //   1654: getfield 910	c/t/m/g/dl:g	[B
    //   1657: astore 7
    //   1659: aload 7
    //   1661: monitorenter
    //   1662: aload 8
    //   1664: getfield 913	c/t/m/g/dl:b	Landroid/bluetooth/BluetoothManager;
    //   1667: ifnonnull +217 -> 1884
    //   1670: aconst_null
    //   1671: astore_1
    //   1672: aload 8
    //   1674: aload_1
    //   1675: putfield 916	c/t/m/g/dl:c	Landroid/bluetooth/BluetoothAdapter;
    //   1678: aload 8
    //   1680: getfield 916	c/t/m/g/dl:c	Landroid/bluetooth/BluetoothAdapter;
    //   1683: ifnull +16 -> 1699
    //   1686: aload 8
    //   1688: aload 8
    //   1690: getfield 916	c/t/m/g/dl:c	Landroid/bluetooth/BluetoothAdapter;
    //   1693: invokevirtual 922	android/bluetooth/BluetoothAdapter:getBluetoothLeScanner	()Landroid/bluetooth/le/BluetoothLeScanner;
    //   1696: putfield 925	c/t/m/g/dl:d	Landroid/bluetooth/le/BluetoothLeScanner;
    //   1699: aload 8
    //   1701: invokevirtual 928	c/t/m/g/dl:b	()I
    //   1704: pop
    //   1705: aload 7
    //   1707: monitorexit
    //   1708: aload 5
    //   1710: ifnull +328 -> 2038
    //   1713: iconst_1
    //   1714: istore_2
    //   1715: iload_2
    //   1716: ifeq +54 -> 1770
    //   1719: aload_0
    //   1720: getfield 293	c/t/m/g/dr:x	Lc/t/m/g/ds;
    //   1723: astore_1
    //   1724: aload_1
    //   1725: getfield 930	c/t/m/g/ds:b	Z
    //   1728: ifne +42 -> 1770
    //   1731: aload_1
    //   1732: iconst_1
    //   1733: putfield 930	c/t/m/g/ds:b	Z
    //   1736: aload 5
    //   1738: ifnull +32 -> 1770
    //   1741: new 932	android/content/IntentFilter
    //   1744: dup
    //   1745: ldc_w 934
    //   1748: invokespecial 935	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1751: astore 7
    //   1753: aload_1
    //   1754: getfield 937	c/t/m/g/ds:a	Lc/t/m/g/dg;
    //   1757: getfield 301	c/t/m/g/dg:a	Landroid/content/Context;
    //   1760: aload_1
    //   1761: aload 7
    //   1763: aconst_null
    //   1764: aload 5
    //   1766: invokevirtual 943	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   1769: pop
    //   1770: aload_0
    //   1771: getfield 308	c/t/m/g/dr:v	Lc/t/m/g/dp;
    //   1774: ifnull +151 -> 1925
    //   1777: iconst_1
    //   1778: istore_2
    //   1779: iload_2
    //   1780: ifeq -1118 -> 662
    //   1783: aload_0
    //   1784: getfield 187	c/t/m/g/dr:j	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1787: invokevirtual 946	com/tencent/map/geolocation/TencentLocationRequest:isAllowDirection	()Z
    //   1790: ifeq -1128 -> 662
    //   1793: aload 5
    //   1795: ifnull +135 -> 1930
    //   1798: iconst_1
    //   1799: istore_2
    //   1800: iload_2
    //   1801: ifeq -1139 -> 662
    //   1804: aload_0
    //   1805: getfield 308	c/t/m/g/dr:v	Lc/t/m/g/dp;
    //   1808: astore_1
    //   1809: aload_1
    //   1810: getfield 947	c/t/m/g/dp:b	Z
    //   1813: ifeq -1151 -> 662
    //   1816: aload_1
    //   1817: getfield 949	c/t/m/g/dp:c	Z
    //   1820: istore 4
    //   1822: iload 4
    //   1824: ifne -1162 -> 662
    //   1827: aload_1
    //   1828: getfield 952	c/t/m/g/dp:a	Landroid/hardware/SensorManager;
    //   1831: bipush 11
    //   1833: invokevirtual 958	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1836: astore 7
    //   1838: aload 7
    //   1840: ifnull -1178 -> 662
    //   1843: aload 5
    //   1845: ifnull -1183 -> 662
    //   1848: aload_1
    //   1849: getfield 952	c/t/m/g/dp:a	Landroid/hardware/SensorManager;
    //   1852: aload_1
    //   1853: aload 7
    //   1855: iconst_3
    //   1856: aload 5
    //   1858: invokevirtual 962	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;ILandroid/os/Handler;)Z
    //   1861: pop
    //   1862: aload_1
    //   1863: iconst_1
    //   1864: putfield 949	c/t/m/g/dp:c	Z
    //   1867: goto -1205 -> 662
    //   1870: astore_1
    //   1871: goto -1209 -> 662
    //   1874: iconst_0
    //   1875: istore_2
    //   1876: goto +148 -> 2024
    //   1879: iconst_0
    //   1880: istore_2
    //   1881: goto -239 -> 1642
    //   1884: aload 8
    //   1886: getfield 913	c/t/m/g/dl:b	Landroid/bluetooth/BluetoothManager;
    //   1889: invokevirtual 968	android/bluetooth/BluetoothManager:getAdapter	()Landroid/bluetooth/BluetoothAdapter;
    //   1892: astore_1
    //   1893: goto -221 -> 1672
    //   1896: astore_1
    //   1897: aload_1
    //   1898: invokevirtual 274	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1901: pop
    //   1902: goto -197 -> 1705
    //   1905: astore_1
    //   1906: aload 7
    //   1908: monitorexit
    //   1909: aload_1
    //   1910: athrow
    //   1911: astore_1
    //   1912: ldc_w 970
    //   1915: ldc_w 972
    //   1918: aload_1
    //   1919: invokestatic 271	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1922: goto -152 -> 1770
    //   1925: iconst_0
    //   1926: istore_2
    //   1927: goto -148 -> 1779
    //   1930: iconst_0
    //   1931: istore_2
    //   1932: goto -132 -> 1800
    //   1935: iconst_0
    //   1936: istore_2
    //   1937: goto -1268 -> 669
    //   1940: astore 5
    //   1942: aload_1
    //   1943: monitorexit
    //   1944: aload 5
    //   1946: athrow
    //   1947: aload 8
    //   1949: iconst_1
    //   1950: putfield 808	c/t/m/g/cs:a	Z
    //   1953: aload 8
    //   1955: aload_1
    //   1956: invokevirtual 974	c/t/m/g/cs:a	(Landroid/os/Looper;)V
    //   1959: aload 5
    //   1961: monitorexit
    //   1962: goto -931 -> 1031
    //   1965: astore_1
    //   1966: aload 5
    //   1968: monitorexit
    //   1969: aload_1
    //   1970: athrow
    //   1971: astore_1
    //   1972: aload 7
    //   1974: monitorexit
    //   1975: aload_1
    //   1976: athrow
    //   1977: iload_2
    //   1978: ifeq -1611 -> 367
    //   1981: aload 5
    //   1983: ifnull -919 -> 1064
    //   1986: iconst_1
    //   1987: istore_2
    //   1988: goto -1749 -> 239
    //   1991: iload_2
    //   1992: ifeq -1557 -> 435
    //   1995: aload 5
    //   1997: ifnull -727 -> 1270
    //   2000: iconst_1
    //   2001: istore_2
    //   2002: goto -1618 -> 384
    //   2005: iconst_0
    //   2006: istore_2
    //   2007: goto -1980 -> 27
    //   2010: iload_2
    //   2011: ifeq -1644 -> 367
    //   2014: aload 5
    //   2016: ifnull -756 -> 1260
    //   2019: iconst_1
    //   2020: istore_2
    //   2021: goto -910 -> 1111
    //   2024: iload_2
    //   2025: ifeq -317 -> 1708
    //   2028: aload 5
    //   2030: ifnull -151 -> 1879
    //   2033: iconst_1
    //   2034: istore_2
    //   2035: goto -393 -> 1642
    //   2038: iconst_0
    //   2039: istore_2
    //   2040: goto -325 -> 1715
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2043	0	this	dr
    //   0	2043	1	paramLooper	Looper
    //   26	2014	2	i1	int
    //   153	1129	3	bool1	boolean
    //   140	1683	4	bool2	boolean
    //   158	1699	5	localObject1	Object
    //   1940	89	5	localObject2	Object
    //   4	1046	6	arrayOfByte	byte[]
    //   304	728	7	localObject3	Object
    //   1069	1	7	localThrowable	Throwable
    //   1192	781	7	localObject4	Object
    //   406	1548	8	localObject5	Object
    //   412	947	9	localc	dr.c
    // Exception table:
    //   from	to	target	type
    //   9	18	1048	finally
    //   18	25	1048	finally
    //   31	42	1048	finally
    //   42	55	1048	finally
    //   55	83	1048	finally
    //   83	97	1048	finally
    //   97	126	1048	finally
    //   126	152	1048	finally
    //   154	215	1048	finally
    //   215	222	1048	finally
    //   227	234	1048	finally
    //   243	279	1048	finally
    //   279	306	1048	finally
    //   311	338	1048	finally
    //   338	354	1048	finally
    //   358	367	1048	finally
    //   372	379	1048	finally
    //   388	424	1048	finally
    //   435	442	1048	finally
    //   448	458	1048	finally
    //   469	482	1048	finally
    //   485	517	1048	finally
    //   524	544	1048	finally
    //   548	563	1048	finally
    //   567	592	1048	finally
    //   592	603	1048	finally
    //   603	622	1048	finally
    //   622	632	1048	finally
    //   636	650	1048	finally
    //   650	657	1048	finally
    //   673	682	1048	finally
    //   692	717	1048	finally
    //   717	724	1048	finally
    //   729	768	1048	finally
    //   782	802	1048	finally
    //   909	950	1048	finally
    //   1034	1037	1048	finally
    //   1038	1045	1048	finally
    //   1049	1052	1048	finally
    //   1071	1091	1048	finally
    //   1099	1106	1048	finally
    //   1115	1215	1048	finally
    //   1220	1235	1048	finally
    //   1235	1252	1048	finally
    //   1401	1403	1048	finally
    //   1431	1437	1048	finally
    //   1441	1455	1048	finally
    //   1459	1471	1048	finally
    //   1474	1491	1048	finally
    //   1495	1507	1048	finally
    //   1510	1597	1048	finally
    //   1601	1611	1048	finally
    //   1614	1630	1048	finally
    //   1630	1637	1048	finally
    //   1646	1662	1048	finally
    //   1719	1736	1048	finally
    //   1741	1770	1048	finally
    //   1770	1777	1048	finally
    //   1783	1793	1048	finally
    //   1804	1822	1048	finally
    //   1827	1838	1048	finally
    //   1848	1867	1048	finally
    //   1909	1911	1048	finally
    //   1912	1922	1048	finally
    //   1944	1947	1048	finally
    //   1975	1977	1048	finally
    //   311	338	1069	java/lang/Throwable
    //   424	435	1397	finally
    //   1275	1300	1397	finally
    //   1302	1322	1397	finally
    //   1322	1339	1397	finally
    //   1343	1358	1397	finally
    //   1358	1381	1397	finally
    //   1381	1394	1397	finally
    //   1398	1401	1397	finally
    //   1403	1412	1397	finally
    //   567	592	1440	java/lang/Throwable
    //   592	603	1458	java/lang/Throwable
    //   1474	1491	1494	java/lang/Throwable
    //   650	657	1600	java/lang/Throwable
    //   1510	1597	1600	java/lang/Throwable
    //   1827	1838	1870	java/lang/Throwable
    //   1848	1867	1870	java/lang/Throwable
    //   1662	1670	1896	java/lang/Throwable
    //   1672	1699	1896	java/lang/Throwable
    //   1699	1705	1896	java/lang/Throwable
    //   1884	1893	1896	java/lang/Throwable
    //   1662	1670	1905	finally
    //   1672	1699	1905	finally
    //   1699	1705	1905	finally
    //   1705	1708	1905	finally
    //   1884	1893	1905	finally
    //   1897	1902	1905	finally
    //   1906	1909	1905	finally
    //   1741	1770	1911	java/lang/Exception
    //   802	907	1940	finally
    //   907	909	1940	finally
    //   1942	1944	1940	finally
    //   1020	1031	1965	finally
    //   1947	1962	1965	finally
    //   1966	1969	1965	finally
    //   950	963	1971	finally
    //   971	1003	1971	finally
    //   1003	1020	1971	finally
    //   1031	1034	1971	finally
    //   1969	1971	1971	finally
    //   1972	1975	1971	finally
  }
  
  private co d()
  {
    try
    {
      Object localObject = this.E.b;
      localObject = new co(((dh)localObject).j, ((dh)localObject).d(), ((dh)localObject).f());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      j.a("TxLocationManagerImpl", "getAppInfo error.", localThrowable);
    }
    return new co("unknown", "unknown", "unknown");
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: putstatic 465	c/t/m/g/en:a	Z
    //   6: aload_0
    //   7: getfield 293	c/t/m/g/dr:x	Lc/t/m/g/ds;
    //   10: ifnull +855 -> 865
    //   13: iconst_1
    //   14: istore_1
    //   15: iload_1
    //   16: ifeq +36 -> 52
    //   19: aload_0
    //   20: getfield 293	c/t/m/g/dr:x	Lc/t/m/g/ds;
    //   23: astore 8
    //   25: aload 8
    //   27: getfield 930	c/t/m/g/ds:b	Z
    //   30: ifeq +22 -> 52
    //   33: aload 8
    //   35: iconst_0
    //   36: putfield 930	c/t/m/g/ds:b	Z
    //   39: aload 8
    //   41: getfield 937	c/t/m/g/ds:a	Lc/t/m/g/dg;
    //   44: getfield 301	c/t/m/g/dg:a	Landroid/content/Context;
    //   47: aload 8
    //   49: invokevirtual 1007	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   52: aload_0
    //   53: getfield 298	c/t/m/g/dr:y	Lc/t/m/g/dv;
    //   56: ifnull +814 -> 870
    //   59: iconst_1
    //   60: istore_1
    //   61: iload_1
    //   62: ifeq +161 -> 223
    //   65: aload_0
    //   66: getfield 298	c/t/m/g/dr:y	Lc/t/m/g/dv;
    //   69: astore 8
    //   71: aload 8
    //   73: getfield 613	c/t/m/g/dv:g	Z
    //   76: ifeq +147 -> 223
    //   79: aload 8
    //   81: iconst_0
    //   82: putfield 613	c/t/m/g/dv:g	Z
    //   85: aload 8
    //   87: getfield 1010	c/t/m/g/dv:a	Ljava/util/concurrent/LinkedBlockingQueue;
    //   90: invokevirtual 1013	java/util/concurrent/LinkedBlockingQueue:clear	()V
    //   93: aload 8
    //   95: getfield 1010	c/t/m/g/dv:a	Ljava/util/concurrent/LinkedBlockingQueue;
    //   98: getstatic 1016	c/t/m/g/dv$a:d	Lc/t/m/g/dv$a;
    //   101: invokevirtual 1020	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload 8
    //   107: aconst_null
    //   108: putfield 615	c/t/m/g/dv:i	Landroid/os/Handler;
    //   111: aload 8
    //   113: getfield 640	c/t/m/g/dv:f	J
    //   116: lconst_0
    //   117: lcmp
    //   118: ifeq +81 -> 199
    //   121: invokestatic 638	android/os/SystemClock:elapsedRealtime	()J
    //   124: lstore_3
    //   125: aload 8
    //   127: getfield 640	c/t/m/g/dv:f	J
    //   130: lstore 5
    //   132: ldc_w 880
    //   135: iconst_4
    //   136: getstatic 1026	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   139: ldc_w 1028
    //   142: iconst_4
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: lload_3
    //   149: lload 5
    //   151: lsub
    //   152: ldc2_w 708
    //   155: ldiv
    //   156: invokestatic 1034	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload 8
    //   164: getfield 1035	c/t/m/g/dv:d	J
    //   167: invokestatic 1034	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   170: aastore
    //   171: dup
    //   172: iconst_2
    //   173: aload 8
    //   175: getfield 1037	c/t/m/g/dv:e	J
    //   178: invokestatic 1034	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   181: aastore
    //   182: dup
    //   183: iconst_3
    //   184: aload 8
    //   186: getfield 1039	c/t/m/g/dv:c	J
    //   189: invokestatic 1034	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   192: aastore
    //   193: invokestatic 1043	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload 8
    //   201: lconst_0
    //   202: putfield 1039	c/t/m/g/dv:c	J
    //   205: aload 8
    //   207: lconst_0
    //   208: putfield 1035	c/t/m/g/dv:d	J
    //   211: aload 8
    //   213: lconst_0
    //   214: putfield 1037	c/t/m/g/dv:e	J
    //   217: aload 8
    //   219: lconst_0
    //   220: putfield 640	c/t/m/g/dv:f	J
    //   223: aload_0
    //   224: getfield 282	c/t/m/g/dr:z	Lc/t/m/g/dw;
    //   227: ifnull +648 -> 875
    //   230: iconst_1
    //   231: istore_1
    //   232: iload_1
    //   233: ifeq +10 -> 243
    //   236: aload_0
    //   237: getfield 282	c/t/m/g/dr:z	Lc/t/m/g/dw;
    //   240: invokevirtual 1044	c/t/m/g/dw:a	()V
    //   243: aload_0
    //   244: getfield 329	c/t/m/g/dr:c	Lc/t/m/g/dx;
    //   247: ifnull +633 -> 880
    //   250: iconst_1
    //   251: istore_1
    //   252: iload_1
    //   253: ifeq +30 -> 283
    //   256: aload_0
    //   257: getfield 329	c/t/m/g/dr:c	Lc/t/m/g/dx;
    //   260: astore 9
    //   262: aload 9
    //   264: getfield 685	c/t/m/g/dx:k	[B
    //   267: astore 8
    //   269: aload 8
    //   271: monitorenter
    //   272: aload 9
    //   274: getfield 686	c/t/m/g/dx:a	Z
    //   277: ifne +608 -> 885
    //   280: aload 8
    //   282: monitorexit
    //   283: aload_0
    //   284: getfield 322	c/t/m/g/dr:t	Z
    //   287: ifeq +744 -> 1031
    //   290: aload_0
    //   291: getfield 335	c/t/m/g/dr:s	Lc/t/m/g/dt;
    //   294: ifnull +724 -> 1018
    //   297: iconst_1
    //   298: istore_1
    //   299: iload_1
    //   300: ifeq +128 -> 428
    //   303: aload_0
    //   304: getfield 335	c/t/m/g/dr:s	Lc/t/m/g/dt;
    //   307: astore 9
    //   309: aload 9
    //   311: getfield 641	c/t/m/g/dt:a	Z
    //   314: ifeq +114 -> 428
    //   317: aload 9
    //   319: iconst_0
    //   320: putfield 641	c/t/m/g/dt:a	Z
    //   323: aload 9
    //   325: getfield 1047	c/t/m/g/dt:h	Lc/t/m/g/dt$b;
    //   328: iconst_0
    //   329: invokevirtual 1050	c/t/m/g/dt$b:a	(I)V
    //   332: aload 9
    //   334: getfield 1051	c/t/m/g/dt:b	[B
    //   337: astore 8
    //   339: aload 8
    //   341: monitorenter
    //   342: aload 9
    //   344: getfield 664	c/t/m/g/dt:g	Lc/t/m/g/dt$a;
    //   347: ifnull +27 -> 374
    //   350: aload 9
    //   352: getfield 664	c/t/m/g/dt:g	Lc/t/m/g/dt$a;
    //   355: iconst_1
    //   356: putfield 1052	c/t/m/g/dt$a:a	Z
    //   359: aload 9
    //   361: getfield 664	c/t/m/g/dt:g	Lc/t/m/g/dt$a;
    //   364: aconst_null
    //   365: invokevirtual 1053	c/t/m/g/dt$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   368: aload 9
    //   370: aconst_null
    //   371: putfield 664	c/t/m/g/dt:g	Lc/t/m/g/dt$a;
    //   374: aload 9
    //   376: getfield 653	c/t/m/g/dt:f	Landroid/os/HandlerThread;
    //   379: ifnull +18 -> 397
    //   382: aload 9
    //   384: getfield 653	c/t/m/g/dt:f	Landroid/os/HandlerThread;
    //   387: invokevirtual 1056	android/os/HandlerThread:quit	()Z
    //   390: pop
    //   391: aload 9
    //   393: aconst_null
    //   394: putfield 653	c/t/m/g/dt:f	Landroid/os/HandlerThread;
    //   397: aload 9
    //   399: aconst_null
    //   400: putfield 1059	c/t/m/g/dt:e	Landroid/telephony/ServiceState;
    //   403: aload 9
    //   405: aconst_null
    //   406: putfield 644	c/t/m/g/dt:j	Ljava/util/List;
    //   409: aload 9
    //   411: aconst_null
    //   412: putfield 1047	c/t/m/g/dt:h	Lc/t/m/g/dt$b;
    //   415: aload 8
    //   417: monitorexit
    //   418: ldc_w 1061
    //   421: iconst_4
    //   422: ldc_w 1063
    //   425: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_0
    //   429: getfield 340	c/t/m/g/dr:u	Lc/t/m/g/dq;
    //   432: ifnull +756 -> 1188
    //   435: iconst_1
    //   436: istore_1
    //   437: iload_1
    //   438: ifeq +138 -> 576
    //   441: aload_0
    //   442: getfield 340	c/t/m/g/dr:u	Lc/t/m/g/dq;
    //   445: astore 8
    //   447: aload 8
    //   449: getfield 693	c/t/m/g/dq:k	Z
    //   452: ifeq +124 -> 576
    //   455: aload 8
    //   457: iconst_0
    //   458: putfield 693	c/t/m/g/dq:k	Z
    //   461: aload 8
    //   463: sipush 1024
    //   466: putfield 720	c/t/m/g/dq:b	I
    //   469: aload 8
    //   471: iconst_0
    //   472: putfield 1065	c/t/m/g/dq:e	Z
    //   475: aload 8
    //   477: iconst_0
    //   478: putfield 1067	c/t/m/g/dq:f	Z
    //   481: aload 8
    //   483: iconst_0
    //   484: putfield 1068	c/t/m/g/dq:i	I
    //   487: aload 8
    //   489: iconst_0
    //   490: putfield 1070	c/t/m/g/dq:h	I
    //   493: aload 8
    //   495: iconst_0
    //   496: putfield 1072	c/t/m/g/dq:g	I
    //   499: aload 8
    //   501: getfield 1075	c/t/m/g/dq:j	Ljava/util/ArrayList;
    //   504: invokevirtual 1076	java/util/ArrayList:clear	()V
    //   507: aload 8
    //   509: ldc2_w 1077
    //   512: putfield 1080	c/t/m/g/dq:m	J
    //   515: aload 8
    //   517: iconst_0
    //   518: putfield 691	c/t/m/g/dq:l	Z
    //   521: aload 8
    //   523: getfield 1083	c/t/m/g/dq:p	[D
    //   526: dconst_0
    //   527: invokestatic 1089	java/util/Arrays:fill	([DD)V
    //   530: aload 8
    //   532: getfield 1090	c/t/m/g/dq:a	Lc/t/m/g/dg;
    //   535: getfield 1092	c/t/m/g/dg:g	Landroid/location/LocationManager;
    //   538: astore 9
    //   540: aload 9
    //   542: aload 8
    //   544: invokevirtual 1096	android/location/LocationManager:removeGpsStatusListener	(Landroid/location/GpsStatus$Listener;)V
    //   547: aload 9
    //   549: aload 8
    //   551: invokevirtual 1100	android/location/LocationManager:removeUpdates	(Landroid/location/LocationListener;)V
    //   554: aload 8
    //   556: aconst_null
    //   557: putfield 698	c/t/m/g/dq:n	Lc/t/m/g/dq$a;
    //   560: aload 8
    //   562: aconst_null
    //   563: putfield 1103	c/t/m/g/dq:c	Landroid/location/Location;
    //   566: ldc_w 724
    //   569: iconst_4
    //   570: ldc_w 1063
    //   573: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: aload_0
    //   577: getfield 308	c/t/m/g/dr:v	Lc/t/m/g/dp;
    //   580: ifnull +613 -> 1193
    //   583: iconst_1
    //   584: istore_1
    //   585: iload_1
    //   586: ifeq +59 -> 645
    //   589: aload_0
    //   590: getfield 187	c/t/m/g/dr:j	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   593: invokevirtual 946	com/tencent/map/geolocation/TencentLocationRequest:isAllowDirection	()Z
    //   596: ifeq +49 -> 645
    //   599: aload_0
    //   600: getfield 308	c/t/m/g/dr:v	Lc/t/m/g/dp;
    //   603: astore 8
    //   605: aload 8
    //   607: getfield 947	c/t/m/g/dp:b	Z
    //   610: ifeq +35 -> 645
    //   613: aload 8
    //   615: getfield 949	c/t/m/g/dp:c	Z
    //   618: ifeq +27 -> 645
    //   621: aload 8
    //   623: iconst_0
    //   624: putfield 949	c/t/m/g/dp:c	Z
    //   627: aload 8
    //   629: ldc2_w 1104
    //   632: putfield 1107	c/t/m/g/dp:d	D
    //   635: aload 8
    //   637: getfield 952	c/t/m/g/dp:a	Landroid/hardware/SensorManager;
    //   640: aload 8
    //   642: invokevirtual 1111	android/hardware/SensorManager:unregisterListener	(Landroid/hardware/SensorEventListener;)V
    //   645: aload_0
    //   646: getfield 320	c/t/m/g/dr:w	Lc/t/m/g/dl;
    //   649: ifnull +549 -> 1198
    //   652: iload_2
    //   653: istore_1
    //   654: iload_1
    //   655: ifeq +64 -> 719
    //   658: aload_0
    //   659: getfield 320	c/t/m/g/dr:w	Lc/t/m/g/dl;
    //   662: astore 9
    //   664: aload 9
    //   666: getfield 910	c/t/m/g/dl:g	[B
    //   669: astore 8
    //   671: aload 8
    //   673: monitorenter
    //   674: aload 9
    //   676: getfield 1112	c/t/m/g/dl:f	Z
    //   679: istore 7
    //   681: iload 7
    //   683: ifeq +33 -> 716
    //   686: aload 9
    //   688: getfield 910	c/t/m/g/dl:g	[B
    //   691: astore 10
    //   693: aload 10
    //   695: monitorenter
    //   696: aload 9
    //   698: getfield 1113	c/t/m/g/dl:a	Landroid/content/Context;
    //   701: invokevirtual 1117	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   704: ldc_w 1119
    //   707: invokevirtual 1124	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   710: ifne +493 -> 1203
    //   713: aload 10
    //   715: monitorexit
    //   716: aload 8
    //   718: monitorexit
    //   719: aload_0
    //   720: getfield 195	c/t/m/g/dr:P	Z
    //   723: ifeq +14 -> 737
    //   726: invokestatic 352	c/t/m/g/dd:a	()Lc/t/m/g/dd;
    //   729: invokevirtual 1125	c/t/m/g/dd:c	()V
    //   732: aload_0
    //   733: iconst_0
    //   734: putfield 195	c/t/m/g/dr:P	Z
    //   737: aload_0
    //   738: getfield 737	c/t/m/g/dr:Q	Lc/t/m/g/cn;
    //   741: ifnull +123 -> 864
    //   744: aload_0
    //   745: getfield 737	c/t/m/g/dr:Q	Lc/t/m/g/cn;
    //   748: astore 9
    //   750: aload 9
    //   752: getfield 757	c/t/m/g/cn:a	[B
    //   755: astore 8
    //   757: aload 8
    //   759: monitorenter
    //   760: aload 9
    //   762: getfield 760	c/t/m/g/cn:c	Lc/t/m/g/ct;
    //   765: ifnull +42 -> 807
    //   768: aload 9
    //   770: getfield 760	c/t/m/g/cn:c	Lc/t/m/g/ct;
    //   773: invokevirtual 1127	c/t/m/g/ct:a	()Z
    //   776: ifeq +31 -> 807
    //   779: aload 9
    //   781: getfield 760	c/t/m/g/cn:c	Lc/t/m/g/ct;
    //   784: astore 11
    //   786: aload 11
    //   788: getfield 807	c/t/m/g/cs:b	[B
    //   791: astore 10
    //   793: aload 10
    //   795: monitorenter
    //   796: aload 11
    //   798: getfield 808	c/t/m/g/cs:a	Z
    //   801: ifne +490 -> 1291
    //   804: aload 10
    //   806: monitorexit
    //   807: aload 9
    //   809: getfield 803	c/t/m/g/cn:d	Landroid/os/HandlerThread;
    //   812: ifnull +44 -> 856
    //   815: aload 9
    //   817: getfield 803	c/t/m/g/cn:d	Landroid/os/HandlerThread;
    //   820: astore 10
    //   822: new 585	android/os/Handler
    //   825: dup
    //   826: aload 10
    //   828: invokevirtual 599	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   831: invokespecial 591	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   834: new 1129	c/t/m/g/cn$1
    //   837: dup
    //   838: aload 10
    //   840: invokespecial 1132	c/t/m/g/cn$1:<init>	(Landroid/os/HandlerThread;)V
    //   843: ldc2_w 1133
    //   846: invokevirtual 1138	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   849: pop
    //   850: aload 9
    //   852: aconst_null
    //   853: putfield 803	c/t/m/g/cn:d	Landroid/os/HandlerThread;
    //   856: aload 9
    //   858: invokevirtual 799	c/t/m/g/cn:c	()V
    //   861: aload 8
    //   863: monitorexit
    //   864: return
    //   865: iconst_0
    //   866: istore_1
    //   867: goto -852 -> 15
    //   870: iconst_0
    //   871: istore_1
    //   872: goto -811 -> 61
    //   875: iconst_0
    //   876: istore_1
    //   877: goto -645 -> 232
    //   880: iconst_0
    //   881: istore_1
    //   882: goto -630 -> 252
    //   885: aload 9
    //   887: iconst_0
    //   888: putfield 686	c/t/m/g/dx:a	Z
    //   891: aload 9
    //   893: getfield 1139	c/t/m/g/dx:b	Lc/t/m/g/dg;
    //   896: getfield 301	c/t/m/g/dg:a	Landroid/content/Context;
    //   899: aload 9
    //   901: invokevirtual 1007	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   904: ldc_w 869
    //   907: bipush 6
    //   909: ldc_w 1141
    //   912: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   915: aload 9
    //   917: aconst_null
    //   918: putfield 1144	c/t/m/g/dx:c	Ljava/util/HashSet;
    //   921: aload 9
    //   923: getfield 1146	c/t/m/g/dx:g	Ljava/util/List;
    //   926: ifnull +13 -> 939
    //   929: aload 9
    //   931: getfield 1146	c/t/m/g/dx:g	Ljava/util/List;
    //   934: invokeinterface 1149 1 0
    //   939: aload 9
    //   941: getfield 1144	c/t/m/g/dx:c	Ljava/util/HashSet;
    //   944: ifnull +11 -> 955
    //   947: aload 9
    //   949: getfield 1144	c/t/m/g/dx:c	Ljava/util/HashSet;
    //   952: invokevirtual 1152	java/util/HashSet:clear	()V
    //   955: aload 9
    //   957: getfield 853	c/t/m/g/dx:f	Lc/t/m/g/dx$a;
    //   960: ifnull +18 -> 978
    //   963: aload 9
    //   965: getfield 853	c/t/m/g/dx:f	Lc/t/m/g/dx$a;
    //   968: aconst_null
    //   969: invokevirtual 857	c/t/m/g/dx$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   972: aload 9
    //   974: aconst_null
    //   975: putfield 853	c/t/m/g/dx:f	Lc/t/m/g/dx$a;
    //   978: ldc_w 869
    //   981: iconst_4
    //   982: ldc_w 1063
    //   985: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   988: aload 8
    //   990: monitorexit
    //   991: goto -708 -> 283
    //   994: astore 9
    //   996: aload 8
    //   998: monitorexit
    //   999: aload 9
    //   1001: athrow
    //   1002: astore 10
    //   1004: ldc_w 869
    //   1007: bipush 6
    //   1009: ldc_w 1154
    //   1012: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1015: goto -100 -> 915
    //   1018: iconst_0
    //   1019: istore_1
    //   1020: goto -721 -> 299
    //   1023: astore 9
    //   1025: aload 8
    //   1027: monitorexit
    //   1028: aload 9
    //   1030: athrow
    //   1031: aload_0
    //   1032: getfield 324	c/t/m/g/dr:r	Lc/t/m/g/dn;
    //   1035: ifnull +140 -> 1175
    //   1038: iconst_1
    //   1039: istore_1
    //   1040: iload_1
    //   1041: ifeq -613 -> 428
    //   1044: aload_0
    //   1045: getfield 324	c/t/m/g/dr:r	Lc/t/m/g/dn;
    //   1048: astore 9
    //   1050: aload 9
    //   1052: getfield 811	c/t/m/g/dn:a	Z
    //   1055: ifeq -627 -> 428
    //   1058: aload 9
    //   1060: iconst_0
    //   1061: putfield 811	c/t/m/g/dn:a	Z
    //   1064: aload 9
    //   1066: iconst_0
    //   1067: invokevirtual 844	c/t/m/g/dn:a	(I)V
    //   1070: aload 9
    //   1072: getfield 1156	c/t/m/g/dn:c	[B
    //   1075: astore 8
    //   1077: aload 8
    //   1079: monitorenter
    //   1080: aload 9
    //   1082: getfield 823	c/t/m/g/dn:i	Lc/t/m/g/dn$a;
    //   1085: ifnull +27 -> 1112
    //   1088: aload 9
    //   1090: getfield 823	c/t/m/g/dn:i	Lc/t/m/g/dn$a;
    //   1093: iconst_1
    //   1094: putfield 1157	c/t/m/g/dn$a:a	Z
    //   1097: aload 9
    //   1099: getfield 823	c/t/m/g/dn:i	Lc/t/m/g/dn$a;
    //   1102: aconst_null
    //   1103: invokevirtual 1158	c/t/m/g/dn$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   1106: aload 9
    //   1108: aconst_null
    //   1109: putfield 823	c/t/m/g/dn:i	Lc/t/m/g/dn$a;
    //   1112: aload 9
    //   1114: getfield 815	c/t/m/g/dn:h	Landroid/os/HandlerThread;
    //   1117: ifnull +18 -> 1135
    //   1120: aload 9
    //   1122: getfield 815	c/t/m/g/dn:h	Landroid/os/HandlerThread;
    //   1125: invokevirtual 1056	android/os/HandlerThread:quit	()Z
    //   1128: pop
    //   1129: aload 9
    //   1131: aconst_null
    //   1132: putfield 815	c/t/m/g/dn:h	Landroid/os/HandlerThread;
    //   1135: aload 9
    //   1137: aconst_null
    //   1138: putfield 841	c/t/m/g/dn:d	Landroid/telephony/CellLocation;
    //   1141: aload 9
    //   1143: aconst_null
    //   1144: putfield 1161	c/t/m/g/dn:e	Landroid/telephony/SignalStrength;
    //   1147: aload 9
    //   1149: aconst_null
    //   1150: putfield 1163	c/t/m/g/dn:f	Landroid/telephony/ServiceState;
    //   1153: aload 9
    //   1155: lconst_0
    //   1156: putfield 1164	c/t/m/g/dn:g	J
    //   1159: aload 8
    //   1161: monitorexit
    //   1162: ldc_w 846
    //   1165: iconst_4
    //   1166: ldc_w 1063
    //   1169: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1172: goto -744 -> 428
    //   1175: iconst_0
    //   1176: istore_1
    //   1177: goto -137 -> 1040
    //   1180: astore 9
    //   1182: aload 8
    //   1184: monitorexit
    //   1185: aload 9
    //   1187: athrow
    //   1188: iconst_0
    //   1189: istore_1
    //   1190: goto -753 -> 437
    //   1193: iconst_0
    //   1194: istore_1
    //   1195: goto -610 -> 585
    //   1198: iconst_0
    //   1199: istore_1
    //   1200: goto -546 -> 654
    //   1203: aload 9
    //   1205: getfield 925	c/t/m/g/dl:d	Landroid/bluetooth/le/BluetoothLeScanner;
    //   1208: ifnull +13 -> 1221
    //   1211: aload 9
    //   1213: getfield 925	c/t/m/g/dl:d	Landroid/bluetooth/le/BluetoothLeScanner;
    //   1216: aload 9
    //   1218: invokevirtual 1170	android/bluetooth/le/BluetoothLeScanner:stopScan	(Landroid/bluetooth/le/ScanCallback;)V
    //   1221: aload 9
    //   1223: aconst_null
    //   1224: putfield 916	c/t/m/g/dl:c	Landroid/bluetooth/BluetoothAdapter;
    //   1227: aload 10
    //   1229: monitorexit
    //   1230: aload 9
    //   1232: iconst_0
    //   1233: putfield 1112	c/t/m/g/dl:f	Z
    //   1236: aload 9
    //   1238: getfield 1172	c/t/m/g/dl:e	Ljava/util/List;
    //   1241: astore 10
    //   1243: aload 10
    //   1245: monitorenter
    //   1246: aload 9
    //   1248: getfield 1172	c/t/m/g/dl:e	Ljava/util/List;
    //   1251: invokeinterface 1149 1 0
    //   1256: aload 10
    //   1258: monitorexit
    //   1259: goto -543 -> 716
    //   1262: astore 9
    //   1264: aload 10
    //   1266: monitorexit
    //   1267: aload 9
    //   1269: athrow
    //   1270: astore 9
    //   1272: goto -556 -> 716
    //   1275: astore 9
    //   1277: aload 10
    //   1279: monitorexit
    //   1280: aload 9
    //   1282: athrow
    //   1283: astore 9
    //   1285: aload 8
    //   1287: monitorexit
    //   1288: aload 9
    //   1290: athrow
    //   1291: aload 11
    //   1293: iconst_0
    //   1294: putfield 808	c/t/m/g/cs:a	Z
    //   1297: aload 11
    //   1299: invokevirtual 1174	c/t/m/g/cs:b	()V
    //   1302: aload 10
    //   1304: monitorexit
    //   1305: goto -498 -> 807
    //   1308: astore 9
    //   1310: aload 10
    //   1312: monitorexit
    //   1313: aload 9
    //   1315: athrow
    //   1316: astore 9
    //   1318: aload 8
    //   1320: monitorexit
    //   1321: aload 9
    //   1323: athrow
    //   1324: astore 10
    //   1326: goto -779 -> 547
    //   1329: astore 9
    //   1331: goto -777 -> 554
    //   1334: astore 8
    //   1336: goto -1284 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1339	0	this	dr
    //   14	1186	1	i1	int
    //   1	652	2	i2	int
    //   124	25	3	l1	long
    //   130	20	5	l2	long
    //   679	3	7	bool	boolean
    //   1334	1	8	localException1	Exception
    //   260	713	9	localObject2	Object
    //   994	6	9	localObject3	Object
    //   1023	6	9	localObject4	Object
    //   1048	106	9	localdn	dn
    //   1180	67	9	localScanCallback	android.bluetooth.le.ScanCallback
    //   1262	6	9	localObject5	Object
    //   1270	1	9	localThrowable	Throwable
    //   1275	6	9	localObject6	Object
    //   1283	6	9	localObject7	Object
    //   1308	6	9	localObject8	Object
    //   1316	6	9	localObject9	Object
    //   1329	1	9	localException2	Exception
    //   1002	226	10	localException3	Exception
    //   1324	1	10	localException4	Exception
    //   784	514	11	localct	ct
    // Exception table:
    //   from	to	target	type
    //   272	283	994	finally
    //   885	891	994	finally
    //   891	915	994	finally
    //   915	939	994	finally
    //   939	955	994	finally
    //   955	978	994	finally
    //   978	991	994	finally
    //   996	999	994	finally
    //   1004	1015	994	finally
    //   891	915	1002	java/lang/Exception
    //   342	374	1023	finally
    //   374	397	1023	finally
    //   397	418	1023	finally
    //   1025	1028	1023	finally
    //   1080	1112	1180	finally
    //   1112	1135	1180	finally
    //   1135	1162	1180	finally
    //   1182	1185	1180	finally
    //   1246	1259	1262	finally
    //   1264	1267	1262	finally
    //   686	696	1270	java/lang/Throwable
    //   1230	1246	1270	java/lang/Throwable
    //   1267	1270	1270	java/lang/Throwable
    //   1280	1283	1270	java/lang/Throwable
    //   696	716	1275	finally
    //   1203	1221	1275	finally
    //   1221	1230	1275	finally
    //   1277	1280	1275	finally
    //   674	681	1283	finally
    //   686	696	1283	finally
    //   716	719	1283	finally
    //   1230	1246	1283	finally
    //   1267	1270	1283	finally
    //   1280	1283	1283	finally
    //   1285	1288	1283	finally
    //   796	807	1308	finally
    //   1291	1305	1308	finally
    //   1310	1313	1308	finally
    //   760	796	1316	finally
    //   807	856	1316	finally
    //   856	864	1316	finally
    //   1313	1316	1316	finally
    //   1318	1321	1316	finally
    //   540	547	1324	java/lang/Exception
    //   547	554	1329	java/lang/Exception
    //   39	52	1334	java/lang/Exception
  }
  
  private void f()
  {
    this.i = 0;
    this.B = null;
    this.A = null;
    this.D = null;
    this.I = 0L;
    ec.a = 0;
    if (Build.VERSION.SDK_INT >= 12) {
      this.E.a("cell").a();
    }
    if (this.e != null)
    {
      this.e.o = "";
      this.e.n = 0L;
      this.e.m = 0L;
      this.e.l = 0L;
    }
  }
  
  private boolean g()
  {
    return this.l == 404;
  }
  
  private boolean h()
  {
    boolean bool = true;
    int i1;
    if (this.u != null) {
      if (this.u.b())
      {
        dq localdq = this.u;
        if (System.currentTimeMillis() - localdq.d < 20000L)
        {
          i1 = 1;
          if (i1 == 0) {
            break label66;
          }
        }
      }
    }
    for (;;)
    {
      if (!bool) {
        j.a("TxLocationManagerImpl", 6, "isGpsValid: provider=false");
      }
      return bool;
      i1 = 0;
      break;
      label66:
      bool = false;
      continue;
      bool = false;
    }
  }
  
  @Nullable
  private dq i()
  {
    if (this.E.g != null) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      j.a("TxLocationManagerImpl", 6, "createGpsProvider: failed");
      return null;
    }
    return new dq(this.E);
  }
  
  @Nullable
  private dx j()
  {
    if (this.E.f != null) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      j.a("TxLocationManagerImpl", 6, "createWifiProvider: failed");
      return null;
    }
    return new dx(this.E);
  }
  
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (this.d != 0) {
      return this.d;
    }
    f();
    if (this.e != null) {
      this.e.l = System.currentTimeMillis();
    }
    this.l = 404;
    this.k = null;
    synchronized (this.J)
    {
      this.F = paramTencentLocationListener;
      if ((this.e != null) && ("0123456789ABCDEF".equals(this.e.a()))) {
        this.E.a();
      }
      this.e.f = paramTencentLocationRequest.getQQ();
      this.e.g = paramTencentLocationRequest.getSmallAppKey();
      TencentLocationRequest.copy(this.j, paramTencentLocationRequest);
      if (TextUtils.isEmpty(j.c(this.e.d))) {
        this.e.d = paramTencentLocationRequest.getPhoneNumber();
      }
      paramTencentLocationListener = this.e;
      long l1 = paramTencentLocationRequest.getInterval();
      paramTencentLocationListener.k = Math.max(de.a().c("min_wifi_scan_interval"), l1);
      this.h = paramTencentLocationRequest.getInterval();
      this.m = dr.b.a;
      a(paramLooper);
      return 0;
    }
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 197	c/t/m/g/dr:R	[B
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokespecial 593	c/t/m/g/dr:e	()V
    //   11: aload_0
    //   12: getfield 483	c/t/m/g/dr:o	Lc/t/m/g/dr$a;
    //   15: ifnull +15 -> 30
    //   18: aload_0
    //   19: getfield 483	c/t/m/g/dr:o	Lc/t/m/g/dr$a;
    //   22: invokevirtual 810	c/t/m/g/dr$a:a	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 483	c/t/m/g/dr:o	Lc/t/m/g/dr$a;
    //   30: aload_1
    //   31: monitorexit
    //   32: aload_0
    //   33: getfield 179	c/t/m/g/dr:J	Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: monitorenter
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 525	c/t/m/g/dr:F	Lcom/tencent/map/geolocation/TencentLocationListener;
    //   44: aload_0
    //   45: getfield 287	c/t/m/g/dr:f	Ljava/util/List;
    //   48: ifnull +12 -> 60
    //   51: aload_0
    //   52: getfield 287	c/t/m/g/dr:f	Ljava/util/List;
    //   55: invokeinterface 1149 1 0
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_0
    //   63: invokespecial 1269	c/t/m/g/dr:f	()V
    //   66: invokestatic 733	c/t/m/g/de:a	()Lc/t/m/g/de;
    //   69: ldc 127
    //   71: invokevirtual 908	c/t/m/g/de:d	(Ljava/lang/String;)Z
    //   74: ifne +44 -> 118
    //   77: ldc 246
    //   79: bipush 6
    //   81: ldc_w 1307
    //   84: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: getstatic 191	c/t/m/g/dr$b:d	Lc/t/m/g/dr$b;
    //   91: putfield 193	c/t/m/g/dr:m	Lc/t/m/g/dr$b;
    //   94: return
    //   95: astore_2
    //   96: ldc 246
    //   98: ldc_w 1309
    //   101: aload_2
    //   102: invokestatic 271	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: goto -75 -> 30
    //   108: astore_2
    //   109: aload_1
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    //   113: astore_2
    //   114: aload_1
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: aload_0
    //   119: getfield 193	c/t/m/g/dr:m	Lc/t/m/g/dr$b;
    //   122: getstatic 1305	c/t/m/g/dr$b:a	Lc/t/m/g/dr$b;
    //   125: if_acmpne +75 -> 200
    //   128: aload_0
    //   129: getfield 201	c/t/m/g/dr:E	Lc/t/m/g/dg;
    //   132: invokestatic 1312	c/t/m/g/es:c	(Lc/t/m/g/dg;)Ljava/lang/String;
    //   135: ldc_w 1314
    //   138: invokevirtual 1317	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   141: ifeq +59 -> 200
    //   144: new 585	android/os/Handler
    //   147: dup
    //   148: invokestatic 596	c/t/m/g/dg:d	()Landroid/os/HandlerThread;
    //   151: invokevirtual 599	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   154: invokespecial 591	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   157: new 8	c/t/m/g/dr$2
    //   160: dup
    //   161: aload_0
    //   162: invokespecial 1320	c/t/m/g/dr$2:<init>	(Lc/t/m/g/dr;)V
    //   165: ldc2_w 1321
    //   168: invokevirtual 1138	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   171: pop
    //   172: aload_0
    //   173: invokestatic 1203	java/lang/System:currentTimeMillis	()J
    //   176: putfield 372	c/t/m/g/dr:N	J
    //   179: aload_0
    //   180: getstatic 191	c/t/m/g/dr$b:d	Lc/t/m/g/dr$b;
    //   183: putfield 193	c/t/m/g/dr:m	Lc/t/m/g/dr$b;
    //   186: return
    //   187: astore_1
    //   188: ldc 246
    //   190: ldc_w 1324
    //   193: aload_1
    //   194: invokestatic 271	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: goto -18 -> 179
    //   200: ldc 246
    //   202: bipush 6
    //   204: new 248	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 1326
    //   211: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield 193	c/t/m/g/dr:m	Lc/t/m/g/dr$b;
    //   218: invokevirtual 557	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 264	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: goto -48 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	dr
    //   187	7	1	localThrowable1	Throwable
    //   95	7	2	localThrowable2	Throwable
    //   108	4	2	localObject2	Object
    //   113	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	30	95	java/lang/Throwable
    //   7	11	108	finally
    //   11	30	108	finally
    //   30	32	108	finally
    //   96	105	108	finally
    //   109	111	108	finally
    //   39	60	113	finally
    //   60	62	113	finally
    //   114	116	113	finally
    //   144	179	187	java/lang/Throwable
  }
  
  public final void a(int paramInt)
  {
    if (this.o != null)
    {
      this.o.sendEmptyMessage(paramInt);
      return;
    }
    j.a("TxLocationManagerImpl", 6, "mHandler is null");
  }
  
  public final void a(em paramem)
  {
    if (paramem != null) {
      if ((this.v != null) && (this.j.isAllowDirection())) {
        paramem.getExtra().putDouble("direction", this.v.a());
      }
    }
    try
    {
      paramem.getExtra().putAll(this.j.getExtras());
      return;
    }
    catch (Exception paramem) {}
  }
  
  public final void a(em paramem, int paramInt1, int paramInt2)
  {
    if ((paramem == null) || (this.p == null)) {
      return;
    }
    Message localMessage = this.p.obtainMessage(paramInt2);
    Bundle localBundle2 = localMessage.getData();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.clear();
    localBundle1.putInt("error_code", paramInt1);
    localBundle1.putParcelable("tx_location", paramem);
    localMessage.setData(localBundle1);
    localMessage.sendToTarget();
  }
  
  public final void onCellInfoEvent(ea arg1)
  {
    this.A = ???;
    long l1 = Math.max(this.j.getInterval(), 20000L);
    Object localObject1 = Collections.emptyList();
    int i1;
    if (this.c != null)
    {
      if (!this.c.a()) {
        break label346;
      }
      i1 = 0;
    }
    for (;;)
    {
      if (i1 != 0) {
        this.B = null;
      }
      Object localObject3;
      if ((i1 != 1) && (this.E != null))
      {
        localObject3 = es.c(this.E.f);
        localObject1 = localObject3;
        if (((List)localObject3).size() == 0)
        {
          j.a("TxLocationManagerImpl", 4, "Wi-Fi List is 0, status:0");
          localObject1 = localObject3;
        }
      }
      for (;;)
      {
        if ((i1 == 1) || (((List)localObject1).size() == 0) || (this.I == -1L) || ((this.I > 0L) && (System.currentTimeMillis() - this.I > l1))) {
          a(3999);
        }
        j.a("TxLocationManagerImpl", 6, "cell change run prepare json,because status:" + i1 + ",mLastWF:" + this.I + ",current:" + System.currentTimeMillis());
        if (this.Q == null) {
          break;
        }
        localObject1 = new cp(???.b, ???.c, ???.d, ???.e, ???.f);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        cn localcn = this.Q;
        synchronized (localcn.a)
        {
          if (!localcn.b()) {
            return;
          }
          localcn.g = ((List)localObject3);
          localcn.i = System.currentTimeMillis();
          if (!((cp)localObject1).equals(localcn.h))
          {
            localcn.h = ((cp)localObject1);
            localcn.a();
          }
          return;
        }
      }
      i1 = 1;
      continue;
      return;
      label346:
      i1 = 1;
    }
  }
  
  public final void onGpsInfoEvent(eb arg1)
  {
    int i1;
    int i2;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    double d2;
    double d1;
    if (???.a != do.a)
    {
      this.D = ???;
      i1 = this.b;
      i2 = this.j.getRequestLevel();
      localObject3 = this.M;
      localObject1 = new Location(???.a);
      localObject4 = ((Location)localObject1).getExtras();
      if (localObject4 == null) {
        break label450;
      }
      d2 = ((Bundle)localObject4).getDouble("lat");
      d1 = ((Bundle)localObject4).getDouble("lng");
    }
    for (;;)
    {
      if (i1 == 0) {
        i1 = 1;
      }
      for (;;)
      {
        if (i1 != 0)
        {
          localObject4 = new em.a();
          ((em.a)localObject4).b = ((em)localObject3);
          ((em.a)localObject4).d = "gps";
          ((em.a)localObject4).c = i2;
          localObject3 = ((em.a)localObject4).a(new Location(???.a)).a();
          ((Location)localObject1).setLatitude(d2);
          ((Location)localObject1).setLongitude(d1);
          ((em)localObject3).a((Location)localObject1);
          a(0, (em)localObject3);
          label172:
          a(12004, 3);
          if (this.Q != null)
          {
            localObject1 = this.Q;
            localObject3 = ???.a;
          }
        }
        synchronized (((cn)localObject1).a)
        {
          if (!((cn)localObject1).b())
          {
            return;
            i1 = 0;
            continue;
            if (g()) {
              a(3999);
            }
            localObject4 = new em.a();
            ((em.a)localObject4).b = ((em)localObject3);
            ((em.a)localObject4).d = "gps";
            ((em.a)localObject4).c = i2;
            localObject3 = ((em.a)localObject4).a(new Location(???.a)).a();
            ((Location)localObject1).setLatitude(d2);
            ((Location)localObject1).setLongitude(d1);
            ((em)localObject3).a((Location)localObject1);
            a(0, (em)localObject3);
            break label172;
          }
          else
          {
            if ((localObject3 == null) || (!"gps".equals(((Location)localObject3).getProvider())) || (((Location)localObject3).getAltitude() == 0.0D)) {
              break label447;
            }
            if ((Build.VERSION.SDK_INT >= 18) && (((Location)localObject3).isFromMockProvider())) {
              return;
            }
          }
        }
      }
      localObject2.e = cn.a(localObject2.e, (Location)localObject3);
      if ((localObject2.f == null) || ((localObject2.e != null) && (localObject2.e.distanceTo(localObject2.f) >= 50.0F) && (System.currentTimeMillis() - localObject2.j >= 5000L))) {
        localObject2.a();
      }
      label447:
      return;
      label450:
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    int i1 = j.d(this.E.a);
    String str;
    if (i1 != -1) {
      if (i1 == 0) {
        str = "mobile";
      }
    }
    for (;;)
    {
      switch (paramInteger.intValue())
      {
      default: 
        return;
        if (i1 == 1) {
          str = "wifi";
        } else {
          str = "none";
        }
        break;
      }
    }
    j.a("TxLocationManagerImpl", 4, "onNetworkEvent: networks not found");
    return;
    j.a("TxLocationManagerImpl", 4, "onNetworkEvent: " + str + " disconnected");
    return;
    j.a("TxLocationManagerImpl", 4, "onNetworkEvent: " + str + " connected");
    a(7999, 1000L);
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    a(paramMessage.arg1, paramMessage.arg2);
  }
  
  public final void onWifiInfoEvent(ee paramee)
  {
    int i1 = 0;
    Object localObject2;
    Object localObject1;
    if (this.C != null)
    {
      localObject2 = this.C;
      if (paramee == null) {
        break label425;
      }
      localObject1 = paramee.b;
      localObject2 = ((ee)localObject2).b;
      if ((((List)localObject1).size() != 0) && (((List)localObject2).size() != 0)) {
        break label161;
      }
      i1 = 0;
    }
    for (;;)
    {
      if (i1 != 0) {
        this.I = System.currentTimeMillis();
      }
      if ((this.B == null) || (this.i == 2) || (paramee == ee.a) || (this.I == -1L) || (Collections.unmodifiableList(paramee.b).size() < 3) || (i1 == 0))
      {
        j.a("TxLocationManagerImpl", 4, "onWifiChanged: --> prepare json");
        a(3999);
      }
      this.B = paramee;
      if (this.Q != null) {
        this.Q.a(Collections.unmodifiableList(paramee.b));
      }
      return;
      label161:
      int i2 = ((List)localObject1).size();
      int i3 = ((List)localObject2).size();
      boolean bool;
      if ((i2 == 0) && (i3 == 0)) {
        bool = true;
      }
      for (;;)
      {
        if (!bool)
        {
          i1 = 1;
          break;
          if ((i2 == 0) || (i3 == 0))
          {
            bool = false;
          }
          else
          {
            if (((List)localObject1).size() > ((List)localObject2).size()) {}
            for (;;)
            {
              localObject2 = ((List)localObject2).iterator();
              i1 = 0;
              for (;;)
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break label330;
                }
                localObject3 = (ScanResult)((Iterator)localObject2).next();
                Iterator localIterator = ((List)localObject1).iterator();
                if (localIterator.hasNext())
                {
                  if (!((ScanResult)localIterator.next()).BSSID.equals(((ScanResult)localObject3).BSSID)) {
                    break;
                  }
                  i1 += 1;
                }
              }
              Object localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
            label330:
            i3 = i2 + i3;
            if ((i1 << 1 < i3 * 0.85D) || (i1 < 13)) {}
            for (bool = true;; bool = false)
            {
              j.a("TxWifiChange", 4, "isDiffrent:c=" + i2 + ",k=" + i1 + ",f=" + i3 + ",r=0.85,s=" + bool);
              break;
            }
          }
        }
      }
      label425:
      i1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.dr
 * JD-Core Version:    0.7.0.1
 */