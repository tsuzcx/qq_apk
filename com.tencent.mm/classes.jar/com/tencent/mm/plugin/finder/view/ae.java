package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.ui.widget.a.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet;", "", "context", "Landroid/content/Context;", "selectListener", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$Data;", "getContext", "()Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "inputCoinValueBottomPage", "Lcom/tencent/mm/plugin/finder/view/LiveChargeInputCoinValueBottomPage;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "selectBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "getSelectListener", "()Lkotlin/jvm/functions/Function1;", "createSelectView", "Landroid/view/View;", "onItemClick", "", "position", "data", "show", "", "update", "Callback", "Companion", "Data", "DataConvert", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
{
  public static final ae.b GEY;
  public WxRecyclerAdapter<ae.c> ALE;
  private WxRecyclerView AZd;
  final kotlin.g.a.b<Integer, ah> GEZ;
  public h GFa;
  final af GFb;
  public final Context context;
  public final ArrayList<ae.c> pUj;
  
  static
  {
    AppMethodBeat.i(344747);
    GEY = new ae.b((byte)0);
    AppMethodBeat.o(344747);
  }
  
  public ae(Context paramContext, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(344727);
    this.context = paramContext;
    this.GEZ = paramb;
    this.pUj = new ArrayList();
    this.GFb = new af((a)new g(this));
    AppMethodBeat.o(344727);
  }
  
  private static final void a(ae paramae, View paramView)
  {
    AppMethodBeat.i(344734);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramae);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/LiveChargeBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramae, "this$0");
    paramae = paramae.GFa;
    if (paramae != null) {
      paramae.cyW();
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/LiveChargeBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344734);
  }
  
  public final View flF()
  {
    AppMethodBeat.i(344767);
    View localView1 = LayoutInflater.from(this.context).inflate(p.f.Cdr, (ViewGroup)new FrameLayout(this.context), false);
    View localView2 = localView1.findViewById(p.e.BWt);
    Object localObject = (WxRecyclerView)localView2;
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter((g)new e(this), this.pUj);
    localWxRecyclerAdapter.agOe = ((i.c)new f(this));
    ah localah = ah.aiuX;
    this.ALE = localWxRecyclerAdapter;
    ((WxRecyclerView)localObject).getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.ALE);
    localObject = ah.aiuX;
    this.AZd = ((WxRecyclerView)localView2);
    ((WeImageView)localView1.findViewById(p.e.BWs)).setOnClickListener(new ae..ExternalSyntheticLambda0(this));
    s.s(localView1, "rootView");
    AppMethodBeat.o(344767);
    return localView1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$Callback;", "", "selectValue", "", "value", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void UK(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$DataConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$Data;", "isLast", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet;Lkotlin/jvm/functions/Function1;)V", "()Lkotlin/jvm/functions/Function1;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends f<ae.c>
  {
    private final kotlin.g.a.b<Integer, Boolean> GEv;
    
    public d()
    {
      AppMethodBeat.i(344554);
      this.GEv = localObject;
      AppMethodBeat.o(344554);
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(344563);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramj, "holder");
      AppMethodBeat.o(344563);
    }
    
    public final int getLayoutId()
    {
      return p.f.CdT;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$createSelectView$1$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$Data;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements g
  {
    e(ae paramae) {}
    
    public final f<ae.c> yF(int paramInt)
    {
      AppMethodBeat.i(344564);
      f localf = (f)new ae.d(this.GFc, (kotlin.g.a.b)new a(this.GFc));
      AppMethodBeat.o(344564);
      return localf;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Integer, Boolean>
    {
      a(ae paramae)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$createSelectView$1$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements i.c<j>
  {
    f(ae paramae) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$inputCoinValueBottomPage$1", "Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$Callback;", "selectValue", "", "value", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ae.a
  {
    g(ae paramae) {}
    
    public final void UK(int paramInt)
    {
      AppMethodBeat.i(344543);
      this.GFc.GEZ.invoke(Integer.valueOf(paramInt));
      h localh = ae.b(this.GFc);
      if (localh != null) {
        localh.cyW();
      }
      AppMethodBeat.o(344543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ae
 * JD-Core Version:    0.7.0.1
 */