package midas.x;

import com.pay.tool.APAppDataInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dd
  extends cc
{
  public dd(lw paramlw)
  {
    super(paramlw);
  }
  
  private void t(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("recommend_list");
      int j = paramJSONObject.length();
      String[] arrayOfString = new String[j];
      int i = 0;
      while (i < j)
      {
        arrayOfString[i] = paramJSONObject.get(i).toString();
        i += 1;
      }
      hn.a().a(arrayOfString);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void u(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("user_info");
        String str2 = paramJSONObject.getString("uin");
        String str1 = paramJSONObject.getString("uin_type");
        int i = paramJSONObject.getInt("uin_len");
        int j = paramJSONObject.getInt("codeindex");
        if ((!str2.equals("")) && (j < i.length))
        {
          paramJSONObject = gh.b(str2, i[j]);
          if (paramJSONObject.length() >= i)
          {
            paramJSONObject = paramJSONObject.substring(0, i);
            this.h.d.k = paramJSONObject;
          }
        }
        else
        {
          this.h.d.l = str1;
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      paramJSONObject = "";
    }
  }
  
  private void v(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("mp");
      int i = paramJSONObject.getInt("firstsave_present_count");
      gd.a().a(i);
      paramJSONObject = paramJSONObject.getString("present_level");
      if ((paramJSONObject != null) && (!paramJSONObject.equals("null")))
      {
        fv.a(paramJSONObject, gd.a().b());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void w(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.getJSONObject("frindspay_info");
      ((JSONObject)localObject).getString("friendspay_url");
      paramJSONObject = ((JSONObject)localObject).getString("friendspay_title");
      String str = ((JSONObject)localObject).getString("friendspay_summay");
      localObject = ((JSONObject)localObject).getString("friendspay_gameimageurl");
      APAppDataInterface.singleton().m((String)localObject);
      APAppDataInterface.singleton().k(paramJSONObject);
      APAppDataInterface.singleton().l(str);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  /* Error */
  protected boolean a(kz paramkz)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 173	midas/x/kz:b	Ljava/lang/String;
    //   4: astore 5
    //   6: new 175	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 179
    //   19: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: aload 5
    //   27: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 185
    //   33: aload 6
    //   35: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 191	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: invokestatic 196	midas/x/em:b	()Lmidas/x/em;
    //   44: invokevirtual 200	midas/x/em:n	()Lmidas/x/el;
    //   47: getfield 203	midas/x/el:a	Lcom/pay/api/request/APBaseRequest;
    //   50: ifnull +1421 -> 1471
    //   53: invokestatic 196	midas/x/em:b	()Lmidas/x/em;
    //   56: invokevirtual 200	midas/x/em:n	()Lmidas/x/el;
    //   59: getfield 203	midas/x/el:a	Lcom/pay/api/request/APBaseRequest;
    //   62: instanceof 205
    //   65: ifne +6 -> 71
    //   68: goto +1403 -> 1471
    //   71: aload_0
    //   72: invokestatic 196	midas/x/em:b	()Lmidas/x/em;
    //   75: invokevirtual 200	midas/x/em:n	()Lmidas/x/el;
    //   78: putfield 102	midas/x/dd:h	Lmidas/x/el;
    //   81: new 17	org/json/JSONObject
    //   84: dup
    //   85: aload 5
    //   87: invokespecial 207	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   90: astore 6
    //   92: aload_0
    //   93: aload 6
    //   95: ldc 209
    //   97: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokestatic 214	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   103: putfield 218	midas/x/dd:j	I
    //   106: aload_0
    //   107: aload 6
    //   109: ldc 220
    //   111: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 221	midas/x/dd:k	Ljava/lang/String;
    //   117: aload_0
    //   118: getfield 218	midas/x/dd:j	I
    //   121: ifne +1190 -> 1311
    //   124: aload 6
    //   126: ldc 223
    //   128: invokevirtual 61	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   131: astore 7
    //   133: aload 7
    //   135: ldc 225
    //   137: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   140: ifeq +21 -> 161
    //   143: aload 7
    //   145: ldc 225
    //   147: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 5
    //   152: aload 5
    //   154: invokestatic 214	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   157: istore_2
    //   158: goto +5 -> 163
    //   161: iconst_0
    //   162: istore_2
    //   163: aload 7
    //   165: ldc 146
    //   167: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   170: ifeq +9 -> 179
    //   173: aload_0
    //   174: aload 7
    //   176: invokespecial 231	midas/x/dd:w	(Lorg/json/JSONObject;)V
    //   179: ldc 233
    //   181: aload_0
    //   182: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   185: getfield 203	midas/x/el:a	Lcom/pay/api/request/APBaseRequest;
    //   188: getfield 238	com/pay/api/request/APBaseRequest:acctType	Ljava/lang/String;
    //   191: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +60 -> 254
    //   197: aload_0
    //   198: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   201: getfield 241	midas/x/el:b	Lmidas/x/et;
    //   204: checkcast 243	midas/x/ex
    //   207: astore 5
    //   209: aload 5
    //   211: aload 7
    //   213: ldc 245
    //   215: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   218: putfield 247	midas/x/ex:a	Ljava/lang/String;
    //   221: aload 5
    //   223: aload 7
    //   225: ldc 249
    //   227: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: putfield 250	midas/x/ex:b	Ljava/lang/String;
    //   233: aload 5
    //   235: aload 7
    //   237: ldc 252
    //   239: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: putfield 255	midas/x/ex:e	Ljava/lang/String;
    //   245: aload 5
    //   247: iload_2
    //   248: putfield 257	midas/x/ex:h	I
    //   251: goto +57 -> 308
    //   254: aload_0
    //   255: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   258: getfield 241	midas/x/el:b	Lmidas/x/et;
    //   261: checkcast 259	midas/x/eu
    //   264: astore 5
    //   266: aload 5
    //   268: aload 7
    //   270: ldc 245
    //   272: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: putfield 260	midas/x/eu:a	Ljava/lang/String;
    //   278: aload 5
    //   280: aload 7
    //   282: ldc 249
    //   284: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   287: putfield 261	midas/x/eu:b	Ljava/lang/String;
    //   290: aload 5
    //   292: aload 7
    //   294: ldc 252
    //   296: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: putfield 262	midas/x/eu:e	Ljava/lang/String;
    //   302: aload 5
    //   304: iload_2
    //   305: putfield 263	midas/x/eu:h	I
    //   308: aload 7
    //   310: ldc_w 265
    //   313: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 5
    //   318: goto +7 -> 325
    //   321: ldc 79
    //   323: astore 5
    //   325: aload_0
    //   326: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   329: getfield 268	midas/x/el:e	Lmidas/x/fa;
    //   332: aload 5
    //   334: putfield 272	midas/x/fa:j	Ljava/lang/String;
    //   337: aload_0
    //   338: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   341: getfield 268	midas/x/el:e	Lmidas/x/fa;
    //   344: aload 5
    //   346: putfield 273	midas/x/fa:k	Ljava/lang/String;
    //   349: aload_0
    //   350: invokevirtual 276	midas/x/dd:X	()Ljava/lang/String;
    //   353: astore 5
    //   355: aload 5
    //   357: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifeq +12 -> 372
    //   363: ldc_w 284
    //   366: ldc_w 286
    //   369: invokestatic 288	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_0
    //   373: aload 7
    //   375: invokevirtual 290	midas/x/dd:b	(Lorg/json/JSONObject;)V
    //   378: aload 7
    //   380: ldc_w 292
    //   383: aload 5
    //   385: invokestatic 297	midas/x/ek:d	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   388: ldc_w 299
    //   391: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   394: ifeq +17 -> 411
    //   397: aload_0
    //   398: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   401: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   404: iconst_1
    //   405: putfield 302	midas/x/ez:d	Z
    //   408: goto +14 -> 422
    //   411: aload_0
    //   412: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   415: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   418: iconst_0
    //   419: putfield 302	midas/x/ez:d	Z
    //   422: aload 7
    //   424: ldc_w 304
    //   427: aload 5
    //   429: invokestatic 297	midas/x/ek:d	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   432: ldc_w 299
    //   435: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   438: ifeq +17 -> 455
    //   441: aload_0
    //   442: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   445: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   448: iconst_1
    //   449: putfield 307	midas/x/ez:c	Z
    //   452: goto +14 -> 466
    //   455: aload_0
    //   456: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   459: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   462: iconst_0
    //   463: putfield 307	midas/x/ez:c	Z
    //   466: aload 7
    //   468: ldc_w 309
    //   471: aload 5
    //   473: invokestatic 297	midas/x/ek:d	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   476: astore 8
    //   478: aload_0
    //   479: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   482: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   485: iconst_0
    //   486: putfield 311	midas/x/ez:e	Z
    //   489: aload 8
    //   491: ldc_w 299
    //   494: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   497: ifeq +17 -> 514
    //   500: aload_0
    //   501: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   504: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   507: iconst_1
    //   508: putfield 311	midas/x/ez:e	Z
    //   511: goto +14 -> 525
    //   514: aload_0
    //   515: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   518: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   521: iconst_0
    //   522: putfield 311	midas/x/ez:e	Z
    //   525: new 175	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   532: astore 8
    //   534: aload 8
    //   536: ldc_w 313
    //   539: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 8
    //   545: aload_0
    //   546: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   549: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   552: getfield 311	midas/x/ez:e	Z
    //   555: invokevirtual 316	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: ldc_w 318
    //   562: aload 8
    //   564: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 320	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload_0
    //   571: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   574: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   577: iconst_0
    //   578: putfield 322	midas/x/ez:b	Z
    //   581: aload 7
    //   583: ldc_w 324
    //   586: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   589: ifeq +31 -> 620
    //   592: aload 7
    //   594: ldc_w 324
    //   597: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   600: ldc_w 299
    //   603: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   606: ifeq +14 -> 620
    //   609: aload_0
    //   610: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   613: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   616: iconst_1
    //   617: putfield 322	midas/x/ez:b	Z
    //   620: aload 7
    //   622: ldc_w 326
    //   625: aload 5
    //   627: invokestatic 297	midas/x/ek:d	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   630: astore 8
    //   632: aload 8
    //   634: invokestatic 214	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   637: istore_2
    //   638: goto +5 -> 643
    //   641: iconst_0
    //   642: istore_2
    //   643: aload_0
    //   644: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   647: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   650: iload_2
    //   651: putfield 329	midas/x/ez:g	I
    //   654: invokestatic 334	midas/x/fy:a	()Lmidas/x/fy;
    //   657: astore 8
    //   659: aload 7
    //   661: ldc_w 336
    //   664: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   667: ifeq +9 -> 676
    //   670: aload_0
    //   671: aload 7
    //   673: invokevirtual 338	midas/x/dd:e	(Lorg/json/JSONObject;)V
    //   676: new 175	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   683: astore 9
    //   685: aload 9
    //   687: ldc_w 340
    //   690: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 9
    //   696: aload_0
    //   697: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   700: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   703: getfield 342	midas/x/ez:m	Ljava/lang/String;
    //   706: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: ldc_w 318
    //   713: aload 9
    //   715: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 320	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: aload 7
    //   723: ldc_w 344
    //   726: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   729: istore_3
    //   730: iload_3
    //   731: ifeq +16 -> 747
    //   734: aload 8
    //   736: aload 7
    //   738: ldc_w 344
    //   741: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   744: invokevirtual 346	midas/x/fy:h	(Ljava/lang/String;)V
    //   747: aload 7
    //   749: ldc 121
    //   751: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   754: ifeq +743 -> 1497
    //   757: aload_0
    //   758: aload 7
    //   760: invokevirtual 350	midas/x/dd:f	(Lorg/json/JSONObject;)Z
    //   763: istore_3
    //   764: goto +3 -> 767
    //   767: aload 7
    //   769: ldc_w 352
    //   772: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   775: ifeq +9 -> 784
    //   778: aload_0
    //   779: aload 7
    //   781: invokevirtual 354	midas/x/dd:d	(Lorg/json/JSONObject;)V
    //   784: aload 7
    //   786: ldc_w 356
    //   789: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   792: ifeq +9 -> 801
    //   795: aload_0
    //   796: aload 7
    //   798: invokevirtual 358	midas/x/dd:a	(Lorg/json/JSONObject;)V
    //   801: aload 7
    //   803: ldc_w 360
    //   806: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   809: ifeq +17 -> 826
    //   812: invokestatic 365	midas/x/o:a	()Lmidas/x/o;
    //   815: aload 7
    //   817: ldc_w 360
    //   820: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   823: invokevirtual 367	midas/x/o:a	(Ljava/lang/String;)V
    //   826: aload 7
    //   828: ldc_w 369
    //   831: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   834: ifeq +190 -> 1024
    //   837: aload 7
    //   839: ldc_w 369
    //   842: invokevirtual 61	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   845: astore 8
    //   847: aload 8
    //   849: ldc_w 371
    //   852: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   855: ifne +47 -> 902
    //   858: aload 8
    //   860: ldc_w 373
    //   863: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   866: ifne +36 -> 902
    //   869: aload 8
    //   871: ldc_w 375
    //   874: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   877: ifne +25 -> 902
    //   880: aload 8
    //   882: ldc_w 377
    //   885: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   888: ifne +14 -> 902
    //   891: aload 8
    //   893: ldc_w 379
    //   896: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   899: ifeq +16 -> 915
    //   902: invokestatic 384	midas/x/ac:a	()Lmidas/x/ac;
    //   905: aload 8
    //   907: invokevirtual 385	org/json/JSONObject:toString	()Ljava/lang/String;
    //   910: invokevirtual 386	midas/x/ac:a	(Ljava/lang/String;)V
    //   913: iconst_1
    //   914: istore_3
    //   915: aload 7
    //   917: ldc_w 356
    //   920: invokevirtual 61	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   923: astore 9
    //   925: aload 9
    //   927: ldc_w 388
    //   930: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   933: ifeq +47 -> 980
    //   936: ldc_w 299
    //   939: invokestatic 393	midas/x/w:a	()Lmidas/x/w;
    //   942: invokevirtual 395	midas/x/w:d	()Ljava/lang/String;
    //   945: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   948: ifeq +32 -> 980
    //   951: ldc_w 299
    //   954: aload 9
    //   956: ldc_w 388
    //   959: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   962: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   965: ifeq +15 -> 980
    //   968: invokestatic 393	midas/x/w:a	()Lmidas/x/w;
    //   971: ldc_w 299
    //   974: invokevirtual 396	midas/x/w:a	(Ljava/lang/String;)V
    //   977: goto +12 -> 989
    //   980: invokestatic 393	midas/x/w:a	()Lmidas/x/w;
    //   983: ldc_w 398
    //   986: invokevirtual 396	midas/x/w:a	(Ljava/lang/String;)V
    //   989: invokestatic 384	midas/x/ac:a	()Lmidas/x/ac;
    //   992: aload 8
    //   994: invokevirtual 399	midas/x/ac:a	(Lorg/json/JSONObject;)V
    //   997: invokestatic 384	midas/x/ac:a	()Lmidas/x/ac;
    //   1000: aload 8
    //   1002: invokevirtual 401	midas/x/ac:e	(Lorg/json/JSONObject;)Z
    //   1005: istore 4
    //   1007: invokestatic 406	midas/x/gf:b	()Lmidas/x/gf;
    //   1010: iload 4
    //   1012: invokevirtual 409	midas/x/gf:a	(Z)V
    //   1015: aload_0
    //   1016: aload 8
    //   1018: invokevirtual 411	midas/x/dd:g	(Lorg/json/JSONObject;)V
    //   1021: goto +25 -> 1046
    //   1024: ldc_w 413
    //   1027: ldc_w 415
    //   1030: invokestatic 191	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: invokestatic 406	midas/x/gf:b	()Lmidas/x/gf;
    //   1036: iconst_0
    //   1037: invokevirtual 409	midas/x/gf:a	(Z)V
    //   1040: invokestatic 365	midas/x/o:a	()Lmidas/x/o;
    //   1043: invokevirtual 417	midas/x/o:i	()V
    //   1046: invokestatic 365	midas/x/o:a	()Lmidas/x/o;
    //   1049: invokevirtual 420	midas/x/o:e	()Z
    //   1052: istore 4
    //   1054: invokestatic 365	midas/x/o:a	()Lmidas/x/o;
    //   1057: iconst_1
    //   1058: invokevirtual 421	midas/x/o:a	(Z)V
    //   1061: invokestatic 365	midas/x/o:a	()Lmidas/x/o;
    //   1064: invokevirtual 423	midas/x/o:b	()Z
    //   1067: ifne +11 -> 1078
    //   1070: invokestatic 365	midas/x/o:a	()Lmidas/x/o;
    //   1073: ldc 79
    //   1075: invokevirtual 367	midas/x/o:a	(Ljava/lang/String;)V
    //   1078: invokestatic 365	midas/x/o:a	()Lmidas/x/o;
    //   1081: iload 4
    //   1083: invokevirtual 421	midas/x/o:a	(Z)V
    //   1086: new 175	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1093: astore 8
    //   1095: aload 8
    //   1097: ldc_w 425
    //   1100: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: aload 8
    //   1106: iload_3
    //   1107: invokevirtual 316	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: ldc 185
    //   1113: aload 8
    //   1115: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1118: invokestatic 191	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1121: iload_3
    //   1122: ifne +16 -> 1138
    //   1125: invokestatic 384	midas/x/ac:a	()Lmidas/x/ac;
    //   1128: aconst_null
    //   1129: invokevirtual 386	midas/x/ac:a	(Ljava/lang/String;)V
    //   1132: invokestatic 393	midas/x/w:a	()Lmidas/x/w;
    //   1135: invokevirtual 427	midas/x/w:c	()V
    //   1138: aload 7
    //   1140: ldc_w 429
    //   1143: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1146: ifeq +17 -> 1163
    //   1149: aload 7
    //   1151: ldc_w 429
    //   1154: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1157: putstatic 434	com/pay/paychannel/hfpay/APHFChannel:o	Ljava/lang/String;
    //   1160: goto +8 -> 1168
    //   1163: ldc 79
    //   1165: putstatic 434	com/pay/paychannel/hfpay/APHFChannel:o	Ljava/lang/String;
    //   1168: aload 7
    //   1170: ldc_w 436
    //   1173: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1176: ifeq +25 -> 1201
    //   1179: aload 7
    //   1181: ldc_w 436
    //   1184: invokevirtual 75	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1187: iconst_1
    //   1188: if_icmpne +13 -> 1201
    //   1191: invokestatic 334	midas/x/fy:a	()Lmidas/x/fy;
    //   1194: iconst_1
    //   1195: invokevirtual 438	midas/x/fy:i	(Z)V
    //   1198: goto +10 -> 1208
    //   1201: invokestatic 334	midas/x/fy:a	()Lmidas/x/fy;
    //   1204: iconst_0
    //   1205: invokevirtual 438	midas/x/fy:i	(Z)V
    //   1208: aload 7
    //   1210: ldc_w 440
    //   1213: aload 5
    //   1215: invokestatic 443	midas/x/ek:c	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)I
    //   1218: istore_2
    //   1219: aload_0
    //   1220: getfield 102	midas/x/dd:h	Lmidas/x/el;
    //   1223: getfield 108	midas/x/el:d	Lmidas/x/ez;
    //   1226: iload_2
    //   1227: putfield 444	midas/x/ez:h	I
    //   1230: new 175	java/lang/StringBuilder
    //   1233: dup
    //   1234: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1237: astore 5
    //   1239: aload 5
    //   1241: ldc_w 446
    //   1244: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload 5
    //   1250: iload_2
    //   1251: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: ldc_w 451
    //   1258: aload 5
    //   1260: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1263: invokestatic 191	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1266: aload_0
    //   1267: aload 7
    //   1269: invokespecial 453	midas/x/dd:t	(Lorg/json/JSONObject;)V
    //   1272: aload_0
    //   1273: aload 7
    //   1275: invokevirtual 455	midas/x/dd:o	(Lorg/json/JSONObject;)V
    //   1278: aload_0
    //   1279: aload 7
    //   1281: invokevirtual 458	midas/x/dd:p	(Lorg/json/JSONObject;)V
    //   1284: aload_0
    //   1285: aload 7
    //   1287: invokespecial 460	midas/x/dd:v	(Lorg/json/JSONObject;)V
    //   1290: aload_0
    //   1291: aload 7
    //   1293: invokevirtual 463	midas/x/dd:r	(Lorg/json/JSONObject;)V
    //   1296: aload_0
    //   1297: aload 7
    //   1299: invokevirtual 466	midas/x/dd:s	(Lorg/json/JSONObject;)V
    //   1302: aload_0
    //   1303: aload 7
    //   1305: invokevirtual 469	midas/x/dd:q	(Lorg/json/JSONObject;)V
    //   1308: goto +70 -> 1378
    //   1311: aload 6
    //   1313: ldc_w 471
    //   1316: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1319: invokevirtual 472	java/lang/String:toString	()Ljava/lang/String;
    //   1322: astore 5
    //   1324: aload 5
    //   1326: ldc 79
    //   1328: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1331: ifne +47 -> 1378
    //   1334: new 175	java/lang/StringBuilder
    //   1337: dup
    //   1338: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1341: astore 7
    //   1343: aload 7
    //   1345: ldc_w 474
    //   1348: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload 7
    //   1354: aload 5
    //   1356: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: pop
    //   1360: aload 7
    //   1362: ldc_w 476
    //   1365: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: aload_0
    //   1370: aload 7
    //   1372: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1375: putfield 221	midas/x/dd:k	Ljava/lang/String;
    //   1378: aload 6
    //   1380: ldc 223
    //   1382: invokevirtual 229	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1385: ifeq +80 -> 1465
    //   1388: aload 6
    //   1390: ldc 223
    //   1392: invokevirtual 61	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1395: astore 5
    //   1397: aload_0
    //   1398: aload 5
    //   1400: invokevirtual 478	midas/x/dd:i	(Lorg/json/JSONObject;)V
    //   1403: aload_0
    //   1404: aload 5
    //   1406: invokespecial 480	midas/x/dd:u	(Lorg/json/JSONObject;)V
    //   1409: aload_0
    //   1410: aload 5
    //   1412: invokevirtual 482	midas/x/dd:j	(Lorg/json/JSONObject;)V
    //   1415: aload_0
    //   1416: aload 5
    //   1418: invokevirtual 484	midas/x/dd:k	(Lorg/json/JSONObject;)V
    //   1421: aload_0
    //   1422: aload 5
    //   1424: invokevirtual 486	midas/x/dd:n	(Lorg/json/JSONObject;)V
    //   1427: aload_0
    //   1428: aload 5
    //   1430: invokevirtual 488	midas/x/dd:l	(Lorg/json/JSONObject;)V
    //   1433: aload_0
    //   1434: aload 5
    //   1436: invokevirtual 490	midas/x/dd:m	(Lorg/json/JSONObject;)V
    //   1439: aload_0
    //   1440: aload 5
    //   1442: invokevirtual 492	midas/x/dd:h	(Lorg/json/JSONObject;)V
    //   1445: goto +20 -> 1465
    //   1448: astore 5
    //   1450: aload 5
    //   1452: invokevirtual 52	org/json/JSONException:printStackTrace	()V
    //   1455: ldc 185
    //   1457: aload 5
    //   1459: invokevirtual 495	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1462: invokestatic 320	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload_0
    //   1466: aload_1
    //   1467: invokespecial 497	midas/x/cc:a	(Lmidas/x/kz;)Z
    //   1470: ireturn
    //   1471: aload_0
    //   1472: aload_1
    //   1473: invokespecial 497	midas/x/cc:a	(Lmidas/x/kz;)Z
    //   1476: ireturn
    //   1477: astore 5
    //   1479: goto -1318 -> 161
    //   1482: astore 5
    //   1484: goto -1163 -> 321
    //   1487: astore 8
    //   1489: goto -848 -> 641
    //   1492: astore 8
    //   1494: goto -747 -> 747
    //   1497: iconst_0
    //   1498: istore_3
    //   1499: goto -732 -> 767
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1502	0	this	dd
    //   0	1502	1	paramkz	kz
    //   157	1094	2	i	int
    //   729	770	3	bool1	boolean
    //   1005	77	4	bool2	boolean
    //   4	1437	5	localObject1	Object
    //   1448	10	5	localJSONException	JSONException
    //   1477	1	5	localException1	Exception
    //   1482	1	5	localException2	Exception
    //   13	1376	6	localObject2	Object
    //   131	1240	7	localObject3	Object
    //   476	638	8	localObject4	Object
    //   1487	1	8	localException3	Exception
    //   1492	1	8	localException4	Exception
    //   683	272	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   81	152	1448	org/json/JSONException
    //   152	158	1448	org/json/JSONException
    //   163	179	1448	org/json/JSONException
    //   179	251	1448	org/json/JSONException
    //   254	308	1448	org/json/JSONException
    //   308	318	1448	org/json/JSONException
    //   325	372	1448	org/json/JSONException
    //   372	408	1448	org/json/JSONException
    //   411	422	1448	org/json/JSONException
    //   422	452	1448	org/json/JSONException
    //   455	466	1448	org/json/JSONException
    //   466	511	1448	org/json/JSONException
    //   514	525	1448	org/json/JSONException
    //   525	620	1448	org/json/JSONException
    //   620	632	1448	org/json/JSONException
    //   632	638	1448	org/json/JSONException
    //   643	676	1448	org/json/JSONException
    //   676	730	1448	org/json/JSONException
    //   734	747	1448	org/json/JSONException
    //   747	764	1448	org/json/JSONException
    //   767	784	1448	org/json/JSONException
    //   784	801	1448	org/json/JSONException
    //   801	826	1448	org/json/JSONException
    //   826	891	1448	org/json/JSONException
    //   891	902	1448	org/json/JSONException
    //   902	913	1448	org/json/JSONException
    //   915	977	1448	org/json/JSONException
    //   980	989	1448	org/json/JSONException
    //   989	1021	1448	org/json/JSONException
    //   1024	1046	1448	org/json/JSONException
    //   1046	1078	1448	org/json/JSONException
    //   1078	1121	1448	org/json/JSONException
    //   1125	1138	1448	org/json/JSONException
    //   1138	1160	1448	org/json/JSONException
    //   1163	1168	1448	org/json/JSONException
    //   1168	1198	1448	org/json/JSONException
    //   1201	1208	1448	org/json/JSONException
    //   1208	1308	1448	org/json/JSONException
    //   1311	1378	1448	org/json/JSONException
    //   1378	1445	1448	org/json/JSONException
    //   152	158	1477	java/lang/Exception
    //   308	318	1482	java/lang/Exception
    //   632	638	1487	java/lang/Exception
    //   734	747	1492	java/lang/Exception
  }
  
  public String e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dd
 * JD-Core Version:    0.7.0.1
 */