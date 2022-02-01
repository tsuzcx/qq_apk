package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow;", "T", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "onClickListener", "Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$OnClickListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$OnClickListener;)V", "autoDismissTime", "", "hasMeasure", "", "item", "Ljava/lang/Object;", "menuLayout", "Landroid/view/View;", "getOnClickListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$OnClickListener;", "popupPadding", "", "tipsTv", "Landroid/widget/TextView;", "topMargin", "vArrow", "setAutoDismissTimeMs", "", "time", "setGone", "setItem", "(Ljava/lang/Object;)V", "setPopupPadding", "padding", "setPopupTopMargin", "setTips", "tips", "Landroid/text/SpannableString;", "tipsId", "", "setVisible", "showWith", "anchor", "Companion", "OnClickListener", "plugin-finder_release"})
public final class r<T>
  extends com.tencent.mm.ui.base.r
{
  public static final a Bbm;
  public final TextView AWF;
  public final View Bbf;
  private final View Bbg;
  public boolean Bbh;
  private T Bbi;
  private int Bbj;
  public long Bbk;
  final b<T> Bbl;
  public final Context context;
  
  static
  {
    AppMethodBeat.i(281524);
    Bbm = new a((byte)0);
    AppMethodBeat.o(281524);
  }
  
  private r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(281523);
    this.context = paramContext;
    this.Bbl = null;
    this.Bbj = 5;
    this.Bbk = 10000L;
    setContentView(LayoutInflater.from(this.context).inflate(b.g.finder_tips_bubble_window_layout, null));
    setClippingEnabled(false);
    paramContext = getContentView().findViewById(b.f.tv_tips);
    p.j(paramContext, "contentView.findViewById(R.id.tv_tips)");
    this.AWF = ((TextView)paramContext);
    paramContext = getContentView().findViewById(b.f.v_arrow);
    p.j(paramContext, "contentView.findViewById(R.id.v_arrow)");
    this.Bbf = paramContext;
    paramContext = getContentView().findViewById(b.f.menu_content);
    p.j(paramContext, "contentView.findViewById(R.id.menu_content)");
    this.Bbg = paramContext;
    setOutsideTouchable(true);
    getContentView().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(290029);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.Bbn.Bbl != null) {
          r.a(this.Bbn);
        }
        this.Bbn.dismiss();
        a.a(this, "com/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(290029);
      }
    });
    AppMethodBeat.o(281523);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$Companion;", "", "()V", "POPUP_PADDING", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$OnClickListener;", "E", "", "onClick", "", "item", "(Ljava/lang/Object;)V", "plugin-finder_release"})
  public static abstract interface b<E> {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "run"})
  public static final class c
    implements Runnable
  {
    public c(r paramr) {}
    
    public final void run()
    {
      AppMethodBeat.i(287775);
      if (this.Bbn.isShowing()) {
        this.Bbn.dismiss();
      }
      AppMethodBeat.o(287775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.r
 * JD-Core Version:    0.7.0.1
 */