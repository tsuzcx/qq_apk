package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.a.a;
import androidx.appcompat.a.c;
import androidx.appcompat.a.e;
import androidx.b.d;
import androidx.b.h;
import androidx.core.graphics.b;
import androidx.l.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class f
{
  private static final int[] rA;
  private static final int[] rB;
  private static final int[] rC;
  private static final int[] rD;
  private static final int[] rE;
  private static final int[] rF;
  private static final PorterDuff.Mode rx;
  private static f ry;
  private static final f.c rz;
  private WeakHashMap<Context, h<ColorStateList>> rG;
  private androidx.b.a<String, f.d> rH;
  private h<String> rI;
  private final WeakHashMap<Context, d<WeakReference<Drawable.ConstantState>>> rJ;
  private TypedValue rK;
  private boolean rL;
  
  static
  {
    AppMethodBeat.i(200273);
    rx = PorterDuff.Mode.SRC_IN;
    rz = new f.c();
    rA = new int[] { a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha };
    rB = new int[] { a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha };
    rC = new int[] { a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light };
    rD = new int[] { a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult };
    rE = new int[] { a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material };
    rF = new int[] { a.e.abc_btn_check_material, a.e.abc_btn_radio_material };
    AppMethodBeat.o(200273);
  }
  
  public f()
  {
    AppMethodBeat.i(200064);
    this.rJ = new WeakHashMap(0);
    AppMethodBeat.o(200064);
  }
  
  private static long a(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      AppMethodBeat.i(200249);
      PorterDuffColorFilter localPorterDuffColorFilter2 = (PorterDuffColorFilter)rz.get(Integer.valueOf(f.c.b(paramInt, paramMode)));
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
        rz.put(Integer.valueOf(f.c.b(paramInt, paramMode)), localPorterDuffColorFilter1);
      }
      AppMethodBeat.o(200249);
      return localPorterDuffColorFilter1;
    }
    finally {}
  }
  
  private Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    AppMethodBeat.i(200115);
    Object localObject = q(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (o.j(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = androidx.core.graphics.drawable.a.s(paramContext);
      androidx.core.graphics.drawable.a.a(paramContext, (ColorStateList)localObject);
      paramDrawable = ar(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        androidx.core.graphics.drawable.a.a(paramContext, paramDrawable);
        localObject = paramContext;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200115);
      return localObject;
      if (paramInt == a.e.abc_seekbar_track_material)
      {
        localObject = (LayerDrawable)paramDrawable;
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), y.t(paramContext, a.a.colorControlNormal), rx);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), y.t(paramContext, a.a.colorControlNormal), rx);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), y.t(paramContext, a.a.colorControlActivated), rx);
        localObject = paramDrawable;
      }
      else if ((paramInt == a.e.abc_ratingbar_material) || (paramInt == a.e.abc_ratingbar_indicator_material) || (paramInt == a.e.abc_ratingbar_small_material))
      {
        localObject = (LayerDrawable)paramDrawable;
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), y.v(paramContext, a.a.colorControlNormal), rx);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), y.t(paramContext, a.a.colorControlActivated), rx);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), y.t(paramContext, a.a.colorControlActivated), rx);
        localObject = paramDrawable;
      }
      else
      {
        localObject = paramDrawable;
        if (!a(paramContext, paramInt, paramDrawable))
        {
          localObject = paramDrawable;
          if (paramBoolean) {
            localObject = null;
          }
        }
      }
    }
  }
  
  private Drawable a(Context paramContext, long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(200155);
        d locald = (d)this.rJ.get(paramContext);
        if (locald == null)
        {
          AppMethodBeat.o(200155);
          paramContext = null;
          return paramContext;
        }
        Object localObject = (WeakReference)locald.get(paramLong, null);
        if (localObject != null)
        {
          localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
          if (localObject != null)
          {
            paramContext = ((Drawable.ConstantState)localObject).newDrawable(paramContext.getResources());
            AppMethodBeat.o(200155);
            continue;
          }
          locald.remove(paramLong);
        }
      }
      finally {}
      AppMethodBeat.o(200155);
      paramContext = null;
    }
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200261);
    Drawable localDrawable = paramDrawable;
    if (o.j(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = rx;
    }
    localDrawable.setColorFilter(a(paramInt, paramDrawable));
    AppMethodBeat.o(200261);
  }
  
  static void a(Drawable paramDrawable, aa paramaa, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200235);
    if ((o.j(paramDrawable)) && (paramDrawable.mutate() != paramDrawable))
    {
      AppMethodBeat.o(200235);
      return;
    }
    ColorStateList localColorStateList;
    label69:
    Object localObject1;
    if ((paramaa.kB) || (paramaa.kC)) {
      if (paramaa.kB)
      {
        localColorStateList = paramaa.kz;
        if (!paramaa.kC) {
          break label115;
        }
        paramaa = paramaa.kA;
        localObject1 = localObject2;
        if (localColorStateList != null)
        {
          if (paramaa != null) {
            break label122;
          }
          localObject1 = localObject2;
        }
        label85:
        paramDrawable.setColorFilter((ColorFilter)localObject1);
      }
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT <= 23) {
        paramDrawable.invalidateSelf();
      }
      AppMethodBeat.o(200235);
      return;
      localColorStateList = null;
      break;
      label115:
      paramaa = rx;
      break label69;
      label122:
      localObject1 = a(localColorStateList.getColorForState(paramArrayOfInt, 0), paramaa);
      break label85;
      paramDrawable.clearColorFilter();
    }
  }
  
  private void a(String paramString, f.d paramd)
  {
    AppMethodBeat.i(200195);
    if (this.rH == null) {
      this.rH = new androidx.b.a();
    }
    this.rH.put(paramString, paramd);
    AppMethodBeat.o(200195);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    int j = 16842801;
    AppMethodBeat.i(200187);
    PorterDuff.Mode localMode = rx;
    int i;
    if (b(rA, paramInt))
    {
      j = a.a.colorControlNormal;
      paramInt = -1;
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (o.j(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(a(y.t(paramContext, j), localMode));
        if (paramInt != -1) {
          localDrawable.setAlpha(paramInt);
        }
        AppMethodBeat.o(200187);
        return true;
        if (b(rC, paramInt))
        {
          j = a.a.colorControlActivated;
          paramInt = -1;
          i = 1;
          continue;
        }
        if (b(rD, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          paramInt = -1;
          i = 1;
          continue;
        }
        if (paramInt == a.e.abc_list_divider_mtrl_alpha)
        {
          j = 16842800;
          paramInt = Math.round(40.799999F);
          i = 1;
          continue;
        }
        if (paramInt == a.e.abc_dialog_material_background)
        {
          paramInt = -1;
          i = 1;
        }
      }
      else
      {
        AppMethodBeat.o(200187);
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
    //   2: ldc_w 389
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload 4
    //   10: invokevirtual 393	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   13: astore 7
    //   15: aload 7
    //   17: ifnull +74 -> 91
    //   20: aload_0
    //   21: getfield 171	androidx/appcompat/widget/f:rJ	Ljava/util/WeakHashMap;
    //   24: aload_1
    //   25: invokevirtual 287	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 289	androidx/b/d
    //   31: astore 6
    //   33: aload 6
    //   35: astore 4
    //   37: aload 6
    //   39: ifnonnull +23 -> 62
    //   42: new 289	androidx/b/d
    //   45: dup
    //   46: invokespecial 394	androidx/b/d:<init>	()V
    //   49: astore 4
    //   51: aload_0
    //   52: getfield 171	androidx/appcompat/widget/f:rJ	Ljava/util/WeakHashMap;
    //   55: aload_1
    //   56: aload 4
    //   58: invokevirtual 395	java/util/WeakHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload 4
    //   64: lload_2
    //   65: new 294	java/lang/ref/WeakReference
    //   68: dup
    //   69: aload 7
    //   71: invokespecial 398	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   74: invokevirtual 401	androidx/b/d:a	(JLjava/lang/Object;)V
    //   77: iconst_1
    //   78: istore 5
    //   80: ldc_w 389
    //   83: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_0
    //   87: monitorexit
    //   88: iload 5
    //   90: ireturn
    //   91: iconst_0
    //   92: istore 5
    //   94: ldc_w 389
    //   97: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: goto -14 -> 86
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	f
    //   0	108	1	paramContext	Context
    //   0	108	2	paramLong	long
    //   0	108	4	paramDrawable	Drawable
    //   78	15	5	bool	boolean
    //   31	7	6	locald	d
    //   13	57	7	localConstantState	Drawable.ConstantState
    // Exception table:
    //   from	to	target	type
    //   2	15	103	finally
    //   20	33	103	finally
    //   42	62	103	finally
    //   62	77	103	finally
    //   80	86	103	finally
    //   94	100	103	finally
  }
  
  private static PorterDuff.Mode ar(int paramInt)
  {
    PorterDuff.Mode localMode = null;
    if (paramInt == a.e.abc_switch_thumb_material) {
      localMode = PorterDuff.Mode.MULTIPLY;
    }
    return localMode;
  }
  
  private static boolean b(int[] paramArrayOfInt, int paramInt)
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
  
  public static f ep()
  {
    try
    {
      AppMethodBeat.i(200084);
      if (ry == null)
      {
        localf = new f();
        ry = localf;
        if (Build.VERSION.SDK_INT < 24)
        {
          localf.a("vector", new f.e());
          localf.a("animated-vector", new f.b());
          localf.a("animated-selector", new f.a());
        }
      }
      f localf = ry;
      AppMethodBeat.o(200084);
      return localf;
    }
    finally {}
  }
  
  private Drawable p(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200137);
    if ((this.rH != null) && (!this.rH.isEmpty()))
    {
      if (this.rI != null)
      {
        localObject1 = (String)this.rI.d(paramInt, null);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.rH.get(localObject1) == null)))
        {
          AppMethodBeat.o(200137);
          return null;
        }
      }
      else
      {
        this.rI = new h();
      }
      if (this.rK == null) {
        this.rK = new TypedValue();
      }
      TypedValue localTypedValue = this.rK;
      Object localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = a(localTypedValue);
      Drawable localDrawable = a(paramContext, l);
      if (localDrawable != null)
      {
        AppMethodBeat.o(200137);
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
              paramContext = new XmlPullParserException("No start tag found");
              localObject2 = localDrawable;
              AppMethodBeat.o(200137);
              localObject2 = localDrawable;
              throw paramContext;
            }
          }
          catch (Exception paramContext) {}
        }
      }
      for (;;)
      {
        if (localObject2 == null) {
          this.rI.e(paramInt, "appcompat_skip_skip");
        }
        AppMethodBeat.o(200137);
        return localObject2;
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        this.rI.e(paramInt, localObject1);
        localObject2 = localDrawable;
        f.d locald = (f.d)this.rH.get(localObject1);
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
        localObject2 = localObject1;
      }
    }
    AppMethodBeat.o(200137);
    return null;
  }
  
  private static ColorStateList r(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200225);
    int k = y.t(paramContext, a.a.colorControlHighlight);
    int i = y.v(paramContext, a.a.colorButtonNormal);
    paramContext = y.xl;
    int[] arrayOfInt1 = y.xo;
    int j = b.av(k, paramInt);
    int[] arrayOfInt2 = y.xm;
    k = b.av(k, paramInt);
    paramContext = new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, y.xr }, new int[] { i, j, k, paramInt });
    AppMethodBeat.o(200225);
    return paramContext;
  }
  
  public final void J(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(200363);
      paramContext = (d)this.rJ.get(paramContext);
      if (paramContext != null) {
        paramContext.clear();
      }
      AppMethodBeat.o(200363);
      return;
    }
    finally {}
  }
  
  /* Error */
  final Drawable a(Context paramContext, ah paramah, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 560
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: iload_3
    //   11: invokespecial 562	androidx/appcompat/widget/f:p	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   14: astore 5
    //   16: aload 5
    //   18: astore 4
    //   20: aload 5
    //   22: ifnonnull +10 -> 32
    //   25: aload_2
    //   26: iload_3
    //   27: invokevirtual 567	androidx/appcompat/widget/ah:aC	(I)Landroid/graphics/drawable/Drawable;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +23 -> 57
    //   37: aload_0
    //   38: aload_1
    //   39: iload_3
    //   40: iconst_0
    //   41: aload 4
    //   43: invokespecial 569	androidx/appcompat/widget/f:a	(Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   46: astore_1
    //   47: ldc_w 560
    //   50: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: ldc_w 560
    //   62: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	f
    //   0	73	1	paramContext	Context
    //   0	73	2	paramah	ah
    //   0	73	3	paramInt	int
    //   18	24	4	localDrawable1	Drawable
    //   14	7	5	localDrawable2	Drawable
    // Exception table:
    //   from	to	target	type
    //   2	16	68	finally
    //   25	32	68	finally
    //   37	53	68	finally
    //   59	65	68	finally
  }
  
  final Drawable b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        AppMethodBeat.i(200299);
        if (!this.rL)
        {
          this.rL = true;
          localObject1 = m(paramContext, a.e.abc_vector_test);
          if (localObject1 != null)
          {
            if ((localObject1 instanceof i)) {
              break label304;
            }
            if (!"android.graphics.drawable.VectorDrawable".equals(localObject1.getClass().getName())) {
              break label307;
            }
            break label304;
          }
          this.rL = false;
          paramContext = new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
          AppMethodBeat.o(200299);
          throw paramContext;
        }
      }
      finally {}
      label304:
      label307:
      do
      {
        Object localObject2 = p(paramContext, paramInt);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (this.rK == null) {
            this.rK = new TypedValue();
          }
          TypedValue localTypedValue = this.rK;
          paramContext.getResources().getValue(paramInt, localTypedValue, true);
          long l = a(localTypedValue);
          localObject2 = a(paramContext, l);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (paramInt == a.e.abc_cab_background_top_material) {
              localObject2 = new LayerDrawable(new Drawable[] { m(paramContext, a.e.abc_cab_background_internal_bg), m(paramContext, a.e.abc_cab_background_top_mtrl_alpha) });
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
          localObject2 = androidx.core.content.a.m(paramContext, paramInt);
        }
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
        }
        if (localObject1 != null) {
          o.i((Drawable)localObject1);
        }
        AppMethodBeat.o(200299);
        return localObject1;
        i = 1;
      } while (i != 0);
    }
  }
  
  public final Drawable m(Context paramContext, int paramInt)
  {
    try
    {
      AppMethodBeat.i(200291);
      paramContext = b(paramContext, paramInt, false);
      AppMethodBeat.o(200291);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  final ColorStateList q(Context paramContext, int paramInt)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        AppMethodBeat.i(200409);
        if (this.rG != null)
        {
          localObject1 = (h)this.rG.get(paramContext);
          if (localObject1 != null)
          {
            localObject1 = (ColorStateList)((h)localObject1).d(paramInt, null);
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              if (paramInt == a.e.abc_edit_text_material)
              {
                localObject1 = androidx.appcompat.a.a.a.l(paramContext, a.c.abc_tint_edittext);
                if (localObject1 == null) {
                  break label508;
                }
                if (this.rG == null) {
                  this.rG = new WeakHashMap();
                }
                localObject3 = (h)this.rG.get(paramContext);
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  localObject2 = new h();
                  this.rG.put(paramContext, localObject2);
                }
                ((h)localObject2).e(paramInt, localObject1);
                break label508;
              }
            }
            else
            {
              AppMethodBeat.o(200409);
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
        if (paramInt == a.e.abc_switch_track_mtrl_alpha)
        {
          localObject1 = androidx.appcompat.a.a.a.l(paramContext, a.c.abc_tint_switch_track);
          continue;
        }
        if (paramInt != a.e.abc_switch_thumb_material) {
          break label339;
        }
        localObject1 = new int[3][];
        localObject2 = new int[3];
        Object localObject3 = y.u(paramContext, a.a.colorSwitchThumbNormal);
        if ((localObject3 != null) && (((ColorStateList)localObject3).isStateful()))
        {
          localObject1[0] = y.xl;
          localObject2[0] = ((ColorStateList)localObject3).getColorForState(localObject1[0], 0);
          localObject1[1] = y.xk;
          localObject2[1] = y.t(paramContext, a.a.colorControlActivated);
          localObject1[2] = y.xr;
          localObject2[2] = ((ColorStateList)localObject3).getDefaultColor();
          localObject1 = new ColorStateList((int[][])localObject1, (int[])localObject2);
          continue;
        }
        localObject1[0] = y.xl;
      }
      finally {}
      localObject2[0] = y.v(paramContext, a.a.colorSwitchThumbNormal);
      localObject1[1] = y.xk;
      localObject2[1] = y.t(paramContext, a.a.colorControlActivated);
      localObject1[2] = y.xr;
      localObject2[2] = y.t(paramContext, a.a.colorSwitchThumbNormal);
      continue;
      label339:
      if (paramInt == a.e.abc_btn_default_mtrl_shape)
      {
        localObject1 = r(paramContext, y.t(paramContext, a.a.colorButtonNormal));
      }
      else if (paramInt == a.e.abc_btn_borderless_material)
      {
        localObject1 = r(paramContext, 0);
      }
      else if (paramInt == a.e.abc_btn_colored_material)
      {
        localObject1 = r(paramContext, y.t(paramContext, a.a.colorAccent));
      }
      else if ((paramInt == a.e.abc_spinner_mtrl_am_alpha) || (paramInt == a.e.abc_spinner_textfield_background_material))
      {
        localObject1 = androidx.appcompat.a.a.a.l(paramContext, a.c.abc_tint_spinner);
      }
      else if (b(rB, paramInt))
      {
        localObject1 = y.u(paramContext, a.a.colorControlNormal);
      }
      else if (b(rE, paramInt))
      {
        localObject1 = androidx.appcompat.a.a.a.l(paramContext, a.c.abc_tint_default);
      }
      else if (b(rF, paramInt))
      {
        localObject1 = androidx.appcompat.a.a.a.l(paramContext, a.c.abc_tint_btn_checkable);
      }
      else if (paramInt == a.e.abc_seekbar_thumb_material)
      {
        localObject1 = androidx.appcompat.a.a.a.l(paramContext, a.c.abc_tint_seek_thumb);
      }
      else
      {
        continue;
        label508:
        localObject2 = localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.f
 * JD-Core Version:    0.7.0.1
 */