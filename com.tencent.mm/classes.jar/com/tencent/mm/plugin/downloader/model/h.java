package com.tencent.mm.plugin.downloader.model;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.downloader.b.b.q;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  /* Error */
  public static String amX(String paramString)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 4
    //   10: new 17	java/net/URL
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 21	java/net/URL:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 25	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   21: checkcast 27	java/net/HttpURLConnection
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +84 -> 110
    //   29: aload_0
    //   30: sipush 1000
    //   33: invokevirtual 30	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   36: aload_0
    //   37: iconst_0
    //   38: invokevirtual 34	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   41: aload_0
    //   42: invokevirtual 38	java/net/HttpURLConnection:getResponseCode	()I
    //   45: istore_1
    //   46: aload_0
    //   47: ldc 40
    //   49: invokevirtual 43	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_2
    //   53: ldc 45
    //   55: ldc 47
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: iload_1
    //   64: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_2
    //   71: aastore
    //   72: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_0
    //   76: ifnull +14 -> 90
    //   79: aload_0
    //   80: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   83: invokevirtual 68	java/io/InputStream:close	()V
    //   86: aload_0
    //   87: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   90: ldc 9
    //   92: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_2
    //   96: areturn
    //   97: astore_3
    //   98: ldc 45
    //   100: aload_3
    //   101: invokevirtual 78	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   104: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -21 -> 86
    //   110: aload_0
    //   111: ifnull +14 -> 125
    //   114: aload_0
    //   115: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   118: invokevirtual 68	java/io/InputStream:close	()V
    //   121: aload_0
    //   122: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   125: ldc 9
    //   127: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: ldc 84
    //   132: areturn
    //   133: astore_2
    //   134: ldc 45
    //   136: aload_2
    //   137: invokevirtual 78	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: goto -22 -> 121
    //   146: astore_3
    //   147: aload 4
    //   149: astore_0
    //   150: aload_0
    //   151: astore_2
    //   152: ldc 45
    //   154: ldc 86
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_3
    //   163: invokevirtual 78	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: aastore
    //   167: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_0
    //   171: ifnull -46 -> 125
    //   174: aload_0
    //   175: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   178: invokevirtual 68	java/io/InputStream:close	()V
    //   181: aload_0
    //   182: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   185: goto -60 -> 125
    //   188: astore_2
    //   189: ldc 45
    //   191: aload_2
    //   192: invokevirtual 78	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   195: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: goto -17 -> 181
    //   201: astore_0
    //   202: aload_2
    //   203: ifnull +14 -> 217
    //   206: aload_2
    //   207: invokevirtual 62	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   210: invokevirtual 68	java/io/InputStream:close	()V
    //   213: aload_2
    //   214: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   217: ldc 9
    //   219: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_0
    //   223: athrow
    //   224: astore_3
    //   225: ldc 45
    //   227: aload_3
    //   228: invokevirtual 78	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: goto -21 -> 213
    //   237: astore_3
    //   238: aload_0
    //   239: astore_2
    //   240: aload_3
    //   241: astore_0
    //   242: goto -40 -> 202
    //   245: astore_3
    //   246: goto -96 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString	String
    //   45	19	1	i	int
    //   6	90	2	str1	String
    //   133	4	2	localException1	java.lang.Exception
    //   151	1	2	str2	String
    //   188	26	2	localException2	java.lang.Exception
    //   239	1	2	str3	String
    //   97	4	3	localException3	java.lang.Exception
    //   146	17	3	localException4	java.lang.Exception
    //   224	4	3	localException5	java.lang.Exception
    //   237	4	3	localObject1	Object
    //   245	1	3	localException6	java.lang.Exception
    //   8	140	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   79	86	97	java/lang/Exception
    //   114	121	133	java/lang/Exception
    //   10	25	146	java/lang/Exception
    //   174	181	188	java/lang/Exception
    //   10	25	201	finally
    //   152	170	201	finally
    //   206	213	224	java/lang/Exception
    //   29	75	237	finally
    //   29	75	245	java/lang/Exception
  }
  
  public static a c(g paramg)
  {
    AppMethodBeat.i(89016);
    a locala = new a();
    locala.field_downloadUrl = paramg.qGJ;
    locala.field_secondaryUrl = paramg.xnK;
    locala.field_fileSize = paramg.mFileSize;
    locala.field_downloadUrlHashCode = paramg.qGJ.hashCode();
    locala.field_fileName = paramg.mFileName;
    locala.field_fileType = paramg.xnM;
    locala.field_md5 = paramg.xnL;
    locala.field_appId = paramg.mAppId;
    locala.field_autoInstall = paramg.xnN;
    locala.field_showNotification = paramg.rCs;
    locala.field_packageName = paramg.mPackageName;
    locala.field_autoDownload = paramg.xnP;
    locala.field_scene = paramg.mScene;
    locala.field_downloadInWifi = paramg.rAz;
    locala.field_fromWeApp = paramg.xnS;
    locala.field_extInfo = paramg.ryZ;
    locala.field_isSecondDownload = paramg.xnT;
    locala.field_fromDownloadApp = paramg.xnU;
    locala.field_reserveInWifi = paramg.rAz;
    locala.field_downloadType = paramg.mDownloadType;
    locala.field_uiarea = paramg.xnY;
    locala.field_noticeId = paramg.xnX;
    locala.field_ssid = paramg.xnW;
    locala.field_startScene = paramg.mScene;
    LinkedList localLinkedList = paramg.xnZ;
    q localq;
    if (!Util.isNullOrNil(localLinkedList))
    {
      localq = new q();
      localq.xlB = localLinkedList;
    }
    try
    {
      locala.field_sectionMd5Byte = localq.toByteArray();
      label241:
      locala.field_rawAppId = paramg.xoa;
      locala.field_notificationTitle = paramg.xod;
      AppMethodBeat.o(89016);
      return locala;
    }
    catch (IOException localIOException)
    {
      break label241;
    }
  }
  
  private static boolean hq(long paramLong)
  {
    AppMethodBeat.i(89019);
    long l = Environment.getExternalStorageDirectory().getFreeSpace();
    Log.d("MicroMsg.FileDownloadUtil", "isSDCardHaveEnoughSpace, freeSpace = %d, needSize = %d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    if (l >= paramLong)
    {
      AppMethodBeat.o(89019);
      return true;
    }
    AppMethodBeat.o(89019);
    return false;
  }
  
  public static boolean li(long paramLong)
  {
    AppMethodBeat.i(89017);
    if (lj(paramLong))
    {
      AppMethodBeat.o(89017);
      return true;
    }
    Object localObject = d.duu();
    if (Util.isNullOrNil((List)localObject))
    {
      AppMethodBeat.o(89017);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala.field_status != 3) && (locala.field_status != 6) && (locala.field_status != 1))
      {
        Log.i("MicroMsg.FileDownloadUtil", "delete appId : %s, path : %s", new Object[] { locala.field_appId, locala.field_filePath });
        d.lb(locala.field_downloadId);
        y.deleteFile(locala.field_filePath);
        ((c)com.tencent.mm.kernel.h.ax(c.class)).Em(locala.field_appId);
        if (hq(paramLong))
        {
          AppMethodBeat.o(89017);
          return true;
        }
      }
    }
    AppMethodBeat.o(89017);
    return false;
  }
  
  public static boolean lj(long paramLong)
  {
    AppMethodBeat.i(89018);
    long l = (1.3F * (float)paramLong);
    Log.d("MicroMsg.FileDownloadUtil", "checkHasEnoughSpace, realSize = %d, needSize = %d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    boolean bool = e.hq(l);
    AppMethodBeat.o(89018);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.h
 * JD-Core Version:    0.7.0.1
 */