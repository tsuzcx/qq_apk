package com.tencent.mm.live.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.view.a.b;
import com.tencent.mm.live.view.a.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIC;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "getLayoutId", "", "initActionBar", "", "initViews", "loadMembers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "plugin-logic_release"})
public final class LiveUIC
  extends MMActivity
  implements i
{
  private RecyclerView jLl;
  private ProgressBar jMF;
  private TextView kGi;
  private TextView kIA;
  private TextView kIB;
  private final b kIC;
  private ViewGroup kIx;
  private ViewGroup kIy;
  private TextView kIz;
  
  public LiveUIC()
  {
    AppMethodBeat.i(189696);
    this.kIC = new b();
    AppMethodBeat.o(189696);
  }
  
  public final int getLayoutId()
  {
    return b.f.live_after_members_states_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(189686);
    super.onCreate(paramBundle);
    paramBundle = h.aHF();
    p.j(paramBundle, "MMKernel.network()");
    paramBundle.aGY().a(3700, (i)this);
    paramBundle = h.ae(n.class);
    p.j(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    paramBundle = ((n)paramBundle).bbL();
    u localu = u.kwz;
    paramBundle = paramBundle.RG(u.aOm());
    p.j(paramBundle, "contact");
    setMMTitle(paramBundle.ays());
    setBackBtn((MenuItem.OnMenuItemClickListener)new LiveUIC.a(this));
    this.kIx = ((ViewGroup)findViewById(b.e.live_after_members_states_online_total_group));
    this.kIy = ((ViewGroup)findViewById(b.e.live_after_members_states_total_group));
    this.jLl = ((RecyclerView)findViewById(b.e.live_after_members_states_content_view));
    this.kIz = ((TextView)findViewById(b.e.live_after_members_states_sub_title));
    this.kIA = ((TextView)findViewById(b.e.live_after_members_states_online_total_number));
    this.kIB = ((TextView)findViewById(b.e.live_after_members_states_total_number));
    this.jMF = ((ProgressBar)findViewById(b.e.live_after_members_states_loading));
    this.kGi = ((TextView)findViewById(b.e.live_after_members_states_retry_tip));
    paramBundle = this.jLl;
    if (paramBundle != null)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramBundle = this.jLl;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.kIC);
    }
    paramBundle = u.kwz;
    int i = v.Pu(u.aOm());
    paramBundle = this.kIA;
    if (paramBundle != null)
    {
      localu = u.kwz;
      paramBundle.setText((CharSequence)String.valueOf(u.aOr().SOs));
    }
    paramBundle = this.kIB;
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)String.valueOf(i));
    }
    paramBundle = this.jMF;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.kGi;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.jLl;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = com.tencent.mm.live.b.o.kvA;
    paramBundle = u.kwz;
    com.tencent.mm.live.b.o.NY(u.aOm());
    AppMethodBeat.o(189686);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(189687);
    super.onDestroy();
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(3700, (i)this);
    AppMethodBeat.o(189687);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(189693);
    if ((paramq instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.kIA;
        if (paramString != null)
        {
          paramq = u.kwz;
          paramString.setText((CharSequence)String.valueOf(u.aOr().SOs));
        }
        paramString = this.jMF;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.kGi;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.jLl;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = u.kwz;
        paramString = u.aOo();
        paramq = u.kwz;
        paramString = (kotlin.o)paramString.get(u.aOm());
        if (paramString != null) {}
        for (paramString = (ArrayList)paramString.Mx;; paramString = null)
        {
          paramq = new ArrayList();
          if (paramString == null) {
            break;
          }
          paramString = ((Iterable)paramString).iterator();
          while (paramString.hasNext()) {
            paramq.add(new g((String)paramString.next()));
          }
        }
        this.kIC.ag((List)paramq);
        this.kIC.notifyDataSetChanged();
        AppMethodBeat.o(189693);
        return;
      }
      paramString = this.jMF;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.kGi;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.jLl;
      if (paramString != null)
      {
        paramString.setVisibility(8);
        AppMethodBeat.o(189693);
        return;
      }
    }
    AppMethodBeat.o(189693);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIC
 * JD-Core Version:    0.7.0.1
 */