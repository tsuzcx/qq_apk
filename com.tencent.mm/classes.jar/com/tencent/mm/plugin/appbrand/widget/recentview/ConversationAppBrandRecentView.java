package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class ConversationAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int hDa = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 200);
  private e.a hCZ;
  private float hDb = 0.0F;
  private int hDc = 0;
  private ConversationAppBrandRecentView.a hDd = null;
  private View.OnCreateContextMenuListener hDe = null;
  private AppBrandRecentView.a hDf = null;
  private boolean hDg = false;
  private AppBrandRecentView.b hrk;
  private int mScreenWidth = 0;
  
  public ConversationAppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ConversationAppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void g(RecyclerView.v paramv, int paramInt)
  {
    y.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    float f;
    if (paramv != null)
    {
      f = paramv.aie.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2) {
        paramv.aie.setAlpha(0.3F);
      }
    }
    else
    {
      return;
    }
    if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.hDb))
    {
      f = 1.0F - (f - this.hDb) / this.hDc * 0.7F;
      y.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
      paramv.aie.setAlpha(f);
      return;
    }
    paramv.aie.setAlpha(1.0F);
  }
  
  private int getItemPadding()
  {
    return com.tencent.mm.plugin.appbrand.widget.desktop.d.c(getContext(), b.getShowCountPerPage());
  }
  
  public final void a(BaseAppBrandRecentView.c paramc, a parama, int paramInt)
  {
    super.a(paramc, parama, paramInt);
    if ((parama != null) && (parama.type == 0))
    {
      paramc.eXr.setVisibility(4);
      paramc.gSx.setImageResource(y.i.multitask_bar_more_btn);
    }
    if ((!b.arj()) || (parama == null) || (paramc == null) || (paramc.aie == null)) {}
    for (;;)
    {
      if (this.hDd != null) {
        this.hDd.a(paramc, paramInt);
      }
      return;
      if (parama.type == 3)
      {
        paramc.aie.setVisibility(4);
        paramc.aie.getLayoutParams().width = 0;
      }
      int i = com.tencent.mm.plugin.appbrand.widget.desktop.d.cI(getContext());
      paramc.hCT.getLayoutParams().width = (com.tencent.mm.cb.a.ab(getContext(), y.e.SmallPadding) * 2 + i);
      paramc.hCT.getLayoutParams().height = (com.tencent.mm.cb.a.ab(getContext(), y.e.SmallPadding) * 2 + i);
      paramc.gSx.getLayoutParams().width = i;
      paramc.gSx.getLayoutParams().height = i;
      paramc.hqB.getLayoutParams().width = i;
      paramc.hqB.getLayoutParams().height = i;
      i = getCurrentPage();
      int j = e.nn(i);
      int k = e.no(i);
      y.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt) });
      if (paramInt == k)
      {
        paramc.aie.animate().alpha(0.3F).setDuration(1L).start();
      }
      else if (parama.gPg)
      {
        paramc.aie.setVisibility(4);
      }
      else
      {
        paramc.aie.setVisibility(0);
        paramc.aie.setAlpha(1.0F);
      }
    }
  }
  
  public final void a(String paramString, l paraml)
  {
    y.i("MicroMsg.ConversationAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)g.DM().Dr()).toString(), Integer.valueOf(paraml.gbI), this.hrp });
    if (asZ()) {
      return;
    }
    refresh();
  }
  
  public final void aE(List<a> paramList)
  {
    if (!b.arj()) {
      paramList.add(new a(0));
    }
    if (b.arj())
    {
      b.ark();
      paramList.add(0, new a(3));
    }
  }
  
  protected final boolean asZ()
  {
    boolean bool = this.hDg;
    this.hDg = false;
    return bool;
  }
  
  protected int getCompletelyCountPerPage()
  {
    return b.getCompletelyCountPerPage();
  }
  
  public int getCustomItemCount()
  {
    if (!b.arj()) {
      return 1;
    }
    if (b.arj())
    {
      b.ark();
      return 1;
    }
    return 0;
  }
  
  public int getItemWidth()
  {
    return com.tencent.mm.plugin.appbrand.widget.desktop.d.cG(getContext());
  }
  
  public int getLayoutId()
  {
    return y.h.appbrand_preview_item;
  }
  
  protected int getLoadCount()
  {
    if (this.hrp == AppBrandRecentView.f.hBX) {}
    while (this.hrp != AppBrandRecentView.f.hBY) {
      return 50;
    }
    return b.ads();
  }
  
  public List<a> getPreviewItemList()
  {
    return super.getPreviewItemList();
  }
  
  protected int getShowCount()
  {
    if (this.hrp == AppBrandRecentView.f.hBX) {
      return b.hpE;
    }
    if (this.hrp == AppBrandRecentView.f.hBY) {
      return b.ads();
    }
    return 50;
  }
  
  protected float getShowCountPerPage()
  {
    return b.getShowCountPerPage();
  }
  
  protected String getType()
  {
    return ConversationAppBrandRecentView.class.getSimpleName();
  }
  
  protected final void init(Context paramContext)
  {
    super.init(paramContext);
    this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
    super.setOnItemClickListener(new ConversationAppBrandRecentView.1(this));
    if (b.arj()) {
      super.setOnScrollPageListener(new ConversationAppBrandRecentView.2(this));
    }
  }
  
  protected final void ni(int paramInt)
  {
    super.ni(paramInt);
    getPreviewItemList().remove(paramInt);
    getAdapter().bN(paramInt);
    getAdapter().ah(paramInt, 5);
    if (this.hrp == AppBrandRecentView.f.hBX) {
      ai.l(new ConversationAppBrandRecentView.3(this), 200L);
    }
    while (getOnDataChangedListener() == null) {
      return;
    }
    AppBrandRecentView.d locald = getOnDataChangedListener();
    getPreviewItemList().size();
    locald.arB();
  }
  
  public final boolean nj(int paramInt)
  {
    int i = getCurrentPage();
    int j = b.getCompletelyCountPerPage();
    b.ark();
    return (i + 1) * j + 1 == paramInt;
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.hDe = paramOnCreateContextMenuListener;
  }
  
  public void setIgnoreNotify(boolean paramBoolean)
  {
    this.hDg = paramBoolean;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    this.hDf = parama;
  }
  
  public void setOnBindCustomViewHolderListener(ConversationAppBrandRecentView.a parama)
  {
    this.hDd = parama;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.hrk = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    this.hCZ = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */