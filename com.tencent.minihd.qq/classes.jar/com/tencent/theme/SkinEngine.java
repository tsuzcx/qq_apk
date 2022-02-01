package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinEngine
{
  public static final String ACTION_THEME_INVALIDATE = "com.tencent.qplus.THEME_INVALIDATE";
  public static final String ACTION_THEME_UPDATE = "com.tencent.qplus.THEME_UPDATE";
  public static final String ASSET_PATH = "/asset/";
  public static boolean DEBUG = false;
  public static boolean IS_PROBLEM_CM11 = false;
  public static boolean IS_PROBLEM_MIUI = false;
  public static final String KEY_PENDING_THEME = "pending_theme_root";
  public static final String KEY_PENDING_THEME_RESOURCES_IS_COMPLIED = "pending_theme_resources_complied";
  public static final String KEY_RESOURCES_IS_COMPLIED = "complied";
  public static final String KEY_THEME = "theme_root";
  public static final String PREFERENCE_NAME = "theme";
  public static boolean SWITCH_DEBUG = false;
  public static final String TAG = "SkinEngine";
  public static final String TAG_SWITCH = "SkinEngine.switch";
  public static final int TYPE_FILE = 16777215;
  public static final int TYPE_RESOURCES = 3;
  static boolean a;
  static final String[][] c;
  static final int[][] d;
  static int e;
  static int f;
  static int g;
  static int h;
  static int i;
  private static SkinEngine l;
  public static Field mComposedIconInfoOfCM;
  public static Integer mIconResourceID;
  public static Field mIconsOfCM;
  final TypedValue b = new TypedValue();
  public HashMap<Integer, BackupForOOMData> backupForOOMData;
  SkinEngineHandler j;
  BroadcastReceiver k = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateReceiver.onReceive ACTION_THEME_UPDATE");
      }
      try
      {
        new SkinEngine.a(SkinEngine.this, null).execute(new Context[] { paramAnonymousContext });
        return;
      }
      catch (RejectedExecutionException paramAnonymousContext) {}
    }
  };
  private boolean m = false;
  public Resources mResources;
  private boolean n = true;
  private final LongSparseArray<WeakReference<b>> o = new LongSparseArray();
  private final LongSparseArray<WeakReference<SkinnableColorStateList>> p = new LongSparseArray();
  private String q;
  private String r;
  private int s = g;
  private g t;
  private d u;
  private e v;
  private HashMap<String, Object> w;
  private HashMap<String, Object> x;
  
  static
  {
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      IS_PROBLEM_MIUI = false;
      mIconsOfCM = null;
      mComposedIconInfoOfCM = null;
      IS_PROBLEM_CM11 = false;
      mIconResourceID = null;
      Object localObject1 = { "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
      Object localObject2 = { "drawable-hdpi/", "drawable-xhdpi/", "drawable-mdpi/", "drawable/" };
      Object localObject3 = { "drawable-ldpi/", "drawable-mdpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable/" };
      c = new String[][] { localObject1, localObject2, { "drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/" }, localObject3, { "drawable-xxhdpi", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" } };
      localObject1 = new int[] { 320, 240, 160, 160 };
      localObject2 = new int[] { 160, 160, 240, 320 };
      localObject3 = new int[] { 480, 320, 240, 160, 160 };
      d = new int[][] { localObject1, { 240, 320, 160, 160 }, localObject2, { 120, 160, 240, 320, 160 }, localObject3 };
      e = 0;
      f = 1;
      g = 2;
      h = 3;
      i = 4;
      return;
    }
  }
  
  private static int a(Resources paramResources)
  {
    switch (paramResources.getDisplayMetrics().densityDpi)
    {
    default: 
      return g;
    case 320: 
      return e;
    case 240: 
      return f;
    case 120: 
      return h;
    }
    return i;
  }
  
  private XmlResourceParser a(int paramInt, TypedValue paramTypedValue)
    throws IOException
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if (paramTypedValue.type == 3) {
      return this.mResources.getAssets().openXmlResourceParser(paramTypedValue.assetCookie, paramTypedValue.string.toString());
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(paramTypedValue.type) + " is not valid");
  }
  
  /* Error */
  private b a(int paramInt, Resources paramResources, j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 176	com/tencent/theme/SkinEngine:b	Landroid/util/TypedValue;
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: new 275	android/graphics/Rect
    //   12: dup
    //   13: invokespecial 276	android/graphics/Rect:<init>	()V
    //   16: astore 13
    //   18: aload_3
    //   19: getfield 280	com/tencent/theme/j:b	Ljava/lang/String;
    //   22: astore 14
    //   24: aload 14
    //   26: ifnull +410 -> 436
    //   29: aload 14
    //   31: ldc_w 282
    //   34: invokevirtual 286	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   37: istore 6
    //   39: iload 6
    //   41: ifne +395 -> 436
    //   44: aload_0
    //   45: aload_2
    //   46: aload 14
    //   48: invokespecial 289	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   51: astore 9
    //   53: new 291	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 292	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 15
    //   62: aload 15
    //   64: aload_3
    //   65: getfield 294	com/tencent/theme/j:c	I
    //   68: putfield 297	android/graphics/BitmapFactory$Options:inDensity	I
    //   71: aload_2
    //   72: aconst_null
    //   73: aload 9
    //   75: aload_3
    //   76: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   79: aload 15
    //   81: aload 13
    //   83: aload_0
    //   84: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   87: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   90: astore 7
    //   92: aload 9
    //   94: invokevirtual 309	java/io/InputStream:close	()V
    //   97: aload 7
    //   99: ifnull +337 -> 436
    //   102: aload 12
    //   104: monitorexit
    //   105: aload 7
    //   107: areturn
    //   108: astore 7
    //   110: aload_0
    //   111: getfield 311	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   114: ifnull +1000 -> 1114
    //   117: aload_0
    //   118: getfield 311	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   121: aload 7
    //   123: aload_3
    //   124: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   127: iconst_1
    //   128: invokeinterface 317 4 0
    //   133: ifeq +981 -> 1114
    //   136: aload 9
    //   138: invokevirtual 309	java/io/InputStream:close	()V
    //   141: aload_0
    //   142: aload_2
    //   143: aload 14
    //   145: invokespecial 289	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   148: astore 9
    //   150: aload_2
    //   151: aconst_null
    //   152: aload 9
    //   154: aload_3
    //   155: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   158: aload 15
    //   160: aload 13
    //   162: aload_0
    //   163: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   166: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   169: astore 7
    //   171: goto -79 -> 92
    //   174: astore 7
    //   176: aload_0
    //   177: getfield 311	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   180: aload 7
    //   182: aload_3
    //   183: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   186: iconst_1
    //   187: invokeinterface 320 4 0
    //   192: ifeq +200 -> 392
    //   195: aload 15
    //   197: iconst_1
    //   198: putfield 323	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   201: aload 9
    //   203: invokevirtual 309	java/io/InputStream:close	()V
    //   206: aload_0
    //   207: aload_2
    //   208: aload 14
    //   210: invokespecial 289	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   213: astore 10
    //   215: aload_2
    //   216: aconst_null
    //   217: aload 10
    //   219: aload_3
    //   220: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   223: aload 15
    //   225: aload 13
    //   227: aload_0
    //   228: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   231: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   234: astore 11
    //   236: aload_0
    //   237: getfield 325	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   240: ifnull +904 -> 1144
    //   243: aload_0
    //   244: getfield 325	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   247: iload_1
    //   248: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokevirtual 334	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   254: ifeq +890 -> 1144
    //   257: aload_0
    //   258: getfield 325	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   261: iload_1
    //   262: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: invokevirtual 338	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   268: ifnull +876 -> 1144
    //   271: iconst_1
    //   272: istore 4
    //   274: iload 4
    //   276: ifeq +857 -> 1133
    //   279: aconst_null
    //   280: astore 7
    //   282: aload_0
    //   283: getfield 325	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   286: iload_1
    //   287: invokestatic 329	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: invokevirtual 338	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   293: checkcast 8	com/tencent/theme/SkinEngine$BackupForOOMData
    //   296: astore 9
    //   298: aload 15
    //   300: getfield 341	android/graphics/BitmapFactory$Options:outWidth	I
    //   303: bipush 8
    //   305: idiv
    //   306: aload 15
    //   308: getfield 344	android/graphics/BitmapFactory$Options:outHeight	I
    //   311: bipush 8
    //   313: idiv
    //   314: invokestatic 350	java/lang/Math:min	(II)I
    //   317: bipush 8
    //   319: invokestatic 353	java/lang/Math:max	(II)I
    //   322: istore 5
    //   324: iconst_2
    //   325: istore 4
    //   327: iload 4
    //   329: iload 5
    //   331: if_icmpgt +29 -> 360
    //   334: aload_0
    //   335: aload_2
    //   336: aload_3
    //   337: aload 15
    //   339: aload 13
    //   341: aload_0
    //   342: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   345: aload 9
    //   347: iload 4
    //   349: iconst_0
    //   350: invokevirtual 356	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Lcom/tencent/theme/j;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/b;
    //   353: astore 7
    //   355: aload 7
    //   357: ifnull +793 -> 1150
    //   360: aload 7
    //   362: astore 8
    //   364: aload 7
    //   366: ifnonnull +754 -> 1120
    //   369: aload_0
    //   370: aload_2
    //   371: aload_3
    //   372: aload 15
    //   374: aload 13
    //   376: aload_0
    //   377: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   380: aload 9
    //   382: iconst_1
    //   383: iconst_1
    //   384: invokevirtual 356	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Lcom/tencent/theme/j;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/b;
    //   387: astore 8
    //   389: goto +731 -> 1120
    //   392: aload 7
    //   394: athrow
    //   395: astore 7
    //   397: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   400: ifeq +36 -> 436
    //   403: ldc 46
    //   405: new 246	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   412: ldc_w 358
    //   415: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 14
    //   420: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc_w 360
    //   426: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 365	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   435: pop
    //   436: aload_3
    //   437: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   440: ldc_w 282
    //   443: invokevirtual 286	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   446: istore 6
    //   448: iload 6
    //   450: ifeq +190 -> 640
    //   453: aload_0
    //   454: iload_1
    //   455: aload_0
    //   456: getfield 176	com/tencent/theme/SkinEngine:b	Landroid/util/TypedValue;
    //   459: invokespecial 367	com/tencent/theme/SkinEngine:a	(ILandroid/util/TypedValue;)Landroid/content/res/XmlResourceParser;
    //   462: astore 8
    //   464: aload 14
    //   466: ifnull +86 -> 552
    //   469: aload_0
    //   470: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   473: ifeq +71 -> 544
    //   476: new 369	com/tencent/theme/a
    //   479: dup
    //   480: invokespecial 370	com/tencent/theme/a:<init>	()V
    //   483: astore 7
    //   485: new 372	java/io/FileInputStream
    //   488: dup
    //   489: aload 14
    //   491: invokespecial 373	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   494: astore 9
    //   496: aload 7
    //   498: aload 9
    //   500: ldc_w 375
    //   503: invokeinterface 381 3 0
    //   508: aload_2
    //   509: aload 8
    //   511: aload 7
    //   513: aload_0
    //   514: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   517: invokestatic 384	com/tencent/theme/i:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/b;
    //   520: astore_2
    //   521: aload 9
    //   523: invokevirtual 385	java/io/FileInputStream:close	()V
    //   526: aload 8
    //   528: invokeinterface 388 1 0
    //   533: aload 12
    //   535: monitorexit
    //   536: aload_2
    //   537: areturn
    //   538: astore_2
    //   539: aload 12
    //   541: monitorexit
    //   542: aload_2
    //   543: athrow
    //   544: invokestatic 394	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   547: astore 7
    //   549: goto -64 -> 485
    //   552: aload_2
    //   553: aload 8
    //   555: aconst_null
    //   556: aload_0
    //   557: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   560: invokestatic 384	com/tencent/theme/i:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/b;
    //   563: astore_2
    //   564: aload 8
    //   566: invokeinterface 388 1 0
    //   571: aload 12
    //   573: monitorexit
    //   574: aload_2
    //   575: areturn
    //   576: astore_2
    //   577: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   580: ifeq +55 -> 635
    //   583: new 244	android/content/res/Resources$NotFoundException
    //   586: dup
    //   587: new 246	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   594: ldc_w 396
    //   597: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_3
    //   601: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   604: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: ldc_w 398
    //   610: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: iload_1
    //   614: invokestatic 259	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   617: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokespecial 267	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   626: astore_3
    //   627: aload_3
    //   628: aload_2
    //   629: invokevirtual 402	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   632: pop
    //   633: aload_3
    //   634: athrow
    //   635: aload 12
    //   637: monitorexit
    //   638: aconst_null
    //   639: areturn
    //   640: getstatic 132	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   643: istore 6
    //   645: iload 6
    //   647: ifeq +100 -> 747
    //   650: getstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   653: iconst_1
    //   654: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   657: getstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   660: aload_0
    //   661: getfield 212	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   664: aconst_null
    //   665: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   668: getstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   671: iconst_1
    //   672: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   675: getstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   678: aload_0
    //   679: getfield 212	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   682: aconst_null
    //   683: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   686: getstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   689: iconst_1
    //   690: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   693: getstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   696: iconst_1
    //   697: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   700: getstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   703: aload_0
    //   704: getfield 212	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   707: invokevirtual 413	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   710: ifnull +37 -> 747
    //   713: getstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   716: aload_0
    //   717: getfield 212	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   720: invokevirtual 413	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   723: astore 7
    //   725: aload 7
    //   727: ifnull +20 -> 747
    //   730: aload 12
    //   732: monitorexit
    //   733: aconst_null
    //   734: areturn
    //   735: astore_2
    //   736: aload 12
    //   738: monitorexit
    //   739: aconst_null
    //   740: areturn
    //   741: astore_2
    //   742: aload 12
    //   744: monitorexit
    //   745: aconst_null
    //   746: areturn
    //   747: aload_0
    //   748: getfield 176	com/tencent/theme/SkinEngine:b	Landroid/util/TypedValue;
    //   751: astore 10
    //   753: aload_2
    //   754: iload_1
    //   755: aload 10
    //   757: invokevirtual 417	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   760: astore 8
    //   762: aload 10
    //   764: getfield 230	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   767: invokeinterface 236 1 0
    //   772: astore 11
    //   774: aload 8
    //   776: astore 7
    //   778: new 291	android/graphics/BitmapFactory$Options
    //   781: dup
    //   782: invokespecial 292	android/graphics/BitmapFactory$Options:<init>	()V
    //   785: astore 14
    //   787: aload 8
    //   789: astore 7
    //   791: aload_2
    //   792: aload 10
    //   794: aload 8
    //   796: aload 11
    //   798: aload 14
    //   800: aload 13
    //   802: iconst_1
    //   803: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   806: astore 9
    //   808: aload 9
    //   810: astore_2
    //   811: aload 8
    //   813: astore 7
    //   815: aload 8
    //   817: invokevirtual 309	java/io/InputStream:close	()V
    //   820: aload_2
    //   821: ifnonnull +33 -> 854
    //   824: aload 8
    //   826: astore 7
    //   828: aload_0
    //   829: getfield 311	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   832: ifnull +22 -> 854
    //   835: aload 8
    //   837: astore 7
    //   839: aload_0
    //   840: getfield 311	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   843: aload_3
    //   844: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   847: iconst_0
    //   848: invokeinterface 421 3 0
    //   853: pop
    //   854: aload 12
    //   856: monitorexit
    //   857: aload_2
    //   858: areturn
    //   859: astore_2
    //   860: aload 12
    //   862: monitorexit
    //   863: aconst_null
    //   864: areturn
    //   865: astore 9
    //   867: aload 8
    //   869: astore 7
    //   871: aload_0
    //   872: getfield 311	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   875: ifnull +234 -> 1109
    //   878: aload 8
    //   880: astore 7
    //   882: aload_0
    //   883: getfield 311	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   886: aload 9
    //   888: aload_3
    //   889: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   892: iconst_0
    //   893: invokeinterface 317 4 0
    //   898: ifeq +211 -> 1109
    //   901: aload 8
    //   903: astore 7
    //   905: aload 8
    //   907: invokevirtual 309	java/io/InputStream:close	()V
    //   910: aload 8
    //   912: astore 7
    //   914: aload_2
    //   915: iload_1
    //   916: aload 10
    //   918: invokevirtual 417	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   921: astore 8
    //   923: aload 8
    //   925: astore 7
    //   927: aload_2
    //   928: aload 10
    //   930: aload 8
    //   932: aload 11
    //   934: aload 14
    //   936: aload 13
    //   938: iconst_1
    //   939: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   942: astore 9
    //   944: aload 9
    //   946: astore_2
    //   947: goto -136 -> 811
    //   950: astore 9
    //   952: aload 8
    //   954: astore 7
    //   956: aload_0
    //   957: getfield 311	com/tencent/theme/SkinEngine:j	Lcom/tencent/theme/SkinEngineHandler;
    //   960: aload 9
    //   962: aload_3
    //   963: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   966: iconst_0
    //   967: invokeinterface 320 4 0
    //   972: ifeq +49 -> 1021
    //   975: aload 8
    //   977: astore 7
    //   979: aload 14
    //   981: iconst_1
    //   982: putfield 323	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   985: aload 8
    //   987: astore 7
    //   989: aload_2
    //   990: iload_1
    //   991: aload 10
    //   993: invokevirtual 417	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   996: astore 8
    //   998: aload 8
    //   1000: astore 7
    //   1002: aload_2
    //   1003: aload 10
    //   1005: aload 8
    //   1007: aload 11
    //   1009: aload 14
    //   1011: aload 13
    //   1013: iconst_1
    //   1014: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   1017: astore_2
    //   1018: goto -207 -> 811
    //   1021: aload 8
    //   1023: astore 7
    //   1025: aload 9
    //   1027: athrow
    //   1028: astore_2
    //   1029: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1032: ifeq +72 -> 1104
    //   1035: new 244	android/content/res/Resources$NotFoundException
    //   1038: dup
    //   1039: new 246	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 396
    //   1049: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload_3
    //   1053: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   1056: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: ldc_w 398
    //   1062: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: iload_1
    //   1066: invokestatic 259	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1069: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: ldc_w 423
    //   1075: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload 7
    //   1080: invokevirtual 427	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1083: invokevirtual 432	java/lang/Class:getName	()Ljava/lang/String;
    //   1086: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: invokespecial 267	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   1095: astore_3
    //   1096: aload_3
    //   1097: aload_2
    //   1098: invokevirtual 402	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1101: pop
    //   1102: aload_3
    //   1103: athrow
    //   1104: aload 12
    //   1106: monitorexit
    //   1107: aconst_null
    //   1108: areturn
    //   1109: aconst_null
    //   1110: astore_2
    //   1111: goto -300 -> 811
    //   1114: aconst_null
    //   1115: astore 7
    //   1117: goto -1025 -> 92
    //   1120: aload 8
    //   1122: astore 7
    //   1124: aload 10
    //   1126: astore 9
    //   1128: aload 8
    //   1130: ifnonnull -1038 -> 92
    //   1133: aload 11
    //   1135: astore 7
    //   1137: aload 10
    //   1139: astore 9
    //   1141: goto -1049 -> 92
    //   1144: iconst_0
    //   1145: istore 4
    //   1147: goto -873 -> 274
    //   1150: iload 4
    //   1152: iconst_2
    //   1153: imul
    //   1154: istore 4
    //   1156: goto -829 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1159	0	this	SkinEngine
    //   0	1159	1	paramInt	int
    //   0	1159	2	paramResources	Resources
    //   0	1159	3	paramj	j
    //   272	883	4	i1	int
    //   322	10	5	i2	int
    //   37	609	6	bool	boolean
    //   90	16	7	localb1	b
    //   108	14	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   169	1	7	localb2	b
    //   174	7	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   280	113	7	localb3	b
    //   395	1	7	localIOException	IOException
    //   483	653	7	localObject1	Object
    //   362	767	8	localObject2	Object
    //   51	758	9	localObject3	Object
    //   865	22	9	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   942	3	9	localb4	b
    //   950	76	9	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1126	14	9	localObject4	Object
    //   213	925	10	localObject5	Object
    //   234	900	11	localObject6	Object
    //   4	1101	12	localTypedValue	TypedValue
    //   16	996	13	localRect	Rect
    //   22	988	14	localObject7	Object
    //   60	313	15	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   71	92	108	java/lang/OutOfMemoryError
    //   150	171	174	java/lang/OutOfMemoryError
    //   44	71	395	java/io/IOException
    //   71	92	395	java/io/IOException
    //   92	97	395	java/io/IOException
    //   110	150	395	java/io/IOException
    //   150	171	395	java/io/IOException
    //   176	271	395	java/io/IOException
    //   282	324	395	java/io/IOException
    //   334	355	395	java/io/IOException
    //   369	389	395	java/io/IOException
    //   392	395	395	java/io/IOException
    //   9	24	538	finally
    //   29	39	538	finally
    //   44	71	538	finally
    //   71	92	538	finally
    //   92	97	538	finally
    //   102	105	538	finally
    //   110	150	538	finally
    //   150	171	538	finally
    //   176	271	538	finally
    //   282	324	538	finally
    //   334	355	538	finally
    //   369	389	538	finally
    //   392	395	538	finally
    //   397	436	538	finally
    //   436	448	538	finally
    //   453	464	538	finally
    //   469	485	538	finally
    //   485	533	538	finally
    //   533	536	538	finally
    //   539	542	538	finally
    //   544	549	538	finally
    //   552	571	538	finally
    //   571	574	538	finally
    //   577	635	538	finally
    //   635	638	538	finally
    //   640	645	538	finally
    //   650	686	538	finally
    //   686	725	538	finally
    //   730	733	538	finally
    //   736	739	538	finally
    //   742	745	538	finally
    //   747	753	538	finally
    //   753	762	538	finally
    //   762	774	538	finally
    //   778	787	538	finally
    //   791	808	538	finally
    //   815	820	538	finally
    //   828	835	538	finally
    //   839	854	538	finally
    //   854	857	538	finally
    //   860	863	538	finally
    //   871	878	538	finally
    //   882	901	538	finally
    //   905	910	538	finally
    //   914	923	538	finally
    //   927	944	538	finally
    //   956	975	538	finally
    //   979	985	538	finally
    //   989	998	538	finally
    //   1002	1018	538	finally
    //   1025	1028	538	finally
    //   1029	1104	538	finally
    //   1104	1107	538	finally
    //   453	464	576	java/lang/Exception
    //   469	485	576	java/lang/Exception
    //   485	533	576	java/lang/Exception
    //   544	549	576	java/lang/Exception
    //   552	571	576	java/lang/Exception
    //   650	686	735	java/lang/Exception
    //   686	725	741	java/lang/Exception
    //   753	762	859	java/lang/Exception
    //   791	808	865	java/lang/OutOfMemoryError
    //   927	944	950	java/lang/OutOfMemoryError
    //   778	787	1028	java/io/IOException
    //   791	808	1028	java/io/IOException
    //   815	820	1028	java/io/IOException
    //   828	835	1028	java/io/IOException
    //   839	854	1028	java/io/IOException
    //   871	878	1028	java/io/IOException
    //   882	901	1028	java/io/IOException
    //   905	910	1028	java/io/IOException
    //   914	923	1028	java/io/IOException
    //   927	944	1028	java/io/IOException
    //   956	975	1028	java/io/IOException
    //   979	985	1028	java/io/IOException
    //   989	998	1028	java/io/IOException
    //   1002	1018	1028	java/io/IOException
    //   1025	1028	1028	java/io/IOException
  }
  
  private String a(Resources paramResources, String paramString)
  {
    paramString = this.q + "color/" + paramString;
    try
    {
      if (paramString.startsWith("/asset/"))
      {
        paramResources.getAssets().open(paramString.substring("/asset/".length())).close();
        return paramString;
      }
      boolean bool = new File(paramString).exists();
      if (bool) {
        return paramString;
      }
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        if (DEBUG) {
          Log.w("SkinEngine", paramResources);
        }
      }
    }
    return null;
    return paramString;
  }
  
  private HashMap<String, Object> a(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i1;
    do
    {
      i1 = paramXmlPullParser.next();
    } while ((i1 != 2) && (i1 != 1));
    if (i1 != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    String str1 = paramXmlPullParser.getName();
    HashMap localHashMap = new HashMap();
    if (str1.equals("resources"))
    {
      i1 = paramXmlPullParser.getDepth();
      for (;;)
      {
        int i2 = paramXmlPullParser.next();
        if ((i2 == 1) || ((paramXmlPullParser.getDepth() < i1 + 1) && (i2 == 3))) {
          break;
        }
        if (i2 == 2)
        {
          String str2 = paramXmlPullParser.getName();
          str1 = paramXmlPullParser.getAttributeValue(null, "name");
          if ("color".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Color.parseColor(paramXmlPullParser.nextText())));
          }
          else if ("dimen".equals(str2))
          {
            str2 = paramXmlPullParser.nextText();
            if (str2.endsWith("dp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("dip")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 3)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("sp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(2, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("px")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(0, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            }
          }
          else if ("bool".equals(str2))
          {
            localHashMap.put(str1, Boolean.valueOf("true".equalsIgnoreCase(paramXmlPullParser.nextText())));
          }
          else if ("integer".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Integer.parseInt(paramXmlPullParser.nextText())));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(Resources paramResources, TypedValue paramTypedValue, String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i1 = 0;
    while (i1 < paramArrayOfInt.length) {
      try
      {
        String str = this.q + paramArrayOfString[i1] + paramString;
        if (str.startsWith("/asset/"))
        {
          paramResources.getAssets().open(str.substring("/asset/".length())).close();
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
        if (new File(str).exists())
        {
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
      }
      catch (IOException localIOException)
      {
        if (DEBUG) {
          Log.w("SkinEngine", localIOException);
        }
        i1 += 1;
      }
    }
    paramTypedValue.string = null;
    paramTypedValue.density = 0;
  }
  
  /* Error */
  private void a(Resources paramResources, Class paramClass1, int[] paramArrayOfInt, int paramInt1, Class paramClass2, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +12 -> 13
    //   4: aload_2
    //   5: ifnull +90 -> 95
    //   8: iload 4
    //   10: ifeq +85 -> 95
    //   13: ldc 198
    //   15: ldc_w 557
    //   18: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   21: astore 8
    //   23: aload 8
    //   25: iconst_1
    //   26: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   29: aload 8
    //   31: aload_1
    //   32: invokevirtual 413	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore 9
    //   37: aload 9
    //   39: instanceof 189
    //   42: ifeq +292 -> 334
    //   45: aload_3
    //   46: ifnull +245 -> 291
    //   49: aload_0
    //   50: new 563	com/tencent/theme/g
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: aload_3
    //   57: aload 7
    //   59: iconst_1
    //   60: anewarray 189	android/util/LongSparseArray
    //   63: dup
    //   64: iconst_0
    //   65: aload 9
    //   67: checkcast 189	android/util/LongSparseArray
    //   70: aastore
    //   71: invokespecial 566	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   74: putfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   77: aload 8
    //   79: aload_1
    //   80: new 570	com/tencent/theme/h
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: getfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   89: invokespecial 573	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   92: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   95: aload 5
    //   97: ifnull +64 -> 161
    //   100: iload 6
    //   102: ifeq +59 -> 161
    //   105: ldc 198
    //   107: ldc_w 575
    //   110: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   113: astore_2
    //   114: aload_2
    //   115: iconst_1
    //   116: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 413	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 189	android/util/LongSparseArray
    //   127: astore_3
    //   128: getstatic 124	com/tencent/theme/SkinEngine:a	Z
    //   131: ifeq +314 -> 445
    //   134: aload_0
    //   135: new 577	com/tencent/theme/f
    //   138: dup
    //   139: aload_0
    //   140: aload_1
    //   141: aload_3
    //   142: aload 5
    //   144: iload 6
    //   146: invokespecial 580	com/tencent/theme/f:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   149: putfield 582	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   152: aload_2
    //   153: aload_1
    //   154: aload_0
    //   155: getfield 582	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   158: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   161: aload_1
    //   162: invokevirtual 427	java/lang/Object:getClass	()Ljava/lang/Class;
    //   165: astore_2
    //   166: aload_2
    //   167: invokevirtual 432	java/lang/Class:getName	()Ljava/lang/String;
    //   170: ldc_w 584
    //   173: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifeq +40 -> 216
    //   179: aload_2
    //   180: ldc_w 586
    //   183: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   186: astore_2
    //   187: aload_2
    //   188: iconst_1
    //   189: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   192: aload_2
    //   193: aload_1
    //   194: invokevirtual 413	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   197: ifnonnull +19 -> 216
    //   200: aload_2
    //   201: aload_1
    //   202: new 588	android/util/SparseArray
    //   205: dup
    //   206: invokespecial 589	android/util/SparseArray:<init>	()V
    //   209: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   212: iconst_1
    //   213: putstatic 126	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   216: aload_1
    //   217: invokevirtual 427	java/lang/Object:getClass	()Ljava/lang/Class;
    //   220: ldc_w 591
    //   223: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   226: putstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   229: getstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   232: iconst_1
    //   233: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   236: getstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   239: aload_1
    //   240: aconst_null
    //   241: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   244: getstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   247: iconst_0
    //   248: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   251: aload_1
    //   252: invokevirtual 427	java/lang/Object:getClass	()Ljava/lang/Class;
    //   255: ldc_w 593
    //   258: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   261: putstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   264: getstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   267: iconst_1
    //   268: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   271: getstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   274: aload_1
    //   275: aconst_null
    //   276: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   279: getstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   282: iconst_0
    //   283: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   286: iconst_1
    //   287: putstatic 132	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   290: return
    //   291: aload_0
    //   292: new 563	com/tencent/theme/g
    //   295: dup
    //   296: aload_0
    //   297: aload_1
    //   298: aload_2
    //   299: iload 4
    //   301: aload 7
    //   303: iconst_1
    //   304: anewarray 189	android/util/LongSparseArray
    //   307: dup
    //   308: iconst_0
    //   309: aload 9
    //   311: checkcast 189	android/util/LongSparseArray
    //   314: aastore
    //   315: invokespecial 596	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Ljava/lang/Class;ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   318: putfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   321: goto -244 -> 77
    //   324: astore_1
    //   325: new 549	com/tencent/theme/UnSupportPlatformException
    //   328: dup
    //   329: aload_1
    //   330: invokespecial 599	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   333: athrow
    //   334: aload 9
    //   336: instanceof 601
    //   339: ifeq -244 -> 95
    //   342: aload 9
    //   344: checkcast 601	[Landroid/util/LongSparseArray;
    //   347: checkcast 601	[Landroid/util/LongSparseArray;
    //   350: astore 8
    //   352: aload_3
    //   353: ifnull +59 -> 412
    //   356: aload_0
    //   357: new 563	com/tencent/theme/g
    //   360: dup
    //   361: aload_0
    //   362: aload_1
    //   363: aload_3
    //   364: aload 7
    //   366: aload 8
    //   368: invokespecial 566	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   371: putfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   374: goto +251 -> 625
    //   377: iload 4
    //   379: aload 8
    //   381: arraylength
    //   382: if_icmpge -287 -> 95
    //   385: aload 8
    //   387: iload 4
    //   389: new 570	com/tencent/theme/h
    //   392: dup
    //   393: iload 4
    //   395: aload_0
    //   396: getfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   399: invokespecial 573	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   402: aastore
    //   403: iload 4
    //   405: iconst_1
    //   406: iadd
    //   407: istore 4
    //   409: goto -32 -> 377
    //   412: aload_0
    //   413: new 563	com/tencent/theme/g
    //   416: dup
    //   417: aload_0
    //   418: aload_1
    //   419: aload_2
    //   420: iload 4
    //   422: aload 7
    //   424: aload 8
    //   426: invokespecial 596	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Ljava/lang/Class;ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   429: putfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   432: goto +193 -> 625
    //   435: astore_1
    //   436: new 549	com/tencent/theme/UnSupportPlatformException
    //   439: dup
    //   440: aload_1
    //   441: invokespecial 599	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   444: athrow
    //   445: aload_0
    //   446: new 603	com/tencent/theme/d
    //   449: dup
    //   450: aload_0
    //   451: aload_1
    //   452: aload_3
    //   453: aload 5
    //   455: iload 6
    //   457: invokespecial 604	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   460: putfield 582	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   463: goto -311 -> 152
    //   466: astore_2
    //   467: ldc 198
    //   469: ldc_w 606
    //   472: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   475: astore_3
    //   476: aload_3
    //   477: iconst_1
    //   478: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   481: aload_3
    //   482: aload_1
    //   483: invokevirtual 413	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   486: astore 7
    //   488: aload 7
    //   490: instanceof 588
    //   493: ifeq +47 -> 540
    //   496: aload_0
    //   497: new 608	com/tencent/theme/e
    //   500: dup
    //   501: aload_0
    //   502: aload_1
    //   503: aload 7
    //   505: checkcast 588	android/util/SparseArray
    //   508: aload 5
    //   510: iload 6
    //   512: invokespecial 611	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/SparseArray;Ljava/lang/Class;I)V
    //   515: putfield 613	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/e;
    //   518: aload_3
    //   519: aload_1
    //   520: aload_0
    //   521: getfield 613	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/e;
    //   524: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   527: goto -366 -> 161
    //   530: astore_1
    //   531: new 549	com/tencent/theme/UnSupportPlatformException
    //   534: dup
    //   535: aload_1
    //   536: invokespecial 599	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   539: athrow
    //   540: aload 7
    //   542: instanceof 189
    //   545: ifeq +37 -> 582
    //   548: aload_0
    //   549: new 603	com/tencent/theme/d
    //   552: dup
    //   553: aload_0
    //   554: aload_1
    //   555: aload 7
    //   557: checkcast 189	android/util/LongSparseArray
    //   560: aload 5
    //   562: iload 6
    //   564: invokespecial 604	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;Ljava/lang/Class;I)V
    //   567: putfield 582	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   570: aload_3
    //   571: aload_1
    //   572: aload_0
    //   573: getfield 582	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   576: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   579: goto -418 -> 161
    //   582: new 549	com/tencent/theme/UnSupportPlatformException
    //   585: dup
    //   586: aload_2
    //   587: invokespecial 599	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   590: athrow
    //   591: astore_2
    //   592: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   595: ifeq +13 -> 608
    //   598: ldc 46
    //   600: ldc_w 615
    //   603: aload_2
    //   604: invokestatic 618	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   607: pop
    //   608: iconst_0
    //   609: putstatic 126	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   612: goto -396 -> 216
    //   615: astore_1
    //   616: aconst_null
    //   617: putstatic 128	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   620: aconst_null
    //   621: putstatic 130	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   624: return
    //   625: iconst_0
    //   626: istore 4
    //   628: goto -251 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	SkinEngine
    //   0	631	1	paramResources	Resources
    //   0	631	2	paramClass1	Class
    //   0	631	3	paramArrayOfInt	int[]
    //   0	631	4	paramInt1	int
    //   0	631	5	paramClass2	Class
    //   0	631	6	paramInt2	int
    //   0	631	7	paramFile	File
    //   21	404	8	localObject1	Object
    //   35	308	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	45	324	java/lang/IllegalArgumentException
    //   49	77	324	java/lang/IllegalArgumentException
    //   77	95	324	java/lang/IllegalArgumentException
    //   105	152	324	java/lang/IllegalArgumentException
    //   152	161	324	java/lang/IllegalArgumentException
    //   291	321	324	java/lang/IllegalArgumentException
    //   334	352	324	java/lang/IllegalArgumentException
    //   356	374	324	java/lang/IllegalArgumentException
    //   377	403	324	java/lang/IllegalArgumentException
    //   412	432	324	java/lang/IllegalArgumentException
    //   445	463	324	java/lang/IllegalArgumentException
    //   467	527	324	java/lang/IllegalArgumentException
    //   540	579	324	java/lang/IllegalArgumentException
    //   582	591	324	java/lang/IllegalArgumentException
    //   13	45	435	java/lang/NoSuchFieldException
    //   49	77	435	java/lang/NoSuchFieldException
    //   77	95	435	java/lang/NoSuchFieldException
    //   105	152	435	java/lang/NoSuchFieldException
    //   152	161	435	java/lang/NoSuchFieldException
    //   291	321	435	java/lang/NoSuchFieldException
    //   334	352	435	java/lang/NoSuchFieldException
    //   356	374	435	java/lang/NoSuchFieldException
    //   377	403	435	java/lang/NoSuchFieldException
    //   412	432	435	java/lang/NoSuchFieldException
    //   445	463	435	java/lang/NoSuchFieldException
    //   467	527	435	java/lang/NoSuchFieldException
    //   540	579	435	java/lang/NoSuchFieldException
    //   582	591	435	java/lang/NoSuchFieldException
    //   105	152	466	java/lang/Exception
    //   152	161	466	java/lang/Exception
    //   445	463	466	java/lang/Exception
    //   13	45	530	java/lang/IllegalAccessException
    //   49	77	530	java/lang/IllegalAccessException
    //   77	95	530	java/lang/IllegalAccessException
    //   105	152	530	java/lang/IllegalAccessException
    //   152	161	530	java/lang/IllegalAccessException
    //   291	321	530	java/lang/IllegalAccessException
    //   334	352	530	java/lang/IllegalAccessException
    //   356	374	530	java/lang/IllegalAccessException
    //   377	403	530	java/lang/IllegalAccessException
    //   412	432	530	java/lang/IllegalAccessException
    //   445	463	530	java/lang/IllegalAccessException
    //   467	527	530	java/lang/IllegalAccessException
    //   540	579	530	java/lang/IllegalAccessException
    //   582	591	530	java/lang/IllegalAccessException
    //   161	216	591	java/lang/Exception
    //   216	290	615	java/lang/Exception
  }
  
  private void a(b paramb)
  {
    Object localObject1 = paramb.d;
    Object localObject2 = ((j)localObject1).b;
    if (this.q != null)
    {
      a(this.mResources, this.b, ((j)localObject1).d, c[this.s], d[this.s]);
      if (this.b.string != null)
      {
        ((j)localObject1).b = this.b.string.toString();
        ((j)localObject1).c = this.b.density;
        if ((localObject2 != null) || (((j)localObject1).b != null) || (((j)localObject1).d.endsWith(".xml"))) {
          break label127;
        }
      }
    }
    label127:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ((j)localObject1).b = null;
            break;
            ((j)localObject1).b = null;
            break;
            if (!(paramb instanceof SkinnableBitmapDrawable.a)) {
              break label353;
            }
            paramb = (SkinnableBitmapDrawable.a)paramb;
            localObject2 = a(((j)localObject1).a, this.mResources, (j)localObject1);
            if (localObject2 != null) {
              break label207;
            }
          } while (!DEBUG);
          throw new NullPointerException("loadImage failed, file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
          if ((DEBUG) && ((localObject2 instanceof SkinnableNinePatchDrawable.a))) {
            throw new IllegalArgumentException("error image, the resource Image is Bitmap, but the skin Image is 9-path, file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
          }
          localObject1 = (SkinnableBitmapDrawable.a)localObject2;
          paramb.g = ((SkinnableBitmapDrawable.a)localObject1).g;
          paramb.c = ((SkinnableBitmapDrawable.a)localObject1).c;
          paramb.e = ((SkinnableBitmapDrawable.a)localObject1).e;
          paramb.f = ((SkinnableBitmapDrawable.a)localObject1).f;
        } while ((!paramb.n) && (!((SkinnableBitmapDrawable.a)localObject1).n));
        paramb.i = ((SkinnableBitmapDrawable.a)localObject1).i;
        paramb.j = ((SkinnableBitmapDrawable.a)localObject1).j;
        paramb.k = ((SkinnableBitmapDrawable.a)localObject1).k;
        paramb.l = ((SkinnableBitmapDrawable.a)localObject1).l;
        paramb.n = true;
        return;
      } while (!(paramb instanceof SkinnableNinePatchDrawable.a));
      paramb = (SkinnableNinePatchDrawable.a)paramb;
      localObject2 = a(((j)localObject1).a, this.mResources, (j)localObject1);
      if (localObject2 != null) {
        break label433;
      }
    } while (!DEBUG);
    label207:
    label353:
    throw new NullPointerException("loadImage failed, file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
    label433:
    if ((DEBUG) && ((localObject2 instanceof SkinnableBitmapDrawable.a))) {
      throw new IllegalArgumentException("error image, the resource Image is 9-path, but the skin Image is Bitmap, did you compiled the 9-pathflie to apk and un-zip it? file path: " + ((j)localObject1).b + " , resource name:" + ((j)localObject1).d);
    }
    localObject1 = (SkinnableNinePatchDrawable.a)localObject2;
    paramb.f = ((SkinnableNinePatchDrawable.a)localObject1).f;
    paramb.g = ((SkinnableNinePatchDrawable.a)localObject1).g;
    paramb.i = paramb.h;
    paramb.h = ((SkinnableNinePatchDrawable.a)localObject1).h;
    paramb.m = ((SkinnableNinePatchDrawable.a)localObject1).m;
    paramb.e = ((SkinnableNinePatchDrawable.a)localObject1).e;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.w == null) {}
    try
    {
      XmlResourceParser localXmlResourceParser = this.mResources.getAssets().openXmlResourceParser("res/xml/theme_config.xml");
      this.w = a(localXmlResourceParser);
      localXmlResourceParser.close();
      if (this.x == null)
      {
        if (this.q == null) {
          this.x = new HashMap();
        }
      }
      else {
        return;
      }
    }
    catch (XmlPullParserException localXmlPullParserException1)
    {
      localObject = new Resources.NotFoundException("wrong xml config file: res/xml/theme_config.xml");
      ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException1);
      throw ((Throwable)localObject);
    }
    catch (IOException localIOException1)
    {
      Object localObject;
      for (;;)
      {
        this.w = new HashMap();
      }
      if (paramBoolean) {}
      try
      {
        a locala = new a();
        localObject = new FileInputStream(new File(this.q, "xml/theme_config.xml"));
        locala.setInput((InputStream)localObject, "UTF-8");
        this.x = a(locala);
        ((FileInputStream)localObject).close();
        return;
      }
      catch (XmlPullParserException localXmlPullParserException2)
      {
        for (;;)
        {
          localObject = new Resources.NotFoundException("wrong theme xml config file: xml/theme_config.xml");
          ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException2);
          throw ((Throwable)localObject);
          XmlPullParser localXmlPullParser = Xml.newPullParser();
        }
      }
      catch (IOException localIOException2)
      {
        this.x = new HashMap();
      }
    }
  }
  
  private SkinnableColorStateList b(int paramInt, Resources paramResources, j paramj)
  {
    Object localObject;
    synchronized (this.b)
    {
      localObject = paramj.b;
      if (localObject != null)
      {
        bool = ((String)localObject).endsWith(".xml");
        if (bool)
        {
          try
          {
            SkinnableColorStateList localSkinnableColorStateList = i.a(this, paramResources, new File((String)localObject), this.n);
            return localSkinnableColorStateList;
          }
          catch (Exception localException)
          {
            if (!DEBUG) {
              break label126;
            }
          }
          paramResources = new Resources.NotFoundException("File " + (String)localObject + " from Skin ColorState resource ID #0x" + Integer.toHexString(paramInt));
          paramResources.initCause(localException);
          throw paramResources;
        }
      }
    }
    label126:
    paramj = paramj.d;
    boolean bool = paramj.endsWith(".xml");
    if (bool) {
      try
      {
        localObject = a(paramInt, this.b);
        paramResources = SkinnableColorStateList.createFromXml(this, paramResources, (XmlPullParser)localObject, true);
        ((XmlResourceParser)localObject).close();
        return paramResources;
      }
      catch (Exception paramResources)
      {
        paramj = new Resources.NotFoundException("File " + paramj + " from Skin ColorList list resource ID #0x" + Integer.toHexString(paramInt));
        paramj.initCause(paramResources);
        throw paramj;
      }
    }
    throw new Resources.NotFoundException("File " + paramj + " from Skin ColorList resource ID #0x" + Integer.toHexString(paramInt) + ": .xml extension required");
  }
  
  private InputStream b(Resources paramResources, String paramString)
    throws IOException, FileNotFoundException
  {
    if (paramString.startsWith("/asset/"))
    {
      paramString = paramString.substring("/asset/".length());
      return paramResources.getAssets().open(paramString);
    }
    return new FileInputStream(new File(paramString));
  }
  
  @TargetApi(16)
  private void b(Context paramContext)
  {
    paramContext = this.b;
    int i1 = 0;
    for (;;)
    {
      j localj;
      try
      {
        if (i1 >= this.p.size()) {
          break label150;
        }
        SkinnableColorStateList localSkinnableColorStateList = (SkinnableColorStateList)((WeakReference)this.p.valueAt(i1)).get();
        if (localSkinnableColorStateList == null) {
          break label153;
        }
        localj = localSkinnableColorStateList.skinData;
        String str1 = localj.b;
        if (this.q != null)
        {
          String str2 = a(this.mResources, localj.d);
          if (str2 != null)
          {
            localj.b = str2;
            if ((str1 != null) || (localj.b != null)) {
              break label128;
            }
            break label153;
          }
          localj.b = null;
          continue;
        }
        localj.b = null;
      }
      finally {}
      continue;
      label128:
      localObject.a(b(localj.a, this.mResources, localj));
      break label153;
      label150:
      return;
      label153:
      i1 += 1;
    }
  }
  
  @TargetApi(16)
  private void c(Context arg1)
  {
    for (;;)
    {
      int i1;
      synchronized (this.b)
      {
        ArrayList localArrayList = new ArrayList();
        i1 = 0;
        if (i1 < this.o.size())
        {
          b localb = (b)((WeakReference)this.o.valueAt(i1)).get();
          if (localb == null) {
            break label126;
          }
          if (localb.d.d.endsWith(".xml")) {
            localArrayList.add(localb);
          } else {
            a(localb);
          }
        }
      }
      Iterator localIterator = localObject.iterator();
      while (localIterator.hasNext()) {
        a((b)localIterator.next());
      }
      return;
      label126:
      i1 += 1;
    }
  }
  
  public static SkinEngine getInstances()
  {
    try
    {
      if (l == null) {
        l = new SkinEngine();
      }
      SkinEngine localSkinEngine = l;
      return localSkinEngine;
    }
    finally {}
  }
  
  public static void init(Context paramContext, Class paramClass1, int paramInt1, Class paramClass2, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.s = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.k, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.a(localResources, paramClass1, null, paramInt1, paramClass2, paramInt2, paramFile);
    paramContext = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.q = paramContext.getString("theme_root", null);
    localSkinEngine.n = paramContext.getBoolean("complied", true);
  }
  
  public static void init(Context paramContext, int[] paramArrayOfInt, Class paramClass, int paramInt, File paramFile)
    throws UnSupportPlatformException
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.s = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.k, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.a(localResources, null, paramArrayOfInt, 0, paramClass, paramInt, paramFile);
    paramContext = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.q = paramContext.getString("theme_root", null);
    localSkinEngine.n = paramContext.getBoolean("complied", true);
  }
  
  public static void invalidateAll(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i2;
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      localObject = (ViewGroup)paramView;
      i2 = ((ViewGroup)localObject).getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        invalidateAll(((ViewGroup)localObject).getChildAt(i1));
        i1 += 1;
      }
    }
    Object localObject = paramView.getBackground();
    Rect localRect;
    if (localObject != null)
    {
      if (!(localObject instanceof DrawableContainer)) {
        break label270;
      }
      localRect = new Rect();
      ((Drawable)localObject).getPadding(localRect);
      if ((localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
      {
        SkinnableActivityProcesser.a((Drawable)localObject);
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    else
    {
      if ((paramView instanceof SkinnableView)) {
        ((SkinnableView)paramView).onThemeChanged();
      }
      if (!(paramView instanceof ImageView)) {
        break label428;
      }
      localObject = ((ImageView)paramView).getDrawable();
      SkinnableActivityProcesser.a((Drawable)localObject);
      ((ImageView)paramView).setImageDrawable(null);
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView.destroyDrawingCache();
      paramView.refreshDrawableState();
      paramView.invalidate();
      paramView.requestLayout();
      return;
      i1 = paramView.getPaddingTop();
      i2 = paramView.getPaddingBottom();
      int i3 = paramView.getPaddingLeft();
      int i4 = paramView.getPaddingRight();
      SkinnableActivityProcesser.a((Drawable)localObject);
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      paramView.setPadding(i3, i1, i4, i2);
      break;
      label270:
      if ((localObject instanceof SkinnableNinePatchDrawable))
      {
        localRect = new Rect();
        if ((((SkinnableNinePatchDrawable)localObject).a(localRect)) && (localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
        {
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject);
          break;
        }
        i1 = paramView.getPaddingTop();
        i2 = paramView.getPaddingBottom();
        i3 = paramView.getPaddingLeft();
        i4 = paramView.getPaddingRight();
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
        paramView.setPadding(i3, i1, i4, i2);
        break;
      }
      if (!(localObject instanceof SkinnableBitmapDrawable)) {
        break;
      }
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      break;
      label428:
      if ((paramView instanceof TextView))
      {
        localObject = ((TextView)paramView).getCompoundDrawables();
        if ((localObject[0] != null) || (localObject[1] != null) || (localObject[2] != null) || (localObject[3] != null))
        {
          ((TextView)paramView).setCompoundDrawables(null, null, null, null);
          ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(localObject[0], localObject[1], localObject[2], localObject[3]);
        }
      }
    }
  }
  
  public static void isSupportPlatform(Context paramContext, Resources paramResources)
    throws UnSupportPlatformException
  {
    try
    {
      localObject = Resources.class.getDeclaredField("sPreloadedDrawables");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramResources);
      if ((!(localObject instanceof LongSparseArray)) && (!(localObject instanceof LongSparseArray[]))) {
        throw new UnSupportPlatformException("sPreloadedDrawables is not LongSparseArray");
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      Object localObject;
      throw new UnSupportPlatformException(paramContext);
      try
      {
        localObject = Resources.class.getDeclaredField("sPreloadedColorStateLists");
        ((Field)localObject).setAccessible(true);
        if (!(((Field)localObject).get(paramResources) instanceof LongSparseArray)) {
          throw new UnSupportPlatformException("sPreloadedColorStateLists is not LongSparseArray");
        }
      }
      catch (Exception localException)
      {
        Field localField = Resources.class.getDeclaredField("mPreloadedColorStateLists");
        localField.setAccessible(true);
        paramResources = localField.get(paramResources);
        boolean bool = paramResources instanceof SparseArray;
        if (bool) {}
        while (l.a(paramContext, "ro.lewa.version").equalsIgnoreCase("LeWa_OS6.0_14.10.22"))
        {
          throw new UnSupportPlatformException("lewa is not supported");
          if (!(paramResources instanceof LongSparseArray)) {
            throw new UnSupportPlatformException(localException);
          }
        }
      }
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new UnSupportPlatformException(paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new UnSupportPlatformException(paramContext);
    }
  }
  
  @TargetApi(16)
  Drawable.ConstantState a(int paramInt)
  {
    synchronized (this.b)
    {
      Object localObject1 = (WeakReference)this.o.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (Drawable.ConstantState)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return localObject1;
        }
        this.o.delete(paramInt);
      }
      boolean bool = IS_PROBLEM_CM11;
      if (bool) {
        try
        {
          mIconsOfCM.setAccessible(true);
          mIconsOfCM.set(this.mResources, null);
          mComposedIconInfoOfCM.setAccessible(true);
          mComposedIconInfoOfCM.set(this.mResources, null);
          this.mResources.getValue(paramInt, this.b, true);
        }
        catch (Exception localException1)
        {
          try
          {
            mIconsOfCM.setAccessible(true);
            mComposedIconInfoOfCM.setAccessible(true);
            if (mIconsOfCM.get(this.mResources) == null) {
              break label159;
            }
            localObject1 = mComposedIconInfoOfCM.get(this.mResources);
            if (localObject1 == null) {
              break label159;
            }
            return null;
          }
          catch (Exception localException2)
          {
            return null;
          }
          localException1 = localException1;
          return null;
        }
      }
      label159:
      Object localObject3 = this.b.string.toString();
      j localj = new j();
      localj.a = paramInt;
      localj.d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
      if (this.q != null)
      {
        a(this.mResources, this.b, localj.d, c[this.s], d[this.s]);
        if (this.b.string != null)
        {
          localj.b = this.b.string.toString();
          localj.c = this.b.density;
        }
      }
      localObject3 = a(paramInt, this.mResources, localj);
      if (localObject3 != null)
      {
        ((b)localObject3).d = localj;
        this.o.put(paramInt, new WeakReference(localObject3));
      }
      return localObject3;
    }
  }
  
  /* Error */
  b a(Resources paramResources, j paramj, android.graphics.BitmapFactory.Options paramOptions, Rect paramRect, boolean paramBoolean1, BackupForOOMData paramBackupForOOMData, int paramInt, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iload 8
    //   2: ifeq +371 -> 373
    //   5: new 173	android/util/TypedValue
    //   8: dup
    //   9: invokespecial 174	android/util/TypedValue:<init>	()V
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 212	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   17: aload 6
    //   19: getfield 961	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   22: aload_2
    //   23: iconst_1
    //   24: invokevirtual 216	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   27: aload_2
    //   28: getfield 230	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   31: invokeinterface 236 1 0
    //   36: astore 9
    //   38: new 278	com/tencent/theme/j
    //   41: dup
    //   42: invokespecial 947	com/tencent/theme/j:<init>	()V
    //   45: astore_3
    //   46: aload_3
    //   47: aload 6
    //   49: getfield 961	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   52: putfield 633	com/tencent/theme/j:a	I
    //   55: aload_3
    //   56: aload 9
    //   58: aload 9
    //   60: ldc_w 949
    //   63: invokevirtual 952	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   66: iconst_1
    //   67: iadd
    //   68: invokevirtual 447	java/lang/String:substring	(I)Ljava/lang/String;
    //   71: putfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   74: aload_0
    //   75: getfield 435	com/tencent/theme/SkinEngine:q	Ljava/lang/String;
    //   78: ifnull +60 -> 138
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 212	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   86: aload_2
    //   87: aload_3
    //   88: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   91: getstatic 150	com/tencent/theme/SkinEngine:c	[[Ljava/lang/String;
    //   94: aload_0
    //   95: getfield 182	com/tencent/theme/SkinEngine:s	I
    //   98: aaload
    //   99: getstatic 154	com/tencent/theme/SkinEngine:d	[[I
    //   102: aload_0
    //   103: getfield 182	com/tencent/theme/SkinEngine:s	I
    //   106: aaload
    //   107: invokespecial 629	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   110: aload_2
    //   111: getfield 230	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   114: ifnull +24 -> 138
    //   117: aload_3
    //   118: aload_2
    //   119: getfield 230	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   122: invokeinterface 236 1 0
    //   127: putfield 280	com/tencent/theme/j:b	Ljava/lang/String;
    //   130: aload_3
    //   131: aload_2
    //   132: getfield 546	android/util/TypedValue:density	I
    //   135: putfield 294	com/tencent/theme/j:c	I
    //   138: aload_3
    //   139: getfield 280	com/tencent/theme/j:b	Ljava/lang/String;
    //   142: ifnull +127 -> 269
    //   145: new 275	android/graphics/Rect
    //   148: dup
    //   149: invokespecial 276	android/graphics/Rect:<init>	()V
    //   152: astore_2
    //   153: new 291	android/graphics/BitmapFactory$Options
    //   156: dup
    //   157: invokespecial 292	android/graphics/BitmapFactory$Options:<init>	()V
    //   160: astore 9
    //   162: aload 9
    //   164: aload_3
    //   165: getfield 294	com/tencent/theme/j:c	I
    //   168: putfield 297	android/graphics/BitmapFactory$Options:inDensity	I
    //   171: aload 9
    //   173: aload 6
    //   175: getfield 965	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   178: putfield 966	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   181: aload_0
    //   182: aload_1
    //   183: aload_3
    //   184: getfield 280	com/tencent/theme/j:b	Ljava/lang/String;
    //   187: invokespecial 289	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   190: astore 4
    //   192: aload_1
    //   193: aconst_null
    //   194: aload 4
    //   196: aload_3
    //   197: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   200: aload 9
    //   202: aload_2
    //   203: aload_0
    //   204: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   207: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   210: astore_2
    //   211: aload_2
    //   212: astore_1
    //   213: aload 4
    //   215: invokevirtual 309	java/io/InputStream:close	()V
    //   218: aload_2
    //   219: astore_3
    //   220: aload_3
    //   221: areturn
    //   222: astore_1
    //   223: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   226: ifeq +38 -> 264
    //   229: ldc 46
    //   231: new 246	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 968
    //   241: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_3
    //   245: getfield 280	com/tencent/theme/j:b	Ljava/lang/String;
    //   248: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 970
    //   254: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 365	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   263: pop
    //   264: aconst_null
    //   265: astore_2
    //   266: goto -55 -> 211
    //   269: aload_1
    //   270: aload 6
    //   272: getfield 961	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   275: aload_2
    //   276: invokevirtual 417	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   279: astore_3
    //   280: aload_2
    //   281: getfield 230	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   284: invokeinterface 236 1 0
    //   289: astore 6
    //   291: new 291	android/graphics/BitmapFactory$Options
    //   294: dup
    //   295: invokespecial 292	android/graphics/BitmapFactory$Options:<init>	()V
    //   298: astore 9
    //   300: aload_1
    //   301: aload_2
    //   302: aload_3
    //   303: aload 6
    //   305: aload 9
    //   307: aload 4
    //   309: iconst_1
    //   310: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   313: astore_2
    //   314: aload_3
    //   315: invokevirtual 309	java/io/InputStream:close	()V
    //   318: aload_2
    //   319: areturn
    //   320: astore_1
    //   321: aload_2
    //   322: astore_3
    //   323: aload_2
    //   324: astore_1
    //   325: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   328: ifeq -108 -> 220
    //   331: aload_2
    //   332: astore_1
    //   333: ldc 46
    //   335: ldc_w 972
    //   338: invokestatic 365	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   341: pop
    //   342: aload_2
    //   343: areturn
    //   344: astore_2
    //   345: aload_1
    //   346: astore_3
    //   347: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   350: ifeq -130 -> 220
    //   353: ldc 46
    //   355: ldc_w 974
    //   358: invokestatic 365	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   361: pop
    //   362: aload_1
    //   363: areturn
    //   364: astore_1
    //   365: aconst_null
    //   366: areturn
    //   367: astore_1
    //   368: aconst_null
    //   369: astore_2
    //   370: goto -56 -> 314
    //   373: aload_0
    //   374: aload_1
    //   375: aload_2
    //   376: getfield 280	com/tencent/theme/j:b	Ljava/lang/String;
    //   379: invokespecial 289	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   382: astore 9
    //   384: aload_3
    //   385: iconst_0
    //   386: putfield 323	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   389: aload_3
    //   390: aload 6
    //   392: getfield 965	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   395: putfield 966	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   398: aload_3
    //   399: iload 7
    //   401: putfield 977	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   404: aload_1
    //   405: aconst_null
    //   406: aload 9
    //   408: aload_2
    //   409: getfield 299	com/tencent/theme/j:d	Ljava/lang/String;
    //   412: aload_3
    //   413: aload 4
    //   415: aload_0
    //   416: getfield 180	com/tencent/theme/SkinEngine:n	Z
    //   419: invokestatic 304	com/tencent/theme/i:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   422: astore_1
    //   423: aload_1
    //   424: astore_2
    //   425: aload_2
    //   426: astore_1
    //   427: aload 9
    //   429: invokevirtual 309	java/io/InputStream:close	()V
    //   432: aload_2
    //   433: areturn
    //   434: astore_1
    //   435: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   438: ifeq +38 -> 476
    //   441: ldc 46
    //   443: new 246	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 979
    //   453: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_2
    //   457: getfield 280	com/tencent/theme/j:b	Ljava/lang/String;
    //   460: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: ldc_w 970
    //   466: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 365	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   475: pop
    //   476: aconst_null
    //   477: astore_2
    //   478: goto -53 -> 425
    //   481: astore_1
    //   482: aconst_null
    //   483: astore_1
    //   484: goto -139 -> 345
    //   487: astore_1
    //   488: aconst_null
    //   489: astore_2
    //   490: goto -169 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	SkinEngine
    //   0	493	1	paramResources	Resources
    //   0	493	2	paramj	j
    //   0	493	3	paramOptions	android.graphics.BitmapFactory.Options
    //   0	493	4	paramRect	Rect
    //   0	493	5	paramBoolean1	boolean
    //   0	493	6	paramBackupForOOMData	BackupForOOMData
    //   0	493	7	paramInt	int
    //   0	493	8	paramBoolean2	boolean
    //   36	392	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   192	211	222	java/lang/OutOfMemoryError
    //   314	318	320	java/io/IOException
    //   213	218	344	java/io/IOException
    //   325	331	344	java/io/IOException
    //   333	342	344	java/io/IOException
    //   427	432	344	java/io/IOException
    //   269	280	364	java/lang/Exception
    //   300	314	367	java/lang/OutOfMemoryError
    //   404	423	434	java/lang/OutOfMemoryError
    //   5	138	481	java/io/IOException
    //   138	192	481	java/io/IOException
    //   192	211	481	java/io/IOException
    //   223	264	481	java/io/IOException
    //   269	280	481	java/io/IOException
    //   280	291	481	java/io/IOException
    //   373	404	481	java/io/IOException
    //   404	423	481	java/io/IOException
    //   435	476	481	java/io/IOException
    //   291	300	487	java/io/IOException
    //   300	314	487	java/io/IOException
  }
  
  void a(Context paramContext)
  {
    boolean bool = true;
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "update start");
    }
    this.m = true;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    String str = localSharedPreferences.getString("pending_theme_root", null);
    if (str != null) {
      bool = localSharedPreferences.getBoolean("pending_theme_resources_complied", true);
    }
    synchronized (this.b)
    {
      this.r = this.q;
      this.q = str;
      this.n = bool;
      c(paramContext);
      b(paramContext);
      localSharedPreferences.edit().putString("theme_root", str).putBoolean("complied", this.n).commit();
      this.m = false;
      this.r = null;
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "update done");
      }
      return;
    }
  }
  
  public void addBackupForOOMData(Integer paramInteger, BackupForOOMData paramBackupForOOMData)
  {
    if (this.backupForOOMData == null) {
      this.backupForOOMData = new HashMap();
    }
    this.backupForOOMData.put(paramInteger, paramBackupForOOMData);
  }
  
  public final void addDrawableResource(int paramInt)
  {
    this.t.a(this.mResources, paramInt);
  }
  
  @TargetApi(16)
  SkinnableColorStateList b(int paramInt)
  {
    synchronized (this.b)
    {
      Object localObject1 = (WeakReference)this.p.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (SkinnableColorStateList)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return localObject1;
        }
        this.p.delete(paramInt);
      }
      this.mResources.getValue(paramInt, this.b, true);
      Object localObject3 = this.b.string.toString();
      if (((String)localObject3).endsWith(".xml"))
      {
        localObject1 = new j();
        ((j)localObject1).a = paramInt;
        ((j)localObject1).d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
        if (this.q != null) {
          ((j)localObject1).b = a(this.mResources, ((j)localObject1).d);
        }
        localObject3 = b(paramInt, this.mResources, (j)localObject1);
        ((SkinnableColorStateList)localObject3).skinData = ((j)localObject1);
        this.p.put(paramInt, new WeakReference(localObject3));
        return localObject3;
      }
    }
    return null;
  }
  
  public int getColor(int paramInt)
  {
    synchronized (this.b)
    {
      TypedValue localTypedValue2 = this.b;
      this.mResources.getValue(paramInt, localTypedValue2, true);
      if ((localTypedValue2.type >= 16) && (localTypedValue2.type <= 31))
      {
        paramInt = localTypedValue2.data;
        return paramInt;
      }
      if (localTypedValue2.type == 3)
      {
        paramInt = b(paramInt).getDefaultColor();
        return paramInt;
      }
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(localObject.type) + " is not valid");
  }
  
  public String getSkinRootPath()
  {
    if (this.m) {
      return this.r;
    }
    return this.q;
  }
  
  public Object getThemeConfig(String paramString, Object paramObject)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (this.b)
      {
        a(this.n);
        Object localObject2 = this.x.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.w.get(paramString);
          break label63;
          return paramObject;
        }
      }
      label63:
      while (localObject1 != null)
      {
        paramObject = localObject1;
        break;
      }
    }
  }
  
  @TargetApi(16)
  public void getValue(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    Object localObject;
    if (this.q != null)
    {
      localObject = (WeakReference)this.o.get(paramInt);
      if (localObject == null) {
        break label83;
      }
      localObject = (b)((WeakReference)localObject).get();
      if (localObject == null) {
        break label74;
      }
      if (((b)localObject).d.b == null) {
        break label83;
      }
      paramTypedValue.type = 16777215;
      paramTypedValue.string = ((b)localObject).d.b;
    }
    label74:
    label83:
    TypedValue localTypedValue;
    do
    {
      return;
      this.o.delete(paramInt);
      localObject = paramTypedValue.string.toString();
      localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
      localTypedValue = new TypedValue();
      a(this.mResources, localTypedValue, (String)localObject, c[this.s], d[this.s]);
    } while (localTypedValue.string == null);
    paramTypedValue.type = 16777215;
    paramTypedValue.string = localTypedValue.string;
  }
  
  public void setSkinEngineHandler(SkinEngineHandler paramSkinEngineHandler)
  {
    this.j = paramSkinEngineHandler;
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString)
  {
    return setSkinRootPath(paramContext, paramString, true);
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.m)
    {
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "[setSkinRootPath] mSkinUpdating is true");
      }
      return false;
    }
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "[setSkinRootPath] start");
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    if (paramString == null) {
      localSharedPreferences.edit().remove("pending_theme_root").remove("pending_theme_resources_complied").commit();
    }
    for (;;)
    {
      paramContext.sendBroadcast(new Intent("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify");
      if (SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "[setSkinRootPath] sendBroadcast(ACTION_THEME_UPDATE)");
        Log.d("SkinEngine.switch", "[setSkinRootPath] done");
      }
      return true;
      String str = paramString;
      if (!paramString.endsWith("/")) {
        str = paramString + "/";
      }
      if (str.startsWith("/asset/"))
      {
        localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
      }
      else
      {
        paramString = new File(str);
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
        else
        {
          if (DEBUG) {
            Log.w("SkinEngine", "[setSkinRootPath] wrong skinPath: " + str);
          }
          localSharedPreferences.edit().remove("pending_theme_root").putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
      }
    }
  }
  
  /* Error */
  public void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   4: ifnull +39 -> 43
    //   7: ldc 198
    //   9: ldc_w 557
    //   12: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   15: astore_1
    //   16: aload_1
    //   17: iconst_1
    //   18: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   21: aload_1
    //   22: invokevirtual 1067	java/lang/reflect/Field:getDeclaringClass	()Ljava/lang/Class;
    //   25: invokevirtual 1070	java/lang/Class:isArray	()Z
    //   28: ifeq +54 -> 82
    //   31: aload_1
    //   32: aconst_null
    //   33: aload_0
    //   34: getfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   37: getfield 1072	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   40: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: ldc 198
    //   45: ldc_w 575
    //   48: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   51: astore_1
    //   52: aload_1
    //   53: iconst_1
    //   54: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 212	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   62: invokevirtual 413	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 189	android/util/LongSparseArray
    //   68: astore_2
    //   69: aload_1
    //   70: aconst_null
    //   71: aload_0
    //   72: getfield 582	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   75: getfield 1074	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   78: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   81: return
    //   82: aload_1
    //   83: aconst_null
    //   84: aload_0
    //   85: getfield 568	com/tencent/theme/SkinEngine:t	Lcom/tencent/theme/g;
    //   88: getfield 1072	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   91: iconst_0
    //   92: aaload
    //   93: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: goto -53 -> 43
    //   99: astore_1
    //   100: getstatic 104	com/tencent/theme/SkinEngine:DEBUG	Z
    //   103: ifeq -22 -> 81
    //   106: ldc 46
    //   108: ldc_w 1076
    //   111: aload_1
    //   112: invokestatic 618	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   115: pop
    //   116: return
    //   117: astore_1
    //   118: ldc 198
    //   120: ldc_w 606
    //   123: invokevirtual 561	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   126: astore_1
    //   127: aload_1
    //   128: iconst_1
    //   129: invokevirtual 408	java/lang/reflect/Field:setAccessible	(Z)V
    //   132: aload_1
    //   133: aload_0
    //   134: getfield 212	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   137: invokevirtual 413	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: astore_2
    //   141: aload_2
    //   142: instanceof 588
    //   145: ifeq +16 -> 161
    //   148: aload_1
    //   149: aconst_null
    //   150: aload_0
    //   151: getfield 613	com/tencent/theme/SkinEngine:v	Lcom/tencent/theme/e;
    //   154: getfield 1079	com/tencent/theme/e:b	Landroid/util/SparseArray;
    //   157: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   160: return
    //   161: aload_2
    //   162: instanceof 189
    //   165: ifeq -84 -> 81
    //   168: aload_1
    //   169: aconst_null
    //   170: aload_0
    //   171: getfield 582	com/tencent/theme/SkinEngine:u	Lcom/tencent/theme/d;
    //   174: getfield 1074	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   177: invokevirtual 412	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   180: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	SkinEngine
    //   15	68	1	localField1	Field
    //   99	13	1	localException1	Exception
    //   117	1	1	localException2	Exception
    //   126	43	1	localField2	Field
    //   68	94	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	43	99	java/lang/Exception
    //   82	96	99	java/lang/Exception
    //   118	160	99	java/lang/Exception
    //   161	180	99	java/lang/Exception
    //   43	81	117	java/lang/Exception
  }
  
  public void writeCacheFile(File paramFile)
    throws IOException
  {
    this.t.a(paramFile);
  }
  
  public static class BackupForOOMData
  {
    public int backFileResId;
    public Bitmap.Config inPreferredConfig;
    public int orgkFileResId;
    
    public BackupForOOMData(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      this.orgkFileResId = paramInt1;
      this.backFileResId = paramInt2;
      this.inPreferredConfig = paramConfig;
    }
  }
  
  private class a
    extends AsyncTask<Context, Void, Context>
  {
    private a() {}
    
    protected Context a(Context... paramVarArgs)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground start");
      }
      SkinEngine.this.a(paramVarArgs[0]);
      System.gc();
      Thread.yield();
      System.gc();
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground done");
      }
      return paramVarArgs[0];
    }
    
    protected void a(Context paramContext)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute start");
      }
      SkinEngine.a(SkinEngine.this, null);
      SkinEngine.a(SkinEngine.this, SkinEngine.a(SkinEngine.this));
      Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
      localIntent.putExtra("pid", Process.myPid());
      paramContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      if (SkinEngine.SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute sendBroadcast(ACTION_THEME_INVALIDATE)");
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute done");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinEngine
 * JD-Core Version:    0.7.0.1
 */