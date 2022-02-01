package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.webview.BaseBoxDialogView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/ad/AdDialogView;", "Lcom/tencent/mm/plugin/finder/webview/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AdDialogView
  extends BaseBoxDialogView
{
  public AdDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(334571);
    AppMethodBeat.o(334571);
  }
  
  public AdDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(334575);
    AppMethodBeat.o(334575);
  }
  
  public final View jdMethod_do(View paramView)
  {
    AppMethodBeat.i(334586);
    s.u(paramView, "root");
    paramView = paramView.findViewById(e.e.close_img);
    s.s(paramView, "root.findViewById(R.id.close_img)");
    AppMethodBeat.o(334586);
    return paramView;
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(334589);
    int i = (int)getContext().getResources().getDimension(e.c.Edge_8A);
    AppMethodBeat.o(334589);
    return i;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_ad_half_dialog_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.AdDialogView
 * JD-Core Version:    0.7.0.1
 */