package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.f.a;

public final class f
{
  public static a c(e parame)
  {
    a locala = new a();
    locala.field_downloadUrl = parame.fDR;
    locala.field_secondaryUrl = parame.iPu;
    locala.field_fileSize = parame.mFileSize;
    locala.field_downloadUrlHashCode = parame.fDR.hashCode();
    locala.field_fileName = parame.mFileName;
    locala.field_fileType = parame.iPx;
    locala.field_md5 = parame.iPw;
    locala.field_appId = parame.mAppId;
    locala.field_autoInstall = parame.iPy;
    locala.field_showNotification = parame.ghU;
    locala.field_packageName = parame.mPackageName;
    locala.field_autoDownload = parame.iPA;
    locala.field_scene = parame.fzn;
    locala.field_downloadInWifi = parame.ghq;
    locala.field_fromWeApp = parame.iPD;
    locala.field_extInfo = parame.ghS;
    locala.field_isSecondDownload = parame.iPE;
    locala.field_fromDownloadApp = parame.iPF;
    return locala;
  }
  
  /* Error */
  public static String zS(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: new 136	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 139	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 143	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 145	java/net/HttpURLConnection
    //   19: astore_0
    //   20: aload_0
    //   21: ifnull +59 -> 80
    //   24: aload_0
    //   25: sipush 1000
    //   28: invokevirtual 149	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   31: aload_0
    //   32: iconst_0
    //   33: invokevirtual 153	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   36: aload_0
    //   37: invokevirtual 156	java/net/HttpURLConnection:getResponseCode	()I
    //   40: istore_1
    //   41: aload_0
    //   42: ldc 158
    //   44: invokevirtual 161	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_2
    //   48: ldc 163
    //   50: ldc 165
    //   52: iconst_2
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: iload_1
    //   59: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_2
    //   66: aastore
    //   67: invokestatic 177	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: ifnull +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   78: aload_2
    //   79: areturn
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   88: ldc 182
    //   90: areturn
    //   91: astore_3
    //   92: aload 4
    //   94: astore_0
    //   95: aload_0
    //   96: astore_2
    //   97: ldc 163
    //   99: ldc 184
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_3
    //   108: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: aastore
    //   112: invokestatic 191	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload_0
    //   116: ifnull -28 -> 88
    //   119: aload_0
    //   120: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   123: goto -35 -> 88
    //   126: astore_0
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 180	java/net/HttpURLConnection:disconnect	()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_3
    //   138: aload_0
    //   139: astore_2
    //   140: aload_3
    //   141: astore_0
    //   142: goto -15 -> 127
    //   145: astore_3
    //   146: goto -51 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString	String
    //   40	19	1	i	int
    //   1	139	2	str	String
    //   91	17	3	localException1	java.lang.Exception
    //   137	4	3	localObject1	Object
    //   145	1	3	localException2	java.lang.Exception
    //   3	90	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	20	91	java/lang/Exception
    //   5	20	126	finally
    //   97	115	126	finally
    //   24	70	137	finally
    //   24	70	145	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f
 * JD-Core Version:    0.7.0.1
 */