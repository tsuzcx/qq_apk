package com.tencent.mm.live.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.view.a.b;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/LiveAfterStateView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "backBtn", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "titleTv", "finish", "", "getLayoutId", "initViews", "loadMembers", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "start", "plugin-logic_release"})
public final class LiveAfterStateView
  extends RelativeLayout
  implements f
{
  private TextView gWd;
  private ViewGroup gYr;
  private ViewGroup gYs;
  private TextView gYt;
  private TextView gYu;
  private TextView gYv;
  private final b gYw;
  private RecyclerView gmV;
  private ProgressBar gnZ;
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(212904);
    AppMethodBeat.o(212904);
  }
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(212903);
    this.gYw = new b();
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    this.gYr = ((ViewGroup)findViewById(2131307511));
    this.gYs = ((ViewGroup)findViewById(2131307517));
    this.gmV = ((RecyclerView)findViewById(2131307509));
    this.gYt = ((TextView)findViewById(2131307515));
    this.gYu = ((TextView)findViewById(2131307513));
    this.gYv = ((TextView)findViewById(2131307519));
    this.gnZ = ((ProgressBar)findViewById(2131307510));
    this.gWd = ((TextView)findViewById(2131307514));
    paramContext = this.gmV;
    if (paramContext != null)
    {
      getContext();
      paramContext.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramContext = this.gmV;
    if (paramContext != null)
    {
      paramContext.setAdapter((RecyclerView.a)this.gYw);
      AppMethodBeat.o(212903);
      return;
    }
    AppMethodBeat.o(212903);
  }
  
  public final int getLayoutId()
  {
    return 2131496283;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212902);
    if ((paramn instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
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
        AppMethodBeat.o(212902);
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
        AppMethodBeat.o(212902);
        return;
      }
    }
    AppMethodBeat.o(212902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAfterStateView
 * JD-Core Version:    0.7.0.1
 */