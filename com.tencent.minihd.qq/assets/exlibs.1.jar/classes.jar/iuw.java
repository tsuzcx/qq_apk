import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.core.UniformDownloadNfn;

public class iuw
{
  float jdField_a_of_type_Float = 14.0F;
  int jdField_a_of_type_Int = 0;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  Integer jdField_a_of_type_JavaLangInteger = null;
  final String jdField_a_of_type_JavaLangString = "SearchForText";
  float jdField_b_of_type_Float = 16.0F;
  Integer jdField_b_of_type_JavaLangInteger = null;
  final String jdField_b_of_type_JavaLangString = "SearchForTitle";
  
  public iuw(UniformDownloadNfn paramUniformDownloadNfn, Context paramContext)
  {
    if (paramContext != null)
    {
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      a(paramContext, false);
    }
  }
  
  private boolean a(ViewGroup paramViewGroup)
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
  
  private boolean b(ViewGroup paramViewGroup)
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
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Integer a()
  {
    return this.jdField_a_of_type_JavaLangInteger;
  }
  
  /* Error */
  public void a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +24 -> 25
    //   4: aload_1
    //   5: ldc 46
    //   7: invokevirtual 52	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast 54	android/view/WindowManager
    //   13: invokeinterface 58 1 0
    //   18: aload_0
    //   19: getfield 42	iuw:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   22: invokevirtual 64	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   25: aload_0
    //   26: getfield 21	iuw:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 26	iuw:jdField_b_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   36: ifnull +4 -> 40
    //   39: return
    //   40: aload_0
    //   41: getfield 44	iuw:jdField_a_of_type_Int	I
    //   44: iconst_3
    //   45: if_icmpgt -6 -> 39
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 44	iuw:jdField_a_of_type_Int	I
    //   53: iconst_1
    //   54: iadd
    //   55: putfield 44	iuw:jdField_a_of_type_Int	I
    //   58: getstatic 133	android/os/Build$VERSION:SDK_INT	I
    //   61: bipush 16
    //   63: if_icmpge +170 -> 233
    //   66: new 135	android/app/Notification
    //   69: dup
    //   70: invokespecial 136	android/app/Notification:<init>	()V
    //   73: astore_3
    //   74: aload_3
    //   75: invokevirtual 140	java/lang/Object:getClass	()Ljava/lang/Class;
    //   78: astore 4
    //   80: aload 4
    //   82: ldc 142
    //   84: iconst_4
    //   85: anewarray 144	java/lang/Class
    //   88: dup
    //   89: iconst_0
    //   90: ldc 48
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: ldc 87
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: ldc 87
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: ldc 146
    //   107: aastore
    //   108: invokevirtual 150	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   111: aload_3
    //   112: iconst_4
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: ldc 35
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: ldc 31
    //   129: aastore
    //   130: dup
    //   131: iconst_3
    //   132: aconst_null
    //   133: aastore
    //   134: invokevirtual 156	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: new 158	android/widget/LinearLayout
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 161	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   146: astore 4
    //   148: aload_3
    //   149: getfield 165	android/app/Notification:contentView	Landroid/widget/RemoteViews;
    //   152: aload_1
    //   153: aload 4
    //   155: invokevirtual 171	android/widget/RemoteViews:apply	(Landroid/content/Context;Landroid/view/ViewGroup;)Landroid/view/View;
    //   158: checkcast 71	android/view/ViewGroup
    //   161: astore_1
    //   162: aload_0
    //   163: aload_1
    //   164: invokespecial 121	iuw:a	(Landroid/view/ViewGroup;)Z
    //   167: ifne +12 -> 179
    //   170: getstatic 174	com/tencent/mobileqq/filemanager/core/UniformDownloadNfn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   173: iconst_1
    //   174: ldc 176
    //   176: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_0
    //   180: aload_1
    //   181: invokespecial 123	iuw:b	(Landroid/view/ViewGroup;)Z
    //   184: ifne +12 -> 196
    //   187: getstatic 174	com/tencent/mobileqq/filemanager/core/UniformDownloadNfn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: iconst_1
    //   191: ldc 184
    //   193: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload 4
    //   198: invokevirtual 187	android/widget/LinearLayout:removeAllViews	()V
    //   201: return
    //   202: astore_1
    //   203: getstatic 174	com/tencent/mobileqq/filemanager/core/UniformDownloadNfn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   206: iconst_1
    //   207: ldc 189
    //   209: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_1
    //   213: invokevirtual 192	java/lang/Exception:printStackTrace	()V
    //   216: return
    //   217: astore 4
    //   219: aload 4
    //   221: invokevirtual 192	java/lang/Exception:printStackTrace	()V
    //   224: goto -86 -> 138
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 193	java/lang/NoSuchFieldError:printStackTrace	()V
    //   232: return
    //   233: new 195	android/app/Notification$Builder
    //   236: dup
    //   237: aload_1
    //   238: invokespecial 196	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   241: iconst_1
    //   242: invokevirtual 200	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   245: ldc 35
    //   247: invokevirtual 204	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   250: ldc 31
    //   252: invokevirtual 207	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   255: aconst_null
    //   256: invokevirtual 211	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   259: invokevirtual 215	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   262: astore_3
    //   263: goto -125 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	iuw
    //   0	266	1	paramContext	Context
    //   0	266	2	paramBoolean	boolean
    //   73	190	3	localNotification	android.app.Notification
    //   78	119	4	localObject	Object
    //   217	3	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   58	80	202	java/lang/Exception
    //   138	179	202	java/lang/Exception
    //   179	196	202	java/lang/Exception
    //   196	201	202	java/lang/Exception
    //   219	224	202	java/lang/Exception
    //   233	263	202	java/lang/Exception
    //   80	138	217	java/lang/Exception
    //   58	80	227	java/lang/NoSuchFieldError
    //   80	138	227	java/lang/NoSuchFieldError
    //   138	179	227	java/lang/NoSuchFieldError
    //   179	196	227	java/lang/NoSuchFieldError
    //   196	201	227	java/lang/NoSuchFieldError
    //   219	224	227	java/lang/NoSuchFieldError
    //   233	263	227	java/lang/NoSuchFieldError
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public Integer b()
  {
    return this.jdField_b_of_type_JavaLangInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iuw
 * JD-Core Version:    0.7.0.1
 */