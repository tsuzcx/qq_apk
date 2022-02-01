package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.widget.a.h;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.mm.w.a.a.a.b;
import com.tencent.mm.w.a.a.a.e;
import com.tencent.mm.w.a.a.a.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet;", "T", "", "()V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "setBottomSheet", "(Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "forceDarkMode", "", "getForceDarkMode", "()Z", "setForceDarkMode", "(Z)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "config", "", "defaultSelectIndex", "", "createData", "source", "(Ljava/lang/Object;)Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "createItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "forceDark", "force", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "isShowing", "onDismiss", "", "onItemClick", "position", "data", "show", "context", "Landroid/content/Context;", "ConditionData", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class m<T>
{
  protected h Epc;
  public boolean FyH;
  final ArrayList<a<T>> pUj = new ArrayList();
  private String title = "";
  
  private static final void a(m paramm)
  {
    s.u(paramm, "this$0");
  }
  
  private static final void a(m paramm, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    paramm.getBottomSheet().cyW();
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public abstract boolean a(a<T> parama);
  
  public final m<T> c(String paramString, List<? extends T> paramList, int paramInt)
  {
    s.u(paramString, "title");
    s.u(paramList, "dataList");
    this.title = paramString;
    this.pUj.clear();
    paramString = this.pUj;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(fH(((Iterator)localObject).next()));
    }
    paramString.addAll((Collection)paramList);
    if ((paramInt >= 0) && (paramInt < this.pUj.size()))
    {
      paramString = (a)p.ae((List)this.pUj, paramInt);
      if (paramString != null) {
        paramString.duj = true;
      }
    }
    return this;
  }
  
  public abstract a<T> fH(T paramT);
  
  public abstract f<?> flg();
  
  protected final h getBottomSheet()
  {
    h localh = this.Epc;
    if (localh != null) {
      return localh;
    }
    s.bIx("bottomSheet");
    return null;
  }
  
  public final void hs(Context paramContext)
  {
    s.u(paramContext, "context");
    Object localObject = new h(paramContext);
    s.u(localObject, "<set-?>");
    this.Epc = ((h)localObject);
    h localh = getBottomSheet().aFa(a.f.finder_single_select_bottom_sheet);
    localh.rootView.setBackground(null);
    localh.rootView.findViewById(a.e.finder_live_close_btn_group).setOnClickListener(new m..ExternalSyntheticLambda0(this));
    TextView localTextView = (TextView)localh.rootView.findViewById(a.e.single_select_bottom_sheet_title_tv);
    localObject = (WxRecyclerView)localh.rootView.findViewById(a.e.single_select_bottom_sheet_rv);
    if (this.FyH)
    {
      localh.jHO();
      localTextView.setTextColor(paramContext.getResources().getColor(a.b.BW_100_Alpha_0_8));
    }
    localTextView.setText((CharSequence)this.title);
    paramContext = new WxRecyclerAdapter((g)new b(this), this.pUj);
    paramContext.agOe = ((i.c)new c(this));
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)paramContext);
    getBottomSheet().agfD = new m..ExternalSyntheticLambda1(this);
    getBottomSheet().dDn();
  }
  
  public final boolean isShowing()
  {
    return getBottomSheet().isShowing();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "T", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "data", "checked", "", "(Ljava/lang/Object;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a<T>
    implements cc
  {
    final T cpt;
    boolean duj;
    
    private a(T paramT)
    {
      this.cpt = paramT;
      this.duj = false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$getAdapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g
  {
    b(m<T> paramm) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(344001);
      f localf = this.GCd.flg();
      AppMethodBeat.o(344001);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$show$1$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements i.c<j>
  {
    c(m<T> paramm) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.m
 * JD-Core Version:    0.7.0.1
 */