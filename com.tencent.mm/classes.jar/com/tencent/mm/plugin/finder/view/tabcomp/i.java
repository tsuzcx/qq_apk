package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "title", "", "(Ljava/lang/String;)V", "titleId", "", "(I)V", "(Ljava/lang/String;I)V", "isFirstValidSelect", "", "isFirstValidUnSelect", "isTabSelected", "isUnSelected", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "firstValidUnSelect", "getLastSelectTabIndex", "getLayoutId", "getTitle", "context", "Landroid/content/Context;", "isShouldSelect", "isSelected", "onTabInflated", "onTabStatusChanged", "setTabRedDot", "redDotText", "setTabTitle", "setTextBold", "isBold", "setTextColor", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class i
  extends g
{
  public static final a GJm;
  private ImageView EFo;
  private int EHx;
  private boolean GJn;
  private boolean GJo;
  private boolean GJp;
  private boolean GJq;
  private String title;
  private TextView titleTv;
  
  static
  {
    AppMethodBeat.i(345568);
    GJm = new a((byte)0);
    AppMethodBeat.o(345568);
  }
  
  public i(int paramInt)
  {
    this.title = "";
    this.EHx = paramInt;
  }
  
  public i(String paramString)
  {
    AppMethodBeat.i(345553);
    this.title = "";
    this.title = paramString;
    AppMethodBeat.o(345553);
  }
  
  public i(String paramString, byte paramByte)
  {
    AppMethodBeat.i(345559);
    this.title = "";
    this.title = paramString;
    this.EHx = -1;
    AppMethodBeat.o(345559);
  }
  
  private final boolean vh(boolean paramBoolean)
  {
    AppMethodBeat.i(345562);
    if (paramBoolean) {
      this.GJo = true;
    }
    while ((fmD() == 0) || (this.index != 0))
    {
      AppMethodBeat.o(345562);
      return true;
      this.GJq = true;
    }
    AppMethodBeat.o(345562);
    return false;
  }
  
  public void F(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345603);
    s.u(paramViewGroup, "tabView");
    Log.i("Finder.FinderTab", "firstValidSelected");
    AppMethodBeat.o(345603);
  }
  
  public void H(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345580);
    if (paramViewGroup != null)
    {
      this.titleTv = ((TextView)paramViewGroup.findViewById(e.e.tabTitle));
      this.EFo = ((ImageView)paramViewGroup.findViewById(e.e.tabTitleImageRed));
    }
    AppMethodBeat.o(345580);
  }
  
  public void J(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345598);
    s.u(paramViewGroup, "tabView");
    Log.i("Finder.FinderTab", "firstValidUnSelected");
    AppMethodBeat.o(345598);
  }
  
  public final void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345586);
    s.u(paramViewGroup, "tabView");
    vg(paramBoolean);
    if (paramBoolean)
    {
      if ((!this.GJn) && ((this.GJo) || (vh(paramBoolean))))
      {
        F(paramViewGroup);
        this.GJn = true;
        AppMethodBeat.o(345586);
      }
    }
    else if ((!this.GJp) && ((this.GJq) || (vh(paramBoolean))))
    {
      J(paramViewGroup);
      this.GJp = true;
    }
    AppMethodBeat.o(345586);
  }
  
  public void aCK(String paramString) {}
  
  public int fmD()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return e.f.finder_msg_normal_tab_text;
  }
  
  public final TextView getTitleTv()
  {
    return this.titleTv;
  }
  
  public final String ht(Context paramContext)
  {
    AppMethodBeat.i(345618);
    s.u(paramContext, "context");
    if (!Util.isNullOrNil(this.title))
    {
      paramContext = this.title;
      AppMethodBeat.o(345618);
      return paramContext;
    }
    if (this.EHx > 0)
    {
      paramContext = paramContext.getResources().getString(this.EHx);
      s.s(paramContext, "{\n            context.re…String(titleId)\n        }");
      AppMethodBeat.o(345618);
      return paramContext;
    }
    AppMethodBeat.o(345618);
    return "";
  }
  
  public void pC(boolean paramBoolean)
  {
    AppMethodBeat.i(345609);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      if (paramBoolean)
      {
        localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.normal_text_color));
        AppMethodBeat.o(345609);
        return;
      }
      localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.desc_text_color));
    }
    AppMethodBeat.o(345609);
  }
  
  public final void setTitleTv(TextView paramTextView)
  {
    this.titleTv = paramTextView;
  }
  
  public final void vg(boolean paramBoolean)
  {
    AppMethodBeat.i(345583);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      Context localContext = localTextView.getContext();
      s.s(localContext, "this.context");
      localTextView.setText((CharSequence)ht(localContext));
      pC(paramBoolean);
      localTextView = this.titleTv;
      if (localTextView != null)
      {
        if (paramBoolean)
        {
          aw.a((Paint)localTextView.getPaint(), 0.8F);
          AppMethodBeat.o(345583);
          return;
        }
        aw.e((Paint)localTextView.getPaint());
      }
    }
    AppMethodBeat.o(345583);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.i
 * JD-Core Version:    0.7.0.1
 */