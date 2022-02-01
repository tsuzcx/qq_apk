package com.tencent.mm.plugin.hld.symbol;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.view.ImeGridScrollView;
import com.tencent.mm.plugin.hld.view.a.a;
import com.tencent.mm.plugin.hld.view.f;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeGridScrollView;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentSymbolType", "", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "onClick", "", "symbolStr", "pressTime", "", "reset", "updateSymbolType", "symbolType", "Companion", "plugin-hld_release"})
public final class ImeSymbolGridScrollView
  extends ImeGridScrollView
  implements e.a
{
  public static final a DFq;
  private String DFp;
  
  static
  {
    AppMethodBeat.i(209677);
    DFq = new a((byte)0);
    AppMethodBeat.o(209677);
  }
  
  public ImeSymbolGridScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeSymbolGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeSymbolGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(209676);
    paramContext = com.tencent.mm.plugin.hld.f.b.DGL;
    this.DFp = com.tencent.mm.plugin.hld.f.b.eFV();
    initView();
    AppMethodBeat.o(209676);
  }
  
  public final void aB(String paramString, long paramLong)
  {
    AppMethodBeat.i(209668);
    p.k(paramString, "symbolStr");
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.ImeSymbolGridScrollView", "onClick ".concat(String.valueOf(paramString)));
    localObject = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCr();
        if (localObject != null)
        {
          paramString = new g(paramString);
          paramString.Dui = paramLong;
          ((c)localObject).b(paramString);
        }
      }
    }
    paramString = k.DDb;
    k.hO(500, 1);
    AppMethodBeat.o(209668);
  }
  
  public final void aLB(String paramString)
  {
    AppMethodBeat.i(209674);
    p.k(paramString, "symbolType");
    this.DFp = paramString;
    Object localObject2 = getScrollContainerRv().getAdapter();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof d)) {
      localObject1 = null;
    }
    localObject1 = (d)localObject1;
    if (localObject1 != null)
    {
      localObject2 = getScrollContainerRv();
      com.tencent.mm.plugin.hld.f.b localb = com.tencent.mm.plugin.hld.f.b.DGL;
      Context localContext = getContext();
      p.j(localContext, "context");
      f.a((f)localObject1, (RecyclerView)localObject2, (List)localb.bc(localContext, this.DFp), paramString, false, 8);
      AppMethodBeat.o(209674);
      return;
    }
    AppMethodBeat.o(209674);
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(209666);
    Object localObject = getContext();
    p.j(localObject, "context");
    com.tencent.mm.plugin.hld.f.b localb = com.tencent.mm.plugin.hld.f.b.DGL;
    Context localContext = getContext();
    p.j(localContext, "context");
    localObject = (RecyclerView.a)new d((Context)localObject, localb.bc(localContext, this.DFp), this.DFp, (e.a)this);
    AppMethodBeat.o(209666);
    return localObject;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(209672);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = new a.a((Context)localObject).UN(a.d.ime_divider_size).UM(a.d.ime_divider_size).UL(a.c.ime_divider_color);
    ((a.a)localObject).CbQ = false;
    localObject = (RecyclerView.h)((a.a)localObject).eHD();
    AppMethodBeat.o(209672);
    return localObject;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(209670);
    super.reset();
    com.tencent.mm.plugin.hld.f.b localb = com.tencent.mm.plugin.hld.f.b.DGL;
    aLB(com.tencent.mm.plugin.hld.f.b.eFV());
    AppMethodBeat.o(209670);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.ImeSymbolGridScrollView
 * JD-Core Version:    0.7.0.1
 */