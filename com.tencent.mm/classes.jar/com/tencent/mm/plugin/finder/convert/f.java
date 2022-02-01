package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "onClickRefresh", "Lkotlin/Function0;", "", "onClickPermission", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class f
  extends b<c>
{
  public static final a qrk;
  private final a<y> KKM;
  private final a<y> KKN;
  
  static
  {
    AppMethodBeat.i(165390);
    qrk = new a((byte)0);
    AppMethodBeat.o(165390);
  }
  
  public f(a<y> parama1, a<y> parama2)
  {
    this.KKM = parama1;
    this.KKN = parama2;
  }
  
  public final void a(RecyclerView paramRecyclerView, final e parame, int paramInt)
  {
    AppMethodBeat.i(165387);
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    parame.arI.setOnClickListener((View.OnClickListener)new b(this, parame));
    AppMethodBeat.o(165387);
  }
  
  public final int getLayoutId()
  {
    return 2131494116;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedEmptyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165386);
      paramView = (c)parame.fjf();
      if (paramView != null)
      {
        if (paramView.type == -1)
        {
          paramView = parame.abq(2131307894);
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          paramView = parame.abq(2131303521);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
          paramView = f.a(this.qrl);
          if (paramView != null)
          {
            paramView.invoke();
            AppMethodBeat.o(165386);
          }
        }
      }
      else
      {
        AppMethodBeat.o(165386);
        return;
      }
      AppMethodBeat.o(165386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.f
 * JD-Core Version:    0.7.0.1
 */