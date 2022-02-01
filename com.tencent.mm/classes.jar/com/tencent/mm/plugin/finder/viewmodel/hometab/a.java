package com.tencent.mm.plugin.finder.viewmodel.hometab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/hometab/FinderHomeTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "tabType", "(II)V", "getTabType", "()I", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "getLayoutId", "onTabInflated", "", "tabView", "Landroid/view/ViewGroup;", "onTabStatusChanged", "isSelected", "", "setTabRedDot", "redDotText", "", "isTabSelected", "setTabTitle", "setTitleTv", "Companion", "plugin-finder_release"})
public final class a
  extends c
{
  private static final Map<Integer, Integer> wBK;
  public static final a wBL;
  private final int dLS;
  private WeImageView uPW;
  
  static
  {
    AppMethodBeat.i(256104);
    wBL = new a((byte)0);
    wBK = ae.e(new o[] { s.U(Integer.valueOf(3), Integer.valueOf(0)), s.U(Integer.valueOf(1), Integer.valueOf(1)), s.U(Integer.valueOf(4), Integer.valueOf(2)) });
    AppMethodBeat.o(256104);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.dLS = paramInt2;
  }
  
  @SuppressLint({"ResourceType"})
  private final void dIR()
  {
    AppMethodBeat.i(256103);
    WeImageView localWeImageView = this.uPW;
    if (localWeImageView != null)
    {
      if (localWeImageView.isSelected())
      {
        i = 2131690580;
        localWeImageView.setImageResource(i);
        if (!localWeImageView.isSelected()) {
          break label63;
        }
      }
      label63:
      for (int i = localWeImageView.getResources().getColor(2131100904);; i = localWeImageView.getResources().getColor(2131100245))
      {
        localWeImageView.setIconColor(i);
        AppMethodBeat.o(256103);
        return;
        i = 2131690824;
        break;
      }
    }
    AppMethodBeat.o(256103);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(256100);
    p.h(paramViewGroup, "tabView");
    pe(paramBoolean);
    setTextBold(paramBoolean);
    switch (this.dLS)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(256100);
      return;
      paramViewGroup = this.uPW;
      if (paramViewGroup != null)
      {
        if (paramBoolean) {}
        for (int i = 2131690589;; i = 2131690826)
        {
          paramViewGroup.setImageResource(i);
          AppMethodBeat.o(256100);
          return;
        }
      }
      AppMethodBeat.o(256100);
      return;
      dIR();
    }
  }
  
  public final void by(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(256102);
    paramString = this.uPX;
    if (paramString != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        paramString.setVisibility(i);
        AppMethodBeat.o(256102);
        return;
      }
    }
    AppMethodBeat.o(256102);
  }
  
  public final int getLayoutId()
  {
    switch (this.dLS)
    {
    case 2: 
    default: 
      return 2131494343;
    case 1: 
      return 2131494346;
    }
    return 2131494345;
  }
  
  public final void pd(boolean paramBoolean)
  {
    AppMethodBeat.i(256101);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      Context localContext = localTextView.getContext();
      p.g(localContext, "context");
      localTextView.setText((CharSequence)getTitle(localContext));
      pe(paramBoolean);
      setTextBold(paramBoolean);
      AppMethodBeat.o(256101);
      return;
    }
    AppMethodBeat.o(256101);
  }
  
  public final void u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(256099);
    if (paramViewGroup != null)
    {
      this.titleTv = ((TextView)paramViewGroup.findViewById(2131308826));
      TextView localTextView = this.titleTv;
      if (localTextView != null) {
        localTextView.setTextSize(1, 15.0F);
      }
      switch (this.dLS)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(256099);
        return;
        this.uPW = ((WeImageView)paramViewGroup.findViewById(2131308829));
        this.uPX = ((ImageView)paramViewGroup.findViewById(2131308830));
        dIR();
        AppMethodBeat.o(256099);
        return;
        this.uPX = ((ImageView)paramViewGroup.findViewById(2131308823));
      }
    }
    AppMethodBeat.o(256099);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/hometab/FinderHomeTab$Companion;", "", "()V", "tabTypeConverter", "", "", "getTabIndex", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static int MK(int paramInt)
    {
      AppMethodBeat.i(256098);
      Integer localInteger = (Integer)a.dIS().get(Integer.valueOf(paramInt));
      if (localInteger != null)
      {
        paramInt = localInteger.intValue();
        AppMethodBeat.o(256098);
        return paramInt;
      }
      AppMethodBeat.o(256098);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.hometab.a
 * JD-Core Version:    0.7.0.1
 */