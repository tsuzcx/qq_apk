package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;

public class MenuAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int oDK = d.omI - 1;
  private static final int oDL = d.omI;
  private AppBrandRecentView.b oDv;
  
  public MenuAppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MenuAppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(BaseAppBrandRecentView.b paramb, e parame, int paramInt)
  {
    AppMethodBeat.i(227834);
    super.a(paramb, parame, paramInt);
    paramb.titleTv.setTextColor(getContext().getResources().getColor(2131100904));
    if ((parame != null) && (parame.type == 2))
    {
      paramb.titleTv.setVisibility(0);
      paramb.ooB.setVisibility(8);
      paramb.titleTv.setText(2131763324);
      paramb.nnL.setImageResource(2131689608);
      AppMethodBeat.o(227834);
      return;
    }
    if ((parame != null) && (parame.type == -1)) {
      paramb.nnL.setImageResource(2131690042);
    }
    AppMethodBeat.o(227834);
  }
  
  public int getLayoutId()
  {
    return 2131493141;
  }
  
  protected int getLoadCount()
  {
    return oDL;
  }
  
  protected int getShowCount()
  {
    return oDK;
  }
  
  protected String getType()
  {
    AppMethodBeat.i(227833);
    String str = MenuAppBrandRecentView.class.getSimpleName();
    AppMethodBeat.o(227833);
    return str;
  }
  
  protected final void init(Context paramContext)
  {
    AppMethodBeat.i(227835);
    super.init(paramContext);
    super.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(227831);
        if (MenuAppBrandRecentView.a(MenuAppBrandRecentView.this) != null) {}
        for (boolean bool = MenuAppBrandRecentView.a(MenuAppBrandRecentView.this).a(paramAnonymousView, paramAnonymouse, paramAnonymousFloat1, paramAnonymousFloat2);; bool = false)
        {
          if (bool)
          {
            AppMethodBeat.o(227831);
            return true;
          }
          if (paramAnonymouse.type != 2)
          {
            paramAnonymousView = new AppBrandStatObject();
            paramAnonymousView.scene = 1090;
            ((r)g.af(r.class)).a(MenuAppBrandRecentView.this.getContext(), paramAnonymouse.ooj.username, null, paramAnonymouse.ooj.iOo, -1, null, paramAnonymousView);
          }
          AppMethodBeat.o(227831);
          return false;
        }
      }
      
      public final boolean b(View paramAnonymousView, e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(227832);
        boolean bool = false;
        if (MenuAppBrandRecentView.a(MenuAppBrandRecentView.this) != null) {
          bool = MenuAppBrandRecentView.a(MenuAppBrandRecentView.this).b(paramAnonymousView, paramAnonymouse, paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(227832);
        return bool;
      }
    });
    AppMethodBeat.o(227835);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.oDv = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.MenuAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */