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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.view.ImeGridScrollView;
import com.tencent.mm.plugin.hld.view.a.a;
import com.tencent.mm.plugin.hld.view.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeGridScrollView;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolGridViewHolder$ISymbolGridViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentSymbolType", "", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "onClick", "", "symbolStr", "pressTime", "", "reset", "updateSymbolType", "symbolType", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeSymbolGridScrollView
  extends ImeGridScrollView
  implements e.a
{
  public static final ImeSymbolGridScrollView.a JwW;
  private String JwX;
  
  static
  {
    AppMethodBeat.i(312208);
    JwW = new ImeSymbolGridScrollView.a((byte)0);
    AppMethodBeat.o(312208);
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
    AppMethodBeat.i(312200);
    paramContext = com.tencent.mm.plugin.hld.f.b.Jyf;
    this.JwX = com.tencent.mm.plugin.hld.f.b.fNO();
    initView();
    AppMethodBeat.o(312200);
  }
  
  public final void aIt(String paramString)
  {
    AppMethodBeat.i(312277);
    s.u(paramString, "symbolType");
    this.JwX = paramString;
    Object localObject = getScrollContainerRv().getAdapter();
    if ((localObject instanceof d)) {}
    for (localObject = (d)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (e)localObject;
        RecyclerView localRecyclerView = getScrollContainerRv();
        com.tencent.mm.plugin.hld.f.b localb = com.tencent.mm.plugin.hld.f.b.Jyf;
        Context localContext = getContext();
        s.s(localContext, "context");
        e.a((e)localObject, localRecyclerView, (List)localb.be(localContext, this.JwX), paramString, false, 8);
      }
      AppMethodBeat.o(312277);
      return;
    }
  }
  
  public final void aL(String paramString, long paramLong)
  {
    AppMethodBeat.i(312239);
    s.u(paramString, "symbolStr");
    Object localObject = l.JyV;
    l.jC("WxIme.ImeSymbolGridScrollView", s.X("onClick ", paramString));
    localObject = (com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).fKC();
        if (localObject != null)
        {
          paramString = new g(paramString);
          paramString.JnG = paramLong;
          ah localah = ah.aiuX;
          ((c)localObject).b(paramString);
        }
      }
    }
    paramString = k.JvH;
    k.YA(500);
    AppMethodBeat.o(312239);
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(312224);
    Object localObject = getContext();
    s.s(localObject, "context");
    com.tencent.mm.plugin.hld.f.b localb = com.tencent.mm.plugin.hld.f.b.Jyf;
    Context localContext = getContext();
    s.s(localContext, "context");
    localObject = (RecyclerView.a)new d((Context)localObject, localb.be(localContext, this.JwX), this.JwX, (e.a)this);
    AppMethodBeat.o(312224);
    return localObject;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(312263);
    Object localObject = getContext();
    s.s(localObject, "context");
    localObject = new a.a((Context)localObject).YL(a.d.ime_divider_size).YK(a.d.ime_divider_size).YJ(a.c.ime_divider_color);
    ((a.a)localObject).HNS = false;
    localObject = (RecyclerView.h)((a.a)localObject).fPp();
    AppMethodBeat.o(312263);
    return localObject;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(312249);
    super.reset();
    com.tencent.mm.plugin.hld.f.b localb = com.tencent.mm.plugin.hld.f.b.Jyf;
    aIt(com.tencent.mm.plugin.hld.f.b.fNO());
    AppMethodBeat.o(312249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.ImeSymbolGridScrollView
 * JD-Core Version:    0.7.0.1
 */