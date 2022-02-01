package midas.x;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.midas.comm.APLog;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class bc
{
  private static final String a = "bc";
  private final int b = 0;
  private HttpURLConnection c = null;
  private InputStream d = null;
  private int e = 0;
  private boolean f = false;
  private Handler g;
  private String h = "";
  private String i = "release";
  private int j = -1;
  private HandlerThread k = null;
  private Handler l = null;
  private String m;
  private String n;
  
  public bc(String paramString1, String paramString2, Handler paramHandler, String paramString3, String paramString4, int paramInt)
  {
    this.k.start();
    this.l = new b(this.k.getLooper());
    this.g = paramHandler;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramInt;
    this.m = paramString1;
    this.n = paramString2;
  }
  
  private void a(Handler paramHandler, String paramString)
  {
    if (this.e > 0)
    {
      paramString = paramHandler.obtainMessage();
      paramString.what = this.j;
      localObject = new a();
      ((a)localObject).a = 4;
      paramString.obj = localObject;
      paramHandler.sendMessage(paramString);
      return;
    }
    if (this.f) {
      return;
    }
    this.e += 1;
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m);
    localStringBuilder.append(":_reconnect disconnect");
    APLog.i((String)localObject, localStringBuilder.toString());
    if (this.c != null) {
      this.c.disconnect();
    }
    b(paramHandler, paramString);
  }
  
  /* Error */
  private void b(Handler paramHandler, String paramString)
  {
    // Byte code:
    //   0: getstatic 111	midas/x/bc:a	Ljava/lang/String;
    //   3: astore 4
    //   5: new 113	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_0
    //   17: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   20: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: ldc 148
    //   28: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 4
    //   34: aload 5
    //   36: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: new 150	java/net/URL
    //   46: dup
    //   47: ldc 152
    //   49: iconst_4
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: invokespecial 154	midas/x/bc:d	()Ljava/lang/String;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_2
    //   63: aastore
    //   64: dup
    //   65: iconst_2
    //   66: ldc 156
    //   68: aastore
    //   69: dup
    //   70: iconst_3
    //   71: aload_0
    //   72: getfield 85	midas/x/bc:n	Ljava/lang/String;
    //   75: aastore
    //   76: invokestatic 162	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokespecial 163	java/net/URL:<init>	(Ljava/lang/String;)V
    //   82: invokevirtual 167	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   85: checkcast 131	java/net/HttpURLConnection
    //   88: putfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   91: aload_0
    //   92: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   95: sipush 15000
    //   98: invokevirtual 171	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   101: aload_0
    //   102: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   105: ldc 173
    //   107: aload_0
    //   108: invokespecial 154	midas/x/bc:d	()Ljava/lang/String;
    //   111: invokevirtual 176	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   118: iconst_0
    //   119: invokevirtual 180	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   122: aload_0
    //   123: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   126: ldc 182
    //   128: ldc 184
    //   130: invokevirtual 176	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   137: ldc 186
    //   139: ldc 188
    //   141: invokevirtual 176	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   148: invokevirtual 191	java/net/HttpURLConnection:connect	()V
    //   151: getstatic 111	midas/x/bc:a	Ljava/lang/String;
    //   154: astore 4
    //   156: new 113	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   163: astore 5
    //   165: aload 5
    //   167: aload_0
    //   168: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   171: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 5
    //   177: ldc 193
    //   179: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 4
    //   185: aload 5
    //   187: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_1
    //   194: invokevirtual 93	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   197: astore 4
    //   199: aload 4
    //   201: aload_0
    //   202: getfield 58	midas/x/bc:j	I
    //   205: putfield 98	android/os/Message:what	I
    //   208: new 6	midas/x/bc$a
    //   211: dup
    //   212: invokespecial 99	midas/x/bc$a:<init>	()V
    //   215: astore 5
    //   217: aload 5
    //   219: iconst_3
    //   220: putfield 101	midas/x/bc$a:a	I
    //   223: aload 4
    //   225: aload 5
    //   227: putfield 105	android/os/Message:obj	Ljava/lang/Object;
    //   230: aload_1
    //   231: aload 4
    //   233: invokevirtual 109	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   236: pop
    //   237: aload_0
    //   238: aload_0
    //   239: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   242: invokevirtual 197	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   245: putfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   248: aload_0
    //   249: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   252: invokevirtual 201	java/net/HttpURLConnection:getResponseCode	()I
    //   255: sipush 200
    //   258: if_icmpne +363 -> 621
    //   261: new 113	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   268: astore 4
    //   270: new 203	java/io/BufferedReader
    //   273: dup
    //   274: new 205	java/io/InputStreamReader
    //   277: dup
    //   278: aload_0
    //   279: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   282: invokespecial 208	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   285: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   288: astore 5
    //   290: aload 5
    //   292: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   295: astore 6
    //   297: aload 6
    //   299: ifnull +14 -> 313
    //   302: aload 4
    //   304: aload 6
    //   306: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: goto -20 -> 290
    //   313: getstatic 111	midas/x/bc:a	Ljava/lang/String;
    //   316: astore 5
    //   318: new 113	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   325: astore 6
    //   327: aload 6
    //   329: aload_0
    //   330: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   333: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 6
    //   339: ldc 216
    //   341: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 6
    //   347: aload 4
    //   349: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 5
    //   358: aload 6
    //   360: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload 4
    //   368: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 222	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   374: istore_3
    //   375: goto +6 -> 381
    //   378: ldc 223
    //   380: istore_3
    //   381: iload_3
    //   382: ldc 223
    //   384: if_icmpeq +114 -> 498
    //   387: iload_3
    //   388: ifne +777 -> 1165
    //   391: aload_0
    //   392: aload_1
    //   393: aload_2
    //   394: invokespecial 225	midas/x/bc:a	(Landroid/os/Handler;Ljava/lang/String;)V
    //   397: goto +320 -> 717
    //   400: aload_1
    //   401: invokevirtual 93	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   404: astore 4
    //   406: aload 4
    //   408: aload_0
    //   409: getfield 58	midas/x/bc:j	I
    //   412: putfield 98	android/os/Message:what	I
    //   415: new 6	midas/x/bc$a
    //   418: dup
    //   419: invokespecial 99	midas/x/bc$a:<init>	()V
    //   422: astore 5
    //   424: aload 5
    //   426: iconst_0
    //   427: putfield 101	midas/x/bc$a:a	I
    //   430: aload 5
    //   432: iload_3
    //   433: putfield 226	midas/x/bc$a:b	I
    //   436: aload 4
    //   438: aload 5
    //   440: putfield 105	android/os/Message:obj	Ljava/lang/Object;
    //   443: aload_1
    //   444: aload 4
    //   446: invokevirtual 109	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   449: pop
    //   450: goto +267 -> 717
    //   453: getstatic 111	midas/x/bc:a	Ljava/lang/String;
    //   456: astore 4
    //   458: new 113	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   465: astore 5
    //   467: aload 5
    //   469: aload_0
    //   470: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   473: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 5
    //   479: ldc 228
    //   481: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload 4
    //   487: aload 5
    //   489: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: goto +222 -> 717
    //   498: aload 4
    //   500: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: ldc 230
    //   505: invokevirtual 234	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   508: ifeq +66 -> 574
    //   511: aload_1
    //   512: invokevirtual 93	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   515: astore 5
    //   517: aload 5
    //   519: aload_0
    //   520: getfield 58	midas/x/bc:j	I
    //   523: putfield 98	android/os/Message:what	I
    //   526: new 6	midas/x/bc$a
    //   529: dup
    //   530: invokespecial 99	midas/x/bc$a:<init>	()V
    //   533: astore 6
    //   535: aload 6
    //   537: iconst_1
    //   538: putfield 101	midas/x/bc$a:a	I
    //   541: aload 6
    //   543: iload_3
    //   544: putfield 226	midas/x/bc$a:b	I
    //   547: aload 6
    //   549: aload 4
    //   551: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: putfield 236	midas/x/bc$a:c	Ljava/lang/String;
    //   557: aload 5
    //   559: aload 6
    //   561: putfield 105	android/os/Message:obj	Ljava/lang/Object;
    //   564: aload_1
    //   565: aload 5
    //   567: invokevirtual 109	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   570: pop
    //   571: goto +146 -> 717
    //   574: aload_1
    //   575: invokevirtual 93	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   578: astore 4
    //   580: aload 4
    //   582: aload_0
    //   583: getfield 58	midas/x/bc:j	I
    //   586: putfield 98	android/os/Message:what	I
    //   589: new 6	midas/x/bc$a
    //   592: dup
    //   593: invokespecial 99	midas/x/bc$a:<init>	()V
    //   596: astore 5
    //   598: aload 5
    //   600: iconst_2
    //   601: putfield 101	midas/x/bc$a:a	I
    //   604: aload 4
    //   606: aload 5
    //   608: putfield 105	android/os/Message:obj	Ljava/lang/Object;
    //   611: aload_1
    //   612: aload 4
    //   614: invokevirtual 109	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   617: pop
    //   618: goto +99 -> 717
    //   621: new 113	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   628: astore 4
    //   630: aload 4
    //   632: ldc 238
    //   634: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload 4
    //   640: aload_0
    //   641: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   644: invokevirtual 201	java/net/HttpURLConnection:getResponseCode	()I
    //   647: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 4
    //   653: ldc 243
    //   655: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 4
    //   661: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: astore 4
    //   666: new 113	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   673: astore 5
    //   675: aload 5
    //   677: aload_0
    //   678: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   681: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 5
    //   687: ldc 245
    //   689: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload 5
    //   695: aload 4
    //   697: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: ldc 247
    //   703: aload 5
    //   705: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload_0
    //   712: aload_1
    //   713: aload_2
    //   714: invokespecial 225	midas/x/bc:a	(Landroid/os/Handler;Ljava/lang/String;)V
    //   717: new 113	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   724: astore_1
    //   725: aload_1
    //   726: aload_0
    //   727: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   730: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload_1
    //   735: ldc 249
    //   737: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: ldc 251
    //   743: aload_1
    //   744: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   750: aload_0
    //   751: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   754: ifnull +10 -> 764
    //   757: aload_0
    //   758: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   761: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   764: aload_0
    //   765: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   768: ifnull +320 -> 1088
    //   771: aload_0
    //   772: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   775: invokevirtual 255	java/io/InputStream:close	()V
    //   778: return
    //   779: astore_1
    //   780: goto +309 -> 1089
    //   783: astore 4
    //   785: aload_0
    //   786: aload_1
    //   787: aload_2
    //   788: invokespecial 225	midas/x/bc:a	(Landroid/os/Handler;Ljava/lang/String;)V
    //   791: aload 4
    //   793: invokevirtual 258	java/lang/Exception:printStackTrace	()V
    //   796: new 113	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   803: astore_1
    //   804: aload_1
    //   805: aload_0
    //   806: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   809: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload_1
    //   814: ldc 249
    //   816: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: ldc 251
    //   822: aload_1
    //   823: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   829: aload_0
    //   830: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   833: ifnull +10 -> 843
    //   836: aload_0
    //   837: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   840: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   843: aload_0
    //   844: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   847: ifnull +241 -> 1088
    //   850: aload_0
    //   851: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   854: invokevirtual 255	java/io/InputStream:close	()V
    //   857: return
    //   858: astore 4
    //   860: aload_0
    //   861: aload_1
    //   862: aload_2
    //   863: invokespecial 225	midas/x/bc:a	(Landroid/os/Handler;Ljava/lang/String;)V
    //   866: aload 4
    //   868: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   871: new 113	java/lang/StringBuilder
    //   874: dup
    //   875: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   878: astore_1
    //   879: aload_1
    //   880: aload_0
    //   881: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   884: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload_1
    //   889: ldc 249
    //   891: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: ldc 251
    //   897: aload_1
    //   898: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   904: aload_0
    //   905: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   908: ifnull +10 -> 918
    //   911: aload_0
    //   912: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   915: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   918: aload_0
    //   919: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   922: ifnull +166 -> 1088
    //   925: aload_0
    //   926: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   929: invokevirtual 255	java/io/InputStream:close	()V
    //   932: return
    //   933: astore 4
    //   935: aload_0
    //   936: aload_1
    //   937: aload_2
    //   938: invokespecial 225	midas/x/bc:a	(Landroid/os/Handler;Ljava/lang/String;)V
    //   941: aload 4
    //   943: invokevirtual 260	java/net/SocketTimeoutException:printStackTrace	()V
    //   946: new 113	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   953: astore_1
    //   954: aload_1
    //   955: aload_0
    //   956: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   959: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: aload_1
    //   964: ldc 249
    //   966: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: ldc 251
    //   972: aload_1
    //   973: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   979: aload_0
    //   980: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   983: ifnull +10 -> 993
    //   986: aload_0
    //   987: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   990: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   993: aload_0
    //   994: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   997: ifnull +91 -> 1088
    //   1000: aload_0
    //   1001: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   1004: invokevirtual 255	java/io/InputStream:close	()V
    //   1007: return
    //   1008: astore 4
    //   1010: aload_0
    //   1011: aload_1
    //   1012: aload_2
    //   1013: invokespecial 225	midas/x/bc:a	(Landroid/os/Handler;Ljava/lang/String;)V
    //   1016: aload 4
    //   1018: invokevirtual 261	org/apache/http/conn/ConnectTimeoutException:printStackTrace	()V
    //   1021: new 113	java/lang/StringBuilder
    //   1024: dup
    //   1025: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1028: astore_1
    //   1029: aload_1
    //   1030: aload_0
    //   1031: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   1034: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload_1
    //   1039: ldc 249
    //   1041: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: ldc 251
    //   1047: aload_1
    //   1048: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1054: aload_0
    //   1055: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   1058: ifnull +10 -> 1068
    //   1061: aload_0
    //   1062: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   1065: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   1068: aload_0
    //   1069: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   1072: ifnull +16 -> 1088
    //   1075: aload_0
    //   1076: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   1079: invokevirtual 255	java/io/InputStream:close	()V
    //   1082: return
    //   1083: astore_1
    //   1084: aload_1
    //   1085: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   1088: return
    //   1089: new 113	java/lang/StringBuilder
    //   1092: dup
    //   1093: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1096: astore_2
    //   1097: aload_2
    //   1098: aload_0
    //   1099: getfield 83	midas/x/bc:m	Ljava/lang/String;
    //   1102: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: aload_2
    //   1107: ldc 249
    //   1109: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: ldc 251
    //   1115: aload_2
    //   1116: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1122: aload_0
    //   1123: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   1126: ifnull +10 -> 1136
    //   1129: aload_0
    //   1130: getfield 42	midas/x/bc:c	Ljava/net/HttpURLConnection;
    //   1133: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   1136: aload_0
    //   1137: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   1140: ifnull +18 -> 1158
    //   1143: aload_0
    //   1144: getfield 44	midas/x/bc:d	Ljava/io/InputStream;
    //   1147: invokevirtual 255	java/io/InputStream:close	()V
    //   1150: goto +8 -> 1158
    //   1153: astore_2
    //   1154: aload_2
    //   1155: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   1158: aload_1
    //   1159: athrow
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
    //   0	1180	0	this	bc
    //   0	1180	1	paramHandler	Handler
    //   0	1180	2	paramString	String
    //   374	801	3	i1	int
    //   3	693	4	localObject1	Object
    //   783	9	4	localException1	java.lang.Exception
    //   858	9	4	localIOException	java.io.IOException
    //   933	9	4	localSocketTimeoutException	java.net.SocketTimeoutException
    //   1008	9	4	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   12	692	5	localObject2	Object
    //   1160	1	5	localException2	java.lang.Exception
    //   295	265	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	290	779	finally
    //   290	297	779	finally
    //   302	310	779	finally
    //   313	366	779	finally
    //   366	375	779	finally
    //   391	397	779	finally
    //   400	450	779	finally
    //   453	495	779	finally
    //   498	571	779	finally
    //   574	618	779	finally
    //   621	717	779	finally
    //   785	796	779	finally
    //   860	871	779	finally
    //   935	946	779	finally
    //   1010	1021	779	finally
    //   0	290	783	java/lang/Exception
    //   290	297	783	java/lang/Exception
    //   302	310	783	java/lang/Exception
    //   313	366	783	java/lang/Exception
    //   391	397	783	java/lang/Exception
    //   400	450	783	java/lang/Exception
    //   453	495	783	java/lang/Exception
    //   498	571	783	java/lang/Exception
    //   574	618	783	java/lang/Exception
    //   621	717	783	java/lang/Exception
    //   0	290	858	java/io/IOException
    //   290	297	858	java/io/IOException
    //   302	310	858	java/io/IOException
    //   313	366	858	java/io/IOException
    //   366	375	858	java/io/IOException
    //   391	397	858	java/io/IOException
    //   400	450	858	java/io/IOException
    //   453	495	858	java/io/IOException
    //   498	571	858	java/io/IOException
    //   574	618	858	java/io/IOException
    //   621	717	858	java/io/IOException
    //   0	290	933	java/net/SocketTimeoutException
    //   290	297	933	java/net/SocketTimeoutException
    //   302	310	933	java/net/SocketTimeoutException
    //   313	366	933	java/net/SocketTimeoutException
    //   366	375	933	java/net/SocketTimeoutException
    //   391	397	933	java/net/SocketTimeoutException
    //   400	450	933	java/net/SocketTimeoutException
    //   453	495	933	java/net/SocketTimeoutException
    //   498	571	933	java/net/SocketTimeoutException
    //   574	618	933	java/net/SocketTimeoutException
    //   621	717	933	java/net/SocketTimeoutException
    //   0	290	1008	org/apache/http/conn/ConnectTimeoutException
    //   290	297	1008	org/apache/http/conn/ConnectTimeoutException
    //   302	310	1008	org/apache/http/conn/ConnectTimeoutException
    //   313	366	1008	org/apache/http/conn/ConnectTimeoutException
    //   366	375	1008	org/apache/http/conn/ConnectTimeoutException
    //   391	397	1008	org/apache/http/conn/ConnectTimeoutException
    //   400	450	1008	org/apache/http/conn/ConnectTimeoutException
    //   453	495	1008	org/apache/http/conn/ConnectTimeoutException
    //   498	571	1008	org/apache/http/conn/ConnectTimeoutException
    //   574	618	1008	org/apache/http/conn/ConnectTimeoutException
    //   621	717	1008	org/apache/http/conn/ConnectTimeoutException
    //   771	778	1083	java/io/IOException
    //   850	857	1083	java/io/IOException
    //   925	932	1083	java/io/IOException
    //   1000	1007	1083	java/io/IOException
    //   1075	1082	1083	java/io/IOException
    //   1143	1150	1153	java/io/IOException
    //   366	375	1160	java/lang/Exception
  }
  
  private void c()
  {
    APLog.i(a, "quit");
    this.f = true;
    if (this.c != null)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.m);
      localStringBuilder.append(":quit disconnect");
      APLog.i(str, localStringBuilder.toString());
      this.c.disconnect();
    }
    if (this.k != null) {
      this.k.quit();
    }
  }
  
  private String d()
  {
    String str = this.i;
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
  
  public void a()
  {
    this.e = 0;
    this.f = false;
    this.l.sendEmptyMessage(1);
  }
  
  public void b()
  {
    c();
  }
  
  public static class a
  {
    public int a;
    public int b;
    public String c;
  }
  
  class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        break;
      case 2: 
        bc.c(bc.this);
        break;
      case 1: 
        bc.a(bc.this, bc.a(bc.this), bc.b(bc.this));
      }
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.bc
 * JD-Core Version:    0.7.0.1
 */