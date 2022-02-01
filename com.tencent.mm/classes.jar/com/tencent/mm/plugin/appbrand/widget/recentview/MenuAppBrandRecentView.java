package com.tencent.mm.plugin.appbrand.widget.recentview;

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
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;

public class MenuAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int ntH = b.naS - 1;
  private static final int ntI = b.naS;
  private AppBrandRecentView.b neA;
  
  public MenuAppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MenuAppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(BaseAppBrandRecentView.b paramb, a parama, int paramInt)
  {
    AppMethodBeat.i(50005);
    super.a(paramb, parama, paramInt);
    paramb.titleTv.setTextColor(getContext().getResources().getColor(2131100711));
    if ((parama != null) && (parama.type == 2))
    {
      paramb.titleTv.setVisibility(0);
      paramb.ndo.setVisibility(8);
      paramb.titleTv.setText(2131761462);
      paramb.mdt.setImageResource(2131689605);
      AppMethodBeat.o(50005);
      return;
    }
    if ((parama != null) && (parama.type == -1)) {
      paramb.mdt.setImageResource(2131690013);
    }
    AppMethodBeat.o(50005);
  }
  
  public int getLayoutId()
  {
    return 2131493099;
  }
  
  protected int getLoadCount()
  {
    return ntI;
  }
  
  protected int getShowCount()
  {
    return ntH;
  }
  
  protected String getType()
  {
    AppMethodBeat.i(50004);
    String str = MenuAppBrandRecentView.class.getSimpleName();
    AppMethodBeat.o(50004);
    return str;
  }
  
  protected final void init(Context paramContext)
  {
    AppMethodBeat.i(50006);
    super.init(paramContext);
    super.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(50002);
        if (MenuAppBrandRecentView.a(MenuAppBrandRecentView.this) != null) {}
        for (boolean bool = MenuAppBrandRecentView.a(MenuAppBrandRecentView.this).a(paramAnonymousView, paramAnonymousa, paramAnonymousFloat1, paramAnonymousFloat2);; bool = false)
        {
          if (bool)
          {
            AppMethodBeat.o(50002);
            return true;
          }
          if (paramAnonymousa.type != 2)
          {
            paramAnonymousView = new AppBrandStatObject();
            paramAnonymousView.scene = 1090;
            ((p)g.ab(p.class)).a(MenuAppBrandRecentView.this.getContext(), paramAnonymousa.ndd.username, null, paramAnonymousa.ndd.hSZ, -1, null, paramAnonymousView);
          }
          AppMethodBeat.o(50002);
          return false;
        }
      }
      
      public final boolean b(View paramAnonymousView, a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(50003);
        boolean bool = false;
        if (MenuAppBrandRecentView.a(MenuAppBrandRecentView.this) != null) {
          bool = MenuAppBrandRecentView.a(MenuAppBrandRecentView.this).b(paramAnonymousView, paramAnonymousa, paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(50003);
        return bool;
      }
    });
    AppMethodBeat.o(50006);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.neA = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */