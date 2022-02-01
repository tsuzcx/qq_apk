package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.report.event.c;
import oicq.wlogin_sdk.request.u;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private u a;
  
  public static d a()
  {
    return b.a;
  }
  
  private void f()
  {
    try
    {
      if (this.a == null)
      {
        util.LOGI("[pubkey]checkLocalPubKey g is null", "");
        return;
      }
      String str = e();
      if (TextUtils.isEmpty(str))
      {
        util.LOGI("[pubkey]checkLocalPubKey local empty", "");
        g();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "checkLocalPubKey");
      return;
    }
    c localc = a(localThrowable);
    if (localc == null)
    {
      c.a(new b("wtlogin_rotate_pub_key_error", "json_error", localThrowable));
      util.LOGI("[pubkey]checkLocalPubKey value is null", "");
      g();
      return;
    }
    long l = d();
    if (localc.a * 1000 + l < System.currentTimeMillis())
    {
      util.LOGI("[pubkey]checkLocalPubKey lastTime:" + l + " span:" + localc.a, "");
      g();
      return;
    }
    util.LOGI("[pubkey]checkLocalPubKey span valid", "");
    if (!a(localc.b, localc.c, localc.d))
    {
      c.a(new b("wtlogin_rotate_pub_key_error", "key_error", ""));
      util.LOGI("[pubkey]checkLocalPubKey wrong sign", "");
      g();
      return;
    }
    util.LOGI("[pubkey]checkLocalPubKey sign valid", "");
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	oicq/wlogin_sdk/tools/d:a	Loicq/wlogin_sdk/request/u;
    //   4: ifnonnull +11 -> 15
    //   7: ldc 139
    //   9: ldc 37
    //   11: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: return
    //   15: aload_0
    //   16: getfield 33	oicq/wlogin_sdk/tools/d:a	Loicq/wlogin_sdk/request/u;
    //   19: getfield 144	oicq/wlogin_sdk/request/u:f	J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifne +250 -> 274
    //   27: ldc 146
    //   29: astore 4
    //   31: new 97	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   38: ldc 148
    //   40: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 4
    //   45: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: ldc 37
    //   53: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: new 150	java/net/URL
    //   59: dup
    //   60: ldc 152
    //   62: iconst_2
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: sipush 305
    //   71: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload 4
    //   79: aastore
    //   80: invokestatic 162	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokespecial 165	java/net/URL:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 169	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   89: checkcast 171	java/net/HttpURLConnection
    //   92: astore 4
    //   94: aload 4
    //   96: ldc 173
    //   98: invokevirtual 176	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   101: aload 4
    //   103: aload_0
    //   104: getfield 33	oicq/wlogin_sdk/tools/d:a	Loicq/wlogin_sdk/request/u;
    //   107: getfield 179	oicq/wlogin_sdk/request/u:l	I
    //   110: invokevirtual 183	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   113: aload 4
    //   115: iconst_1
    //   116: invokevirtual 187	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   119: aload 4
    //   121: iconst_1
    //   122: invokevirtual 190	java/net/HttpURLConnection:setDoInput	(Z)V
    //   125: aload 4
    //   127: invokevirtual 194	java/net/HttpURLConnection:getResponseCode	()I
    //   130: istore_1
    //   131: new 97	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   138: ldc 196
    //   140: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload_1
    //   144: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: new 97	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   157: ldc 37
    //   159: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 33	oicq/wlogin_sdk/tools/d:a	Loicq/wlogin_sdk/request/u;
    //   166: getfield 144	oicq/wlogin_sdk/request/u:f	J
    //   169: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: sipush 200
    //   181: iload_1
    //   182: if_icmpne +240 -> 422
    //   185: aload 4
    //   187: invokevirtual 200	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   190: astore 4
    //   192: new 202	java/io/ByteArrayOutputStream
    //   195: dup
    //   196: invokespecial 203	java/io/ByteArrayOutputStream:<init>	()V
    //   199: astore 5
    //   201: sipush 1024
    //   204: newarray byte
    //   206: astore 6
    //   208: aload 4
    //   210: aload 6
    //   212: invokevirtual 209	java/io/InputStream:read	([B)I
    //   215: istore_1
    //   216: iload_1
    //   217: iconst_m1
    //   218: if_icmpeq +73 -> 291
    //   221: aload 5
    //   223: aload 6
    //   225: iconst_0
    //   226: iload_1
    //   227: invokevirtual 213	java/io/ByteArrayOutputStream:write	([BII)V
    //   230: goto -22 -> 208
    //   233: astore 4
    //   235: new 97	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   242: ldc 215
    //   244: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 4
    //   249: invokevirtual 216	java/net/ConnectException:toString	()Ljava/lang/String;
    //   252: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: ldc 37
    //   260: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: return
    //   264: astore 4
    //   266: aload 4
    //   268: ldc 218
    //   270: invokestatic 64	oicq/wlogin_sdk/tools/util:printThrowable	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   273: return
    //   274: aload_0
    //   275: getfield 33	oicq/wlogin_sdk/tools/d:a	Loicq/wlogin_sdk/request/u;
    //   278: getfield 144	oicq/wlogin_sdk/request/u:f	J
    //   281: lstore_2
    //   282: lload_2
    //   283: invokestatic 221	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   286: astore 4
    //   288: goto -257 -> 31
    //   291: aload 5
    //   293: invokevirtual 224	java/io/ByteArrayOutputStream:close	()V
    //   296: aload 4
    //   298: invokevirtual 225	java/io/InputStream:close	()V
    //   301: new 154	java/lang/String
    //   304: dup
    //   305: aload 5
    //   307: invokevirtual 229	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   310: invokespecial 232	java/lang/String:<init>	([B)V
    //   313: astore 4
    //   315: new 97	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   322: ldc 234
    //   324: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 4
    //   329: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: ldc 37
    //   337: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload_0
    //   341: aload 4
    //   343: invokevirtual 67	oicq/wlogin_sdk/tools/d:a	(Ljava/lang/String;)Loicq/wlogin_sdk/tools/d$c;
    //   346: astore 5
    //   348: aload_0
    //   349: aload 5
    //   351: getfield 119	oicq/wlogin_sdk/tools/d$c:b	I
    //   354: aload 5
    //   356: getfield 122	oicq/wlogin_sdk/tools/d$c:c	Ljava/lang/String;
    //   359: aload 5
    //   361: getfield 124	oicq/wlogin_sdk/tools/d$c:d	Ljava/lang/String;
    //   364: invokevirtual 127	oicq/wlogin_sdk/tools/d:a	(ILjava/lang/String;Ljava/lang/String;)Z
    //   367: ifeq +48 -> 415
    //   370: aload_0
    //   371: aload 4
    //   373: invokevirtual 236	oicq/wlogin_sdk/tools/d:b	(Ljava/lang/String;)V
    //   376: aload_0
    //   377: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   380: invokevirtual 239	oicq/wlogin_sdk/tools/d:a	(J)V
    //   383: return
    //   384: astore 4
    //   386: new 97	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   393: ldc 215
    //   395: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 4
    //   400: invokevirtual 240	java/lang/Exception:toString	()Ljava/lang/String;
    //   403: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: ldc 37
    //   411: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: return
    //   415: ldc 242
    //   417: ldc 37
    //   419: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	d
    //   130	97	1	i	int
    //   281	2	2	l	long
    //   29	180	4	localObject1	Object
    //   233	15	4	localConnectException	java.net.ConnectException
    //   264	3	4	localThrowable	Throwable
    //   286	86	4	str	String
    //   384	15	4	localException	java.lang.Exception
    //   199	161	5	localObject2	Object
    //   206	18	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   56	178	233	java/net/ConnectException
    //   185	208	233	java/net/ConnectException
    //   208	216	233	java/net/ConnectException
    //   221	230	233	java/net/ConnectException
    //   291	383	233	java/net/ConnectException
    //   415	422	233	java/net/ConnectException
    //   0	14	264	java/lang/Throwable
    //   15	27	264	java/lang/Throwable
    //   31	56	264	java/lang/Throwable
    //   56	178	264	java/lang/Throwable
    //   185	208	264	java/lang/Throwable
    //   208	216	264	java/lang/Throwable
    //   221	230	264	java/lang/Throwable
    //   235	263	264	java/lang/Throwable
    //   274	282	264	java/lang/Throwable
    //   291	383	264	java/lang/Throwable
    //   386	414	264	java/lang/Throwable
    //   415	422	264	java/lang/Throwable
    //   56	178	384	java/lang/Exception
    //   185	208	384	java/lang/Exception
    //   208	216	384	java/lang/Exception
    //   221	230	384	java/lang/Exception
    //   291	383	384	java/lang/Exception
    //   415	422	384	java/lang/Exception
  }
  
  public c a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        util.LOGI("[pubkey]parseJsonResult empty json", "");
        return null;
      }
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("QuerySpan", 0);
        paramString = paramString.optJSONObject("PubKeyMeta");
        if (paramString != null) {
          return new c(i, paramString.optInt("KeyVer", 0), paramString.optString("PubKey"), paramString.optString("PubKeySign"));
        }
        util.LOGI("[pubkey]parseJsonResult empty keyMetaObj", "");
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          util.LOGI("[pubkey]parseJsonResult exception" + paramString.toString(), "");
        }
      }
      paramString = null;
    }
    catch (Throwable paramString)
    {
      util.printThrowable(paramString, "parseJsonResult");
      return null;
    }
    return paramString;
  }
  
  public void a(long paramLong)
  {
    try
    {
      Object localObject = this.a;
      localObject = u.u;
      if (localObject != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).edit();
        ((SharedPreferences.Editor)localObject).putLong("pubKeyTime", paramLong);
        ((SharedPreferences.Editor)localObject).commit();
        util.LOGI("[pubkey]saveReqTimeToSp time:" + paramLong, "");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "saveReqTimeToSp");
    }
  }
  
  public void a(u paramu)
  {
    this.a = paramu;
  }
  
  /* Error */
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 97	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   7: sipush 305
    //   10: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   13: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: iload_1
    //   17: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   20: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore_2
    //   31: ldc_w 326
    //   34: invokestatic 332	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   37: new 334	java/security/spec/X509EncodedKeySpec
    //   40: dup
    //   41: ldc_w 336
    //   44: iconst_0
    //   45: invokestatic 342	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   48: invokespecial 343	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   51: invokevirtual 347	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   54: astore 5
    //   56: ldc_w 349
    //   59: invokestatic 354	java/security/Signature:getInstance	(Ljava/lang/String;)Ljava/security/Signature;
    //   62: astore 6
    //   64: aload 6
    //   66: aload 5
    //   68: invokevirtual 358	java/security/Signature:initVerify	(Ljava/security/PublicKey;)V
    //   71: aload 6
    //   73: aload_2
    //   74: invokevirtual 361	java/lang/String:getBytes	()[B
    //   77: invokevirtual 364	java/security/Signature:update	([B)V
    //   80: aload 6
    //   82: aload_3
    //   83: iconst_0
    //   84: invokestatic 342	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   87: invokevirtual 368	java/security/Signature:verify	([B)Z
    //   90: istore 4
    //   92: new 97	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 370
    //   102: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: iload 4
    //   107: invokevirtual 373	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: ldc 37
    //   115: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: iload 4
    //   120: ireturn
    //   121: astore_2
    //   122: new 97	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 375
    //   132: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_2
    //   136: invokevirtual 376	java/security/NoSuchAlgorithmException:toString	()Ljava/lang/String;
    //   139: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: ldc 37
    //   147: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: goto +107 -> 257
    //   153: astore_2
    //   154: new 97	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 375
    //   164: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 377	java/security/spec/InvalidKeySpecException:toString	()Ljava/lang/String;
    //   171: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: ldc 37
    //   179: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: goto +75 -> 257
    //   185: astore_2
    //   186: aload_2
    //   187: ldc_w 379
    //   190: invokestatic 64	oicq/wlogin_sdk/tools/util:printThrowable	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   193: goto +64 -> 257
    //   196: astore_2
    //   197: new 97	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 375
    //   207: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 380	java/security/InvalidKeyException:toString	()Ljava/lang/String;
    //   214: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: ldc 37
    //   222: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: goto +32 -> 257
    //   228: astore_2
    //   229: new 97	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 375
    //   239: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_2
    //   243: invokevirtual 381	java/security/SignatureException:toString	()Ljava/lang/String;
    //   246: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: ldc 37
    //   254: invokestatic 43	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: iconst_0
    //   258: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	d
    //   0	259	1	paramInt	int
    //   0	259	2	paramString1	String
    //   0	259	3	paramString2	String
    //   90	29	4	bool	boolean
    //   54	13	5	localPublicKey	java.security.PublicKey
    //   62	19	6	localSignature	java.security.Signature
    // Exception table:
    //   from	to	target	type
    //   31	118	121	java/security/NoSuchAlgorithmException
    //   31	118	153	java/security/spec/InvalidKeySpecException
    //   0	31	185	java/lang/Throwable
    //   31	118	185	java/lang/Throwable
    //   122	150	185	java/lang/Throwable
    //   154	182	185	java/lang/Throwable
    //   197	225	185	java/lang/Throwable
    //   229	257	185	java/lang/Throwable
    //   31	118	196	java/security/InvalidKeyException
    //   31	118	228	java/security/SignatureException
  }
  
  public void b()
  {
    new Thread(new a(), "PubKeyRotater").start();
  }
  
  public void b(String paramString)
  {
    try
    {
      Object localObject = this.a;
      localObject = u.u;
      if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).edit();
        ((SharedPreferences.Editor)localObject).putString("pubKey", paramString);
        ((SharedPreferences.Editor)localObject).commit();
        localObject = new StringBuilder().append("[pubkey]savePubKeyToFile json:");
        if (paramString == null) {
          break label89;
        }
      }
      label89:
      for (int i = paramString.length();; i = 0)
      {
        util.LOGI(i, "");
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      util.printThrowable(paramString, "savePubKeyToFile");
    }
  }
  
  public Pair<String, Integer> c()
  {
    try
    {
      Object localObject = e();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        util.LOGI("[pubkey]syncGetPubKey json is empty");
        return null;
      }
      localObject = a((String)localObject);
      if (localObject == null)
      {
        util.LOGI("[pubkey]syncGetPubKey value is null");
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "syncGetPubKey");
      return null;
    }
    if (!a(localThrowable.b, localThrowable.c, localThrowable.d))
    {
      util.LOGI("[pubkey]syncGetPubKey key sign not right");
      return null;
    }
    Pair localPair = new Pair(localThrowable.c, Integer.valueOf(localThrowable.b));
    return localPair;
  }
  
  public long d()
  {
    for (;;)
    {
      try
      {
        Object localObject = this.a;
        localObject = u.u;
        if (localObject != null)
        {
          l = ((Context)localObject).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).getLong("pubKeyTime", 0L);
          util.LOGI("[pubkey]getReqTimeFromSp " + l, "");
          return l;
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "getReqTimeFromSp");
        return 0L;
      }
      long l = 0L;
    }
  }
  
  public String e()
  {
    try
    {
      Object localObject1 = this.a;
      Object localObject2 = u.u;
      localObject1 = "";
      if (localObject2 != null) {
        localObject1 = ((Context)localObject2).getSharedPreferences("WLOGIN_DEVICE_INFO", 4).getString("pubKey", "");
      }
      localObject2 = new StringBuilder().append("[pubkey]getPubKeyFromFile ");
      if (localObject1 != null) {}
      for (int i = ((String)localObject1).length();; i = 0)
      {
        util.LOGI(i, "");
        return localObject1;
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "savePubKeyToFile");
    }
  }
  
  public static final class a
    implements Runnable
  {
    public void run()
    {
      util.LOGI("[pubkey]start check local pub key", "");
      d.a(d.a());
    }
  }
  
  private static final class b
  {
    public static final d a = new d(null);
  }
  
  public static class c
  {
    public int a;
    public int b;
    public String c;
    public String d;
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString1;
      this.d = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.d
 * JD-Core Version:    0.7.0.1
 */