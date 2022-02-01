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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeVerticalScrollView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "keyboardType", "getKeyboardType", "()Ljava/lang/Integer;", "setKeyboardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "scrollContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "getScrollContainerRv", "()Landroidx/recyclerview/widget/RecyclerView;", "scrollContainerRv$delegate", "Lkotlin/Lazy;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "initView", "", "onClick", "v", "Landroid/view/View;", "onFinishInflate", "onResume", "reset", "setOnKeyboardActionListener", "listener", "supportMoveCursor", "", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ImeVerticalScrollView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final ImeVerticalScrollView.a JAn = new ImeVerticalScrollView.a((byte)0);
  private Integer JAo;
  private com.tencent.mm.plugin.hld.a.c Jpf;
  private final j Jzm = kotlin.k.cm((kotlin.g.a.a)new b(this));
  
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeVerticalScrollView, paramInt, 0);
    s.s(paramContext, "context!!.obtainStyledAt…ollView, defStyleAttr, 0)");
    this.JAo = Integer.valueOf(paramContext.getInt(a.l.ImeVerticalScrollView_imeKeyboardType, -1));
  }
  
  public abstract RecyclerView.a<RecyclerView.v> getAdapter();
  
  public abstract RecyclerView.h getItemDecoration();
  
  protected final Integer getKeyboardType()
  {
    return this.JAo;
  }
  
  public abstract int getResourceId();
  
  public final RecyclerView getScrollContainerRv()
  {
    Object localObject = this.Jzm.getValue();
    s.s(localObject, "<get-scrollContainerRv>(...)");
    return (RecyclerView)localObject;
  }
  
  public final void initView()
  {
    af.mU(getContext()).inflate(getResourceId(), (ViewGroup)this, true);
    setOrientation(1);
    Object localObject = new WxLinearLayoutManager(getContext());
    ((WxLinearLayoutManager)localObject).setOrientation(1);
    getScrollContainerRv().setLayoutManager((RecyclerView.LayoutManager)localObject);
    getScrollContainerRv().setAdapter(getAdapter());
    localObject = getItemDecoration();
    if (localObject != null) {
      getScrollContainerRv().a((RecyclerView.h)localObject);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/view/ImeVerticalScrollView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    int i;
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject = l.JyV;
      l.jC("WxIme.ImeVerticalScrollView", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) == 2)
      {
        localObject = this.Jpf;
        if (localObject != null) {
          ((com.tencent.mm.plugin.hld.a.c)localObject).Yl(((ImeKeyRelativeLayout)paramView).getFunctionCode());
        }
      }
      paramView = this.JAo;
      i = com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal();
      if (paramView != null) {
        break label213;
      }
      i = com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal();
      if (paramView != null) {
        break label227;
      }
      label174:
      i = com.tencent.mm.plugin.hld.keyboard.c.Jrt.ordinal();
      if (paramView != null) {
        break label242;
      }
      label185:
      i = -1;
    }
    for (;;)
    {
      if (i != -1)
      {
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.YA(i);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/view/ImeVerticalScrollView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      label213:
      if (paramView.intValue() != i) {
        break;
      }
      i = 102;
      continue;
      label227:
      if (paramView.intValue() != i) {
        break label174;
      }
      i = 402;
      continue;
      label242:
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
    f.JzR.a(findViewById(a.f.below_button_ikb), (View.OnClickListener)this);
  }
  
  public void onResume() {}
  
  public void reset()
  {
    RecyclerView localRecyclerView = getScrollContainerRv();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/hld/view/ImeVerticalScrollView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/hld/view/ImeVerticalScrollView", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    getScrollContainerRv().isScrollbarFadingEnabled();
    this.Jpf = null;
  }
  
  protected final void setKeyboardType(Integer paramInteger)
  {
    this.JAo = paramInteger;
  }
  
  public void setOnKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    s.u(paramc, "listener");
    this.Jpf = paramc;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
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