package com.tencent.mm.accessibility.core.area;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.core.provider.Provider;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/area/AreaProvider;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "TAG", "", "buildAccessibilityProvider", "Landroid/view/accessibility/AccessibilityNodeProvider;", "host", "Landroid/view/View;", "dealOnViewInflateAsync", "", "view", "defaultDealExpand", "expand", "findConfigRect", "", "getAuthority", "", "getDefaultViewExpand", "getDp", "px", "getPx", "dp", "isDisExpand", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AreaProvider
  extends Provider
{
  public static final AreaProvider INSTANCE;
  public static final String TAG = "MicroMsg.Acc.AreaProvider";
  
  static
  {
    AppMethodBeat.i(234424);
    INSTANCE = new AreaProvider();
    AppMethodBeat.o(234424);
  }
  
  private final void defaultDealExpand(View paramView)
  {
    AppMethodBeat.i(234376);
    int[] arrayOfInt = getDefaultViewExpand(paramView);
    if (arrayOfInt == null)
    {
      AppMethodBeat.o(234376);
      return;
    }
    logMsg("MicroMsg.Acc.AreaProvider", paramView, "expand " + Arrays.toString(arrayOfInt) + " defaultDealExpand");
    ViewTouchAreaExpander.INSTANCE.expand(paramView, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    AppMethodBeat.o(234376);
  }
  
  private final int[] findConfigRect(View paramView)
  {
    AppMethodBeat.i(234386);
    final ah.f localf = new ah.f();
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234346);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        Object localObject1 = (Map)paramAnonymousMMBaseAccessibilityConfig.getViewRootAreaMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localObject1 == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234346);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        Object localObject2 = paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, p.p((Iterable)((Map)localObject1).keySet()));
        if (localObject2 == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234346);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        paramAnonymousMMBaseAccessibilityConfig = (int[])((Map)localObject1).get(Integer.valueOf(((View)localObject2).getId()));
        if (paramAnonymousMMBaseAccessibilityConfig == null)
        {
          localObject1 = (int[])((Map)localObject1).get(AreaProvider.INSTANCE.getLayoutId((View)localObject2));
          paramAnonymousMMBaseAccessibilityConfig = (MMBaseAccessibilityConfig)localObject1;
          if (localObject1 == null)
          {
            paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
            AppMethodBeat.o(234346);
            return paramAnonymousMMBaseAccessibilityConfig;
          }
        }
        localObject1 = localf;
        paramAnonymousMMBaseAccessibilityConfig = paramAnonymousMMBaseAccessibilityConfig.clone();
        localObject2 = (int[])paramAnonymousMMBaseAccessibilityConfig;
        localObject2[0] = AreaProvider.access$getPx(AreaProvider.INSTANCE, localObject2[0]);
        localObject2[1] = AreaProvider.access$getPx(AreaProvider.INSTANCE, localObject2[1]);
        localObject2[2] = AreaProvider.access$getPx(AreaProvider.INSTANCE, localObject2[2]);
        localObject2[3] = AreaProvider.access$getPx(AreaProvider.INSTANCE, localObject2[3]);
        localObject2 = ah.aiuX;
        ((ah.f)localObject1).aqH = paramAnonymousMMBaseAccessibilityConfig;
        paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
        AppMethodBeat.o(234346);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    paramView = (int[])localf.aqH;
    AppMethodBeat.o(234386);
    return paramView;
  }
  
  private final int getDp(int paramInt)
  {
    AppMethodBeat.i(234402);
    paramInt = a.K(MMApplicationContext.getContext(), paramInt);
    AppMethodBeat.o(234402);
    return paramInt;
  }
  
  private final int getPx(int paramInt)
  {
    AppMethodBeat.i(234395);
    paramInt = a.fromDPToPix(MMApplicationContext.getContext(), paramInt);
    AppMethodBeat.o(234395);
    return paramInt;
  }
  
  private final boolean isDisExpand(View paramView)
  {
    AppMethodBeat.i(234362);
    boolean bool = getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234332);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        List localList = (List)paramAnonymousMMBaseAccessibilityConfig.getViewRootDisableExpandList$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localList == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234332);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        if (paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, localList) != null) {}
        for (boolean bool = true;; bool = false)
        {
          AppMethodBeat.o(234332);
          return Boolean.valueOf(bool);
        }
      }
    });
    AppMethodBeat.o(234362);
    return bool;
  }
  
  public final AccessibilityNodeProvider buildAccessibilityProvider(View paramView)
  {
    AppMethodBeat.i(234436);
    s.u(paramView, "host");
    if ((isDisExpand(paramView)) || (!AccUtil.INSTANCE.canExpand()))
    {
      AppMethodBeat.o(234436);
      return null;
    }
    int[] arrayOfInt = findConfigRect(paramView);
    if (arrayOfInt == null)
    {
      arrayOfInt = getDefaultViewExpand(paramView);
      if (arrayOfInt == null)
      {
        AppMethodBeat.o(234436);
        return null;
      }
    }
    for (;;)
    {
      paramView = (AccessibilityNodeProvider)new VisualAreaNodeProvider(paramView, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
      AppMethodBeat.o(234436);
      return paramView;
    }
  }
  
  public final void dealOnViewInflateAsync(View paramView)
  {
    AppMethodBeat.i(234430);
    s.u(paramView, "view");
    if ((AccUtil.INSTANCE.canExpand()) && ((paramView.isClickable()) || (paramView.isLongClickable()))) {
      expand(paramView);
    }
    AppMethodBeat.o(234430);
  }
  
  public final void expand(View paramView)
  {
    AppMethodBeat.i(234434);
    s.u(paramView, "view");
    if (paramView.getVisibility() != 0)
    {
      AppMethodBeat.o(234434);
      return;
    }
    if (isDisExpand(paramView))
    {
      AppMethodBeat.o(234434);
      return;
    }
    Object localObject = findConfigRect(paramView);
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        defaultDealExpand(paramView);
      }
      AppMethodBeat.o(234434);
      return;
      ViewTouchAreaExpander.INSTANCE.expand(paramView, localObject[0], localObject[1], localObject[2], localObject[3]);
    }
  }
  
  public final int getAuthority()
  {
    AppMethodBeat.i(234438);
    if (AccUtil.INSTANCE.canExpand())
    {
      AppMethodBeat.o(234438);
      return 2;
    }
    AppMethodBeat.o(234438);
    return 0;
  }
  
  public final int[] getDefaultViewExpand(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(234435);
    s.u(paramView, "view");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    paramView = new int[4];
    int i = 0;
    while (i < 4)
    {
      paramView[i] = 0;
      i += 1;
    }
    i = getDp(localRect.width());
    int k = getDp(localRect.height());
    if (i < 44)
    {
      paramView[0] = getPx((44 - i) / 2);
      paramView[2] = getPx((44 - i) / 2);
    }
    i = j;
    if (k < 44)
    {
      paramView[1] = getPx((44 - k) / 2);
      paramView[3] = getPx((44 - k) / 2);
      i = j;
    }
    while (i < 4)
    {
      j = paramView[i];
      i += 1;
      if (j != 0)
      {
        AppMethodBeat.o(234435);
        return paramView;
      }
    }
    AppMethodBeat.o(234435);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.area.AreaProvider
 * JD-Core Version:    0.7.0.1
 */