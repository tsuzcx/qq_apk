package com.tencent.liteav.basic.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  private static final String a;
  private static a b;
  private int c;
  private List<String> d;
  private Map<String, a> e;
  private a f;
  private Set<String> g;
  private Handler h;
  private Context i;
  private String j;
  private String k;
  private int l;
  private long m;
  private boolean n;
  private boolean o;
  
  static
  {
    AppMethodBeat.i(146625);
    a = a.class.getSimpleName();
    b = null;
    AppMethodBeat.o(146625);
  }
  
  private a()
  {
    AppMethodBeat.i(146607);
    this.c = 1253488539;
    this.j = "";
    this.d = new ArrayList();
    this.e = new HashMap();
    this.g = new HashSet();
    AppMethodBeat.o(146607);
  }
  
  public static a a()
  {
    AppMethodBeat.i(146608);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      AppMethodBeat.o(146608);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(146608);
    }
  }
  
  private String a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146613);
    int i1;
    for (;;)
    {
      try
      {
        paramString = (HttpsURLConnection)new URL(paramString).openConnection();
        paramString.setDoInput(true);
        paramString.setDoOutput(true);
        paramString.setConnectTimeout(5000);
        paramString.setReadTimeout(5000);
        paramString.setRequestMethod("POST");
        if (paramMap != null)
        {
          paramMap = paramMap.entrySet().iterator();
          if (paramMap.hasNext())
          {
            localObject = (Map.Entry)paramMap.next();
            paramString.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
            continue;
          }
        }
        paramMap = new DataOutputStream(paramString.getOutputStream());
      }
      catch (Exception paramString)
      {
        TXCLog.i(a, "postDataThroughHttps->response exception: ");
        paramString = "";
        AppMethodBeat.o(146613);
        return paramString;
      }
      paramMap.write(paramArrayOfByte);
      paramMap.flush();
      paramMap.close();
      i1 = paramString.getResponseCode();
      TXCLog.i(a, "postDataThroughHttps->response code: ".concat(String.valueOf(i1)));
      if (i1 != 200) {
        break;
      }
      paramMap = paramString.getInputStream();
      paramArrayOfByte = new ByteArrayOutputStream();
      Object localObject = new byte[1024];
      for (;;)
      {
        i1 = paramMap.read((byte[])localObject, 0, 1024);
        if (i1 == -1) {
          break;
        }
        paramArrayOfByte.write((byte[])localObject, 0, i1);
      }
      paramArrayOfByte.flush();
      paramMap.close();
      paramString.disconnect();
      paramString = paramArrayOfByte.toString();
    }
    paramString = new Exception("response: ".concat(String.valueOf(i1)));
    AppMethodBeat.o(146613);
    throw paramString;
  }
  
  /* Error */
  private void a(b paramb)
  {
    // Byte code:
    //   0: ldc 226
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: ldc 228
    //   10: iconst_5
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: getfield 230	com/tencent/liteav/basic/log/a$b:h	Ljava/lang/String;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_1
    //   24: getfield 232	com/tencent/liteav/basic/log/a$b:g	Ljava/lang/String;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: aload_1
    //   31: getfield 234	com/tencent/liteav/basic/log/a$b:f	Ljava/lang/String;
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: aload_1
    //   38: getfield 236	com/tencent/liteav/basic/log/a$b:e	Ljava/lang/String;
    //   41: aastore
    //   42: dup
    //   43: iconst_4
    //   44: aload_1
    //   45: getfield 238	com/tencent/liteav/basic/log/a$b:c	Ljava/lang/String;
    //   48: aastore
    //   49: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 5
    //   54: invokestatic 248	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   57: invokevirtual 249	java/util/UUID:toString	()Ljava/lang/String;
    //   60: astore 7
    //   62: new 76	java/util/HashMap
    //   65: dup
    //   66: iconst_2
    //   67: invokespecial 251	java/util/HashMap:<init>	(I)V
    //   70: astore 6
    //   72: aload 6
    //   74: ldc 253
    //   76: aload_1
    //   77: getfield 255	com/tencent/liteav/basic/log/a$b:d	Ljava/lang/String;
    //   80: invokeinterface 259 3 0
    //   85: pop
    //   86: aload 6
    //   88: ldc_w 261
    //   91: ldc_w 263
    //   94: aload 7
    //   96: invokestatic 266	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   99: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokeinterface 259 3 0
    //   107: pop
    //   108: aload_0
    //   109: aload_1
    //   110: getfield 238	com/tencent/liteav/basic/log/a$b:c	Ljava/lang/String;
    //   113: invokespecial 268	com/tencent/liteav/basic/log/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_3
    //   117: aload_3
    //   118: ifnonnull +19 -> 137
    //   121: aload_0
    //   122: ldc_w 270
    //   125: ldc_w 272
    //   128: invokespecial 274	com/tencent/liteav/basic/log/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc 226
    //   133: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: aload_0
    //   138: aload_3
    //   139: putfield 276	com/tencent/liteav/basic/log/a:k	Ljava/lang/String;
    //   142: new 278	java/io/RandomAccessFile
    //   145: dup
    //   146: aload_0
    //   147: getfield 276	com/tencent/liteav/basic/log/a:k	Ljava/lang/String;
    //   150: ldc_w 280
    //   153: invokespecial 282	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: astore_3
    //   157: aload_3
    //   158: invokevirtual 286	java/io/RandomAccessFile:length	()J
    //   161: l2i
    //   162: newarray byte
    //   164: astore 8
    //   166: aload_3
    //   167: aload 8
    //   169: invokevirtual 289	java/io/RandomAccessFile:readFully	([B)V
    //   172: aload_0
    //   173: aload 7
    //   175: ldc_w 291
    //   178: ldc_w 293
    //   181: invokespecial 296	com/tencent/liteav/basic/log/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[B
    //   184: astore 4
    //   186: aload_0
    //   187: aload 7
    //   189: ldc_w 298
    //   192: new 300	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   199: aload_1
    //   200: getfield 238	com/tencent/liteav/basic/log/a$b:c	Ljava/lang/String;
    //   203: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 307
    //   209: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: aload 8
    //   217: invokespecial 311	com/tencent/liteav/basic/log/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)[B
    //   220: astore_1
    //   221: new 300	java/lang/StringBuilder
    //   224: dup
    //   225: ldc_w 313
    //   228: invokespecial 314	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: aload 7
    //   233: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 316
    //   239: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokevirtual 320	java/lang/String:getBytes	()[B
    //   248: astore 7
    //   250: aload_1
    //   251: arraylength
    //   252: aload 4
    //   254: arraylength
    //   255: iadd
    //   256: aload 7
    //   258: arraylength
    //   259: iadd
    //   260: newarray byte
    //   262: astore 8
    //   264: aload 4
    //   266: iconst_0
    //   267: aload 8
    //   269: iconst_0
    //   270: aload 4
    //   272: arraylength
    //   273: invokestatic 326	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   276: aload_1
    //   277: iconst_0
    //   278: aload 8
    //   280: aload 4
    //   282: arraylength
    //   283: aload_1
    //   284: arraylength
    //   285: invokestatic 326	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   288: aload 7
    //   290: iconst_0
    //   291: aload 8
    //   293: aload_1
    //   294: arraylength
    //   295: aload 4
    //   297: arraylength
    //   298: iadd
    //   299: aload 7
    //   301: arraylength
    //   302: invokestatic 326	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   305: new 328	org/json/JSONObject
    //   308: dup
    //   309: aload_0
    //   310: aload 5
    //   312: aload 6
    //   314: aload 8
    //   316: invokespecial 330	com/tencent/liteav/basic/log/a:a	(Ljava/lang/String;Ljava/util/Map;[B)Ljava/lang/String;
    //   319: invokespecial 331	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   322: astore_1
    //   323: aload_1
    //   324: ldc_w 333
    //   327: invokevirtual 337	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   330: istore_2
    //   331: aload_1
    //   332: ldc_w 339
    //   335: invokevirtual 343	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   338: astore 4
    //   340: getstatic 53	com/tencent/liteav/basic/log/a:a	Ljava/lang/String;
    //   343: new 300	java/lang/StringBuilder
    //   346: dup
    //   347: ldc_w 345
    //   350: invokespecial 314	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   353: aload_1
    //   354: invokevirtual 346	org/json/JSONObject:toString	()Ljava/lang/String;
    //   357: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 162	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: iload_2
    //   367: ifne +25 -> 392
    //   370: aload_0
    //   371: aload 4
    //   373: ldc_w 348
    //   376: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   379: invokespecial 353	com/tencent/liteav/basic/log/a:a	(Ljava/lang/String;)V
    //   382: aload_3
    //   383: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   386: ldc 226
    //   388: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   391: return
    //   392: aload_0
    //   393: ldc_w 356
    //   396: iload_2
    //   397: invokestatic 191	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   400: invokespecial 274	com/tencent/liteav/basic/log/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: goto -21 -> 382
    //   406: astore 4
    //   408: aload_3
    //   409: astore_1
    //   410: aload 4
    //   412: astore_3
    //   413: aload_0
    //   414: ldc_w 356
    //   417: aload_3
    //   418: invokevirtual 357	java/lang/Exception:toString	()Ljava/lang/String;
    //   421: invokespecial 274	com/tencent/liteav/basic/log/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: aload_1
    //   425: ifnull +7 -> 432
    //   428: aload_1
    //   429: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   432: ldc 226
    //   434: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: return
    //   438: astore_1
    //   439: ldc 226
    //   441: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   444: return
    //   445: astore_1
    //   446: ldc 226
    //   448: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: return
    //   452: astore_1
    //   453: aconst_null
    //   454: astore_3
    //   455: aload_3
    //   456: ifnull +7 -> 463
    //   459: aload_3
    //   460: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   463: ldc 226
    //   465: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   468: aload_1
    //   469: athrow
    //   470: astore_3
    //   471: goto -8 -> 463
    //   474: astore_1
    //   475: goto -20 -> 455
    //   478: astore 4
    //   480: aload_1
    //   481: astore_3
    //   482: aload 4
    //   484: astore_1
    //   485: goto -30 -> 455
    //   488: astore_3
    //   489: aload 4
    //   491: astore_1
    //   492: goto -79 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	this	a
    //   0	495	1	paramb	b
    //   330	67	2	i1	int
    //   116	344	3	localObject1	Object
    //   470	1	3	localException1	Exception
    //   481	1	3	localb	b
    //   488	1	3	localException2	Exception
    //   6	366	4	localObject2	Object
    //   406	5	4	localException3	Exception
    //   478	12	4	localObject3	Object
    //   52	259	5	str	String
    //   70	243	6	localHashMap	HashMap
    //   60	240	7	localObject4	Object
    //   164	151	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   157	366	406	java/lang/Exception
    //   370	382	406	java/lang/Exception
    //   392	403	406	java/lang/Exception
    //   382	386	438	java/lang/Exception
    //   428	432	445	java/lang/Exception
    //   8	117	452	finally
    //   121	131	452	finally
    //   137	157	452	finally
    //   459	463	470	java/lang/Exception
    //   157	366	474	finally
    //   370	382	474	finally
    //   392	403	474	finally
    //   413	424	478	finally
    //   8	117	488	java/lang/Exception
    //   121	131	488	java/lang/Exception
    //   137	157	488	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(146612);
    for (;;)
    {
      StringBuilder localStringBuilder1;
      int i1;
      try
      {
        localStringBuilder1 = new StringBuilder();
        i1 = 0;
        if (i1 < this.d.size()) {
          if (i1 != this.d.size() - 1) {
            localStringBuilder1.append((String)this.d.get(i1)).append(",");
          } else {
            localStringBuilder1.append((String)this.d.get(i1));
          }
        }
      }
      catch (Exception paramString)
      {
        a("reportUploadResult", paramString.toString());
        AppMethodBeat.o(146612);
        return;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      Object localObject1 = this.g.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (localStringBuilder2.length() != 0) {
          localStringBuilder2.append(",");
        }
        localStringBuilder2.append((String)localObject2);
      }
      localObject1 = String.format("Android:%s :%s :%s", new Object[] { TXCCommonUtil.getSDKVersionStr(), b.c(), b.d() });
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("appid", this.c);
      ((JSONObject)localObject2).put("sdkappid", this.l);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("fileurl", paramString);
      localJSONObject.put("desc", localObject1);
      localJSONObject.put("userid", localStringBuilder2);
      localJSONObject.put("logkey", this.j);
      localJSONObject.put("file_list", localStringBuilder1.toString());
      ((JSONObject)localObject2).put("data", localJSONObject);
      paramString = new JSONObject(a("https://avc.qcloud.com/log/report.php", null, ((JSONObject)localObject2).toString().getBytes("utf-8")));
      TXCLog.i(a, "reportUploadResult->rsp  " + paramString.toString());
      this.m = System.currentTimeMillis();
      this.e.clear();
      if ((this.f != null) && (this.f.b != null)) {
        this.e.put(this.f.b, this.f);
      }
      d();
      new File(this.k).delete();
      AppMethodBeat.o(146612);
      return;
      i1 += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146619);
    TXCLog.w(a, "log upload " + paramString1 + " catch error " + paramString2);
    AppMethodBeat.o(146619);
  }
  
  /* Error */
  private void a(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 454
    //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 438	java/io/File
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 439	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: new 456	java/util/zip/ZipOutputStream
    //   21: dup
    //   22: new 458	java/io/FileOutputStream
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 461	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 462	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc_w 464
    //   40: invokevirtual 467	java/util/zip/ZipOutputStream:setComment	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: invokeinterface 468 1 0
    //   49: astore 5
    //   51: aconst_null
    //   52: astore_1
    //   53: aload 5
    //   55: invokeinterface 138 1 0
    //   60: ifeq +145 -> 205
    //   63: new 438	java/io/File
    //   66: dup
    //   67: aload 5
    //   69: invokeinterface 142 1 0
    //   74: checkcast 149	java/lang/String
    //   77: invokespecial 439	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore 6
    //   82: new 470	java/io/FileInputStream
    //   85: dup
    //   86: aload 6
    //   88: invokespecial 471	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_2
    //   92: aload 4
    //   94: new 473	java/util/zip/ZipEntry
    //   97: dup
    //   98: aload 6
    //   100: invokevirtual 476	java/io/File:getName	()Ljava/lang/String;
    //   103: invokespecial 477	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   106: invokevirtual 481	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   109: sipush 8192
    //   112: newarray byte
    //   114: astore_1
    //   115: aload_2
    //   116: aload_1
    //   117: invokevirtual 484	java/io/InputStream:read	([B)I
    //   120: istore_3
    //   121: iload_3
    //   122: iconst_m1
    //   123: if_icmpeq +24 -> 147
    //   126: aload 4
    //   128: aload_1
    //   129: iconst_0
    //   130: iload_3
    //   131: invokevirtual 485	java/util/zip/ZipOutputStream:write	([BII)V
    //   134: goto -19 -> 115
    //   137: astore_1
    //   138: aload_2
    //   139: invokevirtual 213	java/io/InputStream:close	()V
    //   142: aload_2
    //   143: astore_1
    //   144: goto -91 -> 53
    //   147: aload_2
    //   148: invokevirtual 213	java/io/InputStream:close	()V
    //   151: aload_2
    //   152: astore_1
    //   153: goto -100 -> 53
    //   156: astore_1
    //   157: aload_2
    //   158: astore_1
    //   159: goto -106 -> 53
    //   162: astore_1
    //   163: aload_2
    //   164: astore_1
    //   165: goto -112 -> 53
    //   168: astore_1
    //   169: aload_2
    //   170: invokevirtual 213	java/io/InputStream:close	()V
    //   173: ldc_w 454
    //   176: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: aload 4
    //   184: astore_1
    //   185: getstatic 53	com/tencent/liteav/basic/log/a:a	Ljava/lang/String;
    //   188: ldc_w 487
    //   191: invokestatic 450	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_1
    //   195: invokevirtual 488	java/util/zip/ZipOutputStream:close	()V
    //   198: ldc_w 454
    //   201: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: return
    //   205: aload 4
    //   207: invokevirtual 488	java/util/zip/ZipOutputStream:close	()V
    //   210: ldc_w 454
    //   213: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: return
    //   217: astore_1
    //   218: ldc_w 454
    //   221: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: return
    //   225: astore_1
    //   226: ldc_w 454
    //   229: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: return
    //   233: astore_1
    //   234: aconst_null
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 488	java/util/zip/ZipOutputStream:close	()V
    //   240: ldc_w 454
    //   243: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_1
    //   247: athrow
    //   248: astore_2
    //   249: goto -76 -> 173
    //   252: astore_2
    //   253: goto -13 -> 240
    //   256: astore_1
    //   257: aload 4
    //   259: astore_2
    //   260: goto -24 -> 236
    //   263: astore 4
    //   265: aload_1
    //   266: astore_2
    //   267: aload 4
    //   269: astore_1
    //   270: goto -34 -> 236
    //   273: astore_1
    //   274: aload 5
    //   276: astore_1
    //   277: goto -92 -> 185
    //   280: astore_2
    //   281: aload_1
    //   282: astore 5
    //   284: aload_2
    //   285: astore_1
    //   286: aload 5
    //   288: astore_2
    //   289: goto -120 -> 169
    //   292: astore_2
    //   293: aload_1
    //   294: astore_2
    //   295: goto -157 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	a
    //   0	298	1	paramList	List<String>
    //   0	298	2	paramString	String
    //   120	11	3	i1	int
    //   33	225	4	localZipOutputStream	java.util.zip.ZipOutputStream
    //   263	5	4	localObject1	Object
    //   1	286	5	localObject2	Object
    //   80	19	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   92	115	137	java/lang/Exception
    //   115	121	137	java/lang/Exception
    //   126	134	137	java/lang/Exception
    //   147	151	156	java/lang/Exception
    //   138	142	162	java/lang/Exception
    //   92	115	168	finally
    //   115	121	168	finally
    //   126	134	168	finally
    //   35	51	181	java/io/FileNotFoundException
    //   53	82	181	java/io/FileNotFoundException
    //   138	142	181	java/io/FileNotFoundException
    //   147	151	181	java/io/FileNotFoundException
    //   169	173	181	java/io/FileNotFoundException
    //   173	181	181	java/io/FileNotFoundException
    //   205	210	217	java/lang/Exception
    //   194	198	225	java/lang/Exception
    //   18	35	233	finally
    //   169	173	248	java/lang/Exception
    //   236	240	252	java/lang/Exception
    //   35	51	256	finally
    //   53	82	256	finally
    //   138	142	256	finally
    //   147	151	256	finally
    //   169	173	256	finally
    //   173	181	256	finally
    //   185	194	263	finally
    //   18	35	273	java/io/FileNotFoundException
    //   82	92	280	finally
    //   82	92	292	java/lang/Exception
  }
  
  private boolean a(File paramFile)
  {
    bool2 = false;
    AppMethodBeat.i(146614);
    try
    {
      String str1 = TXCLog.getLogFilePath();
      String str2 = paramFile.getAbsolutePath();
      bool1 = bool2;
      if (paramFile.isFile())
      {
        bool1 = bool2;
        if (this.m < paramFile.lastModified())
        {
          bool1 = bool2;
          if (!str2.equalsIgnoreCase(str1))
          {
            paramFile = paramFile.getName();
            paramFile = paramFile.substring(paramFile.lastIndexOf(".") + 1);
            bool1 = bool2;
            if (paramFile != null)
            {
              boolean bool3 = paramFile.equalsIgnoreCase("xlog");
              bool1 = bool2;
              if (bool3) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
    AppMethodBeat.o(146614);
    return bool1;
  }
  
  private byte[] a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(146617);
    paramString1 = ("--" + paramString1 + "\r\nContent-Disposition: form-data; name=\"" + paramString2 + "\"\r\n\r\n" + paramString3 + "\r\n").getBytes();
    AppMethodBeat.o(146617);
    return paramString1;
  }
  
  private byte[] a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(146618);
    paramString1 = ("--" + paramString1 + "\r\nContent-Disposition: form-data; name=\"" + paramString2 + "\"; filename=\"" + paramString3 + "\"\r\nContent-Type: application/octet-stream\"\r\n\r\n").getBytes();
    paramString2 = new byte[paramString1.length + paramArrayOfByte.length + 2];
    System.arraycopy(paramString1, 0, paramString2, 0, paramString1.length);
    System.arraycopy(paramArrayOfByte, 0, paramString2, paramString1.length, paramArrayOfByte.length);
    System.arraycopy("\r\n".getBytes(), 0, paramString2, paramString1.length + paramArrayOfByte.length, 2);
    AppMethodBeat.o(146618);
    return paramString2;
  }
  
  private String b(String paramString)
  {
    AppMethodBeat.i(146615);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.e.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = (String)((Map.Entry)localObject2).getKey();
      TXCLog.d(a, "ready to upload : " + this.m + ", " + (String)localObject3 + "\n");
      localObject3 = new File((String)localObject3);
      if (((File)localObject3).exists())
      {
        localObject3 = ((File)localObject3).listFiles();
        if (localObject3 != null)
        {
          int i2 = localObject3.length;
          int i1 = 0;
          while (i1 < i2)
          {
            File localFile = localObject3[i1];
            TXCLog.d(a, "ready to upload : " + localFile.lastModified() + ", " + localFile.getAbsolutePath() + "\n");
            if (a(localFile))
            {
              this.d.add(localFile.getName());
              localArrayList.add(localFile.getAbsolutePath());
            }
            i1 += 1;
          }
          localObject2 = (a)((Map.Entry)localObject2).getValue();
          this.g.addAll(((a)localObject2).a);
        }
      }
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      TXCLog.d(a, "finally upload : " + (String)localObject2 + "\n");
    }
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(146615);
      return null;
    }
    localObject1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/log/tencent/temp/";
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    paramString = (String)localObject1 + "/" + paramString + ".zip";
    a(localArrayList, paramString);
    AppMethodBeat.o(146615);
    return paramString;
  }
  
  private void c()
  {
    AppMethodBeat.i(146610);
    b localb;
    try
    {
      if (this.n)
      {
        this.o = true;
        TXCLog.w(a, " user is in room delay upload after exit room");
        AppMethodBeat.o(146610);
        return;
      }
      if (this.e.isEmpty())
      {
        TXCLog.w(a, " log record is empty ignore start upload");
        AppMethodBeat.o(146610);
        return;
      }
      TXCLog.w(a, "start log upload " + this.l);
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("appid", this.c);
      ((JSONObject)localObject).put("sdkappid", this.l);
      localObject = a("https://avc.qcloud.com/log/appsign.php", null, ((JSONObject)localObject).toString().getBytes("utf-8"));
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label341;
      }
      localObject = new JSONObject((String)localObject);
      localb = new b();
      localb.a = ((JSONObject)localObject).getInt("retcode");
      localb.b = ((JSONObject)localObject).getString("errmsg");
      localb.c = ((JSONObject)localObject).getString("logkey");
      localb.d = ((JSONObject)localObject).getString("sign");
      localb.f = ((JSONObject)localObject).getString("bucket");
      localb.e = ((JSONObject)localObject).getString("path");
      localb.h = ((JSONObject)localObject).getString("region");
      localb.g = ((JSONObject)localObject).getString("cosAppid");
      TXCLog.i(a, "requestUploadSig->rsp  " + ((JSONObject)localObject).toString());
      if (localb.a == 0)
      {
        this.j = localb.c;
        a(localb);
        AppMethodBeat.o(146610);
        return;
      }
    }
    catch (Exception localException)
    {
      a("uploadLogFiles", localException.toString());
      AppMethodBeat.o(146610);
      return;
    }
    a("requestUploadSig", localb.b);
    AppMethodBeat.o(146610);
    return;
    label341:
    a("requestUploadSig", "upload sign failed");
    AppMethodBeat.o(146610);
  }
  
  private void d()
  {
    AppMethodBeat.i(146620);
    if (this.i != null) {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        localObject = this.e.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Map.Entry)((Iterator)localObject).next()).getValue();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("logPath", locala.b);
          localJSONObject.put("roomId", locala.c);
          localJSONObject.put("userList", locala.a());
          localJSONArray.put(localJSONObject);
        }
        AppMethodBeat.o(146620);
      }
      catch (Exception localException) {}
    } else {
      return;
    }
    Object localObject = this.i.getSharedPreferences("liteav_log_upload_config", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("liteav_log_upload_record", localException.toString());
    ((SharedPreferences.Editor)localObject).putInt("liteav_log_upload_appid", this.l);
    ((SharedPreferences.Editor)localObject).putLong("liteav_log_upload_time", this.m);
    ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(146620);
  }
  
  private void e()
  {
    int i1 = 0;
    AppMethodBeat.i(146621);
    try
    {
      if (this.i != null)
      {
        Object localObject = this.i.getSharedPreferences("liteav_log_upload_config", 0);
        this.l = ((SharedPreferences)localObject).getInt("liteav_log_upload_appid", 0);
        this.m = ((SharedPreferences)localObject).getLong("liteav_log_upload_time", 0L);
        localObject = ((SharedPreferences)localObject).getString("liteav_log_upload_record", "");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool)
        {
          AppMethodBeat.o(146621);
          return;
        }
        localObject = new JSONArray((String)localObject);
        while (i1 < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i1);
          a locala = new a();
          locala.c = localJSONObject.optInt("roomId", 0);
          locala.b = localJSONObject.optString("logPath");
          locala.a(localJSONObject.optString("userList"));
          if (!TextUtils.isEmpty(locala.b)) {
            this.e.put(locala.b, locala);
          }
          i1 += 1;
        }
      }
      AppMethodBeat.o(146621);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(146621);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(146622);
    if (this.h == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("logThread");
      localHandlerThread.start();
      this.h = new Handler(localHandlerThread.getLooper());
      this.h.post(new a.2(this));
    }
    AppMethodBeat.o(146622);
  }
  
  public void b()
  {
    try
    {
      AppMethodBeat.i(146609);
      f();
      this.h.postDelayed(new a.1(this), 30000L);
      AppMethodBeat.o(146609);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static class a
  {
    Set<String> a;
    String b;
    int c;
    
    public a()
    {
      AppMethodBeat.i(146597);
      this.a = new HashSet();
      AppMethodBeat.o(146597);
    }
    
    public String a()
    {
      AppMethodBeat.i(146598);
      Object localObject = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((StringBuilder)localObject).length() != 0) {
          ((StringBuilder)localObject).append(",");
        }
        ((StringBuilder)localObject).append(str);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(146598);
      return localObject;
    }
    
    public void a(String paramString)
    {
      AppMethodBeat.i(146599);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146599);
        return;
      }
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        this.a.add(localObject);
        i += 1;
      }
      AppMethodBeat.o(146599);
    }
  }
  
  static class b
  {
    int a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.basic.log.a
 * JD-Core Version:    0.7.0.1
 */