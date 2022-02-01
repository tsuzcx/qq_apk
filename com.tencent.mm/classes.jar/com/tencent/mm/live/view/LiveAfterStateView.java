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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.view.a.b;
import com.tencent.mm.live.view.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveAfterStateView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "backBtn", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "titleTv", "finish", "", "getLayoutId", "initViews", "loadMembers", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "start", "plugin-logic_release"})
public final class LiveAfterStateView
  extends RelativeLayout
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
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(188667);
    AppMethodBeat.o(188667);
  }
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(188665);
    this.kIC = new b();
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    this.kIx = ((ViewGroup)findViewById(b.e.live_after_members_states_online_total_group));
    this.kIy = ((ViewGroup)findViewById(b.e.live_after_members_states_total_group));
    this.jLl = ((RecyclerView)findViewById(b.e.live_after_members_states_content_view));
    this.kIz = ((TextView)findViewById(b.e.live_after_members_states_sub_title));
    this.kIA = ((TextView)findViewById(b.e.live_after_members_states_online_total_number));
    this.kIB = ((TextView)findViewById(b.e.live_after_members_states_total_number));
    this.jMF = ((ProgressBar)findViewById(b.e.live_after_members_states_loading));
    this.kGi = ((TextView)findViewById(b.e.live_after_members_states_retry_tip));
    paramContext = this.jLl;
    if (paramContext != null)
    {
      getContext();
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramContext = this.jLl;
    if (paramContext != null)
    {
      paramContext.setAdapter((RecyclerView.a)this.kIC);
      AppMethodBeat.o(188665);
      return;
    }
    AppMethodBeat.o(188665);
  }
  
  public final int getLayoutId()
  {
    return b.f.live_after_members_states_ui;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(188661);
    if ((paramq instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
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
        paramString = (o)paramString.get(u.aOm());
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
        AppMethodBeat.o(188661);
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
        AppMethodBeat.o(188661);
        return;
      }
    }
    AppMethodBeat.o(188661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAfterStateView
 * JD-Core Version:    0.7.0.1
 */