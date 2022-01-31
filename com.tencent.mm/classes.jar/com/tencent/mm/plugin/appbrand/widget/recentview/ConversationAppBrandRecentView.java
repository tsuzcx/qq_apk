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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.util.List;

public class ConversationAppBrandRecentView
  extends BaseAppBrandRecentView
{
  private static final int jvB;
  private AppBrandRecentView.b jhJ;
  private e.a jvA;
  private float jvC = 0.0F;
  private int jvD = 0;
  private ConversationAppBrandRecentView.a jvE = null;
  private View.OnCreateContextMenuListener jvF = null;
  private AppBrandRecentView.a jvG = null;
  private boolean jvH = false;
  private int mScreenWidth = 0;
  
  static
  {
    AppMethodBeat.i(134381);
    jvB = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 200);
    AppMethodBeat.o(134381);
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
    AppMethodBeat.i(134373);
    ab.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramv != null)
    {
      float f = paramv.aku.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramv.aku.setAlpha(0.3F);
        AppMethodBeat.o(134373);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.jvC))
      {
        f = 1.0F - (f - this.jvC) / this.jvD * 0.7F;
        ab.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramv.aku.setAlpha(f);
        AppMethodBeat.o(134373);
        return;
      }
      paramv.aku.setAlpha(1.0F);
    }
    AppMethodBeat.o(134373);
  }
  
  private int getItemPadding()
  {
    AppMethodBeat.i(134377);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.d.jdMethod_do(getContext());
    AppMethodBeat.o(134377);
    return i;
  }
  
  public final void a(BaseAppBrandRecentView.c paramc, a parama, int paramInt)
  {
    AppMethodBeat.i(134364);
    super.a(paramc, parama, paramInt);
    if ((parama != null) && (parama.type == 0))
    {
      paramc.titleTv.setVisibility(4);
      paramc.ivs.setImageResource(2131231739);
    }
    if ((!b.aPf()) || (parama == null) || (paramc == null) || (paramc.aku == null)) {}
    for (;;)
    {
      if (this.jvE != null) {
        this.jvE.a(paramc, paramInt);
      }
      AppMethodBeat.o(134364);
      return;
      if (parama.type == 3)
      {
        paramc.aku.setVisibility(4);
        paramc.aku.getLayoutParams().width = 0;
      }
      int i = (int)com.tencent.mm.plugin.appbrand.widget.desktop.d.dq(getContext());
      paramc.jft.getLayoutParams().width = (com.tencent.mm.cb.a.ap(getContext(), 2131427854) * 2 + i);
      paramc.jft.getLayoutParams().height = (com.tencent.mm.cb.a.ap(getContext(), 2131427854) * 2 + i);
      paramc.ivs.getLayoutParams().width = i;
      paramc.ivs.getLayoutParams().height = i;
      paramc.jfs.getLayoutParams().width = i;
      paramc.jfs.getLayoutParams().height = i;
      i = getCurrentPage();
      int j = e.qU(i);
      int k = e.qV(i);
      ab.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt) });
      if (paramInt == k)
      {
        paramc.aku.animate().alpha(0.3F).setDuration(1L).start();
      }
      else if (parama.iqO)
      {
        paramc.aku.setVisibility(4);
      }
      else
      {
        paramc.aku.setVisibility(0);
        paramc.aku.setAlpha(1.0F);
      }
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(134375);
    ab.i("MicroMsg.ConversationAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", new Object[] { ((h)g.RI().Rj()).toString(), Integer.valueOf(paramm.htj), this.jhO });
    if (aSi())
    {
      AppMethodBeat.o(134375);
      return;
    }
    refresh();
    AppMethodBeat.o(134375);
  }
  
  public final void aO(List<a> paramList)
  {
    AppMethodBeat.i(134370);
    if (!b.aPf()) {
      paramList.add(new a(0));
    }
    if (b.aPf())
    {
      b.aPh();
      paramList.add(0, new a(3));
    }
    AppMethodBeat.o(134370);
  }
  
  protected final boolean aSi()
  {
    boolean bool = this.jvH;
    this.jvH = false;
    return bool;
  }
  
  protected int getCompletelyCountPerPage()
  {
    AppMethodBeat.i(134366);
    int i = b.getCompletelyCountPerPage();
    AppMethodBeat.o(134366);
    return i;
  }
  
  public int getCustomItemCount()
  {
    AppMethodBeat.i(134371);
    if (!b.aPf())
    {
      AppMethodBeat.o(134371);
      return 1;
    }
    if (b.aPf())
    {
      b.aPh();
      AppMethodBeat.o(134371);
      return 1;
    }
    AppMethodBeat.o(134371);
    return 0;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(134376);
    int i = com.tencent.mm.plugin.appbrand.widget.desktop.d.dn(getContext());
    AppMethodBeat.o(134376);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2130968775;
  }
  
  protected int getLoadCount()
  {
    AppMethodBeat.i(134367);
    if (this.jhO == AppBrandRecentView.f.juq)
    {
      AppMethodBeat.o(134367);
      return 50;
    }
    if (this.jhO == AppBrandRecentView.f.jur)
    {
      int i = b.axA();
      AppMethodBeat.o(134367);
      return i;
    }
    AppMethodBeat.o(134367);
    return 50;
  }
  
  public List<a> getPreviewItemList()
  {
    AppMethodBeat.i(134378);
    List localList = super.getPreviewItemList();
    AppMethodBeat.o(134378);
    return localList;
  }
  
  protected int getShowCount()
  {
    AppMethodBeat.i(134368);
    int i;
    if (this.jhO == AppBrandRecentView.f.juq)
    {
      i = b.jdj;
      AppMethodBeat.o(134368);
      return i;
    }
    if (this.jhO == AppBrandRecentView.f.jur)
    {
      i = b.axA();
      AppMethodBeat.o(134368);
      return i;
    }
    AppMethodBeat.o(134368);
    return 50;
  }
  
  protected float getShowCountPerPage()
  {
    AppMethodBeat.i(134365);
    float f = b.getShowCountPerPage();
    AppMethodBeat.o(134365);
    return f;
  }
  
  protected String getType()
  {
    AppMethodBeat.i(134369);
    String str = ConversationAppBrandRecentView.class.getSimpleName();
    AppMethodBeat.o(134369);
    return str;
  }
  
  protected final void init(Context paramContext)
  {
    AppMethodBeat.i(134372);
    super.init(paramContext);
    this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
    super.setOnItemClickListener(new ConversationAppBrandRecentView.1(this));
    if (b.aPf()) {
      super.setOnScrollPageListener(new ConversationAppBrandRecentView.2(this));
    }
    AppMethodBeat.o(134372);
  }
  
  protected final void qP(int paramInt)
  {
    AppMethodBeat.i(134374);
    super.qP(paramInt);
    getPreviewItemList().remove(paramInt);
    getAdapter().bT(paramInt);
    getAdapter().an(paramInt, 5);
    if (this.jhO == AppBrandRecentView.f.juq)
    {
      al.p(new ConversationAppBrandRecentView.3(this), 200L);
      AppMethodBeat.o(134374);
      return;
    }
    if (getOnDataChangedListener() != null)
    {
      AppBrandRecentView.d locald = getOnDataChangedListener();
      getPreviewItemList().size();
      locald.aQm();
    }
    AppMethodBeat.o(134374);
  }
  
  public final boolean qQ(int paramInt)
  {
    AppMethodBeat.i(134379);
    int i = getCurrentPage();
    int j = b.getCompletelyCountPerPage();
    b.aPh();
    if ((i + 1) * j + 1 == paramInt)
    {
      AppMethodBeat.o(134379);
      return true;
    }
    AppMethodBeat.o(134379);
    return false;
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.jvF = paramOnCreateContextMenuListener;
  }
  
  public void setIgnoreNotify(boolean paramBoolean)
  {
    this.jvH = paramBoolean;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    this.jvG = parama;
  }
  
  public void setOnBindCustomViewHolderListener(ConversationAppBrandRecentView.a parama)
  {
    this.jvE = parama;
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.jhJ = paramb;
  }
  
  public void setOnScrollPageListener(e.a parama)
  {
    this.jvA = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */