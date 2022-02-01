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
  private int d = 0;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i = 0;
  private boolean j;
  private a.d k = a.d.a;
  
  /* Error */
  public static a b(String paramString)
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 40
    //   14: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: ldc 56
    //   22: invokevirtual 62	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: ifne +19 -> 44
    //   28: aload_0
    //   29: ldc 64
    //   31: invokevirtual 62	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifne +10 -> 44
    //   37: ldc 40
    //   39: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 2	com/tencent/live2/b/a
    //   47: dup
    //   48: invokespecial 65	com/tencent/live2/b/a:<init>	()V
    //   51: astore 5
    //   53: aload_0
    //   54: ldc 67
    //   56: invokevirtual 71	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore 6
    //   61: aload_0
    //   62: ldc 56
    //   64: invokevirtual 62	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifeq +163 -> 230
    //   70: aload 5
    //   72: getstatic 73	com/tencent/live2/impl/a$d:b	Lcom/tencent/live2/impl/a$d;
    //   75: putfield 33	com/tencent/live2/b/a:k	Lcom/tencent/live2/impl/a$d;
    //   78: aload_0
    //   79: ldc 75
    //   81: invokevirtual 79	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   84: istore_1
    //   85: aload_0
    //   86: ldc 81
    //   88: invokevirtual 84	java/lang/String:indexOf	(Ljava/lang/String;)I
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
    //   116: invokevirtual 88	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: putfield 90	com/tencent/live2/b/a:b	Ljava/lang/String;
    //   122: aload 5
    //   124: iconst_0
    //   125: putfield 92	com/tencent/live2/b/a:j	Z
    //   128: aload 5
    //   130: iconst_1
    //   131: putfield 25	com/tencent/live2/b/a:c	I
    //   134: aload 6
    //   136: arraylength
    //   137: istore_3
    //   138: iconst_0
    //   139: istore_2
    //   140: iload_2
    //   141: iload_3
    //   142: if_icmpge +608 -> 750
    //   145: aload 6
    //   147: iload_2
    //   148: aaload
    //   149: astore_0
    //   150: aload_0
    //   151: ldc 94
    //   153: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +67 -> 223
    //   159: aload_0
    //   160: ldc 99
    //   162: invokevirtual 71	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   186: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +34 -> 223
    //   192: aload 7
    //   194: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +26 -> 223
    //   200: aload_0
    //   201: ldc 101
    //   203: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   206: istore 4
    //   208: iload 4
    //   210: ifeq +91 -> 301
    //   213: aload 5
    //   215: aload 7
    //   217: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   220: putfield 111	com/tencent/live2/b/a:a	I
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -87 -> 140
    //   230: aload 5
    //   232: iconst_1
    //   233: putfield 92	com/tencent/live2/b/a:j	Z
    //   236: aload 5
    //   238: getstatic 31	com/tencent/live2/impl/a$d:a	Lcom/tencent/live2/impl/a$d;
    //   241: putfield 33	com/tencent/live2/b/a:k	Lcom/tencent/live2/impl/a$d;
    //   244: goto -110 -> 134
    //   247: astore_0
    //   248: ldc 113
    //   250: ldc 115
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_0
    //   259: aastore
    //   260: invokestatic 120	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: ldc 40
    //   265: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aconst_null
    //   269: areturn
    //   270: astore_0
    //   271: ldc 113
    //   273: new 122	java/lang/StringBuilder
    //   276: dup
    //   277: ldc 124
    //   279: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload 7
    //   284: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc 133
    //   289: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 140	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: goto -75 -> 223
    //   301: aload_0
    //   302: ldc 142
    //   304: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   307: ifeq +19 -> 326
    //   310: aload 5
    //   312: aload 7
    //   314: putfield 90	com/tencent/live2/b/a:b	Ljava/lang/String;
    //   317: aload 5
    //   319: iconst_1
    //   320: putfield 92	com/tencent/live2/b/a:j	Z
    //   323: goto -100 -> 223
    //   326: aload_0
    //   327: ldc 144
    //   329: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   332: ifeq +19 -> 351
    //   335: aload 5
    //   337: aload 7
    //   339: putfield 90	com/tencent/live2/b/a:b	Ljava/lang/String;
    //   342: aload 5
    //   344: iconst_0
    //   345: putfield 92	com/tencent/live2/b/a:j	Z
    //   348: goto -125 -> 223
    //   351: aload_0
    //   352: ldc 146
    //   354: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   357: ifeq +48 -> 405
    //   360: aload 5
    //   362: getfield 33	com/tencent/live2/b/a:k	Lcom/tencent/live2/impl/a$d;
    //   365: getstatic 31	com/tencent/live2/impl/a$d:a	Lcom/tencent/live2/impl/a$d;
    //   368: if_acmpne +20 -> 388
    //   371: aload 5
    //   373: aload 7
    //   375: putfield 148	com/tencent/live2/b/a:h	Ljava/lang/String;
    //   378: aload 5
    //   380: ldc 150
    //   382: putfield 152	com/tencent/live2/b/a:e	Ljava/lang/String;
    //   385: goto -162 -> 223
    //   388: aload 5
    //   390: aload 7
    //   392: putfield 152	com/tencent/live2/b/a:e	Ljava/lang/String;
    //   395: aload 5
    //   397: ldc 154
    //   399: putfield 148	com/tencent/live2/b/a:h	Ljava/lang/String;
    //   402: goto -179 -> 223
    //   405: aload_0
    //   406: ldc 156
    //   408: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   411: ifeq +13 -> 424
    //   414: aload 5
    //   416: aload 7
    //   418: putfield 158	com/tencent/live2/b/a:f	Ljava/lang/String;
    //   421: goto -198 -> 223
    //   424: aload_0
    //   425: ldc 160
    //   427: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   430: ifeq +88 -> 518
    //   433: aload 7
    //   435: ldc 162
    //   437: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   440: ifeq +12 -> 452
    //   443: aload 5
    //   445: iconst_1
    //   446: putfield 25	com/tencent/live2/b/a:c	I
    //   449: goto -226 -> 223
    //   452: aload 7
    //   454: ldc 164
    //   456: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   459: ifeq +12 -> 471
    //   462: aload 5
    //   464: iconst_0
    //   465: putfield 25	com/tencent/live2/b/a:c	I
    //   468: goto -245 -> 223
    //   471: aload 7
    //   473: ldc 166
    //   475: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   478: ifeq +12 -> 490
    //   481: aload 5
    //   483: iconst_2
    //   484: putfield 25	com/tencent/live2/b/a:c	I
    //   487: goto -264 -> 223
    //   490: aload 7
    //   492: ldc 168
    //   494: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   497: ifeq +12 -> 509
    //   500: aload 5
    //   502: iconst_3
    //   503: putfield 25	com/tencent/live2/b/a:c	I
    //   506: goto -283 -> 223
    //   509: aload 5
    //   511: iconst_0
    //   512: putfield 25	com/tencent/live2/b/a:c	I
    //   515: goto -292 -> 223
    //   518: aload_0
    //   519: ldc 170
    //   521: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   524: ifeq +79 -> 603
    //   527: aload 7
    //   529: ldc 172
    //   531: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   534: ifeq +12 -> 546
    //   537: aload 5
    //   539: iconst_0
    //   540: putfield 35	com/tencent/live2/b/a:d	I
    //   543: goto -320 -> 223
    //   546: aload 7
    //   548: ldc 174
    //   550: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   553: ifeq +12 -> 565
    //   556: aload 5
    //   558: iconst_1
    //   559: putfield 35	com/tencent/live2/b/a:d	I
    //   562: goto -339 -> 223
    //   565: aload 7
    //   567: ldc 176
    //   569: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   572: ifeq +12 -> 584
    //   575: aload 5
    //   577: iconst_2
    //   578: putfield 35	com/tencent/live2/b/a:d	I
    //   581: goto -358 -> 223
    //   584: aload 7
    //   586: ldc 178
    //   588: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   591: ifeq -368 -> 223
    //   594: aload 5
    //   596: iconst_3
    //   597: putfield 35	com/tencent/live2/b/a:d	I
    //   600: goto -377 -> 223
    //   603: aload_0
    //   604: ldc 180
    //   606: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   609: ifeq +13 -> 622
    //   612: aload 5
    //   614: aload 7
    //   616: putfield 182	com/tencent/live2/b/a:g	Ljava/lang/String;
    //   619: goto -396 -> 223
    //   622: aload_0
    //   623: ldc 184
    //   625: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   628: ifeq +98 -> 726
    //   631: aload 7
    //   633: invokevirtual 188	java/lang/String:hashCode	()I
    //   636: lookupswitch	default:+122->758, 96964:+75->711, 3343801:+45->681, 109548807:+60->696
    //   673: iconst_2
    //   674: iload_1
    //   675: putfield 27	com/tencent/live2/b/a:i	I
    //   678: goto -455 -> 223
    //   681: aload 7
    //   683: ldc 190
    //   685: invokevirtual 194	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   688: ifeq +70 -> 758
    //   691: iconst_0
    //   692: istore_1
    //   693: goto +67 -> 760
    //   696: aload 7
    //   698: ldc 196
    //   700: invokevirtual 194	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   703: ifeq +55 -> 758
    //   706: iconst_1
    //   707: istore_1
    //   708: goto +52 -> 760
    //   711: aload 7
    //   713: ldc 198
    //   715: invokevirtual 194	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   718: ifeq +40 -> 758
    //   721: iconst_2
    //   722: istore_1
    //   723: goto +37 -> 760
    //   726: aload_0
    //   727: ldc 200
    //   729: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   732: ifeq -509 -> 223
    //   735: aload 5
    //   737: ldc 202
    //   739: aload 7
    //   741: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   744: putfield 92	com/tencent/live2/b/a:j	Z
    //   747: goto -524 -> 223
    //   750: ldc 40
    //   752: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   755: aload 5
    //   757: areturn
    //   758: iconst_m1
    //   759: istore_1
    //   760: iload_1
    //   761: tableswitch	default:+27 -> 788, 0:+32->793, 1:+37->798, 2:+42->803
    //   789: istore_1
    //   790: goto -118 -> 672
    //   793: iconst_0
    //   794: istore_1
    //   795: goto -123 -> 672
    //   798: iconst_1
    //   799: istore_1
    //   800: goto -128 -> 672
    //   803: iconst_2
    //   804: istore_1
    //   805: goto -133 -> 672
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	paramString	String
    //   84	721	1	m	int
    //   91	136	2	n	int
    //   137	6	3	i1	int
    //   206	3	4	bool	boolean
    //   51	705	5	locala	a
    //   59	87	6	arrayOfString	String[]
    //   165	575	7	localObject	Object
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
    //   518	543	247	java/lang/Exception
    //   546	562	247	java/lang/Exception
    //   565	581	247	java/lang/Exception
    //   584	600	247	java/lang/Exception
    //   603	619	247	java/lang/Exception
    //   622	672	247	java/lang/Exception
    //   672	678	247	java/lang/Exception
    //   681	691	247	java/lang/Exception
    //   696	706	247	java/lang/Exception
    //   711	721	247	java/lang/Exception
    //   726	747	247	java/lang/Exception
    //   213	223	270	java/lang/Exception
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public String b()
  {
    return this.h;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public a.d d()
  {
    return this.k;
  }
  
  public boolean e()
  {
    return this.k == a.d.b;
  }
  
  public int f()
  {
    return this.c;
  }
  
  public int g()
  {
    return this.d;
  }
  
  public boolean h()
  {
    AppMethodBeat.i(211400);
    if ((j()) || (i()))
    {
      AppMethodBeat.o(211400);
      return true;
    }
    AppMethodBeat.o(211400);
    return false;
  }
  
  public boolean i()
  {
    AppMethodBeat.i(211406);
    if ((this.k == a.d.b) && (this.a != 0) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)))
    {
      AppMethodBeat.o(211406);
      return true;
    }
    AppMethodBeat.o(211406);
    return false;
  }
  
  public boolean j()
  {
    AppMethodBeat.i(211411);
    if ((this.k == a.d.a) && (!TextUtils.isEmpty(this.h)))
    {
      AppMethodBeat.o(211411);
      return true;
    }
    AppMethodBeat.o(211411);
    return false;
  }
  
  public TRTCCloudDef.TRTCParams k()
  {
    AppMethodBeat.i(211418);
    if ((!i()) && (!j()))
    {
      TXCLog.e("V2-TRTCPlayURLParam", "generate trtc param fail. not trtc protocol.");
      AppMethodBeat.o(211418);
      return null;
    }
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams();
    localTRTCParams.sdkAppId = this.a;
    localTRTCParams.userId = this.e;
    localTRTCParams.userSig = this.f;
    localTRTCParams.role = 21;
    if (this.j) {}
    for (;;)
    {
      try
      {
        localTRTCParams.roomId = Long.valueOf(this.b).intValue();
        if (!TextUtils.isEmpty(this.g)) {
          localTRTCParams.privateMapKey = this.g;
        }
        AppMethodBeat.o(211418);
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
    AppMethodBeat.i(211426);
    String str = "[env:" + this.d + "][sdkAppId:" + this.a + "][roomId:" + this.b + "][isNumRoomId:" + this.j + "][scene:" + this.c + "][userId:" + this.e + "][remoteUserId:" + this.h + "][streamType:" + this.i + "][protocolType:" + this.k + "]";
    AppMethodBeat.o(211426);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.b.a
 * JD-Core Version:    0.7.0.1
 */