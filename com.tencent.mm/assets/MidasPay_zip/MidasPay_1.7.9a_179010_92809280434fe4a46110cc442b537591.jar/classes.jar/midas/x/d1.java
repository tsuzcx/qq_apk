package midas.x;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.midas.comm.APLog;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class d1
{
  public static final String m = "d1";
  public HttpURLConnection a = null;
  public InputStream b = null;
  public int c = 0;
  public boolean d = false;
  public Handler e;
  public String f = "";
  public String g = "release";
  public int h = -1;
  public HandlerThread i = null;
  public Handler j = null;
  public String k;
  public String l;
  
  public d1(String paramString1, String paramString2, Handler paramHandler, String paramString3, String paramString4, int paramInt)
  {
    this.i.start();
    this.j = new b(this.i.getLooper());
    this.e = paramHandler;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramInt;
    this.k = paramString1;
    this.l = paramString2;
  }
  
  public final void a()
  {
    APLog.i(m, "quit");
    this.d = true;
    if (this.a != null)
    {
      localObject = m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k);
      localStringBuilder.append(":quit disconnect");
      APLog.i((String)localObject, localStringBuilder.toString());
      this.a.disconnect();
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((HandlerThread)localObject).quit();
    }
  }
  
  /* Error */
  public final void a(Handler paramHandler, String paramString)
  {
    // Byte code:
    //   0: getstatic 92	midas/x/d1:m	Ljava/lang/String;
    //   3: astore 4
    //   5: new 101	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_0
    //   17: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   20: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: ldc 130
    //   28: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 4
    //   34: aload 5
    //   36: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: new 132	java/net/URL
    //   46: dup
    //   47: ldc 134
    //   49: iconst_4
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: invokevirtual 136	midas/x/d1:b	()Ljava/lang/String;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_2
    //   63: aastore
    //   64: dup
    //   65: iconst_2
    //   66: ldc 138
    //   68: aastore
    //   69: dup
    //   70: iconst_3
    //   71: aload_0
    //   72: getfield 80	midas/x/d1:l	Ljava/lang/String;
    //   75: aastore
    //   76: invokestatic 144	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokespecial 145	java/net/URL:<init>	(Ljava/lang/String;)V
    //   82: invokevirtual 149	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   85: checkcast 114	java/net/HttpURLConnection
    //   88: putfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   91: aload_0
    //   92: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   95: sipush 15000
    //   98: invokevirtual 153	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   101: aload_0
    //   102: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   105: ldc 155
    //   107: aload_0
    //   108: invokevirtual 136	midas/x/d1:b	()Ljava/lang/String;
    //   111: invokevirtual 158	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   118: iconst_0
    //   119: invokevirtual 162	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   122: aload_0
    //   123: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   126: ldc 164
    //   128: ldc 166
    //   130: invokevirtual 158	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   137: ldc 168
    //   139: ldc 170
    //   141: invokevirtual 158	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   148: invokevirtual 173	java/net/HttpURLConnection:connect	()V
    //   151: getstatic 92	midas/x/d1:m	Ljava/lang/String;
    //   154: astore 4
    //   156: new 101	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   163: astore 5
    //   165: aload 5
    //   167: aload_0
    //   168: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   171: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 5
    //   177: ldc 175
    //   179: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 4
    //   185: aload 5
    //   187: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_1
    //   194: invokevirtual 181	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   197: astore 4
    //   199: aload 4
    //   201: aload_0
    //   202: getfield 53	midas/x/d1:h	I
    //   205: putfield 186	android/os/Message:what	I
    //   208: new 6	midas/x/d1$a
    //   211: dup
    //   212: invokespecial 187	midas/x/d1$a:<init>	()V
    //   215: astore 5
    //   217: aload 5
    //   219: iconst_3
    //   220: putfield 189	midas/x/d1$a:a	I
    //   223: aload 4
    //   225: aload 5
    //   227: putfield 193	android/os/Message:obj	Ljava/lang/Object;
    //   230: aload_1
    //   231: aload 4
    //   233: invokevirtual 197	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   236: pop
    //   237: aload_0
    //   238: aload_0
    //   239: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   242: invokevirtual 201	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   245: putfield 39	midas/x/d1:b	Ljava/io/InputStream;
    //   248: aload_0
    //   249: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   252: invokevirtual 205	java/net/HttpURLConnection:getResponseCode	()I
    //   255: sipush 200
    //   258: if_icmpne +363 -> 621
    //   261: new 101	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   268: astore 4
    //   270: new 207	java/io/BufferedReader
    //   273: dup
    //   274: new 209	java/io/InputStreamReader
    //   277: dup
    //   278: aload_0
    //   279: getfield 39	midas/x/d1:b	Ljava/io/InputStream;
    //   282: invokespecial 212	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   285: invokespecial 215	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   288: astore 5
    //   290: aload 5
    //   292: invokevirtual 218	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   295: astore 6
    //   297: aload 6
    //   299: ifnull +14 -> 313
    //   302: aload 4
    //   304: aload 6
    //   306: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: goto -20 -> 290
    //   313: getstatic 92	midas/x/d1:m	Ljava/lang/String;
    //   316: astore 5
    //   318: new 101	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   325: astore 6
    //   327: aload 6
    //   329: aload_0
    //   330: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   333: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 6
    //   339: ldc 220
    //   341: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 6
    //   347: aload 4
    //   349: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 5
    //   358: aload 6
    //   360: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload 4
    //   368: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   374: istore_3
    //   375: goto +6 -> 381
    //   378: ldc 227
    //   380: istore_3
    //   381: iload_3
    //   382: ldc 227
    //   384: if_icmpeq +114 -> 498
    //   387: iload_3
    //   388: ifne +777 -> 1165
    //   391: aload_0
    //   392: aload_1
    //   393: aload_2
    //   394: invokevirtual 229	midas/x/d1:b	(Landroid/os/Handler;Ljava/lang/String;)V
    //   397: goto +320 -> 717
    //   400: aload_1
    //   401: invokevirtual 181	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   404: astore 4
    //   406: aload 4
    //   408: aload_0
    //   409: getfield 53	midas/x/d1:h	I
    //   412: putfield 186	android/os/Message:what	I
    //   415: new 6	midas/x/d1$a
    //   418: dup
    //   419: invokespecial 187	midas/x/d1$a:<init>	()V
    //   422: astore 5
    //   424: aload 5
    //   426: iconst_0
    //   427: putfield 189	midas/x/d1$a:a	I
    //   430: aload 5
    //   432: iload_3
    //   433: putfield 231	midas/x/d1$a:b	I
    //   436: aload 4
    //   438: aload 5
    //   440: putfield 193	android/os/Message:obj	Ljava/lang/Object;
    //   443: aload_1
    //   444: aload 4
    //   446: invokevirtual 197	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   449: pop
    //   450: goto +267 -> 717
    //   453: getstatic 92	midas/x/d1:m	Ljava/lang/String;
    //   456: astore 4
    //   458: new 101	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   465: astore 5
    //   467: aload 5
    //   469: aload_0
    //   470: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   473: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 5
    //   479: ldc 233
    //   481: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 4
    //   487: aload 5
    //   489: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: goto +222 -> 717
    //   498: aload 4
    //   500: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: ldc 235
    //   505: invokevirtual 239	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   508: ifeq +66 -> 574
    //   511: aload_1
    //   512: invokevirtual 181	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   515: astore 5
    //   517: aload 5
    //   519: aload_0
    //   520: getfield 53	midas/x/d1:h	I
    //   523: putfield 186	android/os/Message:what	I
    //   526: new 6	midas/x/d1$a
    //   529: dup
    //   530: invokespecial 187	midas/x/d1$a:<init>	()V
    //   533: astore 6
    //   535: aload 6
    //   537: iconst_1
    //   538: putfield 189	midas/x/d1$a:a	I
    //   541: aload 6
    //   543: iload_3
    //   544: putfield 231	midas/x/d1$a:b	I
    //   547: aload 6
    //   549: aload 4
    //   551: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: putfield 241	midas/x/d1$a:c	Ljava/lang/String;
    //   557: aload 5
    //   559: aload 6
    //   561: putfield 193	android/os/Message:obj	Ljava/lang/Object;
    //   564: aload_1
    //   565: aload 5
    //   567: invokevirtual 197	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   570: pop
    //   571: goto +146 -> 717
    //   574: aload_1
    //   575: invokevirtual 181	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   578: astore 4
    //   580: aload 4
    //   582: aload_0
    //   583: getfield 53	midas/x/d1:h	I
    //   586: putfield 186	android/os/Message:what	I
    //   589: new 6	midas/x/d1$a
    //   592: dup
    //   593: invokespecial 187	midas/x/d1$a:<init>	()V
    //   596: astore 5
    //   598: aload 5
    //   600: iconst_2
    //   601: putfield 189	midas/x/d1$a:a	I
    //   604: aload 4
    //   606: aload 5
    //   608: putfield 193	android/os/Message:obj	Ljava/lang/Object;
    //   611: aload_1
    //   612: aload 4
    //   614: invokevirtual 197	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   617: pop
    //   618: goto +99 -> 717
    //   621: new 101	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   628: astore 4
    //   630: aload 4
    //   632: ldc 243
    //   634: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload 4
    //   640: aload_0
    //   641: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   644: invokevirtual 205	java/net/HttpURLConnection:getResponseCode	()I
    //   647: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 4
    //   653: ldc 248
    //   655: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 4
    //   661: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: astore 4
    //   666: new 101	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   673: astore 5
    //   675: aload 5
    //   677: aload_0
    //   678: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   681: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 5
    //   687: ldc 250
    //   689: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload 5
    //   695: aload 4
    //   697: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: ldc 252
    //   703: aload 5
    //   705: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload_0
    //   712: aload_1
    //   713: aload_2
    //   714: invokevirtual 229	midas/x/d1:b	(Landroid/os/Handler;Ljava/lang/String;)V
    //   717: new 101	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   724: astore_1
    //   725: aload_1
    //   726: aload_0
    //   727: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   730: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload_1
    //   735: ldc 254
    //   737: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: ldc_w 256
    //   744: aload_1
    //   745: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload_0
    //   752: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   755: astore_1
    //   756: aload_1
    //   757: ifnull +7 -> 764
    //   760: aload_1
    //   761: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   764: aload_0
    //   765: getfield 39	midas/x/d1:b	Ljava/io/InputStream;
    //   768: astore_1
    //   769: aload_1
    //   770: ifnull +313 -> 1083
    //   773: aload_1
    //   774: invokevirtual 260	java/io/InputStream:close	()V
    //   777: return
    //   778: astore_1
    //   779: goto +305 -> 1084
    //   782: astore 4
    //   784: aload_0
    //   785: aload_1
    //   786: aload_2
    //   787: invokevirtual 229	midas/x/d1:b	(Landroid/os/Handler;Ljava/lang/String;)V
    //   790: aload 4
    //   792: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   795: new 101	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   802: astore_1
    //   803: aload_1
    //   804: aload_0
    //   805: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   808: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload_1
    //   813: ldc 254
    //   815: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: ldc_w 256
    //   822: aload_1
    //   823: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   829: aload_0
    //   830: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   833: astore_1
    //   834: aload_1
    //   835: ifnull +7 -> 842
    //   838: aload_1
    //   839: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   842: aload_0
    //   843: getfield 39	midas/x/d1:b	Ljava/io/InputStream;
    //   846: astore_1
    //   847: aload_1
    //   848: ifnull +235 -> 1083
    //   851: aload_1
    //   852: invokevirtual 260	java/io/InputStream:close	()V
    //   855: return
    //   856: astore 4
    //   858: aload_0
    //   859: aload_1
    //   860: aload_2
    //   861: invokevirtual 229	midas/x/d1:b	(Landroid/os/Handler;Ljava/lang/String;)V
    //   864: aload 4
    //   866: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   869: new 101	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   876: astore_1
    //   877: aload_1
    //   878: aload_0
    //   879: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   882: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: aload_1
    //   887: ldc 254
    //   889: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: ldc_w 256
    //   896: aload_1
    //   897: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload_0
    //   904: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   907: astore_1
    //   908: aload_1
    //   909: ifnull +7 -> 916
    //   912: aload_1
    //   913: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   916: aload_0
    //   917: getfield 39	midas/x/d1:b	Ljava/io/InputStream;
    //   920: astore_1
    //   921: aload_1
    //   922: ifnull +161 -> 1083
    //   925: aload_1
    //   926: invokevirtual 260	java/io/InputStream:close	()V
    //   929: return
    //   930: astore 4
    //   932: aload_0
    //   933: aload_1
    //   934: aload_2
    //   935: invokevirtual 229	midas/x/d1:b	(Landroid/os/Handler;Ljava/lang/String;)V
    //   938: aload 4
    //   940: invokevirtual 265	java/net/SocketTimeoutException:printStackTrace	()V
    //   943: new 101	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   950: astore_1
    //   951: aload_1
    //   952: aload_0
    //   953: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   956: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: aload_1
    //   961: ldc 254
    //   963: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: ldc_w 256
    //   970: aload_1
    //   971: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: aload_0
    //   978: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   981: astore_1
    //   982: aload_1
    //   983: ifnull +7 -> 990
    //   986: aload_1
    //   987: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   990: aload_0
    //   991: getfield 39	midas/x/d1:b	Ljava/io/InputStream;
    //   994: astore_1
    //   995: aload_1
    //   996: ifnull +87 -> 1083
    //   999: aload_1
    //   1000: invokevirtual 260	java/io/InputStream:close	()V
    //   1003: return
    //   1004: astore 4
    //   1006: aload_0
    //   1007: aload_1
    //   1008: aload_2
    //   1009: invokevirtual 229	midas/x/d1:b	(Landroid/os/Handler;Ljava/lang/String;)V
    //   1012: aload 4
    //   1014: invokevirtual 266	org/apache/http/conn/ConnectTimeoutException:printStackTrace	()V
    //   1017: new 101	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1024: astore_1
    //   1025: aload_1
    //   1026: aload_0
    //   1027: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   1030: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload_1
    //   1035: ldc 254
    //   1037: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: ldc_w 256
    //   1044: aload_1
    //   1045: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1051: aload_0
    //   1052: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   1055: astore_1
    //   1056: aload_1
    //   1057: ifnull +7 -> 1064
    //   1060: aload_1
    //   1061: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   1064: aload_0
    //   1065: getfield 39	midas/x/d1:b	Ljava/io/InputStream;
    //   1068: astore_1
    //   1069: aload_1
    //   1070: ifnull +13 -> 1083
    //   1073: aload_1
    //   1074: invokevirtual 260	java/io/InputStream:close	()V
    //   1077: return
    //   1078: astore_1
    //   1079: aload_1
    //   1080: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   1083: return
    //   1084: new 101	java/lang/StringBuilder
    //   1087: dup
    //   1088: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1091: astore_2
    //   1092: aload_2
    //   1093: aload_0
    //   1094: getfield 78	midas/x/d1:k	Ljava/lang/String;
    //   1097: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: pop
    //   1101: aload_2
    //   1102: ldc 254
    //   1104: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: ldc_w 256
    //   1111: aload_2
    //   1112: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokestatic 99	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1118: aload_0
    //   1119: getfield 37	midas/x/d1:a	Ljava/net/HttpURLConnection;
    //   1122: astore_2
    //   1123: aload_2
    //   1124: ifnull +7 -> 1131
    //   1127: aload_2
    //   1128: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   1131: aload_0
    //   1132: getfield 39	midas/x/d1:b	Ljava/io/InputStream;
    //   1135: astore_2
    //   1136: aload_2
    //   1137: ifnull +15 -> 1152
    //   1140: aload_2
    //   1141: invokevirtual 260	java/io/InputStream:close	()V
    //   1144: goto +8 -> 1152
    //   1147: astore_2
    //   1148: aload_2
    //   1149: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   1152: goto +5 -> 1157
    //   1155: aload_1
    //   1156: athrow
    //   1157: goto -2 -> 1155
    //   1160: astore 5
    //   1162: goto -784 -> 378
    //   1165: iload_3
    //   1166: bipush 252
    //   1168: if_icmpeq -715 -> 453
    //   1171: iload_3
    //   1172: bipush 251
    //   1174: if_icmpne -774 -> 400
    //   1177: goto -724 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1180	0	this	d1
    //   0	1180	1	paramHandler	Handler
    //   0	1180	2	paramString	String
    //   374	801	3	n	int
    //   3	693	4	localObject1	Object
    //   782	9	4	localException1	java.lang.Exception
    //   856	9	4	localIOException	java.io.IOException
    //   930	9	4	localSocketTimeoutException	java.net.SocketTimeoutException
    //   1004	9	4	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   12	692	5	localObject2	Object
    //   1160	1	5	localException2	java.lang.Exception
    //   295	265	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	290	778	finally
    //   290	297	778	finally
    //   302	310	778	finally
    //   313	366	778	finally
    //   366	375	778	finally
    //   391	397	778	finally
    //   400	450	778	finally
    //   453	495	778	finally
    //   498	571	778	finally
    //   574	618	778	finally
    //   621	717	778	finally
    //   784	795	778	finally
    //   858	869	778	finally
    //   932	943	778	finally
    //   1006	1017	778	finally
    //   0	290	782	java/lang/Exception
    //   290	297	782	java/lang/Exception
    //   302	310	782	java/lang/Exception
    //   313	366	782	java/lang/Exception
    //   391	397	782	java/lang/Exception
    //   400	450	782	java/lang/Exception
    //   453	495	782	java/lang/Exception
    //   498	571	782	java/lang/Exception
    //   574	618	782	java/lang/Exception
    //   621	717	782	java/lang/Exception
    //   0	290	856	java/io/IOException
    //   290	297	856	java/io/IOException
    //   302	310	856	java/io/IOException
    //   313	366	856	java/io/IOException
    //   391	397	856	java/io/IOException
    //   400	450	856	java/io/IOException
    //   453	495	856	java/io/IOException
    //   498	571	856	java/io/IOException
    //   574	618	856	java/io/IOException
    //   621	717	856	java/io/IOException
    //   0	290	930	java/net/SocketTimeoutException
    //   290	297	930	java/net/SocketTimeoutException
    //   302	310	930	java/net/SocketTimeoutException
    //   313	366	930	java/net/SocketTimeoutException
    //   391	397	930	java/net/SocketTimeoutException
    //   400	450	930	java/net/SocketTimeoutException
    //   453	495	930	java/net/SocketTimeoutException
    //   498	571	930	java/net/SocketTimeoutException
    //   574	618	930	java/net/SocketTimeoutException
    //   621	717	930	java/net/SocketTimeoutException
    //   0	290	1004	org/apache/http/conn/ConnectTimeoutException
    //   290	297	1004	org/apache/http/conn/ConnectTimeoutException
    //   302	310	1004	org/apache/http/conn/ConnectTimeoutException
    //   313	366	1004	org/apache/http/conn/ConnectTimeoutException
    //   391	397	1004	org/apache/http/conn/ConnectTimeoutException
    //   400	450	1004	org/apache/http/conn/ConnectTimeoutException
    //   453	495	1004	org/apache/http/conn/ConnectTimeoutException
    //   498	571	1004	org/apache/http/conn/ConnectTimeoutException
    //   574	618	1004	org/apache/http/conn/ConnectTimeoutException
    //   621	717	1004	org/apache/http/conn/ConnectTimeoutException
    //   773	777	1078	java/io/IOException
    //   851	855	1078	java/io/IOException
    //   925	929	1078	java/io/IOException
    //   999	1003	1078	java/io/IOException
    //   1073	1077	1078	java/io/IOException
    //   1140	1144	1147	java/io/IOException
    //   366	375	1160	java/lang/Exception
  }
  
  public final String b()
  {
    String str = this.g;
    if (str.equals("custom")) {
      return "jspay.qq.com";
    }
    if (str.equals("dev")) {
      return "sandbox.jspay.qq.com";
    }
    if (str.equals("test")) {
      return "sandbox.jspay.qq.com";
    }
    if (str.equals("release")) {
      return "jspay.qq.com";
    }
    return "";
  }
  
  public final void b(Handler paramHandler, String paramString)
  {
    int n = this.c;
    if (n > 0)
    {
      paramString = paramHandler.obtainMessage();
      paramString.what = this.h;
      localObject = new a();
      ((a)localObject).a = 4;
      paramString.obj = localObject;
      paramHandler.sendMessage(paramString);
      return;
    }
    if (this.d) {
      return;
    }
    this.c = (n + 1);
    Object localObject = m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k);
    localStringBuilder.append(":_reconnect disconnect");
    APLog.i((String)localObject, localStringBuilder.toString());
    localObject = this.a;
    if (localObject != null) {
      ((HttpURLConnection)localObject).disconnect();
    }
    a(paramHandler, paramString);
  }
  
  public void c()
  {
    a();
  }
  
  public void d()
  {
    this.c = 0;
    this.d = false;
    this.j.sendEmptyMessage(1);
  }
  
  public static class a
  {
    public int a;
    public int b;
    public String c;
  }
  
  public class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i == 2) {
          d1.c(d1.this);
        }
      }
      else
      {
        d1 locald1 = d1.this;
        d1.a(locald1, d1.a(locald1), d1.b(d1.this));
      }
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d1
 * JD-Core Version:    0.7.0.1
 */