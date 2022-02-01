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
import com.tencent.mm.al.n;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.view.a.b;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveAfterStateView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "backBtn", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "titleTv", "finish", "", "getLayoutId", "initViews", "loadMembers", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "start", "plugin-logic_release"})
public final class LiveAfterStateView
  extends RelativeLayout
  implements com.tencent.mm.al.g
{
  private TextView Kwd;
  private ViewGroup Kyh;
  private ViewGroup Kyi;
  private TextView Kyj;
  private TextView Kyk;
  private TextView Kyl;
  private final b Kym;
  private RecyclerView fPw;
  private ProgressBar fQC;
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(203408);
    AppMethodBeat.o(203408);
  }
  
  public LiveAfterStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203407);
    this.Kym = new b();
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    this.Kyh = ((ViewGroup)findViewById(2131307435));
    this.Kyi = ((ViewGroup)findViewById(2131307441));
    this.fPw = ((RecyclerView)findViewById(2131307433));
    this.Kyj = ((TextView)findViewById(2131307439));
    this.Kyk = ((TextView)findViewById(2131307437));
    this.Kyl = ((TextView)findViewById(2131307443));
    this.fQC = ((ProgressBar)findViewById(2131307434));
    this.Kwd = ((TextView)findViewById(2131307438));
    paramContext = this.fPw;
    if (paramContext != null)
    {
      getContext();
      paramContext.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramContext = this.fPw;
    if (paramContext != null)
    {
      paramContext.setAdapter((RecyclerView.a)this.Kym);
      AppMethodBeat.o(203407);
      return;
    }
    AppMethodBeat.o(203407);
  }
  
  public final int getLayoutId()
  {
    return 2131496274;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203406);
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
        AppMethodBeat.o(203406);
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
        AppMethodBeat.o(203406);
        return;
      }
    }
    AppMethodBeat.o(203406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAfterStateView
 * JD-Core Version:    0.7.0.1
 */