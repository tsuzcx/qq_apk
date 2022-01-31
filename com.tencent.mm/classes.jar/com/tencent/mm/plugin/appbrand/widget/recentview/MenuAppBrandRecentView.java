package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;

public class MenuAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int jvN = b.jdj - 1;
  private static final int jvO = b.jdj;
  private AppBrandRecentView.b jhJ;
  
  public MenuAppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MenuAppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(BaseAppBrandRecentView.c paramc, a parama, int paramInt)
  {
    AppMethodBeat.i(134385);
    super.a(paramc, parama, paramInt);
    paramc.titleTv.setTextColor(-1728053248);
    if ((parama != null) && (parama.type == 2))
    {
      paramc.titleTv.setVisibility(0);
      paramc.jfs.setVisibility(8);
      paramc.titleTv.setText(2131301719);
      paramc.ivs.setImageResource(2131230848);
      AppMethodBeat.o(134385);
      return;
    }
    if ((parama != null) && (parama.type == -1)) {
      paramc.ivs.setImageResource(2131231207);
    }
    AppMethodBeat.o(134385);
  }
  
  public int getLayoutId()
  {
    return 2130968772;
  }
  
  protected int getLoadCount()
  {
    return jvO;
  }
  
  protected int getShowCount()
  {
    return jvN;
  }
  
  protected String getType()
  {
    AppMethodBeat.i(134384);
    String str = MenuAppBrandRecentView.class.getSimpleName();
    AppMethodBeat.o(134384);
    return str;
  }
  
  protected final void init(Context paramContext)
  {
    AppMethodBeat.i(134386);
    super.init(paramContext);
    super.setOnItemClickListener(new MenuAppBrandRecentView.1(this));
    AppMethodBeat.o(134386);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.jhJ = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */