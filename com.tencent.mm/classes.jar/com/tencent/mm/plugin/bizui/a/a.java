package com.tencent.mm.plugin.bizui.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/bizui/util/BizViewUtils;", "", "()V", "TAG", "", "TITLE_SCENE_MP_CHAT", "", "TITLE_SCENE_MP_CHAT_COVER_TITLE", "TITLE_SCENE_MP_CHAT_ITEM", "TITLE_SCENE_PROFILE", "TITLE_SCENE_PROFILE_COVER_TITLE", "TITLE_SCENE_PROFILE_ITEM", "TITLE_SCENE_TIME_LINE", "TITLE_SCENE_TIME_LINE_COVER_TITLE", "TITLE_SCENE_TIME_LINE_ITEM", "bizVideoOpenWithFinder", "", "getBizVideoOpenWithFinder", "()Z", "bizVideoOpenWithFinder$delegate", "Lkotlin/Lazy;", "optionSearchOpen", "getOptionSearchOpen", "optionSearchOpen$delegate", "widthMap", "Ljava/util/HashMap;", "getWidthMap", "()Ljava/util/HashMap;", "setWidthMap", "(Ljava/util/HashMap;)V", "appendIcon", "", "tv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "", "drawable", "Landroid/graphics/drawable/Drawable;", "padding", "expandTouchArea", "parent", "Landroid/view/ViewParent;", "v", "Landroid/view/View;", "x", "y", "getDefaultTitleWidth", "scene", "context", "Landroid/content/Context;", "getGreenUnreadCountShape", "textSize", "getPaddingSpan", "Landroid/text/SpannableString;", "size", "getRealScreenWidth", "getTitleWidth", "getViewTop", "root", "target", "isCoverTitle", "roundCorner", "view", "cornerRadius", "", "topRound", "bottomRound", "setAccessibilityFocusable", "focused", "setTitleEndWithPayIcon", "icon", "setTitleWidth", "width", "setViewHeight", "height", "setViewSize", "setViewWidth", "ui-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a vtB;
  private static HashMap<Integer, Integer> vtC;
  private static final j vtD;
  private static final j vtE;
  
  static
  {
    AppMethodBeat.i(123735);
    vtB = new a();
    vtC = new HashMap();
    vtD = k.cm((kotlin.g.a.a)a.b.vtG);
    vtE = k.cm((kotlin.g.a.a)a.a.vtF);
    AppMethodBeat.o(123735);
  }
  
  public static boolean GN(int paramInt)
  {
    return (paramInt == 11) || (paramInt == 21) || (paramInt == 41);
  }
  
  public static void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(260928);
    if (paramView == null)
    {
      AppMethodBeat.o(260928);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(260928);
  }
  
  public static void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(260929);
    if (paramView == null)
    {
      AppMethodBeat.o(260929);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(260929);
  }
  
  public static void a(Context paramContext, MMNeat7extView paramMMNeat7extView, int paramInt1, CharSequence paramCharSequence, final int paramInt2)
  {
    AppMethodBeat.i(123732);
    s.u(paramContext, "context");
    s.u(paramMMNeat7extView, "tv");
    s.u(paramCharSequence, "text");
    paramMMNeat7extView.aZ(paramCharSequence);
    int j;
    int i;
    Object localObject;
    if (paramMMNeat7extView.getWidth() > 0)
    {
      j = paramMMNeat7extView.getWidth();
      i = j;
      if (j <= 0)
      {
        localObject = paramMMNeat7extView.getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new d(paramMMNeat7extView, paramInt2));
        }
        switch (paramInt2)
        {
        default: 
          if (paramInt2 == 1) {
            i = com.tencent.mm.cd.a.ms(paramContext) - com.tencent.mm.cd.a.fromDPToPix(paramContext, 136);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localObject = paramContext.getResources().getDrawable(paramInt1);
      paramInt1 = (int)paramMMNeat7extView.getTextSize();
      paramInt2 = ((Drawable)localObject).getIntrinsicWidth() * paramInt1 / ((Drawable)localObject).getIntrinsicHeight();
      ((Drawable)localObject).setBounds(0, 0, paramInt2, paramInt1);
      float f1 = paramInt2;
      float f2 = com.tencent.mm.cd.a.fromDPToPix(paramContext, 9);
      paramMMNeat7extView.a(TextUtils.TruncateAt.END, f1 + f2);
      paramContext = paramMMNeat7extView.pE(i, 2147483647);
      if (paramContext == null) {
        break label548;
      }
      paramInt1 = paramContext.aGN(paramMMNeat7extView.getMaxLines() - 1);
      if (paramInt1 > 0) {
        break label499;
      }
      s.s(localObject, "drawable");
      a(paramMMNeat7extView, paramCharSequence, (Drawable)localObject);
      AppMethodBeat.o(123732);
      return;
      if (((Map)vtC).containsKey(Integer.valueOf(paramInt2)))
      {
        localObject = vtC.get(Integer.valueOf(paramInt2));
        s.checkNotNull(localObject);
        s.s(localObject, "widthMap[scene]!!");
        j = ((Number)localObject).intValue();
        break;
      }
      ((Map)vtC).put(Integer.valueOf(paramInt2), Integer.valueOf(0));
      j = 0;
      break;
      i = com.tencent.mm.cd.a.ms(paramContext) - com.tencent.mm.cd.a.fromDPToPix(paramContext, 48);
      continue;
      switch (paramInt2)
      {
      default: 
        if (paramInt2 == 3) {
          i = com.tencent.mm.cd.a.ms(paramContext) - com.tencent.mm.cd.a.fromDPToPix(paramContext, 136);
        }
        break;
      case 2: 
      case 21: 
        i = com.tencent.mm.cd.a.ms(paramContext) - com.tencent.mm.cd.a.fromDPToPix(paramContext, 64);
        continue;
        switch (paramInt2)
        {
        default: 
          if (paramInt2 == 5) {
            i = com.tencent.mm.cd.a.ms(paramContext) - com.tencent.mm.cd.a.fromDPToPix(paramContext, 144);
          }
          break;
        case 4: 
        case 41: 
          i = com.tencent.mm.cd.a.ms(paramContext) - com.tencent.mm.cd.a.fromDPToPix(paramContext, 64);
          continue;
          i = com.tencent.mm.cd.a.ms(paramContext) - com.tencent.mm.cd.a.fromDPToPix(paramContext, 64);
        }
        break;
      }
    }
    label499:
    paramContext = (CharSequence)s.X(paramCharSequence.subSequence(0, paramCharSequence.length() - paramInt1).toString(), "…");
    s.s(localObject, "drawable");
    a(paramMMNeat7extView, paramContext, (Drawable)localObject);
    AppMethodBeat.o(123732);
    return;
    label548:
    s.s(localObject, "drawable");
    a(paramMMNeat7extView, paramCharSequence, (Drawable)localObject);
    AppMethodBeat.o(123732);
  }
  
  public static void a(View paramView, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(260932);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(260932);
      return;
    }
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new a.c(paramBoolean1, paramBoolean2, paramFloat));
    }
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    AppMethodBeat.o(260932);
  }
  
  private static void a(MMNeat7extView paramMMNeat7extView, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(123733);
    s.u(paramMMNeat7extView, "tv");
    s.u(paramCharSequence, "text");
    s.u(paramDrawable, "drawable");
    paramMMNeat7extView.a(TextUtils.TruncateAt.END, 0.0F);
    Object localObject = new com.tencent.mm.ui.widget.a(paramDrawable, 1);
    paramDrawable = new SpannableString((CharSequence)"@");
    paramDrawable.setSpan(localObject, 0, 1, 33);
    localObject = paramMMNeat7extView.getContext();
    s.s(localObject, "tv.context");
    paramMMNeat7extView.aZ(TextUtils.concat(new CharSequence[] { paramCharSequence, (CharSequence)ad((Context)localObject, (int)paramMMNeat7extView.getTextSize()), (CharSequence)paramDrawable }));
    paramMMNeat7extView.setContentDescription((CharSequence)(paramMMNeat7extView.jPy() + 65292 + paramMMNeat7extView.getContext().getResources().getString(com.tencent.mm.plugin.bizui.a.d.mp_pay_content)));
    AppMethodBeat.o(123733);
  }
  
  private static SpannableString ad(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(123734);
    Object localObject = paramContext.getResources().getDrawable(com.tencent.mm.plugin.bizui.a.b.mm_trans);
    ((Drawable)localObject).setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(paramContext, 8), paramInt);
    paramContext = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
    localObject = new SpannableString((CharSequence)"@");
    ((SpannableString)localObject).setSpan(paramContext, 0, 1, 33);
    AppMethodBeat.o(123734);
    return localObject;
  }
  
  public static int ae(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(260921);
    if (Float.compare(com.tencent.mm.cd.a.getScaleSize(paramContext), com.tencent.mm.cd.a.mf(paramContext)) > 0)
    {
      if (paramInt < 2)
      {
        paramInt = com.tencent.mm.plugin.bizui.a.b.green_unread_count_shape_large_circle;
        AppMethodBeat.o(260921);
        return paramInt;
      }
      paramInt = com.tencent.mm.plugin.bizui.a.b.biz_green_unread_count_shape_large;
      AppMethodBeat.o(260921);
      return paramInt;
    }
    if (paramInt < 2)
    {
      paramInt = com.tencent.mm.plugin.bizui.a.b.biz_green_unread_count_shape_circle;
      AppMethodBeat.o(260921);
      return paramInt;
    }
    paramInt = com.tencent.mm.plugin.bizui.a.b.biz_green_unread_count_shape;
    AppMethodBeat.o(260921);
    return paramInt;
  }
  
  public static boolean daI()
  {
    AppMethodBeat.i(260879);
    boolean bool = ((Boolean)vtD.getValue()).booleanValue();
    AppMethodBeat.o(260879);
    return bool;
  }
  
  public static boolean daJ()
  {
    AppMethodBeat.i(260885);
    boolean bool = ((Boolean)vtE.getValue()).booleanValue();
    AppMethodBeat.o(260885);
    return bool;
  }
  
  public static int fK(Context paramContext)
  {
    AppMethodBeat.i(260923);
    s.u(paramContext, "context");
    try
    {
      i = ao.mX(paramContext).width;
      AppMethodBeat.o(260923);
      return i;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BizViewUtils", (Throwable)paramContext, "getRealScreenWidth exception", new Object[0]);
        int i = 0;
      }
    }
  }
  
  public static int j(View paramView1, View paramView2)
  {
    AppMethodBeat.i(123731);
    if ((paramView1 == null) || (paramView2 == null) || (paramView1 == paramView2))
    {
      AppMethodBeat.o(123731);
      return 0;
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (paramView2 == paramView1) {
        break;
      }
      i += paramView2.getTop();
      Log.v("MicroMsg.BizViewUtils", "alvinluo getViewTop top: %d", new Object[] { Integer.valueOf(i) });
      j = i;
      if (!(paramView2.getParent() instanceof View)) {
        break;
      }
      paramView2 = paramView2.getParent();
      if (paramView2 == null)
      {
        paramView1 = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(123731);
        throw paramView1;
      }
      paramView2 = (View)paramView2;
    }
    AppMethodBeat.o(123731);
    return j;
  }
  
  public static void o(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(260924);
    if (paramView != null)
    {
      if (paramBoolean)
      {
        z.p(paramView, 1);
        AppMethodBeat.o(260924);
        return;
      }
      z.p(paramView, 2);
    }
    AppMethodBeat.o(260924);
  }
  
  public static void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260926);
    if (paramView == null)
    {
      AppMethodBeat.o(260926);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(260926);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/bizui/util/BizViewUtils$setTitleEndWithPayIcon$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "ui-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ViewTreeObserver.OnPreDrawListener
  {
    d(MMNeat7extView paramMMNeat7extView, int paramInt) {}
    
    private static final void a(int paramInt, MMNeat7extView paramMMNeat7extView)
    {
      AppMethodBeat.i(260852);
      s.u(paramMMNeat7extView, "$tv");
      a locala = a.vtB;
      a.gr(paramInt, paramMMNeat7extView.getWidth());
      AppMethodBeat.o(260852);
    }
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(123730);
      ViewTreeObserver localViewTreeObserver = this.vtK.getViewTreeObserver();
      if (localViewTreeObserver != null) {
        localViewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      }
      this.vtK.post(new a.d..ExternalSyntheticLambda0(paramInt2, this.vtK));
      AppMethodBeat.o(123730);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.a
 * JD-Core Version:    0.7.0.1
 */