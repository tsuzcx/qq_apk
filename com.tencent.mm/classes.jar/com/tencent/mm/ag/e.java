package com.tencent.mm.ag;

import android.annotation.SuppressLint;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.e;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import junit.framework.Assert;

public final class e
  implements f
{
  k ebA = null;
  boolean ebB = false;
  private av ebC = null;
  h ebq = null;
  b ebz = null;
  
  public e()
  {
    g.Dk().a(158, this);
  }
  
  public final void JU()
  {
    g.Dk().b(158, this);
  }
  
  public final int a(String paramString, b paramb)
  {
    Assert.assertTrue("GetHDHeadImg must set callback", true);
    if (bk.bl(paramString))
    {
      paramb.bl(3, -101);
      return -101;
    }
    this.ebz = paramb;
    if (ad.hd(paramString)) {}
    for (String str = ad.aaZ(paramString);; str = paramString)
    {
      this.ebq = o.Kh().kp(str);
      y.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.ebq == null) || (!this.ebq.getUsername().equals(str)))
      {
        this.ebq = new h();
        this.ebq.username = str;
      }
      if (bk.bl(this.ebq.JX()))
      {
        y.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString, Integer.valueOf(this.ebq.cCq) });
        this.ebA = new k(str);
        if (!g.Dk().a(this.ebA, 0))
        {
          paramb.bl(3, -102);
          return -102;
        }
        return 0;
      }
      paramString = this.ebq;
      if ((this.ebC == null) || (this.ebC.crx())) {
        this.ebC = new av(1, "get-hd-headimg", 1);
      }
      if (this.ebC.c(new a(paramString)) == 0) {
        return 0;
      }
      paramb.bl(3, -103);
      return -103;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    this.ebz.bl(paramInt1, paramInt2);
  }
  
  @SuppressLint({"DefaultLocale"})
  final class a
    implements av.a
  {
    public String ebD = null;
    public boolean ebE = true;
    private g.a ebF;
    public h ebm = null;
    
    public a(h paramh)
    {
      this.ebm = paramh;
      o.JQ();
      this.ebD = d.z(paramh.getUsername(), true);
      this.ebF = new g.a();
    }
    
    /* Error */
    public final boolean JS()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 31	com/tencent/mm/ag/e$a:ebm	Lcom/tencent/mm/ag/h;
      //   4: ifnonnull +5 -> 9
      //   7: iconst_0
      //   8: ireturn
      //   9: aload_0
      //   10: getfield 31	com/tencent/mm/ag/e$a:ebm	Lcom/tencent/mm/ag/h;
      //   13: invokevirtual 66	com/tencent/mm/ag/h:JX	()Ljava/lang/String;
      //   16: astore 4
      //   18: ldc 68
      //   20: astore_3
      //   21: invokestatic 74	com/tencent/mm/kernel/g:DN	()Lcom/tencent/mm/kernel/a;
      //   24: invokevirtual 79	com/tencent/mm/kernel/a:Dc	()Z
      //   27: ifeq +61 -> 88
      //   30: getstatic 85	com/tencent/mm/protocal/d:spa	I
      //   33: istore_1
      //   34: invokestatic 74	com/tencent/mm/kernel/g:DN	()Lcom/tencent/mm/kernel/a;
      //   37: pop
      //   38: ldc 87
      //   40: iconst_4
      //   41: anewarray 4	java/lang/Object
      //   44: dup
      //   45: iconst_0
      //   46: iload_1
      //   47: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   50: aastore
      //   51: dup
      //   52: iconst_1
      //   53: invokestatic 97	com/tencent/mm/kernel/a:CK	()I
      //   56: invokestatic 103	com/tencent/mm/a/o:getString	(I)Ljava/lang/String;
      //   59: aastore
      //   60: dup
      //   61: iconst_2
      //   62: invokestatic 109	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
      //   65: invokestatic 115	com/tencent/mm/sdk/platformtools/aq:getNetTypeForStat	(Landroid/content/Context;)I
      //   68: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   71: aastore
      //   72: dup
      //   73: iconst_3
      //   74: invokestatic 109	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
      //   77: invokestatic 118	com/tencent/mm/sdk/platformtools/aq:getStrength	(Landroid/content/Context;)I
      //   80: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   83: aastore
      //   84: invokestatic 124	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   87: astore_3
      //   88: ldc 126
      //   90: ldc 128
      //   92: iconst_3
      //   93: anewarray 4	java/lang/Object
      //   96: dup
      //   97: iconst_0
      //   98: aload_0
      //   99: getfield 31	com/tencent/mm/ag/e$a:ebm	Lcom/tencent/mm/ag/h;
      //   102: invokevirtual 47	com/tencent/mm/ag/h:getUsername	()Ljava/lang/String;
      //   105: aastore
      //   106: dup
      //   107: iconst_1
      //   108: aload_3
      //   109: aastore
      //   110: dup
      //   111: iconst_2
      //   112: aload 4
      //   114: aastore
      //   115: invokestatic 134	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   118: aload_0
      //   119: iconst_1
      //   120: putfield 35	com/tencent/mm/ag/e$a:ebE	Z
      //   123: aload 4
      //   125: aconst_null
      //   126: invokestatic 139	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/u;
      //   129: astore 6
      //   131: aload 6
      //   133: ldc 141
      //   135: invokevirtual 147	com/tencent/mm/network/u:setRequestMethod	(Ljava/lang/String;)V
      //   138: aload 6
      //   140: ldc 149
      //   142: aload_3
      //   143: invokevirtual 153	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   146: aload 6
      //   148: sipush 5000
      //   151: invokevirtual 157	com/tencent/mm/network/u:setConnectTimeout	(I)V
      //   154: aload 6
      //   156: sipush 5000
      //   159: invokevirtual 160	com/tencent/mm/network/u:setReadTimeout	(I)V
      //   162: aload 6
      //   164: invokestatic 163	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/u;)I
      //   167: ifeq +69 -> 236
      //   170: ldc 126
      //   172: ldc 165
      //   174: iconst_1
      //   175: anewarray 4	java/lang/Object
      //   178: dup
      //   179: iconst_0
      //   180: aload 4
      //   182: aastore
      //   183: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   186: aload 6
      //   188: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   191: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
      //   194: iconst_1
      //   195: ireturn
      //   196: astore_3
      //   197: ldc 126
      //   199: ldc 179
      //   201: iconst_1
      //   202: anewarray 4	java/lang/Object
      //   205: dup
      //   206: iconst_0
      //   207: aload_3
      //   208: invokestatic 185	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   211: aastore
      //   212: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   215: ldc 126
      //   217: ldc 187
      //   219: iconst_1
      //   220: anewarray 4	java/lang/Object
      //   223: dup
      //   224: iconst_0
      //   225: aload_3
      //   226: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   229: aastore
      //   230: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   233: goto -39 -> 194
      //   236: aload 6
      //   238: invokevirtual 194	com/tencent/mm/network/u:getInputStream	()Ljava/io/InputStream;
      //   241: astore 5
      //   243: aload 5
      //   245: ifnonnull +79 -> 324
      //   248: ldc 126
      //   250: ldc 196
      //   252: iconst_1
      //   253: anewarray 4	java/lang/Object
      //   256: dup
      //   257: iconst_0
      //   258: aload 4
      //   260: aastore
      //   261: invokestatic 134	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   264: aload 6
      //   266: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   269: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
      //   272: aload 5
      //   274: ifnull +8 -> 282
      //   277: aload 5
      //   279: invokevirtual 201	java/io/InputStream:close	()V
      //   282: iconst_1
      //   283: ireturn
      //   284: astore_3
      //   285: ldc 126
      //   287: ldc 179
      //   289: iconst_1
      //   290: anewarray 4	java/lang/Object
      //   293: dup
      //   294: iconst_0
      //   295: aload_3
      //   296: invokestatic 185	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   299: aastore
      //   300: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   303: ldc 126
      //   305: ldc 187
      //   307: iconst_1
      //   308: anewarray 4	java/lang/Object
      //   311: dup
      //   312: iconst_0
      //   313: aload_3
      //   314: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   317: aastore
      //   318: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   321: goto -39 -> 282
      //   324: sipush 1024
      //   327: newarray byte
      //   329: astore 4
      //   331: new 203	java/lang/StringBuilder
      //   334: dup
      //   335: invokespecial 204	java/lang/StringBuilder:<init>	()V
      //   338: aload_0
      //   339: getfield 33	com/tencent/mm/ag/e$a:ebD	Ljava/lang/String;
      //   342: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   345: ldc 210
      //   347: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   350: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   353: iconst_0
      //   354: invokestatic 218	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   357: astore_3
      //   358: iconst_0
      //   359: istore_1
      //   360: aload 5
      //   362: aload 4
      //   364: invokevirtual 222	java/io/InputStream:read	([B)I
      //   367: istore_2
      //   368: iload_2
      //   369: iconst_m1
      //   370: if_icmpeq +18 -> 388
      //   373: aload_3
      //   374: aload 4
      //   376: iconst_0
      //   377: iload_2
      //   378: invokevirtual 228	java/io/OutputStream:write	([BII)V
      //   381: iload_1
      //   382: iload_2
      //   383: iadd
      //   384: istore_1
      //   385: goto -25 -> 360
      //   388: aload 6
      //   390: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   393: invokevirtual 231	java/net/HttpURLConnection:getContentLength	()I
      //   396: istore_2
      //   397: iconst_1
      //   398: aload 6
      //   400: getfield 234	com/tencent/mm/network/u:eNz	I
      //   403: if_icmpne +24 -> 427
      //   406: aload 6
      //   408: getfield 238	com/tencent/mm/network/u:aRP	Ljava/util/Map;
      //   411: ifnonnull +16 -> 427
      //   414: aload 6
      //   416: aload 6
      //   418: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   421: invokevirtual 242	java/net/HttpURLConnection:getRequestProperties	()Ljava/util/Map;
      //   424: putfield 238	com/tencent/mm/network/u:aRP	Ljava/util/Map;
      //   427: iload_1
      //   428: aload 6
      //   430: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   433: ldc 244
      //   435: iload_2
      //   436: invokevirtual 248	java/net/HttpURLConnection:getHeaderFieldInt	(Ljava/lang/String;I)I
      //   439: if_icmpne +36 -> 475
      //   442: aload_0
      //   443: iconst_0
      //   444: putfield 35	com/tencent/mm/ag/e$a:ebE	Z
      //   447: aload 6
      //   449: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   452: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
      //   455: aload 5
      //   457: ifnull +8 -> 465
      //   460: aload 5
      //   462: invokevirtual 201	java/io/InputStream:close	()V
      //   465: aload_3
      //   466: ifnull +7 -> 473
      //   469: aload_3
      //   470: invokevirtual 249	java/io/OutputStream:close	()V
      //   473: iconst_1
      //   474: ireturn
      //   475: ldc 126
      //   477: ldc 251
      //   479: iconst_3
      //   480: anewarray 4	java/lang/Object
      //   483: dup
      //   484: iconst_0
      //   485: iload_1
      //   486: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   489: aastore
      //   490: dup
      //   491: iconst_1
      //   492: aload 6
      //   494: ldc 244
      //   496: invokevirtual 255	com/tencent/mm/network/u:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   499: aastore
      //   500: dup
      //   501: iconst_2
      //   502: aload 6
      //   504: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   507: invokevirtual 231	java/net/HttpURLConnection:getContentLength	()I
      //   510: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   513: aastore
      //   514: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   517: goto -70 -> 447
      //   520: astore 7
      //   522: aload_3
      //   523: astore 4
      //   525: aload 7
      //   527: astore_3
      //   528: ldc 126
      //   530: ldc 179
      //   532: iconst_1
      //   533: anewarray 4	java/lang/Object
      //   536: dup
      //   537: iconst_0
      //   538: aload_3
      //   539: invokestatic 185	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   542: aastore
      //   543: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   546: aload 6
      //   548: ifnull +11 -> 559
      //   551: aload 6
      //   553: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   556: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
      //   559: aload 5
      //   561: ifnull +8 -> 569
      //   564: aload 5
      //   566: invokevirtual 201	java/io/InputStream:close	()V
      //   569: aload 4
      //   571: ifnull -98 -> 473
      //   574: aload 4
      //   576: invokevirtual 249	java/io/OutputStream:close	()V
      //   579: goto -106 -> 473
      //   582: astore_3
      //   583: ldc 126
      //   585: ldc 179
      //   587: iconst_1
      //   588: anewarray 4	java/lang/Object
      //   591: dup
      //   592: iconst_0
      //   593: aload_3
      //   594: invokestatic 185	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   597: aastore
      //   598: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   601: ldc 126
      //   603: ldc 187
      //   605: iconst_1
      //   606: anewarray 4	java/lang/Object
      //   609: dup
      //   610: iconst_0
      //   611: aload_3
      //   612: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   615: aastore
      //   616: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   619: goto -146 -> 473
      //   622: astore_3
      //   623: ldc 126
      //   625: ldc 179
      //   627: iconst_1
      //   628: anewarray 4	java/lang/Object
      //   631: dup
      //   632: iconst_0
      //   633: aload_3
      //   634: invokestatic 185	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   637: aastore
      //   638: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   641: ldc 126
      //   643: ldc 187
      //   645: iconst_1
      //   646: anewarray 4	java/lang/Object
      //   649: dup
      //   650: iconst_0
      //   651: aload_3
      //   652: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   655: aastore
      //   656: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   659: goto -186 -> 473
      //   662: astore_3
      //   663: aconst_null
      //   664: astore 5
      //   666: aconst_null
      //   667: astore 4
      //   669: aconst_null
      //   670: astore 6
      //   672: aload 6
      //   674: ifnull +11 -> 685
      //   677: aload 6
      //   679: getfield 172	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   682: invokevirtual 177	java/net/HttpURLConnection:disconnect	()V
      //   685: aload 5
      //   687: ifnull +8 -> 695
      //   690: aload 5
      //   692: invokevirtual 201	java/io/InputStream:close	()V
      //   695: aload 4
      //   697: ifnull +8 -> 705
      //   700: aload 4
      //   702: invokevirtual 249	java/io/OutputStream:close	()V
      //   705: aload_3
      //   706: athrow
      //   707: astore 4
      //   709: ldc 126
      //   711: ldc 179
      //   713: iconst_1
      //   714: anewarray 4	java/lang/Object
      //   717: dup
      //   718: iconst_0
      //   719: aload 4
      //   721: invokestatic 185	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   724: aastore
      //   725: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   728: ldc 126
      //   730: ldc 187
      //   732: iconst_1
      //   733: anewarray 4	java/lang/Object
      //   736: dup
      //   737: iconst_0
      //   738: aload 4
      //   740: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   743: aastore
      //   744: invokestatic 168	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   747: goto -42 -> 705
      //   750: astore_3
      //   751: aconst_null
      //   752: astore 5
      //   754: aconst_null
      //   755: astore 4
      //   757: goto -85 -> 672
      //   760: astore_3
      //   761: aconst_null
      //   762: astore 4
      //   764: goto -92 -> 672
      //   767: astore 7
      //   769: aload_3
      //   770: astore 4
      //   772: aload 7
      //   774: astore_3
      //   775: goto -103 -> 672
      //   778: astore_3
      //   779: goto -107 -> 672
      //   782: astore_3
      //   783: aconst_null
      //   784: astore 5
      //   786: aconst_null
      //   787: astore 4
      //   789: aconst_null
      //   790: astore 6
      //   792: goto -264 -> 528
      //   795: astore_3
      //   796: aconst_null
      //   797: astore 5
      //   799: aconst_null
      //   800: astore 4
      //   802: goto -274 -> 528
      //   805: astore_3
      //   806: aconst_null
      //   807: astore 4
      //   809: goto -281 -> 528
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	812	0	this	a
      //   33	453	1	i	int
      //   367	69	2	j	int
      //   20	123	3	str	String
      //   196	30	3	localException1	java.lang.Exception
      //   284	30	3	localException2	java.lang.Exception
      //   357	182	3	localObject1	Object
      //   582	30	3	localException3	java.lang.Exception
      //   622	30	3	localException4	java.lang.Exception
      //   662	44	3	localObject2	Object
      //   750	1	3	localObject3	Object
      //   760	10	3	localObject4	Object
      //   774	1	3	localObject5	Object
      //   778	1	3	localObject6	Object
      //   782	1	3	localException5	java.lang.Exception
      //   795	1	3	localException6	java.lang.Exception
      //   805	1	3	localException7	java.lang.Exception
      //   16	685	4	localObject7	Object
      //   707	32	4	localException8	java.lang.Exception
      //   755	53	4	localObject8	Object
      //   241	557	5	localInputStream	java.io.InputStream
      //   129	662	6	localu	com.tencent.mm.network.u
      //   520	6	7	localException9	java.lang.Exception
      //   767	6	7	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   186	194	196	java/lang/Exception
      //   264	272	284	java/lang/Exception
      //   277	282	284	java/lang/Exception
      //   360	368	520	java/lang/Exception
      //   373	381	520	java/lang/Exception
      //   388	427	520	java/lang/Exception
      //   427	447	520	java/lang/Exception
      //   475	517	520	java/lang/Exception
      //   551	559	582	java/lang/Exception
      //   564	569	582	java/lang/Exception
      //   574	579	582	java/lang/Exception
      //   447	455	622	java/lang/Exception
      //   460	465	622	java/lang/Exception
      //   469	473	622	java/lang/Exception
      //   123	131	662	finally
      //   677	685	707	java/lang/Exception
      //   690	695	707	java/lang/Exception
      //   700	705	707	java/lang/Exception
      //   131	186	750	finally
      //   236	243	750	finally
      //   248	264	760	finally
      //   324	358	760	finally
      //   360	368	767	finally
      //   373	381	767	finally
      //   388	427	767	finally
      //   427	447	767	finally
      //   475	517	767	finally
      //   528	546	778	finally
      //   123	131	782	java/lang/Exception
      //   131	186	795	java/lang/Exception
      //   236	243	795	java/lang/Exception
      //   248	264	805	java/lang/Exception
      //   324	358	805	java/lang/Exception
    }
    
    public final boolean JT()
    {
      if (e.this.ebB) {
        return false;
      }
      if ((this.ebE) || (bk.bl(this.ebD)))
      {
        e.this.ebz.bl(4, -1);
        return false;
      }
      y.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.ebm.getUsername() + " urltime:" + this.ebF.zJ());
      if (am.a.dVz != null) {
        am.a.dVz.bg((int)com.tencent.mm.vfs.e.aeQ(this.ebD + ".tmp"), 0);
      }
      com.tencent.mm.vfs.e.deleteFile(this.ebD);
      com.tencent.mm.vfs.e.aA(this.ebD + ".tmp", this.ebD);
      k.aj(this.ebD, e.this.ebq.getUsername());
      e.this.ebz.bl(0, 0);
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract int bl(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.e
 * JD-Core Version:    0.7.0.1
 */