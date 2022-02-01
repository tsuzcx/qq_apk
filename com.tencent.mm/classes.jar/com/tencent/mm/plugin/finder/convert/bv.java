package com.tencent.mm.plugin.finder.convert;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.bq;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderPoiManageItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderPoiData;", "()V", "getLayoutId", "", "gotoFailedPager", "", "context", "Landroid/content/Context;", "failed_url", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bv
  extends f<bq>
{
  private static final void a(bv parambv, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(350312);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parambv);
    localb.cH(paramf);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderPoiManageItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambv, "this$0");
    s.u(paramf, "$failedUrl");
    parambv = paramView.getContext();
    s.s(parambv, "it.context");
    paramf = (String)paramf.aqH;
    paramView = (CharSequence)paramf;
    if ((paramView == null) || (paramView.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramf);
        c.b(parambv, "webview", ".ui.tools.WebViewUI", paramView);
      }
      a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderPoiManageItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350312);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350328);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350328);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_poi_manage_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bv
 * JD-Core Version:    0.7.0.1
 */