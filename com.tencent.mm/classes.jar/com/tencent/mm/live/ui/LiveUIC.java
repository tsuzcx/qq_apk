package com.tencent.mm.live.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/LiveUIC;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "getLayoutId", "", "initActionBar", "", "initViews", "loadMembers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "plugin-logic_release"})
public final class LiveUIC
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private TextView Kwd;
  private ViewGroup Kyh;
  private ViewGroup Kyi;
  private TextView Kyj;
  private TextView Kyk;
  private TextView Kyl;
  private final com.tencent.mm.live.view.a.b Kym;
  private RecyclerView fPw;
  private ProgressBar fQC;
  
  public LiveUIC()
  {
    AppMethodBeat.i(203268);
    this.Kym = new com.tencent.mm.live.view.a.b();
    AppMethodBeat.o(203268);
  }
  
  public final int getLayoutId()
  {
    return 2131496274;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203265);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(paramBundle, "MMKernel.network()");
    paramBundle.aeS().a(3700, (com.tencent.mm.al.g)this);
    paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramBundle).apM();
    f localf = f.rGw;
    paramBundle = paramBundle.aHY(f.eNB());
    d.g.b.k.g(paramBundle, "contact");
    setMMTitle(paramBundle.ZX());
    setBackBtn((MenuItem.OnMenuItemClickListener)new LiveUIC.a(this));
    this.Kyh = ((ViewGroup)findViewById(2131307435));
    this.Kyi = ((ViewGroup)findViewById(2131307441));
    this.fPw = ((RecyclerView)findViewById(2131307433));
    this.Kyj = ((TextView)findViewById(2131307439));
    this.Kyk = ((TextView)findViewById(2131307437));
    this.Kyl = ((TextView)findViewById(2131307443));
    this.fQC = ((ProgressBar)findViewById(2131307434));
    this.Kwd = ((TextView)findViewById(2131307438));
    paramBundle = this.fPw;
    if (paramBundle != null)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = this.fPw;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.Kym);
    }
    paramBundle = f.rGw;
    int i = com.tencent.mm.model.q.rY(f.eNB());
    paramBundle = this.Kyk;
    if (paramBundle != null)
    {
      localf = f.rGw;
      paramBundle.setText((CharSequence)String.valueOf(f.eNG().LyP));
    }
    paramBundle = this.Kyl;
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)String.valueOf(i));
    }
    paramBundle = this.fQC;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.Kwd;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.fPw;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = h.xfu;
    paramBundle = f.rGw;
    h.aUq(f.eNB());
    AppMethodBeat.o(203265);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203266);
    super.onDestroy();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(3700, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(203266);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203267);
    if ((paramn instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.fQC;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Kwd;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.fPw;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = f.rGw;
        paramString = f.eND();
        paramn = f.rGw;
        paramString = (o)paramString.get(f.eNB());
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
        this.Kym.dx((List)paramn);
        this.Kym.notifyDataSetChanged();
        AppMethodBeat.o(203267);
        return;
      }
      paramString = this.fQC;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.Kwd;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.fPw;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        AppMethodBeat.o(203267);
        return;
      }
    }
    AppMethodBeat.o(203267);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIC
 * JD-Core Version:    0.7.0.1
 */