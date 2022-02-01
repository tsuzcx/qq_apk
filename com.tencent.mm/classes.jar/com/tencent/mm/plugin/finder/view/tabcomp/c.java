package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "title", "", "(Ljava/lang/String;)V", "titleId", "", "(I)V", "isFirstValidSelect", "", "isFirstValidUnSelect", "isTabSelected", "isUnSelected", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "firstValidUnSelect", "getLastSelectTabIndex", "getLayoutId", "getTitle", "context", "Landroid/content/Context;", "isShouldSelect", "isSelected", "onTabInflated", "onTabStatusChanged", "setTabRedDot", "redDotText", "setTabTitle", "setTextBold", "isBold", "setTextColor", "Companion", "plugin-finder_release"})
public class c
  extends a
{
  public static final a wtC;
  private String title;
  protected TextView titleTv;
  protected ImageView uPX;
  private int uQk;
  private boolean wtA;
  private boolean wtB;
  private boolean wty;
  private boolean wtz;
  
  static
  {
    AppMethodBeat.i(255301);
    wtC = new a((byte)0);
    AppMethodBeat.o(255301);
  }
  
  public c(int paramInt)
  {
    this.title = "";
    this.uQk = paramInt;
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(255300);
    this.title = "";
    this.title = paramString;
    AppMethodBeat.o(255300);
  }
  
  private final boolean pf(boolean paramBoolean)
  {
    AppMethodBeat.i(255299);
    if (paramBoolean) {
      this.wtz = true;
    }
    while ((dHM() == 0) || (this.index != 0))
    {
      AppMethodBeat.o(255299);
      return true;
      this.wtB = true;
    }
    AppMethodBeat.o(255299);
    return false;
  }
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(255293);
    p.h(paramViewGroup, "tabView");
    pd(paramBoolean);
    if (paramBoolean)
    {
      if ((!this.wty) && ((this.wtz) || (pf(paramBoolean))))
      {
        t(paramViewGroup);
        this.wty = true;
        AppMethodBeat.o(255293);
      }
    }
    else if ((!this.wtA) && ((this.wtB) || (pf(paramBoolean))))
    {
      v(paramViewGroup);
      this.wtA = true;
    }
    AppMethodBeat.o(255293);
  }
  
  public void by(String paramString, boolean paramBoolean) {}
  
  public int dHM()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131494539;
  }
  
  public final String getTitle(Context paramContext)
  {
    AppMethodBeat.i(255298);
    p.h(paramContext, "context");
    if (!Util.isNullOrNil(this.title))
    {
      paramContext = this.title;
      AppMethodBeat.o(255298);
      return paramContext;
    }
    if (this.uQk > 0) {}
    for (paramContext = paramContext.getResources().getString(this.uQk);; paramContext = "")
    {
      p.g(paramContext, "if (titleId > 0) {\n     …\n            \"\"\n        }");
      AppMethodBeat.o(255298);
      return paramContext;
    }
  }
  
  public void pd(boolean paramBoolean)
  {
    AppMethodBeat.i(255292);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      Context localContext = localTextView.getContext();
      p.g(localContext, "this.context");
      localTextView.setText((CharSequence)getTitle(localContext));
      pe(paramBoolean);
      setTextBold(paramBoolean);
      AppMethodBeat.o(255292);
      return;
    }
    AppMethodBeat.o(255292);
  }
  
  public final void pe(boolean paramBoolean)
  {
    AppMethodBeat.i(255296);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localContext = localTextView.getContext();
        p.g(localContext, "context");
        localTextView.setTextColor(localContext.getResources().getColor(2131100904));
        AppMethodBeat.o(255296);
        return;
      }
      Context localContext = localTextView.getContext();
      p.g(localContext, "context");
      localTextView.setTextColor(localContext.getResources().getColor(2131100245));
      AppMethodBeat.o(255296);
      return;
    }
    AppMethodBeat.o(255296);
  }
  
  public final void setTextBold(boolean paramBoolean)
  {
    AppMethodBeat.i(255297);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        ao.a((Paint)localTextView.getPaint(), 0.8F);
        AppMethodBeat.o(255297);
        return;
      }
      ao.b((Paint)localTextView.getPaint());
      AppMethodBeat.o(255297);
      return;
    }
    AppMethodBeat.o(255297);
  }
  
  public void t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(255295);
    p.h(paramViewGroup, "tabView");
    Log.i("Finder.FinderTab", "firstValidSelected");
    AppMethodBeat.o(255295);
  }
  
  public void u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(255291);
    if (paramViewGroup != null)
    {
      this.titleTv = ((TextView)paramViewGroup.findViewById(2131308826));
      this.uPX = ((ImageView)paramViewGroup.findViewById(2131308830));
      AppMethodBeat.o(255291);
      return;
    }
    AppMethodBeat.o(255291);
  }
  
  public void v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(255294);
    p.h(paramViewGroup, "tabView");
    Log.i("Finder.FinderTab", "firstValidUnSelected");
    AppMethodBeat.o(255294);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.c
 * JD-Core Version:    0.7.0.1
 */