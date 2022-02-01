package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.y.f;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "item", "observer", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class ba
  extends com.tencent.mm.view.recyclerview.b<ak>
{
  public static final a rPw;
  private final Observer<g.a> rPt;
  private WxRecyclerAdapter<?> rPu;
  private ak rPv;
  
  static
  {
    AppMethodBeat.i(201479);
    rPw = new a((byte)0);
    AppMethodBeat.o(201479);
  }
  
  public ba()
  {
    AppMethodBeat.i(201478);
    this.rPt = ((Observer)new b(this));
    AppMethodBeat.o(201478);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(201474);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    this.rPu = paramWxRecyclerAdapter;
    paramRecyclerView = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    com.tencent.mm.plugin.finder.extension.reddot.g.cAf().observeForever(this.rPt);
    AppMethodBeat.o(201474);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201477);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    AppMethodBeat.o(201477);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201475);
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    paramRecyclerView = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    com.tencent.mm.plugin.finder.extension.reddot.g.cAf().removeObserver(this.rPt);
    AppMethodBeat.o(201475);
  }
  
  public final int getLayoutId()
  {
    return 2131495492;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class b<T>
    implements Observer<g.a>
  {
    b(ba paramba) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(e parame, y.f paramf1, y.f paramf2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201473);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      ase localase;
      if (((i)this.rPy.MLV != null) && ((ase)this.rPz.MLV != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.g.soH;
        localObject = (i)this.rPy.MLV;
        localase = (ase)this.rPz.MLV;
        paramView = FinderReporterUIC.tcM;
        paramView = this.rMh.getContext();
        p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.eY(paramView);
        if (paramView == null) {
          break label170;
        }
      }
      label170:
      for (paramView = paramView.cOu();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.g.b("2", (i)localObject, localase, 2, paramView, 0, 96);
        paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
        paramView = this.rMh.getContext();
        p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.eW(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201473);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ba
 * JD-Core Version:    0.7.0.1
 */