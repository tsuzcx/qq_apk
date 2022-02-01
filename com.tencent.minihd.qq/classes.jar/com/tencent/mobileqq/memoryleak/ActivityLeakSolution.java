package com.tencent.mobileqq.memoryleak;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ActivityLeakSolution
{
  private static final String a = "LeakInspector";
  
  private static void a()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Class.forName("android.text.TextLine").getDeclaredField("sCached");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (Object[])((Field)localObject1).get(null);
        if (localObject1 == null) {
          throw new IllegalStateException("Failed to invoke currentActivityThread");
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        return;
        try
        {
          int j = localClassNotFoundException.length;
          i = 0;
          if (i < j)
          {
            Object localObject2 = localClassNotFoundException[i];
            Field localField = localObject2.getClass().getDeclaredField("mSpanned");
            localField.setAccessible(true);
            localObject2 = (Spanned)localField.get(localObject2);
            if (localObject2 != null)
            {
              localField = localObject2.getClass().getDeclaredField("mSpanned");
              localField.setAccessible(true);
              localObject2 = (Spanned)localField.get(localObject2);
              if ((localObject2 instanceof SpannableStringBuilder)) {
                ((SpannableStringBuilder)localObject2).clearSpans();
              }
            }
          }
          else
          {
            return;
          }
        }
        finally {}
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getWindow() == null) || (paramActivity.getWindow().peekDecorView() == null)) {
      return;
    }
    try
    {
      b(paramActivity.getWindow().peekDecorView().getRootView());
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Dialog paramDialog)
  {
    if (paramDialog == null) {}
    for (;;)
    {
      return;
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "mDismissMessage";
      arrayOfString[1] = "mCancelMessage";
      arrayOfString[2] = "mShowMessage";
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        try
        {
          localObject = Dialog.class.getDeclaredField((String)localObject);
          if (localObject != null)
          {
            if (!((Field)localObject).isAccessible()) {
              ((Field)localObject).setAccessible(true);
            }
            localObject = ((Field)localObject).get(paramDialog);
            if ((localObject instanceof Message))
            {
              localObject = (Message)localObject;
              if (((Message)localObject).obj != null)
              {
                ((Message)localObject).obj = null;
                ((Message)localObject).what = 0;
              }
            }
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        i += 1;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {}
    label181:
    for (;;)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        String[] arrayOfString = new String[3];
        arrayOfString[0] = "mCurRootView";
        arrayOfString[1] = "mServedView";
        arrayOfString[2] = "mNextServedView";
        int i = 0;
        for (;;)
        {
          for (;;)
          {
            if (i >= arrayOfString.length) {
              break label181;
            }
            Object localObject1 = arrayOfString[i];
            try
            {
              localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
              if (!((Field)localObject1).isAccessible()) {
                ((Field)localObject1).setAccessible(true);
              }
              Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
              if ((localObject2 != null) && ((localObject2 instanceof View)))
              {
                localObject2 = (View)localObject2;
                if (((View)localObject2).getContext() == paramContext)
                {
                  ((Field)localObject1).set(localInputMethodManager, null);
                }
                else
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("LeakInspector", 2, "fixInputMethodManagerLeak break, context is not suitable, get_context=" + ((View)localObject2).getContext() + " dest_context=" + paramContext);
                  return;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              i += 1;
            }
          }
        }
      }
    }
  }
  
  /* Error */
  private static void a(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: aconst_null
    //   7: invokevirtual 184	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   10: aload_0
    //   11: aconst_null
    //   12: invokevirtual 188	android/view/View:setOnCreateContextMenuListener	(Landroid/view/View$OnCreateContextMenuListener;)V
    //   15: aload_0
    //   16: aconst_null
    //   17: invokevirtual 192	android/view/View:setOnFocusChangeListener	(Landroid/view/View$OnFocusChangeListener;)V
    //   20: aload_0
    //   21: aconst_null
    //   22: invokevirtual 196	android/view/View:setOnKeyListener	(Landroid/view/View$OnKeyListener;)V
    //   25: aload_0
    //   26: aconst_null
    //   27: invokevirtual 200	android/view/View:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   30: aload_0
    //   31: aconst_null
    //   32: invokevirtual 184	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   35: aload_0
    //   36: aconst_null
    //   37: invokevirtual 204	android/view/View:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   40: aload_0
    //   41: invokevirtual 208	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   44: ifnull +16 -> 60
    //   47: aload_0
    //   48: invokevirtual 208	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   51: aconst_null
    //   52: invokevirtual 214	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   55: aload_0
    //   56: aconst_null
    //   57: invokevirtual 218	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   60: aload_0
    //   61: invokevirtual 221	android/view/View:destroyDrawingCache	()V
    //   64: return
    //   65: astore_0
    //   66: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +11 -> 80
    //   72: ldc 8
    //   74: iconst_2
    //   75: ldc 223
    //   77: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: new 180	java/lang/IncompatibleClassChangeError
    //   83: dup
    //   84: ldc 223
    //   86: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   93: checkcast 180	java/lang/IncompatibleClassChangeError
    //   96: checkcast 180	java/lang/IncompatibleClassChangeError
    //   99: athrow
    //   100: astore_0
    //   101: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +11 -> 115
    //   107: ldc 8
    //   109: iconst_2
    //   110: ldc 223
    //   112: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: new 180	java/lang/IncompatibleClassChangeError
    //   118: dup
    //   119: ldc 223
    //   121: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   124: aload_0
    //   125: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   128: checkcast 180	java/lang/IncompatibleClassChangeError
    //   131: checkcast 180	java/lang/IncompatibleClassChangeError
    //   134: athrow
    //   135: astore_0
    //   136: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +11 -> 150
    //   142: ldc 8
    //   144: iconst_2
    //   145: ldc 223
    //   147: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: new 180	java/lang/IncompatibleClassChangeError
    //   153: dup
    //   154: ldc 223
    //   156: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   159: aload_0
    //   160: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   163: checkcast 180	java/lang/IncompatibleClassChangeError
    //   166: checkcast 180	java/lang/IncompatibleClassChangeError
    //   169: athrow
    //   170: astore_0
    //   171: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +11 -> 185
    //   177: ldc 8
    //   179: iconst_2
    //   180: ldc 223
    //   182: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: new 180	java/lang/IncompatibleClassChangeError
    //   188: dup
    //   189: ldc 223
    //   191: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   198: checkcast 180	java/lang/IncompatibleClassChangeError
    //   201: checkcast 180	java/lang/IncompatibleClassChangeError
    //   204: athrow
    //   205: astore_0
    //   206: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +11 -> 220
    //   212: ldc 8
    //   214: iconst_2
    //   215: ldc 223
    //   217: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: new 180	java/lang/IncompatibleClassChangeError
    //   223: dup
    //   224: ldc 223
    //   226: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   229: aload_0
    //   230: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   233: checkcast 180	java/lang/IncompatibleClassChangeError
    //   236: checkcast 180	java/lang/IncompatibleClassChangeError
    //   239: athrow
    //   240: astore_0
    //   241: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +11 -> 255
    //   247: ldc 8
    //   249: iconst_2
    //   250: ldc 223
    //   252: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: new 180	java/lang/IncompatibleClassChangeError
    //   258: dup
    //   259: ldc 223
    //   261: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   264: aload_0
    //   265: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   268: checkcast 180	java/lang/IncompatibleClassChangeError
    //   271: checkcast 180	java/lang/IncompatibleClassChangeError
    //   274: athrow
    //   275: astore_0
    //   276: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +11 -> 290
    //   282: ldc 8
    //   284: iconst_2
    //   285: ldc 223
    //   287: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: new 180	java/lang/IncompatibleClassChangeError
    //   293: dup
    //   294: ldc 223
    //   296: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   299: aload_0
    //   300: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   303: checkcast 180	java/lang/IncompatibleClassChangeError
    //   306: checkcast 180	java/lang/IncompatibleClassChangeError
    //   309: athrow
    //   310: astore_1
    //   311: goto -301 -> 10
    //   314: astore_1
    //   315: goto -300 -> 15
    //   318: astore_1
    //   319: goto -299 -> 20
    //   322: astore_1
    //   323: goto -298 -> 25
    //   326: astore_1
    //   327: goto -297 -> 30
    //   330: astore_1
    //   331: goto -296 -> 35
    //   334: astore_1
    //   335: goto -295 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramView	View
    //   310	1	1	localThrowable1	Throwable
    //   314	1	1	localThrowable2	Throwable
    //   318	1	1	localThrowable3	Throwable
    //   322	1	1	localThrowable4	Throwable
    //   326	1	1	localThrowable5	Throwable
    //   330	1	1	localThrowable6	Throwable
    //   334	1	1	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	10	65	java/lang/IncompatibleClassChangeError
    //   10	15	100	java/lang/IncompatibleClassChangeError
    //   15	20	135	java/lang/IncompatibleClassChangeError
    //   20	25	170	java/lang/IncompatibleClassChangeError
    //   25	30	205	java/lang/IncompatibleClassChangeError
    //   30	35	240	java/lang/IncompatibleClassChangeError
    //   35	40	275	java/lang/IncompatibleClassChangeError
    //   5	10	310	java/lang/Throwable
    //   10	15	314	java/lang/Throwable
    //   15	20	318	java/lang/Throwable
    //   20	25	322	java/lang/Throwable
    //   25	30	326	java/lang/Throwable
    //   30	35	330	java/lang/Throwable
    //   35	40	334	java/lang/Throwable
  }
  
  private static void a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      b(paramViewGroup.getChildAt(i));
      i += 1;
    }
  }
  
  private static void a(FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout != null)
    {
      Drawable localDrawable = paramFrameLayout.getForeground();
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        paramFrameLayout.setForeground(null);
      }
    }
  }
  
  private static void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    Drawable localDrawable = paramImageView.getDrawable();
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    paramImageView.setImageDrawable(null);
  }
  
  @TargetApi(16)
  private static void a(LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout == null) {}
    for (;;)
    {
      return;
      if (11 <= Build.VERSION.SDK_INT)
      {
        Object localObject1;
        if (16 <= Build.VERSION.SDK_INT) {
          localObject1 = paramLinearLayout.getDividerDrawable();
        }
        while (localObject1 != null)
        {
          ((Drawable)localObject1).setCallback(null);
          paramLinearLayout.setDividerDrawable(null);
          return;
          try
          {
            localObject1 = paramLinearLayout.getClass().getDeclaredField("mDivider");
            ((Field)localObject1).setAccessible(true);
            localObject1 = (Drawable)((Field)localObject1).get(paramLinearLayout);
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            localNoSuchFieldException.printStackTrace();
            Object localObject2 = null;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
            Object localObject3 = null;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            Object localObject4 = null;
          }
        }
      }
    }
  }
  
  /* Error */
  private static void a(android.widget.ListView paramListView)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 286	android/widget/ListView:getSelector	()Landroid/graphics/drawable/Drawable;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +8 -> 14
    //   9: aload_1
    //   10: aconst_null
    //   11: invokevirtual 214	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   14: aload_0
    //   15: invokevirtual 290	android/widget/ListView:getAdapter	()Landroid/widget/ListAdapter;
    //   18: ifnull +8 -> 26
    //   21: aload_0
    //   22: aconst_null
    //   23: invokevirtual 294	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   26: aload_0
    //   27: aconst_null
    //   28: invokevirtual 298	android/widget/ListView:setOnScrollListener	(Landroid/widget/AbsListView$OnScrollListener;)V
    //   31: aload_0
    //   32: aconst_null
    //   33: invokevirtual 302	android/widget/ListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: invokevirtual 306	android/widget/ListView:setOnItemLongClickListener	(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   41: aload_0
    //   42: aconst_null
    //   43: invokevirtual 310	android/widget/ListView:setOnItemSelectedListener	(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    //   46: return
    //   47: astore_0
    //   48: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +11 -> 62
    //   54: ldc 8
    //   56: iconst_2
    //   57: ldc 223
    //   59: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: new 180	java/lang/IncompatibleClassChangeError
    //   65: dup
    //   66: ldc 223
    //   68: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   75: checkcast 180	java/lang/IncompatibleClassChangeError
    //   78: checkcast 180	java/lang/IncompatibleClassChangeError
    //   81: athrow
    //   82: astore_0
    //   83: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +11 -> 97
    //   89: ldc 8
    //   91: iconst_2
    //   92: ldc 223
    //   94: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: new 180	java/lang/IncompatibleClassChangeError
    //   100: dup
    //   101: ldc 223
    //   103: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   110: checkcast 180	java/lang/IncompatibleClassChangeError
    //   113: checkcast 180	java/lang/IncompatibleClassChangeError
    //   116: athrow
    //   117: astore_0
    //   118: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +11 -> 132
    //   124: ldc 8
    //   126: iconst_2
    //   127: ldc 223
    //   129: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: new 180	java/lang/IncompatibleClassChangeError
    //   135: dup
    //   136: ldc 223
    //   138: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   145: checkcast 180	java/lang/IncompatibleClassChangeError
    //   148: checkcast 180	java/lang/IncompatibleClassChangeError
    //   151: athrow
    //   152: astore_0
    //   153: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +11 -> 167
    //   159: ldc 8
    //   161: iconst_2
    //   162: ldc 223
    //   164: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: new 180	java/lang/IncompatibleClassChangeError
    //   170: dup
    //   171: ldc 223
    //   173: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   176: aload_0
    //   177: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   180: checkcast 180	java/lang/IncompatibleClassChangeError
    //   183: checkcast 180	java/lang/IncompatibleClassChangeError
    //   186: athrow
    //   187: astore_0
    //   188: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +11 -> 202
    //   194: ldc 8
    //   196: iconst_2
    //   197: ldc 223
    //   199: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: new 180	java/lang/IncompatibleClassChangeError
    //   205: dup
    //   206: ldc 223
    //   208: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   211: aload_0
    //   212: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   215: checkcast 180	java/lang/IncompatibleClassChangeError
    //   218: checkcast 180	java/lang/IncompatibleClassChangeError
    //   221: athrow
    //   222: astore_1
    //   223: goto -192 -> 31
    //   226: astore_1
    //   227: goto -191 -> 36
    //   230: astore_1
    //   231: goto -190 -> 41
    //   234: astore_0
    //   235: return
    //   236: astore_1
    //   237: goto -211 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramListView	android.widget.ListView
    //   4	6	1	localDrawable	Drawable
    //   222	1	1	localThrowable1	Throwable
    //   226	1	1	localThrowable2	Throwable
    //   230	1	1	localThrowable3	Throwable
    //   236	1	1	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	26	47	java/lang/IncompatibleClassChangeError
    //   26	31	82	java/lang/IncompatibleClassChangeError
    //   31	36	117	java/lang/IncompatibleClassChangeError
    //   36	41	152	java/lang/IncompatibleClassChangeError
    //   41	46	187	java/lang/IncompatibleClassChangeError
    //   26	31	222	java/lang/Throwable
    //   31	36	226	java/lang/Throwable
    //   36	41	230	java/lang/Throwable
    //   41	46	234	java/lang/Throwable
    //   14	26	236	java/lang/Throwable
  }
  
  private static void a(ProgressBar paramProgressBar)
  {
    Drawable localDrawable = paramProgressBar.getProgressDrawable();
    if (localDrawable != null)
    {
      paramProgressBar.setProgressDrawable(null);
      localDrawable.setCallback(null);
    }
    localDrawable = paramProgressBar.getIndeterminateDrawable();
    if (localDrawable != null)
    {
      paramProgressBar.setIndeterminateDrawable(null);
      localDrawable.setCallback(null);
    }
  }
  
  private static void a(TextView paramTextView)
  {
    if (paramTextView == null) {}
    for (;;)
    {
      return;
      paramTextView.setHint("");
      try
      {
        Object localObject = TextView.class.getDeclaredField("mListeners");
        if (localObject == null) {
          continue;
        }
        if (!((Field)localObject).isAccessible()) {
          ((Field)localObject).setAccessible(true);
        }
        localObject = ((Field)localObject).get(paramTextView);
        if (!(localObject instanceof ArrayList)) {
          continue;
        }
        localObject = (ArrayList)localObject;
        if (localObject == null) {
          continue;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramTextView.removeTextChangedListener((TextWatcher)((Iterator)localObject).next());
        }
        return;
      }
      catch (NoSuchFieldException paramTextView)
      {
        paramTextView.printStackTrace();
        return;
      }
      catch (IllegalArgumentException paramTextView)
      {
        paramTextView.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramTextView)
      {
        paramTextView.printStackTrace();
        return;
      }
      catch (Throwable paramTextView)
      {
        paramTextView.printStackTrace();
      }
    }
  }
  
  /* Error */
  private static void a(com.tencent.widget.ListView paramListView)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 362	com/tencent/widget/ListView:a	()Landroid/graphics/drawable/Drawable;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +8 -> 14
    //   9: aload_1
    //   10: aconst_null
    //   11: invokevirtual 214	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   14: aload_0
    //   15: invokevirtual 364	com/tencent/widget/ListView:a	()Landroid/widget/ListAdapter;
    //   18: ifnull +8 -> 26
    //   21: aload_0
    //   22: aconst_null
    //   23: invokevirtual 365	com/tencent/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   26: aload_0
    //   27: aconst_null
    //   28: invokevirtual 368	com/tencent/widget/ListView:setOnScrollListener	(Lcom/tencent/widget/AbsListView$OnScrollListener;)V
    //   31: aload_0
    //   32: aconst_null
    //   33: invokevirtual 371	com/tencent/widget/ListView:setOnItemClickListener	(Lcom/tencent/widget/AdapterView$OnItemClickListener;)V
    //   36: aload_0
    //   37: aconst_null
    //   38: invokevirtual 374	com/tencent/widget/ListView:setOnItemLongClickListener	(Lcom/tencent/widget/AdapterView$OnItemLongClickListener;)V
    //   41: aload_0
    //   42: aconst_null
    //   43: invokevirtual 377	com/tencent/widget/ListView:setOnItemSelectedListener	(Lcom/tencent/widget/AdapterView$OnItemSelectedListener;)V
    //   46: return
    //   47: astore_0
    //   48: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +11 -> 62
    //   54: ldc 8
    //   56: iconst_2
    //   57: ldc 223
    //   59: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: new 180	java/lang/IncompatibleClassChangeError
    //   65: dup
    //   66: ldc 223
    //   68: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   75: checkcast 180	java/lang/IncompatibleClassChangeError
    //   78: checkcast 180	java/lang/IncompatibleClassChangeError
    //   81: athrow
    //   82: astore_0
    //   83: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +11 -> 97
    //   89: ldc 8
    //   91: iconst_2
    //   92: ldc 223
    //   94: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: new 180	java/lang/IncompatibleClassChangeError
    //   100: dup
    //   101: ldc 223
    //   103: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   110: checkcast 180	java/lang/IncompatibleClassChangeError
    //   113: checkcast 180	java/lang/IncompatibleClassChangeError
    //   116: athrow
    //   117: astore_0
    //   118: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +11 -> 132
    //   124: ldc 8
    //   126: iconst_2
    //   127: ldc 223
    //   129: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: new 180	java/lang/IncompatibleClassChangeError
    //   135: dup
    //   136: ldc 223
    //   138: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   145: checkcast 180	java/lang/IncompatibleClassChangeError
    //   148: checkcast 180	java/lang/IncompatibleClassChangeError
    //   151: athrow
    //   152: astore_0
    //   153: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +11 -> 167
    //   159: ldc 8
    //   161: iconst_2
    //   162: ldc 223
    //   164: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: new 180	java/lang/IncompatibleClassChangeError
    //   170: dup
    //   171: ldc 223
    //   173: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   176: aload_0
    //   177: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   180: checkcast 180	java/lang/IncompatibleClassChangeError
    //   183: checkcast 180	java/lang/IncompatibleClassChangeError
    //   186: athrow
    //   187: astore_0
    //   188: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +11 -> 202
    //   194: ldc 8
    //   196: iconst_2
    //   197: ldc 223
    //   199: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: new 180	java/lang/IncompatibleClassChangeError
    //   205: dup
    //   206: ldc 223
    //   208: invokespecial 227	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
    //   211: aload_0
    //   212: invokevirtual 231	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   215: checkcast 180	java/lang/IncompatibleClassChangeError
    //   218: checkcast 180	java/lang/IncompatibleClassChangeError
    //   221: athrow
    //   222: astore_1
    //   223: goto -192 -> 31
    //   226: astore_1
    //   227: goto -191 -> 36
    //   230: astore_1
    //   231: goto -190 -> 41
    //   234: astore_0
    //   235: return
    //   236: astore_1
    //   237: goto -211 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramListView	com.tencent.widget.ListView
    //   4	6	1	localDrawable	Drawable
    //   222	1	1	localThrowable1	Throwable
    //   226	1	1	localThrowable2	Throwable
    //   230	1	1	localThrowable3	Throwable
    //   236	1	1	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	26	47	java/lang/IncompatibleClassChangeError
    //   26	31	82	java/lang/IncompatibleClassChangeError
    //   31	36	117	java/lang/IncompatibleClassChangeError
    //   36	41	152	java/lang/IncompatibleClassChangeError
    //   41	46	187	java/lang/IncompatibleClassChangeError
    //   26	31	222	java/lang/Throwable
    //   31	36	226	java/lang/Throwable
    //   36	41	230	java/lang/Throwable
    //   41	46	234	java/lang/Throwable
    //   14	26	236	java/lang/Throwable
  }
  
  public static void b(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    try
    {
      Field localField = paramContext.getClass().getDeclaredField("mContext");
      localField.setAccessible(true);
      localField.set(paramContext, null);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "e", paramContext);
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "e", paramContext);
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "e", paramContext);
    }
  }
  
  private static void b(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      a(paramView);
      if ((paramView instanceof ImageView))
      {
        a((ImageView)paramView);
        return;
      }
      if ((paramView instanceof TextView))
      {
        b((TextView)paramView);
        return;
      }
      if ((paramView instanceof ProgressBar))
      {
        a((ProgressBar)paramView);
        return;
      }
      if ((paramView instanceof android.widget.ListView)) {
        a((android.widget.ListView)paramView);
      }
      while ((paramView instanceof ViewGroup))
      {
        a((ViewGroup)paramView);
        return;
        if ((paramView instanceof com.tencent.widget.ListView)) {
          a((com.tencent.widget.ListView)paramView);
        } else if ((paramView instanceof FrameLayout)) {
          a((FrameLayout)paramView);
        } else if ((paramView instanceof LinearLayout)) {
          a((LinearLayout)paramView);
        }
      }
    }
  }
  
  private static void b(TextView paramTextView)
  {
    Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
    int j = arrayOfDrawable.length;
    int i = 0;
    while (i < j)
    {
      Drawable localDrawable = arrayOfDrawable[i];
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      i += 1;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
    if ((paramTextView instanceof EditText)) {
      a(paramTextView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.memoryleak.ActivityLeakSolution
 * JD-Core Version:    0.7.0.1
 */