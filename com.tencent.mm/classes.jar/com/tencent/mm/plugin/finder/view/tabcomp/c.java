package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "title", "", "(Ljava/lang/String;)V", "titleId", "", "(I)V", "isFirstValidSelect", "", "isFirstValidUnSelect", "isTabSelected", "isUnSelected", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "firstValidUnSelect", "getLastSelectTabIndex", "getLayoutId", "getTitle", "context", "Landroid/content/Context;", "isShouldSelect", "isSelected", "onTabInflated", "onTabStatusChanged", "setTabRedDot", "redDotText", "setTabTitle", "setTextBold", "isBold", "setTextColor", "Companion", "plugin-finder_release"})
public class c
  extends a
{
  public static final a BfT;
  private boolean BfP;
  private boolean BfQ;
  private boolean BfR;
  private boolean BfS;
  private String title;
  private TextView titleTv;
  private ImageView zCx;
  private int zDq;
  
  static
  {
    AppMethodBeat.i(280963);
    BfT = new a((byte)0);
    AppMethodBeat.o(280963);
  }
  
  public c(int paramInt)
  {
    this.title = "";
    this.zDq = paramInt;
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(280962);
    this.title = "";
    this.title = paramString;
    AppMethodBeat.o(280962);
  }
  
  private final boolean ry(boolean paramBoolean)
  {
    AppMethodBeat.i(280961);
    if (paramBoolean) {
      this.BfQ = true;
    }
    while ((ejX() == 0) || (this.index != 0))
    {
      AppMethodBeat.o(280961);
      return true;
      this.BfS = true;
    }
    AppMethodBeat.o(280961);
    return false;
  }
  
  public void A(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(280958);
    p.k(paramViewGroup, "tabView");
    Log.i("Finder.FinderTab", "firstValidUnSelected");
    AppMethodBeat.o(280958);
  }
  
  public final void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(280956);
    p.k(paramViewGroup, "tabView");
    rx(paramBoolean);
    if (paramBoolean)
    {
      if ((!this.BfP) && ((this.BfQ) || (ry(paramBoolean))))
      {
        y(paramViewGroup);
        this.BfP = true;
        AppMethodBeat.o(280956);
      }
    }
    else if ((!this.BfR) && ((this.BfS) || (ry(paramBoolean))))
    {
      A(paramViewGroup);
      this.BfR = true;
    }
    AppMethodBeat.o(280956);
  }
  
  public void aGC(String paramString) {}
  
  public int ejX()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return b.g.finder_msg_normal_tab_text;
  }
  
  public final TextView getTitleTv()
  {
    return this.titleTv;
  }
  
  public void od(boolean paramBoolean)
  {
    AppMethodBeat.i(280960);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localContext = localTextView.getContext();
        p.j(localContext, "context");
        localTextView.setTextColor(localContext.getResources().getColor(b.c.normal_text_color));
        AppMethodBeat.o(280960);
        return;
      }
      Context localContext = localTextView.getContext();
      p.j(localContext, "context");
      localTextView.setTextColor(localContext.getResources().getColor(b.c.desc_text_color));
      AppMethodBeat.o(280960);
      return;
    }
    AppMethodBeat.o(280960);
  }
  
  public final void rx(boolean paramBoolean)
  {
    AppMethodBeat.i(280955);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      Object localObject = localTextView.getContext();
      p.j(localObject, "this.context");
      p.k(localObject, "context");
      if (!Util.isNullOrNil(this.title))
      {
        localObject = this.title;
        localTextView.setText((CharSequence)localObject);
        od(paramBoolean);
        localObject = this.titleTv;
        if (localObject == null) {
          break label140;
        }
        if (paramBoolean)
        {
          ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(280955);
        }
      }
      else
      {
        if (this.zDq > 0) {}
        for (localObject = ((Context)localObject).getResources().getString(this.zDq);; localObject = "")
        {
          p.j(localObject, "if (titleId > 0) {\n     …\n            \"\"\n        }");
          break;
        }
      }
      ar.b((Paint)((TextView)localObject).getPaint());
      AppMethodBeat.o(280955);
      return;
      label140:
      AppMethodBeat.o(280955);
      return;
    }
    AppMethodBeat.o(280955);
  }
  
  public final void w(TextView paramTextView)
  {
    this.titleTv = paramTextView;
  }
  
  public void y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(280959);
    p.k(paramViewGroup, "tabView");
    Log.i("Finder.FinderTab", "firstValidSelected");
    AppMethodBeat.o(280959);
  }
  
  public void z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(280952);
    if (paramViewGroup != null)
    {
      this.titleTv = ((TextView)paramViewGroup.findViewById(b.f.tabTitle));
      this.zCx = ((ImageView)paramViewGroup.findViewById(b.f.tabTitleImageRed));
      AppMethodBeat.o(280952);
      return;
    }
    AppMethodBeat.o(280952);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.c
 * JD-Core Version:    0.7.0.1
 */