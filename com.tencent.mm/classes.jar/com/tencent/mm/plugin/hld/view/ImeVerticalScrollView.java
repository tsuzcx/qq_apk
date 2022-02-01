package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.l;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeVerticalScrollView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "keyboardType", "getKeyboardType", "()Ljava/lang/Integer;", "setKeyboardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "scrollContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "getScrollContainerRv", "()Landroidx/recyclerview/widget/RecyclerView;", "scrollContainerRv$delegate", "Lkotlin/Lazy;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "initView", "", "onClick", "v", "Landroid/view/View;", "onFinishInflate", "onResume", "reset", "setOnKeyboardActionListener", "listener", "supportMoveCursor", "", "Companion", "plugin-hld_release"})
public abstract class ImeVerticalScrollView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final a DJm = new a((byte)0);
  private final f DIi = kotlin.g.ar((kotlin.g.a.a)new b(this));
  private Integer DJl;
  private com.tencent.mm.plugin.hld.a.c DvY;
  
  public ImeVerticalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeVerticalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  public ImeVerticalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    this.DJl = Integer.valueOf(paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeVerticalScrollView, paramInt, 0).getInt(a.l.ImeVerticalScrollView_imeKeyboardType, -1));
  }
  
  public abstract RecyclerView.a<RecyclerView.v> getAdapter();
  
  public abstract RecyclerView.h getItemDecoration();
  
  protected final Integer getKeyboardType()
  {
    return this.DJl;
  }
  
  public abstract int getResourceId();
  
  public final RecyclerView getScrollContainerRv()
  {
    return (RecyclerView)this.DIi.getValue();
  }
  
  public final void initView()
  {
    ad.kS(getContext()).inflate(getResourceId(), (ViewGroup)this, true);
    setOrientation(1);
    Object localObject = new WxLinearLayoutManager(getContext());
    ((WxLinearLayoutManager)localObject).setOrientation(1);
    getScrollContainerRv().setLayoutManager((RecyclerView.LayoutManager)localObject);
    getScrollContainerRv().setAdapter(getAdapter());
    localObject = getItemDecoration();
    if (localObject != null) {
      getScrollContainerRv().b((RecyclerView.h)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/view/ImeVerticalScrollView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    int i;
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.ImeVerticalScrollView", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) == 2)
      {
        localObject = this.DvY;
        if (localObject != null) {
          ((com.tencent.mm.plugin.hld.a.c)localObject).Up(((ImeKeyRelativeLayout)paramView).getFunctionCode());
        }
      }
      paramView = this.DJl;
      i = com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal();
      if (paramView != null) {
        break label214;
      }
      i = com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal();
      if (paramView != null) {
        break label228;
      }
      label174:
      i = com.tencent.mm.plugin.hld.keyboard.c.Dyp.ordinal();
      if (paramView != null) {
        break label243;
      }
      label185:
      i = -1;
    }
    for (;;)
    {
      if (i != -1)
      {
        paramView = k.DDb;
        k.hO(i, 1);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/view/ImeVerticalScrollView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      label214:
      if (paramView.intValue() != i) {
        break;
      }
      i = 102;
      continue;
      label228:
      if (paramView.intValue() != i) {
        break label174;
      }
      i = 402;
      continue;
      label243:
      if (paramView.intValue() != i) {
        break label185;
      }
      i = 502;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Log.d("WxIme.ImeVerticalScrollView", "onFinishInflate()");
    g localg = g.DIP;
    g.a(findViewById(a.f.below_button_ikb), (View.OnClickListener)this);
  }
  
  public void onResume() {}
  
  public void reset()
  {
    RecyclerView localRecyclerView = getScrollContainerRv();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/hld/view/ImeVerticalScrollView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/hld/view/ImeVerticalScrollView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    getScrollContainerRv().isScrollbarFadingEnabled();
    this.DvY = null;
  }
  
  protected final void setKeyboardType(Integer paramInteger)
  {
    this.DJl = paramInteger;
  }
  
  public void setOnKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    p.k(paramc, "listener");
    this.DvY = paramc;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeVerticalScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    b(ImeVerticalScrollView paramImeVerticalScrollView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeVerticalScrollView
 * JD-Core Version:    0.7.0.1
 */