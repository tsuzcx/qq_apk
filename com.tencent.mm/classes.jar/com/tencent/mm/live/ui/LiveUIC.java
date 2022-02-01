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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/LiveUIC;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "getLayoutId", "", "initActionBar", "", "initViews", "loadMembers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "plugin-logic_release"})
public final class LiveUIC
  extends MMActivity
  implements f
{
  private TextView gYQ;
  private RecyclerView gpr;
  private ProgressBar gqv;
  private ViewGroup hbe;
  private ViewGroup hbf;
  private TextView hbg;
  private TextView hbh;
  private TextView hbi;
  private final com.tencent.mm.live.view.a.b hbj;
  
  public LiveUIC()
  {
    AppMethodBeat.i(216427);
    this.hbj = new com.tencent.mm.live.view.a.b();
    AppMethodBeat.o(216427);
  }
  
  public final int getLayoutId()
  {
    return 2131496283;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216424);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.ajQ();
    p.g(paramBundle, "MMKernel.network()");
    paramBundle.ajj().a(3700, (f)this);
    paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azF();
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
    paramBundle = paramBundle.BH(com.tencent.mm.live.b.g.anC());
    p.g(paramBundle, "contact");
    setMMTitle(paramBundle.adG());
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.hbe = ((ViewGroup)findViewById(2131307511));
    this.hbf = ((ViewGroup)findViewById(2131307517));
    this.gpr = ((RecyclerView)findViewById(2131307509));
    this.hbg = ((TextView)findViewById(2131307515));
    this.hbh = ((TextView)findViewById(2131307513));
    this.hbi = ((TextView)findViewById(2131307519));
    this.gqv = ((ProgressBar)findViewById(2131307510));
    this.gYQ = ((TextView)findViewById(2131307514));
    paramBundle = this.gpr;
    if (paramBundle != null)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = this.gpr;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.hbj);
    }
    paramBundle = com.tencent.mm.live.b.g.gQZ;
    int i = r.zC(com.tencent.mm.live.b.g.anC());
    paramBundle = this.hbh;
    if (paramBundle != null)
    {
      localg = com.tencent.mm.live.b.g.gQZ;
      paramBundle.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.anH().GTv));
    }
    paramBundle = this.hbi;
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)String.valueOf(i));
    }
    paramBundle = this.gqv;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.gYQ;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.gpr;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = i.gRP;
    paramBundle = com.tencent.mm.live.b.g.gQZ;
    i.yv(com.tencent.mm.live.b.g.anC());
    AppMethodBeat.o(216424);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(216425);
    super.onDestroy();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(3700, (f)this);
    AppMethodBeat.o(216425);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(216426);
    if ((paramn instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.hbh;
        if (paramString != null)
        {
          paramn = com.tencent.mm.live.b.g.gQZ;
          paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.anH().GTv));
        }
        paramString = this.gqv;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gYQ;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gpr;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = com.tencent.mm.live.b.g.gQZ;
        paramString = com.tencent.mm.live.b.g.anE();
        paramn = com.tencent.mm.live.b.g.gQZ;
        paramString = (o)paramString.get(com.tencent.mm.live.b.g.anC());
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
        this.hbj.aa((List)paramn);
        this.hbj.notifyDataSetChanged();
        AppMethodBeat.o(216426);
        return;
      }
      paramString = this.gqv;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.gYQ;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.gpr;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        AppMethodBeat.o(216426);
        return;
      }
    }
    AppMethodBeat.o(216426);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(LiveUIC paramLiveUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(216423);
      this.hbk.finish();
      AppMethodBeat.o(216423);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIC
 * JD-Core Version:    0.7.0.1
 */