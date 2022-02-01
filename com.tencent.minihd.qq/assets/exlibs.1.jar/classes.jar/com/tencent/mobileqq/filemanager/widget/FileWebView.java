package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import jbo;
import jbp;
import jbq;

public class FileWebView
  extends WebView
{
  private static final String jdField_a_of_type_JavaLangString = "FileWebView";
  private static final String jdField_b_of_type_JavaLangString = "FileWebView";
  float jdField_a_of_type_Float = 1.0F;
  final int jdField_a_of_type_Int = 80;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  public FileWebView.TitilebarEventInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  public boolean b;
  float c = 0.0F;
  
  public FileWebView(Context paramContext)
  {
    this(paramContext, null);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public FileWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {
      setZoomControlGone(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilTimerTask = new jbp(this, new jbo(this));
      return;
      getSettings().setDisplayZoomControls(false);
    }
  }
  
  private Class a(ParameterizedType paramParameterizedType, int paramInt)
  {
    paramParameterizedType = paramParameterizedType.getActualTypeArguments()[paramInt];
    if ((paramParameterizedType instanceof ParameterizedType)) {
      return (Class)((ParameterizedType)paramParameterizedType).getRawType();
    }
    if ((paramParameterizedType instanceof GenericArrayType)) {
      return (Class)((GenericArrayType)paramParameterizedType).getGenericComponentType();
    }
    if ((paramParameterizedType instanceof TypeVariable)) {
      return a(((TypeVariable)paramParameterizedType).getBounds()[0], 0);
    }
    return (Class)paramParameterizedType;
  }
  
  private Class a(Type paramType, int paramInt)
  {
    if ((paramType instanceof ParameterizedType)) {
      return a((ParameterizedType)paramType, paramInt);
    }
    if ((paramType instanceof TypeVariable)) {
      return a(((TypeVariable)paramType).getBounds()[0], 0);
    }
    return (Class)paramType;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    float f = getScale();
    return Math.abs(this.jdField_a_of_type_Float - f) < 0.1D;
  }
  
  /* Error */
  public boolean a(WebView paramWebView, String paramString, FileWebView.JSInterface paramJSInterface)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_2
    //   7: ldc 161
    //   9: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_2
    //   18: ldc 169
    //   20: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   23: astore 6
    //   25: aload_2
    //   26: invokevirtual 176	java/lang/String:length	()I
    //   29: iconst_1
    //   30: if_icmple +542 -> 572
    //   33: aload 6
    //   35: arraylength
    //   36: iconst_1
    //   37: if_icmple +535 -> 572
    //   40: aload 6
    //   42: iconst_0
    //   43: aaload
    //   44: astore_1
    //   45: aload 6
    //   47: iconst_1
    //   48: aaload
    //   49: ldc 178
    //   51: ldc 180
    //   53: invokevirtual 184	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: new 186	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   64: aload_1
    //   65: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 193
    //   70: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: ldc 199
    //   78: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: invokestatic 205	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   84: astore_1
    //   85: aload_1
    //   86: invokeinterface 210 1 0
    //   91: iconst_5
    //   92: if_icmpge +5 -> 97
    //   95: iconst_0
    //   96: ireturn
    //   97: aload_1
    //   98: iconst_2
    //   99: invokeinterface 214 2 0
    //   104: checkcast 163	java/lang/String
    //   107: ldc 216
    //   109: invokevirtual 219	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   112: ifne +5 -> 117
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_1
    //   118: iconst_3
    //   119: invokeinterface 214 2 0
    //   124: checkcast 163	java/lang/String
    //   127: astore 9
    //   129: aconst_null
    //   130: astore 6
    //   132: aload_2
    //   133: invokestatic 224	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)Ljava/util/LinkedHashMap;
    //   136: astore_1
    //   137: aload_1
    //   138: astore 6
    //   140: aload_3
    //   141: invokevirtual 228	java/lang/Object:getClass	()Ljava/lang/Class;
    //   144: invokevirtual 232	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   147: astore 10
    //   149: aload 10
    //   151: arraylength
    //   152: istore 5
    //   154: iconst_0
    //   155: istore 4
    //   157: aconst_null
    //   158: astore_1
    //   159: iload 4
    //   161: iload 5
    //   163: if_icmpge +401 -> 564
    //   166: aload 10
    //   168: iload 4
    //   170: aaload
    //   171: astore 8
    //   173: aload_1
    //   174: astore 7
    //   176: aload 8
    //   178: invokevirtual 237	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   181: aload 9
    //   183: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +92 -> 278
    //   189: aload 8
    //   191: invokevirtual 245	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   194: astore_1
    //   195: aload_1
    //   196: astore 7
    //   198: aload_1
    //   199: arraylength
    //   200: aload 6
    //   202: invokevirtual 248	java/util/LinkedHashMap:size	()I
    //   205: if_icmpne +73 -> 278
    //   208: aload_1
    //   209: astore 7
    //   211: aload 8
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull +339 -> 554
    //   218: aload 6
    //   220: invokevirtual 248	java/util/LinkedHashMap:size	()I
    //   223: ifne +67 -> 290
    //   226: aload_1
    //   227: aload_3
    //   228: iconst_0
    //   229: anewarray 51	java/lang/Object
    //   232: invokevirtual 252	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: iconst_1
    //   237: ireturn
    //   238: astore_1
    //   239: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +29 -> 271
    //   245: ldc 8
    //   247: iconst_1
    //   248: new 186	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 259
    //   258: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_2
    //   262: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload_1
    //   272: invokevirtual 266	java/lang/Exception:printStackTrace	()V
    //   275: goto -135 -> 140
    //   278: iload 4
    //   280: iconst_1
    //   281: iadd
    //   282: istore 4
    //   284: aload 7
    //   286: astore_1
    //   287: goto -128 -> 159
    //   290: aload 6
    //   292: invokevirtual 270	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   295: invokeinterface 276 1 0
    //   300: astore_2
    //   301: aload 7
    //   303: arraylength
    //   304: anewarray 51	java/lang/Object
    //   307: astore 6
    //   309: iconst_0
    //   310: istore 4
    //   312: iload 4
    //   314: aload 7
    //   316: arraylength
    //   317: if_icmpge +209 -> 526
    //   320: aload_0
    //   321: aload 7
    //   323: iload 4
    //   325: aaload
    //   326: iload 4
    //   328: invokespecial 135	com/tencent/mobileqq/filemanager/widget/FileWebView:a	(Ljava/lang/reflect/Type;I)Ljava/lang/Class;
    //   331: invokevirtual 277	java/lang/Class:toString	()Ljava/lang/String;
    //   334: invokevirtual 280	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   337: astore 8
    //   339: aload 8
    //   341: ldc_w 282
    //   344: invokevirtual 286	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   347: ifne +14 -> 361
    //   350: aload 8
    //   352: ldc_w 288
    //   355: invokevirtual 286	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   358: ifeq +24 -> 382
    //   361: aload 6
    //   363: iload 4
    //   365: aload_2
    //   366: iload 4
    //   368: aaload
    //   369: checkcast 163	java/lang/String
    //   372: invokestatic 292	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   375: invokestatic 295	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   378: aastore
    //   379: goto +202 -> 581
    //   382: aload 8
    //   384: ldc_w 297
    //   387: invokevirtual 286	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   390: ifeq +42 -> 432
    //   393: aload 6
    //   395: iload 4
    //   397: aload_2
    //   398: iload 4
    //   400: aaload
    //   401: checkcast 163	java/lang/String
    //   404: invokestatic 303	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   407: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   410: aastore
    //   411: goto +170 -> 581
    //   414: astore_1
    //   415: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +12 -> 430
    //   421: ldc 8
    //   423: iconst_2
    //   424: ldc_w 308
    //   427: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: iconst_0
    //   431: ireturn
    //   432: aload 8
    //   434: ldc_w 310
    //   437: invokevirtual 286	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   440: ifeq +36 -> 476
    //   443: aload 6
    //   445: iload 4
    //   447: aload_2
    //   448: iload 4
    //   450: aaload
    //   451: checkcast 163	java/lang/String
    //   454: aastore
    //   455: goto +126 -> 581
    //   458: astore_1
    //   459: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +12 -> 474
    //   465: ldc 8
    //   467: iconst_2
    //   468: ldc_w 312
    //   471: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: iconst_0
    //   475: ireturn
    //   476: aload 8
    //   478: ldc_w 314
    //   481: invokevirtual 286	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   484: ifeq +97 -> 581
    //   487: aload 6
    //   489: iload 4
    //   491: aload_2
    //   492: iload 4
    //   494: aaload
    //   495: checkcast 163	java/lang/String
    //   498: invokestatic 319	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   501: invokestatic 322	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   504: aastore
    //   505: goto +76 -> 581
    //   508: astore_1
    //   509: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +12 -> 524
    //   515: ldc 8
    //   517: iconst_2
    //   518: ldc_w 324
    //   521: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: iconst_0
    //   525: ireturn
    //   526: aload_1
    //   527: aload_3
    //   528: aload 6
    //   530: invokevirtual 252	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   533: pop
    //   534: iconst_1
    //   535: ireturn
    //   536: astore_1
    //   537: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +12 -> 552
    //   543: ldc 8
    //   545: iconst_2
    //   546: ldc_w 326
    //   549: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: iconst_0
    //   553: ireturn
    //   554: aload_3
    //   555: aload_2
    //   556: invokeinterface 331 2 0
    //   561: goto -325 -> 236
    //   564: aload_1
    //   565: astore 7
    //   567: aconst_null
    //   568: astore_1
    //   569: goto -355 -> 214
    //   572: ldc 180
    //   574: astore_1
    //   575: ldc 180
    //   577: astore_2
    //   578: goto -521 -> 57
    //   581: iload 4
    //   583: iconst_1
    //   584: iadd
    //   585: istore 4
    //   587: goto -275 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	FileWebView
    //   0	590	1	paramWebView	WebView
    //   0	590	2	paramString	String
    //   0	590	3	paramJSInterface	FileWebView.JSInterface
    //   155	431	4	i	int
    //   152	12	5	j	int
    //   23	506	6	localObject1	Object
    //   174	392	7	localWebView	WebView
    //   171	306	8	localObject2	Object
    //   127	55	9	str	String
    //   147	20	10	arrayOfMethod	java.lang.reflect.Method[]
    // Exception table:
    //   from	to	target	type
    //   132	137	238	java/lang/Exception
    //   218	236	414	java/lang/IllegalAccessException
    //   290	309	414	java/lang/IllegalAccessException
    //   312	361	414	java/lang/IllegalAccessException
    //   361	379	414	java/lang/IllegalAccessException
    //   382	411	414	java/lang/IllegalAccessException
    //   432	455	414	java/lang/IllegalAccessException
    //   476	505	414	java/lang/IllegalAccessException
    //   526	534	414	java/lang/IllegalAccessException
    //   218	236	458	java/lang/IllegalArgumentException
    //   290	309	458	java/lang/IllegalArgumentException
    //   312	361	458	java/lang/IllegalArgumentException
    //   361	379	458	java/lang/IllegalArgumentException
    //   382	411	458	java/lang/IllegalArgumentException
    //   432	455	458	java/lang/IllegalArgumentException
    //   476	505	458	java/lang/IllegalArgumentException
    //   526	534	458	java/lang/IllegalArgumentException
    //   218	236	508	java/lang/reflect/InvocationTargetException
    //   290	309	508	java/lang/reflect/InvocationTargetException
    //   312	361	508	java/lang/reflect/InvocationTargetException
    //   361	379	508	java/lang/reflect/InvocationTargetException
    //   382	411	508	java/lang/reflect/InvocationTargetException
    //   432	455	508	java/lang/reflect/InvocationTargetException
    //   476	505	508	java/lang/reflect/InvocationTargetException
    //   526	534	508	java/lang/reflect/InvocationTargetException
    //   218	236	536	java/lang/Exception
    //   290	309	536	java/lang/Exception
    //   312	361	536	java/lang/Exception
    //   361	379	536	java/lang/Exception
    //   382	411	536	java/lang/Exception
    //   432	455	536	java/lang/Exception
    //   476	505	536	java/lang/Exception
    //   526	534	536	java/lang/Exception
  }
  
  public void b()
  {
    new Handler().postDelayed(new jbq(this), 500L);
  }
  
  public void destroy()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.d("FileWebView", 4, "memoryleaktest webview timer " + this.jdField_a_of_type_JavaUtilTimer + " this " + this + "is cancel");
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      super.destroy();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Long = Calendar.getInstance().getTimeInMillis();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      if (Calendar.getInstance().getTimeInMillis() - this.jdField_a_of_type_Long < 80L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.f();
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.c = paramMotionEvent.getY();
      if (this.jdField_b_of_type_Float > this.c)
      {
        getContentHeight();
        getHeight();
        getWebScrollY();
        getScale();
        if (getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY()) < 1.0D)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
          return super.dispatchTouchEvent(paramMotionEvent);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a();
      }
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.c();
      } while (getScrollY() >= 1.0F);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.d();
      return super.dispatchTouchEvent(paramMotionEvent);
      a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.e();
    }
  }
  
  public boolean onCheckIsTextEditor()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.onCheckIsTextEditor();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface == null) {}
    do
    {
      return;
      paramInt1 = getContentHeight();
      paramInt3 = getView().getHeight();
      int i = getWebScrollY();
      float f = getScale();
      if (QLog.isDevelopLevel()) {
        QLog.d("FileWebView", 4, "contentHeight[" + paramInt1 + "],height[" + paramInt3 + "],scroolY[" + i + "],scale[" + f + "]");
      }
      f = getContentHeight() * getScale() - (getView().getHeight() + getWebScrollY());
      if ((f < paramInt3 * 2) && (!FileManagerUtil.a())) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.g();
      }
      if (f < 2.5D) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.b();
      }
    } while ((paramInt2 != 0) || (paramInt4 == 0));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface.a(false);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != 0) {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setListenSroll()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 2000L, 300L);
      return;
    }
  }
  
  public void setOnCustomScroolChangeListener(FileWebView.TitilebarEventInterface paramTitilebarEventInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView$TitilebarEventInterface = paramTitilebarEventInterface;
  }
  
  public void setOverrideOnCheckIsTextEditor(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setZoomControlGone(View paramView)
  {
    try
    {
      Field localField = WebView.class.getDeclaredField("mZoomButtonsController");
      localField.setAccessible(true);
      ZoomButtonsController localZoomButtonsController = new ZoomButtonsController(paramView);
      localZoomButtonsController.getZoomControls().setVisibility(8);
      return;
    }
    catch (SecurityException paramView)
    {
      try
      {
        localField.set(paramView, localZoomButtonsController);
        return;
      }
      catch (IllegalArgumentException paramView)
      {
        paramView.printStackTrace();
        return;
        paramView = paramView;
        paramView.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    catch (NoSuchFieldException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.FileWebView
 * JD-Core Version:    0.7.0.1
 */