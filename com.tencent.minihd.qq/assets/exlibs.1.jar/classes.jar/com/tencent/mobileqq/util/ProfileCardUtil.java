package com.tencent.mobileqq.util;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardBackground;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kqb;
import kqc;
import kqd;
import kqg;
import pttcenterservice.PttCenter.ServerListInfo;

public class ProfileCardUtil
{
  public static final int A = 15;
  public static final String A = "0X80044DF";
  public static final int B = 16;
  public static final String B = "0X80044E0";
  public static final int C = 17;
  public static final String C = "VIP_profilecard";
  public static final int D = 160;
  public static final String D = "profileCardDownload";
  public static final String E = "profileCardSet";
  public static final String F = "profileCardGet";
  public static final String G = "profileCardSendFavorite";
  public static final String H = "profileCardTimeStat";
  public static final String I = "inside.myCardBackground";
  public static final String J = "inside.myCardButton";
  public static final String K = "inside.myIndividuation";
  public static final String L = "inside.blackBar";
  public static final String M = "inside.friendCardBackground";
  public static final String N = "inside.defaultStyle";
  public static final String O = "1";
  public static final String P = "2";
  public static final String Q = "pttcenter_filepath";
  public static final String R = "pttcenter_shDuration";
  public static final String S = "pttcenter_cmd";
  public static final String T = "pttcenter_filekey";
  public static final String U = "pttcenter_selfuin";
  public static final String V = "pttcenter_targetuin";
  public static final String W = "pttcenter_voice_optype";
  private static String X = null;
  public static final int a = 100;
  public static final long a = 0L;
  public static final String a = "Q.profilecard.Troop";
  protected static HashMap a;
  public static final boolean a = true;
  public static final int b = 640;
  protected static long b = 0L;
  public static final String b = "Q.profilecard.SummaryCard";
  private static boolean b = false;
  public static final int c = 482;
  private static final long c = 614400L;
  public static final String c = "Q.profilecard.FrdProfileCard";
  public static final int d = -1;
  public static final String d = "Q.profilecard.MicroPhone";
  public static final int e = 0;
  public static final String e = "Q.profilecard.VoicePlayer";
  public static final int f = 1;
  public static final String f = "Q.profilecard.Avatar";
  public static final int g = 2;
  public static final String g = "Q.profilecard.TResource";
  public static final int h = 0;
  public static final String h = "Q.profilecard.VoiceIntro";
  public static final int i = 1;
  public static final String i = "Q.profilecard.PhotoWall";
  public static final int j = 1;
  public static final String j = "Q.profilecard.PhotoWall.Bg";
  public static final int k = 3;
  public static final String k = "Q.profilecard.Detail";
  public static final int l = 0;
  public static final String l = "Q.profilecard.PhotoWall.Trans";
  public static final int m = 1;
  public static final String m = "Q.profilecard.VoiceIntro.Trans";
  public static final int n = 2;
  public static final String n = "Q.profilecard.Visitor";
  public static final int o = 3;
  public static final String o = "ProfileCard.setcard";
  public static final int p = 4;
  public static final String p = "mvip.gongneng.android.mingpian_zhuangbanopen";
  public static final int q = 5;
  public static final String q = "mvip.gongneng.android.mingpian_urlopen";
  public static final int r = 6;
  public static final String r = "profilecard";
  public static final int s = 7;
  public static final String s = "is_template_list_loaded";
  public static final int t = 8;
  public static final String t = "labelList";
  public static final int u = 9;
  public static final String u = "profilecard_sp_file";
  public static final int v = 10;
  public static final String v = "user_visited_profile_browser";
  public static final int w = 11;
  public static final String w = "https://imgcache.qq.com/club/client/card/rel/mall_v54.html?_bid=238&closeSpecialLogic=1&ADTAG=%1$s&sid=%2$s&isCache=%3$s&entryId=%4$s&tabId=%5$s&_wv=5123";
  public static final int x = 12;
  public static final String x = "https://imgcache.qq.com/club/client/card/rel/active.html?_bid=238&bgId=%1$s&ADTAG=inside.myCardBackground&_wv=5123";
  public static final int y = 13;
  public static final String y = "0X8004436";
  public static final int z = 14;
  public static final String z = "0X8004437";
  
  static
  {
    jdField_b_of_type_Boolean = false;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(640, Math.min(paramInt1, paramInt2) - 10);
  }
  
  public static int a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public static int a(Context paramContext)
  {
    int i1 = a(paramContext.getResources());
    return (int)((paramContext.getResources().getDisplayMetrics().heightPixels - i1) * 0.75F);
  }
  
  public static final int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static final int a(Context paramContext, int paramInt)
  {
    return (int)Math.ceil(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static final int a(Resources paramResources)
  {
    try
    {
      int i1 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i1;
    }
    catch (Exception localException) {}
    return (int)(paramResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    int i1 = 0;
    if (paramAllInOne == null) {
      return 1001;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {}
    for (;;)
    {
      return i1;
      if ((paramAllInOne.jdField_a_of_type_Int == 22) || (paramAllInOne.jdField_a_of_type_Int == 21)) {
        i1 = 1000;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 42)) {
        i1 = 1001;
      } else if (paramAllInOne.jdField_a_of_type_Int == 3) {
        i1 = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 2) {
        i1 = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 74) {
        i1 = 1023;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 32) || (paramAllInOne.jdField_a_of_type_Int == 31) || (paramAllInOne.jdField_a_of_type_Int == 51) || (paramAllInOne.jdField_a_of_type_Int == 50) || (paramAllInOne.jdField_a_of_type_Int == 34)) {
        i1 = 1006;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 46) || (paramAllInOne.jdField_a_of_type_Int == 47)) {
        i1 = 1004;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 56) || (paramAllInOne.jdField_a_of_type_Int == 57)) {
        i1 = 1009;
      } else if (paramAllInOne.jdField_a_of_type_Int == 58) {
        i1 = 1020;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 71) || (paramAllInOne.jdField_a_of_type_Int == 72)) {
        i1 = 1021;
      } else if (paramAllInOne.jdField_a_of_type_Int != 70) {
        if (paramAllInOne.jdField_a_of_type_Int == 27) {
          i1 = 1022;
        } else if ((paramAllInOne.jdField_a_of_type_Int == 75) || (paramAllInOne.jdField_a_of_type_Int == 76)) {
          i1 = 1010;
        } else {
          i1 = 1001;
        }
      }
    }
  }
  
  public static int a(String paramString)
  {
    int i6 = 0;
    int i2 = 0;
    long l1 = System.currentTimeMillis();
    paramString = a(paramString, 100, 0.56338F);
    if (paramString == null) {}
    int i1;
    do
    {
      return i2;
      int i3 = 0;
      int i5 = 0;
      i2 = 0;
      while (i3 < paramString.getHeight())
      {
        int i4 = 0;
        i1 = i5;
        if (i4 < paramString.getWidth())
        {
          i5 = paramString.getPixel(i4, i3);
          int i7 = Color.red(i5);
          int i8 = Color.green(i5);
          if ((Color.blue(i5) + (i7 + i8)) / 3 > 127)
          {
            i5 = i2 + 1;
            i2 = i1;
          }
          for (i1 = i5;; i1 = i5)
          {
            i5 = i4 + 1;
            i4 = i1;
            i1 = i2;
            i2 = i4;
            i4 = i5;
            break;
            i5 = i2;
            i2 = i1 + 1;
          }
        }
        i3 += 1;
        i5 = i1;
      }
      i1 = i6;
      if (i2 >= i5) {
        i1 = 1;
      }
      paramString.recycle();
      i2 = i1;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCardUtil", 2, "-->calculate background color cost:" + (System.currentTimeMillis() - l1) + "(ms)");
    return i1;
  }
  
  public static long a()
  {
    return System.currentTimeMillis() - jdField_b_of_type_Long;
  }
  
  public static long a(Context paramContext, String paramString)
  {
    return MediaPlayer.create(paramContext, Uri.parse(paramString)).getDuration() / 1000;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramQQAppInterface == null) || (paramAllInOne == null)) {
      return 0L;
    }
    if ((paramAllInOne.jdField_c_of_type_JavaLangString != null) && (paramAllInOne.jdField_c_of_type_JavaLangString.length() > 0)) {
      paramQQAppInterface = paramAllInOne.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      paramAllInOne = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramAllInOne = "0";
      }
      try
      {
        long l1 = Long.valueOf(paramAllInOne).longValue();
        return l1;
      }
      catch (Exception paramQQAppInterface)
      {
        return 0L;
      }
      if ((paramAllInOne.d != null) && (paramAllInOne.d.length() > 0))
      {
        paramQQAppInterface = (TroopInfo)paramQQAppInterface.a().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { paramAllInOne.d });
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.troopuin;
          continue;
        }
      }
      paramQQAppInterface = "0";
    }
  }
  
  public static Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    paramString = new File(paramString);
    if ((paramString == null) || (!paramString.exists()) || (paramString.length() <= 0L) || (paramString.isDirectory())) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeStream(new FileInputStream(paramString));
        if (localBitmap == null) {
          return null;
        }
        int i1 = localBitmap.getWidth();
        int i2 = localBitmap.getHeight();
        paramString = localBitmap;
        if (i1 > paramInt)
        {
          int i3 = (int)(paramInt / paramFloat);
          paramString = new Matrix();
          paramString.postScale(paramInt / i1, i3 / i2);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, i1, i2, paramString, true);
          localBitmap.recycle();
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  /* Error */
  public static SpannableString a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +66 -> 67
    //   4: new 464	android/text/SpannableString
    //   7: dup
    //   8: ldc_w 466
    //   11: invokespecial 469	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   14: astore 10
    //   16: aload_0
    //   17: invokevirtual 235	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: ldc_w 470
    //   23: invokevirtual 474	android/content/res/Resources:getDimension	(I)F
    //   26: f2i
    //   27: istore_1
    //   28: aload_0
    //   29: invokevirtual 235	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   32: ldc_w 475
    //   35: invokevirtual 479	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_0
    //   41: iconst_0
    //   42: iload_1
    //   43: iload_1
    //   44: invokevirtual 485	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   47: aload 10
    //   49: new 487	android/text/style/ImageSpan
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 490	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   57: iconst_0
    //   58: iconst_1
    //   59: bipush 33
    //   61: invokevirtual 494	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   64: aload 10
    //   66: areturn
    //   67: iload_2
    //   68: bipush 64
    //   70: idiv
    //   71: istore 6
    //   73: iload_2
    //   74: bipush 64
    //   76: irem
    //   77: istore_2
    //   78: iload_2
    //   79: bipush 16
    //   81: idiv
    //   82: istore 7
    //   84: iload_2
    //   85: bipush 16
    //   87: irem
    //   88: istore 9
    //   90: iload 9
    //   92: iconst_4
    //   93: idiv
    //   94: istore 8
    //   96: ldc_w 496
    //   99: astore 11
    //   101: iconst_0
    //   102: istore 4
    //   104: iload 4
    //   106: iconst_4
    //   107: if_icmpge +136 -> 243
    //   110: iconst_0
    //   111: istore_2
    //   112: ldc_w 496
    //   115: astore 10
    //   117: iload 4
    //   119: tableswitch	default:+29 -> 148, 0:+69->188, 1:+80->199, 2:+91->210, 3:+102->221
    //   149: istore 5
    //   151: iload 5
    //   153: iload_2
    //   154: if_icmpge +80 -> 234
    //   157: new 341	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   164: aload 11
    //   166: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 10
    //   171: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 11
    //   179: iload 5
    //   181: iconst_1
    //   182: iadd
    //   183: istore 5
    //   185: goto -34 -> 151
    //   188: ldc_w 498
    //   191: astore 10
    //   193: iload 6
    //   195: istore_2
    //   196: goto -48 -> 148
    //   199: ldc_w 500
    //   202: astore 10
    //   204: iload 7
    //   206: istore_2
    //   207: goto -59 -> 148
    //   210: ldc_w 502
    //   213: astore 10
    //   215: iload 8
    //   217: istore_2
    //   218: goto -70 -> 148
    //   221: ldc_w 504
    //   224: astore 10
    //   226: iload 9
    //   228: iconst_4
    //   229: irem
    //   230: istore_2
    //   231: goto -83 -> 148
    //   234: iload 4
    //   236: iconst_1
    //   237: iadd
    //   238: istore 4
    //   240: goto -136 -> 104
    //   243: iload_3
    //   244: ifeq +489 -> 733
    //   247: aload 11
    //   249: invokevirtual 386	java/lang/String:length	()I
    //   252: iload_1
    //   253: if_icmple +480 -> 733
    //   256: aload 11
    //   258: iconst_0
    //   259: iload_1
    //   260: invokevirtual 508	java/lang/String:substring	(II)Ljava/lang/String;
    //   263: astore 10
    //   265: aload 10
    //   267: astore 14
    //   269: new 464	android/text/SpannableString
    //   272: dup
    //   273: aload 14
    //   275: invokespecial 469	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   278: astore 16
    //   280: aload_0
    //   281: invokevirtual 235	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   284: ldc_w 470
    //   287: invokevirtual 474	android/content/res/Resources:getDimension	(I)F
    //   290: f2i
    //   291: istore 4
    //   293: iconst_0
    //   294: istore_2
    //   295: iload_2
    //   296: aload 14
    //   298: invokevirtual 386	java/lang/String:length	()I
    //   301: if_icmpge +404 -> 705
    //   304: aconst_null
    //   305: astore 13
    //   307: aconst_null
    //   308: astore 15
    //   310: aconst_null
    //   311: astore 12
    //   313: iload_2
    //   314: iload_1
    //   315: iconst_1
    //   316: isub
    //   317: if_icmpne +97 -> 414
    //   320: iload_3
    //   321: iconst_1
    //   322: if_icmpne +92 -> 414
    //   325: aload 13
    //   327: astore 10
    //   329: aload 15
    //   331: astore 11
    //   333: aload_0
    //   334: invokevirtual 235	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 509
    //   340: invokevirtual 479	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   343: astore 12
    //   345: aload 12
    //   347: ifnull +50 -> 397
    //   350: aload 12
    //   352: astore 10
    //   354: aload 12
    //   356: astore 11
    //   358: aload 12
    //   360: iconst_0
    //   361: iconst_0
    //   362: iload 4
    //   364: iload 4
    //   366: invokevirtual 485	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   369: aload 12
    //   371: astore 10
    //   373: aload 12
    //   375: astore 11
    //   377: aload 16
    //   379: new 487	android/text/style/ImageSpan
    //   382: dup
    //   383: aload 12
    //   385: invokespecial 490	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   388: iload_2
    //   389: iload_2
    //   390: iconst_1
    //   391: iadd
    //   392: bipush 33
    //   394: invokevirtual 494	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   397: aload 16
    //   399: areturn
    //   400: astore 10
    //   402: aload 10
    //   404: invokevirtual 512	java/lang/Exception:printStackTrace	()V
    //   407: aload 11
    //   409: astore 14
    //   411: goto -142 -> 269
    //   414: aload 13
    //   416: astore 10
    //   418: aload 15
    //   420: astore 11
    //   422: ldc_w 498
    //   425: aload 14
    //   427: iload_2
    //   428: iload_2
    //   429: iconst_1
    //   430: iadd
    //   431: invokevirtual 508	java/lang/String:substring	(II)Ljava/lang/String;
    //   434: invokevirtual 516	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   437: ifeq +23 -> 460
    //   440: aload 13
    //   442: astore 10
    //   444: aload 15
    //   446: astore 11
    //   448: aload_0
    //   449: invokevirtual 235	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   452: ldc_w 517
    //   455: invokevirtual 479	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   458: astore 12
    //   460: aload 12
    //   462: astore 13
    //   464: aload 12
    //   466: astore 10
    //   468: aload 12
    //   470: astore 11
    //   472: ldc_w 500
    //   475: aload 14
    //   477: iload_2
    //   478: iload_2
    //   479: iconst_1
    //   480: iadd
    //   481: invokevirtual 508	java/lang/String:substring	(II)Ljava/lang/String;
    //   484: invokevirtual 516	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   487: ifeq +23 -> 510
    //   490: aload 12
    //   492: astore 10
    //   494: aload 12
    //   496: astore 11
    //   498: aload_0
    //   499: invokevirtual 235	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   502: ldc_w 518
    //   505: invokevirtual 479	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   508: astore 13
    //   510: aload 13
    //   512: astore 10
    //   514: aload 13
    //   516: astore 11
    //   518: ldc_w 502
    //   521: aload 14
    //   523: iload_2
    //   524: iload_2
    //   525: iconst_1
    //   526: iadd
    //   527: invokevirtual 508	java/lang/String:substring	(II)Ljava/lang/String;
    //   530: invokevirtual 516	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   533: ifeq +193 -> 726
    //   536: aload 13
    //   538: astore 10
    //   540: aload 13
    //   542: astore 11
    //   544: aload_0
    //   545: invokevirtual 235	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   548: ldc_w 519
    //   551: invokevirtual 479	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   554: astore 12
    //   556: aload 12
    //   558: astore 10
    //   560: aload 10
    //   562: astore 11
    //   564: ldc_w 504
    //   567: aload 14
    //   569: iload_2
    //   570: iload_2
    //   571: iconst_1
    //   572: iadd
    //   573: invokevirtual 508	java/lang/String:substring	(II)Ljava/lang/String;
    //   576: invokevirtual 516	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   579: ifeq +15 -> 594
    //   582: aload_0
    //   583: invokevirtual 235	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   586: ldc_w 520
    //   589: invokevirtual 479	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   592: astore 11
    //   594: aload 11
    //   596: astore 10
    //   598: aload 10
    //   600: ifnull +34 -> 634
    //   603: aload 10
    //   605: iconst_0
    //   606: iconst_0
    //   607: iload 4
    //   609: iload 4
    //   611: invokevirtual 485	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   614: aload 16
    //   616: new 487	android/text/style/ImageSpan
    //   619: dup
    //   620: aload 10
    //   622: invokespecial 490	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   625: iload_2
    //   626: iload_2
    //   627: iconst_1
    //   628: iadd
    //   629: bipush 33
    //   631: invokevirtual 494	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   634: iload_2
    //   635: iconst_1
    //   636: iadd
    //   637: istore_2
    //   638: goto -343 -> 295
    //   641: astore 12
    //   643: aload 10
    //   645: astore 11
    //   647: aload 11
    //   649: astore 10
    //   651: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -56 -> 598
    //   657: ldc 99
    //   659: iconst_2
    //   660: aload 12
    //   662: invokevirtual 521	java/lang/Error:toString	()Ljava/lang/String;
    //   665: invokestatic 360	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: aload 11
    //   670: astore 10
    //   672: goto -74 -> 598
    //   675: astore 12
    //   677: aload 11
    //   679: astore 10
    //   681: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   684: ifeq -86 -> 598
    //   687: ldc 99
    //   689: iconst_2
    //   690: aload 12
    //   692: invokevirtual 522	java/lang/Exception:toString	()Ljava/lang/String;
    //   695: invokestatic 360	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: aload 11
    //   700: astore 10
    //   702: goto -104 -> 598
    //   705: aload 16
    //   707: areturn
    //   708: astore 12
    //   710: aload 10
    //   712: astore 11
    //   714: goto -37 -> 677
    //   717: astore 12
    //   719: aload 10
    //   721: astore 11
    //   723: goto -76 -> 647
    //   726: aload 13
    //   728: astore 10
    //   730: goto -170 -> 560
    //   733: aload 11
    //   735: astore 10
    //   737: goto -472 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	paramContext	Context
    //   0	740	1	paramInt1	int
    //   0	740	2	paramInt2	int
    //   0	740	3	paramBoolean	boolean
    //   102	508	4	i1	int
    //   149	35	5	i2	int
    //   71	123	6	i3	int
    //   82	123	7	i4	int
    //   94	122	8	i5	int
    //   88	142	9	i6	int
    //   14	358	10	localObject1	Object
    //   400	3	10	localException1	Exception
    //   416	320	10	localObject2	Object
    //   99	635	11	localObject3	Object
    //   311	246	12	localDrawable	Drawable
    //   641	20	12	localError1	java.lang.Error
    //   675	16	12	localException2	Exception
    //   708	1	12	localException3	Exception
    //   717	1	12	localError2	java.lang.Error
    //   305	422	13	localObject4	Object
    //   267	301	14	localObject5	Object
    //   308	137	15	localObject6	Object
    //   278	428	16	localSpannableString	SpannableString
    // Exception table:
    //   from	to	target	type
    //   247	265	400	java/lang/Exception
    //   333	345	641	java/lang/Error
    //   358	369	641	java/lang/Error
    //   377	397	641	java/lang/Error
    //   422	440	641	java/lang/Error
    //   448	460	641	java/lang/Error
    //   472	490	641	java/lang/Error
    //   498	510	641	java/lang/Error
    //   518	536	641	java/lang/Error
    //   544	556	641	java/lang/Error
    //   333	345	675	java/lang/Exception
    //   358	369	675	java/lang/Exception
    //   377	397	675	java/lang/Exception
    //   422	440	675	java/lang/Exception
    //   448	460	675	java/lang/Exception
    //   472	490	675	java/lang/Exception
    //   498	510	675	java/lang/Exception
    //   518	536	675	java/lang/Exception
    //   544	556	675	java/lang/Exception
    //   564	594	708	java/lang/Exception
    //   564	594	717	java/lang/Error
  }
  
  public static Card a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = null;
    int i1 = 0;
    byte b2 = 1;
    for (;;)
    {
      FriendsManagerImp localFriendsManagerImp;
      try
      {
        localFriendsManagerImp = (FriendsManagerImp)paramQQAppInterface.getManager(8);
        if (localFriendsManagerImp == null) {
          break label413;
        }
        localObject1 = localFriendsManagerImp.c(paramString);
        paramQQAppInterface = localFriendsManagerImp.a(paramString);
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = new Card();
          paramQQAppInterface.uin = paramString;
          paramQQAppInterface.shGender = -1;
          if (localObject1 != null)
          {
            paramQQAppInterface.strSign = ((Friends)localObject1).signature;
            paramQQAppInterface.strNick = ((Friends)localObject1).name;
            paramQQAppInterface.strReMark = ((Friends)localObject1).remark;
            paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
            if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
            {
              b1 = 1;
              paramQQAppInterface.bQQVipOpen = b1;
              if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
              {
                b1 = 1;
                paramQQAppInterface.bSuperVipOpen = b1;
                if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                  continue;
                }
                b1 = b2;
                paramQQAppInterface.bSuperQQOpen = b1;
                paramQQAppInterface.iQQVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP);
                paramQQAppInterface.iSuperVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERVIP);
                paramQQAppInterface.iSuperQQType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERQQ);
                paramQQAppInterface.iQQVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
                paramQQAppInterface.iSuperVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
                paramQQAppInterface.iSuperQQLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERQQ);
                paramQQAppInterface.lUserFlag = ((Friends)localObject1).cSpecialFlag;
                if (localFriendsManagerImp == null) {
                  break label410;
                }
                localFriendsManagerImp.a(paramQQAppInterface);
                if (paramQQAppInterface != null) {
                  paramQQAppInterface.getBusiEntrys();
                }
                return paramQQAppInterface;
              }
            }
            else
            {
              b1 = 0;
              continue;
            }
            byte b1 = 0;
            continue;
            b1 = 0;
            continue;
          }
          paramQQAppInterface.strSign = "";
          paramQQAppInterface.strNick = "";
          paramQQAppInterface.strReMark = "";
          continue;
        }
        if (localObject1 == null) {
          break label407;
        }
      }
      finally {}
      if (!Utils.a(((Friends)localObject1).signature, paramQQAppInterface.strSign))
      {
        paramQQAppInterface.strSign = ((Friends)localObject1).signature;
        i1 = 1;
      }
      if (!Utils.a(((Friends)localObject1).alias, paramQQAppInterface.strShowName))
      {
        paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
        i1 = 1;
      }
      if ((((Friends)localObject1).cSpecialFlag & 0x1) == 1) {
        paramQQAppInterface.lUserFlag |= 1L;
      }
      if ((localFriendsManagerImp != null) && (i1 != 0)) {
        localFriendsManagerImp.a(paramQQAppInterface);
      }
      label407:
      continue;
      label410:
      continue;
      label413:
      Object localObject2 = null;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static ProfileCardTemplate a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int i3 = 0;
    if (paramLong == ProfileCardTemplate.jdField_a_of_type_Long) {
      return null;
    }
    ArrayList localArrayList = a(paramQQAppInterface, true, paramBoolean);
    int i4 = localArrayList.size();
    int i1 = 0;
    paramQQAppInterface = null;
    int i2 = i3;
    if (i1 < i4)
    {
      paramQQAppInterface = (ProfileCardTemplate)localArrayList.get(i1);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.jdField_h_of_type_Long == paramLong)) {
        i2 = 1;
      }
    }
    else
    {
      if ((i2 != 1) || (paramQQAppInterface == null)) {
        break label92;
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      i1 += 1;
      break;
      label92:
      paramQQAppInterface = null;
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_uploading.jpg");
    return localStringBuilder.toString();
  }
  
  public static String a(byte paramByte)
  {
    switch (paramByte)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return "水瓶";
    case 2: 
      return "双鱼";
    case 3: 
      return "白羊";
    case 4: 
      return "金牛";
    case 5: 
      return "双子";
    case 6: 
      return "巨蟹";
    case 7: 
      return "狮子";
    case 8: 
      return "处女";
    case 9: 
      return "天秤";
    case 10: 
      return "天蝎";
    case 11: 
      return "射手";
    }
    return "摩羯";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 2: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    case 3: 
      return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
    case 4: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 5: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    }
    return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "parseUrl() ip = " + paramInt1 + ", port = " + paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramInt1 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 8 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 16 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    localStringBuilder.append(':').append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "parseUrl() url = " + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir("profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_label_config.json" + "5.9.3";
  }
  
  public static String a(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    int i2 = -1;
    Object localObject = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i1;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      label60:
      String str;
      if (i1 == 0)
      {
        paramProfileCardInfo = paramContext.getString(2131366573);
        str = "";
        if (localCard == null) {
          break label485;
        }
        i1 = localCard.age;
        label76:
        if (i1 > 0) {
          str = i1 + paramContext.getString(2131366575);
        }
        localObject = "";
        if (localCard == null) {
          break label501;
        }
        paramContext = (Context)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramContext = (Context)localObject;
          if (!"中国".equals(localCard.strCountry)) {
            paramContext = "" + localCard.strCountry;
          }
        }
        localObject = paramContext;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramContext;
          if (!TextUtils.isEmpty(paramContext)) {
            localObject = paramContext + " ";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramContext = (Context)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramContext = (String)localObject + " ";
          }
          paramContext = paramContext + localCard.strCity;
        }
      }
      for (;;)
      {
        localObject = paramProfileCardInfo;
        if (str != null)
        {
          localObject = paramProfileCardInfo;
          if (str.length() > 0) {
            localObject = paramProfileCardInfo + " " + str;
          }
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (paramContext != null)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (paramContext.length() > 0) {
            paramProfileCardInfo = (String)localObject + " " + paramContext;
          }
        }
        return paramProfileCardInfo;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i1 = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label709;
        }
        i1 = localContactCard.bSex;
        break;
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i1 != 1) {
          break label60;
        }
        paramProfileCardInfo = paramContext.getString(2131366574);
        break label60;
        label485:
        i1 = i2;
        if (localContactCard == null) {
          break label76;
        }
        i1 = localContactCard.bAge;
        break label76;
        label501:
        paramContext = (Context)localObject;
        if (localContactCard != null)
        {
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramContext = (Context)localObject;
            if (!"中国".equals(localContactCard.strCountry)) {
              paramContext = "" + localContactCard.strCountry;
            }
          }
          localObject = paramContext;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramContext;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject = paramContext + " ";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramContext = (Context)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramContext = (Context)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramContext = (String)localObject + " ";
            }
            paramContext = paramContext + localContactCard.strCity;
          }
        }
      }
      label709:
      i1 = -1;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    File localFile;
    do
    {
      return paramContext;
      paramContext = paramContext.getDir("profilecard", 0);
      paramString = (paramContext.getAbsolutePath() + File.separator + paramString).replace(File.separator + File.separator, File.separator);
      localFile = new File(paramString);
      paramContext = paramString;
    } while (localFile.exists());
    localFile.mkdirs();
    return paramString;
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAllInOne != null)
    {
      localObject1 = localObject2;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject1).jdField_c_of_type_JavaLangString;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    String str = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    if (paramLong == -1L) {
      return str + File.separator + "common_" + "53";
    }
    if ((paramLong != ProfileCardTemplate.jdField_a_of_type_Long) && (paramLong > 0L))
    {
      paramQQAppInterface = a(paramQQAppInterface, paramLong, false);
      if (paramQQAppInterface != null) {
        return str + File.separator + paramQQAppInterface.jdField_h_of_type_Long + "_" + paramQQAppInterface.f;
      }
    }
    return null;
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    if (paramByteStringMicro != null)
    {
      byte[] arrayOfByte = new byte[paramByteStringMicro.size()];
      paramByteStringMicro.copyTo(arrayOfByte, 0);
      return c(HexUtil.a(arrayOfByte));
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("HDAvatar").append("/").append(paramString).append(".jpg");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, float paramFloat, TextPaint paramTextPaint)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    int i2 = paramString.length();
    int i1 = i2 / 2;
    for (;;)
    {
      if ((i1 > 0) && (i1 < i2))
      {
        float f1 = paramTextPaint.measureText(paramString, 0, i1);
        if (paramFloat - f1 <= 10.0F) {
          break label135;
        }
        if (paramTextPaint.measureText(paramString, i1, i2) - f1 <= 0.1F) {}
      }
      else
      {
        if ((i1 <= 0) || (i1 >= i2)) {
          break;
        }
        paramTextPaint = new StringBuffer();
        paramTextPaint.append(paramString.substring(0, i1)).append("\n").append(paramString.substring(i1));
        return paramTextPaint.toString();
      }
      i1 -= 1;
      continue;
      label135:
      i1 -= 1;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString1 = MD5.toMD5(paramString1 + paramString2);
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("voice").append("/").append(paramString1).append(".amr");
    return localStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open427";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open429";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open4210";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open428";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open426";
        }
      }
    }
    else if (!paramBoolean2) {
      if (paramInt3 == 2)
      {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open422";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open424";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open425";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open423";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open421";
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open413";
          }
          return "mvip.gongneng.android.mingpian_open412";
        }
        if (paramInt2 == 2) {
          return "mvip.gongneng.android.mingpian_open411";
        }
      }
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return c(HexUtil.a(paramArrayOfByte));
  }
  
  /* Error */
  public static ArrayList a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 809	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore_0
    //   8: aload_0
    //   9: invokestatic 908	com/tencent/mobileqq/util/ProfileCardUtil:b	(Landroid/content/Context;)Ljava/lang/String;
    //   12: astore 7
    //   14: new 648	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 909	java/util/ArrayList:<init>	()V
    //   21: astore 9
    //   23: new 426	java/io/File
    //   26: dup
    //   27: aload 7
    //   29: invokespecial 429	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 7
    //   34: aload 7
    //   36: invokevirtual 432	java/io/File:exists	()Z
    //   39: ifeq +93 -> 132
    //   42: new 439	java/io/FileInputStream
    //   45: dup
    //   46: aload 7
    //   48: invokespecial 442	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: astore_0
    //   52: new 911	java/io/ByteArrayOutputStream
    //   55: dup
    //   56: invokespecial 912	java/io/ByteArrayOutputStream:<init>	()V
    //   59: astore 7
    //   61: sipush 4096
    //   64: newarray byte
    //   66: astore 6
    //   68: aload_0
    //   69: aload 6
    //   71: iconst_0
    //   72: sipush 4096
    //   75: invokevirtual 918	java/io/InputStream:read	([BII)I
    //   78: istore_2
    //   79: iload_2
    //   80: iconst_m1
    //   81: if_icmpeq +65 -> 146
    //   84: aload 7
    //   86: aload 6
    //   88: iconst_0
    //   89: iload_2
    //   90: invokevirtual 922	java/io/ByteArrayOutputStream:write	([BII)V
    //   93: goto -25 -> 68
    //   96: astore 8
    //   98: aload 7
    //   100: astore 6
    //   102: aload 8
    //   104: astore 7
    //   106: aload 7
    //   108: invokevirtual 923	java/lang/Throwable:printStackTrace	()V
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 926	java/io/InputStream:close	()V
    //   119: aload 6
    //   121: ifnull +8 -> 129
    //   124: aload 6
    //   126: invokevirtual 927	java/io/ByteArrayOutputStream:close	()V
    //   129: aload 9
    //   131: areturn
    //   132: aload_0
    //   133: invokevirtual 931	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   136: ldc_w 933
    //   139: invokevirtual 939	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   142: astore_0
    //   143: goto -91 -> 52
    //   146: new 383	java/lang/String
    //   149: dup
    //   150: aload 7
    //   152: invokevirtual 943	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   155: ldc_w 945
    //   158: invokespecial 948	java/lang/String:<init>	([BLjava/lang/String;)V
    //   161: astore 6
    //   163: aload 6
    //   165: ifnull +349 -> 514
    //   168: aload 6
    //   170: invokevirtual 386	java/lang/String:length	()I
    //   173: ifle +341 -> 514
    //   176: new 950	org/json/JSONObject
    //   179: dup
    //   180: aload 6
    //   182: invokespecial 951	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   185: astore 6
    //   187: aload 6
    //   189: ldc_w 953
    //   192: invokevirtual 956	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   195: ifeq +319 -> 514
    //   198: aload 6
    //   200: ldc_w 953
    //   203: invokevirtual 960	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   206: astore 6
    //   208: aload 6
    //   210: invokevirtual 963	org/json/JSONArray:length	()I
    //   213: istore_3
    //   214: iconst_0
    //   215: istore_2
    //   216: iload_2
    //   217: iload_3
    //   218: if_icmpge +296 -> 514
    //   221: aload 6
    //   223: iload_2
    //   224: invokevirtual 967	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   227: astore 8
    //   229: new 969	com/tencent/mobileqq/profile/ProfileCardBackground
    //   232: dup
    //   233: invokespecial 970	com/tencent/mobileqq/profile/ProfileCardBackground:<init>	()V
    //   236: astore 10
    //   238: aload 10
    //   240: aload 8
    //   242: ldc_w 972
    //   245: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   248: putfield 976	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_a_of_type_Int	I
    //   251: aload 10
    //   253: aload 8
    //   255: ldc_w 977
    //   258: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   261: putfield 981	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   264: aload 10
    //   266: aload 8
    //   268: ldc_w 983
    //   271: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   274: putfield 985	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_b_of_type_Int	I
    //   277: aload 10
    //   279: aload 8
    //   281: ldc_w 987
    //   284: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   287: putfield 988	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   290: aload 10
    //   292: aload 8
    //   294: ldc_w 990
    //   297: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   300: putfield 991	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   303: aload 10
    //   305: aload 8
    //   307: ldc_w 993
    //   310: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   313: putfield 995	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_c_of_type_Int	I
    //   316: aload 10
    //   318: aload 8
    //   320: ldc_w 997
    //   323: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   326: putfield 999	com/tencent/mobileqq/profile/ProfileCardBackground:d	I
    //   329: aload 10
    //   331: aload 8
    //   333: ldc_w 1001
    //   336: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   339: putfield 1003	com/tencent/mobileqq/profile/ProfileCardBackground:e	I
    //   342: aload 10
    //   344: aload 8
    //   346: ldc_w 1005
    //   349: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   352: putfield 1007	com/tencent/mobileqq/profile/ProfileCardBackground:f	I
    //   355: aload 10
    //   357: aload 8
    //   359: ldc_w 1009
    //   362: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   365: putfield 1011	com/tencent/mobileqq/profile/ProfileCardBackground:g	I
    //   368: aload 10
    //   370: aload 8
    //   372: ldc_w 1013
    //   375: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   378: putfield 1015	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_h_of_type_Int	I
    //   381: aload 10
    //   383: aload 8
    //   385: ldc_w 1017
    //   388: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   391: putfield 1019	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_i_of_type_Int	I
    //   394: aload 10
    //   396: aload 8
    //   398: ldc_w 1021
    //   401: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   404: putfield 1023	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_j_of_type_Int	I
    //   407: aload 10
    //   409: aload 8
    //   411: ldc_w 1025
    //   414: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   417: putfield 1027	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_k_of_type_Int	I
    //   420: aload 10
    //   422: aload 8
    //   424: ldc_w 1029
    //   427: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   430: putfield 1031	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_m_of_type_Int	I
    //   433: aload 8
    //   435: ldc_w 1033
    //   438: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   441: istore 4
    //   443: iload 4
    //   445: iconst_1
    //   446: if_icmpne +163 -> 609
    //   449: iconst_1
    //   450: istore 5
    //   452: aload 10
    //   454: iload 5
    //   456: putfield 1035	com/tencent/mobileqq/profile/ProfileCardBackground:jdField_a_of_type_Boolean	Z
    //   459: iload_1
    //   460: ifne +12 -> 472
    //   463: iload 4
    //   465: iconst_1
    //   466: if_icmpne +6 -> 472
    //   469: goto +133 -> 602
    //   472: aload 10
    //   474: invokestatic 1038	com/tencent/mobileqq/util/ProfileCardUtil:b	(Lcom/tencent/mobileqq/profile/ProfileCardBackground;)Z
    //   477: ifeq +125 -> 602
    //   480: aload 9
    //   482: aload 10
    //   484: invokevirtual 1041	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   487: pop
    //   488: goto +114 -> 602
    //   491: astore 6
    //   493: aload_0
    //   494: ifnull +7 -> 501
    //   497: aload_0
    //   498: invokevirtual 926	java/io/InputStream:close	()V
    //   501: aload 7
    //   503: ifnull +8 -> 511
    //   506: aload 7
    //   508: invokevirtual 927	java/io/ByteArrayOutputStream:close	()V
    //   511: aload 6
    //   513: athrow
    //   514: aload_0
    //   515: ifnull +7 -> 522
    //   518: aload_0
    //   519: invokevirtual 926	java/io/InputStream:close	()V
    //   522: aload 7
    //   524: ifnull -395 -> 129
    //   527: aload 7
    //   529: invokevirtual 927	java/io/ByteArrayOutputStream:close	()V
    //   532: aload 9
    //   534: areturn
    //   535: astore_0
    //   536: aload_0
    //   537: invokevirtual 1042	java/io/IOException:printStackTrace	()V
    //   540: aload 9
    //   542: areturn
    //   543: astore_0
    //   544: aload_0
    //   545: invokevirtual 1042	java/io/IOException:printStackTrace	()V
    //   548: aload 9
    //   550: areturn
    //   551: astore_0
    //   552: aload_0
    //   553: invokevirtual 1042	java/io/IOException:printStackTrace	()V
    //   556: goto -45 -> 511
    //   559: astore 6
    //   561: aconst_null
    //   562: astore 7
    //   564: aconst_null
    //   565: astore_0
    //   566: goto -73 -> 493
    //   569: astore 6
    //   571: aconst_null
    //   572: astore 7
    //   574: goto -81 -> 493
    //   577: astore 8
    //   579: aload 6
    //   581: astore 7
    //   583: aload 8
    //   585: astore 6
    //   587: goto -94 -> 493
    //   590: astore 7
    //   592: aconst_null
    //   593: astore_0
    //   594: goto -488 -> 106
    //   597: astore 7
    //   599: goto -493 -> 106
    //   602: iload_2
    //   603: iconst_1
    //   604: iadd
    //   605: istore_2
    //   606: goto -390 -> 216
    //   609: iconst_0
    //   610: istore 5
    //   612: goto -160 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	paramQQAppInterface	QQAppInterface
    //   0	615	1	paramBoolean	boolean
    //   78	528	2	i1	int
    //   213	6	3	i2	int
    //   441	26	4	i3	int
    //   450	161	5	bool	boolean
    //   1	221	6	localObject1	Object
    //   491	21	6	localObject2	Object
    //   559	1	6	localObject3	Object
    //   569	11	6	localObject4	Object
    //   585	1	6	localObject5	Object
    //   12	570	7	localObject6	Object
    //   590	1	7	localThrowable1	java.lang.Throwable
    //   597	1	7	localThrowable2	java.lang.Throwable
    //   96	7	8	localThrowable3	java.lang.Throwable
    //   227	207	8	localJSONObject	org.json.JSONObject
    //   577	7	8	localObject7	Object
    //   21	528	9	localArrayList	ArrayList
    //   236	247	10	localProfileCardBackground	ProfileCardBackground
    // Exception table:
    //   from	to	target	type
    //   61	68	96	java/lang/Throwable
    //   68	79	96	java/lang/Throwable
    //   84	93	96	java/lang/Throwable
    //   146	163	96	java/lang/Throwable
    //   168	214	96	java/lang/Throwable
    //   221	443	96	java/lang/Throwable
    //   452	459	96	java/lang/Throwable
    //   472	488	96	java/lang/Throwable
    //   61	68	491	finally
    //   68	79	491	finally
    //   84	93	491	finally
    //   146	163	491	finally
    //   168	214	491	finally
    //   221	443	491	finally
    //   452	459	491	finally
    //   472	488	491	finally
    //   518	522	535	java/io/IOException
    //   527	532	535	java/io/IOException
    //   115	119	543	java/io/IOException
    //   124	129	543	java/io/IOException
    //   497	501	551	java/io/IOException
    //   506	511	551	java/io/IOException
    //   23	52	559	finally
    //   132	143	559	finally
    //   52	61	569	finally
    //   106	111	577	finally
    //   23	52	590	java/lang/Throwable
    //   132	143	590	java/lang/Throwable
    //   52	61	597	java/lang/Throwable
  }
  
  /* Error */
  public static ArrayList a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: invokevirtual 809	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore 7
    //   9: aload 7
    //   11: invokestatic 908	com/tencent/mobileqq/util/ProfileCardUtil:b	(Landroid/content/Context;)Ljava/lang/String;
    //   14: astore 8
    //   16: new 648	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 909	java/util/ArrayList:<init>	()V
    //   23: astore 10
    //   25: new 426	java/io/File
    //   28: dup
    //   29: aload 8
    //   31: invokespecial 429	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 8
    //   36: aload 8
    //   38: invokevirtual 432	java/io/File:exists	()Z
    //   41: ifeq +98 -> 139
    //   44: new 439	java/io/FileInputStream
    //   47: dup
    //   48: aload 8
    //   50: invokespecial 442	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: astore 7
    //   55: new 911	java/io/ByteArrayOutputStream
    //   58: dup
    //   59: invokespecial 912	java/io/ByteArrayOutputStream:<init>	()V
    //   62: astore 8
    //   64: sipush 4096
    //   67: newarray byte
    //   69: astore 9
    //   71: aload 7
    //   73: aload 9
    //   75: iconst_0
    //   76: sipush 4096
    //   79: invokevirtual 918	java/io/InputStream:read	([BII)I
    //   82: istore_3
    //   83: iload_3
    //   84: iconst_m1
    //   85: if_icmpeq +70 -> 155
    //   88: aload 8
    //   90: aload 9
    //   92: iconst_0
    //   93: iload_3
    //   94: invokevirtual 922	java/io/ByteArrayOutputStream:write	([BII)V
    //   97: goto -26 -> 71
    //   100: astore 9
    //   102: aload 7
    //   104: astore_0
    //   105: aload 8
    //   107: astore 7
    //   109: aload 9
    //   111: astore 8
    //   113: aload 8
    //   115: invokevirtual 923	java/lang/Throwable:printStackTrace	()V
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 926	java/io/InputStream:close	()V
    //   126: aload 7
    //   128: ifnull +8 -> 136
    //   131: aload 7
    //   133: invokevirtual 927	java/io/ByteArrayOutputStream:close	()V
    //   136: aload 10
    //   138: areturn
    //   139: aload 7
    //   141: invokevirtual 931	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   144: ldc_w 933
    //   147: invokevirtual 939	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   150: astore 7
    //   152: goto -97 -> 55
    //   155: new 383	java/lang/String
    //   158: dup
    //   159: aload 8
    //   161: invokevirtual 943	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   164: ldc_w 945
    //   167: invokespecial 948	java/lang/String:<init>	([BLjava/lang/String;)V
    //   170: astore 9
    //   172: aload 9
    //   174: invokevirtual 386	java/lang/String:length	()I
    //   177: ifle +594 -> 771
    //   180: new 950	org/json/JSONObject
    //   183: dup
    //   184: aload 9
    //   186: invokespecial 951	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   189: astore 9
    //   191: aload 9
    //   193: ldc_w 1044
    //   196: invokevirtual 956	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   199: ifeq +572 -> 771
    //   202: aload 9
    //   204: ldc_w 1044
    //   207: invokevirtual 960	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   210: astore 9
    //   212: aload 9
    //   214: invokevirtual 963	org/json/JSONArray:length	()I
    //   217: istore 4
    //   219: iconst_0
    //   220: istore_3
    //   221: iload_3
    //   222: iload 4
    //   224: if_icmpge +547 -> 771
    //   227: aload 9
    //   229: iload_3
    //   230: invokevirtual 967	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   233: astore 11
    //   235: new 641	com/tencent/mobileqq/profile/ProfileCardTemplate
    //   238: dup
    //   239: invokespecial 1045	com/tencent/mobileqq/profile/ProfileCardTemplate:<init>	()V
    //   242: astore 12
    //   244: aload 12
    //   246: aload 11
    //   248: ldc_w 972
    //   251: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   254: i2l
    //   255: putfield 657	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_h_of_type_Long	J
    //   258: aload 12
    //   260: aload 11
    //   262: ldc_w 977
    //   265: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   268: putfield 1047	com/tencent/mobileqq/profile/ProfileCardTemplate:e	Ljava/lang/String;
    //   271: aload 12
    //   273: aload 11
    //   275: ldc_w 1049
    //   278: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   281: putfield 824	com/tencent/mobileqq/profile/ProfileCardTemplate:f	Ljava/lang/String;
    //   284: aload 12
    //   286: aload 11
    //   288: ldc_w 993
    //   291: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   294: putfield 1051	com/tencent/mobileqq/profile/ProfileCardTemplate:g	Ljava/lang/String;
    //   297: aload 12
    //   299: aload 11
    //   301: ldc_w 1009
    //   304: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   307: putfield 1052	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Int	I
    //   310: aload 12
    //   312: aload 11
    //   314: ldc_w 1013
    //   317: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   320: putfield 1053	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_Int	I
    //   323: aload 12
    //   325: aload 11
    //   327: ldc_w 1017
    //   330: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   333: putfield 1054	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_c_of_type_Int	I
    //   336: aload 12
    //   338: aload 11
    //   340: ldc_w 1056
    //   343: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: putfield 1058	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   349: aload 12
    //   351: aload 11
    //   353: ldc_w 1060
    //   356: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   359: putfield 1062	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   362: aload 12
    //   364: aload 11
    //   366: ldc_w 1064
    //   369: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   372: putfield 1066	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   375: aload 12
    //   377: aload 11
    //   379: ldc_w 1068
    //   382: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   385: putfield 1070	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   388: aload 12
    //   390: aload 11
    //   392: ldc_w 1072
    //   395: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   398: putfield 1074	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   401: aload 12
    //   403: aload 11
    //   405: ldc_w 1076
    //   408: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   411: putfield 1078	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   414: aload 12
    //   416: aload 11
    //   418: ldc_w 1080
    //   421: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   424: putfield 1082	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_n_of_type_JavaLangString	Ljava/lang/String;
    //   427: aload 12
    //   429: aload 11
    //   431: ldc_w 1084
    //   434: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   437: putfield 1086	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_o_of_type_JavaLangString	Ljava/lang/String;
    //   440: aload 12
    //   442: aload 11
    //   444: ldc_w 1088
    //   447: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   450: putfield 1089	com/tencent/mobileqq/profile/ProfileCardTemplate:d	I
    //   453: aload 12
    //   455: aload 11
    //   457: ldc_w 1091
    //   460: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   463: putfield 1093	com/tencent/mobileqq/profile/ProfileCardTemplate:t	Ljava/lang/String;
    //   466: aload 12
    //   468: aload 11
    //   470: ldc_w 1095
    //   473: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   476: putfield 1097	com/tencent/mobileqq/profile/ProfileCardTemplate:u	Ljava/lang/String;
    //   479: aload 12
    //   481: aload 11
    //   483: ldc_w 1099
    //   486: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   489: putfield 1101	com/tencent/mobileqq/profile/ProfileCardTemplate:v	Ljava/lang/String;
    //   492: aload 12
    //   494: aload 11
    //   496: ldc_w 1103
    //   499: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   502: putfield 1105	com/tencent/mobileqq/profile/ProfileCardTemplate:w	Ljava/lang/String;
    //   505: aload 12
    //   507: aload 11
    //   509: ldc_w 1107
    //   512: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   515: putfield 1109	com/tencent/mobileqq/profile/ProfileCardTemplate:p	Ljava/lang/String;
    //   518: aload 12
    //   520: aload 11
    //   522: ldc_w 1111
    //   525: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   528: putfield 1113	com/tencent/mobileqq/profile/ProfileCardTemplate:r	Ljava/lang/String;
    //   531: aload 12
    //   533: aload 11
    //   535: ldc_w 1115
    //   538: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   541: putfield 1117	com/tencent/mobileqq/profile/ProfileCardTemplate:q	Ljava/lang/String;
    //   544: aload 12
    //   546: aload 11
    //   548: ldc_w 1119
    //   551: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   554: putfield 1121	com/tencent/mobileqq/profile/ProfileCardTemplate:s	Ljava/lang/String;
    //   557: aload 12
    //   559: aload 11
    //   561: ldc_w 1123
    //   564: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   567: putfield 1124	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_k_of_type_Int	I
    //   570: aload 12
    //   572: aload 11
    //   574: ldc_w 1126
    //   577: invokevirtual 980	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   580: putfield 1128	com/tencent/mobileqq/profile/ProfileCardTemplate:x	Ljava/lang/String;
    //   583: aload 12
    //   585: aload 11
    //   587: ldc_w 1130
    //   590: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   593: putfield 1132	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_Int	I
    //   596: aload 12
    //   598: aload 11
    //   600: ldc_w 1134
    //   603: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   606: putfield 1135	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_m_of_type_Int	I
    //   609: aload 12
    //   611: aload 11
    //   613: ldc_w 1137
    //   616: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   619: putfield 1139	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_n_of_type_Int	I
    //   622: aload 12
    //   624: aload 11
    //   626: ldc_w 997
    //   629: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   632: putfield 1140	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_h_of_type_Int	I
    //   635: aload 12
    //   637: aload 11
    //   639: ldc_w 1001
    //   642: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   645: putfield 1141	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_i_of_type_Int	I
    //   648: aload 12
    //   650: aload 11
    //   652: ldc_w 1005
    //   655: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   658: putfield 1142	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_j_of_type_Int	I
    //   661: aload 11
    //   663: ldc_w 1033
    //   666: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   669: istore 5
    //   671: aload 12
    //   673: aload 11
    //   675: ldc_w 1144
    //   678: invokevirtual 975	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   681: putfield 1146	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_o_of_type_Int	I
    //   684: iload 5
    //   686: iconst_1
    //   687: if_icmpne +199 -> 886
    //   690: iconst_1
    //   691: istore 6
    //   693: aload 12
    //   695: iload 6
    //   697: putfield 1147	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Boolean	Z
    //   700: iload_1
    //   701: ifne +12 -> 713
    //   704: iload 5
    //   706: iconst_1
    //   707: if_icmpne +6 -> 713
    //   710: goto +169 -> 879
    //   713: iload_2
    //   714: ifeq +37 -> 751
    //   717: aload 10
    //   719: aload 12
    //   721: invokevirtual 1041	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   724: pop
    //   725: goto +154 -> 879
    //   728: astore_0
    //   729: aload 7
    //   731: ifnull +8 -> 739
    //   734: aload 7
    //   736: invokevirtual 926	java/io/InputStream:close	()V
    //   739: aload 8
    //   741: ifnull +8 -> 749
    //   744: aload 8
    //   746: invokevirtual 927	java/io/ByteArrayOutputStream:close	()V
    //   749: aload_0
    //   750: athrow
    //   751: aload_0
    //   752: aload 12
    //   754: invokestatic 1150	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/profile/ProfileCardTemplate;)Z
    //   757: ifeq +122 -> 879
    //   760: aload 10
    //   762: aload 12
    //   764: invokevirtual 1041	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   767: pop
    //   768: goto +111 -> 879
    //   771: aload 7
    //   773: ifnull +8 -> 781
    //   776: aload 7
    //   778: invokevirtual 926	java/io/InputStream:close	()V
    //   781: aload 8
    //   783: ifnull -647 -> 136
    //   786: aload 8
    //   788: invokevirtual 927	java/io/ByteArrayOutputStream:close	()V
    //   791: aload 10
    //   793: areturn
    //   794: astore_0
    //   795: aload_0
    //   796: invokevirtual 1042	java/io/IOException:printStackTrace	()V
    //   799: aload 10
    //   801: areturn
    //   802: astore_0
    //   803: aload_0
    //   804: invokevirtual 1042	java/io/IOException:printStackTrace	()V
    //   807: aload 10
    //   809: areturn
    //   810: astore 7
    //   812: aload 7
    //   814: invokevirtual 1042	java/io/IOException:printStackTrace	()V
    //   817: goto -68 -> 749
    //   820: astore_0
    //   821: aconst_null
    //   822: astore 8
    //   824: aconst_null
    //   825: astore 7
    //   827: goto -98 -> 729
    //   830: astore_0
    //   831: aconst_null
    //   832: astore 8
    //   834: goto -105 -> 729
    //   837: astore 8
    //   839: aload_0
    //   840: astore 9
    //   842: aload 8
    //   844: astore_0
    //   845: aload 7
    //   847: astore 8
    //   849: aload 9
    //   851: astore 7
    //   853: goto -124 -> 729
    //   856: astore 8
    //   858: aconst_null
    //   859: astore_0
    //   860: aload 9
    //   862: astore 7
    //   864: goto -751 -> 113
    //   867: astore 8
    //   869: aload 7
    //   871: astore_0
    //   872: aload 9
    //   874: astore 7
    //   876: goto -763 -> 113
    //   879: iload_3
    //   880: iconst_1
    //   881: iadd
    //   882: istore_3
    //   883: goto -662 -> 221
    //   886: iconst_0
    //   887: istore 6
    //   889: goto -196 -> 693
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	892	0	paramQQAppInterface	QQAppInterface
    //   0	892	1	paramBoolean1	boolean
    //   0	892	2	paramBoolean2	boolean
    //   82	801	3	i1	int
    //   217	8	4	i2	int
    //   669	39	5	i3	int
    //   691	197	6	bool	boolean
    //   7	770	7	localObject1	Object
    //   810	3	7	localIOException	java.io.IOException
    //   825	50	7	localObject2	Object
    //   14	819	8	localObject3	Object
    //   837	6	8	localObject4	Object
    //   847	1	8	localObject5	Object
    //   856	1	8	localThrowable1	java.lang.Throwable
    //   867	1	8	localThrowable2	java.lang.Throwable
    //   1	90	9	arrayOfByte	byte[]
    //   100	10	9	localThrowable3	java.lang.Throwable
    //   170	703	9	localObject6	Object
    //   23	785	10	localArrayList	ArrayList
    //   233	441	11	localJSONObject	org.json.JSONObject
    //   242	521	12	localProfileCardTemplate	ProfileCardTemplate
    // Exception table:
    //   from	to	target	type
    //   64	71	100	java/lang/Throwable
    //   71	83	100	java/lang/Throwable
    //   88	97	100	java/lang/Throwable
    //   155	219	100	java/lang/Throwable
    //   227	684	100	java/lang/Throwable
    //   693	700	100	java/lang/Throwable
    //   717	725	100	java/lang/Throwable
    //   751	768	100	java/lang/Throwable
    //   64	71	728	finally
    //   71	83	728	finally
    //   88	97	728	finally
    //   155	219	728	finally
    //   227	684	728	finally
    //   693	700	728	finally
    //   717	725	728	finally
    //   751	768	728	finally
    //   776	781	794	java/io/IOException
    //   786	791	794	java/io/IOException
    //   122	126	802	java/io/IOException
    //   131	136	802	java/io/IOException
    //   734	739	810	java/io/IOException
    //   744	749	810	java/io/IOException
    //   25	55	820	finally
    //   139	152	820	finally
    //   55	64	830	finally
    //   113	118	837	finally
    //   25	55	856	java/lang/Throwable
    //   139	152	856	java/lang/Throwable
    //   55	64	867	java/lang/Throwable
  }
  
  public static HashMap a(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    paramQQAppInterface = new File(paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath());
    if ((paramQQAppInterface != null) && (paramQQAppInterface.exists()))
    {
      paramQQAppInterface = paramQQAppInterface.list();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0))
      {
        HashMap localHashMap = new HashMap();
        while (i1 < paramQQAppInterface.length)
        {
          localHashMap.put(paramQQAppInterface[i1], Boolean.valueOf(true));
          i1 += 1;
        }
        return localHashMap;
      }
    }
    return null;
  }
  
  public static List a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      PttCenter.ServerListInfo localServerListInfo = (PttCenter.ServerListInfo)paramList.get(i1);
      if (localServerListInfo != null) {
        localArrayList.add(a(localServerListInfo.uint32_up_ip.get(), localServerListInfo.uint32_up_port.get()));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public static short a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramQQAppInterface = (FriendsManagerImp)paramQQAppInterface.getManager(8);
    if (paramQQAppInterface == null) {
      return -1;
    }
    paramQQAppInterface = paramQQAppInterface.a(paramString);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.shGender;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "initAvatarUploadState");
    }
    jdField_b_of_type_Boolean = false;
    X = null;
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    localIntent.putExtra("requestType", 881);
    localIntent.putExtra("is_activity_to_fragment", false);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("curType", paramInt);
    paramView = AnimationUtils.a(paramView);
    localIntent.putExtra("is_from_face2face_add_friend", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    localIntent.putExtra("requestType", 880);
    localIntent.putExtra("filekey", paramString2);
    localIntent.putExtra("index", paramInt);
    localIntent.putExtra("friendUin", paramString1);
    paramActivity.startActivityForResult(localIntent, 880);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    paramView = AnimationUtils.a(paramView);
    localIntent.putExtra("extra_pendant_id", paramLong);
    localIntent.putExtra("extra_action_source", paramInt);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    localIntent.putExtra("is_activity_to_fragment", false);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, "", false);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramString2 = String.format("https://imgcache.qq.com/club/client/card/rel/mall_v54.html?_bid=238&closeSpecialLogic=1&ADTAG=%1$s&sid=%2$s&isCache=%3$s&entryId=%4$s&tabId=%5$s&_wv=5123", new Object[] { paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1 = paramString2 + "&" + paramString4;
    }
    localIntent.putExtra("url", paramString1);
    if ((paramActivity instanceof IndividuationSetActivity)) {
      localIntent.putExtra("individuation_url_type", 100);
    }
    while (paramBoolean)
    {
      paramActivity.startActivityForResult(localIntent, 1008);
      return;
      if ((paramActivity instanceof FriendProfileCardActivity)) {
        localIntent.putExtra("individuation_url_type", 200);
      }
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("url", String.format("https://imgcache.qq.com/club/client/card/rel/active.html?_bid=238&bgId=%1$s&ADTAG=inside.myCardBackground&_wv=5123", new Object[] { Long.valueOf(paramLong) }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Resources paramResources, View paramView, StatusManager paramStatusManager, RichStatus paramRichStatus, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i2 = 0;
    TextView localTextView = (TextView)paramView.findViewById(2131297409);
    ImageView localImageView = (ImageView)paramView.findViewById(2131298739);
    if (paramRichStatus != null) {
      localObject1 = paramRichStatus.a(null, -8947849, paramResources.getColor(2131427405));
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SpannableString("");
    }
    int i1;
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.jdField_c_of_type_JavaLangString)))
    {
      localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
      ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
      if (paramStatusManager != null)
      {
        localObject1 = paramStatusManager.a(paramRichStatus.jdField_b_of_type_Int, 200);
        localObject1 = new StatableBitmapDrawable(paramResources, (Bitmap)localObject1, false, false);
        i1 = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i1, i1);
        localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
        ((OffsetableImageSpan)localObject1).a(-0.1F);
        ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, "[S]".length(), 17);
        localTextView.setText((CharSequence)localObject2);
        label209:
        if (!paramBoolean) {
          break label547;
        }
        if (paramStatusManager != null) {
          break label455;
        }
        paramBoolean = false;
      }
    }
    for (;;)
    {
      label221:
      if (paramBoolean)
      {
        i1 = 2130838136;
        label231:
        paramResources = paramResources.getDrawable(i1);
        if (localImageView.getDrawable() != paramResources)
        {
          localImageView.setImageDrawable(paramResources);
          if ((paramResources instanceof Animatable)) {
            ((Animatable)paramResources).start();
          }
        }
        paramResources = "";
        if (paramRichStatus == null) {
          break label478;
        }
        if (paramRichStatus.jdField_c_of_type_JavaLangString != null) {
          paramResources = "" + paramRichStatus.jdField_c_of_type_JavaLangString;
        }
        paramStatusManager = paramResources;
        if (paramRichStatus.d != null) {
          paramStatusManager = paramResources + paramRichStatus.d;
        }
        if (paramRichStatus.jdField_a_of_type_JavaUtilArrayList == null) {
          break label472;
        }
        i1 = paramRichStatus.jdField_a_of_type_JavaUtilArrayList.size();
        label355:
        paramResources = paramStatusManager;
        label357:
        paramStatusManager = paramResources;
        if (i2 >= i1) {
          break label482;
        }
        paramStatusManager = (String)paramRichStatus.jdField_a_of_type_JavaUtilArrayList.get(i2);
        if (TextUtils.isEmpty(paramStatusManager)) {
          break label544;
        }
        paramResources = paramResources + paramStatusManager;
      }
      label544:
      for (;;)
      {
        i2 += 1;
        break label357;
        localObject1 = BitmapManager.a(paramResources, 2130841575);
        break;
        if (((SpannableString)localObject2).length() == 0)
        {
          localTextView.setText("无最新签名");
          break label209;
        }
        localTextView.setText((CharSequence)localObject2);
        break label209;
        label455:
        paramBoolean = paramStatusManager.a();
        break label221;
        i1 = 2130838068;
        break label231;
        label472:
        i1 = 0;
        break label355;
        label478:
        paramStatusManager = "";
        label482:
        if ((paramView.getTag() instanceof DataTag)) {
          ((DataTag)paramView.getTag()).a = paramStatusManager;
        }
        for (;;)
        {
          paramView.setContentDescription("个性签名是" + paramStatusManager);
          return;
          paramView.setTag(new DataTag(3, paramStatusManager));
        }
      }
      label547:
      paramBoolean = false;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport param null");
      }
      return;
    }
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramBaseActivity, paramBaseActivity.getTitleBarHeight());
    localQQProgressDialog.show();
    new Thread(new kqd(paramBaseActivity, paramString2, paramBoolean, paramString1, paramString3, localQQProgressDialog)).start();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, null, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramQQAppInterface.a(new kqg(paramQQAppInterface, paramLong1, paramLong2, paramString, paramInt));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    Object localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      localObject2 = ((FriendManager)localObject1).c(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).alias)))
      {
        str = ((Friends)localObject2).alias;
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|f.alias = " + ((Friends)localObject2).alias);
          localObject1 = str;
        }
      }
    }
    for (;;)
    {
      paramString = String.format("https://ti.qq.com/qcard/index.html?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s&_wv=1027", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-5.9.3", localObject1 });
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Detail", 2, "openDetail() url = " + paramString);
      }
      localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramString);
      ((Intent)localObject1).putExtra("uin", paramQQAppInterface.a());
      ((Intent)localObject1).putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
      ((Intent)localObject1).putExtra("reqType", 1);
      paramActivity.startActivity((Intent)localObject1);
      return;
      localObject2 = ((FriendManager)localObject1).a(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((Card)localObject2).strShowName)))
      {
        str = ((Card)localObject2).strShowName;
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|card.strShowName = " + ((Card)localObject2).strShowName);
          localObject1 = str;
        }
      }
      else
      {
        localObject1 = paramString;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "removeAvatarFromCache, uin=" + paramString);
      }
      paramQQAppInterface = new URL("profile_img_thumb", null, paramQQAppInterface.a(false, paramString));
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.remove(paramQQAppInterface.toString());
      }
      paramQQAppInterface = new URL("profile_img_big", null, a(paramString));
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.remove(paramQQAppInterface.toString());
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, "qq_error|" + paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir clear old version template dir");
    }
    paramQQAppInterface = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    try
    {
      File[] arrayOfFile = new File(paramQQAppInterface).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
        while (i1 < arrayOfFile.length)
        {
          String str = arrayOfFile[i1].getName();
          if ((str.startsWith(String.valueOf(paramString1))) && (!str.endsWith(paramString2)))
          {
            str = paramQQAppInterface + File.separator + String.valueOf(paramString1) + "_" + str;
            FileUtils.a(str);
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir old dir=" + str);
            }
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "test start");
    }
    String str1 = a(paramByteStringMicro);
    byte[] arrayOfByte1 = a(str1);
    String str2 = a(arrayOfByte1);
    byte[] arrayOfByte2 = new byte[paramByteStringMicro.size()];
    paramByteStringMicro.copyTo(arrayOfByte2, 0);
    if ((Utils.a(str1, str2)) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "bsm -> str, str -> bs, bs -> str : 相等");
    }
    if ((a(arrayOfByte1, arrayOfByte2)) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "bsm -> str, str -> bs, bsm -> bs : 相等");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "test end");
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|false");
      }
      jdField_b_of_type_Boolean = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|true");
    }
    X = paramString;
    jdField_b_of_type_Boolean = true;
  }
  
  public static void a(String paramString, int paramInt, FileMsg paramFileMsg)
  {
    HashMap localHashMap;
    String str;
    long l2;
    long l1;
    if ((paramInt == 2003) || (paramInt == 1005) || (paramInt == 2005) || (paramInt == 1003))
    {
      localHashMap = new HashMap();
      str = "";
      if (paramFileMsg.jdField_a_of_type_Int != 1) {
        break label275;
      }
      str = "actPicDownloadV2.Card.Picture";
      long l3 = System.currentTimeMillis() - paramFileMsg.f;
      long l4 = paramFileMsg.jdField_a_of_type_Long;
      localHashMap.put("param_Server", StringUtil.a(paramFileMsg.jdField_i_of_type_JavaLangString));
      l2 = l3;
      l1 = l4;
      if (paramInt == 1005)
      {
        localHashMap.put("param_fsized", paramFileMsg.e + "");
        localHashMap.put("param_fsizeo", paramFileMsg.jdField_a_of_type_Long + "");
        localHashMap.put("param_PicScale", paramFileMsg.ae + "");
        l2 = l3;
        l1 = l4;
        if (paramFileMsg.jdField_a_of_type_Int == 1)
        {
          l2 = 0L;
          l1 = 0L;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.VoiceIntro", 2, paramFileMsg.jdField_i_of_type_JavaLangString);
      }
      paramFileMsg = StatisticCollector.a(BaseApplication.getContext());
      if ((paramInt != 2003) && (paramInt != 1003)) {
        break label290;
      }
    }
    label275:
    label290:
    for (boolean bool = true;; bool = false)
    {
      paramFileMsg.a(paramString, str, bool, l2, l1, localHashMap, "");
      return;
      if (paramFileMsg.jdField_a_of_type_Int != 0) {
        break;
      }
      str = "actPicUploadV2.Card.Picture";
      break;
    }
  }
  
  public static void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, long paramLong1, int paramInt2, int paramInt3, long paramLong2, String paramString4, String paramString5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doStaticForVoiceTransfer()").append(", uin = ").append(paramString1).append(", nOpType = ").append(paramInt1).append(", isSuccess = ").append(paramBoolean).append(", filekey = ").append(paramString2).append(", ip = ").append(paramString3).append(", duration = ").append(paramLong1).append(", retry_count = ").append(paramInt2).append(", failCode = ").append(paramInt3).append(", fileSize = ").append(paramLong2).append(", errorMsg = ").append(paramString4).append(", rspHeader = ").append(paramString5);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 0) {}
    HashMap localHashMap;
    for (localObject = "actIntroPttUpload";; localObject = "actIntroPttDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("serverip", paramString3);
      localHashMap.put("param_uuid", paramString2);
      if (!paramBoolean) {
        break;
      }
      localHashMap.put("param_retry", String.valueOf(paramInt2));
      StatisticCollector.a(BaseApplication.getContext()).a(paramString1, (String)localObject, paramBoolean, paramLong1, paramLong2, localHashMap, "", false);
      return;
    }
    if (!BaseTransProcessor.a(paramInt3, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt3));
      if ((paramInt3 == -9527) || (paramInt3 == 9311) || (paramInt3 == 9044) || (paramInt3 == 9350) || (paramInt3 == 9351))
      {
        localHashMap.put(BaseTransProcessor.V, paramString4);
        label316:
        if (paramInt1 == 1) {
          localHashMap.put("param_url", paramString3);
        }
        if (paramString5 == null) {
          break label379;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("param_rspHeader", paramString5);
      break;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      label379:
      paramString5 = "";
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramActivity == null)) {
      return;
    }
    Object localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      localObject2 = ((FriendManager)localObject1).c(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).alias)))
      {
        str = ((Friends)localObject2).alias;
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|f.alias = " + ((Friends)localObject2).alias);
          localObject1 = str;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|strShowName = " + (String)localObject1);
      }
      paramString = String.format("https://ti.qq.com/qcard/index.html?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s&_wv=1027", new Object[] { paramQQAppInterface.getSid(), paramString, String.valueOf(paramQQAppInterface.a()), "android-5.9.3", localObject1 });
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails() url = " + paramString);
      }
      localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramString);
      ((Intent)localObject1).putExtra("uin", paramQQAppInterface.a());
      ((Intent)localObject1).putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
      ((Intent)localObject1).putExtra("reqType", 1);
      paramActivity.startActivity((Intent)localObject1);
      return;
      localObject2 = ((FriendManager)localObject1).a(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((Card)localObject2).strShowName)))
      {
        str = ((Card)localObject2).strShowName;
        localObject1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails|card.strShowName = " + ((Card)localObject2).strShowName);
          localObject1 = str;
          continue;
          a(paramQQAppInterface, paramActivity, paramString);
        }
      }
      else
      {
        localObject1 = paramString;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a == null) {
      a = new HashMap();
    }
    a.put(paramString1, paramString2);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = HexUtil.a(paramArrayOfByte);
      String str = HexUtil.a(paramArrayOfByte);
      new kqb(str, b(paramArrayOfByte)).start();
      b(str);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, paramArrayOfByte.toString());
    }
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = b(paramContext, paramString);
    boolean bool1;
    try
    {
      paramContext = new File(paramContext);
      if ((paramContext.exists()) && (paramContext.isFile()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is exists");
        }
      }
      else
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is not exists");
        return false;
      }
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource exception msg=" + paramContext.getMessage());
        return false;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject = a(paramQQAppInterface, -1L);
    if (localObject != null)
    {
      paramQQAppInterface = new File((String)localObject);
      localObject = new File((String)localObject + File.separator + "config_black.json");
      bool1 = bool2;
      if (paramQQAppInterface.isDirectory())
      {
        bool1 = bool2;
        if (((File)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common dir is exists=" + bool1);
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common path is null");
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, ProfileCardTemplate paramProfileCardTemplate)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    return ((paramProfileCardTemplate.jdField_m_of_type_Int <= 100) || (l1 >= paramProfileCardTemplate.jdField_m_of_type_Int)) && ((paramProfileCardTemplate.jdField_n_of_type_Int <= 100) || (l1 <= paramProfileCardTemplate.jdField_n_of_type_Int));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    File localFile = new File(paramString);
    long l1 = localFile.length();
    if ((!localFile.exists()) || (l1 <= 0L) || (l1 >= 614400L)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|avatarFilePath not exist, or len = " + l1);
      }
    }
    do
    {
      return false;
      if (NetworkUtil.e(paramQQAppInterface.a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|net is not available");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|start upload : size = " + l1);
    }
    a(paramString);
    paramQQAppInterface.a().a(paramQQAppInterface, paramQQAppInterface.a(), paramString, (byte)4, 0);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return false;
    }
    paramQQAppInterface = ((RedTouchManager)paramQQAppInterface.getManager(35)).a(paramString);
    boolean bool;
    if ((paramImageView != null) && (paramQQAppInterface != null) && (paramQQAppInterface.iNewFlag.get() != 0))
    {
      paramImageView.setVisibility(0);
      switch (paramQQAppInterface.type.get())
      {
      default: 
        paramImageView.setVisibility(8);
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      paramImageView.setImageResource(2130841955);
      bool = true;
      continue;
      paramImageView.setImageResource(2130841952);
      bool = true;
      continue;
      bool = false;
      continue;
      paramImageView.setVisibility(8);
      bool = false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    return new File(paramQQAppInterface + File.separator + String.format("%s_%s", new Object[] { paramString1, paramString2 })).exists();
  }
  
  public static boolean a(ProfileCardBackground paramProfileCardBackground)
  {
    return paramProfileCardBackground.jdField_a_of_type_Int == 160;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.Avatar", 2, paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(2));
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i1;
    int i2;
    label12:
    label20:
    boolean bool2;
    if (paramArrayOfByte1 == null)
    {
      i1 = 0;
      if (paramArrayOfByte2 != null) {
        break label74;
      }
      i2 = 0;
      if (i1 != i2) {
        break label80;
      }
      bool1 = true;
      bool2 = bool1;
      if (!bool1) {
        break label92;
      }
      i2 = 0;
      label31:
      bool2 = bool1;
      if (!bool1) {
        break label92;
      }
      bool2 = bool1;
      if (i2 >= i1) {
        break label92;
      }
      if (paramArrayOfByte1[i2] != paramArrayOfByte2[i2]) {
        break label86;
      }
    }
    label74:
    label80:
    label86:
    for (boolean bool1 = true;; bool1 = false)
    {
      i2 += 1;
      break label31;
      i1 = paramArrayOfByte1.length;
      break;
      i2 = paramArrayOfByte2.length;
      break label12;
      bool1 = false;
      break label20;
    }
    label92:
    return bool2;
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = null;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfByte = HexUtil.a(paramString);
    }
    return arrayOfByte;
  }
  
  public static int b(Context paramContext)
  {
    return (int)(0.56338F * a(paramContext));
  }
  
  public static final int b(Context paramContext, int paramInt)
  {
    return (int)Math.floor(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static long b()
  {
    try
    {
      if (Utils.e()) {
        return Utils.a(new File(AppConstants.aE));
      }
      long l1 = Utils.a(new File(Environment.getRootDirectory().getPath()));
      return l1;
    }
    catch (Exception localException) {}
    return -1L;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_portrait.tmp");
    return localStringBuilder.toString();
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getDir("profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_template.json" + "5.9.3";
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return c(paramContext) + e(paramString);
  }
  
  public static String b(String paramString)
  {
    if (a != null) {
      return (String)a.get(paramString);
    }
    return null;
  }
  
  public static void b(String paramString)
  {
    if (a != null) {
      a.remove(paramString);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "delVoiceFile() uin = " + paramString1 + ", filekey = " + paramString2);
    }
    paramString1 = a(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      FileUtils.d(paramString1);
    }
  }
  
  private static boolean b(ProfileCardBackground paramProfileCardBackground)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    return ((paramProfileCardBackground.jdField_j_of_type_Int <= 100) || (l1 >= paramProfileCardBackground.jdField_j_of_type_Int)) && ((paramProfileCardBackground.jdField_k_of_type_Int <= 100) || (l1 <= paramProfileCardBackground.jdField_k_of_type_Int));
  }
  
  public static boolean b(String paramString)
  {
    if (!FileUtils.b(paramString)) {}
    for (;;)
    {
      return false;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      try
      {
        BitmapFactory.decodeFile(paramString, localOptions);
        if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      catch (OutOfMemoryError paramString) {}
    }
    return false;
  }
  
  public static boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(1));
  }
  
  public static final int c(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static String c()
  {
    return X;
  }
  
  public static String c(Context paramContext)
  {
    if (Utils.e()) {
      return AppConstants.bT;
    }
    return paramContext.getDir("profilecard", 0).getAbsoluteFile() + File.separator;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    while (i1 < paramString.length())
    {
      localStringBuffer.append(Character.toLowerCase(paramString.charAt(i1)));
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void c(String paramString)
  {
    jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public static boolean c(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(3));
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.jdField_a_of_type_JavaLangString).append("temp").append("/").append(System.currentTimeMillis()).append("_cardbg.tmp");
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = paramString.lastIndexOf('/');
      str1 = str2;
      if (i1 > 0)
      {
        str1 = str2;
        if (i1 < paramString.length()) {
          str1 = paramString.substring(i1 + 1);
        }
      }
    }
    return str1;
  }
  
  public static void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.a().post(new kqc(paramString));
  }
  
  public static boolean d(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    while ((!b(paramArrayList)) && (!c(paramArrayList)) && (!a(paramArrayList))) {
      return false;
    }
    return true;
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return MD5.toMD5(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil
 * JD-Core Version:    0.7.0.1
 */