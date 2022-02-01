package com.tencent.mm.live.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.view.a.b;
import com.tencent.mm.live.view.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveAfterStateView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "backBtn", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "titleTv", "finish", "", "getLayoutId", "initViews", "loadMembers", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "start", "plugin-logic_release"})
public final class LiveAfterStateView
  extends RelativeLayout
  implements i
{
  private TextView hRL;
  private ViewGroup hTY;
  private ViewGroup hTZ;
  private TextView hUa;
  private TextView hUb;
  private TextView hUc;
  private final b hUd;
  private RecyclerView hak;
  private ProgressBar hbv;
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(208491);
    AppMethodBeat.o(208491);
  }
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208490);
    this.hUd = new b();
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    this.hTY = ((ViewGroup)findViewById(2131303263));
    this.hTZ = ((ViewGroup)findViewById(2131303269));
    this.hak = ((RecyclerView)findViewById(2131303261));
    this.hUa = ((TextView)findViewById(2131303267));
    this.hUb = ((TextView)findViewById(2131303265));
    this.hUc = ((TextView)findViewById(2131303271));
    this.hbv = ((ProgressBar)findViewById(2131303262));
    this.hRL = ((TextView)findViewById(2131303266));
    paramContext = this.hak;
    if (paramContext != null)
    {
      getContext();
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramContext = this.hak;
    if (paramContext != null)
    {
      paramContext.setAdapter((RecyclerView.a)this.hUd);
      AppMethodBeat.o(208490);
      return;
    }
    AppMethodBeat.o(208490);
  }
  
  public final int getLayoutId()
  {
    return 2131495222;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(208489);
    if ((paramq instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
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
            paramq.add(new g((String)paramString.next()));
          }
        }
        this.hUd.ai((List)paramq);
        this.hUd.notifyDataSetChanged();
        AppMethodBeat.o(208489);
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
        AppMethodBeat.o(208489);
        return;
      }
    }
    AppMethodBeat.o(208489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAfterStateView
 * JD-Core Version:    0.7.0.1
 */