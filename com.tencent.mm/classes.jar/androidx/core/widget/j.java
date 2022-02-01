package androidx.core.widget;

import android.content.Intent;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.e.c;
import androidx.core.e.c.a;
import androidx.core.e.c.a.a;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class j
{
  private static Field bwX;
  private static boolean bwY;
  private static Field bwZ;
  private static boolean bxa;
  
  public static int a(TextView paramTextView)
  {
    AppMethodBeat.i(195406);
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = paramTextView.getMaxLines();
      AppMethodBeat.o(195406);
      return i;
    }
    if (!bxa)
    {
      bwZ = aA("mMaxMode");
      bxa = true;
    }
    if ((bwZ != null) && (a(bwZ, paramTextView) == 1))
    {
      if (!bwY)
      {
        bwX = aA("mMaximum");
        bwY = true;
      }
      if (bwX != null)
      {
        i = a(bwX, paramTextView);
        AppMethodBeat.o(195406);
        return i;
      }
    }
    AppMethodBeat.o(195406);
    return -1;
  }
  
  private static int a(Field paramField, TextView paramTextView)
  {
    AppMethodBeat.i(195383);
    try
    {
      int i = paramField.getInt(paramTextView);
      AppMethodBeat.o(195383);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      new StringBuilder("Could not retrieve value of ").append(paramField.getName()).append(" field.");
      AppMethodBeat.o(195383);
    }
    return -1;
  }
  
  public static ActionMode.Callback a(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(195460);
    if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT > 27) || ((paramCallback instanceof a)) || (paramCallback == null))
    {
      AppMethodBeat.o(195460);
      return paramCallback;
    }
    paramTextView = new a(paramCallback, paramTextView);
    AppMethodBeat.o(195460);
    return paramTextView;
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(195416);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      AppMethodBeat.o(195416);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
    AppMethodBeat.o(195416);
  }
  
  public static void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(195396);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      AppMethodBeat.o(195396);
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
          break label82;
        }
        localDrawable = paramDrawable3;
        label55:
        if (i == 0) {
          break label88;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        AppMethodBeat.o(195396);
        return;
        i = 0;
        break;
        label82:
        localDrawable = paramDrawable1;
        break label55;
        label88:
        paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(195396);
  }
  
  public static void a(TextView paramTextView, c.a parama)
  {
    AppMethodBeat.i(195570);
    TextDirectionHeuristic localTextDirectionHeuristic;
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localTextDirectionHeuristic = parama.bsl;
      if ((localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) || (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
        break label173;
      }
      if (localTextDirectionHeuristic != TextDirectionHeuristics.ANYRTL_LTR) {
        break label106;
      }
      i = 2;
    }
    label173:
    for (;;)
    {
      paramTextView.setTextDirection(i);
      if (Build.VERSION.SDK_INT >= 23) {
        break;
      }
      float f = parama.bsk.getTextScaleX();
      paramTextView.getPaint().set(parama.bsk);
      if (f == paramTextView.getTextScaleX()) {
        paramTextView.setTextScaleX(f / 2.0F + 1.0F);
      }
      paramTextView.setTextScaleX(f);
      AppMethodBeat.o(195570);
      return;
      label106:
      if (localTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
        i = 3;
      } else if (localTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
        i = 4;
      } else if (localTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
        i = 5;
      } else if (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
        i = 6;
      } else if (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
        i = 7;
      } else {
        i = 1;
      }
    }
    paramTextView.getPaint().set(parama.bsk);
    paramTextView.setBreakStrategy(parama.bsm);
    paramTextView.setHyphenationFrequency(parama.bsn);
    AppMethodBeat.o(195570);
  }
  
  public static void a(TextView paramTextView, c paramc)
  {
    AppMethodBeat.i(195584);
    if (Build.VERSION.SDK_INT >= 29)
    {
      if ((paramc.bsh instanceof PrecomputedText)) {}
      for (paramc = (PrecomputedText)paramc.bsh;; paramc = null)
      {
        paramTextView.setText(paramc);
        AppMethodBeat.o(195584);
        return;
      }
    }
    if (!f(paramTextView).a(paramc.bsi))
    {
      paramTextView = new IllegalArgumentException("Given text can not be applied to TextView.");
      AppMethodBeat.o(195584);
      throw paramTextView;
    }
    paramTextView.setText(paramc);
    AppMethodBeat.o(195584);
  }
  
  private static Field aA(String paramString)
  {
    AppMethodBeat.i(195371);
    Object localObject = null;
    try
    {
      Field localField = TextView.class.getDeclaredField(paramString);
      localObject = localField;
      localField.setAccessible(true);
      localObject = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        new StringBuilder("Could not retrieve ").append(paramString).append(" field.");
      }
    }
    AppMethodBeat.o(195371);
    return localObject;
  }
  
  public static void b(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(195443);
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeUniformWithConfiguration(1, paramInt, 1, 1);
      AppMethodBeat.o(195443);
      return;
    }
    if ((paramTextView instanceof b)) {
      ((b)paramTextView).setAutoSizeTextTypeUniformWithConfiguration(1, paramInt, 1, 1);
    }
    AppMethodBeat.o(195443);
  }
  
  public static Drawable[] b(TextView paramTextView)
  {
    int i = 1;
    AppMethodBeat.i(195424);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView = paramTextView.getCompoundDrawablesRelative();
      AppMethodBeat.o(195424);
      return paramTextView;
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
        AppMethodBeat.o(195424);
        return paramTextView;
        i = 0;
      }
    }
    paramTextView = paramTextView.getCompoundDrawables();
    AppMethodBeat.o(195424);
    return paramTextView;
  }
  
  public static void c(TextView paramTextView)
  {
    AppMethodBeat.i(195433);
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeWithDefaults(1);
      AppMethodBeat.o(195433);
      return;
    }
    if ((paramTextView instanceof b)) {
      ((b)paramTextView).setAutoSizeTextTypeWithDefaults(1);
    }
    AppMethodBeat.o(195433);
  }
  
  public static void c(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(195473);
    f.el(paramInt);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
      AppMethodBeat.o(195473);
      return;
    }
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
    for (int i = localFontMetricsInt.top;; i = localFontMetricsInt.ascent)
    {
      if (paramInt > Math.abs(i)) {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), i + paramInt, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
      }
      AppMethodBeat.o(195473);
      return;
    }
  }
  
  public static int d(TextView paramTextView)
  {
    AppMethodBeat.i(195500);
    int i = paramTextView.getPaddingTop();
    int j = paramTextView.getPaint().getFontMetricsInt().top;
    AppMethodBeat.o(195500);
    return i - j;
  }
  
  public static void d(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(195487);
    f.el(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
      }
      AppMethodBeat.o(195487);
      return;
    }
  }
  
  public static int e(TextView paramTextView)
  {
    AppMethodBeat.i(195512);
    int i = paramTextView.getPaddingBottom();
    int j = paramTextView.getPaint().getFontMetricsInt().bottom;
    AppMethodBeat.o(195512);
    return i + j;
  }
  
  public static void e(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(195528);
    f.el(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
    AppMethodBeat.o(195528);
  }
  
  public static c.a f(TextView paramTextView)
  {
    int i = 1;
    AppMethodBeat.i(195556);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView = new c.a(paramTextView.getTextMetricsParams());
      AppMethodBeat.o(195556);
      return paramTextView;
    }
    c.a.a locala = new c.a.a(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      locala.bsm = paramTextView.getBreakStrategy();
      locala.bsn = paramTextView.getHyphenationFrequency();
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      if (!(paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
        break label138;
      }
      paramTextView = TextDirectionHeuristics.LTR;
    }
    for (;;)
    {
      label101:
      locala.bsl = paramTextView;
      paramTextView = new c.a(locala.bsk, locala.bsl, locala.bsm, locala.bsn);
      AppMethodBeat.o(195556);
      return paramTextView;
      label138:
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
              break label303;
            }
            paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            break label101;
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
        label303:
        paramTextView = TextDirectionHeuristics.FIRSTSTRONG_RTL;
      }
    }
  }
  
  static final class a
    implements ActionMode.Callback
  {
    private final ActionMode.Callback bxb;
    private Class<?> bxc;
    private Method bxd;
    private boolean bxe;
    private boolean bxf;
    private final TextView sQ;
    
    a(ActionMode.Callback paramCallback, TextView paramTextView)
    {
      this.bxb = paramCallback;
      this.sQ = paramTextView;
      this.bxf = false;
    }
    
    private static Intent Fu()
    {
      AppMethodBeat.i(195373);
      Intent localIntent = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
      AppMethodBeat.o(195373);
      return localIntent;
    }
    
    public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(195407);
      boolean bool = this.bxb.onActionItemClicked(paramActionMode, paramMenuItem);
      AppMethodBeat.o(195407);
      return bool;
    }
    
    public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      AppMethodBeat.i(195381);
      boolean bool = this.bxb.onCreateActionMode(paramActionMode, paramMenu);
      AppMethodBeat.o(195381);
      return bool;
    }
    
    public final void onDestroyActionMode(ActionMode paramActionMode)
    {
      AppMethodBeat.i(195415);
      this.bxb.onDestroyActionMode(paramActionMode);
      AppMethodBeat.o(195415);
    }
    
    /* Error */
    public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      // Byte code:
      //   0: ldc 84
      //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 30	androidx/core/widget/j$a:sQ	Landroid/widget/TextView;
      //   9: invokevirtual 90	android/widget/TextView:getContext	()Landroid/content/Context;
      //   12: astore 8
      //   14: aload 8
      //   16: invokevirtual 96	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
      //   19: astore 7
      //   21: aload_0
      //   22: getfield 32	androidx/core/widget/j$a:bxf	Z
      //   25: ifne +45 -> 70
      //   28: aload_0
      //   29: iconst_1
      //   30: putfield 32	androidx/core/widget/j$a:bxf	Z
      //   33: aload_0
      //   34: ldc 98
      //   36: invokestatic 104	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   39: putfield 106	androidx/core/widget/j$a:bxc	Ljava/lang/Class;
      //   42: aload_0
      //   43: aload_0
      //   44: getfield 106	androidx/core/widget/j$a:bxc	Ljava/lang/Class;
      //   47: ldc 108
      //   49: iconst_1
      //   50: anewarray 100	java/lang/Class
      //   53: dup
      //   54: iconst_0
      //   55: getstatic 113	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   58: aastore
      //   59: invokevirtual 117	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   62: putfield 119	androidx/core/widget/j$a:bxd	Ljava/lang/reflect/Method;
      //   65: aload_0
      //   66: iconst_1
      //   67: putfield 121	androidx/core/widget/j$a:bxe	Z
      //   70: aload_0
      //   71: getfield 121	androidx/core/widget/j$a:bxe	Z
      //   74: ifeq +115 -> 189
      //   77: aload_0
      //   78: getfield 106	androidx/core/widget/j$a:bxc	Ljava/lang/Class;
      //   81: aload_2
      //   82: invokevirtual 125	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
      //   85: ifeq +104 -> 189
      //   88: aload_0
      //   89: getfield 119	androidx/core/widget/j$a:bxd	Ljava/lang/reflect/Method;
      //   92: astore 6
      //   94: aload_2
      //   95: invokeinterface 131 1 0
      //   100: iconst_1
      //   101: isub
      //   102: istore_3
      //   103: iload_3
      //   104: iflt +109 -> 213
      //   107: aload_2
      //   108: iload_3
      //   109: invokeinterface 135 2 0
      //   114: astore 9
      //   116: aload 9
      //   118: invokeinterface 140 1 0
      //   123: ifnull +39 -> 162
      //   126: ldc 47
      //   128: aload 9
      //   130: invokeinterface 140 1 0
      //   135: invokevirtual 144	android/content/Intent:getAction	()Ljava/lang/String;
      //   138: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   141: ifeq +21 -> 162
      //   144: aload 6
      //   146: aload_2
      //   147: iconst_1
      //   148: anewarray 4	java/lang/Object
      //   151: dup
      //   152: iconst_0
      //   153: iload_3
      //   154: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   157: aastore
      //   158: invokevirtual 159	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   161: pop
      //   162: iload_3
      //   163: iconst_1
      //   164: isub
      //   165: istore_3
      //   166: goto -63 -> 103
      //   169: astore 6
      //   171: aload_0
      //   172: aconst_null
      //   173: putfield 106	androidx/core/widget/j$a:bxc	Ljava/lang/Class;
      //   176: aload_0
      //   177: aconst_null
      //   178: putfield 119	androidx/core/widget/j$a:bxd	Ljava/lang/reflect/Method;
      //   181: aload_0
      //   182: iconst_0
      //   183: putfield 121	androidx/core/widget/j$a:bxe	Z
      //   186: goto -116 -> 70
      //   189: aload_2
      //   190: invokevirtual 163	java/lang/Object:getClass	()Ljava/lang/Class;
      //   193: ldc 108
      //   195: iconst_1
      //   196: anewarray 100	java/lang/Class
      //   199: dup
      //   200: iconst_0
      //   201: getstatic 113	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   204: aastore
      //   205: invokevirtual 117	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   208: astore 6
      //   210: goto -116 -> 94
      //   213: new 165	java/util/ArrayList
      //   216: dup
      //   217: invokespecial 166	java/util/ArrayList:<init>	()V
      //   220: astore 6
      //   222: aload 8
      //   224: instanceof 168
      //   227: ifeq +127 -> 354
      //   230: aload 7
      //   232: invokestatic 170	androidx/core/widget/j$a:Fu	()Landroid/content/Intent;
      //   235: iconst_0
      //   236: invokevirtual 176	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
      //   239: invokeinterface 182 1 0
      //   244: astore 9
      //   246: aload 9
      //   248: invokeinterface 188 1 0
      //   253: ifeq +101 -> 354
      //   256: aload 9
      //   258: invokeinterface 192 1 0
      //   263: checkcast 194	android/content/pm/ResolveInfo
      //   266: astore 10
      //   268: aload 8
      //   270: invokevirtual 197	android/content/Context:getPackageName	()Ljava/lang/String;
      //   273: aload 10
      //   275: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   278: getfield 207	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
      //   281: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   284: ifeq +22 -> 306
      //   287: iconst_1
      //   288: istore_3
      //   289: iload_3
      //   290: ifeq -44 -> 246
      //   293: aload 6
      //   295: aload 10
      //   297: invokeinterface 210 2 0
      //   302: pop
      //   303: goto -57 -> 246
      //   306: aload 10
      //   308: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   311: getfield 213	android/content/pm/ActivityInfo:exported	Z
      //   314: ifeq +35 -> 349
      //   317: aload 10
      //   319: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   322: getfield 216	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
      //   325: ifnull +19 -> 344
      //   328: aload 8
      //   330: aload 10
      //   332: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   335: getfield 216	android/content/pm/ActivityInfo:permission	Ljava/lang/String;
      //   338: invokevirtual 220	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
      //   341: ifne +8 -> 349
      //   344: iconst_1
      //   345: istore_3
      //   346: goto -57 -> 289
      //   349: iconst_0
      //   350: istore_3
      //   351: goto -62 -> 289
      //   354: iconst_0
      //   355: istore_3
      //   356: iload_3
      //   357: aload 6
      //   359: invokeinterface 221 1 0
      //   364: if_icmpge +145 -> 509
      //   367: aload 6
      //   369: iload_3
      //   370: invokeinterface 225 2 0
      //   375: checkcast 194	android/content/pm/ResolveInfo
      //   378: astore 8
      //   380: aload_2
      //   381: iconst_0
      //   382: iconst_0
      //   383: iload_3
      //   384: bipush 100
      //   386: iadd
      //   387: aload 8
      //   389: aload 7
      //   391: invokevirtual 229	android/content/pm/ResolveInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
      //   394: invokeinterface 232 5 0
      //   399: astore 9
      //   401: aload_0
      //   402: getfield 30	androidx/core/widget/j$a:sQ	Landroid/widget/TextView;
      //   405: astore 10
      //   407: invokestatic 170	androidx/core/widget/j$a:Fu	()Landroid/content/Intent;
      //   410: astore 11
      //   412: aload 10
      //   414: instanceof 234
      //   417: ifeq +78 -> 495
      //   420: aload 10
      //   422: invokevirtual 237	android/widget/TextView:onCheckIsTextEditor	()Z
      //   425: ifeq +70 -> 495
      //   428: aload 10
      //   430: invokevirtual 240	android/widget/TextView:isEnabled	()Z
      //   433: ifeq +62 -> 495
      //   436: iconst_1
      //   437: istore 4
      //   439: iload 4
      //   441: ifne +60 -> 501
      //   444: iconst_1
      //   445: istore 5
      //   447: aload 9
      //   449: aload 11
      //   451: ldc 242
      //   453: iload 5
      //   455: invokevirtual 246	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
      //   458: aload 8
      //   460: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   463: getfield 207	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
      //   466: aload 8
      //   468: getfield 201	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
      //   471: getfield 249	android/content/pm/ActivityInfo:name	Ljava/lang/String;
      //   474: invokevirtual 253	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   477: invokeinterface 257 2 0
      //   482: iconst_1
      //   483: invokeinterface 260 2 0
      //   488: iload_3
      //   489: iconst_1
      //   490: iadd
      //   491: istore_3
      //   492: goto -136 -> 356
      //   495: iconst_0
      //   496: istore 4
      //   498: goto -59 -> 439
      //   501: iconst_0
      //   502: istore 5
      //   504: goto -57 -> 447
      //   507: astore 6
      //   509: aload_0
      //   510: getfield 28	androidx/core/widget/j$a:bxb	Landroid/view/ActionMode$Callback;
      //   513: aload_1
      //   514: aload_2
      //   515: invokeinterface 262 3 0
      //   520: istore 5
      //   522: ldc 84
      //   524: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   527: iload 5
      //   529: ireturn
      //   530: astore 6
      //   532: goto -23 -> 509
      //   535: astore 6
      //   537: goto -28 -> 509
      //   540: astore 6
      //   542: goto -371 -> 171
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	545	0	this	a
      //   0	545	1	paramActionMode	ActionMode
      //   0	545	2	paramMenu	Menu
      //   102	390	3	i	int
      //   437	60	4	j	int
      //   445	83	5	bool	boolean
      //   92	53	6	localMethod	Method
      //   169	1	6	localClassNotFoundException	java.lang.ClassNotFoundException
      //   208	160	6	localObject1	Object
      //   507	1	6	localIllegalAccessException	IllegalAccessException
      //   530	1	6	localNoSuchMethodException1	java.lang.NoSuchMethodException
      //   535	1	6	localInvocationTargetException	java.lang.reflect.InvocationTargetException
      //   540	1	6	localNoSuchMethodException2	java.lang.NoSuchMethodException
      //   19	371	7	localPackageManager	android.content.pm.PackageManager
      //   12	455	8	localObject2	Object
      //   114	334	9	localObject3	Object
      //   266	163	10	localObject4	Object
      //   410	40	11	localIntent	Intent
      // Exception table:
      //   from	to	target	type
      //   33	70	169	java/lang/ClassNotFoundException
      //   70	94	507	java/lang/IllegalAccessException
      //   94	103	507	java/lang/IllegalAccessException
      //   107	162	507	java/lang/IllegalAccessException
      //   189	210	507	java/lang/IllegalAccessException
      //   70	94	530	java/lang/NoSuchMethodException
      //   94	103	530	java/lang/NoSuchMethodException
      //   107	162	530	java/lang/NoSuchMethodException
      //   189	210	530	java/lang/NoSuchMethodException
      //   70	94	535	java/lang/reflect/InvocationTargetException
      //   94	103	535	java/lang/reflect/InvocationTargetException
      //   107	162	535	java/lang/reflect/InvocationTargetException
      //   189	210	535	java/lang/reflect/InvocationTargetException
      //   33	70	540	java/lang/NoSuchMethodException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.j
 * JD-Core Version:    0.7.0.1
 */