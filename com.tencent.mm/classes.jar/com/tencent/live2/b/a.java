package com.tencent.live2.b;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.impl.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;

public class a
{
  private int a;
  private String b;
  private int c = 1;
  private String d;
  private String e;
  private String f;
  private String g;
  private int h = 0;
  private boolean i;
  private a.d j = a.d.a;
  
  /* Error */
  public static a b(String paramString)
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 37
    //   14: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: ldc 53
    //   22: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: ifne +19 -> 44
    //   28: aload_0
    //   29: ldc 61
    //   31: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifne +10 -> 44
    //   37: ldc 37
    //   39: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 2	com/tencent/live2/b/a
    //   47: dup
    //   48: invokespecial 62	com/tencent/live2/b/a:<init>	()V
    //   51: astore 5
    //   53: aload_0
    //   54: ldc 64
    //   56: invokevirtual 68	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore 6
    //   61: aload_0
    //   62: ldc 53
    //   64: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifeq +163 -> 230
    //   70: aload 5
    //   72: getstatic 70	com/tencent/live2/impl/a$d:b	Lcom/tencent/live2/impl/a$d;
    //   75: putfield 32	com/tencent/live2/b/a:j	Lcom/tencent/live2/impl/a$d;
    //   78: aload_0
    //   79: ldc 72
    //   81: invokevirtual 76	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   84: istore_1
    //   85: aload_0
    //   86: ldc 78
    //   88: invokevirtual 81	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   91: istore_2
    //   92: iload_1
    //   93: iconst_m1
    //   94: if_icmpeq +40 -> 134
    //   97: iload_2
    //   98: iconst_m1
    //   99: if_icmpeq +35 -> 134
    //   102: iload_2
    //   103: iload_1
    //   104: iconst_1
    //   105: iadd
    //   106: if_icmple +28 -> 134
    //   109: aload 5
    //   111: aload_0
    //   112: iload_1
    //   113: iconst_1
    //   114: iadd
    //   115: iload_2
    //   116: invokevirtual 85	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: putfield 87	com/tencent/live2/b/a:b	Ljava/lang/String;
    //   122: aload 5
    //   124: iconst_0
    //   125: putfield 89	com/tencent/live2/b/a:i	Z
    //   128: aload 5
    //   130: iconst_1
    //   131: putfield 24	com/tencent/live2/b/a:c	I
    //   134: aload 6
    //   136: arraylength
    //   137: istore_3
    //   138: iconst_0
    //   139: istore_2
    //   140: iload_2
    //   141: iload_3
    //   142: if_icmpge +520 -> 662
    //   145: aload 6
    //   147: iload_2
    //   148: aaload
    //   149: astore_0
    //   150: aload_0
    //   151: ldc 91
    //   153: invokevirtual 94	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +67 -> 223
    //   159: aload_0
    //   160: ldc 96
    //   162: invokevirtual 68	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   165: astore 7
    //   167: aload 7
    //   169: arraylength
    //   170: iconst_2
    //   171: if_icmpne +52 -> 223
    //   174: aload 7
    //   176: iconst_0
    //   177: aaload
    //   178: astore_0
    //   179: aload 7
    //   181: iconst_1
    //   182: aaload
    //   183: astore 7
    //   185: aload_0
    //   186: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +34 -> 223
    //   192: aload 7
    //   194: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +26 -> 223
    //   200: aload_0
    //   201: ldc 98
    //   203: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   206: istore 4
    //   208: iload 4
    //   210: ifeq +91 -> 301
    //   213: aload 5
    //   215: aload 7
    //   217: invokestatic 106	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   220: putfield 108	com/tencent/live2/b/a:a	I
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -87 -> 140
    //   230: aload 5
    //   232: iconst_1
    //   233: putfield 89	com/tencent/live2/b/a:i	Z
    //   236: aload 5
    //   238: getstatic 30	com/tencent/live2/impl/a$d:a	Lcom/tencent/live2/impl/a$d;
    //   241: putfield 32	com/tencent/live2/b/a:j	Lcom/tencent/live2/impl/a$d;
    //   244: goto -110 -> 134
    //   247: astore_0
    //   248: ldc 110
    //   250: ldc 112
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_0
    //   259: aastore
    //   260: invokestatic 117	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: ldc 37
    //   265: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aconst_null
    //   269: areturn
    //   270: astore_0
    //   271: ldc 110
    //   273: new 119	java/lang/StringBuilder
    //   276: dup
    //   277: ldc 121
    //   279: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload 7
    //   284: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc 130
    //   289: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 137	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: goto -75 -> 223
    //   301: aload_0
    //   302: ldc 139
    //   304: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   307: ifeq +19 -> 326
    //   310: aload 5
    //   312: aload 7
    //   314: putfield 87	com/tencent/live2/b/a:b	Ljava/lang/String;
    //   317: aload 5
    //   319: iconst_1
    //   320: putfield 89	com/tencent/live2/b/a:i	Z
    //   323: goto -100 -> 223
    //   326: aload_0
    //   327: ldc 141
    //   329: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   332: ifeq +19 -> 351
    //   335: aload 5
    //   337: aload 7
    //   339: putfield 87	com/tencent/live2/b/a:b	Ljava/lang/String;
    //   342: aload 5
    //   344: iconst_0
    //   345: putfield 89	com/tencent/live2/b/a:i	Z
    //   348: goto -125 -> 223
    //   351: aload_0
    //   352: ldc 143
    //   354: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   357: ifeq +48 -> 405
    //   360: aload 5
    //   362: getfield 32	com/tencent/live2/b/a:j	Lcom/tencent/live2/impl/a$d;
    //   365: getstatic 30	com/tencent/live2/impl/a$d:a	Lcom/tencent/live2/impl/a$d;
    //   368: if_acmpne +20 -> 388
    //   371: aload 5
    //   373: aload 7
    //   375: putfield 145	com/tencent/live2/b/a:g	Ljava/lang/String;
    //   378: aload 5
    //   380: ldc 147
    //   382: putfield 149	com/tencent/live2/b/a:d	Ljava/lang/String;
    //   385: goto -162 -> 223
    //   388: aload 5
    //   390: aload 7
    //   392: putfield 149	com/tencent/live2/b/a:d	Ljava/lang/String;
    //   395: aload 5
    //   397: ldc 151
    //   399: putfield 145	com/tencent/live2/b/a:g	Ljava/lang/String;
    //   402: goto -179 -> 223
    //   405: aload_0
    //   406: ldc 153
    //   408: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   411: ifeq +13 -> 424
    //   414: aload 5
    //   416: aload 7
    //   418: putfield 155	com/tencent/live2/b/a:e	Ljava/lang/String;
    //   421: goto -198 -> 223
    //   424: aload_0
    //   425: ldc 157
    //   427: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   430: ifeq +88 -> 518
    //   433: aload 7
    //   435: ldc 159
    //   437: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   440: ifeq +12 -> 452
    //   443: aload 5
    //   445: iconst_1
    //   446: putfield 24	com/tencent/live2/b/a:c	I
    //   449: goto -226 -> 223
    //   452: aload 7
    //   454: ldc 161
    //   456: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   459: ifeq +12 -> 471
    //   462: aload 5
    //   464: iconst_0
    //   465: putfield 24	com/tencent/live2/b/a:c	I
    //   468: goto -245 -> 223
    //   471: aload 7
    //   473: ldc 163
    //   475: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   478: ifeq +12 -> 490
    //   481: aload 5
    //   483: iconst_2
    //   484: putfield 24	com/tencent/live2/b/a:c	I
    //   487: goto -264 -> 223
    //   490: aload 7
    //   492: ldc 165
    //   494: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   497: ifeq +12 -> 509
    //   500: aload 5
    //   502: iconst_3
    //   503: putfield 24	com/tencent/live2/b/a:c	I
    //   506: goto -283 -> 223
    //   509: aload 5
    //   511: iconst_0
    //   512: putfield 24	com/tencent/live2/b/a:c	I
    //   515: goto -292 -> 223
    //   518: aload_0
    //   519: ldc 167
    //   521: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   524: ifeq +13 -> 537
    //   527: aload 5
    //   529: aload 7
    //   531: putfield 169	com/tencent/live2/b/a:f	Ljava/lang/String;
    //   534: goto -311 -> 223
    //   537: aload_0
    //   538: ldc 171
    //   540: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   543: ifeq +95 -> 638
    //   546: aload 7
    //   548: invokevirtual 175	java/lang/String:hashCode	()I
    //   551: lookupswitch	default:+119->670, 96964:+72->623, 3343801:+42->593, 109548807:+57->608
    //   585: iconst_2
    //   586: iload_1
    //   587: putfield 26	com/tencent/live2/b/a:h	I
    //   590: goto -367 -> 223
    //   593: aload 7
    //   595: ldc 177
    //   597: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   600: ifeq +70 -> 670
    //   603: iconst_0
    //   604: istore_1
    //   605: goto +67 -> 672
    //   608: aload 7
    //   610: ldc 183
    //   612: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   615: ifeq +55 -> 670
    //   618: iconst_1
    //   619: istore_1
    //   620: goto +52 -> 672
    //   623: aload 7
    //   625: ldc 185
    //   627: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   630: ifeq +40 -> 670
    //   633: iconst_2
    //   634: istore_1
    //   635: goto +37 -> 672
    //   638: aload_0
    //   639: ldc 187
    //   641: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   644: ifeq -421 -> 223
    //   647: aload 5
    //   649: ldc 189
    //   651: aload 7
    //   653: invokevirtual 101	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   656: putfield 89	com/tencent/live2/b/a:i	Z
    //   659: goto -436 -> 223
    //   662: ldc 37
    //   664: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   667: aload 5
    //   669: areturn
    //   670: iconst_m1
    //   671: istore_1
    //   672: iload_1
    //   673: tableswitch	default:+27 -> 700, 0:+32->705, 1:+37->710, 2:+42->715
    //   701: istore_1
    //   702: goto -118 -> 584
    //   705: iconst_0
    //   706: istore_1
    //   707: goto -123 -> 584
    //   710: iconst_1
    //   711: istore_1
    //   712: goto -128 -> 584
    //   715: iconst_2
    //   716: istore_1
    //   717: goto -133 -> 584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	720	0	paramString	String
    //   84	633	1	k	int
    //   91	136	2	m	int
    //   137	6	3	n	int
    //   206	3	4	bool	boolean
    //   51	617	5	locala	a
    //   59	87	6	arrayOfString	String[]
    //   165	487	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	92	247	java/lang/Exception
    //   109	134	247	java/lang/Exception
    //   134	138	247	java/lang/Exception
    //   150	174	247	java/lang/Exception
    //   185	208	247	java/lang/Exception
    //   230	244	247	java/lang/Exception
    //   271	298	247	java/lang/Exception
    //   301	323	247	java/lang/Exception
    //   326	348	247	java/lang/Exception
    //   351	385	247	java/lang/Exception
    //   388	402	247	java/lang/Exception
    //   405	421	247	java/lang/Exception
    //   424	449	247	java/lang/Exception
    //   452	468	247	java/lang/Exception
    //   471	487	247	java/lang/Exception
    //   490	506	247	java/lang/Exception
    //   509	515	247	java/lang/Exception
    //   518	534	247	java/lang/Exception
    //   537	584	247	java/lang/Exception
    //   584	590	247	java/lang/Exception
    //   593	603	247	java/lang/Exception
    //   608	618	247	java/lang/Exception
    //   623	633	247	java/lang/Exception
    //   638	659	247	java/lang/Exception
    //   213	223	270	java/lang/Exception
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public String b()
  {
    return this.g;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public a.d d()
  {
    return this.j;
  }
  
  public boolean e()
  {
    return this.j == a.d.b;
  }
  
  public int f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    AppMethodBeat.i(213902);
    if ((i()) || (h()))
    {
      AppMethodBeat.o(213902);
      return true;
    }
    AppMethodBeat.o(213902);
    return false;
  }
  
  public boolean h()
  {
    AppMethodBeat.i(213903);
    if ((this.j == a.d.b) && (this.a != 0) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)))
    {
      AppMethodBeat.o(213903);
      return true;
    }
    AppMethodBeat.o(213903);
    return false;
  }
  
  public boolean i()
  {
    AppMethodBeat.i(213904);
    if ((this.j == a.d.a) && (!TextUtils.isEmpty(this.g)))
    {
      AppMethodBeat.o(213904);
      return true;
    }
    AppMethodBeat.o(213904);
    return false;
  }
  
  public TRTCCloudDef.TRTCParams j()
  {
    AppMethodBeat.i(213906);
    if ((!h()) && (!i()))
    {
      TXCLog.e("V2-TRTCPlayURLParam", "generate trtc param fail. not trtc protocol.");
      AppMethodBeat.o(213906);
      return null;
    }
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams();
    localTRTCParams.sdkAppId = this.a;
    localTRTCParams.userId = this.d;
    localTRTCParams.userSig = this.e;
    localTRTCParams.role = 21;
    if (this.i) {}
    for (;;)
    {
      try
      {
        localTRTCParams.roomId = Long.valueOf(this.b).intValue();
        if (!TextUtils.isEmpty(this.f)) {
          localTRTCParams.privateMapKey = this.f;
        }
        AppMethodBeat.o(213906);
        return localTRTCParams;
      }
      catch (Exception localException)
      {
        TXCLog.e("V2-TRTCPlayURLParam", "get enter room fail. can't parse num room id.");
        localTRTCParams.roomId = 0;
        continue;
      }
      localTRTCParams.roomId = 0;
      localTRTCParams.strRoomId = this.b;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(213911);
    String str = "[sdkAppId:" + this.a + "][roomId:" + this.b + "][isNumRoomId:" + this.i + "][scene:" + this.c + "][userId:" + this.d + "][remoteUserId:" + this.g + "][streamType:" + this.h + "][protocolType:" + this.j + "]";
    AppMethodBeat.o(213911);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.b.a
 * JD-Core Version:    0.7.0.1
 */