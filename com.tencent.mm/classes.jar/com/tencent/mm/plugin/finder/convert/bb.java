package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.g;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.y.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "item", "observer", "Landroid/arch/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "Companion", "plugin-finder_release"})
public final class bb
  extends com.tencent.mm.view.recyclerview.b<al>
{
  public static final bb.a rXX;
  private final Observer<g.a> rXU;
  private WxRecyclerAdapter<?> rXV;
  private al rXW;
  
  static
  {
    AppMethodBeat.i(201921);
    rXX = new bb.a((byte)0);
    AppMethodBeat.o(201921);
  }
  
  public bb()
  {
    AppMethodBeat.i(201920);
    this.rXU = ((Observer)new b(this));
    AppMethodBeat.o(201920);
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(201916);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    this.rXV = paramWxRecyclerAdapter;
    paramRecyclerView = g.sbw;
    g.cBL().observeForever(this.rXU);
    AppMethodBeat.o(201916);
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201919);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    AppMethodBeat.o(201919);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201917);
    p.h(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    paramRecyclerView = g.sbw;
    g.cBL().removeObserver(this.rXU);
    AppMethodBeat.o(201917);
  }
  
  public final int getLayoutId()
  {
    return 2131495492;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class b<T>
    implements Observer<g.a>
  {
    b(bb parambb) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(e parame, y.f paramf1, y.f paramf2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201915);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      ast localast;
      if (((i)this.rXZ.NiY != null) && ((ast)this.rYa.NiY != null))
      {
        paramView = h.syO;
        localObject = (i)this.rXZ.NiY;
        localast = (ast)this.rYa.NiY;
        paramView = FinderReporterUIC.tnG;
        paramView = this.rUu.getContext();
        p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.fc(paramView);
        if (paramView == null) {
          break label171;
        }
      }
      label171:
      for (paramView = paramView.cQZ();; paramView = null)
      {
        h.a("2", (i)localObject, localast, 2, paramView, 0, 0, 96);
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        paramView = this.rUu.getContext();
        p.g(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.fa(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderPrivateMsgNotifyConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201915);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bb
 * JD-Core Version:    0.7.0.1
 */