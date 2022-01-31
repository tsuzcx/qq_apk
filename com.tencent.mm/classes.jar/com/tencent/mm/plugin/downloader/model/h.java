package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  /* Error */
  public static String JO(String paramString)
  {
    // Byte code:
    //   0: sipush 2450
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore 4
    //   11: new 16	java/net/URL
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 20	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 24	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 26	java/net/HttpURLConnection
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull +85 -> 112
    //   30: aload_0
    //   31: sipush 1000
    //   34: invokevirtual 29	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   37: aload_0
    //   38: iconst_0
    //   39: invokevirtual 33	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   42: aload_0
    //   43: invokevirtual 37	java/net/HttpURLConnection:getResponseCode	()I
    //   46: istore_1
    //   47: aload_0
    //   48: ldc 39
    //   50: invokevirtual 42	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore_2
    //   54: ldc 44
    //   56: ldc 46
    //   58: iconst_2
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: iload_1
    //   65: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload_2
    //   72: aastore
    //   73: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: aload_0
    //   77: ifnull +14 -> 91
    //   80: aload_0
    //   81: invokevirtual 61	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   84: invokevirtual 67	java/io/InputStream:close	()V
    //   87: aload_0
    //   88: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   91: sipush 2450
    //   94: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_2
    //   98: areturn
    //   99: astore_3
    //   100: ldc 44
    //   102: aload_3
    //   103: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: invokestatic 81	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: goto -22 -> 87
    //   112: aload_0
    //   113: ifnull +14 -> 127
    //   116: aload_0
    //   117: invokevirtual 61	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   120: invokevirtual 67	java/io/InputStream:close	()V
    //   123: aload_0
    //   124: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   127: sipush 2450
    //   130: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: ldc 83
    //   135: areturn
    //   136: astore_2
    //   137: ldc 44
    //   139: aload_2
    //   140: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokestatic 81	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: goto -23 -> 123
    //   149: astore_3
    //   150: aload 4
    //   152: astore_0
    //   153: aload_0
    //   154: astore_2
    //   155: ldc 44
    //   157: ldc 85
    //   159: iconst_1
    //   160: anewarray 4	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_3
    //   166: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 87	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_0
    //   174: ifnull -47 -> 127
    //   177: aload_0
    //   178: invokevirtual 61	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   181: invokevirtual 67	java/io/InputStream:close	()V
    //   184: aload_0
    //   185: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   188: goto -61 -> 127
    //   191: astore_2
    //   192: ldc 44
    //   194: aload_2
    //   195: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   198: invokestatic 81	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: goto -17 -> 184
    //   204: astore_0
    //   205: aload_2
    //   206: ifnull +14 -> 220
    //   209: aload_2
    //   210: invokevirtual 61	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   213: invokevirtual 67	java/io/InputStream:close	()V
    //   216: aload_2
    //   217: invokevirtual 70	java/net/HttpURLConnection:disconnect	()V
    //   220: sipush 2450
    //   223: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_0
    //   227: athrow
    //   228: astore_3
    //   229: ldc 44
    //   231: aload_3
    //   232: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   235: invokestatic 81	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -22 -> 216
    //   241: astore_3
    //   242: aload_0
    //   243: astore_2
    //   244: aload_3
    //   245: astore_0
    //   246: goto -41 -> 205
    //   249: astore_3
    //   250: goto -97 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramString	String
    //   46	19	1	i	int
    //   7	91	2	str1	String
    //   136	4	2	localException1	java.lang.Exception
    //   154	1	2	str2	String
    //   191	26	2	localException2	java.lang.Exception
    //   243	1	2	str3	String
    //   99	4	3	localException3	java.lang.Exception
    //   149	17	3	localException4	java.lang.Exception
    //   228	4	3	localException5	java.lang.Exception
    //   241	4	3	localObject1	Object
    //   249	1	3	localException6	java.lang.Exception
    //   9	142	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   80	87	99	java/lang/Exception
    //   116	123	136	java/lang/Exception
    //   11	26	149	java/lang/Exception
    //   177	184	191	java/lang/Exception
    //   11	26	204	finally
    //   155	173	204	finally
    //   209	216	228	java/lang/Exception
    //   30	76	241	finally
    //   30	76	249	java/lang/Exception
  }
  
  public static a c(g paramg)
  {
    AppMethodBeat.i(2451);
    a locala = new a();
    locala.field_downloadUrl = paramg.gWh;
    locala.field_secondaryUrl = paramg.kYC;
    locala.field_fileSize = paramg.mFileSize;
    locala.field_downloadUrlHashCode = paramg.gWh.hashCode();
    locala.field_fileName = paramg.mFileName;
    locala.field_fileType = paramg.kYE;
    locala.field_md5 = paramg.kYD;
    locala.field_appId = paramg.mAppId;
    locala.field_autoInstall = paramg.kYF;
    locala.field_showNotification = paramg.hAU;
    locala.field_packageName = paramg.mPackageName;
    locala.field_autoDownload = paramg.kYH;
    locala.field_scene = paramg.mScene;
    locala.field_downloadInWifi = paramg.hzD;
    locala.field_fromWeApp = paramg.kYK;
    locala.field_extInfo = paramg.hyG;
    locala.field_isSecondDownload = paramg.kYL;
    locala.field_fromDownloadApp = paramg.kYM;
    locala.field_reserveInWifi = paramg.hzD;
    locala.field_downloadType = paramg.mDownloadType;
    locala.field_uiarea = paramg.kYQ;
    locala.field_noticeId = paramg.kYP;
    locala.field_ssid = paramg.kYO;
    locala.field_startScene = paramg.mScene;
    AppMethodBeat.o(2451);
    return locala;
  }
  
  public static boolean iS(long paramLong)
  {
    AppMethodBeat.i(141065);
    Object localObject1 = d.YG();
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject2;
    while (bo.es((List)localObject1))
    {
      AppMethodBeat.o(141065);
      return false;
      localObject2 = String.format("select * from %s where %s<%d order by %s desc", new Object[] { "FileDownloadInfo", "updateTime", Long.valueOf(System.currentTimeMillis() - 604800000L), "updateTime" });
      ab.i("MicroMsg.FileDownloadInfoStorage", "getUpdateTimeBiggerThanTimeInterval, sql = ".concat(String.valueOf(localObject2)));
      Cursor localCursor = ((b)localObject1).rawQuery((String)localObject2, new String[0]);
      localObject2 = new LinkedList();
      localObject1 = localObject2;
      if (localCursor != null)
      {
        while (localCursor.moveToNext())
        {
          localObject1 = new a();
          ((a)localObject1).convertFrom(localCursor);
          ((LinkedList)localObject2).add(localObject1);
        }
        localCursor.close();
        localObject1 = localObject2;
      }
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      if ((((a)localObject2).field_status != 3) && (((a)localObject2).field_status != 6) && (((a)localObject2).field_status != 1))
      {
        ab.i("MicroMsg.FileDownloadUtil", "delete appId : %s, path : %s", new Object[] { ((a)localObject2).field_appId, ((a)localObject2).field_filePath });
        d.iK(((a)localObject2).field_downloadId);
        e.deleteFile(((a)localObject2).field_filePath);
        ((com.tencent.mm.plugin.downloader_app.a.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.downloader_app.a.d.class)).lI(((a)localObject2).field_appId);
        if (f.gc(paramLong))
        {
          AppMethodBeat.o(141065);
          return true;
        }
      }
    }
    AppMethodBeat.o(141065);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.h
 * JD-Core Version:    0.7.0.1
 */