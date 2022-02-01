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
import com.tencent.mm.ui.af;
import com.tencent.mm.view.recyclerview.WxGridLayoutManager;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeGridScrollView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "getMKeyboardActionListener", "()Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "setMKeyboardActionListener", "(Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;)V", "scrollContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "getScrollContainerRv", "()Landroidx/recyclerview/widget/RecyclerView;", "scrollContainerRv$delegate", "Lkotlin/Lazy;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "getSpanSizeLookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "initView", "", "reset", "setOnKeyboardActionListener", "listener", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ImeGridScrollView
  extends RelativeLayout
{
  public static final ImeGridScrollView.a Jzl = new ImeGridScrollView.a((byte)0);
  private com.tencent.mm.plugin.hld.a.c Jpf;
  private final j Jzm = k.cm((kotlin.g.a.a)new c(this));
  
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
    s.s(localObject, "context");
    localObject = new a.a((Context)localObject).YL(a.d.ime_divider_size).YK(a.d.ime_divider_size).YJ(a.c.ime_divider_color);
    ((a.a)localObject).HNS = true;
    return (RecyclerView.h)((a.a)localObject).fPp();
  }
  
  protected final com.tencent.mm.plugin.hld.a.c getMKeyboardActionListener()
  {
    return this.Jpf;
  }
  
  public final int getResourceId()
  {
    return a.h.wxime_symbol_grid_view;
  }
  
  public final RecyclerView getScrollContainerRv()
  {
    Object localObject = this.Jzm.getValue();
    s.s(localObject, "<get-scrollContainerRv>(...)");
    return (RecyclerView)localObject;
  }
  
  public void initView()
  {
    af.mU(getContext()).inflate(getResourceId(), (ViewGroup)this, true);
    getScrollContainerRv().setLayoutManager((RecyclerView.LayoutManager)new WxGridLayoutManager(getContext(), 4));
    getScrollContainerRv().setAdapter(getAdapter());
    Object localObject = getItemDecoration();
    if (localObject != null) {
      getScrollContainerRv().a((RecyclerView.h)localObject);
    }
    localObject = getSpanSizeLookup();
    if (localObject != null)
    {
      RecyclerView.LayoutManager localLayoutManager = getScrollContainerRv().getLayoutManager();
      if (localLayoutManager == null) {
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
      }
      ((GridLayoutManager)localLayoutManager).bWq = ((GridLayoutManager.b)localObject);
    }
  }
  
  public void reset()
  {
    RecyclerView localRecyclerView = getScrollContainerRv();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/hld/view/ImeGridScrollView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/hld/view/ImeGridScrollView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    this.Jpf = null;
  }
  
  protected final void setMKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.Jpf = paramc;
  }
  
  public void setOnKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    s.u(paramc, "listener");
    this.Jpf = paramc;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/view/ImeGridScrollView$getSpanSizeLookup$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends GridLayoutManager.b
  {
    b(ImeGridScrollView paramImeGridScrollView) {}
    
    public final int fJ(int paramInt)
    {
      AppMethodBeat.i(312521);
      RecyclerView.a locala = this.Jzn.getScrollContainerRv().getAdapter();
      if (locala == null)
      {
        AppMethodBeat.o(312521);
        return 1;
      }
      paramInt = locala.getItemViewType(paramInt);
      AppMethodBeat.o(312521);
      return paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
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