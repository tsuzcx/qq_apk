package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

public class ConversationAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int mlN;
  private AppBrandRecentView.b lWI;
  private int mScreenWidth = 0;
  private e.a mlM;
  private float mlO = 0.0F;
  private int mlP = 0;
  private a mlQ = null;
  private View.OnCreateContextMenuListener mlR = null;
  private AppBrandRecentView.a mlS = null;
  private boolean mlT = false;
  
  static
  {
    AppMethodBeat.i(50001);
    mlN = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 200);
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
  
  private void g(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(49993);
    ad.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramv != null)
    {
      float f = paramv.arI.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramv.arI.setAlpha(0.3F);
        AppMethodBeat.o(49993);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.mlO))
      {
        f = 1.0F - (f - this.mlO) / this.mlP * 0.7F;
        ad.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramv.arI.setAlpha(f);
        AppMethodBeat.o(49993);
        return;
      }
      paramv.arI.setAlpha(1.0F);
    }
    AppMethodBeat.o(49993);
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(49997);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.d.dQ(getContext());
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
      paramb.kXS.setImageResource(2131690904);
    }
    if ((!b.brC()) || (parama == null) || (paramb == null) || (paramb.arI == null)) {}
    for (;;)
    {
      if (this.mlQ != null) {
        this.mlQ.a(paramb, paramInt);
      }
      AppMethodBeat.o(49984);
      return;
      if (parama.type == 3)
      {
        paramb.arI.setVisibility(4);
        paramb.arI.getLayoutParams().width = 0;
      }
      int i = (int)com.tencent.mm.plugin.appbrand.widget.desktop.d.dS(getContext());
      paramb.lVz.getLayoutParams().width = (com.tencent.mm.cd.a.ap(getContext(), 2131165568) * 2 + i);
      paramb.lVz.getLayoutParams().height = (com.tencent.mm.cd.a.ap(getContext(), 2131165568) * 2 + i);
      paramb.kXS.getLayoutParams().width = i;
      paramb.kXS.getLayoutParams().height = i;
      paramb.lVy.getLayoutParams().width = i;
      paramb.lVy.getLayoutParams().height = i;
      i = getCurrentPage();
      int j = e.vy(i);
      int k = e.vz(i);
      ad.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt) });
      if (paramInt == k)
      {
        paramb.arI.animate().alpha(0.3F).setDuration(1L).start();
      }
      else if (parama.mku)
      {
        paramb.arI.setVisibility(4);
      }
      else
      {
        paramb.arI.setVisibility(0);
        paramb.arI.setAlpha(1.0F);
      }
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(49995);
    ad.i("MicroMsg.ConversationAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)g.afy().aeZ()).toString(), Integer.valueOf(paramm.jqR), this.lWN });
    if (buE())
    {
      AppMethodBeat.o(49995);
      return;
    }
    refresh();
    AppMethodBeat.o(49995);
  }
  
  public final void bH(List<a> paramList)
  {
    AppMethodBeat.i(49990);
    if (!b.brC()) {
      paramList.add(new a(0));
    }
    if (b.brC())
    {
      b.brD();
      paramList.add(0, new a(3));
    }
    AppMethodBeat.o(49990);
  }
  
  protected final boolean buE()
  {
    boolean bool = this.mlT;
    this.mlT = false;
    return bool;
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
    if (!b.brC())
    {
      AppMethodBeat.o(49991);
      return 1;
    }
    if (b.brC())
    {
      b.brD();
      AppMethodBeat.o(49991);
      return 1;
    }
    AppMethodBeat.o(49991);
    return 0;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(49996);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.d.dP(getContext());
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
    if (this.lWN == AppBrandRecentView.f.mkw)
    {
      AppMethodBeat.o(49987);
      return 50;
    }
    if (this.lWN == AppBrandRecentView.f.mkx)
    {
      int i = b.aSb();
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
    if (this.lWN == AppBrandRecentView.f.mkw)
    {
      i = b.lTd;
      AppMethodBeat.o(49988);
      return i;
    }
    if (this.lWN == AppBrandRecentView.f.mkx)
    {
      i = b.aSb();
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
          ((p)g.ab(p.class)).D(ConversationAppBrandRecentView.this.getContext(), 13);
          AppMethodBeat.o(49978);
          return false;
        }
        ConversationAppBrandRecentView.this.setLayoutFrozen(true);
        paramAnonymousView = new AppBrandStatObject();
        if (ConversationAppBrandRecentView.this.lWN == AppBrandRecentView.f.mkx) {}
        for (int i = 1104;; i = 1089)
        {
          paramAnonymousView.scene = i;
          ((n)g.ab(n.class)).a(ConversationAppBrandRecentView.this.getContext(), paramAnonymousa.lVq.username, null, paramAnonymousa.lVq.gXn, -1, null, paramAnonymousView);
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
          new com.tencent.mm.ui.widget.b.a(ConversationAppBrandRecentView.this.getContext()).a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
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
          }, new n.d()
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
                ad.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s, mType: %s", new Object[] { Integer.valueOf(paramAnonymousa.position), ConversationAppBrandRecentView.this.lWN });
                if (ConversationAppBrandRecentView.this.lWN != AppBrandRecentView.f.mkw) {
                  break label223;
                }
                ((ai)g.ab(ai.class)).aU(paramAnonymousa.lVq.username, paramAnonymousa.lVq.gXn);
              }
              for (;;)
              {
                ad.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo Delete %s, pos: %d", new Object[] { paramAnonymousa.lVq.nickname, Integer.valueOf(paramAnonymousa.position) });
                ConversationAppBrandRecentView.this.vt(paramAnonymousa.position);
                AppMethodBeat.o(49977);
                return;
                label223:
                if (ConversationAppBrandRecentView.this.lWN == AppBrandRecentView.f.mkx) {
                  ((ah)g.ab(ah.class)).aT(paramAnonymousa.lVq.username, paramAnonymousa.lVq.gXn);
                }
              }
            }
          }, (int)paramAnonymousFloat1, (int)paramAnonymousFloat2);
        }
        AppMethodBeat.o(49979);
        return false;
      }
    });
    if (b.brC()) {
      super.setOnScrollPageListener(new ConversationAppBrandRecentView.2(this));
    }
    AppMethodBeat.o(49992);
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.mlR = paramOnCreateContextMenuListener;
  }
  
  public void setIgnoreNotify(boolean paramBoolean)
  {
    this.mlT = paramBoolean;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    this.mlS = parama;
  }
  
  public void setOnBindCustomViewHolderListener(a parama)
  {
    this.mlQ = parama;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.lWI = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    this.mlM = parama;
  }
  
  protected final void vt(int paramInt)
  {
    AppMethodBeat.i(49994);
    super.vt(paramInt);
    getPreviewItemList().remove(paramInt);
    getAdapter().cm(paramInt);
    getAdapter().ao(paramInt, 5);
    if (this.lWN == AppBrandRecentView.f.mkw)
    {
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49983);
          Object localObject = ConversationAppBrandRecentView.this;
          if (((BaseAppBrandRecentView)localObject).mlw)
          {
            int i = ((BaseAppBrandRecentView)localObject).mls.size();
            if ((i - 1 < ((BaseAppBrandRecentView)localObject).lWb.size()) && ((a)((BaseAppBrandRecentView)localObject).lWb.get(i - 1) != null))
            {
              ad.i("MicroMsg.BaseAppBrandRecentView", "alvinluo addCacheItemAtLast pos: %d", new Object[] { Integer.valueOf(i) });
              ((BaseAppBrandRecentView)localObject).mls.add(i, ((BaseAppBrandRecentView)localObject).lWb.get(i - 1));
              ((BaseAppBrandRecentView)localObject).getAdapter().cl(i);
              ((BaseAppBrandRecentView)localObject).getAdapter().ao(i, 5);
            }
          }
          if (ConversationAppBrandRecentView.this.getOnDataChangedListener() != null)
          {
            localObject = ConversationAppBrandRecentView.this.getOnDataChangedListener();
            ConversationAppBrandRecentView.this.getPreviewItemList().size();
            ((AppBrandRecentView.d)localObject).bst();
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
      locald.bst();
    }
    AppMethodBeat.o(49994);
  }
  
  public final boolean vu(int paramInt)
  {
    AppMethodBeat.i(49999);
    int i = getCurrentPage();
    int j = b.getCompletelyCountPerPage();
    b.brD();
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