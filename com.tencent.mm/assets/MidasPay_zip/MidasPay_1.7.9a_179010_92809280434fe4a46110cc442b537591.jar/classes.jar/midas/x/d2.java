package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d2
  extends ob
{
  public static final String[] o = { "Td8qRx7IdbbSyw3K", "elddjmxNE2FK8cch", "n6QnJOTocDGX5dXR", "caUdsBbJ1oOxMbPy", "ehDFwSSDOFz3U1d3", "nmiFzdsTgUYGcMeg", "t3W6mdGCbIfFcwdR", "PLSeUfBBSgfDWAuA", "ayGzfJkNBZKE9UZf", "yVBtdRgAEx3EgG31" };
  public boolean g = false;
  public boolean h = false;
  public String i = "";
  public String j = "";
  public int k = -1;
  public String l = "";
  public String m = "";
  public o4 n = null;
  
  public d2(fc paramfc)
  {
    super(paramfc);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("hf_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("hf_info");
        if (paramJSONObject.has("hfpay_channelInfo"))
        {
          this.m = paramJSONObject.getString("hfpay_channelInfo");
          paramJSONObject = b();
          if (TextUtils.isEmpty(paramJSONObject)) {
            APLog.e("MonthInfo", "Cannot get decode key!");
          }
          this.m = n4.a(this.m, paramJSONObject);
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("OperatorBase = ");
        paramJSONObject.append(this.m);
        APLog.i("APGetExpressPayAns", paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  /* Error */
  public void b(JSONObject paramJSONObject)
    throws JSONException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 138
    //   3: invokevirtual 83	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore 7
    //   8: aload 7
    //   10: ldc 140
    //   12: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   15: ifeq +25 -> 40
    //   18: ldc 142
    //   20: aload 7
    //   22: ldc 140
    //   24: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +10 -> 40
    //   33: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   36: iconst_1
    //   37: invokevirtual 156	midas/x/c6:q	(Z)V
    //   40: aload 7
    //   42: ldc 158
    //   44: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   47: ifeq +35 -> 82
    //   50: ldc 142
    //   52: aload 7
    //   54: ldc 158
    //   56: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +13 -> 75
    //   65: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   68: iconst_1
    //   69: invokevirtual 161	midas/x/c6:s	(Z)V
    //   72: goto +10 -> 82
    //   75: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   78: iconst_0
    //   79: invokevirtual 161	midas/x/c6:s	(Z)V
    //   82: aload 7
    //   84: ldc 163
    //   86: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   89: ifeq +23 -> 112
    //   92: ldc 142
    //   94: aload 7
    //   96: ldc 163
    //   98: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: ifeq +8 -> 112
    //   107: aload_0
    //   108: iconst_1
    //   109: putfield 51	midas/x/d2:g	Z
    //   112: aload 7
    //   114: ldc 165
    //   116: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   119: ifeq +23 -> 142
    //   122: ldc 142
    //   124: aload 7
    //   126: ldc 165
    //   128: invokevirtual 168	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +8 -> 142
    //   137: aload_0
    //   138: iconst_1
    //   139: putfield 53	midas/x/d2:h	Z
    //   142: aload 7
    //   144: ldc 170
    //   146: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   149: ifeq +25 -> 174
    //   152: ldc 142
    //   154: aload 7
    //   156: ldc 170
    //   158: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +10 -> 174
    //   167: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   170: iconst_1
    //   171: invokevirtual 173	midas/x/c6:r	(Z)V
    //   174: aload 7
    //   176: ldc 175
    //   178: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   181: ifeq +25 -> 206
    //   184: aload 7
    //   186: ldc 175
    //   188: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore_1
    //   192: aload_1
    //   193: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifne +10 -> 206
    //   199: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   202: aload_1
    //   203: invokevirtual 179	midas/x/c6:N	(Ljava/lang/String;)V
    //   206: aload 7
    //   208: ldc 181
    //   210: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   213: ifeq +34 -> 247
    //   216: aload 7
    //   218: ldc 181
    //   220: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_1
    //   224: aload_1
    //   225: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +19 -> 247
    //   231: aload_1
    //   232: ldc 183
    //   234: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +10 -> 247
    //   240: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   243: iconst_0
    //   244: invokevirtual 185	midas/x/c6:i	(Z)V
    //   247: aload 7
    //   249: ldc 187
    //   251: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   254: ifeq +30 -> 284
    //   257: aload 7
    //   259: ldc 187
    //   261: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   264: astore 6
    //   266: aload 6
    //   268: astore_1
    //   269: aload 6
    //   271: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   274: ifeq +6 -> 280
    //   277: ldc 189
    //   279: astore_1
    //   280: aload_1
    //   281: invokestatic 194	midas/x/a2:c	(Ljava/lang/String;)V
    //   284: aload 7
    //   286: ldc 196
    //   288: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   291: ifeq +30 -> 321
    //   294: aload 7
    //   296: ldc 196
    //   298: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   301: astore 6
    //   303: aload 6
    //   305: astore_1
    //   306: aload 6
    //   308: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifeq +6 -> 317
    //   314: ldc 183
    //   316: astore_1
    //   317: aload_1
    //   318: invokestatic 198	midas/x/a2:b	(Ljava/lang/String;)V
    //   321: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   324: ldc 142
    //   326: invokevirtual 201	midas/x/c6:z	(Ljava/lang/String;)V
    //   329: aload 7
    //   331: ldc 203
    //   333: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   336: ifeq +36 -> 372
    //   339: aload 7
    //   341: ldc 203
    //   343: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: astore_1
    //   347: aload_1
    //   348: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   351: ifne +13 -> 364
    //   354: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   357: aload_1
    //   358: invokevirtual 201	midas/x/c6:z	(Ljava/lang/String;)V
    //   361: goto +11 -> 372
    //   364: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   367: ldc 142
    //   369: invokevirtual 201	midas/x/c6:z	(Ljava/lang/String;)V
    //   372: aload 7
    //   374: ldc 205
    //   376: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   379: ifeq +25 -> 404
    //   382: aload 7
    //   384: ldc 205
    //   386: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   389: invokestatic 210	midas/x/i:b	(Ljava/lang/String;)I
    //   392: istore_2
    //   393: iload_2
    //   394: ifeq +10 -> 404
    //   397: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   400: iload_2
    //   401: invokevirtual 213	midas/x/c6:e	(I)V
    //   404: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   407: iconst_1
    //   408: invokevirtual 215	midas/x/c6:j	(Z)V
    //   411: aload 7
    //   413: ldc 217
    //   415: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   418: ifeq +25 -> 443
    //   421: ldc 183
    //   423: aload 7
    //   425: ldc 217
    //   427: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   430: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +10 -> 443
    //   436: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   439: iconst_0
    //   440: invokevirtual 215	midas/x/c6:j	(Z)V
    //   443: aload 7
    //   445: ldc 219
    //   447: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   450: ifeq +30 -> 480
    //   453: aload 7
    //   455: ldc 219
    //   457: invokevirtual 222	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   460: istore_2
    //   461: iload_2
    //   462: ifeq +18 -> 480
    //   465: invokestatic 228	com/pay/tool/APAppDataInterface:singleton	()Lcom/pay/tool/APAppDataInterface;
    //   468: iload_2
    //   469: invokevirtual 231	com/pay/tool/APAppDataInterface:f	(I)V
    //   472: goto +8 -> 480
    //   475: astore_1
    //   476: aload_1
    //   477: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   480: aload 7
    //   482: ldc 233
    //   484: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   487: ifeq +30 -> 517
    //   490: aload 7
    //   492: ldc 233
    //   494: invokevirtual 222	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   497: istore_2
    //   498: iload_2
    //   499: ifeq +18 -> 517
    //   502: invokestatic 228	com/pay/tool/APAppDataInterface:singleton	()Lcom/pay/tool/APAppDataInterface;
    //   505: iload_2
    //   506: invokevirtual 234	com/pay/tool/APAppDataInterface:e	(I)V
    //   509: goto +8 -> 517
    //   512: astore_1
    //   513: aload_1
    //   514: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   517: aload 7
    //   519: ldc 236
    //   521: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   524: ifeq +30 -> 554
    //   527: aload 7
    //   529: ldc 236
    //   531: invokevirtual 222	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   534: istore_2
    //   535: iload_2
    //   536: ifeq +18 -> 554
    //   539: invokestatic 228	com/pay/tool/APAppDataInterface:singleton	()Lcom/pay/tool/APAppDataInterface;
    //   542: iload_2
    //   543: invokevirtual 239	com/pay/tool/APAppDataInterface:d	(I)V
    //   546: goto +8 -> 554
    //   549: astore_1
    //   550: aload_1
    //   551: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   554: aload 7
    //   556: ldc 241
    //   558: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   561: ifeq +417 -> 978
    //   564: aload 7
    //   566: ldc 241
    //   568: ldc 243
    //   570: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   573: astore_1
    //   574: aload 7
    //   576: ldc 247
    //   578: ldc 142
    //   580: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   583: astore 6
    //   585: aload 7
    //   587: ldc 249
    //   589: ldc 251
    //   591: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   594: astore 8
    //   596: new 116	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   603: astore 9
    //   605: aload 9
    //   607: ldc 253
    //   609: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload 9
    //   615: aload_1
    //   616: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 9
    //   622: ldc 255
    //   624: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 9
    //   630: aload 6
    //   632: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 9
    //   638: ldc 255
    //   640: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 9
    //   646: aload 8
    //   648: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: ldc_w 257
    //   655: aload 9
    //   657: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokestatic 259	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload_1
    //   664: ldc 243
    //   666: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   669: ifne +10 -> 679
    //   672: invokestatic 263	com/tencent/midas/comm/APLog:getLogInfo	()Lcom/tencent/midas/comm/APLogInfo;
    //   675: aload_1
    //   676: invokevirtual 268	com/tencent/midas/comm/APLogInfo:setLogParamFromServer	(Ljava/lang/String;)V
    //   679: aload 6
    //   681: invokestatic 210	midas/x/i:b	(Ljava/lang/String;)I
    //   684: istore_2
    //   685: aload 8
    //   687: invokestatic 210	midas/x/i:b	(Ljava/lang/String;)I
    //   690: istore_3
    //   691: new 270	midas/x/d6
    //   694: dup
    //   695: invokespecial 271	midas/x/d6:<init>	()V
    //   698: astore_1
    //   699: aload_1
    //   700: invokestatic 276	midas/x/a:r	()Lmidas/x/a;
    //   703: getfield 279	midas/x/a:d	Landroid/content/Context;
    //   706: ldc_w 281
    //   709: ldc 247
    //   711: iload_2
    //   712: invokestatic 285	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   715: invokevirtual 288	midas/x/d6:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   718: aload_1
    //   719: invokestatic 276	midas/x/a:r	()Lmidas/x/a;
    //   722: getfield 279	midas/x/a:d	Landroid/content/Context;
    //   725: ldc_w 281
    //   728: ldc 249
    //   730: iload_3
    //   731: invokestatic 285	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   734: invokevirtual 288	midas/x/d6:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   737: goto +43 -> 780
    //   740: astore_1
    //   741: new 116	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   748: astore 6
    //   750: aload 6
    //   752: ldc_w 290
    //   755: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 6
    //   761: aload_1
    //   762: invokevirtual 295	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   765: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: ldc_w 297
    //   772: aload 6
    //   774: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokestatic 109	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   780: aload 7
    //   782: ldc_w 299
    //   785: ldc 55
    //   787: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   790: astore 8
    //   792: aload 7
    //   794: ldc_w 301
    //   797: ldc 183
    //   799: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   802: astore 9
    //   804: aload 7
    //   806: ldc_w 303
    //   809: ldc 55
    //   811: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   814: astore 6
    //   816: aload 7
    //   818: ldc_w 305
    //   821: ldc 189
    //   823: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   826: invokestatic 210	midas/x/i:b	(Ljava/lang/String;)I
    //   829: putstatic 309	midas/x/p9:a	I
    //   832: aload 6
    //   834: astore_1
    //   835: aload 6
    //   837: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   840: ifne +42 -> 882
    //   843: new 116	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   850: astore_1
    //   851: aload_1
    //   852: invokestatic 315	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   855: invokevirtual 320	java/io/File:getPath	()Ljava/lang/String;
    //   858: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: aload_1
    //   863: ldc_w 322
    //   866: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload_1
    //   871: aload 6
    //   873: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload_1
    //   878: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: astore_1
    //   882: ldc 142
    //   884: aload 9
    //   886: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   889: ifeq +89 -> 978
    //   892: ldc_w 257
    //   895: ldc_w 324
    //   898: iconst_2
    //   899: anewarray 326	java/lang/Object
    //   902: dup
    //   903: iconst_0
    //   904: aload 8
    //   906: aastore
    //   907: dup
    //   908: iconst_1
    //   909: aload_1
    //   910: aastore
    //   911: invokestatic 330	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   914: invokestatic 259	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   917: invokestatic 336	midas/x/p4:p	()Lmidas/x/p4;
    //   920: invokevirtual 339	midas/x/p4:e	()Lmidas/x/o4;
    //   923: getfield 344	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
    //   926: getfield 349	com/pay/api/request/APBaseRequest:openId	Ljava/lang/String;
    //   929: aload 8
    //   931: aload_1
    //   932: invokestatic 352	midas/x/p9:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   935: goto +43 -> 978
    //   938: astore_1
    //   939: new 116	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   946: astore 6
    //   948: aload 6
    //   950: ldc_w 354
    //   953: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload 6
    //   959: aload_1
    //   960: invokevirtual 295	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   963: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: ldc_w 297
    //   970: aload 6
    //   972: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokestatic 109	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   978: aload 7
    //   980: ldc_w 356
    //   983: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   986: ifeq +44 -> 1030
    //   989: ldc 183
    //   991: aload 7
    //   993: ldc_w 356
    //   996: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   999: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1002: ifeq +13 -> 1015
    //   1005: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1008: iconst_0
    //   1009: invokevirtual 358	midas/x/c6:k	(Z)V
    //   1012: goto +18 -> 1030
    //   1015: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1018: iconst_1
    //   1019: invokevirtual 358	midas/x/c6:k	(Z)V
    //   1022: goto +8 -> 1030
    //   1025: astore_1
    //   1026: aload_1
    //   1027: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   1030: aload 7
    //   1032: ldc_w 360
    //   1035: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1038: ifeq +35 -> 1073
    //   1041: aload 7
    //   1043: ldc_w 360
    //   1046: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1049: invokestatic 365	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1052: invokevirtual 369	java/lang/Long:longValue	()J
    //   1055: lstore 4
    //   1057: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1060: lload 4
    //   1062: invokevirtual 372	midas/x/c6:a	(J)V
    //   1065: goto +8 -> 1073
    //   1068: astore_1
    //   1069: aload_1
    //   1070: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   1073: ldc 138
    //   1075: ldc_w 374
    //   1078: invokestatic 131	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1081: aload 7
    //   1083: ldc_w 376
    //   1086: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1089: ifeq +74 -> 1163
    //   1092: ldc 138
    //   1094: ldc_w 378
    //   1097: invokestatic 131	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1100: aload 7
    //   1102: ldc_w 376
    //   1105: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1108: invokestatic 210	midas/x/i:b	(Ljava/lang/String;)I
    //   1111: istore_2
    //   1112: new 116	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1119: astore_1
    //   1120: aload_1
    //   1121: ldc_w 380
    //   1124: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload_1
    //   1129: iload_2
    //   1130: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1133: pop
    //   1134: ldc 138
    //   1136: aload_1
    //   1137: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1140: invokestatic 131	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1143: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1146: iload_2
    //   1147: invokevirtual 385	midas/x/c6:b	(I)V
    //   1150: goto +20 -> 1170
    //   1153: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1156: iconst_0
    //   1157: invokevirtual 385	midas/x/c6:b	(I)V
    //   1160: goto +10 -> 1170
    //   1163: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1166: iconst_0
    //   1167: invokevirtual 385	midas/x/c6:b	(I)V
    //   1170: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1173: aload 7
    //   1175: ldc_w 387
    //   1178: ldc 55
    //   1180: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1183: invokevirtual 389	midas/x/c6:a	(Ljava/lang/String;)V
    //   1186: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1189: aload 7
    //   1191: ldc_w 391
    //   1194: ldc 142
    //   1196: invokevirtual 245	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1199: invokevirtual 394	midas/x/c6:u	(Ljava/lang/String;)V
    //   1202: aload 7
    //   1204: ldc_w 396
    //   1207: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1210: ifeq +20 -> 1230
    //   1213: invokestatic 276	midas/x/a:r	()Lmidas/x/a;
    //   1216: getfield 279	midas/x/a:d	Landroid/content/Context;
    //   1219: aload 7
    //   1221: ldc_w 396
    //   1224: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1227: invokestatic 401	midas/x/h8:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   1230: aload 7
    //   1232: ldc_w 403
    //   1235: invokevirtual 79	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1238: ifeq +47 -> 1285
    //   1241: aload 7
    //   1243: ldc_w 403
    //   1246: invokevirtual 89	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1249: astore_1
    //   1250: aload_1
    //   1251: invokestatic 408	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1254: istore_2
    //   1255: invokestatic 152	midas/x/c6:s0	()Lmidas/x/c6;
    //   1258: iload_2
    //   1259: invokevirtual 409	midas/x/c6:d	(I)V
    //   1262: new 270	midas/x/d6
    //   1265: dup
    //   1266: invokespecial 271	midas/x/d6:<init>	()V
    //   1269: invokestatic 276	midas/x/a:r	()Lmidas/x/a;
    //   1272: getfield 279	midas/x/a:d	Landroid/content/Context;
    //   1275: ldc_w 281
    //   1278: ldc_w 411
    //   1281: aload_1
    //   1282: invokevirtual 288	midas/x/d6:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1285: aload_0
    //   1286: invokevirtual 413	midas/x/d2:k	()V
    //   1289: return
    //   1290: astore_1
    //   1291: goto -138 -> 1153
    //   1294: astore_1
    //   1295: goto -10 -> 1285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1298	0	this	d2
    //   0	1298	1	paramJSONObject	JSONObject
    //   392	867	2	i1	int
    //   690	41	3	i2	int
    //   1055	6	4	l1	long
    //   264	707	6	localObject1	Object
    //   6	1236	7	localJSONObject	JSONObject
    //   594	336	8	str	String
    //   603	282	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   453	461	475	java/lang/Exception
    //   465	472	475	java/lang/Exception
    //   490	498	512	java/lang/Exception
    //   502	509	512	java/lang/Exception
    //   527	535	549	java/lang/Exception
    //   539	546	549	java/lang/Exception
    //   596	679	740	finally
    //   679	737	740	finally
    //   882	935	938	finally
    //   989	1012	1025	java/lang/Exception
    //   1015	1022	1025	java/lang/Exception
    //   1041	1065	1068	java/lang/Exception
    //   1092	1150	1290	java/lang/Exception
    //   1241	1285	1294	java/lang/Exception
  }
  
  public void c(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("goldcoupons_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("goldcoupons_info");
        if (paramJSONObject.has("is_dedute_bymon"))
        {
          if (paramJSONObject.getInt("is_dedute_bymon") == 0)
          {
            c6.s0().d(true);
            return;
          }
          c6.s0().d(false);
          return;
        }
        c6.s0().d(true);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void d(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("session_token");
      this.n.f.k = paramJSONObject;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void e(JSONObject paramJSONObject)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("hf_amt_allow");
      int i2 = localJSONArray.length();
      s6.d().a();
      int i1 = 0;
      while (i1 < i2)
      {
        String str = localJSONArray.get(i1).toString();
        s6.d().a(str);
        i1 += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      s6.d().a();
      localJSONException.printStackTrace();
      try
      {
        paramJSONObject = paramJSONObject.optString("hf_amt_show_info");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          s6.d().b(paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public void f(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getString("is_report").equals("0"))
      {
        c6.s0().h(false);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String g()
  {
    return this.i;
  }
  
  public void g(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInt("is_zy") == 1) {
        APAppDataInterface.singleton().e(true);
      } else {
        APAppDataInterface.singleton().e(false);
      }
      APAppDataInterface.singleton().e(true);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String h()
  {
    return this.j;
  }
  
  public void h(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("mb_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("mb_info");
        APLog.i("mb_info", paramJSONObject.toString());
        this.j = "";
        if (paramJSONObject.has("sms_info"))
        {
          this.j = paramJSONObject.getString("sms_info");
          if ((this.j != null) && (!this.j.equals(""))) {
            com.pay.paychannel.qdqb.APQDQBChannel.r = this.j;
          }
        }
        this.k = -1;
        if (paramJSONObject.has("remain")) {
          this.k = paramJSONObject.getInt("remain");
        }
        this.l = "";
        if (paramJSONObject.has("mb_only_sms")) {
          this.l = paramJSONObject.getString("mb_only_sms");
        }
        this.i = "";
        if (paramJSONObject.has("mburl")) {
          this.i = paramJSONObject.getString("mburl");
        }
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public String i()
  {
    return this.l;
  }
  
  public boolean i(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("mp");
    int i1 = paramJSONObject.getInt("firstsave_present_count");
    String str = paramJSONObject.getString("present_level");
    if ((i1 <= 0) && (TextUtils.isEmpty(str))) {
      return false;
    }
    d0.i().d(paramJSONObject);
    return true;
  }
  
  public int j()
  {
    return this.k;
  }
  
  public void j(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("real_session_id");
    String str = paramJSONObject.optString("real_session_type");
    c6 localc6 = c6.s0();
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "";
    }
    localc6.v(paramJSONObject);
    localObject = c6.s0();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "";
    }
    ((c6)localObject).w(paramJSONObject);
  }
  
  public final void k()
  {
    try
    {
      Object localObject = p4.p().e().b;
      if ((localObject != null) && (!TextUtils.isEmpty(((APBaseRequest)localObject).reserv)))
      {
        localObject = APTools.n(((APBaseRequest)localObject).reserv);
        if ((localObject != null) && ("1".equals((String)((HashMap)localObject).get("disableResultPage")))) {
          c6.s0().z("0");
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void k(JSONObject paramJSONObject)
  {
    String str = b();
    if (TextUtils.isEmpty(str)) {
      APLog.e("BuyGoods", "Cannot get decode key!");
    }
    r6.j().a(paramJSONObject, str);
  }
  
  public void l(JSONObject paramJSONObject)
  {
    q0 localq0 = new q0();
    localq0.a(paramJSONObject);
    localq0.b(paramJSONObject);
  }
  
  public void m(JSONObject paramJSONObject)
  {
    l.a().a(paramJSONObject);
  }
  
  public void n(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("out_trade_no"))
      {
        p4.p().e().a(paramJSONObject.getString("out_trade_no"));
        return;
      }
      p4.p().e().a("");
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void o(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("unicoupon_mpinfo"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("unicoupon_mpinfo");
        o.m().a(paramJSONObject);
        return;
      }
      APLog.i("resolveCouponMpInfo", "MpInfo has not unicoupon_mpinfo");
      o.m().b();
      return;
    }
    catch (Exception paramJSONObject)
    {
      APLog.i("resolveCouponMpInfo", paramJSONObject.toString());
      o.m().b();
    }
  }
  
  public void p(JSONObject paramJSONObject)
  {
    try
    {
      if (!TextUtils.isEmpty(paramJSONObject.getString("result_url")))
      {
        c6.s0().x(paramJSONObject.getString("result_url"));
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void q(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("service_update");
    if (paramJSONObject.has("update_months"))
    {
      String str = paramJSONObject.getString("update_months");
      g6.k().e(str);
    }
    if (paramJSONObject.has("update_price"))
    {
      paramJSONObject = paramJSONObject.getString("update_price");
      g6.k().f(paramJSONObject);
    }
  }
  
  public void r(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("wx_bind_qquin");
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      paramJSONObject = "";
    }
    p4.p().e().e.k = paramJSONObject;
  }
  
  public void s(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("wx_info")) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("wx_info");
      int i1 = paramJSONObject.optInt("wx_contract_signstate", -1);
      int i2 = paramJSONObject.optInt("wx_contract_buylimit");
      this.n.c.b(i1);
      this.n.c.a(i2);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d2
 * JD-Core Version:    0.7.0.1
 */