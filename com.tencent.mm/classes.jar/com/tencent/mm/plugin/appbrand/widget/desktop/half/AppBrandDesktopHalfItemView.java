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
import android.view.View.OnCreateContextMenuListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopHalfItemView
  extends LinearLayout
{
  private RecyclerView.m aiL;
  private int iAy;
  private int jdO;
  ConversationAppBrandRecentView jeb;
  private int jfZ;
  private TextView jhF;
  private ImageView jhG;
  private AppBrandRecentView.e jhH;
  RecyclerView.c jhI;
  private AppBrandRecentView.b jhJ;
  private b jhK;
  private LinearLayout jhL;
  private FrameLayout jhM;
  private View jhN;
  private AppBrandRecentView.f jhO;
  private float jhP;
  AppBrandDesktopHalfItemView.a jhQ;
  boolean jhR;
  private a.b jhS;
  private boolean jhT;
  private Animator.AnimatorListener jhU;
  private Context mContext;
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(134139);
    this.jhH = null;
    this.jhI = null;
    this.jhJ = null;
    this.aiL = null;
    this.jhK = null;
    this.jhL = null;
    this.jhM = null;
    this.jhN = null;
    this.jdO = 0;
    this.jfZ = 0;
    this.jhP = 0.0F;
    this.jhQ = null;
    this.jhR = false;
    this.jhS = null;
    this.jhT = true;
    this.iAy = 1;
    this.jhU = new AppBrandDesktopHalfItemView.2(this);
    init(paramContext);
    AppMethodBeat.o(134139);
  }
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(134140);
    this.jhH = null;
    this.jhI = null;
    this.jhJ = null;
    this.aiL = null;
    this.jhK = null;
    this.jhL = null;
    this.jhM = null;
    this.jhN = null;
    this.jdO = 0;
    this.jfZ = 0;
    this.jhP = 0.0F;
    this.jhQ = null;
    this.jhR = false;
    this.jhS = null;
    this.jhT = true;
    this.iAy = 1;
    this.jhU = new AppBrandDesktopHalfItemView.2(this);
    init(paramContext);
    AppMethodBeat.o(134140);
  }
  
  private void aQh()
  {
    AppMethodBeat.i(134144);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDisplayMetrics().widthPixels * 2, -2);
    this.jhL.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(134144);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(134141);
    this.mContext = paramContext;
    paramContext = w.hM(this.mContext).inflate(2130968675, this);
    this.jhF = ((TextView)paramContext.findViewById(2131821185));
    this.jhF.setOnClickListener(new AppBrandDesktopHalfItemView.5(this));
    this.jhG = ((ImageView)paramContext.findViewById(2131821186));
    this.jhG.setOnClickListener(new AppBrandDesktopHalfItemView.6(this));
    this.jhM = ((FrameLayout)paramContext.findViewById(2131821187));
    this.jhL = ((LinearLayout)paramContext.findViewById(2131821188));
    aQh();
    this.jeb = ((ConversationAppBrandRecentView)paramContext.findViewById(2131821189));
    this.jeb.setRefreshListener(new AppBrandDesktopHalfItemView.7(this));
    this.jeb.getAdapter().a(new AppBrandDesktopHalfItemView.8(this));
    this.jeb.setOnItemClickListener(new AppBrandDesktopHalfItemView.9(this));
    this.jeb.setOnScrollPageListener(new AppBrandDesktopHalfItemView.10(this));
    this.jeb.setOnBindCustomViewHolderListener(new AppBrandDesktopHalfItemView.11(this));
    AppMethodBeat.o(134141);
  }
  
  private void setToDefaultStatus(RecyclerView.v paramv)
  {
    AppMethodBeat.i(134145);
    if ((paramv instanceof BaseAppBrandRecentView.c))
    {
      paramv.aku.setAlpha(0.0F);
      paramv.aku.setScaleX(0.95F);
      paramv.aku.setScaleY(0.95F);
    }
    AppMethodBeat.o(134145);
  }
  
  public final void a(AppBrandRecentView.f paramf)
  {
    AppMethodBeat.i(134138);
    this.jhO = paramf;
    if (this.jhO == AppBrandRecentView.f.juq)
    {
      this.jhF.setText(getResources().getString(2131302333));
      this.jeb.setType(this.jhO);
      this.jeb.setItemAnimator(new c(this.jeb, true));
      this.jeb.setDataQuery(new AppBrandDesktopHalfItemView.1(this));
      AppMethodBeat.o(134138);
      return;
    }
    if (this.jhO == AppBrandRecentView.f.jur)
    {
      setTitle(getResources().getString(2131301736));
      this.jeb.setType(this.jhO);
      this.jeb.setItemAnimator(new c(this.jeb, false));
      this.jeb.setDataQuery(new AppBrandDesktopHalfItemView.4(this));
    }
    AppMethodBeat.o(134138);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(134158);
    Object localObject = this.jeb;
    if (((BaseAppBrandRecentView)localObject).jvj != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).jvj;
      ((e)localObject).jvY = true;
      ((e)localObject).a(0, paramb, true);
    }
    AppMethodBeat.o(134158);
  }
  
  public final void aQi()
  {
    AppMethodBeat.i(134159);
    Object localObject = this.jeb;
    if (((BaseAppBrandRecentView)localObject).jvj != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).jvj;
      ((e)localObject).jvQ.getLayoutManager().bJ(0);
      ((e)localObject).mOffsetX = 0;
      ((e)localObject).jvR = 0;
      ((e)localObject).jvS = 0;
      ((e)localObject).jpR = 0;
    }
    AppMethodBeat.o(134159);
  }
  
  public final void b(Configuration paramConfiguration)
  {
    AppMethodBeat.i(134143);
    ab.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo HalfItemView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.iAy != paramConfiguration.orientation)
    {
      Object localObject = this.jeb;
      int i = ((RecyclerView)localObject).getItemDecorationCount();
      if (i <= 0)
      {
        paramConfiguration = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(i)));
        AppMethodBeat.o(134143);
        throw paramConfiguration;
      }
      localObject = (RecyclerView.h)((RecyclerView)localObject).ahY.get(0);
      if ((localObject != null) && ((localObject instanceof a))) {
        ((a)localObject).padding = d.jdMethod_do(this.mContext);
      }
      this.jeb.getAdapter().ajb.notifyChanged();
    }
    this.iAy = paramConfiguration.orientation;
    AppMethodBeat.o(134143);
  }
  
  public int getCustomCount()
  {
    AppMethodBeat.i(134154);
    int i = this.jeb.getCustomItemCount();
    AppMethodBeat.o(134154);
    return i;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(134153);
    int i = this.jeb.getDataCount();
    AppMethodBeat.o(134153);
    return i;
  }
  
  public List<com.tencent.mm.plugin.appbrand.widget.recentview.a> getPreviewList()
  {
    AppMethodBeat.i(134152);
    List localList = this.jeb.getPreviewItemList();
    AppMethodBeat.o(134152);
    return localList;
  }
  
  public ConversationAppBrandRecentView getRecentView()
  {
    return this.jeb;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134142);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.jhT) && (this.jhG.getMeasuredWidth() != 0) && (this.jhG.getMeasuredHeight() != 0))
    {
      this.jhG.getLayoutParams().width = ((int)(this.jhG.getMeasuredWidth() * d.dr(getContext())));
      this.jhG.getLayoutParams().height = ((int)(this.jhG.getMeasuredHeight() * d.dr(getContext())));
      this.jhT = false;
    }
    AppMethodBeat.o(134142);
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    AppMethodBeat.i(134155);
    this.jeb.setCreateContextMenuListener(paramOnCreateContextMenuListener);
    AppMethodBeat.o(134155);
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    AppMethodBeat.i(134151);
    this.jeb.setDataQuery(paramc);
    AppMethodBeat.o(134151);
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    AppMethodBeat.i(134147);
    this.jeb.setEnableDataCache(paramBoolean);
    AppMethodBeat.o(134147);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.jdO = paramInt;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    AppMethodBeat.i(134156);
    this.jeb.setMenuItemSelectedListener(parama);
    AppMethodBeat.o(134156);
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    AppMethodBeat.i(134157);
    this.jeb.setOnDataChangedListener(paramd);
    AppMethodBeat.o(134157);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.jhJ = paramb;
  }
  
  public void setOnLaunchUIListener(a.b paramb)
  {
    this.jhS = paramb;
  }
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    AppMethodBeat.i(134146);
    this.jeb.setRefreshListener(parame);
    AppMethodBeat.o(134146);
  }
  
  public void setReporter(b paramb)
  {
    this.jhK = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(134148);
    this.jhF.setText(paramString);
    AppMethodBeat.o(134148);
  }
  
  public void setTitlePadding(Rect paramRect)
  {
    AppMethodBeat.i(134150);
    if (paramRect != null) {
      this.jhF.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
    AppMethodBeat.o(134150);
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    AppMethodBeat.i(134149);
    if (this.jhF != null)
    {
      TextView localTextView = this.jhF;
      localTextView.setPadding(paramInt, localTextView.getPaddingTop(), this.jhF.getPaddingRight(), this.jhF.getPaddingBottom());
    }
    AppMethodBeat.o(134149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView
 * JD-Core Version:    0.7.0.1
 */