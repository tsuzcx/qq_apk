package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.c.a.c;
import android.support.c.a.i;
import android.support.v4.e.f;
import android.support.v4.e.n;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class g
{
  private static final PorterDuff.Mode aan = PorterDuff.Mode.SRC_IN;
  private static g aao;
  private static final c aap = new c();
  private static final int[] aaq = { 2130837607, 2130837605, 2130837520 };
  private static final int[] aar = { 2130837542, 2130837584, 2130837549, 2130837544, 2130837545, 2130837548, 2130837547 };
  private static final int[] aas = { 2130837604, 2130837606, 2130837535, 2130837597, 2130837598, 2130837600, 2130837602, 2130837599, 2130837601, 2130837603 };
  private static final int[] aat = { 2130837574, 2130837533, 2130837573 };
  private static final int[] aau = { 2130837595, 2130837608 };
  private static final int[] aav = { 2130837523, 2130837528 };
  private TypedValue aaA;
  private boolean aaB;
  private WeakHashMap<Context, n<ColorStateList>> aaw;
  private android.support.v4.e.a<String, d> aax;
  private n<String> aay;
  private final WeakHashMap<Context, f<WeakReference<Drawable.ConstantState>>> aaz = new WeakHashMap(0);
  
  private static long a(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      PorterDuffColorFilter localPorterDuffColorFilter2 = (PorterDuffColorFilter)aap.get(Integer.valueOf(c.b(paramInt, paramMode)));
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
        aap.put(Integer.valueOf(c.b(paramInt, paramMode)), localPorterDuffColorFilter1);
      }
      return localPorterDuffColorFilter1;
    }
    finally {}
  }
  
  private Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = r(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (x.o(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = android.support.v4.graphics.drawable.a.e(paramContext);
      android.support.v4.graphics.drawable.a.a(paramContext, (ColorStateList)localObject);
      paramDrawable = bq(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        android.support.v4.graphics.drawable.a.a(paramContext, paramDrawable);
        localObject = paramContext;
      }
    }
    do
    {
      do
      {
        return localObject;
        if (paramInt == 2130837585)
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), av.u(paramContext, 2130772209), aan);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), av.u(paramContext, 2130772209), aan);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), av.u(paramContext, 2130772210), aan);
          return paramDrawable;
        }
        if ((paramInt == 2130837576) || (paramInt == 2130837575) || (paramInt == 2130837577))
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), av.w(paramContext, 2130772209), aan);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), av.u(paramContext, 2130772210), aan);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), av.u(paramContext, 2130772210), aan);
          return paramDrawable;
        }
        localObject = paramDrawable;
      } while (a(paramContext, paramInt, paramDrawable));
      localObject = paramDrawable;
    } while (!paramBoolean);
    return null;
  }
  
  /* Error */
  private Drawable a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	android/support/v7/widget/g:aaz	Ljava/util/WeakHashMap;
    //   6: aload_1
    //   7: invokevirtual 206	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 208	android/support/v4/e/f
    //   13: astore 5
    //   15: aload 5
    //   17: ifnonnull +9 -> 26
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aload 5
    //   28: lload_2
    //   29: aconst_null
    //   30: invokevirtual 211	android/support/v4/e/f:get	(JLjava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 213	java/lang/ref/WeakReference
    //   36: astore 6
    //   38: aload 6
    //   40: ifnull +83 -> 123
    //   43: aload 6
    //   45: invokevirtual 216	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   48: checkcast 218	android/graphics/drawable/Drawable$ConstantState
    //   51: astore 6
    //   53: aload 6
    //   55: ifnull +16 -> 71
    //   58: aload 6
    //   60: aload_1
    //   61: invokevirtual 224	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   64: invokevirtual 228	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   67: astore_1
    //   68: goto -46 -> 22
    //   71: aload 5
    //   73: getfield 232	android/support/v4/e/f:EW	[J
    //   76: aload 5
    //   78: getfield 235	android/support/v4/e/f:mSize	I
    //   81: lload_2
    //   82: invokestatic 240	android/support/v4/e/c:a	([JIJ)I
    //   85: istore 4
    //   87: iload 4
    //   89: iflt +34 -> 123
    //   92: aload 5
    //   94: getfield 244	android/support/v4/e/f:EX	[Ljava/lang/Object;
    //   97: iload 4
    //   99: aaload
    //   100: getstatic 248	android/support/v4/e/f:EU	Ljava/lang/Object;
    //   103: if_acmpeq +20 -> 123
    //   106: aload 5
    //   108: getfield 244	android/support/v4/e/f:EX	[Ljava/lang/Object;
    //   111: iload 4
    //   113: getstatic 248	android/support/v4/e/f:EU	Ljava/lang/Object;
    //   116: aastore
    //   117: aload 5
    //   119: iconst_1
    //   120: putfield 251	android/support/v4/e/f:EV	Z
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -103 -> 22
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	g
    //   0	133	1	paramContext	Context
    //   0	133	2	paramLong	long
    //   85	27	4	i	int
    //   13	105	5	localf	f
    //   36	23	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	128	finally
    //   26	38	128	finally
    //   43	53	128	finally
    //   58	68	128	finally
    //   71	87	128	finally
    //   92	123	128	finally
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (x.o(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = aan;
    }
    localDrawable.setColorFilter(a(paramInt, paramDrawable));
  }
  
  static void a(Drawable paramDrawable, ax paramax, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    if ((x.o(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {}
    label57:
    label73:
    label97:
    label104:
    label124:
    for (;;)
    {
      return;
      ColorStateList localColorStateList;
      Object localObject1;
      if ((paramax.SS) || (paramax.ST)) {
        if (paramax.SS)
        {
          localColorStateList = paramax.AW;
          if (!paramax.ST) {
            break label97;
          }
          paramax = paramax.oM;
          localObject1 = localObject2;
          if (localColorStateList != null)
          {
            if (paramax != null) {
              break label104;
            }
            localObject1 = localObject2;
          }
          paramDrawable.setColorFilter((ColorFilter)localObject1);
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT > 23) {
          break label124;
        }
        paramDrawable.invalidateSelf();
        return;
        localColorStateList = null;
        break;
        paramax = aan;
        break label57;
        localObject1 = a(localColorStateList.getColorForState(paramArrayOfInt, 0), paramax);
        break label73;
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  private void a(String paramString, d paramd)
  {
    if (this.aax == null) {
      this.aax = new android.support.v4.e.a();
    }
    this.aax.put(paramString, paramd);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    int j = 16842801;
    PorterDuff.Mode localMode = aan;
    int i;
    if (c(aaq, paramInt))
    {
      j = 2130772209;
      paramInt = -1;
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (x.o(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(a(av.u(paramContext, j), localMode));
        if (paramInt != -1) {
          localDrawable.setAlpha(paramInt);
        }
        return true;
        if (c(aas, paramInt))
        {
          j = 2130772210;
          paramInt = -1;
          i = 1;
          continue;
        }
        if (c(aat, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          paramInt = -1;
          i = 1;
          continue;
        }
        if (paramInt == 2130837562)
        {
          j = 16842800;
          paramInt = Math.round(40.799999F);
          i = 1;
          continue;
        }
        if (paramInt == 2130837537)
        {
          paramInt = -1;
          i = 1;
        }
      }
      else
      {
        return false;
      }
      paramInt = -1;
      j = 0;
      i = 0;
    }
  }
  
  /* Error */
  private boolean a(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload 4
    //   4: invokevirtual 322	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   7: astore 7
    //   9: aload 7
    //   11: ifnull +68 -> 79
    //   14: aload_0
    //   15: getfield 109	android/support/v7/widget/g:aaz	Ljava/util/WeakHashMap;
    //   18: aload_1
    //   19: invokevirtual 206	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 208	android/support/v4/e/f
    //   25: astore 6
    //   27: aload 6
    //   29: astore 4
    //   31: aload 6
    //   33: ifnonnull +23 -> 56
    //   36: new 208	android/support/v4/e/f
    //   39: dup
    //   40: invokespecial 323	android/support/v4/e/f:<init>	()V
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 109	android/support/v7/widget/g:aaz	Ljava/util/WeakHashMap;
    //   49: aload_1
    //   50: aload 4
    //   52: invokevirtual 324	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 4
    //   58: lload_2
    //   59: new 213	java/lang/ref/WeakReference
    //   62: dup
    //   63: aload 7
    //   65: invokespecial 327	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   68: invokevirtual 330	android/support/v4/e/f:put	(JLjava/lang/Object;)V
    //   71: iconst_1
    //   72: istore 5
    //   74: aload_0
    //   75: monitorexit
    //   76: iload 5
    //   78: ireturn
    //   79: iconst_0
    //   80: istore 5
    //   82: goto -8 -> 74
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	g
    //   0	90	1	paramContext	Context
    //   0	90	2	paramLong	long
    //   0	90	4	paramDrawable	Drawable
    //   72	9	5	bool	boolean
    //   25	7	6	localf	f
    //   7	57	7	localConstantState	Drawable.ConstantState
    // Exception table:
    //   from	to	target	type
    //   2	9	85	finally
    //   14	27	85	finally
    //   36	56	85	finally
    //   56	71	85	finally
  }
  
  private static PorterDuff.Mode bq(int paramInt)
  {
    PorterDuff.Mode localMode = null;
    if (paramInt == 2130837593) {
      localMode = PorterDuff.Mode.MULTIPLY;
    }
    return localMode;
  }
  
  private static boolean c(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static g hg()
  {
    try
    {
      if (aao == null)
      {
        localg = new g();
        aao = localg;
        if (Build.VERSION.SDK_INT < 24)
        {
          localg.a("vector", new e());
          localg.a("animated-vector", new b());
          localg.a("animated-selector", new a());
        }
      }
      g localg = aao;
      return localg;
    }
    finally {}
  }
  
  private Drawable q(Context paramContext, int paramInt)
  {
    if ((this.aax != null) && (!this.aax.isEmpty()))
    {
      if (this.aay != null)
      {
        localObject1 = (String)this.aay.get(paramInt, null);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.aax.get(localObject1) == null)))
        {
          localObject1 = null;
          return localObject1;
        }
      }
      else
      {
        this.aay = new n();
      }
      if (this.aaA == null) {
        this.aaA = new TypedValue();
      }
      TypedValue localTypedValue = this.aaA;
      Object localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = a(localTypedValue);
      Drawable localDrawable = a(paramContext, l);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = localDrawable;
      XmlResourceParser localXmlResourceParser;
      AttributeSet localAttributeSet;
      if (localTypedValue.string != null)
      {
        localObject2 = localDrawable;
        if (localTypedValue.string.toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
            localObject2 = localDrawable;
            localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i;
            do
            {
              localObject2 = localDrawable;
              i = localXmlResourceParser.next();
            } while ((i != 2) && (i != 1));
            if (i != 2)
            {
              localObject2 = localDrawable;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext) {}
        }
      }
      for (paramContext = (Context)localObject2;; paramContext = (Context)localObject1)
      {
        localObject1 = paramContext;
        if (paramContext != null) {
          break;
        }
        this.aay.append(paramInt, "appcompat_skip_skip");
        return paramContext;
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        this.aay.append(paramInt, localObject1);
        localObject2 = localDrawable;
        d locald = (d)this.aax.get(localObject1);
        localObject1 = localDrawable;
        if (locald != null)
        {
          localObject2 = localDrawable;
          localObject1 = locald.a(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
          localObject2 = localObject1;
          a(paramContext, l, (Drawable)localObject1);
        }
      }
    }
    return null;
  }
  
  private static ColorStateList s(Context paramContext, int paramInt)
  {
    int k = av.u(paramContext, 2130772211);
    int i = av.w(paramContext, 2130772212);
    paramContext = av.gc;
    int[] arrayOfInt1 = av.PRESSED_STATE_SET;
    int j = android.support.v4.graphics.b.n(k, paramInt);
    int[] arrayOfInt2 = av.FOCUSED_STATE_SET;
    k = android.support.v4.graphics.b.n(k, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, av.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  public final void X(Context paramContext)
  {
    try
    {
      paramContext = (f)this.aaz.get(paramContext);
      if (paramContext != null) {
        paramContext.clear();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  final Drawable a(Context paramContext, be parambe, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_3
    //   5: invokespecial 479	android/support/v7/widget/g:q	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   8: astore 5
    //   10: aload 5
    //   12: astore 4
    //   14: aload 5
    //   16: ifnonnull +10 -> 26
    //   19: aload_2
    //   20: iload_3
    //   21: invokevirtual 484	android/support/v7/widget/be:cK	(I)Landroid/graphics/drawable/Drawable;
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +17 -> 45
    //   31: aload_0
    //   32: aload_1
    //   33: iload_3
    //   34: iconst_0
    //   35: aload 4
    //   37: invokespecial 486	android/support/v7/widget/g:a	(Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: aconst_null
    //   46: astore_1
    //   47: goto -6 -> 41
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	g
    //   0	55	1	paramContext	Context
    //   0	55	2	parambe	be
    //   0	55	3	paramInt	int
    //   12	24	4	localDrawable1	Drawable
    //   8	7	5	localDrawable2	Drawable
    // Exception table:
    //   from	to	target	type
    //   2	10	50	finally
    //   19	26	50	finally
    //   31	41	50	finally
  }
  
  final Drawable b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        if (!this.aaB)
        {
          this.aaB = true;
          localObject1 = k(paramContext, 2130837609);
          if (localObject1 != null)
          {
            if ((localObject1 instanceof i)) {
              break label282;
            }
            if (!"android.graphics.drawable.VectorDrawable".equals(localObject1.getClass().getName())) {
              break label285;
            }
            break label282;
          }
          this.aaB = false;
          throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
      }
      finally {}
      label282:
      label285:
      do
      {
        Object localObject2 = q(paramContext, paramInt);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (this.aaA == null) {
            this.aaA = new TypedValue();
          }
          TypedValue localTypedValue = this.aaA;
          paramContext.getResources().getValue(paramInt, localTypedValue, true);
          long l = a(localTypedValue);
          localObject2 = a(paramContext, l);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (paramInt == 2130837534) {
              localObject2 = new LayerDrawable(new Drawable[] { k(paramContext, 2130837533), k(paramContext, 2130837535) });
            }
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              ((Drawable)localObject2).setChangingConfigurations(localTypedValue.changingConfigurations);
              a(paramContext, l, (Drawable)localObject2);
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = android.support.v4.content.b.k(paramContext, paramInt);
        }
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
        }
        if (localObject1 != null) {
          x.n((Drawable)localObject1);
        }
        return localObject1;
        i = 1;
      } while (i != 0);
    }
  }
  
  public final Drawable k(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = b(paramContext, paramInt, false);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  final ColorStateList r(Context paramContext, int paramInt)
  {
    Object localObject1;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (this.aaw != null)
        {
          localObject1 = (n)this.aaw.get(paramContext);
          if (localObject1 != null)
          {
            localObject1 = (ColorStateList)((n)localObject1).get(paramInt, null);
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              if (paramInt == 2130837538)
              {
                localObject1 = android.support.v7.c.a.a.l(paramContext, 2131690731);
                if (localObject1 != null)
                {
                  if (this.aaw == null) {
                    this.aaw = new WeakHashMap();
                  }
                  localObject3 = (n)this.aaw.get(paramContext);
                  localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject2 = new n();
                    this.aaw.put(paramContext, localObject2);
                  }
                  ((n)localObject2).append(paramInt, localObject1);
                }
                localObject2 = localObject1;
              }
            }
            else {
              return localObject2;
            }
          }
          else
          {
            localObject1 = null;
            continue;
          }
        }
        else
        {
          localObject1 = null;
          continue;
        }
        if (paramInt == 2130837594)
        {
          localObject1 = android.support.v7.c.a.a.l(paramContext, 2131690734);
          continue;
        }
        if (paramInt != 2130837593) {
          break label325;
        }
        localObject1 = new int[3][];
        localObject2 = new int[3];
        Object localObject3 = av.v(paramContext, 2130772213);
        if ((localObject3 != null) && (((ColorStateList)localObject3).isStateful()))
        {
          localObject1[0] = av.gc;
          localObject2[0] = ((ColorStateList)localObject3).getColorForState(localObject1[0], 0);
          localObject1[1] = av.dP;
          localObject2[1] = av.u(paramContext, 2130772210);
          localObject1[2] = av.EMPTY_STATE_SET;
          localObject2[2] = ((ColorStateList)localObject3).getDefaultColor();
          localObject1 = new ColorStateList((int[][])localObject1, (int[])localObject2);
          continue;
        }
        localObject1[0] = av.gc;
      }
      finally {}
      localObject2[0] = av.w(paramContext, 2130772213);
      localObject1[1] = av.dP;
      localObject2[1] = av.u(paramContext, 2130772210);
      localObject1[2] = av.EMPTY_STATE_SET;
      localObject2[2] = av.u(paramContext, 2130772213);
      continue;
      label325:
      if (paramInt == 2130837527)
      {
        localObject1 = s(paramContext, av.u(paramContext, 2130772212));
      }
      else if (paramInt == 2130837522)
      {
        localObject1 = s(paramContext, 0);
      }
      else
      {
        if (paramInt != 2130837526) {
          break;
        }
        localObject1 = s(paramContext, av.u(paramContext, 2130772208));
      }
    }
    for (;;)
    {
      label385:
      localObject1 = android.support.v7.c.a.a.l(paramContext, 2131690733);
      break;
      do
      {
        if (c(aar, paramInt))
        {
          localObject1 = av.v(paramContext, 2130772209);
          break;
        }
        if (c(aau, paramInt))
        {
          localObject1 = android.support.v7.c.a.a.l(paramContext, 2131690730);
          break;
        }
        if (c(aav, paramInt))
        {
          localObject1 = android.support.v7.c.a.a.l(paramContext, 2131690729);
          break;
        }
        if (paramInt == 2130837583)
        {
          localObject1 = android.support.v7.c.a.a.l(paramContext, 2131690732);
          break;
        }
        break;
        if (paramInt == 2130837591) {
          break label385;
        }
      } while (paramInt != 2130837592);
    }
  }
  
  static final class a
    implements g.d
  {
    public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = android.support.v7.d.a.a.b(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext) {}
      return null;
    }
  }
  
  static final class b
    implements g.d
  {
    public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = c.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext) {}
      return null;
    }
  }
  
  static final class c
    extends android.support.v4.e.g<Integer, PorterDuffColorFilter>
  {
    public c()
    {
      super();
    }
    
    static int b(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
  }
  
  static abstract interface d
  {
    public abstract Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  static final class e
    implements g.d
  {
    public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = i.a(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext) {}
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.g
 * JD-Core Version:    0.7.0.1
 */