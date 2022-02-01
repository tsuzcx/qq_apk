package com.tencent.mm.plugin.emoji.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.plugin.emoji.mgr.h;
import com.tencent.mm.plugin.expansions.e.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.toolkit.frontia.a.c.a;

public class EmojiResUpdateListener
  extends IListener<cd>
{
  public EmojiResUpdateListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161066);
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(161066);
  }
  
  /* Error */
  private boolean a(final cd paramcd)
  {
    // Byte code:
    //   0: ldc 52
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: instanceof 27
    //   9: ifeq +417 -> 426
    //   12: invokestatic 58	com/tencent/mm/kernel/h:baz	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 52
    //   20: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_1
    //   26: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   29: getfield 67	com/tencent/mm/autogen/a/cd$a:hCh	I
    //   32: bipush 33
    //   34: if_icmpne +534 -> 568
    //   37: new 69	com/tencent/mm/vfs/u
    //   40: dup
    //   41: aload_1
    //   42: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   45: getfield 73	com/tencent/mm/autogen/a/cd$a:filePath	Ljava/lang/String;
    //   48: invokespecial 76	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   51: astore 13
    //   53: aload 13
    //   55: invokevirtual 79	com/tencent/mm/vfs/u:jKS	()Z
    //   58: ifeq +500 -> 558
    //   61: ldc 81
    //   63: ldc 83
    //   65: iconst_1
    //   66: anewarray 85	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload 13
    //   73: invokevirtual 89	com/tencent/mm/vfs/u:jKU	()Lcom/tencent/mm/vfs/u;
    //   76: aastore
    //   77: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: new 69	com/tencent/mm/vfs/u
    //   83: dup
    //   84: invokestatic 99	com/tencent/mm/modelemoji/a:bIE	()Ljava/lang/String;
    //   87: ldc 101
    //   89: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: astore 14
    //   94: new 69	com/tencent/mm/vfs/u
    //   97: dup
    //   98: aload 14
    //   100: ldc 106
    //   102: invokespecial 109	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   105: astore 15
    //   107: aload 14
    //   109: invokevirtual 112	com/tencent/mm/vfs/u:jKY	()Z
    //   112: pop
    //   113: aload 13
    //   115: invokevirtual 116	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   118: invokestatic 122	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: aload 15
    //   123: invokevirtual 116	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   126: invokestatic 122	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   129: iconst_0
    //   130: invokestatic 128	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   133: pop2
    //   134: aload 15
    //   136: invokevirtual 116	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   139: invokestatic 122	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   142: aload 14
    //   144: invokevirtual 116	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   147: invokestatic 122	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   150: invokestatic 132	com/tencent/mm/vfs/y:aA	(Ljava/lang/String;Ljava/lang/String;)I
    //   153: istore 5
    //   155: iconst_1
    //   156: istore 4
    //   158: iconst_1
    //   159: istore_3
    //   160: iconst_1
    //   161: istore_2
    //   162: iload 5
    //   164: iflt +198 -> 362
    //   167: aconst_null
    //   168: astore 9
    //   170: aconst_null
    //   171: astore 7
    //   173: new 69	com/tencent/mm/vfs/u
    //   176: dup
    //   177: aload 14
    //   179: ldc 134
    //   181: invokespecial 109	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   184: invokestatic 138	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   187: astore_1
    //   188: aload_1
    //   189: astore 7
    //   191: aload_1
    //   192: astore 9
    //   194: new 140	java/io/InputStreamReader
    //   197: dup
    //   198: aload_1
    //   199: invokespecial 143	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   202: astore 8
    //   204: new 145	java/io/BufferedReader
    //   207: dup
    //   208: aload 8
    //   210: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   213: astore 7
    //   215: ldc 150
    //   217: astore 12
    //   219: aload 7
    //   221: astore 11
    //   223: aload_1
    //   224: astore 10
    //   226: aload 8
    //   228: astore 9
    //   230: iload_3
    //   231: istore_2
    //   232: aload 7
    //   234: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   237: astore 16
    //   239: aload 16
    //   241: ifnull +41 -> 282
    //   244: aload 7
    //   246: astore 11
    //   248: aload_1
    //   249: astore 10
    //   251: aload 8
    //   253: astore 9
    //   255: iload_3
    //   256: istore_2
    //   257: new 155	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   264: aload 12
    //   266: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 16
    //   271: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: astore 12
    //   279: goto -60 -> 219
    //   282: aload 7
    //   284: astore 11
    //   286: aload_1
    //   287: astore 10
    //   289: aload 8
    //   291: astore 9
    //   293: iload_3
    //   294: istore_2
    //   295: new 166	org/json/JSONObject
    //   298: dup
    //   299: aload 12
    //   301: invokespecial 167	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   304: ldc 169
    //   306: invokevirtual 173	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   309: istore_3
    //   310: aload 7
    //   312: astore 11
    //   314: aload_1
    //   315: astore 10
    //   317: aload 8
    //   319: astore 9
    //   321: iload_3
    //   322: istore_2
    //   323: ldc 81
    //   325: ldc 175
    //   327: iconst_2
    //   328: anewarray 85	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: aload 12
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: iload_3
    //   339: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: aload_1
    //   347: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   350: aload 8
    //   352: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   355: aload 7
    //   357: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   360: iload_3
    //   361: istore_2
    //   362: aload 14
    //   364: getfield 194	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   367: invokestatic 122	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   370: iconst_1
    //   371: invokestatic 198	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   374: pop
    //   375: aload 15
    //   377: getfield 194	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   380: invokestatic 122	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   383: invokestatic 202	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   386: pop
    //   387: getstatic 205	com/tencent/mm/modelemoji/a:oDj	I
    //   390: iload_2
    //   391: if_icmpge +137 -> 528
    //   394: ldc 81
    //   396: ldc 207
    //   398: iconst_2
    //   399: anewarray 85	java/lang/Object
    //   402: dup
    //   403: iconst_0
    //   404: getstatic 205	com/tencent/mm/modelemoji/a:oDj	I
    //   407: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: aastore
    //   411: dup
    //   412: iconst_1
    //   413: iload_2
    //   414: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   417: aastore
    //   418: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: aload 13
    //   423: invokestatic 211	com/tencent/mm/modelemoji/a:k	(Lcom/tencent/mm/vfs/u;)V
    //   426: ldc 52
    //   428: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: iconst_0
    //   432: ireturn
    //   433: astore 12
    //   435: aconst_null
    //   436: astore 9
    //   438: aconst_null
    //   439: astore 8
    //   441: aload 7
    //   443: astore_1
    //   444: aload 9
    //   446: astore 7
    //   448: iload 4
    //   450: istore_2
    //   451: aload 7
    //   453: astore 11
    //   455: aload_1
    //   456: astore 10
    //   458: aload 8
    //   460: astore 9
    //   462: ldc 81
    //   464: aload 12
    //   466: aload 12
    //   468: invokevirtual 214	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   471: iconst_0
    //   472: anewarray 85	java/lang/Object
    //   475: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: aload_1
    //   479: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   482: aload 8
    //   484: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   487: aload 7
    //   489: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   492: goto -130 -> 362
    //   495: astore 7
    //   497: aconst_null
    //   498: astore 11
    //   500: aconst_null
    //   501: astore 8
    //   503: aload 9
    //   505: astore_1
    //   506: aload_1
    //   507: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   510: aload 8
    //   512: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   515: aload 11
    //   517: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   520: ldc 52
    //   522: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   525: aload 7
    //   527: athrow
    //   528: ldc 81
    //   530: ldc 220
    //   532: iconst_2
    //   533: anewarray 85	java/lang/Object
    //   536: dup
    //   537: iconst_0
    //   538: getstatic 205	com/tencent/mm/modelemoji/a:oDj	I
    //   541: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   544: aastore
    //   545: dup
    //   546: iconst_1
    //   547: iload_2
    //   548: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   551: aastore
    //   552: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   555: goto -129 -> 426
    //   558: ldc 81
    //   560: ldc 222
    //   562: invokestatic 225	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: goto -139 -> 426
    //   568: aload_1
    //   569: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   572: getfield 67	com/tencent/mm/autogen/a/cd$a:hCh	I
    //   575: bipush 37
    //   577: if_icmpne -151 -> 426
    //   580: aload_1
    //   581: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   584: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   587: iconst_1
    //   588: if_icmpne +13 -> 601
    //   591: invokestatic 234	com/tencent/mm/plugin/emoji/mgr/h:dzH	()Lcom/tencent/mm/plugin/emoji/mgr/h;
    //   594: aload_1
    //   595: invokevirtual 238	com/tencent/mm/plugin/emoji/mgr/h:b	(Lcom/tencent/mm/autogen/a/cd;)V
    //   598: goto -172 -> 426
    //   601: aload_1
    //   602: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   605: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   608: iconst_2
    //   609: if_icmpne +591 -> 1200
    //   612: invokestatic 234	com/tencent/mm/plugin/emoji/mgr/h:dzH	()Lcom/tencent/mm/plugin/emoji/mgr/h;
    //   615: astore 9
    //   617: getstatic 244	com/tencent/mm/plugin/emoji/mgr/h$a:xLJ	Lcom/tencent/mm/plugin/emoji/mgr/h$a;
    //   620: astore 7
    //   622: aload 9
    //   624: aload 7
    //   626: invokevirtual 247	com/tencent/mm/plugin/emoji/mgr/h:a	(Lcom/tencent/mm/plugin/emoji/mgr/h$a;)Lcom/tencent/mm/emoji/d/f;
    //   629: astore 8
    //   631: aload 7
    //   633: invokestatic 250	com/tencent/mm/plugin/emoji/mgr/h:b	(Lcom/tencent/mm/plugin/emoji/mgr/h$a;)I
    //   636: istore_2
    //   637: aload_1
    //   638: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   641: getfield 73	com/tencent/mm/autogen/a/cd$a:filePath	Ljava/lang/String;
    //   644: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   647: invokestatic 257	com/tencent/mm/plugin/emoji/mgr/h:az	(Ljava/lang/String;Ljava/lang/String;)Z
    //   650: istore 6
    //   652: aload 8
    //   654: iload_2
    //   655: new 69	com/tencent/mm/vfs/u
    //   658: dup
    //   659: new 155	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   666: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   669: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: ldc_w 262
    //   675: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   681: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: getstatic 265	com/tencent/mm/plugin/emoji/mgr/h:xLo	Ljava/lang/String;
    //   690: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: invokestatic 269	com/tencent/mm/plugin/emoji/mgr/h:P	(Lcom/tencent/mm/vfs/u;)I
    //   696: invokevirtual 275	com/tencent/mm/emoji/d/f:dR	(II)V
    //   699: aload 8
    //   701: iload 6
    //   703: invokevirtual 279	com/tencent/mm/emoji/d/f:fm	(Z)V
    //   706: aload 8
    //   708: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   711: iconst_0
    //   712: putfield 288	com/tencent/mm/autogen/mmdata/rpt/bs:iur	I
    //   715: aload 8
    //   717: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   720: invokevirtual 291	com/tencent/mm/autogen/mmdata/rpt/bs:bMH	()Z
    //   723: pop
    //   724: iload 6
    //   726: ifeq +462 -> 1188
    //   729: new 155	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   736: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   739: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: ldc_w 262
    //   745: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: getstatic 294	com/tencent/mm/plugin/emoji/mgr/h:xLh	Ljava/lang/String;
    //   751: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: iconst_1
    //   758: invokestatic 198	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   761: pop
    //   762: new 155	java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   769: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   772: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: ldc_w 262
    //   778: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   784: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: new 155	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   797: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   800: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 262
    //   806: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: getstatic 294	com/tencent/mm/plugin/emoji/mgr/h:xLh	Ljava/lang/String;
    //   812: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 297	com/tencent/mm/vfs/y:qp	(Ljava/lang/String;Ljava/lang/String;)Z
    //   821: pop
    //   822: new 69	com/tencent/mm/vfs/u
    //   825: dup
    //   826: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   829: getstatic 294	com/tencent/mm/plugin/emoji/mgr/h:xLh	Ljava/lang/String;
    //   832: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: astore 10
    //   837: invokestatic 302	com/tencent/mm/emoji/c/o:aUT	()Ljava/lang/String;
    //   840: astore 8
    //   842: aload 8
    //   844: invokestatic 305	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   847: ifeq +264 -> 1111
    //   850: getstatic 308	com/tencent/mm/plugin/emoji/mgr/h:xLw	Ljava/lang/String;
    //   853: astore 7
    //   855: ldc_w 310
    //   858: ldc_w 312
    //   861: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   864: new 69	com/tencent/mm/vfs/u
    //   867: dup
    //   868: aload 10
    //   870: aload 7
    //   872: invokespecial 109	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   875: astore 8
    //   877: aload 8
    //   879: invokevirtual 79	com/tencent/mm/vfs/u:jKS	()Z
    //   882: ifeq +294 -> 1176
    //   885: aload 8
    //   887: invokestatic 319	com/tencent/mm/emoji/f/d:e	(Lcom/tencent/mm/vfs/u;)Ljava/util/ArrayList;
    //   890: astore 8
    //   892: aload 9
    //   894: getstatic 244	com/tencent/mm/plugin/emoji/mgr/h$a:xLJ	Lcom/tencent/mm/plugin/emoji/mgr/h$a;
    //   897: invokevirtual 247	com/tencent/mm/plugin/emoji/mgr/h:a	(Lcom/tencent/mm/plugin/emoji/mgr/h$a;)Lcom/tencent/mm/emoji/d/f;
    //   900: astore 9
    //   902: aload 8
    //   904: invokevirtual 324	java/util/ArrayList:isEmpty	()Z
    //   907: ifne +251 -> 1158
    //   910: iconst_1
    //   911: istore 6
    //   913: aload 9
    //   915: iload 6
    //   917: invokevirtual 327	com/tencent/mm/emoji/d/f:fn	(Z)V
    //   920: aload 9
    //   922: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   925: aload 8
    //   927: invokevirtual 330	java/util/ArrayList:size	()I
    //   930: putfield 288	com/tencent/mm/autogen/mmdata/rpt/bs:iur	I
    //   933: aload 9
    //   935: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   938: invokevirtual 291	com/tencent/mm/autogen/mmdata/rpt/bs:bMH	()Z
    //   941: pop
    //   942: aload 8
    //   944: invokevirtual 324	java/util/ArrayList:isEmpty	()Z
    //   947: ifne +217 -> 1164
    //   950: ldc_w 332
    //   953: invokestatic 335	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   956: checkcast 332	com/tencent/mm/plugin/emoji/c/d
    //   959: invokeinterface 339 1 0
    //   964: aload 8
    //   966: invokeinterface 345 2 0
    //   971: ifeq +89 -> 1060
    //   974: new 347	com/tencent/mm/autogen/a/dw
    //   977: dup
    //   978: invokespecial 348	com/tencent/mm/autogen/a/dw:<init>	()V
    //   981: astore 8
    //   983: aload 8
    //   985: getfield 352	com/tencent/mm/autogen/a/dw:hDL	Lcom/tencent/mm/autogen/a/dw$a;
    //   988: iconst_2
    //   989: putfield 355	com/tencent/mm/autogen/a/dw$a:subType	I
    //   992: aload 8
    //   994: invokevirtual 358	com/tencent/mm/autogen/a/dw:publish	()Z
    //   997: pop
    //   998: new 69	com/tencent/mm/vfs/u
    //   1001: dup
    //   1002: new 155	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1009: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1012: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: ldc_w 262
    //   1018: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: getstatic 294	com/tencent/mm/plugin/emoji/mgr/h:xLh	Ljava/lang/String;
    //   1024: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: getstatic 265	com/tencent/mm/plugin/emoji/mgr/h:xLo	Ljava/lang/String;
    //   1033: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1036: invokestatic 269	com/tencent/mm/plugin/emoji/mgr/h:P	(Lcom/tencent/mm/vfs/u;)I
    //   1039: putstatic 361	com/tencent/mm/plugin/emoji/mgr/h:xLB	I
    //   1042: invokestatic 365	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1045: invokevirtual 371	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1048: getstatic 377	com/tencent/mm/storage/at$a:acIr	Lcom/tencent/mm/storage/at$a;
    //   1051: getstatic 361	com/tencent/mm/plugin/emoji/mgr/h:xLB	I
    //   1054: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1057: invokevirtual 383	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   1060: invokestatic 365	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1063: invokevirtual 371	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1066: getstatic 386	com/tencent/mm/storage/at$a:acIu	Lcom/tencent/mm/storage/at$a;
    //   1069: aload 7
    //   1071: invokevirtual 383	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   1074: invokestatic 392	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:iJf	()Lcom/tencent/mm/pluginsdk/res/downloader/checkresupdate/b;
    //   1077: aload_1
    //   1078: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1081: getfield 67	com/tencent/mm/autogen/a/cd$a:hCh	I
    //   1084: aload_1
    //   1085: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1088: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   1091: aload_1
    //   1092: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1095: getfield 395	com/tencent/mm/autogen/a/cd$a:hCi	I
    //   1098: invokevirtual 399	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:bu	(III)V
    //   1101: getstatic 405	com/tencent/mm/emoji/a/f:mfZ	Lcom/tencent/mm/emoji/a/f$a;
    //   1104: astore_1
    //   1105: invokestatic 410	com/tencent/mm/emoji/a/f$a:aUr	()V
    //   1108: goto -682 -> 426
    //   1111: aload 8
    //   1113: astore 7
    //   1115: new 69	com/tencent/mm/vfs/u
    //   1118: dup
    //   1119: aload 10
    //   1121: aload 8
    //   1123: invokespecial 109	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   1126: invokevirtual 79	com/tencent/mm/vfs/u:jKS	()Z
    //   1129: ifne +8 -> 1137
    //   1132: getstatic 308	com/tencent/mm/plugin/emoji/mgr/h:xLw	Ljava/lang/String;
    //   1135: astore 7
    //   1137: ldc_w 310
    //   1140: ldc_w 412
    //   1143: iconst_1
    //   1144: anewarray 85	java/lang/Object
    //   1147: dup
    //   1148: iconst_0
    //   1149: aload 7
    //   1151: aastore
    //   1152: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1155: goto -291 -> 864
    //   1158: iconst_0
    //   1159: istore 6
    //   1161: goto -248 -> 913
    //   1164: ldc_w 310
    //   1167: ldc_w 414
    //   1170: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1173: goto -113 -> 1060
    //   1176: ldc_w 310
    //   1179: ldc_w 416
    //   1182: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1185: goto -84 -> 1101
    //   1188: ldc_w 310
    //   1191: ldc_w 418
    //   1194: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1197: goto -771 -> 426
    //   1200: aload_1
    //   1201: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1204: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   1207: iconst_3
    //   1208: if_icmpne +310 -> 1518
    //   1211: invokestatic 234	com/tencent/mm/plugin/emoji/mgr/h:dzH	()Lcom/tencent/mm/plugin/emoji/mgr/h;
    //   1214: astore 8
    //   1216: getstatic 421	com/tencent/mm/plugin/emoji/mgr/h$a:xLK	Lcom/tencent/mm/plugin/emoji/mgr/h$a;
    //   1219: astore 7
    //   1221: aload 8
    //   1223: aload 7
    //   1225: invokevirtual 247	com/tencent/mm/plugin/emoji/mgr/h:a	(Lcom/tencent/mm/plugin/emoji/mgr/h$a;)Lcom/tencent/mm/emoji/d/f;
    //   1228: astore 8
    //   1230: aload 7
    //   1232: invokestatic 250	com/tencent/mm/plugin/emoji/mgr/h:b	(Lcom/tencent/mm/plugin/emoji/mgr/h$a;)I
    //   1235: istore_2
    //   1236: aload_1
    //   1237: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1240: getfield 73	com/tencent/mm/autogen/a/cd$a:filePath	Ljava/lang/String;
    //   1243: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   1246: invokestatic 257	com/tencent/mm/plugin/emoji/mgr/h:az	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1249: istore 6
    //   1251: aload 8
    //   1253: iload_2
    //   1254: new 69	com/tencent/mm/vfs/u
    //   1257: dup
    //   1258: new 155	java/lang/StringBuilder
    //   1261: dup
    //   1262: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1265: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1268: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: ldc_w 262
    //   1274: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   1280: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: getstatic 265	com/tencent/mm/plugin/emoji/mgr/h:xLo	Ljava/lang/String;
    //   1289: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1292: invokestatic 269	com/tencent/mm/plugin/emoji/mgr/h:P	(Lcom/tencent/mm/vfs/u;)I
    //   1295: invokevirtual 275	com/tencent/mm/emoji/d/f:dR	(II)V
    //   1298: aload 8
    //   1300: iload 6
    //   1302: invokevirtual 279	com/tencent/mm/emoji/d/f:fm	(Z)V
    //   1305: aload 8
    //   1307: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   1310: invokevirtual 291	com/tencent/mm/autogen/mmdata/rpt/bs:bMH	()Z
    //   1313: pop
    //   1314: iload 6
    //   1316: ifeq +190 -> 1506
    //   1319: new 155	java/lang/StringBuilder
    //   1322: dup
    //   1323: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1326: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1329: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: ldc_w 262
    //   1335: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: getstatic 424	com/tencent/mm/plugin/emoji/mgr/h:xLi	Ljava/lang/String;
    //   1341: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1347: iconst_1
    //   1348: invokestatic 198	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   1351: pop
    //   1352: new 155	java/lang/StringBuilder
    //   1355: dup
    //   1356: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1359: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1362: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: ldc_w 262
    //   1368: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   1374: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1380: new 155	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1387: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1390: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: ldc_w 262
    //   1396: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: getstatic 424	com/tencent/mm/plugin/emoji/mgr/h:xLi	Ljava/lang/String;
    //   1402: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1408: invokestatic 297	com/tencent/mm/vfs/y:qp	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1411: pop
    //   1412: new 69	com/tencent/mm/vfs/u
    //   1415: dup
    //   1416: new 69	com/tencent/mm/vfs/u
    //   1419: dup
    //   1420: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1423: getstatic 424	com/tencent/mm/plugin/emoji/mgr/h:xLi	Ljava/lang/String;
    //   1426: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1429: getstatic 427	com/tencent/mm/plugin/emoji/mgr/h:xLx	Ljava/lang/String;
    //   1432: invokespecial 109	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   1435: astore 7
    //   1437: aload 7
    //   1439: invokevirtual 79	com/tencent/mm/vfs/u:jKS	()Z
    //   1442: ifeq +52 -> 1494
    //   1445: aload 8
    //   1447: aload 7
    //   1449: invokestatic 431	com/tencent/mm/plugin/emoji/mgr/h:R	(Lcom/tencent/mm/vfs/u;)Z
    //   1452: invokevirtual 327	com/tencent/mm/emoji/d/f:fn	(Z)V
    //   1455: aload 8
    //   1457: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   1460: invokevirtual 291	com/tencent/mm/autogen/mmdata/rpt/bs:bMH	()Z
    //   1463: pop
    //   1464: invokestatic 392	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:iJf	()Lcom/tencent/mm/pluginsdk/res/downloader/checkresupdate/b;
    //   1467: aload_1
    //   1468: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1471: getfield 67	com/tencent/mm/autogen/a/cd$a:hCh	I
    //   1474: aload_1
    //   1475: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1478: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   1481: aload_1
    //   1482: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1485: getfield 395	com/tencent/mm/autogen/a/cd$a:hCi	I
    //   1488: invokevirtual 399	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:bu	(III)V
    //   1491: goto -1065 -> 426
    //   1494: ldc_w 310
    //   1497: ldc_w 433
    //   1500: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1503: goto -39 -> 1464
    //   1506: ldc_w 310
    //   1509: ldc_w 435
    //   1512: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1515: goto -1089 -> 426
    //   1518: aload_1
    //   1519: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1522: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   1525: iconst_5
    //   1526: if_icmpne +344 -> 1870
    //   1529: invokestatic 234	com/tencent/mm/plugin/emoji/mgr/h:dzH	()Lcom/tencent/mm/plugin/emoji/mgr/h;
    //   1532: astore 7
    //   1534: getstatic 438	com/tencent/mm/plugin/emoji/mgr/h$a:xLM	Lcom/tencent/mm/plugin/emoji/mgr/h$a;
    //   1537: astore 9
    //   1539: aload 7
    //   1541: aload 9
    //   1543: invokevirtual 247	com/tencent/mm/plugin/emoji/mgr/h:a	(Lcom/tencent/mm/plugin/emoji/mgr/h$a;)Lcom/tencent/mm/emoji/d/f;
    //   1546: astore 8
    //   1548: aload 9
    //   1550: invokestatic 250	com/tencent/mm/plugin/emoji/mgr/h:b	(Lcom/tencent/mm/plugin/emoji/mgr/h$a;)I
    //   1553: istore_2
    //   1554: aload_1
    //   1555: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1558: getfield 73	com/tencent/mm/autogen/a/cd$a:filePath	Ljava/lang/String;
    //   1561: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   1564: invokestatic 257	com/tencent/mm/plugin/emoji/mgr/h:az	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1567: istore 6
    //   1569: aload 8
    //   1571: iload_2
    //   1572: new 69	com/tencent/mm/vfs/u
    //   1575: dup
    //   1576: new 155	java/lang/StringBuilder
    //   1579: dup
    //   1580: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1583: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1586: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1589: ldc_w 262
    //   1592: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   1598: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1604: getstatic 265	com/tencent/mm/plugin/emoji/mgr/h:xLo	Ljava/lang/String;
    //   1607: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1610: invokestatic 269	com/tencent/mm/plugin/emoji/mgr/h:P	(Lcom/tencent/mm/vfs/u;)I
    //   1613: invokevirtual 275	com/tencent/mm/emoji/d/f:dR	(II)V
    //   1616: aload 8
    //   1618: iload 6
    //   1620: invokevirtual 279	com/tencent/mm/emoji/d/f:fm	(Z)V
    //   1623: aload 8
    //   1625: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   1628: iconst_0
    //   1629: putfield 288	com/tencent/mm/autogen/mmdata/rpt/bs:iur	I
    //   1632: aload 8
    //   1634: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   1637: invokevirtual 291	com/tencent/mm/autogen/mmdata/rpt/bs:bMH	()Z
    //   1640: pop
    //   1641: iload 6
    //   1643: ifeq +215 -> 1858
    //   1646: new 155	java/lang/StringBuilder
    //   1649: dup
    //   1650: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1653: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1656: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: ldc_w 262
    //   1662: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: getstatic 441	com/tencent/mm/plugin/emoji/mgr/h:xLj	Ljava/lang/String;
    //   1668: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1674: iconst_1
    //   1675: invokestatic 198	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   1678: pop
    //   1679: new 155	java/lang/StringBuilder
    //   1682: dup
    //   1683: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1686: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1689: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: ldc_w 262
    //   1695: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: getstatic 253	com/tencent/mm/plugin/emoji/mgr/h:xLf	Ljava/lang/String;
    //   1701: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1707: new 155	java/lang/StringBuilder
    //   1710: dup
    //   1711: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1714: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1717: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: ldc_w 262
    //   1723: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1726: getstatic 441	com/tencent/mm/plugin/emoji/mgr/h:xLj	Ljava/lang/String;
    //   1729: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1735: invokestatic 297	com/tencent/mm/vfs/y:qp	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1738: pop
    //   1739: new 69	com/tencent/mm/vfs/u
    //   1742: dup
    //   1743: new 69	com/tencent/mm/vfs/u
    //   1746: dup
    //   1747: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1750: getstatic 441	com/tencent/mm/plugin/emoji/mgr/h:xLj	Ljava/lang/String;
    //   1753: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1756: getstatic 444	com/tencent/mm/plugin/emoji/mgr/h:xLy	Ljava/lang/String;
    //   1759: invokespecial 109	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   1762: astore 9
    //   1764: aload 9
    //   1766: invokevirtual 79	com/tencent/mm/vfs/u:jKS	()Z
    //   1769: ifeq +77 -> 1846
    //   1772: aload 7
    //   1774: aload 9
    //   1776: invokevirtual 447	com/tencent/mm/plugin/emoji/mgr/h:S	(Lcom/tencent/mm/vfs/u;)Z
    //   1779: istore 6
    //   1781: ldc_w 449
    //   1784: invokestatic 335	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   1787: checkcast 449	com/tencent/mm/plugin/eggspring/a/a
    //   1790: aload 7
    //   1792: getfield 453	com/tencent/mm/plugin/emoji/mgr/h:xLG	Lcom/tencent/mm/modelpackage/g;
    //   1795: invokeinterface 457 2 0
    //   1800: aload 8
    //   1802: iload 6
    //   1804: invokevirtual 327	com/tencent/mm/emoji/d/f:fn	(Z)V
    //   1807: aload 8
    //   1809: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   1812: invokevirtual 291	com/tencent/mm/autogen/mmdata/rpt/bs:bMH	()Z
    //   1815: pop
    //   1816: invokestatic 392	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:iJf	()Lcom/tencent/mm/pluginsdk/res/downloader/checkresupdate/b;
    //   1819: aload_1
    //   1820: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1823: getfield 67	com/tencent/mm/autogen/a/cd$a:hCh	I
    //   1826: aload_1
    //   1827: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1830: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   1833: aload_1
    //   1834: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1837: getfield 395	com/tencent/mm/autogen/a/cd$a:hCi	I
    //   1840: invokevirtual 399	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:bu	(III)V
    //   1843: goto -1417 -> 426
    //   1846: ldc_w 310
    //   1849: ldc_w 459
    //   1852: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1855: goto -1429 -> 426
    //   1858: ldc_w 310
    //   1861: ldc_w 459
    //   1864: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1867: goto -1441 -> 426
    //   1870: aload_1
    //   1871: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1874: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   1877: bipush 6
    //   1879: if_icmpne +102 -> 1981
    //   1882: invokestatic 234	com/tencent/mm/plugin/emoji/mgr/h:dzH	()Lcom/tencent/mm/plugin/emoji/mgr/h;
    //   1885: getstatic 462	com/tencent/mm/plugin/emoji/mgr/h$a:xLN	Lcom/tencent/mm/plugin/emoji/mgr/h$a;
    //   1888: invokevirtual 247	com/tencent/mm/plugin/emoji/mgr/h:a	(Lcom/tencent/mm/plugin/emoji/mgr/h$a;)Lcom/tencent/mm/emoji/d/f;
    //   1891: astore 7
    //   1893: aload_1
    //   1894: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1897: getfield 73	com/tencent/mm/autogen/a/cd$a:filePath	Ljava/lang/String;
    //   1900: getstatic 465	com/tencent/mm/plugin/emoji/mgr/h:xLl	Ljava/lang/String;
    //   1903: invokestatic 257	com/tencent/mm/plugin/emoji/mgr/h:az	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1906: istore 6
    //   1908: aload 7
    //   1910: iload 6
    //   1912: invokevirtual 279	com/tencent/mm/emoji/d/f:fm	(Z)V
    //   1915: aload 7
    //   1917: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   1920: invokevirtual 291	com/tencent/mm/autogen/mmdata/rpt/bs:bMH	()Z
    //   1923: pop
    //   1924: iload 6
    //   1926: ifeq -1500 -> 426
    //   1929: new 69	com/tencent/mm/vfs/u
    //   1932: dup
    //   1933: invokestatic 260	com/tencent/mm/plugin/emoji/mgr/h:getDataEmojiPath	()Ljava/lang/String;
    //   1936: getstatic 465	com/tencent/mm/plugin/emoji/mgr/h:xLl	Ljava/lang/String;
    //   1939: invokespecial 104	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1942: pop
    //   1943: getstatic 471	com/tencent/mm/emoji/c/c/g:mjS	Lcom/tencent/mm/emoji/c/c/g;
    //   1946: astore 7
    //   1948: invokestatic 474	com/tencent/mm/emoji/c/c/g:aVE	()V
    //   1951: invokestatic 392	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:iJf	()Lcom/tencent/mm/pluginsdk/res/downloader/checkresupdate/b;
    //   1954: aload_1
    //   1955: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1958: getfield 67	com/tencent/mm/autogen/a/cd$a:hCh	I
    //   1961: aload_1
    //   1962: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1965: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   1968: aload_1
    //   1969: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1972: getfield 395	com/tencent/mm/autogen/a/cd$a:hCi	I
    //   1975: invokevirtual 399	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:bu	(III)V
    //   1978: goto -1552 -> 426
    //   1981: aload_1
    //   1982: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   1985: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   1988: bipush 7
    //   1990: if_icmpne +49 -> 2039
    //   1993: invokestatic 234	com/tencent/mm/plugin/emoji/mgr/h:dzH	()Lcom/tencent/mm/plugin/emoji/mgr/h;
    //   1996: aload_1
    //   1997: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   2000: getfield 73	com/tencent/mm/autogen/a/cd$a:filePath	Ljava/lang/String;
    //   2003: invokevirtual 477	com/tencent/mm/plugin/emoji/mgr/h:aox	(Ljava/lang/String;)Z
    //   2006: ifeq -1580 -> 426
    //   2009: invokestatic 392	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:iJf	()Lcom/tencent/mm/pluginsdk/res/downloader/checkresupdate/b;
    //   2012: aload_1
    //   2013: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   2016: getfield 67	com/tencent/mm/autogen/a/cd$a:hCh	I
    //   2019: aload_1
    //   2020: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   2023: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   2026: aload_1
    //   2027: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   2030: getfield 395	com/tencent/mm/autogen/a/cd$a:hCi	I
    //   2033: invokevirtual 399	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/b:bu	(III)V
    //   2036: goto -1610 -> 426
    //   2039: aload_1
    //   2040: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   2043: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   2046: bipush 9
    //   2048: if_icmpne +19 -> 2067
    //   2051: new 7	com/tencent/mm/plugin/emoji/event/EmojiResUpdateListener$1
    //   2054: dup
    //   2055: aload_0
    //   2056: aload_1
    //   2057: invokespecial 480	com/tencent/mm/plugin/emoji/event/EmojiResUpdateListener$1:<init>	(Lcom/tencent/mm/plugin/emoji/event/EmojiResUpdateListener;Lcom/tencent/mm/autogen/a/cd;)V
    //   2060: invokestatic 486	com/tencent/mm/plugin/expansions/e:install	(Lcom/tencent/mm/plugin/expansions/e$b;)Ljava/util/concurrent/Future;
    //   2063: pop
    //   2064: goto -1638 -> 426
    //   2067: aload_1
    //   2068: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   2071: getfield 228	com/tencent/mm/autogen/a/cd$a:subType	I
    //   2074: bipush 8
    //   2076: if_icmpne -1650 -> 426
    //   2079: invokestatic 234	com/tencent/mm/plugin/emoji/mgr/h:dzH	()Lcom/tencent/mm/plugin/emoji/mgr/h;
    //   2082: pop
    //   2083: ldc_w 310
    //   2086: ldc_w 488
    //   2089: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2092: new 271	com/tencent/mm/emoji/d/f
    //   2095: dup
    //   2096: invokespecial 491	com/tencent/mm/emoji/d/f:<init>	()V
    //   2099: astore 7
    //   2101: aload 7
    //   2103: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   2106: bipush 8
    //   2108: putfield 494	com/tencent/mm/autogen/mmdata/rpt/bs:iuu	I
    //   2111: aload_1
    //   2112: invokestatic 497	com/tencent/mm/plugin/emoji/mgr/h:c	(Lcom/tencent/mm/autogen/a/cd;)Z
    //   2115: ifeq -299 -> 1816
    //   2118: invokestatic 503	com/tencent/mm/smiley/j:iVg	()Lcom/tencent/mm/smiley/j;
    //   2121: pop
    //   2122: aload_1
    //   2123: getfield 62	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
    //   2126: getfield 73	com/tencent/mm/autogen/a/cd$a:filePath	Ljava/lang/String;
    //   2129: invokestatic 506	com/tencent/mm/smiley/j:bux	(Ljava/lang/String;)V
    //   2132: aload 7
    //   2134: invokestatic 503	com/tencent/mm/smiley/j:iVg	()Lcom/tencent/mm/smiley/j;
    //   2137: invokevirtual 509	com/tencent/mm/smiley/j:iUX	()Z
    //   2140: invokevirtual 327	com/tencent/mm/emoji/d/f:fn	(Z)V
    //   2143: aload 7
    //   2145: getfield 283	com/tencent/mm/emoji/d/f:mmv	Lcom/tencent/mm/autogen/mmdata/rpt/bs;
    //   2148: invokevirtual 291	com/tencent/mm/autogen/mmdata/rpt/bs:bMH	()Z
    //   2151: pop
    //   2152: goto -336 -> 1816
    //   2155: astore 7
    //   2157: aconst_null
    //   2158: astore 11
    //   2160: goto -1654 -> 506
    //   2163: astore 7
    //   2165: aload 10
    //   2167: astore_1
    //   2168: aload 9
    //   2170: astore 8
    //   2172: goto -1666 -> 506
    //   2175: astore 12
    //   2177: aconst_null
    //   2178: astore 7
    //   2180: iload 4
    //   2182: istore_2
    //   2183: goto -1732 -> 451
    //   2186: astore 12
    //   2188: goto -1737 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2191	0	this	EmojiResUpdateListener
    //   0	2191	1	paramcd	cd
    //   161	2022	2	i	int
    //   159	202	3	j	int
    //   156	2025	4	k	int
    //   153	10	5	m	int
    //   650	1275	6	bool	boolean
    //   171	317	7	localObject1	Object
    //   495	31	7	localObject2	Object
    //   620	1524	7	localObject3	Object
    //   2155	1	7	localObject4	Object
    //   2163	1	7	localObject5	Object
    //   2178	1	7	localObject6	Object
    //   202	1969	8	localObject7	Object
    //   168	2001	9	localObject8	Object
    //   224	1942	10	localObject9	Object
    //   221	1938	11	localObject10	Object
    //   217	117	12	str1	String
    //   433	34	12	localException1	java.lang.Exception
    //   2175	1	12	localException2	java.lang.Exception
    //   2186	1	12	localException3	java.lang.Exception
    //   51	371	13	localu1	com.tencent.mm.vfs.u
    //   92	271	14	localu2	com.tencent.mm.vfs.u
    //   105	271	15	localu3	com.tencent.mm.vfs.u
    //   237	33	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   173	188	433	java/lang/Exception
    //   194	204	433	java/lang/Exception
    //   173	188	495	finally
    //   194	204	495	finally
    //   204	215	2155	finally
    //   232	239	2163	finally
    //   257	279	2163	finally
    //   295	310	2163	finally
    //   323	346	2163	finally
    //   462	478	2163	finally
    //   204	215	2175	java/lang/Exception
    //   232	239	2186	java/lang/Exception
    //   257	279	2186	java/lang/Exception
    //   295	310	2186	java/lang/Exception
    //   323	346	2186	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.event.EmojiResUpdateListener
 * JD-Core Version:    0.7.0.1
 */