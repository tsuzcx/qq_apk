package com.tencent.open.downloadnew.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

public class AppNotificationManager$NotificationStyleDiscover
{
  protected float a;
  protected DisplayMetrics a;
  protected Integer a;
  protected final String a;
  protected float b;
  protected Integer b;
  protected final String b;
  
  AppNotificationManager$NotificationStyleDiscover(AppNotificationManager paramAppNotificationManager, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangInteger = null;
    this.jdField_a_of_type_Float = 14.0F;
    this.jdField_b_of_type_JavaLangInteger = null;
    this.jdField_b_of_type_Float = 16.0F;
    this.jdField_a_of_type_JavaLangString = "SearchForText";
    this.jdField_b_of_type_JavaLangString = "SearchForTitle";
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    a(paramContext);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Integer a()
  {
    return this.jdField_a_of_type_JavaLangInteger;
  }
  
  /* Error */
  protected void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/open/downloadnew/common/AppNotificationManager$NotificationStyleDiscover:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   4: ifnull +11 -> 15
    //   7: aload_0
    //   8: getfield 25	com/tencent/open/downloadnew/common/AppNotificationManager$NotificationStyleDiscover:jdField_b_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   11: ifnull +4 -> 15
    //   14: return
    //   15: getstatic 75	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 16
    //   20: if_icmpge +138 -> 158
    //   23: new 77	android/app/Notification
    //   26: dup
    //   27: invokespecial 78	android/app/Notification:<init>	()V
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 82	java/lang/Object:getClass	()Ljava/lang/Class;
    //   35: astore_3
    //   36: aload_3
    //   37: ldc 84
    //   39: iconst_4
    //   40: anewarray 86	java/lang/Class
    //   43: dup
    //   44: iconst_0
    //   45: ldc 45
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: ldc 88
    //   52: aastore
    //   53: dup
    //   54: iconst_2
    //   55: ldc 88
    //   57: aastore
    //   58: dup
    //   59: iconst_3
    //   60: ldc 90
    //   62: aastore
    //   63: invokevirtual 94	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   66: aload_2
    //   67: iconst_4
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: ldc 34
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: ldc 30
    //   84: aastore
    //   85: dup
    //   86: iconst_3
    //   87: aconst_null
    //   88: aastore
    //   89: invokevirtual 100	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: aload_2
    //   94: getfield 104	android/app/Notification:contentView	Landroid/widget/RemoteViews;
    //   97: aload_1
    //   98: aconst_null
    //   99: invokevirtual 110	android/widget/RemoteViews:apply	(Landroid/content/Context;Landroid/view/ViewGroup;)Landroid/view/View;
    //   102: checkcast 112	android/view/ViewGroup
    //   105: astore_1
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 115	com/tencent/open/downloadnew/common/AppNotificationManager$NotificationStyleDiscover:a	(Landroid/view/ViewGroup;)Z
    //   111: pop
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 117	com/tencent/open/downloadnew/common/AppNotificationManager$NotificationStyleDiscover:b	(Landroid/view/ViewGroup;)Z
    //   117: pop
    //   118: return
    //   119: astore_1
    //   120: getstatic 120	com/tencent/open/downloadnew/common/AppNotificationManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   123: new 122	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   130: ldc 125
    //   132: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aload_1
    //   146: invokestatic 142	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: return
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   155: goto -62 -> 93
    //   158: new 147	android/app/Notification$Builder
    //   161: dup
    //   162: aload_1
    //   163: invokespecial 149	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   166: iconst_1
    //   167: invokevirtual 153	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   170: ldc 34
    //   172: invokevirtual 157	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   175: ldc 30
    //   177: invokevirtual 160	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   180: aconst_null
    //   181: invokevirtual 164	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   184: invokevirtual 168	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   187: astore_2
    //   188: goto -95 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	NotificationStyleDiscover
    //   0	191	1	paramContext	Context
    //   30	158	2	localNotification	android.app.Notification
    //   35	2	3	localClass	java.lang.Class
    //   150	2	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   15	36	119	java/lang/Exception
    //   93	118	119	java/lang/Exception
    //   151	155	119	java/lang/Exception
    //   158	188	119	java/lang/Exception
    //   36	93	150	java/lang/Exception
  }
  
  protected boolean a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForTitle".equals(localTextView.getText().toString()))
        {
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_b_of_type_Float = localTextView.getTextSize();
          this.jdField_b_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (a((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public Integer b()
  {
    return this.jdField_b_of_type_JavaLangInteger;
  }
  
  protected boolean b(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForText".equals(localTextView.getText().toString()))
        {
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_a_of_type_Float = localTextView.getTextSize();
          this.jdField_a_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (b((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.AppNotificationManager.NotificationStyleDiscover
 * JD-Core Version:    0.7.0.1
 */