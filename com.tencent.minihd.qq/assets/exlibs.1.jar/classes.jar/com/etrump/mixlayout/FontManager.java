package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ek;
import en;
import eo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FontManager
  implements Manager
{
  public static MQLruCache a;
  static final String jdField_a_of_type_JavaLangString = "FontManager";
  private static final int b = 10;
  public static final String b;
  public static boolean b = false;
  public static final String c;
  public static final String d = "https://i.gtimg.cn/qqshow/admindata/comdata/vipfont_%d/android.zip";
  public static volatile boolean d = false;
  public static final String e = "font_local.cfg";
  public static final String f = ".ttf";
  protected static final String g = "Font_download_succ";
  protected static final String h = "Font_download_cancel";
  protected static final String i = "Font_download";
  protected static final String j = "AIO_Font_download";
  public static final String k = "isUserOpenFontSwitch_";
  public static final String l = "font_open_switch";
  private int jdField_a_of_type_Int = 5000000;
  public long a;
  public ETEngine a;
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new eo(this, "param_WIFIFontDownloadFlow", "param_XGFontDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  public IPCDownloadListener a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public AtomicBoolean a;
  public JSONArray a;
  public boolean a;
  public AtomicBoolean b;
  public AtomicBoolean c;
  public volatile boolean c;
  public AtomicBoolean d;
  public boolean e;
  
  static
  {
    jdField_b_of_type_JavaLangString = AppConstants.aG + "font_info";
    jdField_c_of_type_JavaLangString = AppConstants.aG + "font_tmp";
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache = null;
    jdField_b_of_type_Boolean = false;
  }
  
  public FontManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_OrgJsonJSONArray = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(46));
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(16);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
    this.jdField_a_of_type_Boolean = a();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
    this.e = false;
    a();
  }
  
  public static Drawable a(AppInterface paramAppInterface, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = (Pair)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("font_thumb_" + paramInt);
    if (localObject1 != null)
    {
      paramAppInterface = ((Drawable.ConstantState)((Pair)localObject1).first).newDrawable(paramAppInterface.a().getResources());
      return paramAppInterface;
    }
    for (;;)
    {
      try
      {
        m = paramAppInterface.getApplication().getResources().getDimensionPixelSize(2131493270);
        n = paramAppInterface.getApplication().getResources().getDimensionPixelSize(2131493271);
        if (paramInt != 0) {
          continue;
        }
        localObject1 = BitmapManager.a(paramAppInterface.a().getResources(), 2130840706, m, n);
      }
      catch (Throwable localThrowable)
      {
        int n;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FontManager", 2, "getFontDrawable fail," + localThrowable.getMessage());
        Object localObject2 = null;
        continue;
        int m = Utils.getBitmapSize((Bitmap)localObject2);
        localObject2 = new BitmapDrawable(paramAppInterface.a().getResources(), (Bitmap)localObject2);
        ((BitmapDrawable)localObject2).setTargetDensity(paramAppInterface.a().getResources().getDisplayMetrics());
        paramAppInterface = new Pair(localObject2, Integer.valueOf(m));
        if (paramAppInterface == null) {
          break label350;
        }
      }
      if (localObject1 == null)
      {
        paramAppInterface = localObject3;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FontManager", 2, "getFontDrawable|bitmap null fontid=" + paramInt);
        return null;
        localObject1 = BitmapManager.a(jdField_b_of_type_JavaLangString + File.separator + paramInt + File.separator + "chat_font_thumbnail.png", m, n);
        continue;
      }
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("font_thumb_" + paramInt, new Pair(((Drawable)paramAppInterface.first).getConstantState(), paramAppInterface.second));
    }
    label350:
    for (paramAppInterface = (Drawable)paramAppInterface.first;; paramAppInterface = null) {
      return paramAppInterface;
    }
  }
  
  private static String a(int paramInt)
  {
    String str = String.format("https://i.gtimg.cn/qqshow/admindata/comdata/vipfont_%d/android.zip", new Object[] { Integer.valueOf(paramInt) });
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "getDownLoadResUri" + str);
    }
    return EmosmUtils.insertMtype("VIP_font", str);
  }
  
  private String a(ChatMessage paramChatMessage)
  {
    switch (paramChatMessage.istroop)
    {
    default: 
    case 0: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1025: 
    case 7100: 
    case 1: 
      do
      {
        return null;
        if (paramChatMessage.isSend()) {
          return paramChatMessage.selfuin;
        }
        return paramChatMessage.frienduin;
      } while (AnonymousChatHelper.a(paramChatMessage));
      if (paramChatMessage.isSend()) {
        return paramChatMessage.selfuin;
      }
      return paramChatMessage.senderuin;
    }
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    return paramChatMessage.senderuin;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: new 239	java/io/File
    //   3: dup
    //   4: getstatic 77	com/etrump/mixlayout/FontManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7: ldc 23
    //   9: invokespecial 340	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 343	java/io/File:exists	()Z
    //   17: ifeq +205 -> 222
    //   20: new 345	java/io/FileReader
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 348	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokespecial 351	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_2
    //   34: sipush 4096
    //   37: newarray char
    //   39: astore 4
    //   41: aload_3
    //   42: astore_2
    //   43: new 57	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   50: astore 5
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: aload 4
    //   57: invokevirtual 355	java/io/FileReader:read	([C)I
    //   60: istore_1
    //   61: iload_1
    //   62: ifle +103 -> 165
    //   65: aload_3
    //   66: astore_2
    //   67: aload 5
    //   69: aload 4
    //   71: iconst_0
    //   72: iload_1
    //   73: invokevirtual 358	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -25 -> 52
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +16 -> 103
    //   90: aload_3
    //   91: astore_2
    //   92: ldc 11
    //   94: iconst_2
    //   95: aload 4
    //   97: invokevirtual 359	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_3
    //   104: ifnull +7 -> 111
    //   107: aload_3
    //   108: invokevirtual 364	java/io/FileReader:close	()V
    //   111: aload_0
    //   112: getfield 98	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   115: ifnonnull +14 -> 129
    //   118: aload_0
    //   119: new 366	org/json/JSONArray
    //   122: dup
    //   123: invokespecial 367	org/json/JSONArray:<init>	()V
    //   126: putfield 98	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   129: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +32 -> 164
    //   135: ldc 11
    //   137: iconst_2
    //   138: new 57	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 369
    //   148: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 98	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   155: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: return
    //   165: aload_3
    //   166: astore_2
    //   167: aload 5
    //   169: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore 4
    //   174: aload 4
    //   176: ifnull +18 -> 194
    //   179: aload_3
    //   180: astore_2
    //   181: aload_0
    //   182: new 366	org/json/JSONArray
    //   185: dup
    //   186: aload 4
    //   188: invokespecial 373	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   191: putfield 98	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   194: aload_3
    //   195: ifnull -84 -> 111
    //   198: aload_3
    //   199: invokevirtual 364	java/io/FileReader:close	()V
    //   202: goto -91 -> 111
    //   205: astore_2
    //   206: goto -95 -> 111
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_2
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 364	java/io/FileReader:close	()V
    //   220: aload_3
    //   221: athrow
    //   222: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq -114 -> 111
    //   228: ldc 11
    //   230: iconst_2
    //   231: new 57	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   238: aload_2
    //   239: invokevirtual 348	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   242: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 375
    //   248: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto -146 -> 111
    //   260: astore_2
    //   261: goto -150 -> 111
    //   264: astore_2
    //   265: goto -45 -> 220
    //   268: astore_3
    //   269: goto -57 -> 212
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_3
    //   276: goto -194 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	FontManager
    //   60	13	1	m	int
    //   12	169	2	localObject1	Object
    //   205	1	2	localIOException1	java.io.IOException
    //   211	28	2	localObject2	Object
    //   260	1	2	localIOException2	java.io.IOException
    //   264	1	2	localIOException3	java.io.IOException
    //   31	168	3	localFileReader	java.io.FileReader
    //   209	12	3	localObject3	Object
    //   268	1	3	localObject4	Object
    //   275	1	3	localObject5	Object
    //   39	31	4	arrayOfChar	char[]
    //   80	16	4	localException1	Exception
    //   172	15	4	str	String
    //   272	1	4	localException2	Exception
    //   50	118	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	41	80	java/lang/Exception
    //   43	52	80	java/lang/Exception
    //   54	61	80	java/lang/Exception
    //   67	77	80	java/lang/Exception
    //   167	174	80	java/lang/Exception
    //   181	194	80	java/lang/Exception
    //   198	202	205	java/io/IOException
    //   20	32	209	finally
    //   107	111	260	java/io/IOException
    //   216	220	264	java/io/IOException
    //   34	41	268	finally
    //   43	52	268	finally
    //   54	61	268	finally
    //   67	77	268	finally
    //   84	90	268	finally
    //   92	103	268	finally
    //   167	174	268	finally
    //   181	194	268	finally
    //   20	32	272	java/lang/Exception
  }
  
  private FontInfo b(int paramInt)
  {
    ??? = (FontInfo)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(Integer.valueOf(paramInt));
    boolean bool1;
    Object localObject4;
    boolean bool2;
    Object localObject1;
    if (??? == null)
    {
      bool1 = a(paramInt);
      localObject4 = new File(jdField_b_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + paramInt + ".ttf");
      bool2 = ((File)localObject4).exists();
      localObject1 = ???;
      if (bool1)
      {
        localObject1 = ???;
        if (bool2) {
          localObject1 = new FontInfo(paramInt, ((File)localObject4).getAbsolutePath());
        }
      }
    }
    do
    {
      do
      {
        synchronized (jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
        {
          jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(Integer.valueOf(paramInt), localObject1);
          localObject4 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("FontManager", 2, "findFontInfo|find from local|isDownload=" + bool1 + ",fontExists=" + bool2);
            localObject4 = localObject1;
          }
          return localObject4;
        }
        localObject4 = ???;
      } while (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null);
      if (a(paramInt) == null) {
        a(jdField_b_of_type_JavaLangString);
      }
      localObject4 = ???;
    } while (!QLog.isColorLevel());
    QLog.d("FontManager", 2, "findFontInfo|find from cache");
    return ???;
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield 98	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   8: ifnonnull +7 -> 15
    //   11: iload_1
    //   12: istore_2
    //   13: iload_2
    //   14: ireturn
    //   15: new 239	java/io/File
    //   18: dup
    //   19: getstatic 77	com/etrump/mixlayout/FontManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   22: ldc 23
    //   24: invokespecial 340	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 343	java/io/File:exists	()Z
    //   32: ifeq +8 -> 40
    //   35: aload_3
    //   36: invokevirtual 411	java/io/File:delete	()Z
    //   39: pop
    //   40: new 413	java/io/RandomAccessFile
    //   43: dup
    //   44: aload_3
    //   45: ldc_w 415
    //   48: invokespecial 418	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore 4
    //   53: aload 4
    //   55: astore_3
    //   56: aload 4
    //   58: aload_0
    //   59: getfield 98	com/etrump/mixlayout/FontManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   62: invokevirtual 419	org/json/JSONArray:toString	()Ljava/lang/String;
    //   65: invokevirtual 423	java/lang/String:getBytes	()[B
    //   68: invokevirtual 427	java/io/RandomAccessFile:write	([B)V
    //   71: aload 4
    //   73: astore_3
    //   74: aload 4
    //   76: invokevirtual 428	java/io/RandomAccessFile:close	()V
    //   79: iconst_1
    //   80: istore_2
    //   81: iload_2
    //   82: istore_1
    //   83: aload 4
    //   85: ifnull +10 -> 95
    //   88: aload 4
    //   90: invokevirtual 428	java/io/RandomAccessFile:close	()V
    //   93: iload_2
    //   94: istore_1
    //   95: iload_1
    //   96: istore_2
    //   97: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq -87 -> 13
    //   103: ldc 11
    //   105: iconst_2
    //   106: new 57	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 430
    //   116: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_1
    //   120: invokevirtual 397	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload_1
    //   130: ireturn
    //   131: astore_3
    //   132: aload_3
    //   133: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   136: iload_2
    //   137: istore_1
    //   138: goto -43 -> 95
    //   141: astore 5
    //   143: aconst_null
    //   144: astore 4
    //   146: aload 4
    //   148: astore_3
    //   149: aload 5
    //   151: invokevirtual 434	java/io/FileNotFoundException:printStackTrace	()V
    //   154: iload_2
    //   155: istore_1
    //   156: aload 4
    //   158: ifnull -63 -> 95
    //   161: aload 4
    //   163: invokevirtual 428	java/io/RandomAccessFile:close	()V
    //   166: iload_2
    //   167: istore_1
    //   168: goto -73 -> 95
    //   171: astore_3
    //   172: aload_3
    //   173: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   176: iload_2
    //   177: istore_1
    //   178: goto -83 -> 95
    //   181: astore 5
    //   183: aconst_null
    //   184: astore 4
    //   186: aload 4
    //   188: astore_3
    //   189: aload 5
    //   191: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   194: iload_2
    //   195: istore_1
    //   196: aload 4
    //   198: ifnull -103 -> 95
    //   201: aload 4
    //   203: invokevirtual 428	java/io/RandomAccessFile:close	()V
    //   206: iload_2
    //   207: istore_1
    //   208: goto -113 -> 95
    //   211: astore_3
    //   212: aload_3
    //   213: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   216: iload_2
    //   217: istore_1
    //   218: goto -123 -> 95
    //   221: astore 4
    //   223: aconst_null
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 428	java/io/RandomAccessFile:close	()V
    //   233: aload 4
    //   235: athrow
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   241: goto -8 -> 233
    //   244: astore 4
    //   246: goto -21 -> 225
    //   249: astore 5
    //   251: goto -65 -> 186
    //   254: astore 5
    //   256: goto -110 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	FontManager
    //   3	215	1	bool1	boolean
    //   1	216	2	bool2	boolean
    //   27	47	3	localObject1	Object
    //   131	2	3	localIOException1	java.io.IOException
    //   148	1	3	localObject2	Object
    //   171	2	3	localIOException2	java.io.IOException
    //   188	1	3	localObject3	Object
    //   211	2	3	localIOException3	java.io.IOException
    //   224	6	3	localObject4	Object
    //   236	2	3	localIOException4	java.io.IOException
    //   51	151	4	localRandomAccessFile	java.io.RandomAccessFile
    //   221	13	4	localObject5	Object
    //   244	1	4	localObject6	Object
    //   141	9	5	localFileNotFoundException1	FileNotFoundException
    //   181	9	5	localIOException5	java.io.IOException
    //   249	1	5	localIOException6	java.io.IOException
    //   254	1	5	localFileNotFoundException2	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   88	93	131	java/io/IOException
    //   40	53	141	java/io/FileNotFoundException
    //   161	166	171	java/io/IOException
    //   40	53	181	java/io/IOException
    //   201	206	211	java/io/IOException
    //   40	53	221	finally
    //   229	233	236	java/io/IOException
    //   56	71	244	finally
    //   74	79	244	finally
    //   149	154	244	finally
    //   189	194	244	finally
    //   56	71	249	java/io/IOException
    //   74	79	249	java/io/IOException
    //   56	71	254	java/io/FileNotFoundException
    //   74	79	254	java/io/FileNotFoundException
  }
  
  public int a(int paramInt)
  {
    String str = a(paramInt);
    int m = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(false, str);
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "stopDownload  id=" + paramInt + ", ret=" + m);
    }
    return m;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = a();
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FontManager", 2, "fontFeatureSupported=" + this.jdField_a_of_type_Boolean + ",inited=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      if ((this.jdField_a_of_type_Boolean) && ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        paramChatMessage = a(paramChatMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(paramChatMessage);
          if ((paramChatMessage != null) && (paramChatMessage.uVipFont != 0L)) {
            this.e = true;
          }
        }
      }
    }
    boolean bool1;
    ExtensionInfo localExtensionInfo;
    label340:
    label345:
    label353:
    do
    {
      Object localObject;
      do
      {
        return 0;
        localObject = a(paramChatMessage);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FontManager", 2, "uin is null msg type=" + paramChatMessage.istroop);
      return 0;
      bool1 = bool2;
      if (paramChatMessage.istroop != 1)
      {
        if (paramChatMessage.istroop != 3000) {
          break label340;
        }
        bool1 = bool2;
      }
      for (;;)
      {
        try
        {
          localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a((String)localObject);
          if ((localExtensionInfo != null) && (0L != localExtensionInfo.uVipFont)) {
            break label353;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject = new StringBuilder().append("uin=").append((String)localObject).append(", fontId=");
          if (localExtensionInfo != null) {
            break label345;
          }
          paramChatMessage = null;
          QLog.i("FontManager", 2, paramChatMessage);
          return 0;
        }
        catch (Throwable paramChatMessage) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FontManager", 2, paramChatMessage.getMessage());
        return 0;
        bool1 = false;
        continue;
        paramChatMessage = Integer.valueOf(0);
      }
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) {
        throw new Exception("mEngine is null");
      }
    } while ((!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded((int)localExtensionInfo.uVipFont)) && (!a((int)localExtensionInfo.uVipFont, paramChatMessage.isSend(), bool1)));
    jdField_d_of_type_Boolean = true;
    long l1 = localExtensionInfo.uVipFont;
    return (int)l1;
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 494	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: new 239	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 389	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: aload 5
    //   18: invokevirtual 343	java/io/File:exists	()Z
    //   21: ifeq +16 -> 37
    //   24: aload 5
    //   26: invokevirtual 497	java/io/File:lastModified	()J
    //   29: aload_0
    //   30: getfield 499	com/etrump/mixlayout/FontManager:jdField_a_of_type_Long	J
    //   33: lcmp
    //   34: ifne +54 -> 88
    //   37: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +36 -> 76
    //   43: ldc 11
    //   45: iconst_2
    //   46: new 57	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   53: aload_1
    //   54: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 501
    //   60: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: getfield 168	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   67: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 168	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   80: invokevirtual 505	java/util/ArrayList:size	()I
    //   83: istore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: iload_2
    //   87: ireturn
    //   88: aload_0
    //   89: aload 5
    //   91: invokevirtual 497	java/io/File:lastModified	()J
    //   94: putfield 499	com/etrump/mixlayout/FontManager:jdField_a_of_type_Long	J
    //   97: new 165	java/util/ArrayList
    //   100: dup
    //   101: invokespecial 506	java/util/ArrayList:<init>	()V
    //   104: astore_1
    //   105: aload 5
    //   107: new 508	el
    //   110: dup
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 511	el:<init>	(Lcom/etrump/mixlayout/FontManager;Ljava/util/ArrayList;)V
    //   116: invokevirtual 515	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   119: pop
    //   120: aload_0
    //   121: getfield 168	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   124: astore 5
    //   126: aload 5
    //   128: monitorenter
    //   129: aload_0
    //   130: getfield 168	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   133: invokevirtual 518	java/util/ArrayList:clear	()V
    //   136: aload_0
    //   137: getfield 168	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   140: aload_1
    //   141: invokevirtual 522	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   144: pop
    //   145: aload 5
    //   147: monitorexit
    //   148: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +46 -> 197
    //   154: ldc 11
    //   156: iconst_2
    //   157: new 57	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 524
    //   167: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokestatic 494	java/lang/System:currentTimeMillis	()J
    //   173: lload_3
    //   174: lsub
    //   175: invokevirtual 527	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc_w 529
    //   181: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: getfield 168	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   188: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: getfield 168	com/etrump/mixlayout/FontManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   201: invokevirtual 505	java/util/ArrayList:size	()I
    //   204: istore_2
    //   205: goto -121 -> 84
    //   208: astore_1
    //   209: aload 5
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	FontManager
    //   0	219	1	paramString	String
    //   83	122	2	m	int
    //   5	169	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   129	148	208	finally
    //   209	212	208	finally
    //   2	37	214	finally
    //   37	76	214	finally
    //   76	84	214	finally
    //   88	129	214	finally
    //   148	197	214	finally
    //   197	205	214	finally
    //   212	214	214	finally
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject1 = new File(jdField_b_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return null;
      try
      {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        localObject1 = BitmapFactory.decodeStream(new FileInputStream((File)localObject1));
        if (localObject1 == null) {
          continue;
        }
        return new BitmapDrawable((Bitmap)localObject1);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FontManager", 2, localFileNotFoundException.toString());
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public FontInfo a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          FontInfo localFontInfo = (FontInfo)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          if (localFontInfo.jdField_a_of_type_Int == paramInt) {
            return localFontInfo;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      m += 1;
    }
  }
  
  public JSONObject a(int paramInt)
  {
    int m = 1;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (b(paramInt) != null)
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "本地已存在");
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("FontManager", 2, "queryInfo fontId=" + paramInt + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        Object localObject = a(paramInt);
        localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((String)localObject);
        if (localObject == null) {
          break;
        }
        switch (((DownloadTask)localObject).a())
        {
        case 0: 
        case 1: 
          localJSONObject2.put("status", 1);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", "未知状态");
          if (!((DownloadTask)localObject).b()) {
            break label425;
          }
          localJSONObject2.put("canceling", m);
          localJSONObject2.put("progress", ((DownloadTask)localObject).a);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localJSONException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "下载中");
        continue;
        localJSONException.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "下载完毕");
        continue;
        localJSONException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", "下载失败");
        continue;
        localJSONException.put("status", 1);
        localJSONException.put("progress", 0);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "未知状态");
        continue;
        continue;
        label425:
        m = 0;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramString == null) && (!DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()))) {}
    do
    {
      do
      {
        return;
      } while (b(paramInt) != null);
      DownloadTask localDownloadTask = new DownloadTask(a(paramInt), new File(jdField_c_of_type_JavaLangString, paramInt + ".zip"));
      localDownloadTask.e = this.jdField_a_of_type_Int;
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt);
      if (paramString != null)
      {
        localBundle.putInt("srcType", 2);
        localBundle.putString("callbackId", paramString);
        localDownloadTask.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("FontManager", 2, "startDownload  id=" + paramInt);
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      if (QLog.isColorLevel()) {
        QLog.i("FontManager", 2, "inited=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ",ready=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = a();
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
          break;
        }
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        ExtensionInfo localExtensionInfo = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if ((localExtensionInfo != null) && (localExtensionInfo.uVipFont != 0L)) {
          break;
        }
        paramString = localFriendsManager.a(paramString);
      } while (((paramString == null) || (paramString.uVipFont == 0L)) && (!this.e));
    } while (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
    ThreadManager.a(new ek(this));
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "Font_Mall", paramString, 0, 1, String.valueOf(paramInt), Integer.toString(NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext())), "", String.valueOf(paramLong));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("font_open_switch", 4).edit().putBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramBoolean).commit();
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean1);
      return;
    }
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean1);
  }
  
  public boolean a()
  {
    if (DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name()))
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
    }
    if (jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
    }
    this.jdField_a_of_type_Boolean = false;
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {}
    for (;;)
    {
      return false;
      int m = 0;
      while (m < this.jdField_a_of_type_OrgJsonJSONArray.length()) {
        try
        {
          int n = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(m).getInt("id");
          if (n == paramInt) {
            return true;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          m += 1;
        }
      }
    }
  }
  
  public boolean a(int paramInt, File arg2)
  {
    boolean bool2;
    if (??? == null) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      bool2 = DownloaderFactory.a(???, new File(jdField_b_of_type_JavaLangString, String.valueOf(paramInt)));
      boolean bool1 = bool2;
      FontInfo localFontInfo;
      if (bool2)
      {
        bool2 = c(paramInt);
        bool1 = bool2;
        if (bool2) {
          localFontInfo = new FontInfo(paramInt, jdField_b_of_type_JavaLangString + File.separatorChar + paramInt + File.separatorChar + paramInt + ".ttf");
        }
      }
      synchronized (jdField_a_of_type_AndroidSupportV4UtilMQLruCache)
      {
        jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(Integer.valueOf(paramInt), localFontInfo);
        bool1 = bool2;
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
        {
          a(jdField_b_of_type_JavaLangString);
          bool1 = bool2;
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FontManager", 2, "saveFont|fontId=" + paramInt + ",result=" + bool1);
        return bool1;
      }
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        boolean bool = a(paramBoolean1);
        if (bool) {
          return false;
        }
        FontInfo localFontInfo = a(paramInt);
        if (localFontInfo != null)
        {
          a(true, paramBoolean1);
          ThreadManager.a(new en(this, localFontInfo, paramBoolean1, paramInt));
          continue;
        }
        if (!paramBoolean2) {
          break label78;
        }
      }
      finally {}
      if (NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
        label78:
        a(paramInt, null);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    return this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_OrgJsonJSONArray != null)
    {
      Object localObject1 = new JSONArray();
      int m = 0;
      for (;;)
      {
        if (m >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
          break label92;
        }
        try
        {
          JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(m);
          localObject2 = localObject1;
          if (localJSONObject.getInt("id") != paramInt)
          {
            ((JSONArray)localObject1).put(localJSONObject);
            localObject2 = localObject1;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
        m += 1;
        localObject1 = localObject2;
      }
      label92:
      bool1 = bool2;
      if (localJSONException != null)
      {
        this.jdField_a_of_type_OrgJsonJSONArray = localJSONException;
        bool1 = b();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "delFontInfo|res=" + bool1 + ",fontId=" + paramInt);
    }
    return bool1;
  }
  
  public boolean c(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {}
    try
    {
      if (!a(paramInt))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", paramInt);
        localJSONObject.put("updateFlag", 0);
        this.jdField_a_of_type_OrgJsonJSONArray.put(localJSONObject);
      }
      for (bool1 = b();; bool1 = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FontManager", 2, "addFontInfo|res=" + bool1 + ",fontId=" + paramInt);
        }
        return bool1;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        bool1 = bool2;
      }
    }
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) {}
    try
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_doneEngine();
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = null;
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "onDestroy...");
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FontManager", 2, localUnsatisfiedLinkError.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager
 * JD-Core Version:    0.7.0.1
 */