package midas.x;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class md
{
  public ExecutorService a = Executors.newSingleThreadExecutor(qd.a("Database"));
  public g b;
  
  public md(Context paramContext)
  {
    this.b = new g(paramContext, "TencentUnipayIPList.db", null, 2);
  }
  
  /* Error */
  public java.util.ArrayList<ad> a()
  {
    // Byte code:
    //   0: new 56	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 57	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 50	midas/x/md:b	Lmidas/x/md$g;
    //   13: invokevirtual 63	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 5
    //   18: aload 5
    //   20: ldc 65
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_3
    //   32: aload_3
    //   33: astore 4
    //   35: new 73	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   42: astore 7
    //   44: aload_3
    //   45: astore 4
    //   47: aload 7
    //   49: ldc 76
    //   51: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: astore 4
    //   58: aload 7
    //   60: aload 5
    //   62: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_3
    //   67: astore 4
    //   69: aload 7
    //   71: ldc 85
    //   73: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: astore 4
    //   80: aload 7
    //   82: aload_3
    //   83: invokeinterface 91 1 0
    //   88: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: astore 4
    //   95: ldc 96
    //   97: aload 7
    //   99: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 105	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_3
    //   106: ifnull +169 -> 275
    //   109: aload_3
    //   110: astore 4
    //   112: aload_3
    //   113: invokeinterface 91 1 0
    //   118: ifle +157 -> 275
    //   121: aload_3
    //   122: astore 4
    //   124: aload_3
    //   125: invokeinterface 109 1 0
    //   130: pop
    //   131: iconst_0
    //   132: istore_1
    //   133: aload_3
    //   134: astore 4
    //   136: iload_1
    //   137: aload_3
    //   138: invokeinterface 91 1 0
    //   143: if_icmpge +132 -> 275
    //   146: aload_3
    //   147: astore 4
    //   149: new 111	midas/x/ad
    //   152: dup
    //   153: aload_3
    //   154: aload_3
    //   155: ldc 113
    //   157: invokeinterface 117 2 0
    //   162: invokeinterface 121 2 0
    //   167: invokespecial 124	midas/x/ad:<init>	(Ljava/lang/String;)V
    //   170: astore 5
    //   172: aload_3
    //   173: astore 4
    //   175: aload 5
    //   177: aload_3
    //   178: aload_3
    //   179: ldc 126
    //   181: invokeinterface 117 2 0
    //   186: invokeinterface 130 2 0
    //   191: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: putfield 139	midas/x/ad:b	Ljava/lang/Long;
    //   197: aload_3
    //   198: astore 4
    //   200: aload 5
    //   202: aload_3
    //   203: aload_3
    //   204: ldc 141
    //   206: invokeinterface 117 2 0
    //   211: invokeinterface 130 2 0
    //   216: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   219: putfield 144	midas/x/ad:c	Ljava/lang/Long;
    //   222: aload_3
    //   223: astore 4
    //   225: aload 5
    //   227: aload_3
    //   228: aload_3
    //   229: ldc 146
    //   231: invokeinterface 117 2 0
    //   236: invokeinterface 130 2 0
    //   241: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   244: putfield 149	midas/x/ad:d	Ljava/lang/Long;
    //   247: aload_3
    //   248: astore 4
    //   250: aload 6
    //   252: aload 5
    //   254: invokevirtual 153	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   257: pop
    //   258: aload_3
    //   259: astore 4
    //   261: aload_3
    //   262: invokeinterface 156 1 0
    //   267: pop
    //   268: iload_1
    //   269: iconst_1
    //   270: iadd
    //   271: istore_1
    //   272: goto -139 -> 133
    //   275: aload_3
    //   276: ifnull +90 -> 366
    //   279: goto +81 -> 360
    //   282: astore 5
    //   284: goto +14 -> 298
    //   287: astore_3
    //   288: aconst_null
    //   289: astore 4
    //   291: goto +561 -> 852
    //   294: astore 5
    //   296: aconst_null
    //   297: astore_3
    //   298: aload_3
    //   299: astore 4
    //   301: new 73	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   308: astore 7
    //   310: aload_3
    //   311: astore 4
    //   313: aload 7
    //   315: ldc 158
    //   317: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_3
    //   322: astore 4
    //   324: aload 7
    //   326: aload 5
    //   328: invokevirtual 159	java/lang/Exception:toString	()Ljava/lang/String;
    //   331: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_3
    //   336: astore 4
    //   338: ldc 161
    //   340: aload 7
    //   342: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 164	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload_3
    //   349: astore 4
    //   351: aload 5
    //   353: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   356: aload_3
    //   357: ifnull +9 -> 366
    //   360: aload_3
    //   361: invokeinterface 170 1 0
    //   366: new 73	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   373: astore_3
    //   374: aload_3
    //   375: ldc 172
    //   377: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_3
    //   382: aload 6
    //   384: invokevirtual 175	java/util/ArrayList:size	()I
    //   387: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: ldc 96
    //   393: aload_3
    //   394: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 105	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload 6
    //   402: invokevirtual 179	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   405: astore 7
    //   407: aload 7
    //   409: invokeinterface 184 1 0
    //   414: ifeq +434 -> 848
    //   417: aload 7
    //   419: invokeinterface 188 1 0
    //   424: checkcast 111	midas/x/ad
    //   427: astore 8
    //   429: new 56	java/util/ArrayList
    //   432: dup
    //   433: invokespecial 57	java/util/ArrayList:<init>	()V
    //   436: astore 9
    //   438: aload_0
    //   439: getfield 50	midas/x/md:b	Lmidas/x/md$g;
    //   442: invokevirtual 63	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   445: ldc 190
    //   447: aconst_null
    //   448: ldc 192
    //   450: iconst_1
    //   451: anewarray 194	java/lang/String
    //   454: dup
    //   455: iconst_0
    //   456: aload 8
    //   458: getfield 197	midas/x/ad:a	Ljava/lang/String;
    //   461: aastore
    //   462: aconst_null
    //   463: aconst_null
    //   464: aconst_null
    //   465: invokevirtual 71	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   468: astore_3
    //   469: aload_3
    //   470: astore 4
    //   472: new 73	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   479: astore 5
    //   481: aload_3
    //   482: astore 4
    //   484: aload 5
    //   486: ldc 199
    //   488: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload_3
    //   493: astore 4
    //   495: aload 5
    //   497: aload 8
    //   499: getfield 197	midas/x/ad:a	Ljava/lang/String;
    //   502: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_3
    //   507: astore 4
    //   509: aload 5
    //   511: ldc 201
    //   513: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload_3
    //   518: astore 4
    //   520: aload 5
    //   522: aload_3
    //   523: invokeinterface 91 1 0
    //   528: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_3
    //   533: astore 4
    //   535: ldc 96
    //   537: aload 5
    //   539: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 105	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload_3
    //   546: ifnull +182 -> 728
    //   549: aload_3
    //   550: astore 4
    //   552: aload_3
    //   553: invokeinterface 91 1 0
    //   558: ifle +170 -> 728
    //   561: aload_3
    //   562: astore 4
    //   564: aload_3
    //   565: invokeinterface 109 1 0
    //   570: pop
    //   571: iconst_0
    //   572: istore_1
    //   573: aload_3
    //   574: astore 4
    //   576: iload_1
    //   577: aload_3
    //   578: invokeinterface 91 1 0
    //   583: if_icmpge +145 -> 728
    //   586: aload_3
    //   587: astore 4
    //   589: new 203	midas/x/zc
    //   592: dup
    //   593: aload_3
    //   594: aload_3
    //   595: ldc 205
    //   597: invokeinterface 117 2 0
    //   602: invokeinterface 121 2 0
    //   607: invokespecial 206	midas/x/zc:<init>	(Ljava/lang/String;)V
    //   610: astore 5
    //   612: aload_3
    //   613: astore 4
    //   615: aload 5
    //   617: aload_3
    //   618: aload_3
    //   619: ldc 208
    //   621: invokeinterface 117 2 0
    //   626: invokeinterface 121 2 0
    //   631: invokevirtual 210	midas/x/zc:a	(Ljava/lang/String;)V
    //   634: aload_3
    //   635: astore 4
    //   637: aload_3
    //   638: aload_3
    //   639: ldc 212
    //   641: invokeinterface 117 2 0
    //   646: invokeinterface 216 2 0
    //   651: istore_2
    //   652: aload_3
    //   653: astore 4
    //   655: aload 5
    //   657: aload_3
    //   658: aload_3
    //   659: ldc 218
    //   661: invokeinterface 117 2 0
    //   666: invokeinterface 121 2 0
    //   671: iload_2
    //   672: invokevirtual 221	midas/x/zc:a	(Ljava/lang/String;I)V
    //   675: aload_3
    //   676: astore 4
    //   678: aload 5
    //   680: aload_3
    //   681: aload_3
    //   682: ldc 223
    //   684: invokeinterface 117 2 0
    //   689: invokeinterface 216 2 0
    //   694: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   697: putfield 232	midas/x/zc:e	Ljava/lang/Integer;
    //   700: aload_3
    //   701: astore 4
    //   703: aload 9
    //   705: aload 5
    //   707: invokevirtual 153	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   710: pop
    //   711: aload_3
    //   712: astore 4
    //   714: aload_3
    //   715: invokeinterface 156 1 0
    //   720: pop
    //   721: iload_1
    //   722: iconst_1
    //   723: iadd
    //   724: istore_1
    //   725: goto -152 -> 573
    //   728: aload_3
    //   729: ifnull +90 -> 819
    //   732: goto +81 -> 813
    //   735: astore 5
    //   737: goto +14 -> 751
    //   740: astore_3
    //   741: aconst_null
    //   742: astore 4
    //   744: goto +90 -> 834
    //   747: astore 5
    //   749: aconst_null
    //   750: astore_3
    //   751: aload_3
    //   752: astore 4
    //   754: new 73	java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   761: astore 10
    //   763: aload_3
    //   764: astore 4
    //   766: aload 10
    //   768: ldc 234
    //   770: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload_3
    //   775: astore 4
    //   777: aload 10
    //   779: aload 5
    //   781: invokevirtual 159	java/lang/Exception:toString	()Ljava/lang/String;
    //   784: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload_3
    //   789: astore 4
    //   791: ldc 161
    //   793: aload 10
    //   795: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 164	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: aload_3
    //   802: astore 4
    //   804: aload 5
    //   806: invokevirtual 167	java/lang/Exception:printStackTrace	()V
    //   809: aload_3
    //   810: ifnull +9 -> 819
    //   813: aload_3
    //   814: invokeinterface 170 1 0
    //   819: aload 8
    //   821: getfield 237	midas/x/ad:e	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   824: aload 9
    //   826: invokevirtual 243	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   829: pop
    //   830: goto -423 -> 407
    //   833: astore_3
    //   834: aload 4
    //   836: ifnull +10 -> 846
    //   839: aload 4
    //   841: invokeinterface 170 1 0
    //   846: aload_3
    //   847: athrow
    //   848: aload 6
    //   850: areturn
    //   851: astore_3
    //   852: aload 4
    //   854: ifnull +10 -> 864
    //   857: aload 4
    //   859: invokeinterface 170 1 0
    //   864: goto +5 -> 869
    //   867: aload_3
    //   868: athrow
    //   869: goto -2 -> 867
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	872	0	this	md
    //   132	593	1	i	int
    //   651	21	2	j	int
    //   31	245	3	localCursor	android.database.Cursor
    //   287	1	3	localObject1	Object
    //   297	432	3	localObject2	Object
    //   740	1	3	localObject3	Object
    //   750	64	3	localObject4	Object
    //   833	14	3	localObject5	Object
    //   851	17	3	localObject6	Object
    //   33	825	4	localObject7	Object
    //   16	237	5	localObject8	Object
    //   282	1	5	localException1	Exception
    //   294	58	5	localException2	Exception
    //   479	227	5	localObject9	Object
    //   735	1	5	localException3	Exception
    //   747	58	5	localException4	Exception
    //   7	842	6	localArrayList1	java.util.ArrayList
    //   42	376	7	localObject10	Object
    //   427	393	8	localad	ad
    //   436	389	9	localArrayList2	java.util.ArrayList
    //   761	33	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   35	44	282	java/lang/Exception
    //   47	55	282	java/lang/Exception
    //   58	66	282	java/lang/Exception
    //   69	77	282	java/lang/Exception
    //   80	92	282	java/lang/Exception
    //   95	105	282	java/lang/Exception
    //   112	121	282	java/lang/Exception
    //   124	131	282	java/lang/Exception
    //   136	146	282	java/lang/Exception
    //   149	172	282	java/lang/Exception
    //   175	197	282	java/lang/Exception
    //   200	222	282	java/lang/Exception
    //   225	247	282	java/lang/Exception
    //   250	258	282	java/lang/Exception
    //   261	268	282	java/lang/Exception
    //   9	32	287	finally
    //   9	32	294	java/lang/Exception
    //   472	481	735	java/lang/Exception
    //   484	492	735	java/lang/Exception
    //   495	506	735	java/lang/Exception
    //   509	517	735	java/lang/Exception
    //   520	532	735	java/lang/Exception
    //   535	545	735	java/lang/Exception
    //   552	561	735	java/lang/Exception
    //   564	571	735	java/lang/Exception
    //   576	586	735	java/lang/Exception
    //   589	612	735	java/lang/Exception
    //   615	634	735	java/lang/Exception
    //   637	652	735	java/lang/Exception
    //   655	675	735	java/lang/Exception
    //   678	700	735	java/lang/Exception
    //   703	711	735	java/lang/Exception
    //   714	721	735	java/lang/Exception
    //   438	469	740	finally
    //   438	469	747	java/lang/Exception
    //   472	481	833	finally
    //   484	492	833	finally
    //   495	506	833	finally
    //   509	517	833	finally
    //   520	532	833	finally
    //   535	545	833	finally
    //   552	561	833	finally
    //   564	571	833	finally
    //   576	586	833	finally
    //   589	612	833	finally
    //   615	634	833	finally
    //   637	652	833	finally
    //   655	675	833	finally
    //   678	700	833	finally
    //   703	711	833	finally
    //   714	721	833	finally
    //   754	763	833	finally
    //   766	774	833	finally
    //   777	788	833	finally
    //   791	801	833	finally
    //   804	809	833	finally
    //   35	44	851	finally
    //   47	55	851	finally
    //   58	66	851	finally
    //   69	77	851	finally
    //   80	92	851	finally
    //   95	105	851	finally
    //   112	121	851	finally
    //   124	131	851	finally
    //   136	146	851	finally
    //   149	172	851	finally
    //   175	197	851	finally
    //   200	222	851	finally
    //   225	247	851	finally
    //   250	258	851	finally
    //   261	268	851	finally
    //   301	310	851	finally
    //   313	321	851	finally
    //   324	335	851	finally
    //   338	348	851	finally
    //   351	356	851	finally
  }
  
  public void a(final ad paramad)
  {
    rd.a(this.a, new e(paramad), new Object[] { this.b }, null);
  }
  
  public void a(final ad paramad, final zc paramzc)
  {
    rd.a(this.a, new a(paramzc, paramad), new Object[] { this.b }, null);
  }
  
  public void a(pd parampd)
  {
    rd.a(this.a, new f(), new Object[] { this.b }, parampd);
  }
  
  public void b()
  {
    ExecutorService localExecutorService = this.a;
    if ((localExecutorService != null) && (!localExecutorService.isShutdown())) {
      this.a.shutdown();
    }
    this.a = null;
    this.b.close();
    this.b = null;
  }
  
  public void b(final ad paramad)
  {
    rd.a(this.a, new b(paramad), new Object[] { this.b }, null);
  }
  
  public void c(final ad paramad)
  {
    rd.a(this.a, new d(paramad), new Object[] { this.b }, null);
  }
  
  public void d(final ad paramad)
  {
    rd.a(this.a, new c(paramad), new Object[] { this.b }, null);
  }
  
  public class a
    implements od
  {
    public a(zc paramzc, ad paramad) {}
    
    public Object a(Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfObject = ((md.g)paramArrayOfObject[0]).getWritableDatabase();
        localObject = new ContentValues();
        ((ContentValues)localObject).put("ip", paramzc.a);
        ((ContentValues)localObject).put("measure", paramzc.e());
        ((ContentValues)localObject).put("history", paramzc.a());
        ((ContentValues)localObject).put("historyIndex", paramzc.d);
        ((ContentValues)localObject).put("category", paramzc.e);
        ((ContentValues)localObject).put("netIdentifier", paramad.a);
        paramArrayOfObject.update("MidasIPTableVer2", (ContentValues)localObject, "ip=? and netIdentifier=?", new String[] { paramzc.a, paramad.a });
      }
      catch (Exception paramArrayOfObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("method=updateIP&exception=");
        ((StringBuilder)localObject).append(paramArrayOfObject.toString());
        gd.a("database.exception", ((StringBuilder)localObject).toString());
        paramArrayOfObject.printStackTrace();
      }
      return new Object();
    }
  }
  
  public class b
    implements od
  {
    public b(ad paramad) {}
    
    /* Error */
    public Object a(Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore_2
      //   4: aload_1
      //   5: iconst_0
      //   6: aaload
      //   7: checkcast 26	midas/x/md$g
      //   10: invokevirtual 32	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   13: astore_1
      //   14: new 34	java/lang/StringBuilder
      //   17: dup
      //   18: invokespecial 35	java/lang/StringBuilder:<init>	()V
      //   21: astore_2
      //   22: aload_2
      //   23: ldc 37
      //   25: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: pop
      //   29: aload_2
      //   30: aload_0
      //   31: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   34: getfield 46	midas/x/ad:a	Ljava/lang/String;
      //   37: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: pop
      //   41: aload_2
      //   42: ldc 48
      //   44: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: pop
      //   48: aload_2
      //   49: aload_0
      //   50: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   53: getfield 52	midas/x/ad:e	Ljava/util/concurrent/CopyOnWriteArrayList;
      //   56: invokevirtual 58	java/util/concurrent/CopyOnWriteArrayList:size	()I
      //   59: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   62: pop
      //   63: aload_2
      //   64: ldc 63
      //   66: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: pop
      //   70: aload_2
      //   71: aload_0
      //   72: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   75: getfield 52	midas/x/ad:e	Ljava/util/concurrent/CopyOnWriteArrayList;
      //   78: invokevirtual 67	java/util/concurrent/CopyOnWriteArrayList:toString	()Ljava/lang/String;
      //   81: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   84: pop
      //   85: ldc 69
      //   87: aload_2
      //   88: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   91: invokestatic 75	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   94: aload_1
      //   95: invokevirtual 80	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
      //   98: aload_1
      //   99: ldc 82
      //   101: ldc 84
      //   103: iconst_1
      //   104: anewarray 86	java/lang/String
      //   107: dup
      //   108: iconst_0
      //   109: aload_0
      //   110: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   113: getfield 46	midas/x/ad:a	Ljava/lang/String;
      //   116: aastore
      //   117: invokevirtual 90	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      //   120: pop
      //   121: aload_0
      //   122: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   125: getfield 52	midas/x/ad:e	Ljava/util/concurrent/CopyOnWriteArrayList;
      //   128: invokevirtual 94	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
      //   131: astore_2
      //   132: aload_2
      //   133: invokeinterface 100 1 0
      //   138: ifeq +104 -> 242
      //   141: aload_2
      //   142: invokeinterface 104 1 0
      //   147: checkcast 106	midas/x/zc
      //   150: astore_3
      //   151: new 108	android/content/ContentValues
      //   154: dup
      //   155: invokespecial 109	android/content/ContentValues:<init>	()V
      //   158: astore 4
      //   160: aload 4
      //   162: ldc 111
      //   164: aload_3
      //   165: getfield 112	midas/x/zc:a	Ljava/lang/String;
      //   168: invokevirtual 115	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   171: aload 4
      //   173: ldc 117
      //   175: aload_3
      //   176: invokevirtual 119	midas/x/zc:e	()Ljava/lang/String;
      //   179: invokevirtual 115	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   182: aload 4
      //   184: ldc 121
      //   186: aload_3
      //   187: invokevirtual 123	midas/x/zc:a	()Ljava/lang/String;
      //   190: invokevirtual 115	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   193: aload 4
      //   195: ldc 125
      //   197: aload_3
      //   198: getfield 129	midas/x/zc:d	Ljava/lang/Integer;
      //   201: invokevirtual 132	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   204: aload 4
      //   206: ldc 134
      //   208: aload_3
      //   209: getfield 136	midas/x/zc:e	Ljava/lang/Integer;
      //   212: invokevirtual 132	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   215: aload 4
      //   217: ldc 138
      //   219: aload_0
      //   220: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   223: getfield 46	midas/x/ad:a	Ljava/lang/String;
      //   226: invokevirtual 115	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   229: aload_1
      //   230: ldc 82
      //   232: aconst_null
      //   233: aload 4
      //   235: invokevirtual 142	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   238: pop2
      //   239: goto -107 -> 132
      //   242: new 108	android/content/ContentValues
      //   245: dup
      //   246: invokespecial 109	android/content/ContentValues:<init>	()V
      //   249: astore_2
      //   250: aload_2
      //   251: ldc 144
      //   253: aload_0
      //   254: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   257: getfield 147	midas/x/ad:b	Ljava/lang/Long;
      //   260: invokevirtual 150	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   263: aload_2
      //   264: ldc 152
      //   266: aload_0
      //   267: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   270: getfield 154	midas/x/ad:d	Ljava/lang/Long;
      //   273: invokevirtual 150	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   276: aload_1
      //   277: ldc 156
      //   279: aload_2
      //   280: ldc 158
      //   282: iconst_1
      //   283: anewarray 86	java/lang/String
      //   286: dup
      //   287: iconst_0
      //   288: aload_0
      //   289: getfield 17	midas/x/md$b:a	Lmidas/x/ad;
      //   292: getfield 46	midas/x/ad:a	Ljava/lang/String;
      //   295: aastore
      //   296: invokevirtual 162	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   299: pop
      //   300: aload_1
      //   301: invokevirtual 165	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
      //   304: aload_1
      //   305: ifnull +104 -> 409
      //   308: aload_1
      //   309: invokevirtual 168	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   312: ifeq +97 -> 409
      //   315: aload_1
      //   316: invokevirtual 171	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   319: goto +90 -> 409
      //   322: astore_2
      //   323: goto +94 -> 417
      //   326: astore_3
      //   327: goto +16 -> 343
      //   330: astore_3
      //   331: aload_2
      //   332: astore_1
      //   333: aload_3
      //   334: astore_2
      //   335: goto +82 -> 417
      //   338: astore_2
      //   339: aload_3
      //   340: astore_1
      //   341: aload_2
      //   342: astore_3
      //   343: aload_1
      //   344: astore_2
      //   345: new 34	java/lang/StringBuilder
      //   348: dup
      //   349: invokespecial 35	java/lang/StringBuilder:<init>	()V
      //   352: astore 4
      //   354: aload_1
      //   355: astore_2
      //   356: aload 4
      //   358: ldc 173
      //   360: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   363: pop
      //   364: aload_1
      //   365: astore_2
      //   366: aload 4
      //   368: aload_3
      //   369: invokevirtual 174	java/lang/Exception:toString	()Ljava/lang/String;
      //   372: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   375: pop
      //   376: aload_1
      //   377: astore_2
      //   378: ldc 176
      //   380: aload 4
      //   382: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   385: invokestatic 179	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   388: aload_1
      //   389: astore_2
      //   390: aload_3
      //   391: invokevirtual 182	java/lang/Exception:printStackTrace	()V
      //   394: aload_1
      //   395: ifnull +14 -> 409
      //   398: aload_1
      //   399: invokevirtual 168	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   402: ifeq +7 -> 409
      //   405: aload_1
      //   406: invokevirtual 171	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   409: new 4	java/lang/Object
      //   412: dup
      //   413: invokespecial 20	java/lang/Object:<init>	()V
      //   416: areturn
      //   417: aload_1
      //   418: ifnull +14 -> 432
      //   421: aload_1
      //   422: invokevirtual 168	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   425: ifeq +7 -> 432
      //   428: aload_1
      //   429: invokevirtual 171	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   432: goto +5 -> 437
      //   435: aload_2
      //   436: athrow
      //   437: goto -2 -> 435
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	440	0	this	b
      //   0	440	1	paramArrayOfObject	Object[]
      //   3	277	2	localObject1	Object
      //   322	10	2	localObject2	Object
      //   334	1	2	localObject3	Object
      //   338	4	2	localException1	Exception
      //   344	92	2	arrayOfObject	Object[]
      //   1	208	3	localzc	zc
      //   326	1	3	localException2	Exception
      //   330	10	3	localObject4	Object
      //   342	49	3	localObject5	Object
      //   158	223	4	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   14	132	322	finally
      //   132	239	322	finally
      //   242	304	322	finally
      //   14	132	326	java/lang/Exception
      //   132	239	326	java/lang/Exception
      //   242	304	326	java/lang/Exception
      //   4	14	330	finally
      //   345	354	330	finally
      //   356	364	330	finally
      //   366	376	330	finally
      //   378	388	330	finally
      //   390	394	330	finally
      //   4	14	338	java/lang/Exception
    }
  }
  
  public class c
    implements od
  {
    public c(ad paramad) {}
    
    /* Error */
    public Object a(Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: aload 4
      //   8: astore_3
      //   9: aload 5
      //   11: astore_2
      //   12: aload_1
      //   13: iconst_0
      //   14: aaload
      //   15: checkcast 26	midas/x/md$g
      //   18: invokevirtual 32	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   21: astore 6
      //   23: aload 4
      //   25: astore_3
      //   26: aload 5
      //   28: astore_2
      //   29: aload 6
      //   31: ldc 34
      //   33: aconst_null
      //   34: ldc 36
      //   36: iconst_1
      //   37: anewarray 38	java/lang/String
      //   40: dup
      //   41: iconst_0
      //   42: aload_0
      //   43: getfield 17	midas/x/md$c:a	Lmidas/x/ad;
      //   46: getfield 43	midas/x/ad:a	Ljava/lang/String;
      //   49: aastore
      //   50: aconst_null
      //   51: aconst_null
      //   52: aconst_null
      //   53: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   56: astore_1
      //   57: aload_1
      //   58: ifnonnull +16 -> 74
      //   61: aload_1
      //   62: astore_3
      //   63: aload_1
      //   64: astore_2
      //   65: aload_1
      //   66: invokeinterface 55 1 0
      //   71: ifle +118 -> 189
      //   74: aload_1
      //   75: astore_3
      //   76: aload_1
      //   77: astore_2
      //   78: new 57	android/content/ContentValues
      //   81: dup
      //   82: invokespecial 58	android/content/ContentValues:<init>	()V
      //   85: astore 4
      //   87: aload_1
      //   88: astore_3
      //   89: aload_1
      //   90: astore_2
      //   91: aload 4
      //   93: ldc 60
      //   95: aload_0
      //   96: getfield 17	midas/x/md$c:a	Lmidas/x/ad;
      //   99: getfield 43	midas/x/ad:a	Ljava/lang/String;
      //   102: invokevirtual 64	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   105: aload_1
      //   106: astore_3
      //   107: aload_1
      //   108: astore_2
      //   109: aload 4
      //   111: ldc 66
      //   113: aload_0
      //   114: getfield 17	midas/x/md$c:a	Lmidas/x/ad;
      //   117: getfield 70	midas/x/ad:b	Ljava/lang/Long;
      //   120: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   123: aload_1
      //   124: astore_3
      //   125: aload_1
      //   126: astore_2
      //   127: aload 4
      //   129: ldc 75
      //   131: aload_0
      //   132: getfield 17	midas/x/md$c:a	Lmidas/x/ad;
      //   135: getfield 77	midas/x/ad:d	Ljava/lang/Long;
      //   138: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   141: aload_1
      //   142: astore_3
      //   143: aload_1
      //   144: astore_2
      //   145: aload 4
      //   147: ldc 79
      //   149: aload_0
      //   150: getfield 17	midas/x/md$c:a	Lmidas/x/ad;
      //   153: getfield 82	midas/x/ad:c	Ljava/lang/Long;
      //   156: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   159: aload_1
      //   160: astore_3
      //   161: aload_1
      //   162: astore_2
      //   163: aload 6
      //   165: ldc 34
      //   167: aload 4
      //   169: ldc 36
      //   171: iconst_1
      //   172: anewarray 38	java/lang/String
      //   175: dup
      //   176: iconst_0
      //   177: aload_0
      //   178: getfield 17	midas/x/md$c:a	Lmidas/x/ad;
      //   181: getfield 43	midas/x/ad:a	Ljava/lang/String;
      //   184: aastore
      //   185: invokevirtual 86	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   188: pop
      //   189: aload_1
      //   190: ifnull +74 -> 264
      //   193: goto +65 -> 258
      //   196: astore_1
      //   197: goto +75 -> 272
      //   200: astore_1
      //   201: aload_2
      //   202: astore_3
      //   203: new 88	java/lang/StringBuilder
      //   206: dup
      //   207: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   210: astore 4
      //   212: aload_2
      //   213: astore_3
      //   214: aload 4
      //   216: ldc 91
      //   218: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   221: pop
      //   222: aload_2
      //   223: astore_3
      //   224: aload 4
      //   226: aload_1
      //   227: invokevirtual 99	java/lang/Exception:toString	()Ljava/lang/String;
      //   230: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   233: pop
      //   234: aload_2
      //   235: astore_3
      //   236: ldc 101
      //   238: aload 4
      //   240: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   243: invokestatic 106	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   246: aload_2
      //   247: astore_3
      //   248: aload_1
      //   249: invokevirtual 109	java/lang/Exception:printStackTrace	()V
      //   252: aload_2
      //   253: ifnull +11 -> 264
      //   256: aload_2
      //   257: astore_1
      //   258: aload_1
      //   259: invokeinterface 112 1 0
      //   264: new 4	java/lang/Object
      //   267: dup
      //   268: invokespecial 20	java/lang/Object:<init>	()V
      //   271: areturn
      //   272: aload_3
      //   273: ifnull +9 -> 282
      //   276: aload_3
      //   277: invokeinterface 112 1 0
      //   282: aload_1
      //   283: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	284	0	this	c
      //   0	284	1	paramArrayOfObject	Object[]
      //   11	246	2	localObject1	Object
      //   8	269	3	localObject2	Object
      //   4	235	4	localObject3	Object
      //   1	26	5	localObject4	Object
      //   21	143	6	localSQLiteDatabase	SQLiteDatabase
      // Exception table:
      //   from	to	target	type
      //   12	23	196	finally
      //   29	57	196	finally
      //   65	74	196	finally
      //   78	87	196	finally
      //   91	105	196	finally
      //   109	123	196	finally
      //   127	141	196	finally
      //   145	159	196	finally
      //   163	189	196	finally
      //   203	212	196	finally
      //   214	222	196	finally
      //   224	234	196	finally
      //   236	246	196	finally
      //   248	252	196	finally
      //   12	23	200	java/lang/Exception
      //   29	57	200	java/lang/Exception
      //   65	74	200	java/lang/Exception
      //   78	87	200	java/lang/Exception
      //   91	105	200	java/lang/Exception
      //   109	123	200	java/lang/Exception
      //   127	141	200	java/lang/Exception
      //   145	159	200	java/lang/Exception
      //   163	189	200	java/lang/Exception
    }
  }
  
  public class d
    implements od
  {
    public d(ad paramad) {}
    
    /* Error */
    public Object a(Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aconst_null
      //   4: astore_3
      //   5: aload_3
      //   6: astore_2
      //   7: aload_1
      //   8: iconst_0
      //   9: aaload
      //   10: checkcast 26	midas/x/md$g
      //   13: invokevirtual 32	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   16: astore 5
      //   18: aload_3
      //   19: astore_2
      //   20: aload 5
      //   22: ldc 34
      //   24: aconst_null
      //   25: ldc 36
      //   27: iconst_1
      //   28: anewarray 38	java/lang/String
      //   31: dup
      //   32: iconst_0
      //   33: aload_0
      //   34: getfield 17	midas/x/md$d:a	Lmidas/x/ad;
      //   37: getfield 43	midas/x/ad:a	Ljava/lang/String;
      //   40: aastore
      //   41: aconst_null
      //   42: aconst_null
      //   43: aconst_null
      //   44: invokevirtual 49	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   47: astore_1
      //   48: aload_1
      //   49: ifnull +12 -> 61
      //   52: aload_1
      //   53: invokeinterface 55 1 0
      //   58: ifgt +73 -> 131
      //   61: new 57	android/content/ContentValues
      //   64: dup
      //   65: invokespecial 58	android/content/ContentValues:<init>	()V
      //   68: astore_2
      //   69: aload_2
      //   70: ldc 60
      //   72: aload_0
      //   73: getfield 17	midas/x/md$d:a	Lmidas/x/ad;
      //   76: getfield 43	midas/x/ad:a	Ljava/lang/String;
      //   79: invokevirtual 64	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
      //   82: aload_2
      //   83: ldc 66
      //   85: aload_0
      //   86: getfield 17	midas/x/md$d:a	Lmidas/x/ad;
      //   89: getfield 70	midas/x/ad:b	Ljava/lang/Long;
      //   92: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   95: aload_2
      //   96: ldc 75
      //   98: aload_0
      //   99: getfield 17	midas/x/md$d:a	Lmidas/x/ad;
      //   102: getfield 78	midas/x/ad:d	Ljava/lang/Long;
      //   105: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   108: aload_2
      //   109: ldc 80
      //   111: aload_0
      //   112: getfield 17	midas/x/md$d:a	Lmidas/x/ad;
      //   115: getfield 82	midas/x/ad:c	Ljava/lang/Long;
      //   118: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   121: aload 5
      //   123: ldc 34
      //   125: aconst_null
      //   126: aload_2
      //   127: invokevirtual 86	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      //   130: pop2
      //   131: aload_1
      //   132: ifnull +93 -> 225
      //   135: aload_1
      //   136: invokeinterface 89 1 0
      //   141: goto +84 -> 225
      //   144: astore_2
      //   145: goto +88 -> 233
      //   148: astore_3
      //   149: goto +15 -> 164
      //   152: astore_3
      //   153: aload_2
      //   154: astore_1
      //   155: aload_3
      //   156: astore_2
      //   157: goto +76 -> 233
      //   160: astore_3
      //   161: aload 4
      //   163: astore_1
      //   164: aload_1
      //   165: astore_2
      //   166: new 91	java/lang/StringBuilder
      //   169: dup
      //   170: invokespecial 92	java/lang/StringBuilder:<init>	()V
      //   173: astore 4
      //   175: aload_1
      //   176: astore_2
      //   177: aload 4
      //   179: ldc 94
      //   181: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   184: pop
      //   185: aload_1
      //   186: astore_2
      //   187: aload 4
      //   189: aload_3
      //   190: invokevirtual 102	java/lang/Exception:toString	()Ljava/lang/String;
      //   193: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   196: pop
      //   197: aload_1
      //   198: astore_2
      //   199: ldc 104
      //   201: aload 4
      //   203: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   206: invokestatic 109	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   209: aload_1
      //   210: astore_2
      //   211: aload_3
      //   212: invokevirtual 112	java/lang/Exception:printStackTrace	()V
      //   215: aload_1
      //   216: ifnull +9 -> 225
      //   219: aload_1
      //   220: invokeinterface 89 1 0
      //   225: new 4	java/lang/Object
      //   228: dup
      //   229: invokespecial 20	java/lang/Object:<init>	()V
      //   232: areturn
      //   233: aload_1
      //   234: ifnull +9 -> 243
      //   237: aload_1
      //   238: invokeinterface 89 1 0
      //   243: aload_2
      //   244: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	245	0	this	d
      //   0	245	1	paramArrayOfObject	Object[]
      //   6	121	2	localObject1	Object
      //   144	10	2	localObject2	Object
      //   156	88	2	localObject3	Object
      //   4	15	3	localObject4	Object
      //   148	1	3	localException1	Exception
      //   152	4	3	localObject5	Object
      //   160	52	3	localException2	Exception
      //   1	201	4	localStringBuilder	StringBuilder
      //   16	106	5	localSQLiteDatabase	SQLiteDatabase
      // Exception table:
      //   from	to	target	type
      //   52	61	144	finally
      //   61	131	144	finally
      //   52	61	148	java/lang/Exception
      //   61	131	148	java/lang/Exception
      //   7	18	152	finally
      //   20	48	152	finally
      //   166	175	152	finally
      //   177	185	152	finally
      //   187	197	152	finally
      //   199	209	152	finally
      //   211	215	152	finally
      //   7	18	160	java/lang/Exception
      //   20	48	160	java/lang/Exception
    }
  }
  
  public class e
    implements od
  {
    public e(ad paramad) {}
    
    /* Error */
    public Object a(Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: aload_1
      //   5: iconst_0
      //   6: aaload
      //   7: checkcast 25	midas/x/md$g
      //   10: invokevirtual 31	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   13: astore_1
      //   14: aload_1
      //   15: astore_3
      //   16: aload_1
      //   17: astore_2
      //   18: aload_1
      //   19: invokevirtual 36	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
      //   22: aload_1
      //   23: astore_3
      //   24: aload_1
      //   25: astore_2
      //   26: aload_1
      //   27: ldc 38
      //   29: ldc 40
      //   31: iconst_1
      //   32: anewarray 42	java/lang/String
      //   35: dup
      //   36: iconst_0
      //   37: aload_0
      //   38: getfield 16	midas/x/md$e:a	Lmidas/x/ad;
      //   41: getfield 47	midas/x/ad:a	Ljava/lang/String;
      //   44: aastore
      //   45: invokevirtual 51	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      //   48: pop
      //   49: aload_1
      //   50: astore_3
      //   51: aload_1
      //   52: astore_2
      //   53: aload_1
      //   54: ldc 53
      //   56: ldc 55
      //   58: iconst_1
      //   59: anewarray 42	java/lang/String
      //   62: dup
      //   63: iconst_0
      //   64: aload_0
      //   65: getfield 16	midas/x/md$e:a	Lmidas/x/ad;
      //   68: getfield 47	midas/x/ad:a	Ljava/lang/String;
      //   71: aastore
      //   72: invokevirtual 51	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      //   75: pop
      //   76: aload_1
      //   77: astore_3
      //   78: aload_1
      //   79: astore_2
      //   80: aload_1
      //   81: invokevirtual 58	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
      //   84: aload_1
      //   85: ifnull +86 -> 171
      //   88: aload_1
      //   89: invokevirtual 62	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   92: ifeq +79 -> 171
      //   95: goto +72 -> 167
      //   98: astore_1
      //   99: goto +80 -> 179
      //   102: astore_1
      //   103: aload_2
      //   104: astore_3
      //   105: new 64	java/lang/StringBuilder
      //   108: dup
      //   109: invokespecial 65	java/lang/StringBuilder:<init>	()V
      //   112: astore 4
      //   114: aload_2
      //   115: astore_3
      //   116: aload 4
      //   118: ldc 67
      //   120: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: pop
      //   124: aload_2
      //   125: astore_3
      //   126: aload 4
      //   128: aload_1
      //   129: invokevirtual 75	java/lang/Exception:toString	()Ljava/lang/String;
      //   132: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   135: pop
      //   136: aload_2
      //   137: astore_3
      //   138: ldc 77
      //   140: aload 4
      //   142: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   145: invokestatic 83	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   148: aload_2
      //   149: astore_3
      //   150: aload_1
      //   151: invokevirtual 86	java/lang/Exception:printStackTrace	()V
      //   154: aload_2
      //   155: ifnull +16 -> 171
      //   158: aload_2
      //   159: invokevirtual 62	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   162: ifeq +9 -> 171
      //   165: aload_2
      //   166: astore_1
      //   167: aload_1
      //   168: invokevirtual 89	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   171: new 4	java/lang/Object
      //   174: dup
      //   175: invokespecial 19	java/lang/Object:<init>	()V
      //   178: areturn
      //   179: aload_3
      //   180: ifnull +14 -> 194
      //   183: aload_3
      //   184: invokevirtual 62	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
      //   187: ifeq +7 -> 194
      //   190: aload_3
      //   191: invokevirtual 89	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   194: aload_1
      //   195: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	196	0	this	e
      //   0	196	1	paramArrayOfObject	Object[]
      //   1	165	2	arrayOfObject1	Object[]
      //   3	188	3	arrayOfObject2	Object[]
      //   112	29	4	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   4	14	98	finally
      //   18	22	98	finally
      //   26	49	98	finally
      //   53	76	98	finally
      //   80	84	98	finally
      //   105	114	98	finally
      //   116	124	98	finally
      //   126	136	98	finally
      //   138	148	98	finally
      //   150	154	98	finally
      //   4	14	102	java/lang/Exception
      //   18	22	102	java/lang/Exception
      //   26	49	102	java/lang/Exception
      //   53	76	102	java/lang/Exception
      //   80	84	102	java/lang/Exception
    }
  }
  
  public class f
    implements od
  {
    public f() {}
    
    /* Error */
    public Object a(Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: new 22	java/util/ArrayList
      //   3: dup
      //   4: invokespecial 23	java/util/ArrayList:<init>	()V
      //   7: astore 7
      //   9: aload_1
      //   10: iconst_0
      //   11: aaload
      //   12: checkcast 25	midas/x/md$g
      //   15: invokevirtual 31	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   18: astore 6
      //   20: aload 6
      //   22: ldc 33
      //   24: aconst_null
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: aconst_null
      //   29: aconst_null
      //   30: invokevirtual 39	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   33: astore 4
      //   35: aload 4
      //   37: astore 5
      //   39: new 41	java/lang/StringBuilder
      //   42: dup
      //   43: invokespecial 42	java/lang/StringBuilder:<init>	()V
      //   46: astore 8
      //   48: aload 4
      //   50: astore 5
      //   52: aload 8
      //   54: ldc 44
      //   56: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: pop
      //   60: aload 4
      //   62: astore 5
      //   64: aload 8
      //   66: aload 6
      //   68: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   71: pop
      //   72: aload 4
      //   74: astore 5
      //   76: aload 8
      //   78: ldc 53
      //   80: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: pop
      //   84: aload 4
      //   86: astore 5
      //   88: aload 8
      //   90: aload 4
      //   92: invokeinterface 59 1 0
      //   97: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   100: pop
      //   101: aload 4
      //   103: astore 5
      //   105: ldc 64
      //   107: aload 8
      //   109: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   112: invokestatic 73	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   115: aload 4
      //   117: ifnull +190 -> 307
      //   120: aload 4
      //   122: astore 5
      //   124: aload 4
      //   126: invokeinterface 59 1 0
      //   131: ifle +176 -> 307
      //   134: aload 4
      //   136: astore 5
      //   138: aload 4
      //   140: invokeinterface 77 1 0
      //   145: pop
      //   146: iconst_0
      //   147: istore_2
      //   148: aload 4
      //   150: astore 5
      //   152: iload_2
      //   153: aload 4
      //   155: invokeinterface 59 1 0
      //   160: if_icmpge +147 -> 307
      //   163: aload 4
      //   165: astore 5
      //   167: new 79	midas/x/ad
      //   170: dup
      //   171: aload 4
      //   173: aload 4
      //   175: ldc 81
      //   177: invokeinterface 85 2 0
      //   182: invokeinterface 89 2 0
      //   187: invokespecial 92	midas/x/ad:<init>	(Ljava/lang/String;)V
      //   190: astore 6
      //   192: aload 4
      //   194: astore 5
      //   196: aload 6
      //   198: aload 4
      //   200: aload 4
      //   202: ldc 94
      //   204: invokeinterface 85 2 0
      //   209: invokeinterface 98 2 0
      //   214: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   217: putfield 108	midas/x/ad:b	Ljava/lang/Long;
      //   220: aload 4
      //   222: astore 5
      //   224: aload 6
      //   226: aload 4
      //   228: aload 4
      //   230: ldc 110
      //   232: invokeinterface 85 2 0
      //   237: invokeinterface 98 2 0
      //   242: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   245: putfield 113	midas/x/ad:d	Ljava/lang/Long;
      //   248: aload 4
      //   250: astore 5
      //   252: aload 6
      //   254: aload 4
      //   256: aload 4
      //   258: ldc 115
      //   260: invokeinterface 85 2 0
      //   265: invokeinterface 98 2 0
      //   270: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   273: putfield 118	midas/x/ad:c	Ljava/lang/Long;
      //   276: aload 4
      //   278: astore 5
      //   280: aload 7
      //   282: aload 6
      //   284: invokevirtual 122	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   287: pop
      //   288: aload 4
      //   290: astore 5
      //   292: aload 4
      //   294: invokeinterface 125 1 0
      //   299: pop
      //   300: iload_2
      //   301: iconst_1
      //   302: iadd
      //   303: istore_2
      //   304: goto -156 -> 148
      //   307: aload 4
      //   309: ifnull +98 -> 407
      //   312: goto +88 -> 400
      //   315: astore 6
      //   317: goto +15 -> 332
      //   320: astore_1
      //   321: aconst_null
      //   322: astore 5
      //   324: goto +617 -> 941
      //   327: astore 6
      //   329: aconst_null
      //   330: astore 4
      //   332: aload 4
      //   334: astore 5
      //   336: new 41	java/lang/StringBuilder
      //   339: dup
      //   340: invokespecial 42	java/lang/StringBuilder:<init>	()V
      //   343: astore 8
      //   345: aload 4
      //   347: astore 5
      //   349: aload 8
      //   351: ldc 127
      //   353: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   356: pop
      //   357: aload 4
      //   359: astore 5
      //   361: aload 8
      //   363: aload 6
      //   365: invokevirtual 128	java/lang/Exception:toString	()Ljava/lang/String;
      //   368: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   371: pop
      //   372: aload 4
      //   374: astore 5
      //   376: ldc 130
      //   378: aload 8
      //   380: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   383: invokestatic 133	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   386: aload 4
      //   388: astore 5
      //   390: aload 6
      //   392: invokevirtual 136	java/lang/Exception:printStackTrace	()V
      //   395: aload 4
      //   397: ifnull +10 -> 407
      //   400: aload 4
      //   402: invokeinterface 139 1 0
      //   407: new 41	java/lang/StringBuilder
      //   410: dup
      //   411: invokespecial 42	java/lang/StringBuilder:<init>	()V
      //   414: astore 4
      //   416: aload 4
      //   418: ldc 141
      //   420: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   423: pop
      //   424: aload 4
      //   426: aload 7
      //   428: invokevirtual 144	java/util/ArrayList:size	()I
      //   431: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   434: pop
      //   435: ldc 64
      //   437: aload 4
      //   439: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   442: invokestatic 73	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   445: aload 7
      //   447: invokevirtual 148	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   450: astore 8
      //   452: aload 8
      //   454: invokeinterface 153 1 0
      //   459: ifeq +478 -> 937
      //   462: aload 8
      //   464: invokeinterface 157 1 0
      //   469: checkcast 79	midas/x/ad
      //   472: astore 9
      //   474: new 22	java/util/ArrayList
      //   477: dup
      //   478: invokespecial 23	java/util/ArrayList:<init>	()V
      //   481: astore 10
      //   483: aload_1
      //   484: iconst_0
      //   485: aaload
      //   486: checkcast 25	midas/x/md$g
      //   489: invokevirtual 31	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
      //   492: ldc 159
      //   494: aconst_null
      //   495: ldc 161
      //   497: iconst_1
      //   498: anewarray 163	java/lang/String
      //   501: dup
      //   502: iconst_0
      //   503: aload 9
      //   505: getfield 166	midas/x/ad:a	Ljava/lang/String;
      //   508: aastore
      //   509: aconst_null
      //   510: aconst_null
      //   511: aconst_null
      //   512: invokevirtual 39	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   515: astore 4
      //   517: aload 4
      //   519: astore 5
      //   521: new 41	java/lang/StringBuilder
      //   524: dup
      //   525: invokespecial 42	java/lang/StringBuilder:<init>	()V
      //   528: astore 6
      //   530: aload 4
      //   532: astore 5
      //   534: aload 6
      //   536: ldc 168
      //   538: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   541: pop
      //   542: aload 4
      //   544: astore 5
      //   546: aload 6
      //   548: aload 9
      //   550: getfield 166	midas/x/ad:a	Ljava/lang/String;
      //   553: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   556: pop
      //   557: aload 4
      //   559: astore 5
      //   561: aload 6
      //   563: ldc 170
      //   565: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   568: pop
      //   569: aload 4
      //   571: astore 5
      //   573: aload 6
      //   575: aload 4
      //   577: invokeinterface 59 1 0
      //   582: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   585: pop
      //   586: aload 4
      //   588: astore 5
      //   590: ldc 64
      //   592: aload 6
      //   594: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   597: invokestatic 73	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   600: aload 4
      //   602: ifnull +206 -> 808
      //   605: aload 4
      //   607: astore 5
      //   609: aload 4
      //   611: invokeinterface 59 1 0
      //   616: ifle +192 -> 808
      //   619: aload 4
      //   621: astore 5
      //   623: aload 4
      //   625: invokeinterface 77 1 0
      //   630: pop
      //   631: iconst_0
      //   632: istore_2
      //   633: aload 4
      //   635: astore 5
      //   637: iload_2
      //   638: aload 4
      //   640: invokeinterface 59 1 0
      //   645: if_icmpge +163 -> 808
      //   648: aload 4
      //   650: astore 5
      //   652: new 172	midas/x/zc
      //   655: dup
      //   656: aload 4
      //   658: aload 4
      //   660: ldc 174
      //   662: invokeinterface 85 2 0
      //   667: invokeinterface 89 2 0
      //   672: invokespecial 175	midas/x/zc:<init>	(Ljava/lang/String;)V
      //   675: astore 6
      //   677: aload 4
      //   679: astore 5
      //   681: aload 6
      //   683: aload 4
      //   685: aload 4
      //   687: ldc 177
      //   689: invokeinterface 85 2 0
      //   694: invokeinterface 89 2 0
      //   699: invokevirtual 179	midas/x/zc:a	(Ljava/lang/String;)V
      //   702: aload 4
      //   704: astore 5
      //   706: aload 4
      //   708: aload 4
      //   710: ldc 181
      //   712: invokeinterface 85 2 0
      //   717: invokeinterface 185 2 0
      //   722: istore_3
      //   723: aload 4
      //   725: astore 5
      //   727: aload 6
      //   729: aload 4
      //   731: aload 4
      //   733: ldc 187
      //   735: invokeinterface 85 2 0
      //   740: invokeinterface 89 2 0
      //   745: iload_3
      //   746: invokevirtual 190	midas/x/zc:a	(Ljava/lang/String;I)V
      //   749: aload 4
      //   751: astore 5
      //   753: aload 6
      //   755: aload 4
      //   757: aload 4
      //   759: ldc 192
      //   761: invokeinterface 85 2 0
      //   766: invokeinterface 185 2 0
      //   771: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   774: putfield 201	midas/x/zc:e	Ljava/lang/Integer;
      //   777: aload 4
      //   779: astore 5
      //   781: aload 10
      //   783: aload 6
      //   785: invokevirtual 122	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   788: pop
      //   789: aload 4
      //   791: astore 5
      //   793: aload 4
      //   795: invokeinterface 125 1 0
      //   800: pop
      //   801: iload_2
      //   802: iconst_1
      //   803: iadd
      //   804: istore_2
      //   805: goto -172 -> 633
      //   808: aload 4
      //   810: ifnull +98 -> 908
      //   813: goto +88 -> 901
      //   816: astore 6
      //   818: goto +15 -> 833
      //   821: astore_1
      //   822: aconst_null
      //   823: astore 5
      //   825: goto +98 -> 923
      //   828: astore 6
      //   830: aconst_null
      //   831: astore 4
      //   833: aload 4
      //   835: astore 5
      //   837: new 41	java/lang/StringBuilder
      //   840: dup
      //   841: invokespecial 42	java/lang/StringBuilder:<init>	()V
      //   844: astore 11
      //   846: aload 4
      //   848: astore 5
      //   850: aload 11
      //   852: ldc 203
      //   854: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   857: pop
      //   858: aload 4
      //   860: astore 5
      //   862: aload 11
      //   864: aload 6
      //   866: invokevirtual 128	java/lang/Exception:toString	()Ljava/lang/String;
      //   869: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   872: pop
      //   873: aload 4
      //   875: astore 5
      //   877: ldc 130
      //   879: aload 11
      //   881: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   884: invokestatic 133	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   887: aload 4
      //   889: astore 5
      //   891: aload 6
      //   893: invokevirtual 136	java/lang/Exception:printStackTrace	()V
      //   896: aload 4
      //   898: ifnull +10 -> 908
      //   901: aload 4
      //   903: invokeinterface 139 1 0
      //   908: aload 9
      //   910: getfield 206	midas/x/ad:e	Ljava/util/concurrent/CopyOnWriteArrayList;
      //   913: aload 10
      //   915: invokevirtual 212	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
      //   918: pop
      //   919: goto -467 -> 452
      //   922: astore_1
      //   923: aload 5
      //   925: ifnull +10 -> 935
      //   928: aload 5
      //   930: invokeinterface 139 1 0
      //   935: aload_1
      //   936: athrow
      //   937: aload 7
      //   939: areturn
      //   940: astore_1
      //   941: aload 5
      //   943: ifnull +10 -> 953
      //   946: aload 5
      //   948: invokeinterface 139 1 0
      //   953: goto +5 -> 958
      //   956: aload_1
      //   957: athrow
      //   958: goto -2 -> 956
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	961	0	this	f
      //   0	961	1	paramArrayOfObject	Object[]
      //   147	658	2	i	int
      //   722	24	3	j	int
      //   33	869	4	localObject1	Object
      //   37	910	5	localObject2	Object
      //   18	265	6	localObject3	Object
      //   315	1	6	localException1	Exception
      //   327	64	6	localException2	Exception
      //   528	256	6	localObject4	Object
      //   816	1	6	localException3	Exception
      //   828	64	6	localException4	Exception
      //   7	931	7	localArrayList1	java.util.ArrayList
      //   46	417	8	localObject5	Object
      //   472	437	9	localad	ad
      //   481	433	10	localArrayList2	java.util.ArrayList
      //   844	36	11	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   39	48	315	java/lang/Exception
      //   52	60	315	java/lang/Exception
      //   64	72	315	java/lang/Exception
      //   76	84	315	java/lang/Exception
      //   88	101	315	java/lang/Exception
      //   105	115	315	java/lang/Exception
      //   124	134	315	java/lang/Exception
      //   138	146	315	java/lang/Exception
      //   152	163	315	java/lang/Exception
      //   167	192	315	java/lang/Exception
      //   196	220	315	java/lang/Exception
      //   224	248	315	java/lang/Exception
      //   252	276	315	java/lang/Exception
      //   280	288	315	java/lang/Exception
      //   292	300	315	java/lang/Exception
      //   9	35	320	finally
      //   9	35	327	java/lang/Exception
      //   521	530	816	java/lang/Exception
      //   534	542	816	java/lang/Exception
      //   546	557	816	java/lang/Exception
      //   561	569	816	java/lang/Exception
      //   573	586	816	java/lang/Exception
      //   590	600	816	java/lang/Exception
      //   609	619	816	java/lang/Exception
      //   623	631	816	java/lang/Exception
      //   637	648	816	java/lang/Exception
      //   652	677	816	java/lang/Exception
      //   681	702	816	java/lang/Exception
      //   706	723	816	java/lang/Exception
      //   727	749	816	java/lang/Exception
      //   753	777	816	java/lang/Exception
      //   781	789	816	java/lang/Exception
      //   793	801	816	java/lang/Exception
      //   483	517	821	finally
      //   483	517	828	java/lang/Exception
      //   521	530	922	finally
      //   534	542	922	finally
      //   546	557	922	finally
      //   561	569	922	finally
      //   573	586	922	finally
      //   590	600	922	finally
      //   609	619	922	finally
      //   623	631	922	finally
      //   637	648	922	finally
      //   652	677	922	finally
      //   681	702	922	finally
      //   706	723	922	finally
      //   727	749	922	finally
      //   753	777	922	finally
      //   781	789	922	finally
      //   793	801	922	finally
      //   837	846	922	finally
      //   850	858	922	finally
      //   862	873	922	finally
      //   877	887	922	finally
      //   891	896	922	finally
      //   39	48	940	finally
      //   52	60	940	finally
      //   64	72	940	finally
      //   76	84	940	finally
      //   88	101	940	finally
      //   105	115	940	finally
      //   124	134	940	finally
      //   138	146	940	finally
      //   152	163	940	finally
      //   167	192	940	finally
      //   196	220	940	finally
      //   224	248	940	finally
      //   252	276	940	finally
      //   280	288	940	finally
      //   292	300	940	finally
      //   336	345	940	finally
      //   349	357	940	finally
      //   361	372	940	finally
      //   376	386	940	finally
      //   390	395	940	finally
    }
  }
  
  public class g
    extends SQLiteOpenHelper
  {
    public g(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
    {
      super(paramString, paramCursorFactory, paramInt);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      ed.b("IPDatabaseImpl", "onCreate");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MidasNetTableVer2 ( identifier VARCHAR(128), updatetime INTEGER, accesstime INTEGER, measuretime INTEGER )");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MidasIPTableVer2 ( ip VARCHAR(64), measure VARCHAR(128), history VARCHAR(1024), historyIndex INTEGER, category INTEGER, netIdentifier VARCHAR(128))");
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      ed.b("IPDatabaseImpl", "onUpgrade");
      if (paramInt1 < 2)
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MidasNetTableVer2 ( identifier VARCHAR(128), updatetime INTEGER, accesstime INTEGER, measuretime INTEGER )");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MidasIPTableVer2 ( ip VARCHAR(64), measure VARCHAR(128), history VARCHAR(1024), historyIndex INTEGER, category INTEGER, netIdentifier VARCHAR(128))");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.md
 * JD-Core Version:    0.7.0.1
 */