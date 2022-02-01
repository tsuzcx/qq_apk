package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.webview.BaseBoxDialogView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/ad/AdDialogView;", "Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "plugin-finder_release"})
public final class AdDialogView
  extends BaseBoxDialogView
{
  public AdDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287855);
    AppMethodBeat.o(287855);
  }
  
  public AdDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287856);
    AppMethodBeat.o(287856);
  }
  
  public final View eW(View paramView)
  {
    AppMethodBeat.i(287853);
    p.k(paramView, "root");
    paramView = paramView.findViewById(b.f.close_img);
    p.j(paramView, "root.findViewById(R.id.close_img)");
    AppMethodBeat.o(287853);
    return paramView;
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(287854);
    Context localContext = getContext();
    p.j(localContext, "context");
    int i = (int)localContext.getResources().getDimension(b.d.Edge_8A);
    AppMethodBeat.o(287854);
    return i;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_ad_half_dialog_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.AdDialogView
 * JD-Core Version:    0.7.0.1
 */