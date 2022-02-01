package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.StrictMode.ThreadPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public abstract class q
  extends e
{
  protected String cDq;
  String[] cDr;
  private final Map<String, Object> cDs = new HashMap();
  protected final Context mContext;
  
  protected q(Context paramContext, String paramString)
  {
    super(l(paramContext, paramString), 1);
    this.mContext = paramContext;
  }
  
  /* Error */
  private void a(byte paramByte, b paramb, d paramd)
  {
    // Byte code:
    //   0: new 59	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 61
    //   6: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 70	java/lang/Object:getClass	()Ljava/lang/Class;
    //   13: invokevirtual 76	java/lang/Class:getName	()Ljava/lang/String;
    //   16: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: new 82	java/io/RandomAccessFile
    //   23: dup
    //   24: new 84	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   32: ldc 90
    //   34: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: ldc 95
    //   39: invokespecial 96	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: astore 12
    //   44: aconst_null
    //   45: astore 9
    //   47: aload 9
    //   49: astore 8
    //   51: iload_1
    //   52: iconst_1
    //   53: if_icmpne +10 -> 63
    //   56: aload 12
    //   58: invokestatic 99	com/facebook/soloader/q$b:a	(Ljava/io/DataInput;)Lcom/facebook/soloader/q$b;
    //   61: astore 8
    //   63: aload 8
    //   65: ifnonnull +808 -> 873
    //   68: new 11	com/facebook/soloader/q$b
    //   71: dup
    //   72: iconst_0
    //   73: anewarray 8	com/facebook/soloader/q$a
    //   76: invokespecial 102	com/facebook/soloader/q$b:<init>	([Lcom/facebook/soloader/q$a;)V
    //   79: astore 10
    //   81: aload_0
    //   82: aload_2
    //   83: getfield 106	com/facebook/soloader/q$b:cDA	[Lcom/facebook/soloader/q$a;
    //   86: invokespecial 108	com/facebook/soloader/q:a	([Lcom/facebook/soloader/q$a;)V
    //   89: ldc 109
    //   91: newarray byte
    //   93: astore 15
    //   95: aload_3
    //   96: invokevirtual 113	com/facebook/soloader/q$d:hasNext	()Z
    //   99: ifeq +720 -> 819
    //   102: aload_3
    //   103: invokevirtual 117	com/facebook/soloader/q$d:PY	()Lcom/facebook/soloader/q$c;
    //   106: astore 13
    //   108: iconst_1
    //   109: istore_1
    //   110: iconst_0
    //   111: istore 4
    //   113: iload_1
    //   114: ifeq +82 -> 196
    //   117: iload 4
    //   119: aload 10
    //   121: getfield 106	com/facebook/soloader/q$b:cDA	[Lcom/facebook/soloader/q$a;
    //   124: arraylength
    //   125: if_icmpge +71 -> 196
    //   128: aload 13
    //   130: invokeinterface 121 1 0
    //   135: getfield 124	com/facebook/soloader/q$a:name	Ljava/lang/String;
    //   138: astore_2
    //   139: iload_1
    //   140: istore 5
    //   142: aload 10
    //   144: getfield 106	com/facebook/soloader/q$b:cDA	[Lcom/facebook/soloader/q$a;
    //   147: iload 4
    //   149: aaload
    //   150: getfield 124	com/facebook/soloader/q$a:name	Ljava/lang/String;
    //   153: aload_2
    //   154: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifeq +723 -> 880
    //   160: iload_1
    //   161: istore 5
    //   163: aload 10
    //   165: getfield 106	com/facebook/soloader/q$b:cDA	[Lcom/facebook/soloader/q$a;
    //   168: iload 4
    //   170: aaload
    //   171: getfield 133	com/facebook/soloader/q$a:cDz	Ljava/lang/String;
    //   174: aload 13
    //   176: invokeinterface 121 1 0
    //   181: getfield 133	com/facebook/soloader/q$a:cDz	Ljava/lang/String;
    //   184: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +693 -> 880
    //   190: iconst_0
    //   191: istore 5
    //   193: goto +687 -> 880
    //   196: new 84	java/io/File
    //   199: dup
    //   200: aload_0
    //   201: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   204: aload 13
    //   206: invokeinterface 136 1 0
    //   211: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   214: invokevirtual 139	java/io/File:exists	()Z
    //   217: ifne +5 -> 222
    //   220: iconst_1
    //   221: istore_1
    //   222: iload_1
    //   223: ifeq +560 -> 783
    //   226: new 59	java/lang/StringBuilder
    //   229: dup
    //   230: ldc 141
    //   232: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload 13
    //   237: invokeinterface 121 1 0
    //   242: getfield 124	com/facebook/soloader/q$a:name	Ljava/lang/String;
    //   245: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_0
    //   250: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   253: iconst_1
    //   254: invokevirtual 145	java/io/File:setWritable	(Z)Z
    //   257: ifne +106 -> 363
    //   260: new 57	java/io/IOException
    //   263: dup
    //   264: new 59	java/lang/StringBuilder
    //   267: dup
    //   268: ldc 147
    //   270: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   273: aload_0
    //   274: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   277: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokespecial 154	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   286: athrow
    //   287: astore_2
    //   288: aload_0
    //   289: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   292: iconst_0
    //   293: invokevirtual 145	java/io/File:setWritable	(Z)Z
    //   296: ifne +28 -> 324
    //   299: new 59	java/lang/StringBuilder
    //   302: dup
    //   303: ldc 156
    //   305: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload_0
    //   309: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   312: invokevirtual 159	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   315: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc 161
    //   320: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_2
    //   325: athrow
    //   326: astore_2
    //   327: aload_2
    //   328: athrow
    //   329: astore_3
    //   330: aload 13
    //   332: ifnull +14 -> 346
    //   335: aload_2
    //   336: ifnull +473 -> 809
    //   339: aload 13
    //   341: invokeinterface 164 1 0
    //   346: aload_3
    //   347: athrow
    //   348: astore_2
    //   349: aload_2
    //   350: athrow
    //   351: astore_3
    //   352: aload_2
    //   353: ifnull +503 -> 856
    //   356: aload 12
    //   358: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   361: aload_3
    //   362: athrow
    //   363: new 84	java/io/File
    //   366: dup
    //   367: aload_0
    //   368: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   371: aload 13
    //   373: invokeinterface 136 1 0
    //   378: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   381: astore 14
    //   383: aconst_null
    //   384: astore 11
    //   386: aconst_null
    //   387: astore_2
    //   388: aload_2
    //   389: astore 9
    //   391: aload 11
    //   393: astore 8
    //   395: aload 14
    //   397: invokevirtual 139	java/io/File:exists	()Z
    //   400: ifeq +41 -> 441
    //   403: aload_2
    //   404: astore 9
    //   406: aload 11
    //   408: astore 8
    //   410: aload 14
    //   412: iconst_1
    //   413: invokevirtual 145	java/io/File:setWritable	(Z)Z
    //   416: ifne +25 -> 441
    //   419: aload_2
    //   420: astore 9
    //   422: aload 11
    //   424: astore 8
    //   426: new 59	java/lang/StringBuilder
    //   429: dup
    //   430: ldc 167
    //   432: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   435: aload 14
    //   437: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 11
    //   443: astore 8
    //   445: new 82	java/io/RandomAccessFile
    //   448: dup
    //   449: aload 14
    //   451: ldc 95
    //   453: invokespecial 96	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   456: astore 9
    //   458: aload 9
    //   460: astore_2
    //   461: aload_2
    //   462: astore 9
    //   464: aload_2
    //   465: astore 8
    //   467: aload 13
    //   469: invokeinterface 171 1 0
    //   474: istore_1
    //   475: iload_1
    //   476: iconst_1
    //   477: if_icmple +46 -> 523
    //   480: aload_2
    //   481: astore 9
    //   483: aload_2
    //   484: astore 8
    //   486: aload_2
    //   487: invokevirtual 175	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   490: astore 11
    //   492: iload_1
    //   493: i2l
    //   494: lstore 6
    //   496: aload_2
    //   497: astore 9
    //   499: aload_2
    //   500: astore 8
    //   502: getstatic 181	android/os/Build$VERSION:SDK_INT	I
    //   505: bipush 21
    //   507: if_icmplt +16 -> 523
    //   510: aload_2
    //   511: astore 9
    //   513: aload_2
    //   514: astore 8
    //   516: aload 11
    //   518: lload 6
    //   520: invokestatic 187	com/facebook/soloader/SysUtil$LollipopSysdeps:fallocateIfSupported	(Ljava/io/FileDescriptor;J)V
    //   523: aload_2
    //   524: astore 9
    //   526: aload_2
    //   527: astore 8
    //   529: aload 13
    //   531: aload_2
    //   532: aload 15
    //   534: invokeinterface 190 3 0
    //   539: aload_2
    //   540: astore 9
    //   542: aload_2
    //   543: astore 8
    //   545: aload_2
    //   546: aload_2
    //   547: invokevirtual 194	java/io/RandomAccessFile:getFilePointer	()J
    //   550: invokevirtual 198	java/io/RandomAccessFile:setLength	(J)V
    //   553: aload_2
    //   554: astore 9
    //   556: aload_2
    //   557: astore 8
    //   559: aload 14
    //   561: iconst_1
    //   562: iconst_0
    //   563: invokevirtual 202	java/io/File:setExecutable	(ZZ)Z
    //   566: ifne +148 -> 714
    //   569: aload_2
    //   570: astore 9
    //   572: aload_2
    //   573: astore 8
    //   575: new 57	java/io/IOException
    //   578: dup
    //   579: ldc 204
    //   581: aload 14
    //   583: invokestatic 208	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   586: invokevirtual 212	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   589: invokespecial 154	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   592: athrow
    //   593: astore_2
    //   594: aload 9
    //   596: astore 8
    //   598: aload 14
    //   600: invokestatic 218	com/facebook/soloader/SysUtil:v	(Ljava/io/File;)V
    //   603: aload 9
    //   605: astore 8
    //   607: aload_2
    //   608: athrow
    //   609: astore_2
    //   610: aload 14
    //   612: iconst_0
    //   613: invokevirtual 145	java/io/File:setWritable	(Z)Z
    //   616: ifne +23 -> 639
    //   619: new 59	java/lang/StringBuilder
    //   622: dup
    //   623: ldc 156
    //   625: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   628: aload 14
    //   630: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   633: ldc 161
    //   635: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload 8
    //   641: ifnull +8 -> 649
    //   644: aload 8
    //   646: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   649: aload_2
    //   650: athrow
    //   651: astore 8
    //   653: aload_2
    //   654: astore 9
    //   656: aload 11
    //   658: astore 8
    //   660: new 59	java/lang/StringBuilder
    //   663: dup
    //   664: ldc 220
    //   666: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   669: aload 14
    //   671: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   674: ldc 222
    //   676: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload_2
    //   681: astore 9
    //   683: aload 11
    //   685: astore 8
    //   687: aload 14
    //   689: invokestatic 218	com/facebook/soloader/SysUtil:v	(Ljava/io/File;)V
    //   692: aload_2
    //   693: astore 9
    //   695: aload 11
    //   697: astore 8
    //   699: new 82	java/io/RandomAccessFile
    //   702: dup
    //   703: aload 14
    //   705: ldc 95
    //   707: invokespecial 96	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   710: astore_2
    //   711: goto -250 -> 461
    //   714: aload 14
    //   716: iconst_0
    //   717: invokevirtual 145	java/io/File:setWritable	(Z)Z
    //   720: ifne +23 -> 743
    //   723: new 59	java/lang/StringBuilder
    //   726: dup
    //   727: ldc 156
    //   729: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   732: aload 14
    //   734: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   737: ldc 161
    //   739: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload_2
    //   744: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   747: aload_0
    //   748: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   751: iconst_0
    //   752: invokevirtual 145	java/io/File:setWritable	(Z)Z
    //   755: ifne +28 -> 783
    //   758: new 59	java/lang/StringBuilder
    //   761: dup
    //   762: ldc 156
    //   764: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   767: aload_0
    //   768: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   771: invokevirtual 159	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   774: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: ldc 161
    //   779: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: aload 13
    //   785: ifnull -690 -> 95
    //   788: aload 13
    //   790: invokeinterface 164 1 0
    //   795: goto -700 -> 95
    //   798: astore 8
    //   800: aload_2
    //   801: aload 8
    //   803: invokevirtual 228	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   806: goto -460 -> 346
    //   809: aload 13
    //   811: invokeinterface 164 1 0
    //   816: goto -470 -> 346
    //   819: aload 12
    //   821: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   824: new 59	java/lang/StringBuilder
    //   827: dup
    //   828: ldc 230
    //   830: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   833: aload_0
    //   834: invokevirtual 70	java/lang/Object:getClass	()Ljava/lang/Class;
    //   837: invokevirtual 76	java/lang/Class:getName	()Ljava/lang/String;
    //   840: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: return
    //   845: astore 8
    //   847: aload_2
    //   848: aload 8
    //   850: invokevirtual 228	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   853: goto -492 -> 361
    //   856: aload 12
    //   858: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   861: goto -500 -> 361
    //   864: astore 8
    //   866: aload 9
    //   868: astore 8
    //   870: goto -807 -> 63
    //   873: aload 8
    //   875: astore 10
    //   877: goto -796 -> 81
    //   880: iload 4
    //   882: iconst_1
    //   883: iadd
    //   884: istore 4
    //   886: iload 5
    //   888: istore_1
    //   889: goto -776 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	892	0	this	q
    //   0	892	1	paramByte	byte
    //   0	892	2	paramb	b
    //   0	892	3	paramd	d
    //   111	774	4	i	int
    //   140	747	5	b	byte
    //   494	25	6	l	long
    //   49	596	8	localObject1	Object
    //   651	1	8	localIOException	IOException
    //   658	40	8	localObject2	Object
    //   798	4	8	localThrowable1	Throwable
    //   845	4	8	localThrowable2	Throwable
    //   864	1	8	localException	java.lang.Exception
    //   868	6	8	localObject3	Object
    //   45	822	9	localObject4	Object
    //   79	797	10	localObject5	Object
    //   384	312	11	localFileDescriptor	FileDescriptor
    //   42	815	12	localRandomAccessFile	RandomAccessFile
    //   106	704	13	localc	c
    //   381	352	14	localFile	File
    //   93	440	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   249	287	287	finally
    //   363	383	287	finally
    //   610	639	287	finally
    //   644	649	287	finally
    //   649	651	287	finally
    //   714	743	287	finally
    //   743	747	287	finally
    //   117	139	326	finally
    //   142	160	326	finally
    //   163	190	326	finally
    //   196	220	326	finally
    //   226	249	326	finally
    //   288	324	326	finally
    //   324	326	326	finally
    //   747	783	326	finally
    //   327	329	329	finally
    //   56	63	348	finally
    //   68	81	348	finally
    //   81	95	348	finally
    //   95	108	348	finally
    //   346	348	348	finally
    //   788	795	348	finally
    //   800	806	348	finally
    //   809	816	348	finally
    //   349	351	351	finally
    //   395	403	593	java/io/IOException
    //   410	419	593	java/io/IOException
    //   426	441	593	java/io/IOException
    //   467	475	593	java/io/IOException
    //   486	492	593	java/io/IOException
    //   502	510	593	java/io/IOException
    //   516	523	593	java/io/IOException
    //   529	539	593	java/io/IOException
    //   545	553	593	java/io/IOException
    //   559	569	593	java/io/IOException
    //   575	593	593	java/io/IOException
    //   660	680	593	java/io/IOException
    //   687	692	593	java/io/IOException
    //   699	711	593	java/io/IOException
    //   395	403	609	finally
    //   410	419	609	finally
    //   426	441	609	finally
    //   445	458	609	finally
    //   467	475	609	finally
    //   486	492	609	finally
    //   502	510	609	finally
    //   516	523	609	finally
    //   529	539	609	finally
    //   545	553	609	finally
    //   559	569	609	finally
    //   575	593	609	finally
    //   598	603	609	finally
    //   607	609	609	finally
    //   660	680	609	finally
    //   687	692	609	finally
    //   699	711	609	finally
    //   445	458	651	java/io/IOException
    //   339	346	798	finally
    //   356	361	845	finally
    //   56	63	864	java/lang/Exception
  }
  
  static void a(File paramFile, byte paramByte)
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
    try
    {
      localRandomAccessFile.seek(0L);
      localRandomAccessFile.write(paramByte);
      localRandomAccessFile.setLength(localRandomAccessFile.getFilePointer());
      localRandomAccessFile.getFD().sync();
      localRandomAccessFile.close();
      return;
    }
    finally
    {
      try
      {
        throw paramFile;
      }
      finally {}
    }
    for (;;)
    {
      try
      {
        localRandomAccessFile.close();
        throw localObject;
      }
      finally
      {
        paramFile.addSuppressed(localThrowable);
      }
      localThrowable.close();
    }
  }
  
  private void a(a[] paramArrayOfa)
  {
    String[] arrayOfString = this.cCx.list();
    if (arrayOfString == null) {
      throw new IOException("unable to list directory " + this.cCx);
    }
    int i = 0;
    while (i < arrayOfString.length)
    {
      Object localObject = arrayOfString[i];
      if ((!((String)localObject).equals("dso_state")) && (!((String)localObject).equals("dso_lock")) && (!((String)localObject).equals("dso_deps")) && (!((String)localObject).equals("dso_manifest")))
      {
        int j = 0;
        int k = 0;
        while ((k == 0) && (j < paramArrayOfa.length))
        {
          if (paramArrayOfa[j].name.equals(localObject)) {
            k = 1;
          }
          j += 1;
        }
        if (k == 0)
        {
          localObject = new File(this.cCx, (String)localObject);
          new StringBuilder("deleting unaccounted-for file ").append(localObject);
          SysUtil.v((File)localObject);
        }
      }
      i += 1;
    }
  }
  
  /* Error */
  private boolean a(final j paramj, int paramInt, final byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 84	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   8: ldc 251
    //   10: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore 11
    //   15: new 82	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 11
    //   21: ldc 95
    //   23: invokespecial 96	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 7
    //   28: aload 7
    //   30: invokevirtual 264	java/io/RandomAccessFile:readByte	()B
    //   33: istore 5
    //   35: iload 5
    //   37: istore 4
    //   39: iload 5
    //   41: iconst_1
    //   42: if_icmpeq +30 -> 72
    //   45: new 59	java/lang/StringBuilder
    //   48: dup
    //   49: ldc_w 266
    //   52: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   59: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: ldc_w 268
    //   65: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: iconst_0
    //   70: istore 4
    //   72: aload 7
    //   74: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   77: new 84	java/io/File
    //   80: dup
    //   81: aload_0
    //   82: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   85: ldc 255
    //   87: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: astore 12
    //   92: aconst_null
    //   93: astore 7
    //   95: new 82	java/io/RandomAccessFile
    //   98: dup
    //   99: aload 12
    //   101: ldc 95
    //   103: invokespecial 96	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   106: astore 9
    //   108: aload 9
    //   110: invokevirtual 271	java/io/RandomAccessFile:length	()J
    //   113: l2i
    //   114: newarray byte
    //   116: astore 8
    //   118: aload 9
    //   120: aload 8
    //   122: invokevirtual 275	java/io/RandomAccessFile:read	([B)I
    //   125: aload 8
    //   127: arraylength
    //   128: if_icmpeq +6 -> 134
    //   131: iconst_0
    //   132: istore 4
    //   134: aload 8
    //   136: aload_3
    //   137: invokestatic 280	java/util/Arrays:equals	([B[B)Z
    //   140: ifne +127 -> 267
    //   143: iconst_1
    //   144: istore 6
    //   146: goto +307 -> 453
    //   149: aload 11
    //   151: iconst_0
    //   152: invokestatic 282	com/facebook/soloader/q:a	(Ljava/io/File;B)V
    //   155: aload_0
    //   156: invokevirtual 286	com/facebook/soloader/q:PO	()Lcom/facebook/soloader/q$f;
    //   159: astore 10
    //   161: aload 10
    //   163: invokevirtual 290	com/facebook/soloader/q$f:PW	()Lcom/facebook/soloader/q$b;
    //   166: astore 8
    //   168: aload 10
    //   170: invokevirtual 294	com/facebook/soloader/q$f:PX	()Lcom/facebook/soloader/q$d;
    //   173: astore 7
    //   175: aload_0
    //   176: iload 4
    //   178: aload 8
    //   180: aload 7
    //   182: invokespecial 296	com/facebook/soloader/q:a	(BLcom/facebook/soloader/q$b;Lcom/facebook/soloader/q$d;)V
    //   185: aload 7
    //   187: ifnull +8 -> 195
    //   190: aload 7
    //   192: invokevirtual 297	com/facebook/soloader/q$d:close	()V
    //   195: aload 8
    //   197: astore 7
    //   199: aload 10
    //   201: ifnull +12 -> 213
    //   204: aload 10
    //   206: invokevirtual 298	com/facebook/soloader/q$f:close	()V
    //   209: aload 8
    //   211: astore 7
    //   213: aload 9
    //   215: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   218: aload 7
    //   220: ifnonnull +165 -> 385
    //   223: iconst_0
    //   224: ireturn
    //   225: astore 8
    //   227: iconst_0
    //   228: istore 4
    //   230: goto -158 -> 72
    //   233: astore_1
    //   234: aload_1
    //   235: athrow
    //   236: astore_3
    //   237: aload_1
    //   238: ifnull +21 -> 259
    //   241: aload 7
    //   243: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   246: aload_3
    //   247: athrow
    //   248: astore 7
    //   250: aload_1
    //   251: aload 7
    //   253: invokevirtual 228	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   256: goto -10 -> 246
    //   259: aload 7
    //   261: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   264: goto -18 -> 246
    //   267: iconst_0
    //   268: istore 6
    //   270: goto +183 -> 453
    //   273: astore_1
    //   274: aload_1
    //   275: athrow
    //   276: astore_3
    //   277: aload 7
    //   279: ifnull +12 -> 291
    //   282: aload_1
    //   283: ifnull +56 -> 339
    //   286: aload 7
    //   288: invokevirtual 297	com/facebook/soloader/q$d:close	()V
    //   291: aload_3
    //   292: athrow
    //   293: astore_1
    //   294: aload_1
    //   295: athrow
    //   296: astore_3
    //   297: aload 10
    //   299: ifnull +12 -> 311
    //   302: aload_1
    //   303: ifnull +55 -> 358
    //   306: aload 10
    //   308: invokevirtual 298	com/facebook/soloader/q$f:close	()V
    //   311: aload_3
    //   312: athrow
    //   313: astore_1
    //   314: aload_1
    //   315: athrow
    //   316: astore_3
    //   317: aload_1
    //   318: ifnull +59 -> 377
    //   321: aload 9
    //   323: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   326: aload_3
    //   327: athrow
    //   328: astore 7
    //   330: aload_1
    //   331: aload 7
    //   333: invokevirtual 228	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   336: goto -45 -> 291
    //   339: aload 7
    //   341: invokevirtual 297	com/facebook/soloader/q$d:close	()V
    //   344: goto -53 -> 291
    //   347: astore 7
    //   349: aload_1
    //   350: aload 7
    //   352: invokevirtual 228	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   355: goto -44 -> 311
    //   358: aload 10
    //   360: invokevirtual 298	com/facebook/soloader/q$f:close	()V
    //   363: goto -52 -> 311
    //   366: astore 7
    //   368: aload_1
    //   369: aload 7
    //   371: invokevirtual 228	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   374: goto -48 -> 326
    //   377: aload 9
    //   379: invokevirtual 165	java/io/RandomAccessFile:close	()V
    //   382: goto -56 -> 326
    //   385: new 6	com/facebook/soloader/q$1
    //   388: dup
    //   389: aload_0
    //   390: aload 12
    //   392: aload_3
    //   393: aload 7
    //   395: aload 11
    //   397: aload_1
    //   398: invokespecial 301	com/facebook/soloader/q$1:<init>	(Lcom/facebook/soloader/q;Ljava/io/File;[BLcom/facebook/soloader/q$b;Ljava/io/File;Lcom/facebook/soloader/j;)V
    //   401: astore_1
    //   402: iload_2
    //   403: iconst_1
    //   404: iand
    //   405: ifeq +39 -> 444
    //   408: new 303	java/lang/Thread
    //   411: dup
    //   412: aload_1
    //   413: new 59	java/lang/StringBuilder
    //   416: dup
    //   417: ldc_w 305
    //   420: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: aload_0
    //   424: getfield 88	com/facebook/soloader/q:cCx	Ljava/io/File;
    //   427: invokevirtual 306	java/io/File:getName	()Ljava/lang/String;
    //   430: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokespecial 309	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   439: invokevirtual 312	java/lang/Thread:start	()V
    //   442: iconst_1
    //   443: ireturn
    //   444: aload_1
    //   445: invokeinterface 317 1 0
    //   450: goto -8 -> 442
    //   453: iload 6
    //   455: ifeq +6 -> 461
    //   458: iconst_0
    //   459: istore 4
    //   461: iload 4
    //   463: ifeq -314 -> 149
    //   466: iload_2
    //   467: iconst_2
    //   468: iand
    //   469: ifeq -256 -> 213
    //   472: goto -323 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	q
    //   0	475	1	paramj	j
    //   0	475	2	paramInt	int
    //   0	475	3	paramArrayOfByte	byte[]
    //   37	425	4	b1	byte
    //   33	10	5	b2	byte
    //   144	310	6	i	int
    //   26	216	7	localObject1	Object
    //   248	39	7	localThrowable1	Throwable
    //   328	12	7	localThrowable2	Throwable
    //   347	4	7	localThrowable3	Throwable
    //   366	28	7	localThrowable4	Throwable
    //   116	94	8	localObject2	Object
    //   225	1	8	localEOFException	java.io.EOFException
    //   106	272	9	localRandomAccessFile	RandomAccessFile
    //   159	200	10	localf	f
    //   13	383	11	localFile1	File
    //   90	301	12	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   28	35	225	java/io/EOFException
    //   45	69	225	java/io/EOFException
    //   28	35	233	finally
    //   45	69	233	finally
    //   234	236	236	finally
    //   241	246	248	finally
    //   175	185	273	finally
    //   274	276	276	finally
    //   161	175	293	finally
    //   190	195	293	finally
    //   291	293	293	finally
    //   330	336	293	finally
    //   339	344	293	finally
    //   294	296	296	finally
    //   108	118	313	finally
    //   118	131	313	finally
    //   134	143	313	finally
    //   149	161	313	finally
    //   204	209	313	finally
    //   311	313	313	finally
    //   349	355	313	finally
    //   358	363	313	finally
    //   314	316	316	finally
    //   286	291	328	finally
    //   306	311	347	finally
    //   321	326	366	finally
  }
  
  private Object cC(String paramString)
  {
    synchronized (this.cDs)
    {
      Object localObject2 = this.cDs.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new Object();
        this.cDs.put(paramString, localObject1);
      }
      return localObject1;
    }
  }
  
  public static File l(Context paramContext, String paramString)
  {
    return new File(paramContext.getApplicationInfo().dataDir + "/" + paramString);
  }
  
  protected abstract f PO();
  
  protected byte[] PP()
  {
    Parcel localParcel = Parcel.obtain();
    Object localObject1 = PO();
    try
    {
      a[] arrayOfa = ((f)localObject1).PW().cDA;
      localParcel.writeByte((byte)1);
      localParcel.writeInt(arrayOfa.length);
      int i = 0;
      while (i < arrayOfa.length)
      {
        localParcel.writeString(arrayOfa[i].name);
        localParcel.writeString(arrayOfa[i].cDz);
        i += 1;
      }
      if (localObject1 != null) {
        ((f)localObject1).close();
      }
      localObject1 = localParcel.marshall();
      localParcel.recycle();
      return localObject1;
    }
    finally
    {
      try
      {
        throw localObject2;
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
    for (;;)
    {
      try
      {
        ((f)localObject1).close();
        throw localObject3;
      }
      finally
      {
        localObject2.addSuppressed(localThrowable);
      }
      localThrowable.close();
    }
  }
  
  public final int a(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    synchronized (cC(paramString))
    {
      paramInt = a(paramString, paramInt, this.cCx, paramThreadPolicy);
      return paramInt;
    }
  }
  
  /* Error */
  protected final void cD(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 372	com/facebook/soloader/q:cC	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: astore_2
    //   8: aload_2
    //   9: monitorenter
    //   10: aload_0
    //   11: aload_1
    //   12: putfield 378	com/facebook/soloader/q:cDq	Ljava/lang/String;
    //   15: aload_0
    //   16: iconst_2
    //   17: invokevirtual 381	com/facebook/soloader/q:hi	(I)V
    //   20: aload_2
    //   21: monitorexit
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	q
    //   0	35	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   10	22	25	finally
    //   2	10	30	finally
    //   26	30	30	finally
  }
  
  protected final void hi(int paramInt)
  {
    Object localObject1 = this.cCx;
    if ((!((File)localObject1).mkdirs()) && (!((File)localObject1).isDirectory())) {
      throw new IOException("cannot mkdir: ".concat(String.valueOf(localObject1)));
    }
    localObject1 = j.t(new File(this.cCx, "dso_lock"));
    try
    {
      new StringBuilder("locked dso store ").append(this.cCx);
      boolean bool = a((j)localObject1, paramInt, PP());
      if (bool) {
        localObject1 = null;
      }
      while (localObject1 != null)
      {
        new StringBuilder("releasing dso store lock for ").append(this.cCx);
        ((j)localObject1).close();
        return;
        new StringBuilder("dso store is up-to-date: ").append(this.cCx);
      }
      new StringBuilder("not releasing dso store lock for ").append(this.cCx).append(" (syncer thread started)");
      return;
    }
    finally
    {
      if (localObject1 == null) {
        break label193;
      }
    }
    new StringBuilder("releasing dso store lock for ").append(this.cCx);
    ((j)localObject1).close();
    for (;;)
    {
      throw localObject2;
      label193:
      new StringBuilder("not releasing dso store lock for ").append(this.cCx).append(" (syncer thread started)");
    }
  }
  
  public static class a
  {
    public final String cDz;
    public final String name;
    
    public a(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.cDz = paramString2;
    }
  }
  
  public static final class b
  {
    public final q.a[] cDA;
    
    public b(q.a[] paramArrayOfa)
    {
      this.cDA = paramArrayOfa;
    }
    
    static final b a(DataInput paramDataInput)
    {
      AppMethodBeat.i(208171);
      if (paramDataInput.readByte() != 1)
      {
        paramDataInput = new RuntimeException("wrong dso manifest version");
        AppMethodBeat.o(208171);
        throw paramDataInput;
      }
      int j = paramDataInput.readInt();
      if (j < 0)
      {
        paramDataInput = new RuntimeException("illegal number of shared libraries");
        AppMethodBeat.o(208171);
        throw paramDataInput;
      }
      q.a[] arrayOfa = new q.a[j];
      int i = 0;
      while (i < j)
      {
        arrayOfa[i] = new q.a(paramDataInput.readUTF(), paramDataInput.readUTF());
        i += 1;
      }
      paramDataInput = new b(arrayOfa);
      AppMethodBeat.o(208171);
      return paramDataInput;
    }
    
    public final void a(DataOutput paramDataOutput)
    {
      AppMethodBeat.i(208176);
      paramDataOutput.writeByte(1);
      paramDataOutput.writeInt(this.cDA.length);
      int i = 0;
      while (i < this.cDA.length)
      {
        paramDataOutput.writeUTF(this.cDA[i].name);
        paramDataOutput.writeUTF(this.cDA[i].cDz);
        i += 1;
      }
      AppMethodBeat.o(208176);
    }
  }
  
  protected static abstract interface c
    extends Closeable
  {
    public abstract q.a Qf();
    
    public abstract void a(DataOutput paramDataOutput, byte[] paramArrayOfByte);
    
    public abstract int available();
    
    public abstract String getFileName();
  }
  
  protected static abstract class d
    implements Closeable
  {
    public abstract q.c PY();
    
    public void close() {}
    
    public abstract boolean hasNext();
  }
  
  public static final class e
    implements q.c
  {
    private final q.a cDB;
    private final InputStream cDC;
    
    public e(q.a parama, InputStream paramInputStream)
    {
      this.cDB = parama;
      this.cDC = paramInputStream;
    }
    
    public final q.a Qf()
    {
      return this.cDB;
    }
    
    public final void a(DataOutput paramDataOutput, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(208180);
      InputStream localInputStream = this.cDC;
      int i = 0;
      while (i < 2147483647)
      {
        int j = localInputStream.read(paramArrayOfByte, 0, Math.min(32768, 2147483647 - i));
        if (j == -1) {
          break;
        }
        paramDataOutput.write(paramArrayOfByte, 0, j);
        i += j;
      }
      AppMethodBeat.o(208180);
    }
    
    public final int available()
    {
      AppMethodBeat.i(208188);
      int i = this.cDC.available();
      AppMethodBeat.o(208188);
      return i;
    }
    
    public final void close()
    {
      AppMethodBeat.i(208190);
      this.cDC.close();
      AppMethodBeat.o(208190);
    }
    
    public final String getFileName()
    {
      return this.cDB.name;
    }
  }
  
  protected static abstract class f
    implements Closeable
  {
    public abstract q.b PW();
    
    protected abstract q.d PX();
    
    public void close() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.q
 * JD-Core Version:    0.7.0.1
 */