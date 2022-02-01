package com.tencent.mobileqq.activity.shortvideo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import gzf;
import gzg;
import gzh;
import gzi;
import gzj;
import gzk;
import gzl;
import gzm;
import gzn;
import gzo;
import gzp;
import gzq;
import gzs;
import java.io.File;
import java.util.ArrayList;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class ShortVideoPreviewActivity
  extends BaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "preview_only";
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "ShortVideoPreviewActivity";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  private static final String jdField_i_of_type_JavaLangString = "state_play_position";
  private static final String jdField_j_of_type_JavaLangString = "state_play_state";
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static final int o = 4;
  private static final int p = 6;
  private static final int q = 5;
  private long jdField_a_of_type_Long;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new gzf(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new gzl(this);
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int jdField_i_of_type_Int;
  private int jdField_j_of_type_Int;
  private int k;
  private int r = 0;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  
  /* Error */
  private int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: iconst_2
    //   13: istore_1
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 92	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokestatic 97	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +55 -> 79
    //   27: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +11 -> 41
    //   33: ldc 22
    //   35: iconst_2
    //   36: ldc 105
    //   38: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iconst_0
    //   42: ifeq +11 -> 53
    //   45: new 110	java/lang/NullPointerException
    //   48: dup
    //   49: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   52: athrow
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 110	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: iconst_0
    //   66: ifeq +11 -> 77
    //   69: new 110	java/lang/NullPointerException
    //   72: dup
    //   73: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   76: athrow
    //   77: iload_1
    //   78: ireturn
    //   79: aload_2
    //   80: invokestatic 114	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   83: astore 9
    //   85: aload 9
    //   87: ifnonnull +56 -> 143
    //   90: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +11 -> 104
    //   96: ldc 22
    //   98: iconst_2
    //   99: ldc 116
    //   101: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iconst_0
    //   105: ifeq +11 -> 116
    //   108: new 110	java/lang/NullPointerException
    //   111: dup
    //   112: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   115: athrow
    //   116: iconst_0
    //   117: ifeq +11 -> 128
    //   120: new 110	java/lang/NullPointerException
    //   123: dup
    //   124: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   127: athrow
    //   128: iconst_0
    //   129: ifeq -52 -> 77
    //   132: new 110	java/lang/NullPointerException
    //   135: dup
    //   136: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   139: athrow
    //   140: astore_2
    //   141: iconst_2
    //   142: ireturn
    //   143: aload_0
    //   144: aload 9
    //   146: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   149: putfield 123	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:j	I
    //   152: aload_0
    //   153: aload 9
    //   155: invokevirtual 126	android/graphics/Bitmap:getHeight	()I
    //   158: putfield 128	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:k	I
    //   161: aload_0
    //   162: getfield 123	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:j	I
    //   165: ifeq +10 -> 175
    //   168: aload_0
    //   169: getfield 128	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:k	I
    //   172: ifne +56 -> 228
    //   175: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +11 -> 189
    //   181: ldc 22
    //   183: iconst_2
    //   184: ldc 116
    //   186: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iconst_0
    //   190: ifeq +11 -> 201
    //   193: new 110	java/lang/NullPointerException
    //   196: dup
    //   197: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   200: athrow
    //   201: iconst_0
    //   202: ifeq +11 -> 213
    //   205: new 110	java/lang/NullPointerException
    //   208: dup
    //   209: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   212: athrow
    //   213: iconst_0
    //   214: ifeq -137 -> 77
    //   217: new 110	java/lang/NullPointerException
    //   220: dup
    //   221: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   224: athrow
    //   225: astore_2
    //   226: iconst_2
    //   227: ireturn
    //   228: new 130	java/io/File
    //   231: dup
    //   232: aload_0
    //   233: getfield 92	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   236: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: astore_2
    //   240: aload_0
    //   241: aload_2
    //   242: invokevirtual 137	java/io/File:length	()J
    //   245: putfield 139	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_a_of_type_Long	J
    //   248: new 141	java/io/FileInputStream
    //   251: dup
    //   252: aload_2
    //   253: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   256: astore_3
    //   257: aload_0
    //   258: aload_3
    //   259: aload_0
    //   260: getfield 139	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_a_of_type_Long	J
    //   263: invokestatic 150	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   266: invokestatic 156	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   269: putfield 158	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:f	Ljava/lang/String;
    //   272: aload_0
    //   273: getfield 158	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:f	Ljava/lang/String;
    //   276: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifeq +71 -> 350
    //   282: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +31 -> 316
    //   288: ldc 22
    //   290: iconst_2
    //   291: new 166	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   298: ldc 169
    //   300: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: getfield 158	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:f	Ljava/lang/String;
    //   307: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload_3
    //   317: ifnull +7 -> 324
    //   320: aload_3
    //   321: invokevirtual 180	java/io/FileInputStream:close	()V
    //   324: iconst_0
    //   325: ifeq +11 -> 336
    //   328: new 110	java/lang/NullPointerException
    //   331: dup
    //   332: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   335: athrow
    //   336: iconst_0
    //   337: ifeq +11 -> 348
    //   340: new 110	java/lang/NullPointerException
    //   343: dup
    //   344: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   347: athrow
    //   348: iconst_5
    //   349: ireturn
    //   350: aload_0
    //   351: getfield 139	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_a_of_type_Long	J
    //   354: lconst_0
    //   355: lcmp
    //   356: ifne +56 -> 412
    //   359: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +11 -> 373
    //   365: ldc 22
    //   367: iconst_2
    //   368: ldc 182
    //   370: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: bipush 6
    //   375: istore_1
    //   376: aload_3
    //   377: ifnull +7 -> 384
    //   380: aload_3
    //   381: invokevirtual 180	java/io/FileInputStream:close	()V
    //   384: iconst_0
    //   385: ifeq +11 -> 396
    //   388: new 110	java/lang/NullPointerException
    //   391: dup
    //   392: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   395: athrow
    //   396: iconst_0
    //   397: ifeq -320 -> 77
    //   400: new 110	java/lang/NullPointerException
    //   403: dup
    //   404: invokespecial 111	java/lang/NullPointerException:<init>	()V
    //   407: athrow
    //   408: astore_2
    //   409: bipush 6
    //   411: ireturn
    //   412: aload_0
    //   413: aload_0
    //   414: getfield 158	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:f	Ljava/lang/String;
    //   417: ldc 184
    //   419: invokestatic 187	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   422: putfield 189	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:g	Ljava/lang/String;
    //   425: new 166	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   432: invokestatic 191	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   435: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc 193
    //   440: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 197	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   449: new 130	java/io/File
    //   452: dup
    //   453: aload_0
    //   454: getfield 189	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:g	Ljava/lang/String;
    //   457: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   460: astore 8
    //   462: new 130	java/io/File
    //   465: dup
    //   466: aload 8
    //   468: invokevirtual 200	java/io/File:getParent	()Ljava/lang/String;
    //   471: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   474: astore_2
    //   475: aload_2
    //   476: invokevirtual 203	java/io/File:exists	()Z
    //   479: ifeq +10 -> 489
    //   482: aload_2
    //   483: invokevirtual 206	java/io/File:isDirectory	()Z
    //   486: ifne +8 -> 494
    //   489: aload_2
    //   490: invokevirtual 209	java/io/File:mkdirs	()Z
    //   493: pop
    //   494: aload 8
    //   496: invokevirtual 203	java/io/File:exists	()Z
    //   499: ifeq +11 -> 510
    //   502: aload 8
    //   504: invokevirtual 212	java/io/File:isFile	()Z
    //   507: ifne +9 -> 516
    //   510: aload 8
    //   512: invokevirtual 215	java/io/File:createNewFile	()Z
    //   515: pop
    //   516: new 217	java/io/FileOutputStream
    //   519: dup
    //   520: aload 8
    //   522: invokespecial 218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   525: astore_2
    //   526: aload 9
    //   528: getstatic 224	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   531: bipush 50
    //   533: aload_2
    //   534: invokevirtual 228	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   537: pop
    //   538: aload_2
    //   539: invokevirtual 231	java/io/FileOutputStream:flush	()V
    //   542: new 141	java/io/FileInputStream
    //   545: dup
    //   546: aload 8
    //   548: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   551: astore 4
    //   553: aload_0
    //   554: aload 4
    //   556: aload 8
    //   558: invokevirtual 137	java/io/File:length	()J
    //   561: invokestatic 150	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   564: invokestatic 156	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   567: putfield 233	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:h	Ljava/lang/String;
    //   570: aload_0
    //   571: getfield 233	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:h	Ljava/lang/String;
    //   574: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   577: ifeq +65 -> 642
    //   580: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +31 -> 614
    //   586: ldc 22
    //   588: iconst_2
    //   589: new 166	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   596: ldc 235
    //   598: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload_0
    //   602: getfield 233	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:h	Ljava/lang/String;
    //   605: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aload_3
    //   615: ifnull +7 -> 622
    //   618: aload_3
    //   619: invokevirtual 180	java/io/FileInputStream:close	()V
    //   622: aload_2
    //   623: ifnull +7 -> 630
    //   626: aload_2
    //   627: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   630: aload 4
    //   632: ifnull +8 -> 640
    //   635: aload 4
    //   637: invokevirtual 180	java/io/FileInputStream:close	()V
    //   640: iconst_5
    //   641: ireturn
    //   642: aload_0
    //   643: getfield 238	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_b_of_type_Long	J
    //   646: lconst_0
    //   647: lcmp
    //   648: ifne +14 -> 662
    //   651: aload_0
    //   652: aload_0
    //   653: getfield 92	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   656: invokestatic 241	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   659: putfield 238	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:jdField_b_of_type_Long	J
    //   662: aload_3
    //   663: ifnull +7 -> 670
    //   666: aload_3
    //   667: invokevirtual 180	java/io/FileInputStream:close	()V
    //   670: aload_2
    //   671: ifnull +7 -> 678
    //   674: aload_2
    //   675: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   678: aload 4
    //   680: ifnull +8 -> 688
    //   683: aload 4
    //   685: invokevirtual 180	java/io/FileInputStream:close	()V
    //   688: iconst_1
    //   689: ireturn
    //   690: astore 4
    //   692: aconst_null
    //   693: astore_2
    //   694: aconst_null
    //   695: astore_3
    //   696: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   699: ifeq +13 -> 712
    //   702: ldc 22
    //   704: iconst_2
    //   705: ldc 243
    //   707: aload 4
    //   709: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   712: iconst_3
    //   713: istore_1
    //   714: aload_3
    //   715: ifnull +7 -> 722
    //   718: aload_3
    //   719: invokevirtual 180	java/io/FileInputStream:close	()V
    //   722: aload_2
    //   723: ifnull +7 -> 730
    //   726: aload_2
    //   727: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   730: aload 5
    //   732: ifnull -655 -> 77
    //   735: aload 5
    //   737: invokevirtual 180	java/io/FileInputStream:close	()V
    //   740: iconst_3
    //   741: ireturn
    //   742: astore_2
    //   743: iconst_3
    //   744: ireturn
    //   745: astore 5
    //   747: aconst_null
    //   748: astore_2
    //   749: aconst_null
    //   750: astore 8
    //   752: aload 6
    //   754: astore 7
    //   756: aload_2
    //   757: astore 4
    //   759: aload 8
    //   761: astore_3
    //   762: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   765: ifeq +23 -> 788
    //   768: aload 6
    //   770: astore 7
    //   772: aload_2
    //   773: astore 4
    //   775: aload 8
    //   777: astore_3
    //   778: ldc 22
    //   780: iconst_2
    //   781: ldc 243
    //   783: aload 5
    //   785: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   788: aload 8
    //   790: ifnull +8 -> 798
    //   793: aload 8
    //   795: invokevirtual 180	java/io/FileInputStream:close	()V
    //   798: aload 6
    //   800: ifnull +8 -> 808
    //   803: aload 6
    //   805: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   808: aload_2
    //   809: ifnull +7 -> 816
    //   812: aload_2
    //   813: invokevirtual 180	java/io/FileInputStream:close	()V
    //   816: iconst_5
    //   817: ireturn
    //   818: astore 5
    //   820: aconst_null
    //   821: astore_2
    //   822: aconst_null
    //   823: astore 8
    //   825: aload 4
    //   827: astore 6
    //   829: aload 6
    //   831: astore 7
    //   833: aload_2
    //   834: astore 4
    //   836: aload 8
    //   838: astore_3
    //   839: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   842: ifeq +23 -> 865
    //   845: aload 6
    //   847: astore 7
    //   849: aload_2
    //   850: astore 4
    //   852: aload 8
    //   854: astore_3
    //   855: ldc 22
    //   857: iconst_2
    //   858: ldc 248
    //   860: aload 5
    //   862: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   865: iconst_4
    //   866: istore_1
    //   867: aload 8
    //   869: ifnull +8 -> 877
    //   872: aload 8
    //   874: invokevirtual 180	java/io/FileInputStream:close	()V
    //   877: aload 6
    //   879: ifnull +8 -> 887
    //   882: aload 6
    //   884: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   887: aload_2
    //   888: ifnull -811 -> 77
    //   891: aload_2
    //   892: invokevirtual 180	java/io/FileInputStream:close	()V
    //   895: iconst_4
    //   896: ireturn
    //   897: astore_2
    //   898: iconst_4
    //   899: ireturn
    //   900: astore_2
    //   901: aconst_null
    //   902: astore 4
    //   904: aconst_null
    //   905: astore_3
    //   906: aload 7
    //   908: astore 5
    //   910: aload_3
    //   911: ifnull +7 -> 918
    //   914: aload_3
    //   915: invokevirtual 180	java/io/FileInputStream:close	()V
    //   918: aload 5
    //   920: ifnull +8 -> 928
    //   923: aload 5
    //   925: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   928: aload 4
    //   930: ifnull +8 -> 938
    //   933: aload 4
    //   935: invokevirtual 180	java/io/FileInputStream:close	()V
    //   938: aload_2
    //   939: athrow
    //   940: astore_2
    //   941: goto -888 -> 53
    //   944: astore_2
    //   945: goto -880 -> 65
    //   948: astore_2
    //   949: iconst_2
    //   950: ireturn
    //   951: astore_2
    //   952: goto -836 -> 116
    //   955: astore_2
    //   956: goto -828 -> 128
    //   959: astore_2
    //   960: goto -759 -> 201
    //   963: astore_2
    //   964: goto -751 -> 213
    //   967: astore_2
    //   968: goto -644 -> 324
    //   971: astore_2
    //   972: goto -636 -> 336
    //   975: astore_2
    //   976: goto -628 -> 348
    //   979: astore_2
    //   980: goto -596 -> 384
    //   983: astore_2
    //   984: goto -588 -> 396
    //   987: astore_3
    //   988: goto -366 -> 622
    //   991: astore_2
    //   992: goto -362 -> 630
    //   995: astore_2
    //   996: goto -356 -> 640
    //   999: astore_3
    //   1000: goto -330 -> 670
    //   1003: astore_2
    //   1004: goto -326 -> 678
    //   1007: astore_2
    //   1008: goto -320 -> 688
    //   1011: astore_3
    //   1012: goto -290 -> 722
    //   1015: astore_2
    //   1016: goto -286 -> 730
    //   1019: astore_3
    //   1020: goto -222 -> 798
    //   1023: astore_3
    //   1024: goto -216 -> 808
    //   1027: astore_2
    //   1028: goto -212 -> 816
    //   1031: astore_3
    //   1032: goto -155 -> 877
    //   1035: astore_3
    //   1036: goto -149 -> 887
    //   1039: astore_3
    //   1040: goto -122 -> 918
    //   1043: astore_3
    //   1044: goto -116 -> 928
    //   1047: astore_3
    //   1048: goto -110 -> 938
    //   1051: astore_2
    //   1052: aconst_null
    //   1053: astore 4
    //   1055: aload 7
    //   1057: astore 5
    //   1059: goto -149 -> 910
    //   1062: astore 6
    //   1064: aconst_null
    //   1065: astore 4
    //   1067: aload_2
    //   1068: astore 5
    //   1070: aload 6
    //   1072: astore_2
    //   1073: goto -163 -> 910
    //   1076: astore 6
    //   1078: aload_2
    //   1079: astore 5
    //   1081: aload 6
    //   1083: astore_2
    //   1084: goto -174 -> 910
    //   1087: astore 6
    //   1089: aload 5
    //   1091: astore 4
    //   1093: aload_2
    //   1094: astore 5
    //   1096: aload 6
    //   1098: astore_2
    //   1099: goto -189 -> 910
    //   1102: astore_2
    //   1103: aload 7
    //   1105: astore 5
    //   1107: goto -197 -> 910
    //   1110: astore 5
    //   1112: aconst_null
    //   1113: astore_2
    //   1114: aload 4
    //   1116: astore 6
    //   1118: aload_3
    //   1119: astore 8
    //   1121: goto -292 -> 829
    //   1124: astore 5
    //   1126: aconst_null
    //   1127: astore 4
    //   1129: aload_2
    //   1130: astore 6
    //   1132: aload 4
    //   1134: astore_2
    //   1135: aload_3
    //   1136: astore 8
    //   1138: goto -309 -> 829
    //   1141: astore 5
    //   1143: aload_2
    //   1144: astore 6
    //   1146: aload 4
    //   1148: astore_2
    //   1149: aload_3
    //   1150: astore 8
    //   1152: goto -323 -> 829
    //   1155: astore 5
    //   1157: aconst_null
    //   1158: astore_2
    //   1159: aload_3
    //   1160: astore 8
    //   1162: goto -410 -> 752
    //   1165: astore 5
    //   1167: aconst_null
    //   1168: astore 4
    //   1170: aload_2
    //   1171: astore 6
    //   1173: aload 4
    //   1175: astore_2
    //   1176: aload_3
    //   1177: astore 8
    //   1179: goto -427 -> 752
    //   1182: astore 5
    //   1184: aload_2
    //   1185: astore 6
    //   1187: aload 4
    //   1189: astore_2
    //   1190: aload_3
    //   1191: astore 8
    //   1193: goto -441 -> 752
    //   1196: astore 4
    //   1198: aconst_null
    //   1199: astore_2
    //   1200: goto -504 -> 696
    //   1203: astore 4
    //   1205: goto -509 -> 696
    //   1208: astore 6
    //   1210: aload 4
    //   1212: astore 5
    //   1214: aload 6
    //   1216: astore 4
    //   1218: goto -522 -> 696
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1221	0	this	ShortVideoPreviewActivity
    //   13	854	1	i1	int
    //   22	58	2	localBitmap1	Bitmap
    //   140	1	2	localIOException1	java.io.IOException
    //   225	1	2	localIOException2	java.io.IOException
    //   239	14	2	localFile	File
    //   408	1	2	localIOException3	java.io.IOException
    //   474	253	2	localObject1	Object
    //   742	1	2	localIOException4	java.io.IOException
    //   748	144	2	localObject2	Object
    //   897	1	2	localIOException5	java.io.IOException
    //   900	39	2	localObject3	Object
    //   940	1	2	localIOException6	java.io.IOException
    //   944	1	2	localIOException7	java.io.IOException
    //   948	1	2	localIOException8	java.io.IOException
    //   951	1	2	localIOException9	java.io.IOException
    //   955	1	2	localIOException10	java.io.IOException
    //   959	1	2	localIOException11	java.io.IOException
    //   963	1	2	localIOException12	java.io.IOException
    //   967	1	2	localIOException13	java.io.IOException
    //   971	1	2	localIOException14	java.io.IOException
    //   975	1	2	localIOException15	java.io.IOException
    //   979	1	2	localIOException16	java.io.IOException
    //   983	1	2	localIOException17	java.io.IOException
    //   991	1	2	localIOException18	java.io.IOException
    //   995	1	2	localIOException19	java.io.IOException
    //   1003	1	2	localIOException20	java.io.IOException
    //   1007	1	2	localIOException21	java.io.IOException
    //   1015	1	2	localIOException22	java.io.IOException
    //   1027	1	2	localIOException23	java.io.IOException
    //   1051	17	2	localObject4	Object
    //   1072	27	2	localObject5	Object
    //   1102	1	2	localObject6	Object
    //   1113	87	2	localObject7	Object
    //   256	659	3	localObject8	Object
    //   987	1	3	localIOException24	java.io.IOException
    //   999	1	3	localIOException25	java.io.IOException
    //   1011	1	3	localIOException26	java.io.IOException
    //   1019	1	3	localIOException27	java.io.IOException
    //   1023	1	3	localIOException28	java.io.IOException
    //   1031	1	3	localIOException29	java.io.IOException
    //   1035	1	3	localIOException30	java.io.IOException
    //   1039	1	3	localIOException31	java.io.IOException
    //   1043	1	3	localIOException32	java.io.IOException
    //   1047	144	3	localIOException33	java.io.IOException
    //   4	680	4	localFileInputStream	java.io.FileInputStream
    //   690	18	4	localIOException34	java.io.IOException
    //   757	431	4	localObject9	Object
    //   1196	1	4	localIOException35	java.io.IOException
    //   1203	8	4	localIOException36	java.io.IOException
    //   1216	1	4	localIOException37	java.io.IOException
    //   10	726	5	localObject10	Object
    //   745	39	5	localException1	Exception
    //   818	43	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   908	198	5	localObject11	Object
    //   1110	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1124	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1141	1	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1155	1	5	localException2	Exception
    //   1165	1	5	localException3	Exception
    //   1182	1	5	localException4	Exception
    //   1212	1	5	localIOException38	java.io.IOException
    //   1	882	6	localObject12	Object
    //   1062	9	6	localObject13	Object
    //   1076	6	6	localObject14	Object
    //   1087	10	6	localObject15	Object
    //   1116	70	6	localObject16	Object
    //   1208	7	6	localIOException39	java.io.IOException
    //   7	1097	7	localObject17	Object
    //   460	732	8	localObject18	Object
    //   83	444	9	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   132	140	140	java/io/IOException
    //   217	225	225	java/io/IOException
    //   400	408	408	java/io/IOException
    //   14	23	690	java/io/IOException
    //   27	41	690	java/io/IOException
    //   79	85	690	java/io/IOException
    //   90	104	690	java/io/IOException
    //   143	175	690	java/io/IOException
    //   175	189	690	java/io/IOException
    //   228	257	690	java/io/IOException
    //   735	740	742	java/io/IOException
    //   14	23	745	java/lang/Exception
    //   27	41	745	java/lang/Exception
    //   79	85	745	java/lang/Exception
    //   90	104	745	java/lang/Exception
    //   143	175	745	java/lang/Exception
    //   175	189	745	java/lang/Exception
    //   228	257	745	java/lang/Exception
    //   14	23	818	java/lang/OutOfMemoryError
    //   27	41	818	java/lang/OutOfMemoryError
    //   79	85	818	java/lang/OutOfMemoryError
    //   90	104	818	java/lang/OutOfMemoryError
    //   143	175	818	java/lang/OutOfMemoryError
    //   175	189	818	java/lang/OutOfMemoryError
    //   228	257	818	java/lang/OutOfMemoryError
    //   891	895	897	java/io/IOException
    //   14	23	900	finally
    //   27	41	900	finally
    //   79	85	900	finally
    //   90	104	900	finally
    //   143	175	900	finally
    //   175	189	900	finally
    //   228	257	900	finally
    //   45	53	940	java/io/IOException
    //   57	65	944	java/io/IOException
    //   69	77	948	java/io/IOException
    //   108	116	951	java/io/IOException
    //   120	128	955	java/io/IOException
    //   193	201	959	java/io/IOException
    //   205	213	963	java/io/IOException
    //   320	324	967	java/io/IOException
    //   328	336	971	java/io/IOException
    //   340	348	975	java/io/IOException
    //   380	384	979	java/io/IOException
    //   388	396	983	java/io/IOException
    //   618	622	987	java/io/IOException
    //   626	630	991	java/io/IOException
    //   635	640	995	java/io/IOException
    //   666	670	999	java/io/IOException
    //   674	678	1003	java/io/IOException
    //   683	688	1007	java/io/IOException
    //   718	722	1011	java/io/IOException
    //   726	730	1015	java/io/IOException
    //   793	798	1019	java/io/IOException
    //   803	808	1023	java/io/IOException
    //   812	816	1027	java/io/IOException
    //   872	877	1031	java/io/IOException
    //   882	887	1035	java/io/IOException
    //   914	918	1039	java/io/IOException
    //   923	928	1043	java/io/IOException
    //   933	938	1047	java/io/IOException
    //   257	316	1051	finally
    //   350	373	1051	finally
    //   412	489	1051	finally
    //   489	494	1051	finally
    //   494	510	1051	finally
    //   510	516	1051	finally
    //   516	526	1051	finally
    //   526	553	1062	finally
    //   553	614	1076	finally
    //   642	662	1076	finally
    //   696	712	1087	finally
    //   762	768	1102	finally
    //   778	788	1102	finally
    //   839	845	1102	finally
    //   855	865	1102	finally
    //   257	316	1110	java/lang/OutOfMemoryError
    //   350	373	1110	java/lang/OutOfMemoryError
    //   412	489	1110	java/lang/OutOfMemoryError
    //   489	494	1110	java/lang/OutOfMemoryError
    //   494	510	1110	java/lang/OutOfMemoryError
    //   510	516	1110	java/lang/OutOfMemoryError
    //   516	526	1110	java/lang/OutOfMemoryError
    //   526	553	1124	java/lang/OutOfMemoryError
    //   553	614	1141	java/lang/OutOfMemoryError
    //   642	662	1141	java/lang/OutOfMemoryError
    //   257	316	1155	java/lang/Exception
    //   350	373	1155	java/lang/Exception
    //   412	489	1155	java/lang/Exception
    //   489	494	1155	java/lang/Exception
    //   494	510	1155	java/lang/Exception
    //   510	516	1155	java/lang/Exception
    //   516	526	1155	java/lang/Exception
    //   526	553	1165	java/lang/Exception
    //   553	614	1182	java/lang/Exception
    //   642	662	1182	java/lang/Exception
    //   257	316	1196	java/io/IOException
    //   350	373	1196	java/io/IOException
    //   412	489	1196	java/io/IOException
    //   489	494	1196	java/io/IOException
    //   494	510	1196	java/io/IOException
    //   510	516	1196	java/io/IOException
    //   516	526	1196	java/io/IOException
    //   526	553	1203	java/io/IOException
    //   553	614	1208	java/io/IOException
    //   642	662	1208	java/io/IOException
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    }
    return " error ";
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      switch (this.w)
      {
      default: 
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131365737);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363684);
        }
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("发送");
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131365737);
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364091);
    }
  }
  
  private void a(int paramInt)
  {
    if (!FileUtils.b(this.jdField_c_of_type_JavaLangString))
    {
      QQToast.a(this, 2131369541, 0).a();
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt);
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new gzm(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreviewActivity", 2, "#play#, msec=" + paramInt, localException);
      }
      e();
      DialogUtil.a(this, 232, null, getString(2131369550), new gzn(this), null).show();
    }
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_c_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_b_of_type_Long = paramIntent.getExtras().getLong("file_send_duration");
    this.jdField_a_of_type_Long = paramIntent.getExtras().getLong("file_send_size");
    this.d = paramIntent.getExtras().getString("uin");
    this.i = paramIntent.getIntExtra("uintype", -1);
    this.e = paramIntent.getStringExtra("file_source");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("preview_only", false);
    boolean bool = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
    paramIntent = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (paramIntent.contains("ChatActivity")) {
      this.w = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, " initData(),  mVideoPath :" + this.jdField_c_of_type_JavaLangString + ", mDuration:" + this.jdField_b_of_type_Long + ", mFileSize:" + this.jdField_a_of_type_Long + ",mUin" + this.d + ",mUinType:" + this.i + ",mFileSource:" + this.e + ",mDestType:" + this.w);
      }
      if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || ((this.w != 2) && (TextUtils.isEmpty(this.d))) || (!FileUtils.b(this.jdField_c_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoPreviewActivity", 2, "ShortVideoPreviewActivity initData(),mVideoPath or mUin is empty or mVideoPath not exits, just finish.");
        }
        QQToast.a(this, 2131369541, 0).a();
        finish();
      }
      return;
      if (paramIntent.contains("QZonePublishMoodActivity")) {
        this.w = 1;
      } else if (bool) {
        this.w = 2;
      } else if (paramIntent.contains("TrimVideoActivity")) {
        this.w = 3;
      } else {
        this.w = 0;
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    b(0);
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {}
    for (;;)
    {
      return;
      this.r = paramInt;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840586);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPreviewActivity", 2, "changePlayState, playState => " + a(paramInt));
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840585);
      }
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#pause#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) && (this.r == 1))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      b(2);
    }
  }
  
  private void c(int paramInt)
  {
    DialogUtil.a(this, 232, null, getString(paramInt), new gzi(this), null).show();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#resume#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.r == 2))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      b(1);
    }
  }
  
  private void d(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        i();
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131558902);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903413);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298140));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreviewActivity", 2, "showProgressDialog", localThrowable);
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    b(0);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "#stop#");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((this.r == 1) || (this.r == 2))) {
      b();
    }
  }
  
  private void g()
  {
    int i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
    int i2 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "adjustVideoRatio, videoWith:" + i1 + ",videoHeight:" + i2);
    }
    if ((this.t == 0) || (this.s == 0) || (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (i1 == 0) || (i2 == 0)) {
      return;
    }
    if (this.t / this.s > i2 / i1)
    {
      f1 = this.s;
      i1 = (int)(i2 * f1 / i1);
      i1 = (int)((this.t - i1) / 2.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(0, i1, 0, i1);
      this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
    float f1 = this.t;
    i1 = (int)(i1 * f1 / i2);
    i1 = (int)((this.s - i1) / 2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(i1, 0, i1, 0);
    this.jdField_a_of_type_AndroidViewSurfaceView.setLayoutParams(localLayoutParams);
  }
  
  private void h()
  {
    Object localObject = (SplashActivity)SplashActivity.a();
    if (((SplashActivity)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      ((SplashActivity)localObject).permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new gzq(this, (SplashActivity)localObject));
      return;
    }
    localObject = Environment.getExternalStorageDirectory();
    int i1;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label193;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        if (Utils.b() > 512000L)
        {
          if (NetworkUtil.c(this))
          {
            this.jdField_a_of_type_Long = new File(this.jdField_c_of_type_JavaLangString).length();
            localObject = ShortVideoUtils.a(this, this.jdField_a_of_type_Long);
            DialogUtil.a(this, 232, null, String.format(getResources().getString(2131369559), new Object[] { localObject }), new gzg(this), new gzh(this)).show();
            return;
            i1 = 0;
            break;
            label193:
            i1 = 0;
            continue;
          }
          new gzs(this, null).execute(new Void[0]);
          return;
        }
        c(2131369556);
        return;
      }
    }
    QQToast.a(this, 1, 2131367289, 0).b(getTitleBarHeight());
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(getIntent());
    if (paramBundle != null)
    {
      this.v = paramBundle.getInt("state_play_state");
      this.u = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "onCreate(), mSavedCurPosition : " + this.u + ",mSavedPlayState : " + a(this.v));
      }
    }
    super.setContentView(2130904024);
    this.jdField_a_of_type_AndroidViewSurfaceView = ((SurfaceView)findViewById(2131300539));
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
    this.jdField_a_of_type_AndroidViewSurfaceView.getViewTreeObserver().addOnGlobalLayoutListener(new gzj(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297533));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300547));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300548));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300542));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new gzk(this));
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "doOnDestroy");
    }
    b();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300547: 
      finish();
      return;
    case 2131300542: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "handleClick: mPlayState = " + a(this.r));
      }
      if ((this.v == 2) && (this.u > 0))
      {
        a(this.u);
        this.v = 0;
        this.u = 0;
        return;
      }
      switch (this.r)
      {
      default: 
        return;
      case 0: 
        if (this.app.d())
        {
          QQToast.a(this, 0, 2131369561, 0).a();
          return;
        }
        a(0);
        return;
      case 1: 
        c();
        return;
      case 2: 
        d();
        return;
      }
      a(0);
      return;
    }
    switch (this.w)
    {
    default: 
      return;
    case 0: 
      h();
      return;
    case 1: 
    case 3: 
      paramView = getIntent();
      paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
      paramView.putExtra("PhotoConst.VIDEO_SIZE", this.jdField_a_of_type_Long);
      paramView.putExtra("file_send_duration", this.jdField_b_of_type_Long);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_c_of_type_JavaLangString);
      PhotoUtils.a(this, paramView, localArrayList, 2, false);
      return;
    }
    DialogUtil.a(this, 232, null, getString(2131364106, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(this.jdField_a_of_type_Long / 1024.0D / 1024.0D) }) }), new gzo(this), new gzp(this)).show();
    paramView = new Intent("key_video_select_apply_click");
    paramView.putExtra("className", getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
    sendBroadcast(paramView);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onCompletion");
    }
    b(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPreviewActivity", 2, "mMediaPlayer onError what=" + paramInt1 + ",extra=" + paramInt2);
    }
    b(3);
    e();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared");
    }
    g();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    b(1);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (((this.r == 1) || (this.r == 2)) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)) {
      this.u = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    this.v = this.r;
    paramBundle.putInt("state_play_state", this.r);
    paramBundle.putInt("state_play_position", this.u);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "onSaveInstanceState: mSavedCurPosition: " + this.u + " ,playState = " + a(this.r));
    }
  }
  
  public void onStart()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */