package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.ui.base.sortview.c.a;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "item", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "convertView", "parent", "Landroid/view/ViewGroup;", "position", "", "count", "isFirstOfPage", "", "isLastOfPage", "createView"})
final class FinderContactSortView$b
  implements c.a
{
  FinderContactSortView$b(FinderContactSortView paramFinderContactSortView) {}
  
  public final View a(com.tencent.mm.ui.base.sortview.d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168297);
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.qWr.getContext(), 2131494021, null);
      localObject1 = new FinderContactSortView.a();
      ((FinderContactSortView.a)localObject1).fuj = ((ImageView)paramView.findViewById(2131297008));
      ((FinderContactSortView.a)localObject1).inR = ((TextView)paramView.findViewById(2131302867));
      ((FinderContactSortView.a)localObject1).iiM = ((TextView)paramView.findViewById(2131297925));
      ((FinderContactSortView.a)localObject1).mZJ = paramView.findViewById(2131301145);
      d.g.b.k.g(paramView, "itemView");
      paramView.setTag(localObject1);
    }
    for (;;)
    {
      d.g.b.k.g(paramd, "item");
      localObject2 = paramd.getData();
      if (localObject2 != null) {
        break;
      }
      paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
      AppMethodBeat.o(168297);
      throw paramd;
      d.g.b.k.g(paramView, "convertView");
      localObject1 = paramView.getTag();
      if (localObject1 == null)
      {
        paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.FinderContactSortView.ViewHolder");
        AppMethodBeat.o(168297);
        throw paramd;
      }
      localObject1 = (FinderContactSortView.a)localObject1;
    }
    Object localObject2 = (f)localObject2;
    Object localObject3 = h.qCF;
    localObject3 = h.cmV();
    a locala = new a(((f)localObject2).cks());
    ImageView localImageView = ((FinderContactSortView.a)localObject1).fuj;
    if (localImageView == null) {
      d.g.b.k.fvU();
    }
    h localh = h.qCF;
    ((com.tencent.mm.loader.d)localObject3).a(locala, localImageView, h.a(h.a.qCI));
    localObject3 = ((FinderContactSortView.a)localObject1).inR;
    if (localObject3 != null) {
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.qWr.getContext(), (CharSequence)((f)localObject2).Su()));
    }
    if ((this.qWr.eTJ()) && (paramBoolean1))
    {
      localObject2 = ((FinderContactSortView.a)localObject1).iiM;
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)paramd.eTM());
      }
      paramd = ((FinderContactSortView.a)localObject1).iiM;
      if (paramd != null) {
        paramd.setVisibility(0);
      }
      if ((this.qWr.getMode() != 0) || (!paramBoolean2)) {
        break label390;
      }
      paramd = ((FinderContactSortView.a)localObject1).mZJ;
      if (paramd != null) {
        paramd.setBackgroundResource(2131231820);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(168297);
      return paramView;
      paramd = ((FinderContactSortView.a)localObject1).iiM;
      if (paramd == null) {
        break;
      }
      paramd.setVisibility(8);
      break;
      label390:
      paramd = ((FinderContactSortView.a)localObject1).mZJ;
      if (paramd != null) {
        paramd.setBackgroundResource(2131232867);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderContactSortView.b
 * JD-Core Version:    0.7.0.1
 */