package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class p
{
  private RandomAccessFile gaq;
  private RandomAccessFile gar;
  private a gas;
  private ArrayList<a> gat;
  private long pid = 0L;
  
  public p() {}
  
  public p(long paramLong)
  {
    this.pid = paramLong;
  }
  
  /* Error */
  private void aao()
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 37	com/tencent/mm/compatible/deviceinfo/p:gar	Ljava/io/RandomAccessFile;
    //   9: ifnull +160 -> 169
    //   12: aload_0
    //   13: getfield 37	com/tencent/mm/compatible/deviceinfo/p:gar	Ljava/io/RandomAccessFile;
    //   16: lconst_0
    //   17: invokevirtual 42	java/io/RandomAccessFile:seek	(J)V
    //   20: aload_0
    //   21: getfield 37	com/tencent/mm/compatible/deviceinfo/p:gar	Ljava/io/RandomAccessFile;
    //   24: invokevirtual 46	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   27: astore 25
    //   29: aload_0
    //   30: getfield 48	com/tencent/mm/compatible/deviceinfo/p:gaq	Ljava/io/RandomAccessFile;
    //   33: ifnull +552 -> 585
    //   36: aload_0
    //   37: getfield 48	com/tencent/mm/compatible/deviceinfo/p:gaq	Ljava/io/RandomAccessFile;
    //   40: lconst_0
    //   41: invokevirtual 42	java/io/RandomAccessFile:seek	(J)V
    //   44: iconst_m1
    //   45: istore_1
    //   46: aload_0
    //   47: getfield 48	com/tencent/mm/compatible/deviceinfo/p:gaq	Ljava/io/RandomAccessFile;
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
    //   96: getfield 68	com/tencent/mm/compatible/deviceinfo/p:gas	Lcom/tencent/mm/compatible/deviceinfo/p$a;
    //   99: ifnonnull +19 -> 118
    //   102: aload_0
    //   103: new 6	com/tencent/mm/compatible/deviceinfo/p$a
    //   106: dup
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 23	com/tencent/mm/compatible/deviceinfo/p:pid	J
    //   112: invokespecial 71	com/tencent/mm/compatible/deviceinfo/p$a:<init>	(Lcom/tencent/mm/compatible/deviceinfo/p;J)V
    //   115: putfield 68	com/tencent/mm/compatible/deviceinfo/p:gas	Lcom/tencent/mm/compatible/deviceinfo/p$a;
    //   118: aload_0
    //   119: getfield 68	com/tencent/mm/compatible/deviceinfo/p:gas	Lcom/tencent/mm/compatible/deviceinfo/p$a;
    //   122: astore 28
    //   124: aload 28
    //   126: getfield 74	com/tencent/mm/compatible/deviceinfo/p$a:gav	J
    //   129: lconst_0
    //   130: lcmp
    //   131: ifgt +44 -> 175
    //   134: aload 28
    //   136: aload 27
    //   138: invokevirtual 77	com/tencent/mm/compatible/deviceinfo/p$a:i	([Ljava/lang/String;)V
    //   141: aload 26
    //   143: ifnonnull +577 -> 720
    //   146: ldc 29
    //   148: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: astore 25
    //   154: ldc 82
    //   156: ldc 84
    //   158: aload 25
    //   160: invokestatic 88	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 92	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 98	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   221: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   224: aload 28
    //   226: getfield 74	com/tencent/mm/compatible/deviceinfo/p$a:gav	J
    //   229: lcmp
    //   230: ifne +361 -> 591
    //   233: aload 29
    //   235: bipush 13
    //   237: aaload
    //   238: bipush 10
    //   240: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   243: lstore 7
    //   245: aload 29
    //   247: bipush 14
    //   249: aaload
    //   250: bipush 10
    //   252: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   255: lstore 9
    //   257: aload 29
    //   259: bipush 15
    //   261: aaload
    //   262: bipush 10
    //   264: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   267: lstore 11
    //   269: aload 29
    //   271: bipush 16
    //   273: aaload
    //   274: bipush 10
    //   276: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;I)J
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
    //   300: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;I)J
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
    //   326: invokestatic 104	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   329: ladd
    //   330: lstore 5
    //   332: goto +413 -> 745
    //   335: lload 17
    //   337: aload 28
    //   339: getfield 107	com/tencent/mm/compatible/deviceinfo/p$a:mLastIdle	J
    //   342: lsub
    //   343: lstore 19
    //   345: lload 5
    //   347: aload 28
    //   349: getfield 110	com/tencent/mm/compatible/deviceinfo/p$a:gau	J
    //   352: lsub
    //   353: lstore 21
    //   355: lload 15
    //   357: aload 28
    //   359: getfield 113	com/tencent/mm/compatible/deviceinfo/p$a:gaw	J
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
    //   377: ldc 114
    //   379: fmul
    //   380: f2i
    //   381: putfield 118	com/tencent/mm/compatible/deviceinfo/p$a:KD	I
    //   384: aload 28
    //   386: lload 23
    //   388: l2f
    //   389: lload 21
    //   391: l2f
    //   392: fdiv
    //   393: ldc 114
    //   395: fmul
    //   396: f2i
    //   397: putfield 121	com/tencent/mm/compatible/deviceinfo/p$a:gax	I
    //   400: aload 28
    //   402: lload 5
    //   404: putfield 110	com/tencent/mm/compatible/deviceinfo/p$a:gau	J
    //   407: aload 28
    //   409: lload 17
    //   411: putfield 107	com/tencent/mm/compatible/deviceinfo/p$a:mLastIdle	J
    //   414: aload 28
    //   416: lload 15
    //   418: putfield 113	com/tencent/mm/compatible/deviceinfo/p$a:gaw	J
    //   421: ldc 82
    //   423: ldc 123
    //   425: bipush 14
    //   427: anewarray 4	java/lang/Object
    //   430: dup
    //   431: iconst_0
    //   432: aload 28
    //   434: invokevirtual 126	java/lang/Object:hashCode	()I
    //   437: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: dup
    //   442: iconst_1
    //   443: lload 5
    //   445: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   448: aastore
    //   449: dup
    //   450: iconst_2
    //   451: lload 17
    //   453: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   456: aastore
    //   457: dup
    //   458: iconst_3
    //   459: aload 28
    //   461: getfield 118	com/tencent/mm/compatible/deviceinfo/p$a:KD	I
    //   464: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: aastore
    //   468: dup
    //   469: iconst_4
    //   470: aload 28
    //   472: getfield 74	com/tencent/mm/compatible/deviceinfo/p$a:gav	J
    //   475: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   478: aastore
    //   479: dup
    //   480: iconst_5
    //   481: lload 15
    //   483: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   486: aastore
    //   487: dup
    //   488: bipush 6
    //   490: aload 28
    //   492: getfield 121	com/tencent/mm/compatible/deviceinfo/p$a:gax	I
    //   495: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aastore
    //   499: dup
    //   500: bipush 7
    //   502: lload 7
    //   504: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   507: aastore
    //   508: dup
    //   509: bipush 8
    //   511: lload 9
    //   513: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   516: aastore
    //   517: dup
    //   518: bipush 9
    //   520: lload 11
    //   522: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   525: aastore
    //   526: dup
    //   527: bipush 10
    //   529: lload 13
    //   531: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   534: aastore
    //   535: dup
    //   536: bipush 11
    //   538: lload 21
    //   540: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   543: aastore
    //   544: dup
    //   545: bipush 12
    //   547: lload 19
    //   549: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   552: aastore
    //   553: dup
    //   554: bipush 13
    //   556: lload 23
    //   558: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   561: aastore
    //   562: invokestatic 137	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   565: goto -424 -> 141
    //   568: astore 25
    //   570: ldc 82
    //   572: ldc 139
    //   574: aload 25
    //   576: invokestatic 88	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   579: invokevirtual 92	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   582: invokestatic 98	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: ldc 29
    //   587: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   590: return
    //   591: ldc 82
    //   593: ldc 141
    //   595: iconst_2
    //   596: anewarray 4	java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: aload 28
    //   603: getfield 74	com/tencent/mm/compatible/deviceinfo/p$a:gav	J
    //   606: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   609: aastore
    //   610: dup
    //   611: iconst_1
    //   612: aload 25
    //   614: aastore
    //   615: invokestatic 143	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: goto -477 -> 141
    //   621: aload_0
    //   622: getfield 145	com/tencent/mm/compatible/deviceinfo/p:gat	Ljava/util/ArrayList;
    //   625: ifnonnull +14 -> 639
    //   628: aload_0
    //   629: new 147	java/util/ArrayList
    //   632: dup
    //   633: invokespecial 148	java/util/ArrayList:<init>	()V
    //   636: putfield 145	com/tencent/mm/compatible/deviceinfo/p:gat	Ljava/util/ArrayList;
    //   639: iload_1
    //   640: aload_0
    //   641: getfield 145	com/tencent/mm/compatible/deviceinfo/p:gat	Ljava/util/ArrayList;
    //   644: invokevirtual 151	java/util/ArrayList:size	()I
    //   647: if_icmpge +22 -> 669
    //   650: aload_0
    //   651: getfield 145	com/tencent/mm/compatible/deviceinfo/p:gat	Ljava/util/ArrayList;
    //   654: iload_1
    //   655: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   658: checkcast 6	com/tencent/mm/compatible/deviceinfo/p$a
    //   661: aload 27
    //   663: invokevirtual 77	com/tencent/mm/compatible/deviceinfo/p$a:i	([Ljava/lang/String;)V
    //   666: goto -525 -> 141
    //   669: new 6	com/tencent/mm/compatible/deviceinfo/p$a
    //   672: dup
    //   673: aload_0
    //   674: invokespecial 158	com/tencent/mm/compatible/deviceinfo/p$a:<init>	(Lcom/tencent/mm/compatible/deviceinfo/p;)V
    //   677: astore 28
    //   679: aload 28
    //   681: aload 27
    //   683: invokevirtual 77	com/tencent/mm/compatible/deviceinfo/p$a:i	([Ljava/lang/String;)V
    //   686: aload_0
    //   687: getfield 145	com/tencent/mm/compatible/deviceinfo/p:gat	Ljava/util/ArrayList;
    //   690: aload 28
    //   692: invokevirtual 162	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   695: pop
    //   696: goto -555 -> 141
    //   699: ldc 82
    //   701: ldc 164
    //   703: iconst_1
    //   704: anewarray 4	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: iload_1
    //   710: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   713: aastore
    //   714: invokestatic 143	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      this.gaq = i.dd("/proc/stat", false);
      if (this.pid > 0L) {
        this.gar = i.dd("/proc/" + this.pid + "/stat", false);
      }
      aao();
      if (this.gaq != null) {
        this.gaq.close();
      }
      if (this.gar != null) {
        this.gar.close();
      }
      AppMethodBeat.o(155679);
      return;
    }
    catch (Exception localException1)
    {
      ad.printErrStackTrace(" MicroMsg.CpuUsage", localException1, "update e:", new Object[0]);
      if (this.gaq == null) {}
    }
    try
    {
      this.gaq.close();
      label121:
      this.gaq = null;
      if (this.gar != null) {}
      try
      {
        this.gar.close();
        label140:
        this.gar = null;
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
  
  public final int aap()
  {
    AppMethodBeat.i(195148);
    update();
    int i = 0;
    if (this.gas != null) {
      i = this.gas.KD;
    }
    AppMethodBeat.o(195148);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(155684);
    update();
    Object localObject = new StringBuffer();
    if (this.gas != null)
    {
      ((StringBuffer)localObject).append("Cpu Total : ");
      ((StringBuffer)localObject).append(this.gas.KD);
      ((StringBuffer)localObject).append("%");
      if (this.pid > 0L)
      {
        ((StringBuffer)localObject).append("pid(");
        ((StringBuffer)localObject).append(this.pid + ") :");
        ((StringBuffer)localObject).append(this.gas.gax);
        ((StringBuffer)localObject).append("%");
      }
    }
    if (this.gat != null)
    {
      int i = 0;
      while (i < this.gat.size())
      {
        a locala = (a)this.gat.get(i);
        ((StringBuffer)localObject).append(" Cpu Core(" + i + ") : ");
        ((StringBuffer)localObject).append(locala.KD);
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
    int KD;
    long gau;
    long gav;
    long gaw;
    int gax;
    long mLastIdle;
    
    public a()
    {
      this.KD = 0;
      this.gau = 0L;
      this.mLastIdle = 0L;
      this.gav = 0L;
      this.gaw = 0L;
      this.gax = 0;
    }
    
    public a(long paramLong)
    {
      this.gav = paramLong;
    }
    
    public final void i(String[] paramArrayOfString)
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
      long l4 = l1 - this.gau;
      this.KD = ((int)((float)(l4 - (l2 - l3)) / (float)l4 * 100.0F));
      this.gau = l1;
      this.mLastIdle = l2;
      ad.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + l1 + "; idle=" + l2 + "; usage=" + this.KD);
      AppMethodBeat.o(155678);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.p
 * JD-Core Version:    0.7.0.1
 */