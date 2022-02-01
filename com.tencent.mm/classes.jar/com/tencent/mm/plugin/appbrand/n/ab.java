package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.FileSystem.b;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic;", "", "()V", "IGNORE_DIR_NAME_LIST", "", "", "[Ljava/lang/String;", "TAG", "deleteLibCacheByVersion", "", "targetVersion", "", "doCleanup", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "rootDir", "LIB_SCRIPT_HANDLER", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
{
  public static final ab sTp;
  private static final String[] sTq;
  
  static
  {
    AppMethodBeat.i(319155);
    sTp = new ab();
    sTq = new String[] { "page_scripts" };
    AppMethodBeat.o(319155);
  }
  
  public static final void BQ(int paramInt)
  {
    AppMethodBeat.i(319118);
    long l = Util.currentTicks();
    c localc = new c(paramInt);
    Object localObject1 = y.eB(ad.cpf(), false);
    if (localObject1 != null)
    {
      Iterator localIterator = ((Iterable)localObject1).iterator();
      int i = 0;
      int j = 0;
      for (;;)
      {
        m = i;
        k = j;
        if (!localIterator.hasNext()) {
          break;
        }
        j localj = (j)localIterator.next();
        if (localj.agxh)
        {
          localObject1 = sTq;
          Object localObject2 = localj.name;
          s.s(localObject2, "dir.name");
          if (!k.contains((Object[])localObject1, localObject2))
          {
            k = j + 1;
            localObject1 = null;
            localObject2 = bc.qGk;
            s.s(localObject2, "LIB_FILES");
            int n = localObject2.length;
            j = 0;
            while (j < n)
            {
              Object localObject3 = localObject2[j];
              m = j + 1;
              if (!s.p(localObject3, localj.name))
              {
                s.s(localObject3, "name");
                String str = localj.name;
                s.s(str, "dir.name");
                j = m;
                if (!n.rs(localObject3, str)) {}
              }
              else
              {
                localObject1 = (m)localc;
                j = m;
              }
            }
            j = k;
            if (localObject1 != null)
            {
              localObject2 = ad.cpf();
              s.s(localObject2, "retrieve()");
              s.s(localj, "dir");
              j = ((Number)((m)localObject1).invoke(localObject2, localj)).intValue();
              localObject1 = ad.cpf();
              s.s(localObject1, "retrieve()");
              if (a(localj, (String)localObject1))
              {
                Log.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "delete relPath %s", new Object[] { localj.acpB });
                localj.NP(true);
              }
              i = j + i;
              j = k;
            }
          }
        }
      }
    }
    int m = 0;
    int k = 0;
    Log.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "deleteLibCacheByVersion(" + paramInt + ") cost:" + (Util.currentTicks() - l) + "ms, dirVisitedCount:" + k + ", fileDeletedCount:" + m);
    AppMethodBeat.o(319118);
  }
  
  private static boolean a(j paramj, String paramString)
  {
    AppMethodBeat.i(319138);
    if (paramj.agxh)
    {
      paramj = y.eB(paramString + '/' + paramj.name, false);
      if (paramj == null)
      {
        paramj = null;
        paramj = (Collection)paramj;
        if ((paramj != null) && (!paramj.isEmpty())) {
          break label88;
        }
      }
      label88:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label93;
        }
        AppMethodBeat.o(319138);
        return true;
        paramj = p.p(paramj);
        break;
      }
    }
    label93:
    AppMethodBeat.o(319138);
    return false;
  }
  
  private static SQLiteStatement b(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(319147);
    try
    {
      paramh = paramh.jef().compileStatement(paramString);
      AppMethodBeat.o(319147);
      return paramh;
    }
    catch (SQLiteException paramh)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
    catch (IllegalStateException paramh)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
  }
  
  /* Error */
  public static final void czn()
  {
    // Byte code:
    //   0: ldc_w 262
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 268	com/tencent/mm/plugin/appbrand/app/n:ceY	()Lcom/tencent/mm/platformtools/o$a;
    //   9: astore 11
    //   11: aload 11
    //   13: ifnonnull +10 -> 23
    //   16: ldc_w 262
    //   19: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: return
    //   23: aload 11
    //   25: checkcast 235	com/tencent/mm/storagebase/h
    //   28: astore 13
    //   30: new 9	com/tencent/mm/plugin/appbrand/n/ab$b
    //   33: dup
    //   34: aload 13
    //   36: invokespecial 271	com/tencent/mm/plugin/appbrand/n/ab$b:<init>	(Lcom/tencent/mm/storagebase/h;)V
    //   39: astore 14
    //   41: new 6	com/tencent/mm/plugin/appbrand/n/ab$a
    //   44: dup
    //   45: aload 13
    //   47: invokespecial 272	com/tencent/mm/plugin/appbrand/n/ab$a:<init>	(Lcom/tencent/mm/storagebase/h;)V
    //   50: astore 15
    //   52: invokestatic 76	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   55: lstore 9
    //   57: iconst_0
    //   58: istore 6
    //   60: iconst_0
    //   61: istore_2
    //   62: iconst_0
    //   63: istore_1
    //   64: invokestatic 84	com/tencent/mm/plugin/appbrand/n/ad:cpf	()Ljava/lang/String;
    //   67: iconst_0
    //   68: invokestatic 90	com/tencent/mm/vfs/y:eB	(Ljava/lang/String;Z)Ljava/lang/Iterable;
    //   71: astore 11
    //   73: aload 11
    //   75: ifnull +817 -> 892
    //   78: aload 11
    //   80: invokeinterface 96 1 0
    //   85: astore 16
    //   87: iconst_0
    //   88: istore_0
    //   89: iload_0
    //   90: istore 4
    //   92: iload_1
    //   93: istore 6
    //   95: iload_0
    //   96: istore_3
    //   97: iload_1
    //   98: istore_2
    //   99: aload 16
    //   101: invokeinterface 102 1 0
    //   106: ifeq +663 -> 769
    //   109: iload_0
    //   110: istore 4
    //   112: iload_1
    //   113: istore 6
    //   115: iload_0
    //   116: istore_3
    //   117: iload_1
    //   118: istore_2
    //   119: aload 16
    //   121: invokeinterface 106 1 0
    //   126: checkcast 108	com/tencent/mm/vfs/j
    //   129: astore 17
    //   131: iload_0
    //   132: istore 4
    //   134: iload_1
    //   135: istore 6
    //   137: iload_0
    //   138: istore_3
    //   139: iload_1
    //   140: istore_2
    //   141: aload 17
    //   143: getfield 112	com/tencent/mm/vfs/j:agxh	Z
    //   146: ifeq -57 -> 89
    //   149: iload_0
    //   150: istore 4
    //   152: iload_1
    //   153: istore 6
    //   155: iload_0
    //   156: istore_3
    //   157: iload_1
    //   158: istore_2
    //   159: getstatic 63	com/tencent/mm/plugin/appbrand/n/ab:sTq	[Ljava/lang/String;
    //   162: astore 11
    //   164: iload_0
    //   165: istore 4
    //   167: iload_1
    //   168: istore 6
    //   170: iload_0
    //   171: istore_3
    //   172: iload_1
    //   173: istore_2
    //   174: aload 17
    //   176: getfield 116	com/tencent/mm/vfs/j:name	Ljava/lang/String;
    //   179: astore 12
    //   181: iload_0
    //   182: istore 4
    //   184: iload_1
    //   185: istore 6
    //   187: iload_0
    //   188: istore_3
    //   189: iload_1
    //   190: istore_2
    //   191: aload 12
    //   193: ldc 118
    //   195: invokestatic 124	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   198: iload_0
    //   199: istore 4
    //   201: iload_1
    //   202: istore 6
    //   204: iload_0
    //   205: istore_3
    //   206: iload_1
    //   207: istore_2
    //   208: aload 11
    //   210: aload 12
    //   212: invokestatic 130	kotlin/a/k:contains	([Ljava/lang/Object;Ljava/lang/Object;)Z
    //   215: ifne -126 -> 89
    //   218: iload_1
    //   219: iconst_1
    //   220: iadd
    //   221: istore 5
    //   223: aconst_null
    //   224: astore 11
    //   226: iload_0
    //   227: istore 4
    //   229: iload 5
    //   231: istore 6
    //   233: iload_0
    //   234: istore_3
    //   235: iload 5
    //   237: istore_2
    //   238: getstatic 135	com/tencent/mm/plugin/appbrand/appcache/bc:qGk	[Ljava/lang/String;
    //   241: astore 12
    //   243: iload_0
    //   244: istore 4
    //   246: iload 5
    //   248: istore 6
    //   250: iload_0
    //   251: istore_3
    //   252: iload 5
    //   254: istore_2
    //   255: aload 12
    //   257: ldc 137
    //   259: invokestatic 124	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   262: iconst_0
    //   263: istore_1
    //   264: iload_0
    //   265: istore 4
    //   267: iload 5
    //   269: istore 6
    //   271: iload_0
    //   272: istore_3
    //   273: iload 5
    //   275: istore_2
    //   276: aload 12
    //   278: arraylength
    //   279: istore 8
    //   281: iload_1
    //   282: iload 8
    //   284: if_icmpge +146 -> 430
    //   287: aload 12
    //   289: iload_1
    //   290: aaload
    //   291: astore 18
    //   293: iload_1
    //   294: iconst_1
    //   295: iadd
    //   296: istore 7
    //   298: iload_0
    //   299: istore 4
    //   301: iload 5
    //   303: istore 6
    //   305: iload_0
    //   306: istore_3
    //   307: iload 5
    //   309: istore_2
    //   310: aload 18
    //   312: aload 17
    //   314: getfield 116	com/tencent/mm/vfs/j:name	Ljava/lang/String;
    //   317: invokestatic 141	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   320: ifne +85 -> 405
    //   323: iload_0
    //   324: istore 4
    //   326: iload 5
    //   328: istore 6
    //   330: iload_0
    //   331: istore_3
    //   332: iload 5
    //   334: istore_2
    //   335: aload 18
    //   337: ldc 142
    //   339: invokestatic 124	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   342: iload_0
    //   343: istore 4
    //   345: iload 5
    //   347: istore 6
    //   349: iload_0
    //   350: istore_3
    //   351: iload 5
    //   353: istore_2
    //   354: aload 17
    //   356: getfield 116	com/tencent/mm/vfs/j:name	Ljava/lang/String;
    //   359: astore 19
    //   361: iload_0
    //   362: istore 4
    //   364: iload 5
    //   366: istore 6
    //   368: iload_0
    //   369: istore_3
    //   370: iload 5
    //   372: istore_2
    //   373: aload 19
    //   375: ldc 118
    //   377: invokestatic 124	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   380: iload 7
    //   382: istore_1
    //   383: iload_0
    //   384: istore 4
    //   386: iload 5
    //   388: istore 6
    //   390: iload_0
    //   391: istore_3
    //   392: iload 5
    //   394: istore_2
    //   395: aload 18
    //   397: aload 19
    //   399: invokestatic 148	kotlin/n/n:rs	(Ljava/lang/String;Ljava/lang/String;)Z
    //   402: ifeq -121 -> 281
    //   405: iload_0
    //   406: istore 4
    //   408: iload 5
    //   410: istore 6
    //   412: iload_0
    //   413: istore_3
    //   414: iload 5
    //   416: istore_2
    //   417: aload 15
    //   419: checkcast 150	kotlin/g/a/m
    //   422: astore 11
    //   424: iload 7
    //   426: istore_1
    //   427: goto -146 -> 281
    //   430: aload 11
    //   432: astore 12
    //   434: aload 11
    //   436: ifnonnull +22 -> 458
    //   439: iload_0
    //   440: istore 4
    //   442: iload 5
    //   444: istore 6
    //   446: iload_0
    //   447: istore_3
    //   448: iload 5
    //   450: istore_2
    //   451: aload 14
    //   453: checkcast 150	kotlin/g/a/m
    //   456: astore 12
    //   458: iload_0
    //   459: istore 4
    //   461: iload 5
    //   463: istore 6
    //   465: iload_0
    //   466: istore_3
    //   467: iload 5
    //   469: istore_2
    //   470: invokestatic 84	com/tencent/mm/plugin/appbrand/n/ad:cpf	()Ljava/lang/String;
    //   473: astore 11
    //   475: iload_0
    //   476: istore 4
    //   478: iload 5
    //   480: istore 6
    //   482: iload_0
    //   483: istore_3
    //   484: iload 5
    //   486: istore_2
    //   487: aload 11
    //   489: ldc 152
    //   491: invokestatic 124	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   494: iload_0
    //   495: istore 4
    //   497: iload 5
    //   499: istore 6
    //   501: iload_0
    //   502: istore_3
    //   503: iload 5
    //   505: istore_2
    //   506: aload 17
    //   508: ldc 154
    //   510: invokestatic 124	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   513: iload_0
    //   514: istore 4
    //   516: iload 5
    //   518: istore 6
    //   520: iload_0
    //   521: istore_3
    //   522: iload 5
    //   524: istore_2
    //   525: iload_0
    //   526: aload 12
    //   528: aload 11
    //   530: aload 17
    //   532: invokeinterface 158 3 0
    //   537: checkcast 160	java/lang/Number
    //   540: invokevirtual 164	java/lang/Number:intValue	()I
    //   543: iadd
    //   544: istore 7
    //   546: iload 7
    //   548: istore 4
    //   550: iload 5
    //   552: istore 6
    //   554: iload 7
    //   556: istore_3
    //   557: iload 5
    //   559: istore_2
    //   560: invokestatic 84	com/tencent/mm/plugin/appbrand/n/ad:cpf	()Ljava/lang/String;
    //   563: astore 11
    //   565: iload 7
    //   567: istore 4
    //   569: iload 5
    //   571: istore 6
    //   573: iload 7
    //   575: istore_3
    //   576: iload 5
    //   578: istore_2
    //   579: aload 11
    //   581: ldc 152
    //   583: invokestatic 124	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   586: iload 7
    //   588: istore_0
    //   589: iload 5
    //   591: istore_1
    //   592: iload 7
    //   594: istore 4
    //   596: iload 5
    //   598: istore 6
    //   600: iload 7
    //   602: istore_3
    //   603: iload 5
    //   605: istore_2
    //   606: aload 17
    //   608: aload 11
    //   610: invokestatic 167	com/tencent/mm/plugin/appbrand/n/ab:a	(Lcom/tencent/mm/vfs/j;Ljava/lang/String;)Z
    //   613: ifeq -524 -> 89
    //   616: iload 7
    //   618: istore 4
    //   620: iload 5
    //   622: istore 6
    //   624: iload 7
    //   626: istore_3
    //   627: iload 5
    //   629: istore_2
    //   630: ldc 169
    //   632: ldc 171
    //   634: iconst_1
    //   635: anewarray 4	java/lang/Object
    //   638: dup
    //   639: iconst_0
    //   640: aload 17
    //   642: getfield 174	com/tencent/mm/vfs/j:acpB	Ljava/lang/String;
    //   645: aastore
    //   646: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   649: iload 7
    //   651: istore 4
    //   653: iload 5
    //   655: istore 6
    //   657: iload 7
    //   659: istore_3
    //   660: iload 5
    //   662: istore_2
    //   663: aload 17
    //   665: iconst_1
    //   666: invokevirtual 183	com/tencent/mm/vfs/j:NP	(Z)Z
    //   669: pop
    //   670: iload 7
    //   672: istore_0
    //   673: iload 5
    //   675: istore_1
    //   676: goto -587 -> 89
    //   679: astore 11
    //   681: iload 4
    //   683: istore_3
    //   684: iload 6
    //   686: istore_2
    //   687: ldc 169
    //   689: aload 11
    //   691: checkcast 274	java/lang/Throwable
    //   694: ldc_w 276
    //   697: aload 13
    //   699: invokevirtual 279	com/tencent/mm/storagebase/h:isClose	()Z
    //   702: invokestatic 285	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   705: invokestatic 289	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   708: iconst_0
    //   709: anewarray 4	java/lang/Object
    //   712: invokestatic 293	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   715: ldc 169
    //   717: new 185	java/lang/StringBuilder
    //   720: dup
    //   721: ldc_w 295
    //   724: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   727: invokestatic 76	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   730: lload 9
    //   732: lsub
    //   733: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   736: ldc 204
    //   738: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: iload 6
    //   743: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   746: ldc 206
    //   748: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: iload 4
    //   753: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: ldc_w 262
    //   765: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   768: return
    //   769: ldc 169
    //   771: new 185	java/lang/StringBuilder
    //   774: dup
    //   775: ldc_w 295
    //   778: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   781: invokestatic 76	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   784: lload 9
    //   786: lsub
    //   787: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   790: ldc 204
    //   792: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: iload_1
    //   796: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   799: ldc 206
    //   801: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: iload_0
    //   805: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: ldc_w 262
    //   817: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   820: return
    //   821: astore 11
    //   823: iconst_0
    //   824: istore_3
    //   825: ldc 169
    //   827: new 185	java/lang/StringBuilder
    //   830: dup
    //   831: ldc_w 295
    //   834: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   837: invokestatic 76	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   840: lload 9
    //   842: lsub
    //   843: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   846: ldc 204
    //   848: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: iload_2
    //   852: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   855: ldc 206
    //   857: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: iload_3
    //   861: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   864: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: ldc_w 262
    //   873: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   876: aload 11
    //   878: athrow
    //   879: astore 11
    //   881: goto -56 -> 825
    //   884: astore 11
    //   886: iconst_0
    //   887: istore 4
    //   889: goto -208 -> 681
    //   892: iconst_0
    //   893: istore_0
    //   894: iconst_0
    //   895: istore_1
    //   896: goto -127 -> 769
    // Local variable table:
    //   start	length	slot	name	signature
    //   88	806	0	i	int
    //   63	833	1	j	int
    //   61	791	2	k	int
    //   96	765	3	m	int
    //   90	798	4	n	int
    //   221	453	5	i1	int
    //   58	684	6	i2	int
    //   296	375	7	i3	int
    //   279	6	8	i4	int
    //   55	786	9	l	long
    //   9	600	11	localObject1	Object
    //   679	11	11	localException1	java.lang.Exception
    //   821	56	11	localObject2	Object
    //   879	1	11	localObject3	Object
    //   884	1	11	localException2	java.lang.Exception
    //   179	348	12	localObject4	Object
    //   28	670	13	localh	h
    //   39	413	14	localb	b
    //   50	368	15	locala	a
    //   85	35	16	localIterator	Iterator
    //   129	535	17	localj	j
    //   291	105	18	localObject5	Object
    //   359	39	19	str	String
    // Exception table:
    //   from	to	target	type
    //   99	109	679	java/lang/Exception
    //   119	131	679	java/lang/Exception
    //   141	149	679	java/lang/Exception
    //   159	164	679	java/lang/Exception
    //   174	181	679	java/lang/Exception
    //   191	198	679	java/lang/Exception
    //   208	218	679	java/lang/Exception
    //   238	243	679	java/lang/Exception
    //   255	262	679	java/lang/Exception
    //   276	281	679	java/lang/Exception
    //   310	323	679	java/lang/Exception
    //   335	342	679	java/lang/Exception
    //   354	361	679	java/lang/Exception
    //   373	380	679	java/lang/Exception
    //   395	405	679	java/lang/Exception
    //   417	424	679	java/lang/Exception
    //   451	458	679	java/lang/Exception
    //   470	475	679	java/lang/Exception
    //   487	494	679	java/lang/Exception
    //   506	513	679	java/lang/Exception
    //   525	546	679	java/lang/Exception
    //   560	565	679	java/lang/Exception
    //   579	586	679	java/lang/Exception
    //   606	616	679	java/lang/Exception
    //   630	649	679	java/lang/Exception
    //   663	670	679	java/lang/Exception
    //   64	73	821	finally
    //   78	87	821	finally
    //   99	109	879	finally
    //   119	131	879	finally
    //   141	149	879	finally
    //   159	164	879	finally
    //   174	181	879	finally
    //   191	198	879	finally
    //   208	218	879	finally
    //   238	243	879	finally
    //   255	262	879	finally
    //   276	281	879	finally
    //   310	323	879	finally
    //   335	342	879	finally
    //   354	361	879	finally
    //   373	380	879	finally
    //   395	405	879	finally
    //   417	424	879	finally
    //   451	458	879	finally
    //   470	475	879	finally
    //   487	494	879	finally
    //   506	513	879	finally
    //   525	546	879	finally
    //   560	565	879	finally
    //   579	586	879	finally
    //   606	616	879	finally
    //   630	649	879	finally
    //   663	670	879	finally
    //   687	715	879	finally
    //   64	73	884	java/lang/Exception
    //   78	87	884	java/lang/Exception
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$LIB_SCRIPT_HANDLER;", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "invoke", "rootDir", "dir", "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements m<String, j, Integer>
  {
    private final SQLiteStatement sTr;
    
    public a(h paramh)
    {
      AppMethodBeat.i(319106);
      ab localab = ab.sTp;
      this.sTr = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId =? AND version=? ;");
      AppMethodBeat.o(319106);
    }
    
    private Integer a(String paramString, j paramj)
    {
      AppMethodBeat.i(319112);
      s.u(paramString, "rootDir");
      s.u(paramj, "dir");
      if (this.sTr == null)
      {
        AppMethodBeat.o(319112);
        return Integer.valueOf(0);
      }
      paramString = y.eB(paramString + '/' + paramj.name, false);
      int i;
      int j;
      if (paramString != null)
      {
        paramString = paramString.iterator();
        i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label236;
        }
        paramj = (j)paramString.next();
      }
      label236:
      label247:
      for (;;)
      {
        try
        {
          String str = paramj.name;
          s.s(str, "file.name");
          str = str.substring(1);
          s.s(str, "(this as java.lang.String).substring(startIndex)");
          j = Integer.parseInt(str, kotlin.n.a.aMy(10));
          if ((j == -1) || (j == 0) || (j == 999) || (j == bc.VERSION)) {
            break label247;
          }
          this.sTr.bindString(1, "@LibraryAppId");
          this.sTr.bindLong(2, j);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          try
          {
            l = this.sTr.simpleQueryForLong();
            if (l > 0L) {
              break label247;
            }
            paramj.NP(true);
            i += 1;
            break;
            localNumberFormatException = localNumberFormatException;
            j = -1;
          }
          catch (SQLiteException localSQLiteException)
          {
            long l = 0L;
            continue;
          }
        }
        j = 0;
        AppMethodBeat.o(319112);
        return Integer.valueOf(j);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "rootDir", "dir", "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements m<String, j, Integer>
  {
    private final SQLiteStatement sTr;
    private final SQLiteStatement sTs;
    
    public b(h paramh)
    {
      AppMethodBeat.i(319104);
      ab localab = ab.sTp;
      this.sTr = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      localab = ab.sTp;
      this.sTs = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
      AppMethodBeat.o(319104);
    }
    
    private Integer a(String paramString, j paramj)
    {
      AppMethodBeat.i(319115);
      s.u(paramString, "rootDir");
      s.u(paramj, "dir");
      if (this.sTr == null)
      {
        AppMethodBeat.o(319115);
        return Integer.valueOf(0);
      }
      if (this.sTs == null)
      {
        AppMethodBeat.o(319115);
        return Integer.valueOf(0);
      }
      Object localObject1 = paramj.name;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label266;
        }
        localObject1 = null;
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label316;
        }
      }
      int j;
      label266:
      label281:
      label303:
      label316:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label321;
        }
        AppMethodBeat.o(319115);
        return Integer.valueOf(0);
        int n = ((String)localObject1).length();
        if (n == 0)
        {
          localObject1 = org.apache.commons.c.a.EMPTY_STRING_ARRAY;
          break;
        }
        localObject2 = new ArrayList();
        int k = 0;
        j = 0;
        i = 0;
        while (i < n) {
          if (((String)localObject1).charAt(i) == '_')
          {
            int m = j;
            if (j != 0)
            {
              ((List)localObject2).add(((String)localObject1).substring(k, i));
              m = 0;
            }
            i += 1;
            k = i;
            j = m;
          }
          else
          {
            j = 1;
            i += 1;
          }
        }
        if (j != 0) {
          ((List)localObject2).add(((String)localObject1).substring(k, i));
        }
        localObject1 = (String[])((List)localObject2).toArray(new String[((List)localObject2).size()]);
        break;
        s.u(localObject1, "$this$lastOrNull");
        if (localObject1.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label303;
          }
        }
        for (localObject1 = null;; localObject1 = localObject1[(localObject1.length - 1)])
        {
          localObject1 = (String)localObject1;
          break;
          i = 0;
          break label281;
        }
      }
      label321:
      paramString = y.eB(paramString + '/' + paramj.name, false);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        i = 0;
        do
        {
          j = i;
          if (!paramString.hasNext()) {
            break;
          }
          paramj = (j)paramString.next();
        } while (paramj.agxh);
        this.sTr.bindString(1, s.X((String)localObject1, "%%"));
        this.sTr.bindString(2, paramj.name);
      }
      label519:
      for (;;)
      {
        try
        {
          l1 = this.sTr.simpleQueryForLong();
          this.sTs.bindString(1, s.X((String)localObject1, "%%"));
          this.sTs.bindString(2, paramj.name);
        }
        catch (SQLiteException localSQLiteException1)
        {
          try
          {
            l2 = this.sTs.simpleQueryForLong();
            if (l1 + l2 > 0L) {
              break label519;
            }
            paramj.NP(true);
            i += 1;
            break;
            localSQLiteException1 = localSQLiteException1;
            long l1 = 0L;
          }
          catch (SQLiteException localSQLiteException2)
          {
            long l2 = 0L;
            continue;
          }
        }
        j = 0;
        AppMethodBeat.o(319115);
        return Integer.valueOf(j);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$deleteLibCacheByVersion$targetHandler$1", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "invoke", "rootDir", "dir", "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements m<String, j, Integer>
  {
    c(int paramInt) {}
    
    private Integer a(String paramString, j paramj)
    {
      AppMethodBeat.i(319110);
      s.u(paramString, "rootDir");
      s.u(paramj, "dir");
      int k;
      int i;
      label57:
      int j;
      if (paramj.agxh)
      {
        paramString = paramj.agxi.bDW(paramj.acpB);
        if (paramString == null) {
          break label152;
        }
        k = this.sTt;
        paramString = paramString.iterator();
        i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label155;
        }
        paramj = (j)paramString.next();
      }
      label152:
      label155:
      label166:
      for (;;)
      {
        try
        {
          String str = paramj.name;
          s.s(str, "file.name");
          str = str.substring(1);
          s.s(str, "(this as java.lang.String).substring(startIndex)");
          j = Integer.parseInt(str, kotlin.n.a.aMy(10));
          if (j != k) {
            break label166;
          }
          paramj.NP(true);
          i += 1;
          break label57;
          paramString = null;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          j = -1;
          continue;
        }
        j = 0;
        AppMethodBeat.o(319110);
        return Integer.valueOf(j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.ab
 * JD-Core Version:    0.7.0.1
 */