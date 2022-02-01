package com.tencent.mm.plugin.editor;

import android.view.MenuItem.OnMenuItemClickListener;

final class EditorUI$21
  implements MenuItem.OnMenuItemClickListener
{
  EditorUI$21(EditorUI paramEditorUI) {}
  
  /* Error */
  public final boolean onMenuItemClick(android.view.MenuItem paramMenuItem)
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 33
    //   7: ldc 35
    //   9: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 14	com/tencent/mm/plugin/editor/EditorUI$21:upk	Lcom/tencent/mm/plugin/editor/EditorUI;
    //   16: astore 6
    //   18: aload 6
    //   20: getfield 44	com/tencent/mm/plugin/editor/EditorUI:uoP	Lcom/tencent/mm/plugin/editor/widget/a;
    //   23: aload 6
    //   25: invokevirtual 50	com/tencent/mm/plugin/editor/widget/a:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/b/a;)V
    //   28: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:cRT	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
    //   31: invokevirtual 60	com/tencent/mm/plugin/editor/model/nativenote/manager/c:cSb	()Ljava/lang/String;
    //   34: astore_1
    //   35: aload_1
    //   36: invokestatic 64	com/tencent/mm/plugin/editor/EditorUI:atz	(Ljava/lang/String;)Z
    //   39: ifne +66 -> 105
    //   42: aload 6
    //   44: invokevirtual 68	com/tencent/mm/plugin/editor/EditorUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   47: astore 5
    //   49: aload 6
    //   51: getstatic 74	com/tencent/mm/plugin/editor/d$h:app_tip	I
    //   54: invokevirtual 78	com/tencent/mm/plugin/editor/EditorUI:getString	(I)Ljava/lang/String;
    //   57: pop
    //   58: aload 6
    //   60: aload 5
    //   62: aload 6
    //   64: getstatic 81	com/tencent/mm/plugin/editor/d$h:app_waiting	I
    //   67: invokevirtual 78	com/tencent/mm/plugin/editor/EditorUI:getString	(I)Ljava/lang/String;
    //   70: iconst_1
    //   71: new 83	com/tencent/mm/plugin/editor/EditorUI$18
    //   74: dup
    //   75: aload 6
    //   77: invokespecial 85	com/tencent/mm/plugin/editor/EditorUI$18:<init>	(Lcom/tencent/mm/plugin/editor/EditorUI;)V
    //   80: invokestatic 90	com/tencent/mm/ui/base/h:a	(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/DialogInterface$OnCancelListener;)Lcom/tencent/mm/ui/base/s;
    //   83: putfield 94	com/tencent/mm/plugin/editor/EditorUI:syZ	Landroid/app/ProgressDialog;
    //   86: invokestatic 56	com/tencent/mm/plugin/editor/model/nativenote/manager/c:cRT	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/c;
    //   89: aload_1
    //   90: invokevirtual 98	com/tencent/mm/plugin/editor/model/nativenote/manager/c:atO	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/aoc;
    //   93: astore_1
    //   94: aload_1
    //   95: ifnonnull +17 -> 112
    //   98: ldc 33
    //   100: ldc 100
    //   102: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: ldc 25
    //   107: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: iconst_1
    //   111: ireturn
    //   112: aload 6
    //   114: getfield 110	com/tencent/mm/plugin/editor/EditorUI:uph	Ljava/util/LinkedList;
    //   117: invokevirtual 115	java/util/LinkedList:clear	()V
    //   120: aload 6
    //   122: getfield 110	com/tencent/mm/plugin/editor/EditorUI:uph	Ljava/util/LinkedList;
    //   125: aload_1
    //   126: getfield 120	com/tencent/mm/protocal/protobuf/aoc:syG	Ljava/util/LinkedList;
    //   129: invokevirtual 124	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   132: pop
    //   133: aload 6
    //   135: aload 6
    //   137: getfield 110	com/tencent/mm/plugin/editor/EditorUI:uph	Ljava/util/LinkedList;
    //   140: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   143: invokestatic 135	com/tencent/mm/plugin/fav/ui/k:a	(Ljava/util/LinkedList;J)Lcom/tencent/mm/plugin/fav/a/g;
    //   146: putfield 139	com/tencent/mm/plugin/editor/EditorUI:upg	Lcom/tencent/mm/plugin/fav/a/g;
    //   149: iconst_0
    //   150: istore_2
    //   151: iload_2
    //   152: aload 6
    //   154: getfield 110	com/tencent/mm/plugin/editor/EditorUI:uph	Ljava/util/LinkedList;
    //   157: invokevirtual 143	java/util/LinkedList:size	()I
    //   160: if_icmpge -55 -> 105
    //   163: aload 6
    //   165: getfield 110	com/tencent/mm/plugin/editor/EditorUI:uph	Ljava/util/LinkedList;
    //   168: iload_2
    //   169: invokevirtual 147	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   172: checkcast 149	com/tencent/mm/protocal/protobuf/anm
    //   175: astore 7
    //   177: aload 7
    //   179: getfield 153	com/tencent/mm/protocal/protobuf/anm:fEa	Ljava/lang/String;
    //   182: invokestatic 158	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   185: ifeq +25 -> 210
    //   188: aload 7
    //   190: aload 7
    //   192: invokevirtual 161	java/lang/Object:toString	()Ljava/lang/String;
    //   195: aload 6
    //   197: getfield 139	com/tencent/mm/plugin/editor/EditorUI:upg	Lcom/tencent/mm/plugin/fav/a/g;
    //   200: getfield 166	com/tencent/mm/plugin/fav/a/g:field_type	I
    //   203: invokestatic 172	com/tencent/mm/plugin/fav/a/b:dN	(Ljava/lang/String;I)Ljava/lang/String;
    //   206: invokevirtual 176	com/tencent/mm/protocal/protobuf/anm:bsK	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
    //   209: pop
    //   210: aload 7
    //   212: getfield 179	com/tencent/mm/protocal/protobuf/anm:Syl	Ljava/lang/String;
    //   215: astore_1
    //   216: aload_1
    //   217: invokestatic 184	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   220: ifeq +240 -> 460
    //   223: aload_1
    //   224: invokestatic 190	com/tencent/mm/b/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 5
    //   229: aload_1
    //   230: invokestatic 193	com/tencent/mm/b/g:fR	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 8
    //   235: aload 7
    //   237: aload 5
    //   239: invokevirtual 196	com/tencent/mm/protocal/protobuf/anm:bsI	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
    //   242: pop
    //   243: aload 7
    //   245: aload 8
    //   247: invokevirtual 199	com/tencent/mm/protocal/protobuf/anm:bsJ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
    //   250: pop
    //   251: aload 7
    //   253: new 201	com/tencent/mm/vfs/q
    //   256: dup
    //   257: aload_1
    //   258: invokespecial 204	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   261: invokevirtual 207	com/tencent/mm/vfs/q:length	()J
    //   264: invokevirtual 211	com/tencent/mm/protocal/protobuf/anm:TY	(J)Lcom/tencent/mm/protocal/protobuf/anm;
    //   267: pop
    //   268: aload 7
    //   270: invokestatic 215	com/tencent/mm/plugin/fav/a/b:d	(Lcom/tencent/mm/protocal/protobuf/anm;)Ljava/lang/String;
    //   273: astore 5
    //   275: aload_1
    //   276: aload 5
    //   278: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifne +10 -> 291
    //   284: aload_1
    //   285: aload 5
    //   287: invokestatic 225	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   290: pop2
    //   291: aload 6
    //   293: aload 7
    //   295: getstatic 231	com/tencent/mm/plugin/editor/EditorUI$b:upr	Lcom/tencent/mm/plugin/editor/EditorUI$b;
    //   298: invokevirtual 234	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/anm;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
    //   301: aload 7
    //   303: getfield 237	com/tencent/mm/protocal/protobuf/anm:Syn	Ljava/lang/String;
    //   306: astore 8
    //   308: aload 8
    //   310: invokestatic 184	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   313: ifeq +228 -> 541
    //   316: aconst_null
    //   317: astore_1
    //   318: aload 8
    //   320: invokestatic 241	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   323: astore 5
    //   325: aload 5
    //   327: astore_1
    //   328: aload 5
    //   330: sipush 4096
    //   333: invokestatic 245	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   336: invokestatic 248	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   339: astore 9
    //   341: aload 5
    //   343: astore_1
    //   344: aload 8
    //   346: invokestatic 252	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   349: lstore_3
    //   350: aload 5
    //   352: astore_1
    //   353: aload 5
    //   355: iconst_0
    //   356: sipush 256
    //   359: invokestatic 255	com/tencent/mm/b/g:a	(Ljava/io/InputStream;II)Ljava/lang/String;
    //   362: astore 10
    //   364: aload 5
    //   366: astore_1
    //   367: aload 7
    //   369: aload 9
    //   371: invokevirtual 258	com/tencent/mm/protocal/protobuf/anm:bsN	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
    //   374: pop
    //   375: aload 5
    //   377: astore_1
    //   378: aload 7
    //   380: aload 10
    //   382: invokevirtual 261	com/tencent/mm/protocal/protobuf/anm:bsO	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/anm;
    //   385: pop
    //   386: aload 5
    //   388: astore_1
    //   389: aload 7
    //   391: lload_3
    //   392: invokevirtual 264	com/tencent/mm/protocal/protobuf/anm:TZ	(J)Lcom/tencent/mm/protocal/protobuf/anm;
    //   395: pop
    //   396: aload 5
    //   398: astore_1
    //   399: aload 7
    //   401: invokestatic 266	com/tencent/mm/plugin/fav/a/b:a	(Lcom/tencent/mm/protocal/protobuf/anm;)Ljava/lang/String;
    //   404: astore 9
    //   406: aload 5
    //   408: astore_1
    //   409: aload 8
    //   411: aload 9
    //   413: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifne +14 -> 430
    //   419: aload 5
    //   421: astore_1
    //   422: aload 8
    //   424: aload 9
    //   426: invokestatic 225	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   429: pop2
    //   430: aload 5
    //   432: astore_1
    //   433: aload 6
    //   435: aload 7
    //   437: getstatic 269	com/tencent/mm/plugin/editor/EditorUI$b:upq	Lcom/tencent/mm/plugin/editor/EditorUI$b;
    //   440: invokevirtual 234	com/tencent/mm/plugin/editor/EditorUI:a	(Lcom/tencent/mm/protocal/protobuf/anm;Lcom/tencent/mm/plugin/editor/EditorUI$b;)V
    //   443: aload 5
    //   445: ifnull +8 -> 453
    //   448: aload 5
    //   450: invokevirtual 274	java/io/InputStream:close	()V
    //   453: iload_2
    //   454: iconst_1
    //   455: iadd
    //   456: istore_2
    //   457: goto -306 -> 151
    //   460: ldc 33
    //   462: ldc_w 276
    //   465: iconst_2
    //   466: anewarray 4	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: aload 7
    //   473: getfield 279	com/tencent/mm/protocal/protobuf/anm:dataType	I
    //   476: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   479: aastore
    //   480: dup
    //   481: iconst_1
    //   482: aload_1
    //   483: aastore
    //   484: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   487: goto -186 -> 301
    //   490: astore_1
    //   491: aconst_null
    //   492: astore_1
    //   493: ldc 33
    //   495: ldc_w 290
    //   498: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: aload_1
    //   502: ifnull -49 -> 453
    //   505: aload_1
    //   506: invokevirtual 274	java/io/InputStream:close	()V
    //   509: goto -56 -> 453
    //   512: astore_1
    //   513: goto -60 -> 453
    //   516: astore 5
    //   518: aload_1
    //   519: astore 6
    //   521: aload 5
    //   523: astore_1
    //   524: aload 6
    //   526: ifnull +8 -> 534
    //   529: aload 6
    //   531: invokevirtual 274	java/io/InputStream:close	()V
    //   534: ldc 25
    //   536: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   539: aload_1
    //   540: athrow
    //   541: ldc 33
    //   543: ldc_w 292
    //   546: iconst_1
    //   547: anewarray 4	java/lang/Object
    //   550: dup
    //   551: iconst_0
    //   552: aload 8
    //   554: aastore
    //   555: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   558: goto -105 -> 453
    //   561: astore_1
    //   562: goto -109 -> 453
    //   565: astore 5
    //   567: goto -33 -> 534
    //   570: astore 5
    //   572: aload_1
    //   573: astore 6
    //   575: aload 5
    //   577: astore_1
    //   578: goto -54 -> 524
    //   581: astore_1
    //   582: aload 5
    //   584: astore_1
    //   585: goto -92 -> 493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	21
    //   0	588	1	paramMenuItem	android.view.MenuItem
    //   150	307	2	i	int
    //   349	43	3	l	long
    //   47	402	5	localObject1	Object
    //   516	6	5	localObject2	Object
    //   565	1	5	localException	java.lang.Exception
    //   570	13	5	localObject3	Object
    //   16	558	6	localObject4	Object
    //   175	297	7	localanm	com.tencent.mm.protocal.protobuf.anm
    //   233	320	8	str1	java.lang.String
    //   339	86	9	str2	java.lang.String
    //   362	19	10	str3	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   318	325	490	java/io/FileNotFoundException
    //   505	509	512	java/lang/Exception
    //   318	325	516	finally
    //   328	341	516	finally
    //   344	350	516	finally
    //   353	364	516	finally
    //   367	375	516	finally
    //   378	386	516	finally
    //   389	396	516	finally
    //   399	406	516	finally
    //   409	419	516	finally
    //   422	430	516	finally
    //   433	443	516	finally
    //   448	453	561	java/lang/Exception
    //   529	534	565	java/lang/Exception
    //   493	501	570	finally
    //   328	341	581	java/io/FileNotFoundException
    //   344	350	581	java/io/FileNotFoundException
    //   353	364	581	java/io/FileNotFoundException
    //   367	375	581	java/io/FileNotFoundException
    //   378	386	581	java/io/FileNotFoundException
    //   389	396	581	java/io/FileNotFoundException
    //   399	406	581	java/io/FileNotFoundException
    //   409	419	581	java/io/FileNotFoundException
    //   422	430	581	java/io/FileNotFoundException
    //   433	443	581	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.21
 * JD-Core Version:    0.7.0.1
 */