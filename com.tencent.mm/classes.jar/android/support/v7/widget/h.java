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
import android.support.c.a.i;
import android.support.v4.f.f;
import android.support.v4.f.g;
import android.support.v4.f.n;
import android.support.v7.a.a.a;
import android.support.v7.a.a.c;
import android.support.v7.a.a.e;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class h
{
  private static final PorterDuff.Mode ZC = PorterDuff.Mode.SRC_IN;
  private static h ZD;
  private static final b ZE = new b();
  private static final int[] ZF = { a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha };
  private static final int[] ZG = { a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha };
  private static final int[] ZH = { a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light };
  private static final int[] ZI = { a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult };
  private static final int[] ZJ = { a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material };
  private static final int[] ZK = { a.e.abc_btn_check_material, a.e.abc_btn_radio_material };
  private WeakHashMap<Context, n<ColorStateList>> ZL;
  private android.support.v4.f.a<String, c> ZM;
  private n<String> ZN;
  public final Object ZO = new Object();
  public final WeakHashMap<Context, f<WeakReference<Drawable.ConstantState>>> ZP = new WeakHashMap(0);
  private TypedValue ZQ;
  private boolean ZR;
  
  private static long a(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    PorterDuffColorFilter localPorterDuffColorFilter2 = (PorterDuffColorFilter)ZE.get(Integer.valueOf(b.b(paramInt, paramMode)));
    PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
    if (localPorterDuffColorFilter2 == null)
    {
      localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      ZE.put(Integer.valueOf(b.b(paramInt, paramMode)), localPorterDuffColorFilter1);
    }
    return localPorterDuffColorFilter1;
  }
  
  private Drawable a(Context paramContext, long paramLong)
  {
    f localf;
    synchronized (this.ZO)
    {
      localf = (f)this.ZP.get(paramContext);
      if (localf == null) {
        return null;
      }
      Object localObject2 = (WeakReference)localf.get(paramLong);
      if (localObject2 == null) {
        break label136;
      }
      localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        paramContext = ((Drawable.ConstantState)localObject2).newDrawable(paramContext.getResources());
        return paramContext;
      }
    }
    int i = android.support.v4.f.c.a(localf.Eg, localf.mSize, paramLong);
    if ((i >= 0) && (localf.Eh[i] != f.Ee))
    {
      localf.Eh[i] = f.Ee;
      localf.Ef = true;
    }
    label136:
    return null;
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (y.m(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = ZC;
    }
    localDrawable.setColorFilter(a(paramInt, paramDrawable));
  }
  
  static void a(Drawable paramDrawable, av paramav, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    if ((y.m(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {}
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
      if ((paramav.alX) || (paramav.alW)) {
        if (paramav.alX)
        {
          localColorStateList = paramav.alV;
          if (!paramav.alW) {
            break label97;
          }
          paramav = paramav.nN;
          localObject1 = localObject2;
          if (localColorStateList != null)
          {
            if (paramav != null) {
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
        paramav = ZC;
        break label57;
        localObject1 = a(localColorStateList.getColorForState(paramArrayOfInt, 0), paramav);
        break label73;
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  private void a(String paramString, c paramc)
  {
    if (this.ZM == null) {
      this.ZM = new android.support.v4.f.a();
    }
    this.ZM.put(paramString, paramc);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    int j = 16842801;
    PorterDuff.Mode localMode = ZC;
    int i;
    if (c(ZF, paramInt))
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
        if (y.m(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(a(at.q(paramContext, j), localMode));
        if (paramInt != -1) {
          localDrawable.setAlpha(paramInt);
        }
        return true;
        if (c(ZH, paramInt))
        {
          j = a.a.colorControlActivated;
          paramInt = -1;
          i = 1;
          continue;
        }
        if (c(ZI, paramInt))
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
        return false;
      }
      paramInt = -1;
      j = 0;
      i = 0;
    }
  }
  
  private boolean a(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null) {
      synchronized (this.ZO)
      {
        f localf = (f)this.ZP.get(paramContext);
        paramDrawable = localf;
        if (localf == null)
        {
          paramDrawable = new f();
          this.ZP.put(paramContext, paramDrawable);
        }
        paramDrawable.put(paramLong, new WeakReference(localConstantState));
        return true;
      }
    }
    return false;
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
  
  public static h gi()
  {
    if (ZD == null)
    {
      h localh = new h();
      ZD = localh;
      if (Build.VERSION.SDK_INT < 24)
      {
        localh.a("vector", new d());
        localh.a("animated-vector", new a());
      }
    }
    return ZD;
  }
  
  private static ColorStateList o(Context paramContext, int paramInt)
  {
    int k = at.q(paramContext, a.a.colorControlHighlight);
    int i = at.s(paramContext, a.a.colorButtonNormal);
    paramContext = at.fd;
    int[] arrayOfInt1 = at.PRESSED_STATE_SET;
    int j = android.support.v4.a.b.n(k, paramInt);
    int[] arrayOfInt2 = at.FOCUSED_STATE_SET;
    k = android.support.v4.a.b.n(k, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, at.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  public final Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (!this.ZR)
    {
      this.ZR = true;
      localObject1 = a(paramContext, a.e.abc_vector_test, false);
      if (localObject1 != null) {
        if ((!(localObject1 instanceof i)) && (!"android.graphics.drawable.VectorDrawable".equals(localObject1.getClass().getName()))) {
          break label77;
        }
      }
      label77:
      for (int i = 1; i == 0; i = 0)
      {
        this.ZR = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
      }
    }
    Object localObject2 = m(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.ZQ == null) {
        this.ZQ = new TypedValue();
      }
      TypedValue localTypedValue = this.ZQ;
      paramContext.getResources().getValue(paramInt, localTypedValue, true);
      long l = a(localTypedValue);
      localObject2 = a(paramContext, l);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramInt == a.e.abc_cab_background_top_material) {
          localObject2 = new LayerDrawable(new Drawable[] { a(paramContext, a.e.abc_cab_background_internal_bg, false), a(paramContext, a.e.abc_cab_background_top_mtrl_alpha, false) });
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
      localObject2 = android.support.v4.content.b.g(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
    }
    if (localObject1 != null) {
      y.l((Drawable)localObject1);
    }
    return localObject1;
  }
  
  final Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = null;
    ColorStateList localColorStateList = n(paramContext, paramInt);
    if (localColorStateList != null)
    {
      paramContext = paramDrawable;
      if (y.m(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramDrawable = android.support.v4.a.a.a.f(paramContext);
      android.support.v4.a.a.a.a(paramDrawable, localColorStateList);
      paramContext = (Context)localObject;
      if (paramInt == a.e.abc_switch_thumb_material) {
        paramContext = PorterDuff.Mode.MULTIPLY;
      }
      localObject = paramDrawable;
      if (paramContext != null)
      {
        android.support.v4.a.a.a.a(paramDrawable, paramContext);
        localObject = paramDrawable;
      }
    }
    do
    {
      do
      {
        return localObject;
        if (paramInt == a.e.abc_seekbar_track_material)
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), at.q(paramContext, a.a.colorControlNormal), ZC);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), at.q(paramContext, a.a.colorControlNormal), ZC);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), at.q(paramContext, a.a.colorControlActivated), ZC);
          return paramDrawable;
        }
        if ((paramInt == a.e.abc_ratingbar_material) || (paramInt == a.e.abc_ratingbar_indicator_material) || (paramInt == a.e.abc_ratingbar_small_material))
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), at.s(paramContext, a.a.colorControlNormal), ZC);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), at.q(paramContext, a.a.colorControlActivated), ZC);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), at.q(paramContext, a.a.colorControlActivated), ZC);
          return paramDrawable;
        }
        localObject = paramDrawable;
      } while (a(paramContext, paramInt, paramDrawable));
      localObject = paramDrawable;
    } while (!paramBoolean);
    return null;
  }
  
  final Drawable m(Context paramContext, int paramInt)
  {
    if ((this.ZM != null) && (!this.ZM.isEmpty()))
    {
      if (this.ZN != null)
      {
        localObject1 = (String)this.ZN.get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.ZM.get(localObject1) == null)))
        {
          localObject1 = null;
          return localObject1;
        }
      }
      else
      {
        this.ZN = new n();
      }
      if (this.ZQ == null) {
        this.ZQ = new TypedValue();
      }
      TypedValue localTypedValue = this.ZQ;
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
        this.ZN.append(paramInt, "appcompat_skip_skip");
        return paramContext;
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        this.ZN.append(paramInt, localObject1);
        localObject2 = localDrawable;
        c localc = (c)this.ZM.get(localObject1);
        localObject1 = localDrawable;
        if (localc != null)
        {
          localObject2 = localDrawable;
          localObject1 = localc.a(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
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
  
  final ColorStateList n(Context paramContext, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (this.ZL != null)
    {
      localObject1 = (n)this.ZL.get(paramContext);
      if (localObject1 != null)
      {
        localObject1 = (ColorStateList)((n)localObject1).get(paramInt);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          if (paramInt != a.e.abc_edit_text_material) {
            break label141;
          }
          localObject1 = android.support.v7.c.a.b.h(paramContext, a.c.abc_tint_edittext);
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        if (this.ZL == null) {
          this.ZL = new WeakHashMap();
        }
        localObject3 = (n)this.ZL.get(paramContext);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new n();
          this.ZL.put(paramContext, localObject2);
        }
        ((n)localObject2).append(paramInt, localObject1);
      }
      localObject2 = localObject1;
      return localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
      label141:
      if (paramInt == a.e.abc_switch_track_mtrl_alpha)
      {
        localObject1 = android.support.v7.c.a.b.h(paramContext, a.c.abc_tint_switch_track);
      }
      else
      {
        if (paramInt == a.e.abc_switch_thumb_material)
        {
          localObject1 = new int[3][];
          localObject2 = new int[3];
          localObject3 = at.r(paramContext, a.a.colorSwitchThumbNormal);
          if ((localObject3 != null) && (((ColorStateList)localObject3).isStateful()))
          {
            localObject1[0] = at.fd;
            localObject2[0] = ((ColorStateList)localObject3).getColorForState(localObject1[0], 0);
            localObject1[1] = at.cL;
            localObject2[1] = at.q(paramContext, a.a.colorControlActivated);
            localObject1[2] = at.EMPTY_STATE_SET;
            localObject2[2] = ((ColorStateList)localObject3).getDefaultColor();
          }
          for (;;)
          {
            localObject1 = new ColorStateList((int[][])localObject1, (int[])localObject2);
            break;
            localObject1[0] = at.fd;
            localObject2[0] = at.s(paramContext, a.a.colorSwitchThumbNormal);
            localObject1[1] = at.cL;
            localObject2[1] = at.q(paramContext, a.a.colorControlActivated);
            localObject1[2] = at.EMPTY_STATE_SET;
            localObject2[2] = at.q(paramContext, a.a.colorSwitchThumbNormal);
          }
        }
        if (paramInt == a.e.abc_btn_default_mtrl_shape) {
          localObject1 = o(paramContext, at.q(paramContext, a.a.colorButtonNormal));
        } else if (paramInt == a.e.abc_btn_borderless_material) {
          localObject1 = o(paramContext, 0);
        } else if (paramInt == a.e.abc_btn_colored_material) {
          localObject1 = o(paramContext, at.q(paramContext, a.a.colorAccent));
        } else if ((paramInt == a.e.abc_spinner_mtrl_am_alpha) || (paramInt == a.e.abc_spinner_textfield_background_material)) {
          localObject1 = android.support.v7.c.a.b.h(paramContext, a.c.abc_tint_spinner);
        } else if (c(ZG, paramInt)) {
          localObject1 = at.r(paramContext, a.a.colorControlNormal);
        } else if (c(ZJ, paramInt)) {
          localObject1 = android.support.v7.c.a.b.h(paramContext, a.c.abc_tint_default);
        } else if (c(ZK, paramInt)) {
          localObject1 = android.support.v7.c.a.b.h(paramContext, a.c.abc_tint_btn_checkable);
        } else if (paramInt == a.e.abc_seekbar_thumb_material) {
          localObject1 = android.support.v7.c.a.b.h(paramContext, a.c.abc_tint_seek_thumb);
        }
      }
    }
  }
  
  private static final class a
    implements h.c
  {
    public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = android.support.c.a.c.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext) {}
      return null;
    }
  }
  
  private static final class b
    extends g<Integer, PorterDuffColorFilter>
  {
    public b()
    {
      super();
    }
    
    static int b(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
  }
  
  private static abstract interface c
  {
    public abstract Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  private static final class d
    implements h.c
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
 * Qualified Name:     android.support.v7.widget.h
 * JD-Core Version:    0.7.0.1
 */