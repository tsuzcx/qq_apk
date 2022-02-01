package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.webview.BoxWebViewContainer;
import com.tencent.mm.plugin.finder.webview.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/ad/SimpleAdDialogView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "boxWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "closeButton", "Landroid/view/View;", "dialog", "Lcom/tencent/mm/plugin/finder/webview/BoxDialogModel;", "isAtWebViewTop", "", "webViewContainer", "Lcom/tencent/mm/plugin/finder/webview/BoxWebViewContainer;", "attachDialog", "", "dialogModel", "attachWebView", "webView", "getCloseButton", "root", "getCloseLayoutHeight", "getLayoutId", "init", "Companion", "plugin-finder_release"})
public class SimpleAdDialogView
  extends FrameLayout
{
  public static final a Bsm;
  private static final String TAG = "Finder.SimpleAdDialogView";
  private d BpW;
  private BoxWebViewContainer BpZ;
  private boolean BqC;
  private View Bqa;
  
  static
  {
    AppMethodBeat.i(243780);
    Bsm = new a((byte)0);
    TAG = "Finder.SimpleAdDialogView";
    AppMethodBeat.o(243780);
  }
  
  public SimpleAdDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(243777);
    AppMethodBeat.o(243777);
  }
  
  public SimpleAdDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(243778);
    this.BqC = true;
    paramContext = LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(b.f.webview_container);
    p.j(paramAttributeSet, "view.findViewById(R.id.webview_container)");
    this.BpZ = ((BoxWebViewContainer)paramAttributeSet);
    p.j(paramContext, "view");
    p.k(paramContext, "root");
    paramContext = paramContext.findViewById(b.f.close_img);
    p.j(paramContext, "root.findViewById(R.id.close_img)");
    paramContext.setOnClickListener((View.OnClickListener)new b(this));
    this.Bqa = paramContext;
    AppMethodBeat.o(243778);
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(243776);
    Context localContext = getContext();
    p.j(localContext, "context");
    int i = (int)localContext.getResources().getDimension(b.d.Edge_8A);
    AppMethodBeat.o(243776);
    return i;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_ad_half_dialog_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/ad/SimpleAdDialogView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/webview/ad/SimpleAdDialogView$init$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(SimpleAdDialogView paramSimpleAdDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230541);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/webview/ad/SimpleAdDialogView$init$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      SimpleAdDialogView.a(this.Bsn);
      a.a(this, "com/tencent/mm/plugin/finder/webview/ad/SimpleAdDialogView$init$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.SimpleAdDialogView
 * JD-Core Version:    0.7.0.1
 */