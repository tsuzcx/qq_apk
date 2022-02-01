package com.tencent.mm.plugin.appbrand.widget.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/accessibility/WxaAccessibilityDelegate;", "Landroid/view/View$AccessibilityDelegate;", "view", "Landroid/view/View;", "role", "Ljava/lang/Class;", "contentDesc", "", "disablePosAnnounce", "", "focusable", "clickable", "clickAction", "checkedInvoker", "Lkotlin/Function0;", "expandBounds", "Landroid/graphics/Rect;", "(Landroid/view/View;Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroid/graphics/Rect;)V", "accessibilityNodeProvider", "com/tencent/mm/plugin/appbrand/widget/accessibility/WxaAccessibilityDelegate$accessibilityNodeProvider$2$1", "getAccessibilityNodeProvider", "()Lcom/tencent/mm/plugin/appbrand/widget/accessibility/WxaAccessibilityDelegate$accessibilityNodeProvider$2$1;", "accessibilityNodeProvider$delegate", "Lkotlin/Lazy;", "Ljava/lang/Boolean;", "tempRect", "Landroid/view/accessibility/AccessibilityNodeProvider;", "host", "onInitializeAccessibilityNodeInfo", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "Companion", "luggage-commons-widget_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends View.AccessibilityDelegate
{
  public static final a uyi;
  private static final b uyr;
  private static b uys;
  private final Rect aQJ;
  private final Boolean clickable;
  private final Class<? extends View> uyj;
  private final String uyk;
  private final boolean uyl;
  private final Boolean uym;
  private final String uyn;
  private final a<Boolean> uyo;
  private final Rect uyp;
  private final j uyq;
  private final View view;
  
  static
  {
    AppMethodBeat.i(323987);
    uyi = new a((byte)0);
    b localb = new b();
    uyr = localb;
    uys = (b)localb;
    AppMethodBeat.o(323987);
  }
  
  private c(View paramView, Class<? extends View> paramClass, String paramString1, boolean paramBoolean, Boolean paramBoolean1, Boolean paramBoolean2, String paramString2, a<Boolean> parama, Rect paramRect)
  {
    AppMethodBeat.i(323977);
    this.view = paramView;
    this.uyj = paramClass;
    this.uyk = paramString1;
    this.uyl = paramBoolean;
    this.uym = paramBoolean1;
    this.clickable = paramBoolean2;
    this.uyn = paramString2;
    this.uyo = parama;
    this.uyp = paramRect;
    this.aQJ = new Rect();
    this.uyq = k.a(o.aiuH, (a)new c(this));
    AppMethodBeat.o(323977);
  }
  
  public static final void a(View paramView, a<Boolean> parama, Integer paramInteger)
  {
    AppMethodBeat.i(323981);
    a.a(paramView, null, null, false, null, parama, null, paramInteger);
    AppMethodBeat.o(323981);
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(323979);
    s.u(paramb, "<set-?>");
    uys = paramb;
    AppMethodBeat.o(323979);
  }
  
  public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    AppMethodBeat.i(323988);
    c.c.1 local1 = (c.c.1)this.uyq.getValue();
    if (local1 == null)
    {
      paramView = super.getAccessibilityNodeProvider(paramView);
      AppMethodBeat.o(323988);
      return paramView;
    }
    paramView = (AccessibilityNodeProvider)local1;
    AppMethodBeat.o(323988);
    return paramView;
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(323989);
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if ((this.uyj != null) && (paramAccessibilityNodeInfo != null)) {
      paramAccessibilityNodeInfo.setClassName((CharSequence)this.uyj.getName());
    }
    if ((this.uyk != null) && (paramAccessibilityNodeInfo != null)) {
      paramAccessibilityNodeInfo.setContentDescription((CharSequence)this.uyk);
    }
    if ((this.uyl) && (paramAccessibilityNodeInfo != null)) {
      paramAccessibilityNodeInfo.setCollectionInfo(null);
    }
    if ((this.uym != null) && (paramAccessibilityNodeInfo != null)) {
      paramAccessibilityNodeInfo.setFocusable(this.uym.booleanValue());
    }
    if ((this.clickable != null) && (paramAccessibilityNodeInfo != null)) {
      paramAccessibilityNodeInfo.setClickable(this.clickable.booleanValue());
    }
    if ((this.uyn != null) && (paramAccessibilityNodeInfo != null)) {
      paramAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, (CharSequence)this.uyn));
    }
    if (this.uyo != null)
    {
      boolean bool = ((Boolean)this.uyo.invoke()).booleanValue();
      if (paramAccessibilityNodeInfo != null) {
        paramAccessibilityNodeInfo.setCheckable(true);
      }
      if (paramAccessibilityNodeInfo != null) {
        paramAccessibilityNodeInfo.setChecked(bool);
      }
    }
    AppMethodBeat.o(323989);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/accessibility/WxaAccessibilityDelegate$Companion;", "", "()V", "DEFAULT_VIEW_TOUCH_AREA_EXPANDER", "com/tencent/mm/plugin/appbrand/widget/accessibility/WxaAccessibilityDelegate$Companion$DEFAULT_VIEW_TOUCH_AREA_EXPANDER$1", "Lcom/tencent/mm/plugin/appbrand/widget/accessibility/WxaAccessibilityDelegate$Companion$DEFAULT_VIEW_TOUCH_AREA_EXPANDER$1;", "TAG", "", "viewTouchAreaExpander", "Lcom/tencent/mm/plugin/appbrand/widget/accessibility/IViewTouchAreaExpander;", "getViewTouchAreaExpander$annotations", "getViewTouchAreaExpander", "()Lcom/tencent/mm/plugin/appbrand/widget/accessibility/IViewTouchAreaExpander;", "setViewTouchAreaExpander", "(Lcom/tencent/mm/plugin/appbrand/widget/accessibility/IViewTouchAreaExpander;)V", "attach", "", "view", "Landroid/view/View;", "role", "Ljava/lang/Class;", "contentDescStringId", "", "disablePosAnnounce", "", "focusable", "clickable", "clickActionStringId", "checkedInvoker", "Lkotlin/Function0;", "expandLeftDp", "expandRightDp", "expandTopDp", "expandBottomDp", "defaultExpandDimenId", "(Landroid/view/View;Ljava/lang/Class;Ljava/lang/Integer;ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "luggage-commons-widget_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(View paramView, Class<? extends View> paramClass, Integer paramInteger1, boolean paramBoolean, Integer paramInteger2, a<Boolean> parama, Integer paramInteger3, Integer paramInteger4)
    {
      AppMethodBeat.i(323976);
      s.u(paramView, "view");
      label46:
      int i;
      label65:
      int j;
      if (paramInteger1 != null)
      {
        paramInteger1 = paramView.getContext().getString(paramInteger1.intValue());
        if (paramInteger2 == null) {
          break label145;
        }
        paramInteger2 = paramView.getContext().getString(paramInteger2.intValue());
        if (paramInteger4 == null) {
          break label151;
        }
        i = bd.bs(paramView.getContext(), paramInteger4.intValue());
        if (paramInteger3 == null) {
          break label157;
        }
        j = bd.fromDPToPix(paramView.getContext(), paramInteger3.intValue());
        label84:
        if ((j != 0) || (i != 0) || (i != 0) || (i != 0)) {
          break label164;
        }
      }
      for (paramInteger3 = null;; paramInteger3 = new Rect(j, i, i, i))
      {
        paramView.setAccessibilityDelegate((View.AccessibilityDelegate)new c(paramView, paramClass, paramInteger1, paramBoolean, null, null, paramInteger2, parama, paramInteger3, (byte)0));
        AppMethodBeat.o(323976);
        return;
        paramInteger1 = null;
        break;
        label145:
        paramInteger2 = null;
        break label46;
        label151:
        i = 0;
        break label65;
        label157:
        j = i;
        break label84;
        label164:
        paramView.post(new c.a..ExternalSyntheticLambda0(paramView, j, i, i, i));
      }
    }
    
    private static final void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(323982);
      s.u(paramView, "$view");
      a locala = c.uyi;
      c.cOR().expand(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(323982);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/accessibility/WxaAccessibilityDelegate$Companion$DEFAULT_VIEW_TOUCH_AREA_EXPANDER$1", "Lcom/tencent/mm/plugin/appbrand/widget/accessibility/IViewTouchAreaExpander;", "expand", "", "view", "Landroid/view/View;", "expandLeftPx", "", "expandTopPx", "expandRightPx", "expandBottomPx", "luggage-commons-widget_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b
  {
    public final void expand(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(323974);
      s.u(paramView, "view");
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      localRect.left -= paramInt1;
      localRect.top -= paramInt2;
      localRect.right += paramInt3;
      localRect.bottom += paramInt4;
      Object localObject = paramView.getParent();
      if ((localObject instanceof View)) {}
      for (localObject = (View)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, paramView));
        }
        AppMethodBeat.o(323974);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/appbrand/widget/accessibility/WxaAccessibilityDelegate$accessibilityNodeProvider$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<1>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.a.c
 * JD-Core Version:    0.7.0.1
 */