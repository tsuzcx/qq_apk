package com.tencent.mm.plugin.finder.live.view.adapter;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$ApplyLinkViewHolder;", "()V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "keyword", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateData", "data", "", "ApplyLinkViewHolder", "plugin-finder_release"})
public final class b
  extends RecyclerView.a<a>
{
  private final String TAG;
  private String dDv;
  private final ArrayList<e> kgc;
  public kotlin.g.a.b<? super e, x> uzX;
  
  public b()
  {
    AppMethodBeat.i(247733);
    this.TAG = "Finder.FinderLiveApplyLinkSearchAdapter";
    this.kgc = new ArrayList();
    this.dDv = "";
    AppMethodBeat.o(247733);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(247730);
    int i = this.kgc.size();
    AppMethodBeat.o(247730);
    return i;
  }
  
  public final void j(List<e> paramList, String paramString)
  {
    AppMethodBeat.i(247732);
    p.h(paramList, "data");
    p.h(paramString, "keyword");
    this.dDv = paramString;
    this.kgc.clear();
    this.kgc.addAll((Collection)paramList);
    AppMethodBeat.o(247732);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$ApplyLinkViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "avatar", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getAvatar", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "nicknameTv", "getNicknameTv", "typeIcon", "Landroid/widget/ImageView;", "getTypeIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
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
      AppMethodBeat.i(247727);
      this.uzY = ((MMRoundCornerImageView)paramView.findViewById(2131301069));
      this.pIN = ((TextView)paramView.findViewById(2131301071));
      this.uzZ = ((ImageView)paramView.findViewById(2131301072));
      this.uAa = ((TextView)paramView.findViewById(2131301068));
      AppMethodBeat.o(247727);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247728);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = (e)j.L((List)b.a(this.uAc), this.gUj);
      if (paramView != null)
      {
        localObject = this.uAc.uzX;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247728);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.b
 * JD-Core Version:    0.7.0.1
 */