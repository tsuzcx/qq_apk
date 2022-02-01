package com.tencent.netdemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class SimpleURLImageActivity
  extends Activity
{
  private static final String urlApng = "http://upload.wikimedia.org/wikipedia/commons/1/14/Animated_PNG_example_bouncing_beach_ball.png";
  private static final String urlBitmap = "http://www.google.com.hk/images/nav_logo.png";
  private static final String urlBitmap2 = "https://www.google.com.hk/images/nav_logo.png";
  private static final String urlGif = "http://mat1.gtimg.com/www/mb/images/cFace/a9.gif";
  private AsyncTask<Void, Void, Void> asyncTask;
  private boolean pause = false;
  
  public void onBackPressed()
  {
    if (this.pause)
    {
      URLDrawable.resume();
      NativeGifImage.resumeAll();
      ApngImage.resumeAll();
      this.pause = false;
      return;
    }
    URLDrawable.pause();
    NativeGifImage.pauseAll();
    ApngImage.pauseAll();
    this.pause = true;
  }
  
  /* Error */
  @TargetApi(11)
  protected void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 62	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: invokevirtual 66	com/tencent/netdemo/SimpleURLImageActivity:getResources	()Landroid/content/res/Resources;
    //   9: ldc 67
    //   11: invokevirtual 73	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   14: pop
    //   15: aload_0
    //   16: invokevirtual 77	com/tencent/netdemo/SimpleURLImageActivity:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   19: aload_0
    //   20: invokevirtual 83	android/view/LayoutInflater:setFactory2	(Landroid/view/LayoutInflater$Factory2;)V
    //   23: aload_0
    //   24: ldc 84
    //   26: invokevirtual 88	com/tencent/netdemo/SimpleURLImageActivity:setContentView	(I)V
    //   29: aconst_null
    //   30: astore 5
    //   32: aconst_null
    //   33: astore 4
    //   35: aconst_null
    //   36: astore 8
    //   38: aconst_null
    //   39: astore 7
    //   41: ldc 89
    //   43: newarray byte
    //   45: astore 9
    //   47: aload 7
    //   49: astore_1
    //   50: aload 8
    //   52: astore_3
    //   53: aload_0
    //   54: invokevirtual 93	com/tencent/netdemo/SimpleURLImageActivity:getAssets	()Landroid/content/res/AssetManager;
    //   57: ldc 95
    //   59: invokevirtual 101	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   62: astore 6
    //   64: aload 6
    //   66: astore 4
    //   68: aload 7
    //   70: astore_1
    //   71: aload 6
    //   73: astore 5
    //   75: aload 8
    //   77: astore_3
    //   78: aload_0
    //   79: ldc 95
    //   81: iconst_0
    //   82: invokevirtual 105	com/tencent/netdemo/SimpleURLImageActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   85: astore 7
    //   87: aload 6
    //   89: astore 4
    //   91: aload 7
    //   93: astore_1
    //   94: aload 6
    //   96: astore 5
    //   98: aload 7
    //   100: astore_3
    //   101: aload 6
    //   103: aload 9
    //   105: invokevirtual 111	java/io/InputStream:read	([B)I
    //   108: istore_2
    //   109: iload_2
    //   110: ifgt +981 -> 1091
    //   113: aload 6
    //   115: astore 4
    //   117: aload 7
    //   119: astore_1
    //   120: aload 6
    //   122: astore 5
    //   124: aload 7
    //   126: astore_3
    //   127: aload 7
    //   129: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   132: aload 6
    //   134: ifnull +8 -> 142
    //   137: aload 6
    //   139: invokevirtual 119	java/io/InputStream:close	()V
    //   142: aload 7
    //   144: ifnull +8 -> 152
    //   147: aload 7
    //   149: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   152: aload_0
    //   153: ldc 121
    //   155: invokevirtual 125	com/tencent/netdemo/SimpleURLImageActivity:findViewById	(I)Landroid/view/View;
    //   158: checkcast 127	android/widget/ImageView
    //   161: astore_1
    //   162: aload_0
    //   163: ldc 95
    //   165: invokevirtual 131	com/tencent/netdemo/SimpleURLImageActivity:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   168: astore_3
    //   169: aload_1
    //   170: new 133	java/net/URL
    //   173: dup
    //   174: new 135	java/lang/StringBuilder
    //   177: dup
    //   178: ldc 137
    //   180: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload_3
    //   184: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   187: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokespecial 154	java/net/URL:<init>	(Ljava/lang/String;)V
    //   196: iconst_0
    //   197: iconst_0
    //   198: aconst_null
    //   199: aconst_null
    //   200: iconst_1
    //   201: fconst_0
    //   202: invokestatic 157	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZF)Lcom/tencent/image/URLDrawable;
    //   205: invokevirtual 161	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   208: aconst_null
    //   209: astore 5
    //   211: aconst_null
    //   212: astore 4
    //   214: aconst_null
    //   215: astore 8
    //   217: aconst_null
    //   218: astore 7
    //   220: ldc 89
    //   222: newarray byte
    //   224: astore 9
    //   226: aload 7
    //   228: astore_1
    //   229: aload 8
    //   231: astore_3
    //   232: aload_0
    //   233: invokevirtual 93	com/tencent/netdemo/SimpleURLImageActivity:getAssets	()Landroid/content/res/AssetManager;
    //   236: ldc 95
    //   238: invokevirtual 101	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   241: astore 6
    //   243: aload 6
    //   245: astore 4
    //   247: aload 7
    //   249: astore_1
    //   250: aload 6
    //   252: astore 5
    //   254: aload 8
    //   256: astore_3
    //   257: aload_0
    //   258: ldc 95
    //   260: iconst_0
    //   261: invokevirtual 105	com/tencent/netdemo/SimpleURLImageActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   264: astore 7
    //   266: aload 6
    //   268: astore 4
    //   270: aload 7
    //   272: astore_1
    //   273: aload 6
    //   275: astore 5
    //   277: aload 7
    //   279: astore_3
    //   280: aload 6
    //   282: aload 9
    //   284: invokevirtual 111	java/io/InputStream:read	([B)I
    //   287: istore_2
    //   288: iload_2
    //   289: ifgt +895 -> 1184
    //   292: aload 6
    //   294: astore 4
    //   296: aload 7
    //   298: astore_1
    //   299: aload 6
    //   301: astore 5
    //   303: aload 7
    //   305: astore_3
    //   306: aload 7
    //   308: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   311: aload 6
    //   313: ifnull +8 -> 321
    //   316: aload 6
    //   318: invokevirtual 119	java/io/InputStream:close	()V
    //   321: aload 7
    //   323: ifnull +8 -> 331
    //   326: aload 7
    //   328: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   331: aload_0
    //   332: ldc 162
    //   334: invokevirtual 125	com/tencent/netdemo/SimpleURLImageActivity:findViewById	(I)Landroid/view/View;
    //   337: checkcast 127	android/widget/ImageView
    //   340: astore_1
    //   341: aload_0
    //   342: ldc 95
    //   344: invokevirtual 131	com/tencent/netdemo/SimpleURLImageActivity:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   347: astore_3
    //   348: aload_1
    //   349: new 133	java/net/URL
    //   352: dup
    //   353: new 135	java/lang/StringBuilder
    //   356: dup
    //   357: ldc 137
    //   359: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: aload_3
    //   363: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   366: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokespecial 154	java/net/URL:<init>	(Ljava/lang/String;)V
    //   375: bipush 100
    //   377: bipush 100
    //   379: aconst_null
    //   380: aconst_null
    //   381: iconst_1
    //   382: ldc 163
    //   384: invokestatic 157	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZF)Lcom/tencent/image/URLDrawable;
    //   387: invokevirtual 161	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   390: aconst_null
    //   391: astore 5
    //   393: aconst_null
    //   394: astore 4
    //   396: aconst_null
    //   397: astore 8
    //   399: aconst_null
    //   400: astore 7
    //   402: ldc 89
    //   404: newarray byte
    //   406: astore 9
    //   408: aload 7
    //   410: astore_1
    //   411: aload 8
    //   413: astore_3
    //   414: aload_0
    //   415: invokevirtual 93	com/tencent/netdemo/SimpleURLImageActivity:getAssets	()Landroid/content/res/AssetManager;
    //   418: ldc 165
    //   420: invokevirtual 101	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   423: astore 6
    //   425: aload 6
    //   427: astore 4
    //   429: aload 7
    //   431: astore_1
    //   432: aload 6
    //   434: astore 5
    //   436: aload 8
    //   438: astore_3
    //   439: aload_0
    //   440: ldc 165
    //   442: iconst_0
    //   443: invokevirtual 105	com/tencent/netdemo/SimpleURLImageActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   446: astore 7
    //   448: aload 6
    //   450: astore 4
    //   452: aload 7
    //   454: astore_1
    //   455: aload 6
    //   457: astore 5
    //   459: aload 7
    //   461: astore_3
    //   462: aload 6
    //   464: aload 9
    //   466: invokevirtual 111	java/io/InputStream:read	([B)I
    //   469: istore_2
    //   470: iload_2
    //   471: ifgt +806 -> 1277
    //   474: aload 6
    //   476: astore 4
    //   478: aload 7
    //   480: astore_1
    //   481: aload 6
    //   483: astore 5
    //   485: aload 7
    //   487: astore_3
    //   488: aload 7
    //   490: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   493: aload 6
    //   495: ifnull +8 -> 503
    //   498: aload 6
    //   500: invokevirtual 119	java/io/InputStream:close	()V
    //   503: aload 7
    //   505: ifnull +8 -> 513
    //   508: aload 7
    //   510: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   513: aload_0
    //   514: ldc 166
    //   516: invokevirtual 125	com/tencent/netdemo/SimpleURLImageActivity:findViewById	(I)Landroid/view/View;
    //   519: checkcast 127	android/widget/ImageView
    //   522: astore_1
    //   523: aload_0
    //   524: ldc 165
    //   526: invokevirtual 131	com/tencent/netdemo/SimpleURLImageActivity:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   529: astore_3
    //   530: aload_1
    //   531: new 133	java/net/URL
    //   534: dup
    //   535: new 135	java/lang/StringBuilder
    //   538: dup
    //   539: ldc 137
    //   541: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: aload_3
    //   545: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   548: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokespecial 154	java/net/URL:<init>	(Ljava/lang/String;)V
    //   557: sipush 198
    //   560: sipush 198
    //   563: aconst_null
    //   564: aconst_null
    //   565: iconst_1
    //   566: ldc 163
    //   568: invokestatic 157	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZF)Lcom/tencent/image/URLDrawable;
    //   571: invokevirtual 161	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   574: aconst_null
    //   575: astore 5
    //   577: aconst_null
    //   578: astore 4
    //   580: aconst_null
    //   581: astore 8
    //   583: aconst_null
    //   584: astore 7
    //   586: ldc 89
    //   588: newarray byte
    //   590: astore 9
    //   592: aload 7
    //   594: astore_1
    //   595: aload 8
    //   597: astore_3
    //   598: aload_0
    //   599: invokevirtual 93	com/tencent/netdemo/SimpleURLImageActivity:getAssets	()Landroid/content/res/AssetManager;
    //   602: ldc 168
    //   604: invokevirtual 101	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   607: astore 6
    //   609: aload 6
    //   611: astore 4
    //   613: aload 7
    //   615: astore_1
    //   616: aload 6
    //   618: astore 5
    //   620: aload 8
    //   622: astore_3
    //   623: aload_0
    //   624: ldc 168
    //   626: iconst_0
    //   627: invokevirtual 105	com/tencent/netdemo/SimpleURLImageActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   630: astore 7
    //   632: aload 6
    //   634: astore 4
    //   636: aload 7
    //   638: astore_1
    //   639: aload 6
    //   641: astore 5
    //   643: aload 7
    //   645: astore_3
    //   646: aload 6
    //   648: aload 9
    //   650: invokevirtual 111	java/io/InputStream:read	([B)I
    //   653: istore_2
    //   654: iload_2
    //   655: ifgt +715 -> 1370
    //   658: aload 6
    //   660: astore 4
    //   662: aload 7
    //   664: astore_1
    //   665: aload 6
    //   667: astore 5
    //   669: aload 7
    //   671: astore_3
    //   672: aload 7
    //   674: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   677: aload 6
    //   679: ifnull +8 -> 687
    //   682: aload 6
    //   684: invokevirtual 119	java/io/InputStream:close	()V
    //   687: aload 7
    //   689: ifnull +8 -> 697
    //   692: aload 7
    //   694: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   697: aload_0
    //   698: ldc 169
    //   700: invokevirtual 125	com/tencent/netdemo/SimpleURLImageActivity:findViewById	(I)Landroid/view/View;
    //   703: checkcast 127	android/widget/ImageView
    //   706: astore_1
    //   707: aload_0
    //   708: ldc 168
    //   710: invokevirtual 131	com/tencent/netdemo/SimpleURLImageActivity:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   713: astore_3
    //   714: aload_1
    //   715: new 133	java/net/URL
    //   718: dup
    //   719: new 135	java/lang/StringBuilder
    //   722: dup
    //   723: ldc 137
    //   725: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   728: aload_3
    //   729: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   732: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokespecial 154	java/net/URL:<init>	(Ljava/lang/String;)V
    //   741: sipush 200
    //   744: sipush 200
    //   747: aconst_null
    //   748: aconst_null
    //   749: iconst_1
    //   750: ldc 170
    //   752: invokestatic 157	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZF)Lcom/tencent/image/URLDrawable;
    //   755: invokevirtual 161	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   758: aconst_null
    //   759: astore 5
    //   761: aconst_null
    //   762: astore 4
    //   764: aconst_null
    //   765: astore 8
    //   767: aconst_null
    //   768: astore 7
    //   770: ldc 89
    //   772: newarray byte
    //   774: astore 9
    //   776: aload 7
    //   778: astore_1
    //   779: aload 8
    //   781: astore_3
    //   782: aload_0
    //   783: invokevirtual 93	com/tencent/netdemo/SimpleURLImageActivity:getAssets	()Landroid/content/res/AssetManager;
    //   786: ldc 172
    //   788: invokevirtual 101	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   791: astore 6
    //   793: aload 6
    //   795: astore 4
    //   797: aload 7
    //   799: astore_1
    //   800: aload 6
    //   802: astore 5
    //   804: aload 8
    //   806: astore_3
    //   807: aload_0
    //   808: ldc 172
    //   810: iconst_0
    //   811: invokevirtual 105	com/tencent/netdemo/SimpleURLImageActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   814: astore 7
    //   816: aload 6
    //   818: astore 4
    //   820: aload 7
    //   822: astore_1
    //   823: aload 6
    //   825: astore 5
    //   827: aload 7
    //   829: astore_3
    //   830: aload 6
    //   832: aload 9
    //   834: invokevirtual 111	java/io/InputStream:read	([B)I
    //   837: istore_2
    //   838: iload_2
    //   839: ifgt +624 -> 1463
    //   842: aload 6
    //   844: astore 4
    //   846: aload 7
    //   848: astore_1
    //   849: aload 6
    //   851: astore 5
    //   853: aload 7
    //   855: astore_3
    //   856: aload 7
    //   858: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   861: aload 6
    //   863: ifnull +8 -> 871
    //   866: aload 6
    //   868: invokevirtual 119	java/io/InputStream:close	()V
    //   871: aload 7
    //   873: ifnull +8 -> 881
    //   876: aload 7
    //   878: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   881: aload_0
    //   882: ldc 173
    //   884: invokevirtual 125	com/tencent/netdemo/SimpleURLImageActivity:findViewById	(I)Landroid/view/View;
    //   887: checkcast 127	android/widget/ImageView
    //   890: astore_1
    //   891: aload_0
    //   892: ldc 172
    //   894: invokevirtual 131	com/tencent/netdemo/SimpleURLImageActivity:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   897: astore_3
    //   898: aload_1
    //   899: new 133	java/net/URL
    //   902: dup
    //   903: new 135	java/lang/StringBuilder
    //   906: dup
    //   907: ldc 137
    //   909: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   912: aload_3
    //   913: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   916: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokespecial 154	java/net/URL:<init>	(Ljava/lang/String;)V
    //   925: bipush 50
    //   927: bipush 50
    //   929: aconst_null
    //   930: aconst_null
    //   931: iconst_1
    //   932: fconst_0
    //   933: invokestatic 157	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZF)Lcom/tencent/image/URLDrawable;
    //   936: invokevirtual 161	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   939: aconst_null
    //   940: astore 5
    //   942: aconst_null
    //   943: astore 4
    //   945: ldc 89
    //   947: newarray byte
    //   949: astore 6
    //   951: aload 4
    //   953: astore_3
    //   954: aload 5
    //   956: astore_1
    //   957: aload_0
    //   958: invokevirtual 93	com/tencent/netdemo/SimpleURLImageActivity:getAssets	()Landroid/content/res/AssetManager;
    //   961: ldc 175
    //   963: invokevirtual 101	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   966: astore 7
    //   968: aload 4
    //   970: astore_3
    //   971: aload 5
    //   973: astore_1
    //   974: aload_0
    //   975: ldc 175
    //   977: iconst_0
    //   978: invokevirtual 105	com/tencent/netdemo/SimpleURLImageActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   981: astore 4
    //   983: aload 4
    //   985: astore_3
    //   986: aload 4
    //   988: astore_1
    //   989: aload 7
    //   991: aload 6
    //   993: invokevirtual 111	java/io/InputStream:read	([B)I
    //   996: istore_2
    //   997: iload_2
    //   998: ifgt +558 -> 1556
    //   1001: aload 4
    //   1003: astore_3
    //   1004: aload 4
    //   1006: astore_1
    //   1007: aload 4
    //   1009: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   1012: aload 4
    //   1014: ifnull +8 -> 1022
    //   1017: aload 4
    //   1019: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1022: aload_0
    //   1023: ldc 176
    //   1025: invokevirtual 125	com/tencent/netdemo/SimpleURLImageActivity:findViewById	(I)Landroid/view/View;
    //   1028: checkcast 127	android/widget/ImageView
    //   1031: astore_1
    //   1032: aload_0
    //   1033: ldc 175
    //   1035: invokevirtual 131	com/tencent/netdemo/SimpleURLImageActivity:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   1038: astore_3
    //   1039: aload_1
    //   1040: new 133	java/net/URL
    //   1043: dup
    //   1044: new 135	java/lang/StringBuilder
    //   1047: dup
    //   1048: ldc 137
    //   1050: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1053: aload_3
    //   1054: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1057: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokespecial 154	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1066: iconst_0
    //   1067: iconst_0
    //   1068: aconst_null
    //   1069: aconst_null
    //   1070: iconst_1
    //   1071: fconst_0
    //   1072: invokestatic 157	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZF)Lcom/tencent/image/URLDrawable;
    //   1075: invokevirtual 161	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1078: return
    //   1079: astore_1
    //   1080: aload_0
    //   1081: invokevirtual 77	com/tencent/netdemo/SimpleURLImageActivity:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   1084: aload_0
    //   1085: invokevirtual 180	android/view/LayoutInflater:setFactory	(Landroid/view/LayoutInflater$Factory;)V
    //   1088: goto -1065 -> 23
    //   1091: aload 6
    //   1093: astore 4
    //   1095: aload 7
    //   1097: astore_1
    //   1098: aload 6
    //   1100: astore 5
    //   1102: aload 7
    //   1104: astore_3
    //   1105: aload 7
    //   1107: aload 9
    //   1109: iconst_0
    //   1110: iload_2
    //   1111: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   1114: goto -1027 -> 87
    //   1117: astore 6
    //   1119: aload 4
    //   1121: astore 5
    //   1123: aload_1
    //   1124: astore_3
    //   1125: aload 6
    //   1127: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1130: aload 4
    //   1132: ifnull +8 -> 1140
    //   1135: aload 4
    //   1137: invokevirtual 119	java/io/InputStream:close	()V
    //   1140: aload_1
    //   1141: ifnull -989 -> 152
    //   1144: aload_1
    //   1145: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1148: goto -996 -> 152
    //   1151: astore_1
    //   1152: goto -1000 -> 152
    //   1155: astore_1
    //   1156: aload 5
    //   1158: ifnull +8 -> 1166
    //   1161: aload 5
    //   1163: invokevirtual 119	java/io/InputStream:close	()V
    //   1166: aload_3
    //   1167: ifnull +7 -> 1174
    //   1170: aload_3
    //   1171: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1174: aload_1
    //   1175: athrow
    //   1176: astore_1
    //   1177: aload_1
    //   1178: invokevirtual 188	java/net/MalformedURLException:printStackTrace	()V
    //   1181: goto -973 -> 208
    //   1184: aload 6
    //   1186: astore 4
    //   1188: aload 7
    //   1190: astore_1
    //   1191: aload 6
    //   1193: astore 5
    //   1195: aload 7
    //   1197: astore_3
    //   1198: aload 7
    //   1200: aload 9
    //   1202: iconst_0
    //   1203: iload_2
    //   1204: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   1207: goto -941 -> 266
    //   1210: astore 6
    //   1212: aload 4
    //   1214: astore 5
    //   1216: aload_1
    //   1217: astore_3
    //   1218: aload 6
    //   1220: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1223: aload 4
    //   1225: ifnull +8 -> 1233
    //   1228: aload 4
    //   1230: invokevirtual 119	java/io/InputStream:close	()V
    //   1233: aload_1
    //   1234: ifnull -903 -> 331
    //   1237: aload_1
    //   1238: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1241: goto -910 -> 331
    //   1244: astore_1
    //   1245: goto -914 -> 331
    //   1248: astore_1
    //   1249: aload 5
    //   1251: ifnull +8 -> 1259
    //   1254: aload 5
    //   1256: invokevirtual 119	java/io/InputStream:close	()V
    //   1259: aload_3
    //   1260: ifnull +7 -> 1267
    //   1263: aload_3
    //   1264: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1267: aload_1
    //   1268: athrow
    //   1269: astore_1
    //   1270: aload_1
    //   1271: invokevirtual 188	java/net/MalformedURLException:printStackTrace	()V
    //   1274: goto -884 -> 390
    //   1277: aload 6
    //   1279: astore 4
    //   1281: aload 7
    //   1283: astore_1
    //   1284: aload 6
    //   1286: astore 5
    //   1288: aload 7
    //   1290: astore_3
    //   1291: aload 7
    //   1293: aload 9
    //   1295: iconst_0
    //   1296: iload_2
    //   1297: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   1300: goto -852 -> 448
    //   1303: astore 6
    //   1305: aload 4
    //   1307: astore 5
    //   1309: aload_1
    //   1310: astore_3
    //   1311: aload 6
    //   1313: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1316: aload 4
    //   1318: ifnull +8 -> 1326
    //   1321: aload 4
    //   1323: invokevirtual 119	java/io/InputStream:close	()V
    //   1326: aload_1
    //   1327: ifnull -814 -> 513
    //   1330: aload_1
    //   1331: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1334: goto -821 -> 513
    //   1337: astore_1
    //   1338: goto -825 -> 513
    //   1341: astore_1
    //   1342: aload 5
    //   1344: ifnull +8 -> 1352
    //   1347: aload 5
    //   1349: invokevirtual 119	java/io/InputStream:close	()V
    //   1352: aload_3
    //   1353: ifnull +7 -> 1360
    //   1356: aload_3
    //   1357: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1360: aload_1
    //   1361: athrow
    //   1362: astore_1
    //   1363: aload_1
    //   1364: invokevirtual 188	java/net/MalformedURLException:printStackTrace	()V
    //   1367: goto -793 -> 574
    //   1370: aload 6
    //   1372: astore 4
    //   1374: aload 7
    //   1376: astore_1
    //   1377: aload 6
    //   1379: astore 5
    //   1381: aload 7
    //   1383: astore_3
    //   1384: aload 7
    //   1386: aload 9
    //   1388: iconst_0
    //   1389: iload_2
    //   1390: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   1393: goto -761 -> 632
    //   1396: astore 6
    //   1398: aload 4
    //   1400: astore 5
    //   1402: aload_1
    //   1403: astore_3
    //   1404: aload 6
    //   1406: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1409: aload 4
    //   1411: ifnull +8 -> 1419
    //   1414: aload 4
    //   1416: invokevirtual 119	java/io/InputStream:close	()V
    //   1419: aload_1
    //   1420: ifnull -723 -> 697
    //   1423: aload_1
    //   1424: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1427: goto -730 -> 697
    //   1430: astore_1
    //   1431: goto -734 -> 697
    //   1434: astore_1
    //   1435: aload 5
    //   1437: ifnull +8 -> 1445
    //   1440: aload 5
    //   1442: invokevirtual 119	java/io/InputStream:close	()V
    //   1445: aload_3
    //   1446: ifnull +7 -> 1453
    //   1449: aload_3
    //   1450: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1453: aload_1
    //   1454: athrow
    //   1455: astore_1
    //   1456: aload_1
    //   1457: invokevirtual 188	java/net/MalformedURLException:printStackTrace	()V
    //   1460: goto -702 -> 758
    //   1463: aload 6
    //   1465: astore 4
    //   1467: aload 7
    //   1469: astore_1
    //   1470: aload 6
    //   1472: astore 5
    //   1474: aload 7
    //   1476: astore_3
    //   1477: aload 7
    //   1479: aload 9
    //   1481: iconst_0
    //   1482: iload_2
    //   1483: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   1486: goto -670 -> 816
    //   1489: astore 6
    //   1491: aload 4
    //   1493: astore 5
    //   1495: aload_1
    //   1496: astore_3
    //   1497: aload 6
    //   1499: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1502: aload 4
    //   1504: ifnull +8 -> 1512
    //   1507: aload 4
    //   1509: invokevirtual 119	java/io/InputStream:close	()V
    //   1512: aload_1
    //   1513: ifnull -632 -> 881
    //   1516: aload_1
    //   1517: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1520: goto -639 -> 881
    //   1523: astore_1
    //   1524: goto -643 -> 881
    //   1527: astore_1
    //   1528: aload 5
    //   1530: ifnull +8 -> 1538
    //   1533: aload 5
    //   1535: invokevirtual 119	java/io/InputStream:close	()V
    //   1538: aload_3
    //   1539: ifnull +7 -> 1546
    //   1542: aload_3
    //   1543: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1546: aload_1
    //   1547: athrow
    //   1548: astore_1
    //   1549: aload_1
    //   1550: invokevirtual 188	java/net/MalformedURLException:printStackTrace	()V
    //   1553: goto -614 -> 939
    //   1556: aload 4
    //   1558: astore_3
    //   1559: aload 4
    //   1561: astore_1
    //   1562: aload 4
    //   1564: aload 6
    //   1566: iconst_0
    //   1567: iload_2
    //   1568: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   1571: goto -588 -> 983
    //   1574: astore 4
    //   1576: aload_3
    //   1577: astore_1
    //   1578: aload 4
    //   1580: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   1583: aload_3
    //   1584: ifnull -562 -> 1022
    //   1587: aload_3
    //   1588: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1591: goto -569 -> 1022
    //   1594: astore_1
    //   1595: goto -573 -> 1022
    //   1598: astore_3
    //   1599: aload_1
    //   1600: ifnull +7 -> 1607
    //   1603: aload_1
    //   1604: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   1607: aload_3
    //   1608: athrow
    //   1609: astore_1
    //   1610: aload_1
    //   1611: invokevirtual 188	java/net/MalformedURLException:printStackTrace	()V
    //   1614: return
    //   1615: astore_3
    //   1616: goto -476 -> 1140
    //   1619: astore 4
    //   1621: goto -455 -> 1166
    //   1624: astore_3
    //   1625: goto -451 -> 1174
    //   1628: astore_1
    //   1629: goto -1487 -> 142
    //   1632: astore_1
    //   1633: goto -1481 -> 152
    //   1636: astore_3
    //   1637: goto -404 -> 1233
    //   1640: astore 4
    //   1642: goto -383 -> 1259
    //   1645: astore_3
    //   1646: goto -379 -> 1267
    //   1649: astore_1
    //   1650: goto -1329 -> 321
    //   1653: astore_1
    //   1654: goto -1323 -> 331
    //   1657: astore_3
    //   1658: goto -332 -> 1326
    //   1661: astore 4
    //   1663: goto -311 -> 1352
    //   1666: astore_3
    //   1667: goto -307 -> 1360
    //   1670: astore_1
    //   1671: goto -1168 -> 503
    //   1674: astore_1
    //   1675: goto -1162 -> 513
    //   1678: astore_3
    //   1679: goto -260 -> 1419
    //   1682: astore 4
    //   1684: goto -239 -> 1445
    //   1687: astore_3
    //   1688: goto -235 -> 1453
    //   1691: astore_1
    //   1692: goto -1005 -> 687
    //   1695: astore_1
    //   1696: goto -999 -> 697
    //   1699: astore_3
    //   1700: goto -188 -> 1512
    //   1703: astore 4
    //   1705: goto -167 -> 1538
    //   1708: astore_3
    //   1709: goto -163 -> 1546
    //   1712: astore_1
    //   1713: goto -842 -> 871
    //   1716: astore_1
    //   1717: goto -836 -> 881
    //   1720: astore_1
    //   1721: goto -114 -> 1607
    //   1724: astore_1
    //   1725: goto -703 -> 1022
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1728	0	this	SimpleURLImageActivity
    //   0	1728	1	paramBundle	android.os.Bundle
    //   108	1460	2	i	int
    //   52	1536	3	localObject1	java.lang.Object
    //   1598	10	3	localObject2	java.lang.Object
    //   1615	1	3	localIOException1	java.io.IOException
    //   1624	1	3	localIOException2	java.io.IOException
    //   1636	1	3	localIOException3	java.io.IOException
    //   1645	1	3	localIOException4	java.io.IOException
    //   1657	1	3	localIOException5	java.io.IOException
    //   1666	1	3	localIOException6	java.io.IOException
    //   1678	1	3	localIOException7	java.io.IOException
    //   1687	1	3	localIOException8	java.io.IOException
    //   1699	1	3	localIOException9	java.io.IOException
    //   1708	1	3	localIOException10	java.io.IOException
    //   33	1530	4	localObject3	java.lang.Object
    //   1574	5	4	localIOException11	java.io.IOException
    //   1619	1	4	localIOException12	java.io.IOException
    //   1640	1	4	localIOException13	java.io.IOException
    //   1661	1	4	localIOException14	java.io.IOException
    //   1682	1	4	localIOException15	java.io.IOException
    //   1703	1	4	localIOException16	java.io.IOException
    //   30	1504	5	localObject4	java.lang.Object
    //   62	1037	6	localObject5	java.lang.Object
    //   1117	75	6	localIOException17	java.io.IOException
    //   1210	75	6	localIOException18	java.io.IOException
    //   1303	75	6	localIOException19	java.io.IOException
    //   1396	75	6	localIOException20	java.io.IOException
    //   1489	76	6	localIOException21	java.io.IOException
    //   39	1439	7	localObject6	java.lang.Object
    //   36	769	8	localObject7	java.lang.Object
    //   45	1435	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	23	1079	java/lang/Throwable
    //   53	64	1117	java/io/IOException
    //   78	87	1117	java/io/IOException
    //   101	109	1117	java/io/IOException
    //   127	132	1117	java/io/IOException
    //   1105	1114	1117	java/io/IOException
    //   1144	1148	1151	java/io/IOException
    //   53	64	1155	finally
    //   78	87	1155	finally
    //   101	109	1155	finally
    //   127	132	1155	finally
    //   1105	1114	1155	finally
    //   1125	1130	1155	finally
    //   169	208	1176	java/net/MalformedURLException
    //   232	243	1210	java/io/IOException
    //   257	266	1210	java/io/IOException
    //   280	288	1210	java/io/IOException
    //   306	311	1210	java/io/IOException
    //   1198	1207	1210	java/io/IOException
    //   1237	1241	1244	java/io/IOException
    //   232	243	1248	finally
    //   257	266	1248	finally
    //   280	288	1248	finally
    //   306	311	1248	finally
    //   1198	1207	1248	finally
    //   1218	1223	1248	finally
    //   348	390	1269	java/net/MalformedURLException
    //   414	425	1303	java/io/IOException
    //   439	448	1303	java/io/IOException
    //   462	470	1303	java/io/IOException
    //   488	493	1303	java/io/IOException
    //   1291	1300	1303	java/io/IOException
    //   1330	1334	1337	java/io/IOException
    //   414	425	1341	finally
    //   439	448	1341	finally
    //   462	470	1341	finally
    //   488	493	1341	finally
    //   1291	1300	1341	finally
    //   1311	1316	1341	finally
    //   530	574	1362	java/net/MalformedURLException
    //   598	609	1396	java/io/IOException
    //   623	632	1396	java/io/IOException
    //   646	654	1396	java/io/IOException
    //   672	677	1396	java/io/IOException
    //   1384	1393	1396	java/io/IOException
    //   1423	1427	1430	java/io/IOException
    //   598	609	1434	finally
    //   623	632	1434	finally
    //   646	654	1434	finally
    //   672	677	1434	finally
    //   1384	1393	1434	finally
    //   1404	1409	1434	finally
    //   714	758	1455	java/net/MalformedURLException
    //   782	793	1489	java/io/IOException
    //   807	816	1489	java/io/IOException
    //   830	838	1489	java/io/IOException
    //   856	861	1489	java/io/IOException
    //   1477	1486	1489	java/io/IOException
    //   1516	1520	1523	java/io/IOException
    //   782	793	1527	finally
    //   807	816	1527	finally
    //   830	838	1527	finally
    //   856	861	1527	finally
    //   1477	1486	1527	finally
    //   1497	1502	1527	finally
    //   898	939	1548	java/net/MalformedURLException
    //   957	968	1574	java/io/IOException
    //   974	983	1574	java/io/IOException
    //   989	997	1574	java/io/IOException
    //   1007	1012	1574	java/io/IOException
    //   1562	1571	1574	java/io/IOException
    //   1587	1591	1594	java/io/IOException
    //   957	968	1598	finally
    //   974	983	1598	finally
    //   989	997	1598	finally
    //   1007	1012	1598	finally
    //   1562	1571	1598	finally
    //   1578	1583	1598	finally
    //   1039	1078	1609	java/net/MalformedURLException
    //   1135	1140	1615	java/io/IOException
    //   1161	1166	1619	java/io/IOException
    //   1170	1174	1624	java/io/IOException
    //   137	142	1628	java/io/IOException
    //   147	152	1632	java/io/IOException
    //   1228	1233	1636	java/io/IOException
    //   1254	1259	1640	java/io/IOException
    //   1263	1267	1645	java/io/IOException
    //   316	321	1649	java/io/IOException
    //   326	331	1653	java/io/IOException
    //   1321	1326	1657	java/io/IOException
    //   1347	1352	1661	java/io/IOException
    //   1356	1360	1666	java/io/IOException
    //   498	503	1670	java/io/IOException
    //   508	513	1674	java/io/IOException
    //   1414	1419	1678	java/io/IOException
    //   1440	1445	1682	java/io/IOException
    //   1449	1453	1687	java/io/IOException
    //   682	687	1691	java/io/IOException
    //   692	697	1695	java/io/IOException
    //   1507	1512	1699	java/io/IOException
    //   1533	1538	1703	java/io/IOException
    //   1542	1546	1708	java/io/IOException
    //   866	871	1712	java/io/IOException
    //   876	881	1716	java/io/IOException
    //   1603	1607	1720	java/io/IOException
    //   1017	1022	1724	java/io/IOException
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  @TargetApi(11)
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ("URLImageView".equals(paramString)) {
      return new URLImageView(paramContext, paramAttributeSet);
    }
    return super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ("URLImageView".equals(paramString)) {
      return new URLImageView(paramContext, paramAttributeSet);
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.netdemo.SimpleURLImageActivity
 * JD-Core Version:    0.7.0.1
 */