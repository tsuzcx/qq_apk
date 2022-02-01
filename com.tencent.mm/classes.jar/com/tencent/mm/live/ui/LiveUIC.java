package com.tencent.mm.live.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIC;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "getLayoutId", "", "initActionBar", "", "initViews", "loadMembers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "plugin-logic_release"})
public final class LiveUIC
  extends MMActivity
  implements f
{
  private TextView gWd;
  private ViewGroup gYr;
  private ViewGroup gYs;
  private TextView gYt;
  private TextView gYu;
  private TextView gYv;
  private final com.tencent.mm.live.view.a.b gYw;
  private RecyclerView gmV;
  private ProgressBar gnZ;
  
  public LiveUIC()
  {
    AppMethodBeat.i(212799);
    this.gYw = new com.tencent.mm.live.view.a.b();
    AppMethodBeat.o(212799);
  }
  
  public final int getLayoutId()
  {
    return 2131496283;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212796);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.ajB();
    p.g(paramBundle, "MMKernel.network()");
    paramBundle.aiU().a(3700, (f)this);
    paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azp();
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
    paramBundle = paramBundle.Bf(com.tencent.mm.live.b.g.anm());
    p.g(paramBundle, "contact");
    setMMTitle(paramBundle.adv());
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.gYr = ((ViewGroup)findViewById(2131307511));
    this.gYs = ((ViewGroup)findViewById(2131307517));
    this.gmV = ((RecyclerView)findViewById(2131307509));
    this.gYt = ((TextView)findViewById(2131307515));
    this.gYu = ((TextView)findViewById(2131307513));
    this.gYv = ((TextView)findViewById(2131307519));
    this.gnZ = ((ProgressBar)findViewById(2131307510));
    this.gWd = ((TextView)findViewById(2131307514));
    paramBundle = this.gmV;
    if (paramBundle != null)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = this.gmV;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.gYw);
    }
    paramBundle = com.tencent.mm.live.b.g.gOr;
    int i = com.tencent.mm.model.q.yS(com.tencent.mm.live.b.g.anm());
    paramBundle = this.gYu;
    if (paramBundle != null)
    {
      localg = com.tencent.mm.live.b.g.gOr;
      paramBundle.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.ans().GzV));
    }
    paramBundle = this.gYv;
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)String.valueOf(i));
    }
    paramBundle = this.gnZ;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.gWd;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.gmV;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = i.gPh;
    paramBundle = com.tencent.mm.live.b.g.gOr;
    i.xM(com.tencent.mm.live.b.g.anm());
    AppMethodBeat.o(212796);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212797);
    super.onDestroy();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(3700, (f)this);
    AppMethodBeat.o(212797);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212798);
    if ((paramn instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.gYu;
        if (paramString != null)
        {
          paramn = com.tencent.mm.live.b.g.gOr;
          paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.ans().GzV));
        }
        paramString = this.gnZ;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gWd;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gmV;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = com.tencent.mm.live.b.g.gOr;
        paramString = com.tencent.mm.live.b.g.ano();
        paramn = com.tencent.mm.live.b.g.gOr;
        paramString = (o)paramString.get(com.tencent.mm.live.b.g.anm());
        if (paramString != null) {}
        for (paramString = (ArrayList)paramString.first;; paramString = null)
        {
          paramn = new ArrayList();
          if (paramString == null) {
            break;
          }
          paramString = ((Iterable)paramString).iterator();
          while (paramString.hasNext()) {
            paramn.add(new com.tencent.mm.live.view.a.g((String)paramString.next()));
          }
        }
        this.gYw.aa((List)paramn);
        this.gYw.notifyDataSetChanged();
        AppMethodBeat.o(212798);
        return;
      }
      paramString = this.gnZ;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.gWd;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.gmV;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        AppMethodBeat.o(212798);
        return;
      }
    }
    AppMethodBeat.o(212798);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(LiveUIC paramLiveUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(212795);
      this.gYx.finish();
      AppMethodBeat.o(212795);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIC
 * JD-Core Version:    0.7.0.1
 */