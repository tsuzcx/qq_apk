package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.o.g;
import java.util.List;

public class ConversationAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int oDx;
  private int mScreenWidth = 0;
  private a oDA = null;
  private View.OnCreateContextMenuListener oDB = null;
  private AppBrandRecentView.a oDC = null;
  private boolean oDD = false;
  private AppBrandRecentView.b oDv;
  private p.a oDw;
  private float oDy = 0.0F;
  private int oDz = 0;
  
  static
  {
    AppMethodBeat.i(227830);
    oDx = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 200);
    AppMethodBeat.o(227830);
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
    AppMethodBeat.i(227823);
    Log.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramv != null)
    {
      float f = paramv.aus.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramv.aus.setAlpha(0.3F);
        AppMethodBeat.o(227823);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.oDy))
      {
        f = 1.0F - (f - this.oDy) / this.oDz * 0.7F;
        Log.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramv.aus.setAlpha(f);
        AppMethodBeat.o(227823);
        return;
      }
      paramv.aus.setAlpha(1.0F);
    }
    AppMethodBeat.o(227823);
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(227827);
    int i = f.ew(getContext());
    AppMethodBeat.o(227827);
    return i;
  }
  
  protected final void AD(int paramInt)
  {
    AppMethodBeat.i(227824);
    super.AD(paramInt);
    getPreviewItemList().remove(paramInt);
    getAdapter().ck(paramInt);
    getAdapter().aq(paramInt, 5);
    if (this.oDe == AppBrandRecentView.f.oBY)
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227813);
          ConversationAppBrandRecentView localConversationAppBrandRecentView = ConversationAppBrandRecentView.this;
          if (localConversationAppBrandRecentView.oDd)
          {
            int i = localConversationAppBrandRecentView.oCZ.size();
            if ((i - 1 < localConversationAppBrandRecentView.opg.size()) && ((e)localConversationAppBrandRecentView.opg.get(i - 1) != null))
            {
              Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo addCacheItemAtLast pos: %d", new Object[] { Integer.valueOf(i) });
              localConversationAppBrandRecentView.oCZ.add(i, localConversationAppBrandRecentView.opg.get(i - 1));
              localConversationAppBrandRecentView.getAdapter().cj(i);
              localConversationAppBrandRecentView.getAdapter().aq(i, 5);
            }
          }
          if (ConversationAppBrandRecentView.this.getOnDataChangedListener() != null)
          {
            ConversationAppBrandRecentView.this.getOnDataChangedListener();
            ConversationAppBrandRecentView.this.getPreviewItemList().size();
          }
          AppMethodBeat.o(227813);
        }
      }, 200L);
      AppMethodBeat.o(227824);
      return;
    }
    if (getOnDataChangedListener() != null)
    {
      getOnDataChangedListener();
      getPreviewItemList().size();
    }
    AppMethodBeat.o(227824);
  }
  
  public final void a(BaseAppBrandRecentView.b paramb, e parame, int paramInt)
  {
    AppMethodBeat.i(227814);
    super.a(paramb, parame, paramInt);
    if ((parame != null) && (parame.type == 0))
    {
      paramb.titleTv.setVisibility(4);
      paramb.nnL.setImageResource(2131691193);
    }
    if (d.cak())
    {
      if ((parame == null) || (paramb == null) || (paramb.aus == null))
      {
        AppMethodBeat.o(227814);
        return;
      }
      if (parame.type == 3)
      {
        paramb.aus.setVisibility(4);
        paramb.aus.getLayoutParams().width = 0;
      }
      int i = (int)f.ey(getContext());
      paramb.oDp.getLayoutParams().width = (com.tencent.mm.cb.a.aH(getContext(), 2131165586) * 2 + i);
      paramb.oDp.getLayoutParams().height = (com.tencent.mm.cb.a.aH(getContext(), 2131165586) * 2 + i);
      paramb.nnL.getLayoutParams().width = i;
      paramb.nnL.getLayoutParams().height = i;
      paramb.ooB.getLayoutParams().width = i;
      paramb.ooB.getLayoutParams().height = i;
      i = getCurrentPage();
      int j = p.AH(i);
      int k = d.getCompletelyCountPerPage();
      d.ccS();
      k = (i + 1) * k + 1;
      Log.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt) });
      if (paramInt == k)
      {
        paramb.aus.animate().alpha(0.3F).setDuration(1L).start();
        AppMethodBeat.o(227814);
        return;
      }
      if (parame.oBV)
      {
        paramb.aus.setVisibility(4);
        AppMethodBeat.o(227814);
        return;
      }
      paramb.aus.setVisibility(0);
      paramb.aus.setAlpha(1.0F);
    }
    AppMethodBeat.o(227814);
  }
  
  public final void bX(List<e> paramList)
  {
    AppMethodBeat.i(227820);
    if (!d.cak()) {
      paramList.add(new e(0));
    }
    if (d.cak())
    {
      d.ccS();
      paramList.add(0, new e(3));
    }
    AppMethodBeat.o(227820);
  }
  
  protected final boolean ccX()
  {
    boolean bool = this.oDD;
    this.oDD = false;
    return bool;
  }
  
  protected int getCompletelyCountPerPage()
  {
    AppMethodBeat.i(227816);
    int i = d.getCompletelyCountPerPage();
    AppMethodBeat.o(227816);
    return i;
  }
  
  public int getCustomItemCount()
  {
    AppMethodBeat.i(227821);
    if (!d.cak())
    {
      AppMethodBeat.o(227821);
      return 1;
    }
    if (d.cak())
    {
      d.ccS();
      AppMethodBeat.o(227821);
      return 1;
    }
    AppMethodBeat.o(227821);
    return 0;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(227826);
    int i = f.ev(getContext());
    AppMethodBeat.o(227826);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131493146;
  }
  
  protected int getLoadCount()
  {
    AppMethodBeat.i(227817);
    if (this.oDe == AppBrandRecentView.f.oBY)
    {
      AppMethodBeat.o(227817);
      return 50;
    }
    if (this.oDe == AppBrandRecentView.f.oBZ)
    {
      int i = d.byo();
      AppMethodBeat.o(227817);
      return i;
    }
    AppMethodBeat.o(227817);
    return 50;
  }
  
  public List<e> getPreviewItemList()
  {
    AppMethodBeat.i(227828);
    List localList = super.getPreviewItemList();
    AppMethodBeat.o(227828);
    return localList;
  }
  
  protected int getShowCount()
  {
    AppMethodBeat.i(227818);
    int i;
    if (this.oDe == AppBrandRecentView.f.oBY)
    {
      i = d.omI;
      AppMethodBeat.o(227818);
      return i;
    }
    if (this.oDe == AppBrandRecentView.f.oBZ)
    {
      i = d.byo();
      AppMethodBeat.o(227818);
      return i;
    }
    AppMethodBeat.o(227818);
    return 50;
  }
  
  protected float getShowCountPerPage()
  {
    AppMethodBeat.i(227815);
    float f = d.getShowCountPerPage();
    AppMethodBeat.o(227815);
    return f;
  }
  
  protected String getType()
  {
    AppMethodBeat.i(227819);
    String str = ConversationAppBrandRecentView.class.getSimpleName();
    AppMethodBeat.o(227819);
    return str;
  }
  
  protected final void init(Context paramContext)
  {
    AppMethodBeat.i(227822);
    super.init(paramContext);
    this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
    super.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(227808);
        if (ConversationAppBrandRecentView.a(ConversationAppBrandRecentView.this) != null) {
          ConversationAppBrandRecentView.a(ConversationAppBrandRecentView.this).a(paramAnonymousView, paramAnonymouse, paramAnonymousFloat1, paramAnonymousFloat2);
        }
        if (paramAnonymouse.type == 0)
        {
          ((t)g.af(t.class)).K(ConversationAppBrandRecentView.this.getContext(), 13);
          AppMethodBeat.o(227808);
          return false;
        }
        ConversationAppBrandRecentView.this.setLayoutFrozen(true);
        paramAnonymousView = new AppBrandStatObject();
        if (ConversationAppBrandRecentView.this.oDe == AppBrandRecentView.f.oBZ) {}
        for (int i = 1104;; i = 1089)
        {
          paramAnonymousView.scene = i;
          ((r)g.af(r.class)).a(ConversationAppBrandRecentView.this.getContext(), paramAnonymouse.ooj.username, null, paramAnonymouse.ooj.iOo, -1, null, paramAnonymousView);
          break;
        }
      }
      
      public final boolean b(View paramAnonymousView, final e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(227809);
        if (ConversationAppBrandRecentView.a(ConversationAppBrandRecentView.this) != null) {
          ConversationAppBrandRecentView.a(ConversationAppBrandRecentView.this).b(paramAnonymousView, paramAnonymouse, paramAnonymousFloat1, paramAnonymousFloat2);
        }
        Log.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if (paramAnonymouse.type != 0) {
          new com.tencent.mm.ui.widget.b.a(ConversationAppBrandRecentView.this.getContext()).a(paramAnonymousView, new View.OnCreateContextMenuListener()new o.g
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              AppMethodBeat.i(227806);
              if (ConversationAppBrandRecentView.b(ConversationAppBrandRecentView.this) != null) {
                ConversationAppBrandRecentView.b(ConversationAppBrandRecentView.this).onCreateContextMenu(paramAnonymous2ContextMenu, paramAnonymous2View, paramAnonymous2ContextMenuInfo);
              }
              paramAnonymous2ContextMenu.add(0, 1, paramAnonymous2ContextMenu.size() + 1, ConversationAppBrandRecentView.this.getContext().getResources().getString(2131758283));
              AppMethodBeat.o(227806);
            }
          }, new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(227807);
              if (ConversationAppBrandRecentView.c(ConversationAppBrandRecentView.this) != null) {
                ConversationAppBrandRecentView.c(ConversationAppBrandRecentView.this);
              }
              if ((paramAnonymous2MenuItem.getItemId() == 1) && (paramAnonymouse.position >= 0))
              {
                ConversationAppBrandRecentView.d(ConversationAppBrandRecentView.this);
                Log.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s, mType: %s", new Object[] { Integer.valueOf(paramAnonymouse.position), ConversationAppBrandRecentView.this.oDe });
                if (ConversationAppBrandRecentView.this.oDe != AppBrandRecentView.f.oBY) {
                  break label207;
                }
                ((ah)g.af(ah.class)).bi(paramAnonymouse.ooj.username, paramAnonymouse.ooj.iOo);
              }
              for (;;)
              {
                Log.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo Delete %s, pos: %d", new Object[] { paramAnonymouse.ooj.nickname, Integer.valueOf(paramAnonymouse.position) });
                ConversationAppBrandRecentView.this.AD(paramAnonymouse.position);
                AppMethodBeat.o(227807);
                return;
                label207:
                if (ConversationAppBrandRecentView.this.oDe == AppBrandRecentView.f.oBZ) {
                  ((ag)g.af(ag.class)).bh(paramAnonymouse.ooj.username, paramAnonymouse.ooj.iOo);
                }
              }
            }
          }, (int)paramAnonymousFloat1, (int)paramAnonymousFloat2);
        }
        AppMethodBeat.o(227809);
        return false;
      }
    });
    if (d.cak()) {
      super.setOnScrollPageListener(new p.a()
      {
        public final void V(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(227811);
          if (ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this) != null) {
            ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this).V(paramAnonymousInt, paramAnonymousBoolean);
          }
          AppMethodBeat.o(227811);
        }
        
        public final void c(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(227810);
          Log.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(ConversationAppBrandRecentView.this.getCurrentPage()) });
          ConversationAppBrandRecentView.e(ConversationAppBrandRecentView.this);
          if (ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this) != null) {
            ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this).c(paramAnonymousRecyclerView, paramAnonymousInt);
          }
          AppMethodBeat.o(227810);
        }
        
        public final void c(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(227812);
          if (ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this) != null) {
            ConversationAppBrandRecentView.f(ConversationAppBrandRecentView.this).c(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(227812);
        }
      });
    }
    AppMethodBeat.o(227822);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(227825);
    Log.i("MicroMsg.ConversationAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)g.aAe().azG()).toString(), Integer.valueOf(paramMStorageEventData.eventId), this.oDe });
    if (ccX())
    {
      AppMethodBeat.o(227825);
      return;
    }
    refresh();
    AppMethodBeat.o(227825);
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.oDB = paramOnCreateContextMenuListener;
  }
  
  public void setIgnoreNotify(boolean paramBoolean)
  {
    this.oDD = paramBoolean;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    this.oDC = parama;
  }
  
  public void setOnBindCustomViewHolderListener(a parama)
  {
    this.oDA = parama;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.oDv = paramb;
  }
  
  public void setOnScrollPageListener(p.a parama)
  {
    this.oDw = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.ConversationAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */