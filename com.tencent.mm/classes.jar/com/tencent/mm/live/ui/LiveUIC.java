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
import com.tencent.mm.ak.n;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/LiveUIC;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "getLayoutId", "", "initActionBar", "", "initViews", "loadMembers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "plugin-logic_release"})
public final class LiveUIC
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private RecyclerView fTr;
  private ProgressBar fUx;
  private TextView gCt;
  private ViewGroup gEH;
  private ViewGroup gEI;
  private TextView gEJ;
  private TextView gEK;
  private TextView gEL;
  private final com.tencent.mm.live.view.a.b gEM;
  
  public LiveUIC()
  {
    AppMethodBeat.i(190509);
    this.gEM = new com.tencent.mm.live.view.a.b();
    AppMethodBeat.o(190509);
  }
  
  public final int getLayoutId()
  {
    return 2131496283;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190506);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramBundle, "MMKernel.network()");
    paramBundle.agi().a(3700, (com.tencent.mm.ak.g)this);
    paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramBundle).awB();
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
    paramBundle = paramBundle.aNt(com.tencent.mm.live.b.g.akA());
    d.g.b.k.g(paramBundle, "contact");
    setMMTitle(paramBundle.aaS());
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.gEH = ((ViewGroup)findViewById(2131307511));
    this.gEI = ((ViewGroup)findViewById(2131307517));
    this.fTr = ((RecyclerView)findViewById(2131307509));
    this.gEJ = ((TextView)findViewById(2131307515));
    this.gEK = ((TextView)findViewById(2131307513));
    this.gEL = ((TextView)findViewById(2131307519));
    this.fUx = ((ProgressBar)findViewById(2131307510));
    this.gCt = ((TextView)findViewById(2131307514));
    paramBundle = this.fTr;
    if (paramBundle != null)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = this.fTr;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.gEM);
    }
    paramBundle = com.tencent.mm.live.b.g.guG;
    int i = com.tencent.mm.model.q.wb(com.tencent.mm.live.b.g.akA());
    paramBundle = this.gEK;
    if (paramBundle != null)
    {
      localg = com.tencent.mm.live.b.g.guG;
      paramBundle.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.akF().EQE));
    }
    paramBundle = this.gEL;
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)String.valueOf(i));
    }
    paramBundle = this.fUx;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.gCt;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.fTr;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = i.gvw;
    paramBundle = com.tencent.mm.live.b.g.guG;
    i.uW(com.tencent.mm.live.b.g.akA());
    AppMethodBeat.o(190506);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(190507);
    super.onDestroy();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(3700, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190507);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190508);
    if ((paramn instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.gEK;
        if (paramString != null)
        {
          paramn = com.tencent.mm.live.b.g.guG;
          paramString.setText((CharSequence)String.valueOf(com.tencent.mm.live.b.g.akF().EQE));
        }
        paramString = this.fUx;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gCt;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.fTr;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = com.tencent.mm.live.b.g.guG;
        paramString = com.tencent.mm.live.b.g.akC();
        paramn = com.tencent.mm.live.b.g.guG;
        paramString = (o)paramString.get(com.tencent.mm.live.b.g.akA());
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
        this.gEM.Z((List)paramn);
        this.gEM.notifyDataSetChanged();
        AppMethodBeat.o(190508);
        return;
      }
      paramString = this.fUx;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.gCt;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.fTr;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        AppMethodBeat.o(190508);
        return;
      }
    }
    AppMethodBeat.o(190508);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(LiveUIC paramLiveUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(190505);
      this.gEN.finish();
      AppMethodBeat.o(190505);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIC
 * JD-Core Version:    0.7.0.1
 */