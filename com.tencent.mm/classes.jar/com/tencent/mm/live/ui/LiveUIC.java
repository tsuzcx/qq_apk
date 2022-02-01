package com.tencent.mm.live.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.model.a.d;
import com.tencent.mm.live.model.o;
import com.tencent.mm.live.model.u;
import com.tencent.mm.live.view.a.b;
import com.tencent.mm.live.view.a.f;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIC;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "getLayoutId", "", "initActionBar", "", "initViews", "loadMembers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveUIC
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private RecyclerView mkw;
  private ProgressBar mlF;
  private TextView njg;
  private ViewGroup nla;
  private ViewGroup nlb;
  private TextView nlc;
  private TextView nld;
  private TextView nle;
  private final b nlf;
  
  public LiveUIC()
  {
    AppMethodBeat.i(246274);
    this.nlf = new b();
    AppMethodBeat.o(246274);
  }
  
  private static final boolean a(LiveUIC paramLiveUIC, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(246278);
    kotlin.g.b.s.u(paramLiveUIC, "this$0");
    paramLiveUIC.finish();
    AppMethodBeat.o(246278);
    return true;
  }
  
  public final int getLayoutId()
  {
    return b.f.live_after_members_states_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246307);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.baD().mCm.a(3700, (com.tencent.mm.am.h)this);
    paramBundle = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    u localu = u.mZl;
    setMMTitle(paramBundle.JE(u.bhZ()).aSV());
    setBackBtn(new LiveUIC..ExternalSyntheticLambda0(this));
    this.nla = ((ViewGroup)findViewById(b.e.live_after_members_states_online_total_group));
    this.nlb = ((ViewGroup)findViewById(b.e.live_after_members_states_total_group));
    this.mkw = ((RecyclerView)findViewById(b.e.live_after_members_states_content_view));
    this.nlc = ((TextView)findViewById(b.e.live_after_members_states_sub_title));
    this.nld = ((TextView)findViewById(b.e.live_after_members_states_online_total_number));
    this.nle = ((TextView)findViewById(b.e.live_after_members_states_total_number));
    this.mlF = ((ProgressBar)findViewById(b.e.live_after_members_states_loading));
    this.njg = ((TextView)findViewById(b.e.live_after_members_states_retry_tip));
    paramBundle = this.mkw;
    if (paramBundle != null)
    {
      getContext();
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramBundle = this.mkw;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.nlf);
    }
    paramBundle = u.mZl;
    int i = v.getMembersCountByChatRoomName(u.bhZ());
    paramBundle = this.nld;
    if (paramBundle != null)
    {
      localu = u.mZl;
      paramBundle.setText((CharSequence)String.valueOf(u.bie().ZWw));
    }
    paramBundle = this.nle;
    if (paramBundle != null) {
      paramBundle.setText((CharSequence)String.valueOf(i));
    }
    paramBundle = this.mlF;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.njg;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.mkw;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = o.mZb;
    paramBundle = u.mZl;
    o.Gl(u.bhZ());
    AppMethodBeat.o(246307);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(246312);
    super.onDestroy();
    com.tencent.mm.kernel.h.baD().mCm.b(3700, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(246312);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246326);
    if ((paramp instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.nld;
        if (paramString != null)
        {
          paramp = u.mZl;
          paramString.setText((CharSequence)String.valueOf(u.bie().ZWw));
        }
        paramString = this.mlF;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.njg;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.mkw;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = u.mZl;
        paramString = u.bib();
        paramp = u.mZl;
        paramString = (r)paramString.get(u.bhZ());
        if (paramString == null) {}
        for (paramString = null;; paramString = (ArrayList)paramString.bsC)
        {
          paramp = new ArrayList();
          if (paramString == null) {
            break;
          }
          paramString = ((Iterable)paramString).iterator();
          while (paramString.hasNext()) {
            paramp.add(new f((String)paramString.next()));
          }
        }
        this.nlf.bH((List)paramp);
        this.nlf.bZE.notifyChanged();
        AppMethodBeat.o(246326);
        return;
      }
      paramString = this.mlF;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.njg;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.mkw;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
    AppMethodBeat.o(246326);
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