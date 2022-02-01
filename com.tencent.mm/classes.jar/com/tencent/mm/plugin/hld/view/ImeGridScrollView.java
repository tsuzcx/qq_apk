package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.recyclerview.WxGridLayoutManager;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeGridScrollView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "getMKeyboardActionListener", "()Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "setMKeyboardActionListener", "(Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;)V", "scrollContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "getScrollContainerRv", "()Landroidx/recyclerview/widget/RecyclerView;", "scrollContainerRv$delegate", "Lkotlin/Lazy;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "getSpanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "initView", "", "reset", "setOnKeyboardActionListener", "listener", "Companion", "plugin-hld_release"})
public abstract class ImeGridScrollView
  extends RelativeLayout
{
  public static final a DIj = new a((byte)0);
  private final f DIi = g.ar((kotlin.g.a.a)new c(this));
  private com.tencent.mm.plugin.hld.a.c DvY;
  
  public ImeGridScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  public ImeGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  private final GridLayoutManager.b getSpanSizeLookup()
  {
    return (GridLayoutManager.b)new b(this);
  }
  
  public abstract RecyclerView.a<RecyclerView.v> getAdapter();
  
  public RecyclerView.h getItemDecoration()
  {
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = new a.a((Context)localObject).UN(a.d.ime_divider_size).UM(a.d.ime_divider_size).UL(a.c.ime_divider_color);
    ((a.a)localObject).CbQ = true;
    return (RecyclerView.h)((a.a)localObject).eHD();
  }
  
  protected final com.tencent.mm.plugin.hld.a.c getMKeyboardActionListener()
  {
    return this.DvY;
  }
  
  public final int getResourceId()
  {
    return a.h.wxime_symbol_grid_view;
  }
  
  public final RecyclerView getScrollContainerRv()
  {
    return (RecyclerView)this.DIi.getValue();
  }
  
  public void initView()
  {
    ad.kS(getContext()).inflate(getResourceId(), (ViewGroup)this, true);
    getScrollContainerRv().setLayoutManager((RecyclerView.LayoutManager)new WxGridLayoutManager(getContext(), 4));
    getScrollContainerRv().setAdapter(getAdapter());
    Object localObject = getItemDecoration();
    if (localObject != null) {
      getScrollContainerRv().b((RecyclerView.h)localObject);
    }
    localObject = getSpanSizeLookup();
    if (localObject != null)
    {
      RecyclerView.LayoutManager localLayoutManager = getScrollContainerRv().getLayoutManager();
      if (localLayoutManager == null) {
        throw new t("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
      }
      ((GridLayoutManager)localLayoutManager).a((GridLayoutManager.b)localObject);
    }
  }
  
  public void reset()
  {
    RecyclerView localRecyclerView = getScrollContainerRv();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/hld/view/ImeGridScrollView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/hld/view/ImeGridScrollView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    this.DvY = null;
  }
  
  protected final void setMKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.DvY = paramc;
  }
  
  public void setOnKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    p.k(paramc, "listener");
    this.DvY = paramc;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeGridScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/view/ImeGridScrollView$getSpanSizeLookup$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-hld_release"})
  public static final class b
    extends GridLayoutManager.b
  {
    public final int cx(int paramInt)
    {
      AppMethodBeat.i(214126);
      RecyclerView.a locala = this.DIk.getScrollContainerRv().getAdapter();
      if (locala != null)
      {
        paramInt = locala.getItemViewType(paramInt);
        AppMethodBeat.o(214126);
        return paramInt;
      }
      AppMethodBeat.o(214126);
      return 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    c(ImeGridScrollView paramImeGridScrollView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeGridScrollView
 * JD-Core Version:    0.7.0.1
 */