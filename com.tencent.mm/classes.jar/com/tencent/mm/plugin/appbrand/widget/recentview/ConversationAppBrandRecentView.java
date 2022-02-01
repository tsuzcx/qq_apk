package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.n.e;
import java.util.List;

public class ConversationAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int nol;
  private int mScreenWidth = 0;
  private AppBrandRecentView.b mZs;
  private e.a nok;
  private float nom = 0.0F;
  private int non = 0;
  private a noo = null;
  private View.OnCreateContextMenuListener nop = null;
  private AppBrandRecentView.a noq = null;
  private boolean nor = false;
  
  static
  {
    AppMethodBeat.i(50001);
    nol = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 200);
    AppMethodBeat.o(50001);
  }
  
  public ConversationAppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ConversationAppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void g(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(49993);
    ad.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramw != null)
    {
      float f = paramw.auu.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramw.auu.setAlpha(0.3F);
        AppMethodBeat.o(49993);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.nom))
      {
        f = 1.0F - (f - this.nom) / this.non * 0.7F;
        ad.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramw.auu.setAlpha(f);
        AppMethodBeat.o(49993);
        return;
      }
      paramw.auu.setAlpha(1.0F);
    }
    AppMethodBeat.o(49993);
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(49997);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.d.dY(getContext());
    AppMethodBeat.o(49997);
    return i;
  }
  
  public final void a(BaseAppBrandRecentView.b paramb, a parama, int paramInt)
  {
    AppMethodBeat.i(49984);
    super.a(paramb, parama, paramInt);
    if ((parama != null) && (parama.type == 0))
    {
      paramb.titleTv.setVisibility(4);
      paramb.lZa.setImageResource(2131690904);
    }
    if ((!b.bCH()) || (parama == null) || (paramb == null) || (paramb.auu == null)) {}
    for (;;)
    {
      if (this.noo != null) {
        this.noo.a(paramb, paramInt);
      }
      AppMethodBeat.o(49984);
      return;
      if (parama.type == 3)
      {
        paramb.auu.setVisibility(4);
        paramb.auu.getLayoutParams().width = 0;
      }
      int i = (int)com.tencent.mm.plugin.appbrand.widget.desktop.d.ea(getContext());
      paramb.noe.getLayoutParams().width = (com.tencent.mm.cc.a.ay(getContext(), 2131165568) * 2 + i);
      paramb.noe.getLayoutParams().height = (com.tencent.mm.cc.a.ay(getContext(), 2131165568) * 2 + i);
      paramb.lZa.getLayoutParams().width = i;
      paramb.lZa.getLayoutParams().height = i;
      paramb.mYh.getLayoutParams().width = i;
      paramb.mYh.getLayoutParams().height = i;
      i = getCurrentPage();
      int j = e.wU(i);
      int k = e.wV(i);
      ad.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt) });
      if (paramInt == k)
      {
        paramb.auu.animate().alpha(0.3F).setDuration(1L).start();
      }
      else if (parama.nmR)
      {
        paramb.auu.setVisibility(4);
      }
      else
      {
        paramb.auu.setVisibility(0);
        paramb.auu.setAlpha(1.0F);
      }
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(49995);
    ad.i("MicroMsg.ConversationAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)g.ajz().ajb()).toString(), Integer.valueOf(paramm.dtK), this.mZx });
    if (bFD())
    {
      AppMethodBeat.o(49995);
      return;
    }
    refresh();
    AppMethodBeat.o(49995);
  }
  
  protected final boolean bFD()
  {
    boolean bool = this.nor;
    this.nor = false;
    return bool;
  }
  
  public final void bI(List<a> paramList)
  {
    AppMethodBeat.i(49990);
    if (!b.bCH()) {
      paramList.add(new a(0));
    }
    if (b.bCH())
    {
      b.bCI();
      paramList.add(0, new a(3));
    }
    AppMethodBeat.o(49990);
  }
  
  protected int getCompletelyCountPerPage()
  {
    AppMethodBeat.i(49986);
    int i = b.getCompletelyCountPerPage();
    AppMethodBeat.o(49986);
    return i;
  }
  
  public int getCustomItemCount()
  {
    AppMethodBeat.i(49991);
    if (!b.bCH())
    {
      AppMethodBeat.o(49991);
      return 1;
    }
    if (b.bCH())
    {
      b.bCI();
      AppMethodBeat.o(49991);
      return 1;
    }
    AppMethodBeat.o(49991);
    return 0;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(49996);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.d.dX(getContext());
    AppMethodBeat.o(49996);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131493104;
  }
  
  protected int getLoadCount()
  {
    AppMethodBeat.i(49987);
    if (this.mZx == AppBrandRecentView.f.nmT)
    {
      AppMethodBeat.o(49987);
      return 50;
    }
    if (this.mZx == AppBrandRecentView.f.nmU)
    {
      int i = b.bcu();
      AppMethodBeat.o(49987);
      return i;
    }
    AppMethodBeat.o(49987);
    return 50;
  }
  
  public List<a> getPreviewItemList()
  {
    AppMethodBeat.i(49998);
    List localList = super.getPreviewItemList();
    AppMethodBeat.o(49998);
    return localList;
  }
  
  protected int getShowCount()
  {
    AppMethodBeat.i(49988);
    int i;
    if (this.mZx == AppBrandRecentView.f.nmT)
    {
      i = b.mVM;
      AppMethodBeat.o(49988);
      return i;
    }
    if (this.mZx == AppBrandRecentView.f.nmU)
    {
      i = b.bcu();
      AppMethodBeat.o(49988);
      return i;
    }
    AppMethodBeat.o(49988);
    return 50;
  }
  
  protected float getShowCountPerPage()
  {
    AppMethodBeat.i(49985);
    float f = b.getShowCountPerPage();
    AppMethodBeat.o(49985);
    return f;
  }
  
  protected String getType()
  {
    AppMethodBeat.i(49989);
    String str = ConversationAppBrandRecentView.class.getSimpleName();
    AppMethodBeat.o(49989);
    return str;
  }
  
  protected final void init(Context paramContext)
  {
    AppMethodBeat.i(49992);
    super.init(paramContext);
    this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
    super.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49978);
        if (ConversationAppBrandRecentView.a(ConversationAppBrandRecentView.this) != null) {
          ConversationAppBrandRecentView.a(ConversationAppBrandRecentView.this).a(paramAnonymousView, paramAnonymousa, paramAnonymousFloat1, paramAnonymousFloat2);
        }
        if (paramAnonymousa.type == 0)
        {
          ((q)g.ab(q.class)).H(ConversationAppBrandRecentView.this.getContext(), 13);
          AppMethodBeat.o(49978);
          return false;
        }
        ConversationAppBrandRecentView.this.setLayoutFrozen(true);
        paramAnonymousView = new AppBrandStatObject();
        if (ConversationAppBrandRecentView.this.mZx == AppBrandRecentView.f.nmU) {}
        for (int i = 1104;; i = 1089)
        {
          paramAnonymousView.scene = i;
          ((o)g.ab(o.class)).a(ConversationAppBrandRecentView.this.getContext(), paramAnonymousa.mXW.username, null, paramAnonymousa.mXW.hQh, -1, null, paramAnonymousView);
          break;
        }
      }
      
      public final boolean b(View paramAnonymousView, final a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49979);
        if (ConversationAppBrandRecentView.a(ConversationAppBrandRecentView.this) != null) {
          ConversationAppBrandRecentView.a(ConversationAppBrandRecentView.this).b(paramAnonymousView, paramAnonymousa, paramAnonymousFloat1, paramAnonymousFloat2);
        }
        ad.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if (paramAnonymousa.type != 0) {
          new com.tencent.mm.ui.widget.b.a(ConversationAppBrandRecentView.this.getContext()).a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(49976);
              if (ConversationAppBrandRecentView.b(ConversationAppBrandRecentView.this) != null) {
                ConversationAppBrandRecentView.b(ConversationAppBrandRecentView.this).onCreateContextMenu(paramAnonymous2ContextMenu, paramAnonymous2View, paramAnonymous2ContextMenuInfo);
              }
              paramAnonymous2ContextMenu.add(0, 1, paramAnonymous2ContextMenu.size() + 1, ConversationAppBrandRecentView.this.getContext().getResources().getString(2131758031));
              AppMethodBeat.o(49976);
            }
          }, new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(49977);
              if (ConversationAppBrandRecentView.c(ConversationAppBrandRecentView.this) != null) {
                ConversationAppBrandRecentView.c(ConversationAppBrandRecentView.this).a(paramAnonymous2MenuItem, paramAnonymousa.position, paramAnonymousa);
              }
              if ((paramAnonymous2MenuItem.getItemId() == 1) && (paramAnonymousa.position >= 0))
              {
                ConversationAppBrandRecentView.d(ConversationAppBrandRecentView.this);
                ad.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s, mType: %s", new Object[] { Integer.valueOf(paramAnonymousa.position), ConversationAppBrandRecentView.this.mZx });
                if (ConversationAppBrandRecentView.this.mZx != AppBrandRecentView.f.nmT) {
                  break label223;
                }
                ((ai)g.ab(ai.class)).ba(paramAnonymousa.mXW.username, paramAnonymousa.mXW.hQh);
              }
              for (;;)
              {
                ad.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo Delete %s, pos: %d", new Object[] { paramAnonymousa.mXW.nickname, Integer.valueOf(paramAnonymousa.position) });
                ConversationAppBrandRecentView.this.wP(paramAnonymousa.position);
                AppMethodBeat.o(49977);
                return;
                label223:
                if (ConversationAppBrandRecentView.this.mZx == AppBrandRecentView.f.nmU) {
                  ((ah)g.ab(ah.class)).aZ(paramAnonymousa.mXW.username, paramAnonymousa.mXW.hQh);
                }
              }
            }
          }, (int)paramAnonymousFloat1, (int)paramAnonymousFloat2);
        }
        AppMethodBeat.o(49979);
        return false;
      }
    });
    if (b.bCH()) {
      super.setOnScrollPageListener(new e.a()
      {
        public final void M(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(49981);
          if (ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this) != null) {
            ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this).M(paramAnonymousInt, paramAnonymousBoolean);
          }
          AppMethodBeat.o(49981);
        }
        
        public final void d(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(49980);
          ad.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(ConversationAppBrandRecentView.this.getCurrentPage()) });
          ConversationAppBrandRecentView.e(ConversationAppBrandRecentView.this);
          if (ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this) != null) {
            ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this).d(paramAnonymousRecyclerView, paramAnonymousInt);
          }
          AppMethodBeat.o(49980);
        }
        
        public final void h(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(49982);
          if (ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this) != null) {
            ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this).h(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(49982);
        }
      });
    }
    AppMethodBeat.o(49992);
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.nop = paramOnCreateContextMenuListener;
  }
  
  public void setIgnoreNotify(boolean paramBoolean)
  {
    this.nor = paramBoolean;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    this.noq = parama;
  }
  
  public void setOnBindCustomViewHolderListener(a parama)
  {
    this.noo = parama;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.mZs = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    this.nok = parama;
  }
  
  protected final void wP(int paramInt)
  {
    AppMethodBeat.i(49994);
    super.wP(paramInt);
    getPreviewItemList().remove(paramInt);
    getAdapter().cl(paramInt);
    getAdapter().ap(paramInt, 5);
    if (this.mZx == AppBrandRecentView.f.nmT)
    {
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49983);
          Object localObject = ConversationAppBrandRecentView.this;
          if (((BaseAppBrandRecentView)localObject).nnT)
          {
            int i = ((BaseAppBrandRecentView)localObject).nnP.size();
            if ((i - 1 < ((BaseAppBrandRecentView)localObject).mYL.size()) && ((a)((BaseAppBrandRecentView)localObject).mYL.get(i - 1) != null))
            {
              ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo addCacheItemAtLast pos: %d", new Object[] { Integer.valueOf(i) });
              ((BaseAppBrandRecentView)localObject).nnP.add(i, ((BaseAppBrandRecentView)localObject).mYL.get(i - 1));
              ((BaseAppBrandRecentView)localObject).getAdapter().ck(i);
              ((BaseAppBrandRecentView)localObject).getAdapter().ap(i, 5);
            }
          }
          if (ConversationAppBrandRecentView.this.getOnDataChangedListener() != null)
          {
            localObject = ConversationAppBrandRecentView.this.getOnDataChangedListener();
            ConversationAppBrandRecentView.this.getPreviewItemList().size();
            ((AppBrandRecentView.d)localObject).bDx();
          }
          AppMethodBeat.o(49983);
        }
      }, 200L);
      AppMethodBeat.o(49994);
      return;
    }
    if (getOnDataChangedListener() != null)
    {
      AppBrandRecentView.d locald = getOnDataChangedListener();
      getPreviewItemList().size();
      locald.bDx();
    }
    AppMethodBeat.o(49994);
  }
  
  public final boolean wQ(int paramInt)
  {
    AppMethodBeat.i(49999);
    int i = getCurrentPage();
    int j = b.getCompletelyCountPerPage();
    b.bCI();
    if ((i + 1) * j + 1 == paramInt)
    {
      AppMethodBeat.o(49999);
      return true;
    }
    AppMethodBeat.o(49999);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(BaseAppBrandRecentView.b paramb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */