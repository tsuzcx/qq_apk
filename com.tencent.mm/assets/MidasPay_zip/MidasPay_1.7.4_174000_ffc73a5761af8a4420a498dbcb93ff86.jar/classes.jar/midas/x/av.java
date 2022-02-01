package midas.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class av
{
  private Context a = null;
  private boolean b = false;
  private ArrayList<ap> c = null;
  private ArrayList<ap> d = null;
  private ArrayList<String> e = new ArrayList();
  private ArrayList<String> f = new ArrayList();
  private ar g = null;
  
  public av(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public av(Context paramContext, ar paramar)
  {
    this.a = paramContext;
    this.g = paramar;
  }
  
  private String a(File paramFile, String paramString)
  {
    try
    {
      paramFile = paramFile.listFiles();
      int j = 0;
      int i = 0;
      while (i < paramFile.length)
      {
        String str = paramFile[i].getName();
        if (paramString.equals(str.substring(0, str.length() - 4)))
        {
          str = paramFile[i];
          while (j < this.c.size())
          {
            if ((paramString.equals(((ap)this.c.get(j)).a)) && (new au(this.a).a(str.getAbsolutePath()).compareToIgnoreCase(((ap)this.c.get(j)).i) == 0))
            {
              paramFile = paramFile[i].getName();
              return paramFile;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    catch (Exception paramFile)
    {
      label148:
      break label148;
    }
    return "";
  }
  
  private void a(File paramFile)
  {
    label207:
    label208:
    label213:
    label218:
    label229:
    for (;;)
    {
      int k;
      try
      {
        localArrayList = aq.a().b();
        if (localArrayList == null) {
          break label207;
        }
        File[] arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile == null) || (arrayOfFile.length <= 0)) {
          break label207;
        }
        j = 0;
        i = 0;
        if (j >= arrayOfFile.length) {
          break label207;
        }
        String str2 = arrayOfFile[j].getName();
        k = 0;
        if (k >= localArrayList.size()) {
          break label229;
        }
        if (str2.endsWith(".diff"))
        {
          paramFile = str2.split("\\.");
          i = ((ap)localArrayList.get(k)).k;
          if (paramFile.length <= 1) {
            break label208;
          }
          if (!paramFile[1].equals(String.valueOf(i))) {
            break label218;
          }
          break label213;
        }
        String str1 = ((ap)localArrayList.get(k)).a;
        paramFile = str1;
        if (!str1.endsWith(".apk"))
        {
          paramFile = new StringBuilder();
          paramFile.append(str1);
          paramFile.append(".apk");
          paramFile = paramFile.toString();
        }
        if (!str2.equals(paramFile)) {
          break label218;
        }
      }
      catch (Exception paramFile)
      {
        ArrayList localArrayList;
        int j;
        paramFile.printStackTrace();
      }
      if (i == 0)
      {
        a(localArrayList);
        return;
      }
      j += 1;
      continue;
      return;
      int i = 0;
      continue;
      i = 1;
      continue;
      k += 1;
      i = 0;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateOneByOne path name = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" version = ");
    ((StringBuilder)localObject).append(paramInt);
    APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
    for (;;)
    {
      try
      {
        this.b = false;
        int m = b(paramString, 1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateOneByOne dataVersion = ");
        ((StringBuilder)localObject).append(m);
        APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
        int i;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          APLog.d("APMidasDownload", "sdcard exist!");
          j = b(paramString, 2);
          i = j;
          if (!d()) {
            break label543;
          }
          int k = b(paramString, 0);
          i = j;
          j = k;
        }
        else
        {
          APLog.e("APMidasDownload", "sdcard not exist!");
          i = 0;
          break label543;
        }
        if (m == paramInt)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateOneByOne dataVersion == version == ");
          ((StringBuilder)localObject).append(m);
          APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
          if (paramString.endsWith(".apk")) {
            break label549;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(".apk");
          localObject = ((StringBuilder)localObject).toString();
          c((String)localObject, 3);
          if (m > i) {
            c(b(this.a.getApplicationContext().getDir("midasplugins", 0), paramString), 1);
          }
          APLog.i("APMIdasDownload", "resultData=data区的文件版本号是最新的");
          this.b = false;
          return;
        }
        if ((i > m) && (i == paramInt))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateOneByOne sdcardVersion == version == ");
          ((StringBuilder)localObject).append(i);
          APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject).append("/Tencent/MidasPay/");
          if (new File(((StringBuilder)localObject).toString()).exists())
          {
            APLog.d("APMidasDownload", "updateOneByOne sdcard midasPay dir exist!");
            if (paramString.endsWith(".apk")) {
              break label555;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(".apk");
            localObject = ((StringBuilder)localObject).toString();
            c((String)localObject, 2);
          }
          this.e.add(paramString);
          return;
        }
        if ((j == paramInt) && (j > m))
        {
          APLog.i("APMIdasDownload", "resultData=aststse区的文件版本号是最新的");
          d(paramString, 1);
          d(paramString, 2);
          this.f.add(paramString);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resultData=需要开始走网络下载路径");
        ((StringBuilder)localObject).append(paramString);
        APLog.i("APMIdasDownload", ((StringBuilder)localObject).toString());
        this.b = true;
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label543:
      int j = 0;
      continue;
      label549:
      localObject = paramString;
      continue;
      label555:
      localObject = paramString;
    }
  }
  
  private void a(ArrayList<ap> paramArrayList)
  {
    new au().f();
    ao localao = new ao(this.a);
    int i = 0;
    while (i < paramArrayList.size())
    {
      localao.b(((ap)paramArrayList.get(i)).d, 1);
      i += 1;
    }
    localao.b("filetotalsize", 2);
    localao.a();
    APLog.i("APMidasDownLoad", "resultData=断点续传时，temp区的文件是无效的");
  }
  
  /* Error */
  private boolean a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +69 -> 80
    //   14: new 138	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   27: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   30: invokevirtual 266	android/content/Context:getFilesDir	()Ljava/io/File;
    //   33: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: ldc_w 268
    //   44: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   57: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   60: invokevirtual 266	android/content/Context:getFilesDir	()Ljava/io/File;
    //   63: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   66: astore 4
    //   68: new 50	java/io/File
    //   71: dup
    //   72: aload_2
    //   73: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore_3
    //   77: goto +113 -> 190
    //   80: iload_1
    //   81: iconst_2
    //   82: if_icmpne +102 -> 184
    //   85: new 138	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   92: astore_2
    //   93: aload_2
    //   94: invokestatic 218	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   97: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: ldc_w 268
    //   108: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new 50	java/io/File
    //   115: dup
    //   116: aload_2
    //   117: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore_3
    //   124: new 138	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   131: astore_2
    //   132: aload_2
    //   133: invokestatic 218	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   136: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   139: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_2
    //   144: ldc_w 270
    //   147: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: new 50	java/io/File
    //   154: dup
    //   155: aload_2
    //   156: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore_2
    //   163: aload_2
    //   164: invokevirtual 226	java/io/File:exists	()Z
    //   167: ifne +8 -> 175
    //   170: aload_2
    //   171: invokevirtual 273	java/io/File:mkdir	()Z
    //   174: pop
    //   175: aload_2
    //   176: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   179: astore 4
    //   181: goto +9 -> 190
    //   184: ldc 103
    //   186: astore 4
    //   188: aconst_null
    //   189: astore_3
    //   190: aload_3
    //   191: ifnull +12 -> 203
    //   194: aload_3
    //   195: invokevirtual 226	java/io/File:exists	()Z
    //   198: ifne +5 -> 203
    //   201: iconst_0
    //   202: ireturn
    //   203: aload 7
    //   205: astore_2
    //   206: aload 8
    //   208: astore 5
    //   210: new 275	java/util/zip/ZipFile
    //   213: dup
    //   214: aload_3
    //   215: invokespecial 277	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   218: astore 9
    //   220: aload 7
    //   222: astore_2
    //   223: aload 8
    //   225: astore 5
    //   227: aload 9
    //   229: invokevirtual 281	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   232: astore 7
    //   234: aload 6
    //   236: astore_3
    //   237: aload_3
    //   238: astore_2
    //   239: aload_3
    //   240: astore 5
    //   242: aload 7
    //   244: invokeinterface 286 1 0
    //   249: ifeq +447 -> 696
    //   252: aload_3
    //   253: astore_2
    //   254: aload_3
    //   255: astore 5
    //   257: aload 7
    //   259: invokeinterface 290 1 0
    //   264: checkcast 292	java/util/zip/ZipEntry
    //   267: astore 8
    //   269: aload_3
    //   270: astore_2
    //   271: aload_3
    //   272: astore 5
    //   274: aload 8
    //   276: invokevirtual 293	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   279: astore 10
    //   281: aload_3
    //   282: astore_2
    //   283: aload_3
    //   284: astore 5
    //   286: new 138	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   293: astore 6
    //   295: aload_3
    //   296: astore_2
    //   297: aload_3
    //   298: astore 5
    //   300: aload 6
    //   302: ldc_w 295
    //   305: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_3
    //   310: astore_2
    //   311: aload_3
    //   312: astore 5
    //   314: aload 6
    //   316: aload 10
    //   318: iconst_0
    //   319: bipush 8
    //   321: invokevirtual 68	java/lang/String:substring	(II)Ljava/lang/String;
    //   324: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_3
    //   329: astore_2
    //   330: aload_3
    //   331: astore 5
    //   333: aload 6
    //   335: ldc_w 295
    //   338: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_3
    //   343: astore_2
    //   344: aload_3
    //   345: astore 5
    //   347: aload 6
    //   349: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: astore 6
    //   354: aload_3
    //   355: astore_2
    //   356: aload_3
    //   357: astore 5
    //   359: aload 10
    //   361: aload 10
    //   363: ldc_w 295
    //   366: invokevirtual 298	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   369: iconst_1
    //   370: iadd
    //   371: aload 10
    //   373: invokevirtual 64	java/lang/String:length	()I
    //   376: invokevirtual 68	java/lang/String:substring	(II)Ljava/lang/String;
    //   379: astore 11
    //   381: aload_3
    //   382: astore_2
    //   383: aload_3
    //   384: astore 5
    //   386: new 138	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   393: astore 12
    //   395: aload_3
    //   396: astore_2
    //   397: aload_3
    //   398: astore 5
    //   400: aload 12
    //   402: aload 4
    //   404: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_3
    //   409: astore_2
    //   410: aload_3
    //   411: astore 5
    //   413: aload 12
    //   415: aload 6
    //   417: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload_3
    //   422: astore_2
    //   423: aload_3
    //   424: astore 5
    //   426: aload 12
    //   428: aload 11
    //   430: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload_3
    //   435: astore_2
    //   436: aload_3
    //   437: astore 5
    //   439: new 50	java/io/File
    //   442: dup
    //   443: aload 12
    //   445: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   451: astore 6
    //   453: aload_3
    //   454: astore_2
    //   455: aload_3
    //   456: astore 5
    //   458: aload 8
    //   460: invokevirtual 301	java/util/zip/ZipEntry:isDirectory	()Z
    //   463: ifeq +17 -> 480
    //   466: aload_3
    //   467: astore_2
    //   468: aload_3
    //   469: astore 5
    //   471: aload 6
    //   473: invokevirtual 273	java/io/File:mkdir	()Z
    //   476: pop
    //   477: goto -240 -> 237
    //   480: aload_3
    //   481: astore_2
    //   482: aload_3
    //   483: astore 5
    //   485: aload 10
    //   487: ldc_w 295
    //   490: invokevirtual 305	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   493: ifne +105 -> 598
    //   496: aload_3
    //   497: astore_2
    //   498: aload_3
    //   499: astore 5
    //   501: new 138	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   508: astore 6
    //   510: aload_3
    //   511: astore_2
    //   512: aload_3
    //   513: astore 5
    //   515: aload 6
    //   517: aload 4
    //   519: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_3
    //   524: astore_2
    //   525: aload_3
    //   526: astore 5
    //   528: aload 6
    //   530: ldc_w 307
    //   533: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_3
    //   538: astore_2
    //   539: aload_3
    //   540: astore 5
    //   542: new 50	java/io/File
    //   545: dup
    //   546: aload 6
    //   548: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   554: astore 6
    //   556: aload_3
    //   557: astore_2
    //   558: aload_3
    //   559: astore 5
    //   561: aload 6
    //   563: invokevirtual 226	java/io/File:exists	()Z
    //   566: ifne +14 -> 580
    //   569: aload_3
    //   570: astore_2
    //   571: aload_3
    //   572: astore 5
    //   574: aload 6
    //   576: invokevirtual 273	java/io/File:mkdir	()Z
    //   579: pop
    //   580: aload_3
    //   581: astore_2
    //   582: aload_3
    //   583: astore 5
    //   585: new 50	java/io/File
    //   588: dup
    //   589: aload 6
    //   591: aload 10
    //   593: invokespecial 310	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   596: astore 6
    //   598: aload_3
    //   599: astore_2
    //   600: aload_3
    //   601: astore 5
    //   603: new 312	java/io/BufferedOutputStream
    //   606: dup
    //   607: new 314	java/io/FileOutputStream
    //   610: dup
    //   611: aload 6
    //   613: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   616: invokespecial 318	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   619: astore_3
    //   620: sipush 1024
    //   623: newarray byte
    //   625: astore_2
    //   626: aload 9
    //   628: aload 8
    //   630: invokevirtual 322	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   633: astore 5
    //   635: aload 5
    //   637: aload_2
    //   638: invokevirtual 328	java/io/InputStream:read	([B)I
    //   641: istore_1
    //   642: iload_1
    //   643: iconst_m1
    //   644: if_icmpeq +13 -> 657
    //   647: aload_3
    //   648: aload_2
    //   649: iconst_0
    //   650: iload_1
    //   651: invokevirtual 332	java/io/BufferedOutputStream:write	([BII)V
    //   654: goto -19 -> 635
    //   657: aload 5
    //   659: invokevirtual 335	java/io/InputStream:close	()V
    //   662: goto +8 -> 670
    //   665: astore_2
    //   666: aload_2
    //   667: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   670: aload_3
    //   671: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   674: goto -437 -> 237
    //   677: astore 4
    //   679: aload_3
    //   680: astore_2
    //   681: aload 4
    //   683: astore_3
    //   684: goto +60 -> 744
    //   687: astore_2
    //   688: aload_3
    //   689: astore 5
    //   691: aload_2
    //   692: astore_3
    //   693: goto +25 -> 718
    //   696: aload_3
    //   697: ifnull +14 -> 711
    //   700: aload_3
    //   701: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   704: iconst_1
    //   705: ireturn
    //   706: astore_2
    //   707: aload_2
    //   708: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   711: iconst_1
    //   712: ireturn
    //   713: astore_3
    //   714: goto +30 -> 744
    //   717: astore_3
    //   718: aload 5
    //   720: astore_2
    //   721: aload_3
    //   722: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   725: aload 5
    //   727: ifnull +15 -> 742
    //   730: aload 5
    //   732: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   735: iconst_0
    //   736: ireturn
    //   737: astore_2
    //   738: aload_2
    //   739: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   742: iconst_0
    //   743: ireturn
    //   744: aload_2
    //   745: ifnull +15 -> 760
    //   748: aload_2
    //   749: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   752: goto +8 -> 760
    //   755: astore_2
    //   756: aload_2
    //   757: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   760: aload_3
    //   761: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	av
    //   0	762	1	paramInt	int
    //   21	628	2	localObject1	Object
    //   665	2	2	localIOException1	java.io.IOException
    //   680	1	2	localObject2	Object
    //   687	5	2	localException1	Exception
    //   706	2	2	localIOException2	java.io.IOException
    //   720	1	2	localObject3	Object
    //   737	12	2	localIOException3	java.io.IOException
    //   755	2	2	localIOException4	java.io.IOException
    //   76	625	3	localObject4	Object
    //   713	1	3	localObject5	Object
    //   717	44	3	localException2	Exception
    //   66	452	4	str1	String
    //   677	5	4	localObject6	Object
    //   208	523	5	localObject7	Object
    //   7	605	6	localObject8	Object
    //   1	257	7	localEnumeration	java.util.Enumeration
    //   4	625	8	localZipEntry	java.util.zip.ZipEntry
    //   218	409	9	localZipFile	java.util.zip.ZipFile
    //   279	313	10	str2	String
    //   379	50	11	str3	String
    //   393	51	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   657	662	665	java/io/IOException
    //   620	635	677	finally
    //   635	642	677	finally
    //   647	654	677	finally
    //   657	662	677	finally
    //   666	670	677	finally
    //   670	674	677	finally
    //   620	635	687	java/lang/Exception
    //   635	642	687	java/lang/Exception
    //   647	654	687	java/lang/Exception
    //   657	662	687	java/lang/Exception
    //   666	670	687	java/lang/Exception
    //   670	674	687	java/lang/Exception
    //   700	704	706	java/io/IOException
    //   210	220	713	finally
    //   227	234	713	finally
    //   242	252	713	finally
    //   257	269	713	finally
    //   274	281	713	finally
    //   286	295	713	finally
    //   300	309	713	finally
    //   314	328	713	finally
    //   333	342	713	finally
    //   347	354	713	finally
    //   359	381	713	finally
    //   386	395	713	finally
    //   400	408	713	finally
    //   413	421	713	finally
    //   426	434	713	finally
    //   439	453	713	finally
    //   458	466	713	finally
    //   471	477	713	finally
    //   485	496	713	finally
    //   501	510	713	finally
    //   515	523	713	finally
    //   528	537	713	finally
    //   542	556	713	finally
    //   561	569	713	finally
    //   574	580	713	finally
    //   585	598	713	finally
    //   603	620	713	finally
    //   721	725	713	finally
    //   210	220	717	java/lang/Exception
    //   227	234	717	java/lang/Exception
    //   242	252	717	java/lang/Exception
    //   257	269	717	java/lang/Exception
    //   274	281	717	java/lang/Exception
    //   286	295	717	java/lang/Exception
    //   300	309	717	java/lang/Exception
    //   314	328	717	java/lang/Exception
    //   333	342	717	java/lang/Exception
    //   347	354	717	java/lang/Exception
    //   359	381	717	java/lang/Exception
    //   386	395	717	java/lang/Exception
    //   400	408	717	java/lang/Exception
    //   413	421	717	java/lang/Exception
    //   426	434	717	java/lang/Exception
    //   439	453	717	java/lang/Exception
    //   458	466	717	java/lang/Exception
    //   471	477	717	java/lang/Exception
    //   485	496	717	java/lang/Exception
    //   501	510	717	java/lang/Exception
    //   515	523	717	java/lang/Exception
    //   528	537	717	java/lang/Exception
    //   542	556	717	java/lang/Exception
    //   561	569	717	java/lang/Exception
    //   574	580	717	java/lang/Exception
    //   585	598	717	java/lang/Exception
    //   603	620	717	java/lang/Exception
    //   730	735	737	java/io/IOException
    //   748	752	755	java/io/IOException
  }
  
  private int b(String paramString)
  {
    int i = 0;
    int j = 0;
    try
    {
      Object localObject = this.a.getApplicationContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (localObject != null)
      {
        i = ((PackageInfo)localObject).versionCode;
        try
        {
          localObject = String.format("AppVersionCode %d", new Object[] { Integer.valueOf(i) });
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("resultData=");
          localStringBuilder.append(paramString);
          localStringBuilder.append("/");
          localStringBuilder.append((String)localObject);
          APLog.i("APMidasDownLoad", localStringBuilder.toString());
          return i;
        }
        catch (Exception paramString) {}
        paramString.printStackTrace();
      }
    }
    catch (Exception paramString)
    {
      i = j;
    }
    return i;
  }
  
  private int b(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVersion path name = ");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVersion version = ");
    ((StringBuilder)localObject).append(paramInt);
    APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
    localObject = "";
    StringBuilder localStringBuilder;
    if (paramInt == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject).append("/Tencent/MidasPay/");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists())
      {
        APLog.e("APMidasDownload", "sdcard上的Tencent/MidasPay路径不存在");
        return 0;
      }
      APLog.e("APMidasDownload", "sdcard上的Tencent/MidasPay路径存在");
      if ((((File)localObject).listFiles() != null) && (((File)localObject).listFiles().length > 0))
      {
        APLog.e("APMidasDownload", "sdcard上的Tencent/MidasPay dir is not empty!");
        paramString = a((File)localObject, paramString);
        if (paramString.equals("")) {
          return 0;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append(paramString);
        localObject = localStringBuilder.toString();
        paramString = new StringBuilder();
        paramString.append("Got path from sdcard = ");
        paramString.append((String)localObject);
        APLog.d("APMidasDownload", paramString.toString());
      }
      else
      {
        APLog.e("APMidasDownload", "sdcard上的Tencent/MidasPay dir is empty!");
        return 0;
      }
    }
    else if (paramInt == 1)
    {
      localObject = this.a.getApplicationContext().getDir("midasplugins", 0);
      paramString = b((File)localObject, paramString);
      if (paramString.equals("")) {
        return 0;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      localObject = localStringBuilder.toString();
      paramString = new StringBuilder();
      paramString.append("resultData=从data区上取版本号的路径");
      paramString.append((String)localObject);
      APLog.i("APMidasDownLoad", paramString.toString());
    }
    else if (paramInt == 0)
    {
      localObject = a(paramString);
      if (((String)localObject).equals("")) {
        return 0;
      }
      paramString = new StringBuilder();
      paramString.append("resultData=从assets区上取版本号的路径");
      paramString.append((String)localObject);
      APLog.i("APMidasDownLoad", paramString.toString());
    }
    paramString = new StringBuilder();
    paramString.append("About to get version from path = ");
    paramString.append((String)localObject);
    APLog.d("APMidasDownload", paramString.toString());
    try
    {
      paramInt = b((String)localObject);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramInt = 0;
    }
    paramString = new StringBuilder();
    paramString.append("About to get version from path = ");
    paramString.append((String)localObject);
    paramString.append(" result = ");
    paramString.append(paramInt);
    APLog.d("APMidasDownload", paramString.toString());
    return paramInt;
  }
  
  private String b(File paramFile, String paramString)
  {
    try
    {
      File[] arrayOfFile = paramFile.listFiles();
      paramFile = "";
      int i = 0;
      for (;;)
      {
        localObject = paramFile;
        if (i >= arrayOfFile.length) {
          break;
        }
        if (paramString.contains(arrayOfFile[i].getName().split("\\_")[0])) {
          paramFile = arrayOfFile[i].getName();
        }
        i += 1;
      }
    }
    catch (Exception paramFile)
    {
      Object localObject;
      label58:
      break label58;
    }
    localObject = "";
    return localObject;
  }
  
  private void b()
  {
    this.c = aq.a().b();
    this.d = new ArrayList();
    try
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          if (av.a(av.this) != null)
          {
            int i = 0;
            while (i < av.a(av.this).size())
            {
              localObject = ((ap)av.a(av.this).get(i)).a;
              int j = ((ap)av.a(av.this).get(i)).k;
              if (j != 0)
              {
                av.a(av.this, (String)localObject, j);
                if (av.b(av.this)) {
                  av.c(av.this).add(av.a(av.this).get(i));
                }
              }
              i += 1;
            }
          }
          av.d(av.this);
          if (av.c(av.this).size() > 0)
          {
            av.a(av.this, new ar(av.e(av.this)));
            av.f(av.this).a(av.c(av.this));
            av.f(av.this).b(av.c(av.this), 1);
            av.this.a(av.c(av.this), 1);
            return;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("diffSdcardAndAssetsToData sdcardList size = ");
          ((StringBuilder)localObject).append(av.g(av.this));
          APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("diffSdcardAndAssetsToData assetsList size = ");
          ((StringBuilder)localObject).append(av.h(av.this));
          APLog.d("APMidasDownload", ((StringBuilder)localObject).toString());
          if ((av.g(av.this).size() > 0) || (av.h(av.this).size() > 0))
          {
            new au(av.e(av.this)).a(0);
            File localFile = av.e(av.this).getApplicationContext().getDir("midaspluginsTemp", 0);
            localObject = "sucessnum=";
            if (localFile.listFiles() != null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sucessnum=");
              ((StringBuilder)localObject).append(localFile.listFiles().length);
              localObject = ((StringBuilder)localObject).toString();
            }
            APDataReportManager.getInstance().a("sdk.update.advise.sdcard.sucess", (String)localObject);
            APLog.i("APMidasDownLoad", "本地非网络更新完成");
            av.this.a(av.e(av.this));
          }
        }
      }).start();
      return;
    }
    catch (Exception localException)
    {
      aq.a().f(false);
      localException.printStackTrace();
    }
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    fz localfz = new fz();
    if (("true".equals(localfz.a(paramContext.getApplicationContext(), "TencentUnipay", "processUpdateDex"))) && (APAppDataInterface.singleton().x()))
    {
      APLog.i("APMidasDownLoad", "processUpdateDex is new process need release");
      APPluginUtils.release();
      APPluginUtils.updateLibExtendNum();
      localfz.a(paramContext.getApplicationContext(), "TencentUnipay", "processUpdateDex", "false");
    }
  }
  
  private void c()
  {
    File localFile = Environment.getExternalStorageDirectory();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localFile.getAbsolutePath());
    ((StringBuilder)localObject).append("/MidasPay.zip");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    APLog.i("APMIdasDownload", "resultData=临时的文件被删除");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localFile.getAbsolutePath());
    ((StringBuilder)localObject).append("/MidasTemp/");
    localFile = new File(((StringBuilder)localObject).toString());
    if (localFile.exists())
    {
      localObject = localFile.listFiles();
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].isDirectory())
        {
          File[] arrayOfFile = localObject[i].listFiles();
          int j = 0;
          while (j < arrayOfFile.length)
          {
            arrayOfFile[j].delete();
            j += 1;
          }
          localObject[i].delete();
        }
        else
        {
          localObject[i].delete();
        }
        i += 1;
      }
      localFile.delete();
    }
  }
  
  /* Error */
  private void c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 138	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 456
    //   12: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc_w 458
    //   26: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc 162
    //   38: aload_3
    //   39: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 167	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aconst_null
    //   46: astore 8
    //   48: aconst_null
    //   49: astore 5
    //   51: iload_2
    //   52: iconst_1
    //   53: if_icmpne +71 -> 124
    //   56: new 50	java/io/File
    //   59: dup
    //   60: aload_0
    //   61: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   64: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   67: ldc 200
    //   69: iconst_0
    //   70: invokevirtual 204	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   73: aload_1
    //   74: invokespecial 310	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore_3
    //   78: new 138	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   85: astore 4
    //   87: aload 4
    //   89: invokestatic 218	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   92: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 4
    //   101: ldc 220
    //   103: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: new 50	java/io/File
    //   110: dup
    //   111: aload 4
    //   113: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: astore 4
    //   121: goto +156 -> 277
    //   124: iload_2
    //   125: iconst_2
    //   126: if_icmpne +97 -> 223
    //   129: new 138	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   136: astore_3
    //   137: aload_3
    //   138: invokestatic 218	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   144: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_3
    //   149: ldc 220
    //   151: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore_3
    //   160: new 138	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   167: astore 4
    //   169: aload 4
    //   171: aload_3
    //   172: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 4
    //   178: aload_1
    //   179: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: new 50	java/io/File
    //   186: dup
    //   187: aload 4
    //   189: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: astore_3
    //   196: aload_0
    //   197: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   200: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   203: pop
    //   204: aload_0
    //   205: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   208: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   211: ldc_w 460
    //   214: iconst_0
    //   215: invokevirtual 204	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   218: astore 4
    //   220: goto +57 -> 277
    //   223: iload_2
    //   224: iconst_3
    //   225: if_icmpne +539 -> 764
    //   228: new 50	java/io/File
    //   231: dup
    //   232: aload_0
    //   233: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   236: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   239: ldc 200
    //   241: iconst_0
    //   242: invokevirtual 204	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   245: aload_1
    //   246: invokespecial 310	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   249: astore_3
    //   250: aload_0
    //   251: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   254: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   257: pop
    //   258: aload_0
    //   259: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   262: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   265: ldc_w 460
    //   268: iconst_0
    //   269: invokevirtual 204	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   272: astore 4
    //   274: goto +3 -> 277
    //   277: aload 4
    //   279: ifnull +17 -> 296
    //   282: aload 4
    //   284: invokevirtual 226	java/io/File:exists	()Z
    //   287: ifne +9 -> 296
    //   290: aload 4
    //   292: invokevirtual 463	java/io/File:mkdirs	()Z
    //   295: pop
    //   296: new 465	java/io/FileInputStream
    //   299: dup
    //   300: aload_3
    //   301: invokespecial 466	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   304: astore 6
    //   306: new 468	java/io/BufferedInputStream
    //   309: dup
    //   310: aload 6
    //   312: invokespecial 471	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   315: astore 7
    //   317: new 138	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   324: astore 9
    //   326: aload 9
    //   328: getstatic 474	java/io/File:separator	Ljava/lang/String;
    //   331: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 9
    //   337: aload_1
    //   338: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: new 50	java/io/File
    //   345: dup
    //   346: aload 4
    //   348: aload 9
    //   350: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokespecial 310	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   356: astore_1
    //   357: new 138	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   364: astore 4
    //   366: aload 4
    //   368: ldc_w 476
    //   371: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 4
    //   377: aload_3
    //   378: invokevirtual 479	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 162
    //   384: aload 4
    //   386: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 167	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: new 138	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   399: astore_3
    //   400: aload_3
    //   401: ldc_w 481
    //   404: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_3
    //   409: aload_1
    //   410: invokevirtual 479	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: ldc 162
    //   416: aload_3
    //   417: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 167	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: new 314	java/io/FileOutputStream
    //   426: dup
    //   427: aload_1
    //   428: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   431: astore_1
    //   432: new 312	java/io/BufferedOutputStream
    //   435: dup
    //   436: aload_1
    //   437: invokespecial 318	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   440: astore_3
    //   441: sipush 1024
    //   444: newarray byte
    //   446: astore 4
    //   448: aload 7
    //   450: aload 4
    //   452: invokevirtual 482	java/io/BufferedInputStream:read	([B)I
    //   455: istore_2
    //   456: iload_2
    //   457: iconst_m1
    //   458: if_icmpeq +14 -> 472
    //   461: aload_3
    //   462: aload 4
    //   464: iconst_0
    //   465: iload_2
    //   466: invokevirtual 332	java/io/BufferedOutputStream:write	([BII)V
    //   469: goto -21 -> 448
    //   472: aload_3
    //   473: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   476: aload_3
    //   477: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   480: aload_3
    //   481: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   484: aload_1
    //   485: invokevirtual 483	java/io/FileOutputStream:flush	()V
    //   488: aload_1
    //   489: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   492: aload 7
    //   494: invokevirtual 485	java/io/BufferedInputStream:close	()V
    //   497: aload 6
    //   499: invokevirtual 486	java/io/FileInputStream:close	()V
    //   502: return
    //   503: astore 4
    //   505: aload_1
    //   506: astore 8
    //   508: aload 4
    //   510: astore_1
    //   511: aload_3
    //   512: astore 5
    //   514: aload 7
    //   516: astore 4
    //   518: aload 8
    //   520: astore_3
    //   521: goto +154 -> 675
    //   524: astore 8
    //   526: aload_3
    //   527: astore 5
    //   529: aload 7
    //   531: astore 4
    //   533: aload 8
    //   535: astore_3
    //   536: goto +72 -> 608
    //   539: astore 4
    //   541: aload_1
    //   542: astore_3
    //   543: aload 4
    //   545: astore_1
    //   546: aload 8
    //   548: astore 5
    //   550: aload 7
    //   552: astore 4
    //   554: goto +121 -> 675
    //   557: astore_3
    //   558: aload 7
    //   560: astore 4
    //   562: goto +46 -> 608
    //   565: astore_1
    //   566: aconst_null
    //   567: astore_3
    //   568: aload 8
    //   570: astore 5
    //   572: aload 7
    //   574: astore 4
    //   576: goto +99 -> 675
    //   579: astore_3
    //   580: aconst_null
    //   581: astore_1
    //   582: aload 7
    //   584: astore 4
    //   586: goto +22 -> 608
    //   589: astore_1
    //   590: aconst_null
    //   591: astore_3
    //   592: aload_3
    //   593: astore 4
    //   595: aload 8
    //   597: astore 5
    //   599: goto +76 -> 675
    //   602: astore_3
    //   603: aconst_null
    //   604: astore_1
    //   605: aload_1
    //   606: astore 4
    //   608: aload_3
    //   609: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   612: aload 5
    //   614: ifnull +16 -> 630
    //   617: aload 5
    //   619: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   622: aload 5
    //   624: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   627: goto +3 -> 630
    //   630: aload_1
    //   631: ifnull +11 -> 642
    //   634: aload_1
    //   635: invokevirtual 483	java/io/FileOutputStream:flush	()V
    //   638: aload_1
    //   639: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   642: aload 4
    //   644: ifnull +8 -> 652
    //   647: aload 4
    //   649: invokevirtual 485	java/io/BufferedInputStream:close	()V
    //   652: aload 6
    //   654: ifnull +13 -> 667
    //   657: aload 6
    //   659: invokevirtual 486	java/io/FileInputStream:close	()V
    //   662: return
    //   663: aload_1
    //   664: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   667: return
    //   668: astore 7
    //   670: aload_1
    //   671: astore_3
    //   672: aload 7
    //   674: astore_1
    //   675: aload 5
    //   677: ifnull +16 -> 693
    //   680: aload 5
    //   682: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   685: aload 5
    //   687: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   690: goto +3 -> 693
    //   693: aload_3
    //   694: ifnull +11 -> 705
    //   697: aload_3
    //   698: invokevirtual 483	java/io/FileOutputStream:flush	()V
    //   701: aload_3
    //   702: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   705: aload 4
    //   707: ifnull +8 -> 715
    //   710: aload 4
    //   712: invokevirtual 485	java/io/BufferedInputStream:close	()V
    //   715: aload 6
    //   717: ifnull +15 -> 732
    //   720: aload 6
    //   722: invokevirtual 486	java/io/FileInputStream:close	()V
    //   725: goto +7 -> 732
    //   728: aload_3
    //   729: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   732: aload_1
    //   733: athrow
    //   734: astore_1
    //   735: aconst_null
    //   736: astore_3
    //   737: aload_3
    //   738: astore 6
    //   740: aload 6
    //   742: astore 4
    //   744: aload 8
    //   746: astore 5
    //   748: goto -73 -> 675
    //   751: astore_3
    //   752: aconst_null
    //   753: astore_1
    //   754: aload_1
    //   755: astore 6
    //   757: aload 6
    //   759: astore 4
    //   761: goto -153 -> 608
    //   764: aconst_null
    //   765: astore 4
    //   767: aload 4
    //   769: astore_3
    //   770: goto -493 -> 277
    //   773: astore_1
    //   774: goto -111 -> 663
    //   777: astore_3
    //   778: goto -50 -> 728
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	this	av
    //   0	781	1	paramString	String
    //   0	781	2	paramInt	int
    //   7	536	3	localObject1	Object
    //   557	1	3	localException1	Exception
    //   567	1	3	localObject2	Object
    //   579	1	3	localException2	Exception
    //   591	2	3	localObject3	Object
    //   602	7	3	localException3	Exception
    //   671	67	3	str1	String
    //   751	1	3	localException4	Exception
    //   769	1	3	localObject4	Object
    //   777	1	3	localIOException	java.io.IOException
    //   85	378	4	localObject5	Object
    //   503	6	4	localObject6	Object
    //   516	16	4	localObject7	Object
    //   539	5	4	localObject8	Object
    //   552	216	4	localObject9	Object
    //   49	698	5	localObject10	Object
    //   304	454	6	localObject11	Object
    //   315	268	7	localBufferedInputStream	BufferedInputStream
    //   668	5	7	localObject12	Object
    //   46	473	8	str2	String
    //   524	221	8	localException5	Exception
    //   324	25	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   441	448	503	finally
    //   448	456	503	finally
    //   461	469	503	finally
    //   472	476	503	finally
    //   441	448	524	java/lang/Exception
    //   448	456	524	java/lang/Exception
    //   461	469	524	java/lang/Exception
    //   472	476	524	java/lang/Exception
    //   432	441	539	finally
    //   432	441	557	java/lang/Exception
    //   317	432	565	finally
    //   317	432	579	java/lang/Exception
    //   306	317	589	finally
    //   306	317	602	java/lang/Exception
    //   608	612	668	finally
    //   56	121	734	finally
    //   129	220	734	finally
    //   228	274	734	finally
    //   282	296	734	finally
    //   296	306	734	finally
    //   56	121	751	java/lang/Exception
    //   129	220	751	java/lang/Exception
    //   228	274	751	java/lang/Exception
    //   282	296	751	java/lang/Exception
    //   296	306	751	java/lang/Exception
    //   476	502	773	java/io/IOException
    //   617	627	773	java/io/IOException
    //   634	642	773	java/io/IOException
    //   647	652	773	java/io/IOException
    //   657	662	773	java/io/IOException
    //   680	690	777	java/io/IOException
    //   697	705	777	java/io/IOException
    //   710	715	777	java/io/IOException
    //   720	725	777	java/io/IOException
  }
  
  private void d(String paramString, int paramInt)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject1).append("/MidasTemp/MidasPay/");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject2).append("/MidasTemp/");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject1).exists())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getAbsolutePath());
        ((StringBuilder)localObject2).append("/MidasTemp/MidasPay/");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = b((File)localObject1, paramString);
        if ((localObject1 != null) && (((String)localObject1).length() == 0)) {
          return;
        }
        paramString = new StringBuilder();
        paramString.append((String)localObject2);
        paramString.append((String)localObject1);
        paramString = new File(paramString.toString());
      }
      else
      {
        if (!((File)localObject2).exists()) {
          break label502;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
        ((StringBuilder)localObject1).append("/MidasTemp/");
        localObject3 = ((StringBuilder)localObject1).toString();
        localObject1 = b((File)localObject2, paramString);
        paramString = new StringBuilder();
        paramString.append((String)localObject3);
        paramString.append((String)localObject1);
        paramString = new File(paramString.toString());
      }
      localObject2 = new FileInputStream(paramString);
      Object localObject3 = new BufferedInputStream((InputStream)localObject2);
      paramString = "";
      if (paramInt == 1)
      {
        paramString = this.a.getApplicationContext().getDir("midaspluginsTemp", 0).getAbsolutePath();
      }
      else if (paramInt == 2)
      {
        paramString = new StringBuilder();
        paramString.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        paramString.append("/Tencent/MidasPay/");
        paramString = paramString.toString();
      }
      paramString = new File(paramString);
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append(((String)localObject1).substring(0, ((String)localObject1).length() - 4));
      ((StringBuilder)localObject4).append(".apk");
      paramString = new FileOutputStream(new File(paramString, ((StringBuilder)localObject4).toString()));
      localObject1 = new BufferedOutputStream(paramString);
      localObject4 = new byte[1024];
      for (;;)
      {
        paramInt = ((BufferedInputStream)localObject3).read((byte[])localObject4);
        if (paramInt == -1) {
          break;
        }
        ((BufferedOutputStream)localObject1).write((byte[])localObject4, 0, paramInt);
      }
      ((BufferedOutputStream)localObject1).flush();
      ((BufferedOutputStream)localObject1).close();
      paramString.flush();
      paramString.close();
      ((BufferedInputStream)localObject3).close();
      ((FileInputStream)localObject2).close();
      return;
      label502:
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean d()
  {
    return new au(this.a).b() > e();
  }
  
  private long e()
  {
    Object localObject = this.a.getApplicationContext();
    int i = 0;
    localObject = ((Context)localObject).getDir("midasplugins", 0).listFiles();
    long l = 0L;
    while (i < localObject.length)
    {
      l += localObject[i].length();
      i += 1;
    }
    return l;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: ldc 103
    //   2: astore 8
    //   4: aconst_null
    //   5: astore 9
    //   7: aconst_null
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 10
    //   13: invokestatic 177	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   16: ldc 179
    //   18: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifne +6 -> 27
    //   24: ldc 103
    //   26: areturn
    //   27: invokestatic 218	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   30: astore_3
    //   31: new 138	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   38: astore 4
    //   40: aload 4
    //   42: aload_3
    //   43: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: ldc_w 268
    //   55: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: new 50	java/io/File
    //   62: dup
    //   63: aload 4
    //   65: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 5
    //   73: aload 5
    //   75: invokevirtual 226	java/io/File:exists	()Z
    //   78: ifne +225 -> 303
    //   81: aload_0
    //   82: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   85: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   88: invokevirtual 504	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   91: ldc 103
    //   93: invokevirtual 509	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   96: astore 6
    //   98: ldc 103
    //   100: astore_3
    //   101: iconst_0
    //   102: istore_2
    //   103: iload_2
    //   104: aload 6
    //   106: arraylength
    //   107: if_icmpge +44 -> 151
    //   110: aload_3
    //   111: astore 4
    //   113: aload 6
    //   115: iload_2
    //   116: aaload
    //   117: ldc_w 511
    //   120: invokevirtual 514	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   123: ifeq +791 -> 914
    //   126: aload_3
    //   127: astore 4
    //   129: aload 6
    //   131: iload_2
    //   132: aaload
    //   133: ldc_w 516
    //   136: invokevirtual 120	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   139: ifeq +775 -> 914
    //   142: aload 6
    //   144: iload_2
    //   145: aaload
    //   146: astore 4
    //   148: goto +766 -> 914
    //   151: aload_0
    //   152: getfield 28	midas/x/av:a	Landroid/content/Context;
    //   155: invokevirtual 198	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   158: invokevirtual 504	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   161: aload_3
    //   162: invokevirtual 520	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   165: astore_3
    //   166: new 468	java/io/BufferedInputStream
    //   169: dup
    //   170: aload_3
    //   171: invokespecial 471	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   174: astore 4
    //   176: new 314	java/io/FileOutputStream
    //   179: dup
    //   180: aload 5
    //   182: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   185: astore 5
    //   187: new 312	java/io/BufferedOutputStream
    //   190: dup
    //   191: aload 5
    //   193: invokespecial 318	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   196: astore 6
    //   198: sipush 1024
    //   201: newarray byte
    //   203: astore 7
    //   205: aload 4
    //   207: aload 7
    //   209: invokevirtual 482	java/io/BufferedInputStream:read	([B)I
    //   212: istore_2
    //   213: iload_2
    //   214: iconst_m1
    //   215: if_icmpeq +15 -> 230
    //   218: aload 6
    //   220: aload 7
    //   222: iconst_0
    //   223: iload_2
    //   224: invokevirtual 332	java/io/BufferedOutputStream:write	([BII)V
    //   227: goto -22 -> 205
    //   230: aload 6
    //   232: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   235: goto +87 -> 322
    //   238: astore_1
    //   239: goto +615 -> 854
    //   242: astore 7
    //   244: goto +160 -> 404
    //   247: astore_1
    //   248: aload 7
    //   250: astore 6
    //   252: goto +602 -> 854
    //   255: astore 6
    //   257: goto +35 -> 292
    //   260: astore_1
    //   261: aconst_null
    //   262: astore 5
    //   264: aload 7
    //   266: astore 6
    //   268: goto +586 -> 854
    //   271: astore 6
    //   273: aconst_null
    //   274: astore 5
    //   276: goto +16 -> 292
    //   279: astore_1
    //   280: goto +96 -> 376
    //   283: astore 6
    //   285: aconst_null
    //   286: astore 4
    //   288: aload 4
    //   290: astore 5
    //   292: aload 6
    //   294: astore 7
    //   296: aload 9
    //   298: astore 6
    //   300: goto +104 -> 404
    //   303: aconst_null
    //   304: astore 6
    //   306: aload 6
    //   308: astore_3
    //   309: aload_3
    //   310: astore 5
    //   312: aload_3
    //   313: astore 4
    //   315: aload 6
    //   317: astore_3
    //   318: aload 10
    //   320: astore 6
    //   322: aload 6
    //   324: ifnull +13 -> 337
    //   327: aload 6
    //   329: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   332: aload 6
    //   334: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   337: aload 5
    //   339: ifnull +13 -> 352
    //   342: aload 5
    //   344: invokevirtual 483	java/io/FileOutputStream:flush	()V
    //   347: aload 5
    //   349: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   352: aload 4
    //   354: ifnull +8 -> 362
    //   357: aload 4
    //   359: invokevirtual 485	java/io/BufferedInputStream:close	()V
    //   362: aload_3
    //   363: ifnull +104 -> 467
    //   366: aload_3
    //   367: invokevirtual 335	java/io/InputStream:close	()V
    //   370: goto +97 -> 467
    //   373: astore_1
    //   374: aconst_null
    //   375: astore_3
    //   376: aconst_null
    //   377: astore 4
    //   379: aconst_null
    //   380: astore 5
    //   382: aload 7
    //   384: astore 6
    //   386: goto +468 -> 854
    //   389: astore 7
    //   391: aconst_null
    //   392: astore_3
    //   393: aload_3
    //   394: astore 4
    //   396: aload 4
    //   398: astore 5
    //   400: aload 9
    //   402: astore 6
    //   404: aload 7
    //   406: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   409: aload 6
    //   411: ifnull +16 -> 427
    //   414: aload 6
    //   416: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   419: aload 6
    //   421: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   424: goto +3 -> 427
    //   427: aload 5
    //   429: ifnull +13 -> 442
    //   432: aload 5
    //   434: invokevirtual 483	java/io/FileOutputStream:flush	()V
    //   437: aload 5
    //   439: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   442: aload 4
    //   444: ifnull +8 -> 452
    //   447: aload 4
    //   449: invokevirtual 485	java/io/BufferedInputStream:close	()V
    //   452: aload_3
    //   453: ifnull +14 -> 467
    //   456: aload_3
    //   457: invokevirtual 335	java/io/InputStream:close	()V
    //   460: goto +7 -> 467
    //   463: aload_3
    //   464: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   467: aload 8
    //   469: astore_3
    //   470: aload_1
    //   471: ifnull +380 -> 851
    //   474: new 138	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   481: astore_3
    //   482: aload_3
    //   483: invokestatic 218	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   486: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   489: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload_3
    //   494: ldc_w 488
    //   497: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: new 50	java/io/File
    //   504: dup
    //   505: aload_3
    //   506: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   512: astore 4
    //   514: new 138	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   521: astore_3
    //   522: aload_3
    //   523: invokestatic 218	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   526: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   529: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload_3
    //   534: ldc_w 270
    //   537: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: new 50	java/io/File
    //   544: dup
    //   545: aload_3
    //   546: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokespecial 223	java/io/File:<init>	(Ljava/lang/String;)V
    //   552: astore 5
    //   554: aload 4
    //   556: invokevirtual 226	java/io/File:exists	()Z
    //   559: ifeq +77 -> 636
    //   562: aload 4
    //   564: invokevirtual 54	java/io/File:listFiles	()[Ljava/io/File;
    //   567: ifnull +69 -> 636
    //   570: aload 4
    //   572: invokevirtual 54	java/io/File:listFiles	()[Ljava/io/File;
    //   575: arraylength
    //   576: ifle +60 -> 636
    //   579: aload_0
    //   580: aload 4
    //   582: aload_1
    //   583: invokespecial 206	midas/x/av:b	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   586: astore_1
    //   587: aload 8
    //   589: astore_3
    //   590: aload_1
    //   591: invokevirtual 64	java/lang/String:length	()I
    //   594: ifle +257 -> 851
    //   597: new 138	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   604: astore_3
    //   605: aload_3
    //   606: aload 4
    //   608: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   611: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_3
    //   616: ldc_w 295
    //   619: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload_3
    //   624: aload_1
    //   625: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_3
    //   630: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: astore_1
    //   634: aload_1
    //   635: areturn
    //   636: aload 5
    //   638: invokevirtual 226	java/io/File:exists	()Z
    //   641: ifeq +78 -> 719
    //   644: aload 5
    //   646: invokevirtual 54	java/io/File:listFiles	()[Ljava/io/File;
    //   649: ifnull +70 -> 719
    //   652: aload 5
    //   654: invokevirtual 54	java/io/File:listFiles	()[Ljava/io/File;
    //   657: arraylength
    //   658: ifle +61 -> 719
    //   661: aload_0
    //   662: aload 5
    //   664: aload_1
    //   665: invokespecial 206	midas/x/av:b	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   668: astore_1
    //   669: aload 8
    //   671: astore_3
    //   672: aload_1
    //   673: invokevirtual 64	java/lang/String:length	()I
    //   676: ifle +175 -> 851
    //   679: new 138	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   686: astore_3
    //   687: aload_3
    //   688: aload 5
    //   690: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   693: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload_3
    //   698: ldc_w 295
    //   701: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_3
    //   706: aload_1
    //   707: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload_3
    //   712: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: astore_1
    //   716: goto -82 -> 634
    //   719: aload 8
    //   721: astore_3
    //   722: aload_0
    //   723: iconst_2
    //   724: invokespecial 522	midas/x/av:a	(I)Z
    //   727: ifeq +124 -> 851
    //   730: aload 4
    //   732: invokevirtual 226	java/io/File:exists	()Z
    //   735: ifeq +61 -> 796
    //   738: aload_0
    //   739: aload 4
    //   741: aload_1
    //   742: invokespecial 206	midas/x/av:b	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   745: astore_1
    //   746: aload 8
    //   748: astore_3
    //   749: aload_1
    //   750: invokevirtual 64	java/lang/String:length	()I
    //   753: ifle +98 -> 851
    //   756: new 138	java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   763: astore_3
    //   764: aload_3
    //   765: aload 4
    //   767: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   770: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload_3
    //   775: ldc_w 295
    //   778: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload_3
    //   783: aload_1
    //   784: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload_3
    //   789: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: astore_1
    //   793: goto -159 -> 634
    //   796: aload_0
    //   797: aload 5
    //   799: aload_1
    //   800: invokespecial 206	midas/x/av:b	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   803: astore_1
    //   804: aload 8
    //   806: astore_3
    //   807: aload_1
    //   808: invokevirtual 64	java/lang/String:length	()I
    //   811: ifle +40 -> 851
    //   814: new 138	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   821: astore_3
    //   822: aload_3
    //   823: aload 5
    //   825: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   828: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload_3
    //   833: ldc_w 295
    //   836: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: aload_3
    //   841: aload_1
    //   842: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload_3
    //   847: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: astore_3
    //   851: aload_3
    //   852: areturn
    //   853: astore_1
    //   854: aload 6
    //   856: ifnull +16 -> 872
    //   859: aload 6
    //   861: invokevirtual 339	java/io/BufferedOutputStream:flush	()V
    //   864: aload 6
    //   866: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   869: goto +3 -> 872
    //   872: aload 5
    //   874: ifnull +13 -> 887
    //   877: aload 5
    //   879: invokevirtual 483	java/io/FileOutputStream:flush	()V
    //   882: aload 5
    //   884: invokevirtual 484	java/io/FileOutputStream:close	()V
    //   887: aload 4
    //   889: ifnull +8 -> 897
    //   892: aload 4
    //   894: invokevirtual 485	java/io/BufferedInputStream:close	()V
    //   897: aload_3
    //   898: ifnull +14 -> 912
    //   901: aload_3
    //   902: invokevirtual 335	java/io/InputStream:close	()V
    //   905: goto +7 -> 912
    //   908: aload_3
    //   909: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   912: aload_1
    //   913: athrow
    //   914: iload_2
    //   915: iconst_1
    //   916: iadd
    //   917: istore_2
    //   918: aload 4
    //   920: astore_3
    //   921: goto -818 -> 103
    //   924: astore_3
    //   925: goto -462 -> 463
    //   928: astore_3
    //   929: goto -21 -> 908
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	932	0	this	av
    //   0	932	1	paramString	String
    //   102	816	2	i	int
    //   30	891	3	localObject1	Object
    //   924	1	3	localIOException1	java.io.IOException
    //   928	1	3	localIOException2	java.io.IOException
    //   38	881	4	localObject2	Object
    //   71	812	5	localObject3	Object
    //   96	155	6	localObject4	Object
    //   255	1	6	localException1	Exception
    //   266	1	6	localException2	Exception
    //   271	1	6	localException3	Exception
    //   283	10	6	localException4	Exception
    //   298	567	6	localObject5	Object
    //   8	213	7	arrayOfByte	byte[]
    //   242	23	7	localException5	Exception
    //   294	89	7	localObject6	Object
    //   389	16	7	localException6	Exception
    //   2	803	8	str	String
    //   5	396	9	localObject7	Object
    //   11	308	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   198	205	238	finally
    //   205	213	238	finally
    //   218	227	238	finally
    //   230	235	238	finally
    //   198	205	242	java/lang/Exception
    //   205	213	242	java/lang/Exception
    //   218	227	242	java/lang/Exception
    //   230	235	242	java/lang/Exception
    //   187	198	247	finally
    //   187	198	255	java/lang/Exception
    //   176	187	260	finally
    //   176	187	271	java/lang/Exception
    //   166	176	279	finally
    //   166	176	283	java/lang/Exception
    //   13	24	373	finally
    //   27	98	373	finally
    //   103	110	373	finally
    //   113	126	373	finally
    //   129	142	373	finally
    //   151	166	373	finally
    //   13	24	389	java/lang/Exception
    //   27	98	389	java/lang/Exception
    //   103	110	389	java/lang/Exception
    //   113	126	389	java/lang/Exception
    //   129	142	389	java/lang/Exception
    //   151	166	389	java/lang/Exception
    //   404	409	853	finally
    //   327	337	924	java/io/IOException
    //   342	352	924	java/io/IOException
    //   357	362	924	java/io/IOException
    //   366	370	924	java/io/IOException
    //   414	424	924	java/io/IOException
    //   432	442	924	java/io/IOException
    //   447	452	924	java/io/IOException
    //   456	460	924	java/io/IOException
    //   859	869	928	java/io/IOException
    //   877	887	928	java/io/IOException
    //   892	897	928	java/io/IOException
    //   901	905	928	java/io/IOException
  }
  
  public void a()
  {
    APLog.i("APMidasDownLoad", "updateAndDownLoad 建议更新的入口");
    if (aq.a().p())
    {
      APLog.i("APMidasDownLoad", "updateAndDownLoad IsDownLoading");
      return;
    }
    File localFile = this.a.getApplicationContext().getDir("midaspluginsTemp", 0);
    new File(localFile, "MidasSign.ini");
    if (!aq.a().h())
    {
      aq.a().f(true);
      APLog.i("APMidasDownLoad", "resultData=建议更新的入口开始");
      aq.a().e(true);
      a(localFile);
      b();
    }
  }
  
  public void a(Context paramContext)
  {
    new fz().a(paramContext.getApplicationContext(), "TencentUnipay", "processUpdateDex", "true");
    if (a.a().l())
    {
      APLog.i("APMidasDownLoad", "updateDataDex is calling return");
      return;
    }
    if (APAppDataInterface.singleton().x())
    {
      APLog.i("APMidasDownLoad", "updateDataDex is new process ");
      APPluginUtils.release();
      APPluginUtils.updateLibExtendNum();
      return;
    }
    APLog.i("APMidasDownLoad", "updateDataDex is not new process");
    APPluginUtils.unInstallPlugin(paramContext);
    com.tencent.midas.control.APMidasPayHelper.initState = -1;
  }
  
  public void a(ArrayList<ap> paramArrayList, int paramInt)
  {
    this.g.a(paramArrayList, paramInt, new ba()
    {
      /* Error */
      public void a()
      {
        // Byte code:
        //   0: ldc 24
        //   2: ldc 26
        //   4: invokestatic 32	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   7: new 34	midas/x/an
        //   10: dup
        //   11: aload_0
        //   12: getfield 16	midas/x/av$2:a	Lmidas/x/av;
        //   15: invokestatic 38	midas/x/av:e	(Lmidas/x/av;)Landroid/content/Context;
        //   18: invokespecial 41	midas/x/an:<init>	(Landroid/content/Context;)V
        //   21: astore 4
        //   23: aload 4
        //   25: invokevirtual 44	midas/x/an:a	()Z
        //   28: ifne +10 -> 38
        //   31: aload 4
        //   33: iconst_1
        //   34: invokevirtual 47	midas/x/an:a	(I)V
        //   37: return
        //   38: new 49	midas/x/au
        //   41: dup
        //   42: aload_0
        //   43: getfield 16	midas/x/av$2:a	Lmidas/x/av;
        //   46: invokestatic 38	midas/x/av:e	(Lmidas/x/av;)Landroid/content/Context;
        //   49: invokespecial 50	midas/x/au:<init>	(Landroid/content/Context;)V
        //   52: astore 6
        //   54: aload 6
        //   56: invokevirtual 53	midas/x/au:g	()Z
        //   59: ifeq +131 -> 190
        //   62: aload 4
        //   64: invokevirtual 56	midas/x/an:c	()V
        //   67: iconst_2
        //   68: iconst_m1
        //   69: invokestatic 61	midas/x/ay:a	(II)V
        //   72: aload 6
        //   74: iconst_0
        //   75: invokevirtual 62	midas/x/au:a	(I)V
        //   78: aload_0
        //   79: getfield 16	midas/x/av$2:a	Lmidas/x/av;
        //   82: invokestatic 38	midas/x/av:e	(Lmidas/x/av;)Landroid/content/Context;
        //   85: invokevirtual 68	android/content/Context:getApplicationContext	()Landroid/content/Context;
        //   88: ldc 70
        //   90: iconst_0
        //   91: invokevirtual 74	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
        //   94: astore 5
        //   96: ldc 76
        //   98: astore 4
        //   100: aload 5
        //   102: invokevirtual 82	java/io/File:listFiles	()[Ljava/io/File;
        //   105: ifnull +39 -> 144
        //   108: new 84	java/lang/StringBuilder
        //   111: dup
        //   112: invokespecial 85	java/lang/StringBuilder:<init>	()V
        //   115: astore 4
        //   117: aload 4
        //   119: ldc 76
        //   121: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: pop
        //   125: aload 4
        //   127: aload 5
        //   129: invokevirtual 82	java/io/File:listFiles	()[Ljava/io/File;
        //   132: arraylength
        //   133: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   136: pop
        //   137: aload 4
        //   139: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   142: astore 4
        //   144: invokestatic 102	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
        //   147: ldc 104
        //   149: aload 4
        //   151: invokevirtual 106	com/pay/data/report/APDataReportManager:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   154: ldc 24
        //   156: ldc 108
        //   158: invokestatic 32	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   161: aload_0
        //   162: getfield 16	midas/x/av$2:a	Lmidas/x/av;
        //   165: aload_0
        //   166: getfield 16	midas/x/av$2:a	Lmidas/x/av;
        //   169: invokestatic 38	midas/x/av:e	(Lmidas/x/av;)Landroid/content/Context;
        //   172: invokevirtual 110	midas/x/av:a	(Landroid/content/Context;)V
        //   175: ldc 24
        //   177: ldc 112
        //   179: invokestatic 32	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   182: invokestatic 117	midas/x/aq:a	()Lmidas/x/aq;
        //   185: iconst_0
        //   186: invokevirtual 121	midas/x/aq:f	(Z)V
        //   189: return
        //   190: invokestatic 117	midas/x/aq:a	()Lmidas/x/aq;
        //   193: iconst_0
        //   194: invokevirtual 123	midas/x/aq:e	(Z)V
        //   197: new 125	java/lang/StringBuffer
        //   200: dup
        //   201: invokespecial 126	java/lang/StringBuffer:<init>	()V
        //   204: astore 7
        //   206: aload_0
        //   207: getfield 16	midas/x/av$2:a	Lmidas/x/av;
        //   210: invokestatic 38	midas/x/av:e	(Lmidas/x/av;)Landroid/content/Context;
        //   213: invokevirtual 68	android/content/Context:getApplicationContext	()Landroid/content/Context;
        //   216: ldc 70
        //   218: iconst_0
        //   219: invokevirtual 74	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
        //   222: invokevirtual 82	java/io/File:listFiles	()[Ljava/io/File;
        //   225: astore 8
        //   227: new 84	java/lang/StringBuilder
        //   230: dup
        //   231: invokespecial 85	java/lang/StringBuilder:<init>	()V
        //   234: astore 4
        //   236: aload 4
        //   238: ldc 128
        //   240: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   243: pop
        //   244: aload 8
        //   246: ifnonnull +8 -> 254
        //   249: iconst_0
        //   250: istore_1
        //   251: goto +7 -> 258
        //   254: aload 8
        //   256: arraylength
        //   257: istore_1
        //   258: aload 4
        //   260: iload_1
        //   261: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   264: pop
        //   265: aload 4
        //   267: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   270: astore 4
        //   272: aload 4
        //   274: astore 5
        //   276: aload 8
        //   278: ifnull +168 -> 446
        //   281: aload 4
        //   283: astore 5
        //   285: aload 8
        //   287: arraylength
        //   288: ifle +158 -> 446
        //   291: iconst_0
        //   292: istore_1
        //   293: aload 4
        //   295: astore 5
        //   297: iload_1
        //   298: aload 8
        //   300: arraylength
        //   301: if_icmpge +145 -> 446
        //   304: aload 8
        //   306: iload_1
        //   307: aaload
        //   308: invokevirtual 131	java/io/File:getName	()Ljava/lang/String;
        //   311: ldc 133
        //   313: invokevirtual 139	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   316: ifne +96 -> 412
        //   319: aload 8
        //   321: iload_1
        //   322: aaload
        //   323: invokevirtual 131	java/io/File:getName	()Ljava/lang/String;
        //   326: ldc 141
        //   328: invokevirtual 139	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   331: ifne +81 -> 412
        //   334: aload 7
        //   336: aload 6
        //   338: aload 8
        //   340: iload_1
        //   341: aaload
        //   342: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   345: invokevirtual 147	midas/x/au:a	(Ljava/lang/String;)Ljava/lang/String;
        //   348: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   351: pop
        //   352: new 152	java/io/FileInputStream
        //   355: dup
        //   356: aload 8
        //   358: iload_1
        //   359: aaload
        //   360: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   363: astore 5
        //   365: aload 5
        //   367: invokevirtual 159	java/io/FileInputStream:available	()I
        //   370: i2l
        //   371: lstore_2
        //   372: new 84	java/lang/StringBuilder
        //   375: dup
        //   376: invokespecial 85	java/lang/StringBuilder:<init>	()V
        //   379: astore 9
        //   381: aload 9
        //   383: ldc 161
        //   385: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   388: pop
        //   389: aload 9
        //   391: lload_2
        //   392: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   395: pop
        //   396: aload 7
        //   398: aload 9
        //   400: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   403: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   406: pop
        //   407: aload 5
        //   409: invokevirtual 167	java/io/FileInputStream:close	()V
        //   412: iload_1
        //   413: iconst_1
        //   414: iadd
        //   415: istore_1
        //   416: goto -123 -> 293
        //   419: astore 5
        //   421: goto +9 -> 430
        //   424: astore 5
        //   426: ldc 169
        //   428: astore 4
        //   430: invokestatic 117	midas/x/aq:a	()Lmidas/x/aq;
        //   433: iconst_0
        //   434: invokevirtual 121	midas/x/aq:f	(Z)V
        //   437: aload 5
        //   439: invokevirtual 172	java/lang/Exception:printStackTrace	()V
        //   442: aload 4
        //   444: astore 5
        //   446: aload 6
        //   448: invokevirtual 175	midas/x/au:c	()J
        //   451: lstore_2
        //   452: new 125	java/lang/StringBuffer
        //   455: dup
        //   456: invokespecial 126	java/lang/StringBuffer:<init>	()V
        //   459: astore 4
        //   461: aload 4
        //   463: invokestatic 181	com/pay/tool/APAppDataInterface:singleton	()Lcom/pay/tool/APAppDataInterface;
        //   466: invokevirtual 184	com/pay/tool/APAppDataInterface:j	()Ljava/lang/String;
        //   469: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   472: pop
        //   473: aload 4
        //   475: ldc 186
        //   477: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   480: pop
        //   481: aload 4
        //   483: aload 7
        //   485: invokevirtual 187	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   488: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   491: pop
        //   492: aload 4
        //   494: ldc 189
        //   496: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   499: pop
        //   500: aload 4
        //   502: aload 5
        //   504: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   507: pop
        //   508: aload 4
        //   510: ldc 191
        //   512: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   515: pop
        //   516: new 84	java/lang/StringBuilder
        //   519: dup
        //   520: invokespecial 85	java/lang/StringBuilder:<init>	()V
        //   523: astore 5
        //   525: aload 5
        //   527: ldc 161
        //   529: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   532: pop
        //   533: aload 5
        //   535: lload_2
        //   536: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   539: pop
        //   540: aload 4
        //   542: aload 5
        //   544: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   547: invokevirtual 150	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   550: pop
        //   551: aload 6
        //   553: invokevirtual 193	midas/x/au:f	()V
        //   556: invokestatic 102	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
        //   559: ldc 195
        //   561: aload 4
        //   563: invokevirtual 187	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   566: invokevirtual 106	com/pay/data/report/APDataReportManager:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   569: ldc 24
        //   571: ldc 197
        //   573: invokestatic 32	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   576: invokestatic 117	midas/x/aq:a	()Lmidas/x/aq;
        //   579: iconst_0
        //   580: invokevirtual 121	midas/x/aq:f	(Z)V
        //   583: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	584	0	this	2
        //   250	166	1	i	int
        //   371	165	2	l	long
        //   21	541	4	localObject1	Object
        //   94	314	5	localObject2	Object
        //   419	1	5	localException1	Exception
        //   424	14	5	localException2	Exception
        //   444	99	5	localObject3	Object
        //   52	500	6	localau	au
        //   204	280	7	localStringBuffer	StringBuffer
        //   225	132	8	arrayOfFile	File[]
        //   379	20	9	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   285	291	419	java/lang/Exception
        //   297	412	419	java/lang/Exception
        //   206	244	424	java/lang/Exception
        //   254	258	424	java/lang/Exception
        //   258	272	424	java/lang/Exception
      }
      
      public void a(int paramAnonymousInt) {}
      
      public void b()
      {
        long l = new au(av.e(av.this)).c();
        APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("datanum=");
        localStringBuilder.append(l);
        localAPDataReportManager.a("sdk.update.dasize", localStringBuilder.toString());
      }
      
      public void b(int paramAnonymousInt)
      {
        aq.a().e(false);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(APAppDataInterface.singleton().j());
        localStringBuffer.append("&");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("errone=");
        localStringBuilder.append(aq.a().m());
        localStringBuffer.append(localStringBuilder.toString());
        localStringBuffer.append("&");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("errTwo=");
        localStringBuilder.append(aq.a().n());
        localStringBuffer.append(localStringBuilder.toString());
        localStringBuffer.append("&");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("errThree=");
        localStringBuilder.append(aq.a().o());
        localStringBuffer.append(localStringBuilder.toString());
        APDataReportManager.getInstance().a("sdk.update.advise.wifi.fail", localStringBuffer.toString());
        APLog.i("APMidasDownLoad", "resultData=下载结束时没有完成出现异常");
        aq.a().f(false);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.av
 * JD-Core Version:    0.7.0.1
 */