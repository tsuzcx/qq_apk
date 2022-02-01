package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet;", "T", "", "()V", "bottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "getBottomSheet", "()Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "setBottomSheet", "(Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "forceDarkMode", "", "getForceDarkMode", "()Z", "setForceDarkMode", "(Z)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "config", "", "defaultSelectIndex", "", "createData", "source", "(Ljava/lang/Object;)Lcom/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$ConditionData;", "createItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "forceDark", "force", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onDismiss", "", "onItemClick", "position", "data", "show", "context", "Landroid/content/Context;", "ConditionData", "plugin-finder_release"})
public abstract class k<T>
{
  public boolean AZM;
  final ArrayList<k.a<T>> mXB = new ArrayList();
  private String title = "";
  protected e zrN;
  
  public abstract boolean a(k.a<T> parama);
  
  public final k<T> b(String paramString, List<? extends T> paramList, int paramInt)
  {
    p.k(paramString, "title");
    p.k(paramList, "dataList");
    this.title = paramString;
    this.mXB.clear();
    paramString = this.mXB;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(dt(((Iterator)localObject).next()));
    }
    paramString.addAll((Collection)paramList);
    if ((paramInt >= 0) && (paramInt < this.mXB.size()))
    {
      paramString = (k.a)j.M((List)this.mXB, paramInt);
      if (paramString != null) {
        paramString.bBh = true;
      }
    }
    return this;
  }
  
  public abstract k.a<T> dt(T paramT);
  
  protected final e eja()
  {
    e locale = this.zrN;
    if (locale == null) {
      p.bGy("bottomSheet");
    }
    return locale;
  }
  
  public abstract com.tencent.mm.view.recyclerview.e<?> ejb();
  
  public final void fX(final Context paramContext)
  {
    p.k(paramContext, "context");
    this.zrN = new e(paramContext);
    Object localObject1 = this.zrN;
    if (localObject1 == null) {
      p.bGy("bottomSheet");
    }
    localObject1 = ((e)localObject1).RB(b.g.finder_single_select_bottom_sheet);
    Object localObject2 = ((e)localObject1).oFW;
    p.j(localObject2, "rootView");
    ((View)localObject2).setBackground(null);
    TextView localTextView = (TextView)((e)localObject1).oFW.findViewById(b.f.single_select_bottom_sheet_title_tv);
    localObject2 = (WxRecyclerView)((e)localObject1).oFW.findViewById(b.f.single_select_bottom_sheet_rv);
    if (this.AZM)
    {
      ((e)localObject1).eij();
      localTextView.setTextColor(paramContext.getResources().getColor(b.c.BW_100_Alpha_0_8));
    }
    p.j(localTextView, "titleTv");
    localTextView.setText((CharSequence)this.title);
    localObject1 = new WxRecyclerAdapter((f)new b(this), this.mXB);
    ((h)localObject1).YSn = ((h.c)new c(this, paramContext));
    p.j(localObject2, "rv");
    ((WxRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((WxRecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
    paramContext = this.zrN;
    if (paramContext == null) {
      p.bGy("bottomSheet");
    }
    paramContext.a((e.b)new d(this));
    paramContext = this.zrN;
    if (paramContext == null) {
      p.bGy("bottomSheet");
    }
    paramContext.eik();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$getAdapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(286398);
      com.tencent.mm.view.recyclerview.e locale = this.AZN.ejb();
      AppMethodBeat.o(286398);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSingleSelectBottomSheet$show$1$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class c
    implements h.c<i>
  {
    c(k paramk, Context paramContext) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "onDismiss"})
  static final class d
    implements e.b
  {
    d(k paramk) {}
    
    public final void onDismiss() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.k
 * JD-Core Version:    0.7.0.1
 */