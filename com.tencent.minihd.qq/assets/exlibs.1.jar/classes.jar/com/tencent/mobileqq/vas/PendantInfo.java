package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable.MutilePlayInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import kvj;
import kvk;
import kvl;
import kvm;
import kvn;
import mqq.app.MobileQQ;

public class PendantInfo
  implements VipPendantDrawable.MutilePlayInfo
{
  static int jdField_a_of_type_Int = 1000;
  public static final String a = "PendantInfo";
  static final int jdField_b_of_type_Int = 16;
  private static final String jdField_b_of_type_JavaLangString = "dynamic_pendant";
  static final int jdField_c_of_type_Int = 17;
  private static final String jdField_c_of_type_JavaLangString = "static_pendant";
  static final int jdField_d_of_type_Int = 18;
  static final int e = 19;
  static final int f = 20;
  static final int g = 0;
  static final int h = 1;
  public static int i = 1;
  public static int j = 2;
  public static int k = 3;
  public static int l = 4;
  public static int m = 5;
  public static int n = 100;
  private static final int q = 7;
  private static int r = 20;
  public long a;
  protected Context a;
  public Handler a;
  protected AppInterface a;
  public PendantInfo.AnimationLruCache a;
  public PendantInfo.DecodeNextFrameTask a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new kvl(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  protected Object a;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  DownloadListener jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new kvm(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private boolean jdField_b_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  public int o;
  public int p = -1;
  private int s;
  private int t;
  private int u = 0;
  private int v = 3;
  
  public PendantInfo(AppInterface paramAppInterface, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.o = -1;
    this.t = -1;
    this.s = -1;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_AndroidOsHandler = new kvj(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramAppInterface.getManager(46));
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache = new PendantInfo.AnimationLruCache(this, r);
  }
  
  private String a()
  {
    String str = "static_pendant";
    if (this.o == 2) {
      str = "dynamic_pendant";
    }
    return str + "_" + this.jdField_a_of_type_Long + "_" + this.o;
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = new File(AvatarPendantUtil.a(this.jdField_a_of_type_Long, 4));
    if (!((File)localObject).exists())
    {
      str = AvatarPendantUtil.b(this.jdField_a_of_type_Long, 4);
      localBundle = new Bundle();
      localBundle.putLong("id", this.jdField_a_of_type_Long);
      localBundle.putInt("pendantResType", paramInt);
      localBundle.putLong("targetId", paramLong);
      localObject = new DownloadTask(str, (File)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    }
    while (!a((File)localObject, paramInt))
    {
      String str;
      Bundle localBundle;
      return;
    }
    a(paramLong, paramInt);
  }
  
  private void a(Bitmap paramBitmap)
  {
    String str = a();
    int i1 = Utils.a(paramBitmap);
    paramBitmap = new BitmapDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getResources(), paramBitmap);
    paramBitmap.setTargetDensity(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getResources().getDisplayMetrics());
    BaseApplicationImpl.a.put(str, new Pair(paramBitmap.getConstantState(), Integer.valueOf(i1)));
  }
  
  private void a(String paramString)
  {
    int i1;
    if (paramString != null)
    {
      i1 = paramString.indexOf("\"interval\":");
      if (i1 == -1) {
        break label101;
      }
      int i2 = paramString.indexOf(",", i1 + 10);
      if (i2 == -1) {
        break label101;
      }
      paramString = paramString.substring(i1 + 11, i2);
      if (paramString == null) {
        break label101;
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(paramString.trim());
        if (-2147483648 != i1)
        {
          this.t = i1;
          a(0, 7, 0L);
          return;
        }
      }
      catch (Exception paramString)
      {
        i1 = -2147483648;
        continue;
        this.t = n;
        a(1, 7, 0L);
        return;
      }
      label101:
      i1 = -2147483648;
    }
  }
  
  private boolean a()
  {
    Object localObject = a();
    localObject = (Pair)BaseApplicationImpl.a.get(localObject);
    return (localObject != null) && (((Pair)localObject).first != null);
  }
  
  private Bitmap b()
  {
    Object localObject = a();
    localObject = (Pair)BaseApplicationImpl.a.get(localObject);
    if ((localObject != null) && (((Pair)localObject).first != null)) {
      return ((BitmapDrawable)((Drawable.ConstantState)((Pair)localObject).first).newDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getResources())).getBitmap();
    }
    return null;
  }
  
  private void e()
  {
    if (((this.jdField_a_of_type_JavaLangObject instanceof kvn)) && (a()) && (((this.jdField_a_of_type_JavaLangObject != null) && (((kvn)this.jdField_a_of_type_JavaLangObject).a != null) && (((kvn)this.jdField_a_of_type_JavaLangObject).a.equals(this.d))) || (!this.jdField_b_of_type_Boolean))) {
      return;
    }
    this.jdField_a_of_type_JavaLangObject = new kvn(this, this.d);
    this.v = 0;
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = new PendantInfo.DecodeNextFrameTask(this, this.jdField_a_of_type_JavaLangObject, m);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.t;
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.p), Long.valueOf(this.o) });
  }
  
  public int a()
  {
    return this.v;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == this.u - 1)
    {
      this.v -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  public Bitmap a()
  {
    return b();
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_2
    //   2: if_icmpne +111 -> 113
    //   5: aload_2
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 80	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Boolean	Z
    //   14: aconst_null
    //   15: areturn
    //   16: new 388	android/graphics/BitmapFactory$Options
    //   19: dup
    //   20: invokespecial 389	android/graphics/BitmapFactory$Options:<init>	()V
    //   23: astore 4
    //   25: aload_2
    //   26: checkcast 390	[Ljava/lang/String;
    //   29: checkcast 390	[Ljava/lang/String;
    //   32: astore_2
    //   33: aload_2
    //   34: iload_3
    //   35: iconst_1
    //   36: iadd
    //   37: aload_2
    //   38: arraylength
    //   39: irem
    //   40: aaload
    //   41: astore_2
    //   42: aload 4
    //   44: sipush 320
    //   47: putfield 393	android/graphics/BitmapFactory$Options:inDensity	I
    //   50: aload 4
    //   52: aload_0
    //   53: getfield 106	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   56: invokevirtual 397	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   59: invokevirtual 400	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   62: invokevirtual 255	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   65: getfield 405	android/util/DisplayMetrics:densityDpi	I
    //   68: putfield 408	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   71: aload 4
    //   73: getfield 393	android/graphics/BitmapFactory$Options:inDensity	I
    //   76: aload 4
    //   78: getfield 408	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   81: if_icmpge +13 -> 94
    //   84: aload 4
    //   86: aload 4
    //   88: getfield 408	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   91: putfield 393	android/graphics/BitmapFactory$Options:inDensity	I
    //   94: new 410	java/io/FileInputStream
    //   97: dup
    //   98: aload_2
    //   99: invokespecial 411	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   102: astore_2
    //   103: aload_2
    //   104: aconst_null
    //   105: aload 4
    //   107: invokestatic 417	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   110: astore_2
    //   111: aload_2
    //   112: areturn
    //   113: new 388	android/graphics/BitmapFactory$Options
    //   116: dup
    //   117: invokespecial 389	android/graphics/BitmapFactory$Options:<init>	()V
    //   120: astore 4
    //   122: aload_2
    //   123: checkcast 343	kvn
    //   126: astore_2
    //   127: aload 4
    //   129: sipush 320
    //   132: putfield 393	android/graphics/BitmapFactory$Options:inDensity	I
    //   135: aload 4
    //   137: aload_0
    //   138: getfield 106	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   141: invokevirtual 397	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   144: invokevirtual 400	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   147: invokevirtual 255	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   150: getfield 405	android/util/DisplayMetrics:densityDpi	I
    //   153: putfield 408	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   156: aload 4
    //   158: getfield 393	android/graphics/BitmapFactory$Options:inDensity	I
    //   161: aload 4
    //   163: getfield 408	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   166: if_icmpge +13 -> 179
    //   169: aload 4
    //   171: aload 4
    //   173: getfield 408	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   176: putfield 393	android/graphics/BitmapFactory$Options:inDensity	I
    //   179: aload_2
    //   180: getfield 347	kvn:a	Ljava/lang/String;
    //   183: aload 4
    //   185: invokestatic 421	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   188: astore_2
    //   189: aload_2
    //   190: areturn
    //   191: astore_2
    //   192: aconst_null
    //   193: areturn
    //   194: astore_2
    //   195: aconst_null
    //   196: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	PendantInfo
    //   0	197	1	paramInt1	int
    //   0	197	2	paramObject	Object
    //   0	197	3	paramInt2	int
    //   23	161	4	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   103	111	191	java/lang/OutOfMemoryError
    //   179	189	194	java/lang/OutOfMemoryError
  }
  
  public Drawable a(AppInterface paramAppInterface, int paramInt, long paramLong)
  {
    if (paramAppInterface == null) {
      return null;
    }
    this.o = paramInt;
    Object localObject = (VipPendantDrawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(paramLong));
    paramAppInterface = (AppInterface)localObject;
    if (localObject == null)
    {
      paramAppInterface = new VipPendantDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getResources());
      paramAppInterface.a(this);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.put(Long.valueOf(paramLong), paramAppInterface);
    }
    localObject = AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt);
    if (2 == paramInt) {
      localObject = AvatarPendantUtil.a(this.jdField_a_of_type_Long, 8);
    }
    if (FileUtils.a((String)localObject))
    {
      if (2 == paramInt)
      {
        a();
        if (this.jdField_a_of_type_ArrayOfJavaLangString == null)
        {
          a(paramInt, paramLong);
          return paramAppInterface;
        }
        if ((this.s != -1) && (this.t != -1))
        {
          if ((this.s == 0) && (paramInt == 2)) {
            return null;
          }
          a(paramAppInterface);
          return paramAppInterface;
        }
        ThreadManager.b(new kvk(this, paramInt));
        return paramAppInterface;
      }
      a(paramAppInterface, false, paramLong);
      return paramAppInterface;
    }
    a(paramInt, paramLong);
    return paramAppInterface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {}
    for (;;)
    {
      return;
      String str = AvatarPendantUtil.a(this.jdField_a_of_type_Long, 8);
      if (FileUtils.a(str))
      {
        Object localObject = FileUtils.a(str);
        if (((ArrayList)localObject).size() > 0)
        {
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[((ArrayList)localObject).size()];
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str).append(File.separator).append("%d.png");
          str = ((StringBuilder)localObject).toString();
          int i2 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
          int i1 = 0;
          while (i1 < i2)
          {
            this.jdField_a_of_type_ArrayOfJavaLangString[i1] = String.format(str, new Object[] { Integer.valueOf(i1 + 1) });
            i1 += 1;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("PendantInfo", 2, "download pendant report actionResult=" + paramInt1 + ",pendantId=" + this.jdField_a_of_type_Long + ",type=" + paramInt2);
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      int i1 = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
      if (i1 >= 2) {}
      for (;;)
      {
        ReportController.b(null, "CliStatus", "", "", "AvatarPendant", "download", 0, paramInt1, this.jdField_a_of_type_Long + "", i1 + "", paramInt2 + "", String.valueOf(paramLong));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = new File(AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt));
    String str = AvatarPendantUtil.b(this.jdField_a_of_type_Long, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "getPendantInfo pendantId=" + this.jdField_a_of_type_Long + " will down ,file path=" + ((File)localObject).getAbsolutePath());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("name", ((File)localObject).getAbsolutePath());
    localBundle.putLong("id", this.jdField_a_of_type_Long);
    localBundle.putLong("targetId", paramLong);
    localBundle.putInt("pendantResType", paramInt);
    localObject = new DownloadTask(str, (File)localObject);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    this.d = AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt);
    Drawable localDrawable = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt, paramLong);
    if ((paramView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)paramView).setPendantImage(localDrawable);
    }
    while (!(paramView instanceof ImageView)) {
      return;
    }
    ((ImageView)paramView).setImageDrawable(localDrawable);
  }
  
  public void a(VipPendantDrawable paramVipPendantDrawable)
  {
    if ((paramVipPendantDrawable == null) || (this.jdField_a_of_type_ArrayOfJavaLangString == null)) {
      return;
    }
    paramVipPendantDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString, this.t);
    this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    this.u = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    this.v = 3;
    c();
  }
  
  public void a(VipPendantDrawable paramVipPendantDrawable, boolean paramBoolean, long paramLong)
  {
    if (paramVipPendantDrawable == null) {
      return;
    }
    e();
    this.v = 0;
    paramVipPendantDrawable.a(this.d);
    paramVipPendantDrawable = new Message();
    paramVipPendantDrawable.what = 16;
    Bundle localBundle = new Bundle();
    if (paramBoolean) {
      paramLong = m;
    }
    localBundle.putLong("targetId", paramLong);
    paramVipPendantDrawable.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramVipPendantDrawable);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    Message localMessage = new Message();
    localMessage.what = 18;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, jdField_a_of_type_Int);
  }
  
  /* Error */
  public boolean a(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: getstatic 576	com/tencent/mobileqq/utils/AvatarPendantUtil:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_0
    //   4: getfield 108	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Long	J
    //   7: invokestatic 374	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 579	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 272	java/lang/Integer
    //   16: astore 7
    //   18: aconst_null
    //   19: astore 6
    //   21: aload_1
    //   22: invokevirtual 194	java/io/File:exists	()Z
    //   25: ifeq +318 -> 343
    //   28: aload 7
    //   30: ifnonnull +313 -> 343
    //   33: ldc_w 317
    //   36: istore 4
    //   38: aload_1
    //   39: invokestatic 582	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   42: astore 8
    //   44: iload 4
    //   46: istore_3
    //   47: aload 8
    //   49: ifnull +130 -> 179
    //   52: new 297	java/lang/String
    //   55: dup
    //   56: aload 8
    //   58: invokespecial 585	java/lang/String:<init>	([B)V
    //   61: astore 6
    //   63: aload 6
    //   65: ldc_w 587
    //   68: invokevirtual 301	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   71: istore_3
    //   72: iload_3
    //   73: iconst_m1
    //   74: if_icmpeq +263 -> 337
    //   77: aload 6
    //   79: ldc_w 303
    //   82: iload_3
    //   83: bipush 6
    //   85: iadd
    //   86: invokevirtual 306	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   89: istore 5
    //   91: iload 5
    //   93: iconst_m1
    //   94: if_icmpeq +243 -> 337
    //   97: aload 6
    //   99: iload_3
    //   100: bipush 7
    //   102: iadd
    //   103: iload 5
    //   105: invokevirtual 310	java/lang/String:substring	(II)Ljava/lang/String;
    //   108: astore 8
    //   110: aload 8
    //   112: ifnull +225 -> 337
    //   115: aload 8
    //   117: invokevirtual 313	java/lang/String:trim	()Ljava/lang/String;
    //   120: invokestatic 316	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   123: istore_3
    //   124: invokestatic 478	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +29 -> 156
    //   130: ldc 12
    //   132: iconst_2
    //   133: new 163	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 589
    //   143: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_3
    //   147: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: iload_3
    //   158: putfield 114	com/tencent/mobileqq/vas/PendantInfo:s	I
    //   161: getstatic 576	com/tencent/mobileqq/utils/AvatarPendantUtil:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   164: aload_0
    //   165: getfield 108	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Long	J
    //   168: invokestatic 374	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: iload_3
    //   172: invokestatic 276	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: invokevirtual 590	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   178: pop
    //   179: iload_3
    //   180: ldc_w 317
    //   183: if_icmpne +110 -> 293
    //   186: aload_1
    //   187: invokevirtual 593	java/io/File:delete	()Z
    //   190: pop
    //   191: aload_0
    //   192: iconst_1
    //   193: bipush 7
    //   195: lconst_0
    //   196: invokevirtual 320	com/tencent/mobileqq/vas/PendantInfo:a	(IIJ)V
    //   199: iconst_m1
    //   200: aload_0
    //   201: getfield 112	com/tencent/mobileqq/vas/PendantInfo:t	I
    //   204: if_icmpne +37 -> 241
    //   207: iload_2
    //   208: iconst_2
    //   209: if_icmpne +32 -> 241
    //   212: aload 6
    //   214: astore 8
    //   216: aload 6
    //   218: ifnonnull +17 -> 235
    //   221: aload 6
    //   223: astore 8
    //   225: aload_1
    //   226: ifnull +9 -> 235
    //   229: aload_1
    //   230: invokestatic 596	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   233: astore 8
    //   235: aload_0
    //   236: aload 8
    //   238: invokespecial 597	com/tencent/mobileqq/vas/PendantInfo:a	(Ljava/lang/String;)V
    //   241: aload 7
    //   243: ifnull +79 -> 322
    //   246: aload 7
    //   248: invokevirtual 600	java/lang/Integer:intValue	()I
    //   251: ifne +71 -> 322
    //   254: iload_2
    //   255: iconst_2
    //   256: if_icmpne +66 -> 322
    //   259: invokestatic 478	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc 12
    //   267: iconst_2
    //   268: ldc_w 602
    //   271: invokestatic 523	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore 8
    //   278: ldc_w 317
    //   281: istore_3
    //   282: aload_0
    //   283: iconst_1
    //   284: bipush 7
    //   286: lconst_0
    //   287: invokevirtual 320	com/tencent/mobileqq/vas/PendantInfo:a	(IIJ)V
    //   290: goto -111 -> 179
    //   293: aload_0
    //   294: iconst_0
    //   295: bipush 7
    //   297: lconst_0
    //   298: invokevirtual 320	com/tencent/mobileqq/vas/PendantInfo:a	(IIJ)V
    //   301: getstatic 576	com/tencent/mobileqq/utils/AvatarPendantUtil:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   304: aload_0
    //   305: getfield 108	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Long	J
    //   308: invokestatic 374	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   311: invokevirtual 579	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   314: checkcast 272	java/lang/Integer
    //   317: astore 7
    //   319: goto -120 -> 199
    //   322: iconst_1
    //   323: ireturn
    //   324: astore_1
    //   325: aload 6
    //   327: astore 8
    //   329: goto -94 -> 235
    //   332: astore 8
    //   334: goto -52 -> 282
    //   337: iload 4
    //   339: istore_3
    //   340: goto -161 -> 179
    //   343: aconst_null
    //   344: astore 6
    //   346: goto -147 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	PendantInfo
    //   0	349	1	paramFile	File
    //   0	349	2	paramInt	int
    //   46	294	3	i1	int
    //   36	302	4	i2	int
    //   89	15	5	i3	int
    //   19	326	6	str1	String
    //   16	302	7	localInteger	Integer
    //   42	195	8	localObject	Object
    //   276	1	8	localException1	Exception
    //   327	1	8	str2	String
    //   332	1	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   115	124	276	java/lang/Exception
    //   229	235	324	java/io/IOException
    //   124	156	332	java/lang/Exception
    //   156	179	332	java/lang/Exception
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.clear();
    d();
  }
  
  public void c()
  {
    long l1;
    long l2;
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      l1 = SystemClock.uptimeMillis();
      l2 = this.t;
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = new PendantInfo.DecodeNextFrameTask(this, this.jdField_a_of_type_ArrayOfJavaLangString, m);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.p), Long.valueOf(this.o) });
      return;
    }
    catch (Exception localException) {}
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = null;
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo
 * JD-Core Version:    0.7.0.1
 */