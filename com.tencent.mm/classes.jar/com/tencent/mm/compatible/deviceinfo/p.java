package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class p
{
  private RandomAccessFile lVD;
  private RandomAccessFile lVE;
  private a lVF;
  private ArrayList<a> lVG;
  private long pid = 0L;
  
  public p() {}
  
  public p(long paramLong)
  {
    this.pid = paramLong;
  }
  
  /* Error */
  private void aOU()
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 37	com/tencent/mm/compatible/deviceinfo/p:lVE	Ljava/io/RandomAccessFile;
    //   9: ifnull +160 -> 169
    //   12: aload_0
    //   13: getfield 37	com/tencent/mm/compatible/deviceinfo/p:lVE	Ljava/io/RandomAccessFile;
    //   16: lconst_0
    //   17: invokevirtual 42	java/io/RandomAccessFile:seek	(J)V
    //   20: aload_0
    //   21: getfield 37	com/tencent/mm/compatible/deviceinfo/p:lVE	Ljava/io/RandomAccessFile;
    //   24: invokevirtual 46	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   27: astore 25
    //   29: aload_0
    //   30: getfield 48	com/tencent/mm/compatible/deviceinfo/p:lVD	Ljava/io/RandomAccessFile;
    //   33: ifnull +552 -> 585
    //   36: aload_0
    //   37: getfield 48	com/tencent/mm/compatible/deviceinfo/p:lVD	Ljava/io/RandomAccessFile;
    //   40: lconst_0
    //   41: invokevirtual 42	java/io/RandomAccessFile:seek	(J)V
    //   44: iconst_m1
    //   45: istore_1
    //   46: aload_0
    //   47: getfield 48	com/tencent/mm/compatible/deviceinfo/p:lVD	Ljava/io/RandomAccessFile;
    //   50: invokevirtual 46	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   53: astore 26
    //   55: aload 26
    //   57: ifnull +642 -> 699
    //   60: aload 26
    //   62: invokevirtual 54	java/lang/String:length	()I
    //   65: ifle +634 -> 699
    //   68: aload 26
    //   70: ldc 56
    //   72: invokevirtual 60	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   75: astore 27
    //   77: aload 27
    //   79: iconst_0
    //   80: aaload
    //   81: ldc 62
    //   83: invokevirtual 66	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   86: iconst_m1
    //   87: if_icmpeq +54 -> 141
    //   90: iload_1
    //   91: iconst_m1
    //   92: if_icmpne +529 -> 621
    //   95: aload_0
    //   96: getfield 68	com/tencent/mm/compatible/deviceinfo/p:lVF	Lcom/tencent/mm/compatible/deviceinfo/p$a;
    //   99: ifnonnull +19 -> 118
    //   102: aload_0
    //   103: new 6	com/tencent/mm/compatible/deviceinfo/p$a
    //   106: dup
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 23	com/tencent/mm/compatible/deviceinfo/p:pid	J
    //   112: invokespecial 71	com/tencent/mm/compatible/deviceinfo/p$a:<init>	(Lcom/tencent/mm/compatible/deviceinfo/p;J)V
    //   115: putfield 68	com/tencent/mm/compatible/deviceinfo/p:lVF	Lcom/tencent/mm/compatible/deviceinfo/p$a;
    //   118: aload_0
    //   119: getfield 68	com/tencent/mm/compatible/deviceinfo/p:lVF	Lcom/tencent/mm/compatible/deviceinfo/p$a;
    //   122: astore 28
    //   124: aload 28
    //   126: getfield 74	com/tencent/mm/compatible/deviceinfo/p$a:lVI	J
    //   129: lconst_0
    //   130: lcmp
    //   131: ifgt +44 -> 175
    //   134: aload 28
    //   136: aload 27
    //   138: invokevirtual 78	com/tencent/mm/compatible/deviceinfo/p$a:g	([Ljava/lang/String;)V
    //   141: aload 26
    //   143: ifnonnull +577 -> 720
    //   146: ldc 29
    //   148: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: astore 25
    //   154: ldc 83
    //   156: ldc 85
    //   158: aload 25
    //   160: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aconst_null
    //   170: astore 25
    //   172: goto -143 -> 29
    //   175: aload 25
    //   177: ifnull +414 -> 591
    //   180: aload 25
    //   182: invokevirtual 54	java/lang/String:length	()I
    //   185: ifle +406 -> 591
    //   188: aload 25
    //   190: ldc 56
    //   192: invokevirtual 60	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   195: astore 29
    //   197: aload 29
    //   199: ifnull +392 -> 591
    //   202: aload 29
    //   204: arraylength
    //   205: ifle +386 -> 591
    //   208: aload 29
    //   210: iconst_0
    //   211: aaload
    //   212: ifnull +379 -> 591
    //   215: aload 29
    //   217: iconst_0
    //   218: aaload
    //   219: bipush 10
    //   221: invokestatic 105	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   224: aload 28
    //   226: getfield 74	com/tencent/mm/compatible/deviceinfo/p$a:lVI	J
    //   229: lcmp
    //   230: ifne +361 -> 591
    //   233: aload 29
    //   235: bipush 13
    //   237: aaload
    //   238: bipush 10
    //   240: invokestatic 105	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   243: lstore 7
    //   245: aload 29
    //   247: bipush 14
    //   249: aaload
    //   250: bipush 10
    //   252: invokestatic 105	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   255: lstore 9
    //   257: aload 29
    //   259: bipush 15
    //   261: aaload
    //   262: bipush 10
    //   264: invokestatic 105	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   267: lstore 11
    //   269: aload 29
    //   271: bipush 16
    //   273: aaload
    //   274: bipush 10
    //   276: invokestatic 105	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   279: lstore 13
    //   281: lload 7
    //   283: lload 9
    //   285: ladd
    //   286: lload 11
    //   288: ladd
    //   289: lload 13
    //   291: ladd
    //   292: lstore 15
    //   294: aload 27
    //   296: iconst_4
    //   297: aaload
    //   298: bipush 10
    //   300: invokestatic 105	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   303: lstore 17
    //   305: lconst_0
    //   306: lstore 5
    //   308: iconst_1
    //   309: istore_2
    //   310: aload 27
    //   312: arraylength
    //   313: istore 4
    //   315: iconst_0
    //   316: istore_3
    //   317: goto +410 -> 727
    //   320: lload 5
    //   322: aload 29
    //   324: bipush 10
    //   326: invokestatic 105	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   329: ladd
    //   330: lstore 5
    //   332: goto +413 -> 745
    //   335: lload 17
    //   337: aload 28
    //   339: getfield 108	com/tencent/mm/compatible/deviceinfo/p$a:mLastIdle	J
    //   342: lsub
    //   343: lstore 19
    //   345: lload 5
    //   347: aload 28
    //   349: getfield 111	com/tencent/mm/compatible/deviceinfo/p$a:lVH	J
    //   352: lsub
    //   353: lstore 21
    //   355: lload 15
    //   357: aload 28
    //   359: getfield 114	com/tencent/mm/compatible/deviceinfo/p$a:lVJ	J
    //   362: lsub
    //   363: lstore 23
    //   365: aload 28
    //   367: lload 21
    //   369: lload 19
    //   371: lsub
    //   372: l2f
    //   373: lload 21
    //   375: l2f
    //   376: fdiv
    //   377: ldc 115
    //   379: fmul
    //   380: f2i
    //   381: putfield 119	com/tencent/mm/compatible/deviceinfo/p$a:bJu	I
    //   384: aload 28
    //   386: lload 23
    //   388: l2f
    //   389: lload 21
    //   391: l2f
    //   392: fdiv
    //   393: ldc 115
    //   395: fmul
    //   396: f2i
    //   397: putfield 122	com/tencent/mm/compatible/deviceinfo/p$a:lVK	I
    //   400: aload 28
    //   402: lload 5
    //   404: putfield 111	com/tencent/mm/compatible/deviceinfo/p$a:lVH	J
    //   407: aload 28
    //   409: lload 17
    //   411: putfield 108	com/tencent/mm/compatible/deviceinfo/p$a:mLastIdle	J
    //   414: aload 28
    //   416: lload 15
    //   418: putfield 114	com/tencent/mm/compatible/deviceinfo/p$a:lVJ	J
    //   421: ldc 83
    //   423: ldc 124
    //   425: bipush 14
    //   427: anewarray 4	java/lang/Object
    //   430: dup
    //   431: iconst_0
    //   432: aload 28
    //   434: invokevirtual 127	java/lang/Object:hashCode	()I
    //   437: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: dup
    //   442: iconst_1
    //   443: lload 5
    //   445: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   448: aastore
    //   449: dup
    //   450: iconst_2
    //   451: lload 17
    //   453: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   456: aastore
    //   457: dup
    //   458: iconst_3
    //   459: aload 28
    //   461: getfield 119	com/tencent/mm/compatible/deviceinfo/p$a:bJu	I
    //   464: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: aastore
    //   468: dup
    //   469: iconst_4
    //   470: aload 28
    //   472: getfield 74	com/tencent/mm/compatible/deviceinfo/p$a:lVI	J
    //   475: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   478: aastore
    //   479: dup
    //   480: iconst_5
    //   481: lload 15
    //   483: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   486: aastore
    //   487: dup
    //   488: bipush 6
    //   490: aload 28
    //   492: getfield 122	com/tencent/mm/compatible/deviceinfo/p$a:lVK	I
    //   495: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aastore
    //   499: dup
    //   500: bipush 7
    //   502: lload 7
    //   504: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   507: aastore
    //   508: dup
    //   509: bipush 8
    //   511: lload 9
    //   513: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   516: aastore
    //   517: dup
    //   518: bipush 9
    //   520: lload 11
    //   522: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   525: aastore
    //   526: dup
    //   527: bipush 10
    //   529: lload 13
    //   531: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   534: aastore
    //   535: dup
    //   536: bipush 11
    //   538: lload 21
    //   540: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   543: aastore
    //   544: dup
    //   545: bipush 12
    //   547: lload 19
    //   549: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   552: aastore
    //   553: dup
    //   554: bipush 13
    //   556: lload 23
    //   558: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   561: aastore
    //   562: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   565: goto -424 -> 141
    //   568: astore 25
    //   570: ldc 83
    //   572: ldc 140
    //   574: aload 25
    //   576: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   579: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   582: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: ldc 29
    //   587: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   590: return
    //   591: ldc 83
    //   593: ldc 142
    //   595: iconst_2
    //   596: anewarray 4	java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: aload 28
    //   603: getfield 74	com/tencent/mm/compatible/deviceinfo/p$a:lVI	J
    //   606: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   609: aastore
    //   610: dup
    //   611: iconst_1
    //   612: aload 25
    //   614: aastore
    //   615: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: goto -477 -> 141
    //   621: aload_0
    //   622: getfield 146	com/tencent/mm/compatible/deviceinfo/p:lVG	Ljava/util/ArrayList;
    //   625: ifnonnull +14 -> 639
    //   628: aload_0
    //   629: new 148	java/util/ArrayList
    //   632: dup
    //   633: invokespecial 149	java/util/ArrayList:<init>	()V
    //   636: putfield 146	com/tencent/mm/compatible/deviceinfo/p:lVG	Ljava/util/ArrayList;
    //   639: iload_1
    //   640: aload_0
    //   641: getfield 146	com/tencent/mm/compatible/deviceinfo/p:lVG	Ljava/util/ArrayList;
    //   644: invokevirtual 152	java/util/ArrayList:size	()I
    //   647: if_icmpge +22 -> 669
    //   650: aload_0
    //   651: getfield 146	com/tencent/mm/compatible/deviceinfo/p:lVG	Ljava/util/ArrayList;
    //   654: iload_1
    //   655: invokevirtual 156	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   658: checkcast 6	com/tencent/mm/compatible/deviceinfo/p$a
    //   661: aload 27
    //   663: invokevirtual 78	com/tencent/mm/compatible/deviceinfo/p$a:g	([Ljava/lang/String;)V
    //   666: goto -525 -> 141
    //   669: new 6	com/tencent/mm/compatible/deviceinfo/p$a
    //   672: dup
    //   673: aload_0
    //   674: invokespecial 159	com/tencent/mm/compatible/deviceinfo/p$a:<init>	(Lcom/tencent/mm/compatible/deviceinfo/p;)V
    //   677: astore 28
    //   679: aload 28
    //   681: aload 27
    //   683: invokevirtual 78	com/tencent/mm/compatible/deviceinfo/p$a:g	([Ljava/lang/String;)V
    //   686: aload_0
    //   687: getfield 146	com/tencent/mm/compatible/deviceinfo/p:lVG	Ljava/util/ArrayList;
    //   690: aload 28
    //   692: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   695: pop
    //   696: goto -555 -> 141
    //   699: ldc 83
    //   701: ldc 165
    //   703: iconst_1
    //   704: anewarray 4	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: iload_1
    //   710: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   713: aastore
    //   714: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   717: goto -576 -> 141
    //   720: iload_1
    //   721: iconst_1
    //   722: iadd
    //   723: istore_1
    //   724: goto -678 -> 46
    //   727: iload_3
    //   728: iload 4
    //   730: if_icmpge -395 -> 335
    //   733: aload 27
    //   735: iload_3
    //   736: aaload
    //   737: astore 29
    //   739: iload_2
    //   740: ifeq -420 -> 320
    //   743: iconst_0
    //   744: istore_2
    //   745: iload_3
    //   746: iconst_1
    //   747: iadd
    //   748: istore_3
    //   749: goto -22 -> 727
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	752	0	this	p
    //   45	679	1	i	int
    //   309	436	2	j	int
    //   316	433	3	k	int
    //   313	418	4	m	int
    //   306	138	5	l1	long
    //   243	260	7	l2	long
    //   255	257	9	l3	long
    //   267	254	11	l4	long
    //   279	251	13	l5	long
    //   292	190	15	l6	long
    //   303	149	17	l7	long
    //   343	205	19	l8	long
    //   353	186	21	l9	long
    //   363	194	23	l10	long
    //   27	1	25	str1	String
    //   152	7	25	localIOException1	java.io.IOException
    //   170	19	25	localObject1	Object
    //   568	45	25	localIOException2	java.io.IOException
    //   53	89	26	str2	String
    //   75	659	27	arrayOfString	String[]
    //   122	569	28	locala	a
    //   195	543	29	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	29	152	java/io/IOException
    //   36	44	568	java/io/IOException
    //   46	55	568	java/io/IOException
    //   60	90	568	java/io/IOException
    //   95	118	568	java/io/IOException
    //   118	141	568	java/io/IOException
    //   180	197	568	java/io/IOException
    //   202	208	568	java/io/IOException
    //   215	281	568	java/io/IOException
    //   294	305	568	java/io/IOException
    //   310	315	568	java/io/IOException
    //   320	332	568	java/io/IOException
    //   335	565	568	java/io/IOException
    //   591	618	568	java/io/IOException
    //   621	639	568	java/io/IOException
    //   639	666	568	java/io/IOException
    //   669	696	568	java/io/IOException
    //   699	717	568	java/io/IOException
  }
  
  private void update()
  {
    AppMethodBeat.i(155679);
    try
    {
      this.lVD = y.eA("/proc/stat", false);
      if (this.pid > 0L) {
        this.lVE = y.eA("/proc/" + this.pid + "/stat", false);
      }
      aOU();
      if (this.lVD != null) {
        this.lVD.close();
      }
      if (this.lVE != null) {
        this.lVE.close();
      }
      AppMethodBeat.o(155679);
      return;
    }
    catch (Exception localException1)
    {
      Log.printErrStackTrace(" MicroMsg.CpuUsage", localException1, "update e:", new Object[0]);
      if (this.lVD == null) {}
    }
    try
    {
      this.lVD.close();
      label121:
      this.lVD = null;
      if (this.lVE != null) {}
      try
      {
        this.lVE.close();
        label140:
        this.lVE = null;
        AppMethodBeat.o(155679);
        return;
      }
      catch (Exception localException2)
      {
        break label140;
      }
    }
    catch (Exception localException3)
    {
      break label121;
    }
  }
  
  public final int aOV()
  {
    AppMethodBeat.i(240871);
    update();
    int i = 0;
    if (this.lVF != null) {
      i = this.lVF.bJu;
    }
    AppMethodBeat.o(240871);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(155684);
    update();
    Object localObject = new StringBuffer();
    if (this.lVF != null)
    {
      ((StringBuffer)localObject).append("Cpu Total : ");
      ((StringBuffer)localObject).append(this.lVF.bJu);
      ((StringBuffer)localObject).append("%");
      if (this.pid > 0L)
      {
        ((StringBuffer)localObject).append("pid(");
        ((StringBuffer)localObject).append(this.pid + ") :");
        ((StringBuffer)localObject).append(this.lVF.lVK);
        ((StringBuffer)localObject).append("%");
      }
    }
    if (this.lVG != null)
    {
      int i = 0;
      while (i < this.lVG.size())
      {
        a locala = (a)this.lVG.get(i);
        ((StringBuffer)localObject).append(" Cpu Core(" + i + ") : ");
        ((StringBuffer)localObject).append(locala.bJu);
        ((StringBuffer)localObject).append("%");
        i += 1;
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155684);
    return localObject;
  }
  
  public final class a
  {
    int bJu;
    long lVH;
    long lVI;
    long lVJ;
    int lVK;
    long mLastIdle;
    
    public a()
    {
      this.bJu = 0;
      this.lVH = 0L;
      this.mLastIdle = 0L;
      this.lVI = 0L;
      this.lVJ = 0L;
      this.lVK = 0;
    }
    
    public a(long paramLong)
    {
      this.lVI = paramLong;
    }
    
    public final void g(String[] paramArrayOfString)
    {
      AppMethodBeat.i(155678);
      long l2 = Long.parseLong(paramArrayOfString[4], 10);
      long l1 = 0L;
      int j = 1;
      int k = paramArrayOfString.length;
      int i = 0;
      if (i < k)
      {
        String str = paramArrayOfString[i];
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          l1 += Long.parseLong(str, 10);
        }
      }
      long l3 = this.mLastIdle;
      long l4 = l1 - this.lVH;
      this.bJu = ((int)((float)(l4 - (l2 - l3)) / (float)l4 * 100.0F));
      this.lVH = l1;
      this.mLastIdle = l2;
      Log.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + l1 + "; idle=" + l2 + "; usage=" + this.bJu);
      AppMethodBeat.o(155678);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.p
 * JD-Core Version:    0.7.0.1
 */