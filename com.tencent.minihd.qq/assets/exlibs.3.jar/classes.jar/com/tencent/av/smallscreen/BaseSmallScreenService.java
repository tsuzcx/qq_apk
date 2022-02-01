package com.tencent.av.smallscreen;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import bys;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements SmallScreenRelativeLayout.FloatListener
{
  static final String jdField_a_of_type_JavaLangString = "BaseSmallScreenService";
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = new bys(this);
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  View jdField_a_of_type_AndroidViewView = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  SmallScreenRelativeLayout jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
  SmallScreenToast jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  SmallScreenRelativeLayout jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
  SmallScreenToast jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  public boolean b;
  int c;
  public boolean c;
  int d;
  public boolean d;
  int e;
  public boolean e;
  int f;
  public boolean f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m = 0;
  int n = 7;
  int o = 0;
  
  public BaseSmallScreenService()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
  }
  
  static void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 136;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    if (SmallScreenUtils.a()) {}
    for (int i1 = 2005;; i1 = 2002)
    {
      paramLayoutParams.type = i1;
      return;
    }
  }
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().x;
    }
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  Animation a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1750L);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setInterpolator(new SmallScreenInterpolator());
    return localAlphaAnimation;
  }
  
  void a()
  {
    if (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.a()) {}
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(long paramLong) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast)
    {
      WindowManager.LayoutParams localLayoutParams = paramSmallScreenRelativeLayout.a();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      paramSmallScreenRelativeLayout.c();
      return;
    }
  }
  
  public boolean a()
  {
    return SmallScreenUtils.d(((AppInterface)this.app).a());
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().y;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
  }
  
  public int c(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().width;
    }
  }
  
  public void c()
  {
    a(0L);
  }
  
  public int d(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout) {}
    for (paramSmallScreenRelativeLayout = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast;; paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast) {
      return paramSmallScreenRelativeLayout.a().height;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onHasSmartBarChanged mHasSmartBar = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) {
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 10
    //   8: iconst_2
    //   9: ldc 219
    //   11: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: invokespecial 221	mqq/app/AppService:onCreate	()V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 47	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Boolean	Z
    //   23: aload_0
    //   24: ldc 223
    //   26: invokevirtual 227	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   29: checkcast 229	android/view/LayoutInflater
    //   32: astore_1
    //   33: aload_1
    //   34: ifnonnull +121 -> 155
    //   37: ldc 10
    //   39: iconst_1
    //   40: ldc 231
    //   42: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: invokevirtual 236	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   49: return
    //   50: astore_1
    //   51: ldc 10
    //   53: iconst_1
    //   54: new 191	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   61: ldc 238
    //   63: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: invokevirtual 236	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   80: return
    //   81: astore_1
    //   82: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +28 -> 113
    //   88: ldc 10
    //   90: iconst_2
    //   91: new 191	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   98: ldc 238
    //   100: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -82 -> 33
    //   118: astore_1
    //   119: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +28 -> 150
    //   125: ldc 10
    //   127: iconst_2
    //   128: new 191	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   135: ldc 238
    //   137: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aconst_null
    //   151: astore_1
    //   152: goto -119 -> 33
    //   155: aload_0
    //   156: aload_0
    //   157: ldc 243
    //   159: invokevirtual 227	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   162: checkcast 245	android/telephony/TelephonyManager
    //   165: putfield 77	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   168: aload_0
    //   169: getfield 77	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   172: aload_0
    //   173: getfield 84	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyPhoneStateListener	Landroid/telephony/PhoneStateListener;
    //   176: bipush 32
    //   178: invokevirtual 249	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   181: aload_0
    //   182: aload_0
    //   183: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   186: ldc 254
    //   188: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   191: putfield 262	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Int	I
    //   194: aload_0
    //   195: aload_0
    //   196: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   199: ldc_w 263
    //   202: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   205: putfield 265	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Int	I
    //   208: aload_0
    //   209: aload_0
    //   210: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   213: ldc_w 266
    //   216: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   219: putfield 268	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Int	I
    //   222: aload_0
    //   223: aload_0
    //   224: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   227: ldc_w 269
    //   230: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   233: putfield 271	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Int	I
    //   236: aload_0
    //   237: aload_0
    //   238: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   241: ldc_w 272
    //   244: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   247: putfield 274	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_e_of_type_Int	I
    //   250: aload_0
    //   251: aload_0
    //   252: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   255: ldc_w 275
    //   258: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   261: putfield 277	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_f_of_type_Int	I
    //   264: aload_0
    //   265: aload_0
    //   266: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   269: ldc_w 278
    //   272: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   275: putfield 280	com/tencent/av/smallscreen/BaseSmallScreenService:g	I
    //   278: aload_0
    //   279: aload_0
    //   280: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   283: ldc_w 281
    //   286: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   289: putfield 283	com/tencent/av/smallscreen/BaseSmallScreenService:h	I
    //   292: aload_0
    //   293: aload_0
    //   294: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   297: ldc_w 284
    //   300: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   303: putfield 286	com/tencent/av/smallscreen/BaseSmallScreenService:i	I
    //   306: aload_0
    //   307: aload_0
    //   308: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   311: ldc_w 287
    //   314: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   317: putfield 289	com/tencent/av/smallscreen/BaseSmallScreenService:j	I
    //   320: aload_0
    //   321: aload_0
    //   322: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   325: ldc_w 290
    //   328: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   331: putfield 292	com/tencent/av/smallscreen/BaseSmallScreenService:k	I
    //   334: aload_0
    //   335: aload_0
    //   336: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   339: ldc_w 293
    //   342: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   345: putfield 295	com/tencent/av/smallscreen/BaseSmallScreenService:l	I
    //   348: aload_0
    //   349: aload_1
    //   350: ldc_w 296
    //   353: aconst_null
    //   354: invokevirtual 300	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   357: checkcast 210	com/tencent/av/smallscreen/SmallScreenRelativeLayout
    //   360: putfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   363: aload_0
    //   364: aload_1
    //   365: ldc_w 301
    //   368: aconst_null
    //   369: invokevirtual 300	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   372: checkcast 210	com/tencent/av/smallscreen/SmallScreenRelativeLayout
    //   375: putfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   378: aload_0
    //   379: getfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   382: invokevirtual 303	com/tencent/av/smallscreen/SmallScreenRelativeLayout:b	()V
    //   385: aload_0
    //   386: getfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   389: aload_0
    //   390: invokevirtual 307	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setFloatListener	(Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout$FloatListener;)V
    //   393: aload_0
    //   394: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   397: aload_0
    //   398: invokevirtual 307	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setFloatListener	(Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout$FloatListener;)V
    //   401: aload_0
    //   402: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   405: aload_0
    //   406: invokevirtual 253	com/tencent/av/smallscreen/BaseSmallScreenService:getResources	()Landroid/content/res/Resources;
    //   409: ldc_w 308
    //   412: invokevirtual 260	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   415: iconst_5
    //   416: imul
    //   417: iconst_2
    //   418: idiv
    //   419: invokevirtual 311	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setTitleHeight	(I)V
    //   422: aload_0
    //   423: aload_0
    //   424: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   427: ldc_w 312
    //   430: invokevirtual 316	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   433: checkcast 318	android/widget/TextView
    //   436: putfield 67	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   439: aload_0
    //   440: new 112	com/tencent/av/smallscreen/SmallScreenToast
    //   443: dup
    //   444: aload_0
    //   445: aload_0
    //   446: getfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   449: invokespecial 321	com/tencent/av/smallscreen/SmallScreenToast:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   452: putfield 65	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast	Lcom/tencent/av/smallscreen/SmallScreenToast;
    //   455: aload_0
    //   456: new 112	com/tencent/av/smallscreen/SmallScreenToast
    //   459: dup
    //   460: aload_0
    //   461: aload_0
    //   462: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   465: invokespecial 321	com/tencent/av/smallscreen/SmallScreenToast:<init>	(Landroid/content/Context;Landroid/view/View;)V
    //   468: putfield 63	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast	Lcom/tencent/av/smallscreen/SmallScreenToast;
    //   471: aload_0
    //   472: getfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   475: iconst_1
    //   476: invokevirtual 325	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setIsRotateSize	(Z)V
    //   479: aload_0
    //   480: getfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   483: aload_0
    //   484: getfield 262	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_Int	I
    //   487: aload_0
    //   488: getfield 265	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Int	I
    //   491: invokevirtual 329	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setSize	(II)V
    //   494: aload_0
    //   495: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   498: aload_0
    //   499: getfield 268	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Int	I
    //   502: aload_0
    //   503: getfield 271	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_d_of_type_Int	I
    //   506: invokevirtual 329	com/tencent/av/smallscreen/SmallScreenRelativeLayout:setSize	(II)V
    //   509: aload_0
    //   510: getfield 65	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast	Lcom/tencent/av/smallscreen/SmallScreenToast;
    //   513: invokevirtual 115	com/tencent/av/smallscreen/SmallScreenToast:a	()Landroid/view/WindowManager$LayoutParams;
    //   516: invokestatic 331	com/tencent/av/smallscreen/BaseSmallScreenService:a	(Landroid/view/WindowManager$LayoutParams;)V
    //   519: aload_0
    //   520: getfield 63	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast	Lcom/tencent/av/smallscreen/SmallScreenToast;
    //   523: invokevirtual 115	com/tencent/av/smallscreen/SmallScreenToast:a	()Landroid/view/WindowManager$LayoutParams;
    //   526: invokestatic 331	com/tencent/av/smallscreen/BaseSmallScreenService:a	(Landroid/view/WindowManager$LayoutParams;)V
    //   529: aload_0
    //   530: aload_0
    //   531: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   534: ldc_w 332
    //   537: invokevirtual 316	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   540: checkcast 334	android/widget/ImageView
    //   543: putfield 69	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   546: aload_0
    //   547: getfield 69	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   550: ldc_w 335
    //   553: invokevirtual 338	android/widget/ImageView:setImageResource	(I)V
    //   556: aload_0
    //   557: getfield 69	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   560: invokevirtual 342	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   563: checkcast 344	android/graphics/drawable/AnimationDrawable
    //   566: invokevirtual 347	android/graphics/drawable/AnimationDrawable:start	()V
    //   569: aload_0
    //   570: aload_0
    //   571: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout	Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout;
    //   574: ldc_w 348
    //   577: invokevirtual 316	com/tencent/av/smallscreen/SmallScreenRelativeLayout:findViewById	(I)Landroid/view/View;
    //   580: putfield 71	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   583: new 350	android/content/IntentFilter
    //   586: dup
    //   587: invokespecial 351	android/content/IntentFilter:<init>	()V
    //   590: astore_1
    //   591: aload_1
    //   592: ldc_w 353
    //   595: invokevirtual 357	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   598: aload_1
    //   599: ldc_w 359
    //   602: invokevirtual 357	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   605: aload_0
    //   606: invokestatic 361	com/tencent/av/smallscreen/SmallScreenUtils:g	()Z
    //   609: putfield 43	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_Boolean	Z
    //   612: aload_0
    //   613: aload_0
    //   614: getfield 90	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   617: checkcast 175	com/tencent/common/app/AppInterface
    //   620: invokevirtual 178	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   623: invokestatic 363	com/tencent/av/smallscreen/SmallScreenUtils:a	(Landroid/content/Context;)Z
    //   626: putfield 49	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_e_of_type_Boolean	Z
    //   629: aload_0
    //   630: aload_0
    //   631: getfield 90	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   634: checkcast 175	com/tencent/common/app/AppInterface
    //   637: invokevirtual 178	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   640: invokestatic 365	com/tencent/av/smallscreen/SmallScreenUtils:b	(Landroid/content/Context;)Z
    //   643: putfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_c_of_type_Boolean	Z
    //   646: aload_0
    //   647: aload_0
    //   648: getfield 90	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   651: checkcast 175	com/tencent/common/app/AppInterface
    //   654: invokevirtual 178	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   657: invokestatic 181	com/tencent/av/smallscreen/SmallScreenUtils:d	(Landroid/content/Context;)Z
    //   660: putfield 51	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_f_of_type_Boolean	Z
    //   663: aload_0
    //   664: getfield 73	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   667: ifnonnull +15 -> 682
    //   670: aload_0
    //   671: new 367	byt
    //   674: dup
    //   675: aload_0
    //   676: invokespecial 368	byt:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   679: putfield 73	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   682: aload_0
    //   683: invokevirtual 370	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   686: aload_0
    //   687: getfield 73	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   690: ldc2_w 371
    //   693: invokevirtual 376	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   696: pop
    //   697: aload_0
    //   698: getfield 75	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   701: ifnonnull +15 -> 716
    //   704: aload_0
    //   705: new 378	byu
    //   708: dup
    //   709: aload_0
    //   710: invokespecial 379	byu:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   713: putfield 75	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   716: aload_0
    //   717: invokevirtual 370	com/tencent/av/smallscreen/BaseSmallScreenService:a	()Landroid/os/Handler;
    //   720: aload_0
    //   721: getfield 75	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   724: ldc2_w 380
    //   727: invokevirtual 376	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   730: pop
    //   731: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   734: ifeq -685 -> 49
    //   737: ldc 10
    //   739: iconst_2
    //   740: ldc_w 383
    //   743: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	this	BaseSmallScreenService
    //   32	2	1	localLayoutInflater	android.view.LayoutInflater
    //   50	17	1	localException1	java.lang.Exception
    //   81	23	1	localException2	java.lang.Exception
    //   114	1	1	localObject	java.lang.Object
    //   118	23	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   151	448	1	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   14	18	50	java/lang/Exception
    //   23	33	81	java/lang/Exception
    //   23	33	118	java/lang/OutOfMemoryError
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy start");
    }
    super.onDestroy();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy end");
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onLowMemory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService
 * JD-Core Version:    0.7.0.1
 */