package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.IMediaFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumUtil
{
  public static final int a = 170;
  public static final long a = 60000L;
  public static String a;
  public static SimpleDateFormat a;
  public static HashMap a;
  private static Map a;
  public static final int[] a;
  public static final String[] a;
  public static final int b = 170;
  public static final long b = 28835840L;
  public static String b;
  public static HashMap b;
  static String[] b;
  public static int c = 0;
  public static long c = 0L;
  public static String c;
  public static HashMap c;
  private static final String[] c;
  public static final int d = 20;
  private static long d = 0L;
  public static final String d = "album_file";
  private static final int e = 65535;
  public static final String e = "album_key_id";
  private static final int f = 65535;
  public static final String f = "album_key_name";
  private static final String g = AlbumUtil.class.getSimpleName();
  private static final String h = "_id DESC";
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_data" };
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat();
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_Long = 0L;
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("yyyy-MM-dd:HH:mm:ss:SSS");
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 3000, 1 };
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "_size", "width" };; jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "_size" })
    {
      jdField_c_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size" };
      return;
    }
  }
  
  public static int a()
  {
    return jdField_c_of_type_Int;
  }
  
  /* Error */
  public static int a(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 125	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: aload_2
    //   6: aload_3
    //   7: aload 4
    //   9: aconst_null
    //   10: invokevirtual 131	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: invokeinterface 137 1 0
    //   22: ifeq +27 -> 49
    //   25: aload_1
    //   26: astore_0
    //   27: aload_1
    //   28: iconst_0
    //   29: invokeinterface 141 2 0
    //   34: istore 5
    //   36: aload_1
    //   37: ifnull +9 -> 46
    //   40: aload_1
    //   41: invokeinterface 144 1 0
    //   46: iload 5
    //   48: ireturn
    //   49: aload_1
    //   50: ifnull +9 -> 59
    //   53: aload_1
    //   54: invokeinterface 144 1 0
    //   59: iconst_0
    //   60: ireturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +14 -> 83
    //   72: aload_1
    //   73: astore_0
    //   74: ldc 151
    //   76: iconst_2
    //   77: ldc 153
    //   79: aload_2
    //   80: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_1
    //   84: ifnull -25 -> 59
    //   87: aload_1
    //   88: invokeinterface 144 1 0
    //   93: goto -34 -> 59
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +9 -> 109
    //   103: aload_0
    //   104: invokeinterface 144 1 0
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: goto -13 -> 99
    //   115: astore_2
    //   116: goto -52 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramContext	Context
    //   0	119	1	paramUri	Uri
    //   0	119	2	paramArrayOfString1	String[]
    //   0	119	3	paramString	String
    //   0	119	4	paramArrayOfString2	String[]
    //   34	13	5	i	int
    // Exception table:
    //   from	to	target	type
    //   0	14	61	java/lang/Throwable
    //   0	14	96	finally
    //   16	25	111	finally
    //   27	36	111	finally
    //   66	72	111	finally
    //   74	83	111	finally
    //   16	25	115	java/lang/Throwable
    //   27	36	115	java/lang/Throwable
  }
  
  public static long a()
  {
    return d;
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return paramContext.getContentResolver().query((Uri)localObject, jdField_b_of_type_ArrayOfJavaLangString, paramString, paramArrayOfString, "_id DESC");
    }
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_id", null);
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    paramLocalMediaInfo.f = paramInt;
    paramLocalMediaInfo.g = paramInt;
    paramLocalMediaInfo = LocalMediaInfo.a(paramLocalMediaInfo);
    try
    {
      paramLocalMediaInfo = new URL("albumthumb", "", paramLocalMediaInfo);
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public static URL a(String paramString)
  {
    Object localObject1 = new File(paramString);
    do
    {
      try
      {
        localObject1 = ((File)localObject1).toURL();
        String str;
        Object localObject2 = localObject1;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          str = ((URL)localObject1).toString();
          localObject2 = new URL(str + "?thumb=true");
          return localObject2;
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          continue;
        }
        localMalformedURLException1 = localMalformedURLException1;
        localObject1 = null;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SelectPhotoTrace", 2, "path is:" + paramString + ",path->url failed", localMalformedURLException1);
    return localObject1;
  }
  
  /* Error */
  public static List a(Context paramContext, int paramInt1, int paramInt2, IMediaFilter paramIMediaFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iload_2
    //   4: ifgt +13 -> 17
    //   7: new 253	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 255
    //   13: invokespecial 256	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 258	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 259	java/util/ArrayList:<init>	()V
    //   24: astore 6
    //   26: getstatic 93	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 16
    //   31: if_icmplt +195 -> 226
    //   34: iconst_1
    //   35: istore 4
    //   37: iload 4
    //   39: ifeq +61 -> 100
    //   42: aload_0
    //   43: ldc_w 261
    //   46: iconst_3
    //   47: anewarray 50	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: iconst_0
    //   53: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: iload_1
    //   60: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_2
    //   66: iload_1
    //   67: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   70: aastore
    //   71: iload_2
    //   72: invokestatic 263	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   75: astore_0
    //   76: aload_0
    //   77: aload 6
    //   79: iload_1
    //   80: iload_2
    //   81: iload 4
    //   83: aload_3
    //   84: invokestatic 266	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/IMediaFilter;)V
    //   87: aload_0
    //   88: ifnull +9 -> 97
    //   91: aload_0
    //   92: invokeinterface 144 1 0
    //   97: aload 6
    //   99: areturn
    //   100: getstatic 166	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   103: invokevirtual 172	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   106: astore 7
    //   108: aload 7
    //   110: ldc 174
    //   112: iload_2
    //   113: bipush 6
    //   115: imul
    //   116: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   119: invokevirtual 184	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   122: pop
    //   123: aload 7
    //   125: invokevirtual 188	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   128: astore 7
    //   130: aload_0
    //   131: invokevirtual 125	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   134: aload 7
    //   136: getstatic 109	com/tencent/mobileqq/utils/AlbumUtil:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   139: ldc_w 268
    //   142: aconst_null
    //   143: ldc 38
    //   145: invokevirtual 131	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   148: astore_0
    //   149: goto -73 -> 76
    //   152: astore_3
    //   153: aconst_null
    //   154: astore_0
    //   155: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +15 -> 173
    //   161: getstatic 48	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   164: iconst_2
    //   165: aload_3
    //   166: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   169: aload_3
    //   170: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_0
    //   174: ifnull -77 -> 97
    //   177: aload_0
    //   178: invokeinterface 144 1 0
    //   183: aload 6
    //   185: areturn
    //   186: astore_0
    //   187: aload 5
    //   189: astore_3
    //   190: aload_3
    //   191: ifnull +9 -> 200
    //   194: aload_3
    //   195: invokeinterface 144 1 0
    //   200: aload_0
    //   201: athrow
    //   202: astore 5
    //   204: aload_0
    //   205: astore_3
    //   206: aload 5
    //   208: astore_0
    //   209: goto -19 -> 190
    //   212: astore 5
    //   214: aload_0
    //   215: astore_3
    //   216: aload 5
    //   218: astore_0
    //   219: goto -29 -> 190
    //   222: astore_3
    //   223: goto -68 -> 155
    //   226: iconst_0
    //   227: istore 4
    //   229: goto -192 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramContext	Context
    //   0	232	1	paramInt1	int
    //   0	232	2	paramInt2	int
    //   0	232	3	paramIMediaFilter	IMediaFilter
    //   35	193	4	bool	boolean
    //   1	187	5	localObject1	Object
    //   202	5	5	localObject2	Object
    //   212	5	5	localObject3	Object
    //   24	160	6	localArrayList	ArrayList
    //   106	29	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   42	76	152	java/lang/Exception
    //   100	149	152	java/lang/Exception
    //   42	76	186	finally
    //   100	149	186	finally
    //   76	87	202	finally
    //   155	173	212	finally
    //   76	87	222	java/lang/Exception
  }
  
  /* Error */
  private static List a(Context paramContext, String paramString, int paramInt, IMediaFilter paramIMediaFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 258	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 259	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 263	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 93	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 16
    //   28: if_icmplt +30 -> 58
    //   31: iconst_1
    //   32: istore 4
    //   34: aload_0
    //   35: aload 7
    //   37: iconst_m1
    //   38: iload_2
    //   39: iload 4
    //   41: aload_3
    //   42: invokestatic 266	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;IIZLcom/tencent/mobileqq/activity/photo/IMediaFilter;)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 144 1 0
    //   55: aload 7
    //   57: areturn
    //   58: iconst_0
    //   59: istore 4
    //   61: goto -27 -> 34
    //   64: astore_1
    //   65: aload 6
    //   67: astore_0
    //   68: aload_0
    //   69: astore 5
    //   71: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +18 -> 92
    //   77: aload_0
    //   78: astore 5
    //   80: getstatic 48	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   83: iconst_2
    //   84: aload_1
    //   85: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: aload_1
    //   89: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: ifnull -38 -> 55
    //   96: aload_0
    //   97: invokeinterface 144 1 0
    //   102: aload 7
    //   104: areturn
    //   105: astore_1
    //   106: aload 5
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +9 -> 119
    //   113: aload_0
    //   114: invokeinterface 144 1 0
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -13 -> 109
    //   125: astore_1
    //   126: goto -58 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   0	129	1	paramString	String
    //   0	129	2	paramInt	int
    //   0	129	3	paramIMediaFilter	IMediaFilter
    //   32	28	4	bool	boolean
    //   1	106	5	localContext	Context
    //   4	62	6	localObject	Object
    //   13	90	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   15	23	64	java/lang/Exception
    //   15	23	105	finally
    //   71	77	105	finally
    //   80	92	105	finally
    //   23	31	121	finally
    //   34	45	121	finally
    //   23	31	125	java/lang/Exception
    //   34	45	125	java/lang/Exception
  }
  
  public static List a(Context paramContext, String paramString1, String paramString2, IMediaFilter paramIMediaFilter)
  {
    if ((paramString2 == null) || ("$RecentAlbumId".equals(paramString1))) {
      paramContext = a(paramContext, -1, 100, paramIMediaFilter);
    }
    do
    {
      do
      {
        return paramContext;
        paramString1 = a(paramContext, "bucket_id='" + paramString1 + "'", -1, paramIMediaFilter);
        paramContext = paramString1;
      } while (paramString1 == null);
      paramContext = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d(g, 2, "photo list size is:" + paramString1.size());
    return paramString1;
  }
  
  private static List a(Cursor paramCursor, List paramList, int paramInt, IMediaFilter paramIMediaFilter)
  {
    if (paramCursor.getCount() <= 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("date_added");
    int i1 = paramCursor.getColumnIndexOrThrow("date_modified");
    int i2 = paramCursor.getColumnIndexOrThrow("duration");
    int i3 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i4 = paramCursor.getColumnIndexOrThrow("_size");
    int i = 0;
    label216:
    int j;
    do
    {
      do
      {
        String str;
        for (;;)
        {
          paramList = (List)localObject;
          if (!paramCursor.moveToNext()) {
            break;
          }
          paramList = paramCursor.getString(m);
          if ((!TextUtils.isEmpty(paramList)) && (new File(paramList).exists()))
          {
            str = paramCursor.getString(i3);
            if ((paramIMediaFilter == null) || (!paramIMediaFilter.filter(str))) {
              break label216;
            }
            if (QLog.isColorLevel()) {
              QLog.i(g, 2, "Filter mime type:" + str + ", path is " + paramList);
            }
          }
        }
        long l1 = paramCursor.getLong(n);
        long l2 = paramCursor.getLong(i1);
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo.jdField_a_of_type_Long = paramCursor.getLong(k);
        localLocalMediaInfo.jdField_a_of_type_JavaLangString = paramList;
        localLocalMediaInfo.jdField_b_of_type_JavaLangString = str;
        localLocalMediaInfo.jdField_c_of_type_Long = l1;
        localLocalMediaInfo.d = l2;
        localLocalMediaInfo.e = paramCursor.getLong(i2);
        localLocalMediaInfo.jdField_b_of_type_Long = paramCursor.getLong(i4);
        ((List)localObject).add(localLocalMediaInfo);
        j = i + 1;
        if (d < l2) {
          d = l2;
        }
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (j < paramInt);
    return localObject;
  }
  
  public static void a() {}
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968593, 2130968594);
  }
  
  public static void a(Activity paramActivity, Class paramClass, Intent paramIntent)
  {
    paramIntent.setClass(paramActivity, paramClass);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    a(paramActivity, true, false);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramActivity.overridePendingTransition(2130968599, 0);
      return;
    }
    paramActivity.overridePendingTransition(0, 2130968600);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a(paramActivity);
        return;
      }
      b(paramActivity);
      return;
    }
    if (paramBoolean2)
    {
      c(paramActivity);
      return;
    }
    e(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("album_file", 0).edit();
    paramContext.putString("album_key_id", jdField_b_of_type_JavaLangString);
    paramContext.putString("album_key_name", jdField_c_of_type_JavaLangString);
    paramContext.commit();
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false))
    {
      String str = paramIntent.getStringExtra("ALBUM_ID");
      paramIntent = paramIntent.getStringExtra("PhotoConst.LAST_ALBUMPATH");
      if ((paramIntent != null) && (str != null))
      {
        jdField_a_of_type_JavaLangString = paramIntent;
        jdField_c_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", paramBoolean);
      paramIntent.putExtra("ALBUM_ID", paramString1);
      paramIntent.putExtra("PhotoConst.LAST_ALBUMPATH", paramString2);
    }
  }
  
  private static void a(Cursor paramCursor, List paramList, int paramInt1, int paramInt2, boolean paramBoolean, IMediaFilter paramIMediaFilter)
  {
    Object localObject;
    int i1;
    int i2;
    int i3;
    int i5;
    int k;
    String str1;
    String str2;
    LocalMediaInfo localLocalMediaInfo;
    if (paramCursor.getCount() > 0)
    {
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      int n = paramCursor.getColumnIndexOrThrow("_data");
      i1 = paramCursor.getColumnIndexOrThrow("orientation");
      i2 = paramCursor.getColumnIndexOrThrow("date_added");
      i3 = paramCursor.getColumnIndexOrThrow("date_modified");
      int i4 = paramCursor.getColumnIndexOrThrow("mime_type");
      i5 = paramCursor.getColumnIndexOrThrow("_size");
      int j = 0;
      if (paramBoolean) {
        j = paramCursor.getColumnIndexOrThrow("width");
      }
      paramList = new BitmapFactory.Options();
      paramList.inJustDecodeBounds = true;
      int[] arrayOfInt = new int[2];
      k = 0;
      for (;;)
      {
        if (paramCursor.moveToNext())
        {
          str1 = paramCursor.getString(n);
          if ((!TextUtils.isEmpty(str1)) && (new File(str1).exists()))
          {
            str2 = paramCursor.getString(i4);
            if ((paramIMediaFilter != null) && (paramIMediaFilter.filter(str2)))
            {
              if (QLog.isColorLevel()) {
                QLog.i(g, 2, "Filter mime type:" + str2 + ", path is " + str1);
              }
            }
            else
            {
              long l1 = paramCursor.getLong(i2);
              long l2 = paramCursor.getLong(i3);
              if (d < l2) {
                d = l2;
              }
              int m = 0;
              i = m;
              if (paramBoolean)
              {
                i = m;
                if (paramCursor.getInt(j) == 0) {
                  i = 1;
                }
              }
              if ((paramInt1 <= 0) || ((paramBoolean) && (i == 0))) {
                break label445;
              }
              a(str1, paramList, arrayOfInt);
              if (arrayOfInt[0] < paramInt1)
              {
                i = k;
                if (arrayOfInt[1] < paramInt1) {
                  break;
                }
              }
              else
              {
                localLocalMediaInfo = new LocalMediaInfo();
                localLocalMediaInfo.jdField_a_of_type_JavaLangString = str1;
                localLocalMediaInfo.jdField_c_of_type_Long = l1;
                localLocalMediaInfo.d = l2;
                localLocalMediaInfo.jdField_a_of_type_Int = paramCursor.getInt(i1);
                localLocalMediaInfo.jdField_b_of_type_JavaLangString = str2;
                localLocalMediaInfo.jdField_b_of_type_Long = paramCursor.getLong(i5);
                ((List)localObject).add(localLocalMediaInfo);
              }
            }
          }
        }
      }
    }
    for (int i = k + 1;; i = k + 1)
    {
      k = i;
      if (paramInt2 <= 0) {
        break;
      }
      k = i;
      if (i < paramInt2) {
        break;
      }
      return;
      label445:
      localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.jdField_a_of_type_JavaLangString = str1;
      localLocalMediaInfo.jdField_c_of_type_Long = paramCursor.getLong(i2);
      localLocalMediaInfo.d = paramCursor.getLong(i3);
      localLocalMediaInfo.jdField_a_of_type_Int = paramCursor.getInt(i1);
      localLocalMediaInfo.jdField_b_of_type_JavaLangString = str2;
      localLocalMediaInfo.jdField_b_of_type_Long = paramCursor.getLong(i5);
      ((List)localObject).add(localLocalMediaInfo);
    }
  }
  
  private static void a(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localInteger == null) {}
    for (;;)
    {
      try
      {
        BitmapFactory.decodeFile(paramString, paramOptions);
        k = paramOptions.outWidth;
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = 0;
        continue;
      }
      try
      {
        m = paramOptions.outHeight;
        i = m;
        j = k;
        if (k <= 65535)
        {
          i = m;
          j = k;
          if (m > 65535) {}
        }
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = k;
        continue;
      }
      try
      {
        i = paramOptions.outWidth;
        j = paramOptions.outHeight;
        jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i << 16 & 0xFFFF0000 | j & 0xFFFF));
        j = k;
        i = m;
      }
      catch (OutOfMemoryError paramString)
      {
        i = m;
        j = k;
        continue;
      }
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      return;
      j = localInteger.intValue() >> 16 & 0xFFFF;
      i = localInteger.intValue() & 0xFFFF;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_name", null);
  }
  
  /* Error */
  public static List b(Context paramContext, int paramInt1, int paramInt2, IMediaFilter paramIMediaFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iload_2
    //   4: ifgt +13 -> 17
    //   7: new 253	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 255
    //   13: invokespecial 256	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 258	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 259	java/util/ArrayList:<init>	()V
    //   24: astore 5
    //   26: getstatic 484	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   29: invokevirtual 172	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   32: astore 6
    //   34: aload 6
    //   36: ldc 174
    //   38: iload_2
    //   39: bipush 6
    //   41: imul
    //   42: invokestatic 178	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   45: invokevirtual 184	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   48: pop
    //   49: aload 6
    //   51: invokevirtual 188	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   54: astore 6
    //   56: aload_0
    //   57: invokevirtual 125	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: aload 6
    //   62: getstatic 113	com/tencent/mobileqq/utils/AlbumUtil:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   65: ldc_w 268
    //   68: aconst_null
    //   69: ldc 38
    //   71: invokevirtual 131	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore_0
    //   75: aload_0
    //   76: astore 4
    //   78: aload 4
    //   80: astore_0
    //   81: aload 4
    //   83: aload 5
    //   85: iload_2
    //   86: aload_3
    //   87: invokestatic 486	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/IMediaFilter;)Ljava/util/List;
    //   90: pop
    //   91: aload 4
    //   93: ifnull +10 -> 103
    //   96: aload 4
    //   98: invokeinterface 144 1 0
    //   103: aload 5
    //   105: areturn
    //   106: astore_3
    //   107: aconst_null
    //   108: astore 4
    //   110: aload 4
    //   112: astore_0
    //   113: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +18 -> 134
    //   119: aload 4
    //   121: astore_0
    //   122: getstatic 48	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   125: iconst_2
    //   126: aload_3
    //   127: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: aload_3
    //   131: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload 4
    //   136: ifnull -33 -> 103
    //   139: aload 4
    //   141: invokeinterface 144 1 0
    //   146: aload 5
    //   148: areturn
    //   149: astore_0
    //   150: aload 4
    //   152: astore_3
    //   153: aload_3
    //   154: ifnull +9 -> 163
    //   157: aload_3
    //   158: invokeinterface 144 1 0
    //   163: aload_0
    //   164: athrow
    //   165: astore 4
    //   167: aload_0
    //   168: astore_3
    //   169: aload 4
    //   171: astore_0
    //   172: goto -19 -> 153
    //   175: astore_3
    //   176: goto -66 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramContext	Context
    //   0	179	1	paramInt1	int
    //   0	179	2	paramInt2	int
    //   0	179	3	paramIMediaFilter	IMediaFilter
    //   1	150	4	localContext	Context
    //   165	5	4	localObject1	Object
    //   24	123	5	localArrayList	ArrayList
    //   32	29	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	75	106	java/lang/Exception
    //   26	75	149	finally
    //   81	91	165	finally
    //   113	119	165	finally
    //   122	134	165	finally
    //   81	91	175	java/lang/Exception
  }
  
  /* Error */
  public static List b(Context paramContext, String paramString1, String paramString2, IMediaFilter paramIMediaFilter)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: ldc_w 273
    //   7: aload_1
    //   8: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +14 -> 25
    //   14: aload_0
    //   15: sipush 210
    //   18: bipush 100
    //   20: aload_3
    //   21: invokestatic 488	com/tencent/mobileqq/utils/AlbumUtil:b	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/IMediaFilter;)Ljava/util/List;
    //   24: areturn
    //   25: new 258	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 259	java/util/ArrayList:<init>	()V
    //   32: astore 4
    //   34: new 235	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 281
    //   44: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 283
    //   54: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 125	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   65: getstatic 484	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   68: getstatic 113	com/tencent/mobileqq/utils/AlbumUtil:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   71: aload_1
    //   72: aconst_null
    //   73: ldc 38
    //   75: invokevirtual 131	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: aload 4
    //   84: iconst_m1
    //   85: aload_3
    //   86: invokestatic 486	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/database/Cursor;Ljava/util/List;ILcom/tencent/mobileqq/activity/photo/IMediaFilter;)Ljava/util/List;
    //   89: pop
    //   90: aload_1
    //   91: ifnull +72 -> 163
    //   94: aload_1
    //   95: invokeinterface 144 1 0
    //   100: aload 4
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +16 -> 127
    //   114: aload_1
    //   115: astore_0
    //   116: getstatic 48	com/tencent/mobileqq/utils/AlbumUtil:g	Ljava/lang/String;
    //   119: iconst_2
    //   120: ldc_w 490
    //   123: aload_2
    //   124: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_1
    //   128: ifnull +35 -> 163
    //   131: aload_1
    //   132: invokeinterface 144 1 0
    //   137: aload 4
    //   139: areturn
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +9 -> 153
    //   147: aload_0
    //   148: invokeinterface 144 1 0
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: goto -13 -> 143
    //   159: astore_2
    //   160: goto -54 -> 106
    //   163: aload 4
    //   165: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramContext	Context
    //   0	166	1	paramString1	String
    //   0	166	2	paramString2	String
    //   0	166	3	paramIMediaFilter	IMediaFilter
    //   32	132	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   61	79	103	java/lang/Exception
    //   61	79	140	finally
    //   81	90	155	finally
    //   108	114	155	finally
    //   116	127	155	finally
    //   81	90	159	java/lang/Exception
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaLangString = null;
    jdField_c_of_type_Long = 0L;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
  }
  
  private static void b(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968589, 2130968591);
  }
  
  public static void b(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a(paramActivity);
        return;
      }
      b(paramActivity);
      return;
    }
    if (paramBoolean2)
    {
      d(paramActivity);
      return;
    }
    f(paramActivity);
  }
  
  public static List c(Context paramContext, String paramString1, String paramString2, IMediaFilter paramIMediaFilter)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    if (paramIMediaFilter != null)
    {
      localObject1 = localObject2;
      if (paramIMediaFilter.showImage()) {
        localObject1 = a(paramContext, paramString1, paramString2, paramIMediaFilter);
      }
    }
    localObject2 = localObject3;
    if (paramIMediaFilter != null)
    {
      localObject2 = localObject3;
      if (paramIMediaFilter.showVideo()) {
        localObject2 = b(paramContext, paramString1, paramString2, paramIMediaFilter);
      }
    }
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      return localObject1;
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return localObject2;
    }
    int i = ((List)localObject1).size();
    int j = 0;
    int k = 0;
    int m;
    if (k < ((List)localObject2).size())
    {
      paramContext = (LocalMediaInfo)((List)localObject2).get(k);
      paramString1 = (LocalMediaInfo)((List)localObject1).get(i - 1);
      if (paramContext.jdField_c_of_type_Long <= paramString1.jdField_c_of_type_Long)
      {
        if (i < 100)
        {
          j = Math.min(((List)localObject2).size() - k, 100 - i);
          i = 0;
          while (i < j)
          {
            ((List)localObject1).add(((List)localObject2).get(i + k));
            i += 1;
          }
        }
      }
      else
      {
        m = j;
        while (m < i)
        {
          paramString1 = (LocalMediaInfo)((List)localObject1).get(m);
          if (paramContext.jdField_c_of_type_Long <= paramString1.jdField_c_of_type_Long)
          {
            m += 1;
          }
          else
          {
            ((List)localObject1).add(m, paramContext);
            if (((List)localObject1).size() > 100) {
              ((List)localObject1).remove(i);
            }
            int n = ((List)localObject1).size();
            j = i;
            if (i != n) {
              j = n;
            }
            i = m + 1;
          }
        }
      }
    }
    for (;;)
    {
      k += 1;
      m = j;
      j = i;
      i = m;
      break;
      return localObject1;
      m = i;
      i = j;
      j = m;
    }
  }
  
  public static void c()
  {
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  private static void c(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968586, 2130968588);
  }
  
  private static void d(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968587, 2130968588);
  }
  
  private static void e(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968583, 2130968584);
  }
  
  private static void f(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968583, 2130968585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AlbumUtil
 * JD-Core Version:    0.7.0.1
 */