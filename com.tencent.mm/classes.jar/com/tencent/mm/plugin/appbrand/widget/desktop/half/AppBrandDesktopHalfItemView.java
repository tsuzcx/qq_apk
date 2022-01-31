package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.widget.desktop.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopHalfItemView
  extends LinearLayout
{
  private RecyclerView.m agv = null;
  ConversationAppBrandRecentView hpU;
  private int hrb = 0;
  private TextView hrg;
  private ImageView hrh;
  private AppBrandRecentView.e hri = null;
  RecyclerView.c hrj = null;
  private AppBrandRecentView.b hrk = null;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b hrl = null;
  private LinearLayout hrm = null;
  private FrameLayout hrn = null;
  private View hro = null;
  private AppBrandRecentView.f hrp;
  private int hrq = 0;
  private float hrr = 0.0F;
  AppBrandDesktopHalfItemView.a hrs = null;
  boolean hrt = false;
  private a.b hru = null;
  private boolean hrv = true;
  private int hrw = 1;
  private Animator.AnimatorListener hrx = new AppBrandDesktopHalfItemView.2(this);
  private Context mContext;
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = com.tencent.mm.ui.y.gt(this.mContext).inflate(y.h.app_brand_desktop_half_item_view_layout, this);
    this.hrg = ((TextView)paramContext.findViewById(y.g.app_brand_desktop_half_item_title));
    this.hrg.setOnClickListener(new AppBrandDesktopHalfItemView.5(this));
    this.hrh = ((ImageView)paramContext.findViewById(y.g.app_brand_desktop_half_item_more_btn));
    this.hrh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.hBY)
        {
          ((f)g.r(f.class)).cc(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).arD();
          }
        }
        do
        {
          do
          {
            return;
          } while (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) != AppBrandRecentView.f.hBX);
          ((f)g.r(f.class)).cb(AppBrandDesktopHalfItemView.this.getContext());
        } while (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) == null);
        AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).arE();
      }
    });
    this.hrn = ((FrameLayout)paramContext.findViewById(y.g.app_brand_desktop_list_container));
    this.hrm = ((LinearLayout)paramContext.findViewById(y.g.float_view_container));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDisplayMetrics().widthPixels * 2, -2);
    this.hrm.setLayoutParams(localLayoutParams);
    this.hpU = ((ConversationAppBrandRecentView)paramContext.findViewById(y.g.app_brand_desktop_half_item_list));
    this.hpU.setRefreshListener(new AppBrandDesktopHalfItemView.7(this));
    this.hpU.getAdapter().a(new AppBrandDesktopHalfItemView.8(this));
    this.hpU.setOnItemClickListener(new AppBrandDesktopHalfItemView.9(this));
    this.hpU.setOnScrollPageListener(new AppBrandDesktopHalfItemView.10(this));
    this.hpU.setOnBindCustomViewHolderListener(new AppBrandDesktopHalfItemView.11(this));
  }
  
  private void setToDefaultStatus(RecyclerView.v paramv)
  {
    if ((paramv instanceof BaseAppBrandRecentView.c))
    {
      paramv.aie.setAlpha(0.0F);
      paramv.aie.setScaleX(0.95F);
      paramv.aie.setScaleY(0.95F);
    }
  }
  
  public final void a(Configuration paramConfiguration)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo HalfItemView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.hrw != paramConfiguration.orientation)
    {
      Object localObject = this.hpU;
      int i = ((RecyclerView)localObject).getItemDecorationCount();
      if (i <= 0) {
        throw new IndexOutOfBoundsException("0 is an invalid index for size " + i);
      }
      localObject = (RecyclerView.h)((RecyclerView)localObject).afI.get(0);
      if ((localObject != null) && ((localObject instanceof a))) {
        ((a)localObject).padding = d.c(this.mContext, com.tencent.mm.plugin.appbrand.widget.desktop.b.getShowCountPerPage());
      }
      this.hpU.getAdapter().agL.notifyChanged();
    }
    this.hrw = paramConfiguration.orientation;
  }
  
  public final void a(AppBrandRecentView.f paramf)
  {
    this.hrp = paramf;
    if (this.hrp == AppBrandRecentView.f.hBX)
    {
      this.hrg.setText(getResources().getString(y.j.recent_app_brand));
      this.hpU.setType(this.hrp);
      this.hpU.setItemAnimator(new c(this.hpU, true));
      this.hpU.setDataQuery(new AppBrandDesktopHalfItemView.1(this));
    }
    while (this.hrp != AppBrandRecentView.f.hBY) {
      return;
    }
    setTitle(getResources().getString(y.j.my_app_brand));
    this.hpU.setType(this.hrp);
    this.hpU.setItemAnimator(new c(this.hpU, false));
    this.hpU.setDataQuery(new AppBrandDesktopHalfItemView.4(this));
  }
  
  public final void a(e.b paramb)
  {
    Object localObject = this.hpU;
    if (((BaseAppBrandRecentView)localObject).hCH != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).hCH;
      ((e)localObject).hDx = true;
      ((e)localObject).a(0, paramb, true);
    }
  }
  
  public final void arw()
  {
    Object localObject = this.hpU;
    if (((BaseAppBrandRecentView)localObject).hCH != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).hCH;
      ((e)localObject).hDp.getLayoutManager().bE(0);
      ((e)localObject).mOffsetX = 0;
      ((e)localObject).hDq = 0;
      ((e)localObject).hDr = 0;
      ((e)localObject).hxH = 0;
    }
  }
  
  public int getCustomCount()
  {
    return this.hpU.getCustomItemCount();
  }
  
  public int getDataCount()
  {
    return this.hpU.getDataCount();
  }
  
  public List<com.tencent.mm.plugin.appbrand.widget.recentview.a> getPreviewList()
  {
    return this.hpU.getPreviewItemList();
  }
  
  public ConversationAppBrandRecentView getRecentView()
  {
    return this.hpU;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.hrv) && (this.hrh.getMeasuredWidth() != 0) && (this.hrh.getMeasuredHeight() != 0))
    {
      this.hrh.getLayoutParams().width = ((int)(this.hrh.getMeasuredWidth() * d.cJ(getContext())));
      this.hrh.getLayoutParams().height = ((int)(this.hrh.getMeasuredHeight() * d.cJ(getContext())));
      this.hrv = false;
    }
  }
  
  public final void release()
  {
    if (this.hpU != null) {
      this.hpU.release();
    }
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.hpU.setCreateContextMenuListener(paramOnCreateContextMenuListener);
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    this.hpU.setDataQuery(paramc);
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    this.hpU.setEnableDataCache(paramBoolean);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.hrb = paramInt;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    this.hpU.setMenuItemSelectedListener(parama);
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    this.hpU.setOnDataChangedListener(paramd);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.hrk = paramb;
  }
  
  public void setOnLaunchUIListener(a.b paramb)
  {
    this.hru = paramb;
  }
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    this.hpU.setRefreshListener(parame);
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    this.hrl = paramb;
  }
  
  public void setTitle(String paramString)
  {
    this.hrg.setText(paramString);
  }
  
  public void setTitlePadding(Rect paramRect)
  {
    if (paramRect != null) {
      this.hrg.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    if (this.hrg != null) {
      this.hrg.setPadding(paramInt, this.hrg.getPaddingTop(), this.hrg.getPaddingRight(), this.hrg.getPaddingBottom());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView
 * JD-Core Version:    0.7.0.1
 */