package com.tencent.mm.plugin.bizui.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/bizui/util/BizViewUtils;", "", "()V", "TAG", "", "TITLE_SCENE_MP_CHAT", "", "TITLE_SCENE_MP_CHAT_COVER_TITLE", "TITLE_SCENE_MP_CHAT_ITEM", "TITLE_SCENE_PROFILE", "TITLE_SCENE_PROFILE_COVER_TITLE", "TITLE_SCENE_PROFILE_ITEM", "TITLE_SCENE_TIME_LINE", "TITLE_SCENE_TIME_LINE_COVER_TITLE", "TITLE_SCENE_TIME_LINE_ITEM", "optionSearchOpen", "", "getOptionSearchOpen", "()Z", "optionSearchOpen$delegate", "Lkotlin/Lazy;", "widthMap", "Ljava/util/HashMap;", "getWidthMap", "()Ljava/util/HashMap;", "setWidthMap", "(Ljava/util/HashMap;)V", "appendIcon", "", "tv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "", "drawable", "Landroid/graphics/drawable/Drawable;", "padding", "expandTouchArea", "parent", "Landroid/view/ViewParent;", "v", "Landroid/view/View;", "x", "y", "getDefaultTitleWidth", "scene", "context", "Landroid/content/Context;", "getGreenUnreadCountShape", "textSize", "getPaddingSpan", "Landroid/text/SpannableString;", "size", "getRealScreenWidth", "getTitleWidth", "getViewTop", "root", "target", "isCoverTitle", "setAccessibilityFocusable", "view", "focused", "setTitleEndWithPayIcon", "icon", "setTitleWidth", "width", "setViewSize", "height", "ui-biz_release"})
public final class a
{
  private static HashMap<Integer, Integer> shE;
  private static final f shF;
  public static final a shG;
  
  static
  {
    AppMethodBeat.i(123735);
    shG = new a();
    shE = new HashMap();
    shF = g.ar((kotlin.g.a.a)a.a.shH);
    AppMethodBeat.o(123735);
  }
  
  public static boolean Go(int paramInt)
  {
    return (paramInt == 11) || (paramInt == 21) || (paramInt == 41);
  }
  
  private static SpannableString W(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(123734);
    Object localObject = paramContext.getResources().getDrawable(com.tencent.mm.plugin.bizui.a.b.mm_trans);
    ((Drawable)localObject).setBounds(0, 0, com.tencent.mm.ci.a.fromDPToPix(paramContext, 8), paramInt);
    paramContext = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
    localObject = new SpannableString((CharSequence)"@");
    ((SpannableString)localObject).setSpan(paramContext, 0, 1, 33);
    AppMethodBeat.o(123734);
    return localObject;
  }
  
  public static int X(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(195685);
    if (Float.compare(com.tencent.mm.ci.a.ez(paramContext), com.tencent.mm.ci.a.kd(paramContext)) > 0)
    {
      if (paramInt < 2)
      {
        paramInt = com.tencent.mm.plugin.bizui.a.b.green_unread_count_shape_large_circle;
        AppMethodBeat.o(195685);
        return paramInt;
      }
      paramInt = com.tencent.mm.plugin.bizui.a.b.biz_green_unread_count_shape_large;
      AppMethodBeat.o(195685);
      return paramInt;
    }
    if (paramInt < 2)
    {
      paramInt = com.tencent.mm.plugin.bizui.a.b.biz_green_unread_count_shape_circle;
      AppMethodBeat.o(195685);
      return paramInt;
    }
    paramInt = com.tencent.mm.plugin.bizui.a.b.biz_green_unread_count_shape;
    AppMethodBeat.o(195685);
    return paramInt;
  }
  
  public static void a(Context paramContext, MMNeat7extView paramMMNeat7extView, int paramInt1, CharSequence paramCharSequence, final int paramInt2)
  {
    AppMethodBeat.i(123732);
    p.k(paramContext, "context");
    p.k(paramMMNeat7extView, "tv");
    p.k(paramCharSequence, "text");
    paramMMNeat7extView.aL(paramCharSequence);
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
          ((ViewTreeObserver)localObject).addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new b(paramMMNeat7extView, paramInt2));
        }
        if ((paramInt2 != 0) && (paramInt2 != 11)) {
          break label302;
        }
        i = com.tencent.mm.ci.a.kr(paramContext) - com.tencent.mm.ci.a.fromDPToPix(paramContext, 48);
      }
    }
    for (;;)
    {
      localObject = paramContext.getResources().getDrawable(paramInt1);
      paramInt1 = (int)paramMMNeat7extView.getTextSize();
      p.j(localObject, "drawable");
      paramInt2 = ((Drawable)localObject).getIntrinsicWidth() * paramInt1 / ((Drawable)localObject).getIntrinsicHeight();
      ((Drawable)localObject).setBounds(0, 0, paramInt2, paramInt1);
      float f1 = paramInt2;
      float f2 = com.tencent.mm.ci.a.fromDPToPix(paramContext, 9);
      paramMMNeat7extView.a(TextUtils.TruncateAt.END, f1 + f2);
      paramContext = paramMMNeat7extView.nH(i, 2147483647);
      if (paramContext == null) {
        break label499;
      }
      paramInt1 = paramContext.aAa(paramMMNeat7extView.getMaxLines() - 1);
      if (paramInt1 > 0) {
        break label445;
      }
      a(paramMMNeat7extView, paramCharSequence, (Drawable)localObject);
      AppMethodBeat.o(123732);
      return;
      if (((Map)shE).containsKey(Integer.valueOf(paramInt2)))
      {
        localObject = shE.get(Integer.valueOf(paramInt2));
        if (localObject == null) {
          p.iCn();
        }
        j = ((Number)localObject).intValue();
        break;
      }
      ((Map)shE).put(Integer.valueOf(paramInt2), Integer.valueOf(0));
      j = 0;
      break;
      label302:
      if (paramInt2 == 1) {
        i = com.tencent.mm.ci.a.kr(paramContext) - com.tencent.mm.ci.a.fromDPToPix(paramContext, 136);
      } else if ((paramInt2 == 2) || (paramInt2 == 21)) {
        i = com.tencent.mm.ci.a.kr(paramContext) - com.tencent.mm.ci.a.fromDPToPix(paramContext, 64);
      } else if (paramInt2 == 3) {
        i = com.tencent.mm.ci.a.kr(paramContext) - com.tencent.mm.ci.a.fromDPToPix(paramContext, 136);
      } else if ((paramInt2 == 4) || (paramInt2 == 41)) {
        i = com.tencent.mm.ci.a.kr(paramContext) - com.tencent.mm.ci.a.fromDPToPix(paramContext, 64);
      } else if (paramInt2 == 5) {
        i = com.tencent.mm.ci.a.kr(paramContext) - com.tencent.mm.ci.a.fromDPToPix(paramContext, 144);
      } else {
        i = com.tencent.mm.ci.a.kr(paramContext) - com.tencent.mm.ci.a.fromDPToPix(paramContext, 64);
      }
    }
    label445:
    paramContext = paramCharSequence.subSequence(0, paramCharSequence.length() - paramInt1).toString();
    a(paramMMNeat7extView, (CharSequence)(paramContext + '…'), (Drawable)localObject);
    AppMethodBeat.o(123732);
    return;
    label499:
    a(paramMMNeat7extView, paramCharSequence, (Drawable)localObject);
    AppMethodBeat.o(123732);
  }
  
  private static void a(MMNeat7extView paramMMNeat7extView, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    AppMethodBeat.i(123733);
    p.k(paramMMNeat7extView, "tv");
    p.k(paramCharSequence, "text");
    p.k(paramDrawable, "drawable");
    paramMMNeat7extView.a(TextUtils.TruncateAt.END, 0.0F);
    Object localObject = new com.tencent.mm.ui.widget.a(paramDrawable, 1);
    paramDrawable = new SpannableString((CharSequence)"@");
    paramDrawable.setSpan(localObject, 0, 1, 33);
    localObject = paramMMNeat7extView.getContext();
    p.j(localObject, "tv.context");
    paramMMNeat7extView.aL(TextUtils.concat(new CharSequence[] { paramCharSequence, (CharSequence)W((Context)localObject, (int)paramMMNeat7extView.getTextSize()), (CharSequence)paramDrawable }));
    AppMethodBeat.o(123733);
  }
  
  public static boolean cxR()
  {
    AppMethodBeat.i(195664);
    boolean bool = ((Boolean)shF.getValue()).booleanValue();
    AppMethodBeat.o(195664);
    return bool;
  }
  
  public static int eO(Context paramContext)
  {
    AppMethodBeat.i(195689);
    p.k(paramContext, "context");
    try
    {
      i = ak.kU(paramContext).width;
      AppMethodBeat.o(195689);
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
        paramView1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(123731);
        throw paramView1;
      }
      paramView2 = (View)paramView2;
    }
    AppMethodBeat.o(123731);
    return j;
  }
  
  public static void n(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(195691);
    if (paramView != null)
    {
      if (paramBoolean)
      {
        w.p(paramView, 1);
        AppMethodBeat.o(195691);
        return;
      }
      w.p(paramView, 2);
    }
    AppMethodBeat.o(195691);
  }
  
  public static void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195694);
    if (paramView == null)
    {
      AppMethodBeat.o(195694);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(195694);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/bizui/util/BizViewUtils$setTitleEndWithPayIcon$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "ui-biz_release"})
  public static final class b
    implements ViewTreeObserver.OnPreDrawListener
  {
    b(MMNeat7extView paramMMNeat7extView, int paramInt) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(123730);
      ViewTreeObserver localViewTreeObserver = this.shI.getViewTreeObserver();
      if (localViewTreeObserver != null) {
        localViewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      }
      this.shI.post((Runnable)new a(this));
      AppMethodBeat.o(123730);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(123729);
        a locala = a.shG;
        a.fz(this.shJ.$scene, this.shJ.shI.getWidth());
        AppMethodBeat.o(123729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.a
 * JD-Core Version:    0.7.0.1
 */