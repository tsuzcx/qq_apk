package android.support.v4.widget;

import android.content.Intent;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.d.b;
import android.support.v4.d.b.a;
import android.support.v4.d.b.a.a;
import android.support.v4.e.l;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class q
{
  private static Field Mn;
  private static boolean Mo;
  private static Field Mp;
  private static boolean Mq;
  
  private static Field N(String paramString)
  {
    Object localObject = null;
    try
    {
      Field localField = TextView.class.getDeclaredField(paramString);
      localObject = localField;
      localField.setAccessible(true);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      new StringBuilder("Could not retrieve ").append(paramString).append(" field.");
    }
    return localObject;
  }
  
  private static int a(Field paramField, TextView paramTextView)
  {
    try
    {
      int i = paramField.getInt(paramTextView);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      new StringBuilder("Could not retrieve value of ").append(paramField.getName()).append(" field.");
    }
    return -1;
  }
  
  public static ActionMode.Callback a(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT > 27) || ((paramCallback instanceof a))) {
      return paramCallback;
    }
    return new a(paramCallback, paramTextView);
  }
  
  public static void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label67;
        }
        localDrawable = paramDrawable3;
        label45:
        if (i == 0) {
          break label73;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        return;
        i = 0;
        break;
        label67:
        localDrawable = paramDrawable1;
        break label45;
        label73:
        paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void a(TextView paramTextView, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      if ((paramb.El instanceof PrecomputedText)) {}
      for (paramb = (PrecomputedText)paramb.El;; paramb = null)
      {
        paramTextView.setText(paramb);
        return;
      }
    }
    if (!d(paramTextView).equals(paramb.Em)) {
      throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }
    paramTextView.setText(paramb);
  }
  
  public static int b(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramTextView.getMaxLines();
    }
    if (!Mq)
    {
      Mp = N("mMaxMode");
      Mq = true;
    }
    if ((Mp != null) && (a(Mp, paramTextView) == 1))
    {
      if (!Mo)
      {
        Mn = N("mMaximum");
        Mo = true;
      }
      if (Mn != null) {
        return a(Mn, paramTextView);
      }
    }
    return -1;
  }
  
  public static void b(TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }
  
  public static void c(TextView paramTextView, int paramInt)
  {
    l.at(paramInt);
    if (Build.VERSION.SDK_INT >= 28) {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
    }
    for (;;)
    {
      return;
      Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
      if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
      for (int i = localFontMetricsInt.top; paramInt > Math.abs(i); i = localFontMetricsInt.ascent)
      {
        i = -i;
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramInt - i, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
        return;
      }
    }
  }
  
  public static Drawable[] c(TextView paramTextView)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 18) {
      return paramTextView.getCompoundDrawablesRelative();
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (paramTextView.getLayoutDirection() == 1) {}
      for (;;)
      {
        paramTextView = paramTextView.getCompoundDrawables();
        if (i != 0)
        {
          Object localObject1 = paramTextView[2];
          Object localObject2 = paramTextView[0];
          paramTextView[0] = localObject1;
          paramTextView[2] = localObject2;
        }
        return paramTextView;
        i = 0;
      }
    }
    return paramTextView.getCompoundDrawables();
  }
  
  public static b.a d(TextView paramTextView)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 28) {
      return new b.a(paramTextView.getTextMetricsParams());
    }
    b.a.a locala = new b.a.a(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      locala.Ep = paramTextView.getBreakStrategy();
      locala.Eq = paramTextView.getHyphenationFrequency();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      if (!(paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
        break label116;
      }
      paramTextView = TextDirectionHeuristics.LTR;
    }
    label279:
    for (;;)
    {
      label87:
      locala.Eo = paramTextView;
      return new b.a(locala.mPaint, locala.Eo, locala.Ep, locala.Eq);
      label116:
      if ((Build.VERSION.SDK_INT >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
      {
        i = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
        if ((i == 1) || (i == 2)) {
          paramTextView = TextDirectionHeuristics.RTL;
        } else {
          paramTextView = TextDirectionHeuristics.LTR;
        }
      }
      else
      {
        if (paramTextView.getLayoutDirection() == 1) {}
        for (;;)
        {
          switch (paramTextView.getTextDirection())
          {
          default: 
            if (i != 0) {
              break label279;
            }
            paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            break label87;
            i = 0;
          }
        }
        paramTextView = TextDirectionHeuristics.ANYRTL_LTR;
        continue;
        paramTextView = TextDirectionHeuristics.LTR;
        continue;
        paramTextView = TextDirectionHeuristics.RTL;
        continue;
        paramTextView = TextDirectionHeuristics.LOCALE;
        continue;
        paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        continue;
        paramTextView = TextDirectionHeuristics.FIRSTSTRONG_RTL;
      }
    }
  }
  
  public static void d(TextView paramTextView, int paramInt)
  {
    l.at(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
      }
      return;
    }
  }
  
  public static void e(TextView paramTextView, int paramInt)
  {
    l.at(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
  }
  
  static final class a
    implements ActionMode.Callback
  {
    private final ActionMode.Callback Mr;
    private Class Ms;
    private Method Mt;
    private boolean Mu;
    private boolean Mv;
    private final TextView md;
    
    a(ActionMode.Callback paramCallback, TextView paramTextView)
    {
      this.Mr = paramCallback;
      this.md = paramTextView;
      this.Mv = false;
    }
    
    private static Intent eo()
    {
      return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }
    
    public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.Mr.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.Mr.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public final void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.Mr.onDestroyActionMode(paramActionMode);
    }
    
    /* Error */
    public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	android/support/v4/widget/q$a:md	Landroid/widget/TextView;
      //   4: invokevirtual 75	android/widget/TextView:getContext	()Landroid/content/Context;
      //   7: astore 8
      //   9: aload 8
      //   11: invokevirtual 81	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
      //   14: astore 7
      //   16: aload_0
      //   17: getfield 31	android/support/v4/widget/q$a:Mv	Z
      //   20: ifne +45 -> 65
      //   23: aload_0
      //   24: iconst_1
      //   25: putfield 31	android/support/v4/widget/q$a:Mv	Z
      //   28: aload_0
      //   29: ldc 83
      //   31: invokestatic 89	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   34: putfield 91	android/support/v4/widget/q$a:Ms	Ljava/lang/Class;
      //   37: aload_0
      //   38: aload_0
      //   39: getfield 91	android/support/v4/widget/q$a:Ms	Ljava/lang/Class;
      //   42: ldc 93
      //   44: iconst_1
      //   45: anewarray 85	java/lang/Class
      //   48: dup
      //   49: iconst_0
      //   50: getstatic 98	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   53: aastore
      //   54: invokevirtual 102	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   57: putfield 104	android/support/v4/widget/q$a:Mt	Ljava/lang/reflect/Method;
      //   60: aload_0
      //   61: iconst_1
      //   62: putfield 106	android/support/v4/widget/q$a:Mu	Z
      //   65: aload_0
      //   66: getfield 106	android/support/v4/widget/q$a:Mu	Z
      //   69: ifeq +115 -> 184
      //   72: aload_0
      //   73: getfield 91	android/support/v4/widget/q$a:Ms	Ljava/lang/Class;
      //   76: aload_2
      //   77: invokevirtual 110	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
      //   80: ifeq +104 -> 184
      //   83: aload_0
      //   84: getfield 104	android/support/v4/widget/q$a:Mt	Ljava/lang/reflect/Method;
      //   87: astore 6
      //   89: aload_2
      //   90: invokeinterface 116 1 0
      //   95: iconst_1
      //   96: isub
      //   97: istore_3
      //   98: iload_3
      //   99: iflt +109 -> 208
      //   102: aload_2
      //   103: iload_3
      //   104: invokeinterface 120 2 0
      //   109: astore 9
      //   111: aload 9
      //   113: invokeinterface 125 1 0
      //   118: ifnull +39 -> 157
      //   121: ldc 39
      //   123: aload 9
      //   125: invokeinterface 125 1 0
      //   130: invokevirtual 129	android/content/Intent:getAction	()Ljava/lang/String;
      //   133: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   136: ifeq +21 -> 157
      //   139: aload 6
      //   141: aload_2
      //   142: iconst_1
      //   143: anewarray 4	java/lang/Object
      //   146: dup
      //   147: iconst_0
      //   148: iload_3
      //   149: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   152: aastore
      //   153: invokevirtual 144	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   156: pop
      //   157: iload_3
      //   158: iconst_1
      //   159: isub
      //   160: istore_3
      //   161: goto -63 -> 98
      //   164: astore 6
      //   166: aload_0
      //   167: aconst_null
      //   168: putfield 91	android/support/v4/widget/q$a:Ms	Ljava/lang/Class;
      //   171: aload_0
      //   172: aconst_null
      //   173: putfield 104	android/support/v4/widget/q$a:Mt	Ljava/lang/reflect/Method;
      //   176: aload_0
      //   177: iconst_0
      //   178: putfield 106	android/support/v4/widget/q$a:Mu	Z
      //   181: goto -116 -> 65
      //   184: aload_2
      //   185: invokevirtual 148	java/lang/Object:getClass	()Ljava/lang/Class;
      //   188: ldc 93
      //   190: iconst_1
      //   191: anewarray 85	java/lang/Class
      //   194: dup
      //   195: iconst_0
      //   196: getstatic 98	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   199: aastore
      //   200: invokevirtual 102	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   203: astore 6
      //   205: goto -116 -> 89
      //   208: new 150	java/util/ArrayList
      //   211: dup
      //   212: invokespecial 151	java/util/ArrayList:<init>	()V
      //   215: astore 6
      //   217: aload 8
      //   219: instanceof 153
      //   222: ifeq +127 -> 349
      //   225: aload 7
      //   227: invokestatic 155	android/support/v4/widget/q$a:eo	()Landroid/content/Intent;
      //   230: iconst_0
      //   231: invokevirtual 161	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
      //   234: invokeinterface 167 1 0
      //   239: astore 9
      //   241: aload 9
      //   243: invokeinterface 173 1 0
      //   248: ifeq +101 -> 349
      //   251: aload 9
      //   253: invokeinterface 177 1 0
      //   258: checkcast 179	android/content/pm/ResolveInfo
      //   261: astore 10
      //   263: aload 8
      //   265: invokevirtual 182	android/content/Context:getPackageName	()Ljava/lang/String;
      //   268: aload 10
      //   270: getfield 186	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   273: getfield 192	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
      //   276: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   279: ifeq +22 -> 301
      //   282: iconst_1
      //   283: istore_3
      //   284: iload_3
      //   285: ifeq -44 -> 241
      //   288: aload 6
      //   290: aload 10
      //   292: invokeinterface 195 2 0
      //   297: pop
      //   298: goto -57 -> 241
      //   301: aload 10
      //   303: getfield 186	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   306: getfield 198	android/content/pm/ActivityInfo:exported	Z
      //   309: ifeq +35 -> 344
      //   312: aload 10
      //   314: getfield 186	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   317: getfield 201	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
      //   320: ifnull +19 -> 339
      //   323: aload 8
      //   325: aload 10
      //   327: getfield 186	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   330: getfield 201	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
      //   333: invokevirtual 205	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
      //   336: ifne +8 -> 344
      //   339: iconst_1
      //   340: istore_3
      //   341: goto -57 -> 284
      //   344: iconst_0
      //   345: istore_3
      //   346: goto -62 -> 284
      //   349: iconst_0
      //   350: istore_3
      //   351: iload_3
      //   352: aload 6
      //   354: invokeinterface 206 1 0
      //   359: if_icmpge +145 -> 504
      //   362: aload 6
      //   364: iload_3
      //   365: invokeinterface 210 2 0
      //   370: checkcast 179	android/content/pm/ResolveInfo
      //   373: astore 8
      //   375: aload_2
      //   376: iconst_0
      //   377: iconst_0
      //   378: iload_3
      //   379: bipush 100
      //   381: iadd
      //   382: aload 8
      //   384: aload 7
      //   386: invokevirtual 214	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
      //   389: invokeinterface 217 5 0
      //   394: astore 9
      //   396: aload_0
      //   397: getfield 29	android/support/v4/widget/q$a:md	Landroid/widget/TextView;
      //   400: astore 10
      //   402: invokestatic 155	android/support/v4/widget/q$a:eo	()Landroid/content/Intent;
      //   405: astore 11
      //   407: aload 10
      //   409: instanceof 219
      //   412: ifeq +78 -> 490
      //   415: aload 10
      //   417: invokevirtual 222	android/widget/TextView:onCheckIsTextEditor	()Z
      //   420: ifeq +70 -> 490
      //   423: aload 10
      //   425: invokevirtual 225	android/widget/TextView:isEnabled	()Z
      //   428: ifeq +62 -> 490
      //   431: iconst_1
      //   432: istore 4
      //   434: iload 4
      //   436: ifne +60 -> 496
      //   439: iconst_1
      //   440: istore 5
      //   442: aload 9
      //   444: aload 11
      //   446: ldc 227
      //   448: iload 5
      //   450: invokevirtual 231	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
      //   453: aload 8
      //   455: getfield 186	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   458: getfield 192	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
      //   461: aload 8
      //   463: getfield 186	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   466: getfield 234	android/content/pm/ActivityInfo:name	Ljava/lang/String;
      //   469: invokevirtual 238	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   472: invokeinterface 242 2 0
      //   477: iconst_1
      //   478: invokeinterface 246 2 0
      //   483: iload_3
      //   484: iconst_1
      //   485: iadd
      //   486: istore_3
      //   487: goto -136 -> 351
      //   490: iconst_0
      //   491: istore 4
      //   493: goto -59 -> 434
      //   496: iconst_0
      //   497: istore 5
      //   499: goto -57 -> 442
      //   502: astore 6
      //   504: aload_0
      //   505: getfield 27	android/support/v4/widget/q$a:Mr	Landroid/view/ActionMode$Callback;
      //   508: aload_1
      //   509: aload_2
      //   510: invokeinterface 248 3 0
      //   515: ireturn
      //   516: astore 6
      //   518: goto -14 -> 504
      //   521: astore 6
      //   523: goto -19 -> 504
      //   526: astore 6
      //   528: goto -362 -> 166
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	531	0	this	a
      //   0	531	1	paramActionMode	ActionMode
      //   0	531	2	paramMenu	Menu
      //   97	390	3	i	int
      //   432	60	4	j	int
      //   440	58	5	bool	boolean
      //   87	53	6	localMethod	Method
      //   164	1	6	localClassNotFoundException	java.lang.ClassNotFoundException
      //   203	160	6	localObject1	Object
      //   502	1	6	localIllegalAccessException	IllegalAccessException
      //   516	1	6	localNoSuchMethodException1	java.lang.NoSuchMethodException
      //   521	1	6	localInvocationTargetException	java.lang.reflect.InvocationTargetException
      //   526	1	6	localNoSuchMethodException2	java.lang.NoSuchMethodException
      //   14	371	7	localPackageManager	android.content.pm.PackageManager
      //   7	455	8	localObject2	Object
      //   109	334	9	localObject3	Object
      //   261	163	10	localObject4	Object
      //   405	40	11	localIntent	Intent
      // Exception table:
      //   from	to	target	type
      //   28	65	164	java/lang/ClassNotFoundException
      //   65	89	502	java/lang/IllegalAccessException
      //   89	98	502	java/lang/IllegalAccessException
      //   102	157	502	java/lang/IllegalAccessException
      //   184	205	502	java/lang/IllegalAccessException
      //   65	89	516	java/lang/NoSuchMethodException
      //   89	98	516	java/lang/NoSuchMethodException
      //   102	157	516	java/lang/NoSuchMethodException
      //   184	205	516	java/lang/NoSuchMethodException
      //   65	89	521	java/lang/reflect/InvocationTargetException
      //   89	98	521	java/lang/reflect/InvocationTargetException
      //   102	157	521	java/lang/reflect/InvocationTargetException
      //   184	205	521	java/lang/reflect/InvocationTargetException
      //   28	65	526	java/lang/NoSuchMethodException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.q
 * JD-Core Version:    0.7.0.1
 */