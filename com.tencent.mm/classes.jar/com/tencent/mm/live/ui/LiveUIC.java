package com.tencent.mm.live.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.o;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/LiveUIC;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "getLayoutId", "", "initActionBar", "", "initViews", "loadMembers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "plugin-logic_release"})
public final class LiveUIC
  extends MMActivity
  implements i
{
  private TextView hRL;
  private ViewGroup hTY;
  private ViewGroup hTZ;
  private TextView hUa;
  private TextView hUb;
  private TextView hUc;
  private final com.tencent.mm.live.view.a.b hUd;
  private RecyclerView hak;
  private ProgressBar hbv;
  
  public LiveUIC()
  {
    AppMethodBeat.i(208388);
    this.hUd = new com.tencent.mm.live.view.a.b();
    AppMethodBeat.o(208388);
  }
  
  public final int getLayoutId()
  {
    return 2131495222;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208385);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.kernel.g.aAg();
    p.g(paramBundle, "MMKernel.network()");
    paramBundle.azz().a(3700, (i)this);
    paramBundle = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).aSN();
    x localx = x.hJf;
    paramBundle = paramBundle.Kn(x.aGm());
    p.g(paramBundle, "contact");
    setMMTitle(paramBundle.arJ());
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.hTY = ((ViewGroup)findViewById(2131303263));
    this.hTZ = ((ViewGroup)findViewById(2131303269));
    this.hak = ((RecyclerView)findViewById(2131303261));
    this.hUa = ((TextView)findViewById(2131303267));
    this.hUb = ((TextView)findViewById(2131303265));
    this.hUc = ((TextView)findViewById(2131303271));
    this.hbv = ((ProgressBar)findViewById(2131303262));
    this.hRL = ((TextView)findViewById(2131303266));
    paramBundle = this.hak;
    if (paramBundle != null)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramBundle = this.hak;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.hUd);
    }
    paramBundle = x.hJf;
    int i = v.Ie(x.aGm());
    paramBundle = this.hUb;
    if (paramBundle != null)
    {
      localx = x.hJf;
      paramBundle.setText((CharSequence)String.valueOf(x.aGr().LIa));
    }
    paramBundle = this.hUc;
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)String.valueOf(i));
    }
    paramBundle = this.hbv;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.hRL;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.hak;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = r.hIg;
    paramBundle = x.hJf;
    r.GN(x.aGm());
    AppMethodBeat.o(208385);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(208386);
    super.onDestroy();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3700, (i)this);
    AppMethodBeat.o(208386);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(208387);
    if ((paramq instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.hUb;
        if (paramString != null)
        {
          paramq = x.hJf;
          paramString.setText((CharSequence)String.valueOf(x.aGr().LIa));
        }
        paramString = this.hbv;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hRL;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hak;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = x.hJf;
        paramString = x.aGo();
        paramq = x.hJf;
        paramString = (o)paramString.get(x.aGm());
        if (paramString != null) {}
        for (paramString = (ArrayList)paramString.first;; paramString = null)
        {
          paramq = new ArrayList();
          if (paramString == null) {
            break;
          }
          paramString = ((Iterable)paramString).iterator();
          while (paramString.hasNext()) {
            paramq.add(new com.tencent.mm.live.view.a.g((String)paramString.next()));
          }
        }
        this.hUd.ai((List)paramq);
        this.hUd.notifyDataSetChanged();
        AppMethodBeat.o(208387);
        return;
      }
      paramString = this.hbv;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.hRL;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.hak;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        AppMethodBeat.o(208387);
        return;
      }
    }
    AppMethodBeat.o(208387);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(LiveUIC paramLiveUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(208384);
      this.hUe.finish();
      AppMethodBeat.o(208384);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIC
 * JD-Core Version:    0.7.0.1
 */