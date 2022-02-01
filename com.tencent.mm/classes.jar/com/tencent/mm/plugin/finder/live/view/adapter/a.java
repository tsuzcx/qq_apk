package com.tencent.mm.plugin.finder.live.view.adapter;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkAdapter$ApplyLinkViewHolder;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "getDataList", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "ApplyLinkViewHolder", "plugin-finder_release"})
public final class a
  extends RecyclerView.a<a>
{
  private final ArrayList<e> kgc;
  public kotlin.g.a.b<? super e, x> uzX;
  
  public a()
  {
    AppMethodBeat.i(247726);
    this.kgc = new ArrayList();
    AppMethodBeat.o(247726);
  }
  
  public final void ad(List<e> paramList)
  {
    AppMethodBeat.i(247725);
    p.h(paramList, "data");
    this.kgc.clear();
    this.kgc.addAll((Collection)paramList);
    AppMethodBeat.o(247725);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(247723);
    int i = this.kgc.size();
    AppMethodBeat.o(247723);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkAdapter$ApplyLinkViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "avatar", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getAvatar", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "nicknameTv", "getNicknameTv", "typeIcon", "Landroid/widget/ImageView;", "getTypeIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView pIN;
    final TextView uAa;
    final MMRoundCornerImageView uzY;
    final ImageView uzZ;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(247720);
      this.uzY = ((MMRoundCornerImageView)paramView.findViewById(2131301069));
      this.pIN = ((TextView)paramView.findViewById(2131301071));
      this.uzZ = ((ImageView)paramView.findViewById(2131301072));
      this.uAa = ((TextView)paramView.findViewById(2131301068));
      AppMethodBeat.o(247720);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247721);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = (e)j.L((List)a.a(this.uAb), this.gUj);
      if (paramView != null)
      {
        localObject = this.uAb.uzX;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.a
 * JD-Core Version:    0.7.0.1
 */