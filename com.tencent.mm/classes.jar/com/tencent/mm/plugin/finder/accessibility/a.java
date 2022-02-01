package com.tencent.mm.plugin.finder.accessibility;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.w.a.a.a.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderAccessibilityUtil;", "", "()V", "checkIfOverMaxTextScale", "", "context", "Landroid/content/Context;", "textView", "Landroid/widget/TextView;", "originSize", "", "maxScale", "getAuthText", "", "authType", "", "getBadgeInfoText", "", "badgeInfos", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "getFontSizeWithoutScale", "fontSize", "getLiveMaxTextScale", "getMediaTypeText", "mediaType", "setContentDescription", "root", "Landroid/view/View;", "contentDesc", "withOutScale", "adjustWidthHeight", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Ate;
  
  static
  {
    AppMethodBeat.i(334038);
    Ate = new a();
    AppMethodBeat.o(334038);
  }
  
  public static CharSequence am(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(334000);
    s.u(paramContext, "context");
    switch (paramInt)
    {
    default: 
      paramContext = (CharSequence)"";
      AppMethodBeat.o(334000);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(a.i.finder_auth_enterprise2);
      s.s(paramContext, "{\n                 conte…terprise2)\n             }");
      paramContext = (CharSequence)paramContext;
      AppMethodBeat.o(334000);
      return paramContext;
    }
    paramContext = paramContext.getString(a.i.finder_auth_personal2);
    s.s(paramContext, "{\n                 conte…personal2)\n             }");
    paramContext = (CharSequence)paramContext;
    AppMethodBeat.o(334000);
    return paramContext;
  }
  
  public static CharSequence an(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(334010);
    s.u(paramContext, "context");
    switch (paramInt)
    {
    default: 
      paramContext = (CharSequence)"";
      AppMethodBeat.o(334010);
      return paramContext;
    case 4: 
    case 3002: 
      paramContext = paramContext.getString(a.i.finder_media_type_video);
      s.s(paramContext, "{\n                contex…type_video)\n            }");
      paramContext = (CharSequence)paramContext;
      AppMethodBeat.o(334010);
      return paramContext;
    case 2: 
    case 3001: 
      paramContext = paramContext.getString(a.i.finder_media_type_image);
      s.s(paramContext, "{\n                contex…type_image)\n            }");
      paramContext = (CharSequence)paramContext;
      AppMethodBeat.o(334010);
      return paramContext;
    }
    paramContext = paramContext.getString(a.i.finder_media_type_live);
    s.s(paramContext, "{\n                contex…_type_live)\n            }");
    paramContext = (CharSequence)paramContext;
    AppMethodBeat.o(334010);
    return paramContext;
  }
  
  public static String b(Context paramContext, List<? extends bfl> paramList)
  {
    AppMethodBeat.i(334024);
    s.u(paramContext, "context");
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(334024);
      return "";
    }
    localObject = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      bfl localbfl = (bfl)paramList.next();
      i = localbfl.ZPr;
      switch (localbfl.ZPp)
      {
      default: 
        break;
      case 1: 
        if (i > 0) {
          ((StringBuilder)localObject).append(paramContext.getResources().getString(a.i.finder_live_msg_badge_level_prefix)).append(i).append(" ");
        }
        break;
      case 2: 
        if (i > 0) {
          ((StringBuilder)localObject).append(paramContext.getResources().getString(a.i.finder_live_badge_level, new Object[] { Integer.valueOf(i) }));
        }
        break;
      }
    }
    paramContext = ((StringBuilder)localObject).toString();
    s.s(paramContext, "sb.toString()");
    AppMethodBeat.o(334024);
    return paramContext;
  }
  
  public static float g(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(333967);
    s.u(paramContext, "context");
    Object localObject1 = paramContext.getSystemService("window");
    if (localObject1 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(333967);
      throw paramContext;
    }
    Object localObject2 = (WindowManager)localObject1;
    localObject1 = new DisplayMetrics();
    localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    if (localObject2 != null) {
      ((Display)localObject2).getMetrics((DisplayMetrics)localObject1);
    }
    paramFloat = ((DisplayMetrics)localObject1).density * paramFloat / paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(333967);
    return paramFloat;
  }
  
  private static final void q(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(334036);
    s.u(paramView, "$this_withOutScale");
    Object localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int i = (int)g((Context)localObject1, paramView.getPaddingLeft());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int j = (int)g((Context)localObject1, paramView.getPaddingRight());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int k = (int)g((Context)localObject1, paramView.getPaddingTop());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    paramView.setPadding(i, k, j, (int)g((Context)localObject1, paramView.getPaddingBottom()));
    localObject1 = paramView.getLayoutParams();
    Object localObject2;
    if (paramBoolean)
    {
      if (((ViewGroup.LayoutParams)localObject1).width > 0)
      {
        localObject2 = paramView.getContext();
        s.s(localObject2, "context");
        ((ViewGroup.LayoutParams)localObject1).width = ((int)g((Context)localObject2, ((ViewGroup.LayoutParams)localObject1).width));
      }
      if (((ViewGroup.LayoutParams)localObject1).height > 0)
      {
        localObject2 = paramView.getContext();
        s.s(localObject2, "context");
        ((ViewGroup.LayoutParams)localObject1).height = ((int)g((Context)localObject2, ((ViewGroup.LayoutParams)localObject1).height));
      }
    }
    if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      Context localContext = paramView.getContext();
      s.s(localContext, "context");
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ((int)g(localContext, ((ViewGroup.MarginLayoutParams)localObject1).leftMargin));
      localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = ((int)g(localContext, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin));
      localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)g(localContext, ((ViewGroup.MarginLayoutParams)localObject1).topMargin));
      localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = ((int)g(localContext, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin));
      localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((ViewGroup.MarginLayoutParams)localObject2).setMarginStart((int)g(localContext, ((ViewGroup.MarginLayoutParams)localObject1).getMarginStart()));
      localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((ViewGroup.MarginLayoutParams)localObject2).setMarginEnd((int)g(localContext, ((ViewGroup.MarginLayoutParams)localObject1).getMarginEnd()));
    }
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    AppMethodBeat.o(334036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.a
 * JD-Core Version:    0.7.0.1
 */