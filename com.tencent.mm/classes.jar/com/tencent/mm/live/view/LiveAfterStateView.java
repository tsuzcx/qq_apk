package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.model.a.d;
import com.tencent.mm.live.model.u;
import com.tencent.mm.live.view.a.b;
import com.tencent.mm.live.view.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/LiveAfterStateView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "backBtn", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "titleTv", "finish", "", "getLayoutId", "initViews", "loadMembers", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "start", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveAfterStateView
  extends RelativeLayout
  implements h
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
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(246184);
    AppMethodBeat.o(246184);
  }
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246177);
    this.nlf = new b();
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    this.nla = ((ViewGroup)findViewById(b.e.live_after_members_states_online_total_group));
    this.nlb = ((ViewGroup)findViewById(b.e.live_after_members_states_total_group));
    this.mkw = ((RecyclerView)findViewById(b.e.live_after_members_states_content_view));
    this.nlc = ((TextView)findViewById(b.e.live_after_members_states_sub_title));
    this.nld = ((TextView)findViewById(b.e.live_after_members_states_online_total_number));
    this.nle = ((TextView)findViewById(b.e.live_after_members_states_total_number));
    this.mlF = ((ProgressBar)findViewById(b.e.live_after_members_states_loading));
    this.njg = ((TextView)findViewById(b.e.live_after_members_states_retry_tip));
    paramContext = this.mkw;
    if (paramContext != null)
    {
      getContext();
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramContext = this.mkw;
    if (paramContext != null) {
      paramContext.setAdapter((RecyclerView.a)this.nlf);
    }
    AppMethodBeat.o(246177);
  }
  
  public final int getLayoutId()
  {
    return b.f.live_after_members_states_ui;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246199);
    if ((paramp instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
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
        AppMethodBeat.o(246199);
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
    AppMethodBeat.o(246199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAfterStateView
 * JD-Core Version:    0.7.0.1
 */